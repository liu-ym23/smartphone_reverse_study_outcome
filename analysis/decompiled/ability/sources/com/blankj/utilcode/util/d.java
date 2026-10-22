package com.blankj.utilcode.util;

import android.app.NotificationChannel;

/* loaded from: classes2.dex */
public final class d {
    public static final d b;

    /* renamed from: a, reason: collision with root package name */
    public NotificationChannel f2204a;

    static {
        String packageName = S0.b.X0().getPackageName();
        String packageName2 = S0.b.X0().getPackageName();
        d dVar = new d();
        dVar.f2204a = new NotificationChannel(packageName, packageName2, 3);
        b = dVar;
    }
}
