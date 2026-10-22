package com.bytedance.android.anniex.container.util;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f40626a = null;

    static {
        f40626a = new i();
    }

    public i() {
    }

    private final Application getContext() {
        com.bytedance.ies.bullet.core.h r100 = com.bytedance.ies.bullet.core.h.f246501h;
        return com.bytedance.ies.bullet.core.h.f246501h.f246503b;
    }

    public final DisplayMetrics b() {
        Application r100 = getContext();
        if (r100 == null) goto L9;
        Context r101 = r100.getApplicationContext();
        if (r101 == null) goto L9;
        Resources r102 = r101.getResources();
        if (r102 == null) goto L9;
        DisplayMetrics r103 = WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics());
    L10:
        if (r103 != null) goto L13;
        Resources r104 = Resources.getSystem();
        return WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics());
    L13:
        return r103;
    L9:
        r103 = null;
        goto L10
    }

    public final int d() {
        return b().heightPixels;
    }

    public final Resources getResources() {
        Application r100 = getContext();
        if (r100 == null) goto L5;
        Resources r101 = r100.getResources();
    L6:
        if (r101 == null) goto L8;
        return r101;
    L8:
        return Resources.getSystem();
    L5:
        r101 = null;
        goto L6
    }

    public static DisplayMetrics c(Context r100) {
        DisplayMetrics r101 = new DisplayMetrics();
        if (r100 != null) goto L6;
        return r101;
    L6:
        if ((r100 instanceof Activity) == false) goto L8;
        WindowManager r102 = ((Activity) r100).getWindowManager();
    L9:
        if (r102 != null) goto L11;
        return r101;
    L11:
        r102.getDefaultDisplay().getRealMetrics(r101);
        return r101;
    L8:
        Object r103 = r100.getSystemService(LiveEndPageData.TAG_WINDOW);
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.view.WindowManager");
        r102 = (WindowManager) r103;
        goto L9
    }

    public final int a(float r100) {
        return (int) ((r100 * b().density) + 0.5f);
    }

    public final float e(int r100) {
        return r100 / b().density;
    }
}
