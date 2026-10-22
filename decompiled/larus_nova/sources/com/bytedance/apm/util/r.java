package com.bytedance.apm.util;

import android.content.Context;
import java.io.InputStream;
import java.util.Properties;

/* JADX INFO: loaded from: classes3.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Properties f190683a;

    public static String a() {
        Context r100 = com.bytedance.apm.d.getContext();
        Object r101 = null;
        if (f190683a != null) goto L27;
        f190683a = new Properties();
        InputStream r102 = r100.getApplicationContext().getAssets().open("slardar.properties");     // Catch: Throwable -> L8
        f190683a.load(r102);     // Catch: Throwable -> L21
    L10:
        xu3.c.a(r102);
    L29:
        f190683a = null;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        xu3.c.a(r102);
        throw th;
    L8:
        r102 = null;
    L27:
        Properties r103 = f190683a;     // Catch: Exception -> L22
        if (r103 == null) goto L20;
        if (r103.containsKey("release_build") == false) goto L20;
        r101 = f190683a.get("release_build");     // Catch: Exception -> L22
    L20:
        return String.valueOf(r101);
    }
}
