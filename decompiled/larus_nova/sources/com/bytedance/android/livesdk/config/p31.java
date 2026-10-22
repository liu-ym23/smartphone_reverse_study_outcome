package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/config/p31;", "", "", "enable", "Z", "getEnable", "()Z", "setEnable", "(Z)V", "enablePreviewCreateRoomOptimize", "getEnablePreviewCreateRoomOptimize", "setEnablePreviewCreateRoomOptimize", "enableRecyclerViewOptimize", "getEnableRecyclerViewOptimize", "setEnableRecyclerViewOptimize", "enablePlayerViewOptimize", "getEnablePlayerViewOptimize", "setEnablePlayerViewOptimize", "enablePerformanceOptimize", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setEnablePerformanceOptimize", "enableDataCollectorOptimize", "getEnableDataCollectorOptimize", "setEnableDataCollectorOptimize", "enableLiveStreamerOptimize", "getEnableLiveStreamerOptimize", "setEnableLiveStreamerOptimize", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class p31 {

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("data_collector")
    private boolean enableDataCollectorOptimize;

    @SerializedName("live_streamer")
    private boolean enableLiveStreamerOptimize;

    @SerializedName("live_performance")
    private boolean enablePerformanceOptimize;

    @SerializedName("player_view")
    private boolean enablePlayerViewOptimize;

    @SerializedName("preview_create_room")
    private boolean enablePreviewCreateRoomOptimize;

    @SerializedName("category_recyclerview")
    private boolean enableRecyclerViewOptimize;

    public p31() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof p31) == false) goto L20;
        p31 r101 = (p31) r100;
        if (this.enable == r101.enable) goto L8;
        return false;
    L8:
        if (this.enablePreviewCreateRoomOptimize == r101.enablePreviewCreateRoomOptimize) goto L10;
        return false;
    L10:
        if (this.enableRecyclerViewOptimize == r101.enableRecyclerViewOptimize) goto L12;
        return false;
    L12:
        if (this.enablePlayerViewOptimize == r101.enablePlayerViewOptimize) goto L14;
        return false;
    L14:
        if (this.enablePerformanceOptimize == r101.enablePerformanceOptimize) goto L16;
        return false;
    L16:
        if (this.enableDataCollectorOptimize == r101.enableDataCollectorOptimize) goto L18;
        return false;
    L18:
        if (this.enableLiveStreamerOptimize == r101.enableLiveStreamerOptimize) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9, types: [int] */
    public final int hashCode() {
        boolean r100 = this.enable;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.enablePreviewCreateRoomOptimize;
        ?? r105 = r104;
        if (r104 == false) goto L8;
        r105 = 1;
    L8:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.enableRecyclerViewOptimize;
        ?? r108 = r107;
        if (r107 == false) goto L11;
        r108 = 1;
    L11:
        int r109 = (r106 + r108) * 31;
        boolean r110 = this.enablePlayerViewOptimize;
        ?? r111 = r110;
        if (r110 == false) goto L14;
        r111 = 1;
    L14:
        int r112 = (r109 + r111) * 31;
        boolean r113 = this.enablePerformanceOptimize;
        ?? r114 = r113;
        if (r113 == false) goto L17;
        r114 = 1;
    L17:
        int r115 = (r112 + r114) * 31;
        boolean r116 = this.enableDataCollectorOptimize;
        ?? r117 = r116;
        if (r116 == false) goto L20;
        r117 = 1;
    L20:
        int r118 = (r115 + r117) * 31;
        boolean r119 = this.enableLiveStreamerOptimize;
        if (r119 == true) goto L25;
        r101 = r119;
    L25:
        return r118 + r101;
    }

    public final String toString() {
        return "LiveGameLinkConfig(enable=" + this.enable + ", enablePreviewCreateRoomOptimize=" + this.enablePreviewCreateRoomOptimize + ", enableRecyclerViewOptimize=" + this.enableRecyclerViewOptimize + ", enablePlayerViewOptimize=" + this.enablePlayerViewOptimize + ", enablePerformanceOptimize=" + this.enablePerformanceOptimize + ", enableDataCollectorOptimize=" + this.enableDataCollectorOptimize + ", enableLiveStreamerOptimize=" + this.enableLiveStreamerOptimize + ")";
    }

    public final boolean a() {
        return this.enablePerformanceOptimize;
    }

    public p31(int r100) {
        this.enable = false;
        this.enablePreviewCreateRoomOptimize = false;
        this.enableRecyclerViewOptimize = false;
        this.enablePlayerViewOptimize = false;
        this.enablePerformanceOptimize = false;
        this.enableDataCollectorOptimize = false;
        this.enableLiveStreamerOptimize = false;
    }
}
