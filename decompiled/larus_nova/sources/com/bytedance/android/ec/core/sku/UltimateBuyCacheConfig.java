package com.bytedance.android.ec.core.sku;

import com.bytedance.android.livehostapi.platform.base.IBaseHostPerformanceMonitor;
import com.google.gson.annotations.SerializedName;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J/\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\bHÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/ec/core/sku/UltimateBuyCacheConfig;", "Ljava/io/Serializable;", "cacheCount", "", Keys.API_PARAM_KEY_SDK_EXPIRETIME, "", "sceneTypeBlackList", "", "", "(IJLjava/util/List;)V", "getCacheCount", "()I", "setCacheCount", "(I)V", "getExpireTime", "()J", "getSceneTypeBlackList", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UltimateBuyCacheConfig implements Serializable {

    @SerializedName(IBaseHostPerformanceMonitor.CACHE_BITMAP_COUNT)
    private int cacheCount;

    @SerializedName("expire_time")
    private final long expireTime;

    @SerializedName("scene_type_black_list")
    private final List<String> sceneTypeBlackList;

    public UltimateBuyCacheConfig() {
        this(0, 0, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UltimateBuyCacheConfig copy$default(UltimateBuyCacheConfig r100, int r101, long r102, List r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.cacheCount;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.expireTime;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.sceneTypeBlackList;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final int component1() {
        return this.cacheCount;
    }

    public final long component2() {
        return this.expireTime;
    }

    public final List<String> component3() {
        return this.sceneTypeBlackList;
    }

    public final UltimateBuyCacheConfig copy(int r100, long r101, List<String> r102) {
        return new UltimateBuyCacheConfig(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof UltimateBuyCacheConfig) == false) goto L12;
        UltimateBuyCacheConfig r101 = (UltimateBuyCacheConfig) r100;
        if (this.cacheCount == r101.cacheCount) goto L8;
        return false;
    L8:
        if (this.expireTime == r101.expireTime) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.sceneTypeBlackList, r101.sceneTypeBlackList) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        int r100 = this.cacheCount * 31;
        long r101 = this.expireTime;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        List<String> r103 = this.sceneTypeBlackList;
        if (r103 == null) goto L5;
        int r104 = r103.hashCode();
    L7:
        return r102 + r104;
    L5:
        r104 = 0;
        goto L7
    }

    public String toString() {
        return "UltimateBuyCacheConfig(cacheCount=" + this.cacheCount + ", expireTime=" + this.expireTime + ", sceneTypeBlackList=" + this.sceneTypeBlackList + ")";
    }

    public final int getCacheCount() {
        return this.cacheCount;
    }

    public final long getExpireTime() {
        return this.expireTime;
    }

    public final List<String> getSceneTypeBlackList() {
        return this.sceneTypeBlackList;
    }

    public final void setCacheCount(int r100) {
        this.cacheCount = r100;
    }

    public UltimateBuyCacheConfig(int r100, long r101, List<String> r102) {
        this.cacheCount = r100;
        this.expireTime = r101;
        this.sceneTypeBlackList = r102;
    }

    public /* synthetic */ UltimateBuyCacheConfig(int r100, long r101, List r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = 5;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = 300;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
