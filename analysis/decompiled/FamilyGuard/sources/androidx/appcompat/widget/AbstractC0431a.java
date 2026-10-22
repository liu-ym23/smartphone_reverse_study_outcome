package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import g.C0728a;

/* renamed from: androidx.appcompat.widget.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
abstract class AbstractC0431a extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    protected final C0107a f8467a;

    /* renamed from: b, reason: collision with root package name */
    protected final Context f8468b;

    /* renamed from: c, reason: collision with root package name */
    protected ActionMenuView f8469c;

    /* renamed from: d, reason: collision with root package name */
    protected C0433c f8470d;

    /* renamed from: e, reason: collision with root package name */
    protected int f8471e;

    /* renamed from: f, reason: collision with root package name */
    protected androidx.core.view.S f8472f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f8473g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f8474h;

    /* renamed from: androidx.appcompat.widget.a$a, reason: collision with other inner class name */
    protected class C0107a implements androidx.core.view.T {

        /* renamed from: a, reason: collision with root package name */
        private boolean f8475a = false;

        /* renamed from: b, reason: collision with root package name */
        int f8476b;

        protected C0107a() {
        }

        public C0107a a(androidx.core.view.S s5, int i5) {
            AbstractC0431a.this.f8472f = s5;
            this.f8476b = i5;
            return this;
        }

        @Override // androidx.core.view.T
        public void c(View view) {
            this.f8475a = true;
        }

        @Override // androidx.core.view.T
        public void d(View view) {
            if (this.f8475a) {
                return;
            }
            AbstractC0431a abstractC0431a = AbstractC0431a.this;
            abstractC0431a.f8472f = null;
            AbstractC0431a.super.setVisibility(this.f8476b);
        }

        @Override // androidx.core.view.T
        public void e(View view) {
            AbstractC0431a.super.setVisibility(0);
            this.f8475a = false;
        }
    }

    AbstractC0431a(Context context, AttributeSet attributeSet) {
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

    public androidx.core.view.S f(int i5, long j5) {
        androidx.core.view.S s5 = this.f8472f;
        if (s5 != null) {
            s5.c();
        }
        if (i5 != 0) {
            androidx.core.view.S sB = androidx.core.view.H.d(this).b(0.0f);
            sB.h(j5);
            sB.j(this.f8467a.a(sB, i5));
            return sB;
        }
        if (getVisibility() != 0) {
            setAlpha(0.0f);
        }
        androidx.core.view.S sB2 = androidx.core.view.H.d(this).b(1.0f);
        sB2.h(j5);
        sB2.j(this.f8467a.a(sB2, i5));
        return sB2;
    }

    public int getAnimatedVisibility() {
        return this.f8472f != null ? this.f8467a.f8476b : getVisibility();
    }

    public int getContentHeight() {
        return this.f8471e;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, g.j.f17094a, C0728a.f16826c, 0);
        setContentHeight(typedArrayObtainStyledAttributes.getLayoutDimension(g.j.f17139j, 0));
        typedArrayObtainStyledAttributes.recycle();
        C0433c c0433c = this.f8470d;
        if (c0433c != null) {
            c0433c.F(configuration);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f8474h = false;
        }
        if (!this.f8474h) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.f8474h = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f8474h = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f8473g = false;
        }
        if (!this.f8473g) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.f8473g = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f8473g = false;
        }
        return true;
    }

    public void setContentHeight(int i5) {
        this.f8471e = i5;
        requestLayout();
    }

    @Override // android.view.View
    public void setVisibility(int i5) {
        if (i5 != getVisibility()) {
            androidx.core.view.S s5 = this.f8472f;
            if (s5 != null) {
                s5.c();
            }
            super.setVisibility(i5);
        }
    }

    AbstractC0431a(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f8467a = new C0107a();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(C0728a.f16824a, typedValue, true) || typedValue.resourceId == 0) {
            this.f8468b = context;
        } else {
            this.f8468b = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }
}
