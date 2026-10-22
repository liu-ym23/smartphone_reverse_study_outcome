package com.bytedance.apm.util;

import android.content.Context;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.apm.core.ActivityLifeObserver;

/* JADX INFO: loaded from: classes6.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static float f190669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f190670b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f190671c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f190672d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f190673e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f190674f;

    static {
        Context r100 = com.bytedance.apm.d.getContext();
        ActivityLifeObserver.getInstance().register(new h());
        int r101 = 0;
        boolean r102 = false;
        float r103 = 0.0f;
        if (com.bytedance.apm.d.f190532t == true) goto L5;
    L18:
        f190671c = 60;
        f190670b = 60;
        f190672d = true;
        f190669a = 1000.0f / 60;
        f190674f = 60;
        f190673e = 60;
        if (Build.VERSION.SDK_INT < 23) goto L36;
        if (r100 == null) goto L37;
        Display r104 = ((WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW)).getDefaultDisplay();
        f190673e = a(r104.getRefreshRate());
        Display.Mode[] r105 = r104.getSupportedModes();
        int r106 = r105.length;
    L22:
        if (r101 >= r106) goto L27;
        float r107 = r105[r101].getRefreshRate();
        if (r107 <= r103) goto L26;
        r103 = r107;
    L26:
        r101 = r101 + 1;
        goto L22
    L27:
        f190674f = a(r103);
        return;
    L37:
        return;
    L36:
        return;
    L5:
        if (Build.VERSION.SDK_INT < 23) goto L18;
        if (r100 == null) goto L18;
        Display r108 = ((WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW)).getDefaultDisplay();
        float r109 = r108.getRefreshRate();
        Display.Mode[] r110 = r108.getSupportedModes();
        int r111 = r110.length;
        int r112 = 0;
    L9:
        if (r112 >= r111) goto L14;
        float r113 = r110[r112].getRefreshRate();
        if (r113 <= r103) goto L13;
        r103 = r113;
    L13:
        r112 = r112 + 1;
        goto L9
    L14:
        int r114 = a(r109);
        f190670b = r114;
        f190673e = r114;
        int r115 = a(r103);
        f190671c = r115;
        int r116 = f190670b;
        if (r116 != r115) goto L17;
        r102 = true;
    L17:
        f190672d = r102;
        f190669a = 1000.0f / r116;
    }

    public static int a(float r100) {
        if (Math.abs(r100 - 60.0f) >= 5.1f) goto L7;
        return 60;
    L7:
        if (Math.abs(r100 - 90.0f) >= 5.1f) goto L11;
        return 90;
    L11:
        if (Math.abs(r100 - 120.0f) >= 5.1f) goto L15;
        return 120;
    L15:
        return (int) r100;
    }
}
