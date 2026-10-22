package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

/* loaded from: classes.dex */
public final class b0 extends n {

    /* renamed from: b, reason: collision with root package name */
    public n[] f7697b;

    public class a implements Enumeration {

        /* renamed from: a, reason: collision with root package name */
        public int f7698a = 0;

        public a() {
        }

        @Override // java.util.Enumeration
        public final boolean hasMoreElements() {
            return this.f7698a < b0.this.f7697b.length;
        }

        @Override // java.util.Enumeration
        public final Object nextElement() {
            n[] nVarArr = b0.this.f7697b;
            int i4 = this.f7698a;
            this.f7698a = i4 + 1;
            return nVarArr[i4];
        }
    }

    public b0(byte[] bArr) {
        super(bArr);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p pVar) throws IOException {
        pVar.a(36);
        pVar.a(128);
        Enumeration enumerationJ = j();
        while (enumerationJ.hasMoreElements()) {
            pVar.a((d) enumerationJ.nextElement());
        }
        pVar.a(0);
        pVar.a(0);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final int e() throws IOException {
        Enumeration enumerationJ = j();
        int iE = 0;
        while (enumerationJ.hasMoreElements()) {
            iE += ((d) enumerationJ.nextElement()).c().e();
        }
        return iE + 4;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean f() {
        return true;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.n
    public final byte[] i() {
        return this.f7739a;
    }

    public final Enumeration j() {
        if (this.f7697b != null) {
            return new a();
        }
        Vector vector = new Vector();
        int i4 = 0;
        while (true) {
            byte[] bArr = this.f7739a;
            if (i4 >= bArr.length) {
                return vector.elements();
            }
            int i5 = i4 + 1000;
            int length = (i5 > bArr.length ? bArr.length : i5) - i4;
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, i4, bArr2, 0, length);
            vector.addElement(new v0(bArr2));
            i4 = i5;
        }
    }

    public b0(n[] nVarArr) {
        super(a(nVarArr));
        this.f7697b = nVarArr;
    }

    public static byte[] a(n[] nVarArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i4 = 0; i4 != nVarArr.length; i4++) {
            try {
                byteArrayOutputStream.write(((v0) nVarArr[i4]).f7739a);
            } catch (IOException e4) {
                StringBuilder sbA = com.baidu.mapauto.auth.a.a("exception converting octets ");
                sbA.append(e4.toString());
                throw new IllegalArgumentException(sbA.toString());
            } catch (ClassCastException unused) {
                throw new IllegalArgumentException(nVarArr[i4].getClass().getName().concat(" found in input should only contain DEROctetString"));
            }
        }
        return byteArrayOutputStream.toByteArray();
    }
}
