package com.bytedance.android.shopping.mall.homepage.pendant.anchor;

import android.graphics.Rect;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.card.api.e;
import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;
import com.bytedance.android.shopping.mall.settings.MallSettings;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/pendant/anchor/AnchorPendant;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Lcom/bytedance/android/shopping/api/mall/b$a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorPendant extends RecyclerView.OnScrollListener implements com.bytedance.android.shopping.api.mall.b.a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final Lazy f178318u = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f178319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f178320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f178321c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f178322d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f178323e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f178324f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f178325g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f178326h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f178327i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f178328j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f178329k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ViewGroup f178330l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final View f178331m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ConstraintLayout f178332n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final View f178333o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final View f178334p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final com.bytedance.android.shopping.mall.homepage.pendant.anchor.c f178335q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final com.bytedance.android.shopping.mall.homepage.pendant.anchor.b f178336r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final com.bytedance.android.shopping.api.mall.b f178337s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Function0<Integer> f178338t;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements ViewTreeObserver.OnScrollChangedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorPendant f178340a;

        public b(AnchorPendant r100) {
            this.f178340a = r100;
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public final void onScrollChanged() {
            AnchorPendant r100 = this.f178340a;
            if (r100.f178336r.f178360d == false) goto L5;
            return;
        L5:
            View r101 = r100.f178321c;
            int r102 = 0;
            if ((r101 instanceof RecyclerView) == false) goto L8;
            int r103 = r100.f178322d - r100.f178323e;
        L11:
            AnchorPendant r104 = this.f178340a;
            r104.f178334p.setTranslationY(r103 - r104.f178322d);
            e r105 = null;
            if (this.f178340a.f178334p.getY() <= this.f178340a.f178338t.invoke().floatValue()) goto L23;
            float r106 = this.f178340a.f178334p.getY();
            Object r107 = this.f178340a.f178334p.getParent();
            if ((r107 instanceof View) == true) goto L16;
            r107 = null;
        L16:
            View r108 = (View) r107;
            if (r108 == null) goto L19;
            int r109 = r108.getMeasuredHeight();
        L21:
            if (r106 >= r109) goto L23;
            boolean r110 = true;
        L24:
            AnchorPendant r111 = this.f178340a;
            if (r110 == r111.f178319a) goto L39;
            e r112 = r111.f178336r.f178358b.f523073b;
            if ((r112 instanceof ECLynxCard) == false) goto L30;
            r105 = r112;
        L30:
            ECLynxCard r113 = (ECLynxCard) r105;
            if (r113 == null) goto L33;
            ECLynxCard.m(r113, r110, "list", "", false, false, false, 0, 248);
        L33:
            View r114 = this.f178340a.f178334p;
            if (r110 == true) goto L37;
            r102 = 4;
        L37:
            r114.setVisibility(r102);
            this.f178340a.f178319a = r110;
            return;
        L39:
            return;
        L19:
            r109 = Integer.MAX_VALUE;
        L23:
            r110 = false;
            goto L24
        L8:
            if (r101 == null) goto L10;
            r103 = r101.getTop();
            goto L11
        L10:
            r103 = 0;
            goto L11
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorPendant f178341a;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f178342a;

            public a(c r100) {
                this.f178342a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                AnchorPendant r100 = this.f178342a.f178341a;     // Catch: Throwable -> L4
                r100.b(r100.f178337s.a());     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public c(AnchorPendant r100) {
            this.f178341a = r100;
        }

        public final void a() {
            com.bytedance.android.shopping.api.mall.b r100 = this.f178341a.f178337s;
            if (r100 != null) goto L5;
        L15:
            com.bytedance.android.shopping.api.mall.b r101 = this.f178341a.f178337s;
            if (r101 != null) goto L18;
            return;
        L18:
            if (r101.a() != true) goto L23;
            ((Handler) this.f178341a.f178329k.getValue()).postDelayed(new a(this), 350);
            return;
        L23:
            return;
        L5:
            if (r100.a() != true) goto L15;
            View r102 = this.f178341a.f178331m;
            Rect r103 = new Rect();
            r102.getGlobalVisibleRect(r103);
            if (r103.width() <= 0) goto L9;
        L12:
            boolean r104 = true;
        L13:
            if (r104 == false) goto L15;
            this.f178341a.j();
            return;
        L9:
            if (r103.height() > 0) goto L12;
            r104 = false;
            goto L13
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

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorPendant f178343a;

        public d(AnchorPendant r100) {
            this.f178343a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f178343a.j();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final void k() {
        int[] r100 = new int[2];
        this.f178333o.getLocationInWindow(r100);
        int[] r101 = new int[2];
        this.f178331m.getLocationInWindow(r101);
        int r102 = r100[0] - r101[0];
        int r103 = r100[1] - r101[1];
        View r104 = this.f178320b;
        int r105 = this.f178333o.getMeasuredWidth();
        if (r103 >= 0) goto L5;
        int r106 = RangesKt.coerceAtLeast(this.f178333o.getMeasuredHeight() + r103, 1);
    L6:
        ConstraintLayout.LayoutParams r107 = new ConstraintLayout.LayoutParams(r105, r106);
        r107.leftToLeft = 0;
        r107.topToTop = 0;
        ((ViewGroup.MarginLayoutParams) r107).leftMargin = r102;
        ((ViewGroup.MarginLayoutParams) r107).topMargin = r103;
        Unit r108 = Unit.INSTANCE;
        r104.setLayoutParams(r107);
        return;
    L5:
        r106 = this.f178333o.getMeasuredHeight();
        goto L6
    }

    static {
        new a();
        f178318u = LazyKt.lazy(AnchorPendant$Companion$pendingShowEnable$2.INSTANCE);
    }

    public final String j() {
        if (this.f178327i == true) goto L108;
        if (this.f178328j == true) goto L108;
        Lazy r100 = f178318u;
        if (((Boolean) r100.getValue()).booleanValue() == false) goto L16;
        com.bytedance.android.shopping.api.mall.b r101 = this.f178337s;
        if (r101 == null) goto L16;
        if (r101.a() == true) goto L16;
        return this.f178326h;
    L16:
        if (((Boolean) r100.getValue()).booleanValue() == false) goto L31;
        com.bytedance.android.shopping.api.mall.b r102 = this.f178337s;
        if (r102 == null) goto L31;
        if (r102.a() == false) goto L31;
        View r103 = this.f178331m;
        Rect r104 = new Rect();
        r103.getGlobalVisibleRect(r104);
        if (r104.width() <= 0) goto L24;
    L27:
        boolean r105 = true;
    L28:
        if (r105 == true) goto L31;
        ((Handler) this.f178329k.getValue()).postDelayed(new d(this), 350);
        return this.f178326h;
    L24:
        if (r104.height() > 0) goto L27;
        r105 = false;
    L31:
        ViewParent r106 = null;
        if (this.f178336r.f178360d == true) goto L46;
        View r107 = t93.a.a(this.f178330l, AnchorPendant$show$2.INSTANCE);
        this.f178321c = r107;
        if ((r107 instanceof RecyclerView) == true) goto L36;
        r107 = null;
    L36:
        RecyclerView r108 = (RecyclerView) r107;
        if (r108 == null) goto L39;
        r108.addOnScrollListener(this);
    L39:
        View r109 = this.f178321c;
        if ((r109 instanceof RecyclerView) == false) goto L42;
        int r110 = this.f178322d - this.f178323e;
    L45:
        this.f178322d = r110;
        goto L46
    L42:
        if (r109 == null) goto L44;
        r110 = r109.getTop();
        goto L45
    L44:
        r110 = 0;
    L46:
        ViewParent r111 = this.f178320b.getParent();
        if ((r111 instanceof ViewGroup) == true) goto L49;
        r111 = null;
    L49:
        ViewGroup r112 = (ViewGroup) r111;
        if (r112 == null) goto L52;
        r112.removeView(this.f178320b);
    L52:
        k();
        this.f178332n.addView(this.f178320b);
        View r113 = this.f178334p;
        ConstraintLayout.LayoutParams r114 = new ConstraintLayout.LayoutParams(com.bytedance.android.ec.hybrid.tools.d.a(this.f178335q.f178364a), com.bytedance.android.ec.hybrid.tools.d.a(this.f178335q.f178365b));
        String r115 = this.f178335q.f178366c;
        switch(r115.hashCode()) {
            case -1383228885: goto L65;
            case 115029: goto L62;
            case 3317767: goto L59;
            case 108511772: goto L56;
            default: goto L68;
        };
    L56:
        if (r115.equals("right") == false) goto L68;
        r114.leftToRight = this.f178320b.getId();
        goto L68
    L59:
        if (r115.equals("left") == false) goto L68;
        r114.rightToLeft = this.f178320b.getId();
        goto L68
    L62:
        if (r115.equals("top") == false) goto L68;
        r114.bottomToTop = this.f178320b.getId();
        goto L68
    L65:
        if (r115.equals("bottom") == false) goto L68;
        r114.topToBottom = this.f178320b.getId();
    L68:
        if (Intrinsics.areEqual(this.f178335q.f178366c, "left") == false) goto L70;
    L73:
        boolean r116 = true;
    L74:
        String r117 = this.f178335q.f178367d;
        int r118 = r117.hashCode();
        if (r118 == 100571) goto L85;
        if (r118 == 109757538) goto L80;
    L89:
        if (r116 == false) goto L91;
        r114.topToTop = this.f178320b.getId();
        r114.bottomToBottom = this.f178320b.getId();
    L92:
        Number[] r119 = this.f178335q.f178368e;
        r114.setMargins(com.bytedance.android.ec.hybrid.tools.d.b(r119[0]), com.bytedance.android.ec.hybrid.tools.d.b(r119[1]), com.bytedance.android.ec.hybrid.tools.d.b(r119[2]), com.bytedance.android.ec.hybrid.tools.d.b(r119[3]));
        Unit r120 = Unit.INSTANCE;
        r113.setLayoutParams(r114);
        ViewParent r121 = this.f178334p.getParent();
        if ((r121 instanceof ViewGroup) == false) goto L96;
        r106 = r121;
    L96:
        ViewGroup r122 = (ViewGroup) r106;
        if (r122 == null) goto L99;
        r122.removeView(this.f178334p);
    L99:
        this.f178332n.addView(this.f178334p);
        this.f178333o.getViewTreeObserver().addOnScrollChangedListener(this.f178324f);
        if (MallSettings.a() == false) goto L102;
        this.f178333o.addOnAttachStateChangeListener((View.OnAttachStateChangeListener) this.f178325g.getValue());
    L102:
        this.f178327i = true;
        com.bytedance.android.shopping.api.mall.b r123 = this.f178337s;
        if (r123 == null) goto L106;
        Intrinsics.checkNotNullParameter(this, "listener");
        ((ArrayList) r123.f170222a).remove(this);
    L106:
        return this.f178326h;
    L91:
        r114.leftToLeft = this.f178320b.getId();
        r114.rightToRight = this.f178320b.getId();
        goto L92
    L80:
        if (r117.equals("start") == false) goto L89;
        if (r116 == false) goto L83;
        r114.topToTop = this.f178320b.getId();
        goto L92
    L83:
        r114.leftToLeft = this.f178320b.getId();
        goto L92
    L85:
        if (r117.equals("end") == false) goto L89;
        if (r116 == false) goto L88;
        r114.bottomToBottom = this.f178320b.getId();
        goto L92
    L88:
        r114.rightToRight = this.f178320b.getId();
        goto L92
    L70:
        if (Intrinsics.areEqual(this.f178335q.f178366c, "right") == true) goto L73;
        r116 = false;
    L108:
        return this.f178326h;
    }

    public final String toString() {
        return "schema = " + this.f178336r.f178357a;
    }

    @Override // com.bytedance.android.shopping.api.mall.b.a
    public final void b(boolean r100) {
        if (this.f178328j == false) goto L5;
        return;
    L5:
        if (this.f178327i == true) goto L10;
        if (r100 == false) goto L11;
        ((Handler) this.f178329k.getValue()).postDelayed(new c(this), 350);
        return;
    L11:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onScrolled(r100, r101, r102);
        this.f178323e += r102;
    }

    public AnchorPendant(ViewGroup r100, View r101, ConstraintLayout r102, View r103, View r104, com.bytedance.android.shopping.mall.homepage.pendant.anchor.c r105, com.bytedance.android.shopping.mall.homepage.pendant.anchor.b r106, com.bytedance.android.shopping.api.mall.b r107, Function0<Integer> r110) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        Intrinsics.checkNotNullParameter(r101, "pendantContainer");
        Intrinsics.checkNotNullParameter(r102, "internalPendantContainer");
        Intrinsics.checkNotNullParameter(r103, "anchor");
        Intrinsics.checkNotNullParameter(r104, "pendant");
        Intrinsics.checkNotNullParameter(r105, "layout");
        Intrinsics.checkNotNullParameter(r106, "extra");
        Intrinsics.checkNotNullParameter(r110, "instantTopBoundaryGetter");
        this.f178330l = r100;
        this.f178331m = r101;
        this.f178332n = r102;
        this.f178333o = r103;
        this.f178334p = r104;
        this.f178335q = r105;
        this.f178336r = r106;
        this.f178337s = r107;
        this.f178338t = r110;
        this.f178319a = true;
        View r108 = new View(r102.getContext());
        r108.setId(r108.hashCode());
        Unit r109 = Unit.INSTANCE;
        this.f178320b = r108;
        this.f178324f = new b(this);
        this.f178325g = LazyKt.lazy(new AnchorPendant$anchorAttachStateChangeListener$2(this));
        this.f178326h = UUID.randomUUID().toString();
        this.f178329k = LazyKt.lazy(AnchorPendant$mainHandler$2.INSTANCE);
        if (r107 == null) goto L6;
        Intrinsics.checkNotNullParameter(this, "listener");
        ((ArrayList) r107.f170222a).add(this);
        return;
    }
}
