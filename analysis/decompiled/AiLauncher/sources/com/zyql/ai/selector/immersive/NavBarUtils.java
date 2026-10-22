package com.zyql.ai.selector.immersive;

import android.app.Activity;
import android.view.Window;

/* loaded from: classes4.dex */
public class NavBarUtils {
    public static void setNavBarColor(Activity activity, int i10) {
        setNavBarColor(activity.getWindow(), i10);
    }

    public static void setNavBarColor(Window window, int i10) {
        window.setNavigationBarColor(i10);
    }
}
