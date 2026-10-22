package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001a\u0010\u0014\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/preload/d;", "", "", "enable", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "enableScroll", "e", "enableDefaultSelect", "d", "enableChangeTab", "b", "enableCreatePanel", "c", "preloadGiftExtra", ce.f26391f, "preloadLynxModel", "h", "", "gridViewHolderItemNum", "I", "f", "()I", "verticalPageItemNum", RXScreenCaptureService.KEY_INDEX, "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("enable_change_tab")
    private final boolean enableChangeTab;

    @SerializedName("enable_create_panel")
    private final boolean enableCreatePanel;

    @SerializedName("enable_default_select")
    private final boolean enableDefaultSelect;

    @SerializedName("enable_scroll")
    private final boolean enableScroll;

    @SerializedName("grid_view_holder_item_num")
    private final int gridViewHolderItemNum;

    @SerializedName("preload_gift_extra")
    private final boolean preloadGiftExtra;

    @SerializedName("preload_lynx_model")
    private final boolean preloadLynxModel;

    @SerializedName("vertical_page_item_num")
    private final int verticalPageItemNum;

    public d() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L24;
        d r101 = (d) r100;
        if (this.enable == r101.enable) goto L8;
        return false;
    L8:
        if (this.enableScroll == r101.enableScroll) goto L10;
        return false;
    L10:
        if (this.enableDefaultSelect == r101.enableDefaultSelect) goto L12;
        return false;
    L12:
        if (this.enableChangeTab == r101.enableChangeTab) goto L14;
        return false;
    L14:
        if (this.enableCreatePanel == r101.enableCreatePanel) goto L16;
        return false;
    L16:
        if (this.preloadGiftExtra == r101.preloadGiftExtra) goto L18;
        return false;
    L18:
        if (this.preloadLynxModel == r101.preloadLynxModel) goto L20;
        return false;
    L20:
        if (this.gridViewHolderItemNum == r101.gridViewHolderItemNum) goto L22;
        return false;
    L22:
        if (this.verticalPageItemNum == r101.verticalPageItemNum) goto L37;
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
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
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
        boolean r104 = this.enableScroll;
        ?? r105 = r104;
        if (r104 == false) goto L8;
        r105 = 1;
    L8:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.enableDefaultSelect;
        ?? r108 = r107;
        if (r107 == false) goto L11;
        r108 = 1;
    L11:
        int r109 = (r106 + r108) * 31;
        boolean r110 = this.enableChangeTab;
        ?? r111 = r110;
        if (r110 == false) goto L14;
        r111 = 1;
    L14:
        int r112 = (r109 + r111) * 31;
        boolean r113 = this.enableCreatePanel;
        ?? r114 = r113;
        if (r113 == false) goto L17;
        r114 = 1;
    L17:
        int r115 = (r112 + r114) * 31;
        boolean r116 = this.preloadGiftExtra;
        ?? r117 = r116;
        if (r116 == false) goto L20;
        r117 = 1;
    L20:
        int r118 = (r115 + r117) * 31;
        boolean r119 = this.preloadLynxModel;
        if (r119 == true) goto L25;
        r101 = r119;
    L25:
        return ((((r118 + r101) * 31) + this.gridViewHolderItemNum) * 31) + this.verticalPageItemNum;
    }

    public final String toString() {
        return "GiftPreloaderConfig(enable=" + this.enable + ", enableScroll=" + this.enableScroll + ", enableDefaultSelect=" + this.enableDefaultSelect + ", enableChangeTab=" + this.enableChangeTab + ", enableCreatePanel=" + this.enableCreatePanel + ", preloadGiftExtra=" + this.preloadGiftExtra + ", preloadLynxModel=" + this.preloadLynxModel + ", gridViewHolderItemNum=" + this.gridViewHolderItemNum + ", verticalPageItemNum=" + this.verticalPageItemNum + ")";
    }

    public final boolean a() {
        return this.enable;
    }

    public final boolean b() {
        return this.enableChangeTab;
    }

    public final boolean c() {
        return this.enableCreatePanel;
    }

    public final boolean d() {
        return this.enableDefaultSelect;
    }

    public final boolean e() {
        return this.enableScroll;
    }

    public final int f() {
        return this.gridViewHolderItemNum;
    }

    public final boolean g() {
        return this.preloadGiftExtra;
    }

    public final boolean h() {
        return this.preloadLynxModel;
    }

    public final int i() {
        return this.verticalPageItemNum;
    }

    public d(int r100) {
        this.enable = false;
        this.enableScroll = false;
        this.enableDefaultSelect = false;
        this.enableChangeTab = false;
        this.enableCreatePanel = false;
        this.preloadGiftExtra = false;
        this.preloadLynxModel = false;
        this.gridViewHolderItemNum = 12;
        this.verticalPageItemNum = 2;
    }
}
