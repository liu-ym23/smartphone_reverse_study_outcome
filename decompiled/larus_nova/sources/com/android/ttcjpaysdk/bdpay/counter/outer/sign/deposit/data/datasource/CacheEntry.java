package com.android.ttcjpaysdk.bdpay.counter.outer.sign.deposit.data.datasource;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u000e\u0010\u000e\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J2\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0006\u0010\u0018\u001a\u00020\u0014J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/data/datasource/CacheEntry;", ExifInterface.GPS_DIRECTION_TRUE, "", "data", "timestamp", "", Keys.API_PARAM_KEY_SDK_EXPIRETIME, "(Ljava/lang/Object;JJ)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getExpireTime", "()J", "getTimestamp", "component1", "component2", "component3", "copy", "(Ljava/lang/Object;JJ)Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/data/datasource/CacheEntry;", "equals", "", "other", "hashCode", "", "isExpired", "toString", "", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CacheEntry<T> {
    private final T data;
    private final long expireTime;
    private final long timestamp;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CacheEntry copy$default(CacheEntry r100, Object r101, long r102, long r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.data;
    L6:
        if ((r104 & 2) == 0) goto L8;
        r102 = r100.timestamp;
    L8:
        long r106 = r102;
        if ((r104 & 4) == 0) goto L11;
        r103 = r100.expireTime;
    L11:
        Object r107 = r101;
        return r100.copy(r107, r106, r103);
    }

    public final T component1() {
        return this.data;
    }

    public final long component2() {
        return this.timestamp;
    }

    public final long component3() {
        return this.expireTime;
    }

    public final CacheEntry<T> copy(T r100, long r101, long r110) {
        return new CacheEntry(r100, r101, r110);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CacheEntry) == true) goto L8;
        return false;
    L8:
        CacheEntry r101 = (CacheEntry) r100;
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L12;
        return false;
    L12:
        if (this.timestamp == r101.timestamp) goto L15;
        return false;
    L15:
        if (this.expireTime == r101.expireTime) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        T r100 = this.data;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        long r102 = this.timestamp;
        int r103 = ((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.expireTime;
        return r103 + ((int) (r104 ^ (r104 >>> 32)));
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "CacheEntry(data=" + this.data + ", timestamp=" + this.timestamp + ", expireTime=" + this.expireTime + ')';
    }

    public final boolean isExpired() {
        if ((System.currentTimeMillis() - this.timestamp) <= this.expireTime) goto L5;
        return true;
    L5:
        return false;
    }

    public final T getData() {
        return this.data;
    }

    public final long getExpireTime() {
        return this.expireTime;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public CacheEntry(T r100, long r101, long r102) {
        this.data = r100;
        this.timestamp = r101;
        this.expireTime = r102;
    }

    public /* synthetic */ CacheEntry(Object r100, long r101, long r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 4) == 0) goto L5;
        r110 = 600000;
    L5:
        this(r100, r101, r110);
    }
}
