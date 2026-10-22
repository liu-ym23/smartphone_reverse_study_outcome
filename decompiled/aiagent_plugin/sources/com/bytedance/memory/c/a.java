package com.bytedance.memory.c;

import java.io.File;

/* JADX INFO: compiled from: DumpFileController.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f8777a;

    private a() {
    }

    public static a a() {
        if (f8777a != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f8777a != null) goto L9;
        f8777a = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f8777a;
    }

    public void b() {
        com.bytedance.memory.b.b.f8771b.a(new AnonymousClass1(this), "DumpFileController-checkWidgetFolder");
    }

    public void a(File r5) {
        if (r5.isFile() == false) goto L10;
        if (b(r5) == false) goto L7;
    L8:
        r5.delete();
        return;
    L7:
        if (r5.length() == 0) goto L8;
        return;
    L10:
        if (r5.isDirectory() == false) goto L21;
        File[] r6 = r5.listFiles();
        if (r6 != null) goto L14;
        return;
    L14:
        if (r6.length <= 0) goto L23;
        int r0 = r6.length;
        int r1 = 0;
    L16:
        if (r1 >= r0) goto L24;
        a(r6[r1]);
        r1 = r1 + 1;
        goto L16
    L24:
        return;
    L23:
        return;
    }

    private boolean b(File r6) {
        com.bytedance.memory.b.c.a("lastModified %d now %d", new Object[]{Long.valueOf(r6.lastModified()), Long.valueOf(System.currentTimeMillis())});
        if ((System.currentTimeMillis() - r6.lastModified()) > 604800000) goto L5;
        return false;
    L5:
        return true;
    }
}
