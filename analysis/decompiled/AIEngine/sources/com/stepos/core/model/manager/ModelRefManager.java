package com.stepos.core.model.manager;

import android.os.SystemClock;
import com.stepos.base.model.ModelReleaseReason;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelRefManager {
    private final ConcurrentHashMap<String, Bucket> buckets = new ConcurrentHashMap<>();
    private final AtomicLong tokenSeq = new AtomicLong(0);
    private final ConcurrentHashMap<String, ConcurrentHashMap<ModelReleaseReason, AtomicLong>> releaseCounters = new ConcurrentHashMap<>();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Bucket {
        private final ReentrantLock lock = new ReentrantLock();
        private final LinkedHashMap<String, ModelRefRecord> records = new LinkedHashMap<>();

        public final ReentrantLock getLock() {
            return this.lock;
        }

        public final LinkedHashMap<String, ModelRefRecord> getRecords() {
            return this.records;
        }
    }

    private final Bucket bucketOf(String str) {
        Bucket bucketPutIfAbsent;
        ConcurrentHashMap<String, Bucket> concurrentHashMap = this.buckets;
        Bucket bucket = concurrentHashMap.get(str);
        if (bucket == null && (bucketPutIfAbsent = concurrentHashMap.putIfAbsent(str, (bucket = new Bucket()))) != null) {
            bucket = bucketPutIfAbsent;
        }
        return bucket;
    }

    private final String nextToken(String str) {
        return str + "#" + this.tokenSeq.incrementAndGet();
    }

    private static final long releaseStats$n(ConcurrentHashMap<ModelReleaseReason, AtomicLong> concurrentHashMap, ModelReleaseReason modelReleaseReason) {
        AtomicLong atomicLong;
        if (concurrentHashMap == null || (atomicLong = concurrentHashMap.get(modelReleaseReason)) == null) {
            return 0L;
        }
        return atomicLong.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence releaseStatsAll$lambda$14(ModelRefManager modelRefManager, String mid) {
        kotlin.jvm.internal.g.f(mid, "mid");
        return com.stepos.core.ota.d.i(mid, ": ", modelRefManager.releaseStats(mid));
    }

    public final String acquire(String modelId, ModelRefHolder holder, ModelAcquireSource source) {
        kotlin.jvm.internal.g.f(modelId, "modelId");
        kotlin.jvm.internal.g.f(holder, "holder");
        kotlin.jvm.internal.g.f(source, "source");
        Bucket bucketBucketOf = bucketOf(modelId);
        ReentrantLock lock = bucketBucketOf.getLock();
        lock.lock();
        try {
            String strNextToken = nextToken(modelId);
            bucketBucketOf.getRecords().put(strNextToken, new ModelRefRecord(strNextToken, holder, source, SystemClock.elapsedRealtimeNanos()));
            return strNextToken;
        } finally {
            lock.unlock();
        }
    }

    public final int clear(String modelId) {
        kotlin.jvm.internal.g.f(modelId, "modelId");
        Bucket bucketRemove = this.buckets.remove(modelId);
        if (bucketRemove == null) {
            return 0;
        }
        ReentrantLock lock = bucketRemove.getLock();
        lock.lock();
        try {
            int size = bucketRemove.getRecords().size();
            bucketRemove.getRecords().clear();
            return size;
        } finally {
            lock.unlock();
        }
    }

    public final void clearAll() {
        this.buckets.clear();
        this.releaseCounters.clear();
    }

    public final int count(String modelId) {
        kotlin.jvm.internal.g.f(modelId, "modelId");
        Bucket bucket = this.buckets.get(modelId);
        if (bucket == null) {
            return 0;
        }
        ReentrantLock lock = bucket.getLock();
        lock.lock();
        try {
            return bucket.getRecords().size();
        } finally {
            lock.unlock();
        }
    }

    public final Set<Integer> holderUidsOf(String modelId) {
        kotlin.jvm.internal.g.f(modelId, "modelId");
        Bucket bucket = this.buckets.get(modelId);
        if (bucket == null) {
            return EmptySet.f10003a;
        }
        ReentrantLock lock = bucket.getLock();
        lock.lock();
        try {
            Collection<ModelRefRecord> collectionValues = bucket.getRecords().values();
            kotlin.jvm.internal.g.e(collectionValues, "<get-values>(...)");
            HashSet hashSet = new HashSet();
            Iterator<T> it = collectionValues.iterator();
            while (it.hasNext()) {
                hashSet.add(Integer.valueOf(((ModelRefRecord) it.next()).getHolder().getUid()));
            }
            return hashSet;
        } finally {
            lock.unlock();
        }
    }

    public final boolean release(String modelId, String str, ModelReleaseReason reason) {
        AtomicLong atomicLongPutIfAbsent;
        ConcurrentHashMap<ModelReleaseReason, AtomicLong> concurrentHashMapPutIfAbsent;
        kotlin.jvm.internal.g.f(modelId, "modelId");
        kotlin.jvm.internal.g.f(reason, "reason");
        Bucket bucket = this.buckets.get(modelId);
        if (bucket == null) {
            return true;
        }
        ReentrantLock lock = bucket.getLock();
        lock.lock();
        try {
            if (str != null) {
                bucket.getRecords().remove(str);
            } else {
                Set<String> setKeySet = bucket.getRecords().keySet();
                kotlin.jvm.internal.g.e(setKeySet, "<get-keys>(...)");
                String str2 = (String) kotlin.collections.a.u0(setKeySet);
                if (str2 != null) {
                    bucket.getRecords().remove(str2);
                }
            }
            ConcurrentHashMap<String, ConcurrentHashMap<ModelReleaseReason, AtomicLong>> concurrentHashMap = this.releaseCounters;
            ConcurrentHashMap<ModelReleaseReason, AtomicLong> concurrentHashMap2 = concurrentHashMap.get(modelId);
            if (concurrentHashMap2 == null && (concurrentHashMapPutIfAbsent = concurrentHashMap.putIfAbsent(modelId, (concurrentHashMap2 = new ConcurrentHashMap<>()))) != null) {
                concurrentHashMap2 = concurrentHashMapPutIfAbsent;
            }
            ConcurrentHashMap<ModelReleaseReason, AtomicLong> concurrentHashMap3 = concurrentHashMap2;
            AtomicLong atomicLong = concurrentHashMap3.get(reason);
            if (atomicLong == null && (atomicLongPutIfAbsent = concurrentHashMap3.putIfAbsent(reason, (atomicLong = new AtomicLong(0L)))) != null) {
                atomicLong = atomicLongPutIfAbsent;
            }
            atomicLong.incrementAndGet();
            boolean zIsEmpty = bucket.getRecords().isEmpty();
            lock.unlock();
            return zIsEmpty;
        } catch (Throwable th) {
            lock.unlock();
            throw th;
        }
    }

    public final String releaseStats(String modelId) {
        kotlin.jvm.internal.g.f(modelId, "modelId");
        ConcurrentHashMap<ModelReleaseReason, AtomicLong> concurrentHashMap = this.releaseCounters.get(modelId);
        long jReleaseStats$n = releaseStats$n(concurrentHashMap, ModelReleaseReason.f6320a);
        long jReleaseStats$n2 = releaseStats$n(concurrentHashMap, ModelReleaseReason.f6321b);
        long jReleaseStats$n3 = releaseStats$n(concurrentHashMap, ModelReleaseReason.f6322c);
        long jReleaseStats$n4 = releaseStats$n(concurrentHashMap, ModelReleaseReason.f6323d);
        long jReleaseStats$n5 = releaseStats$n(concurrentHashMap, ModelReleaseReason.f6324e);
        long jReleaseStats$n6 = releaseStats$n(concurrentHashMap, ModelReleaseReason.h);
        StringBuilder sbQ = ai.onnxruntime.a.q(jReleaseStats$n, "soft_idle=", " hard_explicit=");
        sbQ.append(jReleaseStats$n2);
        a0.a.s(jReleaseStats$n3, " client_death=", " framework_recycle=", sbQ);
        sbQ.append(jReleaseStats$n4);
        a0.a.s(jReleaseStats$n5, " load_fail=", " version_swap=", sbQ);
        sbQ.append(jReleaseStats$n6);
        return sbQ.toString();
    }

    public final String releaseStatsAll() {
        if (this.releaseCounters.isEmpty()) {
            return "";
        }
        Set<String> setKeySet = this.releaseCounters.keySet();
        kotlin.jvm.internal.g.e(setKeySet, "<get-keys>(...)");
        return kotlin.collections.a.z0(kotlin.collections.a.H0(setKeySet), "\n", null, null, new zb.l() { // from class: com.stepos.core.model.manager.r
            @Override // zb.l
            public final Object invoke(Object obj) {
                return ModelRefManager.releaseStatsAll$lambda$14(this.f7472a, (String) obj);
            }
        }, 30);
    }

    public final List<ModelRefRecord> snapshot(String modelId) {
        kotlin.jvm.internal.g.f(modelId, "modelId");
        Bucket bucket = this.buckets.get(modelId);
        if (bucket != null) {
            ReentrantLock lock = bucket.getLock();
            lock.lock();
            try {
                Collection<ModelRefRecord> collectionValues = bucket.getRecords().values();
                kotlin.jvm.internal.g.e(collectionValues, "<get-values>(...)");
                List<ModelRefRecord> listO0 = kotlin.collections.a.O0(collectionValues);
                if (listO0 != null) {
                    return listO0;
                }
            } finally {
                lock.unlock();
            }
        }
        return EmptyList.f10001a;
    }
}
