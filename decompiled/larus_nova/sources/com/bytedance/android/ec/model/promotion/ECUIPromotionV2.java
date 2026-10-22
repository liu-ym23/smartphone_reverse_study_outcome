package com.bytedance.android.ec.model.promotion;

import android.text.TextUtils;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.alipay.sdk.m.x.d;
import com.bytedance.android.ec.model.response.ECCarouselData;
import com.bytedance.android.ec.model.response.ECHotAtmosphere;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.ec.model.response.Product;
import com.bytedance.android.ec.model.response.TrackEventType;
import com.bytedance.android.ec.model.response.b0;
import com.bytedance.android.ec.model.response.c1;
import com.bytedance.android.ec.model.response.d1;
import com.bytedance.android.ec.model.response.g1;
import com.bytedance.android.ec.model.response.h1;
import com.bytedance.android.ec.model.response.i0;
import com.bytedance.android.ec.model.response.j1;
import com.bytedance.android.ec.model.response.k1;
import com.bytedance.android.ec.model.response.l1;
import com.bytedance.android.ec.model.response.p0;
import com.bytedance.android.ec.model.response.q0;
import com.bytedance.android.ec.model.response.v;
import com.bytedance.android.ec.model.response.v0;
import com.bytedance.android.ec.model.response.y0;
import com.bytedance.android.ec.model.response.z;
import com.bytedance.android.ec.model.response.z0;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ql.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010W\u001a\u00020V¢\u0006\u0004\bf\u0010^J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0001H\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0012\u0010\u0014\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0016J\b\u0010\u0016\u001a\u00020\u0010H\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0016J\b\u0010\u0019\u001a\u00020\u0010H\u0016J\u0011\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u001d\u001a\u00020\u0010H\u0016J\b\u0010\u001e\u001a\u00020\u0010H\u0016J\b\u0010\u001f\u001a\u00020\u001aH\u0016J\b\u0010 \u001a\u00020\u0010H\u0016J\b\u0010!\u001a\u00020\u0010H\u0016R$\u0010#\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u0010\u000b\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010*\u001a\u0004\b\n\u0010+\"\u0004\b\f\u0010,R$\u0010.\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R$\u00105\u001a\u0004\u0018\u0001048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b\u0017\u00107\"\u0004\b8\u00109R$\u0010;\u001a\u0004\u0018\u00010:8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R$\u0010B\u001a\u0004\u0018\u00010A8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR$\u0010I\u001a\u0004\u0018\u00010H8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR$\u0010P\u001a\u0004\u0018\u00010O8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u0017\u0010W\u001a\u00020V8\u0006¢\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bY\u0010ZR\"\u0010[\u001a\u00020V8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b[\u0010X\u001a\u0004\b\\\u0010Z\"\u0004\b]\u0010^R$\u0010`\u001a\u0004\u0018\u00010_8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010e¨\u0006g"}, d2 = {"Lcom/bytedance/android/ec/model/promotion/ECUIPromotionV2;", "Lql/a;", "Ljava/io/Serializable;", "Lcom/bytedance/android/ec/model/response/v;", "getStepperInfo", "", "getCover", "cover", "", "setCover", "getTitle", "title", d.f25925o, "promotion", "copyIconDataFromPromotion", "tag", "", "containsIconTag", "Lcom/bytedance/android/ec/model/response/ECHotAtmosphere;", "hotAtmosphere", "updateHotAtmosphere", "getLabelNameLive", "isLottery", "getPrice", "isPreSale", "isCrossborderProduct", "", "getCampainExtraType", "()Ljava/lang/Integer;", "canShowAddCart", "isFlash", "getEcomGoodsStatus", "isAuction", "isAuctionV2", "Lcom/bytedance/android/ec/model/response/z0;", "image", "Lcom/bytedance/android/ec/model/response/z0;", "getImage", "()Lcom/bytedance/android/ec/model/response/z0;", "setImage", "(Lcom/bytedance/android/ec/model/response/z0;)V", "Lcom/bytedance/android/ec/model/response/j1;", "Lcom/bytedance/android/ec/model/response/j1;", "()Lcom/bytedance/android/ec/model/response/j1;", "(Lcom/bytedance/android/ec/model/response/j1;)V", "Lcom/bytedance/android/ec/model/response/q0;", "benefits", "Lcom/bytedance/android/ec/model/response/q0;", "getBenefits", "()Lcom/bytedance/android/ec/model/response/q0;", "setBenefits", "(Lcom/bytedance/android/ec/model/response/q0;)V", "Lcom/bytedance/android/ec/model/response/d1;", "price", "Lcom/bytedance/android/ec/model/response/d1;", "()Lcom/bytedance/android/ec/model/response/d1;", "setPrice", "(Lcom/bytedance/android/ec/model/response/d1;)V", "Lcom/bytedance/android/ec/model/response/g1;", "purchase", "Lcom/bytedance/android/ec/model/response/g1;", "getPurchase", "()Lcom/bytedance/android/ec/model/response/g1;", "setPurchase", "(Lcom/bytedance/android/ec/model/response/g1;)V", "Lcom/bytedance/android/ec/model/response/d;", "blank", "Lcom/bytedance/android/ec/model/response/d;", "getBlank", "()Lcom/bytedance/android/ec/model/response/d;", "setBlank", "(Lcom/bytedance/android/ec/model/response/d;)V", "Lcom/bytedance/android/ec/model/response/v0;", GXTemplateKey.GAIAX_EXTEND, "Lcom/bytedance/android/ec/model/response/v0;", "getExtend", "()Lcom/bytedance/android/ec/model/response/v0;", "setExtend", "(Lcom/bytedance/android/ec/model/response/v0;)V", "Lcom/bytedance/android/ec/model/response/Product;", "product", "Lcom/bytedance/android/ec/model/response/Product;", "getProduct", "()Lcom/bytedance/android/ec/model/response/Product;", "setProduct", "(Lcom/bytedance/android/ec/model/response/Product;)V", "", "currentTime", "J", "getCurrentTime", "()J", "auctionV2EndTime", "getAuctionV2EndTime", "setAuctionV2EndTime", "(J)V", "Lcom/bytedance/android/ec/model/response/k1;", GXTemplateKey.GAIAX_TRACK, "Lcom/bytedance/android/ec/model/response/k1;", "getTrack", "()Lcom/bytedance/android/ec/model/response/k1;", "setTrack", "(Lcom/bytedance/android/ec/model/response/k1;)V", "<init>", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ECUIPromotionV2 extends a implements Serializable {
    private long auctionV2EndTime;
    private q0 benefits;
    private com.bytedance.android.ec.model.response.d blank;
    private final long currentTime;
    private v0 extend;
    private z0 image;
    private d1 price;
    private Product product;
    private g1 purchase;
    private j1 title;
    private k1 track;

    @Override // ql.a
    public boolean isAuctionV2() {
        return false;
    }

    @Override // ql.a
    public boolean canShowAddCart() {
        g1 r100 = this.purchase;
        if (r100 == null) goto L5;
        l1 r101 = r100.a();
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
    public String getCover() {
        z0 r100 = this.image;
        if (r100 == null) goto L5;
        String r101 = r100.d();
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
        if (getHasFlagShopTag() == false) goto L35;
        addTagToSet(r100, "flagship_shop");
    L35:
        List<String> r113 = getPromotionListHeaderLabelNames();
        if (r113 == null) goto L44;
        Iterator<String> r114 = r113.iterator();
    L39:
        if (r114.hasNext() == false) goto L44;
        String r115 = r114.next();
        if (TextUtils.isEmpty(r115) == true) goto L39;
        addTagToSet(r100, r115);
    L44:
        if (TextUtils.isEmpty(getLiveLabelNameFromEventParams()) == true) goto L48;
        String r116 = getLiveLabelNameFromEventParams();
        if (r116 == null) goto L48;
        addTagToSet(r100, r116);
    L48:
        z0 r117 = this.image;
        if (r117 == null) goto L58;
        List<y0> r118 = r117.g();
        if (r118 == null) goto L58;
        Iterator<T> r119 = r118.iterator();
    L54:
        if (r119.hasNext() == false) goto L58;
        String r120 = ((y0) r119.next()).d();
        if (r120 == null) goto L54;
        r100.add(r120);
    L58:
        q0 r121 = this.benefits;
        if (r121 == null) goto L84;
        List<i0> r122 = r121.a();
        if (r122 == null) goto L84;
        Iterator<T> r123 = r122.iterator();
    L64:
        if (r123.hasNext() == false) goto L84;
        List<p0> r124 = ((i0) r123.next()).a();
        if (r124 == null) goto L64;
        Iterator<T> r125 = r124.iterator();
    L69:
        if (r125.hasNext() == false) goto L64;
        b0 r126 = ((p0) r125.next()).d();
        if (r126 == null) goto L69;
        z r127 = r126.a();
        if (r127 == null) goto L69;
        List<ECCarouselData> r128 = r127.b();
        if (r128 == null) goto L69;
        Iterator<T> r129 = r128.iterator();
    L78:
        if (r129.hasNext() == false) goto L69;
        Map<String, String> r130 = ((ECCarouselData) r129.next()).getEventParam();
        if (r130 == null) goto L78;
        String r131 = r130.get(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME_LIVE);
        if (r131 == null) goto L78;
        r100.add(r131);
    L84:
        Map<String, String> r132 = getEventParams();
        if (r132 == null) goto L102;
        String r133 = r132.get(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME_LIVE);
        if (r133 == null) goto L102;
        List r134 = StringsKt.split$default(StringsKt.removeSurrounding(r133, "[", "]"), new String[]{","}, false, 0, 6, null);
        ArrayList r135 = new ArrayList();
        Iterator r136 = r134.iterator();
    L90:
        if (r136.hasNext() == false) goto L97;
        Object r137 = r136.next();
        if (((String) r137).length() <= 0) goto L94;
        boolean r138 = true;
    L95:
        if (r138 == false) goto L90;
        r135.add(r137);
        goto L90
    L94:
        r138 = false;
        goto L95
    L97:
        Iterator r139 = r135.iterator();
    L99:
        if (r139.hasNext() == false) goto L102;
        r100.add((String) r139.next());
    L102:
        return tagSetToString(r100);
    }

    @Override // ql.a
    /* JADX INFO: renamed from: getPrice, reason: collision with other method in class */
    public String mo8153getPrice() {
        d1 r100 = this.price;
        if (r100 == null) goto L9;
        h1 r101 = r100.c();
        if (r101 == null) goto L9;
        c1 r102 = r101.b();
        if (r102 == null) goto L9;
        Long r103 = Long.valueOf(r102.b());
    L11:
        return String.valueOf(r103);
    L9:
        r103 = null;
        goto L11
    }

    @Override // ql.a
    public v getStepperInfo() {
        g1 r100 = this.purchase;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.c();
    }

    @Override // ql.a
    /* JADX INFO: renamed from: getTitle, reason: collision with other method in class */
    public String mo8154getTitle() {
        j1 r100 = this.title;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.b();
    }

    @Override // ql.a
    public boolean isAuction() {
        Product r100 = this.product;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isAuction() != true) goto L7;
        return true;
    }

    @Override // ql.a
    public boolean isLottery() {
        k1 r100 = this.track;
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

    public final long getAuctionV2EndTime() {
        return this.auctionV2EndTime;
    }

    public final q0 getBenefits() {
        return this.benefits;
    }

    public final com.bytedance.android.ec.model.response.d getBlank() {
        return this.blank;
    }

    public final long getCurrentTime() {
        return this.currentTime;
    }

    public final v0 getExtend() {
        return this.extend;
    }

    public final z0 getImage() {
        return this.image;
    }

    public final Product getProduct() {
        return this.product;
    }

    public final g1 getPurchase() {
        return this.purchase;
    }

    public final k1 getTrack() {
        return this.track;
    }

    public final d1 getPrice() {
        return this.price;
    }

    public final j1 getTitle() {
        return this.title;
    }

    public ECUIPromotionV2(long r100) {
        this.currentTime = r100;
    }

    @Override // ql.a
    public boolean containsIconTag(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        z0 r101 = this.image;
        if (r101 == null) goto L21;
        List<y0> r102 = r101.g();
        if (r102 == null) goto L22;
        List<y0> r103 = r102;
        if ((r103 instanceof Collection) == true) goto L9;
    L11:
        Iterator<T> r104 = r103.iterator();
    L13:
        if (r104.hasNext() == false) goto L24;
        if (Intrinsics.areEqual(((y0) r104.next()).d(), r100) == false) goto L13;
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

    @Override // ql.a
    public void copyIconDataFromPromotion(a r100) {
        Intrinsics.checkNotNullParameter(r100, "promotion");
        if (isRelatedInfo() == true) goto L5;
        return;
    L5:
        if ((r100 instanceof ECUIPromotionV2) == true) goto L7;
        r100 = null;
    L7:
        ECUIPromotionV2 r101 = (ECUIPromotionV2) r100;
        if (r101 == null) goto L18;
        z0 r102 = r101.image;
        if (r102 == null) goto L19;
        List<y0> r103 = r102.g();
        if (r103 == null) goto L20;
        z0 r104 = this.image;
        if (r104 == null) goto L21;
        r104.m(r103);
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    }

    public final void setAuctionV2EndTime(long r100) {
        this.auctionV2EndTime = r100;
    }

    public final void setBenefits(q0 r100) {
        this.benefits = r100;
    }

    public final void setBlank(com.bytedance.android.ec.model.response.d r100) {
        this.blank = r100;
    }

    @Override // ql.a
    public void setCover(String r100) {
        Intrinsics.checkNotNullParameter(r100, "cover");
        z0 r101 = this.image;
        if (r101 == null) goto L6;
        r101.k(r100);
        return;
    }

    public final void setExtend(v0 r100) {
        this.extend = r100;
    }

    public final void setImage(z0 r100) {
        this.image = r100;
    }

    public final void setPrice(d1 r100) {
        this.price = r100;
    }

    public final void setProduct(Product r100) {
        this.product = r100;
    }

    public final void setPurchase(g1 r100) {
        this.purchase = r100;
    }

    @Override // ql.a
    public void setTitle(String r100) {
        j1 r101 = this.title;
        if (r101 == null) goto L6;
        r101.d(r100);
        return;
    }

    public final void setTrack(k1 r100) {
        this.track = r100;
    }

    @Override // ql.a
    public void updateHotAtmosphere(ECHotAtmosphere r100) {
        z0 r101 = this.image;
        if (r101 == null) goto L6;
        r101.l(r100);
        return;
    }

    public final void setTitle(j1 r100) {
        this.title = r100;
    }
}
