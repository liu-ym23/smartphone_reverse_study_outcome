package com.baidu.mapauto.auth.org.spongycastle.asn1;

import ch.qos.logback.core.CoreConstants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.ByteCompanionObject;

/* loaded from: classes.dex */
public final class m extends r {

    /* renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap f7733c = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    public final String f7734a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f7735b;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f7736a;

        /* renamed from: b, reason: collision with root package name */
        public final byte[] f7737b;

        public a(byte[] bArr) {
            this.f7736a = com.baidu.mapauto.auth.org.spongycastle.util.a.b(bArr);
            this.f7737b = bArr;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof a) {
                return com.baidu.mapauto.auth.org.spongycastle.util.a.a(this.f7737b, ((a) obj).f7737b);
            }
            return false;
        }

        public final int hashCode() {
            return this.f7736a;
        }
    }

    public m(byte[] bArr) {
        int i4;
        StringBuffer stringBuffer = new StringBuffer();
        boolean z4 = true;
        BigInteger bigIntegerShiftLeft = null;
        int i5 = 0;
        long j4 = 0;
        while (i5 != bArr.length) {
            byte b4 = bArr[i5];
            if (j4 <= 72057594037927808L) {
                i4 = i5;
                long j5 = j4 + (b4 & ByteCompanionObject.MAX_VALUE);
                if ((b4 & ByteCompanionObject.MIN_VALUE) == 0) {
                    if (z4) {
                        if (j5 < 40) {
                            stringBuffer.append('0');
                        } else if (j5 < 80) {
                            stringBuffer.append('1');
                            j5 -= 40;
                        } else {
                            stringBuffer.append('2');
                            j5 -= 80;
                        }
                        z4 = false;
                    }
                    stringBuffer.append(CoreConstants.DOT);
                    stringBuffer.append(j5);
                    j4 = 0;
                } else {
                    j4 = j5 << 7;
                }
            } else {
                i4 = i5;
                BigInteger bigIntegerOr = (bigIntegerShiftLeft == null ? BigInteger.valueOf(j4) : bigIntegerShiftLeft).or(BigInteger.valueOf(b4 & ByteCompanionObject.MAX_VALUE));
                if ((b4 & ByteCompanionObject.MIN_VALUE) == 0) {
                    if (z4) {
                        stringBuffer.append('2');
                        bigIntegerOr = bigIntegerOr.subtract(BigInteger.valueOf(80L));
                        z4 = false;
                    }
                    stringBuffer.append(CoreConstants.DOT);
                    stringBuffer.append(bigIntegerOr);
                    bigIntegerShiftLeft = null;
                    j4 = 0;
                } else {
                    bigIntegerShiftLeft = bigIntegerOr.shiftLeft(7);
                }
            }
            i5 = i4 + 1;
        }
        this.f7734a = stringBuffer.toString();
        this.f7735b = com.baidu.mapauto.auth.org.spongycastle.util.a.a(bArr);
    }

    public static void a(ByteArrayOutputStream byteArrayOutputStream, BigInteger bigInteger) {
        int iBitLength = (bigInteger.bitLength() + 6) / 7;
        if (iBitLength == 0) {
            byteArrayOutputStream.write(0);
            return;
        }
        byte[] bArr = new byte[iBitLength];
        int i4 = iBitLength - 1;
        for (int i5 = i4; i5 >= 0; i5--) {
            bArr[i5] = (byte) ((bigInteger.intValue() & 127) | 128);
            bigInteger = bigInteger.shiftRight(7);
        }
        bArr[i4] = (byte) (bArr[i4] & ByteCompanionObject.MAX_VALUE);
        byteArrayOutputStream.write(bArr, 0, iBitLength);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final int e() throws IOException {
        int length = i().length;
        return u1.a(length) + 1 + length;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean f() {
        return false;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r, com.baidu.mapauto.auth.org.spongycastle.asn1.l
    public final int hashCode() {
        return this.f7734a.hashCode();
    }

    public final synchronized byte[] i() {
        String strSubstring;
        int i4;
        String strSubstring2;
        int i5;
        int i6;
        String strSubstring3;
        try {
            if (this.f7735b == null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                String str = this.f7734a;
                int i7 = 46;
                int iIndexOf = str.indexOf(46, 0);
                if (iIndexOf == -1) {
                    strSubstring = str.substring(0);
                    i4 = -1;
                } else {
                    strSubstring = str.substring(0, iIndexOf);
                    i4 = iIndexOf + 1;
                }
                int i8 = Integer.parseInt(strSubstring) * 40;
                if (i4 == -1) {
                    i5 = i4;
                    strSubstring2 = null;
                } else {
                    int iIndexOf2 = str.indexOf(46, i4);
                    if (iIndexOf2 == -1) {
                        strSubstring2 = str.substring(i4);
                        i5 = -1;
                    } else {
                        strSubstring2 = str.substring(i4, iIndexOf2);
                        i5 = iIndexOf2 + 1;
                    }
                }
                if (strSubstring2.length() <= 18) {
                    i6 = i5;
                    long j4 = Long.parseLong(strSubstring2) + i8;
                    byte[] bArr = new byte[9];
                    bArr[8] = (byte) (((int) j4) & 127);
                    int i9 = 8;
                    while (j4 >= 128) {
                        j4 >>= 7;
                        i9--;
                        bArr[i9] = (byte) ((((int) j4) & 127) | 128);
                    }
                    byteArrayOutputStream.write(bArr, i9, 9 - i9);
                } else {
                    i6 = i5;
                    a(byteArrayOutputStream, new BigInteger(strSubstring2).add(BigInteger.valueOf(i8)));
                }
                int i10 = i6;
                while (i10 != -1) {
                    if (i10 == -1) {
                        strSubstring3 = null;
                    } else {
                        int iIndexOf3 = str.indexOf(i7, i10);
                        if (iIndexOf3 == -1) {
                            strSubstring3 = str.substring(i10);
                            i10 = -1;
                        } else {
                            String strSubstring4 = str.substring(i10, iIndexOf3);
                            i10 = iIndexOf3 + 1;
                            strSubstring3 = strSubstring4;
                        }
                    }
                    if (strSubstring3.length() <= 18) {
                        long j5 = Long.parseLong(strSubstring3);
                        byte[] bArr2 = new byte[9];
                        bArr2[8] = (byte) (((int) j5) & 127);
                        int i11 = 8;
                        while (j5 >= 128) {
                            j5 >>= 7;
                            i11--;
                            bArr2[i11] = (byte) ((((int) j5) & 127) | 128);
                        }
                        byteArrayOutputStream.write(bArr2, i11, 9 - i11);
                    } else {
                        a(byteArrayOutputStream, new BigInteger(strSubstring3));
                    }
                    i7 = 46;
                }
                this.f7735b = byteArrayOutputStream.toByteArray();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f7735b;
    }

    public final String toString() {
        return this.f7734a;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean a(r rVar) {
        if (rVar == this) {
            return true;
        }
        if (rVar instanceof m) {
            return this.f7734a.equals(((m) rVar).f7734a);
        }
        return false;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p pVar) throws IOException {
        byte[] bArrI = i();
        pVar.a(6);
        pVar.b(bArrI.length);
        pVar.f7749a.write(bArrI);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static m a(d dVar) {
        if (dVar == 0 || (dVar instanceof m)) {
            return (m) dVar;
        }
        if (dVar.c() instanceof m) {
            return (m) dVar.c();
        }
        if (dVar instanceof byte[]) {
            try {
                return (m) r.a((byte[]) dVar);
            } catch (IOException e4) {
                StringBuilder sbA = com.baidu.mapauto.auth.a.a("failed to construct object identifier from byte[]: ");
                sbA.append(e4.getMessage());
                throw new IllegalArgumentException(sbA.toString());
            }
        }
        StringBuilder sbA2 = com.baidu.mapauto.auth.a.a("illegal object in getInstance: ");
        sbA2.append(dVar.getClass().getName());
        throw new IllegalArgumentException(sbA2.toString());
    }
}
