package com.bytedance.android.shopping.sku.common.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes13.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f182779a = 0;

    static {
    }

    public static h a(Activity r100) {
        if (r100 != null) goto L4;
        Context r101 = ECAppInfoService.f48114e.getCurrentActivity();
    L4:
        if (r101 != null) goto L7;
        r101 = ECAppInfoService.f48114e.getApplicationContext();
    L7:
        int r102 = 0;
        Object r103 = null;
        if (r101 != null) goto L38;
        Object r104 = null;
    L12:
        if ((r104 instanceof WindowManager) == false) goto L15;
        r103 = r104;
    L15:
        WindowManager r105 = (WindowManager) r103;     // Catch: Exception -> L34
        if (r105 == null) goto L25;
        Display r106 = r105.getDefaultDisplay();     // Catch: Exception -> L34
        Point r107 = new Point();     // Catch: Exception -> L34
        if (r106 == null) goto L20;
        r106.getRealSize(r107);     // Catch: Exception -> L34
    L20:
        int r108 = r107.x;     // Catch: Exception -> L34
        if (r108 <= 0) goto L33;
        int r109 = r107.y;     // Catch: Exception -> L34
        if (r109 <= 0) goto L33;
        r102 = r109;
    L36:
        return new h(r108, r102);
    L33:
        r108 = 0;
        goto L36
    L25:
        if (r101 == null) goto L33;
        Resources r110 = r101.getResources();     // Catch: Exception -> L34
        if (r110 == null) goto L33;
        DisplayMetrics r111 = WindowDisplayMetricsOverride.apply(r110, r110.getDisplayMetrics());     // Catch: Exception -> L34
        if (r111 == null) goto L33;
        int r112 = r111.widthPixels;     // Catch: Exception -> L34
        r102 = r111.heightPixels;     // Catch: Exception -> L37
    L32:
        r108 = r112;
        goto L36
    L38:
        r104 = r101.getSystemService(LiveEndPageData.TAG_WINDOW);     // Catch: Exception -> L34
    L34:
        r112 = 0;
        goto L32
    }
}
