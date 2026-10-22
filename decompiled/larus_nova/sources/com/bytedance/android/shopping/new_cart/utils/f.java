package com.bytedance.android.shopping.new_cart.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f179365a = 0;

    static {
    }

    public static int a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "tempContext");
        Object r101 = r100.getSystemService(LiveEndPageData.TAG_WINDOW);     // Catch: Exception -> L22
        if ((r101 instanceof WindowManager) == true) goto L6;
        r101 = null;
    L6:
        WindowManager r102 = (WindowManager) r101;     // Catch: Exception -> L22
        if (r102 == null) goto L16;
        Display r103 = r102.getDefaultDisplay();     // Catch: Exception -> L22
        Point r104 = new Point();     // Catch: Exception -> L22
        if (r103 == null) goto L12;
        r103.getRealSize(r104);     // Catch: Exception -> L22
    L12:
        if (r104.x <= 0) goto L24;
        int r105 = r104.y;     // Catch: Exception -> L22
        if (r105 <= 0) goto L24;
        return r105;
    L24:
        return 0;
    L16:
        Resources r106 = r100.getResources();     // Catch: Exception -> L22
        if (r106 == null) goto L24;
        DisplayMetrics r107 = WindowDisplayMetricsOverride.apply(r106, r106.getDisplayMetrics());     // Catch: Exception -> L22
        if (r107 == null) goto L24;
        return r107.heightPixels;
    L22:
        e = move-exception;
        ECExceptionMonitor.d("YATA_CART", e, "getScreenSize crash");
        goto L24
    }
}
