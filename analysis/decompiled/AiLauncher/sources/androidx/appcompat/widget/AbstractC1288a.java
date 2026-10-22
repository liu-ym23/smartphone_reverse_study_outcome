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
import androidx.appcompat.R$attr;
import androidx.appcompat.R$styleable;

/* renamed from: androidx.appcompat.widget.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1288a extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    public final C0129a f9165a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f9166b;

    /* renamed from: c, reason: collision with root package name */
    public ActionMenuView f9167c;

    /* renamed from: d, reason: collision with root package name */
    public ActionMenuPresenter f9168d;

    /* renamed from: e, reason: collision with root package name */
    public int f9169e;

    /* renamed from: f, reason: collision with root package name */
    public androidx.core.view.U f9170f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f9171g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f9172h;

    /* renamed from: androidx.appcompat.widget.a$a, reason: collision with other inner class name */
    public class C0129a implements androidx.core.view.V {

        /* renamed from: a, reason: collision with root package name */
        public boolean f9173a = false;

        /* renamed from: b, reason: collision with root package name */
        public int f9174b;

        public C0129a() {
        }

        public C0129a a(androidx.core.view.U u10, int i10) {
            AbstractC1288a.this.f9170f = u10;
            this.f9174b = i10;
            return this;
        }

        @Override // androidx.core.view.V
        public void c(View view) {
            this.f9173a = true;
        }

        @Override // androidx.core.view.V
        public void d(View view) {
            if (this.f9173a) {
                return;
            }
            AbstractC1288a abstractC1288a = AbstractC1288a.this;
            abstractC1288a.f9170f = null;
            AbstractC1288a.super.setVisibility(this.f9174b);
        }

        @Override // androidx.core.view.V
        public void e(View view) {
            AbstractC1288a.super.setVisibility(0);
            this.f9173a = false;
        }
    }

    public AbstractC1288a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static int d(int i10, int i11, boolean z10) {
        return z10 ? i10 - i11 : i10 + i11;
    }

    public int c(View view, int i10, int i11, int i12) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i10, Integer.MIN_VALUE), i11);
        return Math.max(0, (i10 - view.getMeasuredWidth()) - i12);
    }

    public int e(View view, int i10, int i11, int i12, boolean z10) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i13 = i11 + ((i12 - measuredHeight) / 2);
        if (z10) {
            view.layout(i10 - measuredWidth, i13, i10, measuredHeight + i13);
        } else {
            view.layout(i10, i13, i10 + measuredWidth, measuredHeight + i13);
        }
        return z10 ? -measuredWidth : measuredWidth;
    }

    public androidx.core.view.U f(int i10, long j10) {
        androidx.core.view.U u10 = this.f9170f;
        if (u10 != null) {
            u10.c();
        }
        if (i10 != 0) {
            androidx.core.view.U uB = androidx.core.view.N.d(this).b(0.0f);
            uB.f(j10);
            uB.h(this.f9165a.a(uB, i10));
            return uB;
        }
        if (getVisibility() != 0) {
            setAlpha(0.0f);
        }
        androidx.core.view.U uB2 = androidx.core.view.N.d(this).b(1.0f);
        uB2.f(j10);
        uB2.h(this.f9165a.a(uB2, i10));
        return uB2;
    }

    public int getAnimatedVisibility() {
        return this.f9170f != null ? this.f9165a.f9174b : getVisibility();
    }

    public int getContentHeight() {
        return this.f9169e;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, R$styleable.ActionBar, R$attr.actionBarStyle, 0);
        setContentHeight(typedArrayObtainStyledAttributes.getLayoutDimension(R$styleable.ActionBar_height, 0));
        typedArrayObtainStyledAttributes.recycle();
        ActionMenuPresenter actionMenuPresenter = this.f9168d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.H(configuration);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f9172h = false;
        }
        if (!this.f9172h) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.f9172h = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f9172h = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f9171g = false;
        }
        if (!this.f9171g) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.f9171g = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f9171g = false;
        }
        return true;
    }

    public void setContentHeight(int i10) {
        this.f9169e = i10;
        requestLayout();
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        if (i10 != getVisibility()) {
            androidx.core.view.U u10 = this.f9170f;
            if (u10 != null) {
                u10.c();
            }
            super.setVisibility(i10);
        }
    }

    public AbstractC1288a(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f9165a = new C0129a();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(R$attr.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.f9166b = context;
        } else {
            this.f9166b = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }
}
