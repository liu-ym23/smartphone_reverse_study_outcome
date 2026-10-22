package com.bytedance.android.shopping.searchsimilar.view;

import android.content.Context;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.core.utils.j1;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.core.widget.ECCouponView;
import com.bytedance.android.ec.core.widget.RoundedLinearLayout;
import com.bytedance.android.ec.core.widget.price.PriceView;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.PromotionDepositPrice;
import com.bytedance.android.ec.model.response.anchorv3.PromotionDiscountLabel;
import com.bytedance.android.ec.model.response.anchorv3.PromotionMarketFloor;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductActivitiesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductExtraStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPriceStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.ec.sdk.helper.p;
import com.bytedance.android.shopping.anchorv3.activities.vo.ActivityVO;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.searchsimilar.adapter.SimilarProductCardAdapter;
import com.bytedance.android.shopping.searchsimilar.model.DislikeType;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.searchsimilar.viewmodel.SimilarProductVM;
import com.bytedance.android.shopping.widget.legacy.SquareImageView;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import d63.j;
import gh3.g;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0012B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0002¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/shopping/searchsimilar/view/SimilarProductCardView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/ec/model/ECUrlModel;", "image", "", "setImage", "", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionDiscountLabel;", "coupons", "setCoupons", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "c", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SimilarProductCardView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f182519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SquareImageView f182520b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f182521c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinearLayout f182522d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ECCouponView f182523e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ECCouponView f182524f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final PriceView f182525g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final SimilarProductFeedbackView f182526h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TextView f182527i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final RoundedLinearLayout f182528j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final PriceView f182529k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public rd3.a f182530l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Integer f182531m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public SimilarProductVM f182532n;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SimilarProductCardView f182533a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f182534b;

        public a(SimilarProductCardView r100, Context r101) {
            this.f182533a = r100;
            this.f182534b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r110) {
            SimilarProductCardView r111 = this.f182533a;
            SimilarProductFeedbackView r100 = r111.f182526h;
            if (r100 == null) goto L5;
            r100.a(r111);
        L5:
            SimilarProductFeedbackView r112 = this.f182533a.f182526h;
            if (r112 != null) goto L8;
        L13:
            int r113 = g.f481273a;
            Context r114 = this.f182534b;
            Integer r101 = this.f182533a.f182531m;
            String r102 = null;
            if (r101 == null) goto L16;
            String r103 = String.valueOf(r101.intValue() + 1);
        L17:
            SimilarProductCardView r104 = this.f182533a;
            g.a(r114, com.bytedance.android.ec.core.event.a.KEY_CLICK_PRODUCT, r103, r104.f182532n, r104.f182530l);
            int r115 = com.bytedance.android.shopping.searchsimilar.utils.g.f182500a;
            SimilarProductCardView r116 = this.f182533a;
            rd3.a r105 = r116.f182530l;
            SimilarProductVM r117 = r116.f182532n;
            if (r117 == null) goto L60;
            if (r105 == null) goto L60;
            Promotion r106 = r105.f();
            if (r106 == null) goto L60;
            String r107 = r106.getLink();
            if (r107 == null) goto L60;
            Uri r108 = UriProtector.parse(r107);
            JSONObject r109 = k.w(UriProtector.getQueryParameter(r108, "meta_params"));
            if (r109 != null) goto L28;
            r109 = new JSONObject();
        L28:
            JSONObject r118 = k.w(r109.optString(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO));
            if (r118 != null) goto L31;
            r118 = new JSONObject();
        L31:
            SimilarProductParam r119 = r117.getSimilarProductParam();
            if (r119 == null) goto L34;
            String r120 = r119.getEnterFrom();
        L35:
            r118.put(com.bytedance.android.ec.core.event.a.KEY_CARRIER_SOURCE, r120);
            r118.put(com.bytedance.android.ec.core.event.a.KEY_SOURCE_METHOD, "similar_product_homepage");
            r118.put(com.bytedance.android.ec.core.event.a.KEY_ECOM_GROUP_TYPE, "product_card");
            r118.put(com.bytedance.android.ec.core.event.a.KEY_KEY_ID, r117.getProductFrameId());
            r118.put(com.bytedance.android.ec.core.event.a.KEY_KEY_RANK, r117.getFrameRank());
            Promotion r121 = r105.f();
            if (r121 == null) goto L42;
            PromotionProductStruct r122 = r121.getPromotionInfo();
            if (r122 == null) goto L42;
            PromotionProductExtraStruct r123 = r122.getExtraInfo();
            if (r123 == null) goto L42;
            String r124 = r123.getSimilarProductType();
        L43:
            r118.put(com.bytedance.android.ec.core.event.a.KEY_SIMILAR_TYPE, r124);
            r109.put(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, r118.toString());
            Set<String> r125 = j1.b(r108);
            Uri.Builder r126 = r108.buildUpon().clearQuery();
            if (r125 == null) goto L52;
            Iterator<T> r127 = r125.iterator();
        L47:
            if (r127.hasNext() == false) goto L52;
            String r128 = (String) r127.next();
            if (StringsKt.equals$default(r128, "meta_params", false, 2, null) == false) goto L50;
            r126.appendQueryParameter("meta_params", r109.toString());
            goto L47
        L50:
            r126.appendQueryParameter(r128, UriProtector.getQueryParameter(r108, r128));
        L52:
            SimilarProductParam r129 = r117.getSimilarProductParam();
            if (r129 == null) goto L55;
            String r130 = r129.getAwemeId();
        L56:
            Uri.Builder r131 = r126.appendQueryParameter("item_id", r130);
            SimilarProductParam r132 = r117.getSimilarProductParam();
            if (r132 == null) goto L59;
            r102 = r132.getAuthorId();
        L59:
            r102 = r131.appendQueryParameter(com.bytedance.android.ec.core.event.a.KEY_KOL_ID, r102).build().toString();
            goto L60
        L55:
            r130 = null;
        L42:
            r124 = null;
            goto L43
        L34:
            r120 = null;
        L60:
            p.f48130a.openSchema(this.f182534b, r102);
            return;
        L16:
            r103 = null;
            goto L17
        L8:
            if (r112.getVisibility() != 0) goto L13;
            SimilarProductCardView r133 = this.f182533a;
            SimilarProductFeedbackView r134 = r133.f182526h;
            if (r134 == null) goto L68;
            r134.b(false, r133);
            return;
        }
    }

    public static final class b implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SimilarProductCardView f182535a;

        public b(SimilarProductCardView r100) {
            this.f182535a = r100;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r100) {
            SimilarProductCardView r101 = this.f182535a;
            SimilarProductFeedbackView r102 = r101.f182526h;
            if (r102 == null) goto L5;
            r102.b(true, r101);
        L5:
            return true;
        }
    }

    public static final class c {
    }

    static {
    }

    public SimilarProductCardView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SimilarProductCardView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final void setCoupons(List<PromotionDiscountLabel> r110) {
        if (r110 == null) goto L4;
        PromotionDiscountLabel r100 = (PromotionDiscountLabel) CollectionsKt.firstOrNull(r110);
    L6:
        if (r100 == null) goto L43;
        LinearLayout r101 = this.f182522d;
        if (r101 == null) goto L10;
        r101.setVisibility(0);
    L10:
        ECCouponView r102 = this.f182523e;
        if (r102 == null) goto L13;
        r102.setVisibility(0);
    L13:
        ECCouponView r103 = this.f182523e;
        if (r103 == null) goto L16;
        ECCouponView.a(r103, r100.getTag(), r100.getTagHeader(), true, null, 24);
    L16:
        ECCouponView r104 = this.f182523e;
        if (r104 == null) goto L24;
        TextView r105 = r104.f45912b;
        if (r105 == null) goto L21;
        r105.setTextSize(1, 10.0f);
    L21:
        TextView r106 = r104.f45911a;
        if (r106 == null) goto L24;
        r106.setTextSize(1, 10.0f);
    L24:
        PromotionDiscountLabel r111 = (PromotionDiscountLabel) CollectionsKt.getOrNull(r110, 1);
        if (r111 == null) goto L40;
        ECCouponView r107 = this.f182524f;
        if (r107 == null) goto L29;
        r107.setVisibility(0);
    L29:
        ECCouponView r108 = this.f182524f;
        if (r108 == null) goto L32;
        ECCouponView.a(r108, r111.getTag(), r111.getTagHeader(), true, null, 24);
    L32:
        ECCouponView r112 = this.f182524f;
        if (r112 == null) goto L50;
        TextView r109 = r112.f45912b;
        if (r109 == null) goto L37;
        r109.setTextSize(1, 10.0f);
    L37:
        TextView r113 = r112.f45911a;
        if (r113 == null) goto L51;
        r113.setTextSize(1, 10.0f);
        return;
    L51:
        return;
    L50:
        return;
    L40:
        ECCouponView r114 = this.f182524f;
        if (r114 == null) goto L53;
        r114.setVisibility(8);
        return;
    L53:
        return;
    L43:
        ECCouponView r115 = this.f182523e;
        if (r115 == null) goto L46;
        r115.setVisibility(8);
    L46:
        LinearLayout r116 = this.f182522d;
        if (r116 == null) goto L55;
        r116.setVisibility(8);
        return;
    L55:
        return;
    L4:
        r100 = null;
        goto L6
    }

    private final void setImage(ECUrlModel r100) {
        if (r100 == null) goto L7;
        List<String> r101 = r100.getUrlList();
        if (r101 == null) goto L7;
        String r102 = (String) CollectionsKt.firstOrNull(r101);
    L9:
        if (k.c(r102) == false) goto L18;
        SquareImageView r103 = this.f182520b;
        int r104 = -1;
        if (r100 == null) goto L13;
        int r105 = r100.getWidth();
    L14:
        if (r100 == null) goto L16;
        r104 = r100.getHeight();
    L16:
        y.c(r103, r100, r105, r104, null);
        return;
    L13:
        r105 = -1;
        goto L14
    L18:
        return;
    L7:
        r102 = null;
        goto L9
    }

    public SimilarProductCardView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.ec_commerce_similar_product_card_layout, this, true);
        FrameLayout r103 = (FrameLayout) findViewById(R.id.ec_similar_product_card_rootView);
        this.f182519a = r103;
        this.f182520b = (SquareImageView) findViewById(R.id.ec_similar_product_card_image);
        this.f182521c = (TextView) findViewById(R.id.ec_similar_product_card_title);
        this.f182522d = (LinearLayout) findViewById(R.id.ec_similar_product_card_coupons_container);
        this.f182523e = (ECCouponView) findViewById(R.id.ec_similar_product_card_first_coupon);
        this.f182524f = (ECCouponView) findViewById(R.id.ec_similar_product_card_second_coupon);
        this.f182525g = (PriceView) findViewById(R.id.ec_similar_product_card_price);
        this.f182526h = (SimilarProductFeedbackView) findViewById(R.id.ec_similar_product_card_feedback_view);
        this.f182527i = (TextView) findViewById(R.id.ec_similar_product_card_sales);
        this.f182528j = (RoundedLinearLayout) findViewById(R.id.ec_similar_product_card_deposit_presale_price_container);
        this.f182529k = (PriceView) findViewById(R.id.ec_similar_product_card_deposit_presale_price);
        if (r103 == null) goto L5;
        r103.setOnClickListener(new a(this, r100));
    L5:
        if (r103 == null) goto L8;
        r103.setOnLongClickListener(new b(this));
        return;
    }

    public /* synthetic */ SimilarProductCardView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void a(rd3.a r110, SimilarProductVM r210, Integer r211, RecyclerView r212, SimilarProductCardAdapter r213, Function0<Unit> r214) {
        Intrinsics.checkNotNullParameter(r210, "vm");
        Intrinsics.checkNotNullParameter(r213, "adapter");
        this.f182530l = r110;
        this.f182531m = r211;
        this.f182532n = r210;
        ViewGroup r111 = null;
        if (r110 == null) goto L13;
        Promotion r100 = r110.f();
        if (r100 == null) goto L13;
        PromotionProductStruct r101 = r100.getPromotionInfo();
        if (r101 == null) goto L13;
        PromotionProductBaseStruct r102 = r101.getBaseInfo();
        if (r102 == null) goto L13;
        List<ECUrlModel> r103 = r102.getImages();
        if (r103 == null) goto L13;
        ECUrlModel r104 = (ECUrlModel) CollectionsKt.firstOrNull(r103);
    L14:
        setImage(r104);
        if (r110 == null) goto L23;
        Promotion r105 = r110.f();
        if (r105 == null) goto L23;
        PromotionProductStruct r106 = r105.getPromotionInfo();
        if (r106 == null) goto L23;
        PromotionProductBaseStruct r107 = r106.getBaseInfo();
        if (r107 == null) goto L23;
        String r108 = r107.getTitle();
    L24:
        if (r110 == null) goto L36;
        Promotion r109 = r110.f();
        if (r109 == null) goto L36;
        PromotionProductStruct r112 = r109.getPromotionInfo();
        if (r112 == null) goto L36;
        PromotionProductPrivilegesStruct r113 = r112.getPrivilegeInfo();
        if (r113 == null) goto L36;
        PromotionProductActivitiesStruct r114 = r113.getActivities();
        if (r114 == null) goto L36;
        PromotionMarketFloor r115 = r114.getPlatformTextActivity();
        if (r115 == null) goto L36;
        ECUrlModel r116 = r115.getIcon();
    L37:
        if (r116 == null) goto L41;
        List<String> r117 = r116.getUrlList();
        if (r117 == null) goto L41;
        String r118 = (String) CollectionsKt.firstOrNull(r117);
    L43:
        if (k.c(r118) == false) goto L45;
        y.l(r116, 0, 0, new com.bytedance.android.shopping.searchsimilar.view.b(this, new SpannableStringBuilder(), r108));
    L48:
        if (r110 == null) goto L54;
        Promotion r119 = r110.f();
        if (r119 == null) goto L54;
        PromotionProductStruct r120 = r119.getPromotionInfo();
        if (r120 == null) goto L54;
        final ActivityVO r121 = f53.a.c(r120);
    L55:
        if (r110 == null) goto L61;
        Promotion r122 = r110.f();
        if (r122 == null) goto L61;
        PromotionProductStruct r123 = r122.getPromotionInfo();
        if (r123 == null) goto L61;
        final j r124 = d63.k.a(r123);
    L62:
        if (r124 == null) goto L70;
        if (r121 == null) goto L70;
        PriceView r125 = this.f182525g;
        if (r125 == null) goto L67;
        r125.C(new SimilarProductCardView$updatePrefixText$1(this, r121, r124));
    L67:
        PriceView r126 = this.f182525g;
        if (r126 == null) goto L73;
        r126.C(new SimilarProductCardView$updatePrice$1(this, r124));
    L73:
        if (r110 == null) goto L83;
        Promotion r127 = r110.f();
        if (r127 == null) goto L83;
        PromotionProductStruct r128 = r127.getPromotionInfo();
        if (r128 == null) goto L83;
        PromotionProductPriceStruct r129 = r128.getProductPrice();
        if (r129 == null) goto L83;
        PromotionDepositPrice r130 = r129.getDepositPrice();
        if (r130 == null) goto L83;
        final Long r131 = Long.valueOf(r130.getDepositPrice());
    L84:
        PriceView r132 = this.f182529k;
        if (r132 == null) goto L87;
        r132.C(new SimilarProductCardView$setDepositPresalePrice$1(this, r121, r131));
    L87:
        if (r110 == null) goto L95;
        Promotion r133 = r110.f();
        if (r133 == null) goto L95;
        PromotionProductStruct r134 = r133.getPromotionInfo();
        if (r134 == null) goto L95;
        PromotionProductBaseStruct r135 = r134.getBaseInfo();
        if (r135 == null) goto L95;
        Long r136 = r135.getSales();
    L97:
        if (r136 != null) goto L99;
    L110:
        TextView r137 = this.f182527i;
        if (r137 == null) goto L113;
        r137.setText(null);
    L113:
        TextView r138 = this.f182527i;
        if (r138 == null) goto L116;
        r138.setVisibility(8);
    L116:
        SimilarProductFeedbackView r139 = this.f182526h;
        if (r139 == null) goto L141;
        Intrinsics.checkNotNullParameter(r210, "vm");
        Intrinsics.checkNotNullParameter(r213, "adapter");
        LinearLayout r140 = r139.f182536a;
        if (r140 == null) goto L121;
        r140.removeAllViews();
    L121:
        r139.f182538c = r213;
        r139.f182539d = r212;
        r139.setVisibility(8);
        Iterator<T> r141 = r210.getFeedbackList().iterator();
        int r142 = 0;
    L123:
        if (r141.hasNext() == false) goto L145;
        Object r143 = r141.next();
        int r144 = r142 + 1;
        if (r142 >= 0) goto L127;
        CollectionsKt.throwIndexOverflow();
    L127:
        DislikeType r145 = (DislikeType) r143;
        View r146 = LayoutInflater.from(r139.getContext()).inflate(R.layout.ec_commerce_similar_product_feedback_item_view, r111);
        r146.setOnClickListener(new com.bytedance.android.shopping.searchsimilar.view.c(r146, r145, r142, r139, r214, r110, r210));
        SimpleDraweeView r147 = (SimpleDraweeView) r146.findViewById(R.id.ec_commerce_similar_product_feedback_item_icon);
        TextView r148 = (TextView) r146.findViewById(R.id.ec_commerce_similar_product_feedback_item_text);
        String r149 = r145.getIcon();
        if (r149 == null) goto L130;
        r147.setVisibility(0);
        ViewGroup r150 = null;
        y.e(r147, r149, th.a.f(r139.getContext()).getDimensionPixelOffset(R.dimen.commerce_similar_product_feedback_icon), th.a.f(r139.getContext()).getDimensionPixelOffset(R.dimen.commerce_similar_product_feedback_icon), null);
    L131:
        String r151 = r145.getName();
        if (r151 == null) goto L134;
        r148.setVisibility(0);
        r148.setText(r151);
    L134:
        LinearLayout.LayoutParams r152 = new LinearLayout.LayoutParams(-2, -2);
        if (r142 == 0) goto L137;
        r152.setMargins(0, com.bytedance.android.shopping.extensions.b.b(20), 0, 0);
    L137:
        LinearLayout r153 = r139.f182536a;
        if (r153 == null) goto L140;
        r153.addView(r146, r152);
    L140:
        r111 = r150;
        r142 = r144;
        goto L123
    L130:
        r150 = null;
        goto L131
    L145:
        return;
    L141:
        return;
    L99:
        if (r136.longValue() == 0) goto L110;
        if (r121 != null) goto L102;
    L104:
        TextView r154 = this.f182527i;
        if (r154 == null) goto L107;
        int r155 = g1.f45599a;
        r154.setText(g1.a.c(getContext(), R.string.shopping_sales, new Object[]{r136}));
    L107:
        TextView r156 = this.f182527i;
        if (r156 == null) goto L116;
        r156.setVisibility(0);
        goto L116
    L102:
        if (r121.getActivityType() != 8) goto L104;
    L95:
        r136 = null;
    L83:
        r131 = null;
    L70:
        PriceView r157 = this.f182525g;
        if (r157 == null) goto L73;
        r157.C(SimilarProductCardView$setPrice$1.INSTANCE);
    L61:
        r124 = null;
    L54:
        r121 = null;
        goto L55
    L45:
        TextView r158 = this.f182521c;
        if (r158 == null) goto L48;
        r158.setText(r108);
    L41:
        r118 = null;
    L36:
        r116 = null;
    L23:
        r108 = null;
    L13:
        r104 = null;
        goto L14
    }
}
