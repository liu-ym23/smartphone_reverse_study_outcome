package com.bytedance.android.shopping.store.mall.follows.apidata;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/shopping/store/mall/follows/apidata/FollowStoreApiDataCacheKey;", "", "nativeData", "", "nativeTime", "feData", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFeData", "()Ljava/lang/String;", "getNativeData", "getNativeTime", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FollowStoreApiDataCacheKey {
    private final String feData;
    private final String nativeData;
    private final String nativeTime;

    public static /* synthetic */ FollowStoreApiDataCacheKey copy$default(FollowStoreApiDataCacheKey r100, String r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.nativeData;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.nativeTime;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.feData;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.nativeData;
    }

    public final String component2() {
        return this.nativeTime;
    }

    public final String component3() {
        return this.feData;
    }

    public final FollowStoreApiDataCacheKey copy(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "nativeData");
        Intrinsics.checkNotNullParameter(r101, "nativeTime");
        return new FollowStoreApiDataCacheKey(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof FollowStoreApiDataCacheKey) == false) goto L12;
        FollowStoreApiDataCacheKey r101 = (FollowStoreApiDataCacheKey) r100;
        if (Intrinsics.areEqual(this.nativeData, r101.nativeData) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.nativeTime, r101.nativeTime) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.feData, r101.feData) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r100 = this.nativeData;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.nativeTime;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.feData;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "FollowStoreApiDataCacheKey(nativeData=" + this.nativeData + ", nativeTime=" + this.nativeTime + ", feData=" + this.feData + ")";
    }

    public final String getFeData() {
        return this.feData;
    }

    public final String getNativeData() {
        return this.nativeData;
    }

    public final String getNativeTime() {
        return this.nativeTime;
    }

    public FollowStoreApiDataCacheKey(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "nativeData");
        Intrinsics.checkNotNullParameter(r101, "nativeTime");
        this.nativeData = r100;
        this.nativeTime = r101;
        this.feData = r102;
    }

    public /* synthetic */ FollowStoreApiDataCacheKey(String r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = null;
    L5:
        this(r100, r101, r102);
    }
}
