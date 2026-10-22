package com.stepos.widget.toolbar;

import K2.A;
import K2.F;
import K2.o;
import M2.C;
import V3.v;
import W3.C0403n;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import b4.C0567b;
import b4.InterfaceC0566a;
import com.stepos.widget.toolbar.StepOSTitleBar;
import i4.InterfaceC0772l;
import j4.g;
import j4.k;
import j4.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.ranges.l;
import l3.C0844b;
import l3.C0846d;
import l3.C0847e;
import l3.h;
import l3.m;
import l4.C0848a;
import r3.C1003H;
import r3.C1009e;
import r3.C1010f;
import r3.InterfaceC1005a;
import r3.n;
import s3.f;

/* loaded from: classes.dex */
public class StepOSTitleBar extends FrameLayout {

    /* renamed from: g0, reason: collision with root package name */
    public static final a f16383g0 = new a(null);

    /* renamed from: A, reason: collision with root package name */
    private Drawable f16384A;

    /* renamed from: B, reason: collision with root package name */
    private boolean f16385B;

    /* renamed from: C, reason: collision with root package name */
    private boolean f16386C;

    /* renamed from: D, reason: collision with root package name */
    private View f16387D;

    /* renamed from: E, reason: collision with root package name */
    private boolean f16388E;

    /* renamed from: F, reason: collision with root package name */
    private boolean f16389F;

    /* renamed from: G, reason: collision with root package name */
    private o f16390G;

    /* renamed from: H, reason: collision with root package name */
    private InterfaceC1005a f16391H;

    /* renamed from: I, reason: collision with root package name */
    private boolean f16392I;

    /* renamed from: J, reason: collision with root package name */
    private float f16393J;

    /* renamed from: K, reason: collision with root package name */
    private boolean f16394K;

    /* renamed from: L, reason: collision with root package name */
    private int f16395L;

    /* renamed from: M, reason: collision with root package name */
    private float f16396M;

    /* renamed from: Q, reason: collision with root package name */
    private boolean f16397Q;

    /* renamed from: R, reason: collision with root package name */
    private boolean f16398R;

    /* renamed from: S, reason: collision with root package name */
    private boolean f16399S;

    /* renamed from: T, reason: collision with root package name */
    private Integer f16400T;

    /* renamed from: U, reason: collision with root package name */
    private Integer f16401U;

    /* renamed from: V, reason: collision with root package name */
    private Integer f16402V;

    /* renamed from: W, reason: collision with root package name */
    private Integer f16403W;

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f16404a;

    /* renamed from: a0, reason: collision with root package name */
    private final C1009e f16405a0;

    /* renamed from: b, reason: collision with root package name */
    private final LinearLayout f16406b;

    /* renamed from: b0, reason: collision with root package name */
    private Drawable f16407b0;

    /* renamed from: c, reason: collision with root package name */
    private final FrameLayout f16408c;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f16409c0;

    /* renamed from: d, reason: collision with root package name */
    private final TextView f16410d;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f16411d0;

    /* renamed from: e, reason: collision with root package name */
    private final TextView f16412e;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f16413e0;

    /* renamed from: f, reason: collision with root package name */
    private final LinearLayout f16414f;

    /* renamed from: f0, reason: collision with root package name */
    private final Runnable f16415f0;

    /* renamed from: g, reason: collision with root package name */
    private final ArrayList<ImageButton> f16416g;

    /* renamed from: h, reason: collision with root package name */
    private final ArrayList<ImageButton> f16417h;

    /* renamed from: i, reason: collision with root package name */
    private final ArrayList<LinearLayout> f16418i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f16419j;

    /* renamed from: k, reason: collision with root package name */
    private int f16420k;

    /* renamed from: l, reason: collision with root package name */
    private int f16421l;

    /* renamed from: m, reason: collision with root package name */
    private int f16422m;

    /* renamed from: n, reason: collision with root package name */
    private int f16423n;

    /* renamed from: o, reason: collision with root package name */
    private int f16424o;

    /* renamed from: p, reason: collision with root package name */
    private int f16425p;

    /* renamed from: q, reason: collision with root package name */
    private int f16426q;

    /* renamed from: r, reason: collision with root package name */
    private int f16427r;

    /* renamed from: s, reason: collision with root package name */
    private int f16428s;

    /* renamed from: t, reason: collision with root package name */
    private int f16429t;

    /* renamed from: u, reason: collision with root package name */
    private int f16430u;

    /* renamed from: v, reason: collision with root package name */
    private int f16431v;

    /* renamed from: w, reason: collision with root package name */
    private int f16432w;

    /* renamed from: x, reason: collision with root package name */
    private float f16433x;

    /* renamed from: y, reason: collision with root package name */
    private float f16434y;

    /* renamed from: z, reason: collision with root package name */
    private Drawable f16435z;

    public static final class a {
        public /* synthetic */ a(g gVar) {
            this();
        }

        private a() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final b f16436a = new b("DISABLED", 0);

        /* renamed from: b, reason: collision with root package name */
        public static final b f16437b = new b("PENDING", 1);

        /* renamed from: c, reason: collision with root package name */
        public static final b f16438c = new b("MOTION_KIT", 2);

