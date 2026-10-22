package com.bytedance.android.shopping.buynow.utils;

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
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f171211a = 0;

    static {
    }

    public static f a(Context r100) {
        if (r100 != null) goto L4;
        r100 = ECAppInfoService.f48114e.getCurrentActivity();
    L4:
        if (r100 != null) goto L6;
        r100 = ECAppInfoService.f48114e.getApplicationContext();
    L6:
        int r101 = 0;
        Object r102 = null;
        if (r100 != null) goto L37;
        Object r103 = null;
    L11:
        if ((r103 instanceof WindowManager) == false) goto L14;
        r102 = r103;
    L14:
        WindowManager r104 = (WindowManager) r102;     // Catch: Exception -> L33
        if (r104 == null) goto L24;
        Display r105 = r104.getDefaultDisplay();     // Catch: Exception -> L33
        Point r106 = new Point();     // Catch: Exception -> L33
        if (r105 == null) goto L19;
        r105.getRealSize(r106);     // Catch: Exception -> L33
    L19:
        int r107 = r106.x;     // Catch: Exception -> L33
        if (r107 <= 0) goto L32;
        int r108 = r106.y;     // Catch: Exception -> L33
        if (r108 <= 0) goto L32;
        r101 = r108;
    L35:
        return new f(r107, r101);
    L32:
        r107 = 0;
        goto L35
    L24:
        if (r100 == null) goto L32;
        Resources r109 = r100.getResources();     // Catch: Exception -> L33
        if (r109 == null) goto L32;
        DisplayMetrics r110 = WindowDisplayMetricsOverride.apply(r109, r109.getDisplayMetrics());     // Catch: Exception -> L33
        if (r110 == null) goto L32;
        int r111 = r110.widthPixels;     // Catch: Exception -> L33
        r101 = r110.heightPixels;     // Catch: Exception -> L36
    L31:
        r107 = r111;
        goto L35
    L37:
        r103 = r100.getSystemService(LiveEndPageData.TAG_WINDOW);     // Catch: Exception -> L33
    L33:
        r111 = 0;
        goto L31
    }
}
