package androidx.customview.widget;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes17.dex */
public abstract class ExploreByTouchHelper extends AccessibilityDelegateCompat {
    private static final String DEFAULT_CLASS_NAME = "android.view.View";
    public static final int HOST_ID = -1;
    public static final int INVALID_ID = Integer.MIN_VALUE;
    private static final Rect INVALID_PARENT_BOUNDS = null;
    private static final FocusStrategy.BoundsAdapter<AccessibilityNodeInfoCompat> NODE_ADAPTER = null;
    private static final FocusStrategy.CollectionAdapter<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat> SPARSE_VALUES_ADAPTER = null;
    int mAccessibilityFocusedVirtualViewId;
    private final View mHost;
    private int mHoveredVirtualViewId;
    int mKeyboardFocusedVirtualViewId;
    private final AccessibilityManager mManager;
    private MyNodeProvider mNodeProvider;
    private final int[] mTempGlobalRect;
    private final Rect mTempParentRect;
    private final Rect mTempScreenRect;
    private final Rect mTempVisibleRect;

    public class MyNodeProvider extends AccessibilityNodeProviderCompat {
        final /* synthetic */ ExploreByTouchHelper this$0;

        public MyNodeProvider(ExploreByTouchHelper r100) {
            this.this$0 = r100;
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int r100) {
            return AccessibilityNodeInfoCompat.obtain(this.this$0.obtainAccessibilityNodeInfo(r100));
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public AccessibilityNodeInfoCompat findFocus(int r100) {
            if (r100 != 2) goto L5;
            int r101 = this.this$0.mAccessibilityFocusedVirtualViewId;
        L7:
            if (r101 != Integer.MIN_VALUE) goto L11;
            return null;
        L11:
            return createAccessibilityNodeInfo(r101);
        L5:
            r101 = this.this$0.mKeyboardFocusedVirtualViewId;
            goto L7
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public boolean performAction(int r100, int r101, Bundle r102) {
            return this.this$0.performAction(r100, r101, r102);
        }
    }

    private static int keyToDirection(int r100) {
        if (r100 != 19) goto L5;
        return 33;
    L5:
        if (r100 != 21) goto L7;
        return 17;
    L7:
        if (r100 == 22) goto L10;
        return 130;
    L10:
        return 66;
    }

    public abstract int getVirtualViewAt(float r100, float r101);

    public abstract void getVisibleVirtualViews(List<Integer> r100);

    public final void invalidateRoot() {
        invalidateVirtualView(-1, 1);
    }

    public abstract boolean onPerformActionForVirtualView(int r100, int r101, Bundle r102);

    public void onPopulateEventForHost(AccessibilityEvent r100) {
    }

    public void onPopulateEventForVirtualView(int r100, AccessibilityEvent r101) {
    }

    public void onPopulateNodeForHost(AccessibilityNodeInfoCompat r100) {
    }

    public abstract void onPopulateNodeForVirtualView(int r100, AccessibilityNodeInfoCompat r101);

    public void onVirtualViewKeyboardFocusChanged(int r100, boolean r101) {
    }

    static {
        INVALID_PARENT_BOUNDS = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
        NODE_ADAPTER = new AnonymousClass1();
        SPARSE_VALUES_ADAPTER = new AnonymousClass2();
    }

    private boolean clickKeyboardFocusedVirtualView() {
        int r100 = this.mKeyboardFocusedVirtualViewId;
        if (r100 != Integer.MIN_VALUE) goto L5;
    L7:
        return false;
    L5:
        if (onPerformActionForVirtualView(r100, 16, null) == false) goto L7;
        return true;
    }

    private AccessibilityNodeInfoCompat createNodeForHost() {
        AccessibilityNodeInfoCompat r100 = AccessibilityNodeInfoCompat.obtain(this.mHost);
        ViewCompat.onInitializeAccessibilityNodeInfo(this.mHost, r100);
        ArrayList r101 = new ArrayList();
        getVisibleVirtualViews(r101);
        if (r100.getChildCount() > 0) goto L5;
    L9:
        int r102 = r101.size();
        int r103 = 0;
    L10:
        if (r103 >= r102) goto L12;
        r100.addChild(this.mHost, ((Integer) ListProtector.get(r101, r103)).intValue());
        r103 = r103 + 1;
        goto L10
    L12:
        return r100;
    L5:
        if (r101.size() <= 0) goto L9;
        throw new RuntimeException("Views cannot have both real and virtual children");
    }

    private SparseArrayCompat<AccessibilityNodeInfoCompat> getAllNodes() {
        ArrayList r100 = new ArrayList();
        getVisibleVirtualViews(r100);
        SparseArrayCompat<AccessibilityNodeInfoCompat> r101 = new SparseArrayCompat();
        int r102 = 0;
    L4:
        if (r102 >= r100.size()) goto L6;
        AccessibilityNodeInfoCompat r103 = createNodeForChild(((Integer) ListProtector.get(r100, r102)).intValue());
        r101.put(((Integer) ListProtector.get(r100, r102)).intValue(), r103);
        r102 = r102 + 1;
        goto L4
    L6:
        return r101;
    }

    public int getFocusedVirtualView() {
        return getAccessibilityFocusedVirtualViewId();
    }

    public final int getAccessibilityFocusedVirtualViewId() {
        return this.mAccessibilityFocusedVirtualViewId;
    }

    public final int getKeyboardFocusedVirtualViewId() {
        return this.mKeyboardFocusedVirtualViewId;
    }

    public ExploreByTouchHelper(View r100) {
        this.mTempScreenRect = new Rect();
        this.mTempParentRect = new Rect();
        this.mTempVisibleRect = new Rect();
        this.mTempGlobalRect = new int[2];
        this.mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
        this.mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
        this.mHoveredVirtualViewId = Integer.MIN_VALUE;
        if (r100 == null) goto L9;
        this.mHost = r100;
        this.mManager = (AccessibilityManager) r100.getContext().getSystemService("accessibility");
        r100.setFocusable(true);
        if (ViewCompat.getImportantForAccessibility(r100) != 0) goto L10;
        ViewCompat.setImportantForAccessibility(r100, 1);
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("View may not be null");
    }

    private boolean clearAccessibilityFocus(int r100) {
        if (this.mAccessibilityFocusedVirtualViewId != r100) goto L6;
        this.mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
        this.mHost.invalidate();
        sendEventForVirtualView(r100, 65536);
        return true;
    L6:
        return false;
    }

    private AccessibilityEvent createEventForHost(int r100) {
        AccessibilityEvent r101 = AccessibilityEvent.obtain(r100);
        this.mHost.onInitializeAccessibilityEvent(r101);
        return r101;
    }

    private AccessibilityNodeInfoCompat createNodeForChild(int r100) {
        AccessibilityNodeInfoCompat r101 = AccessibilityNodeInfoCompat.obtain();
        r101.setEnabled(true);
        r101.setFocusable(true);
        r101.setClassName("android.view.View");
        Rect r102 = INVALID_PARENT_BOUNDS;
        r101.setBoundsInParent(r102);
        r101.setBoundsInScreen(r102);
        r101.setParent(this.mHost);
        onPopulateNodeForVirtualView(r100, r101);
        if (r101.getText() == null) goto L5;
    L9:
        r101.getBoundsInParent(this.mTempParentRect);
        if (this.mTempParentRect.equals(r102) == true) goto L50;
        int r103 = r101.getActions();
        if ((r103 & 64) != 0) goto L48;
        if ((r103 & 128) != 0) goto L46;
        r101.setPackageName(this.mHost.getContext().getPackageName());
        r101.setSource(this.mHost, r100);
        if (this.mAccessibilityFocusedVirtualViewId != r100) goto L18;
        r101.setAccessibilityFocused(true);
        r101.addAction(128);
    L20:
        if (this.mKeyboardFocusedVirtualViewId != r100) goto L22;
        boolean r104 = true;
    L23:
        if (r104 == false) goto L26;
        r101.addAction(2);
    L28:
        r101.setFocused(r104);
        this.mHost.getLocationOnScreen(this.mTempGlobalRect);
        r101.getBoundsInScreen(this.mTempScreenRect);
        if (this.mTempScreenRect.equals(r102) == false) goto L38;
        r101.getBoundsInParent(this.mTempScreenRect);
        if (r101.mParentVirtualDescendantId == (-1)) goto L36;
        AccessibilityNodeInfoCompat r105 = AccessibilityNodeInfoCompat.obtain();
        int r106 = r101.mParentVirtualDescendantId;
    L33:
        if (r106 == (-1)) goto L35;
        r105.setParent(this.mHost, -1);
        r105.setBoundsInParent(INVALID_PARENT_BOUNDS);
        onPopulateNodeForVirtualView(r106, r105);
        r105.getBoundsInParent(this.mTempParentRect);
        Rect r107 = this.mTempScreenRect;
        Rect r108 = this.mTempParentRect;
        r107.offset(r108.left, r108.top);
        r106 = r105.mParentVirtualDescendantId;
        goto L33
    L35:
        r105.recycle();
    L36:
        this.mTempScreenRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
    L38:
        if (this.mHost.getLocalVisibleRect(this.mTempVisibleRect) == false) goto L44;
        this.mTempVisibleRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
        if (this.mTempScreenRect.intersect(this.mTempVisibleRect) == false) goto L44;
        r101.setBoundsInScreen(this.mTempScreenRect);
        if (isVisibleToUser(this.mTempScreenRect) == false) goto L44;
        r101.setVisibleToUser(true);
    L44:
        return r101;
    L26:
        if (r101.isFocusable() == false) goto L28;
        r101.addAction(1);
        goto L28
    L22:
        r104 = false;
        goto L23
    L18:
        r101.setAccessibilityFocused(false);
        r101.addAction(64);
        goto L20
    L46:
        throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
    L48:
        throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
    L50:
        throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
    L5:
        if (r101.getContentDescription() != null) goto L9;
        throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
    }

    private boolean isVisibleToUser(Rect r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.isEmpty() == false) goto L8;
        return false;
    L8:
        if (this.mHost.getWindowVisibility() == 0) goto L10;
        return false;
    L10:
        Object r101 = this.mHost.getParent();
    L12:
        if ((r101 instanceof View) == false) goto L20;
        View r102 = (View) r101;
        if (r102.getAlpha() <= 0.0f) goto L19;
        if (r102.getVisibility() != 0) goto L19;
        r101 = r102.getParent();
    L19:
        return false;
    L20:
        if (r101 == null) goto L27;
        return true;
    L27:
        return false;
    }

