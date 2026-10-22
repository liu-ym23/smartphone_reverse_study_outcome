package c7;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class i implements Serializable, Comparable {
    public static final i d = new i(new byte[0]);

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f1165a;

    /* renamed from: b, reason: collision with root package name */
    public transient int f1166b;

    /* renamed from: c, reason: collision with root package name */
    public transient String f1167c;

    public i(byte[] data) {
        kotlin.jvm.internal.p.e(data, "data");
        this.f1165a = data;
    }

    public String a() {
        byte[] map = a.f1146a;
        byte[] bArr = this.f1165a;
        kotlin.jvm.internal.p.e(bArr, "<this>");
        kotlin.jvm.internal.p.e(map, "map");
        byte[] bArr2 = new byte[((bArr.length + 2) / 3) * 4];
        int length = bArr.length - (bArr.length % 3);
        int i8 = 0;
        int i9 = 0;
        while (i8 < length) {
            byte b9 = bArr[i8];
            int i10 = i8 + 2;
            byte b10 = bArr[i8 + 1];
            i8 += 3;
            byte b11 = bArr[i10];
            bArr2[i9] = map[(b9 & 255) >> 2];
            bArr2[i9 + 1] = map[((b9 & 3) << 4) | ((b10 & 255) >> 4)];
            int i11 = i9 + 3;
            bArr2[i9 + 2] = map[((b10 & 15) << 2) | ((b11 & 255) >> 6)];
            i9 += 4;
            bArr2[i11] = map[b11 & 63];
        }
        int length2 = bArr.length - length;
        if (length2 == 1) {
            byte b12 = bArr[i8];
            bArr2[i9] = map[(b12 & 255) >> 2];
            bArr2[i9 + 1] = map[(b12 & 3) << 4];
            bArr2[i9 + 2] = 61;
            bArr2[i9 + 3] = 61;
        } else if (length2 == 2) {
            int i12 = i8 + 1;
            byte b13 = bArr[i8];
            byte b14 = bArr[i12];
            bArr2[i9] = map[(b13 & 255) >> 2];
            bArr2[i9 + 1] = map[((b13 & 3) << 4) | ((b14 & 255) >> 4)];
            bArr2[i9 + 2] = map[(b14 & 15) << 2];
            bArr2[i9 + 3] = 61;
        }
        return new String(bArr2, x5.a.f6276a);
    }

    public i b(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        messageDigest.update(this.f1165a, 0, c());
        byte[] bArrDigest = messageDigest.digest();
        kotlin.jvm.internal.p.b(bArrDigest);
        return new i(bArrDigest);
    }

    public int c() {
        return this.f1165a.length;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        i other = (i) obj;
        kotlin.jvm.internal.p.e(other, "other");
        int iC = c();
        int iC2 = other.c();
        int iMin = Math.min(iC, iC2);
        for (int i8 = 0; i8 < iMin; i8++) {
            int iF = f(i8) & 255;
            int iF2 = other.f(i8) & 255;
            if (iF != iF2) {
                return iF < iF2 ? -1 : 1;
            }
        }
        if (iC == iC2) {
            return 0;
        }
        return iC < iC2 ? -1 : 1;
    }

    public String d() {
        byte[] bArr = this.f1165a;
        char[] cArr = new char[bArr.length * 2];
        int i8 = 0;
        for (byte b9 : bArr) {
            int i9 = i8 + 1;
            char[] cArr2 = d7.b.f1926a;
            cArr[i8] = cArr2[(b9 >> 4) & 15];
            i8 += 2;
            cArr[i9] = cArr2[b9 & 15];
        }
        return new String(cArr);
    }

    public byte[] e() {
        return this.f1165a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            int iC = iVar.c();
            byte[] bArr = this.f1165a;
            if (iC == bArr.length && iVar.h(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public byte f(int i8) {
        return this.f1165a[i8];
    }

    public boolean g(int i8, i other) {
        kotlin.jvm.internal.p.e(other, "other");
        return other.h(0, this.f1165a, 0, i8);
    }

    public boolean h(int i8, byte[] other, int i9, int i10) {
        kotlin.jvm.internal.p.e(other, "other");
        if (i8 < 0) {
            return false;
        }
        byte[] bArr = this.f1165a;
        return i8 <= bArr.length - i10 && i9 >= 0 && i9 <= other.length - i10 && b.a(i8, bArr, i9, other, i10);
    }

    public int hashCode() {
        int i8 = this.f1166b;
        if (i8 != 0) {
            return i8;
        }
        int iHashCode = Arrays.hashCode(this.f1165a);
        this.f1166b = iHashCode;
        return iHashCode;
    }

    public String i(Charset charset) {
        kotlin.jvm.internal.p.e(charset, "charset");
        return new String(this.f1165a, charset);
    }

    public i j(int i8, int i9) {
        if (i9 == -1234567890) {
            i9 = c();
        }
        if (i8 < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        byte[] bArr = this.f1165a;
        if (i9 <= bArr.length) {
            if (i9 - i8 >= 0) {
                return (i8 == 0 && i9 == bArr.length) ? this : new i(c5.l.Z(bArr, i8, i9));
            }
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        throw new IllegalArgumentException(("endIndex > length(" + bArr.length + ')').toString());
    }

    public i k() {
        int i8 = 0;
        while (true) {
            byte[] bArr = this.f1165a;
            if (i8 >= bArr.length) {
                return this;
            }
            byte b9 = bArr[i8];
            if (b9 >= 65 && b9 <= 90) {
                byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
                kotlin.jvm.internal.p.d(bArrCopyOf, "copyOf(...)");
                bArrCopyOf[i8] = (byte) (b9 + 32);
                for (int i9 = i8 + 1; i9 < bArrCopyOf.length; i9++) {
                    byte b10 = bArrCopyOf[i9];
                    if (b10 >= 65 && b10 <= 90) {
                        bArrCopyOf[i9] = (byte) (b10 + 32);
                    }
                }
                return new i(bArrCopyOf);
            }
            i8++;
        }
    }

    public final String l() {
        String str = this.f1167c;
        if (str != null) {
            return str;
        }
        byte[] bArrE = e();
        kotlin.jvm.internal.p.e(bArrE, "<this>");
        String str2 = new String(bArrE, x5.a.f6276a);
        this.f1167c = str2;
        return str2;
    }

    public void m(f fVar, int i8) {
        fVar.v(this.f1165a, i8);
    }

    public String toString() {
        byte b9;
        int i8;
        i iVar = this;
        byte[] bArr = iVar.f1165a;
        if (bArr.length == 0) {
            return "[size=0]";
        }
        int length = bArr.length;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        loop0: while (true) {
            if (i9 >= length) {
                break;
            }
            byte b10 = bArr[i9];
            if (b10 >= 0) {
                int i12 = i11 + 1;
                if (i11 == 64) {
                    break;
                }
                if ((b10 != 10 && b10 != 13 && ((b10 >= 0 && b10 < 32) || (127 <= b10 && b10 < 160))) || b10 == 65533) {
                    break;
                }
                i10 += b10 < 65536 ? 1 : 2;
                i9++;
                while (true) {
                    i11 = i12;
                    if (i9 < length && (b9 = bArr[i9]) >= 0) {
                        i9++;
                        i12 = i11 + 1;
                        if (i11 == 64) {
                            break loop0;
                        }
                        if ((b9 != 10 && b9 != 13 && ((b9 >= 0 && b9 < 32) || (127 <= b9 && b9 < 160))) || b9 == 65533) {
                            break loop0;
                        }
                        i10 += b9 < 65536 ? 1 : 2;
                    } else {
                        break;
                    }
                }
            } else if ((b10 >> 5) == -2) {
                int i13 = i9 + 1;
                if (length > i13) {
                    byte b11 = bArr[i13];
                    if ((b11 & 192) == 128) {
                        int i14 = (b11 ^ 3968) ^ (b10 << 6);
                        if (i14 >= 128) {
                            i8 = i11 + 1;
                            if (i11 == 64) {
                                break;
                            }
                            if ((i14 != 10 && i14 != 13 && ((i14 >= 0 && i14 < 32) || (127 <= i14 && i14 < 160))) || i14 == 65533) {
                                break;
                            }
                            i10 += i14 < 65536 ? 1 : 2;
                            i9 += 2;
                            i11 = i8;
                        } else if (i11 != 64) {
                            break;
                        }
                    } else if (i11 != 64) {
                        break;
                    }
                } else if (i11 != 64) {
                    break;
                }
            } else if ((b10 >> 4) == -2) {
                int i15 = i9 + 2;
                if (length > i15) {
                    byte b12 = bArr[i9 + 1];
                    if ((b12 & 192) == 128) {
                        byte b13 = bArr[i15];
                        if ((b13 & 192) == 128) {
                            int i16 = ((b13 ^ (-123008)) ^ (b12 << 6)) ^ (b10 << 12);
                            if (i16 < 2048) {
                                if (i11 != 64) {
                                    break;
                                }
                            } else if (55296 > i16 || i16 >= 57344) {
                                i8 = i11 + 1;
                                if (i11 == 64) {
                                    break;
                                }
                                if ((i16 != 10 && i16 != 13 && ((i16 >= 0 && i16 < 32) || (127 <= i16 && i16 < 160))) || i16 == 65533) {
                                    break;
                                }
                                i10 += i16 < 65536 ? 1 : 2;
                                i9 += 3;
                                i11 = i8;
                            } else if (i11 != 64) {
                                break;
                            }
                        } else if (i11 != 64) {
                            break;
                        }
                    } else if (i11 != 64) {
                        break;
                    }
                } else if (i11 != 64) {
                    break;
                }
            } else if ((b10 >> 3) == -2) {
                int i17 = i9 + 3;
                if (length > i17) {
                    byte b14 = bArr[i9 + 1];
                    if ((b14 & 192) == 128) {
                        byte b15 = bArr[i9 + 2];
                        if ((b15 & 192) == 128) {
                            byte b16 = bArr[i17];
                            if ((b16 & 192) == 128) {
                                int i18 = (((b16 ^ 3678080) ^ (b15 << 6)) ^ (b14 << 12)) ^ (b10 << 18);
                                if (i18 > 1114111) {
                                    if (i11 != 64) {
                                        break;
                                    }
                                } else if (55296 > i18 || i18 >= 57344) {
                                    if (i18 >= 65536) {
                                        i8 = i11 + 1;
                                        if (i11 == 64) {
                                            break;
                                        }
                                        if ((i18 != 10 && i18 != 13 && ((i18 >= 0 && i18 < 32) || (127 <= i18 && i18 < 160))) || i18 == 65533) {
                                            break;
                                        }
                                        i10 += i18 < 65536 ? 1 : 2;
                                        i9 += 4;
                                        i11 = i8;
                                    } else if (i11 != 64) {
                                        break;
                                    }
                                } else if (i11 != 64) {
                                    break;
                                }
                            } else if (i11 != 64) {
                                break;
                            }
                        } else if (i11 != 64) {
                            break;
                        }
                    } else if (i11 != 64) {
                        break;
                    }
                } else if (i11 != 64) {
                    break;
                }
            } else if (i11 != 64) {
                break;
            }
        }
        i10 = -1;
        if (i10 != -1) {
            String strL = iVar.l();
            String strSubstring = strL.substring(0, i10);
            kotlin.jvm.internal.p.d(strSubstring, "substring(...)");
            String strA1 = x5.u.a1(x5.u.a1(x5.u.a1(strSubstring, "\\", "\\\\"), "\n", "\\n"), "\r", "\\r");
            if (i10 >= strL.length()) {
                return "[text=" + strA1 + AbstractJsonLexerKt.END_LIST;
            }
            return "[size=" + bArr.length + " text=" + strA1 + "…]";
        }
        if (bArr.length <= 64) {
            return "[hex=" + iVar.d() + AbstractJsonLexerKt.END_LIST;
        }
        StringBuilder sb = new StringBuilder("[size=");
        sb.append(bArr.length);
        sb.append(" hex=");
        if (64 > bArr.length) {
            throw new IllegalArgumentException(("endIndex > length(" + bArr.length + ')').toString());
        }
        if (64 != bArr.length) {
            iVar = new i(c5.l.Z(bArr, 0, 64));
        }
        sb.append(iVar.d());
        sb.append("…]");
        return sb.toString();
    }
}
