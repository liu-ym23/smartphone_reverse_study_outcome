package com.bytedanceos.common.toolbox;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f9986a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static re.a.h f9987b;

    public static synchronized re.a.h a() {
        monitor-enter(a.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (f9987b != null) goto L13;
        Context r10 = f9986a;     // Catch: Throwable -> L9
        if (r10 == null) goto L12;
        f9987b = re.a.i("SensitiveContent", r10);     // Catch: Throwable -> L9
        goto L13
    L12:
        throw new IllegalStateException("ALogger is not initialized");     // Catch: Throwable -> L9
    L13:
        re.a.h r11 = f9987b;     // Catch: Throwable -> L9
        monitor-exit(a.class);
        return r11;
    }

    public static synchronized void b(Context r10) {
        monitor-enter(a.class);
        Context r11 = r10.getApplicationContext();     // Catch: Throwable -> L11
        if (r11 == null) goto L8;
        r10 = r11;
    L8:
        f9986a = r10;     // Catch: Throwable -> L11
        a();     // Catch: Throwable -> L11
        monitor-exit(a.class);
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
