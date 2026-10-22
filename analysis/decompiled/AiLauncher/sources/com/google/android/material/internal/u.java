package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import androidx.core.view.A;
import androidx.core.view.N;
import androidx.core.view.a0;
import androidx.core.view.b0;

/* loaded from: classes2.dex */
public class u {

    public class a implements A {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f21152a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f21153b;

        public a(c cVar, d dVar) {
            this.f21152a = cVar;
            this.f21153b = dVar;
        }

        @Override // androidx.core.view.A
        public a0 a(View view, a0 a0Var) {
            return this.f21152a.a(view, a0Var, new d(this.f21153b));
        }
    }

    public class b implements View.OnAttachStateChangeListener {
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            view.removeOnAttachStateChangeListener(this);
            view.requestApplyInsets();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    public interface c {
        a0 a(View view, a0 a0Var, d dVar);
    }

    public static void b(View view, c cVar) {
        N.u0(view, new a(cVar, new d(view.getPaddingStart(), view.getPaddingTop(), view.getPaddingEnd(), view.getPaddingBottom())));
        j(view);
    }

    public static float c(Context context, int i10) {
        return TypedValue.applyDimension(1, i10, context.getResources().getDisplayMetrics());
    }

    public static Integer d(View view) {
        ColorStateList colorStateListF = O2.a.f(view.getBackground());
        if (colorStateListF != null) {
            return Integer.valueOf(colorStateListF.getDefaultColor());
        }
        return null;
    }

    public static InputMethodManager e(View view) {
        return (InputMethodManager) androidx.core.content.a.i(view.getContext(), InputMethodManager.class);
    }

    public static float f(View view) {
        float elevation = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            elevation += ((View) parent).getElevation();
        }
        return elevation;
    }

    public static void g(View view, boolean z10) {
        b0 b0VarG;
        if (z10 && (b0VarG = N.G(view)) != null) {
            b0VarG.a(a0.o.b());
            return;
        }
        InputMethodManager inputMethodManagerE = e(view);
        if (inputMethodManagerE != null) {
            inputMethodManagerE.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static boolean h(View view) {
        return view.getLayoutDirection() == 1;
    }

    public static PorterDuff.Mode i(int i10, PorterDuff.Mode mode) {
        if (i10 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i10 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i10 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i10) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    public static void j(View view) {
        if (view.isAttachedToWindow()) {
            view.requestApplyInsets();
        } else {
            view.addOnAttachStateChangeListener(new b());
        }
    }

    public static void k(final View view, final boolean z10) {
        view.requestFocus();
        view.post(new Runnable() { // from class: com.google.android.material.internal.t
            @Override // java.lang.Runnable
            public final void run() {
                u.l(view, z10);
            }
        });
    }

    public static void l(View view, boolean z10) {
        b0 b0VarG;
        if (!z10 || (b0VarG = N.G(view)) == null) {
            e(view).showSoftInput(view, 1);
        } else {
            b0VarG.g(a0.o.b());
        }
    }

    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public int f21154a;

        /* renamed from: b, reason: collision with root package name */
        public int f21155b;

        /* renamed from: c, reason: collision with root package name */
        public int f21156c;

        /* renamed from: d, reason: collision with root package name */
        public int f21157d;

        public d(int i10, int i11, int i12, int i13) {
            this.f21154a = i10;
            this.f21155b = i11;
            this.f21156c = i12;
            this.f21157d = i13;
        }

        public d(d dVar) {
            this.f21154a = dVar.f21154a;
            this.f21155b = dVar.f21155b;
            this.f21156c = dVar.f21156c;
            this.f21157d = dVar.f21157d;
        }
    }
}
