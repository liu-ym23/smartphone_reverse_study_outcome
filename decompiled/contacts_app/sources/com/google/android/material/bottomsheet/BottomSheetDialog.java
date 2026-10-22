package com.google.android.material.bottomsheet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.EdgeToEdgeUtils;
import com.google.android.material.shape.MaterialShapeDrawable;

/* JADX INFO: loaded from: classes2.dex */
public class BottomSheetDialog extends AppCompatDialog {
    private BottomSheetBehavior<FrameLayout> behavior;
    private FrameLayout bottomSheet;
    private BottomSheetBehavior.BottomSheetCallback bottomSheetCallback;
    boolean cancelable;
    private boolean canceledOnTouchOutside;
    private boolean canceledOnTouchOutsideSet;
    private FrameLayout container;
    private CoordinatorLayout coordinator;
    boolean dismissWithAnimation;
    private EdgeToEdgeCallback edgeToEdgeCallback;
    private boolean edgeToEdgeEnabled;

    private static class EdgeToEdgeCallback extends BottomSheetBehavior.BottomSheetCallback {
        private final WindowInsetsCompat insetsCompat;
        private final Boolean lightBottomSheet;
        private boolean lightStatusBar;
        private Window window;

        /* synthetic */ EdgeToEdgeCallback(View r1, WindowInsetsCompat r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        private EdgeToEdgeCallback(View r1, WindowInsetsCompat r2) {
            this.insetsCompat = r2;
            MaterialShapeDrawable r3 = BottomSheetBehavior.from(r1).getMaterialShapeDrawable();
            if (r3 == null) goto L5;
            ColorStateList r4 = r3.getFillColor();
        L6:
            if (r4 == null) goto L9;
            this.lightBottomSheet = Boolean.valueOf(MaterialColors.isColorLight(r4.getDefaultColor()));
            return;
        L9:
            if ((r1.getBackground() instanceof ColorDrawable) == false) goto L11;
            this.lightBottomSheet = Boolean.valueOf(MaterialColors.isColorLight(((ColorDrawable) r1.getBackground()).getColor()));
            return;
        L11:
            this.lightBottomSheet = null;
            return;
        L5:
            r4 = ViewCompat.getBackgroundTintList(r1);
            goto L6
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onStateChanged(View r1, int r2) {
            setPaddingForPosition(r1);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onSlide(View r1, float r2) {
            setPaddingForPosition(r1);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        void onLayout(View r1) {
            setPaddingForPosition(r1);
        }

        void setWindow(Window r2) {
            if (this.window != r2) goto L5;
            return;
        L5:
            this.window = r2;
            if (r2 == null) goto L9;
            this.lightStatusBar = WindowCompat.getInsetsController(r2, r2.getDecorView()).isAppearanceLightStatusBars();
            return;
        }

        private void setPaddingForPosition(View r4) {
            if (r4.getTop() >= this.insetsCompat.getSystemWindowInsetTop()) goto L13;
            Window r0 = this.window;
            if (r0 == null) goto L11;
            Boolean r1 = this.lightBottomSheet;
            if (r1 != null) goto L9;
            boolean r2 = this.lightStatusBar;
        L10:
            EdgeToEdgeUtils.setLightStatusBar(r0, r2);
            goto L11
        L9:
            r2 = r1.booleanValue();
        L11:
            r4.setPadding(r4.getPaddingLeft(), this.insetsCompat.getSystemWindowInsetTop() - r4.getTop(), r4.getPaddingRight(), r4.getPaddingBottom());
            return;
        L13:
            if (r4.getTop() == 0) goto L20;
            Window r3 = this.window;
            if (r3 == null) goto L17;
            EdgeToEdgeUtils.setLightStatusBar(r3, this.lightStatusBar);
        L17:
            r4.setPadding(r4.getPaddingLeft(), 0, r4.getPaddingRight(), r4.getPaddingBottom());
            return;
        }
    }

    static /* synthetic */ EdgeToEdgeCallback access$000(BottomSheetDialog r0) {
        return r0.edgeToEdgeCallback;
    }

    static /* synthetic */ EdgeToEdgeCallback access$002(BottomSheetDialog r0, EdgeToEdgeCallback r1) {
        r0.edgeToEdgeCallback = r1;
        return r1;
    }

    static /* synthetic */ BottomSheetBehavior access$100(BottomSheetDialog r0) {
        return r0.behavior;
    }

    static /* synthetic */ FrameLayout access$200(BottomSheetDialog r0) {
        return r0.bottomSheet;
    }

    public BottomSheetDialog(Context r4) {
        this(r4, 0);
        this.edgeToEdgeEnabled = getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.enableEdgeToEdge}).getBoolean(0, false);
    }

    public BottomSheetDialog(Context r3, int r4) {
        super(r3, getThemeResId(r3, r4));
        this.cancelable = true;
        this.canceledOnTouchOutside = true;
        this.bottomSheetCallback = new AnonymousClass5(this);
        supportRequestWindowFeature(1);
        this.edgeToEdgeEnabled = getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.enableEdgeToEdge}).getBoolean(0, false);
    }

