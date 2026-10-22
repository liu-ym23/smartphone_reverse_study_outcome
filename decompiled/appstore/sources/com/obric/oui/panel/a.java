package com.obric.oui.panel;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.obric.capabilitykit.common.UiType;
import com.obric.common.oui.R$attr;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$style;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a extends androidx.appcompat.app.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BottomSheetBehavior f15806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FrameLayout f15807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CoordinatorLayout f15808c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FrameLayout f15809d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f15810e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f15811f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f15812g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f15813h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f15814i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List f15815j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public BottomSheetBehavior.d f15816k;

    /* JADX INFO: renamed from: com.obric.oui.panel.a$a, reason: collision with other inner class name */
    public class ViewOnClickListenerC0201a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f15817a;

        public ViewOnClickListenerC0201a(a r10) {
            this.f15817a = r10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r10) {
            a r11 = this.f15817a;
            if (r11.f15811f == true) goto L5;
            return;
        L5:
            if (r11.isShowing() == true) goto L7;
            return;
        L7:
            if (this.f15817a.shouldWindowCloseOnTouchOutside() == false) goto L12;
            this.f15817a.cancel();
            return;
        }
    }

    public class b extends View.AccessibilityDelegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f15818a;

        /* JADX INFO: renamed from: com.obric.oui.panel.a$b$a, reason: collision with other inner class name */
        public class C0202a extends androidx.core.view.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f15819a;

            public C0202a(b r10) {
                this.f15819a = r10;
            }

            @Override // androidx.core.view.a
            public void onInitializeAccessibilityNodeInfo(View r10, AccessibilityNodeInfoCompat r11) {
                super.onInitializeAccessibilityNodeInfo(r10, r11);
                r11.b(new AccessibilityNodeInfoCompat.a(16, "关闭面板"));
            }
        }

        public b(a r10) {
            this.f15818a = r10;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View r10, AccessibilityEvent r11) {
            super.onPopulateAccessibilityEvent(r10, r11);
            if (this.f15818a.f15811f == false) goto L5;
            int r12 = 1;
        L6:
            r10.setImportantForAccessibility(r12);
            r10.setScreenReaderFocusable(this.f15818a.f15811f);
            r10.setContentDescription("关闭");
            ViewCompat.p0(r10, new C0202a(this));
            return;
        L5:
            r12 = 2;
            goto L6
        }
    }

    public class c extends androidx.core.view.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f15820a;

        public c(a r10) {
            this.f15820a = r10;
        }

        @Override // androidx.core.view.a
        public void onInitializeAccessibilityNodeInfo(View r10, AccessibilityNodeInfoCompat r11) {
            super.onInitializeAccessibilityNodeInfo(r10, r11);
            if (this.f15820a.f15811f == false) goto L5;
            r11.a(UiType.FLAG_APP_CHOOSER_CARD);
            r11.a0(true);
            return;
        L5:
            r11.a0(false);
        }

        @Override // androidx.core.view.a
        public boolean performAccessibilityAction(View r10, int r11, Bundle r12) {
            if (r11 != 1048576) goto L9;
            a r13 = this.f15820a;
            if (r13.f15811f == false) goto L9;
            r13.cancel();
            return true;
        L9:
            return super.performAccessibilityAction(r10, r11, r12);
        }
    }

    public class d implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f15821a;

        public d(a r10) {
            this.f15821a = r10;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View r10, MotionEvent r11) {
            return true;
        }
    }

    public class e extends BottomSheetBehavior.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f15822a;

        public e(a r10) {
            this.f15822a = r10;
        }

        @Override // com.obric.oui.panel.BottomSheetBehavior.d
        public void c(View r10, float r11) {
            Iterator r12 = a.d(this.f15822a).iterator();
        L4:
            if (r12.hasNext() == false) goto L6;
            ((BottomSheetBehavior.d) r12.next()).c(r10, r11);
            goto L4
        }

        @Override // com.obric.oui.panel.BottomSheetBehavior.d
        public void d(View r10, int r11) {
            Iterator r12 = a.d(this.f15822a).iterator();
        L4:
            if (r12.hasNext() == false) goto L7;
            ((BottomSheetBehavior.d) r12.next()).d(r10, r11);
            goto L4
        L7:
            if (r11 != 5) goto L11;
            this.f15822a.cancel();
            return;
        }
    }

    public a(Context r10, int r11) {
        super(r10, getThemeResId(r10, r11));
        this.f15811f = true;
        this.f15812g = true;
        this.f15814i = false;
        this.f15815j = new ArrayList();
        this.f15816k = new e(this);
        supportRequestWindowFeature(1);
    }

    public static /* synthetic */ List d(a r10) {
        return r10.f15815j;
    }

    public static int getThemeResId(Context r10, int r11) {
        if (r11 != 0) goto L8;
        TypedValue r12 = new TypedValue();
        if (r10.getTheme().resolveAttribute(R$attr.bottomSheetDialogTheme, r12, true) == false) goto L7;
        return r12.resourceId;
    L7:
        return R$style.Theme_Design_Light_BottomSheetDialog;
    L8:
        return r11;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        BottomSheetBehavior r10 = h();
        if (this.f15810e == true) goto L5;
    L8:
        super.cancel();
        return;
    L5:
        if (r10.getState() == 5) goto L8;
        r10.setState(5);
    }

    public void e(boolean r10) {
        h().i(r10);
    }

    public final FrameLayout ensureContainerAndBehavior() {
        if (this.f15807b != null) goto L6;
        FrameLayout r10 = (FrameLayout) View.inflate(getContext(), R$layout.o_bottom_sheet_dialog, null);
        this.f15807b = r10;
        this.f15808c = (CoordinatorLayout) r10.findViewById(R$id.coordinator);
        FrameLayout r11 = (FrameLayout) this.f15807b.findViewById(R$id.design_bottom_sheet);
        this.f15809d = r11;
        r11.setAccessibilityPaneTitle("");
        BottomSheetBehavior r12 = BottomSheetBehavior.f(this.f15809d);
        this.f15806a = r12;
        r12.k(this.f15816k);
        this.f15806a.setHideable(this.f15811f);
    L6:
        return this.f15807b;
    }

    public void f(BottomSheetBehavior.d r10) {
        this.f15815j.add(r10);
    }

    public void g() {
        this.f15815j.clear();
    }

    public boolean getDismissWithAnimation() {
        return this.f15810e;
    }

    public BottomSheetBehavior h() {
        if (this.f15806a != null) goto L6;
        ensureContainerAndBehavior();
    L6:
        return this.f15806a;
    }

    public FrameLayout i() {
        if (this.f15809d != null) goto L6;
        ensureContainerAndBehavior();
    L6:
        return this.f15809d;
    }

    public void j(boolean r10) {
        this.f15814i = r10;
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
        BottomSheetBehavior r10 = this.f15806a;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.getState() == 5) goto L7;
        return;
    L7:
        if (this.f15814i == false) goto L9;
        this.f15806a.setState(4);
        return;
    L9:
        this.f15806a.setState(3);
    }

    public void removeDefaultCallback() {
        this.f15806a.h(this.f15816k);
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean r10) {
        super.setCancelable(r10);
        if (this.f15811f == r10) goto L8;
        this.f15811f = r10;
        BottomSheetBehavior r11 = this.f15806a;
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
        this.f15812g = r10;
        this.f15813h = true;
        return;
    L5:
        if (this.f15811f == true) goto L7;
        this.f15811f = true;
        goto L7
    }

    @Override // androidx.appcompat.app.e, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(View r10) {
        super.setContentView(wrapInBottomSheet(0, r10, null));
    }

    public boolean shouldWindowCloseOnTouchOutside() {
        if (this.f15813h == true) goto L6;
        TypedArray r10 = getContext().obtainStyledAttributes(new int[]{R.attr.windowCloseOnTouchOutside});
        this.f15812g = r10.getBoolean(0, true);
        r10.recycle();
        this.f15813h = true;
    L6:
        return this.f15812g;
    }

    public final View wrapInBottomSheet(int r10, View r11, ViewGroup.LayoutParams r12) {
        ensureContainerAndBehavior();
        CoordinatorLayout r13 = (CoordinatorLayout) this.f15807b.findViewById(R$id.coordinator);
        if (r10 == 0) goto L6;
        if (r11 != null) goto L6;
        r11 = getLayoutInflater().inflate(r10, r13, false);
    L6:
        this.f15809d.removeAllViews();
        if (this.f15814i == false) goto L10;
        if (r12 != null) goto L10;
        r12 = new FrameLayout.LayoutParams(-1, -1);
    L10:
        if (r12 != null) goto L12;
        this.f15809d.addView(r11);
    L13:
        int r14 = R$id.touch_outside;
        r13.findViewById(r14).setOnClickListener(new ViewOnClickListenerC0201a(this));
        r13.findViewById(r14).setAccessibilityDelegate(new b(this));
        ViewCompat.p0(this.f15809d, new c(this));
        this.f15809d.setOnTouchListener(new d(this));
        return this.f15807b;
    L12:
        this.f15809d.addView(r11, r12);
        goto L13
    }
}
