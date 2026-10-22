package com.bytedance.retrofit2;

import java.net.URL;

/* JADX INFO: compiled from: HttpException.java */
/* JADX INFO: loaded from: classes.dex */
public class o extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f9572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9573b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final transient ak<?> f9574c;

    private static String a(ak<?> r3) {
        an.a(r3, "response == null");
        if (r3.a() != null) goto L5;
    L7:
        String r0 = "";
    L9:
        if ("".equals(r0) == false) goto L17;
        if (r3.b() == null) goto L17;
        r0 = new URL(r3.b().a()).getPath();     // Catch: Exception -> L14
    L14:
        e = move-exception;
        e.printStackTrace();
    L17:
        return "Path is " + r0 + " HTTP " + r3.c() + " " + r3.h();
    L5:
        if (r3.a().f9432b == null) goto L7;
        r0 = r3.a().f9432b.getPath();
        goto L9
    }

    public o(ak<?> r2) {
        super(a(r2));
        this.f9572a = r2.c();
        this.f9573b = r2.h();
        this.f9574c = r2;
    }

    public int a() {
        return this.f9572a;
    }

    public ak<?> b() {
        return this.f9574c;
    }
}
