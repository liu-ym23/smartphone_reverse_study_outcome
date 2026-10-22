package com.stepos.policy.sdk.util;

import a5.l;
import android.app.Activity;
import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.ColorInt;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.stepos.ability.R;

/* loaded from: classes3.dex */
public class SmartBarPaddingUtil {
    private static int sActionBarHeight = -1;
    private static int sStatusBarHeight = -1;

    public static void applyBottomNavigationPadding(View view, final int i) {
        final int paddingLeft = view.getPaddingLeft();
        final int paddingTop = view.getPaddingTop();
        final int paddingRight = view.getPaddingRight();
        ViewCompat.setOnApplyWindowInsetsListener(view, new OnApplyWindowInsetsListener() { // from class: com.stepos.policy.sdk.util.h
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
                return SmartBarPaddingUtil.lambda$applyBottomNavigationPadding$0(paddingLeft, paddingTop, paddingRight, i, view2, windowInsetsCompat);
            }
        });
        ViewCompat.requestApplyInsets(view);
    }

    public static void applyNavigationBarContrast(Activity activity, @ColorInt int i, boolean z10) {
        Window window;
        if (activity == null || (window = activity.getWindow()) == null) {
            return;
        }
        window.setNavigationBarColor(i);
        WindowInsetsControllerCompat insetsController = WindowCompat.getInsetsController(window, window.getDecorView());
        if (insetsController != null) {
            insetsController.setAppearanceLightNavigationBars(z10);
        }
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
            sStatusBarHeight = l.f(context);
        }
        return sStatusBarHeight;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ WindowInsetsCompat lambda$applyBottomNavigationPadding$0(int i, int i6, int i10, int i11, View view, WindowInsetsCompat windowInsetsCompat) {
        view.setPadding(i, i6, i10, i11 + windowInsetsCompat.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom);
        return windowInsetsCompat;
    }

    public static void setPaddingActionBar(Context context, ViewGroup viewGroup) {
        viewGroup.setClipToPadding(false);
        viewGroup.setPadding(viewGroup.getPaddingLeft(), getActionBarStatusBarHeight(context) + viewGroup.getPaddingTop(), viewGroup.getPaddingRight(), viewGroup.getPaddingBottom());
    }
}
