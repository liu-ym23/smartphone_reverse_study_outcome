package com.bytedance.android.shopping.anchorv3.compat;

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
import androidx.fragment.app.FragmentActivity;
import com.bytedance.commerce.uikit.base.ImmersiveAppCompatDialog;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes12.dex */
public class ToggleBottomSheetDialog extends ImmersiveAppCompatDialog {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f164764j = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BottomSheetBehavior<FrameLayout> f164765b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f164766c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f164767d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f164768e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f164769f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function0<Unit> f164770g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final g f164771h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b f164772i;

    public class a extends AccessibilityDelegateCompat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ToggleBottomSheetDialog f164773a;

        public a(ToggleBottomSheetDialog r100) {
            this.f164773a = r100;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityNodeInfo(View r100, AccessibilityNodeInfoCompat r101) {
            super.onInitializeAccessibilityNodeInfo(r100, r101);
            if (this.f164773a.f164766c == false) goto L5;
            r101.addAction(1048576);
            r101.setDismissable(true);
            return;
        L5:
            r101.setDismissable(false);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final boolean performAccessibilityAction(View r100, int r101, Bundle r102) {
            if (r101 != 1048576) goto L9;
            ToggleBottomSheetDialog r103 = this.f164773a;
            if (r103.f164766c == false) goto L9;
            r103.cancel();
            return true;
        L9:
            return super.performAccessibilityAction(r100, r101, r102);
        }
    }

    public class b extends BottomSheetBehavior.BottomSheetCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ToggleBottomSheetDialog f164774a;

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public final void onSlide(View r100, float r101) {
        }

        public b(ToggleBottomSheetDialog r100) {
            this.f164774a = r100;
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public final void onStateChanged(View r100, int r101) {
            if (r101 != 5) goto L6;
            this.f164774a.cancel();
            return;
        }
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        BottomSheetBehavior<FrameLayout> r100 = this.f164765b;
        if (r100 == null) goto L6;
        r100.setState(4);
        return;
    }

    public final void L0(View r100) {
        FrameLayout r101 = (FrameLayout) r100.findViewById(R.id.commerce_design_bottom_sheet);
        r100.findViewById(R.id.touch_outside).setOnClickListener(new e(this));
        ViewCompat.setAccessibilityDelegate(r101, new a(this));
        r101.setOnTouchListener(new f());
        Window r102 = getWindow();
        if (r102 == null) goto L11;
        WindowManager.LayoutParams r103 = r102.getAttributes();
        r103.width = -1;
        r103.height = -1;
        View r104 = r102.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L9;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r105 = ThreadMethodProxy.currentThread();
        if (r105 == com.larus.home.impl.utils.c.f346341a) goto L9;
        com.larus.home.impl.utils.c.a(r105, "getDecorView");
    L9:
        r104.setPadding(0, 0, 0, 0);
        r102.setAttributes(r103);
        return;
    }

    @Override // android.app.Dialog
    public final void setCancelable(boolean r100) {
        super.setCancelable(r100);
        if (this.f164766c == r100) goto L8;
        this.f164766c = r100;
        BottomSheetBehavior<FrameLayout> r101 = this.f164765b;
        if (r101 == null) goto L9;
        r101.setHideable(r100);
        return;
    L9:
        return;
    }

    @Override // android.app.Dialog
    public final void setCanceledOnTouchOutside(boolean r100) {
        super.setCanceledOnTouchOutside(r100);
        if (r100 == true) goto L5;
    L7:
        this.f164767d = r100;
        this.f164768e = true;
        return;
    L5:
        if (this.f164766c == true) goto L7;
        this.f164766c = true;
        goto L7
    }

    @Override // com.bytedance.commerce.uikit.base.ImmersiveAppCompatDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void setContentView(View r100) {
        View r101 = wrapInBottomSheet(0, r100, null);
        super.setContentView(r101);
        g r102 = this.f164771h;
        if (r102 == null) goto L6;
        r102.D30(r101);
        return;
    }

    @Override // com.bytedance.commerce.uikit.base.ImmersiveAppCompatDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void setContentView(int r100) {
        View r101 = wrapInBottomSheet(r100, null, null);
        super.setContentView(r101);
        g r102 = this.f164771h;
        if (r102 == null) goto L6;
        r102.D30(r101);
        return;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void setContentView(View r100, ViewGroup.LayoutParams r101) {
        View r102 = wrapInBottomSheet(0, r100, r101);
        super.setContentView(r102);
        g r103 = this.f164771h;
        if (r103 == null) goto L6;
        r103.D30(r102);
        return;
    }

    public View wrapInBottomSheet(int r100, View r101, ViewGroup.LayoutParams r102) {
        int r103 = this.f164769f;
        if (r103 > 0) goto L5;
        r103 = R.layout.ec_commerce_layout_bottom_sheet_dialog_in_flow;
    L5:
        ViewGroup r104 = (ViewGroup) th.a.c(getContext(), r103, null, false);
        CoordinatorLayout r105 = (CoordinatorLayout) r104.findViewById(R.id.coordinator);
        if (r100 == 0) goto L9;
        if (r101 != null) goto L9;
        r101 = th.a.c(getContext(), r100, r105, false);
    L9:
        FrameLayout r106 = (FrameLayout) r105.findViewById(R.id.commerce_design_bottom_sheet);
        BottomSheetBehavior<FrameLayout> r107 = BottomSheetBehavior.from(r106);
        this.f164765b = r107;
        r107.setBottomSheetCallback(this.f164772i);
        this.f164765b.setHideable(this.f164766c);
        if (r102 != null) goto L12;
        r106.addView(r101);
    L13:
        L0(r105);
        return r104;
    L12:
        r106.addView(r101, r102);
        goto L13
    }

    public ToggleBottomSheetDialog(FragmentActivity r100, int r101, g r102, Function0 r103) {
        super(r100, R.style.Commerce_Dialog_Immersive_BottomSheets);
        this.f164766c = true;
        this.f164767d = true;
        this.f164769f = 0;
        this.f164772i = new b(this);
        this.f164769f = r101;
        this.f164770g = r103;
        this.f164771h = r102;
    }
}
