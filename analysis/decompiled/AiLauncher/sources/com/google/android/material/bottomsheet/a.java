package com.google.android.material.bottomsheet;

import Z2.h;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.k;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.A;
import androidx.core.view.C1313a;
import androidx.core.view.N;
import androidx.core.view.Y;
import androidx.core.view.a0;
import com.google.android.material.R$attr;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$style;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.internal.u;

/* loaded from: classes2.dex */
public class a extends k {
    private T2.c backOrchestrator;
    private BottomSheetBehavior<FrameLayout> behavior;
    private FrameLayout bottomSheet;
    private BottomSheetBehavior.g bottomSheetCallback;
    boolean cancelable;
    private boolean canceledOnTouchOutside;
    private boolean canceledOnTouchOutsideSet;
    private FrameLayout container;
    private CoordinatorLayout coordinator;
    boolean dismissWithAnimation;
    private f edgeToEdgeCallback;
    private boolean edgeToEdgeEnabled;

    /* renamed from: com.google.android.material.bottomsheet.a$a, reason: collision with other inner class name */
    public class C0229a implements A {
        public C0229a() {
        }

        @Override // androidx.core.view.A
        public a0 a(View view, a0 a0Var) {
            if (a.this.edgeToEdgeCallback != null) {
                a.this.behavior.e0(a.this.edgeToEdgeCallback);
            }
            if (a0Var != null) {
                a aVar = a.this;
                aVar.edgeToEdgeCallback = new f(aVar.bottomSheet, a0Var, null);
                a.this.edgeToEdgeCallback.e(a.this.getWindow());
                a.this.behavior.A(a.this.edgeToEdgeCallback);
            }
            return a0Var;
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar = a.this;
            if (aVar.cancelable && aVar.isShowing() && a.this.r()) {
                a.this.cancel();
            }
        }
    }

    public class c extends C1313a {
        public c() {
        }

        @Override // androidx.core.view.C1313a
        public void onInitializeAccessibilityNodeInfo(View view, C0.c cVar) {
            super.onInitializeAccessibilityNodeInfo(view, cVar);
            if (!a.this.cancelable) {
                cVar.s0(false);
            } else {
                cVar.a(1048576);
                cVar.s0(true);
            }
        }

        @Override // androidx.core.view.C1313a
        public boolean performAccessibilityAction(View view, int i10, Bundle bundle) {
            if (i10 == 1048576) {
                a aVar = a.this;
                if (aVar.cancelable) {
                    aVar.cancel();
                    return true;
                }
            }
            return super.performAccessibilityAction(view, i10, bundle);
        }
    }

    public class d implements View.OnTouchListener {
        public d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    public class e extends BottomSheetBehavior.g {
        public e() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void b(View view, float f10) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void c(View view, int i10) {
            if (i10 == 5) {
                a.this.cancel();
            }
        }
    }

    public static class f extends BottomSheetBehavior.g {

        /* renamed from: a, reason: collision with root package name */
        public final Boolean f20443a;

        /* renamed from: b, reason: collision with root package name */
        public final a0 f20444b;

        /* renamed from: c, reason: collision with root package name */
        public Window f20445c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f20446d;

        public /* synthetic */ f(View view, a0 a0Var, C0229a c0229a) {
            this(view, a0Var);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void a(View view) {
            d(view);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void b(View view, float f10) {
            d(view);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void c(View view, int i10) {
            d(view);
        }

        public final void d(View view) {
            if (view.getTop() < this.f20444b.m()) {
                Window window = this.f20445c;
                if (window != null) {
                    Boolean bool = this.f20443a;
                    com.google.android.material.internal.d.f(window, bool == null ? this.f20446d : bool.booleanValue());
                }
                view.setPadding(view.getPaddingLeft(), this.f20444b.m() - view.getTop(), view.getPaddingRight(), view.getPaddingBottom());
                return;
            }
            if (view.getTop() != 0) {
                Window window2 = this.f20445c;
                if (window2 != null) {
                    com.google.android.material.internal.d.f(window2, this.f20446d);
                }
                view.setPadding(view.getPaddingLeft(), 0, view.getPaddingRight(), view.getPaddingBottom());
            }
        }

        public void e(Window window) {
            if (this.f20445c == window) {
                return;
            }
            this.f20445c = window;
            if (window != null) {
                this.f20446d = Y.a(window, window.getDecorView()).c();
            }
        }

        public f(View view, a0 a0Var) {
            this.f20444b = a0Var;
            h hVarR = BottomSheetBehavior.O(view).R();
            ColorStateList colorStateListB = hVarR != null ? hVarR.B() : view.getBackgroundTintList();
            if (colorStateListB != null) {
                this.f20443a = Boolean.valueOf(M2.a.h(colorStateListB.getDefaultColor()));
                return;
            }
            Integer numD = u.d(view);
            if (numD != null) {
                this.f20443a = Boolean.valueOf(M2.a.h(numD.intValue()));
            } else {
                this.f20443a = null;
            }
        }
    }

    public a(Context context) {
        this(context, 0);
        p();
    }

    public static int f(Context context, int i10) {
        if (i10 != 0) {
            return i10;
        }
        TypedValue typedValue = new TypedValue();
        return context.getTheme().resolveAttribute(R$attr.bottomSheetDialogTheme, typedValue, true) ? typedValue.resourceId : R$style.Theme_Design_Light_BottomSheetDialog;
    }

    private void p() {
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(new int[]{R$attr.enableEdgeToEdge});
        this.edgeToEdgeEnabled = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        BottomSheetBehavior<FrameLayout> bottomSheetBehaviorN = n();
        if (!this.dismissWithAnimation || bottomSheetBehaviorN.S() == 5) {
            super.cancel();
        } else {
            bottomSheetBehaviorN.x0(5);
        }
    }

    public final FrameLayout m() {
        if (this.container == null) {
            FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), R$layout.design_bottom_sheet_dialog, null);
            this.container = frameLayout;
            this.coordinator = (CoordinatorLayout) frameLayout.findViewById(R$id.coordinator);
            FrameLayout frameLayout2 = (FrameLayout) this.container.findViewById(R$id.design_bottom_sheet);
            this.bottomSheet = frameLayout2;
            BottomSheetBehavior<FrameLayout> bottomSheetBehaviorO = BottomSheetBehavior.O(frameLayout2);
            this.behavior = bottomSheetBehaviorO;
            bottomSheetBehaviorO.A(this.bottomSheetCallback);
            this.behavior.p0(this.cancelable);
            this.backOrchestrator = new T2.c(this.behavior, this.bottomSheet);
        }
        return this.container;
    }

