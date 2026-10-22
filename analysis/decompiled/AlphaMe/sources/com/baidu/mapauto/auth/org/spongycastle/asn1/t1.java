package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.InputStream;

/* loaded from: classes.dex */
public abstract class t1 extends InputStream {

    /* renamed from: a, reason: collision with root package name */
    public final InputStream f7769a;

    /* renamed from: b, reason: collision with root package name */
    public int f7770b;

    public t1(int i4, InputStream inputStream) {
        this.f7769a = inputStream;
        this.f7770b = i4;
    }

    public int a() {
        return this.f7770b;
    }

    public final void b() {
        InputStream inputStream = this.f7769a;
        if (inputStream instanceof q1) {
            q1 q1Var = (q1) inputStream;
            q1Var.f7760f = true;
            q1Var.c();
        }
    }
}
