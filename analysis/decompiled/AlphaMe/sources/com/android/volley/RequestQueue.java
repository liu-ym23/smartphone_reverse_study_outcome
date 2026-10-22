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

/* loaded from: classes.dex */
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
        boolean apply(Request<?> request);
    }

    public interface RequestFinishedListener<T> {
        void onRequestFinished(Request<T> request);
    }

    public RequestQueue(Cache cache, Network network, int i4, ResponseDelivery responseDelivery) {
        this.mSequenceGenerator = new AtomicInteger();
        this.mWaitingRequests = new HashMap();
        this.mCurrentRequests = new HashSet();
        this.mCacheQueue = new PriorityBlockingQueue<>();
        this.mNetworkQueue = new PriorityBlockingQueue<>();
        this.mFinishedListeners = new ArrayList();
        this.mCache = cache;
        this.mNetwork = network;
        this.mDispatchers = new NetworkDispatcher[i4];
        this.mDelivery = responseDelivery;
    }

    public <T> Request<T> add(Request<T> request) {
        request.setRequestQueue(this);
        synchronized (this.mCurrentRequests) {
            this.mCurrentRequests.add(request);
        }
        request.setSequence(getSequenceNumber());
        request.addMarker("add-to-queue");
        if (!request.shouldCache()) {
            this.mNetworkQueue.add(request);
            return request;
        }
        synchronized (this.mWaitingRequests) {
            try {
                String cacheKey = request.getCacheKey();
                if (this.mWaitingRequests.containsKey(cacheKey)) {
                    Queue<Request<?>> linkedList = this.mWaitingRequests.get(cacheKey);
                    if (linkedList == null) {
                        linkedList = new LinkedList<>();
                    }
                    linkedList.add(request);
                    this.mWaitingRequests.put(cacheKey, linkedList);
                    if (VolleyLog.DEBUG) {
                        VolleyLog.v("Request for cacheKey=%s is in flight, putting on hold.", cacheKey);
                    }
                } else {
                    this.mWaitingRequests.put(cacheKey, null);
                    this.mCacheQueue.add(request);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return request;
    }

    public <T> void addRequestFinishedListener(RequestFinishedListener<T> requestFinishedListener) {
        synchronized (this.mFinishedListeners) {
            this.mFinishedListeners.add(requestFinishedListener);
        }
    }

    public void cancelAll(RequestFilter requestFilter) {
        synchronized (this.mCurrentRequests) {
            try {
                for (Request<?> request : this.mCurrentRequests) {
                    if (requestFilter.apply(request)) {
                        request.cancel();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public <T> void finish(Request<T> request) {
        synchronized (this.mCurrentRequests) {
            this.mCurrentRequests.remove(request);
        }
        synchronized (this.mFinishedListeners) {
            try {
                Iterator<RequestFinishedListener> it = this.mFinishedListeners.iterator();
                while (it.hasNext()) {
                    it.next().onRequestFinished(request);
                }
            } finally {
            }
        }
        if (request.shouldCache()) {
            synchronized (this.mWaitingRequests) {
                try {
                    String cacheKey = request.getCacheKey();
                    Queue<Request<?>> queueRemove = this.mWaitingRequests.remove(cacheKey);
                    if (queueRemove != null) {
                        if (VolleyLog.DEBUG) {
                            VolleyLog.v("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(queueRemove.size()), cacheKey);
                        }
                        this.mCacheQueue.addAll(queueRemove);
                    }
                } finally {
                }
            }
        }
    }

    public Cache getCache() {
        return this.mCache;
    }

    public int getSequenceNumber() {
        return this.mSequenceGenerator.incrementAndGet();
    }

    public <T> void removeRequestFinishedListener(RequestFinishedListener<T> requestFinishedListener) {
        synchronized (this.mFinishedListeners) {
            this.mFinishedListeners.remove(requestFinishedListener);
        }
    }

    public void start() {
        stop();
        CacheDispatcher cacheDispatcher = new CacheDispatcher(this.mCacheQueue, this.mNetworkQueue, this.mCache, this.mDelivery);
        this.mCacheDispatcher = cacheDispatcher;
        cacheDispatcher.start();
        for (int i4 = 0; i4 < this.mDispatchers.length; i4++) {
            NetworkDispatcher networkDispatcher = new NetworkDispatcher(this.mNetworkQueue, this.mNetwork, this.mCache, this.mDelivery);
            this.mDispatchers[i4] = networkDispatcher;
            networkDispatcher.start();
        }
    }

    public void stop() {
        CacheDispatcher cacheDispatcher = this.mCacheDispatcher;
        if (cacheDispatcher != null) {
            cacheDispatcher.quit();
        }
        int i4 = 0;
        while (true) {
            NetworkDispatcher[] networkDispatcherArr = this.mDispatchers;
            if (i4 >= networkDispatcherArr.length) {
                return;
            }
            NetworkDispatcher networkDispatcher = networkDispatcherArr[i4];
            if (networkDispatcher != null) {
                networkDispatcher.quit();
            }
            i4++;
        }
    }

    public void cancelAll(final Object obj) {
        if (obj != null) {
            cancelAll(new RequestFilter() { // from class: com.android.volley.RequestQueue.1
                @Override // com.android.volley.RequestQueue.RequestFilter
                public boolean apply(Request<?> request) {
                    return request.getTag() == obj;
                }
            });
            return;
        }
        throw new IllegalArgumentException("Cannot cancelAll with a null tag");
    }

    public RequestQueue(Cache cache, Network network, int i4) {
        this(cache, network, i4, new ExecutorDelivery(new Handler(Looper.getMainLooper())));
    }

    public RequestQueue(Cache cache, Network network) {
        this(cache, network, 4);
    }
}
