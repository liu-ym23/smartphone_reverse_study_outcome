package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;
import java.math.BigInteger;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: classes39.dex */
public final class j extends r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f31847a;

    public j(BigInteger r100) {
        this.f31847a = r100.toByteArray();
    }

    public j(byte[] r100) {
        if (com.baidu.mapauto.auth.org.spongycastle.util.c.a() == false) goto L5;
    L9:
        this.f31847a = r100;
        return;
    L5:
        if (b(r100) == false) goto L9;
        throw new IllegalArgumentException("malformed integer");
    }

    public static boolean b(byte[] r100) {
        if (r100.length <= 1) goto L14;
        byte r101 = r100[0];
        if (r101 != 0) goto L10;
        if ((r100[1] & ByteCompanionObject.MIN_VALUE) != 0) goto L10;
        return true;
    L10:
        if (r101 != (-1)) goto L14;
        if ((r100[1] & ByteCompanionObject.MIN_VALUE) == 0) goto L14;
        return true;
    L14:
        return false;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p r100) throws IOException {
        r100.a(this.f31847a, 2);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean a(r r100) {
        if ((r100 instanceof j) == true) goto L7;
        return false;
    L7:
        return com.baidu.mapauto.auth.org.spongycastle.util.a.a(this.f31847a, ((j) r100).f31847a);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final int e() {
        return (u1.a(this.f31847a.length) + 1) + this.f31847a.length;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean f() {
        return false;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r, com.baidu.mapauto.auth.org.spongycastle.asn1.l
    public final int hashCode() {
        int r100 = 0;
        int r101 = 0;
    L3:
        byte[] r102 = this.f31847a;
        if (r100 == r102.length) goto L6;
        r101 = r101 ^ ((r102[r100] & UByte.MAX_VALUE) << (r100 % 4));
        r100 = r100 + 1;
        goto L3
    L6:
        return r101;
    }

    public final BigInteger i() {
        return new BigInteger(1, this.f31847a);
    }

    public final String toString() {
        return new BigInteger(this.f31847a).toString();
    }

    public static j a(Object r100) {
        if (r100 == null) goto L16;
        if ((r100 instanceof j) == true) goto L16;
        if ((r100 instanceof byte[]) == true) goto L17;
        StringBuilder r101 = com.baidu.mapauto.auth.b.a("illegal object in getInstance: ");
        r101.append(r100.getClass().getName());
        throw new IllegalArgumentException(r101.toString());
    L17:
        return (j) r.a((byte[]) r100);
    L10:
        e = move-exception;
        StringBuilder r102 = com.baidu.mapauto.auth.b.a("encoding error in getInstance: ");
        r102.append(e.toString());
        throw new IllegalArgumentException(r102.toString());
    L16:
        return (j) r100;
    }
}