    public BottomSheetBehavior<FrameLayout> n() {
        if (this.behavior == null) {
            m();
        }
        return this.behavior;
    }

    public boolean o() {
        return this.dismissWithAnimation;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        if (window != null) {
            boolean z10 = this.edgeToEdgeEnabled && Color.alpha(window.getNavigationBarColor()) < 255;
            FrameLayout frameLayout = this.container;
            if (frameLayout != null) {
                frameLayout.setFitsSystemWindows(!z10);
            }
            CoordinatorLayout coordinatorLayout = this.coordinator;
            if (coordinatorLayout != null) {
                coordinatorLayout.setFitsSystemWindows(!z10);
            }
            Y.b(window, !z10);
            f fVar = this.edgeToEdgeCallback;
            if (fVar != null) {
                fVar.e(window);
            }
        }
        s();
    }

    @Override // androidx.appcompat.app.k, b.v, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.setStatusBarColor(0);
            window.addFlags(Integer.MIN_VALUE);
            window.setLayout(-1, -1);
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        f fVar = this.edgeToEdgeCallback;
        if (fVar != null) {
            fVar.e(null);
        }
        T2.c cVar = this.backOrchestrator;
        if (cVar != null) {
            cVar.f();
        }
    }

    @Override // b.v, android.app.Dialog
    public void onStart() {
        super.onStart();
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.behavior;
        if (bottomSheetBehavior == null || bottomSheetBehavior.S() != 5) {
            return;
        }
        this.behavior.x0(4);
    }

    public void q() {
        this.behavior.e0(this.bottomSheetCallback);
    }

    public boolean r() {
        if (!this.canceledOnTouchOutsideSet) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{R.attr.windowCloseOnTouchOutside});
            this.canceledOnTouchOutside = typedArrayObtainStyledAttributes.getBoolean(0, true);
            typedArrayObtainStyledAttributes.recycle();
            this.canceledOnTouchOutsideSet = true;
        }
        return this.canceledOnTouchOutside;
    }

    public final void s() {
        T2.c cVar = this.backOrchestrator;
        if (cVar == null) {
            return;
        }
        if (this.cancelable) {
            cVar.c();
        } else {
            cVar.f();
        }
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean z10) {
        super.setCancelable(z10);
        if (this.cancelable != z10) {
            this.cancelable = z10;
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.behavior;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.p0(z10);
            }
            if (getWindow() != null) {
                s();
            }
        }
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean z10) {
        super.setCanceledOnTouchOutside(z10);
        if (z10 && !this.cancelable) {
            this.cancelable = true;
        }
        this.canceledOnTouchOutside = z10;
        this.canceledOnTouchOutsideSet = true;
    }

    @Override // androidx.appcompat.app.k, b.v, android.app.Dialog
    public void setContentView(int i10) {
        super.setContentView(t(i10, null, null));
    }

    public final View t(int i10, View view, ViewGroup.LayoutParams layoutParams) {
        m();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.container.findViewById(R$id.coordinator);
        if (i10 != 0 && view == null) {
            view = getLayoutInflater().inflate(i10, (ViewGroup) coordinatorLayout, false);
        }
        if (this.edgeToEdgeEnabled) {
            N.u0(this.container, new C0229a());
        }
        this.bottomSheet.removeAllViews();
        if (layoutParams == null) {
            this.bottomSheet.addView(view);
        } else {
            this.bottomSheet.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(R$id.touch_outside).setOnClickListener(new b());
        N.i0(this.bottomSheet, new c());
        this.bottomSheet.setOnTouchListener(new d());
        return this.container;
    }

    @Override // androidx.appcompat.app.k, b.v, android.app.Dialog
    public void setContentView(View view) {
        super.setContentView(t(0, view, null));
    }

    public a(Context context, int i10) {
        super(context, f(context, i10));
        this.cancelable = true;
        this.canceledOnTouchOutside = true;
        this.bottomSheetCallback = new e();
        h(1);
        p();
    }

    @Override // androidx.appcompat.app.k, b.v, android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(t(0, view, layoutParams));
    }
}