    protected BottomSheetDialog(Context r2, boolean r3, DialogInterface.OnCancelListener r4) {
        super(r2, r3, r4);
        this.cancelable = true;
        this.canceledOnTouchOutside = true;
        this.bottomSheetCallback = new AnonymousClass5(this);
        supportRequestWindowFeature(1);
        this.cancelable = r3;
        this.edgeToEdgeEnabled = getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.enableEdgeToEdge}).getBoolean(0, false);
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(int r2) {
        super.setContentView(wrapInBottomSheet(r2, null, null));
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

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(View r3) {
        super.setContentView(wrapInBottomSheet(0, r3, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(View r2, ViewGroup.LayoutParams r3) {
        super.setContentView(wrapInBottomSheet(0, r2, r3));
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean r2) {
        super.setCancelable(r2);
        if (this.cancelable == r2) goto L8;
        this.cancelable = r2;
        BottomSheetBehavior<FrameLayout> r1 = this.behavior;
        if (r1 == null) goto L9;
        r1.setHideable(r2);
        return;
    L9:
        return;
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    protected void onStart() {
        super.onStart();
        BottomSheetBehavior<FrameLayout> r0 = this.behavior;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getState() != 5) goto L9;
        this.behavior.setState(4);
        return;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window r0 = getWindow();
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.edgeToEdgeEnabled == true) goto L7;
    L9:
        boolean r1 = false;
    L10:
        FrameLayout r3 = this.container;
        if (r3 == null) goto L13;
        r3.setFitsSystemWindows(!r1);
    L13:
        CoordinatorLayout r4 = this.coordinator;
        if (r4 == null) goto L16;
        r4.setFitsSystemWindows(!r1);
    L16:
        WindowCompat.setDecorFitsSystemWindows(r0, !r1);
        EdgeToEdgeCallback r5 = this.edgeToEdgeCallback;
        if (r5 == null) goto L21;
        r5.setWindow(r0);
        return;
    L21:
        return;
    L7:
        if (Color.alpha(r0.getNavigationBarColor()) >= 255) goto L9;
        r1 = true;
        goto L10
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        EdgeToEdgeCallback r1 = this.edgeToEdgeCallback;
        if (r1 == null) goto L6;
        r1.setWindow(null);
        return;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        BottomSheetBehavior<FrameLayout> r0 = getBehavior();
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

    public BottomSheetBehavior<FrameLayout> getBehavior() {
        if (this.behavior != null) goto L6;
        ensureContainerAndBehavior();
    L6:
        return this.behavior;
    }

    public void setDismissWithAnimation(boolean r1) {
        this.dismissWithAnimation = r1;
    }

    public boolean getDismissWithAnimation() {
        return this.dismissWithAnimation;
    }

    public boolean getEdgeToEdgeEnabled() {
        return this.edgeToEdgeEnabled;
    }

    private FrameLayout ensureContainerAndBehavior() {
        if (this.container != null) goto L6;
        FrameLayout r0 = (FrameLayout) View.inflate(getContext(), R.layout.design_bottom_sheet_dialog, null);
        this.container = r0;
        this.coordinator = (CoordinatorLayout) r0.findViewById(R.id.coordinator);
        FrameLayout r1 = (FrameLayout) this.container.findViewById(R.id.design_bottom_sheet);
        this.bottomSheet = r1;
        BottomSheetBehavior<FrameLayout> r2 = BottomSheetBehavior.from(r1);
        this.behavior = r2;
        r2.addBottomSheetCallback(this.bottomSheetCallback);
        this.behavior.setHideable(this.cancelable);
    L6:
        return this.container;
    }

    private View wrapInBottomSheet(int r3, View r4, ViewGroup.LayoutParams r5) {
        ensureContainerAndBehavior();
        CoordinatorLayout r0 = (CoordinatorLayout) this.container.findViewById(R.id.coordinator);
        if (r3 == 0) goto L7;
        if (r4 != null) goto L7;
        r4 = getLayoutInflater().inflate(r3, r0, false);
    L7:
        if (this.edgeToEdgeEnabled == false) goto L9;
        ViewCompat.setOnApplyWindowInsetsListener(this.bottomSheet, new AnonymousClass1(this));
    L9:
        this.bottomSheet.removeAllViews();
        if (r5 != null) goto L12;
        this.bottomSheet.addView(r4);
    L13:
        r0.findViewById(R.id.touch_outside).setOnClickListener(new AnonymousClass2(this));
        ViewCompat.setAccessibilityDelegate(this.bottomSheet, new AnonymousClass3(this));
        this.bottomSheet.setOnTouchListener(new AnonymousClass4(this));
        return this.container;
    L12:
        this.bottomSheet.addView(r4, r5);
        goto L13
    }

    boolean shouldWindowCloseOnTouchOutside() {
        if (this.canceledOnTouchOutsideSet == true) goto L6;
        TypedArray r0 = getContext().obtainStyledAttributes(new int[]{android.R.attr.windowCloseOnTouchOutside});
        this.canceledOnTouchOutside = r0.getBoolean(0, true);
        r0.recycle();
        this.canceledOnTouchOutsideSet = true;
    L6:
        return this.canceledOnTouchOutside;
    }

    private static int getThemeResId(Context r2, int r3) {
        if (r3 != 0) goto L8;
        TypedValue r4 = new TypedValue();
        if (r2.getTheme().resolveAttribute(R.attr.bottomSheetDialogTheme, r4, true) == false) goto L7;
        return r4.resourceId;
    L7:
        return R.style.Theme_Design_Light_BottomSheetDialog;
    L8:
        return r3;
    }

    void removeDefaultCallback() {
        this.behavior.removeBottomSheetCallback(this.bottomSheetCallback);
    }

    @Deprecated
    public static void setLightStatusBar(View r1, boolean r2) {
        int r0 = r1.getSystemUiVisibility();
        if (r2 == false) goto L5;
        int r3 = r0 | 8192;
    L6:
        r1.setSystemUiVisibility(r3);
        return;
    L5:
        r3 = r0 & (-8193);
        goto L6
    }
}
