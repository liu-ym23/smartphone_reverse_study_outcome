package com.bytedance.reparo.core.i;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: TimesRecorder.java */
/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f9292b = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private File f9293a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f9294c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f9295d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Runnable f9296e;

    static {
    }

    public static void a(long r2) {
        if (f9292b == true) goto L5;
        return;
    L5:
        if (r2 < 300) goto L9;
        f9292b = false;
        return;
    }

    public k(File r7, String r8, int r9, String r10) {
        this(r7, r8, r9, r10, null);
        this.f9293a = new File(r7, r8 + "@" + r10.hashCode());
        this.f9294c = r9;
    }

    public k(File r3, String r4, int r5, String r6, Runnable r7) {
        Runnable r8 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r7, Runnable.class, "com.obric.aiagent.plugin");
        this.f9295d = -1;
        this.f9296e = null;
        this.f9293a = new File(r3, r4 + "@" + r6.hashCode());
        this.f9294c = r5;
        this.f9296e = r8;
    }

    private int a() {
        int r0 = this.f9295d;
        if (r0 < 0) goto L6;
        return r0;
    L6:
        if (this.f9293a.exists() == true) goto L15;
        return 0;
    L15:
        this.f9295d = Integer.parseInt(com.bytedance.reparo.core.a.b.b.f(this.f9293a));     // Catch: Throwable -> L14
    L10:
        if (this.f9295d >= 0) goto L13;
        this.f9295d = 0;
    L13:
        return this.f9295d;
    }

    private void a(int r3) {
        this.f9295d = r3;
        com.bytedance.reparo.core.a.b.b.a(this.f9293a, String.valueOf(r3), false);     // Catch: IOException -> L10
    L5:
        if (c() == false) goto L13;
        Runnable r2 = this.f9296e;
        if (r2 == null) goto L14;
        r2.run();
        return;
    L14:
        return;
    }

    public boolean c() {
        if (a() < this.f9294c) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean d() {
        if (c() == false) goto L5;
        return true;
    L5:
        a(a() + 1);
        return false;
    }

    public void e() {
        this.f9293a.delete();
    }
}
