package com.stepos.policy.sdk.util;

import android.content.Context;
import android.util.TypedValue;
import android.view.ViewGroup;
import com.stepos.alphame.R;
import m2.o;

/* loaded from: classes.dex */
public class SmartBarPaddingUtil {
    private static int sActionBarHeight = -1;
    private static int sStatusBarHeight = -1;

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
            sStatusBarHeight = o.g(context);
        }
        return sStatusBarHeight;
    }

    public static void setPaddingActionBar(Context context, ViewGroup viewGroup) {
        viewGroup.setClipToPadding(false);
        viewGroup.setPadding(viewGroup.getPaddingLeft(), getActionBarStatusBarHeight(context) + viewGroup.getPaddingTop(), viewGroup.getPaddingRight(), viewGroup.getPaddingBottom());
    }
}
