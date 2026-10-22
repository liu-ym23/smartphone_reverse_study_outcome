package androidx.customview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.b.h;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import com.obric.cae.libs.useraware.ApWakeEvent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ExploreByTouchHelper.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a extends AccessibilityDelegateCompat {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Rect f1550c = null;
    private static final b.a<androidx.core.view.accessibility.b> l = null;
    private static final b.InterfaceC0046b<h<androidx.core.view.accessibility.b>, androidx.core.view.accessibility.b> m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f1551a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f1552b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Rect f1553d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Rect f1554e;
    private final Rect f;
    private final int[] g;
    private final AccessibilityManager h;
    private final View i;
    private C0045a j;
    private int k;

    /* JADX INFO: renamed from: androidx.customview.widget.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ExploreByTouchHelper.java */
    private class C0045a extends AccessibilityNodeProviderCompat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f1555a;

        C0045a(a r1) {
            this.f1555a = r1;
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public androidx.core.view.accessibility.b a(int r1) {
            return androidx.core.view.accessibility.b.a(this.f1555a.b(r1));
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public boolean a(int r1, int r2, Bundle r3) {
            return this.f1555a.a(r1, r2, r3);
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public androidx.core.view.accessibility.b b(int r2) {
            if (r2 != 2) goto L5;
            int r3 = this.f1555a.f1551a;
        L7:
            if (r3 != Integer.MIN_VALUE) goto L11;
            return null;
        L11:
            return a(r3);
        L5:
            r3 = this.f1555a.f1552b;
            goto L7
        }
    }

    private static int e(int r1) {
        if (r1 != 19) goto L5;
        return 33;
    L5:
        if (r1 != 21) goto L7;
        return 17;
    L7:
        if (r1 == 22) goto L10;
        return ApWakeEvent.ACCELERATING_START;
    L10:
        return 66;
    }

    public abstract int a(float r1, float r2);

    public void a(int r1, AccessibilityEvent r2) {
    }

    public abstract void a(int r1, androidx.core.view.accessibility.b r2);

    public void a(int r1, boolean r2) {
    }

    public void a(AccessibilityEvent r1) {
    }

    public void a(androidx.core.view.accessibility.b r1) {
    }

    public abstract void a(List<Integer> r1);

    public abstract boolean b(int r1, int r2, Bundle r3);

    static {
        f1550c = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
        l = new AnonymousClass1();
        m = new AnonymousClass2();
    }

    public a(View r4) {
        this.f1553d = new Rect();
        this.f1554e = new Rect();
        this.f = new Rect();
        this.g = new int[2];
        this.f1551a = Integer.MIN_VALUE;
        this.f1552b = Integer.MIN_VALUE;
        this.k = Integer.MIN_VALUE;
        if (r4 == null) goto L9;
        this.i = r4;
        this.h = (AccessibilityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService("accessibility"), AccessibilityManager.class, "com.obric.aiagent.plugin");
        r4.setFocusable(true);
        if (ViewCompat.g(r4) != 0) goto L10;
        ViewCompat.c(r4, 1);
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("View may not be null");
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public AccessibilityNodeProviderCompat a(View r1) {
        if (this.j != null) goto L6;
        this.j = new C0045a(this);
    L6:
        return this.j;
    }

    public final boolean a(MotionEvent r6) {
        if (this.h.isEnabled() == true) goto L5;
        return false;
    L5:
        if (this.h.isTouchExplorationEnabled() == false) goto L25;
        int r0 = r6.getAction();
        if (r0 != 7) goto L10;
    L19:
        int r7 = a(r6.getX(), r6.getY());
        f(r7);
        if (r7 != Integer.MIN_VALUE) goto L22;
        return false;
    L22:
        return true;
    L10:
        if (r0 == 9) goto L19;
        if (r0 == 10) goto L15;
        return false;
    L15:
        if (this.k == Integer.MIN_VALUE) goto L18;
        f(Integer.MIN_VALUE);
        return true;
    L18:
        return false;
    L25:
        return false;
    }

    public final boolean a(KeyEvent r7) {
        int r1 = 0;
        if (r7.getAction() == 1) goto L32;
        int r0 = r7.getKeyCode();
        if (r0 == 61) goto L24;
        if (r0 == 66) goto L19;
        switch(r0) {
            case 19: goto L11;
            case 20: goto L11;
            case 21: goto L11;
            case 22: goto L11;
            case 23: goto L19;
            default: goto L40;
        };
    L40:
        return false;
    L11:
        if (r7.hasNoModifiers() == false) goto L33;
        int r2 = e(r0);
        int r8 = r7.getRepeatCount() + 1;
        boolean r3 = false;
    L13:
        if (r1 >= r8) goto L34;
        if (b(r2, null) == false) goto L34;
        r1 = r1 + 1;
        r3 = true;
    L34:
        return r3;
    L33:
        return false;
    L19:
        if (r7.hasNoModifiers() == true) goto L21;
        return false;
    L21:
        if (r7.getRepeatCount() != 0) goto L36;
        e();
        return true;
    L36:
        return false;
    L24:
        if (r7.hasNoModifiers() == false) goto L27;
        return b(2, null);
    L27:
        if (r7.hasModifiers(1) == true) goto L29;
        return false;
    L29:
        return b(1, null);
    L32:
        return false;
    }

    public final void a(boolean r3, int r4, Rect r5) {
        int r0 = this.f1552b;
        if (r0 == Integer.MIN_VALUE) goto L5;
        d(r0);
    L5:
        if (r3 == false) goto L8;
        b(r4, r5);
        return;
    }

    public final int b() {
        return this.f1551a;
    }

    public final int c() {
        return this.f1552b;
    }

    private void a(int r1, Rect r2) {
        b(r1).a(r2);
    }

    private boolean b(int r11, Rect r12) {
        h<androidx.core.view.accessibility.b> r7 = d();
        int r0 = this.f1552b;
        int r9 = Integer.MIN_VALUE;
        if (r0 != Integer.MIN_VALUE) goto L5;
        androidx.core.view.accessibility.b r1 = null;
    L6:
        androidx.core.view.accessibility.b r3 = r1;
        if (r11 == 1) goto L29;
        if (r11 == 2) goto L29;
        if (r11 != 17) goto L13;
    L21:
        Rect r4 = new Rect();
        int r2 = this.f1552b;
        if (r2 == Integer.MIN_VALUE) goto L24;
        a(r2, r4);
    L27:
        androidx.core.view.accessibility.b r13 = (androidx.core.view.accessibility.b) ZeusTransformUtils.preCheckCast(b.a(r7, m, l, r3, r4, r11), androidx.core.view.accessibility.b.class, "com.obric.aiagent.plugin");
    L33:
        if (r13 == null) goto L37;
        r9 = r7.c(r7.a(r13));
    L37:
        return c(r9);
    L24:
        if (r12 == null) goto L26;
        r4.set(r12);
        goto L27
    L26:
        a(this.i, r11, r4);
        goto L27
    L13:
        if (r11 == 33) goto L21;
        if (r11 == 66) goto L21;
        if (r11 == 130) goto L21;
        throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    L29:
        if (ViewCompat.i(this.i) != 1) goto L31;
        boolean r5 = true;
    L32:
        r13 = (androidx.core.view.accessibility.b) ZeusTransformUtils.preCheckCast(b.a(r7, m, l, r3, r11, r5, false), androidx.core.view.accessibility.b.class, "com.obric.aiagent.plugin");
        goto L33
    L31:
        r5 = false;
        goto L32
    L5:
        r1 = (androidx.core.view.accessibility.b) ZeusTransformUtils.preCheckCast(r7.a(r0), androidx.core.view.accessibility.b.class, "com.obric.aiagent.plugin");
        goto L6
    }

    private h<androidx.core.view.accessibility.b> d() {
        ArrayList r0 = new ArrayList();
        a(r0);
        h<androidx.core.view.accessibility.b> r1 = new h();
        int r2 = 0;
    L4:
        if (r2 >= r0.size()) goto L6;
        androidx.core.view.accessibility.b r3 = h(((Integer) ZeusTransformUtils.preCheckCast(r0.get(r2), Integer.class, "com.obric.aiagent.plugin")).intValue());
        r1.b(((Integer) ZeusTransformUtils.preCheckCast(r0.get(r2), Integer.class, "com.obric.aiagent.plugin")).intValue(), r3);
        r2 = r2 + 1;
        goto L4
    L6:
        return r1;
    }

    private static Rect a(View r4, int r5, Rect r6) {
        int r0 = r4.getWidth();
        int r7 = r4.getHeight();
        if (r5 != 17) goto L5;
        r6.set(r0, 0, r0, r7);
    L16:
        return r6;
    L5:
        if (r5 != 33) goto L7;
        r6.set(0, r7, r0, r7);
        goto L16
    L7:
        if (r5 != 66) goto L9;
        r6.set(-1, 0, -1, r7);
        goto L16
    L9:
        if (r5 != 130) goto L12;
        r6.set(0, -1, r0, -1);
        goto L16
    L12:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    private boolean e() {
        int r0 = this.f1552b;
        if (r0 != Integer.MIN_VALUE) goto L5;
    L7:
        return false;
    L5:
        if (b(r0, 16, null) == false) goto L7;
        return true;
    }

    public final boolean a(int r3, int r4) {
        if (r3 != Integer.MIN_VALUE) goto L5;
    L12:
        return false;
    L5:
        if (this.h.isEnabled() == false) goto L12;
        ViewParent r1 = this.i.getParent();
        if (r1 != null) goto L10;
        return false;
    L10:
        AccessibilityEvent r5 = c(r3, r4);
        return r1.requestSendAccessibilityEvent(this.i, r5);
    }

    public final void a(int r2) {
        b(r2, 0);
    }

    public final void b(int r3, int r4) {
        if (r3 != Integer.MIN_VALUE) goto L5;
        return;
    L5:
        if (this.h.isEnabled() == false) goto L11;
        ViewParent r0 = this.i.getParent();
        if (r0 == null) goto L12;
        AccessibilityEvent r5 = c(r3, 2048);
        androidx.core.view.accessibility.a.a(r5, r4);
        r0.requestSendAccessibilityEvent(this.i, r5);
        return;
    L12:
        return;
    }

    private void f(int r3) {
        int r0 = this.k;
        if (r0 != r3) goto L5;
        return;
    L5:
        this.k = r3;
        a(r3, 128);
        a(r0, 256);
    }

    private AccessibilityEvent c(int r2, int r3) {
        if (r2 == (-1)) goto L7;
        return d(r2, r3);
    L7:
        return g(r3);
    }

    private AccessibilityEvent g(int r1) {
        AccessibilityEvent r2 = AccessibilityEvent.obtain(r1);
        this.i.onInitializeAccessibilityEvent(r2);
        return r2;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void d(View r1, AccessibilityEvent r2) {
        super.d(r1, r2);
        a(r2);
    }

    private AccessibilityEvent d(int r4, int r5) {
        AccessibilityEvent r6 = AccessibilityEvent.obtain(r5);
        androidx.core.view.accessibility.b r0 = b(r4);
        r6.getText().add(r0.x());
        r6.setContentDescription(r0.y());
        r6.setScrollable(r0.q());
        r6.setPassword(r0.p());
        r6.setEnabled(r0.o());
        r6.setChecked(r0.g());
        a(r4, r6);
        if (r6.getText().isEmpty() == true) goto L5;
    L9:
        r6.setClassName(r0.w());
        androidx.core.view.accessibility.c.a(r6, this.i, r4);
        r6.setPackageName(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.i.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getPackageName());
        return r6;
    L5:
        if (r6.getContentDescription() != null) goto L9;
        throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
    }

    androidx.core.view.accessibility.b b(int r2) {
        if (r2 != (-1)) goto L7;
        return f();
    L7:
        return h(r2);
    }

    private androidx.core.view.accessibility.b f() {
        androidx.core.view.accessibility.b r0 = androidx.core.view.accessibility.b.a(this.i);
        ViewCompat.a(this.i, r0);
        ArrayList r1 = new ArrayList();
        a(r1);
        if (r0.c() > 0) goto L5;
    L9:
        int r2 = 0;
        int r3 = r1.size();
    L10:
        if (r2 >= r3) goto L12;
        r0.b(this.i, ((Integer) ZeusTransformUtils.preCheckCast(r1.get(r2), Integer.class, "com.obric.aiagent.plugin")).intValue());
        r2 = r2 + 1;
        goto L10
    L12:
        return r0;
    L5:
        if (r1.size() <= 0) goto L9;
        throw new RuntimeException("Views cannot have both real and virtual children");
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void a(View r1, androidx.core.view.accessibility.b r2) {
        super.a(r1, r2);
        a(r2);
    }

    private androidx.core.view.accessibility.b h(int r8) {
        androidx.core.view.accessibility.b r0 = androidx.core.view.accessibility.b.b();
        r0.j(true);
        r0.c(true);
        r0.b("android.view.View");
        Rect r2 = f1550c;
        r0.b(r2);
        r0.d(r2);
        r0.d(this.i);
        a(r8, r0);
        if (r0.x() == null) goto L5;
    L9:
        r0.a(this.f1554e);
        if (this.f1554e.equals(r2) == true) goto L50;
        int r3 = r0.d();
        if ((r3 & 64) != 0) goto L48;
        if ((r3 & 128) != 0) goto L46;
        r0.a(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.i.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getPackageName());
        r0.a(this.i, r8);
        if (this.f1551a != r8) goto L18;
        r0.f(true);
        r0.a(128);
    L20:
        if (this.f1552b != r8) goto L22;
        boolean r9 = true;
    L23:
        if (r9 == false) goto L26;
        r0.a(2);
    L28:
        r0.d(r9);
        this.i.getLocationOnScreen(this.g);
        r0.c(this.f1553d);
        if (this.f1553d.equals(r2) == false) goto L38;
        r0.a(this.f1553d);
        if (r0.f1434a == (-1)) goto L36;
        androidx.core.view.accessibility.b r10 = androidx.core.view.accessibility.b.b();
        int r4 = r0.f1434a;
    L33:
        if (r4 == (-1)) goto L35;
        r10.c(this.i, -1);
        r10.b(f1550c);
        a(r4, r10);
        r10.a(this.f1554e);
        this.f1553d.offset(this.f1554e.left, this.f1554e.top);
        r4 = r10.f1434a;
        goto L33
    L35:
        r10.C();
    L36:
        this.f1553d.offset(this.g[0] - this.i.getScrollX(), this.g[1] - this.i.getScrollY());
    L38:
        if (this.i.getLocalVisibleRect(this.f) == false) goto L44;
        this.f.offset(this.g[0] - this.i.getScrollX(), this.g[1] - this.i.getScrollY());
        if (this.f1553d.intersect(this.f) == false) goto L44;
        r0.d(this.f1553d);
        if (a(this.f1553d) == false) goto L44;
        r0.e(true);
    L44:
        return r0;
    L26:
        if (r0.h() == false) goto L28;
        r0.a(1);
        goto L28
    L22:
        r9 = false;
        goto L23
    L18:
        r0.f(false);
        r0.a(64);
        goto L20
    L46:
        throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
    L48:
        throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
    L50:
        throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
    L5:
        if (r0.y() != null) goto L9;
        throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
    }

    boolean a(int r2, int r3, Bundle r4) {
        if (r2 == (-1)) goto L7;
        return c(r2, r3, r4);
    L7:
        return a(r3, r4);
    }

    private boolean a(int r1, Bundle r2) {
        return ViewCompat.a(this.i, r1, r2);
    }

    private boolean c(int r2, int r3, Bundle r4) {
        if (r3 == 1) goto L19;
        if (r3 == 2) goto L17;
        if (r3 == 64) goto L15;
        if (r3 == 128) goto L13;
        return b(r2, r3, r4);
    L13:
        return j(r2);
    L15:
        return i(r2);
    L17:
        return d(r2);
    L19:
        return c(r2);
    }

    private boolean a(Rect r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        if (r3.isEmpty() == false) goto L8;
        return false;
    L8:
        if (this.i.getWindowVisibility() == 0) goto L10;
        return false;
    L10:
        ViewParent r2 = this.i.getParent();
    L12:
        if (ZeusTransformUtils.instanceOf(r2, View.class) == false) goto L20;
        View r4 = (View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin");
        if (r4.getAlpha() <= 0.0f) goto L19;
        if (r4.getVisibility() != 0) goto L19;
        r2 = r4.getParent();
    L19:
        return false;
    L20:
        if (r2 == null) goto L27;
        return true;
    L27:
        return false;
    }

    private boolean i(int r3) {
        if (this.h.isEnabled() == true) goto L5;
    L14:
        return false;
    L5:
        if (this.h.isTouchExplorationEnabled() == false) goto L14;
        int r0 = this.f1551a;
        if (r0 == r3) goto L14;
        if (r0 == Integer.MIN_VALUE) goto L12;
        j(r0);
    L12:
        this.f1551a = r3;
        this.i.invalidate();
        a(r3, 32768);
        return true;
    }

    private boolean j(int r2) {
        if (this.f1551a != r2) goto L6;
        this.f1551a = Integer.MIN_VALUE;
        this.i.invalidate();
        a(r2, 65536);
        return true;
    L6:
        return false;
    }

    public final boolean c(int r4) {
        if (this.i.isFocused() == false) goto L5;
    L7:
        int r0 = this.f1552b;
        if (r0 != r4) goto L11;
        return false;
    L11:
        if (r0 == Integer.MIN_VALUE) goto L13;
        d(r0);
    L13:
        if (r4 != Integer.MIN_VALUE) goto L15;
        return false;
    L15:
        this.f1552b = r4;
        a(r4, true);
        a(r4, 8);
        return true;
    L5:
        if (this.i.requestFocus() == true) goto L7;
        return false;
    }

    public final boolean d(int r3) {
        if (this.f1552b == r3) goto L5;
        return false;
    L5:
        this.f1552b = Integer.MIN_VALUE;
        a(r3, false);
        a(r3, 8);
        return true;
    }
}
