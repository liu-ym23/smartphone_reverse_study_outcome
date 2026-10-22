package com.bytedance.crash.o;

import com.bytedance.crash.runtime.DefaultWorkThread;
import java.io.File;

/* JADX INFO: compiled from: NpthDiskMonitor.java */
/* JADX INFO: loaded from: classes.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f7673a = "npth_disk_event";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static q f7674b;

    static {
        f7674b = new q();
    }

    private q() {
    }

    public static q a() {
        return f7674b;
    }

    public void a(com.bytedance.crash.d.g r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.a(f7673a) == true) goto L7;
        return;
    L7:
        DefaultWorkThread.post(new AnonymousClass1(this));
    }

    public void b() {
        DefaultWorkThread.post(new AnonymousClass2(this));
    }

    public void c() {
        File r0 = com.bytedance.crash.i.d();     // Catch: Throwable -> L8
        if (new File(r0, "crash.deleted").exists() == false) goto L6;
        return;
    L6:
        j.a(new File(r0, "RuntimeContext"));     // Catch: Throwable -> L8
        j.a(new File(r0, "ProcessTrack"));     // Catch: Throwable -> L8
        j.a(new File(r0, "TrackInfo"));     // Catch: Throwable -> L8
        j.a(new File(r0, "CrashCommonLog"));     // Catch: Throwable -> L8
        j.a(new File(r0, "CrashLogJava"));     // Catch: Throwable -> L8
        j.a(new File(r0, "CrashLogNative"));     // Catch: Throwable -> L8
        j.a(new File(r0, "procanr"));     // Catch: Throwable -> L8
        j.a(new File(r0, "configCrash"));     // Catch: Throwable -> L8
        new File(r0, "crash.deleted").createNewFile();     // Catch: Throwable -> L8
        return;
    }

    public static long a(File r6) {
        long r1 = 0;
        if (r6.exists() == true) goto L5;
        return 0;
    L5:
        if (r6.isDirectory() == false) goto L11;
        File[] r7 = r6.listFiles();
        int r0 = r7.length;
        int r3 = 0;
    L7:
        if (r3 >= r0) goto L9;
        r1 = r1 + a(r7[r3]);
        r3 = r3 + 1;
        goto L7
    L9:
        return r1;
    L11:
        return r6.length() / 1024;
    }
}
