package com.bytedance.android.shopping.inflow.view;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.hybrid.list.util.k;
import com.bytedance.android.ec.sdk.helper.p;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.event.goodprice.enums.LocationType;
import com.bytedance.android.shopping.feed.view.GoodPriceStrip;
import com.bytedance.android.shopping.product.flow.banner.BannerHolder;
import com.bytedance.android.shopping.widget.RemoteRoundImageView;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.google.gson.Gson;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import yd3.o;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/inflow/view/MainCardImageBannerHolder;", "Lcom/bytedance/android/shopping/product/flow/banner/BannerHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MainCardImageBannerHolder extends BannerHolder {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f176351j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ECDraweeView f176352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f176353b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ECDraweeView f176354c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f176355d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f176356e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RemoteRoundImageView f176357f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final GoodPriceStrip f176358g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final FrameLayout f176359h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ImageView f176360i;

    public static final class a {
    }

    public static final class b implements GoodPriceStrip.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MainCardImageBannerHolder f176361a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ rd3.a f176362b;

        @Override // com.bytedance.android.shopping.feed.view.GoodPriceStrip.a
        public final void a(o r100) {
            Intrinsics.checkNotNullParameter(r100, "resourceBarData");
            BtmSDK r101 = BtmSDK.INSTANCE;
            FeedProductEventTracker r102 = FeedProductEventTracker.f174442a;
            rd3.a r103 = this.f176362b;
            r102.getClass();
            String r104 = FeedProductEventTracker.f(r103, "c12364.d943130");
            PageFinder r105 = PageFinder.via(this.f176361a.itemView);
            BcmParams r106 = new BcmParams();
            rd3.a r107 = this.f176362b;
            if (r107 == null) goto L7;
            Map<String, String> r108 = r107.f537250p;
            if (r108 == null) goto L7;
            String r109 = r108.get("request_id");
        L8:
            r106.put("video_guide_search", k.d(FeedProductEventTracker.g(r107, r109)));
            Unit r110 = Unit.INSTANCE;
            String r111 = r101.createJumpSourceBtmToken(r104, r105, r106);
            List<yd3.e> r112 = r100.a();
            if (r112 == null) goto L15;
            yd3.e r113 = (yd3.e) CollectionsKt.firstOrNull(r112);
            if (r113 == null) goto L15;
            String r114 = r113.c();
            if (r114 == null) goto L15;
            p.f48130a.openSchema(this.f176361a.itemView.getContext(), md3.a.a(r114, r111));
        L15:
            MainCardImageBannerHolder.T3(this.f176361a, this.f176362b, r100, "inflow_low_price_entrance_click");
            return;
        L7:
            r109 = null;
            goto L8
        }

        public final void b(o r100) {
            Intrinsics.checkNotNullParameter(r100, "resourceBarData");
            MainCardImageBannerHolder.T3(this.f176361a, this.f176362b, r100, "inflow_low_price_entrance_show");
        }

        public b(MainCardImageBannerHolder r100, rd3.a r101) {
            this.f176361a = r100;
            this.f176362b = r101;
        }
    }

    static {
    }

    public MainCardImageBannerHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f176352a = (ECDraweeView) r100.findViewById(R.id.image);
        this.f176353b = (FrameLayout) r100.findViewById(R.id.image_layer);
        this.f176354c = (ECDraweeView) r100.findViewById(R.id.image_blur);
        this.f176355d = (FrameLayout) r100.findViewById(R.id.image_blur_layer);
        this.f176356e = r100.findViewById(R.id.fl_image_container);
        this.f176357f = (RemoteRoundImageView) r100.findViewById(R.id.atmosphere_image);
        this.f176358g = (GoodPriceStrip) r100.findViewById(R.id.good_price_strip);
        this.f176359h = (FrameLayout) r100.findViewById(R.id.head_image_up_layer);
        this.f176360i = (ImageView) r100.findViewById(R.id.head_image_bubble_point);
    }

    public final void U3(rd3.a r100) {
        Object r101 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L11
        if (r100 == null) goto L8;
        String r103 = r100.f537249o;     // Catch: Throwable -> L11
        if (r103 == null) goto L8;
        o r104 = (o) new Gson().fromJson(r103, o.class);     // Catch: Throwable -> L11
    L9:
        Object r105 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L11
    L14:
        if (Result.m9455isFailureimpl(r105) == true) goto L17;
        r101 = r105;
    L17:
        o r106 = (o) r101;
        if (r106 == null) goto L20;
        this.f176358g.a(r106, new b(this, r100));
        this.f176358g.setVisibility(0);
        return;
    L20:
        this.f176358g.setVisibility(8);
        return;
    L8:
        r104 = null;
    L11:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    public static final void T3(MainCardImageBannerHolder r100, rd3.a r101, o r110, String r111) {
        r100.getClass();
        String r102 = k.d(CollectionsKt.emptyList());
        List<yd3.e> r112 = r110.a();
        String r103 = null;
        if (r112 == null) goto L7;
        yd3.e r113 = (yd3.e) CollectionsKt.firstOrNull(r112);
        if (r113 == null) goto L7;
        String r114 = r113.b();
    L8:
        if (r114 != null) goto L10;
    L13:
        boolean r104 = true;
    L14:
        if (r104 == true) goto L16;
        r102 = k.d(CollectionsKt.listOf(r114));
    L16:
        String r105 = r102;
        FeedProductEventTracker r106 = FeedProductEventTracker.f174442a;
        String r107 = LocationType.INFLOW_MAIN_CARD_TAG.getType();
        if (r101 == null) goto L21;
        Map<String, String> r115 = r101.f537250p;
        if (r115 == null) goto L21;
        String r108 = r115.get(com.bytedance.android.ec.core.event.a.KEY_SIM_PRODUCT_ID);
    L22:
        if (r101 == null) goto L26;
        Map<String, String> r116 = r101.f537250p;
        if (r116 == null) goto L26;
        r103 = r116.get("request_id");
    L26:
        r106.getClass();
        FeedProductEventTracker.w(r111, r101, r105, r107, "c12364.d943130", r108, r103);
        return;
    L21:
        r108 = null;
        goto L22
    L10:
        if (r114.length() == 0) goto L13;
        r104 = false;
    L7:
        r114 = null;
        goto L8
    }
}
