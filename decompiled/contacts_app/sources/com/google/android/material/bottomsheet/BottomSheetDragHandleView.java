package com.google.android.material.bottomsheet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import com.google.android.material.R;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* JADX INFO: loaded from: classes2.dex */
public class BottomSheetDragHandleView extends AppCompatImageView implements AccessibilityManager.AccessibilityStateChangeListener {
    private static final int DEF_STYLE_RES = 0;
    private final AccessibilityManager accessibilityManager;
    private boolean accessibilityServiceEnabled;
    private BottomSheetBehavior<?> bottomSheetBehavior;
    private final BottomSheetBehavior.BottomSheetCallback bottomSheetCallback;
    private final String clickFeedback;
    private final String clickToCollapseActionLabel;
    private boolean clickToExpand;
    private final String clickToExpandActionLabel;
    private boolean interactable;

    static /* synthetic */ void access$000(BottomSheetDragHandleView r0, int r1) {
        r0.onBottomSheetStateChanged(r1);
    }

    static /* synthetic */ boolean access$100(BottomSheetDragHandleView r0) {
        return r0.expandOrCollapseBottomSheetIfPossible();
    }

    static {
        DEF_STYLE_RES = R.style.Widget_Material3_BottomSheet_DragHandle;
    }

    public BottomSheetDragHandleView(Context r2) {
        this(r2, null);
    }

    public BottomSheetDragHandleView(Context r2, AttributeSet r3) {
        this(r2, r3, R.attr.bottomSheetDragHandleStyle);
    }

    public BottomSheetDragHandleView(Context r2, AttributeSet r3, int r4) {
        super(MaterialThemeOverlay.wrap(r2, r3, r4, DEF_STYLE_RES), r3, r4);
        this.clickToExpandActionLabel = getResources().getString(R.string.bottomsheet_action_expand);
        this.clickToCollapseActionLabel = getResources().getString(R.string.bottomsheet_action_collapse);
        this.clickFeedback = getResources().getString(R.string.bottomsheet_drag_handle_clicked);
        this.bottomSheetCallback = new AnonymousClass1(this);
        this.accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        updateInteractableState();
        ViewCompat.setAccessibilityDelegate(this, new AnonymousClass2(this));
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setBottomSheetBehavior(findParentBottomSheetBehavior());
        AccessibilityManager r0 = this.accessibilityManager;
        if (r0 == null) goto L6;
        r0.addAccessibilityStateChangeListener(this);
        onAccessibilityStateChanged(this.accessibilityManager.isEnabled());
        return;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        AccessibilityManager r0 = this.accessibilityManager;
        if (r0 == null) goto L5;
        r0.removeAccessibilityStateChangeListener(this);
    L5:
        setBottomSheetBehavior(null);
        super.onDetachedFromWindow();
    }

    @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
    public void onAccessibilityStateChanged(boolean r1) {
        this.accessibilityServiceEnabled = r1;
        updateInteractableState();
    }

    private void setBottomSheetBehavior(BottomSheetBehavior<?> r3) {
        BottomSheetBehavior<?> r0 = this.bottomSheetBehavior;
        if (r0 == null) goto L5;
        r0.removeBottomSheetCallback(this.bottomSheetCallback);
        this.bottomSheetBehavior.setAccessibilityDelegateView(null);
    L5:
        this.bottomSheetBehavior = r3;
        if (r3 == null) goto L8;
        r3.setAccessibilityDelegateView(this);
        onBottomSheetStateChanged(this.bottomSheetBehavior.getState());
        this.bottomSheetBehavior.addBottomSheetCallback(this.bottomSheetCallback);
    L8:
        updateInteractableState();
    }

    private void onBottomSheetStateChanged(int r3) {
        if (r3 != 4) goto L6;
        this.clickToExpand = true;
    L8:
        AccessibilityNodeInfoCompat.AccessibilityActionCompat r4 = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK;
        if (this.clickToExpand == false) goto L11;
        String r0 = this.clickToExpandActionLabel;
    L12:
        ViewCompat.replaceAccessibilityAction(this, r4, r0, new BottomSheetDragHandleView$$ExternalSyntheticLambda0(this));
        return;
    L11:
        r0 = this.clickToCollapseActionLabel;
        goto L12
    L6:
        if (r3 != 3) goto L8;
        this.clickToExpand = false;
        goto L8
    }

    /* JADX INFO: renamed from: lambda$onBottomSheetStateChanged$0$com-google-android-material-bottomsheet-BottomSheetDragHandleView, reason: not valid java name */
    /* synthetic */ boolean m242xa7b4c95f(View r1, AccessibilityViewCommand.CommandArguments r2) {
        return expandOrCollapseBottomSheetIfPossible();
    }

    private void updateInteractableState() {
        int r1 = 1;
        if (this.accessibilityServiceEnabled == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        this.interactable = r0;
        if (this.bottomSheetBehavior != null) goto L12;
        r1 = 2;
    L12:
        ViewCompat.setImportantForAccessibility(this, r1);
        setClickable(this.interactable);
        return;
    L5:
        if (this.bottomSheetBehavior == null) goto L7;
        r0 = true;
        goto L8
    }

    private boolean expandOrCollapseBottomSheetIfPossible() {
        boolean r1 = false;
        if (this.interactable == true) goto L5;
        return false;
    L5:
        announceAccessibilityEvent(this.clickFeedback);
        if (this.bottomSheetBehavior.isFitToContents() == false) goto L8;
    L10:
        int r0 = this.bottomSheetBehavior.getState();
        int r3 = 6;
        int r4 = 3;
        if (r0 != 4) goto L14;
        if (r1 == true) goto L23;
    L22:
        r3 = r4;
    L23:
        this.bottomSheetBehavior.setState(r3);
        return true;
    L14:
        if (r0 != 3) goto L19;
        if (r1 == true) goto L23;
        r3 = 4;
        goto L23
    L19:
        if (this.clickToExpand == true) goto L22;
        r4 = 4;
        goto L22
    L8:
        if (this.bottomSheetBehavior.shouldSkipHalfExpandedStateWhenDragging() == true) goto L10;
        r1 = true;
        goto L10
    }

    private void announceAccessibilityEvent(String r3) {
        if (this.accessibilityManager != null) goto L5;
        return;
    L5:
        AccessibilityEvent r0 = AccessibilityEvent.obtain(16384);
        r0.getText().add(r3);
        this.accessibilityManager.sendAccessibilityEvent(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.android.material.bottomsheet.BottomSheetDragHandleView] */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.view.View] */
    private BottomSheetBehavior<?> findParentBottomSheetBehavior() {
    L2:
        BottomSheetDragHandleView this = getParentView(this);
        if (this == 0) goto L10;
        ViewGroup.LayoutParams r0 = this.getLayoutParams();
        if ((r0 instanceof CoordinatorLayout.LayoutParams) == false) goto L2;
        CoordinatorLayout.Behavior r1 = ((CoordinatorLayout.LayoutParams) r0).getBehavior();
        if ((r1 instanceof BottomSheetBehavior) == false) goto L2;
        return (BottomSheetBehavior) r1;
    L10:
        return null;
    }

    private static View getParentView(View r1) {
        Object r2 = r1.getParent();
        if ((r2 instanceof View) == true) goto L7;
        return null;
    L7:
        return (View) r2;
    }
}
