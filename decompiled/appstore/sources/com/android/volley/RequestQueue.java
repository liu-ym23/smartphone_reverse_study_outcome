package com.android.volley;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class RequestQueue {
    private static final int DEFAULT_NETWORK_THREAD_POOL_SIZE = 4;
    private final Cache mCache;
    private CacheDispatcher mCacheDispatcher;
    private final PriorityBlockingQueue<Request<?>> mCacheQueue;
    private final Set<Request<?>> mCurrentRequests;
    private final ResponseDelivery mDelivery;
    private NetworkDispatcher[] mDispatchers;
    private List<RequestFinishedListener> mFinishedListeners;
    private final Network mNetwork;
    private final PriorityBlockingQueue<Request<?>> mNetworkQueue;
    private AtomicInteger mSequenceGenerator;
    private final Map<String, Queue<Request<?>>> mWaitingRequests;

    public interface RequestFilter {
        boolean apply(Request<?> r10);
    }

    public interface RequestFinishedListener<T> {
        void onRequestFinished(Request<T> r10);
    }

    public RequestQueue(Cache r10, Network r11, int r12, ResponseDelivery r13) {
        this.mSequenceGenerator = new AtomicInteger();
        this.mWaitingRequests = new HashMap();
        this.mCurrentRequests = new HashSet();
        this.mCacheQueue = new PriorityBlockingQueue();
        this.mNetworkQueue = new PriorityBlockingQueue();
        this.mFinishedListeners = new ArrayList();
        this.mCache = r10;
        this.mNetwork = r11;
        this.mDispatchers = new NetworkDispatcher[r12];
        this.mDelivery = r13;
    }

    public <T> Request<T> add(Request<T> r10) {
        r10.setRequestQueue(this);
        Set<Request<?>> r11 = this.mCurrentRequests;
        monitor-enter(r11);
        this.mCurrentRequests.add(r10);     // Catch: Throwable -> L27
        monitor-exit(r11);     // Catch: Throwable -> L27
        r10.setSequence(getSequenceNumber());
        r10.addMarker("add-to-queue");
        if (r10.shouldCache() == true) goto L10;
        this.mNetworkQueue.add(r10);
        return r10;
    L10:
        Map<String, Queue<Request<?>>> r12 = this.mWaitingRequests;
        monitor-enter(r12);
        String r13 = r10.getCacheKey();     // Catch: Throwable -> L17
        if (this.mWaitingRequests.containsKey(r13) == false) goto L22;
        Queue<Request<?>> r14 = this.mWaitingRequests.get(r13);     // Catch: Throwable -> L17
        if (r14 != null) goto L19;
        r14 = new LinkedList();     // Catch: Throwable -> L17
    L19:
        r14.add(r10);     // Catch: Throwable -> L17
        this.mWaitingRequests.put(r13, r14);     // Catch: Throwable -> L17
        if (VolleyLog.DEBUG == false) goto L23;
        VolleyLog.v("Request for cacheKey=%s is in flight, putting on hold.", new Object[]{r13});     // Catch: Throwable -> L17
    L23:
        monitor-exit(r12);     // Catch: Throwable -> L17
        return r10;
    L22:
        this.mWaitingRequests.put(r13, null);     // Catch: Throwable -> L17
        this.mCacheQueue.add(r10);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    L27:
        th = move-exception;
        throw th;
    }

    public <T> void addRequestFinishedListener(RequestFinishedListener<T> r10) {
        List<RequestFinishedListener> r11 = this.mFinishedListeners;
        monitor-enter(r11);
        this.mFinishedListeners.add(r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void cancelAll(RequestFilter r10) {
        Set<Request<?>> r11 = this.mCurrentRequests;
        monitor-enter(r11);
        Iterator<Request<?>> r12 = this.mCurrentRequests.iterator();     // Catch: Throwable -> L10
    L6:
        if (r12.hasNext() == false) goto L12;
        Request<?> r13 = r12.next();     // Catch: Throwable -> L10
        if (r10.apply(r13) == false) goto L6;
        r13.cancel();     // Catch: Throwable -> L10
        goto L6
    L12:
        monitor-exit(r11);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public <T> void finish(Request<T> r10) {
        Set<Request<?>> r11 = this.mCurrentRequests;
        monitor-enter(r11);
        this.mCurrentRequests.remove(r10);     // Catch: Throwable -> L34
        monitor-exit(r11);     // Catch: Throwable -> L34
        List<RequestFinishedListener> r12 = this.mFinishedListeners;
        monitor-enter(r12);
        Iterator<RequestFinishedListener> r13 = this.mFinishedListeners.iterator();     // Catch: Throwable -> L12
    L10:
        if (r13.hasNext() == false) goto L14;
        r13.next().onRequestFinished(r10);     // Catch: Throwable -> L12
        goto L10
    L14:
        monitor-exit(r12);     // Catch: Throwable -> L12
        if (r10.shouldCache() == false) goto L31;
        Map<String, Queue<Request<?>>> r14 = this.mWaitingRequests;
        monitor-enter(r14);
        String r15 = r10.getCacheKey();     // Catch: Throwable -> L24
        Queue<Request<?>> r16 = this.mWaitingRequests.remove(r15);     // Catch: Throwable -> L24
        if (r16 != null) goto L22;
    L27:
        monitor-exit(r14);     // Catch: Throwable -> L24
        return;
    L22:
        if (VolleyLog.DEBUG == false) goto L26;
        VolleyLog.v("Releasing %d waiting requests for cacheKey=%s.", new Object[]{Integer.valueOf(r16.size()), r15});     // Catch: Throwable -> L24
    L26:
        this.mCacheQueue.addAll(r16);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    L31:
        return;
    L12:
        th = move-exception;
        throw th;
    L34:
        th = move-exception;
        throw th;
    }

    public Cache getCache() {
        return this.mCache;
    }

    public int getSequenceNumber() {
        return this.mSequenceGenerator.incrementAndGet();
    }

    public <T> void removeRequestFinishedListener(RequestFinishedListener<T> r10) {
        List<RequestFinishedListener> r11 = this.mFinishedListeners;
        monitor-enter(r11);
        this.mFinishedListeners.remove(r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void start() {
        stop();
        CacheDispatcher r10 = new CacheDispatcher(this.mCacheQueue, this.mNetworkQueue, this.mCache, this.mDelivery);
        this.mCacheDispatcher = r10;
        r10.start();
        int r11 = 0;
    L4:
        if (r11 >= this.mDispatchers.length) goto L6;
        NetworkDispatcher r12 = new NetworkDispatcher(this.mNetworkQueue, this.mNetwork, this.mCache, this.mDelivery);
        this.mDispatchers[r11] = r12;
        r12.start();
        r11 = r11 + 1;
        goto L4
    }

    public void stop() {
        CacheDispatcher r10 = this.mCacheDispatcher;
        if (r10 == null) goto L5;
        r10.quit();
    L5:
        int r11 = 0;
    L6:
        NetworkDispatcher[] r12 = this.mDispatchers;
        if (r11 >= r12.length) goto L12;
        NetworkDispatcher r13 = r12[r11];
        if (r13 == null) goto L11;
        r13.quit();
    L11:
        r11 = r11 + 1;
        goto L6
    }

    public void cancelAll(final Object r10) {
        if (r10 == null) goto L6;
        cancelAll(new AnonymousClass1(this, r10));
        return;
    L6:
        throw new IllegalArgumentException("Cannot cancelAll with a null tag");
    }

    public RequestQueue(Cache r10, Network r11, int r12) {
        this(r10, r11, r12, new ExecutorDelivery(new Handler(Looper.getMainLooper())));
    }

    public RequestQueue(Cache r10, Network r11) {
        this(r10, r11, 4);
    }
}
