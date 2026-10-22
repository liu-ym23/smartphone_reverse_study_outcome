package stepos.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.a0;
import androidx.core.view.H;
import androidx.core.view.S;
import androidx.core.view.T;
import g.C0728a;

/* loaded from: classes.dex */
public class ActionBarContextView extends AbstractC1098a {

    /* renamed from: B, reason: collision with root package name */
    private static final Interpolator f21424B;

    /* renamed from: C, reason: collision with root package name */
    private static final Interpolator f21425C;

    /* renamed from: A, reason: collision with root package name */
    private S f21426A;

    /* renamed from: m, reason: collision with root package name */
    private CharSequence f21427m;

    /* renamed from: n, reason: collision with root package name */
    private CharSequence f21428n;

    /* renamed from: o, reason: collision with root package name */
    private View f21429o;

    /* renamed from: p, reason: collision with root package name */
    private View f21430p;

    /* renamed from: q, reason: collision with root package name */
    private LinearLayout f21431q;

    /* renamed from: r, reason: collision with root package name */
    private TextView f21432r;

    /* renamed from: s, reason: collision with root package name */
    private TextView f21433s;

    /* renamed from: t, reason: collision with root package name */
    private int f21434t;

    /* renamed from: u, reason: collision with root package name */
    private int f21435u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f21436v;

    /* renamed from: w, reason: collision with root package name */
    private int f21437w;

    /* renamed from: x, reason: collision with root package name */
    private int f21438x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f21439y;

    /* renamed from: z, reason: collision with root package name */
    protected final c f21440z;

    class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b5.b f21441a;

