package com.bytedance.android.livesdk.livecommerce.playback.card;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.common.api.model.PlaybackSmallCardViewState;
import com.bytedance.android.ec.core.utils.BtmUtilsKt;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.livesdk.livecommerce.playback.card.widget.ExplainProductCardWithBuyButtonView;
import com.bytedance.android.livesdk.livecommerce.playback.main.ExplainPlaybackViewModel;
import com.bytedance.android.livesdk.livecommerce.promotion.card.PromotionCardModuleName;
import com.bytedance.android.livesdk.livecommerce.utils.LiveBstReport;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes10.dex */
public final class ExplainPlaybackCardPresenter extends QFragmentPresenter {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ int f149809v = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f149810f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public FrameLayout f149811g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public FrameLayout f149812h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ExplainProductCardWithBuyButtonView f149813i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f149814j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f149815k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f149816l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f149817m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ECUIPromotion f149818n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f149819o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public com.bytedance.android.livesdk.livecommerce.promotion.card.b f149820p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f149821q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f149822r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public AnimatorSet f149823s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f149824t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final bk2.b f149825u;

    public static final class a {
    }

    static {
    }

    public final ExplainPlaybackViewModel h0() {
        return (ExplainPlaybackViewModel) this.f149810f.getValue();
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void c0() {
        com.bytedance.android.livesdk.livecommerce.promotion.card.b r100 = this.f149820p;
        if (r100 == null) goto L5;
        r100.release();
    L5:
        AnimatorSet r101 = this.f149823s;
        if (r101 == null) goto L8;
        r101.cancel();
    L8:
        this.f149825u.clearDisposable();
    }

    public ExplainPlaybackCardPresenter(final Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100);
        this.f149810f = LazyKt.lazy(new ExplainPlaybackCardPresenter$viewModel$2(this));
        this.f149821q = LazyKt.lazy(ExplainPlaybackCardPresenter$btmInfo$2.INSTANCE);
        this.f149822r = LazyKt.lazy(new ExplainPlaybackCardPresenter$absParams$2(this, r100));
        this.f149825u = new bk2.b();
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void b0(QModel r100) {
        this.f149811g = (FrameLayout) Z().b(R.id.commerce_video_promotion_small_card_view_container).f();
        this.f149812h = (FrameLayout) Z().b(R.id.commerce_video_promotion_card_view_container).f();
        com.bytedance.android.ec.core.arch.state.c.a(h0(), com.bytedance.android.ec.core.arch.lifecycle.g.a(Y()), ExplainPlaybackCardPresenter$onBind$1.INSTANCE, new ExplainPlaybackCardPresenter$onBind$2(this));
        com.bytedance.android.ec.core.arch.event.c.c(h0(), com.bytedance.android.ec.core.arch.lifecycle.g.a(Y()), Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.playback.main.a.k.class), new ExplainPlaybackCardPresenter$onBind$3(this));
        com.bytedance.android.ec.core.arch.event.c.c(h0(), com.bytedance.android.ec.core.arch.lifecycle.g.a(Y()), Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.playback.main.a.l.class), new ExplainPlaybackCardPresenter$onBind$4(this));
    }

    public static final void d0(final ExplainPlaybackCardPresenter r110, final boolean r111) {
        if (r110.f149819o == true) goto L5;
        return;
    L5:
        if (r111 == false) goto L9;
        FrameLayout r100 = r110.f149812h;
        if (r100 == null) goto L9;
        r100.setVisibility(0);
    L9:
        com.bytedance.android.livesdk.livecommerce.promotion.card.b r101 = r110.f149820p;
        if (r101 == null) goto L35;
        View r102 = com.bytedance.android.livesdk.livecommerce.promotion.card.b.a.a(r101);
        View r112 = r101.F0(PromotionCardModuleName.ImageAreaModule);
        PlaybackSmallCardViewState r103 = new PlaybackSmallCardViewState(r110.f149814j, r110.f149815k, th.a.f(r110.Y().c()).getDimensionPixelSize(R.dimen.ec_explain_playback_small_product_card_imagesize));
        AnimatorSet r104 = r110.f149823s;
        if (r104 != null) goto L14;
    L16:
        int r105 = com.bytedance.android.livesdk.livecommerce.playback.utils.g.f149992a;
        View r106 = com.bytedance.android.livesdk.livecommerce.promotion.card.b.a.a(r101);
        int r107 = r102.getWidth();
        int r113 = r102.getHeight();
        int r114 = UtilityKotlinExtentionsKt.d(Float.valueOf(96.0f));
        Function0<Unit> r115 = new ExplainPlaybackCardPresenter$showOrHideBigProductCard$$inlined$also$lambda$1(r110, r111);
        Intrinsics.checkNotNullParameter(r106, "rootView");
        Intrinsics.checkNotNullParameter(r112, "imageModuleView");
        Intrinsics.checkNotNullParameter(r103, "smallCardViewState");
        List<View> r108 = com.bytedance.commerce.base.view.b.a(r106);
        ArrayList r109 = new ArrayList();
        Iterator<T> r116 = r108.iterator();
    L18:
        if (r116.hasNext() == false) goto L22;
        Object r117 = r116.next();
        if ((!Intrinsics.areEqual((View) r117, r112)) == false) goto L18;
        r109.add(r117);
        goto L18
    L22:
        AnimatorSet r118 = new AnimatorSet();
        if (r111 == false) goto L29;
        ArrayList r119 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r109, 10));
        Iterator r120 = r109.iterator();
    L26:
        if (r120.hasNext() == false) goto L28;
        r119.add(ObjectAnimator.ofFloat((View) r120.next(), "alpha", new float[]{0.0f, 1.0f}));
        goto L26
    L28:
        r118.playTogether(r119);
        r118.setDuration(200);
        r118.start();
        r106.getLayoutParams().height = -2;
        r106.getLayoutParams().width = -1;
        r112.getLayoutParams().height = r114;
        r112.getLayoutParams().width = UtilityKotlinExtentionsKt.d(20) + r114;
        r106.setVisibility(0);
    L34:
        r110.f149823s = r118;
        goto L35
    L29:
        ArrayList r121 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r109, 10));
        Iterator r122 = r109.iterator();
    L31:
        if (r122.hasNext() == false) goto L33;
        r121.add(ObjectAnimator.ofFloat((View) r122.next(), "alpha", new float[]{1.0f, 0.0f}));
        goto L31
    L33:
        r118.playTogether(r121);
        r118.setDuration(200);
        r118.addListener(new com.bytedance.android.livesdk.livecommerce.playback.utils.b(r103, r106, r107, r113, r112, r114, r115));
        r118.start();
        goto L34
    L14:
        if (r104.isRunning() != true) goto L16;
    L35:
        if (r111 == false) goto L46;
        cj2.a.d("1", null, null, null, null);
        return;
    }

    public static final void e0(final ExplainPlaybackCardPresenter r100, boolean r101) {
        if (r100.f149819o == false) goto L17;
        ExplainProductCardWithBuyButtonView r102 = null;
        if (r101 == false) goto L10;
        FrameLayout r103 = r100.f149811g;
        if (r103 == null) goto L9;
        r103.setVisibility(0);
    L9:
        cj2.a.d("2", null, null, null, null);
        com.bytedance.android.bst.api.e r104 = new com.bytedance.android.bst.api.e(r100.Z().f());
        r104.f41913a = "a1.b3390.c11834.d45925";
        r104.f41914b = "livesdk_show_product";
        r104.f41916d = "live_shopping";
        r104.f41915c = r100.f149818n;
        r104.f41918f = new LiveBstReport(ExplainPlaybackCardPresenter$bindBst$1$1.INSTANCE, new ExplainPlaybackCardPresenter$bindBst$$inlined$apply$lambda$1(r100));
        com.bytedance.android.bst.api.f r105 = com.bytedance.android.bst.api.f.f41925b;
        com.bytedance.android.bst.api.d r106 = BtmUtilsKt.h(r104);
        r105.getClass();
        com.bytedance.android.bst.api.f.a(r106);
    L10:
        ExplainProductCardWithBuyButtonView r107 = r100.f149813i;
        if ((r107 instanceof com.bytedance.android.livesdk.livecommerce.playback.card.widget.f) == false) goto L14;
        r102 = r107;
    L14:
        if (r102 == null) goto L18;
        r102.a(r101, new dj2.d(r100.f149816l, r100.f149817m, UtilityKotlinExtentionsKt.d(96)), new ExplainPlaybackCardPresenter$showOrHideSmallCardView$1(r100));
        return;
    L18:
        return;
    }
}
