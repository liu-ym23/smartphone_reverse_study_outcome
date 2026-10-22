package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes39.dex */
public final class g1 extends r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final char[] f31836b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f31837a;

    static {
        f31836b = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public g1(byte[] r100) {
        this.f31837a = com.baidu.mapauto.auth.org.spongycastle.util.a.a(r100);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean a(r r100) {
        if ((r100 instanceof g1) == true) goto L7;
        return false;
    L7:
        return com.baidu.mapauto.auth.org.spongycastle.util.a.a(this.f31837a, ((g1) r100).f31837a);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final int e() {
        return (u1.a(this.f31837a.length) + 1) + this.f31837a.length;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean f() {
        return false;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r, com.baidu.mapauto.auth.org.spongycastle.asn1.l
    public final int hashCode() {
        return com.baidu.mapauto.auth.org.spongycastle.util.a.b(this.f31837a);
    }

    public final String toString() {
        StringBuffer r100 = new StringBuffer("#");
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        new p(r101).a(this);     // Catch: IOException -> L10
        byte[] r102 = r101.toByteArray();
        int r103 = 0;
    L6:
        if (r103 == r102.length) goto L9;
        char[] r104 = f31836b;
        r100.append(r104[(r102[r103] >>> 4) & 15]);
        r100.append(r104[r102[r103] & 15]);
        r103 = r103 + 1;
        goto L6
    L9:
        return r100.toString();
    L11:
        throw new q("internal error encoding BitString");
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p r100) throws IOException {
        r100.a(com.baidu.mapauto.auth.org.spongycastle.util.a.a(this.f31837a), 28);
    }
}
