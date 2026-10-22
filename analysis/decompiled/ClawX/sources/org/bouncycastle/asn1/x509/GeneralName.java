package org.bouncycastle.asn1.x509;

import a8.b;
import java.io.IOException;
import java.util.StringTokenizer;
import m0.f;
import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1IA5String;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.util.IPAddress;

/* loaded from: classes.dex */
public class GeneralName extends ASN1Object implements ASN1Choice {
    public static final int dNSName = 2;
    public static final int directoryName = 4;
    public static final int ediPartyName = 5;
    public static final int iPAddress = 7;
    public static final int otherName = 0;
    public static final int registeredID = 8;
    public static final int rfc822Name = 1;
    public static final int uniformResourceIdentifier = 6;
    public static final int x400Address = 3;
    private ASN1Encodable obj;
    private int tag;

    public GeneralName(int i8, String str) throws NumberFormatException {
        this.tag = i8;
        if (i8 == 1 || i8 == 2 || i8 == 6) {
            this.obj = new DERIA5String(str);
            return;
        }
        if (i8 == 8) {
            this.obj = new ASN1ObjectIdentifier(str);
            return;
        }
        if (i8 == 4) {
            this.obj = new X500Name(str);
        } else {
            if (i8 != 7) {
                throw new IllegalArgumentException(b.j(i8, "can't process String for tag: "));
            }
            byte[] generalNameEncoding = toGeneralNameEncoding(str);
            if (generalNameEncoding == null) {
                throw new IllegalArgumentException("IP Address is invalid");
            }
            this.obj = new DEROctetString(generalNameEncoding);
        }
    }

    private void copyInts(int[] iArr, byte[] bArr, int i8) {
        for (int i9 = 0; i9 != iArr.length; i9++) {
            int i10 = i9 * 2;
            int i11 = iArr[i9];
            bArr[i10 + i8] = (byte) (i11 >> 8);
            bArr[i10 + 1 + i8] = (byte) i11;
        }
    }

