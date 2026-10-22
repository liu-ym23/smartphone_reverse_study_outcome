package com.stepos.policy.sdk.util;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsetsController;
import com.stepos.aiengine.R;
import java.util.WeakHashMap;
import v0.e0;
import v0.h0;
import v0.m0;
import v0.n0;
import v0.o0;
import v0.r;
import v0.w;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class SmartBarPaddingUtil {
    private static int sActionBarHeight = -1;
    private static int sStatusBarHeight = -1;

    public static void applyBottomNavigationPadding(View view, final int i10) {
        final int paddingLeft = view.getPaddingLeft();
        final int paddingTop = view.getPaddingTop();
        final int paddingRight = view.getPaddingRight();
        r rVar = new r() { // from class: com.stepos.policy.sdk.util.g
            @Override // v0.r
            public final m0 g(View view2, m0 m0Var) {
                return SmartBarPaddingUtil.lambda$applyBottomNavigationPadding$0(paddingLeft, paddingTop, paddingRight, i10, view2, m0Var);
            }
        };
        WeakHashMap<View, h0> weakHashMap = e0.f13274a;
        e0.d.k(view, rVar);
        e0.c.b(view);
    }

    public static void applyNavigationBarContrast(Activity activity, int i10, boolean z) {
        Window window;
        if (activity == null || (window = activity.getWindow()) == null) {
            return;
        }
        window.setNavigationBarColor(i10);
        w wVar = new w(window.getDecorView());
        n0 o0Var = Build.VERSION.SDK_INT >= 35 ? new o0(window, wVar) : new n0(window, wVar);
        WindowInsetsController windowInsetsController = o0Var.f13330a;
        Window window2 = o0Var.f13331b;
        if (z) {
            if (window2 != null) {
                View decorView = window2.getDecorView();
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 16);
            }
            windowInsetsController.setSystemBarsAppearance(16, 16);
            return;
        }
        if (window2 != null) {
            View decorView2 = window2.getDecorView();
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() & (-17));
        }
        windowInsetsController.setSystemBarsAppearance(0, 16);
    }

    public static int getActionBarHeight(Context context) {
        if (sActionBarHeight < 0) {
            TypedValue typedValue = new TypedValue();
            sActionBarHeight = context.getTheme().resolveAttribute(R.attr.steposActionBarSizeFullScreen, typedValue, true) ? TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics()) : context.getResources().getDimensionPixelSize(R.dimen.stepos_action_bar_default_height_appcompat_full_screen);
        }
        return sActionBarHeight;
    }

    public static int getActionBarStatusBarHeight(Context context) {
        return getStatusBarHeight(context) + getActionBarHeight(context);
    }

    public static int getStatusBarHeight(Context context) {
        if (sStatusBarHeight < 0) {
            sStatusBarHeight = l8.f.c(context);
        }
        return sStatusBarHeight;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static m0 lambda$applyBottomNavigationPadding$0(int i10, int i11, int i12, int i13, View view, m0 m0Var) {
        view.setPadding(i10, i11, i12, i13 + m0Var.f13309a.g(2).f10591d);
        return m0Var;
    }

    public static void setPaddingActionBar(Context context, ViewGroup viewGroup) {
        viewGroup.setClipToPadding(false);
        viewGroup.setPadding(viewGroup.getPaddingLeft(), getActionBarStatusBarHeight(context) + viewGroup.getPaddingTop(), viewGroup.getPaddingRight(), viewGroup.getPaddingBottom());
    }
}
