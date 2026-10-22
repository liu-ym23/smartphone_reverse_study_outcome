package com.bytedance.android.livesdk.livecommerce.intro.model.resp;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.amap.api.col.s.ce;
import com.bytedance.android.ec.model.response.StandardEventTrack;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010!\u001a\u0004\u0018\u00010 8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010&\u001a\u0004\u0018\u00010%8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001c\u0010+\u001a\u0004\u0018\u00010*8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\"\u00101\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010/8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u001c\u00106\u001a\u0004\u0018\u0001058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u001a\u0010;\u001a\u00020:8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u001c\u0010@\u001a\u0004\u0018\u00010?8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\u001c\u0010E\u001a\u0004\u0018\u00010D8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR(\u0010K\u001a\u0010\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u00020J\u0018\u00010I8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u0010NR\u001c\u0010P\u001a\u0004\u0018\u00010O8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010SR\u001c\u0010U\u001a\u0004\u0018\u00010T8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bU\u0010V\u001a\u0004\bW\u0010XR\u001c\u0010Z\u001a\u0004\u0018\u00010Y8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]¨\u0006^"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/t0;", "", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/u;", "image", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/u;", RXScreenCaptureService.KEY_INDEX, "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/u;", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/o0;", "title", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/o0;", "p", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/o0;", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/g;", "benefits", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/g;", "c", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/g;", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/l;", "carouselBenefits", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/l;", "f", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/l;", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/e;", "background", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/e;", "b", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/e;", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroPrice;", "price", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroPrice;", ce.f26396k, "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroPrice;", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/k0;", "purchase", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/k0;", "m", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/k0;", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/i;", "blank", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/i;", "e", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/i;", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroAtmosphere;", "atmosphere", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroAtmosphere;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroAtmosphere;", "", "", "durations", "Ljava/util/List;", ce.f26391f, "()Ljava/util/List;", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/g0;", "secondFrame", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/g0;", OfficeSDKRequestTag.KEY_NEW_USER, "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/g0;", "", "status", "I", "getStatus", "()I", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroProduct;", "product", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroProduct;", "l", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroProduct;", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/h;", "bizExtendParam", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/h;", "d", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/h;", "", "", "eventParams", "Ljava/util/Map;", "h", "()Ljava/util/Map;", "Lcom/bytedance/android/ec/model/response/StandardEventTrack;", "standardEventTrack", "Lcom/bytedance/android/ec/model/response/StandardEventTrack;", "o", "()Lcom/bytedance/android/ec/model/response/StandardEventTrack;", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/j0;", GXTemplateKey.GAIAX_TRACK, "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/j0;", "q", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/j0;", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/y;", "openPriceAnimation", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/y;", ce.f26395j, "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/y;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class t0 {

    @SerializedName("atmosphere")
    private final IntroAtmosphere atmosphere;

    @SerializedName("background")
    private final e background;

    @SerializedName("benefits")
    private final g benefits;

    @SerializedName("biz_extend_param")
    private final h bizExtendParam;

    @SerializedName("blank")
    private final i blank;

    @SerializedName("carousel_benefits")
    private final l carouselBenefits;

    @SerializedName("durations")
    private final List<Long> durations;

    @SerializedName("event_param")
    private final Map<String, String> eventParams;

    @SerializedName("image")
    private final u image;

    @SerializedName("open_price_animation")
    private final y openPriceAnimation;

    @SerializedName("price")
    private final IntroPrice price;

    @SerializedName("product")
    private final IntroProduct product;

    @SerializedName("purchase")
    private final k0 purchase;

    @SerializedName("second_frame")
    private final g0 secondFrame;

    @SerializedName("standard_event_track")
    private final StandardEventTrack standardEventTrack;

    @SerializedName("status")
    private final int status;

    @SerializedName("title")
    private final o0 title;

    @SerializedName(GXTemplateKey.GAIAX_TRACK)
    private final j0 track;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof t0) == false) goto L42;
        t0 r101 = (t0) r100;
        if (Intrinsics.areEqual(this.image, r101.image) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.benefits, r101.benefits) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.carouselBenefits, r101.carouselBenefits) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.background, r101.background) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.price, r101.price) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.purchase, r101.purchase) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.blank, r101.blank) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.atmosphere, r101.atmosphere) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.durations, r101.durations) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.secondFrame, r101.secondFrame) == true) goto L28;
        return false;
    L28:
        if (this.status == r101.status) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.product, r101.product) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.bizExtendParam, r101.bizExtendParam) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.eventParams, r101.eventParams) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.standardEventTrack, r101.standardEventTrack) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.track, r101.track) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.openPriceAnimation, r101.openPriceAnimation) == true) goto L64;
        return false;
    L64:
        return true;
    L42:
        return false;
    }

    public final int hashCode() {
        u r100 = this.image;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        o0 r104 = this.title;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        g r107 = this.benefits;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        l r110 = this.carouselBenefits;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        e r113 = this.background;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        IntroPrice r116 = this.price;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        k0 r119 = this.purchase;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        i r122 = this.blank;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        IntroAtmosphere r125 = this.atmosphere;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        List<Long> r128 = this.durations;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        g0 r131 = this.secondFrame;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (((r130 + r132) * 31) + this.status) * 31;
        IntroProduct r134 = this.product;
        if (r134 == null) goto L49;
        int r135 = r134.hashCode();
    L50:
        int r136 = (r133 + r135) * 31;
        h r137 = this.bizExtendParam;
        if (r137 == null) goto L53;
        int r138 = r137.hashCode();
    L54:
        int r139 = (r136 + r138) * 31;
        Map<String, String> r140 = this.eventParams;
        if (r140 == null) goto L57;
        int r141 = r140.hashCode();
    L58:
        int r142 = (r139 + r141) * 31;
        StandardEventTrack r143 = this.standardEventTrack;
        if (r143 == null) goto L61;
        int r144 = r143.hashCode();
    L62:
        int r145 = (r142 + r144) * 31;
        j0 r146 = this.track;
        if (r146 == null) goto L65;
        int r147 = r146.hashCode();
    L66:
        int r148 = (r145 + r147) * 31;
        y r149 = this.openPriceAnimation;
        if (r149 == null) goto L70;
        r101 = r149.hashCode();
    L70:
        return r148 + r101;
    L65:
        r147 = 0;
        goto L66
    L61:
        r144 = 0;
        goto L62
    L57:
        r141 = 0;
        goto L58
    L53:
        r138 = 0;
        goto L54
    L49:
        r135 = 0;
        goto L50
    L45:
        r132 = 0;
        goto L46
    L41:
        r129 = 0;
        goto L42
    L37:
        r126 = 0;
        goto L38
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "LiveIntroProduct(image=" + this.image + ", title=" + this.title + ", benefits=" + this.benefits + ", carouselBenefits=" + this.carouselBenefits + ", background=" + this.background + ", price=" + this.price + ", purchase=" + this.purchase + ", blank=" + this.blank + ", atmosphere=" + this.atmosphere + ", durations=" + this.durations + ", secondFrame=" + this.secondFrame + ", status=" + this.status + ", product=" + this.product + ", bizExtendParam=" + this.bizExtendParam + ", eventParams=" + this.eventParams + ", standardEventTrack=" + this.standardEventTrack + ", track=" + this.track + ", openPriceAnimation=" + this.openPriceAnimation + ")";
    }

    public t0() {
        this.image = null;
        this.title = null;
        this.benefits = null;
        this.carouselBenefits = null;
        this.background = null;
        this.price = null;
        this.purchase = null;
        this.blank = null;
        this.atmosphere = null;
        this.durations = null;
        this.secondFrame = null;
        this.status = 0;
        this.product = null;
        this.bizExtendParam = null;
        this.eventParams = null;
        this.standardEventTrack = null;
        this.track = null;
        this.openPriceAnimation = null;
    }

    public final IntroAtmosphere a() {
        return this.atmosphere;
    }

    public final e b() {
        return this.background;
    }

    public final g c() {
        return this.benefits;
    }

    public final h d() {
        return this.bizExtendParam;
    }

    public final i e() {
        return this.blank;
    }

    public final l f() {
        return this.carouselBenefits;
    }

    public final List<Long> g() {
        return this.durations;
    }

    public final Map<String, String> h() {
        return this.eventParams;
    }

    public final u i() {
        return this.image;
    }

    public final y j() {
        return this.openPriceAnimation;
    }

    public final IntroPrice k() {
        return this.price;
    }

    public final IntroProduct l() {
        return this.product;
    }

    public final k0 m() {
        return this.purchase;
    }

    public final g0 n() {
        return this.secondFrame;
    }

    public final StandardEventTrack o() {
        return this.standardEventTrack;
    }

    public final o0 p() {
        return this.title;
    }

    public final j0 q() {
        return this.track;
    }
}
