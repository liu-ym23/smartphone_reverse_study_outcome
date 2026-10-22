package com.bytedance.android.shopping.store.shopfeed.presenter;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.sdk.helper.q;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.shopping.store.shopfeed.viewmodel.ECShopFeedViewModel;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class ECShopMomentFlowGuidePresenter extends QPresenter {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f186265m = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f186266e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Handler f186267f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public FrameLayout f186268g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LottieAnimationView f186269h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f186270i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f186271j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f186272k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Fragment f186273l;

    public static final class a {
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECShopMomentFlowGuidePresenter f186274a;

        public b(ECShopMomentFlowGuidePresenter r100) {
            this.f186274a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r110) {
            if (((LoadStatus) r110) != LoadStatus.InitializeSuccess) goto L21;
            ECShopMomentFlowGuidePresenter r111 = this.f186274a;
            r111.getClass();
            long r100 = System.currentTimeMillis();
            q r101 = q.f48131a;
            long r102 = q.f("shop_moment_flow_guide_last_show_time");
            if (q.f("shop_moment_flow_guide_show_count") < 3) goto L7;
        L9:
            boolean r103 = false;
        L10:
            if (r103 == false) goto L22;
            long r104 = System.currentTimeMillis();
            long r105 = q.f("shop_moment_flow_guide_show_count");
            q.h("shop_moment_flow_guide_last_show_time", r104);
            q.h("shop_moment_flow_guide_show_count", r105 + 1);
            FrameLayout r106 = r111.f186268g;
            if (r106 == null) goto L15;
            r106.setVisibility(0);
        L15:
            View r107 = th.a.c(r111.u().c(), R.layout.ec_shop_moment_flow_slide_guide, r111.f186268g, false);
            LottieAnimationView r108 = (LottieAnimationView) r107.findViewById(R.id.shop_moment_flow_slide_guide_lottie);
            if (r108 == null) goto L18;
            r108.addAnimatorListener((ECShopMomentFlowGuidePresenter$lottieAnimatorListener$2.a) r111.f186271j.getValue());
            r108.setRepeatCount(1);
            Unit r109 = Unit.INSTANCE;
        L19:
            r111.f186269h = r108;
            r111.f186270i = (TextView) r107.findViewById(R.id.shop_moment_flow_slide_guide_text);
            r111.f186267f.postDelayed(new g(r111, r107), 1500);
            return;
        L18:
            r108 = null;
            goto L19
        L22:
            return;
        L7:
            if (Math.abs(r100 - r102) <= 86400000) goto L9;
            r103 = true;
            goto L10
        }
    }

    static {
    }

    public ECShopMomentFlowGuidePresenter(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        this.f186273l = r100;
        this.f186266e = LazyKt.lazy(new ECShopMomentFlowGuidePresenter$viewModel$2(this));
        this.f186267f = new Handler(Looper.getMainLooper());
        this.f186271j = LazyKt.lazy(new ECShopMomentFlowGuidePresenter$lottieAnimatorListener$2(this));
        this.f186272k = LazyKt.lazy(new ECShopMomentFlowGuidePresenter$guideContainerTouchListener$2(this));
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r100) {
        FrameLayout r101 = (FrameLayout) com.bytedance.android.ec.store.product.presenter.utils.f.a(w().b(R.id.shop_feed_guide_container));
        this.f186268g = r101;
        if (r101 == null) goto L5;
        r101.setOnTouchListener((ECShopMomentFlowGuidePresenter$guideContainerTouchListener$2.a) this.f186272k.getValue());
    L5:
        ((ECShopFeedViewModel) this.f186266e.getValue()).getLoadStatus().b(ECQuickUtilKt.a(u()), new b(this));
    }
}
