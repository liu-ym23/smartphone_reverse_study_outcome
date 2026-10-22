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
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.e;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.shape.MaterialShapeDrawable;

/* JADX INFO: loaded from: classes3.dex */
public class BottomSheetDialog extends e {
    private BottomSheetBehavior<FrameLayout> behavior;
    private FrameLayout bottomSheet;

    @NonNull
    private BottomSheetBehavior.BottomSheetCallback bottomSheetCallback;
    boolean cancelable;
    private boolean canceledOnTouchOutside;
    private boolean canceledOnTouchOutsideSet;
    private FrameLayout container;
    private CoordinatorLayout coordinator;
    boolean dismissWithAnimation;
    private BottomSheetBehavior.BottomSheetCallback edgeToEdgeCallback;
    private boolean edgeToEdgeEnabled;

    public static class EdgeToEdgeCallback extends BottomSheetBehavior.BottomSheetCallback {
        private final WindowInsetsCompat insetsCompat;
        private final boolean lightBottomSheet;
        private final boolean lightStatusBar;

        public /* synthetic */ EdgeToEdgeCallback(View r10, WindowInsetsCompat r11, AnonymousClass1 r12) {
            this(r10, r11);
        }

        private void setPaddingForPosition(View r10) {
            if (r10.getTop() >= this.insetsCompat.m()) goto L6;
            BottomSheetDialog.setLightStatusBar(r10, this.lightBottomSheet);
            r10.setPadding(r10.getPaddingLeft(), this.insetsCompat.m() - r10.getTop(), r10.getPaddingRight(), r10.getPaddingBottom());
            return;
        L6:
            if (r10.getTop() == 0) goto L10;
            BottomSheetDialog.setLightStatusBar(r10, this.lightStatusBar);
            r10.setPadding(r10.getPaddingLeft(), 0, r10.getPaddingRight(), r10.getPaddingBottom());
            return;
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onSlide(@NonNull View r10, float r11) {
            setPaddingForPosition(r10);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onStateChanged(@NonNull View r10, int r11) {
            setPaddingForPosition(r10);
        }

        private EdgeToEdgeCallback(@NonNull View r10, @NonNull WindowInsetsCompat r11) {
            this.insetsCompat = r11;
            if ((r10.getSystemUiVisibility() & 8192) == 0) goto L5;
            boolean r12 = true;
        L6:
            this.lightStatusBar = r12;
            MaterialShapeDrawable r13 = BottomSheetBehavior.from(r10).getMaterialShapeDrawable();
            if (r13 == null) goto L9;
            ColorStateList r14 = r13.getFillColor();
        L10:
            if (r14 == null) goto L13;
            this.lightBottomSheet = MaterialColors.isColorLight(r14.getDefaultColor());
            return;
        L13:
            if ((r10.getBackground() instanceof ColorDrawable) == false) goto L15;
            this.lightBottomSheet = MaterialColors.isColorLight(((ColorDrawable) r10.getBackground()).getColor());
            return;
        L15:
            this.lightBottomSheet = r12;
            return;
        L9:
            r14 = ViewCompat.r(r10);
            goto L10
        L5:
            r12 = false;
            goto L6
        }
    }

    public BottomSheetDialog(@NonNull Context r10) {
        this(r10, 0);
        this.edgeToEdgeEnabled = getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.enableEdgeToEdge}).getBoolean(0, false);
    }

    public static /* synthetic */ BottomSheetBehavior.BottomSheetCallback access$000(BottomSheetDialog r10) {
        return r10.edgeToEdgeCallback;
    }

    public static /* synthetic */ BottomSheetBehavior.BottomSheetCallback access$002(BottomSheetDialog r10, BottomSheetBehavior.BottomSheetCallback r11) {
        r10.edgeToEdgeCallback = r11;
        return r11;
    }

    public static /* synthetic */ BottomSheetBehavior access$100(BottomSheetDialog r10) {
        return r10.behavior;
    }

    public static /* synthetic */ FrameLayout access$200(BottomSheetDialog r10) {
        return r10.bottomSheet;
    }

    private FrameLayout ensureContainerAndBehavior() {
        if (this.container != null) goto L6;
        FrameLayout r10 = (FrameLayout) View.inflate(getContext(), R.layout.design_bottom_sheet_dialog, null);
        this.container = r10;
        this.coordinator = (CoordinatorLayout) r10.findViewById(R.id.coordinator);
        FrameLayout r11 = (FrameLayout) this.container.findViewById(R.id.design_bottom_sheet);
        this.bottomSheet = r11;
        BottomSheetBehavior<FrameLayout> r12 = BottomSheetBehavior.from(r11);
        this.behavior = r12;
        r12.addBottomSheetCallback(this.bottomSheetCallback);
        this.behavior.setHideable(this.cancelable);
    L6:
        return this.container;
    }

    private static int getThemeResId(@NonNull Context r10, int r11) {
        if (r11 != 0) goto L8;
        TypedValue r12 = new TypedValue();
        if (r10.getTheme().resolveAttribute(R.attr.bottomSheetDialogTheme, r12, true) == false) goto L7;
        return r12.resourceId;
    L7:
        return R.style.Theme_Design_Light_BottomSheetDialog;
    L8:
        return r11;
    }

    public static void setLightStatusBar(@NonNull View r10, boolean r11) {
        int r12 = r10.getSystemUiVisibility();
        if (r11 == false) goto L5;
        int r13 = r12 | 8192;
    L6:
        r10.setSystemUiVisibility(r13);
        return;
    L5:
        r13 = r12 & (-8193);
        goto L6
    }

