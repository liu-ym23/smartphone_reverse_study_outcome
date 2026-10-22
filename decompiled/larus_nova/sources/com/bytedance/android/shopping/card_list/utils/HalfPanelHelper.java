package com.bytedance.android.shopping.card_list.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.shopping.card_list.components.CardListQueryFetchComponent;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import com.bytedance.android.shopping.card_list.widgets.CardListRootFrameLayoutContainer;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class HalfPanelHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f171887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f171888b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f171889c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CardListRootFrameLayoutContainer f171890d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LinearLayout f171891e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f171892f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f171893g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f171894h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f171895i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f171896j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f171897k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f171898l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f171899m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f171900n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f171901o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final GestureDetector f171902p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final View f171903q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final CardListObjectContainer f171904r;

    public static final class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HalfPanelHelper f171905a;

        public a(HalfPanelHelper r100) {
            this.f171905a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            CardListRootFrameLayoutContainer r101 = this.f171905a.f171890d;
            if (r101 == null) goto L5;
            r101.setBorderRadius(0);
        L5:
            View r102 = this.f171905a.f171892f;
            if (r102 == null) goto L8;
            r102.setVisibility(4);
        L8:
            HalfPanelHelper.a(this.f171905a, true);
            Map<String, ?> r103 = this.f171905a.f171904r.f171545e.a();
            if (r103 == null) goto L11;
            Object r104 = r103.get("pull_full_screen_refresh");
        L13:
            if ((r104 instanceof Integer) == true) goto L15;
            r104 = null;
        L15:
            Integer r105 = (Integer) r104;
            if (r105 != null) goto L19;
            return;
        L19:
            if (r105.intValue() != 1) goto L24;
            CardListQueryFetchComponent r106 = (CardListQueryFetchComponent) this.f171905a.f171901o.getValue();
            if (r106 == null) goto L25;
            int r107 = CardListQueryFetchComponent.f171401x;
            r106.i(false, "pull_to_full_screen", null);
            return;
        L25:
            return;
        L24:
            return;
        L11:
            r104 = null;
            goto L13
        }
    }

    public static final class b extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f171906a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f171907b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ HalfPanelHelper f171908c;

        public b(HalfPanelHelper r100) {
            this.f171908c = r100;
            this.f171906a = 100;
            this.f171907b = 1500;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent r100, MotionEvent r101, float r102, float r103) {
            Intrinsics.checkNotNullParameter(r101, "e2");
            float r104 = 0.0f;
            if (r100 == null) goto L5;
            float r105 = r100.getRawY();
        L6:
            float r106 = r105 - r101.getRawY();
            if (r100 == null) goto L10;
            r104 = r100.getRawX();
        L10:
            if (Math.abs(r106) > Math.abs(r104 - r101.getRawX())) goto L12;
            return false;
        L12:
            if (Math.abs(r106) > this.f171906a) goto L14;
            return false;
        L14:
            if (Math.abs(r103) > this.f171907b) goto L16;
            return false;
        L16:
            if (r106 <= 0) goto L22;
            View r107 = this.f171908c.f171892f;
            if (r107 != null) goto L20;
        L23:
            return true;
        L20:
            if (r107.getVisibility() != 0) goto L23;
            this.f171908c.b();
            goto L23
        L22:
            this.f171908c.e();
            goto L23
        L5:
            r105 = 0.0f;
            goto L6
        }
    }

    public static final class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HalfPanelHelper f171909a;

        public c(HalfPanelHelper r100) {
            this.f171909a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            View r101 = this.f171909a.f171893g;
            if (r101 == null) goto L5;
            r101.setTranslationY(0.0f);
        L5:
            View r102 = this.f171909a.f171893g;
            if (r102 == null) goto L8;
            r102.setVisibility(4);
        L8:
            CardListRootFrameLayoutContainer r103 = this.f171909a.f171890d;
            if (r103 == null) goto L11;
            r103.setBorderRadius(com.bytedance.android.shopping.extensions.b.b(20));
        L11:
            HalfPanelHelper.a(this.f171909a, false);
            Map<String, ?> r104 = this.f171909a.f171904r.f171545e.a();
            if (r104 == null) goto L14;
            Object r105 = r104.get("pull_full_screen_refresh");
        L16:
            if ((r105 instanceof Integer) == true) goto L18;
            r105 = null;
        L18:
            Integer r106 = (Integer) r105;
            if (r106 != null) goto L22;
            return;
        L22:
            if (r106.intValue() != 1) goto L27;
            CardListQueryFetchComponent r107 = (CardListQueryFetchComponent) this.f171909a.f171901o.getValue();
            if (r107 == null) goto L28;
            int r108 = CardListQueryFetchComponent.f171401x;
            r107.i(false, "drop_down_to_split_screen", null);
            return;
        L28:
            return;
        L27:
            return;
        L14:
            r105 = null;
            goto L16
        }
    }

    public static final class d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HalfPanelHelper f171910a;

        public d(HalfPanelHelper r100) {
            this.f171910a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            View r101 = this.f171910a.f171892f;
            if (r101 == null) goto L6;
            r101.setVisibility(0);
            return;
        }
    }

    public final float c() {
        return ((Number) this.f171897k.getValue()).floatValue();
    }

    public final void b() {
        com.bytedance.android.shopping.card_list.components.k r100 = (com.bytedance.android.shopping.card_list.components.k) this.f171900n.getValue();
        if (r100 != null) goto L5;
    L7:
        this.f171904r.f171545e.f171322n = 100;
        d(true);
        AnimatorSet r101 = new AnimatorSet();
        ObjectAnimator r102 = ObjectAnimator.ofFloat(this.f171890d, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{((Number) this.f171894h.getValue()).intValue() - ((Number) this.f171895i.getValue()).intValue()});
        r102.setDuration(340);
        ObjectAnimator r103 = ObjectAnimator.ofFloat(this.f171889c, "alpha", new float[]{0.0f});
        r103.setDuration(100);
        ObjectAnimator r104 = ObjectAnimator.ofFloat(this.f171893g, "alpha", new float[]{1.0f});
        r104.setDuration(160);
        View r110 = this.f171893g;
        if (r110 == null) goto L10;
        r110.setVisibility(0);
    L10:
        View r111 = this.f171893g;
        if (r111 == null) goto L13;
        r111.setAlpha(0.0f);
    L13:
        ObjectAnimator r105 = ObjectAnimator.ofFloat(this.f171892f, "alpha", new float[]{0.0f});
        r105.setDuration(100);
        r105.addListener(new a(this));
        r101.playTogether(new Animator[]{r102, r103, r104, r105});
        r101.start();
        return;
    L5:
        if (r100.isLoading() != true) goto L7;
    }

    public final void e() {
        com.bytedance.android.shopping.card_list.components.k r100 = (com.bytedance.android.shopping.card_list.components.k) this.f171900n.getValue();
        if (r100 != null) goto L5;
    L7:
        this.f171904r.f171545e.f171322n = ((Number) this.f171896j.getValue()).intValue();
        d(false);
        AnimatorSet r101 = new AnimatorSet();
        ObjectAnimator r102 = ObjectAnimator.ofFloat(this.f171890d, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{c()});
        r102.setDuration(340);
        ObjectAnimator r103 = ObjectAnimator.ofFloat(this.f171893g, "alpha", new float[]{0.0f});
        r103.setDuration(100);
        r103.addListener(new c(this));
        ObjectAnimator r104 = ObjectAnimator.ofFloat(this.f171889c, "alpha", new float[]{0.6f});
        r104.setDuration(100);
        ObjectAnimator r105 = ObjectAnimator.ofFloat(this.f171892f, "alpha", new float[]{1.0f});
        r105.setDuration(260);
        r105.setStartDelay(100);
        r105.addListener(new d(this));
        r101.playTogether(new Animator[]{r102, r104, r103, r105});
        r101.start();
        return;
    L5:
        if (r100.isLoading() != true) goto L7;
    }

    public final void d(boolean r110) {
        AndroidYaTaInstance r100 = this.f171904r.f171545e.f171311c.invoke();
        List<com.bytedance.kmp.ec.yata.store.node.c> r101 = r100.n(ContainerPosition.BODY);
        com.bytedance.kmp.ec.yata.store.node.b r102 = null;
        if (r101 == null) goto L19;
        Iterator<T> r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L17;
        Object r104 = r103.next();
        com.bytedance.kmp.ec.yata.store.node.b r105 = ((com.bytedance.kmp.ec.yata.store.node.c) r104).getParent();
        if ((r105 instanceof com.bytedance.kmp.ec.yata.store.node.c) == true) goto L10;
        r105 = null;
    L10:
        com.bytedance.kmp.ec.yata.store.node.c r106 = (com.bytedance.kmp.ec.yata.store.node.c) r105;
        if (r106 == null) goto L13;
        String r107 = r106.getNodeName();
    L15:
        if (Intrinsics.areEqual(r107, "cart_top_bar") == false) goto L6;
    L18:
        com.bytedance.kmp.ec.yata.store.node.c r108 = (com.bytedance.kmp.ec.yata.store.node.c) r104;
    L20:
        List<com.bytedance.kmp.ec.yata.store.node.c> r109 = r100.n(ContainerPosition.BODY);
        if (r109 == null) goto L36;
        Iterator<T> r111 = r109.iterator();
    L24:
        if (r111.hasNext() == false) goto L34;
        Object r112 = r111.next();
        com.bytedance.kmp.ec.yata.store.node.c r113 = (com.bytedance.kmp.ec.yata.store.node.c) r112;
        if ((r113 instanceof com.bytedance.kmp.ec.yata.store.node.c) == true) goto L28;
        r113 = null;
    L28:
        if (r113 == null) goto L30;
        String r114 = r113.getNodeName();
    L32:
        if (Intrinsics.areEqual(r114, "cart_tab") == false) goto L24;
    L35:
        com.bytedance.kmp.ec.yata.store.node.c r115 = (com.bytedance.kmp.ec.yata.store.node.c) r112;
    L37:
        if (r108 == null) goto L39;
        com.bytedance.kmp.ec.yata.store.node.b r116 = r108.getParent();
    L41:
        if ((r116 instanceof com.bytedance.kmp.ec.yata.store.node.c) == false) goto L45;
        r102 = r116;
    L45:
        if (((com.bytedance.kmp.ec.yata.store.node.c) r102) == null) goto L51;
        Map<String, ? extends Object> r117 = MapsKt.mapOf(TuplesKt.to("show", Boolean.valueOf(r110)));
        if (r110 == false) goto L49;
        String r118 = "show_cart_to_top";
    L50:
        r100.k().d(com.bytedance.kmp.ec.yata.event.common.e.f251660a.a(r100, null, r108.getKey(), "controlChildTopBarVisibility", r117, r118));
        goto L51
    L49:
        r118 = "hide_cart_to_top";
    L51:
        if (r115 == null) goto L64;
        Map<String, ? extends Object> r119 = MapsKt.mapOf(TuplesKt.to("show", Boolean.valueOf(r110)));
        if (r110 == false) goto L55;
        String r120 = "show_cart_tab";
    L56:
        r100.k().d(com.bytedance.kmp.ec.yata.event.common.e.f251660a.a(r100, null, r115.getKey(), "showCartTab", r119, r120));
        return;
    L55:
        r120 = "hide_cart_tab";
        goto L56
    L64:
        return;
    L39:
        r116 = null;
        goto L41
    L30:
        r114 = null;
        goto L32
    L34:
        r112 = null;
        goto L35
    L36:
        r115 = null;
        goto L37
    L13:
        r107 = null;
        goto L15
    L17:
        r104 = null;
        goto L18
    L19:
        r108 = null;
        goto L20
    }

    public HalfPanelHelper(View r100, CardListObjectContainer r101) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        Intrinsics.checkNotNullParameter(r101, "objectContainer");
        this.f171903q = r100;
        this.f171904r = r101;
        this.f171894h = LazyKt.lazy(new HalfPanelHelper$headerViewHeight$2(this));
        this.f171895i = LazyKt.lazy(new HalfPanelHelper$bodyTitleViewHeight$2(this));
        this.f171896j = LazyKt.lazy(new HalfPanelHelper$heightPercent$2(this));
        this.f171897k = LazyKt.lazy(new HalfPanelHelper$initialTransY$2(this));
        this.f171898l = com.bytedance.android.shopping.extensions.b.b(5);
        this.f171899m = LazyKt.lazy(new HalfPanelHelper$footerComponent$2(this));
        this.f171900n = LazyKt.lazy(new HalfPanelHelper$loadingComponent$2(this));
        this.f171901o = LazyKt.lazy(new HalfPanelHelper$queryFetchComponent$2(this));
        this.f171902p = new GestureDetector(r101.getContext(), new b(this));
    }

    public static final void a(HalfPanelHelper r100, boolean r101) {
        View r102 = r100.f171903q;
        Fragment r103 = null;
        if ((r102 instanceof FrameLayout) == true) goto L5;
        r102 = null;
    L5:
        FrameLayout r104 = (FrameLayout) r102;
        if (r104 == null) goto L25;
        if (r101 == false) goto L19;
        Fragment r105 = r100.f171904r.f171544d;
        if ((r105 instanceof DialogFragment) == false) goto L12;
        r103 = r105;
    L12:
        DialogFragment r106 = (DialogFragment) r103;
        if (r106 == null) goto L26;
        int r107 = ECSdk.f48106a;
        IAdapterService r108 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r108 == null) goto L27;
        com.bytedance.android.ec.adapter.api.j r109 = r108.getLiveWindowService();
        if (r109 == null) goto L28;
        com.bytedance.android.ec.adapter.api.a r110 = new com.bytedance.android.ec.adapter.api.a();
        Intrinsics.checkNotNullParameter("product_cart_page", "<set-?>");
        r110.f42669a = "product_cart_page";
        Unit r111 = Unit.INSTANCE;
        r109.a(r106, r104, r110);
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L19:
        int r112 = ECSdk.f48106a;
        IAdapterService r113 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r113 == null) goto L30;
        com.bytedance.android.ec.adapter.api.j r114 = r113.getLiveWindowService();
        if (r114 == null) goto L31;
        r114.stopShowFloat();
        return;
    L31:
        return;
    L30:
        return;
    }
}
