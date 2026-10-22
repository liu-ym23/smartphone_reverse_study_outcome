package com.android.ttcjpaysdk.bdpay.counter.outer.preload;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/preload/CacheData;", ExifInterface.GPS_DIRECTION_TRUE, "", "data", "cacheTime", "", "(Ljava/lang/Object;J)V", "getCacheTime", "()J", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CacheData<T> {
    private final long cacheTime;
    private final T data;

    public final long getCacheTime() {
        return this.cacheTime;
    }

    public final T getData() {
        return this.data;
    }

    public CacheData(T r100, long r101) {
        this.data = r100;
        this.cacheTime = r101;
    }
}
