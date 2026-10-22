package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;

/* JADX INFO: loaded from: classes39.dex */
public abstract class r extends l {
    public r() {
    }

    public static r a(byte[] r100) throws IOException {
        i r101 = new i(r100);
        r r102 = r101.a();     // Catch: ClassCastException -> L8
        if (r101.available() != 0) goto L7;
        return r102;
    L7:
        throw new IOException("Extra data detected in stream");     // Catch: ClassCastException -> L8
    L9:
        throw new IOException("cannot recognise object in stream");
    }

    public abstract void a(p r100) throws IOException;

    public abstract boolean a(r r100);

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.l, com.baidu.mapauto.auth.org.spongycastle.asn1.d
    public final r c() {
        return this;
    }

    public abstract int e() throws IOException;

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.l
    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
    L10:
        return false;
    L8:
        if (a(((d) r100).c()) == false) goto L10;
        return true;
    }

    public abstract boolean f();

    public r g() {
        return this;
    }

    public r h() {
        return this;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.l
    public abstract int hashCode();
}