        a(b5.b bVar) {
            this.f21441a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f21441a.a();
        }
    }

    class b implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f21443a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f21444b;

        b(View view, int i5) {
            this.f21443a = view;
            this.f21444b = i5;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.f21443a.getViewTreeObserver().removeOnPreDrawListener(this);
            if (ActionBarContextView.this.f21438x == 2) {
                ActionBarContextView.this.f21440z.d(this.f21443a);
                return false;
            }
            H.F0(this.f21443a, this.f21443a.getHeight());
            S sP = H.d(this.f21443a).p(0.0f);
            sP.h(260L);
            sP.i(ActionBarContextView.f21424B);
            sP.j(ActionBarContextView.this.f21440z.a(sP, this.f21444b));
            sP.n();
            return false;
        }
    }

    protected class c implements T {

        /* renamed from: a, reason: collision with root package name */
        private boolean f21446a = false;

        /* renamed from: b, reason: collision with root package name */
        int f21447b;

        protected c() {
        }

        public c a(S s5, int i5) {
            ActionBarContextView.this.f21426A = s5;
            this.f21447b = i5;
            return this;
        }

        @Override // androidx.core.view.T
        public void c(View view) {
            this.f21446a = true;
        }

        @Override // androidx.core.view.T
        public void d(View view) {
            if (this.f21446a) {
                return;
            }
            if (ActionBarContextView.this.f21438x == 2) {
                ActionBarContextView.this.s();
            }
            ViewGroup viewGroup = ActionBarContextView.this.f21907e;
            if (viewGroup != null) {
                viewGroup.setTranslationY(0.0f);
            }
            ActionBarContextView.this.f21438x = 0;
            ActionBarContextView.this.f21426A = null;
        }

        @Override // androidx.core.view.T
        public void e(View view) {
            ViewGroup viewGroup = ActionBarContextView.this.f21907e;
            if (viewGroup != null) {
                viewGroup.setVisibility(0);
            }
            this.f21446a = false;
        }
    }

    static {
        Interpolator interpolatorA = androidx.core.view.animation.a.a(0.2f, 0.028f, 0.1f, 1.0f);
        f21424B = interpolatorA;
        f21425C = interpolatorA;
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    private void l(boolean z5) {
        t(z5 ? 0 : 8);
    }

    private void p() {
        if (this.f21431q == null) {
            LayoutInflater.from(getContext()).inflate(X4.h.f6037i, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f21431q = linearLayout;
            this.f21432r = (TextView) linearLayout.findViewById(X4.f.f5989f);
            this.f21433s = (TextView) this.f21431q.findViewById(X4.f.f5987e);
            if (this.f21434t != 0) {
                this.f21432r.setTextAppearance(getContext(), this.f21434t);
            }
            if (this.f21435u != 0) {
                this.f21433s.setTextAppearance(getContext(), this.f21435u);
            }
        }
        this.f21432r.setText(this.f21427m);
        this.f21433s.setText(this.f21428n);
        boolean zIsEmpty = TextUtils.isEmpty(this.f21427m);
        boolean zIsEmpty2 = TextUtils.isEmpty(this.f21428n);
        this.f21433s.setVisibility(!zIsEmpty2 ? 0 : 8);
        this.f21431q.setVisibility((zIsEmpty && zIsEmpty2) ? 8 : 0);
        if (this.f21431q.getParent() == null) {
            addView(this.f21431q);
        }
    }

    @Override // stepos.support.v7.widget.AbstractC1098a
    public /* bridge */ /* synthetic */ S f(int i5, long j5) {
        return super.f(i5, j5);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // stepos.support.v7.widget.AbstractC1098a
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // stepos.support.v7.widget.AbstractC1098a
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    View getCustomView() {
        return this.f21430p;
    }

    public CharSequence getSubtitle() {
        return this.f21428n;
    }

    public CharSequence getTitle() {
        return this.f21427m;
    }

    public void k(boolean z5, b5.b bVar) {
        S s5;
        (z5 ? f(0, 200L) : f(8, 100L)).n();
        if (this.f21908f || this.f21439y) {
            if (bVar != null ? bVar.m() : true) {
                l(z5);
            } else if (this.f21438x == 2 && (s5 = this.f21426A) != null && z5) {
                s5.c();
            }
        }
    }

    public void m() {
        if (this.f21429o != null || this.f21439y) {
            return;
        }
        s();
    }

    public void n(b5.b bVar) {
        View view = this.f21429o;
        if (view == null) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(this.f21437w, (ViewGroup) this, false);
            this.f21429o = viewInflate;
            addView(viewInflate);
        } else if (view.getParent() == null) {
            addView(this.f21429o);
        }
        this.f21429o.findViewById(g.f.f16927i).setOnClickListener(new a(bVar));
        stepos.support.v7.view.menu.d dVar = (stepos.support.v7.view.menu.d) bVar.f();
        d dVar2 = this.f21906d;
        if (dVar2 != null) {
            dVar2.I();
        }
        d dVar3 = new d(getContext());
        this.f21906d = dVar3;
        dVar3.Y(true);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        if (!this.f21908f) {
            dVar.c(this.f21906d, this.f21904b);
            ActionMenuView actionMenuView = (ActionMenuView) this.f21906d.n(this);
            this.f21905c = actionMenuView;
            actionMenuView.setBackgroundDrawable(null);
            addView(this.f21905c, layoutParams);
            return;
        }
        this.f21906d.Z(getContext().getResources().getDisplayMetrics().widthPixels - (b5.a.b(getContext()).f() * 2), true);
        this.f21906d.U(Integer.MAX_VALUE);
        this.f21906d.T(true);
        layoutParams.width = -1;
        layoutParams.height = -2;
        dVar.c(this.f21906d, this.f21904b);
        ActionMenuView actionMenuView2 = (ActionMenuView) this.f21906d.n(this);
        this.f21905c = actionMenuView2;
        actionMenuView2.setId(X4.f.f5970R);
        ViewGroup viewGroup = this.f21907e;
        if (viewGroup != null) {
            viewGroup.addView(this.f21905c, layoutParams);
        }
    }

    public void o(b5.b bVar) {
        this.f21439y = true;
        stepos.support.v7.view.menu.d dVar = (stepos.support.v7.view.menu.d) bVar.f();
        d dVar2 = this.f21906d;
        if (dVar2 != null) {
            dVar2.I();
        }
        d dVar3 = new d(getContext());
        this.f21906d = dVar3;
        dVar3.Y(true);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        if (this.f21907e == null) {
            dVar.c(this.f21906d, this.f21904b);
            ActionMenuView actionMenuView = (ActionMenuView) this.f21906d.n(this);
            this.f21905c = actionMenuView;
            actionMenuView.setBackgroundDrawable(null);
            addView(this.f21905c, layoutParams);
            return;
        }
        this.f21906d.Z(getContext().getResources().getDisplayMetrics().widthPixels - (b5.a.b(getContext()).f() * 2), true);
        this.f21906d.U(Integer.MAX_VALUE);
        this.f21906d.T(true);
        layoutParams.width = -1;
        layoutParams.height = -2;
        dVar.c(this.f21906d, this.f21904b);
        ActionMenuView actionMenuView2 = (ActionMenuView) this.f21906d.n(this);
        this.f21905c = actionMenuView2;
        actionMenuView2.setId(X4.f.f5970R);
        this.f21907e.addView(this.f21905c, layoutParams);
    }

    @Override // stepos.support.v7.widget.AbstractC1098a, android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        if (this.f21909g) {
            setSplitToolbar(getContext().getResources().getBoolean(X4.b.f5854d));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d dVar = this.f21906d;
        if (dVar != null) {
            dVar.M();
            this.f21906d.N();
        }
    }

    @Override // stepos.support.v7.widget.AbstractC1098a, android.view.View
    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() != 32) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            return;
        }
        accessibilityEvent.setSource(this);
        accessibilityEvent.setClassName(getClass().getName());
        accessibilityEvent.setPackageName(getContext().getPackageName());
        accessibilityEvent.setContentDescription(this.f21427m);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i5, int i6, int i7, int i8) {
        boolean zM = C.m(this);
        int paddingRight = zM ? (i7 - i5) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i8 - i6) - getPaddingTop()) - getPaddingBottom();
        View view = this.f21429o;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f21429o.getLayoutParams();
            int i9 = zM ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i10 = zM ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int iD = AbstractC1098a.d(paddingRight, i9, zM);
            paddingRight = AbstractC1098a.d(iD + e(this.f21429o, iD, paddingTop, paddingTop2, zM), i10, zM);
        }
        int iE = paddingRight;
        LinearLayout linearLayout = this.f21431q;
        if (linearLayout != null && this.f21430p == null && linearLayout.getVisibility() != 8) {
            iE += e(this.f21431q, iE, paddingTop, paddingTop2, zM);
        }
        View view2 = this.f21430p;
        if (view2 != null) {
            e(view2, iE, paddingTop, paddingTop2, zM);
        }
        int paddingLeft = zM ? getPaddingLeft() : (i7 - i5) - getPaddingRight();
        ActionMenuView actionMenuView = this.f21905c;
        if (actionMenuView == null || actionMenuView.getParent() != this) {
            return;
        }
        e(this.f21905c, paddingLeft, paddingTop, paddingTop2, !zM);
    }

    @Override // android.view.View
    protected void onMeasure(int i5, int i6) {
        if (View.MeasureSpec.getMode(i5) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        }
        if (View.MeasureSpec.getMode(i6) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
        int size = View.MeasureSpec.getSize(i5);
        int size2 = this.f21910h;
        if (size2 <= 0) {
            size2 = View.MeasureSpec.getSize(i6);
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int iMin = size2 - paddingTop;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMin, Integer.MIN_VALUE);
        View view = this.f21429o;
        if (view != null) {
            int iC = c(view, paddingLeft, iMakeMeasureSpec, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f21429o.getLayoutParams();
            paddingLeft = iC - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        ActionMenuView actionMenuView = this.f21905c;
        if (actionMenuView != null && actionMenuView.getParent() == this) {
            paddingLeft = c(this.f21905c, paddingLeft, iMakeMeasureSpec, 0);
        }
        LinearLayout linearLayout = this.f21431q;
        if (linearLayout != null && this.f21430p == null) {
            if (this.f21436v) {
                this.f21431q.measure(View.MeasureSpec.makeMeasureSpec(0, 0), iMakeMeasureSpec);
                int measuredWidth = this.f21431q.getMeasuredWidth();
                boolean z5 = measuredWidth <= paddingLeft;
                if (z5) {
                    paddingLeft -= measuredWidth;
                }
                this.f21431q.setVisibility(z5 ? 0 : 8);
            } else {
                paddingLeft = c(linearLayout, paddingLeft, iMakeMeasureSpec, 0);
            }
        }
        View view2 = this.f21430p;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            int i7 = layoutParams.width;
            int i8 = i7 != -2 ? 1073741824 : Integer.MIN_VALUE;
            if (i7 >= 0) {
                paddingLeft = Math.min(i7, paddingLeft);
            }
            int i9 = layoutParams.height;
            int i10 = i9 == -2 ? Integer.MIN_VALUE : 1073741824;
            if (i9 >= 0) {
                iMin = Math.min(i9, iMin);
            }
            this.f21430p.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i8), View.MeasureSpec.makeMeasureSpec(iMin, i10));
        }
        if (this.f21910h > 0) {
            setMeasuredDimension(size, size2);
            return;
        }
        int childCount = getChildCount();
        int i11 = 0;
        for (int i12 = 0; i12 < childCount; i12++) {
            int measuredHeight = getChildAt(i12).getMeasuredHeight() + paddingTop;
            if (measuredHeight > i11) {
                i11 = measuredHeight;
            }
        }
        setMeasuredDimension(size, i11);
    }

    @Override // stepos.support.v7.widget.AbstractC1098a, android.view.View
    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public boolean q() {
        return this.f21439y;
    }

    public boolean r() {
        return this.f21436v;
    }

    public void s() {
        removeAllViews();
        ViewGroup viewGroup = this.f21907e;
        if (viewGroup != null) {
            viewGroup.removeView(this.f21905c);
        }
        this.f21430p = null;
        this.f21905c = null;
        this.f21439y = false;
        this.f21906d = null;
    }

    @Override // stepos.support.v7.widget.AbstractC1098a
    public void setContentHeight(int i5) {
        this.f21910h = i5;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f21430p;
        if (view2 != null) {
            removeView(view2);
        }
        this.f21430p = view;
        if (view != null && (linearLayout = this.f21431q) != null) {
            removeView(linearLayout);
            this.f21431q = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    @Override // stepos.support.v7.widget.AbstractC1098a
    public void setSplitToolbar(boolean z5) {
        if (this.f21908f != z5) {
            if (this.f21906d != null) {
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
                if (!z5) {
                    ActionMenuView actionMenuView = (ActionMenuView) this.f21906d.n(this);
                    this.f21905c = actionMenuView;
                    actionMenuView.setBackgroundDrawable(null);
                    ViewGroup viewGroup = (ViewGroup) this.f21905c.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(this.f21905c);
                    }
                    addView(this.f21905c, layoutParams);
                } else if (this.f21907e != null) {
                    this.f21906d.Z(getContext().getResources().getDisplayMetrics().widthPixels, true);
                    this.f21906d.U(Integer.MAX_VALUE);
                    layoutParams.width = -1;
                    layoutParams.height = this.f21910h;
                    ActionMenuView actionMenuView2 = (ActionMenuView) this.f21906d.n(this);
                    this.f21905c = actionMenuView2;
                    ViewGroup viewGroup2 = (ViewGroup) actionMenuView2.getParent();
                    if (viewGroup2 != null) {
                        viewGroup2.removeView(this.f21905c);
                    }
                    this.f21907e.addView(this.f21905c, layoutParams);
                }
            }
            super.setSplitToolbar(z5);
        }
    }

    @Override // stepos.support.v7.widget.AbstractC1098a
    public /* bridge */ /* synthetic */ void setSplitView(ViewGroup viewGroup) {
        super.setSplitView(viewGroup);
    }

    @Override // stepos.support.v7.widget.AbstractC1098a
    public /* bridge */ /* synthetic */ void setSplitWhenNarrow(boolean z5) {
        super.setSplitWhenNarrow(z5);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f21428n = charSequence;
        p();
    }

    public void setTitle(CharSequence charSequence) {
        this.f21427m = charSequence;
        p();
    }

    public void setTitleOptional(boolean z5) {
        if (z5 != this.f21436v) {
            requestLayout();
        }
        this.f21436v = z5;
    }

    @Override // stepos.support.v7.widget.AbstractC1098a, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i5) {
        super.setVisibility(i5);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public void t(int i5) {
        S s5 = this.f21426A;
        if (s5 != null) {
            s5.c();
        }
        this.f21438x = i5 == 0 ? 1 : 2;
        View childAt = this.f21907e.getChildAt(0);
        if (childAt.getId() == X4.f.f5975W) {
            childAt = this.f21907e.getChildAt(1);
        }
        ViewGroup viewGroup = this.f21907e;
        ViewGroup viewGroup2 = viewGroup != null ? (ViewGroup) childAt : null;
        View view = viewGroup == null ? this.f21905c : (viewGroup2 == null || viewGroup2 == this.f21905c || viewGroup2.getChildCount() <= 0) ? this.f21907e : this.f21905c;
        if (view == null) {
            this.f21438x = 0;
            return;
        }
        if (i5 == 0) {
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnPreDrawListener(new b(view, i5));
                return;
            }
            return;
        }
        S sP = H.d(view).p(view.getHeight());
        sP.h(260L);
        sP.j(this.f21440z.a(sP, i5));
        sP.i(f21425C);
        sP.n();
    }

    public boolean u() {
        d dVar = this.f21906d;
        if (dVar != null) {
            return dVar.a0();
        }
        return false;
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, N1.a.c() ? X4.a.f5839o : C0728a.f16835l);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f21440z = new c();
        a0 a0VarV = a0.v(context, attributeSet, g.j.f17214y, i5, 0);
        setBackgroundDrawable(a0VarV.g(g.j.f17219z));
        this.f21434t = a0VarV.n(g.j.f16997D, 0);
        this.f21435u = a0VarV.n(g.j.f16992C, 0);
        this.f21910h = a0VarV.m(g.j.f16987B, 0);
        this.f21437w = a0VarV.n(g.j.f16982A, g.g.f16948d);
        a0VarV.x();
    }
}
