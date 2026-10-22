package j6;

import com.stepos.stepclaw.SecurePrefs;
import java.io.EOFException;
import k4.z;
import kotlin.jvm.internal.p;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.bouncycastle.asn1.BERTags;
import org.tukaani.xz.common.Util;
import x5.u;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f3536a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static final void a(long j4, long j8, long j9) {
        if (j8 < 0 || j9 > j4) {
            throw new IndexOutOfBoundsException("startIndex (" + j8 + ") and endIndex (" + j9 + ") are not within the range [0..size(" + j4 + "))");
        }
        if (j8 <= j9) {
            return;
        }
        throw new IllegalArgumentException("startIndex (" + j8 + ") > endIndex (" + j9 + ')');
    }

    public static final void b(long j4, long j8) {
        if (0 > j4 || j4 < j8 || j8 < 0) {
            StringBuilder sb = new StringBuilder("offset (0) and byteCount (");
            sb.append(j8);
            sb.append(") are not within the range [0..size(");
            throw new IllegalArgumentException(a8.b.r(sb, j4, "))"));
        }
    }

    public static final String c(a aVar, long j4) throws EOFException {
        if (j4 == 0) {
            return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        g gVar = aVar.f3510a;
        if (gVar == null) {
            throw new IllegalStateException("Unreacheable");
        }
        if (gVar.b() < j4) {
            byte[] bArrE = e(aVar, (int) j4);
            return z.i(0, bArrE.length, bArrE);
        }
        byte[] bArr = gVar.f3524a;
        int i8 = gVar.f3525b;
        String strI = z.i(i8, Math.min(gVar.f3526c, ((int) j4) + i8), bArr);
        aVar.skip(j4);
        return strI;
    }

    public static final int d(a aVar) throws EOFException {
        int i8;
        int i9;
        int i10;
        aVar.f(1L);
        byte bA = aVar.a(0L);
        if ((bA & 128) == 0) {
            i8 = bA & AbstractJsonLexerKt.TC_INVALID;
            i10 = 0;
            i9 = 1;
        } else if ((bA & 224) == 192) {
            i8 = bA & 31;
            i9 = 2;
            i10 = 128;
        } else if ((bA & 240) == 224) {
            i8 = bA & 15;
            i9 = 3;
            i10 = 2048;
        } else {
            if ((bA & 248) != 240) {
                aVar.skip(1L);
                return 65533;
            }
            i8 = bA & 7;
            i9 = 4;
            i10 = 65536;
        }
        long j4 = i9;
        if (aVar.f3512c < j4) {
            StringBuilder sbS = a8.b.s(i9, "size < ", ": ");
            sbS.append(aVar.f3512c);
            sbS.append(" (to read code point prefixed 0x");
            char[] cArr = f3536a;
            sbS.append(new String(new char[]{cArr[(bA >> 4) & 15], cArr[bA & 15]}));
            sbS.append(')');
            throw new EOFException(sbS.toString());
        }
        for (int i11 = 1; i11 < i9; i11++) {
            long j8 = i11;
            byte bA2 = aVar.a(j8);
            if ((bA2 & 192) != 128) {
                aVar.skip(j8);
                return 65533;
            }
            i8 = (i8 << 6) | (bA2 & 63);
        }
        aVar.skip(j4);
        if (i8 <= 1114111 && ((55296 > i8 || i8 >= 57344) && i8 >= i10)) {
            return i8;
        }
        return 65533;
    }

    public static final byte[] e(j jVar, int i8) {
        p.e(jVar, "<this>");
        long j4 = i8;
        if (j4 >= 0) {
            return f(jVar, i8);
        }
        throw new IllegalArgumentException(("byteCount (" + j4 + ") < 0").toString());
    }

    public static final byte[] f(j jVar, int i8) {
        if (i8 == -1) {
            for (long j4 = 2147483647L; jVar.c().f3512c < 2147483647L && jVar.k(j4); j4 *= 2) {
            }
            if (jVar.c().f3512c >= 2147483647L) {
                throw new IllegalStateException(("Can't create an array of size " + jVar.c().f3512c).toString());
            }
            i8 = (int) jVar.c().f3512c;
        } else {
            jVar.f(i8);
        }
        byte[] bArr = new byte[i8];
        a aVarC = jVar.c();
        p.e(aVarC, "<this>");
        long j8 = i8;
        int i9 = 0;
        a(j8, 0, j8);
        while (i9 < i8) {
            int iB = aVarC.b(i9, i8, bArr);
            if (iB == -1) {
                throw new EOFException("Source exhausted before reading " + i8 + " bytes. Only " + iB + " bytes were read.");
            }
            i9 += iB;
        }
        return bArr;
    }

    public static final String g(j jVar) {
        p.e(jVar, "<this>");
        jVar.k(Util.VLI_MAX);
        return c(jVar.c(), jVar.c().f3512c);
    }

    public static final void h(i iVar, int i8) {
        String strU0;
        p.e(iVar, "<this>");
        a aVar = (a) iVar;
        if (i8 < 0 || i8 > 1114111) {
            StringBuilder sb = new StringBuilder("Code point value is out of Unicode codespace 0..0x10ffff: 0x");
            if (i8 != 0) {
                char[] cArr = f3536a;
                char[] cArr2 = {cArr[(i8 >> 28) & 15], cArr[(i8 >> 24) & 15], cArr[(i8 >> 20) & 15], cArr[(i8 >> 16) & 15], cArr[(i8 >> 12) & 15], cArr[(i8 >> 8) & 15], cArr[(i8 >> 4) & 15], cArr[i8 & 15]};
                int i9 = 0;
                while (i9 < 8 && cArr2[i9] == '0') {
                    i9++;
                }
                strU0 = u.U0(cArr2, i9, 8);
            } else {
                strU0 = "0";
            }
            sb.append(strU0);
            sb.append(" (");
            sb.append(i8);
            sb.append(')');
            throw new IllegalArgumentException(sb.toString());
        }
        if (i8 < 128) {
            aVar.t((byte) i8);
            return;
        }
        if (i8 < 2048) {
            g gVarN = aVar.n(2);
            byte[] bArr = gVarN.f3524a;
            byte b9 = (byte) ((i8 >> 6) | BERTags.PRIVATE);
            int i10 = gVarN.f3526c;
            bArr[i10] = b9;
            bArr[i10 + 1] = (byte) ((i8 & 63) | 128);
            gVarN.f3526c = i10 + 2;
            aVar.f3512c += 2;
            return;
        }
        if (55296 <= i8 && i8 < 57344) {
            aVar.t((byte) 63);
            return;
        }
        if (i8 < 65536) {
            g gVarN2 = aVar.n(3);
            byte[] bArr2 = gVarN2.f3524a;
            byte b10 = (byte) ((i8 >> 12) | BERTags.FLAGS);
            int i11 = gVarN2.f3526c;
            bArr2[i11] = b10;
            bArr2[i11 + 1] = (byte) (((i8 >> 6) & 63) | 128);
            bArr2[i11 + 2] = (byte) ((i8 & 63) | 128);
            gVarN2.f3526c = i11 + 3;
            aVar.f3512c += 3;
            return;
        }
        g gVarN3 = aVar.n(4);
        byte[] bArr3 = gVarN3.f3524a;
        int i12 = gVarN3.f3526c;
        bArr3[i12] = (byte) ((i8 >> 18) | 240);
        bArr3[i12 + 1] = (byte) (((i8 >> 12) & 63) | 128);
        bArr3[i12 + 2] = (byte) (((i8 >> 6) & 63) | 128);
        bArr3[i12 + 3] = (byte) ((i8 & 63) | 128);
        gVarN3.f3526c = i12 + 4;
        aVar.f3512c += 4;
    }

    public static final void i(i iVar, String string, int i8, int i9) {
        char cCharAt;
        int i10;
        p.e(iVar, "<this>");
        p.e(string, "string");
        a(string.length(), i8, i9);
        a aVar = (a) iVar;
        while (i8 < i9) {
            char cCharAt2 = string.charAt(i8);
            if (cCharAt2 < 128) {
                g gVarN = aVar.n(1);
                byte[] bArr = gVarN.f3524a;
                int i11 = -i8;
                int iMin = Math.min(i9, gVarN.a() + i8);
                int i12 = i8 + 1;
                bArr[gVarN.f3526c + i8 + i11] = (byte) cCharAt2;
                while (true) {
                    i8 = i12;
                    if (i8 >= iMin || (cCharAt = string.charAt(i8)) >= 128) {
                        break;
                    }
                    i12 = i8 + 1;
                    bArr[gVarN.f3526c + i8 + i11] = (byte) cCharAt;
                }
                int i13 = i11 + i8;
                if (i13 == 1) {
                    gVarN.f3526c += i13;
                    aVar.f3512c += i13;
                } else {
                    if (i13 < 0 || i13 > gVarN.a()) {
                        StringBuilder sbS = a8.b.s(i13, "Invalid number of bytes written: ", ". Should be in 0..");
                        sbS.append(gVarN.a());
                        throw new IllegalStateException(sbS.toString().toString());
                    }
                    if (i13 != 0) {
                        gVarN.f3526c += i13;
                        aVar.f3512c += i13;
                    } else if (gVarN.b() == 0) {
                        g gVar = aVar.f3511b;
                        p.b(gVar);
                        g gVar2 = gVar.f3529g;
                        aVar.f3511b = gVar2;
                        if (gVar2 == null) {
                            aVar.f3510a = null;
                        } else {
                            gVar2.f3528f = null;
                        }
                        gVar.f3529g = null;
                        h.a(gVar);
                    }
                }
            } else {
                if (cCharAt2 < 2048) {
                    i10 = 2;
                    g gVarN2 = aVar.n(2);
                    byte b9 = (byte) ((cCharAt2 >> 6) | BERTags.PRIVATE);
                    byte[] bArr2 = gVarN2.f3524a;
                    int i14 = gVarN2.f3526c;
                    bArr2[i14] = b9;
                    bArr2[i14 + 1] = (byte) ((cCharAt2 & '?') | 128);
                    gVarN2.f3526c = i14 + 2;
                } else if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                    i10 = 3;
                    g gVarN3 = aVar.n(3);
                    byte b10 = (byte) ((cCharAt2 >> '\f') | BERTags.FLAGS);
                    byte[] bArr3 = gVarN3.f3524a;
                    int i15 = gVarN3.f3526c;
                    bArr3[i15] = b10;
                    bArr3[i15 + 1] = (byte) ((63 & (cCharAt2 >> 6)) | 128);
                    bArr3[i15 + 2] = (byte) ((cCharAt2 & '?') | 128);
                    gVarN3.f3526c = i15 + 3;
                } else {
                    int i16 = i8 + 1;
                    char cCharAt3 = i16 < i9 ? string.charAt(i16) : (char) 0;
                    if (cCharAt2 > 56319 || 56320 > cCharAt3 || cCharAt3 >= 57344) {
                        aVar.t((byte) 63);
                        i8 = i16;
                    } else {
                        int i17 = (((cCharAt2 & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                        g gVarN4 = aVar.n(4);
                        byte[] bArr4 = gVarN4.f3524a;
                        int i18 = gVarN4.f3526c;
                        bArr4[i18] = (byte) ((i17 >> 18) | 240);
                        bArr4[i18 + 1] = (byte) (((i17 >> 12) & 63) | 128);
                        bArr4[i18 + 2] = (byte) (((i17 >> 6) & 63) | 128);
                        bArr4[i18 + 3] = (byte) ((i17 & 63) | 128);
                        gVarN4.f3526c = i18 + 4;
                        aVar.f3512c += 4;
                        i8 += 2;
                    }
                }
                aVar.f3512c += i10;
                i8++;
            }
        }
    }
}
