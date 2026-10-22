package com.ttnet.org.chromium.net.impl;

import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes4.dex */
public class URLDispatch {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f18757f = "URLDispatch";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f18758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f18759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f18760c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f18761d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public lf.f f18762e;

    static {
    }

    public URLDispatch(String r10) {
        this.f18758a = r10;
        this.f18762e = new lf.f();
    }

    public void a() {
        this.f18762e.c();
    }

    public String b() {
        return this.f18760c;
    }

    public String c() {
        return this.f18761d;
    }

    public String d() {
        return this.f18759b;
    }

    public void e(Runnable r10) {
        this.f18762e.execute(r10);     // Catch: RejectedExecutionException -> L4
        return;
    L4:
        e = move-exception;
        com.ttnet.org.chromium.base.j.a(f18757f, "Exception URLDispatch resume ", new Object[]{e});
    }

    public void f(String r10, String r11, String r12) {
        this.f18759b = r10;
        this.f18761d = r11;
        this.f18760c = r12;
    }

    public void g() {
        this.f18762e.b(300);
    }
}