        /* renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ b[] f16439d;

        /* renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ InterfaceC0566a f16440e;

        static {
            b[] bVarArrB = b();
            f16439d = bVarArrB;
            f16440e = C0567b.a(bVarArrB);
        }

        private b(String str, int i5) {
        }

        private static final /* synthetic */ b[] b() {
            return new b[]{f16436a, f16437b, f16438c};
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) f16439d.clone();
        }
    }

    public static final class c extends LinearLayout {
        c(Context context) {
            super(context);
        }

        @Override // android.view.ViewGroup
        public void onViewRemoved(View view) {
            k.g(view, "child");
            super.onViewRemoved(view);
            z.a(StepOSTitleBar.this.f16416g).remove(view);
            z.a(StepOSTitleBar.this.f16417h).remove(view);
            if (view instanceof LinearLayout) {
                StepOSTitleBar.this.f16418i.remove(view);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSTitleBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        k.g(context, "context");
    }

    private final Drawable A() {
        Drawable drawableW = w(this.f16384A);
        boolean z5 = drawableW instanceof ColorDrawable;
        Drawable drawable = drawableW;
        if (z5) {
            return B(((ColorDrawable) drawableW).getColor(), G());
        }
        if (drawableW == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(getResources().getColor((!this.f16388E || this.f16386C) ? C0846d.f18318y : C0846d.f18293C));
            gradientDrawable.setCornerRadius(G());
            drawable = gradientDrawable;
        }
        return drawable;
    }

    private final Drawable B(int i5, float f5) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i5);
        gradientDrawable.setCornerRadius(f5);
        return gradientDrawable;
    }

    private final InterfaceC1005a C() {
        return (getResources().getConfiguration().uiMode & 48) == 32 ? C1003H.f20004a.B(getResources().getDisplayMetrics().density) : C1003H.f20004a.A(getResources().getDisplayMetrics().density);
    }

    private final int D(int i5) {
        return getResources().getDimensionPixelSize(i5);
    }

    private final Drawable E(TypedArray typedArray, int i5) {
        if (!typedArray.hasValue(i5)) {
            return null;
        }
        Drawable drawable = typedArray.getDrawable(i5);
        return drawable == null ? new ColorDrawable(typedArray.getColor(i5, 0)) : drawable;
    }

    private final float F() {
        float f5 = this.f16433x;
        return f5 > 0.0f ? f5 : this.f16424o / 2.0f;
    }

    private final float G() {
        float f5 = this.f16434y;
        return f5 > 0.0f ? f5 : this.f16424o / 2.0f;
    }

    private final boolean H(View view, ViewGroup viewGroup) {
        while (view != null) {
            if (view == viewGroup) {
                return true;
            }
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return false;
    }

    private final void I(View view, int i5, int i6, int i7, Float f5) {
        int paddingTop = f5 == null ? getPaddingTop() + ((i7 - view.getMeasuredHeight()) / 2) : Math.round(f5.floatValue() - (view.getMeasuredHeight() / 2.0f));
        view.layout(i5, paddingTop, i6, view.getMeasuredHeight() + paddingTop);
    }

    private final void J(boolean z5) {
        this.f16405a0.m();
        if (z5) {
            this.f16409c0 = true;
            try {
                super.setBackground(this.f16407b0);
            } finally {
                this.f16409c0 = false;
            }
        }
    }

    private final void K() {
        if (this.f16399S && isAttachedToWindow() && !this.f16413e0) {
            this.f16413e0 = true;
            post(this.f16415f0);
        }
    }

    private final int L(Integer num, int i5, int i6) {
        return num != null ? num.intValue() : W(i5, ((i6 >>> 24) & 255) / 255.0f);
    }

    private final int M(int i5, int i6) {
        TypedValue typedValue = new TypedValue();
        if (getContext().getTheme().resolveAttribute(i5, typedValue, true)) {
            int i7 = typedValue.type;
            if (28 <= i7 && i7 < 32) {
                return typedValue.data;
            }
            if (typedValue.resourceId != 0) {
                try {
                    return getResources().getColor(typedValue.resourceId);
                } catch (RuntimeException unused) {
                }
            }
        }
        return i6;
    }

    private final void N(ImageButton imageButton) {
        boolean z5 = imageButton instanceof n;
        n nVar = z5 ? (n) imageButton : null;
        if (nVar != null) {
            nVar.setSurfaceDrawable((this.f16388E && this.f16397Q) ? null : x());
        }
        f.e(f.f20267a, imageButton, getContext().getColor(C0846d.f18319z), Math.max(0.0f, F()), false, false, F(), 8, null);
        n nVar2 = z5 ? (n) imageButton : null;
        if (nVar2 != null) {
            nVar2.setPressScaleEnabled(this.f16398R);
        }
    }

    private final void O(ImageButton imageButton) {
        ViewGroup.LayoutParams layoutParams = imageButton.getLayoutParams();
        if (layoutParams == null) {
            int i5 = this.f16424o;
            layoutParams = new LinearLayout.LayoutParams(i5, i5);
        }
        int i6 = this.f16424o;
        layoutParams.width = i6;
        layoutParams.height = i6;
        imageButton.setLayoutParams(layoutParams);
        P(imageButton);
        N(imageButton);
    }

    private final void P(ImageButton imageButton) {
        int iMax = Math.max(0, (this.f16424o - this.f16425p) / 2);
        imageButton.setPadding(iMax, iMax, iMax, iMax);
        imageButton.setMinimumWidth(this.f16424o);
        imageButton.setMinimumHeight(this.f16424o);
    }

    private final void Q(LinearLayout linearLayout) {
        int childCount = linearLayout.getChildCount();
        int i5 = 0;
        while (i5 < childCount) {
            View childAt = linearLayout.getChildAt(i5);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams).setMarginStart(i5 == 0 ? 0 : this.f16426q);
                childAt.setLayoutParams(layoutParams);
            }
            i5++;
        }
    }

    private final void R(LinearLayout linearLayout) {
        int childCount = linearLayout.getChildCount();
        int i5 = 0;
        while (i5 < childCount) {
            View childAt = linearLayout.getChildAt(i5);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                layoutParams2.setMarginStart(i5 == 0 ? 0 : this.f16427r);
                int i6 = this.f16425p;
                layoutParams2.width = i6;
                layoutParams2.height = i6;
                childAt.setLayoutParams(layoutParams);
            }
            i5++;
        }
    }

    private final void S(LinearLayout linearLayout) {
        r3.o oVar = linearLayout instanceof r3.o ? (r3.o) linearLayout : null;
        if (oVar != null) {
            oVar.setSurfaceDrawable(this.f16388E ? null : A());
        }
        if (k.b(linearLayout.getTag(h.f18420L), Boolean.TRUE)) {
            f.g(f.f20267a, linearLayout, getContext().getColor(C0846d.f18319z), Math.max(0.0f, G()), false, this.f16398R, G(), 8, null);
        } else {
            r(linearLayout, G());
        }
    }

    private final void T(ImageButton imageButton) {
        ViewGroup.LayoutParams layoutParams = imageButton.getLayoutParams();
        if (layoutParams == null) {
            int i5 = this.f16425p;
            layoutParams = new LinearLayout.LayoutParams(i5, i5);
        }
        int i6 = this.f16425p;
        layoutParams.width = i6;
        layoutParams.height = i6;
        imageButton.setLayoutParams(layoutParams);
        imageButton.setPadding(0, 0, 0, 0);
        imageButton.setBackground(null);
        imageButton.setForeground(null);
        imageButton.setClipToOutline(false);
    }

    private final void U() {
        int i5 = this.f16420k == 1 ? 17 : 8388627;
        this.f16410d.setGravity(i5);
        this.f16412e.setGravity(i5);
    }

    private final int V(View view) {
        if (view.getVisibility() == 8) {
            return 0;
        }
        return view.getMeasuredWidth();
    }

    private final int W(int i5, float f5) {
        return Color.argb(C0848a.a(l.g(f5, 0.0f, 1.0f) * 255.0f), Color.red(i5), Color.green(i5), Color.blue(i5));
    }

    private final LinearLayout g(int i5) {
        if (i5 == 0) {
            return this.f16404a;
        }
        if (i5 == 1) {
            return this.f16406b;
        }
        throw new IllegalArgumentException("Unsupported side: " + i5);
    }

    private final void l(LinearLayout linearLayout, View view) {
        LinearLayout.LayoutParams layoutParams;
        if (view == null) {
            throw new IllegalArgumentException("view must not be null");
        }
        if (view.getParent() != null) {
            throw new IllegalStateException("The action view already has a parent");
        }
        if (view.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            k.e(layoutParams2, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            layoutParams = (LinearLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        layoutParams.setMarginStart(linearLayout.getChildCount() == 0 ? 0 : this.f16426q);
        linearLayout.addView(view, layoutParams);
        Q(linearLayout);
        if (!this.f16419j) {
            n(view);
        }
        requestLayout();
    }

    private final void m() {
        n(this.f16404a);
        n(this.f16406b);
    }

    private final void n(View view) {
        view.setEnabled(this.f16419j);
        if ((view instanceof TextView) && !(view instanceof Button) && !(view instanceof CompoundButton)) {
            ((TextView) view).setAlpha(this.f16419j ? 1.0f : 0.3f);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = viewGroup.getChildAt(i5);
                k.f(childAt, "getChildAt(...)");
                n(childAt);
            }
        }
    }

    private final void o() throws Resources.NotFoundException {
        if (!this.f16399S || getWidth() <= 0 || getHeight() <= 0) {
            J(true);
            return;
        }
        final float dimension = getResources().getDimension(C0847e.f18373n0);
        this.f16409c0 = true;
        try {
            super.setBackground(null);
            this.f16409c0 = false;
            final int backdropScrimColor = getBackdropScrimColor();
            if (!this.f16405a0.h(0, 0.0f, new InterfaceC0772l() { // from class: w3.f
                @Override // i4.InterfaceC0772l
                public final Object invoke(Object obj) {
                    return StepOSTitleBar.p(dimension, this, backdropScrimColor, (A) obj);
                }
            })) {
                this.f16409c0 = true;
                try {
                    super.setBackground(this.f16407b0);
                } finally {
                }
            }
            invalidate();
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final A p(final float f5, final StepOSTitleBar stepOSTitleBar, final int i5, A a6) {
        k.g(a6, "builder");
        return a6.i(F.a.f3610a.g(), new InterfaceC0772l() { // from class: w3.g
            @Override // i4.InterfaceC0772l
            public final Object invoke(Object obj) {
                return StepOSTitleBar.q(f5, stepOSTitleBar, i5, (C) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final v q(float f5, StepOSTitleBar stepOSTitleBar, int i5, C c6) {
        k.g(c6, "$this$apply");
        c6.n(f5);
        int iW = c6.w();
        int iV = c6.v();
        int iT = c6.t();
        c6.D(stepOSTitleBar.L(stepOSTitleBar.f16401U, i5, iW));
        c6.C(stepOSTitleBar.L(stepOSTitleBar.f16402V, i5, iV));
        c6.A(stepOSTitleBar.L(stepOSTitleBar.f16403W, i5, iT));
        return v.f5542a;
    }

    private final void r(View view, float f5) {
        f.e(f.f20267a, view, getContext().getColor(C0846d.f18319z), Math.max(0.0f, f5), false, this.f16398R, f5, 8, null);
    }

    private final void s() {
        TextView textView = this.f16410d;
        int i5 = this.f16395L;
        textView.setTextSize(0, i5 > 0 ? i5 : this.f16393J);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(StepOSTitleBar stepOSTitleBar) throws Resources.NotFoundException {
        stepOSTitleBar.f16413e0 = false;
        if (stepOSTitleBar.isAttachedToWindow()) {
            stepOSTitleBar.o();
        }
    }

    private final Drawable w(Drawable drawable) {
        Drawable drawableNewDrawable;
        Drawable drawableMutate;
        if (drawable == null) {
            return null;
        }
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState != null && (drawableNewDrawable = constantState.newDrawable(getResources())) != null && (drawableMutate = drawableNewDrawable.mutate()) != null) {
            return drawableMutate;
        }
        Drawable drawableMutate2 = drawable.mutate();
        k.f(drawableMutate2, "mutate(...)");
        return drawableMutate2;
    }

    private final Drawable x() {
        Drawable drawableW = w(this.f16435z);
        if (drawableW instanceof ColorDrawable) {
            return B(((ColorDrawable) drawableW).getColor(), F());
        }
        if (drawableW != null) {
            return drawableW;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(F());
        return gradientDrawable;
    }

    private final LinearLayout y(int i5) {
        c cVar = new c(getContext());
        cVar.setId(i5);
        cVar.setOrientation(0);
        cVar.setGravity(16);
        cVar.setClipChildren(false);
        cVar.setClipToPadding(false);
        return cVar;
    }

    private final ImageButton z(Drawable drawable, CharSequence charSequence, View.OnClickListener onClickListener, boolean z5) {
        Context context = getContext();
        k.f(context, "getContext(...)");
        n nVar = new n(context, null, 0, 0, 14, null);
        nVar.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        nVar.setImageDrawable(w(drawable));
        nVar.setContentDescription(charSequence);
        nVar.setClickable(true);
        nVar.setFocusable(true);
        nVar.setOnClickListener(onClickListener);
        nVar.setGlassCrossWindow(this.f16389F);
        nVar.setGlassEffect(this.f16390G);
        if (z5) {
            nVar.setGlassEnabled(false);
            nVar.setPadding(0, 0, 0, 0);
            nVar.setSurfaceDrawable(null);
            nVar.setPressScaleEnabled(false);
            nVar.setForeground(null);
            nVar.setClipToOutline(false);
            return nVar;
        }
        nVar.setGlassEnabled(this.f16388E && this.f16397Q);
        nVar.setGlassCornerRadius(this.f16433x);
        InterfaceC1005a interfaceC1005a = this.f16391H;
        if (interfaceC1005a != null) {
            nVar.d(interfaceC1005a);
        }
        nVar.setPressScaleEnabled(this.f16398R);
        P(nVar);
        N(nVar);
        return nVar;
    }

    public Drawable getActionBackground() {
        return w(this.f16435z);
    }

    public float getActionCornerRadius() {
        return this.f16433x;
    }

    public int getActionSize() {
        return this.f16424o;
    }

    public int getActionSpacing() {
        return this.f16426q;
    }

    public Integer getBackdropGradientEndColor() {
        return this.f16403W;
    }

    public Integer getBackdropGradientMiddleColor() {
        return this.f16402V;
    }

    public Integer getBackdropGradientStartColor() {
        return this.f16401U;
    }

    public int getBackdropScrimColor() {
        Integer num = this.f16400T;
        return num != null ? num.intValue() : getResources().getColor(C0846d.f18291A);
    }

    public int getBottomPadding() {
        return this.f16423n;
    }

    public ViewGroup getCenterContainer() {
        return this.f16408c;
    }

    public View getCenterView() {
        View view = this.f16387D;
        return view == null ? this.f16414f : view;
    }

    public LinearLayout getEndActionContainer() {
        return this.f16406b;
    }

    public int getGlassActiveCount() {
        return getGlassActiveIds().size();
    }

    public Set<String> getGlassActiveIds() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (View view : C0403n.M(this.f16397Q ? this.f16416g : C0403n.h(), this.f16418i)) {
            if (view instanceof n) {
                linkedHashSet.addAll(((n) view).getGlassActiveIds());
            } else if (view instanceof r3.o) {
                linkedHashSet.addAll(((r3.o) view).getGlassActiveIds());
            }
        }
        return linkedHashSet;
    }

    public o getGlassEffect() {
        return this.f16390G;
    }

    public b getGlassRenderMode() {
        if (!this.f16388E) {
            return b.f16436a;
        }
        List listM = C0403n.M(this.f16397Q ? this.f16416g : C0403n.h(), this.f16418i);
        if (listM.isEmpty()) {
            return b.f16437b;
        }
        boolean z5 = true;
        if (!listM.isEmpty()) {
            Iterator it = listM.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                View view = (View) it.next();
                if (!(view instanceof n ? ((n) view).k() : view instanceof r3.o ? ((r3.o) view).c() : false)) {
                    z5 = false;
                    break;
                }
            }
        }
        return z5 ? b.f16438c : b.f16437b;
    }

    public Drawable getGroupBackground() {
        return w(this.f16384A);
    }

    public float getGroupCornerRadius() {
        return this.f16434y;
    }

    public int getGroupPadding() {
        return this.f16429t;
    }

    public int getGroupSpacing() {
        return this.f16427r;
    }

    public int getIconSize() {
        return this.f16425p;
    }

    public LinearLayout getLeftActionContainer() {
        return this.f16404a;
    }

    public LinearLayout getRightActionContainer() {
        return this.f16406b;
    }

    public int getSidePadding() {
        return this.f16421l;
    }

    public LinearLayout getStartActionContainer() {
        return this.f16404a;
    }

    public CharSequence getSubtitle() {
        CharSequence text = this.f16412e.getText();
        k.f(text, "getText(...)");
        return text;
    }

    public CharSequence getTitle() {
        CharSequence text = this.f16410d.getText();
        k.f(text, "getText(...)");
        return text;
    }

    public int getTitleActionGap() {
        return this.f16428s;
    }

    public int getTitleGravity() {
        return this.f16420k;
    }

    public int getTitleMaxWidth() {
        return this.f16430u;
    }

    public int getTitleTextSize() {
        return this.f16395L;
    }

    public TextView getTitleView() {
        return this.f16410d;
    }

    public int getTopPadding() {
        return this.f16422m;
    }

    public ImageButton h(int i5, int i6, CharSequence charSequence, View.OnClickListener onClickListener) {
        return i(i5, i6 == 0 ? null : androidx.core.content.res.h.f(getResources(), i6, getContext().getTheme()), charSequence, onClickListener);
    }

    public ImageButton i(int i5, Drawable drawable, CharSequence charSequence, View.OnClickListener onClickListener) {
        ImageButton imageButtonZ = z(drawable, charSequence, onClickListener, false);
        l(g(i5), imageButtonZ);
        this.f16416g.add(imageButtonZ);
        return imageButtonZ;
    }

    public ImageButton j(int i5, CharSequence charSequence, View.OnClickListener onClickListener) {
        return h(1, i5, charSequence, onClickListener);
    }

    public ImageButton k(int i5, CharSequence charSequence, View.OnClickListener onClickListener) {
        return h(0, i5, charSequence, onClickListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f16399S) {
            K();
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        k.g(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        int i5 = 0;
        if (this.f16388E && this.f16392I && this.f16391H != null) {
            InterfaceC1005a interfaceC1005aC = C();
            this.f16391H = interfaceC1005aC;
            ArrayList<ImageButton> arrayList = this.f16416g;
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            int i6 = 0;
            while (i6 < size) {
                ImageButton imageButton = arrayList.get(i6);
                i6++;
                if (imageButton instanceof n) {
                    arrayList2.add(imageButton);
                }
            }
            int size2 = arrayList2.size();
            int i7 = 0;
            while (i7 < size2) {
                Object obj = arrayList2.get(i7);
                i7++;
                ((n) obj).d(interfaceC1005aC);
            }
            ArrayList<LinearLayout> arrayList3 = this.f16418i;
            ArrayList arrayList4 = new ArrayList();
            int size3 = arrayList3.size();
            int i8 = 0;
            while (i8 < size3) {
                LinearLayout linearLayout = arrayList3.get(i8);
                i8++;
                if (linearLayout instanceof r3.o) {
                    arrayList4.add(linearLayout);
                }
            }
            int size4 = arrayList4.size();
            int i9 = 0;
            while (i9 < size4) {
                Object obj2 = arrayList4.get(i9);
                i9++;
                ((r3.o) obj2).a(interfaceC1005aC);
            }
        }
        ArrayList<ImageButton> arrayList5 = this.f16416g;
        int size5 = arrayList5.size();
        int i10 = 0;
        while (i10 < size5) {
            ImageButton imageButton2 = arrayList5.get(i10);
            i10++;
            N(imageButton2);
        }
        ArrayList<LinearLayout> arrayList6 = this.f16418i;
        int size6 = arrayList6.size();
        while (i5 < size6) {
            LinearLayout linearLayout2 = arrayList6.get(i5);
            i5++;
            S(linearLayout2);
        }
        if (this.f16399S) {
            K();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.f16415f0);
        this.f16413e0 = false;
        J(false);
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i5, int i6, int i7, int i8) {
        int i9 = i7 - i5;
        int i10 = i8 - i6;
        int i11 = 0;
        boolean z6 = getLayoutDirection() == 1;
        int paddingLeft = getPaddingLeft();
        int paddingRight = i9 - getPaddingRight();
        int iMax = Math.max(0, (i10 - getPaddingTop()) - getPaddingBottom());
        int iV = V(this.f16404a);
        int iV2 = V(this.f16406b);
        int measuredWidth = this.f16408c.getMeasuredWidth();
        int i12 = z6 ? iV2 : iV;
        int i13 = z6 ? iV : iV2;
        int i14 = (measuredWidth <= 0 || i12 <= 0) ? 0 : this.f16428s;
        if (measuredWidth > 0 && i13 > 0) {
            i11 = this.f16428s;
        }
        int iMax2 = i12 + paddingLeft + i14;
        int i15 = (paddingRight - i13) - i11;
        if (this.f16420k == 1 || this.f16387D != null) {
            iMax2 = Math.max(iMax2, Math.min((i9 - measuredWidth) / 2, i15 - measuredWidth));
        } else if (z6) {
            iMax2 = i15 - measuredWidth;
        }
        int paddingTop = getPaddingTop() + ((iMax - this.f16408c.getMeasuredHeight()) / 2);
        FrameLayout frameLayout = this.f16408c;
        frameLayout.layout(iMax2, paddingTop, measuredWidth + iMax2, frameLayout.getMeasuredHeight() + paddingTop);
        Float fValueOf = (this.f16387D == null && this.f16412e.getVisibility() == 0 && this.f16410d.getVisibility() == 0) ? Float.valueOf(this.f16408c.getTop() + this.f16414f.getTop() + this.f16410d.getTop() + (this.f16410d.getMeasuredHeight() / 2.0f)) : null;
        if (z6) {
            I(this.f16404a, paddingRight - iV, paddingRight, iMax, fValueOf);
            I(this.f16406b, paddingLeft, paddingLeft + iV2, iMax, fValueOf);
        } else {
            I(this.f16404a, paddingLeft, paddingLeft + iV, iMax, fValueOf);
            I(this.f16406b, paddingRight - iV2, paddingRight, iMax, fValueOf);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i5, int i6) {
        int i7;
        int mode = View.MeasureSpec.getMode(i5);
        int size = View.MeasureSpec.getSize(i5);
        int mode2 = View.MeasureSpec.getMode(i6);
        int size2 = View.MeasureSpec.getSize(i6);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int iMax = mode == 0 ? 536870911 : Math.max(0, size - paddingLeft);
        int iMax2 = mode2 != 0 ? Math.max(0, size2 - paddingTop) : 536870911;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMax, Integer.MIN_VALUE);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMax2, Integer.MIN_VALUE);
        this.f16404a.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        this.f16406b.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        View centerView = getCenterView();
        boolean z5 = (centerView.getVisibility() == 8 || (this.f16387D == null && TextUtils.isEmpty(this.f16410d.getText()))) ? false : true;
        if (z5) {
            centerView.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        }
        int iV = V(this.f16404a);
        int iV2 = V(this.f16406b);
        int measuredWidth = z5 ? centerView.getMeasuredWidth() : 0;
        if (this.f16387D == null && (i7 = this.f16430u) > 0) {
            measuredWidth = Math.min(measuredWidth, i7);
        }
        int i8 = (!z5 || iV <= 0) ? 0 : this.f16428s;
        int i9 = (!z5 || iV2 <= 0) ? 0 : this.f16428s;
        int iResolveSize = View.resolveSize(paddingLeft + iV + iV2 + i8 + i9 + measuredWidth, i5);
        int iMin = !z5 ? 0 : Math.min(measuredWidth, Math.max(0, (((Math.max(0, iResolveSize - paddingLeft) - iV) - iV2) - i8) - i9));
        int iResolveSize2 = View.resolveSize(Math.max(this.f16431v, Math.max(this.f16404a.getMeasuredHeight(), Math.max(this.f16406b.getMeasuredHeight(), z5 ? centerView.getMeasuredHeight() : 0)) + paddingTop), i6);
        this.f16408c.measure(View.MeasureSpec.makeMeasureSpec(iMin, 1073741824), View.MeasureSpec.makeMeasureSpec(Math.max(0, iResolveSize2 - paddingTop), 1073741824));
        setMeasuredDimension(iResolveSize, iResolveSize2);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i5, int i6, int i7, int i8) {
        super.onSizeChanged(i5, i6, i7, i8);
        if (this.f16399S) {
            K();
        }
    }

    public void setActionBackground(Drawable drawable) {
        this.f16435z = w(drawable);
        int i5 = 0;
        this.f16385B = drawable != null;
        ArrayList<ImageButton> arrayList = this.f16416g;
        int size = arrayList.size();
        while (i5 < size) {
            ImageButton imageButton = arrayList.get(i5);
            i5++;
            N(imageButton);
        }
    }

    public void setActionCornerRadius(float f5) {
        this.f16433x = Math.max(0.0f, f5);
        ArrayList<ImageButton> arrayList = this.f16416g;
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i5 = 0;
        int i6 = 0;
        while (i6 < size) {
            ImageButton imageButton = arrayList.get(i6);
            i6++;
            if (imageButton instanceof n) {
                arrayList2.add(imageButton);
            }
        }
        int size2 = arrayList2.size();
        int i7 = 0;
        while (i7 < size2) {
            Object obj = arrayList2.get(i7);
            i7++;
            ((n) obj).setGlassCornerRadius(this.f16433x);
        }
        ArrayList<ImageButton> arrayList3 = this.f16416g;
        int size3 = arrayList3.size();
        while (i5 < size3) {
            ImageButton imageButton2 = arrayList3.get(i5);
            i5++;
            N(imageButton2);
        }
    }

    public void setActionSize(int i5) {
        if (i5 < 1) {
            throw new IllegalArgumentException(("actionSize must be >= 1 but was " + i5).toString());
        }
        this.f16424o = i5;
        ArrayList<ImageButton> arrayList = this.f16416g;
        int size = arrayList.size();
        int i6 = 0;
        int i7 = 0;
        while (i7 < size) {
            ImageButton imageButton = arrayList.get(i7);
            i7++;
            O(imageButton);
        }
        ArrayList<ImageButton> arrayList2 = this.f16417h;
        int size2 = arrayList2.size();
        int i8 = 0;
        while (i8 < size2) {
            ImageButton imageButton2 = arrayList2.get(i8);
            i8++;
            T(imageButton2);
        }
        ArrayList<LinearLayout> arrayList3 = this.f16418i;
        int size3 = arrayList3.size();
        while (i6 < size3) {
            LinearLayout linearLayout = arrayList3.get(i6);
            i6++;
            LinearLayout linearLayout2 = linearLayout;
            linearLayout2.setMinimumHeight(this.f16424o);
            S(linearLayout2);
        }
        requestLayout();
    }

    public void setActionSpacing(int i5) {
        if (i5 < 0) {
            throw new IllegalArgumentException(("actionSpacing must be >= 0 but was " + i5).toString());
        }
        this.f16426q = i5;
        Q(this.f16404a);
        Q(this.f16406b);
        requestLayout();
    }

    public void setActionsEnabled(boolean z5) {
        if (this.f16419j == z5) {
            return;
        }
        this.f16419j = z5;
        m();
    }

    public void setBackdropBlurEnabled(boolean z5) {
        if (this.f16399S == z5) {
            return;
        }
        this.f16399S = z5;
        if (z5) {
            K();
        } else {
            J(true);
        }
    }

    public void setBackdropGradientEndColor(Integer num) {
        if (k.b(this.f16403W, num)) {
            return;
        }
        this.f16403W = num;
        K();
    }

    public void setBackdropGradientEndColorResource(int i5) {
        setBackdropGradientEndColor(Integer.valueOf(i5 == 0 ? 0 : getContext().getColor(i5)));
    }

    public void setBackdropGradientMiddleColor(Integer num) {
        if (k.b(this.f16402V, num)) {
            return;
        }
        this.f16402V = num;
        K();
    }

    public void setBackdropGradientMiddleColorResource(int i5) {
        setBackdropGradientMiddleColor(Integer.valueOf(i5 == 0 ? 0 : getContext().getColor(i5)));
    }

    public void setBackdropGradientStartColor(Integer num) {
        if (k.b(this.f16401U, num)) {
            return;
        }
        this.f16401U = num;
        K();
    }

    public void setBackdropGradientStartColorResource(int i5) {
        setBackdropGradientStartColor(Integer.valueOf(i5 == 0 ? 0 : getContext().getColor(i5)));
    }

    public void setBackdropScrimColor(int i5) {
        Integer num = this.f16400T;
        if (num != null && num.intValue() == i5) {
            return;
        }
        this.f16400T = Integer.valueOf(i5);
        K();
    }

    public void setBackdropScrimColorResource(int i5) {
        setBackdropScrimColor(getContext().getColor(i5));
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (!this.f16411d0 || this.f16409c0) {
            super.setBackground(drawable);
            return;
        }
        this.f16407b0 = drawable;
        if (this.f16405a0.l()) {
            return;
        }
        super.setBackground(drawable);
    }

    public void setBottomPadding(int i5) {
        int iMax = Math.max(0, i5);
        this.f16423n = iMax;
        int i6 = this.f16421l;
        setPaddingRelative(i6, this.f16422m, i6, iMax);
        requestLayout();
    }

    public void setCenterView(View view) {
        if (view == null) {
            v();
            return;
        }
        if (view == this.f16387D) {
            return;
        }
        if (view.getParent() != null) {
            throw new IllegalStateException("The center view already has a parent");
        }
        View view2 = this.f16387D;
        if (view2 != null) {
            this.f16408c.removeView(view2);
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : layoutParams == null ? new FrameLayout.LayoutParams(-2, -2) : new FrameLayout.LayoutParams(layoutParams.width, layoutParams.height);
        if (layoutParams2.gravity == -1) {
            layoutParams2.gravity = 17;
        }
        this.f16387D = view;
        this.f16414f.setVisibility(8);
        this.f16408c.addView(view, layoutParams2);
        requestLayout();
    }

    public void setGlassCrossWindow(boolean z5) {
        if (this.f16389F == z5) {
            return;
        }
        this.f16389F = z5;
        ArrayList<ImageButton> arrayList = this.f16416g;
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i5 = 0;
        int i6 = 0;
        while (i6 < size) {
            ImageButton imageButton = arrayList.get(i6);
            i6++;
            if (imageButton instanceof n) {
                arrayList2.add(imageButton);
            }
        }
        int size2 = arrayList2.size();
        int i7 = 0;
        while (i7 < size2) {
            Object obj = arrayList2.get(i7);
            i7++;
            ((n) obj).setGlassCrossWindow(z5);
        }
        ArrayList<LinearLayout> arrayList3 = this.f16418i;
        ArrayList arrayList4 = new ArrayList();
        int size3 = arrayList3.size();
        int i8 = 0;
        while (i8 < size3) {
            LinearLayout linearLayout = arrayList3.get(i8);
            i8++;
            if (linearLayout instanceof r3.o) {
                arrayList4.add(linearLayout);
            }
        }
        int size4 = arrayList4.size();
        while (i5 < size4) {
            Object obj2 = arrayList4.get(i5);
            i5++;
            ((r3.o) obj2).setGlassCrossWindow(z5);
        }
    }

    public void setGlassEffect(o oVar) {
        k.g(oVar, "effect");
        int i5 = 0;
        boolean z5 = this.f16391H != null;
        this.f16391H = null;
        this.f16392I = false;
        if (!k.b(this.f16390G, oVar) || z5) {
            this.f16390G = oVar;
            ArrayList<ImageButton> arrayList = this.f16416g;
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            int i6 = 0;
            while (i6 < size) {
                ImageButton imageButton = arrayList.get(i6);
                i6++;
                if (imageButton instanceof n) {
                    arrayList2.add(imageButton);
                }
            }
            int size2 = arrayList2.size();
            int i7 = 0;
            while (i7 < size2) {
                Object obj = arrayList2.get(i7);
                i7++;
                ((n) obj).setGlassEffect(oVar);
            }
            ArrayList<LinearLayout> arrayList3 = this.f16418i;
            ArrayList arrayList4 = new ArrayList();
            int size3 = arrayList3.size();
            int i8 = 0;
            while (i8 < size3) {
                LinearLayout linearLayout = arrayList3.get(i8);
                i8++;
                if (linearLayout instanceof r3.o) {
                    arrayList4.add(linearLayout);
                }
            }
            int size4 = arrayList4.size();
            while (i5 < size4) {
                Object obj2 = arrayList4.get(i5);
                i5++;
                ((r3.o) obj2).setGlassEffect(oVar);
            }
        }
    }

    public void setGlassEnabled(boolean z5) {
        if (this.f16388E == z5) {
            return;
        }
        this.f16388E = z5;
        ArrayList<ImageButton> arrayList = this.f16416g;
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i5 = 0;
        int i6 = 0;
        while (i6 < size) {
            ImageButton imageButton = arrayList.get(i6);
            i6++;
            if (imageButton instanceof n) {
                arrayList2.add(imageButton);
            }
        }
        int size2 = arrayList2.size();
        int i7 = 0;
        while (i7 < size2) {
            Object obj = arrayList2.get(i7);
            i7++;
            ((n) obj).setGlassEnabled(z5 && this.f16397Q);
        }
        ArrayList<LinearLayout> arrayList3 = this.f16418i;
        ArrayList arrayList4 = new ArrayList();
        int size3 = arrayList3.size();
        int i8 = 0;
        while (i8 < size3) {
            LinearLayout linearLayout = arrayList3.get(i8);
            i8++;
            if (linearLayout instanceof r3.o) {
                arrayList4.add(linearLayout);
            }
        }
        int size4 = arrayList4.size();
        int i9 = 0;
        while (i9 < size4) {
            Object obj2 = arrayList4.get(i9);
            i9++;
            ((r3.o) obj2).setGlassEnabled(z5);
        }
        ArrayList<ImageButton> arrayList5 = this.f16416g;
        int size5 = arrayList5.size();
        int i10 = 0;
        while (i10 < size5) {
            ImageButton imageButton2 = arrayList5.get(i10);
            i10++;
            N(imageButton2);
        }
        ArrayList<LinearLayout> arrayList6 = this.f16418i;
        int size6 = arrayList6.size();
        while (i5 < size6) {
            LinearLayout linearLayout2 = arrayList6.get(i5);
            i5++;
            S(linearLayout2);
        }
    }

    public void setGroupBackground(Drawable drawable) {
        this.f16384A = w(drawable);
        int i5 = 0;
        this.f16386C = drawable != null;
        ArrayList<LinearLayout> arrayList = this.f16418i;
        int size = arrayList.size();
        while (i5 < size) {
            LinearLayout linearLayout = arrayList.get(i5);
            i5++;
            S(linearLayout);
        }
    }

    public void setGroupCornerRadius(float f5) {
        this.f16434y = Math.max(0.0f, f5);
        ArrayList<LinearLayout> arrayList = this.f16418i;
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i5 = 0;
        int i6 = 0;
        while (i6 < size) {
            LinearLayout linearLayout = arrayList.get(i6);
            i6++;
            if (linearLayout instanceof r3.o) {
                arrayList2.add(linearLayout);
            }
        }
        int size2 = arrayList2.size();
        int i7 = 0;
        while (i7 < size2) {
            Object obj = arrayList2.get(i7);
            i7++;
            ((r3.o) obj).setGlassCornerRadius(this.f16434y);
        }
        ArrayList<LinearLayout> arrayList3 = this.f16418i;
        int size3 = arrayList3.size();
        while (i5 < size3) {
            LinearLayout linearLayout2 = arrayList3.get(i5);
            i5++;
            S(linearLayout2);
        }
    }

    public void setGroupPadding(int i5) {
        this.f16429t = Math.max(0, i5);
        ArrayList<LinearLayout> arrayList = this.f16418i;
        int size = arrayList.size();
        int i6 = 0;
        while (i6 < size) {
            LinearLayout linearLayout = arrayList.get(i6);
            i6++;
            int i7 = this.f16429t;
            linearLayout.setPadding(i7, 0, i7, 0);
        }
        requestLayout();
    }

    public void setGroupSpacing(int i5) {
        int i6 = 0;
        this.f16427r = Math.max(0, i5);
        ArrayList<LinearLayout> arrayList = this.f16418i;
        int size = arrayList.size();
        while (i6 < size) {
            LinearLayout linearLayout = arrayList.get(i6);
            i6++;
            R(linearLayout);
        }
        requestLayout();
    }

    public void setIconSize(int i5) {
        if (i5 < 1) {
            throw new IllegalArgumentException(("iconSize must be >= 1 but was " + i5).toString());
        }
        this.f16425p = i5;
        ArrayList<ImageButton> arrayList = this.f16416g;
        int size = arrayList.size();
        int i6 = 0;
        int i7 = 0;
        while (i7 < size) {
            ImageButton imageButton = arrayList.get(i7);
            i7++;
            P(imageButton);
        }
        ArrayList<ImageButton> arrayList2 = this.f16417h;
        int size2 = arrayList2.size();
        while (i6 < size2) {
            ImageButton imageButton2 = arrayList2.get(i6);
            i6++;
            T(imageButton2);
        }
        requestLayout();
    }

    public void setIndividualActionGlassEnabled(boolean z5) {
        if (this.f16397Q == z5) {
            return;
        }
        this.f16397Q = z5;
        ArrayList<ImageButton> arrayList = this.f16416g;
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i5 = 0;
        int i6 = 0;
        while (i6 < size) {
            ImageButton imageButton = arrayList.get(i6);
            i6++;
            if (imageButton instanceof n) {
                arrayList2.add(imageButton);
            }
        }
        int size2 = arrayList2.size();
        int i7 = 0;
        while (i7 < size2) {
            Object obj = arrayList2.get(i7);
            i7++;
            ((n) obj).setGlassEnabled(this.f16388E && z5);
        }
        ArrayList<ImageButton> arrayList3 = this.f16416g;
        int size3 = arrayList3.size();
        while (i5 < size3) {
            ImageButton imageButton2 = arrayList3.get(i5);
            i5++;
            N(imageButton2);
        }
    }

    public final void setPressScaleEnabled(boolean z5) {
        if (this.f16398R == z5) {
            return;
        }
        this.f16398R = z5;
        ArrayList<ImageButton> arrayList = this.f16416g;
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i5 = 0;
        int i6 = 0;
        while (i6 < size) {
            ImageButton imageButton = arrayList.get(i6);
            i6++;
            if (imageButton instanceof n) {
                arrayList2.add(imageButton);
            }
        }
        int size2 = arrayList2.size();
        while (i5 < size2) {
            Object obj = arrayList2.get(i5);
            i5++;
            ((n) obj).setPressScaleEnabled(z5);
        }
        f.f20267a.i(this, z5);
    }

    public void setSidePadding(int i5) {
        int iMax = Math.max(0, i5);
        this.f16421l = iMax;
        setPaddingRelative(iMax, this.f16422m, iMax, this.f16423n);
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        boolean z5 = charSequence == null || charSequence.length() == 0;
        this.f16412e.setText(charSequence);
        this.f16412e.setVisibility(!z5 ? 0 : 8);
        this.f16410d.setMinimumHeight(!z5 ? D(C0847e.f18385t0) : 0);
        if (!this.f16394K) {
            this.f16410d.setTextSize(0, !z5 ? this.f16396M : this.f16393J);
        }
        requestLayout();
    }

    public void setTitle(CharSequence charSequence) {
        this.f16410d.setText(charSequence);
        requestLayout();
    }

    public void setTitleActionGap(int i5) {
        this.f16428s = Math.max(0, i5);
        requestLayout();
    }

    public void setTitleCentered(boolean z5) {
        setTitleGravity(z5 ? 1 : 0);
    }

    public void setTitleGravity(int i5) {
        if (i5 != 0 && i5 != 1) {
            throw new IllegalArgumentException(("Unsupported title gravity: " + i5).toString());
        }
        if (this.f16420k != i5) {
            this.f16420k = i5;
            U();
            requestLayout();
        }
    }

    public void setTitleMaxWidth(int i5) {
        int iMax = Math.max(0, i5);
        this.f16430u = iMax;
        TextView textView = this.f16410d;
        if (iMax <= 0) {
            iMax = Integer.MAX_VALUE;
        }
        textView.setMaxWidth(iMax);
        requestLayout();
    }

    public void setTitleTextAppearance(int i5) {
        this.f16410d.setTextAppearance(getContext(), i5);
    }

    public void setTitleTextColor(int i5) {
        this.f16432w = i5;
        this.f16410d.setTextColor(i5);
    }

    public void setTitleTextSize(int i5) {
        if (i5 < 0) {
            throw new IllegalArgumentException(("titleTextSize must be >= 0 but was " + i5).toString());
        }
        if (this.f16395L == i5) {
            return;
        }
        this.f16395L = i5;
        this.f16394K = i5 > 0;
        s();
        requestLayout();
    }

    public void setTitleTextSizeRes(int i5) {
        setTitleTextSize(getResources().getDimensionPixelSize(i5));
    }

    public void setTopPadding(int i5) {
        int iMax = Math.max(0, i5);
        this.f16422m = iMax;
        int i6 = this.f16421l;
        setPaddingRelative(i6, iMax, i6, this.f16423n);
        requestLayout();
    }

    public void u(int i5) {
        LinearLayout linearLayoutG = g(i5);
        Iterator<ImageButton> it = this.f16416g.iterator();
        k.f(it, "iterator(...)");
        while (it.hasNext()) {
            ImageButton next = it.next();
            k.f(next, "next(...)");
            if (H(next, linearLayoutG)) {
                it.remove();
            }
        }
        Iterator<ImageButton> it2 = this.f16417h.iterator();
        k.f(it2, "iterator(...)");
        while (it2.hasNext()) {
            ImageButton next2 = it2.next();
            k.f(next2, "next(...)");
            if (H(next2, linearLayoutG)) {
                it2.remove();
            }
        }
        Iterator<LinearLayout> it3 = this.f16418i.iterator();
        k.f(it3, "iterator(...)");
        while (it3.hasNext()) {
            LinearLayout next3 = it3.next();
            k.f(next3, "next(...)");
            if (H(next3, linearLayoutG)) {
                it3.remove();
            }
        }
        linearLayoutG.removeAllViews();
        requestLayout();
    }

    public void v() {
        View view = this.f16387D;
        if (view != null) {
            this.f16408c.removeView(view);
            this.f16387D = null;
        }
        this.f16414f.setVisibility(0);
        requestLayout();
    }

    public /* synthetic */ StepOSTitleBar(Context context, AttributeSet attributeSet, int i5, int i6, g gVar) {
        this(context, (i6 & 2) != 0 ? null : attributeSet, (i6 & 4) != 0 ? C0844b.f18288i : i5);
    }

    public void setTitle(int i5) {
        this.f16410d.setText(i5);
        requestLayout();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSTitleBar(Context context, AttributeSet attributeSet, int i5) {
        int iM;
        super(context, attributeSet, i5);
        k.g(context, "context");
        this.f16416g = new ArrayList<>();
        this.f16417h = new ArrayList<>();
        this.f16418i = new ArrayList<>();
        this.f16419j = true;
        this.f16388E = true;
        this.f16390G = o.f3626h.i();
        this.f16391H = C();
        this.f16392I = true;
        this.f16397Q = true;
        this.f16398R = true;
        this.f16399S = true;
        this.f16405a0 = new C1009e(this);
        this.f16415f0 = new Runnable() { // from class: w3.e
            @Override // java.lang.Runnable
            public final void run() throws Resources.NotFoundException {
                StepOSTitleBar.t(this.f23705a);
            }
        };
        setClipChildren(false);
        setClipToPadding(false);
        int iD = D(C0847e.f18379q0);
        int iD2 = D(C0847e.f18381r0);
        int iD3 = D(C0847e.f18377p0);
        int iD4 = D(C0847e.f18369l0);
        int iD5 = D(C0847e.f18367k0);
        int iD6 = D(C0847e.f18371m0);
        int iD7 = D(C0847e.f18365j0);
        int iD8 = D(C0847e.f18387u0);
        int iD9 = D(C0847e.f18363i0);
        int iD10 = D(C0847e.f18389v0);
        int iD11 = D(C0847e.f18375o0);
        float fD = D(C0847e.f18359g0);
        float fD2 = D(C0847e.f18361h0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.f18639Y3, i5, 0);
        k.f(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        this.f16420k = typedArrayObtainStyledAttributes.getInt(m.f18506B4, 1);
        this.f16421l = typedArrayObtainStyledAttributes.getDimensionPixelSize(m.f18770u4, iD);
        this.f16422m = typedArrayObtainStyledAttributes.getDimensionPixelSize(m.f18500A4, iD2);
        this.f16423n = typedArrayObtainStyledAttributes.getDimensionPixelSize(m.f18698i4, iD3);
        this.f16424o = typedArrayObtainStyledAttributes.getDimensionPixelSize(m.f18656b4, iD4);
        this.f16425p = typedArrayObtainStyledAttributes.getDimensionPixelSize(m.f18746q4, iD5);
        this.f16426q = typedArrayObtainStyledAttributes.getDimensionPixelSize(m.f18662c4, iD6);
        this.f16427r = typedArrayObtainStyledAttributes.getDimensionPixelSize(m.f18740p4, iD7);
        this.f16428s = typedArrayObtainStyledAttributes.getDimensionPixelSize(m.f18788x4, iD8);
        this.f16429t = typedArrayObtainStyledAttributes.getDimensionPixelSize(m.f18734o4, iD9);
        this.f16430u = typedArrayObtainStyledAttributes.getDimensionPixelSize(m.f18512C4, iD10);
        this.f16431v = typedArrayObtainStyledAttributes.getDimensionPixelSize(m.f18758s4, iD11);
        this.f16433x = typedArrayObtainStyledAttributes.getDimension(m.f18650a4, fD);
        this.f16434y = typedArrayObtainStyledAttributes.getDimension(m.f18728n4, fD2);
        this.f16388E = typedArrayObtainStyledAttributes.getBoolean(m.f18716l4, true);
        o oVarB = C1010f.f20022a.b(typedArrayObtainStyledAttributes, m.f18710k4);
        if (oVarB != null) {
            this.f16390G = oVarB;
            this.f16391H = null;
        }
        this.f16389F = typedArrayObtainStyledAttributes.getBoolean(m.f18704j4, false);
        this.f16397Q = typedArrayObtainStyledAttributes.getBoolean(m.f18752r4, true);
        int i6 = m.f18644Z3;
        this.f16385B = typedArrayObtainStyledAttributes.hasValue(i6);
        int i7 = m.f18722m4;
        this.f16386C = typedArrayObtainStyledAttributes.hasValue(i7);
        this.f16399S = typedArrayObtainStyledAttributes.getBoolean(m.f18668d4, true);
        int i8 = m.f18692h4;
        if (typedArrayObtainStyledAttributes.hasValue(i8)) {
            this.f16400T = Integer.valueOf(typedArrayObtainStyledAttributes.getColor(i8, 0));
        }
        int i9 = m.f18686g4;
        if (typedArrayObtainStyledAttributes.hasValue(i9)) {
            this.f16401U = Integer.valueOf(typedArrayObtainStyledAttributes.getColor(i9, 0));
        }
        int i10 = m.f18680f4;
        if (typedArrayObtainStyledAttributes.hasValue(i10)) {
            this.f16402V = Integer.valueOf(typedArrayObtainStyledAttributes.getColor(i10, 0));
        }
        int i11 = m.f18674e4;
        if (typedArrayObtainStyledAttributes.hasValue(i11)) {
            this.f16403W = Integer.valueOf(typedArrayObtainStyledAttributes.getColor(i11, 0));
        }
        CharSequence text = typedArrayObtainStyledAttributes.getText(m.f18782w4);
        CharSequence text2 = typedArrayObtainStyledAttributes.getText(m.f18776v4);
        ColorStateList colorStateList = typedArrayObtainStyledAttributes.getColorStateList(m.f18518D4);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(m.f18794y4, 0);
        int i12 = m.f18800z4;
        int dimensionPixelSize = typedArrayObtainStyledAttributes.hasValue(i12) ? typedArrayObtainStyledAttributes.getDimensionPixelSize(i12, 0) : 0;
        this.f16394K = dimensionPixelSize > 0;
        this.f16435z = E(typedArrayObtainStyledAttributes, i6);
        this.f16384A = E(typedArrayObtainStyledAttributes, i7);
        this.f16398R = typedArrayObtainStyledAttributes.getBoolean(m.f18764t4, true);
        typedArrayObtainStyledAttributes.recycle();
        if (colorStateList != null) {
            iM = colorStateList.getDefaultColor();
        } else {
            iM = M(R.attr.textColorPrimary, -16777216);
        }
        this.f16432w = iM;
        int i13 = this.f16421l;
        setPaddingRelative(i13, this.f16422m, i13, this.f16423n);
        setMinimumHeight(this.f16431v);
        if (getBackground() == null) {
            setBackground(new ColorDrawable(getResources().getColor(C0846d.f18292B)));
        }
        this.f16407b0 = super.getBackground();
        LinearLayout linearLayoutY = y(h.f18423O);
        this.f16404a = linearLayoutY;
        LinearLayout linearLayoutY2 = y(h.f18422N);
        this.f16406b = linearLayoutY2;
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setId(h.f18421M);
        frameLayout.setClipChildren(false);
        frameLayout.setClipToPadding(false);
        this.f16408c = frameLayout;
        TextView textView = new TextView(context);
        textView.setId(h.f18425Q);
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        textView.setGravity(16);
        textView.setIncludeFontPadding(false);
        textView.setTextSize(2, 18.0f);
        textView.setTypeface(Typeface.create("sans-serif", 1));
        if (resourceId != 0) {
            textView.setTextAppearance(context, resourceId);
        }
        if (colorStateList != null) {
            textView.setTextColor(colorStateList);
        } else if (resourceId == 0) {
            textView.setTextColor(this.f16432w);
        }
        int i14 = this.f16430u;
        if (i14 > 0) {
            textView.setMaxWidth(i14);
        }
        textView.setText(text);
        this.f16410d = textView;
        this.f16432w = textView.getCurrentTextColor();
        this.f16393J = textView.getTextSize();
        if (this.f16394K) {
            this.f16395L = dimensionPixelSize;
            s();
        }
        this.f16396M = getResources().getDimension(C0847e.f18391w0);
        TextView textView2 = new TextView(context);
        textView2.setId(h.f18424P);
        textView2.setSingleLine(true);
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setIncludeFontPadding(false);
        textView2.setMinimumHeight(D(C0847e.f18383s0));
        textView2.setTextAppearance(context, l3.l.f18486i);
        textView2.setVisibility(8);
        this.f16412e = textView2;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(16);
        linearLayout.setClipChildren(false);
        linearLayout.setClipToPadding(false);
        this.f16414f = linearLayout;
        linearLayout.addView(textView, new LinearLayout.LayoutParams(-1, -2));
        linearLayout.addView(textView2, new LinearLayout.LayoutParams(-1, -2));
        U();
        frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-1, -2, 16));
        addView(frameLayout, new FrameLayout.LayoutParams(-2, -2));
        addView(linearLayoutY, new FrameLayout.LayoutParams(-2, -2));
        addView(linearLayoutY2, new FrameLayout.LayoutParams(-2, -2));
        this.f16411d0 = true;
        if (text2 == null || text2.length() == 0) {
            return;
        }
        setSubtitle(text2);
    }
}
