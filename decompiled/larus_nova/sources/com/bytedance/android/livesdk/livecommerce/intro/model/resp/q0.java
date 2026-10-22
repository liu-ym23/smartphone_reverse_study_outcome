package com.bytedance.android.livesdk.livecommerce.intro.model.resp;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.amap.api.col.s.ce;
import com.bytedance.android.ec.model.response.StandardEventTrack;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R*\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R*\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000f\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R*\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010\u0005\u001a\u0004\b$\u0010\u0007R\u001c\u0010%\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R(\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010\u0005\u001a\u0004\b*\u0010\u0007R\u001c\u0010,\u001a\u0004\u0018\u00010+8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u001c\u00101\u001a\u0004\u0018\u0001008\u0006X\u0087\u0004¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104¨\u00065"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/q0;", "", "", "", "uiFrame", "Ljava/util/Map;", "h", "()Ljava/util/Map;", "uiFrameV2", RXScreenCaptureService.KEY_INDEX, "uiTemplate", "Ljava/lang/String;", ce.f26395j, "()Ljava/lang/String;", "", "status", "I", "getStatus", "()I", "", "", "durations", "Ljava/util/List;", "c", "()Ljava/util/List;", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroProduct;", "product", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroProduct;", "e", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroProduct;", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/h;", "bizExtendParam", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/h;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/h;", "auctionInfo", "getAuctionInfo", "cardType", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "eventParams", "d", "Lcom/bytedance/android/ec/model/response/StandardEventTrack;", "standardEventTrack", "Lcom/bytedance/android/ec/model/response/StandardEventTrack;", "f", "()Lcom/bytedance/android/ec/model/response/StandardEventTrack;", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/j0;", GXTemplateKey.GAIAX_TRACK, "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/j0;", ce.f26391f, "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/j0;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class q0 {

    @SerializedName("auction_info")
    private final Map<String, Object> auctionInfo;

    @SerializedName("biz_extend_param")
    private final h bizExtendParam;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE)
    private final Integer cardType;

    @SerializedName("durations")
    private final List<Long> durations;

    @SerializedName("event_param")
    private final Map<String, String> eventParams;

    @SerializedName("product")
    private final IntroProduct product;

    @SerializedName("standard_event_track")
    private final StandardEventTrack standardEventTrack;

    @SerializedName("status")
    private final int status;

    @SerializedName(GXTemplateKey.GAIAX_TRACK)
    private final j0 track;

    @SerializedName("ui_frame")
    private final Map<String, Object> uiFrame;

    @SerializedName("ui_frame_v2")
    private final Map<String, Object> uiFrameV2;

    @SerializedName("ui_template")
    private final String uiTemplate;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof q0) == false) goto L30;
        q0 r101 = (q0) r100;
        if (Intrinsics.areEqual(this.uiFrame, r101.uiFrame) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.uiFrameV2, r101.uiFrameV2) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.uiTemplate, r101.uiTemplate) == true) goto L12;
        return false;
    L12:
        if (this.status == r101.status) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.durations, r101.durations) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.product, r101.product) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.bizExtendParam, r101.bizExtendParam) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.auctionInfo, r101.auctionInfo) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.cardType, r101.cardType) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.eventParams, r101.eventParams) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.standardEventTrack, r101.standardEventTrack) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.track, r101.track) == true) goto L46;
        return false;
    L46:
        return true;
    L30:
        return false;
    }

    public final int hashCode() {
        Map<String, Object> r100 = this.uiFrame;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<String, Object> r104 = this.uiFrameV2;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.uiTemplate;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (((r106 + r108) * 31) + this.status) * 31;
        List<Long> r110 = this.durations;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        IntroProduct r113 = this.product;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        h r116 = this.bizExtendParam;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Map<String, Object> r119 = this.auctionInfo;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.cardType;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        Map<String, String> r125 = this.eventParams;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        StandardEventTrack r128 = this.standardEventTrack;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        j0 r131 = this.track;
        if (r131 == null) goto L46;
        r101 = r131.hashCode();
    L46:
        return r130 + r101;
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
        return "LiveAuctionProduct(uiFrame=" + this.uiFrame + ", uiFrameV2=" + this.uiFrameV2 + ", uiTemplate=" + this.uiTemplate + ", status=" + this.status + ", durations=" + this.durations + ", product=" + this.product + ", bizExtendParam=" + this.bizExtendParam + ", auctionInfo=" + this.auctionInfo + ", cardType=" + this.cardType + ", eventParams=" + this.eventParams + ", standardEventTrack=" + this.standardEventTrack + ", track=" + this.track + ")";
    }

    public q0() {
        this.uiFrame = null;
        this.uiFrameV2 = null;
        this.uiTemplate = null;
        this.status = 0;
        this.durations = null;
        this.product = null;
        this.bizExtendParam = null;
        this.auctionInfo = null;
        this.cardType = null;
        this.eventParams = null;
        this.standardEventTrack = null;
        this.track = null;
    }

    public final h a() {
        return this.bizExtendParam;
    }

    public final Integer b() {
        return this.cardType;
    }

    public final List<Long> c() {
        return this.durations;
    }

    public final Map<String, String> d() {
        return this.eventParams;
    }

    public final IntroProduct e() {
        return this.product;
    }

    public final StandardEventTrack f() {
        return this.standardEventTrack;
    }

    public final j0 g() {
        return this.track;
    }

    public final Map<String, Object> h() {
        return this.uiFrame;
    }

    public final Map<String, Object> i() {
        return this.uiFrameV2;
    }

    public final String j() {
        return this.uiTemplate;
    }
}
