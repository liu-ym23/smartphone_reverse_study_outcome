package com.bytedance.apm6.hub;

import android.app.Application;
import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f190829a;

    public static void a(it3.b r100) {
        du3.a.f470025c = r100;
        Context r101 = r100.getContext();
        if (r101 != null) goto L5;
    L9:
        du3.a.f470034l = System.currentTimeMillis();
        du3.a.f470035m = System.currentTimeMillis();
        if (xu3.a.a() == false) goto L12;
        av3.b.a("APM-Hub", "APM init start in process " + com.bytedance.apm.d.c());
    L12:
        av3.b.f16366a = new eu3.b();
        qu3.c.f534840a.put(uu3.a.class, new cu3.a());
        return;
    L5:
        if ((r101 instanceof Application) == true) goto L8;
        r101 = r101.getApplicationContext();
    L8:
        xu3.a.f565089b = (Application) r101;
        goto L9
    }
}
