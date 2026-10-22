package J;

import E.d;
import E.e;
import J.b;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.core.view.C0456a;
import androidx.core.view.H;
import java.util.ArrayList;
import java.util.List;
import q.j;

/* loaded from: classes.dex */
public abstract class a extends C0456a {

    /* renamed from: k, reason: collision with root package name */
    private static final Rect f3153k = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);

    /* renamed from: l, reason: collision with root package name */
    private static final b.a<E.c> f3154l = new C0040a();

    /* renamed from: m, reason: collision with root package name */
    private static final b.InterfaceC0041b<j<E.c>, E.c> f3155m = new b();

    /* renamed from: e, reason: collision with root package name */
    private final AccessibilityManager f3160e;

    /* renamed from: f, reason: collision with root package name */
    private final View f3161f;

    /* renamed from: g, reason: collision with root package name */
    private c f3162g;

    /* renamed from: a, reason: collision with root package name */
    private final Rect f3156a = new Rect();

    /* renamed from: b, reason: collision with root package name */
    private final Rect f3157b = new Rect();

    /* renamed from: c, reason: collision with root package name */
    private final Rect f3158c = new Rect();

    /* renamed from: d, reason: collision with root package name */
    private final int[] f3159d = new int[2];

    /* renamed from: h, reason: collision with root package name */
    int f3163h = Integer.MIN_VALUE;

    /* renamed from: i, reason: collision with root package name */
    int f3164i = Integer.MIN_VALUE;

    /* renamed from: j, reason: collision with root package name */
    private int f3165j = Integer.MIN_VALUE;

    /* renamed from: J.a$a, reason: collision with other inner class name */
    class C0040a implements b.a<E.c> {
        C0040a() {
        }

        @Override // J.b.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(E.c cVar, Rect rect) {
            cVar.j(rect);
        }
    }

    class b implements b.InterfaceC0041b<j<E.c>, E.c> {
        b() {
        }

        @Override // J.b.InterfaceC0041b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public E.c a(j<E.c> jVar, int i5) {
            return jVar.l(i5);
        }

        @Override // J.b.InterfaceC0041b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public int b(j<E.c> jVar) {
            return jVar.k();
        }
    }

    private class c extends d {
        c() {
        }

        @Override // E.d
        public E.c b(int i5) {
            return E.c.T(a.this.u(i5));
        }

        @Override // E.d
        public E.c d(int i5) {
            int i6 = i5 == 2 ? a.this.f3163h : a.this.f3164i;
            if (i6 == Integer.MIN_VALUE) {
                return null;
            }
            return b(i6);
        }

        @Override // E.d
        public boolean f(int i5, int i6, Bundle bundle) {
            return a.this.C(i5, i6, bundle);
        }
    }

    public a(View view) {
        if (view == null) {
            throw new IllegalArgumentException("View may not be null");
        }
        this.f3161f = view;
        this.f3160e = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        view.setFocusable(true);
        if (H.v(view) == 0) {
            H.t0(view, 1);
        }
    }

    private boolean D(int i5, int i6, Bundle bundle) {
        return i6 != 1 ? i6 != 2 ? i6 != 64 ? i6 != 128 ? w(i5, i6, bundle) : a(i5) : F(i5) : b(i5) : G(i5);
    }

    private boolean E(int i5, Bundle bundle) {
        return H.Z(this.f3161f, i5, bundle);
    }

    private boolean F(int i5) {
        int i6;
        if (!this.f3160e.isEnabled() || !this.f3160e.isTouchExplorationEnabled() || (i6 = this.f3163h) == i5) {
            return false;
        }
        if (i6 != Integer.MIN_VALUE) {
            a(i6);
        }
        this.f3163h = i5;
        this.f3161f.invalidate();
        H(i5, 32768);
        return true;
    }

    private void I(int i5) {
        int i6 = this.f3165j;
        if (i6 == i5) {
            return;
        }
        this.f3165j = i5;
        H(i5, 128);
        H(i6, 256);
    }

    private boolean a(int i5) {
        if (this.f3163h != i5) {
            return false;
        }
        this.f3163h = Integer.MIN_VALUE;
        this.f3161f.invalidate();
        H(i5, 65536);
        return true;
    }

    private boolean c() {
        int i5 = this.f3164i;
        return i5 != Integer.MIN_VALUE && w(i5, 16, null);
    }

    private AccessibilityEvent d(int i5, int i6) {
        return i5 != -1 ? e(i5, i6) : f(i6);
    }

    private AccessibilityEvent e(int i5, int i6) {
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i6);
        E.c cVarU = u(i5);
        accessibilityEventObtain.getText().add(cVarU.w());
        accessibilityEventObtain.setContentDescription(cVarU.q());
        accessibilityEventObtain.setScrollable(cVarU.N());
        accessibilityEventObtain.setPassword(cVarU.M());
        accessibilityEventObtain.setEnabled(cVarU.G());
        accessibilityEventObtain.setChecked(cVarU.D());
        y(i5, accessibilityEventObtain);
        if (accessibilityEventObtain.getText().isEmpty() && accessibilityEventObtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        accessibilityEventObtain.setClassName(cVarU.n());
        e.g(accessibilityEventObtain, this.f3161f, i5);
        accessibilityEventObtain.setPackageName(this.f3161f.getContext().getPackageName());
        return accessibilityEventObtain;
    }

    private AccessibilityEvent f(int i5) {
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i5);
        this.f3161f.onInitializeAccessibilityEvent(accessibilityEventObtain);
        return accessibilityEventObtain;
    }

    private E.c g(int i5) {
        E.c cVarS = E.c.S();
        cVarS.j0(true);
        cVarS.l0(true);
        cVarS.d0("android.view.View");
        Rect rect = f3153k;
        cVarS.Z(rect);
        cVarS.a0(rect);
        cVarS.t0(this.f3161f);
        A(i5, cVarS);
        if (cVarS.w() == null && cVarS.q() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        cVarS.j(this.f3157b);
        if (this.f3157b.equals(rect)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int iH = cVarS.h();
        if ((iH & 64) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        if ((iH & 128) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        cVarS.r0(this.f3161f.getContext().getPackageName());
        cVarS.y0(this.f3161f, i5);
        if (this.f3163h == i5) {
            cVarS.Y(true);
            cVarS.a(128);
        } else {
            cVarS.Y(false);
            cVarS.a(64);
        }
        boolean z5 = this.f3164i == i5;
        if (z5) {
            cVarS.a(2);
        } else if (cVarS.H()) {
            cVarS.a(1);
        }
        cVarS.m0(z5);
        this.f3161f.getLocationOnScreen(this.f3159d);
        cVarS.k(this.f3156a);
        if (this.f3156a.equals(rect)) {
            cVarS.j(this.f3156a);
            if (cVarS.f1222b != -1) {
                E.c cVarS2 = E.c.S();
                for (int i6 = cVarS.f1222b; i6 != -1; i6 = cVarS2.f1222b) {
                    cVarS2.u0(this.f3161f, -1);
                    cVarS2.Z(f3153k);
                    A(i6, cVarS2);
                    cVarS2.j(this.f3157b);
                    Rect rect2 = this.f3156a;
                    Rect rect3 = this.f3157b;
                    rect2.offset(rect3.left, rect3.top);
                }
                cVarS2.W();
            }
            this.f3156a.offset(this.f3159d[0] - this.f3161f.getScrollX(), this.f3159d[1] - this.f3161f.getScrollY());
        }
        if (this.f3161f.getLocalVisibleRect(this.f3158c)) {
            this.f3158c.offset(this.f3159d[0] - this.f3161f.getScrollX(), this.f3159d[1] - this.f3161f.getScrollY());
            if (this.f3156a.intersect(this.f3158c)) {
                cVarS.a0(this.f3156a);
                if (r(this.f3156a)) {
                    cVarS.C0(true);
                }
            }
        }
        return cVarS;
    }

    private E.c h() {
        E.c cVarU = E.c.U(this.f3161f);
        H.X(this.f3161f, cVarU);
        ArrayList arrayList = new ArrayList();
        p(arrayList);
        if (cVarU.m() > 0 && arrayList.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            cVarU.c(this.f3161f, ((Integer) arrayList.get(i5)).intValue());
        }
        return cVarU;
    }

    private j<E.c> l() {
        ArrayList arrayList = new ArrayList();
        p(arrayList);
        j<E.c> jVar = new j<>();
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            jVar.j(arrayList.get(i5).intValue(), g(arrayList.get(i5).intValue()));
        }
        return jVar;
    }

    private void m(int i5, Rect rect) {
        u(i5).j(rect);
    }

    private static Rect q(View view, int i5, Rect rect) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (i5 == 17) {
            rect.set(width, 0, width, height);
            return rect;
        }
        if (i5 == 33) {
            rect.set(0, height, width, height);
            return rect;
        }
        if (i5 == 66) {
            rect.set(-1, 0, -1, height);
            return rect;
        }
        if (i5 != 130) {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        rect.set(0, -1, width, -1);
        return rect;
    }

    private boolean r(Rect rect) {
        if (rect == null || rect.isEmpty() || this.f3161f.getWindowVisibility() != 0) {
            return false;
        }
        Object parent = this.f3161f.getParent();
        while (parent instanceof View) {
            View view = (View) parent;
            if (view.getAlpha() <= 0.0f || view.getVisibility() != 0) {
                return false;
            }
            parent = view.getParent();
        }
        return parent != null;
    }

    private static int s(int i5) {
        if (i5 == 19) {
            return 33;
        }
        if (i5 != 21) {
            return i5 != 22 ? 130 : 66;
        }
        return 17;
    }

    private boolean t(int i5, Rect rect) {
        E.c cVar;
        j<E.c> jVarL = l();
        int i6 = this.f3164i;
        E.c cVarG = i6 == Integer.MIN_VALUE ? null : jVarL.g(i6);
        if (i5 == 1 || i5 == 2) {
            cVar = (E.c) J.b.d(jVarL, f3155m, f3154l, cVarG, i5, H.x(this.f3161f) == 1, false);
        } else {
            if (i5 != 17 && i5 != 33 && i5 != 66 && i5 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            Rect rect2 = new Rect();
            int i7 = this.f3164i;
            if (i7 != Integer.MIN_VALUE) {
                m(i7, rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                q(this.f3161f, i5, rect2);
            }
            cVar = (E.c) J.b.c(jVarL, f3155m, f3154l, cVarG, rect2, i5);
        }
        return G(cVar != null ? jVarL.i(jVarL.h(cVar)) : Integer.MIN_VALUE);
    }

    protected abstract void A(int i5, E.c cVar);

    protected abstract void B(int i5, boolean z5);

    boolean C(int i5, int i6, Bundle bundle) {
        return i5 != -1 ? D(i5, i6, bundle) : E(i6, bundle);
    }

    public final boolean G(int i5) {
        int i6;
        if ((!this.f3161f.isFocused() && !this.f3161f.requestFocus()) || (i6 = this.f3164i) == i5) {
            return false;
        }
        if (i6 != Integer.MIN_VALUE) {
            b(i6);
        }
        if (i5 == Integer.MIN_VALUE) {
            return false;
        }
        this.f3164i = i5;
        B(i5, true);
        H(i5, 8);
        return true;
    }

    public final boolean H(int i5, int i6) {
        ViewParent parent;
        if (i5 == Integer.MIN_VALUE || !this.f3160e.isEnabled() || (parent = this.f3161f.getParent()) == null) {
            return false;
        }
        return parent.requestSendAccessibilityEvent(this.f3161f, d(i5, i6));
    }

    public final boolean b(int i5) {
        if (this.f3164i != i5) {
            return false;
        }
        this.f3164i = Integer.MIN_VALUE;
        B(i5, false);
        H(i5, 8);
        return true;
    }

    @Override // androidx.core.view.C0456a
    public d getAccessibilityNodeProvider(View view) {
        if (this.f3162g == null) {
            this.f3162g = new c();
        }
        return this.f3162g;
    }

    public final boolean i(MotionEvent motionEvent) {
        if (this.f3160e.isEnabled() && this.f3160e.isTouchExplorationEnabled()) {
            int action = motionEvent.getAction();
            if (action != 7 && action != 9) {
                if (action != 10 || this.f3165j == Integer.MIN_VALUE) {
                    return false;
                }
                I(Integer.MIN_VALUE);
                return true;
            }
            int iO = o(motionEvent.getX(), motionEvent.getY());
            I(iO);
            if (iO != Integer.MIN_VALUE) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean j(android.view.KeyEvent r7) {
        /*
            r6 = this;
            int r0 = r7.getAction()
            r1 = 0
            r2 = 1
            if (r0 == r2) goto L5d
            int r0 = r7.getKeyCode()
            r3 = 61
            r4 = 0
            if (r0 == r3) goto L46
            r3 = 66
            if (r0 == r3) goto L36
            switch(r0) {
                case 19: goto L19;
                case 20: goto L19;
                case 21: goto L19;
                case 22: goto L19;
                case 23: goto L36;
                default: goto L18;
            }
        L18:
            goto L5d
        L19:
            boolean r3 = r7.hasNoModifiers()
            if (r3 == 0) goto L5d
            int r0 = s(r0)
            int r7 = r7.getRepeatCount()
            int r7 = r7 + r2
            r3 = r1
        L29:
            if (r1 >= r7) goto L35
            boolean r5 = r6.t(r0, r4)
            if (r5 == 0) goto L35
            int r1 = r1 + 1
            r3 = r2
            goto L29
        L35:
            return r3
        L36:
            boolean r0 = r7.hasNoModifiers()
            if (r0 == 0) goto L5d
            int r7 = r7.getRepeatCount()
            if (r7 != 0) goto L5d
            r6.c()
            return r2
        L46:
            boolean r0 = r7.hasNoModifiers()
            if (r0 == 0) goto L52
            r7 = 2
            boolean r6 = r6.t(r7, r4)
            return r6
        L52:
            boolean r7 = r7.hasModifiers(r2)
            if (r7 == 0) goto L5d
            boolean r6 = r6.t(r2, r4)
            return r6
        L5d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: J.a.j(android.view.KeyEvent):boolean");
    }

    public final int k() {
        return this.f3163h;
    }

    public final int n() {
        return this.f3164i;
    }

    protected abstract int o(float f5, float f6);

    @Override // androidx.core.view.C0456a
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        x(accessibilityEvent);
    }

    @Override // androidx.core.view.C0456a
    public void onInitializeAccessibilityNodeInfo(View view, E.c cVar) {
        super.onInitializeAccessibilityNodeInfo(view, cVar);
        z(cVar);
    }

    protected abstract void p(List<Integer> list);

    E.c u(int i5) {
        return i5 == -1 ? h() : g(i5);
    }

    public final void v(boolean z5, int i5, Rect rect) {
        int i6 = this.f3164i;
        if (i6 != Integer.MIN_VALUE) {
            b(i6);
        }
        if (z5) {
            t(i5, rect);
        }
    }

    protected abstract boolean w(int i5, int i6, Bundle bundle);

    protected void x(AccessibilityEvent accessibilityEvent) {
    }

    protected void y(int i5, AccessibilityEvent accessibilityEvent) {
    }

    protected abstract void z(E.c cVar);
}
