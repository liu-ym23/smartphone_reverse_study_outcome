package com.bytedance.bdinstall;

/* JADX INFO: compiled from: Env.java */
/* JADX INFO: loaded from: classes.dex */
public class u extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static u f6446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static u f6447b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final u f6448c = null;

    static {
        f6446a = new u(ap.a("https://log.snssdk.com", true), false, false);
        f6447b = new u(ap.a("https://boe.i.snssdk.com", true), false, true);
        f6448c = f6446a;
    }

    public u(ap r2, boolean r3, boolean r4) {
        this(r2, r3, r4, false);
    }

    public u(ap r1, boolean r2, boolean r3, boolean r4) {
        super(r1, r2, r3, r4);
    }
}
