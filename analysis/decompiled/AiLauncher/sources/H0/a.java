package H0;

import C0.d;
import C0.e;
import H0.b;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.collection.u;
import androidx.core.view.C1313a;
import androidx.core.view.N;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class a extends C1313a {

    /* renamed from: k, reason: collision with root package name */
    public static final Rect f2920k = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);

    /* renamed from: l, reason: collision with root package name */
    public static final b.a<C0.c> f2921l = new C0042a();

    /* renamed from: m, reason: collision with root package name */
    public static final b.InterfaceC0043b<u<C0.c>, C0.c> f2922m = new b();

    /* renamed from: e, reason: collision with root package name */
    public final AccessibilityManager f2927e;

    /* renamed from: f, reason: collision with root package name */
    public final View f2928f;

    /* renamed from: g, reason: collision with root package name */
    public c f2929g;

    /* renamed from: a, reason: collision with root package name */
    public final Rect f2923a = new Rect();

    /* renamed from: b, reason: collision with root package name */
    public final Rect f2924b = new Rect();

    /* renamed from: c, reason: collision with root package name */
    public final Rect f2925c = new Rect();

    /* renamed from: d, reason: collision with root package name */
    public final int[] f2926d = new int[2];

    /* renamed from: h, reason: collision with root package name */
    public int f2930h = Integer.MIN_VALUE;

    /* renamed from: i, reason: collision with root package name */
    public int f2931i = Integer.MIN_VALUE;

    /* renamed from: j, reason: collision with root package name */
    public int f2932j = Integer.MIN_VALUE;

    /* renamed from: H0.a$a, reason: collision with other inner class name */
    public class C0042a implements b.a<C0.c> {
        @Override // H0.b.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(C0.c cVar, Rect rect) {
            cVar.k(rect);
        }
    }

    public class b implements b.InterfaceC0043b<u<C0.c>, C0.c> {
        @Override // H0.b.InterfaceC0043b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public C0.c a(u<C0.c> uVar, int i10) {
            return uVar.n(i10);
        }

        @Override // H0.b.InterfaceC0043b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public int b(u<C0.c> uVar) {
            return uVar.k();
        }
    }

    public class c extends d {
        public c() {
        }

        @Override // C0.d
        public C0.c b(int i10) {
            return C0.c.b0(a.this.u(i10));
        }

        @Override // C0.d
        public C0.c d(int i10) {
            int i11 = i10 == 2 ? a.this.f2930h : a.this.f2931i;
            if (i11 == Integer.MIN_VALUE) {
                return null;
            }
            return b(i11);
        }

        @Override // C0.d
        public boolean f(int i10, int i11, Bundle bundle) {
            return a.this.C(i10, i11, bundle);
        }
    }

    public a(View view) {
        if (view == null) {
            throw new IllegalArgumentException("View may not be null");
        }
        this.f2928f = view;
        this.f2927e = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        view.setFocusable(true);
        if (N.s(view) == 0) {
            N.r0(view, 1);
        }
    }

    private boolean F(int i10) {
        int i11;
        if (!this.f2927e.isEnabled() || !this.f2927e.isTouchExplorationEnabled() || (i11 = this.f2930h) == i10) {
            return false;
        }
        if (i11 != Integer.MIN_VALUE) {
            a(i11);
        }
        this.f2930h = i10;
        this.f2928f.invalidate();
        H(i10, 32768);
        return true;
    }

    private void I(int i10) {
        int i11 = this.f2932j;
        if (i11 == i10) {
            return;
        }
        this.f2932j = i10;
        H(i10, 128);
        H(i11, 256);
    }

    private boolean a(int i10) {
        if (this.f2930h != i10) {
            return false;
        }
        this.f2930h = Integer.MIN_VALUE;
        this.f2928f.invalidate();
        H(i10, 65536);
        return true;
    }

    private AccessibilityEvent d(int i10, int i11) {
        return i10 != -1 ? e(i10, i11) : f(i11);
    }

    public static Rect q(View view, int i10, Rect rect) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (i10 == 17) {
            rect.set(width, 0, width, height);
            return rect;
        }
        if (i10 == 33) {
            rect.set(0, height, width, height);
            return rect;
        }
        if (i10 == 66) {
            rect.set(-1, 0, -1, height);
            return rect;
        }
        if (i10 != 130) {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        rect.set(0, -1, width, -1);
        return rect;
    }

    public static int s(int i10) {
        if (i10 == 19) {
            return 33;
        }
        if (i10 != 21) {
            return i10 != 22 ? 130 : 66;
        }
        return 17;
    }

    public abstract void A(int i10, C0.c cVar);

    public abstract void B(int i10, boolean z10);

    public boolean C(int i10, int i11, Bundle bundle) {
        return i10 != -1 ? D(i10, i11, bundle) : E(i11, bundle);
    }

    public final boolean D(int i10, int i11, Bundle bundle) {
        return i11 != 1 ? i11 != 2 ? i11 != 64 ? i11 != 128 ? w(i10, i11, bundle) : a(i10) : F(i10) : b(i10) : G(i10);
    }

    public final boolean E(int i10, Bundle bundle) {
        return N.X(this.f2928f, i10, bundle);
    }

    public final boolean G(int i10) {
        int i11;
        if ((!this.f2928f.isFocused() && !this.f2928f.requestFocus()) || (i11 = this.f2931i) == i10) {
            return false;
        }
        if (i11 != Integer.MIN_VALUE) {
            b(i11);
        }
        if (i10 == Integer.MIN_VALUE) {
            return false;
        }
        this.f2931i = i10;
        B(i10, true);
        H(i10, 8);
        return true;
    }

    public final boolean H(int i10, int i11) {
        ViewParent parent;
        if (i10 == Integer.MIN_VALUE || !this.f2927e.isEnabled() || (parent = this.f2928f.getParent()) == null) {
            return false;
        }
        return parent.requestSendAccessibilityEvent(this.f2928f, d(i10, i11));
    }

    public final boolean b(int i10) {
        if (this.f2931i != i10) {
            return false;
        }
        this.f2931i = Integer.MIN_VALUE;
        B(i10, false);
        H(i10, 8);
        return true;
    }

    public final boolean c() {
        int i10 = this.f2931i;
        return i10 != Integer.MIN_VALUE && w(i10, 16, null);
    }

    public final AccessibilityEvent e(int i10, int i11) {
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i11);
        C0.c cVarU = u(i10);
        accessibilityEventObtain.getText().add(cVarU.C());
        accessibilityEventObtain.setContentDescription(cVarU.t());
        accessibilityEventObtain.setScrollable(cVarU.V());
        accessibilityEventObtain.setPassword(cVarU.U());
        accessibilityEventObtain.setEnabled(cVarU.N());
        accessibilityEventObtain.setChecked(cVarU.K());
        y(i10, accessibilityEventObtain);
        if (accessibilityEventObtain.getText().isEmpty() && accessibilityEventObtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        accessibilityEventObtain.setClassName(cVarU.q());
        e.c(accessibilityEventObtain, this.f2928f, i10);
        accessibilityEventObtain.setPackageName(this.f2928f.getContext().getPackageName());
        return accessibilityEventObtain;
    }

    public final AccessibilityEvent f(int i10) {
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i10);
        this.f2928f.onInitializeAccessibilityEvent(accessibilityEventObtain);
        return accessibilityEventObtain;
    }

    public final C0.c g(int i10) {
        C0.c cVarA0 = C0.c.a0();
        cVarA0.t0(true);
        cVarA0.v0(true);
        cVarA0.m0("android.view.View");
        Rect rect = f2920k;
        cVarA0.i0(rect);
        cVarA0.j0(rect);
        cVarA0.E0(this.f2928f);
        A(i10, cVarA0);
        if (cVarA0.C() == null && cVarA0.t() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        cVarA0.k(this.f2924b);
        if (this.f2924b.equals(rect)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int i11 = cVarA0.i();
        if ((i11 & 64) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        if ((i11 & 128) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        cVarA0.C0(this.f2928f.getContext().getPackageName());
        cVarA0.M0(this.f2928f, i10);
        if (this.f2930h == i10) {
            cVarA0.g0(true);
            cVarA0.a(128);
        } else {
            cVarA0.g0(false);
            cVarA0.a(64);
        }
        boolean z10 = this.f2931i == i10;
        if (z10) {
            cVarA0.a(2);
        } else if (cVarA0.P()) {
            cVarA0.a(1);
        }
        cVarA0.w0(z10);
        this.f2928f.getLocationOnScreen(this.f2926d);
        cVarA0.l(this.f2923a);
        if (this.f2923a.equals(rect)) {
            cVarA0.k(this.f2923a);
            if (cVarA0.f1626b != -1) {
                C0.c cVarA02 = C0.c.a0();
                for (int i12 = cVarA0.f1626b; i12 != -1; i12 = cVarA02.f1626b) {
                    cVarA02.F0(this.f2928f, -1);
                    cVarA02.i0(f2920k);
                    A(i12, cVarA02);
                    cVarA02.k(this.f2924b);
                    Rect rect2 = this.f2923a;
                    Rect rect3 = this.f2924b;
                    rect2.offset(rect3.left, rect3.top);
                }
                cVarA02.e0();
            }
            this.f2923a.offset(this.f2926d[0] - this.f2928f.getScrollX(), this.f2926d[1] - this.f2928f.getScrollY());
        }
        if (this.f2928f.getLocalVisibleRect(this.f2925c)) {
            this.f2925c.offset(this.f2926d[0] - this.f2928f.getScrollX(), this.f2926d[1] - this.f2928f.getScrollY());
            if (this.f2923a.intersect(this.f2925c)) {
                cVarA0.j0(this.f2923a);
                if (r(this.f2923a)) {
                    cVarA0.Q0(true);
                }
            }
        }
        return cVarA0;
    }

    @Override // androidx.core.view.C1313a
    public d getAccessibilityNodeProvider(View view) {
        if (this.f2929g == null) {
            this.f2929g = new c();
        }
        return this.f2929g;
    }

    public final C0.c h() {
        C0.c cVarC0 = C0.c.c0(this.f2928f);
        N.V(this.f2928f, cVarC0);
        ArrayList arrayList = new ArrayList();
        p(arrayList);
        if (cVarC0.p() > 0 && arrayList.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            cVarC0.d(this.f2928f, ((Integer) arrayList.get(i10)).intValue());
        }
        return cVarC0;
    }

    public final boolean i(MotionEvent motionEvent) {
        if (this.f2927e.isEnabled() && this.f2927e.isTouchExplorationEnabled()) {
            int action = motionEvent.getAction();
            if (action != 7 && action != 9) {
                if (action != 10 || this.f2932j == Integer.MIN_VALUE) {
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
        throw new UnsupportedOperationException("Method not decompiled: H0.a.j(android.view.KeyEvent):boolean");
    }

    public final int k() {
        return this.f2930h;
    }

    public final u<C0.c> l() {
        ArrayList arrayList = new ArrayList();
        p(arrayList);
        u<C0.c> uVar = new u<>();
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            uVar.j(arrayList.get(i10).intValue(), g(arrayList.get(i10).intValue()));
        }
        return uVar;
    }

    public final void m(int i10, Rect rect) {
        u(i10).k(rect);
    }

    public final int n() {
        return this.f2931i;
    }

    public abstract int o(float f10, float f11);

    @Override // androidx.core.view.C1313a
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        x(accessibilityEvent);
    }

    @Override // androidx.core.view.C1313a
    public void onInitializeAccessibilityNodeInfo(View view, C0.c cVar) {
        super.onInitializeAccessibilityNodeInfo(view, cVar);
        z(cVar);
    }

    public abstract void p(List<Integer> list);

    public final boolean r(Rect rect) {
        if (rect == null || rect.isEmpty() || this.f2928f.getWindowVisibility() != 0) {
            return false;
        }
        Object parent = this.f2928f.getParent();
        while (parent instanceof View) {
            View view = (View) parent;
            if (view.getAlpha() <= 0.0f || view.getVisibility() != 0) {
                return false;
            }
            parent = view.getParent();
        }
        return parent != null;
    }

    public final boolean t(int i10, Rect rect) {
        C0.c cVar;
        u<C0.c> uVarL = l();
        int i11 = this.f2931i;
        C0.c cVarG = i11 == Integer.MIN_VALUE ? null : uVarL.g(i11);
        if (i10 == 1 || i10 == 2) {
            cVar = (C0.c) H0.b.d(uVarL, f2922m, f2921l, cVarG, i10, N.u(this.f2928f) == 1, false);
        } else {
            if (i10 != 17 && i10 != 33 && i10 != 66 && i10 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            Rect rect2 = new Rect();
            int i12 = this.f2931i;
            if (i12 != Integer.MIN_VALUE) {
                m(i12, rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                q(this.f2928f, i10, rect2);
            }
            cVar = (C0.c) H0.b.c(uVarL, f2922m, f2921l, cVarG, rect2, i10);
        }
        return G(cVar != null ? uVarL.i(uVarL.h(cVar)) : Integer.MIN_VALUE);
    }

    public C0.c u(int i10) {
        return i10 == -1 ? h() : g(i10);
    }

    public final void v(boolean z10, int i10, Rect rect) {
        int i11 = this.f2931i;
        if (i11 != Integer.MIN_VALUE) {
            b(i11);
        }
        if (z10) {
            t(i10, rect);
        }
    }

    public abstract boolean w(int i10, int i11, Bundle bundle);

    public void x(AccessibilityEvent accessibilityEvent) {
    }

    public void y(int i10, AccessibilityEvent accessibilityEvent) {
    }

    public abstract void z(C0.c cVar);
}
