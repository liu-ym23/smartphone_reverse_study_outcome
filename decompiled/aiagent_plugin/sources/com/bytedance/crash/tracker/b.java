package com.bytedance.crash.tracker;

import android.text.TextUtils;
import com.bytedance.crash.i;
import com.bytedance.crash.o.d;
import com.bytedance.crash.o.j;
import java.io.File;
import java.util.Date;

/* JADX INFO: compiled from: ProcessTracker.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f7775a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static File f7776b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static File f7777c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static File f7778d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static File f7779e;
    private static b g;
    private boolean f;

    static {
        g = new b();
    }

    private b() {
    }

    public static b a() {
        return g;
    }

    private void d() {
        if (f7775a == false) goto L5;
        return;
    L5:
        File r5 = new File(i.d(), "processTrack");
        f7776b = r5;
        com.bytedance.crash.o.i.b(r5);
        File r6 = new File(f7776b, String.valueOf(i.f() / 86400000));
        f7777c = r6;
        com.bytedance.crash.o.i.b(r6);
        File r7 = new File(f7777c, com.bytedance.crash.o.b.a());
        f7778d = r7;
        com.bytedance.crash.o.i.b(r7);
        f7775a = true;
    }

    public void a(boolean r1) {
        if (r1 == true) goto L4;
        return;
    L4:
        this.f = true;
    }

    public boolean b() {
        return this.f;
    }

    public void a(String r2, String r3, long r4) {
        File r1 = c();     // Catch: Throwable -> L6
        if (r1 == null) goto L9;
        j.a(r1, r2 + ' ' + r3 + ' ' + d.c().format(new Date(r4)) + '\n', true);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    public File c() {
        File r0 = f7779e;
        if (r0 == null) goto L5;
        return r0;
    L5:
        d();
        if (f7778d == null) goto L10;
        File r3 = new File(f7778d, String.valueOf(i.f()));
        f7779e = r3;
        return r3;
    L10:
        return f7779e;
    }

    public File a(String r4, long r5) {
        if (TextUtils.isEmpty(r4) == false) goto L7;
        return null;
    L7:
        return new File(i.d(), "processTrack" + File.separator + String.valueOf(r5 / 86400000) + File.separator + r4 + File.separator + String.valueOf(r5));
    }
}
