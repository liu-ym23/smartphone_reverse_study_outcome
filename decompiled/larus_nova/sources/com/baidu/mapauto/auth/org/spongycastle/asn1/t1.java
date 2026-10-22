package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.InputStream;

/* JADX INFO: loaded from: classes39.dex */
public abstract class t1 extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputStream f31889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f31890b;

    public t1(int r100, InputStream r101) {
        this.f31889a = r101;
        this.f31890b = r100;
    }

    public int a() {
        return this.f31890b;
    }

    public final void b() {
        InputStream r100 = this.f31889a;
        if ((r100 instanceof q1) == false) goto L6;
        q1 r101 = (q1) r100;
        r101.f31880f = true;
        r101.c();
        return;
    }
}
