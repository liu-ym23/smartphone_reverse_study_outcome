package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import kotlin.UByte;

/* JADX INFO: loaded from: classes39.dex */
public abstract class n extends r implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f31859a;

    public n(byte[] r100) {
        if (r100 == null) goto L7;
        this.f31859a = r100;
        return;
    L7:
        throw new NullPointerException("string cannot be null");
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.p1
    public final r a() {
        return this;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean a(r r100) {
        if ((r100 instanceof n) == true) goto L7;
        return false;
    L7:
        return com.baidu.mapauto.auth.org.spongycastle.util.a.a(this.f31859a, ((n) r100).f31859a);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.o
    public final InputStream b() {
        return new ByteArrayInputStream(this.f31859a);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final r g() {
        return new v0(this.f31859a);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final r h() {
        return new v0(this.f31859a);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r, com.baidu.mapauto.auth.org.spongycastle.asn1.l
    public final int hashCode() {
        return com.baidu.mapauto.auth.org.spongycastle.util.a.b(i());
    }

    public byte[] i() {
        return this.f31859a;
    }

    public final String toString() {
        StringBuilder r100 = com.baidu.mapauto.auth.b.a("#");
        byte[] r101 = this.f31859a;
        com.baidu.mapauto.auth.org.spongycastle.util.encoders.e r102 = com.baidu.mapauto.auth.org.spongycastle.util.encoders.d.f31920a;
        int r103 = r101.length;
        ByteArrayOutputStream r104 = new ByteArrayOutputStream();
        r102.getClass();     // Catch: Exception -> L10
        int r105 = 0;
    L5:
        if (r105 >= (0 + r103)) goto L8;
        int r106 = r101[r105] & UByte.MAX_VALUE;     // Catch: Exception -> L10
        r104.write(r102.f31921a[r106 >>> 4]);     // Catch: Exception -> L10
        r104.write(r102.f31921a[r106 & 15]);     // Catch: Exception -> L10
        r105 = r105 + 1;
        goto L5
    L8:
        r100.append(com.baidu.mapauto.auth.org.spongycastle.util.d.a(r104.toByteArray()));
        return r100.toString();
    L10:
        e = move-exception;
        StringBuilder r107 = com.baidu.mapauto.auth.b.a("exception encoding Hex string: ");
        r107.append(e.getMessage());
        throw new com.baidu.mapauto.auth.org.spongycastle.util.encoders.c(r107.toString(), e);
    }
}
