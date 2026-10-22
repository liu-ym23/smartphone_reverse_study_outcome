package com.android.volley;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

/* loaded from: classes.dex */
public class NetworkDispatcher extends Thread {
    private final Cache mCache;
    private final ResponseDelivery mDelivery;
    private final Network mNetwork;
    private final BlockingQueue<Request<?>> mQueue;
    private volatile boolean mQuit = false;

    public NetworkDispatcher(BlockingQueue<Request<?>> blockingQueue, Network network, Cache cache, ResponseDelivery responseDelivery) {
        this.mQueue = blockingQueue;
        this.mNetwork = network;
        this.mCache = cache;
        this.mDelivery = responseDelivery;
    }

    @TargetApi(14)
    private void addTrafficStatsTag(Request<?> request) {
        TrafficStats.setThreadStatsTag(request.getTrafficStatsTag());
    }

    private void parseAndDeliverNetworkError(Request<?> request, VolleyError volleyError) {
        this.mDelivery.postError(request, request.parseNetworkError(volleyError));
    }

    public void quit() {
        this.mQuit = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() throws InterruptedException, SecurityException, IllegalArgumentException {
        Process.setThreadPriority(10);
        while (true) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            try {
                Request<?> requestTake = this.mQueue.take();
                try {
                    requestTake.addMarker("network-queue-take");
                    if (requestTake.isCanceled()) {
                        requestTake.finish("network-discard-cancelled");
                    } else {
                        addTrafficStatsTag(requestTake);
                        NetworkResponse networkResponsePerformRequest = this.mNetwork.performRequest(requestTake);
                        requestTake.addMarker("network-http-complete");
                        if (networkResponsePerformRequest.notModified && requestTake.hasHadResponseDelivered()) {
                            requestTake.finish("not-modified");
                        } else {
                            Response<?> networkResponse = requestTake.parseNetworkResponse(networkResponsePerformRequest);
                            requestTake.addMarker("network-parse-complete");
                            if (requestTake.shouldCache() && networkResponse.cacheEntry != null) {
                                this.mCache.put(requestTake.getCacheKey(), networkResponse.cacheEntry);
                                requestTake.addMarker("network-cache-written");
                            }
                            requestTake.markDelivered();
                            this.mDelivery.postResponse(requestTake, networkResponse);
                        }
                    }
                } catch (VolleyError e4) {
                    e4.setNetworkTimeMs(SystemClock.elapsedRealtime() - jElapsedRealtime);
                    parseAndDeliverNetworkError(requestTake, e4);
                } catch (Exception e5) {
                    VolleyLog.e(e5, "Unhandled exception %s", e5.toString());
                    VolleyError volleyError = new VolleyError(e5);
                    volleyError.setNetworkTimeMs(SystemClock.elapsedRealtime() - jElapsedRealtime);
                    this.mDelivery.postError(requestTake, volleyError);
                }
            } catch (InterruptedException unused) {
                if (this.mQuit) {
                    return;
                }
            }
        }
    }
}
