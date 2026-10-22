package com.stepos.widget.toolbar;

import K2.o;
import P.i;
import P.j;
import W3.C0403n;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.H;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.widget.toolbar.StepOSTitleBar;
import j4.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.ranges.l;
import l3.C0846d;
import l4.C0848a;
import r3.C1009e;

/* loaded from: classes.dex */
public class a extends FrameLayout {

    /* renamed from: O0, reason: collision with root package name */
    public static final b f16442O0 = new b(null);

    /* renamed from: P0, reason: collision with root package name */
    private static final C0201a f16443P0 = new C0201a();

    /* renamed from: A, reason: collision with root package name */
    private final TextView f16444A;

    /* renamed from: A0, reason: collision with root package name */
    private View f16445A0;

    /* renamed from: B, reason: collision with root package name */
    private final int f16446B;

    /* renamed from: B0, reason: collision with root package name */
    private float f16447B0;

    /* renamed from: C, reason: collision with root package name */
    private int f16448C;

    /* renamed from: C0, reason: collision with root package name */
    private boolean f16449C0;

    /* renamed from: D, reason: collision with root package name */
    private boolean f16450D;

    /* renamed from: D0, reason: collision with root package name */
    private boolean f16451D0;

    /* renamed from: E, reason: collision with root package name */
    private final int f16452E;

    /* renamed from: E0, reason: collision with root package name */
    private final FrameLayout f16453E0;

    /* renamed from: F, reason: collision with root package name */
    private final int f16454F;

    /* renamed from: F0, reason: collision with root package name */
    private final FrameLayout f16455F0;

    /* renamed from: G, reason: collision with root package name */
    private boolean f16456G;

    /* renamed from: G0, reason: collision with root package name */
    private View f16457G0;

    /* renamed from: H, reason: collision with root package name */
    private final int f16458H;

    /* renamed from: H0, reason: collision with root package name */
    private boolean f16459H0;

    /* renamed from: I, reason: collision with root package name */
    private final int f16460I;

    /* renamed from: I0, reason: collision with root package name */
    private long f16461I0;

    /* renamed from: J, reason: collision with root package name */
    private final int f16462J;

    /* renamed from: J0, reason: collision with root package name */
    private float f16463J0;

    /* renamed from: K, reason: collision with root package name */
    private final int f16464K;

    /* renamed from: K0, reason: collision with root package name */
    private float f16465K0;

    /* renamed from: L, reason: collision with root package name */
    private final int f16466L;

    /* renamed from: L0, reason: collision with root package name */
    private final ArrayList<e> f16467L0;

    /* renamed from: M, reason: collision with root package name */
    private final int f16468M;

    /* renamed from: M0, reason: collision with root package name */
    private boolean f16469M0;

    /* renamed from: N0, reason: collision with root package name */
    private i f16470N0;

    /* renamed from: Q, reason: collision with root package name */
    private final int f16471Q;

    /* renamed from: R, reason: collision with root package name */
    private final int f16472R;

    /* renamed from: S, reason: collision with root package name */
    private long f16473S;

    /* renamed from: T, reason: collision with root package name */
    private boolean f16474T;

    /* renamed from: U, reason: collision with root package name */
    private float f16475U;

    /* renamed from: V, reason: collision with root package name */
    private float f16476V;

    /* renamed from: W, reason: collision with root package name */
    private int f16477W;

    /* renamed from: a, reason: collision with root package name */
    private final StepOSTitleBar f16478a;

    /* renamed from: a0, reason: collision with root package name */
    private ValueAnimator f16479a0;

    /* renamed from: b, reason: collision with root package name */
    private final View f16480b;

    /* renamed from: b0, reason: collision with root package name */
    private View f16481b0;

    /* renamed from: c, reason: collision with root package name */
    private View f16482c;

    /* renamed from: c0, reason: collision with root package name */
    private ViewTreeObserver.OnScrollChangedListener f16483c0;

    /* renamed from: d, reason: collision with root package name */
    private C1009e f16484d;

    /* renamed from: d0, reason: collision with root package name */
    private ViewTreeObserver f16485d0;

    /* renamed from: e, reason: collision with root package name */
    private Drawable f16486e;

    /* renamed from: e0, reason: collision with root package name */
    private RecyclerView.OnScrollListener f16487e0;

    /* renamed from: f, reason: collision with root package name */
    private boolean f16488f;

    /* renamed from: f0, reason: collision with root package name */
    private int f16489f0;

    /* renamed from: g, reason: collision with root package name */
    private boolean f16490g;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f16491g0;

    /* renamed from: h, reason: collision with root package name */
    private boolean f16492h;

    /* renamed from: h0, reason: collision with root package name */
    private final ArrayList<c> f16493h0;

    /* renamed from: i, reason: collision with root package name */
    private Integer f16494i;

    /* renamed from: i0, reason: collision with root package name */
    private boolean f16495i0;

    /* renamed from: j, reason: collision with root package name */
    private Integer f16496j;

    /* renamed from: j0, reason: collision with root package name */
    private int f16497j0;

    /* renamed from: k, reason: collision with root package name */
    private Integer f16498k;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f16499k0;

    /* renamed from: l, reason: collision with root package name */
    private Integer f16500l;

    /* renamed from: l0, reason: collision with root package name */
    private float f16501l0;

    /* renamed from: m, reason: collision with root package name */
    private boolean f16502m;

    /* renamed from: m0, reason: collision with root package name */
    private boolean f16503m0;

    /* renamed from: n, reason: collision with root package name */
    private final Runnable f16504n;

    /* renamed from: n0, reason: collision with root package name */
    private i f16505n0;

    /* renamed from: o, reason: collision with root package name */
    private final Runnable f16506o;

    /* renamed from: o0, reason: collision with root package name */
    private float f16507o0;

    /* renamed from: p, reason: collision with root package name */
    private boolean f16508p;

    /* renamed from: p0, reason: collision with root package name */
    private boolean f16509p0;

    /* renamed from: q, reason: collision with root package name */
    private boolean f16510q;

    /* renamed from: q0, reason: collision with root package name */
    private boolean f16511q0;

    /* renamed from: r, reason: collision with root package name */
    private final Paint f16512r;

    /* renamed from: r0, reason: collision with root package name */
    private float f16513r0;

    /* renamed from: s, reason: collision with root package name */
    private final Runnable f16514s;

