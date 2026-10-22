package com.stepos.policy.sdk.util;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.view.A;
import androidx.core.view.N;
import androidx.core.view.Y;
import androidx.core.view.a0;
import androidx.core.view.b0;

/* loaded from: classes.dex */
public class SmartBarPaddingUtil {
    private static int sActionBarHeight = -1;
    private static int sStatusBarHeight = -1;

    public static /* synthetic */ a0 a(int i10, int i11, int i12, int i13, View view, a0 a0Var) {
        view.setPadding(i10, i11, i12, i13 + a0Var.f(a0.o.e()).f41980d);
        return a0Var;
    }

    public static void applyBottomNavigationPadding(View view, final int i10) {
        final int paddingLeft = view.getPaddingLeft();
        final int paddingTop = view.getPaddingTop();
        final int paddingRight = view.getPaddingRight();
        N.u0(view, new A() { // from class: com.stepos.policy.sdk.util.j
            @Override // androidx.core.view.A
            public final a0 a(View view2, a0 a0Var) {
                return SmartBarPaddingUtil.a(paddingLeft, paddingTop, paddingRight, i10, view2, a0Var);
            }
        });
        N.e0(view);
    }

    public static void applyNavigationBarContrast(Activity activity, int i10, boolean z10) {
        Window window;
        if (activity == null || (window = activity.getWindow()) == null) {
            return;
        }
        window.setNavigationBarColor(i10);
        b0 b0VarA = Y.a(window, window.getDecorView());
        if (b0VarA != null) {
            b0VarA.d(z10);
        }
    }

    public static int getActionBarHeight(Context context) {
        if (sActionBarHeight < 0) {
            sActionBarHeight = Hc.f.a(context);
        }
        return sActionBarHeight;
    }

    public static int getActionBarStatusBarHeight(Context context) {
        return getActionBarHeight(context) + getStatusBarHeight(context);
    }

    public static int getStatusBarHeight(Context context) {
        if (sStatusBarHeight < 0) {
            sStatusBarHeight = Hc.f.b(context);
        }
        return sStatusBarHeight;
    }

    public static void setPaddingActionBar(Context context, ViewGroup viewGroup) {
        viewGroup.setClipToPadding(false);
        viewGroup.setPadding(viewGroup.getPaddingLeft(), viewGroup.getPaddingTop() + getActionBarStatusBarHeight(context), viewGroup.getPaddingRight(), viewGroup.getPaddingBottom());
    }
}
