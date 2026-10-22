package com.google.android.material.bottomsheet;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsetsController;
import android.widget.FrameLayout;
import androidx.appcompat.app.r;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.stepos.aiengine.R;
import com.stepos.core.ability.speech.PcmDumpBudget;
import java.util.ArrayList;
import java.util.WeakHashMap;
import u4.d;
import v0.e0;
import v0.h0;
import v0.k0;
import v0.m0;
import v0.n0;
import v0.o0;
import v0.w;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class h extends r {
    public BottomSheetBehavior<FrameLayout> h;

    /* renamed from: j, reason: collision with root package name */
    public FrameLayout f4719j;

    /* renamed from: k, reason: collision with root package name */
    public CoordinatorLayout f4720k;

    /* renamed from: l, reason: collision with root package name */
    public FrameLayout f4721l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f4722m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f4723n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f4724o;

    /* renamed from: p, reason: collision with root package name */
    public b f4725p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f4726q;
    public u4.d r;

    /* renamed from: s, reason: collision with root package name */
    public a f4727s;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class b extends BottomSheetBehavior.d {

        /* renamed from: a, reason: collision with root package name */
        public final Boolean f4729a;

        /* renamed from: b, reason: collision with root package name */
        public final m0 f4730b;

        /* renamed from: c, reason: collision with root package name */
        public Window f4731c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f4732d;

        public b(View view, m0 m0Var) {
            this.f4730b = m0Var;
            y4.g gVar = BottomSheetBehavior.l(view).f4688l;
            ColorStateList backgroundTintList = gVar != null ? gVar.f14023b.f14047d : view.getBackgroundTintList();
            if (backgroundTintList != null) {
                this.f4729a = Boolean.valueOf(jd.b.z(backgroundTintList.getDefaultColor()));
                return;
            }
            ColorStateList colorStateListA = r4.a.a(view.getBackground());
            Integer numValueOf = colorStateListA != null ? Integer.valueOf(colorStateListA.getDefaultColor()) : null;
            if (numValueOf != null) {
                this.f4729a = Boolean.valueOf(jd.b.z(numValueOf.intValue()));
            } else {
                this.f4729a = null;
            }
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.d
        public final void a(View view) {
            d(view);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.d
        public final void b(View view) {
            d(view);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.d
        public final void c(int i10, View view) {
            d(view);
        }

        public final void d(View view) {
            int top = view.getTop();
            m0 m0Var = this.f4730b;
            if (top < m0Var.d()) {
                Window window = this.f4731c;
                if (window != null) {
                    Boolean bool = this.f4729a;
                    boolean zBooleanValue = bool == null ? this.f4732d : bool.booleanValue();
                    w wVar = new w(window.getDecorView());
                    n0 o0Var = Build.VERSION.SDK_INT >= 35 ? new o0(window, wVar) : new n0(window, wVar);
                    WindowInsetsController windowInsetsController = o0Var.f13330a;
                    Window window2 = o0Var.f13331b;
                    if (zBooleanValue) {
                        if (window2 != null) {
                            View decorView = window2.getDecorView();
                            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | PcmDumpBudget.HARD_MAX_DIR_MB);
                        }
                        windowInsetsController.setSystemBarsAppearance(8, 8);
                    } else {
                        if (window2 != null) {
                            View decorView2 = window2.getDecorView();
                            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() & (-8193));
                        }
                        windowInsetsController.setSystemBarsAppearance(0, 8);
                    }
                }
                view.setPadding(view.getPaddingLeft(), m0Var.d() - view.getTop(), view.getPaddingRight(), view.getPaddingBottom());
                return;
            }
            if (view.getTop() != 0) {
                Window window3 = this.f4731c;
                if (window3 != null) {
                    boolean z = this.f4732d;
                    w wVar2 = new w(window3.getDecorView());
                    n0 o0Var2 = Build.VERSION.SDK_INT >= 35 ? new o0(window3, wVar2) : new n0(window3, wVar2);
                    WindowInsetsController windowInsetsController2 = o0Var2.f13330a;
                    Window window4 = o0Var2.f13331b;
                    if (z) {
                        if (window4 != null) {
                            View decorView3 = window4.getDecorView();
                            decorView3.setSystemUiVisibility(decorView3.getSystemUiVisibility() | PcmDumpBudget.HARD_MAX_DIR_MB);
                        }
                        windowInsetsController2.setSystemBarsAppearance(8, 8);
                    } else {
                        if (window4 != null) {
                            View decorView4 = window4.getDecorView();
                            decorView4.setSystemUiVisibility(decorView4.getSystemUiVisibility() & (-8193));
                        }
                        windowInsetsController2.setSystemBarsAppearance(0, 8);
                    }
                }
                view.setPadding(view.getPaddingLeft(), 0, view.getPaddingRight(), view.getPaddingBottom());
            }
        }

        public final void e(Window window) {
            if (this.f4731c == window) {
                return;
            }
            this.f4731c = window;
            if (window != null) {
                w wVar = new w(window.getDecorView());
                this.f4732d = (Build.VERSION.SDK_INT >= 35 ? new o0(window, wVar) : new n0(window, wVar)).T();
            }
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void cancel() {
        if (this.h == null) {
            e();
        }
        super.cancel();
    }

    public final void e() throws Resources.NotFoundException {
        if (this.f4719j == null) {
            FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), R.layout.design_bottom_sheet_dialog, null);
            this.f4719j = frameLayout;
            this.f4720k = (CoordinatorLayout) frameLayout.findViewById(R.id.coordinator);
            FrameLayout frameLayout2 = (FrameLayout) this.f4719j.findViewById(R.id.design_bottom_sheet);
            this.f4721l = frameLayout2;
            BottomSheetBehavior<FrameLayout> bottomSheetBehaviorL = BottomSheetBehavior.l(frameLayout2);
            this.h = bottomSheetBehaviorL;
            a aVar = this.f4727s;
            ArrayList<BottomSheetBehavior.d> arrayList = bottomSheetBehaviorL.b0;
            if (!arrayList.contains(aVar)) {
                arrayList.add(aVar);
            }
            this.h.q(this.f4722m);
            this.r = new u4.d(this.h, this.f4721l);
        }
    }

    public final FrameLayout f(View view, int i10, ViewGroup.LayoutParams layoutParams) throws Resources.NotFoundException {
        e();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.f4719j.findViewById(R.id.coordinator);
        if (i10 != 0 && view == null) {
            view = getLayoutInflater().inflate(i10, (ViewGroup) coordinatorLayout, false);
        }
        if (this.f4726q) {
            FrameLayout frameLayout = this.f4719j;
            d dVar = new d(this);
            WeakHashMap<View, h0> weakHashMap = e0.f13274a;
            e0.d.k(frameLayout, dVar);
        }
        this.f4721l.removeAllViews();
        if (layoutParams == null) {
            this.f4721l.addView(view);
        } else {
            this.f4721l.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(R.id.touch_outside).setOnClickListener(new e(this));
        e0.j(this.f4721l, new f(this));
        this.f4721l.setOnTouchListener(new g());
        return this.f4719j;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        if (window != null) {
            boolean z = this.f4726q && Color.alpha(window.getNavigationBarColor()) < 255;
            FrameLayout frameLayout = this.f4719j;
            if (frameLayout != null) {
                frameLayout.setFitsSystemWindows(!z);
            }
            CoordinatorLayout coordinatorLayout = this.f4720k;
            if (coordinatorLayout != null) {
                coordinatorLayout.setFitsSystemWindows(!z);
            }
            k0.a(window, !z);
            b bVar = this.f4725p;
            if (bVar != null) {
                bVar.e(window);
            }
        }
        u4.d dVar = this.r;
        if (dVar == null) {
            return;
        }
        View view = dVar.f13152c;
        d.a aVar = dVar.f13150a;
        if (this.f4722m) {
            if (aVar != null) {
                aVar.b(dVar.f13151b, view, false);
            }
        } else if (aVar != null) {
            aVar.c(view);
        }
    }

    @Override // androidx.appcompat.app.r, b.n, android.app.Dialog
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.setStatusBarColor(0);
            window.addFlags(Integer.MIN_VALUE);
            window.setLayout(-1, -1);
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        d.a aVar;
        b bVar = this.f4725p;
        if (bVar != null) {
            bVar.e(null);
        }
        u4.d dVar = this.r;
        if (dVar == null || (aVar = dVar.f13150a) == null) {
            return;
        }
        aVar.c(dVar.f13152c);
    }

    @Override // b.n, android.app.Dialog
    public final void onStart() throws Resources.NotFoundException {
        super.onStart();
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.h;
        if (bottomSheetBehavior == null || bottomSheetBehavior.Q != 5) {
            return;
        }
        bottomSheetBehavior.s(4);
    }

    @Override // android.app.Dialog
    public final void setCancelable(boolean z) throws Resources.NotFoundException {
        u4.d dVar;
        super.setCancelable(z);
        if (this.f4722m != z) {
            this.f4722m = z;
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.h;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.q(z);
            }
            if (getWindow() == null || (dVar = this.r) == null) {
                return;
            }
            View view = dVar.f13152c;
            d.a aVar = dVar.f13150a;
            if (this.f4722m) {
                if (aVar != null) {
                    aVar.b(dVar.f13151b, view, false);
                }
            } else if (aVar != null) {
                aVar.c(view);
            }
        }
    }

    @Override // android.app.Dialog
    public final void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
        if (z && !this.f4722m) {
            this.f4722m = true;
        }
        this.f4723n = z;
        this.f4724o = true;
    }

    @Override // androidx.appcompat.app.r, b.n, android.app.Dialog
    public final void setContentView(int i10) {
        super.setContentView(f(null, i10, null));
    }

    @Override // androidx.appcompat.app.r, b.n, android.app.Dialog
    public final void setContentView(View view) {
        super.setContentView(f(view, 0, null));
    }

    @Override // androidx.appcompat.app.r, b.n, android.app.Dialog
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(f(view, 0, layoutParams));
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a extends BottomSheetBehavior.d {
        public a() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.d
        public final void c(int i10, View view) {
            if (i10 == 5) {
                h.this.cancel();
            }
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.d
        public final void b(View view) {
        }
    }
}
