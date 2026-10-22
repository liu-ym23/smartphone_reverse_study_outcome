package com.stepos.policy.sdk.util;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import com.stepos.agentsafetycenter.R;
import java.lang.invoke.VarHandle;
import java.util.WeakHashMap;
import n3.e0;
import n3.k0;
import n3.m1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class SmartBarPaddingUtil {
    private static int sActionBarHeight = -1;
    private static int sStatusBarHeight = -1;

    public static void applyBottomNavigationPadding(View view, int i) {
        int paddingLeft = view.getPaddingLeft();
        int paddingTop = view.getPaddingTop();
        int paddingRight = view.getPaddingRight();
        e eVar = new e();
        eVar.f2803c = paddingLeft;
        eVar.f2804f = paddingTop;
        eVar.f2805g = paddingRight;
        eVar.f2806h = i;
        VarHandle.storeStoreFence();
        WeakHashMap weakHashMap = k0.f8724a;
        e0.b(view, eVar);
        view.requestApplyInsets();
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
            sStatusBarHeight = t1.e.k(context);
        }
        return sStatusBarHeight;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static m1 lambda$applyBottomNavigationPadding$0(int i, int i3, int i10, int i11, View view, m1 m1Var) {
        view.setPadding(i, i3, i10, i11 + m1Var.f8737a.i(2).f3903d);
        return m1Var;
    }

    public static void setPaddingActionBar(Context context, ViewGroup viewGroup) {
        viewGroup.setClipToPadding(false);
        viewGroup.setPadding(viewGroup.getPaddingLeft(), getActionBarStatusBarHeight(context) + viewGroup.getPaddingTop(), viewGroup.getPaddingRight(), viewGroup.getPaddingBottom());
    }
}
