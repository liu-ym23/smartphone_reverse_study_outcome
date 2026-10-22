package stepos.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.appcompat.R$styleable;
import androidx.core.view.C1330s;
import androidx.core.view.N;
import androidx.core.view.U;
import androidx.core.view.V;
import stepos.support.v7.appcompat.R$attr;

/* loaded from: classes5.dex */
public abstract class a extends ViewGroup {

    /* renamed from: l, reason: collision with root package name */
    public static final Interpolator f41516l = D0.a.a(0.33f, 0.0f, 0.66f, 1.0f);

    /* renamed from: a, reason: collision with root package name */
    public final C0527a f41517a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f41518b;

    /* renamed from: c, reason: collision with root package name */
    public ActionMenuView f41519c;

    /* renamed from: d, reason: collision with root package name */
    public ActionMenuPresenter f41520d;

    /* renamed from: e, reason: collision with root package name */
    public ViewGroup f41521e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f41522f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f41523g;

    /* renamed from: h, reason: collision with root package name */
    public int f41524h;

    /* renamed from: i, reason: collision with root package name */
    public U f41525i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f41526j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f41527k;

    /* renamed from: stepos.support.v7.widget.a$a, reason: collision with other inner class name */
    public class C0527a implements V {

        /* renamed from: a, reason: collision with root package name */
        public boolean f41528a = false;

        /* renamed from: b, reason: collision with root package name */
        public int f41529b;

        public C0527a() {
        }

        public C0527a a(U u10, int i10) {
            a.this.f41525i = u10;
            this.f41529b = i10;
            return this;
        }

        @Override // androidx.core.view.V
        public void c(View view) {
            this.f41528a = true;
        }

        @Override // androidx.core.view.V
        public void d(View view) {
            if (this.f41528a) {
                return;
            }
            a aVar = a.this;
            aVar.f41525i = null;
            a.super.setVisibility(this.f41529b);
        }

        @Override // androidx.core.view.V
        public void e(View view) {
            a.super.setVisibility(0);
            this.f41528a = false;
        }
    }

    public a(Context context, AttributeSet attributeSet) {
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

    public U f(int i10, long j10) {
        U u10 = this.f41525i;
        if (u10 != null) {
            u10.c();
        }
        if (i10 != 0) {
            U uB = N.d(this).b(0.0f);
            uB.f(j10);
            uB.h(this.f41517a.a(uB, i10));
            return uB;
        }
        if (getVisibility() != 0) {
            N.l0(this, 0.0f);
        }
        U uB2 = N.d(this).b(1.0f);
        uB2.f(j10);
        uB2.h(this.f41517a.a(uB2, i10));
        return uB2;
    }

    public int getAnimatedVisibility() {
        return this.f41525i != null ? this.f41517a.f41529b : getVisibility();
    }

    public int getContentHeight() {
        return this.f41524h;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, R$styleable.ActionBar, O6.c.c() ? R$attr.steposActionBarStyleFullScreen : androidx.appcompat.R$attr.actionBarStyle, 0);
        setContentHeight(typedArrayObtainStyledAttributes.getLayoutDimension(R$styleable.ActionBar_height, 0));
        typedArrayObtainStyledAttributes.recycle();
        ActionMenuPresenter actionMenuPresenter = this.f41520d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.R(configuration);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int iA = C1330s.a(motionEvent);
        if (iA == 9) {
            this.f41527k = false;
        }
        if (!this.f41527k) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (iA == 9 && !zOnHoverEvent) {
                this.f41527k = true;
            }
        }
        if (iA == 10 || iA == 3) {
            this.f41527k = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int iA = C1330s.a(motionEvent);
        if (iA == 0) {
            this.f41526j = false;
        }
        if (!this.f41526j) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (iA == 0 && !zOnTouchEvent) {
                this.f41526j = true;
            }
        }
        if (iA == 1 || iA == 3) {
            this.f41526j = false;
        }
        return true;
    }

    public void setContentHeight(int i10) {
        this.f41524h = i10;
        requestLayout();
    }

    public void setSplitToolbar(boolean z10) {
        this.f41522f = z10;
    }

    public void setSplitView(ViewGroup viewGroup) {
        this.f41521e = viewGroup;
    }

    public void setSplitWhenNarrow(boolean z10) {
        this.f41523g = z10;
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        if (i10 != getVisibility()) {
            U u10 = this.f41525i;
            if (u10 != null) {
                u10.c();
            }
            super.setVisibility(i10);
        }
    }

    public a(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f41517a = new C0527a();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(androidx.appcompat.R$attr.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.f41518b = context;
        } else {
            this.f41518b = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }
}
