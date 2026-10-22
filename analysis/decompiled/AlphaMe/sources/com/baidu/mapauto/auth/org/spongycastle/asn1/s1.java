package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;

/* loaded from: classes.dex */
public final class s1 extends s {

    /* renamed from: b, reason: collision with root package name */
    public byte[] f7766b;

    public s1(byte[] bArr) throws IOException {
        this.f7766b = bArr;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p pVar) throws IOException {
        byte[] bArr = this.f7766b;
        if (bArr != null) {
            pVar.a(bArr, 48);
        } else {
            super.h().a(pVar);
        }
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final int e() throws IOException {
        byte[] bArr = this.f7766b;
        return bArr != null ? u1.a(bArr.length) + 1 + this.f7766b.length : super.h().e();
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.s, com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final r g() {
        byte[] bArr = this.f7766b;
        if (bArr != null) {
            r1 r1Var = new r1(bArr);
            while (r1Var.hasMoreElements()) {
                this.f7764a.addElement(r1Var.nextElement());
            }
            this.f7766b = null;
        }
        return super.g();
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.s, com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final r h() {
        byte[] bArr = this.f7766b;
        if (bArr != null) {
            r1 r1Var = new r1(bArr);
            while (r1Var.hasMoreElements()) {
                this.f7764a.addElement(r1Var.nextElement());
            }
            this.f7766b = null;
        }
        return super.h();
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.s
    public final synchronized Enumeration i() {
        byte[] bArr = this.f7766b;
        if (bArr == null) {
            return this.f7764a.elements();
        }
        return new r1(bArr);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.s
    public final synchronized int size() {
        try {
            byte[] bArr = this.f7766b;
            if (bArr != null) {
                r1 r1Var = new r1(bArr);
                while (r1Var.hasMoreElements()) {
                    this.f7764a.addElement(r1Var.nextElement());
                }
                this.f7766b = null;
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f7764a.size();
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.s
    public final synchronized d a(int i4) {
        try {
            byte[] bArr = this.f7766b;
            if (bArr != null) {
                r1 r1Var = new r1(bArr);
                while (r1Var.hasMoreElements()) {
                    this.f7764a.addElement(r1Var.nextElement());
                }
                this.f7766b = null;
            }
        } catch (Throwable th) {
            throw th;
        }
        return super.a(i4);
    }
}
