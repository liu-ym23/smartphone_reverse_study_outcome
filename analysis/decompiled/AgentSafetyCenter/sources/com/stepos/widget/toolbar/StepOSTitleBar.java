package com.stepos.widget.toolbar;

import a4.t;
import ab.a;
import ab.c;
import ab.g;
import ab.i;
import ab.j;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.crypto.tink.shaded.protobuf.Reader;
import com.stepos.agentsafetycenter.R;
import fb.d;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kb.l;
import kb.s;
import p5.f;
import y9.b;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class StepOSTitleBar extends FrameLayout {

    /* renamed from: c0, reason: collision with root package name */
    public static final /* synthetic */ int f2893c0 = 0;
    public int A;
    public float B;
    public float C;
    public Drawable D;
    public Drawable E;
    public View F;
    public boolean G;
    public boolean H;
    public b I;
    public a J;
    public boolean K;
    public final float L;
    public boolean M;
    public int N;
    public final float O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public Integer S;
    public final c T;
    public Drawable U;
    public boolean V;
    public final boolean W;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f2894a0;

    /* renamed from: b0, reason: collision with root package name */
    public final t f2895b0;

    /* renamed from: c, reason: collision with root package name */
    public final d f2896c;

    /* renamed from: f, reason: collision with root package name */
    public final d f2897f;

    /* renamed from: g, reason: collision with root package name */
    public final FrameLayout f2898g;

    /* renamed from: h, reason: collision with root package name */
    public final TextView f2899h;
    public final TextView i;

    /* renamed from: j, reason: collision with root package name */
    public final LinearLayout f2900j;

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList f2901k;

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f2902l;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList f2903m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f2904n;

    /* renamed from: o, reason: collision with root package name */
    public int f2905o;

    /* renamed from: p, reason: collision with root package name */
    public int f2906p;

    /* renamed from: q, reason: collision with root package name */
    public int f2907q;

    /* renamed from: r, reason: collision with root package name */
    public int f2908r;

    /* renamed from: s, reason: collision with root package name */
    public int f2909s;

    /* renamed from: t, reason: collision with root package name */
    public int f2910t;

    /* renamed from: u, reason: collision with root package name */
    public int f2911u;

    /* renamed from: v, reason: collision with root package name */
    public int f2912v;

    /* renamed from: w, reason: collision with root package name */
    public int f2913w;

    /* renamed from: x, reason: collision with root package name */
    public int f2914x;

    /* renamed from: y, reason: collision with root package name */
    public int f2915y;

    /* renamed from: z, reason: collision with root package name */
    public final int f2916z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0253  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public StepOSTitleBar(android.content.Context r22, android.util.AttributeSet r23, int r24) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 979
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.widget.toolbar.StepOSTitleBar.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(StepOSTitleBar stepOSTitleBar) throws Resources.NotFoundException {
        boolean z10 = false;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        stepOSTitleBar.f2894a0 = false;
        if (stepOSTitleBar.isAttachedToWindow()) {
            if (!stepOSTitleBar.R || stepOSTitleBar.getWidth() <= 0 || stepOSTitleBar.getHeight() <= 0) {
                stepOSTitleBar.l(true);
                return;
            }
            float dimension = stepOSTitleBar.getResources().getDimension(R.dimen.stepos_titlebar_backdrop_blur_radius);
            stepOSTitleBar.V = true;
            try {
                super.setBackground(null);
                stepOSTitleBar.V = false;
                int backdropScrimColor = stepOSTitleBar.getBackdropScrimColor();
                c cVar = stepOSTitleBar.T;
                fb.a aVar = new fb.a(objArr == true ? 1 : 0);
                aVar.f4048g = dimension;
                aVar.f4049h = stepOSTitleBar;
                aVar.f4047f = backdropScrimColor;
                VarHandle.storeStoreFence();
                if (!cVar.b(0, 0.0f, aVar)) {
                    stepOSTitleBar.V = true;
                    try {
                        super.setBackground(stepOSTitleBar.U);
                    } finally {
                    }
                }
                stepOSTitleBar.invalidate();
            } finally {
            }
        }
    }

    public static boolean j(View view, d dVar) {
        while (view != null) {
            if (view == dVar) {
                return true;
            }
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return false;
    }

    public static int s(d dVar) {
        if (dVar.getVisibility() == 8) {
            return 0;
        }
        return dVar.getMeasuredWidth();
    }

    public static int t(float f5, int i) {
        return Color.argb(ac.a.Q(f.p(f5, 0.0f, 1.0f) * 255.0f), Color.red(i), Color.green(i), Color.blue(i));
    }

    public final d b(int i) {
        if (i == 0) {
            return this.f2896c;
        }
        if (i == 1) {
            return this.f2897f;
        }
        g5.f.s(k0.a.j(i, "Unsupported side: "));
        return null;
    }

    public final void c(LinearLayout linearLayout, View view) {
        LinearLayout.LayoutParams layoutParams;
        if (view.getParent() != null) {
            od.f.e("The action view already has a parent");
            return;
        }
        if (view.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            layoutParams2.getClass();
            layoutParams = (LinearLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        layoutParams.setMarginStart(linearLayout.getChildCount() == 0 ? 0 : this.f2911u);
        linearLayout.addView(view, layoutParams);
        p(linearLayout);
        if (!this.f2904n) {
            d(view);
        }
        requestLayout();
    }

    public final void d(View view) {
        view.setEnabled(this.f2904n);
        if ((view instanceof TextView) && !(view instanceof Button) && !(view instanceof CompoundButton)) {
            ((TextView) view).setAlpha(this.f2904n ? 1.0f : 0.3f);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                childAt.getClass();
                d(childAt);
            }
        }
    }

    public final Drawable e(Drawable drawable) {
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
        drawableMutate2.getClass();
        return drawableMutate2;
    }

    public final a f() {
        if ((getResources().getConfiguration().uiMode & 48) != 32) {
            float f5 = getResources().getDisplayMetrics().density;
            return j.a(j.f418a, b.f16030h, f5, 56);
        }
        float f10 = getResources().getDisplayMetrics().density;
        i iVar = new i();
        iVar.f417a = f10;
        VarHandle.storeStoreFence();
        return iVar;
    }

    public final int g(int i) {
        return getResources().getDimensionPixelSize(i);
    }

    public Drawable getActionBackground() {
        return e(this.D);
    }

    public float getActionCornerRadius() {
        return this.B;
    }

    public int getActionSize() {
        return this.f2909s;
    }

    public int getActionSpacing() {
        return this.f2911u;
    }

    public int getBackdropScrimColor() {
        Integer num = this.S;
        return num != null ? num.intValue() : getResources().getColor(R.color.stepos_titlebar_backdrop_scrim_top);
    }

    public int getBottomPadding() {
        return this.f2908r;
    }

    public ViewGroup getCenterContainer() {
        return this.f2898g;
    }

    public View getCenterView() {
        View view = this.F;
        return view == null ? this.f2900j : view;
    }

    public LinearLayout getEndActionContainer() {
        return this.f2897f;
    }

    public int getGlassActiveCount() {
        return getGlassActiveIds().size();
    }

    public Set<String> getGlassActiveIds() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayListF0 = l.F0(this.P ? this.f2901k : s.f7404c, this.f2903m);
        int size = arrayListF0.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayListF0.get(i);
            i++;
            View view = (View) obj;
            if (view instanceof g) {
                linkedHashSet.addAll(((g) view).getGlassActiveIds());
            }
        }
        return linkedHashSet;
    }

    public b getGlassEffect() {
        return this.I;
    }

    public fb.c getGlassRenderMode() {
        if (!this.G) {
            return fb.c.f4052c;
        }
        ArrayList arrayListF0 = l.F0(this.P ? this.f2901k : s.f7404c, this.f2903m);
        if (arrayListF0.isEmpty()) {
            return fb.c.f4053f;
        }
        boolean z10 = true;
        if (!arrayListF0.isEmpty()) {
            int size = arrayListF0.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                Object obj = arrayListF0.get(i);
                i++;
                View view = (View) obj;
                if (!(view instanceof g ? ((g) view).i.f382a : false)) {
                    z10 = false;
                    break;
                }
            }
        }
        return z10 ? fb.c.f4054g : fb.c.f4053f;
    }

    public Drawable getGroupBackground() {
        return e(this.E);
    }

    public float getGroupCornerRadius() {
        return this.C;
    }

    public int getGroupPadding() {
        return this.f2914x;
    }

    public int getGroupSpacing() {
        return this.f2912v;
    }

    public int getIconSize() {
        return this.f2910t;
    }

    public LinearLayout getLeftActionContainer() {
        return this.f2896c;
    }

    public LinearLayout getRightActionContainer() {
        return this.f2897f;
    }

    public int getSidePadding() {
        return this.f2906p;
    }

    public LinearLayout getStartActionContainer() {
        return this.f2896c;
    }

    public CharSequence getSubtitle() {
        CharSequence text = this.i.getText();
        text.getClass();
        return text;
    }

    public CharSequence getTitle() {
        CharSequence text = this.f2899h.getText();
        text.getClass();
        return text;
    }

    public int getTitleActionGap() {
        return this.f2913w;
    }

    public int getTitleGravity() {
        return this.f2905o;
    }

    public int getTitleMaxWidth() {
        return this.f2915y;
    }

    public int getTitleTextSize() {
        return this.N;
    }

    public TextView getTitleView() {
        return this.f2899h;
    }

    public int getTopPadding() {
        return this.f2907q;
    }

    public final float h() {
        float f5 = this.B;
        return f5 > 0.0f ? f5 : this.f2909s / 2.0f;
    }

    public final float i() {
        float f5 = this.C;
        return f5 > 0.0f ? f5 : this.f2909s / 2.0f;
    }

    public final void k(d dVar, int i, int i3, int i10, Float f5) {
        int iRound;
        if (f5 == null) {
            iRound = ((i10 - dVar.getMeasuredHeight()) / 2) + getPaddingTop();
        } else {
            iRound = Math.round(f5.floatValue() - (dVar.getMeasuredHeight() / 2.0f));
        }
        dVar.layout(i, iRound, i3, dVar.getMeasuredHeight() + iRound);
    }

    public final void l(boolean z10) {
        this.T.e();
        if (z10) {
            this.V = true;
            try {
                super.setBackground(this.U);
            } finally {
                this.V = false;
            }
        }
    }

    public final void m() {
        if (this.R && isAttachedToWindow() && !this.f2894a0) {
            this.f2894a0 = true;
            post(this.f2895b0);
        }
    }

    public final void n(ImageButton imageButton) {
        Drawable drawable = null;
        g gVar = imageButton instanceof g ? (g) imageButton : null;
        if (gVar != null) {
            if (!this.G || !this.P) {
                Drawable drawableE = e(this.D);
                boolean z10 = drawableE instanceof ColorDrawable;
                drawable = drawableE;
                if (z10) {
                    int color = ((ColorDrawable) drawableE).getColor();
                    float fH = h();
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setColor(color);
                    gradientDrawable.setCornerRadius(fH);
                    drawable = gradientDrawable;
                } else if (drawableE == null) {
                    GradientDrawable gradientDrawable2 = new GradientDrawable();
                    gradientDrawable2.setCornerRadius(h());
                    drawable = gradientDrawable2;
                }
            }
            gVar.setSurfaceDrawable(drawable);
        }
        bb.a.b(imageButton, getContext().getColor(R.color.stepos_titlebar_action_ripple), Math.max(0.0f, h()), false, h(), 24);
    }

    public final void o(ImageButton imageButton) {
        int iMax = Math.max(0, (this.f2909s - this.f2910t) / 2);
        imageButton.setPadding(iMax, iMax, iMax, iMax);
        imageButton.setMinimumWidth(this.f2909s);
        imageButton.setMinimumHeight(this.f2909s);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.R) {
            m();
        }
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        configuration.getClass();
        super.onConfigurationChanged(configuration);
        boolean z10 = this.G;
        ArrayList arrayList = this.f2903m;
        ArrayList arrayList2 = this.f2901k;
        int i = 0;
        if (z10 && this.K && this.J != null) {
            a aVarF = f();
            this.J = aVarF;
            ArrayList arrayList3 = new ArrayList();
            int size = arrayList2.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList2.get(i3);
                i3++;
                if (obj instanceof g) {
                    arrayList3.add(obj);
                }
            }
            int size2 = arrayList3.size();
            int i10 = 0;
            while (i10 < size2) {
                Object obj2 = arrayList3.get(i10);
                i10++;
                g gVar = (g) obj2;
                gVar.getClass();
                gVar.f403l = aVarF;
                gVar.a();
                gVar.b();
            }
            ArrayList arrayList4 = new ArrayList();
            int size3 = arrayList.size();
            for (int i11 = 0; i11 < size3; i11++) {
                arrayList.get(i11);
            }
            Iterator it = arrayList4.iterator();
            if (it.hasNext()) {
                throw androidx.activity.b.g(it);
            }
        }
        int size4 = arrayList2.size();
        int i12 = 0;
        while (i12 < size4) {
            Object obj3 = arrayList2.get(i12);
            i12++;
            n((ImageButton) obj3);
        }
        int size5 = arrayList.size();
        while (i < size5) {
            Object obj4 = arrayList.get(i);
            i++;
            q((LinearLayout) obj4);
        }
        if (this.R) {
            m();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        removeCallbacks(this.f2895b0);
        this.f2894a0 = false;
        l(false);
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00c3  */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onLayout(boolean r17, int r18, int r19, int r20, int r21) {
        /*
            Method dump skipped, instructions count: 234
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.widget.toolbar.StepOSTitleBar.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i3) {
        int i10;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int iMax = mode == 0 ? 536870911 : Math.max(0, size - paddingRight);
        int iMax2 = mode2 != 0 ? Math.max(0, size2 - paddingBottom) : 536870911;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMax, Integer.MIN_VALUE);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMax2, Integer.MIN_VALUE);
        d dVar = this.f2896c;
        dVar.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        d dVar2 = this.f2897f;
        dVar2.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        View centerView = getCenterView();
        boolean z10 = (centerView.getVisibility() == 8 || (this.F == null && TextUtils.isEmpty(this.f2899h.getText()))) ? false : true;
        if (z10) {
            centerView.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        }
        int iS = s(dVar);
        int iS2 = s(dVar2);
        int measuredWidth = z10 ? centerView.getMeasuredWidth() : 0;
        if (this.F == null && (i10 = this.f2915y) > 0) {
            measuredWidth = Math.min(measuredWidth, i10);
        }
        int i11 = (!z10 || iS <= 0) ? 0 : this.f2913w;
        int i12 = (!z10 || iS2 <= 0) ? 0 : this.f2913w;
        int iResolveSize = View.resolveSize(paddingRight + iS + iS2 + i11 + i12 + measuredWidth, i);
        int iMin = !z10 ? 0 : Math.min(measuredWidth, Math.max(0, (((Math.max(0, iResolveSize - paddingRight) - iS) - iS2) - i11) - i12));
        int iResolveSize2 = View.resolveSize(Math.max(this.f2916z, Math.max(dVar.getMeasuredHeight(), Math.max(dVar2.getMeasuredHeight(), z10 ? centerView.getMeasuredHeight() : 0)) + paddingBottom), i3);
        this.f2898g.measure(View.MeasureSpec.makeMeasureSpec(iMin, 1073741824), View.MeasureSpec.makeMeasureSpec(Math.max(0, iResolveSize2 - paddingBottom), 1073741824));
        setMeasuredDimension(iResolveSize, iResolveSize2);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i3, int i10, int i11) {
        super.onSizeChanged(i, i3, i10, i11);
        if (this.R) {
            m();
        }
    }

    public final void p(LinearLayout linearLayout) {
        int childCount = linearLayout.getChildCount();
        int i = 0;
        while (i < childCount) {
            View childAt = linearLayout.getChildAt(i);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams).setMarginStart(i == 0 ? 0 : this.f2911u);
                childAt.setLayoutParams(layoutParams);
            }
            i++;
        }
    }

    public final void q(LinearLayout linearLayout) throws Resources.NotFoundException {
        if (!k.a(linearLayout.getTag(R.id.stepos_titlebar_action_group), Boolean.TRUE)) {
            float fI = i();
            bb.a.b(linearLayout, getContext().getColor(R.color.stepos_titlebar_action_ripple), Math.max(0.0f, fI), this.Q, fI, 8);
            return;
        }
        int color = getContext().getColor(R.color.stepos_titlebar_action_ripple);
        float fMax = Math.max(0.0f, i());
        boolean z10 = this.Q;
        float fI2 = i();
        linearLayout.setAddStatesFromChildren(true);
        bb.a.a(linearLayout, color, fMax, z10, fI2);
    }

    public final void r(ImageButton imageButton) {
        ViewGroup.LayoutParams layoutParams = imageButton.getLayoutParams();
        if (layoutParams == null) {
            int i = this.f2910t;
            layoutParams = new LinearLayout.LayoutParams(i, i);
        }
        int i3 = this.f2910t;
        layoutParams.width = i3;
        layoutParams.height = i3;
        imageButton.setLayoutParams(layoutParams);
        imageButton.setPadding(0, 0, 0, 0);
        imageButton.setBackground(null);
        imageButton.setForeground(null);
        imageButton.setClipToOutline(false);
    }

    public void setActionBackground(Drawable drawable) {
        this.D = e(drawable);
        ArrayList arrayList = this.f2901k;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            n((ImageButton) obj);
        }
    }

    public void setActionCornerRadius(float f5) {
        this.B = Math.max(0.0f, f5);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.f2901k;
        int size = arrayList2.size();
        int i = 0;
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList2.get(i3);
            i3++;
            if (obj instanceof g) {
                arrayList.add(obj);
            }
        }
        int size2 = arrayList.size();
        int i10 = 0;
        while (i10 < size2) {
            Object obj2 = arrayList.get(i10);
            i10++;
            ((g) obj2).setGlassCornerRadius(this.B);
        }
        int size3 = arrayList2.size();
        while (i < size3) {
            Object obj3 = arrayList2.get(i);
            i++;
            n((ImageButton) obj3);
        }
    }

    public void setActionSize(int i) throws Resources.NotFoundException {
        if (i < 1) {
            od.f.c(k0.a.j(i, "actionSize must be >= 1 but was "));
            return;
        }
        this.f2909s = i;
        ArrayList arrayList = this.f2901k;
        int size = arrayList.size();
        int i3 = 0;
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            ImageButton imageButton = (ImageButton) obj;
            ViewGroup.LayoutParams layoutParams = imageButton.getLayoutParams();
            if (layoutParams == null) {
                int i11 = this.f2909s;
                layoutParams = new LinearLayout.LayoutParams(i11, i11);
            }
            int i12 = this.f2909s;
            layoutParams.width = i12;
            layoutParams.height = i12;
            imageButton.setLayoutParams(layoutParams);
            o(imageButton);
            n(imageButton);
        }
        ArrayList arrayList2 = this.f2902l;
        int size2 = arrayList2.size();
        int i13 = 0;
        while (i13 < size2) {
            Object obj2 = arrayList2.get(i13);
            i13++;
            r((ImageButton) obj2);
        }
        ArrayList arrayList3 = this.f2903m;
        int size3 = arrayList3.size();
        while (i3 < size3) {
            Object obj3 = arrayList3.get(i3);
            i3++;
            LinearLayout linearLayout = (LinearLayout) obj3;
            linearLayout.setMinimumHeight(this.f2909s);
            q(linearLayout);
        }
        requestLayout();
    }

    public void setActionSpacing(int i) {
        if (i < 0) {
            od.f.c(k0.a.j(i, "actionSpacing must be >= 0 but was "));
            return;
        }
        this.f2911u = i;
        p(this.f2896c);
        p(this.f2897f);
        requestLayout();
    }

    public void setActionsEnabled(boolean z10) {
        if (this.f2904n == z10) {
            return;
        }
        this.f2904n = z10;
        d(this.f2896c);
        d(this.f2897f);
    }

    public void setBackdropBlurEnabled(boolean z10) {
        if (this.R == z10) {
            return;
        }
        this.R = z10;
        if (z10) {
            m();
        } else {
            l(true);
        }
    }

    public void setBackdropScrimColor(int i) {
        Integer num = this.S;
        if (num != null && num.intValue() == i) {
            return;
        }
        this.S = Integer.valueOf(i);
        m();
    }

    public void setBackdropScrimColorResource(int i) {
        setBackdropScrimColor(getContext().getColor(i));
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (!this.W || this.V) {
            super.setBackground(drawable);
            return;
        }
        this.U = drawable;
        if (this.T.f382a) {
            return;
        }
        super.setBackground(drawable);
    }

    public void setBottomPadding(int i) {
        int iMax = Math.max(0, i);
        this.f2908r = iMax;
        int i3 = this.f2906p;
        setPaddingRelative(i3, this.f2907q, i3, iMax);
        requestLayout();
    }

    public void setCenterView(View view) {
        View view2 = this.F;
        LinearLayout linearLayout = this.f2900j;
        FrameLayout frameLayout = this.f2898g;
        if (view == null) {
            if (view2 != null) {
                frameLayout.removeView(view2);
                this.F = null;
            }
            linearLayout.setVisibility(0);
            requestLayout();
            return;
        }
        if (view == view2) {
            return;
        }
        if (view.getParent() != null) {
            od.f.e("The center view already has a parent");
            return;
        }
        View view3 = this.F;
        if (view3 != null) {
            frameLayout.removeView(view3);
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : layoutParams == null ? new FrameLayout.LayoutParams(-2, -2) : new FrameLayout.LayoutParams(layoutParams.width, layoutParams.height);
        if (layoutParams2.gravity == -1) {
            layoutParams2.gravity = 17;
        }
        this.F = view;
        linearLayout.setVisibility(8);
        frameLayout.addView(view, layoutParams2);
        requestLayout();
    }

    public void setGlassCrossWindow(boolean z10) {
        if (this.H == z10) {
            return;
        }
        this.H = z10;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.f2901k;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            if (obj instanceof g) {
                arrayList.add(obj);
            }
        }
        int size2 = arrayList.size();
        int i3 = 0;
        while (i3 < size2) {
            Object obj2 = arrayList.get(i3);
            i3++;
            ((g) obj2).setGlassCrossWindow(z10);
        }
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = this.f2903m;
        int size3 = arrayList4.size();
        for (int i10 = 0; i10 < size3; i10++) {
            arrayList4.get(i10);
        }
        Iterator it = arrayList3.iterator();
        if (it.hasNext()) {
            throw androidx.activity.b.g(it);
        }
    }

    public void setGlassEffect(b bVar) {
        bVar.getClass();
        boolean z10 = this.J != null;
        this.J = null;
        this.K = false;
        if (!k.a(this.I, bVar) || z10) {
            this.I = bVar;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = this.f2901k;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList2.get(i);
                i++;
                if (obj instanceof g) {
                    arrayList.add(obj);
                }
            }
            int size2 = arrayList.size();
            int i3 = 0;
            while (i3 < size2) {
                Object obj2 = arrayList.get(i3);
                i3++;
                ((g) obj2).setGlassEffect(bVar);
            }
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = this.f2903m;
            int size3 = arrayList4.size();
            for (int i10 = 0; i10 < size3; i10++) {
                arrayList4.get(i10);
            }
            Iterator it = arrayList3.iterator();
            if (it.hasNext()) {
                throw androidx.activity.b.g(it);
            }
        }
    }

    public void setGlassEnabled(boolean z10) throws Resources.NotFoundException {
        if (this.G == z10) {
            return;
        }
        this.G = z10;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.f2901k;
        int size = arrayList2.size();
        int i = 0;
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList2.get(i3);
            i3++;
            if (obj instanceof g) {
                arrayList.add(obj);
            }
        }
        int size2 = arrayList.size();
        int i10 = 0;
        while (i10 < size2) {
            Object obj2 = arrayList.get(i10);
            i10++;
            ((g) obj2).setGlassEnabled(z10 && this.P);
        }
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = this.f2903m;
        int size3 = arrayList4.size();
        for (int i11 = 0; i11 < size3; i11++) {
            arrayList4.get(i11);
        }
        Iterator it = arrayList3.iterator();
        if (it.hasNext()) {
            throw androidx.activity.b.g(it);
        }
        int size4 = arrayList2.size();
        int i12 = 0;
        while (i12 < size4) {
            Object obj3 = arrayList2.get(i12);
            i12++;
            n((ImageButton) obj3);
        }
        int size5 = arrayList4.size();
        while (i < size5) {
            Object obj4 = arrayList4.get(i);
            i++;
            q((LinearLayout) obj4);
        }
    }

    public void setGroupBackground(Drawable drawable) throws Resources.NotFoundException {
        this.E = e(drawable);
        ArrayList arrayList = this.f2903m;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            q((LinearLayout) obj);
        }
    }

    public void setGroupCornerRadius(float f5) throws Resources.NotFoundException {
        this.C = Math.max(0.0f, f5);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.f2903m;
        int size = arrayList2.size();
        int i = 0;
        for (int i3 = 0; i3 < size; i3++) {
            arrayList2.get(i3);
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            throw androidx.activity.b.g(it);
        }
        int size2 = arrayList2.size();
        while (i < size2) {
            Object obj = arrayList2.get(i);
            i++;
            q((LinearLayout) obj);
        }
    }

    public void setGroupPadding(int i) {
        this.f2914x = Math.max(0, i);
        ArrayList arrayList = this.f2903m;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            int i10 = this.f2914x;
            ((LinearLayout) obj).setPadding(i10, 0, i10, 0);
        }
        requestLayout();
    }

    public void setGroupSpacing(int i) {
        this.f2912v = Math.max(0, i);
        ArrayList arrayList = this.f2903m;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            LinearLayout linearLayout = (LinearLayout) obj;
            int childCount = linearLayout.getChildCount();
            int i10 = 0;
            while (i10 < childCount) {
                View childAt = linearLayout.getChildAt(i10);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof LinearLayout.LayoutParams) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                    layoutParams2.setMarginStart(i10 == 0 ? 0 : this.f2912v);
                    int i11 = this.f2910t;
                    layoutParams2.width = i11;
                    layoutParams2.height = i11;
                    childAt.setLayoutParams(layoutParams);
                }
                i10++;
            }
        }
        requestLayout();
    }

    public void setIconSize(int i) {
        if (i < 1) {
            od.f.c(k0.a.j(i, "iconSize must be >= 1 but was "));
            return;
        }
        this.f2910t = i;
        ArrayList arrayList = this.f2901k;
        int size = arrayList.size();
        int i3 = 0;
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            o((ImageButton) obj);
        }
        ArrayList arrayList2 = this.f2902l;
        int size2 = arrayList2.size();
        while (i3 < size2) {
            Object obj2 = arrayList2.get(i3);
            i3++;
            r((ImageButton) obj2);
        }
        requestLayout();
    }

    public void setIndividualActionGlassEnabled(boolean z10) {
        if (this.P == z10) {
            return;
        }
        this.P = z10;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.f2901k;
        int size = arrayList2.size();
        int i = 0;
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList2.get(i3);
            i3++;
            if (obj instanceof g) {
                arrayList.add(obj);
            }
        }
        int size2 = arrayList.size();
        int i10 = 0;
        while (i10 < size2) {
            Object obj2 = arrayList.get(i10);
            i10++;
            ((g) obj2).setGlassEnabled(this.G && z10);
        }
        int size3 = arrayList2.size();
        while (i < size3) {
            Object obj3 = arrayList2.get(i);
            i++;
            n((ImageButton) obj3);
        }
    }

    public final void setPressScaleEnabled(boolean z10) {
        if (this.Q == z10) {
            return;
        }
        this.Q = z10;
        bb.a.c(this, z10);
    }

    public void setSidePadding(int i) {
        int iMax = Math.max(0, i);
        this.f2906p = iMax;
        setPaddingRelative(iMax, this.f2907q, iMax, this.f2908r);
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        boolean z10 = charSequence == null || charSequence.length() == 0;
        TextView textView = this.i;
        textView.setText(charSequence);
        textView.setVisibility(!z10 ? 0 : 8);
        int iG = !z10 ? g(R.dimen.stepos_titlebar_subtitle_title_row_height) : 0;
        TextView textView2 = this.f2899h;
        textView2.setMinimumHeight(iG);
        if (!this.M) {
            textView2.setTextSize(0, !z10 ? this.O : this.L);
        }
        requestLayout();
    }

    public void setTitle(CharSequence charSequence) {
        this.f2899h.setText(charSequence);
        requestLayout();
    }

    public void setTitleActionGap(int i) {
        this.f2913w = Math.max(0, i);
        requestLayout();
    }

    public void setTitleCentered(boolean z10) {
        setTitleGravity(z10 ? 1 : 0);
    }

    public void setTitleGravity(int i) {
        if (i != 0 && i != 1) {
            od.f.c(k0.a.j(i, "Unsupported title gravity: "));
            return;
        }
        if (this.f2905o != i) {
            this.f2905o = i;
            int i3 = i == 1 ? 17 : 8388627;
            this.f2899h.setGravity(i3);
            this.i.setGravity(i3);
            requestLayout();
        }
    }

    public void setTitleMaxWidth(int i) {
        int iMax = Math.max(0, i);
        this.f2915y = iMax;
        if (iMax <= 0) {
            iMax = Reader.READ_DONE;
        }
        this.f2899h.setMaxWidth(iMax);
        requestLayout();
    }

    public void setTitleTextAppearance(int i) {
        this.f2899h.setTextAppearance(getContext(), i);
    }

    public void setTitleTextColor(int i) {
        this.A = i;
        this.f2899h.setTextColor(i);
    }

    public void setTitleTextSize(int i) {
        if (i < 0) {
            od.f.c(k0.a.j(i, "titleTextSize must be >= 0 but was "));
        } else {
            if (this.N == i) {
                return;
            }
            this.N = i;
            this.M = i > 0;
            this.f2899h.setTextSize(0, i > 0 ? i : this.L);
            requestLayout();
        }
    }

    public void setTitleTextSizeRes(int i) {
        setTitleTextSize(getResources().getDimensionPixelSize(i));
    }

    public void setTopPadding(int i) {
        int iMax = Math.max(0, i);
        this.f2907q = iMax;
        int i3 = this.f2906p;
        setPaddingRelative(i3, iMax, i3, this.f2908r);
        requestLayout();
    }

    public void setTitle(int i) {
        this.f2899h.setText(i);
        requestLayout();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSTitleBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        context.getClass();
    }

    public /* synthetic */ StepOSTitleBar(Context context, AttributeSet attributeSet, int i, int i3, yb.f fVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? R.attr.steposTitleBarStyle : i);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSTitleBar(Context context) {
        this(context, null, 0, 6, null);
        context.getClass();
    }
}