    /* renamed from: s0, reason: collision with root package name */
    private boolean f16515s0;

    /* renamed from: t, reason: collision with root package name */
    private final LinearLayout f16516t;

    /* renamed from: t0, reason: collision with root package name */
    private long f16517t0;

    /* renamed from: u, reason: collision with root package name */
    private final FrameLayout f16518u;

    /* renamed from: u0, reason: collision with root package name */
    private boolean f16519u0;

    /* renamed from: v, reason: collision with root package name */
    private final TextView f16520v;

    /* renamed from: v0, reason: collision with root package name */
    private boolean f16521v0;

    /* renamed from: w, reason: collision with root package name */
    private final ImageView f16522w;

    /* renamed from: w0, reason: collision with root package name */
    private boolean f16523w0;

    /* renamed from: x, reason: collision with root package name */
    private final LinearLayout f16524x;

    /* renamed from: x0, reason: collision with root package name */
    private Runnable f16525x0;

    /* renamed from: y, reason: collision with root package name */
    private final TextView f16526y;

    /* renamed from: y0, reason: collision with root package name */
    private int f16527y0;

    /* renamed from: z, reason: collision with root package name */
    private final FrameLayout f16528z;

    /* renamed from: z0, reason: collision with root package name */
    private boolean f16529z0;

    /* renamed from: com.stepos.widget.toolbar.a$a, reason: collision with other inner class name */
    public static final class C0201a extends P.f<a> {
        C0201a() {
            super("centeredTitleFraction");
        }

        @Override // P.f
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(a aVar) {
            k.g(aVar, "view");
            return aVar.f16501l0;
        }

        @Override // P.f
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(a aVar, float f5) {
            k.g(aVar, "view");
            aVar.f16501l0 = f5;
            aVar.l();
        }
    }

    public static final class b {
        public /* synthetic */ b(j4.g gVar) {
            this();
        }

        private b() {
        }
    }

    public interface c {
        void a(float f5);
    }

    public interface d {
    }

    private static final class e {

        /* renamed from: a, reason: collision with root package name */
        private final View f16530a;

        /* renamed from: b, reason: collision with root package name */
        private final float f16531b;

        public final float a() {
            return this.f16531b;
        }

        public final View b() {
            return this.f16530a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return k.b(this.f16530a, eVar.f16530a) && Float.compare(this.f16531b, eVar.f16531b) == 0;
        }

        public int hashCode() {
            return (this.f16530a.hashCode() * 31) + Float.hashCode(this.f16531b);
        }

        public String toString() {
            return "OverScrollLayer(view=" + this.f16530a + ", translationRatio=" + this.f16531b + ")";
        }
    }

    private static final class f extends View.BaseSavedState {

        /* renamed from: a, reason: collision with root package name */
        private float f16533a;

        /* renamed from: b, reason: collision with root package name */
        private int f16534b;

        /* renamed from: c, reason: collision with root package name */
        public static final b f16532c = new b(null);
        public static final Parcelable.ClassLoaderCreator<f> CREATOR = new C0202a();

        /* renamed from: com.stepos.widget.toolbar.a$f$a, reason: collision with other inner class name */
        public static final class C0202a implements Parcelable.ClassLoaderCreator<f> {
            C0202a() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public f createFromParcel(Parcel parcel) {
                k.g(parcel, "source");
                return new f(parcel, null, 0 == true ? 1 : 0);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public f createFromParcel(Parcel parcel, ClassLoader classLoader) {
                k.g(parcel, "source");
                return new f(parcel, classLoader, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public f[] newArray(int i5) {
                return new f[i5];
            }
        }

        public static final class b {
            public /* synthetic */ b(j4.g gVar) {
                this();
            }

            private b() {
            }
        }

        public /* synthetic */ f(Parcel parcel, ClassLoader classLoader, j4.g gVar) {
            this(parcel, classLoader);
        }

        public final void A(int i5) {
            this.f16534b = i5;
        }

        public final float a() {
            return this.f16533a;
        }

        public final int c() {
            return this.f16534b;
        }

        public final void f(float f5) {
            this.f16533a = f5;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i5) {
            k.g(parcel, "out");
            super.writeToParcel(parcel, i5);
            parcel.writeFloat(this.f16533a);
            parcel.writeInt(this.f16534b);
        }

        public f(Parcelable parcelable) {
            super(parcelable);
            this.f16534b = 1;
        }

        private f(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f16534b = 1;
            this.f16533a = parcel.readFloat();
            this.f16534b = parcel.readInt();
        }
    }

    private static final class g {

        /* renamed from: a, reason: collision with root package name */
        private final float f16535a;

        /* renamed from: b, reason: collision with root package name */
        private final float f16536b;

        /* renamed from: c, reason: collision with root package name */
        private final float f16537c;

        public g(float f5, float f6, float f7) {
            this.f16535a = f5;
            this.f16536b = f6;
            this.f16537c = f7;
        }

        public final float a() {
            return this.f16537c;
        }

        public final float b() {
            return this.f16535a;
        }

        public final float c() {
            return this.f16536b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            return Float.compare(this.f16535a, gVar.f16535a) == 0 && Float.compare(this.f16536b, gVar.f16536b) == 0 && Float.compare(this.f16537c, gVar.f16537c) == 0;
        }

        public int hashCode() {
            return (((Float.hashCode(this.f16535a) * 31) + Float.hashCode(this.f16536b)) * 31) + Float.hashCode(this.f16537c);
        }

        public String toString() {
            return "TitleTransformTarget(left=" + this.f16535a + ", right=" + this.f16536b + ", centerY=" + this.f16537c + ")";
        }
    }

    public static final class h extends AnimatorListenerAdapter {
        h() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            k.g(animator, "animation");
            if (a.this.f16479a0 == animator) {
                a.this.f16479a0 = null;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            k.g(animator, "animation");
            if (a.this.f16479a0 == animator) {
                a.this.f16479a0 = null;
            }
        }
    }

    private final void A(Canvas canvas) {
        if (getWidth() <= 0 || getHeight() <= 0) {
            return;
        }
        Drawable drawable = this.f16486e;
        if (drawable == null || drawable.getOpacity() != -1) {
            this.f16512r.setColor(androidx.core.content.a.c(getContext(), C0846d.f18303j));
            canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.f16512r);
        } else {
            drawable.setBounds(0, 0, getWidth(), getHeight());
            drawable.draw(canvas);
        }
    }

