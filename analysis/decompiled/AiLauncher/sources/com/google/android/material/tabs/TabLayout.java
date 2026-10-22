package com.google.android.material.tabs;

import C0.c;
import android.R;
import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.E;
import androidx.core.view.N;
import androidx.viewpager.widget.ViewPager;
import b3.C1447a;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.r;
import com.google.android.material.internal.u;
import d3.C3953a;
import f.C4027a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import u0.C5566a;

@ViewPager.e
/* loaded from: classes2.dex */
public class TabLayout extends HorizontalScrollView {

    /* renamed from: a0, reason: collision with root package name */
    public static final int f21375a0 = R$style.Widget_Design_TabLayout;

    /* renamed from: b0, reason: collision with root package name */
    public static final B0.e<g> f21376b0 = new B0.g(16);

    /* renamed from: A, reason: collision with root package name */
    public int f21377A;

    /* renamed from: B, reason: collision with root package name */
    public int f21378B;

    /* renamed from: C, reason: collision with root package name */
    public int f21379C;

    /* renamed from: D, reason: collision with root package name */
    public int f21380D;

    /* renamed from: E, reason: collision with root package name */
    public boolean f21381E;

    /* renamed from: F, reason: collision with root package name */
    public boolean f21382F;

    /* renamed from: G, reason: collision with root package name */
    public int f21383G;

    /* renamed from: H, reason: collision with root package name */
    public int f21384H;

    /* renamed from: I, reason: collision with root package name */
    public boolean f21385I;

    /* renamed from: J, reason: collision with root package name */
    public com.google.android.material.tabs.a f21386J;

    /* renamed from: K, reason: collision with root package name */
    public final TimeInterpolator f21387K;

    /* renamed from: L, reason: collision with root package name */
    public c f21388L;

    /* renamed from: M, reason: collision with root package name */
    public final ArrayList<c> f21389M;

    /* renamed from: N, reason: collision with root package name */
    public c f21390N;

    /* renamed from: O, reason: collision with root package name */
    public ValueAnimator f21391O;

    /* renamed from: P, reason: collision with root package name */
    public ViewPager f21392P;

    /* renamed from: Q, reason: collision with root package name */
    public androidx.viewpager.widget.a f21393Q;

    /* renamed from: R, reason: collision with root package name */
    public DataSetObserver f21394R;

    /* renamed from: S, reason: collision with root package name */
    public h f21395S;

    /* renamed from: T, reason: collision with root package name */
    public b f21396T;

    /* renamed from: U, reason: collision with root package name */
    public boolean f21397U;

    /* renamed from: V, reason: collision with root package name */
    public int f21398V;

    /* renamed from: W, reason: collision with root package name */
    public final B0.e<i> f21399W;

    /* renamed from: a, reason: collision with root package name */
    public int f21400a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList<g> f21401b;

    /* renamed from: c, reason: collision with root package name */
    public g f21402c;

    /* renamed from: d, reason: collision with root package name */
    public final f f21403d;

    /* renamed from: e, reason: collision with root package name */
    public int f21404e;

    /* renamed from: f, reason: collision with root package name */
    public int f21405f;

    /* renamed from: g, reason: collision with root package name */
    public int f21406g;

    /* renamed from: h, reason: collision with root package name */
    public int f21407h;

    /* renamed from: i, reason: collision with root package name */
    public final int f21408i;

    /* renamed from: j, reason: collision with root package name */
    public final int f21409j;

    /* renamed from: k, reason: collision with root package name */
    public int f21410k;

    /* renamed from: l, reason: collision with root package name */
    public ColorStateList f21411l;

    /* renamed from: m, reason: collision with root package name */
    public ColorStateList f21412m;

    /* renamed from: n, reason: collision with root package name */
    public ColorStateList f21413n;

    /* renamed from: o, reason: collision with root package name */
    public Drawable f21414o;

    /* renamed from: p, reason: collision with root package name */
    public int f21415p;

    /* renamed from: q, reason: collision with root package name */
    public PorterDuff.Mode f21416q;

    /* renamed from: r, reason: collision with root package name */
    public float f21417r;

    /* renamed from: s, reason: collision with root package name */
    public float f21418s;

    /* renamed from: t, reason: collision with root package name */
    public float f21419t;

    /* renamed from: u, reason: collision with root package name */
    public final int f21420u;

    /* renamed from: v, reason: collision with root package name */
    public int f21421v;

    /* renamed from: w, reason: collision with root package name */
    public final int f21422w;

    /* renamed from: x, reason: collision with root package name */
    public final int f21423x;

    /* renamed from: y, reason: collision with root package name */
    public final int f21424y;

