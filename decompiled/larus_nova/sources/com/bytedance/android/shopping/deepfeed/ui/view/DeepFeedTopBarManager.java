package com.bytedance.android.shopping.deepfeed.ui.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.shopping.deepfeed.fold.DeepFeedFoldHelper;
import com.bytedance.android.shopping.deepfeed.ui.vh.AbsDeepFeedProductVH;
import com.bytedance.android.shopping.deepfeed.viewmodel.DeepFeedProductViewModel;
import com.bytedance.android.shopping.deepfeed.weights.common.ProductMarqueeTextView;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.facebook.drawee.view.SimpleDraweeView;
import com.gyf.barlibrary.ImmersionBar;
import com.larus.nova.R;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class DeepFeedTopBarManager implements com.bytedance.android.shopping.deepfeed.ui.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f173909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LottieAnimationView f173910b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ConstraintLayout f173911c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SimpleDraweeView f173912d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SimpleDraweeView f173913e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ProductMarqueeTextView f173914f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f173915g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f173916h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final View f173917i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Fragment f173918j;

    @Override // com.bytedance.android.shopping.deepfeed.ui.c
    public final void B() {
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.c
    public final boolean o() {
        return this.f173915g;
    }

    public static final boolean a(DeepFeedTopBarManager r100) {
        r100.getClass();
        Lazy r101 = DeepFeedFoldHelper.f173363a;
        DeepFeedFoldHelper.b(r100.f173918j.getActivity());
        return false;
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.c
    public final void e(float r100) {
        ConstraintLayout r101 = this.f173911c;
        if (r101 == null) goto L6;
        r101.setAlpha(r100);
        return;
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.c
    public final void l(boolean r100) {
        if (r100 == true) goto L16;
        if (tc3.f.b() == false) goto L12;
        ImageView r101 = this.f173909a;
        if (r101 == null) goto L9;
        r101.setVisibility(8);
    L9:
        LottieAnimationView r102 = this.f173910b;
        if (r102 == null) goto L27;
        r102.setVisibility(8);
        return;
    L27:
        return;
    L12:
        ImageView r103 = this.f173909a;
        if (r103 == null) goto L29;
        r103.setVisibility(8);
        return;
    L29:
        return;
    L16:
        if (tc3.f.b() == false) goto L23;
        LottieAnimationView r104 = this.f173910b;
        if (r104 == null) goto L20;
        r104.setVisibility(0);
    L20:
        ImageView r105 = this.f173909a;
        if (r105 == null) goto L31;
        r105.setVisibility(8);
        return;
    L31:
        return;
    L23:
        ImageView r106 = this.f173909a;
        if (r106 == null) goto L33;
        r106.setVisibility(0);
        return;
    }

    public DeepFeedTopBarManager(View r100, Fragment r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, WidgetService.PARAM_FRAGMENT);
        this.f173917i = r100;
        this.f173918j = r101;
        this.f173916h = LazyKt.lazy(DeepFeedTopBarManager$imageCallerContext$2.INSTANCE);
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.c
    public final void f(final DeepFeedProductViewModel r100, com.bytedance.android.shopping.deepfeed.action.b r101, Function0<? extends AbsDeepFeedProductVH> r110) {
        Intrinsics.checkNotNullParameter(r100, "viewModel");
        Intrinsics.checkNotNullParameter(r101, "deepFeedContext");
        Intrinsics.checkNotNullParameter(r110, "curVH");
        View r102 = this.f173917i;
        Fragment r103 = this.f173918j;
        View r104 = r102.findViewById(R.id.tool_bar_container);
        if (r104 == null) goto L5;
        r104.setVisibility(0);
        Lazy r105 = DeepFeedFoldHelper.f173363a;
        DeepFeedFoldHelper.b(r103.getActivity());
        ImmersionBar.with(r103).titleBar(r104).init();
    L5:
        ImageView r106 = (ImageView) r102.findViewById(R.id.iv_back);
        if (r106 == null) goto L8;
        r106.setOnClickListener(new j(this, r103));
        Unit r107 = Unit.INSTANCE;
    L8:
        ImageView r108 = (ImageView) this.f173917i.findViewById(R.id.iv_fold_back);
        ImageView r109 = null;
        InFeedProductV2 r111 = null;
        LottieAnimationView r112 = null;
        InFeedProductV2 r113 = null;
        if (r108 == null) goto L12;
        r108.setOnClickListener(new m(this));
        Unit r114 = Unit.INSTANCE;
    L12:
        if (this.f173918j.getActivity() == null) goto L15;
        Lazy r115 = DeepFeedFoldHelper.f173363a;
        DeepFeedFoldHelper.b(this.f173918j.getActivity());
    L15:
        final View r116 = this.f173917i;
        r101.getClass();
        ConstraintLayout r117 = (ConstraintLayout) r116.findViewById(R.id.shop_container);
        this.f173911c = r117;
        if (r117 == null) goto L18;
        r117.setVisibility(0);
    L18:
        this.f173912d = (SimpleDraweeView) r116.findViewById(R.id.shop_logo);
        this.f173913e = (SimpleDraweeView) r116.findViewById(R.id.shop_dance_log);
        ProductMarqueeTextView r118 = (ProductMarqueeTextView) r116.findViewById(R.id.shop_name);
        this.f173914f = r118;
        if (r118 == null) goto L21;
        a r119 = a.f173924e;
        r118.setTextSize(0, a.C2600a.a(r116.getContext(), 16));
    L21:
        ProductMarqueeTextView r120 = this.f173914f;
        if (r120 == null) goto L24;
        r120.setWeight(500);
    L24:
        int r121 = k1.q();
        if (r121 <= 0) goto L36;
        ConstraintLayout r122 = this.f173911c;
        if (r122 == null) goto L29;
        ViewGroup.LayoutParams r123 = r122.getLayoutParams();
    L31:
        if ((r123 instanceof ViewGroup.MarginLayoutParams) == true) goto L33;
        r123 = null;
    L33:
        ViewGroup.MarginLayoutParams r124 = (ViewGroup.MarginLayoutParams) r123;
        if (r124 == null) goto L36;
        r124.topMargin = r121;
        Lazy r125 = DeepFeedFoldHelper.f173363a;
        DeepFeedFoldHelper.b(this.f173918j.getActivity());
        goto L36
    L29:
        r123 = null;
    L36:
        Intrinsics.checkNotNullParameter(new DeepFeedTopBarManager$initShopView$2(this, r116, r100), "callback");
        View r126 = this.f173917i;
        if (tc3.f.b() == false) goto L50;
        LottieAnimationView r127 = (LottieAnimationView) r126.findViewById(R.id.cart_anim_view);
        if (r127 == null) goto L44;
        AbsDeepFeedProductVH r128 = r110.invoke();
        if (r128 == null) goto L43;
        r111 = r128.f173751m;
    L43:
        r100.logShowCartEntrance("c958668.d226180", r126, r111);
        r127.setOnClickListener(new k(r100, r126, r110));
        int r129 = re3.b.f537423a;
        Intrinsics.checkNotNullParameter(r127, "view");
        new WeakReference(r127);
        r127.setAnimation("shopping_deep_feed_cart_lottie.json");
        Unit r130 = Unit.INSTANCE;
        r112 = r127;
    L44:
        this.f173910b = r112;
        if (r112 == null) goto L47;
        r112.setVisibility(0);
    L47:
        ImageView r131 = (ImageView) r126.findViewById(R.id.iv_cart);
        this.f173909a = r131;
        if (r131 == null) goto L58;
        r131.setVisibility(8);
        return;
    L58:
        return;
    L50:
        ImageView r132 = (ImageView) r126.findViewById(R.id.iv_cart);
        if (r132 == null) goto L56;
        AbsDeepFeedProductVH r133 = r110.invoke();
        if (r133 == null) goto L55;
        r113 = r133.f173751m;
    L55:
        r100.logShowCartEntrance("c958668.d226180", r126, r113);
        r132.setOnClickListener(new l(r100, r126, r110));
        int r134 = re3.b.f537423a;
        Intrinsics.checkNotNullParameter(r132, "view");
        new WeakReference(r132);
        Unit r135 = Unit.INSTANCE;
        r109 = r132;
    L56:
        this.f173909a = r109;
    }
}
