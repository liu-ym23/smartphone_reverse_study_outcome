package androidx.appcompat.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R$attr;
import androidx.appcompat.app.ActionBar;
import com.google.common.primitives.Ints;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ScrollingTabContainerView extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Interpolator f873l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Runnable f874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f875b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LinearLayoutCompat f876c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Spinner f877d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f878e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f879f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f880g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f881h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f882i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ViewPropertyAnimator f883j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final e f884k;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f885a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ScrollingTabContainerView f886b;

        public a(ScrollingTabContainerView r10, View r11) {
            this.f886b = r10;
            this.f885a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            int r10 = this.f885a.getLeft() - ((this.f886b.getWidth() - this.f885a.getWidth()) / 2);
            this.f886b.smoothScrollTo(r10, 0);
            this.f886b.f874a = null;
        }
    }

    public class b extends BaseAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ScrollingTabContainerView f887a;

        public b(ScrollingTabContainerView r10) {
            this.f887a = r10;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f887a.f876c.getChildCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int r10) {
            ((d) this.f887a.f876c.getChildAt(r10)).b();
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int r10) {
            return r10;
        }

        @Override // android.widget.Adapter
        public View getView(int r10, View r11, ViewGroup r12) {
            if (r11 != null) goto L5;
            ScrollingTabContainerView r13 = this.f887a;
            p.a(getItem(r10));
            return r13.d(null, true);
        L5:
            p.a(getItem(r10));
            ((d) r11).a(null);
            return r11;
        }
    }

    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ScrollingTabContainerView f888a;

        public c(ScrollingTabContainerView r10) {
            this.f888a = r10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r10) {
            ((d) r10).b();
            throw null;
        }
    }

    public class d extends LinearLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int[] f889a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ScrollingTabContainerView f890b;

        public d(ScrollingTabContainerView r10, Context r11, ActionBar.a r12, boolean r13) {
            this.f890b = r10;
            int r14 = R$attr.actionBarTabStyle;
            super(r11, null, r14);
            int[] r15 = {R.attr.background};
            this.f889a = r15;
            b0 r16 = b0.v(r11, null, r15, r14, 0);
            if (r16.s(0) == false) goto L5;
            setBackgroundDrawable(r16.g(0));
        L5:
            r16.w();
            if (r13 == false) goto L8;
            setGravity(8388627);
        L8:
            c();
        }

        public void a(ActionBar.a r10) {
            c();
        }

        public ActionBar.a b() {
            return null;
        }

        public void c() {
            throw null;
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent r10) {
            super.onInitializeAccessibilityEvent(r10);
            r10.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r10) {
            super.onInitializeAccessibilityNodeInfo(r10);
            r10.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int r10, int r11) {
            super.onMeasure(r10, r11);
            if (this.f890b.f879f <= 0) goto L8;
            int r12 = getMeasuredWidth();
            int r13 = this.f890b.f879f;
            if (r12 <= r13) goto L9;
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(r13, Ints.MAX_POWER_OF_TWO), r11);
            return;
        L9:
            return;
        }

        @Override // android.view.View
        public void setSelected(boolean r10) {
            if (isSelected() == r10) goto L5;
            boolean r11 = true;
        L6:
            super.setSelected(r10);
            if (r11 == false) goto L11;
            if (r10 == false) goto L12;
            sendAccessibilityEvent(4);
            return;
        L12:
            return;
        L11:
            return;
        L5:
            r11 = false;
            goto L6
        }
    }

    public class e extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f891a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f892b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ScrollingTabContainerView f893c;

        public e(ScrollingTabContainerView r10) {
            this.f893c = r10;
            this.f891a = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r10) {
            this.f891a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            if (this.f891a == false) goto L5;
            return;
        L5:
            ScrollingTabContainerView r11 = this.f893c;
            r11.f883j = null;
            r11.setVisibility(this.f892b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r10) {
            this.f893c.setVisibility(0);
            this.f891a = false;
        }
    }

    static {
        f873l = new DecelerateInterpolator();
    }

    public ScrollingTabContainerView(@NonNull Context r10) {
        super(r10);
        this.f884k = new e(this);
        setHorizontalScrollBarEnabled(false);
        g.a r11 = g.a.b(r10);
        setContentHeight(r11.f());
        this.f880g = r11.e();
        LinearLayoutCompat r12 = c();
        this.f876c = r12;
        addView(r12, new ViewGroup.LayoutParams(-2, -1));
    }

    public void a(int r10) {
        View r11 = this.f876c.getChildAt(r10);
        Runnable r12 = this.f874a;
        if (r12 == null) goto L5;
        removeCallbacks(r12);
    L5:
        a r13 = new a(this, r11);
        this.f874a = r13;
        post(r13);
    }

    public final Spinner b() {
        AppCompatSpinner r10 = new AppCompatSpinner(getContext(), null, R$attr.actionDropDownStyle);
        r10.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        r10.setOnItemSelectedListener(this);
        return r10;
    }

    public final LinearLayoutCompat c() {
        LinearLayoutCompat r10 = new LinearLayoutCompat(getContext(), null, R$attr.actionBarTabBarStyle);
        r10.setMeasureWithLargestChildEnabled(true);
        r10.setGravity(17);
        r10.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        return r10;
    }

    public d d(ActionBar.a r10, boolean r11) {
        d r12 = new d(this, getContext(), r10, r11);
        if (r11 == false) goto L5;
        r12.setBackgroundDrawable(null);
        r12.setLayoutParams(new AbsListView.LayoutParams(-1, this.f881h));
    L9:
        return r12;
    L5:
        r12.setFocusable(true);
        if (this.f875b != null) goto L8;
        this.f875b = new c(this);
    L8:
        r12.setOnClickListener(this.f875b);
        goto L9
    }

    public final boolean e() {
        Spinner r10 = this.f877d;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.getParent() != this) goto L7;
        return true;
    }

    public final void f() {
        if (e() == false) goto L6;
        return;
    L6:
        if (this.f877d != null) goto L8;
        this.f877d = b();
    L8:
        removeView(this.f876c);
        addView(this.f877d, new ViewGroup.LayoutParams(-2, -1));
        if (this.f877d.getAdapter() != null) goto L11;
        this.f877d.setAdapter(new b(this));
    L11:
        Runnable r10 = this.f874a;
        if (r10 == null) goto L14;
        removeCallbacks(r10);
        this.f874a = null;
    L14:
        this.f877d.setSelection(this.f882i);
    }

    public final boolean g() {
        if (e() == true) goto L5;
        return false;
    L5:
        removeView(this.f877d);
        addView(this.f876c, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.f877d.getSelectedItemPosition());
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable r10 = this.f874a;
        if (r10 == null) goto L6;
        post(r10);
        return;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r10) {
        super.onConfigurationChanged(r10);
        g.a r11 = g.a.b(getContext());
        setContentHeight(r11.f());
        this.f880g = r11.e();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable r10 = this.f874a;
        if (r10 == null) goto L6;
        removeCallbacks(r10);
        return;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView r10, View r11, int r12, long r13) {
        ((d) r11).b();
        throw null;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        int r12 = View.MeasureSpec.getMode(r10);
        if (r12 != 1073741824) goto L5;
        boolean r13 = true;
    L6:
        setFillViewport(r13);
        int r14 = this.f876c.getChildCount();
        if (r14 <= 1) goto L16;
        if (r12 == 1073741824) goto L12;
        if (r12 != Integer.MIN_VALUE) goto L16;
    L12:
        if (r14 <= 2) goto L14;
        this.f879f = (int) (View.MeasureSpec.getSize(r10) * 0.4f);
    L15:
        this.f879f = Math.min(this.f879f, this.f880g);
    L17:
        int r15 = View.MeasureSpec.makeMeasureSpec(this.f881h, Ints.MAX_POWER_OF_TWO);
        if (r13 == false) goto L20;
    L25:
        g();
    L26:
        int r16 = getMeasuredWidth();
        super.onMeasure(r10, r15);
        int r17 = getMeasuredWidth();
        if (r13 == false) goto L31;
        if (r16 == r17) goto L32;
        setTabSelected(this.f882i);
        return;
    L32:
        return;
    L31:
        return;
    L20:
        if (this.f878e == false) goto L25;
        this.f876c.measure(0, r15);
        if (this.f876c.getMeasuredWidth() <= View.MeasureSpec.getSize(r10)) goto L24;
        f();
        goto L26
    L24:
        g();
        goto L26
    L14:
        this.f879f = View.MeasureSpec.getSize(r10) / 2;
    L16:
        this.f879f = -1;
        goto L17
    L5:
        r13 = false;
        goto L6
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView r10) {
    }

    public void setAllowCollapse(boolean r10) {
        this.f878e = r10;
    }

    public void setContentHeight(int r10) {
        this.f881h = r10;
        requestLayout();
    }

    public void setTabSelected(int r10) {
        this.f882i = r10;
        int r11 = this.f876c.getChildCount();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L12;
        View r13 = this.f876c.getChildAt(r12);
        if (r12 != r10) goto L7;
        boolean r14 = true;
    L8:
        r13.setSelected(r14);
        if (r14 == false) goto L11;
        a(r10);
    L11:
        r12 = r12 + 1;
        goto L3
    L7:
        r14 = false;
        goto L8
    L12:
        Spinner r15 = this.f877d;
        if (r15 == null) goto L20;
        if (r10 < 0) goto L21;
        r15.setSelection(r10);
        return;
    L21:
        return;
    }
}
