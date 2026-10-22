package stepos.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.C0189a;
import com.stepos.alphame.R;
import com.stepos.alphame.utils.Property;
import java.util.WeakHashMap;

/* renamed from: stepos.support.v7.widget.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0881a extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    public final C0189a f15052a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f15053b;

    /* renamed from: c, reason: collision with root package name */
    public ActionMenuView f15054c;

    /* renamed from: d, reason: collision with root package name */
    public C0897q f15055d;

    /* renamed from: e, reason: collision with root package name */
    public ViewGroup f15056e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f15057f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f15058g;

    /* renamed from: h, reason: collision with root package name */
    public int f15059h;

    /* renamed from: i, reason: collision with root package name */
    public K.e0 f15060i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f15061j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f15062k;

    static {
        M.a.b(0.33f, Property.DEFAULT_FLOAT_VALUE, 0.66f, 1.0f);
    }

    public AbstractC0881a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.steposActionModeStyleFullScreen);
        this.f15052a = new C0189a(this, 2);
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.f15053b = context;
        } else {
            this.f15053b = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    public static int c(View view, int i4, int i5) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE), i5);
        return Math.max(0, i4 - view.getMeasuredWidth());
    }

    public static int d(int i4, int i5, int i6, View view, boolean z4) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i7 = ((i6 - measuredHeight) / 2) + i5;
        if (z4) {
            view.layout(i4 - measuredWidth, i7, i4, measuredHeight + i7);
        } else {
            view.layout(i4, i7, i4 + measuredWidth, measuredHeight + i7);
        }
        return z4 ? -measuredWidth : measuredWidth;
    }

    public final K.e0 e(int i4, long j4) {
        K.e0 e0Var = this.f15060i;
        if (e0Var != null) {
            e0Var.b();
        }
        C0189a c0189a = this.f15052a;
        if (i4 != 0) {
            K.e0 e0VarA = K.S.a(this);
            e0VarA.a(Property.DEFAULT_FLOAT_VALUE);
            e0VarA.c(j4);
            ((AbstractC0881a) c0189a.f3051d).f15060i = e0VarA;
            c0189a.f3050c = i4;
            e0VarA.e(c0189a);
            return e0VarA;
        }
        if (getVisibility() != 0) {
            WeakHashMap weakHashMap = K.S.f939a;
            setAlpha(Property.DEFAULT_FLOAT_VALUE);
        }
        K.e0 e0VarA2 = K.S.a(this);
        e0VarA2.a(1.0f);
        e0VarA2.c(j4);
        ((AbstractC0881a) c0189a.f3051d).f15060i = e0VarA2;
        c0189a.f3050c = i4;
        e0VarA2.e(c0189a);
        return e0VarA2;
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f15062k = false;
        }
        if (!this.f15062k) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.f15062k = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f15062k = false;
        }
        return true;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f15061j = false;
        }
        if (!this.f15061j) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.f15061j = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f15061j = false;
        }
        return true;
    }

    @Override // android.view.View
    public void setVisibility(int i4) {
        if (i4 != getVisibility()) {
            K.e0 e0Var = this.f15060i;
            if (e0Var != null) {
                e0Var.b();
            }
            super.setVisibility(i4);
        }
    }
}
