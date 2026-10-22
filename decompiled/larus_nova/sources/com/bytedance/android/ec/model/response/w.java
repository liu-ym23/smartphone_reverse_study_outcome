package com.bytedance.android.ec.model.response;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bm\u0010nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010&\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u0010-\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R$\u00104\u001a\u0004\u0018\u0001038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R$\u0010;\u001a\u0004\u0018\u00010:8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010B\u001a\u00020A8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR$\u0010H\u001a\u0004\u0018\u00010A8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR$\u0010N\u001a\u0004\u0018\u00010A8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bN\u0010I\u001a\u0004\bO\u0010K\"\u0004\bP\u0010MR$\u0010R\u001a\u0004\u0018\u00010Q8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR0\u0010Y\u001a\u0010\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020:\u0018\u00010X8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R$\u0010`\u001a\u0004\u0018\u00010_8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR$\u0010g\u001a\u0004\u0018\u00010f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bg\u0010h\u001a\u0004\bi\u0010j\"\u0004\bk\u0010l¨\u0006o"}, d2 = {"Lcom/bytedance/android/ec/model/response/w;", "Lcom/bytedance/android/ec/model/g;", "Lcom/bytedance/android/ec/model/response/z0;", "image", "Lcom/bytedance/android/ec/model/response/z0;", "f", "()Lcom/bytedance/android/ec/model/response/z0;", "setImage", "(Lcom/bytedance/android/ec/model/response/z0;)V", "Lcom/bytedance/android/ec/model/response/j1;", "title", "Lcom/bytedance/android/ec/model/response/j1;", "o", "()Lcom/bytedance/android/ec/model/response/j1;", com.alipay.sdk.m.x.d.f25925o, "(Lcom/bytedance/android/ec/model/response/j1;)V", "Lcom/bytedance/android/ec/model/response/q0;", "benefits", "Lcom/bytedance/android/ec/model/response/q0;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/ec/model/response/q0;", "setBenefits", "(Lcom/bytedance/android/ec/model/response/q0;)V", "Lcom/bytedance/android/ec/model/response/d1;", "price", "Lcom/bytedance/android/ec/model/response/d1;", "h", "()Lcom/bytedance/android/ec/model/response/d1;", "setPrice", "(Lcom/bytedance/android/ec/model/response/d1;)V", "Lcom/bytedance/android/ec/model/response/g1;", "purchase", "Lcom/bytedance/android/ec/model/response/g1;", ce.f26396k, "()Lcom/bytedance/android/ec/model/response/g1;", "setPurchase", "(Lcom/bytedance/android/ec/model/response/g1;)V", "Lcom/bytedance/android/ec/model/response/d;", "blank", "Lcom/bytedance/android/ec/model/response/d;", "c", "()Lcom/bytedance/android/ec/model/response/d;", "setBlank", "(Lcom/bytedance/android/ec/model/response/d;)V", "Lcom/bytedance/android/ec/model/response/v0;", GXTemplateKey.GAIAX_EXTEND, "Lcom/bytedance/android/ec/model/response/v0;", "e", "()Lcom/bytedance/android/ec/model/response/v0;", "setExtend", "(Lcom/bytedance/android/ec/model/response/v0;)V", "Lcom/bytedance/android/ec/model/response/Product;", "product", "Lcom/bytedance/android/ec/model/response/Product;", RXScreenCaptureService.KEY_INDEX, "()Lcom/bytedance/android/ec/model/response/Product;", "setProduct", "(Lcom/bytedance/android/ec/model/response/Product;)V", "", "promotionId", "Ljava/lang/String;", ce.f26395j, "()Ljava/lang/String;", "setPromotionId", "(Ljava/lang/String;)V", "", "status", "I", OfficeSDKRequestTag.KEY_NEW_USER, "()I", "setStatus", "(I)V", "index", "Ljava/lang/Integer;", ce.f26391f, "()Ljava/lang/Integer;", "setIndex", "(Ljava/lang/Integer;)V", "realIndex", "l", "setRealIndex", "Lcom/bytedance/android/ec/model/response/BizExtendParam;", "bizExtendParam", "Lcom/bytedance/android/ec/model/response/BizExtendParam;", "b", "()Lcom/bytedance/android/ec/model/response/BizExtendParam;", "setBizExtendParam", "(Lcom/bytedance/android/ec/model/response/BizExtendParam;)V", "", "eventParams", "Ljava/util/Map;", "d", "()Ljava/util/Map;", "setEventParams", "(Ljava/util/Map;)V", "Lcom/bytedance/android/ec/model/response/StandardEventTrack;", "standardEventTrack", "Lcom/bytedance/android/ec/model/response/StandardEventTrack;", "m", "()Lcom/bytedance/android/ec/model/response/StandardEventTrack;", "setStandardEventTrack", "(Lcom/bytedance/android/ec/model/response/StandardEventTrack;)V", "Lcom/bytedance/android/ec/model/response/k1;", GXTemplateKey.GAIAX_TRACK, "Lcom/bytedance/android/ec/model/response/k1;", "p", "()Lcom/bytedance/android/ec/model/response/k1;", "setTrack", "(Lcom/bytedance/android/ec/model/response/k1;)V", "<init>", "()V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class w extends com.bytedance.android.ec.model.g {

    @SerializedName("benefits")
    private q0 benefits;

    @SerializedName("biz_extend_param")
    private BizExtendParam bizExtendParam;

    @SerializedName("blank")
    private d blank;

    @SerializedName("event_param")
    private Map<String, String> eventParams;

    @SerializedName(GXTemplateKey.GAIAX_EXTEND)
    private v0 extend;

    @SerializedName("image")
    private z0 image;

    @SerializedName("index")
    private Integer index;

    @SerializedName("price")
    private d1 price;

    @SerializedName("product")
    private Product product;

    @SerializedName("promotion_id")
    private String promotionId;

    @SerializedName("purchase")
    private g1 purchase;

    @SerializedName("real_index")
    private Integer realIndex;

    @SerializedName("standard_event_track")
    private StandardEventTrack standardEventTrack;

    @SerializedName("status")
    private int status;

    @SerializedName("title")
    private j1 title;

    @SerializedName(GXTemplateKey.GAIAX_TRACK)
    private k1 track;

    public w() {
    }

    public final q0 a() {
        return this.benefits;
    }

    public final BizExtendParam b() {
        return this.bizExtendParam;
    }

    public final d c() {
        return this.blank;
    }

    public final Map<String, String> d() {
        return this.eventParams;
    }

    public final v0 e() {
        return this.extend;
    }

    public final z0 f() {
        return this.image;
    }

    public final Integer g() {
        return this.index;
    }

    public final d1 h() {
        return this.price;
    }

    public final Product i() {
        return this.product;
    }

    public final String j() {
        return this.promotionId;
    }

    public final g1 k() {
        return this.purchase;
    }

    public final Integer l() {
        return this.realIndex;
    }

    public final StandardEventTrack m() {
        return this.standardEventTrack;
    }

    public final int n() {
        return this.status;
    }

    public final j1 o() {
        return this.title;
    }

    public final k1 p() {
        return this.track;
    }
}
