package com.bytedance.android.shopping.store.tabkit.container;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.bytedance.commerce.uikit.base.ImmersiveAppCompatDialog;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes14.dex */
public class TabKitToggleBottomSheetDialog extends ImmersiveAppCompatDialog {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f186713f = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f186714b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f186715c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f186716d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f186717e;

    public class a extends AccessibilityDelegateCompat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TabKitToggleBottomSheetDialog f186718a;

        public a(TabKitToggleBottomSheetDialog r100) {
            this.f186718a = r100;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityNodeInfo(View r100, AccessibilityNodeInfoCompat r101) {
            super.onInitializeAccessibilityNodeInfo(r100, r101);
            if (this.f186718a.f186714b == false) goto L5;
            r101.addAction(1048576);
            r101.setDismissable(true);
            return;
        L5:
            r101.setDismissable(false);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final boolean performAccessibilityAction(View r100, int r101, Bundle r102) {
            if (r101 != 1048576) goto L9;
            TabKitToggleBottomSheetDialog r103 = this.f186718a;
            if (r103.f186714b == false) goto L9;
            r103.cancel();
            return true;
        L9:
            return super.performAccessibilityAction(r100, r101, r102);
        }
    }

    public class b extends BottomSheetBehavior.BottomSheetCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TabKitToggleBottomSheetDialog f186719a;

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public final void onSlide(View r100, float r101) {
        }

        public b(TabKitToggleBottomSheetDialog r100) {
            this.f186719a = r100;
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public final void onStateChanged(View r100, int r101) {
            if (r101 != 5) goto L6;
            this.f186719a.cancel();
            return;
        }
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
    }

    public static View L0(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    @Override // android.app.Dialog
    public final void setCancelable(boolean r100) {
        super.setCancelable(r100);
        if (this.f186714b == r100) goto L6;
        this.f186714b = r100;
        return;
    }

    @Override // android.app.Dialog
    public final void setCanceledOnTouchOutside(boolean r100) {
        super.setCanceledOnTouchOutside(r100);
        if (r100 == true) goto L5;
    L7:
        this.f186715c = r100;
        this.f186716d = true;
        return;
    L5:
        if (this.f186714b == true) goto L7;
        this.f186714b = true;
        goto L7
    }

    @Override // com.bytedance.commerce.uikit.base.ImmersiveAppCompatDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void setContentView(View r100) {
        super.setContentView(wrapInBottomSheet(0, r100, null));
    }

    @Override // com.bytedance.commerce.uikit.base.ImmersiveAppCompatDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void setContentView(int r100) {
        super.setContentView(wrapInBottomSheet(r100, null, null));
    }

    public TabKitToggleBottomSheetDialog(Context r100, int r101) {
        super(r100, R.style.Commerce_Dialog_Immersive_BottomSheets);
        this.f186714b = true;
        this.f186715c = true;
        this.f186717e = 0;
        new b(this);
        this.f186717e = r101;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void setContentView(View r100, ViewGroup.LayoutParams r101) {
        super.setContentView(wrapInBottomSheet(0, r100, r101));
    }

    public final View wrapInBottomSheet(int r100, View r101, ViewGroup.LayoutParams r102) {
        int r103 = this.f186717e;
        ViewGroup r104 = (ViewGroup) th.a.c(getContext(), r103, null, false);
        CoordinatorLayout r105 = (CoordinatorLayout) r104.findViewById(R.id.coordinator);
        FrameLayout r106 = (FrameLayout) r105.findViewById(R.id.ec_tabkit_commerce_design_bottom_sheet);
        if (r102 != null) goto L5;
        r106.addView(r101);
    L6:
        r105.findViewById(R.id.touch_outside).setOnClickListener(new j(this));
        ViewCompat.setAccessibilityDelegate(r106, new a(this));
        r106.setOnTouchListener(new k());
        final Window r107 = getWindow();
        if (r107 == null) goto L13;
        WindowManager.LayoutParams r108 = r107.getAttributes();
        r108.width = -1;
        r108.height = -1;
        L0(r107).setPadding(0, 0, 0, 0);     // Catch: Exception -> L11
    L12:
        r107.setAttributes(r108);
    L11:
        r101.post(new l(r107));
    L13:
        return r104;
    L5:
        r106.addView(r101, r102);
        goto L6
    }
}
