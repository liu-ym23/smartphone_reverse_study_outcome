package com.bytedance.android.gamecp.common.setting.config;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\rR\u001a\u0010\u0015\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u001a\u0010\u0017\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001a\u0010\u0019\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006R\u001a\u0010\u001b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/i1;", "", "", "optLynxPreLoadVersionCheck", "Z", "e", "()Z", "optRenderOrder", "h", "", "optLynxPreCreateTime", "J", "getOptLynxPreCreateTime", "()J", "", "optLynxPreCreateUrl", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "optCloudGameInitTime", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "optLynxSubscribeDownload", ce.f26391f, "optDownloadStatusCacheEnable", "b", "optLynxPredecodeEnable", "f", "optLynxCodeCacheEnable", "c", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i1 {

    @SerializedName("opt_cloud_game_init_time")
    private final long optCloudGameInitTime;

    @SerializedName("opt_download_status_cache_enable")
    private final boolean optDownloadStatusCacheEnable;

    @SerializedName("opt_lynx_code_cache_enable")
    private final boolean optLynxCodeCacheEnable;

    @SerializedName("opt_lynx_pre_create_time")
    private final long optLynxPreCreateTime;

    @SerializedName("opt_lynx_pre_create_url")
    private final String optLynxPreCreateUrl;

    @SerializedName("opt_lynx_preload_version_check")
    private final boolean optLynxPreLoadVersionCheck;

    @SerializedName("opt_lynx_predecode_enable")
    private final boolean optLynxPredecodeEnable;

    @SerializedName("opt_lynx_subscribe_download")
    private final boolean optLynxSubscribeDownload;

    @SerializedName("opt_render_order")
    private final boolean optRenderOrder;

    public i1() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i1) == false) goto L24;
        i1 r101 = (i1) r100;
        if (this.optLynxPreLoadVersionCheck == r101.optLynxPreLoadVersionCheck) goto L8;
        return false;
    L8:
        if (this.optRenderOrder == r101.optRenderOrder) goto L10;
        return false;
    L10:
        if (this.optLynxPreCreateTime == r101.optLynxPreCreateTime) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.optLynxPreCreateUrl, r101.optLynxPreCreateUrl) == true) goto L14;
        return false;
    L14:
        if (this.optCloudGameInitTime == r101.optCloudGameInitTime) goto L16;
        return false;
    L16:
        if (this.optLynxSubscribeDownload == r101.optLynxSubscribeDownload) goto L18;
        return false;
    L18:
        if (this.optDownloadStatusCacheEnable == r101.optDownloadStatusCacheEnable) goto L20;
        return false;
    L20:
        if (this.optLynxPredecodeEnable == r101.optLynxPredecodeEnable) goto L22;
        return false;
    L22:
        if (this.optLynxCodeCacheEnable == r101.optLynxCodeCacheEnable) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r0v17, types: [int] */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v14, types: [int] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    public final int hashCode() {
        boolean r100 = this.optLynxPreLoadVersionCheck;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.optRenderOrder;
        ?? r105 = r104;
        if (r104 == false) goto L8;
        r105 = 1;
    L8:
        int r106 = (r103 + r105) * 31;
        long r107 = this.optLynxPreCreateTime;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        String r109 = this.optLynxPreCreateUrl;
        if (r109 == null) goto L11;
        int r110 = r109.hashCode();
    L12:
        int r111 = (r108 + r110) * 31;
        long r112 = this.optCloudGameInitTime;
        int r113 = (r111 + ((int) (r112 ^ (r112 >>> 32)))) * 31;
        boolean r114 = this.optLynxSubscribeDownload;
        ?? r115 = r114;
        if (r114 == false) goto L15;
        r115 = 1;
    L15:
        int r116 = (r113 + r115) * 31;
        boolean r117 = this.optDownloadStatusCacheEnable;
        ?? r118 = r117;
        if (r117 == false) goto L18;
        r118 = 1;
    L18:
        int r119 = (r116 + r118) * 31;
        boolean r120 = this.optLynxPredecodeEnable;
        ?? r121 = r120;
        if (r120 == false) goto L21;
        r121 = 1;
    L21:
        int r122 = (r119 + r121) * 31;
        boolean r123 = this.optLynxCodeCacheEnable;
        if (r123 == true) goto L26;
        r101 = r123;
    L26:
        return r122 + r101;
    L11:
        r110 = 0;
        goto L12
    }

    public final String toString() {
        return "GameDetailPerformanceOptConfig(optLynxPreLoadVersionCheck=" + this.optLynxPreLoadVersionCheck + ", optRenderOrder=" + this.optRenderOrder + ", optLynxPreCreateTime=" + this.optLynxPreCreateTime + ", optLynxPreCreateUrl=" + this.optLynxPreCreateUrl + ", optCloudGameInitTime=" + this.optCloudGameInitTime + ", optLynxSubscribeDownload=" + this.optLynxSubscribeDownload + ", optDownloadStatusCacheEnable=" + this.optDownloadStatusCacheEnable + ", optLynxPredecodeEnable=" + this.optLynxPredecodeEnable + ", optLynxCodeCacheEnable=" + this.optLynxCodeCacheEnable + ")";
    }

    public final long a() {
        return this.optCloudGameInitTime;
    }

    public final boolean b() {
        return this.optDownloadStatusCacheEnable;
    }

    public final boolean c() {
        return this.optLynxCodeCacheEnable;
    }

    public final String d() {
        return this.optLynxPreCreateUrl;
    }

    public final boolean e() {
        return this.optLynxPreLoadVersionCheck;
    }

    public final boolean f() {
        return this.optLynxPredecodeEnable;
    }

    public final boolean g() {
        return this.optLynxSubscribeDownload;
    }

    public final boolean h() {
        return this.optRenderOrder;
    }

    public i1(int r100) {
        this.optLynxPreLoadVersionCheck = false;
        this.optRenderOrder = false;
        this.optLynxPreCreateTime = 0;
        this.optLynxPreCreateUrl = "";
        this.optCloudGameInitTime = 0;
        this.optLynxSubscribeDownload = false;
        this.optDownloadStatusCacheEnable = false;
        this.optLynxPredecodeEnable = false;
        this.optLynxCodeCacheEnable = false;
    }
}
