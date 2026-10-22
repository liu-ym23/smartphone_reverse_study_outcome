package androidx.customview.widget;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.e;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.obric.capabilitykit.common.UiType;
import java.util.ArrayList;
import java.util.List;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends androidx.core.view.a {
    private static final String DEFAULT_CLASS_NAME = "android.view.View";
    public static final int HOST_ID = -1;
    public static final int INVALID_ID = Integer.MIN_VALUE;
    private static final Rect INVALID_PARENT_BOUNDS = null;
    private static final FocusStrategy.BoundsAdapter<AccessibilityNodeInfoCompat> NODE_ADAPTER = null;
    private static final FocusStrategy.CollectionAdapter<e, AccessibilityNodeInfoCompat> SPARSE_VALUES_ADAPTER = null;
    int mAccessibilityFocusedVirtualViewId;
    private final View mHost;
    private int mHoveredVirtualViewId;
    int mKeyboardFocusedVirtualViewId;
    private final AccessibilityManager mManager;
    private c mNodeProvider;
    private final int[] mTempGlobalRect;
    private final Rect mTempParentRect;
    private final Rect mTempScreenRect;
    private final Rect mTempVisibleRect;

    /* JADX INFO: renamed from: androidx.customview.widget.a$a, reason: collision with other inner class name */
    public class C0024a implements FocusStrategy.BoundsAdapter {
        public C0024a() {
        }

        public void a(AccessibilityNodeInfoCompat r10, Rect r11) {
            r10.j(r11);
        }

        @Override // androidx.customview.widget.FocusStrategy.BoundsAdapter
        public /* bridge */ /* synthetic */ void obtainBounds(Object r10, Rect r11) {
            a((AccessibilityNodeInfoCompat) r10, r11);
        }
    }

    public class b implements FocusStrategy.CollectionAdapter {
        public b() {
        }

        public AccessibilityNodeInfoCompat a(e r10, int r11) {
            return (AccessibilityNodeInfoCompat) r10.o(r11);
        }

        public int b(e r10) {
            return r10.n();
        }

        @Override // androidx.customview.widget.FocusStrategy.CollectionAdapter
        public /* bridge */ /* synthetic */ Object get(Object r10, int r11) {
            return a((e) r10, r11);
        }

        @Override // androidx.customview.widget.FocusStrategy.CollectionAdapter
        public /* bridge */ /* synthetic */ int size(Object r10) {
            return b((e) r10);
        }
    }

    public class c extends r.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f2853b;

        public c(a r10) {
            this.f2853b = r10;
        }

        @Override // r.b
        public AccessibilityNodeInfoCompat b(int r10) {
            return AccessibilityNodeInfoCompat.L(this.f2853b.obtainAccessibilityNodeInfo(r10));
        }

        @Override // r.b
        public AccessibilityNodeInfoCompat d(int r10) {
            if (r10 != 2) goto L5;
            int r11 = this.f2853b.mAccessibilityFocusedVirtualViewId;
        L7:
            if (r11 != Integer.MIN_VALUE) goto L11;
            return null;
        L11:
            return b(r11);
        L5:
            r11 = this.f2853b.mKeyboardFocusedVirtualViewId;
            goto L7
        }

        @Override // r.b
        public boolean f(int r10, int r11, Bundle r12) {
            return this.f2853b.performAction(r10, r11, r12);
        }
    }

    static {
        INVALID_PARENT_BOUNDS = new Rect(Channel.UNLIMITED, Channel.UNLIMITED, Integer.MIN_VALUE, Integer.MIN_VALUE);
        NODE_ADAPTER = new C0024a();
        SPARSE_VALUES_ADAPTER = new b();
    }

    public a(View r10) {
        this.mTempScreenRect = new Rect();
        this.mTempParentRect = new Rect();
        this.mTempVisibleRect = new Rect();
        this.mTempGlobalRect = new int[2];
        this.mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
        this.mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
        this.mHoveredVirtualViewId = Integer.MIN_VALUE;
        if (r10 == null) goto L9;
        this.mHost = r10;
        this.mManager = (AccessibilityManager) r10.getContext().getSystemService("accessibility");
        r10.setFocusable(true);
        if (ViewCompat.y(r10) != 0) goto L10;
        ViewCompat.A0(r10, 1);
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("View may not be null");
    }

    public static Rect l(View r10, int r11, Rect r12) {
        int r13 = r10.getWidth();
        int r14 = r10.getHeight();
        if (r11 != 17) goto L5;
        r12.set(r13, 0, r13, r14);
    L16:
        return r12;
    L5:
        if (r11 != 33) goto L7;
        r12.set(0, r14, r13, r14);
        goto L16
    L7:
        if (r11 != 66) goto L9;
        r12.set(-1, 0, -1, r14);
        goto L16
    L9:
        if (r11 != 130) goto L12;
        r12.set(0, -1, r13, -1);
        goto L16
    L12:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    public static int n(int r10) {
        if (r10 != 19) goto L5;
        return 33;
    L5:
        if (r10 != 21) goto L7;
        return 17;
    L7:
        if (r10 == 22) goto L10;
        return 130;
    L10:
        return 66;
    }

    public final boolean c(int r10) {
        if (this.mAccessibilityFocusedVirtualViewId != r10) goto L6;
        this.mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
        this.mHost.invalidate();
        sendEventForVirtualView(r10, 65536);
        return true;
    L6:
        return false;
    }

    public final boolean clearKeyboardFocusForVirtualView(int r10) {
        if (this.mKeyboardFocusedVirtualViewId == r10) goto L5;
        return false;
    L5:
        this.mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
        onVirtualViewKeyboardFocusChanged(r10, false);
        sendEventForVirtualView(r10, 8);
        return true;
    }

    public final boolean d() {
        int r10 = this.mKeyboardFocusedVirtualViewId;
        if (r10 != Integer.MIN_VALUE) goto L5;
    L7:
        return false;
    L5:
        if (onPerformActionForVirtualView(r10, 16, null) == false) goto L7;
        return true;
    }

    public final boolean dispatchHoverEvent(@NonNull MotionEvent r10) {
        if (this.mManager.isEnabled() == true) goto L5;
        return false;
    L5:
        if (this.mManager.isTouchExplorationEnabled() == false) goto L25;
        int r11 = r10.getAction();
        if (r11 != 7) goto L10;
    L19:
        int r12 = getVirtualViewAt(r10.getX(), r10.getY());
        s(r12);
        if (r12 != Integer.MIN_VALUE) goto L22;
        return false;
    L22:
        return true;
    L10:
        if (r11 == 9) goto L19;
        if (r11 == 10) goto L15;
        return false;
    L15:
        if (this.mHoveredVirtualViewId == Integer.MIN_VALUE) goto L18;
        s(Integer.MIN_VALUE);
        return true;
    L18:
        return false;
    L25:
        return false;
    }

    public final boolean dispatchKeyEvent(@NonNull KeyEvent r10) {
        int r11 = 0;
        if (r10.getAction() == 1) goto L32;
        int r12 = r10.getKeyCode();
        if (r12 == 61) goto L24;
        if (r12 == 66) goto L19;
        switch(r12) {
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
        if (r10.hasNoModifiers() == false) goto L33;
        int r13 = n(r12);
        int r14 = r10.getRepeatCount() + 1;
        boolean r15 = false;
    L13:
        if (r11 >= r14) goto L34;
        if (o(r13, null) == false) goto L34;
        r11 = r11 + 1;
        r15 = true;
    L34:
        return r15;
    L33:
        return false;
    L19:
        if (r10.hasNoModifiers() == true) goto L21;
        return false;
    L21:
        if (r10.getRepeatCount() != 0) goto L36;
        d();
        return true;
    L36:
        return false;
    L24:
        if (r10.hasNoModifiers() == false) goto L27;
        return o(2, null);
    L27:
        if (r10.hasModifiers(1) == true) goto L29;
        return false;
    L29:
        return o(1, null);
    L32:
        return false;
    }

    public final AccessibilityEvent e(int r10, int r11) {
        if (r10 == (-1)) goto L7;
        return f(r10, r11);
    L7:
        return g(r11);
    }

    public final AccessibilityEvent f(int r10, int r11) {
        AccessibilityEvent r12 = AccessibilityEvent.obtain(r11);
        AccessibilityNodeInfoCompat r13 = obtainAccessibilityNodeInfo(r10);
        r12.getText().add(r13.s());
        r12.setContentDescription(r13.o());
        r12.setScrollable(r13.F());
        r12.setPassword(r13.E());
        r12.setEnabled(r13.A());
        r12.setChecked(r13.y());
        onPopulateEventForVirtualView(r10, r12);
        if (r12.getText().isEmpty() == true) goto L5;
    L9:
        r12.setClassName(r13.m());
        r.c.c(r12, this.mHost, r10);
        r12.setPackageName(this.mHost.getContext().getPackageName());
        return r12;
    L5:
        if (r12.getContentDescription() != null) goto L9;
        throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
    }

    public final AccessibilityEvent g(int r10) {
        AccessibilityEvent r11 = AccessibilityEvent.obtain(r10);
        this.mHost.onInitializeAccessibilityEvent(r11);
        return r11;
    }

    public final int getAccessibilityFocusedVirtualViewId() {
        return this.mAccessibilityFocusedVirtualViewId;
    }

    @Override // androidx.core.view.a
    public r.b getAccessibilityNodeProvider(View r10) {
        if (this.mNodeProvider != null) goto L6;
        this.mNodeProvider = new c(this);
    L6:
        return this.mNodeProvider;
    }

    @Deprecated
    public int getFocusedVirtualView() {
        return getAccessibilityFocusedVirtualViewId();
    }

    public final int getKeyboardFocusedVirtualViewId() {
        return this.mKeyboardFocusedVirtualViewId;
    }

    public abstract int getVirtualViewAt(float r10, float r11);

    public abstract void getVisibleVirtualViews(List r10);

    public final AccessibilityNodeInfoCompat h(int r10) {
        AccessibilityNodeInfoCompat r11 = AccessibilityNodeInfoCompat.J();
        r11.b0(true);
        r11.d0(true);
        r11.V(DEFAULT_CLASS_NAME);
        Rect r12 = INVALID_PARENT_BOUNDS;
        r11.Q(r12);
        r11.R(r12);
        r11.m0(this.mHost);
        onPopulateNodeForVirtualView(r10, r11);
        if (r11.s() == null) goto L5;
    L9:
        r11.j(this.mTempParentRect);
        if (this.mTempParentRect.equals(r12) == true) goto L50;
        int r13 = r11.i();
        if ((r13 & 64) != 0) goto L48;
        if ((r13 & 128) != 0) goto L46;
        r11.k0(this.mHost.getContext().getPackageName());
        r11.v0(this.mHost, r10);
        if (this.mAccessibilityFocusedVirtualViewId != r10) goto L18;
        r11.P(true);
        r11.a(128);
    L20:
        if (this.mKeyboardFocusedVirtualViewId != r10) goto L22;
        boolean r14 = true;
    L23:
        if (r14 == false) goto L26;
        r11.a(2);
    L28:
        r11.e0(r14);
        this.mHost.getLocationOnScreen(this.mTempGlobalRect);
        r11.k(this.mTempScreenRect);
        if (this.mTempScreenRect.equals(r12) == false) goto L38;
        r11.j(this.mTempScreenRect);
        if (r11.f2735b == (-1)) goto L36;
        AccessibilityNodeInfoCompat r15 = AccessibilityNodeInfoCompat.J();
        int r16 = r11.f2735b;
    L33:
        if (r16 == (-1)) goto L35;
        r15.n0(this.mHost, -1);
        r15.Q(INVALID_PARENT_BOUNDS);
        onPopulateNodeForVirtualView(r16, r15);
        r15.j(this.mTempParentRect);
        Rect r17 = this.mTempScreenRect;
        Rect r18 = this.mTempParentRect;
        r17.offset(r18.left, r18.top);
        r16 = r15.f2735b;
        goto L33
    L35:
        r15.N();
    L36:
        this.mTempScreenRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
    L38:
        if (this.mHost.getLocalVisibleRect(this.mTempVisibleRect) == false) goto L44;
        this.mTempVisibleRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
        if (this.mTempScreenRect.intersect(this.mTempVisibleRect) == false) goto L44;
        r11.R(this.mTempScreenRect);
        if (m(this.mTempScreenRect) == false) goto L44;
        r11.z0(true);
    L44:
        return r11;
    L26:
        if (r11.B() == false) goto L28;
        r11.a(1);
        goto L28
    L22:
        r14 = false;
        goto L23
    L18:
        r11.P(false);
        r11.a(64);
        goto L20
    L46:
        throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
    L48:
        throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
    L50:
        throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
    L5:
        if (r11.o() != null) goto L9;
        throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
    }

    public final AccessibilityNodeInfoCompat i() {
        AccessibilityNodeInfoCompat r10 = AccessibilityNodeInfoCompat.K(this.mHost);
        ViewCompat.c0(this.mHost, r10);
        ArrayList r11 = new ArrayList();
        getVisibleVirtualViews(r11);
        if (r10.l() > 0) goto L5;
    L9:
        int r12 = r11.size();
        int r13 = 0;
    L10:
        if (r13 >= r12) goto L12;
        r10.d(this.mHost, ((Integer) r11.get(r13)).intValue());
        r13 = r13 + 1;
        goto L10
    L12:
        return r10;
    L5:
        if (r11.size() <= 0) goto L9;
        throw new RuntimeException("Views cannot have both real and virtual children");
    }

    public final void invalidateRoot() {
        invalidateVirtualView(-1, 1);
    }

    public final void invalidateVirtualView(int r10) {
        invalidateVirtualView(r10, 0);
    }

    public final e j() {
        ArrayList r10 = new ArrayList();
        getVisibleVirtualViews(r10);
        e r11 = new e();
        int r12 = 0;
    L4:
        if (r12 >= r10.size()) goto L6;
        AccessibilityNodeInfoCompat r13 = h(((Integer) r10.get(r12)).intValue());
        r11.k(((Integer) r10.get(r12)).intValue(), r13);
        r12 = r12 + 1;
        goto L4
    L6:
        return r11;
    }

    public final void k(int r10, Rect r11) {
        obtainAccessibilityNodeInfo(r10).j(r11);
    }

    public final boolean m(Rect r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        if (r10.isEmpty() == false) goto L8;
        return false;
    L8:
        if (this.mHost.getWindowVisibility() == 0) goto L10;
        return false;
    L10:
        Object r11 = this.mHost.getParent();
    L12:
        if ((r11 instanceof View) == false) goto L20;
        View r12 = (View) r11;
        if (r12.getAlpha() <= 0.0f) goto L19;
        if (r12.getVisibility() != 0) goto L19;
        r11 = r12.getParent();
    L19:
        return false;
    L20:
        if (r11 == null) goto L27;
        return true;
    L27:
        return false;
    }

    public final boolean o(int r10, Rect r11) {
        e r12 = j();
        int r13 = this.mKeyboardFocusedVirtualViewId;
        int r14 = Integer.MIN_VALUE;
        if (r13 != Integer.MIN_VALUE) goto L6;
        AccessibilityNodeInfoCompat r15 = null;
    L5:
        AccessibilityNodeInfoCompat r16 = r15;
        if (r10 == 1) goto L30;
        if (r10 == 2) goto L30;
        if (r10 != 17) goto L14;
    L22:
        Rect r17 = new Rect();
        int r18 = this.mKeyboardFocusedVirtualViewId;
        if (r18 == Integer.MIN_VALUE) goto L25;
        k(r18, r17);
    L28:
        AccessibilityNodeInfoCompat r19 = (AccessibilityNodeInfoCompat) FocusStrategy.c(r12, SPARSE_VALUES_ADAPTER, NODE_ADAPTER, r16, r17, r10);
    L34:
        if (r19 == null) goto L38;
        r14 = r12.j(r12.i(r19));
    L38:
        return requestKeyboardFocusForVirtualView(r14);
    L25:
        if (r11 == null) goto L27;
        r17.set(r11);
        goto L28
    L27:
        l(this.mHost, r10, r17);
        goto L28
    L14:
        if (r10 == 33) goto L22;
        if (r10 == 66) goto L22;
        if (r10 == 130) goto L22;
        throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    L30:
        if (ViewCompat.A(this.mHost) != 1) goto L32;
        boolean r20 = true;
    L33:
        r19 = (AccessibilityNodeInfoCompat) FocusStrategy.d(r12, SPARSE_VALUES_ADAPTER, NODE_ADAPTER, r16, r10, r20, false);
        goto L34
    L32:
        r20 = false;
        goto L33
    L6:
        r15 = (AccessibilityNodeInfoCompat) r12.f(r13);
        goto L5
    }

    @NonNull
    public AccessibilityNodeInfoCompat obtainAccessibilityNodeInfo(int r10) {
        if (r10 != (-1)) goto L7;
        return i();
    L7:
        return h(r10);
    }

    public final void onFocusChanged(boolean r10, int r11, @Nullable Rect r12) {
        int r13 = this.mKeyboardFocusedVirtualViewId;
        if (r13 == Integer.MIN_VALUE) goto L5;
        clearKeyboardFocusForVirtualView(r13);
    L5:
        if (r10 == false) goto L8;
        o(r11, r12);
        return;
    }

    @Override // androidx.core.view.a
    public void onInitializeAccessibilityEvent(View r10, AccessibilityEvent r11) {
        super.onInitializeAccessibilityEvent(r10, r11);
        onPopulateEventForHost(r11);
    }

    @Override // androidx.core.view.a
    public void onInitializeAccessibilityNodeInfo(View r10, AccessibilityNodeInfoCompat r11) {
        super.onInitializeAccessibilityNodeInfo(r10, r11);
        onPopulateNodeForHost(r11);
    }

    public abstract boolean onPerformActionForVirtualView(int r10, int r11, Bundle r12);

    public void onPopulateEventForHost(@NonNull AccessibilityEvent r10) {
    }

    public void onPopulateEventForVirtualView(int r10, @NonNull AccessibilityEvent r11) {
    }

    public void onPopulateNodeForHost(@NonNull AccessibilityNodeInfoCompat r10) {
    }

    public abstract void onPopulateNodeForVirtualView(int r10, AccessibilityNodeInfoCompat r11);

    public void onVirtualViewKeyboardFocusChanged(int r10, boolean r11) {
    }

    public final boolean p(int r10, int r11, Bundle r12) {
        if (r11 == 1) goto L19;
        if (r11 == 2) goto L17;
        if (r11 == 64) goto L15;
        if (r11 == 128) goto L13;
        return onPerformActionForVirtualView(r10, r11, r12);
    L13:
        return c(r10);
    L15:
        return r(r10);
    L17:
        return clearKeyboardFocusForVirtualView(r10);
    L19:
        return requestKeyboardFocusForVirtualView(r10);
    }

    public boolean performAction(int r10, int r11, Bundle r12) {
        if (r10 == (-1)) goto L7;
        return p(r10, r11, r12);
    L7:
        return q(r11, r12);
    }

    public final boolean q(int r10, Bundle r11) {
        return ViewCompat.e0(this.mHost, r10, r11);
    }

    public final boolean r(int r10) {
        if (this.mManager.isEnabled() == true) goto L5;
    L14:
        return false;
    L5:
        if (this.mManager.isTouchExplorationEnabled() == false) goto L14;
        int r11 = this.mAccessibilityFocusedVirtualViewId;
        if (r11 == r10) goto L14;
        if (r11 == Integer.MIN_VALUE) goto L12;
        c(r11);
    L12:
        this.mAccessibilityFocusedVirtualViewId = r10;
        this.mHost.invalidate();
        sendEventForVirtualView(r10, UiType.FLAG_SETTINGS_CARD);
        return true;
    }

    public final boolean requestKeyboardFocusForVirtualView(int r10) {
        if (this.mHost.isFocused() == false) goto L5;
    L7:
        int r11 = this.mKeyboardFocusedVirtualViewId;
        if (r11 != r10) goto L11;
        return false;
    L11:
        if (r11 == Integer.MIN_VALUE) goto L13;
        clearKeyboardFocusForVirtualView(r11);
    L13:
        if (r10 != Integer.MIN_VALUE) goto L15;
        return false;
    L15:
        this.mKeyboardFocusedVirtualViewId = r10;
        onVirtualViewKeyboardFocusChanged(r10, true);
        sendEventForVirtualView(r10, 8);
        return true;
    L5:
        if (this.mHost.requestFocus() == true) goto L7;
        return false;
    }

    public final void s(int r10) {
        int r11 = this.mHoveredVirtualViewId;
        if (r11 != r10) goto L5;
        return;
    L5:
        this.mHoveredVirtualViewId = r10;
        sendEventForVirtualView(r10, 128);
        sendEventForVirtualView(r11, 256);
    }

    public final boolean sendEventForVirtualView(int r10, int r11) {
        if (r10 != Integer.MIN_VALUE) goto L5;
    L12:
        return false;
    L5:
        if (this.mManager.isEnabled() == false) goto L12;
        ViewParent r12 = this.mHost.getParent();
        if (r12 != null) goto L10;
        return false;
    L10:
        AccessibilityEvent r13 = e(r10, r11);
        return r12.requestSendAccessibilityEvent(this.mHost, r13);
    }

    public final void invalidateVirtualView(int r10, int r11) {
        if (r10 != Integer.MIN_VALUE) goto L5;
        return;
    L5:
        if (this.mManager.isEnabled() == false) goto L11;
        ViewParent r12 = this.mHost.getParent();
        if (r12 == null) goto L12;
        AccessibilityEvent r13 = e(r10, 2048);
        AccessibilityEventCompat.b(r13, r11);
        r12.requestSendAccessibilityEvent(this.mHost, r13);
        return;
    L12:
        return;
    }
}