    /* renamed from: z, reason: collision with root package name */
    public int f21425z;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TabLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
        }
    }

    public class b implements ViewPager.i {

        /* renamed from: a, reason: collision with root package name */
        public boolean f21427a;

        public b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void a(ViewPager viewPager, androidx.viewpager.widget.a aVar, androidx.viewpager.widget.a aVar2) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.f21392P == viewPager) {
                tabLayout.M(aVar2, this.f21427a);
            }
        }

        public void b(boolean z10) {
            this.f21427a = z10;
        }
    }

    @Deprecated
    public interface c<T extends g> {
        void a(T t10);

        void b(T t10);

        void c(T t10);
    }

    public interface d extends c<g> {
    }

    public class e extends DataSetObserver {
        public e() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            TabLayout.this.F();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            TabLayout.this.F();
        }
    }

    public class f extends LinearLayout {

        /* renamed from: a, reason: collision with root package name */
        public ValueAnimator f21430a;

        /* renamed from: b, reason: collision with root package name */
        public int f21431b;

        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ View f21433a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ View f21434b;

            public a(View view, View view2) {
                this.f21433a = view;
                this.f21434b = view2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.j(this.f21433a, this.f21434b, valueAnimator.getAnimatedFraction());
            }
        }

        public f(Context context) {
            super(context);
            this.f21431b = -1;
            setWillNotDraw(false);
        }

        public void c(int i10, int i11) {
            ValueAnimator valueAnimator = this.f21430a;
            if (valueAnimator != null && valueAnimator.isRunning() && TabLayout.this.f21400a != i10) {
                this.f21430a.cancel();
            }
            k(true, i10, i11);
        }

        public boolean d() {
            int childCount = getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                if (getChildAt(i10).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        @Override // android.view.View
        public void draw(Canvas canvas) {
            int height;
            int iHeight = TabLayout.this.f21414o.getBounds().height();
            if (iHeight < 0) {
                iHeight = TabLayout.this.f21414o.getIntrinsicHeight();
            }
            int i10 = TabLayout.this.f21379C;
            if (i10 == 0) {
                height = getHeight() - iHeight;
                iHeight = getHeight();
            } else if (i10 != 1) {
                height = 0;
                if (i10 != 2) {
                    iHeight = i10 != 3 ? 0 : getHeight();
                }
            } else {
                height = (getHeight() - iHeight) / 2;
                iHeight = (getHeight() + iHeight) / 2;
            }
            if (TabLayout.this.f21414o.getBounds().width() > 0) {
                Rect bounds = TabLayout.this.f21414o.getBounds();
                TabLayout.this.f21414o.setBounds(bounds.left, height, bounds.right, iHeight);
                TabLayout.this.f21414o.draw(canvas);
            }
            super.draw(canvas);
        }

        public final void e() {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.f21400a == -1) {
                tabLayout.f21400a = tabLayout.getSelectedTabPosition();
            }
            f(TabLayout.this.f21400a);
        }

        public final void f(int i10) {
            if (TabLayout.this.f21398V == 0 || (TabLayout.this.getTabSelectedIndicator().getBounds().left == -1 && TabLayout.this.getTabSelectedIndicator().getBounds().right == -1)) {
                View childAt = getChildAt(i10);
                com.google.android.material.tabs.a aVar = TabLayout.this.f21386J;
                TabLayout tabLayout = TabLayout.this;
                aVar.c(tabLayout, childAt, tabLayout.f21414o);
                TabLayout.this.f21400a = i10;
            }
        }

        public final void g() {
            f(TabLayout.this.getSelectedTabPosition());
        }

        public void h(int i10, float f10) {
            TabLayout.this.f21400a = Math.round(i10 + f10);
            ValueAnimator valueAnimator = this.f21430a;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f21430a.cancel();
            }
            j(getChildAt(i10), getChildAt(i10 + 1), f10);
        }

        public void i(int i10) {
            Rect bounds = TabLayout.this.f21414o.getBounds();
            TabLayout.this.f21414o.setBounds(bounds.left, 0, bounds.right, i10);
            requestLayout();
        }

        public final void j(View view, View view2, float f10) {
            if (view == null || view.getWidth() <= 0) {
                Drawable drawable = TabLayout.this.f21414o;
                drawable.setBounds(-1, drawable.getBounds().top, -1, TabLayout.this.f21414o.getBounds().bottom);
            } else {
                com.google.android.material.tabs.a aVar = TabLayout.this.f21386J;
                TabLayout tabLayout = TabLayout.this;
                aVar.d(tabLayout, view, view2, f10, tabLayout.f21414o);
            }
            postInvalidateOnAnimation();
        }

        public final void k(boolean z10, int i10, int i11) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.f21400a == i10) {
                return;
            }
            View childAt = getChildAt(tabLayout.getSelectedTabPosition());
            View childAt2 = getChildAt(i10);
            if (childAt2 == null) {
                g();
                return;
            }
            TabLayout.this.f21400a = i10;
            a aVar = new a(childAt, childAt2);
            if (!z10) {
                this.f21430a.removeAllUpdateListeners();
                this.f21430a.addUpdateListener(aVar);
                return;
            }
            ValueAnimator valueAnimator = new ValueAnimator();
            this.f21430a = valueAnimator;
            valueAnimator.setInterpolator(TabLayout.this.f21387K);
            valueAnimator.setDuration(i11);
            valueAnimator.setFloatValues(0.0f, 1.0f);
            valueAnimator.addUpdateListener(aVar);
            valueAnimator.start();
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
            super.onLayout(z10, i10, i11, i12, i13);
            ValueAnimator valueAnimator = this.f21430a;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                e();
            } else {
                k(false, TabLayout.this.getSelectedTabPosition(), -1);
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i10, int i11) {
            super.onMeasure(i10, i11);
            if (View.MeasureSpec.getMode(i10) != 1073741824) {
                return;
            }
            TabLayout tabLayout = TabLayout.this;
            boolean z10 = true;
            if (tabLayout.f21377A == 1 || tabLayout.f21380D == 2) {
                int childCount = getChildCount();
                int iMax = 0;
                for (int i12 = 0; i12 < childCount; i12++) {
                    View childAt = getChildAt(i12);
                    if (childAt.getVisibility() == 0) {
                        iMax = Math.max(iMax, childAt.getMeasuredWidth());
                    }
                }
                if (iMax <= 0) {
                    return;
                }
                if (iMax * childCount <= getMeasuredWidth() - (((int) u.c(getContext(), 16)) * 2)) {
                    boolean z11 = false;
                    for (int i13 = 0; i13 < childCount; i13++) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i13).getLayoutParams();
                        if (layoutParams.width != iMax || layoutParams.weight != 0.0f) {
                            layoutParams.width = iMax;
                            layoutParams.weight = 0.0f;
                            z11 = true;
                        }
                    }
                    z10 = z11;
                } else {
                    TabLayout tabLayout2 = TabLayout.this;
                    tabLayout2.f21377A = 0;
                    tabLayout2.U(false);
                }
                if (z10) {
                    super.onMeasure(i10, i11);
                }
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int i10) {
            super.onRtlPropertiesChanged(i10);
        }
    }

    public static class g {

        /* renamed from: a, reason: collision with root package name */
        public Object f21436a;

        /* renamed from: b, reason: collision with root package name */
        public Drawable f21437b;

        /* renamed from: c, reason: collision with root package name */
        public CharSequence f21438c;

        /* renamed from: d, reason: collision with root package name */
        public CharSequence f21439d;

        /* renamed from: f, reason: collision with root package name */
        public View f21441f;

        /* renamed from: h, reason: collision with root package name */
        public TabLayout f21443h;

        /* renamed from: i, reason: collision with root package name */
        public i f21444i;

        /* renamed from: e, reason: collision with root package name */
        public int f21440e = -1;

        /* renamed from: g, reason: collision with root package name */
        public int f21442g = 1;

        /* renamed from: j, reason: collision with root package name */
        public int f21445j = -1;

        public View e() {
            return this.f21441f;
        }

        public Drawable f() {
            return this.f21437b;
        }

        public int g() {
            return this.f21440e;
        }

        public int h() {
            return this.f21442g;
        }

        public CharSequence i() {
            return this.f21438c;
        }

        public boolean j() {
            TabLayout tabLayout = this.f21443h;
            if (tabLayout == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            int selectedTabPosition = tabLayout.getSelectedTabPosition();
            return selectedTabPosition != -1 && selectedTabPosition == this.f21440e;
        }

        public void k() {
            this.f21443h = null;
            this.f21444i = null;
            this.f21436a = null;
            this.f21437b = null;
            this.f21445j = -1;
            this.f21438c = null;
            this.f21439d = null;
            this.f21440e = -1;
            this.f21441f = null;
        }

        public void l() {
            TabLayout tabLayout = this.f21443h;
            if (tabLayout == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            tabLayout.K(this);
        }

        public g m(CharSequence charSequence) {
            this.f21439d = charSequence;
            s();
            return this;
        }

        public g n(int i10) {
            return o(LayoutInflater.from(this.f21444i.getContext()).inflate(i10, (ViewGroup) this.f21444i, false));
        }

        public g o(View view) {
            this.f21441f = view;
            s();
            return this;
        }

        public g p(Drawable drawable) {
            this.f21437b = drawable;
            TabLayout tabLayout = this.f21443h;
            if (tabLayout.f21377A == 1 || tabLayout.f21380D == 2) {
                tabLayout.U(true);
            }
            s();
            return this;
        }

        public void q(int i10) {
            this.f21440e = i10;
        }

        public g r(CharSequence charSequence) {
            if (TextUtils.isEmpty(this.f21439d) && !TextUtils.isEmpty(charSequence)) {
                this.f21444i.setContentDescription(charSequence);
            }
            this.f21438c = charSequence;
            s();
            return this;
        }

        public void s() {
            i iVar = this.f21444i;
            if (iVar != null) {
                iVar.p();
            }
        }
    }

    public static class h implements ViewPager.j {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference<TabLayout> f21446a;

        /* renamed from: b, reason: collision with root package name */
        public int f21447b;

        /* renamed from: c, reason: collision with root package name */
        public int f21448c;

        public h(TabLayout tabLayout) {
            this.f21446a = new WeakReference<>(tabLayout);
        }

        public void a() {
            this.f21448c = 0;
            this.f21447b = 0;
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageScrollStateChanged(int i10) {
            this.f21447b = this.f21448c;
            this.f21448c = i10;
            TabLayout tabLayout = this.f21446a.get();
            if (tabLayout != null) {
                tabLayout.V(this.f21448c);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageScrolled(int i10, float f10, int i11) {
            boolean z10;
            TabLayout tabLayout = this.f21446a.get();
            if (tabLayout != null) {
                int i12 = this.f21448c;
                boolean z11 = true;
                if (i12 != 2 || this.f21447b == 1) {
                    z10 = true;
                } else {
                    z10 = true;
                    z11 = false;
                }
                if (i12 == 2 && this.f21447b == 0) {
                    z10 = false;
                }
                tabLayout.P(i10, f10, z11, z10, false);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageSelected(int i10) {
            TabLayout tabLayout = this.f21446a.get();
            if (tabLayout == null || tabLayout.getSelectedTabPosition() == i10 || i10 >= tabLayout.getTabCount()) {
                return;
            }
            int i11 = this.f21448c;
            tabLayout.L(tabLayout.B(i10), i11 == 0 || (i11 == 2 && this.f21447b == 0));
        }
    }

    public final class i extends LinearLayout {

        /* renamed from: a, reason: collision with root package name */
        public g f21449a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f21450b;

        /* renamed from: c, reason: collision with root package name */
        public ImageView f21451c;

        /* renamed from: d, reason: collision with root package name */
        public View f21452d;

        /* renamed from: e, reason: collision with root package name */
        public com.google.android.material.badge.a f21453e;

        /* renamed from: f, reason: collision with root package name */
        public View f21454f;

        /* renamed from: g, reason: collision with root package name */
        public TextView f21455g;

        /* renamed from: h, reason: collision with root package name */
        public ImageView f21456h;

        /* renamed from: i, reason: collision with root package name */
        public Drawable f21457i;

        /* renamed from: j, reason: collision with root package name */
        public int f21458j;

        public class a implements View.OnLayoutChangeListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ View f21460a;

            public a(View view) {
                this.f21460a = view;
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                if (this.f21460a.getVisibility() == 0) {
                    i.this.o(this.f21460a);
                }
            }
        }

        public i(Context context) {
            super(context);
            this.f21458j = 2;
            q(context);
            setPaddingRelative(TabLayout.this.f21404e, TabLayout.this.f21405f, TabLayout.this.f21406g, TabLayout.this.f21407h);
            setGravity(17);
            setOrientation(!TabLayout.this.f21381E ? 1 : 0);
            setClickable(true);
            N.x0(this, E.b(getContext(), 1002));
        }

        private com.google.android.material.badge.a getBadge() {
            return this.f21453e;
        }

        private com.google.android.material.badge.a getOrCreateBadge() {
            if (this.f21453e == null) {
                this.f21453e = com.google.android.material.badge.a.e(getContext());
            }
            n();
            com.google.android.material.badge.a aVar = this.f21453e;
            if (aVar != null) {
                return aVar;
            }
            throw new IllegalStateException("Unable to create badge");
        }

        public final void d(View view) {
            if (view == null) {
                return;
            }
            view.addOnLayoutChangeListener(new a(view));
        }

        @Override // android.view.ViewGroup, android.view.View
        public void drawableStateChanged() {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.f21457i;
            if ((drawable == null || !drawable.isStateful()) ? false : this.f21457i.setState(drawableState)) {
                invalidate();
                TabLayout.this.invalidate();
            }
        }

        public final float e(Layout layout, int i10, float f10) {
            return layout.getLineWidth(i10) * (f10 / layout.getPaint().getTextSize());
        }

        public final void f(boolean z10) {
            setClipChildren(z10);
            setClipToPadding(z10);
            ViewGroup viewGroup = (ViewGroup) getParent();
            if (viewGroup != null) {
                viewGroup.setClipChildren(z10);
                viewGroup.setClipToPadding(z10);
            }
        }

        public final void g(Canvas canvas) {
            Drawable drawable = this.f21457i;
            if (drawable != null) {
                drawable.setBounds(getLeft(), getTop(), getRight(), getBottom());
                this.f21457i.draw(canvas);
            }
        }

        public int getContentHeight() {
            View[] viewArr = {this.f21450b, this.f21451c, this.f21454f};
            int iMax = 0;
            int iMin = 0;
            boolean z10 = false;
            for (int i10 = 0; i10 < 3; i10++) {
                View view = viewArr[i10];
                if (view != null && view.getVisibility() == 0) {
                    iMin = z10 ? Math.min(iMin, view.getTop()) : view.getTop();
                    iMax = z10 ? Math.max(iMax, view.getBottom()) : view.getBottom();
                    z10 = true;
                }
            }
            return iMax - iMin;
        }

        public int getContentWidth() {
            View[] viewArr = {this.f21450b, this.f21451c, this.f21454f};
            int iMax = 0;
            int iMin = 0;
            boolean z10 = false;
            for (int i10 = 0; i10 < 3; i10++) {
                View view = viewArr[i10];
                if (view != null && view.getVisibility() == 0) {
                    iMin = z10 ? Math.min(iMin, view.getLeft()) : view.getLeft();
                    iMax = z10 ? Math.max(iMax, view.getRight()) : view.getRight();
                    z10 = true;
                }
            }
            return iMax - iMin;
        }

        public g getTab() {
            return this.f21449a;
        }

        public final boolean h() {
            return this.f21453e != null;
        }

        public final void i() {
            ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(R$layout.design_layout_tab_icon, (ViewGroup) this, false);
            this.f21451c = imageView;
            addView(imageView, 0);
        }

        public final void j() {
            TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(R$layout.design_layout_tab_text, (ViewGroup) this, false);
            this.f21450b = textView;
            addView(textView);
        }

        public void k() {
            setTab(null);
            setSelected(false);
        }

        public final void l(View view) {
            if (h() && view != null) {
                f(false);
                com.google.android.material.badge.b.a(this.f21453e, view, null);
                this.f21452d = view;
            }
        }

        public final void m() {
            if (h()) {
                f(true);
                View view = this.f21452d;
                if (view != null) {
                    com.google.android.material.badge.b.b(this.f21453e, view);
                    this.f21452d = null;
                }
            }
        }

        public final void n() {
            g gVar;
            g gVar2;
            if (h()) {
                if (this.f21454f != null) {
                    m();
                    return;
                }
                if (this.f21451c != null && (gVar2 = this.f21449a) != null && gVar2.f() != null) {
                    View view = this.f21452d;
                    ImageView imageView = this.f21451c;
                    if (view == imageView) {
                        o(imageView);
                        return;
                    } else {
                        m();
                        l(this.f21451c);
                        return;
                    }
                }
                if (this.f21450b == null || (gVar = this.f21449a) == null || gVar.h() != 1) {
                    m();
                    return;
                }
                View view2 = this.f21452d;
                TextView textView = this.f21450b;
                if (view2 == textView) {
                    o(textView);
                } else {
                    m();
                    l(this.f21450b);
                }
            }
        }

        public final void o(View view) {
            if (h() && view == this.f21452d) {
                com.google.android.material.badge.b.c(this.f21453e, view, null);
            }
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            C0.c cVarS0 = C0.c.S0(accessibilityNodeInfo);
            com.google.android.material.badge.a aVar = this.f21453e;
            if (aVar != null && aVar.isVisible()) {
                cVarS0.q0(this.f21453e.i());
            }
            cVarS0.p0(c.g.a(0, 1, this.f21449a.g(), 1, false, isSelected()));
            if (isSelected()) {
                cVarS0.n0(false);
                cVarS0.f0(c.a.f1654i);
            }
            cVarS0.G0(getResources().getString(R$string.item_view_role_description));
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i10, int i11) {
            Layout layout;
            int size = View.MeasureSpec.getSize(i10);
            int mode = View.MeasureSpec.getMode(i10);
            int tabMaxWidth = TabLayout.this.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i10 = View.MeasureSpec.makeMeasureSpec(TabLayout.this.f21421v, Integer.MIN_VALUE);
            }
            super.onMeasure(i10, i11);
            if (this.f21450b != null) {
                float f10 = TabLayout.this.f21417r;
                if (isSelected() && TabLayout.this.f21410k != -1) {
                    f10 = TabLayout.this.f21418s;
                }
                int i12 = this.f21458j;
                ImageView imageView = this.f21451c;
                if (imageView == null || imageView.getVisibility() != 0) {
                    TextView textView = this.f21450b;
                    if (textView != null && textView.getLineCount() > 1) {
                        f10 = TabLayout.this.f21419t;
                    }
                } else {
                    i12 = 1;
                }
                float textSize = this.f21450b.getTextSize();
                int lineCount = this.f21450b.getLineCount();
                int maxLines = this.f21450b.getMaxLines();
                if (f10 != textSize || (maxLines >= 0 && i12 != maxLines)) {
                    if (TabLayout.this.f21380D != 1 || f10 <= textSize || lineCount != 1 || ((layout = this.f21450b.getLayout()) != null && e(layout, 0, f10) <= (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) {
                        this.f21450b.setTextSize(0, f10);
                        this.f21450b.setMaxLines(i12);
                        super.onMeasure(i10, i11);
                    }
                }
            }
        }

        public final void p() {
            s();
            g gVar = this.f21449a;
            setSelected(gVar != null && gVar.j());
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean zPerformClick = super.performClick();
            if (this.f21449a == null) {
                return zPerformClick;
            }
            if (!zPerformClick) {
                playSoundEffect(0);
            }
            this.f21449a.l();
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v0, types: [android.graphics.drawable.RippleDrawable] */
        /* JADX WARN: Type inference failed for: r5v0, types: [android.view.View, com.google.android.material.tabs.TabLayout$i] */
        public final void q(Context context) {
            int i10 = TabLayout.this.f21420u;
            if (i10 != 0) {
                Drawable drawableB = C4027a.b(context, i10);
                this.f21457i = drawableB;
                if (drawableB != null && drawableB.isStateful()) {
                    this.f21457i.setState(getDrawableState());
                }
            } else {
                this.f21457i = null;
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(0);
            if (TabLayout.this.f21413n != null) {
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setCornerRadius(1.0E-5f);
                gradientDrawable2.setColor(-1);
                ColorStateList colorStateListA = X2.a.a(TabLayout.this.f21413n);
                boolean z10 = TabLayout.this.f21385I;
                if (z10) {
                    gradientDrawable = null;
                }
                gradientDrawable = new RippleDrawable(colorStateListA, gradientDrawable, z10 ? null : gradientDrawable2);
            }
            setBackground(gradientDrawable);
            TabLayout.this.invalidate();
        }

        public final void r() {
            setOrientation(!TabLayout.this.f21381E ? 1 : 0);
            TextView textView = this.f21455g;
            if (textView == null && this.f21456h == null) {
                t(this.f21450b, this.f21451c, true);
            } else {
                t(textView, this.f21456h, false);
            }
        }

        public final void s() {
            ViewParent parent;
            g gVar = this.f21449a;
            View viewE = gVar != null ? gVar.e() : null;
            if (viewE != null) {
                ViewParent parent2 = viewE.getParent();
                if (parent2 != this) {
                    if (parent2 != null) {
                        ((ViewGroup) parent2).removeView(viewE);
                    }
                    View view = this.f21454f;
                    if (view != null && (parent = view.getParent()) != null) {
                        ((ViewGroup) parent).removeView(this.f21454f);
                    }
                    addView(viewE);
                }
                this.f21454f = viewE;
                TextView textView = this.f21450b;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f21451c;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f21451c.setImageDrawable(null);
                }
                TextView textView2 = (TextView) viewE.findViewById(R.id.text1);
                this.f21455g = textView2;
                if (textView2 != null) {
                    this.f21458j = textView2.getMaxLines();
                }
                this.f21456h = (ImageView) viewE.findViewById(R.id.icon);
            } else {
                View view2 = this.f21454f;
                if (view2 != null) {
                    removeView(view2);
                    this.f21454f = null;
                }
                this.f21455g = null;
                this.f21456h = null;
            }
            if (this.f21454f == null) {
                if (this.f21451c == null) {
                    i();
                }
                if (this.f21450b == null) {
                    j();
                    this.f21458j = this.f21450b.getMaxLines();
                }
                androidx.core.widget.i.m(this.f21450b, TabLayout.this.f21408i);
                if (!isSelected() || TabLayout.this.f21410k == -1) {
                    androidx.core.widget.i.m(this.f21450b, TabLayout.this.f21409j);
                } else {
                    androidx.core.widget.i.m(this.f21450b, TabLayout.this.f21410k);
                }
                ColorStateList colorStateList = TabLayout.this.f21411l;
                if (colorStateList != null) {
                    this.f21450b.setTextColor(colorStateList);
                }
                t(this.f21450b, this.f21451c, true);
                n();
                d(this.f21451c);
                d(this.f21450b);
            } else {
                TextView textView3 = this.f21455g;
                if (textView3 != null || this.f21456h != null) {
                    t(textView3, this.f21456h, false);
                }
            }
            if (gVar == null || TextUtils.isEmpty(gVar.f21439d)) {
                return;
            }
            setContentDescription(gVar.f21439d);
        }

        @Override // android.view.View
        public void setSelected(boolean z10) {
            isSelected();
            super.setSelected(z10);
            TextView textView = this.f21450b;
            if (textView != null) {
                textView.setSelected(z10);
            }
            ImageView imageView = this.f21451c;
            if (imageView != null) {
                imageView.setSelected(z10);
            }
            View view = this.f21454f;
            if (view != null) {
                view.setSelected(z10);
            }
        }

        public void setTab(g gVar) {
            if (gVar != this.f21449a) {
                this.f21449a = gVar;
                p();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x0060  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void t(android.widget.TextView r8, android.widget.ImageView r9, boolean r10) {
            /*
                r7 = this;
                com.google.android.material.tabs.TabLayout$g r0 = r7.f21449a
                r1 = 0
                if (r0 == 0) goto L1a
                android.graphics.drawable.Drawable r0 = r0.f()
                if (r0 == 0) goto L1a
                com.google.android.material.tabs.TabLayout$g r0 = r7.f21449a
                android.graphics.drawable.Drawable r0 = r0.f()
                android.graphics.drawable.Drawable r0 = u0.C5566a.r(r0)
                android.graphics.drawable.Drawable r0 = r0.mutate()
                goto L1b
            L1a:
                r0 = r1
            L1b:
                if (r0 == 0) goto L2d
                com.google.android.material.tabs.TabLayout r2 = com.google.android.material.tabs.TabLayout.this
                android.content.res.ColorStateList r2 = r2.f21412m
                r0.setTintList(r2)
                com.google.android.material.tabs.TabLayout r2 = com.google.android.material.tabs.TabLayout.this
                android.graphics.PorterDuff$Mode r2 = r2.f21416q
                if (r2 == 0) goto L2d
                r0.setTintMode(r2)
            L2d:
                com.google.android.material.tabs.TabLayout$g r2 = r7.f21449a
                if (r2 == 0) goto L36
                java.lang.CharSequence r2 = r2.i()
                goto L37
            L36:
                r2 = r1
            L37:
                r3 = 8
                r4 = 0
                if (r9 == 0) goto L4e
                if (r0 == 0) goto L48
                r9.setImageDrawable(r0)
                r9.setVisibility(r4)
                r7.setVisibility(r4)
                goto L4e
            L48:
                r9.setVisibility(r3)
                r9.setImageDrawable(r1)
            L4e:
                boolean r0 = android.text.TextUtils.isEmpty(r2)
                if (r8 == 0) goto L77
                if (r0 != 0) goto L60
                com.google.android.material.tabs.TabLayout$g r5 = r7.f21449a
                int r5 = com.google.android.material.tabs.TabLayout.g.b(r5)
                r6 = 1
                if (r5 != r6) goto L60
                goto L61
            L60:
                r6 = r4
            L61:
                if (r0 != 0) goto L65
                r5 = r2
                goto L66
            L65:
                r5 = r1
            L66:
                r8.setText(r5)
                if (r6 == 0) goto L6d
                r5 = r4
                goto L6e
            L6d:
                r5 = r3
            L6e:
                r8.setVisibility(r5)
                if (r0 != 0) goto L78
                r7.setVisibility(r4)
                goto L78
            L77:
                r6 = r4
            L78:
                if (r10 == 0) goto Lbc
                if (r9 == 0) goto Lbc
                android.view.ViewGroup$LayoutParams r8 = r9.getLayoutParams()
                android.view.ViewGroup$MarginLayoutParams r8 = (android.view.ViewGroup.MarginLayoutParams) r8
                if (r6 == 0) goto L94
                int r10 = r9.getVisibility()
                if (r10 != 0) goto L94
                android.content.Context r10 = r7.getContext()
                float r10 = com.google.android.material.internal.u.c(r10, r3)
                int r10 = (int) r10
                goto L95
            L94:
                r10 = r4
            L95:
                com.google.android.material.tabs.TabLayout r3 = com.google.android.material.tabs.TabLayout.this
                boolean r3 = r3.f21381E
                if (r3 == 0) goto Lad
                int r3 = r8.getMarginEnd()
                if (r10 == r3) goto Lbc
                r8.setMarginEnd(r10)
                r8.bottomMargin = r4
                r9.setLayoutParams(r8)
                r9.requestLayout()
                goto Lbc
            Lad:
                int r3 = r8.bottomMargin
                if (r10 == r3) goto Lbc
                r8.bottomMargin = r10
                r8.setMarginEnd(r4)
                r9.setLayoutParams(r8)
                r9.requestLayout()
            Lbc:
                com.google.android.material.tabs.TabLayout$g r8 = r7.f21449a
                if (r8 == 0) goto Lc4
                java.lang.CharSequence r1 = com.google.android.material.tabs.TabLayout.g.c(r8)
            Lc4:
                if (r0 != 0) goto Lc7
                goto Lc8
            Lc7:
                r2 = r1
            Lc8:
                androidx.appcompat.widget.Z.a(r7, r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.i.t(android.widget.TextView, android.widget.ImageView, boolean):void");
        }
    }

    public static class j implements d {

        /* renamed from: a, reason: collision with root package name */
        public final ViewPager f21462a;

        public j(ViewPager viewPager) {
            this.f21462a = viewPager;
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void a(g gVar) throws Resources.NotFoundException {
            this.f21462a.setCurrentItem(gVar.g());
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void b(g gVar) {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void c(g gVar) {
        }
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.tabStyle);
    }

    private int getDefaultHeight() {
        int size = this.f21401b.size();
        for (int i10 = 0; i10 < size; i10++) {
            g gVar = this.f21401b.get(i10);
            if (gVar != null && gVar.f() != null && !TextUtils.isEmpty(gVar.i())) {
                return !this.f21381E ? 72 : 48;
            }
        }
        return 48;
    }

    private int getTabMinWidth() {
        int i10 = this.f21422w;
        if (i10 != -1) {
            return i10;
        }
        int i11 = this.f21380D;
        if (i11 == 0 || i11 == 2) {
            return this.f21424y;
        }
        return 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.f21403d.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void setSelectedTabView(int i10) {
        int childCount = this.f21403d.getChildCount();
        if (i10 < childCount) {
            int i11 = 0;
            while (i11 < childCount) {
                View childAt = this.f21403d.getChildAt(i11);
                if ((i11 != i10 || childAt.isSelected()) && (i11 == i10 || !childAt.isSelected())) {
                    childAt.setSelected(i11 == i10);
                    childAt.setActivated(i11 == i10);
                } else {
                    childAt.setSelected(i11 == i10);
                    childAt.setActivated(i11 == i10);
                    if (childAt instanceof i) {
                        ((i) childAt).s();
                    }
                }
                i11++;
            }
        }
    }

    public static ColorStateList t(int i10, int i11) {
        return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{i11, i10});
    }

    public final void A() {
        if (this.f21391O == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.f21391O = valueAnimator;
            valueAnimator.setInterpolator(this.f21387K);
            this.f21391O.setDuration(this.f21378B);
            this.f21391O.addUpdateListener(new a());
        }
    }

    public g B(int i10) {
        if (i10 < 0 || i10 >= getTabCount()) {
            return null;
        }
        return this.f21401b.get(i10);
    }

    public final boolean C() {
        return getTabMode() == 0 || getTabMode() == 2;
    }

    public boolean D() {
        return this.f21382F;
    }

    public g E() {
        g gVarV = v();
        gVarV.f21443h = this;
        gVarV.f21444i = w(gVarV);
        if (gVarV.f21445j != -1) {
            gVarV.f21444i.setId(gVarV.f21445j);
        }
        return gVarV;
    }

    public void F() {
        int currentItem;
        H();
        androidx.viewpager.widget.a aVar = this.f21393Q;
        if (aVar != null) {
            int count = aVar.getCount();
            for (int i10 = 0; i10 < count; i10++) {
                k(E().r(this.f21393Q.getPageTitle(i10)), false);
            }
            ViewPager viewPager = this.f21392P;
            if (viewPager == null || count <= 0 || (currentItem = viewPager.getCurrentItem()) == getSelectedTabPosition() || currentItem >= getTabCount()) {
                return;
            }
            K(B(currentItem));
        }
    }

    public boolean G(g gVar) {
        return f21376b0.release(gVar);
    }

    public void H() {
        for (int childCount = this.f21403d.getChildCount() - 1; childCount >= 0; childCount--) {
            J(childCount);
        }
        Iterator<g> it = this.f21401b.iterator();
        while (it.hasNext()) {
            g next = it.next();
            it.remove();
            next.k();
            G(next);
        }
        this.f21402c = null;
    }

    @Deprecated
    public void I(c cVar) {
        this.f21389M.remove(cVar);
    }

    public final void J(int i10) {
        i iVar = (i) this.f21403d.getChildAt(i10);
        this.f21403d.removeViewAt(i10);
        if (iVar != null) {
            iVar.k();
            this.f21399W.release(iVar);
        }
        requestLayout();
    }

    public void K(g gVar) {
        L(gVar, true);
    }

    public void L(g gVar, boolean z10) {
        g gVar2 = this.f21402c;
        if (gVar2 == gVar) {
            if (gVar2 != null) {
                x(gVar);
                o(gVar.g());
                return;
            }
            return;
        }
        int iG = gVar != null ? gVar.g() : -1;
        if (z10) {
            if ((gVar2 == null || gVar2.g() == -1) && iG != -1) {
                N(iG, 0.0f, true);
            } else {
                o(iG);
            }
            if (iG != -1) {
                setSelectedTabView(iG);
            }
        }
        this.f21402c = gVar;
        if (gVar2 != null && gVar2.f21443h != null) {
            z(gVar2);
        }
        if (gVar != null) {
            y(gVar);
        }
    }

    public void M(androidx.viewpager.widget.a aVar, boolean z10) {
        DataSetObserver dataSetObserver;
        androidx.viewpager.widget.a aVar2 = this.f21393Q;
        if (aVar2 != null && (dataSetObserver = this.f21394R) != null) {
            aVar2.unregisterDataSetObserver(dataSetObserver);
        }
        this.f21393Q = aVar;
        if (z10 && aVar != null) {
            if (this.f21394R == null) {
                this.f21394R = new e();
            }
            aVar.registerDataSetObserver(this.f21394R);
        }
        F();
    }

    public void N(int i10, float f10, boolean z10) {
        O(i10, f10, z10, true);
    }

    public void O(int i10, float f10, boolean z10, boolean z11) {
        P(i10, f10, z10, z11, true);
    }

    public void P(int i10, float f10, boolean z10, boolean z11, boolean z12) {
        int iRound = Math.round(i10 + f10);
        if (iRound < 0 || iRound >= this.f21403d.getChildCount()) {
            return;
        }
        if (z11) {
            this.f21403d.h(i10, f10);
        }
        ValueAnimator valueAnimator = this.f21391O;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f21391O.cancel();
        }
        int iR = r(i10, f10);
        int scrollX = getScrollX();
        boolean z13 = (i10 < getSelectedTabPosition() && iR >= scrollX) || (i10 > getSelectedTabPosition() && iR <= scrollX) || i10 == getSelectedTabPosition();
        if (getLayoutDirection() == 1) {
            z13 = (i10 < getSelectedTabPosition() && iR <= scrollX) || (i10 > getSelectedTabPosition() && iR >= scrollX) || i10 == getSelectedTabPosition();
        }
        if (z13 || this.f21398V == 1 || z12) {
            if (i10 < 0) {
                iR = 0;
            }
            scrollTo(iR, 0);
        }
        if (z10) {
            setSelectedTabView(iRound);
        }
    }

    public void Q(ViewPager viewPager, boolean z10) {
        R(viewPager, z10, false);
    }

    public final void R(ViewPager viewPager, boolean z10, boolean z11) {
        ViewPager viewPager2 = this.f21392P;
        if (viewPager2 != null) {
            h hVar = this.f21395S;
            if (hVar != null) {
                viewPager2.removeOnPageChangeListener(hVar);
            }
            b bVar = this.f21396T;
            if (bVar != null) {
                this.f21392P.removeOnAdapterChangeListener(bVar);
            }
        }
        c cVar = this.f21390N;
        if (cVar != null) {
            I(cVar);
            this.f21390N = null;
        }
        if (viewPager != null) {
            this.f21392P = viewPager;
            if (this.f21395S == null) {
                this.f21395S = new h(this);
            }
            this.f21395S.a();
            viewPager.addOnPageChangeListener(this.f21395S);
            j jVar = new j(viewPager);
            this.f21390N = jVar;
            g(jVar);
            androidx.viewpager.widget.a adapter = viewPager.getAdapter();
            if (adapter != null) {
                M(adapter, z10);
            }
            if (this.f21396T == null) {
                this.f21396T = new b();
            }
            this.f21396T.b(z10);
            viewPager.addOnAdapterChangeListener(this.f21396T);
            N(viewPager.getCurrentItem(), 0.0f, true);
        } else {
            this.f21392P = null;
            M(null, false);
        }
        this.f21397U = z11;
    }

    public final void S() {
        int size = this.f21401b.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f21401b.get(i10).s();
        }
    }

    public final void T(LinearLayout.LayoutParams layoutParams) {
        if (this.f21380D == 1 && this.f21377A == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
        } else {
            layoutParams.width = -2;
            layoutParams.weight = 0.0f;
        }
    }

    public void U(boolean z10) {
        for (int i10 = 0; i10 < this.f21403d.getChildCount(); i10++) {
            View childAt = this.f21403d.getChildAt(i10);
            childAt.setMinimumWidth(getTabMinWidth());
            T((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z10) {
                childAt.requestLayout();
            }
        }
    }

    public void V(int i10) {
        this.f21398V = i10;
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view) {
        n(view);
    }

    @Deprecated
    public void g(c cVar) {
        if (this.f21389M.contains(cVar)) {
            return;
        }
        this.f21389M.add(cVar);
    }

    public int getSelectedTabPosition() {
        g gVar = this.f21402c;
        if (gVar != null) {
            return gVar.g();
        }
        return -1;
    }

    public int getTabCount() {
        return this.f21401b.size();
    }

    public int getTabGravity() {
        return this.f21377A;
    }

    public ColorStateList getTabIconTint() {
        return this.f21412m;
    }

    public int getTabIndicatorAnimationMode() {
        return this.f21384H;
    }

    public int getTabIndicatorGravity() {
        return this.f21379C;
    }

    public int getTabMaxWidth() {
        return this.f21421v;
    }

    public int getTabMode() {
        return this.f21380D;
    }

    public ColorStateList getTabRippleColor() {
        return this.f21413n;
    }

    public Drawable getTabSelectedIndicator() {
        return this.f21414o;
    }

    public ColorStateList getTabTextColors() {
        return this.f21411l;
    }

    public void h(d dVar) {
        g(dVar);
    }

    public void i(g gVar) {
        k(gVar, this.f21401b.isEmpty());
    }

    public void j(g gVar, int i10, boolean z10) {
        if (gVar.f21443h != this) {
            throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
        }
        s(gVar, i10);
        m(gVar);
        if (z10) {
            gVar.l();
        }
    }

    public void k(g gVar, boolean z10) {
        j(gVar, this.f21401b.size(), z10);
    }

    public final void l(b3.c cVar) {
        g gVarE = E();
        CharSequence charSequence = cVar.f15250a;
        if (charSequence != null) {
            gVarE.r(charSequence);
        }
        Drawable drawable = cVar.f15251b;
        if (drawable != null) {
            gVarE.p(drawable);
        }
        int i10 = cVar.f15252c;
        if (i10 != 0) {
            gVarE.n(i10);
        }
        if (!TextUtils.isEmpty(cVar.getContentDescription())) {
            gVarE.m(cVar.getContentDescription());
        }
        i(gVarE);
    }

    public final void m(g gVar) {
        i iVar = gVar.f21444i;
        iVar.setSelected(false);
        iVar.setActivated(false);
        this.f21403d.addView(iVar, gVar.g(), u());
    }

    public final void n(View view) {
        if (!(view instanceof b3.c)) {
            throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
        }
        l((b3.c) view);
    }

    public final void o(int i10) {
        if (i10 == -1) {
            return;
        }
        if (getWindowToken() == null || !isLaidOut() || this.f21403d.d()) {
            N(i10, 0.0f, true);
            return;
        }
        int scrollX = getScrollX();
        int iR = r(i10, 0.0f);
        if (scrollX != iR) {
            A();
            this.f21391O.setIntValues(scrollX, iR);
            this.f21391O.start();
        }
        this.f21403d.c(i10, this.f21378B);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Z2.i.e(this);
        if (this.f21392P == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                R((ViewPager) parent, true, true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f21397U) {
            setupWithViewPager(null);
            this.f21397U = false;
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        for (int i10 = 0; i10 < this.f21403d.getChildCount(); i10++) {
            View childAt = this.f21403d.getChildAt(i10);
            if (childAt instanceof i) {
                ((i) childAt).g(canvas);
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        C0.c.S0(accessibilityNodeInfo).o0(c.f.b(1, getTabCount(), false, 1));
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return C() && super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r7, int r8) {
        /*
            r6 = this;
            android.content.Context r0 = r6.getContext()
            int r1 = r6.getDefaultHeight()
            float r0 = com.google.android.material.internal.u.c(r0, r1)
            int r0 = java.lang.Math.round(r0)
            int r1 = android.view.View.MeasureSpec.getMode(r8)
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 0
            r4 = 1073741824(0x40000000, float:2.0)
            r5 = 1
            if (r1 == r2) goto L2e
            if (r1 == 0) goto L1f
            goto L41
        L1f:
            int r8 = r6.getPaddingTop()
            int r0 = r0 + r8
            int r8 = r6.getPaddingBottom()
            int r0 = r0 + r8
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r4)
            goto L41
        L2e:
            int r1 = r6.getChildCount()
            if (r1 != r5) goto L41
            int r1 = android.view.View.MeasureSpec.getSize(r8)
            if (r1 < r0) goto L41
            android.view.View r1 = r6.getChildAt(r3)
            r1.setMinimumHeight(r0)
        L41:
            int r0 = android.view.View.MeasureSpec.getSize(r7)
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            if (r1 == 0) goto L5f
            int r1 = r6.f21423x
            if (r1 <= 0) goto L50
            goto L5d
        L50:
            float r0 = (float) r0
            android.content.Context r1 = r6.getContext()
            r2 = 56
            float r1 = com.google.android.material.internal.u.c(r1, r2)
            float r0 = r0 - r1
            int r1 = (int) r0
        L5d:
            r6.f21421v = r1
        L5f:
            super.onMeasure(r7, r8)
            int r7 = r6.getChildCount()
            if (r7 != r5) goto Laa
            android.view.View r7 = r6.getChildAt(r3)
            int r0 = r6.f21380D
            if (r0 == 0) goto L82
            if (r0 == r5) goto L76
            r1 = 2
            if (r0 == r1) goto L82
            goto Laa
        L76:
            int r0 = r7.getMeasuredWidth()
            int r1 = r6.getMeasuredWidth()
            if (r0 == r1) goto L81
            goto L8c
        L81:
            return
        L82:
            int r0 = r7.getMeasuredWidth()
            int r1 = r6.getMeasuredWidth()
            if (r0 >= r1) goto Laa
        L8c:
            int r0 = r6.getPaddingTop()
            int r1 = r6.getPaddingBottom()
            int r0 = r0 + r1
            android.view.ViewGroup$LayoutParams r1 = r7.getLayoutParams()
            int r1 = r1.height
            int r8 = android.view.ViewGroup.getChildMeasureSpec(r8, r0, r1)
            int r6 = r6.getMeasuredWidth()
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r4)
            r7.measure(r6, r8)
        Laa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.onMeasure(int, int):void");
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 8 || C()) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public final void p(int i10) {
        if (i10 == 0) {
            Log.w("TabLayout", "MODE_SCROLLABLE + GRAVITY_FILL is not supported, GRAVITY_START will be used instead");
        } else if (i10 == 1) {
            this.f21403d.setGravity(1);
            return;
        } else if (i10 != 2) {
            return;
        }
        this.f21403d.setGravity(8388611);
    }

    public final void q() {
        int i10 = this.f21380D;
        this.f21403d.setPaddingRelative((i10 == 0 || i10 == 2) ? Math.max(0, this.f21425z - this.f21404e) : 0, 0, 0, 0);
        int i11 = this.f21380D;
        if (i11 == 0) {
            p(this.f21377A);
        } else if (i11 == 1 || i11 == 2) {
            if (this.f21377A == 2) {
                Log.w("TabLayout", "GRAVITY_START is not supported with the current tab mode, GRAVITY_CENTER will be used instead");
            }
            this.f21403d.setGravity(1);
        }
        U(true);
    }

    public final int r(int i10, float f10) {
        View childAt;
        int i11 = this.f21380D;
        if ((i11 != 0 && i11 != 2) || (childAt = this.f21403d.getChildAt(i10)) == null) {
            return 0;
        }
        int i12 = i10 + 1;
        View childAt2 = i12 < this.f21403d.getChildCount() ? this.f21403d.getChildAt(i12) : null;
        int width = childAt.getWidth();
        int width2 = childAt2 != null ? childAt2.getWidth() : 0;
        int left = (childAt.getLeft() + (width / 2)) - (getWidth() / 2);
        int i13 = (int) ((width + width2) * 0.5f * f10);
        return getLayoutDirection() == 0 ? left + i13 : left - i13;
    }

    public final void s(g gVar, int i10) {
        gVar.q(i10);
        this.f21401b.add(i10, gVar);
        int size = this.f21401b.size();
        int i11 = -1;
        for (int i12 = i10 + 1; i12 < size; i12++) {
            if (this.f21401b.get(i12).g() == this.f21400a) {
                i11 = i12;
            }
            this.f21401b.get(i12).q(i12);
        }
        this.f21400a = i11;
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        super.setElevation(f10);
        Z2.i.d(this, f10);
    }

    public void setInlineLabel(boolean z10) {
        if (this.f21381E != z10) {
            this.f21381E = z10;
            for (int i10 = 0; i10 < this.f21403d.getChildCount(); i10++) {
                View childAt = this.f21403d.getChildAt(i10);
                if (childAt instanceof i) {
                    ((i) childAt).r();
                }
            }
            q();
        }
    }

    public void setInlineLabelResource(int i10) {
        setInlineLabel(getResources().getBoolean(i10));
    }

    @Deprecated
    public void setOnTabSelectedListener(d dVar) {
        setOnTabSelectedListener((c) dVar);
    }

    public void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        A();
        this.f21391O.addListener(animatorListener);
    }

    public void setSelectedTabIndicator(Drawable drawable) {
        if (drawable == null) {
            drawable = new GradientDrawable();
        }
        Drawable drawableMutate = C5566a.r(drawable).mutate();
        this.f21414o = drawableMutate;
        O2.a.k(drawableMutate, this.f21415p);
        int intrinsicHeight = this.f21383G;
        if (intrinsicHeight == -1) {
            intrinsicHeight = this.f21414o.getIntrinsicHeight();
        }
        this.f21403d.i(intrinsicHeight);
    }

    public void setSelectedTabIndicatorColor(int i10) {
        this.f21415p = i10;
        O2.a.k(this.f21414o, i10);
        U(false);
    }

    public void setSelectedTabIndicatorGravity(int i10) {
        if (this.f21379C != i10) {
            this.f21379C = i10;
            this.f21403d.postInvalidateOnAnimation();
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i10) {
        this.f21383G = i10;
        this.f21403d.i(i10);
    }

    public void setTabGravity(int i10) {
        if (this.f21377A != i10) {
            this.f21377A = i10;
            q();
        }
    }

    public void setTabIconTint(ColorStateList colorStateList) {
        if (this.f21412m != colorStateList) {
            this.f21412m = colorStateList;
            S();
        }
    }

    public void setTabIconTintResource(int i10) {
        setTabIconTint(C4027a.a(getContext(), i10));
    }

    public void setTabIndicatorAnimationMode(int i10) {
        this.f21384H = i10;
        if (i10 == 0) {
            this.f21386J = new com.google.android.material.tabs.a();
            return;
        }
        if (i10 == 1) {
            this.f21386J = new C1447a();
        } else {
            if (i10 == 2) {
                this.f21386J = new b3.b();
                return;
            }
            throw new IllegalArgumentException(i10 + " is not a valid TabIndicatorAnimationMode");
        }
    }

    public void setTabIndicatorFullWidth(boolean z10) {
        this.f21382F = z10;
        this.f21403d.g();
        this.f21403d.postInvalidateOnAnimation();
    }

    public void setTabMode(int i10) {
        if (i10 != this.f21380D) {
            this.f21380D = i10;
            q();
        }
    }

    public void setTabRippleColor(ColorStateList colorStateList) {
        if (this.f21413n != colorStateList) {
            this.f21413n = colorStateList;
            for (int i10 = 0; i10 < this.f21403d.getChildCount(); i10++) {
                View childAt = this.f21403d.getChildAt(i10);
                if (childAt instanceof i) {
                    ((i) childAt).q(getContext());
                }
            }
        }
    }

    public void setTabRippleColorResource(int i10) {
        setTabRippleColor(C4027a.a(getContext(), i10));
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.f21411l != colorStateList) {
            this.f21411l = colorStateList;
            S();
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(androidx.viewpager.widget.a aVar) {
        M(aVar, false);
    }

    public void setUnboundedRipple(boolean z10) {
        if (this.f21385I != z10) {
            this.f21385I = z10;
            for (int i10 = 0; i10 < this.f21403d.getChildCount(); i10++) {
                View childAt = this.f21403d.getChildAt(i10);
                if (childAt instanceof i) {
                    ((i) childAt).q(getContext());
                }
            }
        }
    }

    public void setUnboundedRippleResource(int i10) {
        setUnboundedRipple(getResources().getBoolean(i10));
    }

    public void setupWithViewPager(ViewPager viewPager) {
        Q(viewPager, true);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    public final LinearLayout.LayoutParams u() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        T(layoutParams);
        return layoutParams;
    }

    public g v() {
        g gVarAcquire = f21376b0.acquire();
        return gVarAcquire == null ? new g() : gVarAcquire;
    }

    public final i w(g gVar) {
        B0.e<i> eVar = this.f21399W;
        i iVarAcquire = eVar != null ? eVar.acquire() : null;
        if (iVarAcquire == null) {
            iVarAcquire = new i(getContext());
        }
        iVarAcquire.setTab(gVar);
        iVarAcquire.setFocusable(true);
        iVarAcquire.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(gVar.f21439d)) {
            iVarAcquire.setContentDescription(gVar.f21438c);
            return iVarAcquire;
        }
        iVarAcquire.setContentDescription(gVar.f21439d);
        return iVarAcquire;
    }

    public final void x(g gVar) {
        for (int size = this.f21389M.size() - 1; size >= 0; size--) {
            this.f21389M.get(size).c(gVar);
        }
    }

    public final void y(g gVar) {
        for (int size = this.f21389M.size() - 1; size >= 0; size--) {
            this.f21389M.get(size).a(gVar);
        }
    }

    public final void z(g gVar) {
        for (int size = this.f21389M.size() - 1; size >= 0; size--) {
            this.f21389M.get(size).b(gVar);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public TabLayout(Context context, AttributeSet attributeSet, int i10) throws Resources.NotFoundException {
        int i11 = f21375a0;
        super(C3953a.d(context, attributeSet, i10, i11), attributeSet, i10);
        this.f21400a = -1;
        this.f21401b = new ArrayList<>();
        this.f21410k = -1;
        this.f21415p = 0;
        this.f21421v = Integer.MAX_VALUE;
        this.f21383G = -1;
        this.f21389M = new ArrayList<>();
        this.f21399W = new B0.f(12);
        Context context2 = getContext();
        setHorizontalScrollBarEnabled(false);
        f fVar = new f(context2);
        this.f21403d = fVar;
        super.addView(fVar, 0, new FrameLayout.LayoutParams(-2, -1));
        int[] iArr = R$styleable.TabLayout;
        int i12 = R$styleable.TabLayout_tabTextAppearance;
        TypedArray typedArrayI = r.i(context2, attributeSet, iArr, i10, i11, i12);
        ColorStateList colorStateListF = O2.a.f(getBackground());
        if (colorStateListF != null) {
            Z2.h hVar = new Z2.h();
            hVar.g0(colorStateListF);
            hVar.U(context2);
            hVar.f0(getElevation());
            setBackground(hVar);
        }
        setSelectedTabIndicator(W2.c.d(context2, typedArrayI, R$styleable.TabLayout_tabIndicator));
        setSelectedTabIndicatorColor(typedArrayI.getColor(R$styleable.TabLayout_tabIndicatorColor, 0));
        fVar.i(typedArrayI.getDimensionPixelSize(R$styleable.TabLayout_tabIndicatorHeight, -1));
        setSelectedTabIndicatorGravity(typedArrayI.getInt(R$styleable.TabLayout_tabIndicatorGravity, 0));
        setTabIndicatorAnimationMode(typedArrayI.getInt(R$styleable.TabLayout_tabIndicatorAnimationMode, 0));
        setTabIndicatorFullWidth(typedArrayI.getBoolean(R$styleable.TabLayout_tabIndicatorFullWidth, true));
        int dimensionPixelSize = typedArrayI.getDimensionPixelSize(R$styleable.TabLayout_tabPadding, 0);
        this.f21407h = dimensionPixelSize;
        this.f21406g = dimensionPixelSize;
        this.f21405f = dimensionPixelSize;
        this.f21404e = dimensionPixelSize;
        this.f21404e = typedArrayI.getDimensionPixelSize(R$styleable.TabLayout_tabPaddingStart, dimensionPixelSize);
        this.f21405f = typedArrayI.getDimensionPixelSize(R$styleable.TabLayout_tabPaddingTop, this.f21405f);
        this.f21406g = typedArrayI.getDimensionPixelSize(R$styleable.TabLayout_tabPaddingEnd, this.f21406g);
        this.f21407h = typedArrayI.getDimensionPixelSize(R$styleable.TabLayout_tabPaddingBottom, this.f21407h);
        if (r.g(context2)) {
            this.f21408i = R$attr.textAppearanceTitleSmall;
        } else {
            this.f21408i = R$attr.textAppearanceButton;
        }
        int resourceId = typedArrayI.getResourceId(i12, R$style.TextAppearance_Design_Tab);
        this.f21409j = resourceId;
        int[] iArr2 = androidx.appcompat.R$styleable.TextAppearance;
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(resourceId, iArr2);
        try {
            int i13 = androidx.appcompat.R$styleable.TextAppearance_android_textSize;
            this.f21417r = typedArrayObtainStyledAttributes.getDimensionPixelSize(i13, 0);
            int i14 = androidx.appcompat.R$styleable.TextAppearance_android_textColor;
            this.f21411l = W2.c.a(context2, typedArrayObtainStyledAttributes, i14);
            typedArrayObtainStyledAttributes.recycle();
            int i15 = R$styleable.TabLayout_tabSelectedTextAppearance;
            if (typedArrayI.hasValue(i15)) {
                this.f21410k = typedArrayI.getResourceId(i15, resourceId);
            }
            int i16 = this.f21410k;
            if (i16 != -1) {
                typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(i16, iArr2);
                try {
                    this.f21418s = typedArrayObtainStyledAttributes.getDimensionPixelSize(i13, (int) this.f21417r);
                    ColorStateList colorStateListA = W2.c.a(context2, typedArrayObtainStyledAttributes, i14);
                    if (colorStateListA != null) {
                        this.f21411l = t(this.f21411l.getDefaultColor(), colorStateListA.getColorForState(new int[]{R.attr.state_selected}, colorStateListA.getDefaultColor()));
                    }
                } finally {
                }
            }
            int i17 = R$styleable.TabLayout_tabTextColor;
            if (typedArrayI.hasValue(i17)) {
                this.f21411l = W2.c.a(context2, typedArrayI, i17);
            }
            int i18 = R$styleable.TabLayout_tabSelectedTextColor;
            if (typedArrayI.hasValue(i18)) {
                this.f21411l = t(this.f21411l.getDefaultColor(), typedArrayI.getColor(i18, 0));
            }
            this.f21412m = W2.c.a(context2, typedArrayI, R$styleable.TabLayout_tabIconTint);
            this.f21416q = u.i(typedArrayI.getInt(R$styleable.TabLayout_tabIconTintMode, -1), null);
            this.f21413n = W2.c.a(context2, typedArrayI, R$styleable.TabLayout_tabRippleColor);
            this.f21378B = typedArrayI.getInt(R$styleable.TabLayout_tabIndicatorAnimationDuration, 300);
            this.f21387K = T2.h.g(context2, R$attr.motionEasingEmphasizedInterpolator, E2.a.f2340b);
            this.f21422w = typedArrayI.getDimensionPixelSize(R$styleable.TabLayout_tabMinWidth, -1);
            this.f21423x = typedArrayI.getDimensionPixelSize(R$styleable.TabLayout_tabMaxWidth, -1);
            this.f21420u = typedArrayI.getResourceId(R$styleable.TabLayout_tabBackground, 0);
            this.f21425z = typedArrayI.getDimensionPixelSize(R$styleable.TabLayout_tabContentStart, 0);
            this.f21380D = typedArrayI.getInt(R$styleable.TabLayout_tabMode, 1);
            this.f21377A = typedArrayI.getInt(R$styleable.TabLayout_tabGravity, 0);
            this.f21381E = typedArrayI.getBoolean(R$styleable.TabLayout_tabInlineLabel, false);
            this.f21385I = typedArrayI.getBoolean(R$styleable.TabLayout_tabUnboundedRipple, false);
            typedArrayI.recycle();
            Resources resources = getResources();
            this.f21419t = resources.getDimensionPixelSize(R$dimen.design_tab_text_size_2line);
            this.f21424y = resources.getDimensionPixelSize(R$dimen.design_tab_scrollable_min_width);
            q();
        } finally {
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i10) {
        n(view);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    @Deprecated
    public void setOnTabSelectedListener(c cVar) {
        c cVar2 = this.f21388L;
        if (cVar2 != null) {
            I(cVar2);
        }
        this.f21388L = cVar;
        if (cVar != null) {
            g(cVar);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        n(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        n(view);
    }

    public void setSelectedTabIndicator(int i10) {
        if (i10 != 0) {
            setSelectedTabIndicator(C4027a.b(getContext(), i10));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }
}
