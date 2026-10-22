package com.bytedance.android.ec.common.impl.sku.utils;

import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes43.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f43360a = 0;

    static {
    }

    public static int a(FragmentActivity r100) {
        if (r100 != null) goto L18;
        return 0;
    L18:
        Object r101 = r100.getSystemService(LiveEndPageData.TAG_WINDOW);     // Catch: Exception -> L17
        DisplayMetrics r102 = null;
        if ((r101 instanceof WindowManager) == true) goto L8;
        r101 = null;
    L8:
        WindowManager r103 = (WindowManager) r101;     // Catch: Exception -> L17
        if (r103 == null) goto L11;
        Display r104 = r103.getDefaultDisplay();     // Catch: Exception -> L17
        Point r105 = new Point();     // Catch: Exception -> L17
        r104.getRealSize(r105);     // Catch: Exception -> L17
        return r105.y;
    L11:
        Resources r106 = r100.getResources();     // Catch: Exception -> L17
        if (r106 == null) goto L14;
        r102 = WindowDisplayMetricsOverride.apply(r106, r106.getDisplayMetrics());     // Catch: Exception -> L17
    L14:
        if (r102 != null) goto L16;
        return 0;
    L16:
        return r102.heightPixels;
    L21:
        return 0;
    }
}
