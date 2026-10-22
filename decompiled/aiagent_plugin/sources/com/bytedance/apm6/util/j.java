package com.bytedance.apm6.util;

import android.os.Build;
import android.os.Trace;

/* JADX INFO: compiled from: TraceUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class j {
    public static void a(String r2) {
        if (a.v() == true) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT < 18) goto L9;
        Trace.beginSection(r2);
        return;
    }

    public static void a() {
        if (a.v() == true) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT < 18) goto L9;
        Trace.endSection();
        return;
    }
}