    public static GeneralName getInstance(Object obj) {
        if (obj == null || (obj instanceof GeneralName)) {
            return (GeneralName) obj;
        }
        if (!(obj instanceof ASN1TaggedObject)) {
            if (!(obj instanceof byte[])) {
                throw new IllegalArgumentException(f.b(obj, "unknown object in getInstance: "));
            }
            try {
                return getInstance(ASN1Primitive.fromByteArray((byte[]) obj));
            } catch (IOException unused) {
                throw new IllegalArgumentException("unable to parse encoded general name");
            }
        }
        ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) obj;
        int tagNo = aSN1TaggedObject.getTagNo();
        switch (tagNo) {
            case 0:
            case 3:
            case 5:
                return new GeneralName(tagNo, ASN1Sequence.getInstance(aSN1TaggedObject, false));
            case 1:
            case 2:
            case 6:
                return new GeneralName(tagNo, ASN1IA5String.getInstance(aSN1TaggedObject, false));
            case 4:
                return new GeneralName(tagNo, X500Name.getInstance(aSN1TaggedObject, true));
            case 7:
                return new GeneralName(tagNo, ASN1OctetString.getInstance(aSN1TaggedObject, false));
            case 8:
                return new GeneralName(tagNo, ASN1ObjectIdentifier.getInstance(aSN1TaggedObject, false));
            default:
                throw new IllegalArgumentException(b.j(tagNo, "unknown tag: "));
        }
    }

    private void parseIPv4(String str, byte[] bArr, int i8) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, "./");
        int i9 = 0;
        while (stringTokenizer.hasMoreTokens()) {
            bArr[i9 + i8] = (byte) Integer.parseInt(stringTokenizer.nextToken());
            i9++;
        }
    }

    private void parseIPv4Mask(String str, byte[] bArr, int i8) throws NumberFormatException {
        int i9 = Integer.parseInt(str);
        for (int i10 = 0; i10 != i9; i10++) {
            int i11 = (i10 / 8) + i8;
            bArr[i11] = (byte) (bArr[i11] | (1 << (7 - (i10 % 8))));
        }
    }

    private int[] parseIPv6(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ":", true);
        int[] iArr = new int[8];
        if (str.charAt(0) == ':' && str.charAt(1) == ':') {
            stringTokenizer.nextToken();
        }
        int i8 = -1;
        int i9 = 0;
        while (stringTokenizer.hasMoreTokens()) {
            String strNextToken = stringTokenizer.nextToken();
            if (strNextToken.equals(":")) {
                iArr[i9] = 0;
                int i10 = i9;
                i9++;
                i8 = i10;
            } else if (strNextToken.indexOf(46) < 0) {
                int i11 = i9 + 1;
                iArr[i9] = Integer.parseInt(strNextToken, 16);
                if (stringTokenizer.hasMoreTokens()) {
                    stringTokenizer.nextToken();
                }
                i9 = i11;
            } else {
                StringTokenizer stringTokenizer2 = new StringTokenizer(strNextToken, ".");
                int i12 = i9 + 1;
                iArr[i9] = (Integer.parseInt(stringTokenizer2.nextToken()) << 8) | Integer.parseInt(stringTokenizer2.nextToken());
                i9 += 2;
                iArr[i12] = Integer.parseInt(stringTokenizer2.nextToken()) | (Integer.parseInt(stringTokenizer2.nextToken()) << 8);
            }
        }
        if (i9 != 8) {
            int i13 = i9 - i8;
            int i14 = 8 - i13;
            System.arraycopy(iArr, i8, iArr, i14, i13);
            while (i8 != i14) {
                iArr[i8] = 0;
                i8++;
            }
        }
        return iArr;
    }

    private int[] parseMask(String str) throws NumberFormatException {
        int[] iArr = new int[8];
        int i8 = Integer.parseInt(str);
        for (int i9 = 0; i9 != i8; i9++) {
            int i10 = i9 / 16;
            iArr[i10] = iArr[i10] | (1 << (15 - (i9 % 16)));
        }
        return iArr;
    }

    private byte[] toGeneralNameEncoding(String str) throws NumberFormatException {
        if (IPAddress.isValidIPv6WithNetmask(str) || IPAddress.isValidIPv6(str)) {
            int iIndexOf = str.indexOf(47);
            if (iIndexOf < 0) {
                byte[] bArr = new byte[16];
                copyInts(parseIPv6(str), bArr, 0);
                return bArr;
            }
            byte[] bArr2 = new byte[32];
            copyInts(parseIPv6(str.substring(0, iIndexOf)), bArr2, 0);
            String strSubstring = str.substring(iIndexOf + 1);
            copyInts(strSubstring.indexOf(58) > 0 ? parseIPv6(strSubstring) : parseMask(strSubstring), bArr2, 16);
            return bArr2;
        }
        if (!IPAddress.isValidIPv4WithNetmask(str) && !IPAddress.isValidIPv4(str)) {
            return null;
        }
        int iIndexOf2 = str.indexOf(47);
        if (iIndexOf2 < 0) {
            byte[] bArr3 = new byte[4];
            parseIPv4(str, bArr3, 0);
            return bArr3;
        }
        byte[] bArr4 = new byte[8];
        parseIPv4(str.substring(0, iIndexOf2), bArr4, 0);
        String strSubstring2 = str.substring(iIndexOf2 + 1);
        if (strSubstring2.indexOf(46) > 0) {
            parseIPv4(strSubstring2, bArr4, 4);
            return bArr4;
        }
        parseIPv4Mask(strSubstring2, bArr4, 4);
        return bArr4;
    }

    public ASN1Encodable getName() {
        return this.obj;
    }

    public int getTagNo() {
        return this.tag;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        int i8 = this.tag;
        return new DERTaggedObject(i8 == 4, i8, this.obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r1 = r3.tag
            r0.append(r1)
            java.lang.String r1 = ": "
            r0.append(r1)
            int r1 = r3.tag
            r2 = 1
            if (r1 == r2) goto L32
            r2 = 2
            if (r1 == r2) goto L32
            r2 = 4
            if (r1 == r2) goto L27
            r2 = 6
            if (r1 == r2) goto L32
            org.bouncycastle.asn1.ASN1Encodable r3 = r3.obj
            java.lang.String r3 = r3.toString()
        L23:
            r0.append(r3)
            goto L3d
        L27:
            org.bouncycastle.asn1.ASN1Encodable r3 = r3.obj
            org.bouncycastle.asn1.x500.X500Name r3 = org.bouncycastle.asn1.x500.X500Name.getInstance(r3)
            java.lang.String r3 = r3.toString()
            goto L23
        L32:
            org.bouncycastle.asn1.ASN1Encodable r3 = r3.obj
            org.bouncycastle.asn1.ASN1IA5String r3 = org.bouncycastle.asn1.ASN1IA5String.getInstance(r3)
            java.lang.String r3 = r3.getString()
            goto L23
        L3d:
            java.lang.String r3 = r0.toString()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.asn1.x509.GeneralName.toString():java.lang.String");
    }

    public GeneralName(int i8, ASN1Encodable aSN1Encodable) {
        this.obj = aSN1Encodable;
        this.tag = i8;
    }

    public GeneralName(X500Name x500Name) {
        this.obj = x500Name;
        this.tag = 4;
    }

    public GeneralName(X509Name x509Name) {
        this.obj = X500Name.getInstance(x509Name);
        this.tag = 4;
    }

    public static GeneralName getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        if (z) {
            return getInstance(ASN1TaggedObject.getInstance(aSN1TaggedObject, true));
        }
        throw new IllegalArgumentException("choice item must be explicitly tagged");
    }
}
