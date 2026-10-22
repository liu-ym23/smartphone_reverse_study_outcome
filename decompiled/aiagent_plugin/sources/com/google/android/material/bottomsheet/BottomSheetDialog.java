package com.google.android.material.bottomsheet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.al;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.google.android.material.color.b;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class BottomSheetDialog extends AppCompatDialog {
    private BottomSheetBehavior<FrameLayout> behavior;
    private FrameLayout bottomSheet;
    private BottomSheetBehavior.a bottomSheetCallback;
    boolean cancelable;
    private boolean canceledOnTouchOutside;
    private boolean canceledOnTouchOutsideSet;
    private FrameLayout container;
    private CoordinatorLayout coordinator;
    boolean dismissWithAnimation;
    private BottomSheetBehavior.a edgeToEdgeCallback;
    private boolean edgeToEdgeEnabled;

    private static class a extends BottomSheetBehavior.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f13263a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f13264b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final al f13265c;

        /* synthetic */ a(View r1, al r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        private a(View r3, al r4) {
            this.f13265c = r4;
            if (Build.VERSION.SDK_INT >= 23) goto L5;
        L7:
            boolean r5 = false;
        L8:
            this.f13264b = r5;
            MaterialShapeDrawable r0 = BottomSheetBehavior.b(r3).f();
            if (r0 == null) goto L11;
            ColorStateList r1 = r0.getFillColor();
        L12:
            if (r1 == null) goto L15;
            this.f13263a = b.a(r1.getDefaultColor());
            return;
        L15:
            if (ZeusTransformUtils.instanceOf(r3.getBackground(), ColorDrawable.class) == false) goto L17;
            this.f13263a = b.a(((ColorDrawable) ZeusTransformUtils.preCheckCast(r3.getBackground(), ColorDrawable.class, "com.obric.aiagent.plugin")).getColor());
            return;
        L17:
            this.f13263a = r5;
            return;
        L11:
            r1 = ViewCompat.B(r3);
            goto L12
        L5:
            if ((r3.getSystemUiVisibility() & 8192) == 0) goto L7;
            r5 = true;
            goto L8
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.a
        public void a(View r1, int r2) {
            b(r1);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.a
        public void a(View r1, float r2) {
            b(r1);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.a
        void a(View r1) {
            b(r1);
        }

        private void b(View r4) {
            if (r4.getTop() >= this.f13265c.b()) goto L6;
            BottomSheetDialog.setLightStatusBar(r4, this.f13263a);
            r4.setPadding(r4.getPaddingLeft(), this.f13265c.b() - r4.getTop(), r4.getPaddingRight(), r4.getPaddingBottom());
            return;
        L6:
            if (r4.getTop() == 0) goto L10;
            BottomSheetDialog.setLightStatusBar(r4, this.f13264b);
            r4.setPadding(r4.getPaddingLeft(), 0, r4.getPaddingRight(), r4.getPaddingBottom());
            return;
        }
    }

    static /* synthetic */ BottomSheetBehavior.a access$000(BottomSheetDialog r0) {
        return r0.edgeToEdgeCallback;
    }

    static /* synthetic */ BottomSheetBehavior.a access$002(BottomSheetDialog r0, BottomSheetBehavior.a r1) {
        r0.edgeToEdgeCallback = r1;
        return r1;
    }

    static /* synthetic */ BottomSheetBehavior access$100(BottomSheetDialog r0) {
        return r0.behavior;
    }

    static /* synthetic */ FrameLayout access$200(BottomSheetDialog r0) {
        return r0.bottomSheet;
    }

    public BottomSheetDialog(Context r6) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin"), 0);
        this.edgeToEdgeEnabled = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getTheme().obtainStyledAttributes(new int[]{ZeusTransformUtils.mapRes(R.attr.enableEdgeToEdge, "attr", "enableEdgeToEdge")}).getBoolean(0, false);
    }

    public BottomSheetDialog(Context r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        super(r6, getThemeResId(r6, r5));
        this.cancelable = true;
        this.canceledOnTouchOutside = true;
        this.bottomSheetCallback = new AnonymousClass5(this);
        supportRequestWindowFeature(1);
        this.edgeToEdgeEnabled = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getTheme().obtainStyledAttributes(new int[]{ZeusTransformUtils.mapRes(R.attr.enableEdgeToEdge, "attr", "enableEdgeToEdge")}).getBoolean(0, false);
    }

    public BottomSheetDialog(Context r3, boolean r4, DialogInterface.OnCancelListener r5) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4, (DialogInterface.OnCancelListener) ZeusTransformUtils.wrapperContextForParams(r5, DialogInterface.OnCancelListener.class, "com.obric.aiagent.plugin"));
        this.cancelable = true;
        this.canceledOnTouchOutside = true;
        this.bottomSheetCallback = new AnonymousClass5(this);
        supportRequestWindowFeature(1);
        this.cancelable = r4;
        this.edgeToEdgeEnabled = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getTheme().obtainStyledAttributes(new int[]{ZeusTransformUtils.mapRes(R.attr.enableEdgeToEdge, "attr", "enableEdgeToEdge")}).getBoolean(0, false);
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(int r2) {
        super.setContentView(wrapInBottomSheet(r2, null, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void onCreate(Bundle r2) {
        super.onCreate(r2);
        Window r1 = getWindow();
        if (r1 != null) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT < 21) goto L9;
        r1.setStatusBarColor(0);
        r1.addFlags(Integer.MIN_VALUE);
        if (Build.VERSION.SDK_INT >= 23) goto L9;
        r1.addFlags(67108864);
    L9:
        r1.setLayout(-1, -1);
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
        r1.b(r2);
        return;
    L9:
        return;
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public void onStart() {
        super.onStart();
        BottomSheetBehavior<FrameLayout> r0 = this.behavior;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.e() != 5) goto L9;
        this.behavior.f(4);
        return;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window r0 = getWindow();
        if (r0 != null) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT >= 21) goto L7;
        return;
    L7:
        if (this.edgeToEdgeEnabled == true) goto L9;
    L11:
        boolean r1 = false;
    L12:
        FrameLayout r2 = this.container;
        if (r2 == null) goto L15;
        r2.setFitsSystemWindows(!r1);
    L15:
        CoordinatorLayout r4 = this.coordinator;
        if (r4 == null) goto L18;
        r4.setFitsSystemWindows(!r1);
    L18:
        if (r1 == false) goto L23;
        r0.getDecorView().setSystemUiVisibility(768);
        return;
    L23:
        return;
    L9:
        if (Color.alpha(r0.getNavigationBarColor()) >= 255) goto L11;
        r1 = true;
        goto L12
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        BottomSheetBehavior<FrameLayout> r0 = getBehavior();
        if (this.dismissWithAnimation == true) goto L5;
    L8:
        super.cancel();
        return;
    L5:
        if (r0.e() == 5) goto L8;
        r0.f(5);
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
        FrameLayout r0 = (FrameLayout) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.inflate((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.layout.design_bottom_sheet_dialog, "layout", "design_bottom_sheet_dialog"), null, "com.obric.aiagent.plugin"), FrameLayout.class, "com.obric.aiagent.plugin");
        this.container = r0;
        this.coordinator = (CoordinatorLayout) ZeusTransformUtils.preCheckCast(r0.findViewById(ZeusTransformUtils.mapRes(R.id.coordinator, DbHelper.COL_ID, "coordinator")), CoordinatorLayout.class, "com.obric.aiagent.plugin");
        FrameLayout r1 = (FrameLayout) ZeusTransformUtils.preCheckCast(this.container.findViewById(ZeusTransformUtils.mapRes(R.id.design_bottom_sheet, DbHelper.COL_ID, "design_bottom_sheet")), FrameLayout.class, "com.obric.aiagent.plugin");
        this.bottomSheet = r1;
        BottomSheetBehavior<FrameLayout> r2 = BottomSheetBehavior.b(r1);
        this.behavior = r2;
        r2.b(this.bottomSheetCallback);
        this.behavior.b(this.cancelable);
    L6:
        return this.container;
    }

    private View wrapInBottomSheet(int r5, View r6, ViewGroup.LayoutParams r7) {
        ensureContainerAndBehavior();
        CoordinatorLayout r0 = (CoordinatorLayout) ZeusTransformUtils.preCheckCast(this.container.findViewById(ZeusTransformUtils.mapRes(R.id.coordinator, DbHelper.COL_ID, "coordinator")), CoordinatorLayout.class, "com.obric.aiagent.plugin");
        if (r5 == 0) goto L7;
        if (r6 != null) goto L7;
        r6 = ZeusTransformUtils.inflate(getLayoutInflater(), r5, r0, false, "com.obric.aiagent.plugin");
    L7:
        if (this.edgeToEdgeEnabled == false) goto L9;
        ViewCompat.a(this.bottomSheet, new AnonymousClass1(this));
    L9:
        this.bottomSheet.removeAllViews();
        if (r7 != null) goto L12;
        this.bottomSheet.addView(r6);
    L13:
        r0.findViewById(ZeusTransformUtils.mapRes(R.id.touch_outside, DbHelper.COL_ID, "touch_outside")).setOnClickListener(new AnonymousClass2(this));
        ViewCompat.a(this.bottomSheet, new AnonymousClass3(this));
        this.bottomSheet.setOnTouchListener(new AnonymousClass4(this));
        return this.container;
    L12:
        this.bottomSheet.addView(r6, r7);
        goto L13
    }

    boolean shouldWindowCloseOnTouchOutside() {
        if (this.canceledOnTouchOutsideSet == true) goto L6;
        TypedArray r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).obtainStyledAttributes(new int[]{android.R.attr.windowCloseOnTouchOutside});
        this.canceledOnTouchOutside = r0.getBoolean(0, true);
        r0.recycle();
        this.canceledOnTouchOutsideSet = true;
    L6:
        return this.canceledOnTouchOutside;
    }

    private static int getThemeResId(Context r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (r4 != 0) goto L9;
        TypedValue r6 = new TypedValue();
        if (r5.getTheme().resolveAttribute(ZeusTransformUtils.mapRes(R.attr.bottomSheetDialogTheme, "attr", "bottomSheetDialogTheme"), r6, true) == false) goto L8;
        return r6.resourceId;
    L8:
        return ZeusTransformUtils.mapRes(R.style.Theme_Design_Light_BottomSheetDialog, "style", "Theme_Design_Light_BottomSheetDialog");
    L9:
        return r4;
    }

    void removeDefaultCallback() {
        this.behavior.c(this.bottomSheetCallback);
    }

    public static void setLightStatusBar(View r2, boolean r3) {
        if (Build.VERSION.SDK_INT < 23) goto L10;
        int r0 = r2.getSystemUiVisibility();
        if (r3 == false) goto L7;
        int r4 = r0 | 8192;
    L8:
        r2.setSystemUiVisibility(r4);
        return;
    L7:
        r4 = r0 & (-8193);
        goto L8
    }
}
