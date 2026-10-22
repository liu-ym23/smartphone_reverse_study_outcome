package com.android.volley;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: loaded from: classes.dex */
public class CacheDispatcher extends Thread {
    private static final boolean DEBUG = false;
    private final Cache mCache;
    private final BlockingQueue<Request<?>> mCacheQueue;
    private final ResponseDelivery mDelivery;
    private final BlockingQueue<Request<?>> mNetworkQueue;
    private volatile boolean mQuit;

    static {
        DEBUG = VolleyLog.DEBUG;
    }

    public CacheDispatcher(BlockingQueue<Request<?>> r10, BlockingQueue<Request<?>> r11, Cache r12, ResponseDelivery r13) {
        this.mQuit = false;
        this.mCacheQueue = r10;
        this.mNetworkQueue = r11;
        this.mCache = r12;
        this.mDelivery = r13;
    }

    public static /* synthetic */ BlockingQueue access$000(CacheDispatcher r10) {
        return r10.mNetworkQueue;
    }

    public void quit() {
        this.mQuit = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (DEBUG == false) goto L5;
        VolleyLog.v("start new dispatcher", new Object[0]);
    L5:
        Process.setThreadPriority(10);
        this.mCache.initialize();
    L23:
        final Request<?> r10 = this.mCacheQueue.take();     // Catch: InterruptedException -> L20
        r10.addMarker("cache-queue-take");     // Catch: InterruptedException -> L20
        if (r10.isCanceled() == true) goto L8;
        Cache.Entry r11 = this.mCache.get(r10.getCacheKey());     // Catch: InterruptedException -> L20
        if (r11 == null) goto L11;
        if (r11.isExpired() == true) goto L14;
        r10.addMarker("cache-hit");     // Catch: InterruptedException -> L20
        Response<?> r12 = r10.parseNetworkResponse(new NetworkResponse(r11.data, r11.responseHeaders));     // Catch: InterruptedException -> L20
        r10.addMarker("cache-hit-parsed");     // Catch: InterruptedException -> L20
        if (r11.refreshNeeded() == false) goto L17;
        r10.addMarker("cache-hit-refresh-needed");     // Catch: InterruptedException -> L20
        r10.setCacheEntry(r11);     // Catch: InterruptedException -> L20
        r12.intermediate = true;     // Catch: InterruptedException -> L20
        this.mDelivery.postResponse(r10, r12, new AnonymousClass1(this, r10));     // Catch: InterruptedException -> L20
        goto L23
    L17:
        this.mDelivery.postResponse(r10, r12);     // Catch: InterruptedException -> L20
        goto L23
    L14:
        r10.addMarker("cache-hit-expired");     // Catch: InterruptedException -> L20
        r10.setCacheEntry(r11);     // Catch: InterruptedException -> L20
        this.mNetworkQueue.put(r10);     // Catch: InterruptedException -> L20
        goto L23
    L11:
        r10.addMarker("cache-miss");     // Catch: InterruptedException -> L20
        this.mNetworkQueue.put(r10);     // Catch: InterruptedException -> L20
        goto L23
    L8:
        r10.finish("cache-discard-canceled");     // Catch: InterruptedException -> L20
    L21:
        if (this.mQuit == false) goto L23;
    }
}