    private final int B() {
        if (this.f16523w0 && this.f16529z0) {
            return this.f16527y0;
        }
        return 0;
    }

    private final float C() {
        if (this.f16475U >= 0.999f) {
            return 1.0f;
        }
        float fZ = z(44.0f);
        return fZ <= 0.0f ? this.f16475U : l.g(this.f16476V / fZ, 0.0f, 1.0f);
    }

    private final void E() {
        int iIndexOfChild = indexOfChild(this.f16478a);
        if (iIndexOfChild > 0 && indexOfChild(this.f16444A) != iIndexOfChild - 1) {
            removeView(this.f16444A);
            addView(this.f16444A, indexOfChild(this.f16478a));
        }
        ViewGroup.LayoutParams layoutParams = this.f16444A.getLayoutParams();
        k.e(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        int iA = this.f16478a.getHeight() > 0 ? C0848a.a((((this.f16478a.getTop() + this.f16478a.getPaddingTop()) + (this.f16478a.getBottom() - this.f16478a.getPaddingBottom())) / 2.0f) - (this.f16446B / 2.0f)) : B();
        if (layoutParams2.width != -1 || layoutParams2.height != this.f16446B || layoutParams2.topMargin != iA) {
            layoutParams2.width = -1;
            layoutParams2.height = this.f16446B;
            layoutParams2.topMargin = iA;
            layoutParams2.gravity = 48;
            this.f16444A.setLayoutParams(layoutParams2);
        }
        int iMax = Math.max(this.f16478a.getStartActionContainer().getWidth(), this.f16478a.getEndActionContainer().getWidth());
        int titleActionGap = iMax > 0 ? iMax + this.f16478a.getTitleActionGap() : this.f16458H;
        if (this.f16444A.getPaddingStart() == titleActionGap && this.f16444A.getPaddingEnd() == titleActionGap) {
            return;
        }
        this.f16444A.setPaddingRelative(titleActionGap, 0, titleActionGap, 0);
    }

    private final float F(float f5, float f6, float f7) {
        return f5 + ((f6 - f5) * f7);
    }

    private final void H(boolean z5) {
        s();
        C1009e c1009e = this.f16484d;
        if (c1009e == null) {
            k.t("backdropGlassDelegate");
            c1009e = null;
        }
        c1009e.m();
        if (z5) {
            this.f16488f = true;
            try {
                super.setBackground(this.f16486e);
            } finally {
                this.f16488f = false;
            }
        }
        Y();
    }

    private final void I() {
        if (this.f16492h && isAttachedToWindow() && !this.f16502m) {
            this.f16502m = true;
            post(this.f16504n);
        }
    }

    private final void L(View view, int i5) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null || layoutParams.height == i5) {
            return;
        }
        layoutParams.height = i5;
        view.setLayoutParams(layoutParams);
    }

