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
import com.stepos.aiengine.R;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class a extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    public final C0003a f737a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f738b;

    /* renamed from: c, reason: collision with root package name */
    public ActionMenuView f739c;

    /* renamed from: d, reason: collision with root package name */
    public ActionMenuPresenter f740d;

    /* renamed from: e, reason: collision with root package name */
    public int f741e;
    public v0.h0 h;

    /* renamed from: j, reason: collision with root package name */
    public boolean f742j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f743k;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: androidx.appcompat.widget.a$a, reason: collision with other inner class name */
    public class C0003a implements v0.i0 {

        /* renamed from: a, reason: collision with root package name */
        public boolean f744a = false;

        /* renamed from: b, reason: collision with root package name */
        public int f745b;

        public C0003a() {
        }

        @Override // v0.i0
        public final void c() {
            this.f744a = true;
        }

        @Override // v0.i0
        public final void d(View view) {
            if (this.f744a) {
                return;
            }
            a aVar = a.this;
            aVar.h = null;
            a.super.setVisibility(this.f745b);
        }

        @Override // v0.i0
        public final void e(View view) {
            a.super.setVisibility(0);
            this.f744a = false;
        }
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static int c(View view, int i10, int i11) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i10, Integer.MIN_VALUE), i11);
        return Math.max(0, i10 - view.getMeasuredWidth());
    }

    public static int d(int i10, int i11, int i12, View view, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i13 = ((i12 - measuredHeight) / 2) + i11;
        if (z) {
            view.layout(i10 - measuredWidth, i13, i10, measuredHeight + i13);
        } else {
            view.layout(i10, i13, i10 + measuredWidth, measuredHeight + i13);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    public final v0.h0 e(int i10, long j10) {
        v0.h0 h0Var = this.h;
        if (h0Var != null) {
            h0Var.b();
        }
        C0003a c0003a = this.f737a;
        if (i10 != 0) {
            v0.h0 h0VarA = v0.e0.a(this);
            h0VarA.a(0.0f);
            h0VarA.c(j10);
            a.this.h = h0VarA;
            c0003a.f745b = i10;
            h0VarA.e(c0003a);
            return h0VarA;
        }
        if (getVisibility() != 0) {
            setAlpha(0.0f);
        }
        v0.h0 h0VarA2 = v0.e0.a(this);
        h0VarA2.a(1.0f);
        h0VarA2.c(j10);
        a.this.h = h0VarA2;
        c0003a.f745b = i10;
        h0VarA2.e(c0003a);
        return h0VarA2;
    }

    public int getAnimatedVisibility() {
        return this.h != null ? this.f737a.f745b : getVisibility();
    }

    public int getContentHeight() {
        return this.f741e;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, g.a.f8921a, R.attr.actionBarStyle, 0);
        setContentHeight(typedArrayObtainStyledAttributes.getLayoutDimension(13, 0));
        typedArrayObtainStyledAttributes.recycle();
        ActionMenuPresenter actionMenuPresenter = this.f740d;
        if (actionMenuPresenter != null) {
            Configuration configuration2 = actionMenuPresenter.f431b.getResources().getConfiguration();
            int i10 = configuration2.screenWidthDp;
            int i11 = configuration2.screenHeightDp;
            actionMenuPresenter.f602s = (configuration2.smallestScreenWidthDp > 600 || i10 > 600 || (i10 > 960 && i11 > 720) || (i10 > 720 && i11 > 960)) ? 5 : (i10 >= 500 || (i10 > 640 && i11 > 480) || (i10 > 480 && i11 > 640)) ? 4 : i10 >= 360 ? 3 : 2;
            androidx.appcompat.view.menu.f fVar = actionMenuPresenter.f432c;
            if (fVar != null) {
                fVar.p(true);
            }
        }
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f743k = false;
        }
        if (!this.f743k) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.f743k = true;
            }
        }
        if (actionMasked != 10 && actionMasked != 3) {
            return true;
        }
        this.f743k = false;
        return true;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f742j = false;
        }
        if (!this.f742j) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.f742j = true;
            }
        }
        if (actionMasked != 1 && actionMasked != 3) {
            return true;
        }
        this.f742j = false;
        return true;
    }

    public void setContentHeight(int i10) {
        this.f741e = i10;
        requestLayout();
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        if (i10 != getVisibility()) {
            v0.h0 h0Var = this.h;
            if (h0Var != null) {
                h0Var.b();
            }
            super.setVisibility(i10);
        }
    }

    public a(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f737a = new C0003a();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.f738b = context;
        } else {
            this.f738b = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }
}
