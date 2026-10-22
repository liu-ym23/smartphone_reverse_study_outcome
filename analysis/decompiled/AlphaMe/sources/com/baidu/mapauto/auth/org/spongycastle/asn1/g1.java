package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public final class g1 extends r {

    /* renamed from: b, reason: collision with root package name */
    public static final char[] f7716b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f7717a;

    public g1(byte[] bArr) {
        this.f7717a = com.baidu.mapauto.auth.org.spongycastle.util.a.a(bArr);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean a(r rVar) {
        if (rVar instanceof g1) {
            return com.baidu.mapauto.auth.org.spongycastle.util.a.a(this.f7717a, ((g1) rVar).f7717a);
        }
        return false;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final int e() {
        return u1.a(this.f7717a.length) + 1 + this.f7717a.length;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean f() {
        return false;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r, com.baidu.mapauto.auth.org.spongycastle.asn1.l
    public final int hashCode() {
        return com.baidu.mapauto.auth.org.spongycastle.util.a.b(this.f7717a);
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer("#");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new p(byteArrayOutputStream).a((d) this);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            for (int i4 = 0; i4 != byteArray.length; i4++) {
                char[] cArr = f7716b;
                stringBuffer.append(cArr[(byteArray[i4] >>> 4) & 15]);
                stringBuffer.append(cArr[byteArray[i4] & 15]);
            }
            return stringBuffer.toString();
        } catch (IOException unused) {
            throw new q("internal error encoding BitString");
        }
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p pVar) throws IOException {
        pVar.a(com.baidu.mapauto.auth.org.spongycastle.util.a.a(this.f7717a), 28);
    }
}