    private View wrapInBottomSheet(int r10, @Nullable View r11, @Nullable ViewGroup.LayoutParams r12) {
        ensureContainerAndBehavior();
        CoordinatorLayout r13 = (CoordinatorLayout) this.container.findViewById(R.id.coordinator);
        if (r10 == 0) goto L7;
        if (r11 != null) goto L7;
        r11 = getLayoutInflater().inflate(r10, r13, false);
    L7:
        if (this.edgeToEdgeEnabled == false) goto L9;
        ViewCompat.C0(this.bottomSheet, new AnonymousClass1(this));
    L9:
        this.bottomSheet.removeAllViews();
        if (r12 != null) goto L12;
        this.bottomSheet.addView(r11);
    L13:
        r13.findViewById(R.id.touch_outside).setOnClickListener(new AnonymousClass2(this));
        ViewCompat.p0(this.bottomSheet, new AnonymousClass3(this));
        this.bottomSheet.setOnTouchListener(new AnonymousClass4(this));
        return this.container;
    L12:
        this.bottomSheet.addView(r11, r12);
        goto L13
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        BottomSheetBehavior<FrameLayout> r10 = getBehavior();
        if (this.dismissWithAnimation == true) goto L5;
    L8:
        super.cancel();
        return;
    L5:
        if (r10.getState() == 5) goto L8;
        r10.setState(5);
    }

    @NonNull
    public BottomSheetBehavior<FrameLayout> getBehavior() {
        if (this.behavior != null) goto L6;
        ensureContainerAndBehavior();
    L6:
        return this.behavior;
    }

    public boolean getDismissWithAnimation() {
        return this.dismissWithAnimation;
    }

    public boolean getEdgeToEdgeEnabled() {
        return this.edgeToEdgeEnabled;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window r10 = getWindow();
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.edgeToEdgeEnabled == true) goto L7;
    L9:
        boolean r11 = false;
    L10:
        FrameLayout r12 = this.container;
        if (r12 == null) goto L13;
        r12.setFitsSystemWindows(!r11);
    L13:
        CoordinatorLayout r13 = this.coordinator;
        if (r13 == null) goto L16;
        r13.setFitsSystemWindows(!r11);
    L16:
        if (r11 == false) goto L20;
        r10.getDecorView().setSystemUiVisibility(768);
        return;
    L20:
        return;
    L7:
        if (Color.alpha(r10.getNavigationBarColor()) >= 255) goto L9;
        r11 = true;
        goto L10
    }

    @Override // androidx.appcompat.app.e, androidx.activity.ComponentDialog, android.app.Dialog
    public void onCreate(Bundle r10) {
        super.onCreate(r10);
        Window r11 = getWindow();
        if (r11 == null) goto L6;
        r11.setStatusBarColor(0);
        r11.addFlags(Integer.MIN_VALUE);
        r11.setLayout(-1, -1);
        return;
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public void onStart() {
        super.onStart();
        BottomSheetBehavior<FrameLayout> r10 = this.behavior;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.getState() != 5) goto L9;
        this.behavior.setState(4);
        return;
    }

    public void removeDefaultCallback() {
        this.behavior.removeBottomSheetCallback(this.bottomSheetCallback);
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean r10) {
        super.setCancelable(r10);
        if (this.cancelable == r10) goto L8;
        this.cancelable = r10;
        BottomSheetBehavior<FrameLayout> r11 = this.behavior;
        if (r11 == null) goto L9;
        r11.setHideable(r10);
        return;
    L9:
        return;
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean r10) {
        super.setCanceledOnTouchOutside(r10);
        if (r10 == true) goto L5;
    L7:
        this.canceledOnTouchOutside = r10;
        this.canceledOnTouchOutsideSet = true;
        return;
    L5:
        if (this.cancelable == true) goto L7;
        this.cancelable = true;
        goto L7
    }

    @Override // androidx.appcompat.app.e, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(@LayoutRes int r10) {
        super.setContentView(wrapInBottomSheet(r10, null, null));
    }

    public void setDismissWithAnimation(boolean r10) {
        this.dismissWithAnimation = r10;
    }

    public boolean shouldWindowCloseOnTouchOutside() {
        if (this.canceledOnTouchOutsideSet == true) goto L6;
        TypedArray r10 = getContext().obtainStyledAttributes(new int[]{android.R.attr.windowCloseOnTouchOutside});
        this.canceledOnTouchOutside = r10.getBoolean(0, true);
        r10.recycle();
        this.canceledOnTouchOutsideSet = true;
    L6:
        return this.canceledOnTouchOutside;
    }

    @Override // androidx.appcompat.app.e, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(View r10) {
        super.setContentView(wrapInBottomSheet(0, r10, null));
    }

    @Override // androidx.appcompat.app.e, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(View r10, ViewGroup.LayoutParams r11) {
        super.setContentView(wrapInBottomSheet(0, r10, r11));
    }

    public BottomSheetDialog(@NonNull Context r10, @StyleRes int r11) {
        super(r10, getThemeResId(r10, r11));
        this.cancelable = true;
        this.canceledOnTouchOutside = true;
        this.bottomSheetCallback = new AnonymousClass5(this);
        supportRequestWindowFeature(1);
        this.edgeToEdgeEnabled = getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.enableEdgeToEdge}).getBoolean(0, false);
    }

    public BottomSheetDialog(@NonNull Context r10, boolean r11, DialogInterface.OnCancelListener r12) {
        super(r10, r11, r12);
        this.cancelable = true;
        this.canceledOnTouchOutside = true;
        this.bottomSheetCallback = new AnonymousClass5(this);
        supportRequestWindowFeature(1);
        this.cancelable = r11;
        this.edgeToEdgeEnabled = getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.enableEdgeToEdge}).getBoolean(0, false);
    }
}
