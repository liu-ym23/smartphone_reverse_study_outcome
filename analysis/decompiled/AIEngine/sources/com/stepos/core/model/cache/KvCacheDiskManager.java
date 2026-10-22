package com.stepos.core.model.cache;

import a0.a;
import android.content.Context;
import android.util.Log;
import com.stepos.core.ota.d;
import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.g;
import kotlin.text.Regex;
import lb.n;
import mb.l;
import ob.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class KvCacheDiskManager {
    private static final String DIR_NAME = "kv_cache";
    private static final long MAX_TOTAL_BYTES = 536870912;
    private static final String TAG = "KvCacheDiskManager";
    private static File cacheDir;
    private static long totalBytes;
    public static final KvCacheDiskManager INSTANCE = new KvCacheDiskManager();
    private static final KvCacheDiskManager$index$1 index = new KvCacheDiskManager$index$1();
    private static final Object lock = new Object();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class KvCacheEntry {
        private final long createdAt;
        private final String sessionId;
        private final long sizeBytes;

        public KvCacheEntry(String sessionId, long j10, long j11) {
            g.f(sessionId, "sessionId");
            this.sessionId = sessionId;
            this.sizeBytes = j10;
            this.createdAt = j11;
        }

        public static /* synthetic */ KvCacheEntry copy$default(KvCacheEntry kvCacheEntry, String str, long j10, long j11, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = kvCacheEntry.sessionId;
            }
            if ((i10 & 2) != 0) {
                j10 = kvCacheEntry.sizeBytes;
            }
            if ((i10 & 4) != 0) {
                j11 = kvCacheEntry.createdAt;
            }
            return kvCacheEntry.copy(str, j10, j11);
        }

        public final String component1() {
            return this.sessionId;
        }

        public final long component2() {
            return this.sizeBytes;
        }

        public final long component3() {
            return this.createdAt;
        }

        public final KvCacheEntry copy(String sessionId, long j10, long j11) {
            g.f(sessionId, "sessionId");
            return new KvCacheEntry(sessionId, j10, j11);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof KvCacheEntry)) {
                return false;
            }
            KvCacheEntry kvCacheEntry = (KvCacheEntry) obj;
            return g.b(this.sessionId, kvCacheEntry.sessionId) && this.sizeBytes == kvCacheEntry.sizeBytes && this.createdAt == kvCacheEntry.createdAt;
        }

        public final long getCreatedAt() {
            return this.createdAt;
        }

        public final String getSessionId() {
            return this.sessionId;
        }

        public final long getSizeBytes() {
            return this.sizeBytes;
        }

        public int hashCode() {
            return Long.hashCode(this.createdAt) + a.c(this.sessionId.hashCode() * 31, this.sizeBytes, 31);
        }

        public String toString() {
            String str = this.sessionId;
            return a.d(this.createdAt, ", createdAt=", ")", d.l("KvCacheEntry(sessionId=", this.sizeBytes, str, ", sizeBytes="));
        }
    }

    private KvCacheDiskManager() {
    }

    private final void evictIfNeeded() {
        evictUntil(536870912L);
    }

    private final void evictUntil(long j10) {
        File file = cacheDir;
        if (file == null) {
            return;
        }
        Iterator<Map.Entry<String, KvCacheEntry>> it = index.entrySet().iterator();
        while (totalBytes > j10 && it.hasNext()) {
            KvCacheEntry value = it.next().getValue();
            it.remove();
            totalBytes -= value.getSizeBytes();
            new File(file, sanitizeFileName(value.getSessionId())).delete();
            StringBuilder sbL = d.l("Evicted KV-Cache: ", value.getSizeBytes(), value.getSessionId(), ", freed ");
            sbL.append(" bytes");
            Log.d(TAG, sbL.toString());
        }
    }

    private final void rebuildIndex() {
        File file = cacheDir;
        if (file == null) {
            return;
        }
        index.clear();
        totalBytes = 0L;
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : l.k0(fileArrListFiles, new Comparator() { // from class: com.stepos.core.model.cache.KvCacheDiskManager$rebuildIndex$$inlined$sortedBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t8, T t10) {
                    return b.a(Long.valueOf(((File) t8).lastModified()), Long.valueOf(((File) t10).lastModified()));
                }
            })) {
                g.c(file2);
                String strV = wb.d.V(file2);
                KvCacheEntry kvCacheEntry = new KvCacheEntry(strV, file2.length(), file2.lastModified());
                index.put(strV, kvCacheEntry);
                totalBytes = kvCacheEntry.getSizeBytes() + totalBytes;
            }
        }
        int size = index.size();
        long j10 = totalBytes / 1024;
        StringBuilder sb2 = new StringBuilder("Index rebuilt: ");
        sb2.append(size);
        sb2.append(" entries, ");
        sb2.append(j10);
        ai.onnxruntime.a.y(sb2, "KB total", TAG);
    }

    private final String sanitizeFileName(String str) {
        return new Regex("[^a-zA-Z0-9_-]").d(str, "_").concat(".kvc");
    }

    public final void cleanup(int i10) {
        synchronized (lock) {
            long j10 = 1024;
            INSTANCE.evictUntil(i10 * j10 * j10);
            n nVar = n.f10413a;
        }
    }

    public final void clear() {
        synchronized (lock) {
            try {
                File file = cacheDir;
                if (file == null) {
                    return;
                }
                index.clear();
                totalBytes = 0L;
                File[] fileArrListFiles = file.listFiles();
                if (fileArrListFiles != null) {
                    for (File file2 : fileArrListFiles) {
                        file2.delete();
                    }
                    n nVar = n.f10413a;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final int entryCount() {
        int size;
        synchronized (lock) {
            size = index.size();
        }
        return size;
    }

    public final void evict(String sessionId) {
        g.f(sessionId, "sessionId");
        synchronized (lock) {
            File file = cacheDir;
            if (file == null) {
                return;
            }
            KvCacheEntry kvCacheEntry = (KvCacheEntry) index.remove((Object) sessionId);
            if (kvCacheEntry != null) {
                totalBytes -= kvCacheEntry.getSizeBytes();
                new File(file, INSTANCE.sanitizeFileName(sessionId)).delete();
            }
        }
    }

    public final void init(Context context) {
        g.f(context, "context");
        synchronized (lock) {
            try {
                File file = new File(context.getFilesDir(), DIR_NAME);
                if (!file.exists()) {
                    file.mkdirs();
                }
                cacheDir = file;
                INSTANCE.rebuildIndex();
                n nVar = n.f10413a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final byte[] load(String sessionId) {
        g.f(sessionId, "sessionId");
        synchronized (lock) {
            File file = cacheDir;
            byte[] bArrX = null;
            if (file == null) {
                return null;
            }
            KvCacheEntry kvCacheEntry = (KvCacheEntry) index.get((Object) sessionId);
            if (kvCacheEntry == null) {
                return null;
            }
            File file2 = new File(file, INSTANCE.sanitizeFileName(kvCacheEntry.getSessionId()));
            try {
                if (file2.exists()) {
                    bArrX = wb.d.X(file2);
                }
            } catch (IOException e10) {
                Log.e(TAG, "Failed to read KV-Cache: ".concat(sessionId), e10);
            }
            return bArrX;
        }
    }

    public final void save(String sessionId, byte[] data) {
        g.f(sessionId, "sessionId");
        g.f(data, "data");
        synchronized (lock) {
            File file = cacheDir;
            if (file == null) {
                return;
            }
            KvCacheDiskManager kvCacheDiskManager = INSTANCE;
            File file2 = new File(file, kvCacheDiskManager.sanitizeFileName(sessionId));
            KvCacheDiskManager$index$1 kvCacheDiskManager$index$1 = index;
            KvCacheEntry kvCacheEntry = (KvCacheEntry) kvCacheDiskManager$index$1.remove((Object) sessionId);
            if (kvCacheEntry != null) {
                totalBytes -= kvCacheEntry.getSizeBytes();
            }
            try {
                wb.d.c0(file2, data);
                KvCacheEntry kvCacheEntry2 = new KvCacheEntry(sessionId, data.length, System.currentTimeMillis());
                kvCacheDiskManager$index$1.put(sessionId, kvCacheEntry2);
                totalBytes += kvCacheEntry2.getSizeBytes();
                kvCacheDiskManager.evictIfNeeded();
                n nVar = n.f10413a;
            } catch (IOException e10) {
                Log.e(TAG, "Failed to write KV-Cache: ".concat(sessionId), e10);
            }
        }
    }

    public final long totalSizeBytes() {
        long j10;
        synchronized (lock) {
            j10 = totalBytes;
        }
        return j10;
    }
}
