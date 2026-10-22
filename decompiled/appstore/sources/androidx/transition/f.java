package androidx.transition;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
public class f extends ViewGroup implements GhostView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewGroup f5059a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f5060b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f5061c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f5062d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Matrix f5063e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ViewTreeObserver.OnPreDrawListener f5064f;

    public class a implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f5065a;

        public a(f r10) {
            this.f5065a = r10;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            ViewCompat.g0(this.f5065a);
            f r10 = this.f5065a;
            ViewGroup r11 = r10.f5059a;
            if (r11 == null) goto L9;
            View r12 = r10.f5060b;
            if (r12 == null) goto L10;
            r11.endViewTransition(r12);
            ViewCompat.g0(this.f5065a.f5059a);
            f r13 = this.f5065a;
            r13.f5059a = null;
            r13.f5060b = null;
            return true;
        L10:
            return true;
        L9:
            return true;
        }
    }

    public f(View r10) {
        super(r10.getContext());
        this.f5064f = new a(this);
        this.f5061c = r10;
        setWillNotDraw(false);
        setClipChildren(false);
        setLayerType(2, null);
    }

    public static f a(View r10, ViewGroup r11, Matrix r12) {
        if ((r10.getParent() instanceof ViewGroup) == false) goto L23;
        e r13 = e.b(r11);
        f r14 = d(r10);
        if (r14 == null) goto L9;
        e r15 = (e) r14.getParent();
        if (r15 == r13) goto L9;
        int r16 = r14.f5062d;
        r15.removeView(r14);
        r14 = null;
    L10:
        if (r14 != null) goto L18;
        if (r12 != null) goto L13;
        r12 = new Matrix();
        b(r10, r11, r12);
    L13:
        r14 = new f(r10);
        r14.g(r12);
        if (r13 != null) goto L16;
        r13 = new e(r11);
    L17:
        c(r11, r13);
        c(r11, r14);
        r13.a(r14);
        r14.f5062d = r16;
    L20:
        r14.f5062d++;
        return r14;
    L16:
        r13.g();
        goto L17
    L18:
        if (r12 == null) goto L20;
        r14.g(r12);
    L9:
        r16 = 0;
        goto L10
    L23:
        throw new IllegalArgumentException("Ghosted views must be parented by a ViewGroup");
    }

    public static void b(View r10, ViewGroup r11, Matrix r12) {
        ViewGroup r13 = (ViewGroup) r10.getParent();
        r12.reset();
        y.j(r13, r12);
        r12.preTranslate(-r13.getScrollX(), -r13.getScrollY());
        y.k(r11, r12);
    }

    public static void c(View r10, View r11) {
        y.g(r11, r11.getLeft(), r11.getTop(), r11.getLeft() + r10.getWidth(), r11.getTop() + r10.getHeight());
    }

    public static f d(View r10) {
        return (f) r10.getTag(R$id.ghost_view);
    }

    public static void e(View r10) {
        f r11 = d(r10);
        if (r11 == null) goto L8;
        int r12 = r11.f5062d - 1;
        r11.f5062d = r12;
        if (r12 > 0) goto L9;
        ((e) r11.getParent()).removeView(r11);
        return;
    L9:
        return;
    }

    public static void f(View r10, f r11) {
        r10.setTag(R$id.ghost_view, r11);
    }

    public void g(Matrix r10) {
        this.f5063e = r10;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        f(this.f5061c, this);
        this.f5061c.getViewTreeObserver().addOnPreDrawListener(this.f5064f);
        y.i(this.f5061c, 4);
        if (this.f5061c.getParent() == null) goto L6;
        ((View) this.f5061c.getParent()).invalidate();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.f5061c.getViewTreeObserver().removeOnPreDrawListener(this.f5064f);
        y.i(this.f5061c, 0);
        f(this.f5061c, null);
        if (this.f5061c.getParent() == null) goto L5;
        ((View) this.f5061c.getParent()).invalidate();
    L5:
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas r10) {
        androidx.transition.a.a(r10, true);
        r10.setMatrix(this.f5063e);
        y.i(this.f5061c, 0);
        this.f5061c.invalidate();
        y.i(this.f5061c, 4);
        drawChild(r10, this.f5061c, getDrawingTime());
        androidx.transition.a.a(r10, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
    }

    @Override // androidx.transition.GhostView
    public void reserveEndViewTransition(ViewGroup r10, View r11) {
        this.f5059a = r10;
        this.f5060b = r11;
    }

    @Override // android.view.View, androidx.transition.GhostView
    public void setVisibility(int r10) {
        super.setVisibility(r10);
        if (d(this.f5061c) != this) goto L9;
        if (r10 != 0) goto L6;
        int r11 = 4;
    L7:
        y.i(this.f5061c, r11);
        return;
    L6:
        r11 = 0;
        goto L7
    }
}
