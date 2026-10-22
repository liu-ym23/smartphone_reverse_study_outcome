package stepos.support.v7.widget;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public abstract class a extends ViewGroup {

    /* renamed from: c, reason: collision with root package name */
    public m.a f12708c;

    /* renamed from: f, reason: collision with root package name */
    public Context f12709f;

    /* renamed from: g, reason: collision with root package name */
    public ActionMenuView f12710g;

    /* renamed from: h, reason: collision with root package name */
    public q f12711h;
    public ViewGroup i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f12712j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f12713k;

    /* renamed from: l, reason: collision with root package name */
    public int f12714l;

    /* renamed from: m, reason: collision with root package name */
    public n3.o0 f12715m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f12716n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f12717o;

    static {
        id.k.m(0.33f, 0.0f, 0.66f, 1.0f);
    }

    public static int c(View view, int i, int i3) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i3);
        return Math.max(0, i - view.getMeasuredWidth());
    }

    public static int d(View view, int i, int i3, int i10, boolean z10) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i11 = ((i10 - measuredHeight) / 2) + i3;
        if (z10) {
            view.layout(i - measuredWidth, i11, i, measuredHeight + i11);
        } else {
            view.layout(i, i11, i + measuredWidth, measuredHeight + i11);
        }
        return z10 ? -measuredWidth : measuredWidth;
    }

    public final n3.o0 e(int i, long j10) {
        m.a aVar = this.f12708c;
        n3.o0 o0Var = this.f12715m;
        if (o0Var != null) {
            o0Var.b();
        }
        if (i != 0) {
            n3.o0 o0VarA = n3.k0.a(this);
            o0VarA.a(0.0f);
            o0VarA.c(j10);
            ((ActionBarContextView) aVar.f7866h).f12715m = o0VarA;
            aVar.f7865g = i;
            o0VarA.e(aVar);
            return o0VarA;
        }
        if (getVisibility() != 0) {
            WeakHashMap weakHashMap = n3.k0.f8724a;
            setAlpha(0.0f);
        }
        n3.o0 o0VarA2 = n3.k0.a(this);
        o0VarA2.a(1.0f);
        o0VarA2.c(j10);
        ((ActionBarContextView) aVar.f7866h).f12715m = o0VarA2;
        aVar.f7865g = i;
        o0VarA2.e(aVar);
        return o0VarA2;
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f12717o = false;
        }
        if (!this.f12717o) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.f12717o = true;
            }
        }
        if (actionMasked != 10 && actionMasked != 3) {
            return true;
        }
        this.f12717o = false;
        return true;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f12716n = false;
        }
        if (!this.f12716n) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.f12716n = true;
            }
        }
        if (actionMasked != 1 && actionMasked != 3) {
            return true;
        }
        this.f12716n = false;
        return true;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i != getVisibility()) {
            n3.o0 o0Var = this.f12715m;
            if (o0Var != null) {
                o0Var.b();
            }
            super.setVisibility(i);
        }
    }
}