    private boolean requestAccessibilityFocus(int r100) {
        if (this.mManager.isEnabled() == true) goto L5;
    L14:
        return false;
    L5:
        if (this.mManager.isTouchExplorationEnabled() == false) goto L14;
        int r101 = this.mAccessibilityFocusedVirtualViewId;
        if (r101 == r100) goto L14;
        if (r101 == Integer.MIN_VALUE) goto L12;
        clearAccessibilityFocus(r101);
    L12:
        this.mAccessibilityFocusedVirtualViewId = r100;
        this.mHost.invalidate();
        sendEventForVirtualView(r100, 32768);
        return true;
    }

    private void updateHoveredVirtualView(int r100) {
        int r101 = this.mHoveredVirtualViewId;
        if (r101 != r100) goto L5;
        return;
    L5:
        this.mHoveredVirtualViewId = r100;
        sendEventForVirtualView(r100, 128);
        sendEventForVirtualView(r101, 256);
    }

    public final boolean clearKeyboardFocusForVirtualView(int r100) {
        if (this.mKeyboardFocusedVirtualViewId == r100) goto L5;
        return false;
    L5:
        this.mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
        onVirtualViewKeyboardFocusChanged(r100, false);
        sendEventForVirtualView(r100, 8);
        return true;
    }

    public final boolean dispatchHoverEvent(MotionEvent r100) {
        if (this.mManager.isEnabled() == true) goto L5;
        return false;
    L5:
        if (this.mManager.isTouchExplorationEnabled() == false) goto L25;
        int r101 = r100.getAction();
        if (r101 != 7) goto L10;
    L19:
        int r102 = getVirtualViewAt(r100.getX(), r100.getY());
        updateHoveredVirtualView(r102);
        if (r102 == Integer.MIN_VALUE) goto L24;
        return true;
    L24:
        return false;
    L10:
        if (r101 == 9) goto L19;
        if (r101 == 10) goto L15;
        return false;
    L15:
        if (this.mHoveredVirtualViewId == Integer.MIN_VALUE) goto L18;
        updateHoveredVirtualView(Integer.MIN_VALUE);
        return true;
    L18:
        return false;
    L25:
        return false;
    }

