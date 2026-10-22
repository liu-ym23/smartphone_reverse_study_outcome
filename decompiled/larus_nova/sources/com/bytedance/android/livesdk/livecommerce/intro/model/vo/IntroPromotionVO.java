package com.bytedance.android.livesdk.livecommerce.intro.model.vo;

import android.text.TextUtils;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.alipay.sdk.m.x.d;
import com.bytedance.android.ec.model.response.ECHotAtmosphere;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.ec.model.response.TrackEventType;
import com.bytedance.android.livesdk.livecommerce.intro.model.req.IntroCardScene;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.IntroAtmosphere;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.IntroPrice;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.IntroProduct;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.e;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.g;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.g0;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.i;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.j0;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.k0;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.l;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.m0;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.o0;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.s0;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.t;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.u;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.w;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.y;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ql.a;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0014\u0012\t\b\u0002\u0010¤\u0001\u001a\u00020s¢\u0006\u0006\b¥\u0001\u0010\u009b\u0001J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0004H\u0016J\u0012\u0010\u0011\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\rH\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\rH\u0016J\b\u0010\u0016\u001a\u00020\rH\u0016J\u0011\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u001a\u001a\u00020\rH\u0016J\b\u0010\u001b\u001a\u00020\rH\u0016J\b\u0010\u001c\u001a\u00020\u0017H\u0016J\b\u0010\u001d\u001a\u00020\rH\u0016J\b\u0010\u001e\u001a\u00020\rH\u0016R\u001a\u0010\u001f\u001a\u00020\u00178\u0016X\u0096D¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R$\u0010$\u001a\u0004\u0018\u00010#8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u0010+\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R$\u0010\n\u001a\u0004\u0018\u0001018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u00102\u001a\u0004\b\t\u00103\"\u0004\b\u000b\u00104R$\u00106\u001a\u0004\u0018\u0001058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R$\u0010=\u001a\u0004\u0018\u00010<8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR$\u0010D\u001a\u0004\u0018\u00010C8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR$\u0010K\u001a\u0004\u0018\u00010J8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\b\u0014\u0010M\"\u0004\bN\u0010OR$\u0010Q\u001a\u0004\u0018\u00010P8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR$\u0010X\u001a\u0004\u0018\u00010W8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R$\u0010_\u001a\u0004\u0018\u00010^8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\"\u0010e\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\be\u0010f\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR$\u0010l\u001a\u0004\u0018\u00010k8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bl\u0010m\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR*\u0010t\u001a\n\u0012\u0004\u0012\u00020s\u0018\u00010r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bt\u0010u\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR%\u0010{\u001a\u0004\u0018\u00010z8\u0006@\u0006X\u0086\u000e¢\u0006\u0013\n\u0004\b{\u0010|\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001R,\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0081\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0082\u0001\u0010\u0083\u0001\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001\"\u0006\b\u0086\u0001\u0010\u0087\u0001R,\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u0088\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0089\u0001\u0010\u008a\u0001\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001\"\u0006\b\u008d\u0001\u0010\u008e\u0001R,\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u008f\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0090\u0001\u0010\u0091\u0001\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001\"\u0006\b\u0094\u0001\u0010\u0095\u0001R)\u0010\u0096\u0001\u001a\u00020s8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0096\u0001\u0010\u0097\u0001\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001\"\u0006\b\u009a\u0001\u0010\u009b\u0001R)\u0010\u009c\u0001\u001a\u00020s8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u009c\u0001\u0010\u0097\u0001\u001a\u0006\b\u009d\u0001\u0010\u0099\u0001\"\u0006\b\u009e\u0001\u0010\u009b\u0001R)\u0010\u009f\u0001\u001a\u00020s8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u009f\u0001\u0010\u0097\u0001\u001a\u0006\b \u0001\u0010\u0099\u0001\"\u0006\b¡\u0001\u0010\u009b\u0001R\u001c\u0010¢\u0001\u001a\u00020s8\u0006¢\u0006\u0010\n\u0006\b¢\u0001\u0010\u0097\u0001\u001a\u0006\b£\u0001\u0010\u0099\u0001R\u0017\u0010¤\u0001\u001a\u00020s8\u0002X\u0083\u0004¢\u0006\b\n\u0006\b¤\u0001\u0010\u0097\u0001¨\u0006¦\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/vo/IntroPromotionVO;", "Lql/a;", "Luh2/a;", "Ljava/io/Serializable;", "", "getCover", "cover", "", "setCover", "getTitle", "title", d.f25925o, "tag", "", "containsIconTag", "Lcom/bytedance/android/ec/model/response/ECHotAtmosphere;", "hotAtmosphere", "updateHotAtmosphere", "getLabelNameLive", "isLottery", "getPrice", "isPreSale", "isCrossborderProduct", "", "getCampainExtraType", "()Ljava/lang/Integer;", "canShowAddCart", "isFlash", "getEcomGoodsStatus", "isAuction", "isAuctionV2", "introType", "I", "getIntroType", "()I", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/s0;", "control", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/s0;", "getControl", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/s0;", "setControl", "(Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/s0;)V", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/u;", "image", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/u;", "getImage", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/u;", "setImage", "(Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/u;)V", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/o0;", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/o0;", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/o0;", "(Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/o0;)V", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/g;", "benefits", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/g;", "getBenefits", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/g;", "setBenefits", "(Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/g;)V", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/l;", "carouselBenefits", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/l;", "getCarouselBenefits", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/l;", "setCarouselBenefits", "(Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/l;)V", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/e;", "introBackground", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/e;", "getIntroBackground", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/e;", "setIntroBackground", "(Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/e;)V", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroPrice;", "price", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroPrice;", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroPrice;", "setPrice", "(Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroPrice;)V", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/i;", "blank", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/i;", "getBlank", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/i;", "setBlank", "(Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/i;)V", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/k0;", "purchase", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/k0;", "getPurchase", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/k0;", "setPurchase", "(Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/k0;)V", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/y;", "openPriceAnimation", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/y;", "getOpenPriceAnimation", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/y;", "setOpenPriceAnimation", "(Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/y;)V", "shouldExtendSameCardDuration", "Z", "getShouldExtendSameCardDuration", "()Z", "setShouldExtendSameCardDuration", "(Z)V", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroAtmosphere;", "introAtmosphere", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroAtmosphere;", "getIntroAtmosphere", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroAtmosphere;", "setIntroAtmosphere", "(Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroAtmosphere;)V", "", "", "durations", "Ljava/util/List;", "getDurations", "()Ljava/util/List;", "setDurations", "(Ljava/util/List;)V", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/g0;", "secondFrame", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/g0;", "getSecondFrame", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/g0;", "setSecondFrame", "(Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/g0;)V", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroProduct;", "product", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroProduct;", "getProduct", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroProduct;", "setProduct", "(Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroProduct;)V", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/j0;", GXTemplateKey.GAIAX_TRACK, "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/j0;", "getTrack", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/j0;", "setTrack", "(Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/j0;)V", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/req/IntroCardScene;", "cardReqScene", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/req/IntroCardScene;", "getCardReqScene", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/req/IntroCardScene;", "setCardReqScene", "(Lcom/bytedance/android/livesdk/livecommerce/intro/model/req/IntroCardScene;)V", "exposureTime", "J", "getExposureTime", "()J", "setExposureTime", "(J)V", "showTimestamp", "getShowTimestamp", "setShowTimestamp", "auctionEndTime", "getAuctionEndTime", "setAuctionEndTime", "currentTime", "getCurrentTime", "currentTimeStamp", "<init>", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IntroPromotionVO extends a implements uh2.a, Serializable {
    private long auctionEndTime;
    private g benefits;
    private i blank;
    private IntroCardScene cardReqScene;
    private l carouselBenefits;
    private s0 control;
    private final long currentTime;

    @SerializedName("current_time_stamp")
    private final long currentTimeStamp;
    private List<Long> durations;
    private long exposureTime;
    private u image;
    private IntroAtmosphere introAtmosphere;
    private e introBackground;
    private final int introType;
    private y openPriceAnimation;
    private IntroPrice price;
    private IntroProduct product;
    private k0 purchase;
    private g0 secondFrame;
    private boolean shouldExtendSameCardDuration;
    private long showTimestamp;
    private o0 title;
    private j0 track;

    public IntroPromotionVO() {
        long r100 = 0;
        this(r100, 1, null);
    }

    @Override // ql.a
    public boolean canShowAddCart() {
        return false;
    }

    @Override // ql.a
    public String getCover() {
        u r100 = this.image;
        if (r100 == null) goto L5;
        String r101 = r100.c();
    L6:
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    @Override // ql.a
    public String getLabelNameLive() {
        HashSet r100 = new HashSet();
        Map<String, List<ECRitTag>> r101 = getRitTag();
        if (r101 == null) goto L12;
        List<ECRitTag> r102 = r101.get("live_room_good_list_user_right");
        if (r102 == null) goto L12;
        Iterator<ECRitTag> r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L12;
        ECRitTag r104 = r103.next();
        if (TextUtils.isEmpty(r104.getLabelName()) == true) goto L8;
        addTagToSet(r100, r104.getLabelName());
    L12:
        Map<String, List<ECRitTag>> r105 = getRitTag();
        if (r105 == null) goto L22;
        List<ECRitTag> r106 = r105.get("live_room_good_list_stimulate");
        if (r106 == null) goto L22;
        Iterator<ECRitTag> r107 = r106.iterator();
    L18:
        if (r107.hasNext() == false) goto L22;
        ECRitTag r108 = r107.next();
        if (TextUtils.isEmpty(r108.getLabelName()) == true) goto L18;
        addTagToSet(r100, r108.getLabelName());
    L22:
        Map<String, List<ECRitTag>> r109 = getRitTag();
        if (r109 == null) goto L33;
        List<ECRitTag> r110 = r109.get("live_room_product_title_before");
        if (r110 == null) goto L33;
        Iterator<ECRitTag> r111 = r110.iterator();
    L28:
        if (r111.hasNext() == false) goto L33;
        ECRitTag r112 = r111.next();
        if (TextUtils.isEmpty(r112.getLabelName()) == true) goto L28;
        addTagToSet(r100, r112.getLabelName());
    L33:
        if (TextUtils.isEmpty(getLiveLabelNameFromEventParams()) == true) goto L37;
        String r113 = getLiveLabelNameFromEventParams();
        if (r113 == null) goto L37;
        addTagToSet(r100, r113);
    L37:
        u r114 = this.image;
        if (r114 == null) goto L47;
        List<t> r115 = r114.d();
        if (r115 == null) goto L47;
        Iterator<T> r116 = r115.iterator();
    L43:
        if (r116.hasNext() == false) goto L47;
        String r117 = ((t) r116.next()).e();
        if (r117 == null) goto L43;
        r100.add(r117);
    L47:
        Map<String, String> r118 = getEventParams();
        if (r118 == null) goto L65;
        String r119 = r118.get(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME_LIVE);
        if (r119 == null) goto L65;
        List r120 = StringsKt.split$default(StringsKt.removeSurrounding(r119, "[", "]"), new String[]{","}, false, 0, 6, null);
        ArrayList r121 = new ArrayList();
        Iterator r122 = r120.iterator();
    L53:
        if (r122.hasNext() == false) goto L60;
        Object r123 = r122.next();
        if (((String) r123).length() <= 0) goto L57;
        boolean r124 = true;
    L58:
        if (r124 == false) goto L53;
        r121.add(r123);
        goto L53
    L57:
        r124 = false;
        goto L58
    L60:
        Iterator r125 = r121.iterator();
    L62:
        if (r125.hasNext() == false) goto L65;
        r100.add((String) r125.next());
    L65:
        return tagSetToString(r100);
    }

    @Override // ql.a
    /* JADX INFO: renamed from: getPrice */
    public String mo8153getPrice() {
        IntroPrice r100 = this.price;
        if (r100 == null) goto L9;
        m0 r101 = r100.c();
        if (r101 == null) goto L9;
        w r102 = r101.b();
        if (r102 == null) goto L9;
        Long r103 = Long.valueOf(r102.b());
    L11:
        return String.valueOf(r103);
    L9:
        r103 = null;
        goto L11
    }

    @Override // ql.a
    /* JADX INFO: renamed from: getTitle */
    public String mo8154getTitle() {
        o0 r100 = this.title;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.b();
    }

    @Override // ql.a
    public boolean isAuction() {
        IntroProduct r100 = this.product;
        if (r100 != null) goto L5;
    L6:
        IntroProduct r101 = this.product;
        if (r101 != null) goto L9;
    L11:
        return false;
    L9:
        if (r101.e() != 2) goto L11;
        return true;
    L5:
        if (r100.e() != 1) goto L6;
        return true;
    }

    @Override // ql.a
    public boolean isAuctionV2() {
        IntroProduct r100 = this.product;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.e() != 1) goto L7;
        return true;
    }

    @Override // ql.a
    public boolean isLottery() {
        j0 r100 = this.track;
        if (r100 == null) goto L5;
        TrackEventType r101 = r100.b();
    L7:
        if (r101 != TrackEventType.UnRecProduct) goto L9;
        return true;
    L9:
        return false;
    L5:
        r101 = null;
        goto L7
    }

    @Override // ql.a
    public Integer getCampainExtraType() {
        Map<String, String> r100 = getEventParams();
        if (r100 == null) goto L7;
        String r101 = r100.get(com.bytedance.android.ec.core.event.a.KEY_CAMPAIGN_EXTRA_TYPE);
        if (r101 == null) goto L7;
        return Integer.valueOf(CastIntegerProtector.parseInt(r101));
    L7:
        return null;
    }

    @Override // ql.a
    public int getEcomGoodsStatus() {
        Map<String, String> r100 = getEventParams();
        if (r100 == null) goto L7;
        String r101 = r100.get("ecom_goods_status");
        if (r101 == null) goto L7;
        return CastIntegerProtector.parseInt(r101);
    L7:
        return 0;
    }

    @Override // ql.a
    public boolean isCrossborderProduct() {
        Map<String, String> r100 = getEventParams();
        if (r100 == null) goto L5;
        String r101 = r100.get(com.bytedance.android.ec.core.event.a.KEY_CROSSBORDER_GOODS);
    L7:
        return Intrinsics.areEqual(r101, "1");
    L5:
        r101 = null;
        goto L7
    }

    @Override // ql.a
    public boolean isFlash() {
        Map<String, String> r100 = getEventParams();
        if (r100 == null) goto L5;
        String r101 = r100.get("live_product_type");
    L6:
        if (r101 == null) goto L8;
        return true;
    L8:
        return false;
    L5:
        r101 = null;
        goto L6
    }

    @Override // ql.a
    public boolean isPreSale() {
        Map<String, String> r100 = getEventParams();
        if (r100 == null) goto L5;
        String r101 = r100.get(com.bytedance.android.ec.core.event.a.KEY_UPFRONT_PRESELL);
    L7:
        return Intrinsics.areEqual(r101, "1");
    L5:
        r101 = null;
        goto L7
    }

    public final long getAuctionEndTime() {
        return this.auctionEndTime;
    }

    public final g getBenefits() {
        return this.benefits;
    }

    public final i getBlank() {
        return this.blank;
    }

    public final IntroCardScene getCardReqScene() {
        return this.cardReqScene;
    }

    public final l getCarouselBenefits() {
        return this.carouselBenefits;
    }

    @Override // uh2.a
    public s0 getControl() {
        return this.control;
    }

    public final long getCurrentTime() {
        return this.currentTime;
    }

    public final List<Long> getDurations() {
        return this.durations;
    }

    public final long getExposureTime() {
        return this.exposureTime;
    }

    public final u getImage() {
        return this.image;
    }

    public final IntroAtmosphere getIntroAtmosphere() {
        return this.introAtmosphere;
    }

    public final e getIntroBackground() {
        return this.introBackground;
    }

    @Override // uh2.a
    public int getIntroType() {
        return this.introType;
    }

    public final y getOpenPriceAnimation() {
        return this.openPriceAnimation;
    }

    public final IntroProduct getProduct() {
        return this.product;
    }

    public final k0 getPurchase() {
        return this.purchase;
    }

    public final g0 getSecondFrame() {
        return this.secondFrame;
    }

    public final boolean getShouldExtendSameCardDuration() {
        return this.shouldExtendSameCardDuration;
    }

    public final long getShowTimestamp() {
        return this.showTimestamp;
    }

    public final j0 getTrack() {
        return this.track;
    }

    public final IntroPrice getPrice() {
        return this.price;
    }

    public final o0 getTitle() {
        return this.title;
    }

    public IntroPromotionVO(long r100) {
        this.currentTimeStamp = r100;
        this.introType = 1;
        this.currentTime = r100;
    }

    @Override // ql.a
    public boolean containsIconTag(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        u r101 = this.image;
        if (r101 == null) goto L21;
        List<t> r102 = r101.d();
        if (r102 == null) goto L22;
        List<t> r103 = r102;
        if ((r103 instanceof Collection) == true) goto L9;
    L11:
        Iterator<T> r104 = r103.iterator();
    L13:
        if (r104.hasNext() == false) goto L24;
        if (Intrinsics.areEqual(((t) r104.next()).e(), r100) == false) goto L13;
        return true;
    L24:
        return false;
    L9:
        if (r103.isEmpty() == false) goto L11;
        return false;
    L22:
        return false;
    L21:
        return false;
    }

    public final void setAuctionEndTime(long r100) {
        this.auctionEndTime = r100;
    }

    public final void setBenefits(g r100) {
        this.benefits = r100;
    }

    public final void setBlank(i r100) {
        this.blank = r100;
    }

    public final void setCardReqScene(IntroCardScene r100) {
        this.cardReqScene = r100;
    }

    public final void setCarouselBenefits(l r100) {
        this.carouselBenefits = r100;
    }

    public void setControl(s0 r100) {
        this.control = r100;
    }

    @Override // ql.a
    public void setCover(String r100) {
        Intrinsics.checkNotNullParameter(r100, "cover");
        u r101 = this.image;
        if (r101 == null) goto L6;
        r101.f(r100);
        return;
    }

    public final void setDurations(List<Long> r100) {
        this.durations = r100;
    }

    public final void setExposureTime(long r100) {
        this.exposureTime = r100;
    }

    public final void setImage(u r100) {
        this.image = r100;
    }

    public final void setIntroAtmosphere(IntroAtmosphere r100) {
        this.introAtmosphere = r100;
    }

    public final void setIntroBackground(e r100) {
        this.introBackground = r100;
    }

    public final void setOpenPriceAnimation(y r100) {
        this.openPriceAnimation = r100;
    }

    public final void setPrice(IntroPrice r100) {
        this.price = r100;
    }

    public final void setProduct(IntroProduct r100) {
        this.product = r100;
    }

    public final void setPurchase(k0 r100) {
        this.purchase = r100;
    }

    public final void setSecondFrame(g0 r100) {
        this.secondFrame = r100;
    }

    public final void setShouldExtendSameCardDuration(boolean r100) {
        this.shouldExtendSameCardDuration = r100;
    }

    public final void setShowTimestamp(long r100) {
        this.showTimestamp = r100;
    }

    @Override // ql.a
    public void setTitle(String r100) {
        o0 r101 = this.title;
        if (r101 == null) goto L6;
        r101.d(r100);
        return;
    }

    public final void setTrack(j0 r100) {
        this.track = r100;
    }

    @Override // ql.a
    public void updateHotAtmosphere(ECHotAtmosphere r100) {
        setHotAtmosphere(r100);
    }

    public final void setTitle(o0 r100) {
        this.title = r100;
    }

    public /* synthetic */ IntroPromotionVO(long r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = System.currentTimeMillis();
    L5:
        this(r100);
    }
}
