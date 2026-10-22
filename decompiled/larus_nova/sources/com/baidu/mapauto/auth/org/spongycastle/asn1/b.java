package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes39.dex */
public abstract class b extends r {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final char[] f31814c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f31815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f31816b;

    static {
        f31814c = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public b(byte[] r100, int r101) {
        if (r100 == null) goto L18;
        if (r100.length != 0) goto L11;
        if (r101 == 0) goto L11;
        throw new IllegalArgumentException("zero length data with non-zero pad bits");
    L11:
        if (r101 > 7) goto L16;
        if (r101 < 0) goto L16;
        this.f31815a = com.baidu.mapauto.auth.org.spongycastle.util.a.a(r100);
        this.f31816b = r101;
        return;
    L16:
        throw new IllegalArgumentException("pad bits cannot be greater than 7 or less than 0");
    L18:
        throw new NullPointerException("data cannot be null");
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final r g() {
        return new m0(this.f31815a, this.f31816b);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final r h() {
        return new j1(this.f31815a, this.f31816b);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r, com.baidu.mapauto.auth.org.spongycastle.asn1.l
    public final int hashCode() {
        int r100 = this.f31816b;
        byte[] r101 = this.f31815a;
        byte[] r102 = com.baidu.mapauto.auth.org.spongycastle.util.a.a(r101);
        if (r100 <= 0) goto L6;
        int r103 = r101.length - 1;
        r102[r103] = (byte) (r102[r103] & (255 << r100));
    L6:
        return r100 ^ com.baidu.mapauto.auth.org.spongycastle.util.a.b(r102);
    }

    public final String toString() {
        StringBuffer r100 = new StringBuffer("#");
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        new p(r101).a(this);     // Catch: IOException -> L10
        byte[] r102 = r101.toByteArray();
        int r103 = 0;
    L6:
        if (r103 == r102.length) goto L9;
        char[] r104 = f31814c;
        r100.append(r104[(r102[r103] >>> 4) & 15]);
        r100.append(r104[r102[r103] & 15]);
        r103 = r103 + 1;
        goto L6
    L9:
        return r100.toString();
    L10:
        e = move-exception;
        StringBuilder r105 = com.baidu.mapauto.auth.b.a("Internal error encoding BitString: ");
        r105.append(e.getMessage());
        throw new q(r105.toString(), e);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean a(r r100) {
        if ((r100 instanceof b) == true) goto L5;
        return false;
    L5:
        b r101 = (b) r100;
        int r102 = this.f31816b;
        if (r102 != r101.f31816b) goto L17;
        byte[] r103 = this.f31815a;
        byte[] r104 = com.baidu.mapauto.auth.org.spongycastle.util.a.a(r103);
        if (r102 <= 0) goto L10;
        int r105 = r103.length - 1;
        int r106 = 255 << r102;
        r104[r105] = (byte) (r106 & r104[r105]);
    L10:
        byte[] r107 = r101.f31815a;
        int r108 = r101.f31816b;
        byte[] r109 = com.baidu.mapauto.auth.org.spongycastle.util.a.a(r107);
        if (r108 <= 0) goto L14;
        int r110 = r107.length - 1;
        int r111 = 255 << r108;
        r109[r110] = (byte) (r111 & r109[r110]);
    L14:
        if (com.baidu.mapauto.auth.org.spongycastle.util.a.a(r104, r109) == false) goto L18;
        return true;
    L18:
        return false;
    L17:
        return false;
    }
}
