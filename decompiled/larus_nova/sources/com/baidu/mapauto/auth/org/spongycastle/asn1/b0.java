package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

/* JADX INFO: loaded from: classes39.dex */
public final class b0 extends n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public n[] f31817b;

    public class a implements Enumeration {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f31818a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b0 f31819b;

        public a(b0 r100) {
            this.f31819b = r100;
            this.f31818a = 0;
        }

        @Override // java.util.Enumeration
        public final boolean hasMoreElements() {
            if (this.f31818a >= this.f31819b.f31817b.length) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Enumeration
        public final Object nextElement() {
            n[] r100 = this.f31819b.f31817b;
            int r101 = this.f31818a;
            this.f31818a = r101 + 1;
            return r100[r101];
        }
    }

    public b0(byte[] r100) {
        super(r100);
    }

    public b0(n[] r100) {
        super(a(r100));
        this.f31817b = r100;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p r100) throws IOException {
        r100.a(36);
        r100.a(128);
        Enumeration r101 = j();
    L4:
        if (r101.hasMoreElements() == false) goto L6;
        r100.a((d) r101.nextElement());
        goto L4
    L6:
        r100.a(0);
        r100.a(0);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final int e() throws IOException {
        Enumeration r100 = j();
        int r101 = 0;
    L4:
        if (r100.hasMoreElements() == false) goto L7;
        r101 = r101 + ((d) r100.nextElement()).c().e();
        goto L4
    L7:
        return (r101 + 2) + 2;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean f() {
        return true;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.n
    public final byte[] i() {
        return this.f31859a;
    }

    public final Enumeration j() {
        if (this.f31817b != null) goto L15;
        Vector r100 = new Vector();
        int r101 = 0;
    L5:
        byte[] r102 = this.f31859a;
        if (r101 >= r102.length) goto L13;
        int r103 = r101 + 1000;
        if (r103 <= r102.length) goto L10;
        int r104 = r102.length;
    L11:
        int r105 = r104 - r101;
        byte[] r106 = new byte[r105];
        System.arraycopy(r102, r101, r106, 0, r105);
        r100.addElement(new v0(r106));
        r101 = r103;
        goto L5
    L10:
        r104 = r103;
        goto L11
    L13:
        return r100.elements();
    L15:
        return new a(this);
    }

    public static byte[] a(n[] r100) {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        int r102 = 0;
    L4:
        if (r102 == r100.length) goto L13;
        r101.write(((v0) r100[r102]).f31859a);     // Catch: IOException -> L7 ClassCastException -> L10
        r102 = r102 + 1;
        goto L4
    L7:
        e = move-exception;
        StringBuilder r103 = com.baidu.mapauto.auth.b.a("exception converting octets ");
        r103.append(e.toString());
        throw new IllegalArgumentException(r103.toString());
    L11:
        throw new IllegalArgumentException(r100[r102].getClass().getName().concat(" found in input should only contain DEROctetString"));
    L13:
        return r101.toByteArray();
    }
}
