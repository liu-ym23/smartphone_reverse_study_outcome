package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;
import java.math.BigInteger;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* loaded from: classes.dex */
public final class j extends r {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f7727a;

    public j(BigInteger bigInteger) {
        this.f7727a = bigInteger.toByteArray();
    }

    public static boolean b(byte[] bArr) {
        if (bArr.length > 1) {
            byte b4 = bArr[0];
            if (b4 == 0 && (bArr[1] & ByteCompanionObject.MIN_VALUE) == 0) {
                return true;
            }
            if (b4 == -1 && (bArr[1] & ByteCompanionObject.MIN_VALUE) != 0) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p pVar) throws IOException {
        pVar.a(this.f7727a, 2);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final int e() {
        return u1.a(this.f7727a.length) + 1 + this.f7727a.length;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean f() {
        return false;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r, com.baidu.mapauto.auth.org.spongycastle.asn1.l
    public final int hashCode() {
        int i4 = 0;
        int i5 = 0;
        while (true) {
            byte[] bArr = this.f7727a;
            if (i4 == bArr.length) {
                return i5;
            }
            i5 ^= (bArr[i4] & UByte.MAX_VALUE) << (i4 % 4);
            i4++;
        }
    }

    public final BigInteger i() {
        return new BigInteger(1, this.f7727a);
    }

    public final String toString() {
        return new BigInteger(this.f7727a).toString();
    }

    public j(byte[] bArr) {
        if (!com.baidu.mapauto.auth.org.spongycastle.util.c.a() && b(bArr)) {
            throw new IllegalArgumentException("malformed integer");
        }
        this.f7727a = bArr;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean a(r rVar) {
        if (rVar instanceof j) {
            return com.baidu.mapauto.auth.org.spongycastle.util.a.a(this.f7727a, ((j) rVar).f7727a);
        }
        return false;
    }

    public static j a(Object obj) {
        if (obj == null || (obj instanceof j)) {
            return (j) obj;
        }
        if (obj instanceof byte[]) {
            try {
                return (j) r.a((byte[]) obj);
            } catch (Exception e4) {
                StringBuilder sbA = com.baidu.mapauto.auth.a.a("encoding error in getInstance: ");
                sbA.append(e4.toString());
                throw new IllegalArgumentException(sbA.toString());
            }
        }
        StringBuilder sbA2 = com.baidu.mapauto.auth.a.a("illegal object in getInstance: ");
        sbA2.append(obj.getClass().getName());
        throw new IllegalArgumentException(sbA2.toString());
    }
}
