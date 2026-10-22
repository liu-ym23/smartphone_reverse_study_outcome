package com.bytedance.android.ec.store.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.ec.core.utils.s0;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\r\u0012B\u0011\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019B\u001b\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u0018\u0010\u001cB#\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u0018\u0010\u001fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u001b\u0010\u000b\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001b\u0010\u0010\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0015\u001a\u00020\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/bytedance/android/ec/store/view/SortFilterExpandPanel;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/ec/store/view/SortFilterExpandPanel$e;", "event", "", "handleDismissPanelEvent", "Landroid/view/ViewGroup;", "c", "Lkotlin/Lazy;", "getContentLayout", "()Landroid/view/ViewGroup;", "contentLayout", "Landroidx/recyclerview/widget/RecyclerView;", "d", "getPanelListRv", "()Landroidx/recyclerview/widget/RecyclerView;", "panelListRv", "Landroid/view/View;", "e", "getMaskView", "()Landroid/view/View;", "maskView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SortFilterExpandPanel extends FrameLayout {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f48904j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SortFilterPanelAdapter f48905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f48906b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f48907c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f48908d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f48909e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f48910f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f48911g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f48912h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Function1<? super SortFilterExpandPanel, Unit> f48913i;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SortFilterExpandPanel f48914a;

        public a(SortFilterExpandPanel r100) {
            this.f48914a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            SortFilterExpandPanel r101 = this.f48914a;
            int r102 = SortFilterExpandPanel.f48904j;
            r101.getClass();
            this.f48914a.b(false);
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SortFilterExpandPanel f48915a;

        public b(SortFilterExpandPanel r100) {
            this.f48915a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            SortFilterExpandPanel r101 = this.f48915a;
            int r102 = SortFilterExpandPanel.f48904j;
            r101.getClass();
            this.f48915a.b(false);
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SortFilterExpandPanel f48916a;

        public c(SortFilterExpandPanel r100) {
            this.f48916a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            SortFilterExpandPanel r101 = this.f48916a;
            int r102 = SortFilterExpandPanel.f48904j;
            r101.getClass();
            this.f48916a.b(false);
        }
    }

    public static final class d {
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f48917a;

        public e() {
            this.f48917a = false;
        }
    }

    public static final class f implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SortFilterExpandPanel f48918a;

        public f(SortFilterExpandPanel r100) {
            this.f48918a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            ViewGroup r101 = SortFilterExpandPanel.a(this.f48918a);
            Object r102 = r100.getAnimatedValue();
            if (r102 == null) goto L7;
            r101.setTranslationY(((Float) r102).floatValue());
            this.f48918a.setBackgroundColor(Color.argb((int) ((1 - r100.getAnimatedFraction()) * 128), 0, 0, 0));
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final class g extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SortFilterExpandPanel f48919a;

        public g(SortFilterExpandPanel r100) {
            this.f48919a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f48919a.setVisibility(8);
            ViewParent r101 = this.f48919a.getParent();
            if ((r101 instanceof ViewGroup) == true) goto L5;
            r101 = null;
        L5:
            ViewGroup r102 = (ViewGroup) r101;
            if (r102 == null) goto L9;
            r102.removeView(this.f48919a);
            return;
        }
    }

    public static final class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SortFilterExpandPanel f48920a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f48921b;

        public h(SortFilterExpandPanel r100, boolean r101) {
            this.f48920a = r100;
            this.f48921b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f48920a.b(this.f48921b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    private final ViewGroup getContentLayout() {
        return (ViewGroup) this.f48907c.getValue();
    }

    private final RecyclerView getPanelListRv() {
        return (RecyclerView) this.f48908d.getValue();
    }

    public final View getMaskView() {
        return (View) this.f48909e.getValue();
    }

    public SortFilterExpandPanel(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f48905a = new SortFilterPanelAdapter(this);
        this.f48906b = new Handler(Looper.getMainLooper());
        this.f48907c = LazyKt.lazy(new SortFilterExpandPanel$contentLayout$2(this));
        this.f48908d = LazyKt.lazy(new SortFilterExpandPanel$panelListRv$2(this));
        this.f48909e = LazyKt.lazy(new SortFilterExpandPanel$maskView$2(this));
        View r101 = new View(getContext());
        r101.setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0f));
        r101.setOnClickListener(new a(this));
        Unit r102 = Unit.INSTANCE;
        this.f48910f = r101;
        this.f48911g = 1.366f;
        this.f48912h = 2.366f;
        setBackgroundColor(Color.argb(128, 0, 0, 0));
        getContentLayout().addView(getPanelListRv());
        addView(getMaskView());
        addView(r101);
        addView(getContentLayout(), new FrameLayout.LayoutParams(-1, -2));
        setId(R.id.ui_view_sort_filter_expand_panel);
    }

    public static final /* synthetic */ ViewGroup a(SortFilterExpandPanel r100) {
        return r100.getContentLayout();
    }

    public final void b(boolean r100) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L6;
        this.f48906b.post(new h(this, r100));
        return;
    L6:
        if (r100 == false) goto L16;
        s0.e(this);
        Function1<? super SortFilterExpandPanel, Unit> r101 = this.f48913i;
        if (r101 == null) goto L10;
        Unit r102 = r101.invoke(this);
    L10:
        ViewParent r103 = getParent();
        if ((r103 instanceof ViewGroup) == true) goto L13;
        r103 = null;
    L13:
        ViewGroup r104 = (ViewGroup) r103;
        if (r104 == null) goto L20;
        r104.removeView(this);
        return;
    L20:
        return;
    L16:
        ValueAnimator r105 = ValueAnimator.ofFloat(new float[]{0.0f, -getContentLayout().getChildAt(0).getHeight()});
        r105.setInterpolator(new com.bytedance.android.ec.hybrid.tools.g(this.f48912h));
        r105.addUpdateListener(new f(this));
        r105.addListener(new g(this));
        r105.setDuration(200);
        r105.start();
        s0.e(this);
        Function1<? super SortFilterExpandPanel, Unit> r106 = this.f48913i;
        if (r106 == null) goto L22;
        Unit r107 = r106.invoke(this);
        return;
    }

    @Subscribe
    public final void handleDismissPanelEvent(e r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        b(r100.f48917a);
    }

    public SortFilterExpandPanel(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f48905a = new SortFilterPanelAdapter(this);
        this.f48906b = new Handler(Looper.getMainLooper());
        this.f48907c = LazyKt.lazy(new SortFilterExpandPanel$contentLayout$2(this));
        this.f48908d = LazyKt.lazy(new SortFilterExpandPanel$panelListRv$2(this));
        this.f48909e = LazyKt.lazy(new SortFilterExpandPanel$maskView$2(this));
        View r102 = new View(getContext());
        r102.setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0f));
        r102.setOnClickListener(new b(this));
        Unit r103 = Unit.INSTANCE;
        this.f48910f = r102;
        this.f48911g = 1.366f;
        this.f48912h = 2.366f;
        setBackgroundColor(Color.argb(128, 0, 0, 0));
        getContentLayout().addView(getPanelListRv());
        addView(getMaskView());
        addView(r102);
        addView(getContentLayout(), new FrameLayout.LayoutParams(-1, -2));
        setId(R.id.ui_view_sort_filter_expand_panel);
    }

    public final void c(List r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "sortFilterList");
        Intrinsics.checkNotNullParameter(r101, "anchorView");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L6;
        this.f48906b.post(new v(this, r100, r101));
        return;
    L6:
        Intrinsics.checkNotNullParameter(r101, "anchorView");
        Context r102 = r101.getContext();
        View r103 = null;
        if ((r102 instanceof Activity) == true) goto L9;
        r102 = null;
    L9:
        Activity r104 = (Activity) r102;
        if (r104 == null) goto L18;
        Window r105 = r104.getWindow();
        if (r105 == null) goto L18;
        View r106 = r105.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L20;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r107 = ThreadMethodProxy.currentThread();
        if (r107 == com.larus.home.impl.utils.c.f346341a) goto L20;
        com.larus.home.impl.utils.c.a(r107, "getDecorView");
    L20:
        if ((r106 instanceof ViewGroup) == true) goto L22;
        r106 = null;
    L22:
        ViewGroup r108 = (ViewGroup) r106;
        if (r108 != null) goto L29;
        View r109 = r101.getRootView();
        if ((r109 instanceof ViewGroup) == false) goto L28;
        r103 = r109;
    L28:
        r108 = (ViewGroup) r103;
    L29:
        if (r108 == null) goto L32;
        s0.c(this);
        setVisibility(4);
        ViewGroup.MarginLayoutParams r110 = new ViewGroup.MarginLayoutParams(-1, -1);
        int[] r111 = new int[2];
        r108.getLocationOnScreen(r111);
        int r112 = r111[1];
        int[] r113 = new int[2];
        r101.getLocationOnScreen(r113);
        r110.topMargin = (r113[1] - r112) + r101.getHeight();
        Unit r114 = Unit.INSTANCE;
        r108.addView(this, r110);
        SortFilterPanelAdapter r115 = this.f48905a;
        r115.getClass();
        Intrinsics.checkNotNullParameter(r100, "sortFilterList");
        ((ArrayList) r115.f48923b).clear();
        ((ArrayList) r115.f48923b).addAll(r100);
        r115.notifyDataSetChanged();
        getContentLayout().post(new u(this, r101, r100));
        return;
    L32:
        return;
    L18:
        r106 = null;
        goto L20
    }

    public SortFilterExpandPanel(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f48905a = new SortFilterPanelAdapter(this);
        this.f48906b = new Handler(Looper.getMainLooper());
        this.f48907c = LazyKt.lazy(new SortFilterExpandPanel$contentLayout$2(this));
        this.f48908d = LazyKt.lazy(new SortFilterExpandPanel$panelListRv$2(this));
        this.f48909e = LazyKt.lazy(new SortFilterExpandPanel$maskView$2(this));
        View r103 = new View(getContext());
        r103.setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0f));
        r103.setOnClickListener(new c(this));
        Unit r104 = Unit.INSTANCE;
        this.f48910f = r103;
        this.f48911g = 1.366f;
        this.f48912h = 2.366f;
        setBackgroundColor(Color.argb(128, 0, 0, 0));
        getContentLayout().addView(getPanelListRv());
        addView(getMaskView());
        addView(r103);
        addView(getContentLayout(), new FrameLayout.LayoutParams(-1, -2));
        setId(R.id.ui_view_sort_filter_expand_panel);
    }
}
