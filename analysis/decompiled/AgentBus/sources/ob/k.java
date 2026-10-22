package ob;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* loaded from: classes.dex */
public class k implements Serializable, Comparable {

    /* renamed from: i, reason: collision with root package name */
    public static final k f7997i = new k(new byte[0]);

    /* renamed from: f, reason: collision with root package name */
    public final byte[] f7998f;

    /* renamed from: g, reason: collision with root package name */
    public transient int f7999g;

    /* renamed from: h, reason: collision with root package name */
    public transient String f8000h;

    public k(byte[] bArr) {
        q7.k.e(bArr, "data");
        this.f7998f = bArr;
    }

    public static int g(k kVar, k kVar2) {
        kVar.getClass();
        q7.k.e(kVar2, "other");
        return kVar.f(0, kVar2.h());
    }

    public static int k(k kVar, k kVar2) {
        kVar.getClass();
        q7.k.e(kVar2, "other");
        return kVar.j(kVar2.h());
    }

    public static /* synthetic */ k o(k kVar, int i2, int i10, int i11) {
        if ((i11 & 1) != 0) {
            i2 = 0;
        }
        if ((i11 & 2) != 0) {
            i10 = -1234567890;
        }
        return kVar.n(i2, i10);
    }

    public String a() {
        byte[] bArr = a.f7945a;
        byte[] bArr2 = this.f7998f;
        q7.k.e(bArr2, "<this>");
        q7.k.e(bArr, "map");
        byte[] bArr3 = new byte[((bArr2.length + 2) / 3) * 4];
        int length = bArr2.length - (bArr2.length % 3);
        int i2 = 0;
        int i10 = 0;
        while (i2 < length) {
            byte b10 = bArr2[i2];
            int i11 = i2 + 2;
            byte b11 = bArr2[i2 + 1];
            i2 += 3;
            byte b12 = bArr2[i11];
            bArr3[i10] = bArr[(b10 & 255) >> 2];
            bArr3[i10 + 1] = bArr[((b10 & 3) << 4) | ((b11 & 255) >> 4)];
            int i12 = i10 + 3;
            bArr3[i10 + 2] = bArr[((b11 & 15) << 2) | ((b12 & 255) >> 6)];
            i10 += 4;
            bArr3[i12] = bArr[b12 & 63];
        }
        int length2 = bArr2.length - length;
        if (length2 == 1) {
            byte b13 = bArr2[i2];
            bArr3[i10] = bArr[(b13 & 255) >> 2];
            bArr3[i10 + 1] = bArr[(b13 & 3) << 4];
            bArr3[i10 + 2] = 61;
            bArr3[i10 + 3] = 61;
        } else if (length2 == 2) {
            int i13 = i2 + 1;
            byte b14 = bArr2[i2];
            byte b15 = bArr2[i13];
            bArr3[i10] = bArr[(b14 & 255) >> 2];
            bArr3[i10 + 1] = bArr[((b14 & 3) << 4) | ((b15 & 255) >> 4)];
            bArr3[i10 + 2] = bArr[(b15 & 15) << 2];
            bArr3[i10 + 3] = 61;
        }
        return new String(bArr3, ga.a.f4005a);
    }

