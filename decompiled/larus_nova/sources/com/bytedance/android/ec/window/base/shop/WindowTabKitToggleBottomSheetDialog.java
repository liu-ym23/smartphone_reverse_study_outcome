package com.bytedance.android.ec.window.base.shop;

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
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes44.dex */
public class WindowTabKitToggleBottomSheetDialog extends ImmersiveAppCompatDialog {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f49627e = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f49628b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f49629c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f49630d;

    public class a extends AccessibilityDelegateCompat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WindowTabKitToggleBottomSheetDialog f49631a;

        public a(WindowTabKitToggleBottomSheetDialog r100) {
            this.f49631a = r100;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityNodeInfo(View r100, AccessibilityNodeInfoCompat r101) {
            super.onInitializeAccessibilityNodeInfo(r100, r101);
            if (this.f49631a.f49628b == false) goto L5;
            r101.addAction(1048576);
            r101.setDismissable(true);
            return;
        L5:
            r101.setDismissable(false);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final boolean performAccessibilityAction(View r100, int r101, Bundle r102) {
            if (r101 != 1048576) goto L9;
            WindowTabKitToggleBottomSheetDialog r103 = this.f49631a;
            if (r103.f49628b == false) goto L9;
            r103.cancel();
            return true;
        L9:
            return super.performAccessibilityAction(r100, r101, r102);
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
        if (this.f49628b == r100) goto L6;
        this.f49628b = r100;
        return;
    }

    @Override // android.app.Dialog
    public final void setCanceledOnTouchOutside(boolean r100) {
        super.setCanceledOnTouchOutside(r100);
        if (r100 == true) goto L5;
    L7:
        this.f49629c = r100;
        this.f49630d = true;
        return;
    L5:
        if (this.f49628b == true) goto L7;
        this.f49628b = true;
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

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void setContentView(View r100, ViewGroup.LayoutParams r101) {
        super.setContentView(wrapInBottomSheet(0, r100, r101));
    }

    public final View wrapInBottomSheet(int r100, View r101, ViewGroup.LayoutParams r102) {
        ViewGroup r103 = (ViewGroup) th.a.c(getContext(), 0, null, false);
        CoordinatorLayout r104 = (CoordinatorLayout) r103.findViewById(R.id.coordinator);
        FrameLayout r105 = (FrameLayout) r104.findViewById(R.id.ec_tabkit_commerce_design_bottom_sheet);
        if (r102 != null) goto L5;
        r105.addView(r101);
    L6:
        r104.findViewById(R.id.touch_outside).setOnClickListener(new n(this));
        ViewCompat.setAccessibilityDelegate(r105, new a(this));
        r105.setOnTouchListener(new o());
        final Window r106 = getWindow();
        if (r106 == null) goto L13;
        WindowManager.LayoutParams r107 = r106.getAttributes();
        r107.width = -1;
        r107.height = -1;
        L0(r106).setPadding(0, 0, 0, 0);     // Catch: Exception -> L11
    L12:
        r106.setAttributes(r107);
    L11:
        r101.post(new p(r106));
    L13:
        return r103;
    L5:
        r105.addView(r101, r102);
        goto L6
    }
}
