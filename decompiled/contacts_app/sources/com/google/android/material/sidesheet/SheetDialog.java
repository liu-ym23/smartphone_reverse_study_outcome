package com.google.android.material.sidesheet;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.sidesheet.SheetCallback;

/* JADX INFO: loaded from: classes2.dex */
abstract class SheetDialog<C extends SheetCallback> extends AppCompatDialog {
    private static final int COORDINATOR_LAYOUT_ID = 0;
    private static final int TOUCH_OUTSIDE_ID = 0;
    private Sheet<C> behavior;
    boolean cancelable;
    private boolean canceledOnTouchOutside;
    private boolean canceledOnTouchOutsideSet;
    private FrameLayout container;
    boolean dismissWithAnimation;
    private FrameLayout sheet;

    abstract void addSheetCancelOnHideCallback(Sheet<C> r1);

    abstract Sheet<C> getBehaviorFromSheet(FrameLayout r1);

    abstract int getDialogId();

    abstract int getLayoutResId();

    abstract int getStateOnStart();

    static {
        COORDINATOR_LAYOUT_ID = R.id.coordinator;
        TOUCH_OUTSIDE_ID = R.id.touch_outside;
    }

    SheetDialog(Context r1, int r2, int r3, int r4) {
        super(r1, getThemeResId(r1, r2, r3, r4));
        this.cancelable = true;
        this.canceledOnTouchOutside = true;
        supportRequestWindowFeature(1);
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(int r2) {
        super.setContentView(wrapInSheet(r2, null, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(View r3) {
        super.setContentView(wrapInSheet(0, r3, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(View r2, ViewGroup.LayoutParams r3) {
        super.setContentView(wrapInSheet(0, r2, r3));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    protected void onCreate(Bundle r1) {
        super.onCreate(r1);
        Window r0 = getWindow();
        if (r0 == null) goto L6;
        r0.setStatusBarColor(0);
        r0.addFlags(Integer.MIN_VALUE);
        r0.setLayout(-1, -1);
        return;
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean r2) {
        super.setCancelable(r2);
        if (this.cancelable == r2) goto L6;
        this.cancelable = r2;
        return;
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    protected void onStart() {
        super.onStart();
        Sheet<C> r0 = this.behavior;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getState() != 5) goto L9;
        this.behavior.setState(getStateOnStart());
        return;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        Sheet<C> r0 = getBehavior();
        if (this.dismissWithAnimation == true) goto L5;
    L8:
        super.cancel();
        return;
    L5:
        if (r0.getState() == 5) goto L8;
        r0.setState(5);
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean r3) {
        super.setCanceledOnTouchOutside(r3);
        if (r3 == true) goto L5;
    L7:
        this.canceledOnTouchOutside = r3;
        this.canceledOnTouchOutsideSet = true;
        return;
    L5:
        if (this.cancelable == true) goto L7;
        this.cancelable = true;
        goto L7
    }

    public void setDismissWithSheetAnimationEnabled(boolean r1) {
        this.dismissWithAnimation = r1;
    }

    public boolean isDismissWithSheetAnimationEnabled() {
        return this.dismissWithAnimation;
    }

    private void ensureContainerAndBehavior() {
        if (this.container != null) goto L6;
        FrameLayout r0 = (FrameLayout) View.inflate(getContext(), getLayoutResId(), null);
        this.container = r0;
        FrameLayout r1 = (FrameLayout) r0.findViewById(getDialogId());
        this.sheet = r1;
        Sheet<C> r2 = getBehaviorFromSheet(r1);
        this.behavior = r2;
        addSheetCancelOnHideCallback(r2);
        return;
    }

    private FrameLayout getContainer() {
        if (this.container != null) goto L6;
        ensureContainerAndBehavior();
    L6:
        return this.container;
    }

    private FrameLayout getSheet() {
        if (this.sheet != null) goto L6;
        ensureContainerAndBehavior();
    L6:
        return this.sheet;
    }

    Sheet<C> getBehavior() {
        if (this.behavior != null) goto L6;
        ensureContainerAndBehavior();
    L6:
        return this.behavior;
    }

    private View wrapInSheet(int r3, View r4, ViewGroup.LayoutParams r5) {
        ensureContainerAndBehavior();
        CoordinatorLayout r0 = (CoordinatorLayout) getContainer().findViewById(COORDINATOR_LAYOUT_ID);
        if (r3 == 0) goto L6;
        if (r4 != null) goto L6;
        r4 = getLayoutInflater().inflate(r3, r0, false);
    L6:
        FrameLayout r6 = getSheet();
        r6.removeAllViews();
        if (r5 != null) goto L9;
        r6.addView(r4);
    L10:
        r0.findViewById(TOUCH_OUTSIDE_ID).setOnClickListener(new SheetDialog$$ExternalSyntheticLambda0(this));
        ViewCompat.setAccessibilityDelegate(getSheet(), new AnonymousClass1(this));
        return this.container;
    L9:
        r6.addView(r4, r5);
        goto L10
    }

    /* JADX INFO: renamed from: lambda$wrapInSheet$0$com-google-android-material-sidesheet-SheetDialog, reason: not valid java name */
    /* synthetic */ void m266x401f75dd(View r1) {
        if (this.cancelable == true) goto L5;
        return;
    L5:
        if (isShowing() == true) goto L7;
        return;
    L7:
        if (shouldWindowCloseOnTouchOutside() == false) goto L12;
        cancel();
        return;
    }

    private boolean shouldWindowCloseOnTouchOutside() {
        if (this.canceledOnTouchOutsideSet == true) goto L6;
        TypedArray r0 = getContext().obtainStyledAttributes(new int[]{android.R.attr.windowCloseOnTouchOutside});
        this.canceledOnTouchOutside = r0.getBoolean(0, true);
        r0.recycle();
        this.canceledOnTouchOutsideSet = true;
    L6:
        return this.canceledOnTouchOutside;
    }

    private static int getThemeResId(Context r1, int r2, int r3, int r4) {
        if (r2 != 0) goto L8;
        TypedValue r5 = new TypedValue();
        if (r1.getTheme().resolveAttribute(r3, r5, true) == false) goto L7;
        return r5.resourceId;
    L7:
        return r4;
    L8:
        return r2;
    }
}
