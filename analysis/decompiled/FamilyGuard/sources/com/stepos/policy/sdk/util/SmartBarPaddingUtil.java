package com.stepos.policy.sdk.util;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.view.H;
import androidx.core.view.InterfaceC0479y;
import androidx.core.view.W;
import androidx.core.view.Y;
import androidx.core.view.Z;

/* loaded from: classes.dex */
public class SmartBarPaddingUtil {
    private static int sActionBarHeight = -1;
    private static int sStatusBarHeight = -1;

    public static /* synthetic */ Y a(int i5, int i6, int i7, int i8, View view, Y y5) {
        view.setPadding(i5, i6, i7, i8 + y5.f(Y.l.d()).f9645d);
        return y5;
    }

    public static void applyBottomNavigationPadding(View view, final int i5) {
        final int paddingLeft = view.getPaddingLeft();
        final int paddingTop = view.getPaddingTop();
        final int paddingRight = view.getPaddingRight();
        H.w0(view, new InterfaceC0479y() { // from class: com.stepos.policy.sdk.util.j
            @Override // androidx.core.view.InterfaceC0479y
            public final Y a(View view2, Y y5) {
                return SmartBarPaddingUtil.a(paddingLeft, paddingTop, paddingRight, i5, view2, y5);
            }
        });
        H.g0(view);
    }

    public static void applyNavigationBarContrast(Activity activity, int i5, boolean z5) {
        Window window;
        if (activity == null || (window = activity.getWindow()) == null) {
            return;
        }
        window.setNavigationBarColor(i5);
        Z zA = W.a(window, window.getDecorView());
        if (zA != null) {
            zA.a(z5);
        }
    }

    public static int getActionBarHeight(Context context) {
        if (sActionBarHeight < 0) {
            sActionBarHeight = a5.g.a(context);
        }
        return sActionBarHeight;
    }

    public static int getActionBarStatusBarHeight(Context context) {
        return getActionBarHeight(context) + getStatusBarHeight(context);
    }

    public static int getStatusBarHeight(Context context) {
        if (sStatusBarHeight < 0) {
            sStatusBarHeight = a5.g.b(context);
        }
        return sStatusBarHeight;
    }

    public static void setPaddingActionBar(Context context, ViewGroup viewGroup) {
        viewGroup.setClipToPadding(false);
        viewGroup.setPadding(viewGroup.getPaddingLeft(), viewGroup.getPaddingTop() + getActionBarStatusBarHeight(context), viewGroup.getPaddingRight(), viewGroup.getPaddingBottom());
    }
}