    private final void M(View view, boolean z5) {
        view.setEnabled(z5);
        view.setClickable(z5 && view.hasOnClickListeners());
        view.setFocusable(z5);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = viewGroup.getChildAt(i5);
                k.f(childAt, "getChildAt(...)");
                M(childAt, z5);
            }
        }
    }

    private final void Q(boolean z5) {
        boolean z6 = z5 && (this.f16476V >= z(34.0f) || this.f16475U >= 0.999f);
        if (!z5) {
            i iVar = this.f16505n0;
            if (iVar != null) {
                iVar.d();
            }
            this.f16503m0 = false;
            this.f16501l0 = 0.0f;
            this.f16444A.setVisibility(8);
            this.f16444A.setAlpha(0.0f);
            this.f16444A.setRenderEffect(null);
            return;
        }
        E();
        if (!isLaidOut()) {
            this.f16503m0 = z6;
            this.f16501l0 = z6 ? 1.0f : 0.0f;
            l();
        } else {
            if (z6 != this.f16503m0) {
                this.f16503m0 = z6;
                i iVarT = t();
                iVarT.d();
                iVarT.s(z6 ? 1.0f : 0.0f);
                return;
            }
            i iVar2 = this.f16505n0;
            if (iVar2 == null || !iVar2.i()) {
                this.f16501l0 = z6 ? 1.0f : 0.0f;
            }
            l();
        }
    }

    private final void S() {
        int iY;
        if (this.f16456G) {
            return;
        }
        CharSequence text = this.f16526y.getText();
        this.f16524x.setVisibility((text != null && text.length() != 0) || this.f16528z.getChildCount() > 0 ? 0 : 8);
        if (!this.f16450D || this.f16448C == (iY = y())) {
            return;
        }
        this.f16448C = iY;
        int iMax = Math.max(1, iY);
        this.f16477W = iMax;
        m(this.f16475U * iMax, false);
    }

    private final void T() {
        if (this.f16490g) {
            View view = this.f16482c;
            if (view == null) {
                k.t("backdropBlurView");
                view = null;
            }
            L(view, x());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void U() {
        boolean z5 = (Z(this.f16478a.getStartActionContainer()) > 0 || Z(this.f16478a.getEndActionContainer()) > 3 || this.f16451D0) ? 1 : 0;
        this.f16499k0 = z5;
        this.f16478a.setTitleGravity(!z5);
        this.f16478a.setSidePadding(this.f16460I);
        if (this.f16490g) {
            Y();
        }
    }

    private final void V(int i5) {
        ViewGroup.LayoutParams layoutParams = this.f16516t.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 != null) {
            layoutParams2.height = this.f16448C;
            layoutParams2.topMargin = this.f16446B + B();
            this.f16516t.setLayoutParams(layoutParams2);
        }
        View view = this.f16457G0;
        Object layoutParams3 = view != null ? view.getLayoutParams() : null;
        FrameLayout.LayoutParams layoutParams4 = layoutParams3 instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams3 : null;
        if (layoutParams4 != null) {
            layoutParams4.topMargin = B() + this.f16462J;
            layoutParams4.bottomMargin = this.f16464K;
            View view2 = this.f16457G0;
            if (view2 != null) {
                view2.setLayoutParams(layoutParams4);
            }
        }
        int iB = this.f16462J + B();
        if (this.f16478a.getTopPadding() != iB) {
            this.f16478a.setTopPadding(iB);
        }
        int bottomPadding = this.f16478a.getBottomPadding();
        int i6 = this.f16464K;
        if (bottomPadding != i6) {
            this.f16478a.setBottomPadding(i6);
        }
    }

    static /* synthetic */ void W(a aVar, int i5, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateInsetLayoutParams");
        }
        if ((i6 & 1) != 0) {
            i5 = aVar.f16446B + aVar.f16448C + aVar.B();
        }
        aVar.V(i5);
    }

    private final void X() {
        for (e eVar : C0403n.U(this.f16467L0)) {
            eVar.b().setTranslationY(this.f16463J0 * eVar.a());
        }
    }

    private final void Y() {
        float f5;
        boolean z5;
        float f6 = this.f16475U;
        boolean z6 = false;
        boolean z7 = this.f16459H0 || (this.f16445A0 != null && this.f16449C0);
        this.f16516t.setTranslationY(0.0f);
        this.f16516t.setAlpha(this.f16459H0 ? 0.0f : 1.0f);
        this.f16524x.setTranslationY(((-f6) * this.f16448C) + this.f16463J0);
        this.f16524x.setAlpha(this.f16459H0 ? 0.0f : 1.0f - f6);
        boolean z8 = (this.f16499k0 || z7) ? false : true;
        float fC = C();
        View view = null;
        if (z8) {
            float fD = l.d(this.f16476V, z(44.0f));
            this.f16520v.setScaleX(1.0f);
            this.f16520v.setScaleY(1.0f);
            this.f16520v.setTranslationX(0.0f);
            float f7 = -fD;
            this.f16520v.setTranslationY(this.f16463J0 + f7);
            float f8 = 1.0f - fC;
            this.f16520v.setAlpha(f8);
            this.f16520v.setClipBounds(null);
            this.f16522w.setTranslationY(f7 + this.f16463J0);
            this.f16522w.setAlpha(f8);
        } else {
            this.f16522w.setTranslationY(0.0f);
            this.f16522w.setAlpha(z7 ? 0.0f : 1.0f - f6);
            n(f6, z7);
        }
        if (this.f16511q0) {
            boolean z9 = this.f16459H0;
            f5 = z9 ? 0.0f : 1.0f;
            z5 = !z9;
        } else {
            f5 = this.f16507o0;
            z5 = this.f16509p0;
        }
        this.f16478a.setAlpha(f5);
        j(z5);
        Q(z8);
        T();
        if (this.f16490g) {
            View view2 = this.f16482c;
            if (view2 == null) {
                k.t("backdropBlurView");
            } else {
                view = view2;
            }
            view.setAlpha(!this.f16492h ? 0.0f : z8 ? fC : 1.0f);
        }
        View view3 = this.f16480b;
        if (!this.f16474T || this.f16459H0 || this.f16492h) {
            fC = 0.0f;
        } else if (!z8) {
            fC = f6;
        }
        view3.setAlpha(fC);
        View view4 = this.f16445A0;
        if (view4 != null) {
            view4.setPivotX(0.0f);
            view4.setPivotY(view4.getHeight());
            float F5 = F(1.0f, this.f16447B0, f6);
            view4.setScaleX(F5);
            view4.setScaleY(F5);
            view4.setTranslationY(this.f16463J0);
            view4.setAlpha(this.f16459H0 ? 0.0f : 1.0f);
            view4.setEnabled(!this.f16459H0);
            view4.setClickable(!this.f16459H0);
            view4.setImportantForAccessibility(this.f16459H0 ? 4 : 1);
        }
        X();
        this.f16453E0.setTranslationY(this.f16463J0 * 0.1f);
        this.f16455F0.setTranslationY(this.f16463J0 * 0.13f);
        boolean z10 = f6 >= 0.5f;
        if (z10 != this.f16495i0) {
            this.f16495i0 = z10;
        }
        if (z8 && this.f16501l0 >= 0.5f) {
            z6 = true;
        }
        this.f16520v.setImportantForAccessibility((z7 || z6) ? 2 : 1);
        this.f16444A.setImportantForAccessibility(z6 ? 1 : 2);
        View view5 = this.f16457G0;
        if (view5 != null) {
            view5.setImportantForAccessibility(this.f16459H0 ? 1 : 4);
        }
    }

    private final int Z(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        int iZ = 0;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = viewGroup.getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                iZ += (k.b(childAt.getTag(l3.h.f18420L), Boolean.TRUE) && (childAt instanceof ViewGroup)) ? Z((ViewGroup) childAt) : 1;
            }
        }
        return iZ;
    }

    private final void g(float f5) {
        q();
        ValueAnimator valueAnimator = this.f16479a0;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        float fG = l.g(f5, 0.0f, this.f16477W);
        if (Math.abs(fG - this.f16476V) < 0.5f) {
            m(fG, true);
            return;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.f16476V, fG);
        valueAnimatorOfFloat.setDuration(this.f16473S);
        valueAnimatorOfFloat.setInterpolator(new PathInterpolator(0.4f, 0.0f, 0.4f, 1.0f));
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: w3.d
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                com.stepos.widget.toolbar.a.h(this.f23704a, valueAnimator2);
            }
        });
        valueAnimatorOfFloat.addListener(new h());
        valueAnimatorOfFloat.start();
        this.f16479a0 = valueAnimatorOfFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(a aVar, ValueAnimator valueAnimator) {
        k.g(valueAnimator, "animator");
        Object animatedValue = valueAnimator.getAnimatedValue();
        k.e(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        aVar.m(((Float) animatedValue).floatValue(), true);
    }

    private final void j(boolean z5) {
        boolean z6 = z5 && !this.f16459H0 && this.f16478a.getAlpha() > 0.001f;
        this.f16478a.setEnabled(z6);
        this.f16478a.setClickable(z6);
        this.f16478a.setFocusable(z6);
        M(this.f16478a.getStartActionContainer(), z6);
        M(this.f16478a.getEndActionContainer(), z6);
    }

    static /* synthetic */ void k(a aVar, boolean z5, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: applyActionLayerState");
        }
        if ((i5 & 1) != 0) {
            z5 = aVar.f16509p0;
        }
        aVar.j(z5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l() {
        float fG = l.g(this.f16501l0, 0.0f, 1.0f);
        TextView textView = this.f16444A;
        textView.setVisibility(0);
        textView.setAlpha(fG);
        float F5 = F(0.7f, 1.0f, fG);
        textView.setPivotX(textView.getWidth() / 2.0f);
        textView.setPivotY(textView.getHeight() / 2.0f);
        textView.setScaleX(F5);
        textView.setScaleY(F5);
        textView.setTranslationY((1.0f - fG) * z(17.48f));
        float F6 = F(30.0f, 0.0f, fG);
        if (F6 < 0.5f) {
            textView.setRenderEffect(null);
        } else {
            textView.setRenderEffect(RenderEffect.createBlurEffect(F6, F6, Shader.TileMode.CLAMP));
        }
    }

    private final void m(float f5, boolean z5) {
        float fG = l.g(f5, 0.0f, this.f16477W);
        int i5 = this.f16477W;
        float f6 = i5 <= 0 ? 0.0f : fG / i5;
        boolean z6 = Math.abs(fG - this.f16476V) > 0.001f;
        this.f16476V = fG;
        this.f16475U = f6;
        if (f6 > 0.0f) {
            this.f16465K0 = 0.0f;
            i iVar = this.f16470N0;
            if (iVar != null) {
                iVar.d();
            }
            this.f16463J0 = 0.0f;
        }
        Y();
        if (z6) {
            requestLayout();
            invalidateOutline();
        }
        if (z5) {
            if (z6 || !this.f16493h0.isEmpty()) {
                Iterator it = C0403n.U(this.f16493h0).iterator();
                while (it.hasNext()) {
                    ((c) it.next()).a(f6);
                }
            }
        }
    }

    private final void n(float f5, boolean z5) {
        int i5 = this.f16499k0 ? this.f16471Q : this.f16468M;
        int i6 = this.f16466L;
        float f6 = i6 == 0 ? 1.0f : i5 / i6;
        float F5 = F(1.0f, f6, f5);
        boolean z6 = getLayoutDirection() == 1;
        this.f16520v.setPivotX(z6 ? r3.getMeasuredWidth() : 0.0f);
        this.f16520v.setPivotY(r3.getHeight() / 2.0f);
        int left = this.f16516t.getLeft() + this.f16518u.getLeft();
        int top = this.f16516t.getTop() + this.f16518u.getTop();
        float f7 = left;
        float left2 = this.f16520v.getLeft() + f7;
        float right = f7 + this.f16520v.getRight();
        float top2 = top + this.f16520v.getTop() + (this.f16520v.getHeight() / 2.0f);
        g gVarO = o(this.f16520v.getMeasuredWidth() * F5);
        float fC = z6 ? gVarO.c() - right : gVarO.b() - left2;
        float fA = gVarO.a() - top2;
        this.f16520v.setScaleX(F5);
        this.f16520v.setScaleY(F5);
        this.f16520v.setTranslationX(fC * f5);
        this.f16520v.setTranslationY((fA * f5) + this.f16463J0);
        this.f16520v.setAlpha(z5 ? 0.0f : 1.0f);
        if (!this.f16451D0 || z5) {
            this.f16520v.setClipBounds(null);
            return;
        }
        ViewGroup centerContainer = this.f16478a.getCenterContainer();
        int titleActionGap = this.f16478a.getTitleActionGap();
        int width = this.f16478a.getStartActionContainer().getWidth();
        int iB = (z6 || centerContainer.getWidth() <= 0) ? Integer.MAX_VALUE : l.b((centerContainer.getLeft() - titleActionGap) - ((this.f16478a.getPaddingLeft() + width) + (width > 0 ? titleActionGap : 0)), 0);
        int measuredWidth = this.f16520v.getMeasuredWidth();
        int i7 = f6 > 0.0f ? (int) (iB / f6) : measuredWidth;
        if (measuredWidth > i7) {
            this.f16520v.setClipBounds(new Rect(0, 0, l.b((int) F(measuredWidth, i7, f5), 0), this.f16520v.getMeasuredHeight()));
        } else {
            this.f16520v.setClipBounds(null);
        }
    }

    private final g o(float f5) {
        float paddingLeft;
        float width;
        boolean z5 = getLayoutDirection() == 1;
        int width2 = this.f16478a.getStartActionContainer().getWidth();
        int width3 = this.f16478a.getEndActionContainer().getWidth();
        int titleActionGap = this.f16478a.getTitleActionGap();
        if (z5) {
            paddingLeft = this.f16478a.getPaddingLeft() + width3 + (width3 > 0 ? titleActionGap : 0);
            width = ((this.f16478a.getWidth() - this.f16478a.getPaddingRight()) - width2) - (width2 > 0 ? titleActionGap : 0);
        } else {
            paddingLeft = this.f16478a.getPaddingLeft() + width2 + (width2 > 0 ? titleActionGap : 0);
            width = ((this.f16478a.getWidth() - this.f16478a.getPaddingRight()) - width3) - (width3 > 0 ? titleActionGap : 0);
        }
        if (this.f16451D0) {
            ViewGroup centerContainer = this.f16478a.getCenterContainer();
            if (centerContainer.getWidth() > 0) {
                float right = z5 ? centerContainer.getRight() + titleActionGap : centerContainer.getLeft() - titleActionGap;
                width = z5 ? Math.max(width, right) : Math.min(width, right);
            }
        }
        float fMax = Math.max(paddingLeft, width - f5);
        if (!this.f16499k0) {
            paddingLeft = l.g((this.f16478a.getWidth() - f5) / 2.0f, paddingLeft, fMax);
        } else if (z5) {
            paddingLeft = fMax;
        }
        return new g(paddingLeft, f5 + paddingLeft, ((this.f16478a.getTop() + this.f16478a.getPaddingTop()) + (this.f16478a.getBottom() - this.f16478a.getPaddingBottom())) / 2.0f);
    }

    private final void q() {
        Runnable runnable = this.f16525x0;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        this.f16525x0 = null;
    }

    private final void r() {
        ValueAnimator valueAnimator = this.f16479a0;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.f16479a0 = null;
    }

    private final void s() {
        removeCallbacks(this.f16514s);
        this.f16510q = false;
    }

    private final void setOverScrollTranslationInternal(float f5) {
        this.f16463J0 = l.a(f5, 0.0f);
        Y();
    }

    private final i t() {
        i iVar = this.f16505n0;
        if (iVar != null) {
            return iVar;
        }
        i iVar2 = new i(this, f16443P0);
        j jVar = new j(0.0f);
        jVar.h(230.0f);
        jVar.f(27.0f / (((float) Math.sqrt(230.0f)) * 2.0f));
        iVar2.x(jVar);
        iVar2.k(0.00390625f);
        this.f16505n0 = iVar2;
        return iVar2;
    }

    private final float u(float f5) {
        return l.g(f5, 0.0f, 1.0f);
    }

    private final Drawable w() {
        int[] iArr = {getResources().getColor(C0846d.f18296c), getResources().getColor(C0846d.f18295b), getResources().getColor(C0846d.f18294a)};
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, iArr);
        gradientDrawable.setColors(iArr, new float[]{0.0f, 0.498546f, 1.0f});
        return gradientDrawable;
    }

    private final int x() {
        return getCollapsedHeight() + C0848a.a((1.0f - this.f16475U) * this.f16448C);
    }

    private final int y() {
        return this.f16452E + (this.f16524x.getVisibility() == 0 ? this.f16454F : 0);
    }

    private final float z(float f5) {
        return TypedValue.applyDimension(1, f5, getResources().getDisplayMetrics());
    }

    public boolean D() {
        return this.f16492h;
    }

    public void G(int i5) {
        if (i5 == 0) {
            J();
        }
    }

    public void J() {
        K(true);
    }

    public void K(boolean z5) {
        this.f16465K0 = 0.0f;
        if (!z5 || this.f16463J0 <= 0.0f || !isAttachedToWindow()) {
            i iVar = this.f16470N0;
            if (iVar != null) {
                iVar.d();
            }
            setOverScrollTranslationInternal(0.0f);
            return;
        }
        i iVar2 = this.f16470N0;
        if (iVar2 == null) {
            iVar2 = new i(this, null);
            j jVar = new j(0.0f);
            jVar.f(0.78f);
            jVar.h(380.0f);
            iVar2.x(jVar);
            this.f16470N0 = iVar2;
        }
        iVar2.d();
        iVar2.m(this.f16463J0);
        iVar2.s(0.0f);
    }

    public void N(int i5, int i6) {
        r();
        q();
        this.f16477W = Math.max(1, i6);
        m(l.h(i5, 0, r4), true);
    }

    public void O(View view, float f5, int i5, int i6, boolean z5) {
        View view2 = this.f16445A0;
        if (view2 != null) {
            removeView(view2);
        }
        this.f16445A0 = null;
        if (view != null) {
            if (view.getParent() != null) {
                throw new IllegalStateException("The tab view already has a parent");
            }
            this.f16447B0 = l.g(f5, 0.0f, 1.0f);
            this.f16449C0 = z5;
            this.f16445A0 = view;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
            if (layoutParams2 == null) {
                layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            }
            layoutParams2.gravity = 8388691;
            layoutParams2.setMarginStart(i5);
            layoutParams2.bottomMargin = i6;
            addView(view, indexOfChild(this.f16478a), layoutParams2);
        }
        requestLayout();
        Y();
    }

    public void P(boolean z5) {
        if (this.f16515s0) {
            float f5 = this.f16475U >= 0.5f ? 1.0f : 0.0f;
            if (z5) {
                i(f5);
            } else {
                setCollapseProgress(f5);
            }
        }
    }

    public void R() {
        RecyclerView.OnScrollListener onScrollListener;
        View view = this.f16481b0;
        ViewTreeObserver.OnScrollChangedListener onScrollChangedListener = this.f16483c0;
        if (view != null && onScrollChangedListener != null) {
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (!viewTreeObserver.isAlive()) {
                viewTreeObserver = null;
            }
            if (viewTreeObserver == null && ((viewTreeObserver = this.f16485d0) == null || !viewTreeObserver.isAlive())) {
                viewTreeObserver = null;
            }
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnScrollChangedListener(onScrollChangedListener);
            }
        }
        if ((view instanceof RecyclerView) && (onScrollListener = this.f16487e0) != null) {
            ((RecyclerView) view).removeOnScrollListener(onScrollListener);
        }
        q();
        this.f16481b0 = null;
        this.f16483c0 = null;
        this.f16487e0 = null;
        this.f16489f0 = 0;
        this.f16485d0 = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        k.g(canvas, "canvas");
        if (this.f16510q) {
            A(canvas);
        }
        super.dispatchDraw(canvas);
    }

    public StepOSTitleBar getActionBar() {
        return this.f16478a;
    }

    public float getActionLayerAlpha() {
        return this.f16507o0;
    }

    public long getAnimationDuration() {
        return this.f16473S;
    }

    public Integer getBackdropGradientEndColor() {
        return this.f16500l;
    }

    public Integer getBackdropGradientMiddleColor() {
        return this.f16498k;
    }

    public Integer getBackdropGradientStartColor() {
        return this.f16496j;
    }

    public int getBackdropScrimColor() {
        Integer num = this.f16494i;
        return num != null ? num.intValue() : getResources().getColor(C0846d.f18291A);
    }

    public View getBoundScrollableView() {
        return this.f16481b0;
    }

    public ViewGroup getCenterContainer() {
        return this.f16478a.getCenterContainer();
    }

    public View getCenterView() {
        return this.f16478a.getCenterView();
    }

    public float getCollapseProgress() {
        return this.f16475U;
    }

    public int getCollapsedHeight() {
        return this.f16446B + B();
    }

    public TextView getCollapsedTitleView() {
        return this.f16444A;
    }

    public LinearLayout getEndActionContainer() {
        return this.f16478a.getEndActionContainer();
    }

    public int getExpandRange() {
        return this.f16477W;
    }

    public int getExpandedHeight() {
        return this.f16446B + this.f16448C + B();
    }

    public float getExpandedTitleTranslationRatio() {
        return this.f16513r0;
    }

    public TextView getExpandedTitleView() {
        return this.f16520v;
    }

    public int getGlassActiveCount() {
        return this.f16478a.getGlassActiveCount();
    }

    public Set<String> getGlassActiveIds() {
        return this.f16478a.getGlassActiveIds();
    }

    public o getGlassEffect() {
        return this.f16478a.getGlassEffect();
    }

    public StepOSTitleBar.b getGlassRenderMode() {
        return this.f16478a.getGlassRenderMode();
    }

    public LinearLayout getLeftActionContainer() {
        return this.f16478a.getLeftActionContainer();
    }

    public View getMultiChoiceView() {
        return this.f16457G0;
    }

    public float getOverScrollTranslationY() {
        return this.f16463J0;
    }

    public LinearLayout getRightActionContainer() {
        return this.f16478a.getRightActionContainer();
    }

    public int getScrollOffset() {
        return C0848a.a(this.f16476V);
    }

    public long getSnapDelay() {
        return this.f16517t0;
    }

    public ViewGroup getSpringLayoutMiddle() {
        return this.f16453E0;
    }

    public ViewGroup getSpringLayoutQuick() {
        return this.f16455F0;
    }

    public LinearLayout getStartActionContainer() {
        return this.f16478a.getStartActionContainer();
    }

    public CharSequence getSubtitle() {
        CharSequence text = this.f16526y.getText();
        k.f(text, "getText(...)");
        return text;
    }

    public FrameLayout getSubtitleIconContainer() {
        return this.f16528z;
    }

    public float getTabCollapseScale() {
        return this.f16447B0;
    }

    public View getTabView() {
        return this.f16445A0;
    }

    public CharSequence getTitle() {
        CharSequence text = this.f16520v.getText();
        k.f(text, "getText(...)");
        return text;
    }

    public int getTitleTextColor() {
        return this.f16497j0;
    }

    public int getTopInset() {
        return this.f16527y0;
    }

    public void i(float f5) {
        g(u(f5) * this.f16477W);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        H.g0(this);
        if (this.f16492h) {
            I();
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        k.g(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        if (!this.f16492h) {
            this.f16480b.setBackground(w());
        }
        if (this.f16492h) {
            I();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        R();
        r();
        q();
        K(false);
        i iVar = this.f16470N0;
        if (iVar != null) {
            iVar.d();
        }
        i iVar2 = this.f16505n0;
        if (iVar2 != null) {
            iVar2.d();
        }
        this.f16505n0 = null;
        this.f16493h0.clear();
        removeCallbacks(this.f16504n);
        this.f16502m = false;
        removeCallbacks(this.f16506o);
        this.f16508p = false;
        H(false);
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i5, int i6, int i7, int i8) {
        super.onLayout(z5, i5, i6, i7, i8);
        Y();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i5, int i6) {
        int iMax;
        int iX = x();
        if (getLayoutParams() != null && getLayoutParams().height != -2 && (!this.f16523w0 || !this.f16529z0)) {
            iX = View.resolveSize(iX, i6);
        }
        int i7 = this.f16522w.getVisibility() == 0 ? this.f16458H : this.f16460I;
        if (this.f16516t.getPaddingStart() != this.f16458H || this.f16516t.getPaddingEnd() != i7) {
            this.f16516t.setPaddingRelative(this.f16458H, 0, i7, 0);
        }
        if (View.MeasureSpec.getMode(i5) == 0) {
            iMax = Integer.MAX_VALUE;
        } else {
            iMax = Math.max(0, ((View.MeasureSpec.getSize(i5) - this.f16458H) - i7) - (this.f16522w.getVisibility() == 0 ? this.f16472R : 0));
        }
        this.f16520v.setMaxWidth(iMax);
        V(iX);
        super.onMeasure(i5, View.MeasureSpec.makeMeasureSpec(iX, 1073741824));
        V(iX);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof f)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        f fVar = (f) parcelable;
        super.onRestoreInstanceState(fVar.getSuperState());
        this.f16477W = Math.max(1, fVar.c());
        m(u(fVar.a()) * this.f16477W, false);
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i5) {
        super.onRtlPropertiesChanged(i5);
        if (this.f16490g) {
            requestLayout();
            Y();
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        f fVar = new f(super.onSaveInstanceState());
        fVar.f(this.f16475U);
        fVar.A(this.f16477W);
        return fVar;
    }

    public boolean p(int i5) {
        if (this.f16519u0 && i5 != 0) {
            if (i5 > 0) {
                return this.f16476V < ((float) this.f16477W);
            }
            if (this.f16476V > 0.0f) {
                return true;
            }
        }
        return false;
    }

    public void setActionBarCanScroll(boolean z5) {
        this.f16519u0 = z5;
        this.f16469M0 = z5;
        if (z5) {
            return;
        }
        q();
    }

    public void setActionLayerAlpha(float f5) {
        this.f16507o0 = l.g(f5, 0.0f, 1.0f);
        Y();
    }

    public void setActionLayerEnabled(boolean z5) {
        this.f16509p0 = z5;
        k(this, false, 1, null);
    }

    public void setAnimationDuration(long j5) {
        this.f16473S = l.c(j5, 0L);
    }

    public void setArrowVisible(boolean z5) {
        this.f16522w.setVisibility(z5 ? 0 : 8);
    }

    public void setAutoActionAlpha(boolean z5) {
        if (this.f16511q0 != z5) {
            this.f16511q0 = z5;
            Y();
        }
    }

    public void setAutoSnapBoundScrollable(boolean z5) {
        this.f16491g0 = z5;
    }

    public void setBackdropBlurEnabled(boolean z5) {
        if (this.f16492h == z5) {
            return;
        }
        this.f16492h = z5;
        if (z5) {
            I();
        } else {
            H(true);
        }
        Y();
    }

    public void setBackdropGradientEndColor(Integer num) {
        if (k.b(this.f16500l, num)) {
            return;
        }
        this.f16500l = num;
        I();
    }

    public void setBackdropGradientEndColorResource(int i5) {
        setBackdropGradientEndColor(Integer.valueOf(i5 == 0 ? 0 : getContext().getColor(i5)));
    }

    public void setBackdropGradientMiddleColor(Integer num) {
        if (k.b(this.f16498k, num)) {
            return;
        }
        this.f16498k = num;
        I();
    }

    public void setBackdropGradientMiddleColorResource(int i5) {
        setBackdropGradientMiddleColor(Integer.valueOf(i5 == 0 ? 0 : getContext().getColor(i5)));
    }

    public void setBackdropGradientStartColor(Integer num) {
        if (k.b(this.f16496j, num)) {
            return;
        }
        this.f16496j = num;
        I();
    }

    public void setBackdropGradientStartColorResource(int i5) {
        setBackdropGradientStartColor(Integer.valueOf(i5 == 0 ? 0 : getContext().getColor(i5)));
    }

    public void setBackdropScrimColor(int i5) {
        Integer num = this.f16494i;
        if (num != null && num.intValue() == i5) {
            return;
        }
        this.f16494i = Integer.valueOf(i5);
        I();
    }

    public void setBackdropScrimColorResource(int i5) {
        setBackdropScrimColor(getContext().getColor(i5));
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (!this.f16490g || this.f16488f) {
            super.setBackground(drawable);
            return;
        }
        this.f16486e = drawable;
        C1009e c1009e = this.f16484d;
        if (c1009e == null) {
            k.t("backdropGlassDelegate");
            c1009e = null;
        }
        if (c1009e.l()) {
            return;
        }
        super.setBackground(drawable);
    }

    public void setBlurBackground(Drawable drawable) {
        View view = this.f16480b;
        if (drawable == null) {
            drawable = w();
        }
        view.setBackground(drawable);
    }

    public void setBlurEnabled(boolean z5) {
        this.f16474T = z5;
        Y();
    }

    public void setCenterView(View view) {
        this.f16478a.setCenterView(view);
        this.f16451D0 = view != null;
        U();
    }

    public void setCollapseProgress(float f5) {
        r();
        q();
        m(u(f5) * this.f16477W, true);
    }

    public void setDragEnabled(boolean z5) {
        this.f16521v0 = z5;
    }

    public void setExpandedTitleTranslationRatio(float f5) {
        this.f16513r0 = l.a(f5, 0.0f);
        Y();
    }

    public void setGlassCrossWindow(boolean z5) {
        this.f16478a.setGlassCrossWindow(z5);
    }

    public void setGlassEffect(o oVar) {
        k.g(oVar, "effect");
        this.f16478a.setGlassEffect(oVar);
    }

    public void setGlassEnabled(boolean z5) {
        this.f16478a.setGlassEnabled(z5);
    }

    public void setIncludeTopInset(boolean z5) {
        if (this.f16523w0 != z5) {
            this.f16523w0 = z5;
            W(this, 0, 1, null);
            requestLayout();
        }
    }

    public void setIndividualActionGlassEnabled(boolean z5) {
        this.f16478a.setIndividualActionGlassEnabled(z5);
    }

    public void setMultiChoiceAnimationDuration(long j5) {
        this.f16461I0 = l.c(j5, 0L);
    }

    public void setMultiChoiceView(View view) {
        View view2 = this.f16457G0;
        if (view2 != null) {
            removeView(view2);
        }
        this.f16457G0 = null;
        if (view != null) {
            if (view.getParent() != null) {
                throw new IllegalStateException("The multi-choice view already has a parent");
            }
            this.f16457G0 = view;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
            if (layoutParams2 == null) {
                layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams2.gravity = 8388659;
            layoutParams2.topMargin = B() + this.f16462J;
            layoutParams2.bottomMargin = this.f16464K;
            addView(view, layoutParams2);
            view.setVisibility(this.f16459H0 ? 0 : 8);
            view.setAlpha(this.f16459H0 ? 1.0f : 0.0f);
        }
        requestLayout();
        Y();
    }

    public void setNestedScrollEnabled(boolean z5) {
        this.f16519u0 = z5;
    }

    public void setOnCollapseProgressListener(c cVar) {
        this.f16493h0.clear();
        if (cVar != null) {
            this.f16493h0.add(cVar);
        }
    }

    public void setOnOffsetChangedListener(d dVar) {
    }

    public void setOverScrollEnabled(boolean z5) {
        this.f16469M0 = z5;
        if (z5) {
            return;
        }
        J();
    }

    public void setOverScrollTranslationY(float f5) {
        if (!this.f16469M0 || this.f16476V > 0.0f) {
            return;
        }
        i iVar = this.f16470N0;
        if (iVar != null) {
            iVar.d();
        }
        setOverScrollTranslationInternal(l.d(l.a(f5, 0.0f), Math.max(this.f16446B, 1.0f)));
    }

    public void setScrollRange(int i5) {
        this.f16450D = false;
        int iMax = Math.max(1, i5);
        this.f16477W = iMax;
        m(this.f16475U * iMax, true);
    }

    public void setSnapDelay(long j5) {
        this.f16517t0 = l.c(j5, 0L);
    }

    public void setSnapEnabled(boolean z5) {
        this.f16515s0 = z5;
        if (z5) {
            return;
        }
        q();
    }

    public void setSpringLayoutVisibility(boolean z5) {
        int i5 = z5 ? 0 : 8;
        this.f16453E0.setVisibility(i5);
        this.f16455F0.setVisibility(i5);
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f16526y.setText(charSequence);
        S();
        requestLayout();
        Y();
    }

    public void setSubtitleVisible(boolean z5) {
        this.f16456G = true;
        this.f16524x.setVisibility(z5 ? 0 : 8);
        if (this.f16450D) {
            int iY = y();
            this.f16448C = iY;
            int iMax = Math.max(1, iY);
            this.f16477W = iMax;
            m(this.f16475U * iMax, false);
        }
        requestLayout();
        Y();
    }

    public void setTabCollapseScale(float f5) {
        this.f16447B0 = l.g(f5, 0.0f, 1.0f);
        Y();
    }

    public void setTabReplacesTitle(boolean z5) {
        this.f16449C0 = z5;
        Y();
    }

    public void setTabView(View view) {
        O(view, 0.73f, 0, 0, true);
    }

    public void setTitle(CharSequence charSequence) {
        this.f16520v.setText(charSequence);
        this.f16444A.setText(charSequence);
        setContentDescription(charSequence);
        requestLayout();
        Y();
    }

    public void setTitleTextColor(int i5) {
        this.f16497j0 = i5;
        this.f16520v.setTextColor(i5);
        this.f16444A.setTextColor(i5);
        Y();
    }

    public int v(int i5) {
        if (!this.f16519u0) {
            return 0;
        }
        int iA = C0848a.a(this.f16476V);
        int iH = l.h(i5 + iA, 0, this.f16477W);
        int i6 = iH - iA;
        if (i6 != 0) {
            m(iH, true);
        }
        return i6;
    }

    public void setSubtitle(int i5) {
        setSubtitle(getResources().getText(i5));
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(this.f16497j0);
            k.f(colorStateList, "valueOf(...)");
        }
        this.f16520v.setTextColor(colorStateList);
        this.f16444A.setTextColor(colorStateList);
        this.f16497j0 = colorStateList.getDefaultColor();
        Y();
    }

    public void setTitle(int i5) {
        setTitle(getResources().getText(i5));
    }
}
