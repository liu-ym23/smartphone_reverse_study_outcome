package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import androidx.core.view.H;
import androidx.core.view.InterfaceC0479y;
import androidx.core.view.Y;
import androidx.core.view.Z;
import com.stepos.policy.sdk.bean.PolicyBasicListVO;

/* loaded from: classes.dex */
public class r {

    class a implements InterfaceC0479y {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f13045a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f13046b;

        a(c cVar, d dVar) {
            this.f13045a = cVar;
            this.f13046b = dVar;
        }

        @Override // androidx.core.view.InterfaceC0479y
        public Y a(View view, Y y5) {
            return this.f13045a.a(view, y5, new d(this.f13046b));
        }
    }

    class b implements View.OnAttachStateChangeListener {
        b() {
        }

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
        Y a(View view, Y y5, d dVar);
    }

    public static void b(View view, c cVar) {
        H.w0(view, new a(cVar, new d(view.getPaddingStart(), view.getPaddingTop(), view.getPaddingEnd(), view.getPaddingBottom())));
        i(view);
    }

    public static float c(Context context, int i5) {
        return TypedValue.applyDimension(1, i5, context.getResources().getDisplayMetrics());
    }

    public static Integer d(View view) {
        ColorStateList colorStateListF = com.google.android.material.drawable.a.f(view.getBackground());
        if (colorStateListF != null) {
            return Integer.valueOf(colorStateListF.getDefaultColor());
        }
        return null;
    }

    private static InputMethodManager e(View view) {
        return (InputMethodManager) androidx.core.content.a.h(view.getContext(), InputMethodManager.class);
    }

    public static float f(View view) {
        float elevation = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            elevation += ((View) parent).getElevation();
        }
        return elevation;
    }

    public static boolean g(View view) {
        return view.getLayoutDirection() == 1;
    }

    public static PorterDuff.Mode h(int i5, PorterDuff.Mode mode) {
        if (i5 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i5 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i5 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i5) {
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER_WITH_ARROW /* 14 */:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    public static void i(View view) {
        if (view.isAttachedToWindow()) {
            view.requestApplyInsets();
        } else {
            view.addOnAttachStateChangeListener(new b());
        }
    }

    public static void j(final View view, final boolean z5) {
        view.requestFocus();
        view.post(new Runnable() { // from class: com.google.android.material.internal.q
            @Override // java.lang.Runnable
            public final void run() {
                r.k(view, z5);
            }
        });
    }

    public static void k(View view, boolean z5) {
        Z zJ;
        if (!z5 || (zJ = H.J(view)) == null) {
            e(view).showSoftInput(view, 1);
        } else {
            zJ.c(Y.l.a());
        }
    }

    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public int f13047a;

        /* renamed from: b, reason: collision with root package name */
        public int f13048b;

        /* renamed from: c, reason: collision with root package name */
        public int f13049c;

        /* renamed from: d, reason: collision with root package name */
        public int f13050d;

        public d(int i5, int i6, int i7, int i8) {
            this.f13047a = i5;
            this.f13048b = i6;
            this.f13049c = i7;
            this.f13050d = i8;
        }

        public d(d dVar) {
            this.f13047a = dVar.f13047a;
            this.f13048b = dVar.f13048b;
            this.f13049c = dVar.f13049c;
            this.f13050d = dVar.f13050d;
        }
    }
}