    @Override // java.lang.Comparable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final int compareTo(k kVar) {
        q7.k.e(kVar, "other");
        int iD = d();
        int iD2 = kVar.d();
        int iMin = Math.min(iD, iD2);
        for (int i2 = 0; i2 < iMin; i2++) {
            int i10 = i(i2) & 255;
            int i11 = kVar.i(i2) & 255;
            if (i10 != i11) {
                return i10 < i11 ? -1 : 1;
            }
        }
        if (iD == iD2) {
            return 0;
        }
        return iD < iD2 ? -1 : 1;
    }

    public k c(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        messageDigest.update(this.f7998f, 0, d());
        byte[] bArrDigest = messageDigest.digest();
        q7.k.b(bArrDigest);
        return new k(bArrDigest);
    }

    public int d() {
        return this.f7998f.length;
    }

    public String e() {
        byte[] bArr = this.f7998f;
        char[] cArr = new char[bArr.length * 2];
        int i2 = 0;
        for (byte b10 : bArr) {
            int i10 = i2 + 1;
            char[] cArr2 = pb.b.f8577a;
            cArr[i2] = cArr2[(b10 >> 4) & 15];
            i2 += 2;
            cArr[i10] = cArr2[b10 & 15];
        }
        return new String(cArr);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof k) {
            k kVar = (k) obj;
            int iD = kVar.d();
            byte[] bArr = this.f7998f;
            if (iD == bArr.length && kVar.l(0, 0, bArr.length, bArr)) {
                return true;
            }
        }
        return false;
    }

    public int f(int i2, byte[] bArr) {
        q7.k.e(bArr, "other");
        byte[] bArr2 = this.f7998f;
        int length = bArr2.length - bArr.length;
        int iMax = Math.max(i2, 0);
        if (iMax > length) {
            return -1;
        }
        while (!b.a(iMax, 0, bArr.length, bArr2, bArr)) {
            if (iMax == length) {
                return -1;
            }
            iMax++;
        }
        return iMax;
    }

    public byte[] h() {
        return this.f7998f;
    }

    public int hashCode() {
        int i2 = this.f7999g;
        if (i2 != 0) {
            return i2;
        }
        int iHashCode = Arrays.hashCode(this.f7998f);
        this.f7999g = iHashCode;
        return iHashCode;
    }

    public byte i(int i2) {
        return this.f7998f[i2];
    }

    public int j(byte[] bArr) {
        q7.k.e(bArr, "other");
        int iD = d();
        byte[] bArr2 = this.f7998f;
        for (int iMin = Math.min(iD, bArr2.length - bArr.length); -1 < iMin; iMin--) {
            if (b.a(iMin, 0, bArr.length, bArr2, bArr)) {
                return iMin;
            }
        }
        return -1;
    }

    public boolean l(int i2, int i10, int i11, byte[] bArr) {
        q7.k.e(bArr, "other");
        if (i2 < 0) {
            return false;
        }
        byte[] bArr2 = this.f7998f;
        return i2 <= bArr2.length - i11 && i10 >= 0 && i10 <= bArr.length - i11 && b.a(i2, i10, i11, bArr2, bArr);
    }

    public boolean m(int i2, k kVar, int i10) {
        q7.k.e(kVar, "other");
        return kVar.l(0, i2, i10, this.f7998f);
    }

    public k n(int i2, int i10) {
        if (i10 == -1234567890) {
            i10 = d();
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        byte[] bArr = this.f7998f;
        if (i10 > bArr.length) {
            throw new IllegalArgumentException(m.x.m(new StringBuilder("endIndex > length("), bArr.length, ')').toString());
        }
        if (i10 - i2 >= 0) {
            return (i2 == 0 && i10 == bArr.length) ? this : new k(d7.n.b0(bArr, i2, i10));
        }
        throw new IllegalArgumentException("endIndex < beginIndex");
    }

    public k p() {
        int i2 = 0;
        while (true) {
            byte[] bArr = this.f7998f;
            if (i2 >= bArr.length) {
                return this;
            }
            byte b10 = bArr[i2];
            if (b10 >= 65 && b10 <= 90) {
                byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
                q7.k.d(bArrCopyOf, "copyOf(...)");
                bArrCopyOf[i2] = (byte) (b10 + 32);
                for (int i10 = i2 + 1; i10 < bArrCopyOf.length; i10++) {
                    byte b11 = bArrCopyOf[i10];
                    if (b11 >= 65 && b11 <= 90) {
                        bArrCopyOf[i10] = (byte) (b11 + 32);
                    }
                }
                return new k(bArrCopyOf);
            }
            i2++;
        }
    }

    public byte[] q() {
        byte[] bArr = this.f7998f;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        q7.k.d(bArrCopyOf, "copyOf(...)");
        return bArrCopyOf;
    }

    public final String r() {
        String str = this.f8000h;
        if (str != null) {
            return str;
        }
        byte[] bArrH = h();
        q7.k.e(bArrH, "<this>");
        String str2 = new String(bArrH, ga.a.f4005a);
        this.f8000h = str2;
        return str2;
    }

    public void s(h hVar, int i2) {
        hVar.write(this.f7998f, 0, i2);
    }

    public String toString() {
        byte b10;
        int i2;
        k kVar = this;
        byte[] bArr = kVar.f7998f;
        if (bArr.length == 0) {
            return "[size=0]";
        }
        int length = bArr.length;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        loop0: while (true) {
            if (i10 >= length) {
                break;
            }
            byte b11 = bArr[i10];
            if (b11 >= 0) {
                int i13 = i12 + 1;
                if (i12 == 64) {
                    break;
                }
                if ((b11 != 10 && b11 != 13 && ((b11 >= 0 && b11 < 32) || (127 <= b11 && b11 < 160))) || b11 == 65533) {
                    break;
                }
                i11 += b11 < 65536 ? 1 : 2;
                i10++;
                while (true) {
                    i12 = i13;
                    if (i10 < length && (b10 = bArr[i10]) >= 0) {
                        i10++;
                        i13 = i12 + 1;
                        if (i12 == 64) {
                            break loop0;
                        }
                        if ((b10 != 10 && b10 != 13 && ((b10 >= 0 && b10 < 32) || (127 <= b10 && b10 < 160))) || b10 == 65533) {
                            break loop0;
                        }
                        i11 += b10 < 65536 ? 1 : 2;
                    } else {
                        break;
                    }
                }
            } else if ((b11 >> 5) == -2) {
                int i14 = i10 + 1;
                if (length > i14) {
                    byte b12 = bArr[i14];
                    if ((b12 & 192) == 128) {
                        int i15 = (b12 ^ 3968) ^ (b11 << 6);
                        if (i15 >= 128) {
                            i2 = i12 + 1;
                            if (i12 == 64) {
                                break;
                            }
                            if ((i15 != 10 && i15 != 13 && ((i15 >= 0 && i15 < 32) || (127 <= i15 && i15 < 160))) || i15 == 65533) {
                                break;
                            }
                            i11 += i15 < 65536 ? 1 : 2;
                            i10 += 2;
                            i12 = i2;
                        } else if (i12 != 64) {
                            break;
                        }
                    } else if (i12 != 64) {
                        break;
                    }
                } else if (i12 != 64) {
                    break;
                }
            } else if ((b11 >> 4) == -2) {
                int i16 = i10 + 2;
                if (length > i16) {
                    byte b13 = bArr[i10 + 1];
                    if ((b13 & 192) == 128) {
                        byte b14 = bArr[i16];
                        if ((b14 & 192) == 128) {
                            int i17 = ((b14 ^ (-123008)) ^ (b13 << 6)) ^ (b11 << 12);
                            if (i17 < 2048) {
                                if (i12 != 64) {
                                    break;
                                }
                            } else if (55296 > i17 || i17 >= 57344) {
                                i2 = i12 + 1;
                                if (i12 == 64) {
                                    break;
                                }
                                if ((i17 != 10 && i17 != 13 && ((i17 >= 0 && i17 < 32) || (127 <= i17 && i17 < 160))) || i17 == 65533) {
                                    break;
                                }
                                i11 += i17 < 65536 ? 1 : 2;
                                i10 += 3;
                                i12 = i2;
                            } else if (i12 != 64) {
                                break;
                            }
                        } else if (i12 != 64) {
                            break;
                        }
                    } else if (i12 != 64) {
                        break;
                    }
                } else if (i12 != 64) {
                    break;
                }
            } else if ((b11 >> 3) == -2) {
                int i18 = i10 + 3;
                if (length > i18) {
                    byte b15 = bArr[i10 + 1];
                    if ((b15 & 192) == 128) {
                        byte b16 = bArr[i10 + 2];
                        if ((b16 & 192) == 128) {
                            byte b17 = bArr[i18];
                            if ((b17 & 192) == 128) {
                                int i19 = (((b17 ^ 3678080) ^ (b16 << 6)) ^ (b15 << 12)) ^ (b11 << 18);
                                if (i19 > 1114111) {
                                    if (i12 != 64) {
                                        break;
                                    }
                                } else if (55296 > i19 || i19 >= 57344) {
                                    if (i19 >= 65536) {
                                        i2 = i12 + 1;
                                        if (i12 == 64) {
                                            break;
                                        }
                                        if ((i19 != 10 && i19 != 13 && ((i19 >= 0 && i19 < 32) || (127 <= i19 && i19 < 160))) || i19 == 65533) {
                                            break;
                                        }
                                        i11 += i19 < 65536 ? 1 : 2;
                                        i10 += 4;
                                        i12 = i2;
                                    } else if (i12 != 64) {
                                        break;
                                    }
                                } else if (i12 != 64) {
                                    break;
                                }
                            } else if (i12 != 64) {
                                break;
                            }
                        } else if (i12 != 64) {
                            break;
                        }
                    } else if (i12 != 64) {
                        break;
                    }
                } else if (i12 != 64) {
                    break;
                }
            } else if (i12 != 64) {
                break;
            }
        }
        i11 = -1;
        if (i11 != -1) {
            String strR = kVar.r();
            String strSubstring = strR.substring(0, i11);
            q7.k.d(strSubstring, "substring(...)");
            String strE0 = ga.r.e0(ga.r.e0(ga.r.e0(strSubstring, "\\", "\\\\"), "\n", "\\n"), "\r", "\\r");
            if (i11 >= strR.length()) {
                return a1.a.e(']', "[text=", strE0);
            }
            return "[size=" + bArr.length + " text=" + strE0 + "…]";
        }
        if (bArr.length <= 64) {
            return "[hex=" + kVar.e() + ']';
        }
        StringBuilder sb2 = new StringBuilder("[size=");
        sb2.append(bArr.length);
        sb2.append(" hex=");
        if (64 > bArr.length) {
            throw new IllegalArgumentException(m.x.m(new StringBuilder("endIndex > length("), bArr.length, ')').toString());
        }
        if (64 != bArr.length) {
            kVar = new k(d7.n.b0(bArr, 0, 64));
        }
        sb2.append(kVar.e());
        sb2.append("…]");
        return sb2.toString();
    }
}
