package stepos.support.v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AdapterView;
import android.widget.HorizontalScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.LinearLayoutCompat;
import stepos.support.v7.app.a;

/* loaded from: classes5.dex */
public class r extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {

    /* renamed from: r, reason: collision with root package name */
    public static final Interpolator f41689r = D0.a.a(0.17f, 0.17f, 0.2f, 1.0f);

    /* renamed from: s, reason: collision with root package name */
    public static final Interpolator f41690s = D0.a.a(0.33f, 0.0f, 0.83f, 0.83f);

    /* renamed from: t, reason: collision with root package name */
    public static final Interpolator f41691t = D0.a.a(0.17f, 0.17f, 0.2f, 1.0f);

    /* renamed from: u, reason: collision with root package name */
    public static final Interpolator f41692u = new DecelerateInterpolator();

    /* renamed from: a, reason: collision with root package name */
    public Runnable f41693a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f41694b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f41695c;

    /* renamed from: d, reason: collision with root package name */
    public int f41696d;

    /* renamed from: e, reason: collision with root package name */
    public int f41697e;

    /* renamed from: f, reason: collision with root package name */
    public int f41698f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f41699g;

    /* renamed from: h, reason: collision with root package name */
    public int f41700h;

    /* renamed from: i, reason: collision with root package name */
    public int f41701i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f41702j;

    /* renamed from: k, reason: collision with root package name */
    public int f41703k;

    /* renamed from: l, reason: collision with root package name */
    public int f41704l;

    /* renamed from: m, reason: collision with root package name */
    public int f41705m;

    /* renamed from: n, reason: collision with root package name */
    public int f41706n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f41707o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f41708p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f41709q;

    @SuppressLint({"RestrictedApi"})
    public class a extends LinearLayoutCompat implements View.OnLongClickListener {

        /* renamed from: a, reason: collision with root package name */
        public a.h f41710a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f41711b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ r f41712c;

        public a.h g() {
            return this.f41710a;
        }

        @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(a.h.class.getName());
        }

        @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(a.h.class.getName());
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            Context context = getContext();
            int width = getWidth();
            int height = getHeight();
            int i10 = context.getResources().getDisplayMetrics().widthPixels;
            Toast toastMakeText = Toast.makeText(context, this.f41710a.a(), 0);
            toastMakeText.setGravity(49, (iArr[0] + (width / 2)) - (i10 / 2), height);
            toastMakeText.show();
            return true;
        }

        @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
        public void onMeasure(int i10, int i11) {
            super.onMeasure(i10, i11);
            if (this.f41712c.f41701i <= 0 || getMeasuredWidth() >= this.f41712c.f41701i || this.f41712c.f41707o) {
                return;
            }
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.f41712c.f41701i, 1073741824), i11);
        }

        @Override // android.view.View
        public void setSelected(boolean z10) {
            boolean z11 = isSelected() != z10;
            super.setSelected(z10);
            if (z11 && z10) {
                sendAccessibilityEvent(4);
            }
            if (!this.f41712c.j()) {
                if (z10) {
                    this.f41711b.setTextColor(this.f41712c.f41705m);
                    return;
                } else {
                    this.f41711b.setTextColor(this.f41712c.f41706n);
                    return;
                }
            }
            Drawable background = getBackground();
            if (z10) {
                this.f41711b.setTextColor(this.f41712c.f41705m);
                background.setTint(this.f41712c.f41703k);
            } else {
                this.f41711b.setTextColor(this.f41712c.f41706n);
                background.setTint(this.f41712c.f41704l);
            }
        }
    }

    private void setSelectedTabView(int i10) {
        throw null;
    }

    private void setTabsGravityInner(int i10) {
    }

    public float getContentBottom() {
        throw null;
    }

    public int getContentStart() {
        getPaddingStart();
        throw null;
    }

    public int getTabStripWidth() {
        throw null;
    }

    public void h(int i10, boolean z10) {
        this.f41698f = i10;
        throw null;
    }

    public void i(boolean z10) {
        if (this.f41708p != z10) {
            this.f41708p = z10;
            Ic.a aVarB = Ic.a.b(getContext());
            setContentHeight(this.f41708p ? aVarB.c() : aVarB.h());
        }
    }

    public final boolean j() {
        return this.f41702j && !this.f41708p;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.f41693a;
        if (runnable != null) {
            post(runnable);
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        Ic.a aVarB = Ic.a.b(getContext());
        int iC = this.f41708p ? aVarB.c() : aVarB.h();
        if (j()) {
            setContentHeight((int) O6.s.a(55.0f, getContext()));
        } else {
            setContentHeight(iC);
        }
        this.f41696d = aVarB.g();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f41693a;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i10, long j10) {
        ((a) view).g().b();
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        setFillViewport(View.MeasureSpec.getMode(i10) == 1073741824);
        setTabsGravity(this.f41700h);
        throw null;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void setAdaptTabWidthNoScroll(boolean z10) {
        if (this.f41707o == z10) {
            return;
        }
        this.f41707o = z10;
        requestLayout();
    }

    public void setAllowCollapse(boolean z10) {
        this.f41694b = z10;
    }

    public void setCapsuleStyleEnable(boolean z10) {
        this.f41702j = z10;
        if (j()) {
            new Gc.a().a((int) O6.s.a(16.0f, getContext()));
            throw null;
        }
    }

    public void setContentHeight(int i10) {
        this.f41697e = i10;
        requestLayout();
    }

    public void setEqualTabWidth(boolean z10) {
        this.f41699g = z10;
    }

    public void setIndicatorDrawable(Drawable drawable) {
        throw null;
    }

    public void setIsAloneTabContainer(boolean z10) {
        this.f41709q = z10;
    }

    public void setNeedCollapse(boolean z10) {
        this.f41695c = z10;
    }

    public void setTabSelected(int i10) {
        h(i10, false);
    }

    public void setTabsGravity(int i10) {
        this.f41700h = i10;
    }
}
