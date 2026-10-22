package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.UByte;

/* loaded from: classes.dex */
public abstract class n extends r implements o {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f7739a;

    public n(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("string cannot be null");
        }
        this.f7739a = bArr;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.p1
    public final r a() {
        return this;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.o
    public final InputStream b() {
        return new ByteArrayInputStream(this.f7739a);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final r g() {
        return new v0(this.f7739a);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final r h() {
        return new v0(this.f7739a);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r, com.baidu.mapauto.auth.org.spongycastle.asn1.l
    public final int hashCode() {
        return com.baidu.mapauto.auth.org.spongycastle.util.a.b(i());
    }

    public byte[] i() {
        return this.f7739a;
    }

    public final String toString() throws IOException {
        StringBuilder sbA = com.baidu.mapauto.auth.a.a("#");
        byte[] bArr = this.f7739a;
        com.baidu.mapauto.auth.org.spongycastle.util.encoders.e eVar = com.baidu.mapauto.auth.org.spongycastle.util.encoders.d.f7800a;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            eVar.getClass();
            for (byte b4 : bArr) {
                byteArrayOutputStream.write(eVar.f7801a[(b4 & UByte.MAX_VALUE) >>> 4]);
                byteArrayOutputStream.write(eVar.f7801a[b4 & 15]);
            }
            sbA.append(com.baidu.mapauto.auth.org.spongycastle.util.d.a(byteArrayOutputStream.toByteArray()));
            return sbA.toString();
        } catch (Exception e4) {
            StringBuilder sbA2 = com.baidu.mapauto.auth.a.a("exception encoding Hex string: ");
            sbA2.append(e4.getMessage());
            throw new com.baidu.mapauto.auth.org.spongycastle.util.encoders.c(sbA2.toString(), e4);
        }
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean a(r rVar) {
        if (rVar instanceof n) {
            return com.baidu.mapauto.auth.org.spongycastle.util.a.a(this.f7739a, ((n) rVar).f7739a);
        }
        return false;
    }
}
