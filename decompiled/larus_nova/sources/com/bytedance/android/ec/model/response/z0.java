package com.bytedance.android.ec.model.response;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b7\u00108R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R$\u0010\u0014\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010&\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u0010-\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R*\u00104\u001a\n\u0012\u0004\u0012\u000203\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u0010\u0005\u001a\u0004\b5\u0010\u0007\"\u0004\b6\u0010\t¨\u00069"}, d2 = {"Lcom/bytedance/android/ec/model/response/z0;", "", "", "Lcom/bytedance/android/ec/model/response/y0;", "icons", "Ljava/util/List;", ce.f26391f, "()Ljava/util/List;", "m", "(Ljava/util/List;)V", "", "borderURL", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setBorderURL", "(Ljava/lang/String;)V", "cover", "d", ce.f26396k, "maskHint", "h", "setMaskHint", "Lcom/bytedance/android/ec/model/response/a1;", "bottomBanner", "Lcom/bytedance/android/ec/model/response/a1;", "c", "()Lcom/bytedance/android/ec/model/response/a1;", "setBottomBanner", "(Lcom/bytedance/android/ec/model/response/a1;)V", "Lcom/bytedance/android/ec/model/response/ECHotAtmosphere;", "hotAtmosphere", "Lcom/bytedance/android/ec/model/response/ECHotAtmosphere;", "f", "()Lcom/bytedance/android/ec/model/response/ECHotAtmosphere;", "l", "(Lcom/bytedance/android/ec/model/response/ECHotAtmosphere;)V", "", "showHotAtmosphere", "Ljava/lang/Boolean;", RXScreenCaptureService.KEY_INDEX, "()Ljava/lang/Boolean;", "setShowHotAtmosphere", "(Ljava/lang/Boolean;)V", "Lcom/bytedance/android/ec/model/response/ECAuctionAtmosphere;", "auctionAtmosphere", "Lcom/bytedance/android/ec/model/response/ECAuctionAtmosphere;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/ec/model/response/ECAuctionAtmosphere;", ce.f26395j, "(Lcom/bytedance/android/ec/model/response/ECAuctionAtmosphere;)V", "Lcom/bytedance/android/ec/model/response/ECPromotionFloatIcon;", "floatIcons", "e", "setFloatIcons", "<init>", "()V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class z0 {

    @SerializedName("auction_atmosphere")
    private ECAuctionAtmosphere auctionAtmosphere;

    @SerializedName("border_url")
    private String borderURL;

    @SerializedName("bottom_banner")
    private a1 bottomBanner;

    @SerializedName("cover")
    private String cover;

    @SerializedName("float_icons")
    private List<ECPromotionFloatIcon> floatIcons;

    @SerializedName("hot_atmosphere")
    private ECHotAtmosphere hotAtmosphere;

    @SerializedName("icons")
    private List<y0> icons;

    @SerializedName("mask_hint")
    private String maskHint;

    @SerializedName("show_hot_atmosphere")
    private Boolean showHotAtmosphere;

    public z0() {
    }

    public final ECAuctionAtmosphere a() {
        return this.auctionAtmosphere;
    }

    public final String b() {
        return this.borderURL;
    }

    public final a1 c() {
        return this.bottomBanner;
    }

    public final String d() {
        return this.cover;
    }

    public final List<ECPromotionFloatIcon> e() {
        return this.floatIcons;
    }

    public final ECHotAtmosphere f() {
        return this.hotAtmosphere;
    }

    public final List<y0> g() {
        return this.icons;
    }

    public final String h() {
        return this.maskHint;
    }

    public final Boolean i() {
        return this.showHotAtmosphere;
    }

    public final void j(ECAuctionAtmosphere r100) {
        this.auctionAtmosphere = r100;
    }

    public final void k(String r100) {
        this.cover = r100;
    }

    public final void l(ECHotAtmosphere r100) {
        this.hotAtmosphere = r100;
    }

    public final void m(List<y0> r100) {
        this.icons = r100;
    }
}
