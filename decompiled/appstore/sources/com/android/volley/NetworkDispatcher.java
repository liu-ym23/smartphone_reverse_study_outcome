package com.android.volley;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: loaded from: classes.dex */
public class NetworkDispatcher extends Thread {
    private final Cache mCache;
    private final ResponseDelivery mDelivery;
    private final Network mNetwork;
    private final BlockingQueue<Request<?>> mQueue;
    private volatile boolean mQuit;

    public NetworkDispatcher(BlockingQueue<Request<?>> r10, Network r11, Cache r12, ResponseDelivery r13) {
        this.mQuit = false;
        this.mQueue = r10;
        this.mNetwork = r11;
        this.mCache = r12;
        this.mDelivery = r13;
    }

    @TargetApi(14)
    private void addTrafficStatsTag(Request<?> r10) {
        TrafficStats.setThreadStatsTag(r10.getTrafficStatsTag());
    }

    private void parseAndDeliverNetworkError(Request<?> r10, VolleyError r11) {
        VolleyError r12 = r10.parseNetworkError(r11);
        this.mDelivery.postError(r10, r12);
    }

    public void quit() {
        this.mQuit = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
    L3:
        long r10 = SystemClock.elapsedRealtime();
        Request<?> r11 = this.mQueue.take();     // Catch: InterruptedException -> L26
        r11.addMarker("network-queue-take");     // Catch: Exception -> L8 VolleyError -> L10
    L6:
        if (r11.isCanceled() == true) goto L7;
        addTrafficStatsTag(r11);     // Catch: Exception -> L8 VolleyError -> L10
        NetworkResponse r12 = this.mNetwork.performRequest(r11);     // Catch: Exception -> L8 VolleyError -> L10
        r11.addMarker("network-http-complete");     // Catch: Exception -> L8 VolleyError -> L10
        if (r12.notModified == false) goto L17;
        if (r11.hasHadResponseDelivered() == false) goto L17;
        r11.finish("not-modified");     // Catch: Exception -> L8 VolleyError -> L10
    L17:
        Response<?> r13 = r11.parseNetworkResponse(r12);     // Catch: Exception -> L8 VolleyError -> L10
        r11.addMarker("network-parse-complete");     // Catch: Exception -> L8 VolleyError -> L10
        if (r11.shouldCache() == true) goto L20;
    L22:
        r11.markDelivered();     // Catch: Exception -> L8 VolleyError -> L10
        this.mDelivery.postResponse(r11, r13);     // Catch: Exception -> L8 VolleyError -> L10
        goto L3
    L20:
        if (r13.cacheEntry == null) goto L22;
        this.mCache.put(r11.getCacheKey(), r13.cacheEntry);     // Catch: Exception -> L8 VolleyError -> L10
        r11.addMarker("network-cache-written");     // Catch: Exception -> L8 VolleyError -> L10
        goto L22
    L7:
        r11.finish("network-discard-cancelled");     // Catch: Exception -> L8 VolleyError -> L10
    L10:
        e = move-exception;
        e.setNetworkTimeMs(SystemClock.elapsedRealtime() - r10);
        parseAndDeliverNetworkError(r11, e);
    L8:
        e = move-exception;
        VolleyLog.e(e, "Unhandled exception %s", new Object[]{e.toString()});
        VolleyError r14 = new VolleyError(e);
        r14.setNetworkTimeMs(SystemClock.elapsedRealtime() - r10);
        this.mDelivery.postError(r11, r14);
    L27:
        if (this.mQuit == false) goto L3;
    }
}
