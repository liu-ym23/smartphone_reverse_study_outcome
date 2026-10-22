package com.bytedance.android.anniex.container.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes43.dex */
public final class h {
    static {
    }

    @JvmStatic
    public static final boolean a(Context r100) {
        if ((r100 instanceof Activity) == false) goto L12;
        Activity r101 = (Activity) r100;
        WindowManager r102 = r101.getWindowManager();
        if (r102 == null) goto L7;
        Display r103 = r102.getDefaultDisplay();
    L8:
        if (r103 == null) goto L12;
        Display r104 = r101.getWindowManager().getDefaultDisplay();
        if (r104.getWidth() >= r104.getHeight()) goto L20;
    L21:
        return false;
    L20:
        return true;
    L7:
        r103 = null;
    L12:
        if (r100 == null) goto L17;
        Resources r105 = r100.getResources();
        if (r105 == null) goto L17;
        DisplayMetrics r106 = WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics());
        if (r106 == null) goto L17;
    L19:
        if (r106.widthPixels < r106.heightPixels) goto L21;
    L17:
        Resources r107 = Resources.getSystem();
        r106 = WindowDisplayMetricsOverride.apply(r107, r107.getDisplayMetrics());
        goto L19
    }
}
