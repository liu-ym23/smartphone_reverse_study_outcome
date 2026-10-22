package com.obric.repo.core;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CacheManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u001b\u0010\t\u001a\u0004\u0018\u0001H\n\"\u0004\b\u0000\u0010\n2\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\fJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010J!\u0010\u0011\u001a\u00020\b\"\u0004\b\u0000\u0010\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u0002H\n¢\u0006\u0002\u0010\u0013J\u000e\u0010\u0014\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0005R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/obric/repo/core/CacheManager;", "", "()V", "cache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/obric/repo/core/CacheManager$CacheEntry;", "clear", "", "get", ExifInterface.GPS_DIRECTION_TRUE, "key", "(Ljava/lang/String;)Ljava/lang/Object;", "isExpired", "", "maxAge", "", "put", "data", "(Ljava/lang/String;Ljava/lang/Object;)V", "remove", "CacheEntry", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CacheManager {
    public static final CacheManager INSTANCE = null;
    private static final ConcurrentHashMap<String, CacheEntry<?>> cache = null;

    /* JADX INFO: compiled from: CacheManager.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\f\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\bJ\t\u0010\r\u001a\u00020\u0005HÆ\u0003J(\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/obric/repo/core/CacheManager$CacheEntry;", ExifInterface.GPS_DIRECTION_TRUE, "", "data", "timestamp", "", "(Ljava/lang/Object;J)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getTimestamp", "()J", "component1", "component2", "copy", "(Ljava/lang/Object;J)Lcom/obric/repo/core/CacheManager$CacheEntry;", "equals", "", "other", "hashCode", "", "toString", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class CacheEntry<T> {
        private final T data;
        private final long timestamp;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CacheEntry copy$default(CacheEntry r0, Object r1, long r2, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.data;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.timestamp;
        L9:
            return r0.copy(r1, r2);
        }

        public final T component1() {
            return this.data;
        }

        public final long component2() {
            return this.timestamp;
        }

        public final CacheEntry<T> copy(T r1, long r2) {
            return new CacheEntry(r1, r2);
        }

        public boolean equals(Object r6) {
            if (this != r6) goto L6;
            return true;
        L6:
            if ((r6 instanceof CacheEntry) == true) goto L8;
            return false;
        L8:
            CacheEntry r7 = (CacheEntry) r6;
            if (Intrinsics.areEqual(this.data, r7.data) == true) goto L12;
            return false;
        L12:
            if (this.timestamp == r7.timestamp) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            T r0 = this.data;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (r1 * 31) + Long.hashCode(this.timestamp);
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public String toString() {
            return "CacheEntry(data=" + this.data + ", timestamp=" + this.timestamp + ')';
        }

        public CacheEntry(T r1, long r2) {
            this.data = r1;
            this.timestamp = r2;
        }

        public final T getData() {
            return this.data;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }
    }

    private CacheManager() {
    }

    static {
        INSTANCE = new CacheManager();
        cache = new ConcurrentHashMap();
    }

    public final <T> T get(String r1) {
        Intrinsics.checkNotNullParameter(r1, "key");
        CacheEntry<?> r0 = cache.get(r1);
        if (r0 == null) goto L5;
        Object r2 = r0.getData();
    L6:
        if (r2 != null) goto L9;
        return null;
    L9:
        return (T) r2;
    L5:
        r2 = null;
        goto L6
    }

    public final <T> void put(String r4, T r5) {
        Intrinsics.checkNotNullParameter(r4, "key");
        cache.put(r4, new CacheEntry(r5, System.currentTimeMillis()));
    }

    public final boolean isExpired(String r5, long r6) {
        Intrinsics.checkNotNullParameter(r5, "key");
        CacheEntry<?> r4 = cache.get(r5);
        if (r4 != null) goto L6;
        return true;
    L6:
        if ((System.currentTimeMillis() - r4.getTimestamp()) > r6) goto L10;
        return false;
    L10:
        return true;
    }

    public final void remove(String r1) {
        Intrinsics.checkNotNullParameter(r1, "key");
        cache.remove(r1);
    }

    public final void clear() {
        cache.clear();
    }
}
