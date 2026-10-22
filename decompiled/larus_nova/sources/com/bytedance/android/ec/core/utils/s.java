package com.bytedance.android.ec.core.utils;

import android.graphics.Color;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f45717a = 0;

    static {
    }

    public static Integer b(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L10:
        if (r101 == false) goto L22;
        return null;
    L22:
    L19:
        e = move-exception;
        ECExceptionMonitor.f(e, "an error occurs when parsing color " + r100);
        return null;
    L14:
        if (StringsKt.startsWith$default(r100, "#", false, 2, null) == true) goto L16;
        String r102 = "#" + r100;     // Catch: Exception -> L19
    L17:
        return Integer.valueOf(Color.parseColor(r102));
    L16:
        r102 = r100;
        goto L17
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r101 = false;
        goto L10
    }

    public static int a(String r100, int r101) {
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L21;
        return r101;
    L21:
    L18:
        e = move-exception;
        ECExceptionMonitor.f(e, "an error occurs when parsing color " + r100);
        return r101;
    L13:
        if (StringsKt.startsWith$default(r100, "#", false, 2, null) == true) goto L15;
        String r103 = "#" + r100;     // Catch: Exception -> L18
    L16:
        return Color.parseColor(r103);
    L15:
        r103 = r100;
        goto L16
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r102 = false;
        goto L9
    }
}
