package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes39.dex */
public final class s1 extends s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f31886b;

    public s1(byte[] r100) throws IOException {
        this.f31886b = r100;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p r100) throws IOException {
        byte[] r101 = this.f31886b;
        if (r101 == null) goto L5;
        r100.a(r101, 48);
        return;
    L5:
        super.h().a(r100);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final int e() throws IOException {
        byte[] r100 = this.f31886b;
        if (r100 == null) goto L7;
        return (u1.a(r100.length) + 1) + this.f31886b.length;
    L7:
        return super.h().e();
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.s
    public final synchronized Enumeration i() {
        monitor-enter(this);
        byte[] r100 = this.f31886b;     // Catch: Throwable -> L11
        if (r100 != null) goto L8;
        Enumeration r101 = this.f31884a.elements();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r101;
    L8:
        r1 r102 = new r1(r100);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r102;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.s
    public final synchronized int size() {
        monitor-enter(this);
        byte[] r100 = this.f31886b;     // Catch: Throwable -> L13
        if (r100 == null) goto L10;
        r1 r101 = new r1(r100);     // Catch: Throwable -> L13
    L7:
        if (r101.hasMoreElements() == false) goto L9;
        this.f31884a.addElement(r101.nextElement());     // Catch: Throwable -> L13
        goto L7
    L9:
        this.f31886b = null;     // Catch: Throwable -> L13
    L10:
        int r102 = this.f31884a.size();     // Catch: Throwable -> L13
        monitor-exit(this);
        return r102;
    L13:
        th = move-exception;
        throw th;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.s, com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final r g() {
        byte[] r100 = this.f31886b;
        if (r100 == null) goto L10;
        r1 r101 = new r1(r100);
    L6:
        if (r101.hasMoreElements() == false) goto L8;
        this.f31884a.addElement(r101.nextElement());
        goto L6
    L8:
        this.f31886b = null;
    L10:
        return super.g();
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.s, com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final r h() {
        byte[] r100 = this.f31886b;
        if (r100 == null) goto L10;
        r1 r101 = new r1(r100);
    L6:
        if (r101.hasMoreElements() == false) goto L8;
        this.f31884a.addElement(r101.nextElement());
        goto L6
    L8:
        this.f31886b = null;
    L10:
        return super.h();
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.s
    public final synchronized d a(int r100) {
        monitor-enter(this);
        byte[] r101 = this.f31886b;     // Catch: Throwable -> L13
        if (r101 == null) goto L10;
        r1 r102 = new r1(r101);     // Catch: Throwable -> L13
    L7:
        if (r102.hasMoreElements() == false) goto L9;
        this.f31884a.addElement(r102.nextElement());     // Catch: Throwable -> L13
        goto L7
    L9:
        this.f31886b = null;     // Catch: Throwable -> L13
    L10:
        d r103 = super.a(r100);     // Catch: Throwable -> L13
        monitor-exit(this);
        return r103;
    L13:
        th = move-exception;
        throw th;
    }
}
