package com.bytedance.android.shopping.feed.widget.popupview;

import android.graphics.Typeface;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.bst.api.ext.ExtKt;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.hybrid.list.util.k;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductExtraStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.event.goodprice.enums.LocationType;
import com.bytedance.android.shopping.feed.viewmodel.ProductFeedViewModel;
import com.bytedance.android.shopping.inflow.view.f;
import com.bytedance.android.ui.ec.widget.popup.BubblePopupWindow;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a extends BubblePopupWindow {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f176046h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f176047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public rd3.a f176048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f176049c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f176050d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.shopping.feed.widget.popupview.b f176051e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f176052f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final InterfaceC2610a f176053g;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.feed.widget.popupview.a$a, reason: collision with other inner class name */
    public interface InterfaceC2610a {
        void a();
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f176054a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ rd3.a f176055b;

        public b(a r100, rd3.a r101) {
            this.f176054a = r100;
            this.f176055b = r101;
        }

        public final void a() {
            a r100 = this.f176054a;
            r100.show(r100.f176052f, com.bytedance.android.shopping.extensions.b.b(Double.valueOf(-1.5d)), 0, com.bytedance.android.shopping.extensions.b.b(2), 80);
            FeedProductEventTracker r101 = FeedProductEventTracker.f174442a;
            rd3.a r102 = this.f176055b;
            String r103 = k.d(CollectionsKt.emptyList());
            String r104 = LocationType.INFLOW_MAIN_CARD_IMAGE.getType();
            String r105 = this.f176054a.f176049c;
            String r106 = this.f176055b.f537237d;
            r101.getClass();
            FeedProductEventTracker.w("inflow_low_price_entrance_show", r102, r103, r104, "c12364.d801587", r105, r106);
            this.f176054a.f176047a = true;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.bytedance.android.ui.ec.widget.popup.BubblePopupWindow, android.widget.PopupWindow
    public final void dismiss() {
        if (this.f176047a == true) goto L5;
        return;
    L5:
        this.f176047a = false;
        PopupWindowLancet.handleDismissBeforeOrigin(this);
        super.dismiss();
        this.f176053g.a();
        rd3.a r100 = this.f176048b;
        if (r100 == null) goto L13;
        ProductFeedViewModel r101 = r100.f537236c;
        if (r101 == null) goto L14;
        MutableLiveData<Boolean> r102 = r101.getPopupViewLiveData();
        if (r102 == null) goto L15;
        r102.removeObserver(this.f176051e);
        return;
    L15:
        return;
    L14:
        return;
    }

    @Override // com.bytedance.android.ui.ec.widget.popup.BubblePopupWindow
    public final void onDestroy() {
        super.onDestroy();
        this.f176053g.a();
        rd3.a r100 = this.f176048b;
        if (r100 == null) goto L10;
        ProductFeedViewModel r101 = r100.f537236c;
        if (r101 == null) goto L11;
        MutableLiveData<Boolean> r102 = r101.getPopupViewLiveData();
        if (r102 == null) goto L12;
        r102.removeObserver(this.f176051e);
        return;
    L12:
        return;
    L11:
        return;
    }

    public a(View r100, f r101) {
        Intrinsics.checkNotNullParameter(r100, "parentView");
        Intrinsics.checkNotNullParameter(r101, "iinflowHeadImageSearchPopupView");
        super(ExtKt.getActivity(r100), false, true);
        this.f176052f = r100;
        this.f176053g = r101;
        this.f176051e = new com.bytedance.android.shopping.feed.widget.popupview.b(this);
    }

    public final void b(rd3.a r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "anchorInflowFeedItem");
        Promotion r100 = r110.f();
        if (r100 == null) goto L9;
        PromotionProductStruct r101 = r100.getPromotionInfo();
        if (r101 == null) goto L9;
        PromotionProductExtraStruct r102 = r101.getExtraInfo();
        if (r102 == null) goto L9;
        String r103 = r102.getImgSearchSchema();
    L11:
        if (r103 != null) goto L13;
    L16:
        boolean r104 = true;
    L17:
        if (r104 == false) goto L19;
        return;
    L19:
        this.f176048b = r110;
        Promotion r105 = r110.f();
        if (r105 == null) goto L27;
        PromotionProductStruct r106 = r105.getPromotionInfo();
        if (r106 == null) goto L27;
        PromotionProductBaseStruct r107 = r106.getBaseInfo();
        if (r107 == null) goto L27;
        String r108 = r107.getProductId();
        if (r108 == null) goto L27;
    L28:
        this.f176049c = r108;
        this.f176050d = r111;
        Object r112 = this.f176052f.getContext();
        if ((r112 instanceof LifecycleOwner) == true) goto L31;
        r112 = null;
    L31:
        LifecycleOwner r113 = (LifecycleOwner) r112;
        if (r113 == null) goto L38;
        ProductFeedViewModel r109 = r110.f537236c;
        if (r109 == null) goto L38;
        MutableLiveData<Boolean> r114 = r109.getPopupViewLiveData();
        if (r114 == null) goto L38;
        r114.observe(r113, this.f176051e);
    L38:
        rd3.a r115 = this.f176048b;
        if (r115 == null) goto L47;
        Promotion r116 = r115.f();
        if (r116 == null) goto L47;
        PromotionProductStruct r117 = r116.getPromotionInfo();
        if (r117 == null) goto L47;
        PromotionProductExtraStruct r118 = r117.getExtraInfo();
        if (r118 == null) goto L47;
        final String r119 = r118.getImgSearchSchema();
    L48:
        final LinearLayout r120 = new LinearLayout(this.f176052f.getContext());
        r120.setLayoutParams(new ViewGroup.LayoutParams(-2, com.bytedance.android.shopping.extensions.b.b(40)));
        r120.setPadding(com.bytedance.android.shopping.extensions.b.b(12), com.bytedance.android.shopping.extensions.b.b(11), com.bytedance.android.shopping.extensions.b.b(12), com.bytedance.android.shopping.extensions.b.b(11));
        r120.setGravity(16);
        ImageView r121 = new ImageView(r120.getContext());
        r120.setGravity(16);
        r121.setLayoutParams(new ViewGroup.LayoutParams(com.bytedance.android.shopping.extensions.b.b(16), com.bytedance.android.shopping.extensions.b.b(16)));
        int r122 = Build.VERSION.SDK_INT;
        r121.setBackground(ContextCompat.getDrawable(r121.getContext(), R.drawable.ec_commerce_head_image_search_icon));
        Unit r123 = Unit.INSTANCE;
        r120.addView(r121);
        TextView r124 = new TextView(r120.getContext());
        r124.setGravity(16);
        r124.setPadding(com.bytedance.android.shopping.extensions.b.b(4), 0, com.bytedance.android.shopping.extensions.b.b(2), 0);
        String r125 = r124.getContext().getString(R.string.ec_inner_flow_find_similar_with_image);
        r124.setIncludeFontPadding(false);
        r124.setGravity(16);
        r124.setText(r125);
        r124.setTextColor(ContextCompat.getColor(r124.getContext(), R.color.ec_inflow_coupon_desc_color_161823));
        r124.setTextSize(13.0f);
        if (r122 < 28) goto L51;
        Typeface r126 = Typeface.create(null, 500, false);
    L52:
        r124.setTypeface(r126);
        r120.addView(r124);
        ImageView r127 = new ImageView(r120.getContext());
        r120.setGravity(16);
        r127.setLayoutParams(new ViewGroup.LayoutParams(com.bytedance.android.shopping.extensions.b.b(12), com.bytedance.android.shopping.extensions.b.b(12)));
        r127.setBackground(ContextCompat.getDrawable(r127.getContext(), R.drawable.ec_inflow_popup_view_arrow));
        r120.addView(r127);
        com.bytedance.android.ec.core.widget.f.c(r120, null, null, new InflowHeadImageSearchPopupView$initView$$inlined$apply$lambda$1(r120, this, r119), 3);
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L55
        setBubbleView(r120, Boolean.TRUE);     // Catch: Throwable -> L55
        Object r129 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L55
    L57:
        Throwable r130 = Result.m9452exceptionOrNullimpl(r129);
        if (r130 == null) goto L60;
        ECExceptionMonitor.e(r130);
    L60:
        setBgColor(-1);
        setNeedPath(false);
        setAutoDismissDelayMillis(3000);
        setShadowLayerYOffset(0);
        setOutsideTouchable(true);
        setFocusable(false);
        setInAnimTime(100);
        setOutAnimTime(0);
        setOutsideTouchable(true);
        setArrowVerticalSize(7);
        setArrowLongSize(19);
        setHorizontalPadding(0);
        this.f176052f.post(new b(this, r110));
        return;
    L55:
        th = move-exception;
        Result.Companion r131 = Result.Companion;
        r129 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L57
    L51:
        r126 = Typeface.DEFAULT_BOLD;
    L47:
        r119 = null;
    L27:
        r108 = "";
        goto L28
    L13:
        if (r103.length() == 0) goto L16;
        r104 = false;
    L9:
        r103 = null;
        goto L11
    }
}