    public final boolean dispatchKeyEvent(KeyEvent r100) {
        int r101 = 0;
        if (r100.getAction() == 1) goto L32;
        int r102 = r100.getKeyCode();
        if (r102 == 61) goto L24;
        if (r102 == 66) goto L19;
        switch(r102) {
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
        if (r100.hasNoModifiers() == false) goto L33;
        int r103 = keyToDirection(r102);
        int r104 = r100.getRepeatCount() + 1;
        boolean r105 = false;
    L13:
        if (r101 >= r104) goto L34;
        if (moveFocus(r103, null) == false) goto L34;
        r101 = r101 + 1;
        r105 = true;
    L34:
        return r105;
    L33:
        return false;
    L19:
        if (r100.hasNoModifiers() == true) goto L21;
        return false;
    L21:
        if (r100.getRepeatCount() != 0) goto L36;
        clickKeyboardFocusedVirtualView();
        return true;
    L36:
        return false;
    L24:
        if (r100.hasNoModifiers() == false) goto L27;
        return moveFocus(2, null);
    L27:
        if (r100.hasModifiers(1) == true) goto L29;
        return false;
    L29:
        return moveFocus(1, null);
    L32:
        return false;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View r100) {
        if (this.mNodeProvider != null) goto L6;
        this.mNodeProvider = new MyNodeProvider(this);
    L6:
        return this.mNodeProvider;
    }

    public final void invalidateVirtualView(int r100) {
        invalidateVirtualView(r100, 0);
    }

    public AccessibilityNodeInfoCompat obtainAccessibilityNodeInfo(int r100) {
        if (r100 != (-1)) goto L7;
        return createNodeForHost();
    L7:
        return createNodeForChild(r100);
    }

    public final boolean requestKeyboardFocusForVirtualView(int r100) {
        if (this.mHost.isFocused() == false) goto L5;
    L7:
        int r101 = this.mKeyboardFocusedVirtualViewId;
        if (r101 != r100) goto L11;
        return false;
    L11:
        if (r101 == Integer.MIN_VALUE) goto L13;
        clearKeyboardFocusForVirtualView(r101);
    L13:
        if (r100 != Integer.MIN_VALUE) goto L15;
        return false;
    L15:
        this.mKeyboardFocusedVirtualViewId = r100;
        onVirtualViewKeyboardFocusChanged(r100, true);
        sendEventForVirtualView(r100, 8);
        return true;
    L5:
        if (this.mHost.requestFocus() == true) goto L7;
        return false;
    }

    private AccessibilityEvent createEvent(int r100, int r101) {
        if (r100 == (-1)) goto L7;
        return createEventForChild(r100, r101);
    L7:
        return createEventForHost(r101);
    }

    private AccessibilityEvent createEventForChild(int r100, int r101) {
        AccessibilityEvent r102 = AccessibilityEvent.obtain(r101);
        AccessibilityNodeInfoCompat r103 = obtainAccessibilityNodeInfo(r100);
        r102.getText().add(r103.getText());
        r102.setContentDescription(r103.getContentDescription());
        r102.setScrollable(r103.isScrollable());
        r102.setPassword(r103.isPassword());
        r102.setEnabled(r103.isEnabled());
        r102.setChecked(r103.isChecked());
        onPopulateEventForVirtualView(r100, r102);
        if (r102.getText().isEmpty() == true) goto L5;
    L9:
        r102.setClassName(r103.getClassName());
        AccessibilityRecordCompat.setSource(r102, this.mHost, r100);
        r102.setPackageName(this.mHost.getContext().getPackageName());
        return r102;
    L5:
        if (r102.getContentDescription() != null) goto L9;
        throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
    }

    private void getBoundsInParent(int r100, Rect r101) {
        obtainAccessibilityNodeInfo(r100).getBoundsInParent(r101);
    }

    private boolean moveFocus(int r110, Rect r111) {
        SparseArrayCompat<AccessibilityNodeInfoCompat> r100 = getAllNodes();
        int r101 = this.mKeyboardFocusedVirtualViewId;
        int r102 = Integer.MIN_VALUE;
        if (r101 != Integer.MIN_VALUE) goto L5;
        AccessibilityNodeInfoCompat r103 = null;
    L6:
        AccessibilityNodeInfoCompat r104 = r103;
        if (r110 == 1) goto L29;
        if (r110 == 2) goto L29;
        if (r110 != 17) goto L13;
    L21:
        Rect r105 = new Rect();
        int r106 = this.mKeyboardFocusedVirtualViewId;
        if (r106 == Integer.MIN_VALUE) goto L24;
        getBoundsInParent(r106, r105);
    L27:
        AccessibilityNodeInfoCompat r112 = (AccessibilityNodeInfoCompat) FocusStrategy.findNextFocusInAbsoluteDirection(r100, SPARSE_VALUES_ADAPTER, NODE_ADAPTER, r104, r105, r110);
    L33:
        if (r112 == null) goto L37;
        r102 = r100.keyAt(r100.indexOfValue(r112));
    L37:
        return requestKeyboardFocusForVirtualView(r102);
    L24:
        if (r111 == null) goto L26;
        r105.set(r111);
        goto L27
    L26:
        guessPreviouslyFocusedRect(this.mHost, r110, r105);
        goto L27
    L13:
        if (r110 == 33) goto L21;
        if (r110 == 66) goto L21;
        if (r110 == 130) goto L21;
        throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    L29:
        if (ViewCompat.getLayoutDirection(this.mHost) != 1) goto L31;
        boolean r107 = true;
    L32:
        r112 = (AccessibilityNodeInfoCompat) FocusStrategy.findNextFocusInRelativeDirection(r100, SPARSE_VALUES_ADAPTER, NODE_ADAPTER, r104, r110, r107, false);
        goto L33
    L31:
        r107 = false;
        goto L32
    L5:
        r103 = r100.get(r101);
        goto L6
    }

    private boolean performActionForHost(int r100, Bundle r101) {
        return ViewCompat.performAccessibilityAction(this.mHost, r100, r101);
    }

    public final void invalidateVirtualView(int r100, int r101) {
        if (r100 != Integer.MIN_VALUE) goto L5;
        return;
    L5:
        if (this.mManager.isEnabled() == false) goto L11;
        ViewParent r102 = this.mHost.getParent();
        if (r102 == null) goto L12;
        AccessibilityEvent r103 = createEvent(r100, 2048);
        AccessibilityEventCompat.setContentChangeTypes(r103, r101);
        r102.requestSendAccessibilityEvent(this.mHost, r103);
        return;
    L12:
        return;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityEvent(View r100, AccessibilityEvent r101) {
        super.onInitializeAccessibilityEvent(r100, r101);
        onPopulateEventForHost(r101);
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View r100, AccessibilityNodeInfoCompat r101) {
        super.onInitializeAccessibilityNodeInfo(r100, r101);
        onPopulateNodeForHost(r101);
    }

    public final boolean sendEventForVirtualView(int r100, int r101) {
        if (r100 != Integer.MIN_VALUE) goto L5;
    L12:
        return false;
    L5:
        if (this.mManager.isEnabled() == false) goto L12;
        ViewParent r102 = this.mHost.getParent();
        if (r102 != null) goto L10;
        return false;
    L10:
        AccessibilityEvent r103 = createEvent(r100, r101);
        return r102.requestSendAccessibilityEvent(this.mHost, r103);
    }

    private static Rect guessPreviouslyFocusedRect(View r100, int r101, Rect r102) {
        int r103 = r100.getWidth();
        int r104 = r100.getHeight();
        if (r101 != 17) goto L5;
        r102.set(r103, 0, r103, r104);
    L16:
        return r102;
    L5:
        if (r101 != 33) goto L7;
        r102.set(0, r104, r103, r104);
        goto L16
    L7:
        if (r101 != 66) goto L9;
        r102.set(-1, 0, -1, r104);
        goto L16
    L9:
        if (r101 != 130) goto L12;
        r102.set(0, -1, r103, -1);
        goto L16
    L12:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    private boolean performActionForChild(int r100, int r101, Bundle r102) {
        if (r101 == 1) goto L19;
        if (r101 == 2) goto L17;
        if (r101 == 64) goto L15;
        if (r101 == 128) goto L13;
        return onPerformActionForVirtualView(r100, r101, r102);
    L13:
        return clearAccessibilityFocus(r100);
    L15:
        return requestAccessibilityFocus(r100);
    L17:
        return clearKeyboardFocusForVirtualView(r100);
    L19:
        return requestKeyboardFocusForVirtualView(r100);
    }

    public final void onFocusChanged(boolean r100, int r101, Rect r102) {
        int r103 = this.mKeyboardFocusedVirtualViewId;
        if (r103 == Integer.MIN_VALUE) goto L5;
        clearKeyboardFocusForVirtualView(r103);
    L5:
        if (r100 == false) goto L8;
        moveFocus(r101, r102);
        return;
    }

    public boolean performAction(int r100, int r101, Bundle r102) {
        if (r100 == (-1)) goto L7;
        return performActionForChild(r100, r101, r102);
    L7:
        return performActionForHost(r101, r102);
    }
}
