package stepos.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.core.view.C0473s;
import androidx.core.view.H;
import androidx.core.view.S;
import androidx.core.view.T;
import g.C0728a;

/* renamed from: stepos.support.v7.widget.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
abstract class AbstractC1098a extends ViewGroup {

    /* renamed from: l, reason: collision with root package name */
    static final Interpolator f21902l = androidx.core.view.animation.a.a(0.33f, 0.0f, 0.66f, 1.0f);

    /* renamed from: a, reason: collision with root package name */
    protected final C0247a f21903a;

    /* renamed from: b, reason: collision with root package name */
    protected final Context f21904b;

    /* renamed from: c, reason: collision with root package name */
    protected ActionMenuView f21905c;

    /* renamed from: d, reason: collision with root package name */
    protected d f21906d;

    /* renamed from: e, reason: collision with root package name */
    protected ViewGroup f21907e;

    /* renamed from: f, reason: collision with root package name */
    protected boolean f21908f;

    /* renamed from: g, reason: collision with root package name */
    protected boolean f21909g;

    /* renamed from: h, reason: collision with root package name */
    protected int f21910h;

    /* renamed from: i, reason: collision with root package name */
    protected S f21911i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f21912j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f21913k;

    /* renamed from: stepos.support.v7.widget.a$a, reason: collision with other inner class name */
    protected class C0247a implements T {

        /* renamed from: a, reason: collision with root package name */
        private boolean f21914a = false;

        /* renamed from: b, reason: collision with root package name */
        int f21915b;

        protected C0247a() {
        }

        public C0247a a(S s5, int i5) {
            AbstractC1098a.this.f21911i = s5;
            this.f21915b = i5;
            return this;
        }

        @Override // androidx.core.view.T
        public void c(View view) {
            this.f21914a = true;
        }

        @Override // androidx.core.view.T
        public void d(View view) {
            if (this.f21914a) {
                return;
            }
            AbstractC1098a abstractC1098a = AbstractC1098a.this;
            abstractC1098a.f21911i = null;
            AbstractC1098a.super.setVisibility(this.f21915b);
        }

        @Override // androidx.core.view.T
        public void e(View view) {
            AbstractC1098a.super.setVisibility(0);
            this.f21914a = false;
        }
    }

    AbstractC1098a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    protected static int d(int i5, int i6, boolean z5) {
        return z5 ? i5 - i6 : i5 + i6;
    }

    protected int c(View view, int i5, int i6, int i7) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE), i6);
        return Math.max(0, (i5 - view.getMeasuredWidth()) - i7);
    }

    protected int e(View view, int i5, int i6, int i7, boolean z5) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i8 = i6 + ((i7 - measuredHeight) / 2);
        if (z5) {
            view.layout(i5 - measuredWidth, i8, i5, measuredHeight + i8);
        } else {
            view.layout(i5, i8, i5 + measuredWidth, measuredHeight + i8);
        }
        return z5 ? -measuredWidth : measuredWidth;
    }

    public S f(int i5, long j5) {
        S s5 = this.f21911i;
        if (s5 != null) {
            s5.c();
        }
        if (i5 != 0) {
            S sB = H.d(this).b(0.0f);
            sB.h(j5);
            sB.j(this.f21903a.a(sB, i5));
            return sB;
        }
        if (getVisibility() != 0) {
            H.n0(this, 0.0f);
        }
        S sB2 = H.d(this).b(1.0f);
        sB2.h(j5);
        sB2.j(this.f21903a.a(sB2, i5));
        return sB2;
    }

    public int getAnimatedVisibility() {
        return this.f21911i != null ? this.f21903a.f21915b : getVisibility();
    }

    public int getContentHeight() {
        return this.f21910h;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        super.onConfigurationChanged(configuration);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, g.j.f17094a, N1.a.c() ? X4.a.f5832h : C0728a.f16826c, 0);
        setContentHeight(typedArrayObtainStyledAttributes.getLayoutDimension(g.j.f17139j, 0));
        typedArrayObtainStyledAttributes.recycle();
        d dVar = this.f21906d;
        if (dVar != null) {
            dVar.R(configuration);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int iC = C0473s.c(motionEvent);
        if (iC == 9) {
            this.f21913k = false;
        }
        if (!this.f21913k) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (iC == 9 && !zOnHoverEvent) {
                this.f21913k = true;
            }
        }
        if (iC == 10 || iC == 3) {
            this.f21913k = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int iC = C0473s.c(motionEvent);
        if (iC == 0) {
            this.f21912j = false;
        }
        if (!this.f21912j) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (iC == 0 && !zOnTouchEvent) {
                this.f21912j = true;
            }
        }
        if (iC == 1 || iC == 3) {
            this.f21912j = false;
        }
        return true;
    }

    public void setContentHeight(int i5) {
        this.f21910h = i5;
        requestLayout();
    }

    public void setSplitToolbar(boolean z5) {
        this.f21908f = z5;
    }

    public void setSplitView(ViewGroup viewGroup) {
        this.f21907e = viewGroup;
    }

    public void setSplitWhenNarrow(boolean z5) {
        this.f21909g = z5;
    }

    @Override // android.view.View
    public void setVisibility(int i5) {
        if (i5 != getVisibility()) {
            S s5 = this.f21911i;
            if (s5 != null) {
                s5.c();
            }
            super.setVisibility(i5);
        }
    }

    AbstractC1098a(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f21903a = new C0247a();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(C0728a.f16824a, typedValue, true) || typedValue.resourceId == 0) {
            this.f21904b = context;
        } else {
            this.f21904b = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }
}
