package com.bytedance.crash.resource.f;

import com.bytedance.crash.o.j;
import com.bytedance.crash.o.r;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: GuardFile.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final String TAG = "GuardFile: ";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final File f7716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f7717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f7718c;

    public a(String r2, String r3, long r4) {
        this.f7716a = new File(r2, r3);
        this.f7717b = r3;
        if (r4 > 0) goto L6;
        r4 = 604800;
    L6:
        this.f7718c = r4;
    }

    public void a() {
        j.a(this.f7716a, String.valueOf(System.currentTimeMillis() / 1000), false);     // Catch: Throwable -> L5
        r.b(TAG, this.f7717b + ": createGuardFile success");     // Catch: Throwable -> L5
        return;
    L5:
        r.b(TAG, this.f7717b + ": createGuardFile fail");
    }

    public boolean b() {
        if (this.f7716a.exists() == true) goto L18;
        return true;
    L18:
        long r3 = System.currentTimeMillis() / 1000;     // Catch: IOException -> L15
        long r5 = Long.parseLong(j.c(this.f7716a.getAbsolutePath()));     // Catch: IOException -> L15
        if (r3 >= r5) goto L8;
        r.b(TAG, this.f7717b + ": time error currentTime is earlier than lastTime");     // Catch: IOException -> L15
        return false;
    L8:
        if ((r3 - r5) >= this.f7718c) goto L11;
        r.b(TAG, this.f7717b + ": CheckTime Less than " + this.f7718c + " seconds, lastTime:" + r5 + " currentTime:" + r3);     // Catch: IOException -> L15
        return false;
    L11:
        j.a(this.f7716a.getAbsolutePath());     // Catch: IOException -> L15
        r.b(TAG, this.f7717b + ": deleteFile guard file");     // Catch: IOException -> L15
        return true;
    L15:
        r.b(TAG, this.f7717b + ": read guard file faild!");
        return false;
    }

    public void c() {
        if (this.f7716a.exists() == true) goto L5;
        return;
    L5:
        if (this.f7716a.delete() == true) goto L7;
        r.b(TAG, "delete guard file faild!");
        return;
    L7:
        r.b(TAG, "delete guard file success");
    }
}
