package com.bytedance.android.gamecp.common.setting.config;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R$\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R$\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0015\u0010\u000eR\u001a\u0010\u0016\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006R\u001a\u0010\u0018\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/h1;", "", "", "enableLynxPreloadWhenLiveRoomIdle", "I", "b", "()I", "enableLynxPreload", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "", "lynxPreloadList", "Ljava/util/List;", "e", "()Ljava/util/List;", "", "minLynxGeckoResVersion", "J", "f", "()J", "lynxLazyRenderList", "d", "optLynxInitParams", ce.f26391f, "lynxCacheInContext", "c", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h1 {

    @SerializedName("enable_lynx_preload")
    private final int enableLynxPreload;

    @SerializedName("enable_lynx_preload_room_idle")
    private final int enableLynxPreloadWhenLiveRoomIdle;

    @SerializedName("lynx_cache_in_context")
    private final int lynxCacheInContext;

    @SerializedName("lynx_lazy_render_list")
    private final List<String> lynxLazyRenderList;

    @SerializedName("lynx_preload_list")
    private final List<String> lynxPreloadList;

    @SerializedName("game_promote_tools_update_data_min_version")
    private final long minLynxGeckoResVersion;

    @SerializedName("opt_lynx_init_params")
    private final int optLynxInitParams;

    public h1() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h1) == false) goto L20;
        h1 r101 = (h1) r100;
        if (this.enableLynxPreloadWhenLiveRoomIdle == r101.enableLynxPreloadWhenLiveRoomIdle) goto L8;
        return false;
    L8:
        if (this.enableLynxPreload == r101.enableLynxPreload) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.lynxPreloadList, r101.lynxPreloadList) == true) goto L12;
        return false;
    L12:
        if (this.minLynxGeckoResVersion == r101.minLynxGeckoResVersion) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.lynxLazyRenderList, r101.lynxLazyRenderList) == true) goto L16;
        return false;
    L16:
        if (this.optLynxInitParams == r101.optLynxInitParams) goto L18;
        return false;
    L18:
        if (this.lynxCacheInContext == r101.lynxCacheInContext) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        int r100 = ((this.enableLynxPreloadWhenLiveRoomIdle * 31) + this.enableLynxPreload) * 31;
        List<String> r101 = this.lynxPreloadList;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        long r104 = this.minLynxGeckoResVersion;
        int r105 = (((r100 + r103) * 31) + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        List<String> r106 = this.lynxLazyRenderList;
        if (r106 == null) goto L10;
        r102 = r106.hashCode();
    L10:
        return ((((r105 + r102) * 31) + this.optLynxInitParams) * 31) + this.lynxCacheInContext;
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "GameDetailLynxPreloadConfig(enableLynxPreloadWhenLiveRoomIdle=" + this.enableLynxPreloadWhenLiveRoomIdle + ", enableLynxPreload=" + this.enableLynxPreload + ", lynxPreloadList=" + this.lynxPreloadList + ", minLynxGeckoResVersion=" + this.minLynxGeckoResVersion + ", lynxLazyRenderList=" + this.lynxLazyRenderList + ", optLynxInitParams=" + this.optLynxInitParams + ", lynxCacheInContext=" + this.lynxCacheInContext + ")";
    }

    public final int a() {
        return this.enableLynxPreload;
    }

    public final int b() {
        return this.enableLynxPreloadWhenLiveRoomIdle;
    }

    public final int c() {
        return this.lynxCacheInContext;
    }

    public final List<String> d() {
        return this.lynxLazyRenderList;
    }

    public final List<String> e() {
        return this.lynxPreloadList;
    }

    public final long f() {
        return this.minLynxGeckoResVersion;
    }

    public final int g() {
        return this.optLynxInitParams;
    }

    public h1(Object r100) {
        this.enableLynxPreloadWhenLiveRoomIdle = 0;
        this.enableLynxPreload = 0;
        this.lynxPreloadList = null;
        this.minLynxGeckoResVersion = 0;
        this.lynxLazyRenderList = null;
        this.optLynxInitParams = 1;
        this.lynxCacheInContext = 0;
    }
}
