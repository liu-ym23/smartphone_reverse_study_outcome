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
import com.stepos.aiengine.R;
import java.util.WeakHashMap;
import v0.h0;
import v0.i0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class a extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    public final C0144a f12686a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f12687b;

    /* renamed from: c, reason: collision with root package name */
    public ActionMenuView f12688c;

    /* renamed from: d, reason: collision with root package name */
    public ActionMenuPresenter f12689d;

    /* renamed from: e, reason: collision with root package name */
    public ViewGroup f12690e;
    public boolean h;

    /* renamed from: j, reason: collision with root package name */
    public boolean f12691j;

    /* renamed from: k, reason: collision with root package name */
    public int f12692k;

    /* renamed from: l, reason: collision with root package name */
    public h0 f12693l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f12694m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f12695n;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: stepos.support.v7.widget.a$a, reason: collision with other inner class name */
    public class C0144a implements i0 {

        /* renamed from: a, reason: collision with root package name */
        public boolean f12696a = false;

        /* renamed from: b, reason: collision with root package name */
        public int f12697b;

        public C0144a() {
        }

        @Override // v0.i0
        public final void c() {
            this.f12696a = true;
        }

        @Override // v0.i0
        public final void d(View view) {
            if (this.f12696a) {
                return;
            }
            a aVar = a.this;
            aVar.f12693l = null;
            a.super.setVisibility(this.f12697b);
        }

        @Override // v0.i0
        public final void e(View view) {
            a.super.setVisibility(0);
            this.f12696a = false;
        }
    }

    static {
        x0.a.a(0.33f, 0.0f, 0.66f, 1.0f);
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

    public final h0 e(int i10, long j10) {
        h0 h0Var = this.f12693l;
        if (h0Var != null) {
            h0Var.b();
        }
        C0144a c0144a = this.f12686a;
        if (i10 != 0) {
            h0 h0VarA = v0.e0.a(this);
            h0VarA.a(0.0f);
            h0VarA.c(j10);
            a.this.f12693l = h0VarA;
            c0144a.f12697b = i10;
            h0VarA.e(c0144a);
            return h0VarA;
        }
        if (getVisibility() != 0) {
            WeakHashMap<View, h0> weakHashMap = v0.e0.f13274a;
            setAlpha(0.0f);
        }
        h0 h0VarA2 = v0.e0.a(this);
        h0VarA2.a(1.0f);
        h0VarA2.c(j10);
        a.this.f12693l = h0VarA2;
        c0144a.f12697b = i10;
        h0VarA2.e(c0144a);
        return h0VarA2;
    }

    public int getAnimatedVisibility() {
        return this.f12693l != null ? this.f12686a.f12697b : getVisibility();
    }

    public int getContentHeight() {
        return this.f12692k;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, g.a.f8921a, R.attr.steposActionBarStyleFullScreen, 0);
        setContentHeight(typedArrayObtainStyledAttributes.getLayoutDimension(13, 0));
        typedArrayObtainStyledAttributes.recycle();
        ActionMenuPresenter actionMenuPresenter = this.f12689d;
        if (actionMenuPresenter != null) {
            if (!actionMenuPresenter.f12507u) {
                actionMenuPresenter.f12506t = actionMenuPresenter.f12361b.getResources().getInteger(R.integer.abc_max_action_buttons);
            }
            stepos.support.v7.view.menu.c cVar = actionMenuPresenter.f12362c;
            if (cVar != null) {
                cVar.o(true);
            }
        }
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f12695n = false;
        }
        if (!this.f12695n) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.f12695n = true;
            }
        }
        if (actionMasked != 10 && actionMasked != 3) {
            return true;
        }
        this.f12695n = false;
        return true;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f12694m = false;
        }
        if (!this.f12694m) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.f12694m = true;
            }
        }
        if (actionMasked != 1 && actionMasked != 3) {
            return true;
        }
        this.f12694m = false;
        return true;
    }

    public void setContentHeight(int i10) {
        this.f12692k = i10;
        requestLayout();
    }

    public void setSplitToolbar(boolean z) {
        this.h = z;
    }

    public void setSplitView(ViewGroup viewGroup) {
        this.f12690e = viewGroup;
    }

    public void setSplitWhenNarrow(boolean z) {
        this.f12691j = z;
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        if (i10 != getVisibility()) {
            h0 h0Var = this.f12693l;
            if (h0Var != null) {
                h0Var.b();
            }
            super.setVisibility(i10);
        }
    }

    public a(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f12686a = new C0144a();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.f12687b = context;
        } else {
            this.f12687b = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }
}
