package com.alipay.sdk.m.n0;

import android.content.Context;
import java.util.zip.Adler32;

/* JADX INFO: loaded from: classes28.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f25623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f25624b = null;

    static {
        f25624b = new Object();
    }

    public static b a(Context r100) {
        if (r100 == null) goto L18;
        Object r101 = f25624b;
        monitor-enter(r101);
        String r102 = d.a(r100).b();     // Catch: Throwable -> L15
        if (com.alipay.sdk.m.l0.f.m8017a(r102) == false) goto L8;
        monitor-exit(r101);     // Catch: Throwable -> L15
        return null;
    L8:
        if (r102.endsWith("\n") == false) goto L10;
        r102 = r102.substring(0, r102.length() - 1);     // Catch: Throwable -> L15
    L10:
        b r103 = new b();     // Catch: Throwable -> L15
        long r104 = System.currentTimeMillis();     // Catch: Throwable -> L15
        String r105 = com.alipay.sdk.m.l0.d.a(r100);     // Catch: Throwable -> L15
        String r106 = com.alipay.sdk.m.l0.d.b(r100);     // Catch: Throwable -> L15
        r103.c(r105);     // Catch: Throwable -> L15
        r103.a(r105);     // Catch: Throwable -> L15
        r103.b(r104);     // Catch: Throwable -> L15
        r103.b(r106);     // Catch: Throwable -> L15
        r103.d(r102);     // Catch: Throwable -> L15
        r103.a(a(r103));     // Catch: Throwable -> L15
        monitor-exit(r101);     // Catch: Throwable -> L15
        return r103;
    L15:
        th = move-exception;
        throw th;
    L18:
        return null;
    }

    public static synchronized b b(Context r100) {
        monitor-enter(c.class);
        b r101 = f25623a;     // Catch: Throwable -> L15
        if (r101 == null) goto L8;
        monitor-exit(c.class);
        return r101;
    L8:
        if (r100 == null) goto L12;
        b r102 = a(r100);     // Catch: Throwable -> L15
        f25623a = r102;     // Catch: Throwable -> L15
        monitor-exit(c.class);
        return r102;
    L12:
        monitor-exit(c.class);
        return null;
    L15:
        th = move-exception;
        throw th;
    }

    public static long a(b r100) {
        if (r100 == null) goto L7;
        String r101 = String.format("%s%s%s%s%s", new Object[]{r100.c(), r100.d(), Long.valueOf(r100.a()), r100.e(), r100.b()});
        if (com.alipay.sdk.m.l0.f.m8017a(r101) == true) goto L9;
        Adler32 r102 = new Adler32();
        r102.reset();
        r102.update(r101.getBytes());
        return r102.getValue();
    L9:
        return 0;
    L7:
        return 0;
    }
}
