package com.c.a.e.b.a;

import android.content.Context;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;

/* JADX INFO: compiled from: DbFileGenerator.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f11930a = "db.zip";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f11931b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f11932c;

    static {
    }

    public static File a(Context r7, String r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(r8) == true) goto L5;
        f11931b = true;
        f11932c = r8;
    L5:
        String r10 = r9.getApplicationInfo().dataDir + File.separator + "databases";
        String r11 = r9.getApplicationInfo().dataDir + File.separator + "dbFiles";
        String r0 = r11 + File.separator + "/tmp";
        File r1 = new File(r10);
        if (r1.exists() == false) goto L32;
        File[] r12 = r1.listFiles();
        int r2 = r12.length;
        int r3 = 0;
    L8:
        if (r3 >= r2) goto L32;
        File r4 = r12[r3];
        String r5 = r4.getName();
        if (r5.endsWith(".db") == false) goto L17;
        if (f11931b == true) goto L17;
        if (com.c.a.i.b.a(r4.getAbsolutePath(), r0, r5) == true) goto L17;
        return null;
    L17:
        if (f11931b == false) goto L25;
        if (TextUtils.isEmpty(f11932c) == true) goto L25;
        if (f11932c.equals(r5) == false) goto L25;
        if (com.c.a.i.b.a(r4.getAbsolutePath(), r0, r5) == true) goto L25;
        return null;
    L25:
        r3 = r3 + 1;
    L32:
        com.c.a.i.b.b(r0, r11 + File.separator + f11930a);     // Catch: Exception -> L29
        com.c.a.i.b.a(r0);
        return new File(r11 + File.separator + f11930a);
    L29:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static void a(Context r2) {
        com.c.a.i.b.a(((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).getApplicationInfo().dataDir + File.separator + "dbFiles");
    }
}
