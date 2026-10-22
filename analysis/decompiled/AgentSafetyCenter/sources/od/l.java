package od;

import java.io.Serializable;
import java.lang.invoke.VarHandle;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class l implements Serializable, Comparable {

    /* renamed from: h, reason: collision with root package name */
    public static final l f9459h;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f9460c;

    /* renamed from: f, reason: collision with root package name */
    public transient int f9461f;

    /* renamed from: g, reason: collision with root package name */
    public transient String f9462g;

    static {
        l lVar = new l();
        lVar.f9460c = new byte[0];
        VarHandle.storeStoreFence();
        f9459h = lVar;
    }

    public static int f(l lVar, l lVar2) {
        lVar.getClass();
        lVar2.getClass();
        return lVar.e(0, lVar2.g());
    }

    public static int j(l lVar, l lVar2) {
        lVar.getClass();
        lVar2.getClass();
        return lVar.i(lVar2.g());
    }

    public static /* synthetic */ l n(l lVar, int i, int i3, int i10) {
        if ((i10 & 1) != 0) {
            i = 0;
        }
        if ((i10 & 2) != 0) {
            i3 = -1234567890;
        }
        return lVar.m(i, i3);
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int compareTo(l lVar) {
        lVar.getClass();
        int iC = c();
        int iC2 = lVar.c();
        int iMin = Math.min(iC, iC2);
        for (int i = 0; i < iMin; i++) {
            int iH = h(i) & 255;
            int iH2 = lVar.h(i) & 255;
            if (iH != iH2) {
                return iH < iH2 ? -1 : 1;
            }
        }
        if (iC == iC2) {
            return 0;
        }
        return iC < iC2 ? -1 : 1;
    }

    public l b(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        messageDigest.update(this.f9460c, 0, c());
        byte[] bArrDigest = messageDigest.digest();
        bArrDigest.getClass();
        l lVar = new l();
        lVar.f9460c = bArrDigest;
        return lVar;
    }

    public int c() {
        return this.f9460c.length;
    }

    public String d() {
        byte[] bArr = this.f9460c;
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b10 : bArr) {
            int i3 = i + 1;
            char[] cArr2 = pd.b.f9998a;
            cArr[i] = cArr2[(b10 >> 4) & 15];
            i += 2;
            cArr[i3] = cArr2[b10 & 15];
        }
        return new String(cArr);
    }

    public int e(int i, byte[] bArr) {
        bArr.getClass();
        byte[] bArr2 = this.f9460c;
        int length = bArr2.length - bArr.length;
        int iMax = Math.max(i, 0);
        if (iMax > length) {
            return -1;
        }
        while (!a.a.i(bArr2, iMax, 0, bArr, bArr.length)) {
            if (iMax == length) {
                return -1;
            }
            iMax++;
        }
        return iMax;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof l) {
            l lVar = (l) obj;
            int iC = lVar.c();
            byte[] bArr = this.f9460c;
            if (iC == bArr.length && lVar.l(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public byte[] g() {
        return this.f9460c;
    }

    public byte h(int i) {
        return this.f9460c[i];
    }

    public int hashCode() {
        int i = this.f9461f;
        if (i != 0) {
            return i;
        }
        int iHashCode = Arrays.hashCode(this.f9460c);
        this.f9461f = iHashCode;
        return iHashCode;
    }

    public int i(byte[] bArr) {
        bArr.getClass();
        int iC = c();
        byte[] bArr2 = this.f9460c;
        for (int iMin = Math.min(iC, bArr2.length - bArr.length); -1 < iMin; iMin--) {
            if (a.a.i(bArr2, iMin, 0, bArr, bArr.length)) {
                return iMin;
            }
        }
        return -1;
    }

    public boolean k(int i, l lVar, int i3) {
        lVar.getClass();
        return lVar.l(0, this.f9460c, i, i3);
    }

    public boolean l(int i, byte[] bArr, int i3, int i10) {
        bArr.getClass();
        if (i < 0) {
            return false;
        }
        byte[] bArr2 = this.f9460c;
        return i <= bArr2.length - i10 && i3 >= 0 && i3 <= bArr.length - i10 && a.a.i(bArr2, i, i3, bArr, i10);
    }

    public l m(int i, int i3) {
        byte[] bArr = this.f9460c;
        if (i3 == -1234567890) {
            i3 = c();
        }
        if (i < 0) {
            g5.f.s("beginIndex < 0");
            return null;
        }
        if (i3 > bArr.length) {
            f.c(androidx.activity.b.l(new StringBuilder("endIndex > length("), bArr.length, ')'));
            return null;
        }
        if (i3 - i < 0) {
            g5.f.s("endIndex < beginIndex");
            return null;
        }
        if (i == 0 && i3 == bArr.length) {
            return this;
        }
        a.a.n(i3, bArr.length);
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i, i3);
        bArrCopyOfRange.getClass();
        l lVar = new l();
        lVar.f9460c = bArrCopyOfRange;
        return lVar;
    }

    public l o() {
        int i = 0;
        while (true) {
            byte[] bArr = this.f9460c;
            if (i >= bArr.length) {
                return this;
            }
            byte b10 = bArr[i];
            if (b10 >= 65 && b10 <= 90) {
                byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
                bArrCopyOf[i] = (byte) (b10 + 32);
                for (int i3 = i + 1; i3 < bArrCopyOf.length; i3++) {
                    byte b11 = bArrCopyOf[i3];
                    if (b11 >= 65 && b11 <= 90) {
                        bArrCopyOf[i3] = (byte) (b11 + 32);
                    }
                }
                l lVar = new l();
                lVar.f9460c = bArrCopyOf;
                return lVar;
            }
            i++;
        }
    }

    public final String p() {
        String str = this.f9462g;
        if (str != null) {
            return str;
        }
        byte[] bArrG = g();
        bArrG.getClass();
        String str2 = new String(bArrG, hc.a.f5448a);
        this.f9462g = str2;
        return str2;
    }

    public void q(i iVar, int i) {
        iVar.write(this.f9460c, 0, i);
    }

    public String toString() {
        byte b10;
        int i;
        l lVar = this;
        byte[] bArr = lVar.f9460c;
        if (bArr.length == 0) {
            return "[size=0]";
        }
        int length = bArr.length;
        int i3 = 0;
        int i10 = 0;
        int i11 = 0;
        loop0: while (true) {
            if (i3 >= length) {
                break;
            }
            byte b11 = bArr[i3];
            if (b11 >= 0) {
                int i12 = i11 + 1;
                if (i11 == 64) {
                    break;
                }
                if ((b11 != 10 && b11 != 13 && ((b11 >= 0 && b11 < 32) || (127 <= b11 && b11 < 160))) || b11 == 65533) {
                    break;
                }
                i10 += b11 < 65536 ? 1 : 2;
                i3++;
                while (true) {
                    i11 = i12;
                    if (i3 < length && (b10 = bArr[i3]) >= 0) {
                        i3++;
                        i12 = i11 + 1;
                        if (i11 == 64) {
                            break loop0;
                        }
                        if ((b10 != 10 && b10 != 13 && ((b10 >= 0 && b10 < 32) || (127 <= b10 && b10 < 160))) || b10 == 65533) {
                            break loop0;
                        }
                        i10 += b10 < 65536 ? 1 : 2;
                    } else {
                        break;
                    }
                }
            } else if ((b11 >> 5) == -2) {
                int i13 = i3 + 1;
                if (length > i13) {
                    byte b12 = bArr[i13];
                    if ((b12 & 192) == 128) {
                        int i14 = (b12 ^ 3968) ^ (b11 << 6);
                        if (i14 >= 128) {
                            i = i11 + 1;
                            if (i11 == 64) {
                                break;
                            }
                            if ((i14 != 10 && i14 != 13 && ((i14 >= 0 && i14 < 32) || (127 <= i14 && i14 < 160))) || i14 == 65533) {
                                break;
                            }
                            i10 += i14 < 65536 ? 1 : 2;
                            i3 += 2;
                            i11 = i;
                        } else if (i11 != 64) {
                            break;
                        }
                    } else if (i11 != 64) {
                        break;
                    }
                } else if (i11 != 64) {
                    break;
                }
            } else if ((b11 >> 4) == -2) {
                int i15 = i3 + 2;
                if (length > i15) {
                    byte b13 = bArr[i3 + 1];
                    if ((b13 & 192) == 128) {
                        byte b14 = bArr[i15];
                        if ((b14 & 192) == 128) {
                            int i16 = ((b14 ^ (-123008)) ^ (b13 << 6)) ^ (b11 << 12);
                            if (i16 < 2048) {
                                if (i11 != 64) {
                                    break;
                                }
                            } else if (55296 > i16 || i16 >= 57344) {
                                i = i11 + 1;
                                if (i11 == 64) {
                                    break;
                                }
                                if ((i16 != 10 && i16 != 13 && ((i16 >= 0 && i16 < 32) || (127 <= i16 && i16 < 160))) || i16 == 65533) {
                                    break;
                                }
                                i10 += i16 < 65536 ? 1 : 2;
                                i3 += 3;
                                i11 = i;
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
            } else if ((b11 >> 3) == -2) {
                int i17 = i3 + 3;
                if (length > i17) {
                    byte b15 = bArr[i3 + 1];
                    if ((b15 & 192) == 128) {
                        byte b16 = bArr[i3 + 2];
                        if ((b16 & 192) == 128) {
                            byte b17 = bArr[i17];
                            if ((b17 & 192) == 128) {
                                int i18 = (((b17 ^ 3678080) ^ (b16 << 6)) ^ (b15 << 12)) ^ (b11 << 18);
                                if (i18 > 1114111) {
                                    if (i11 != 64) {
                                        break;
                                    }
                                } else if (55296 > i18 || i18 >= 57344) {
                                    if (i18 >= 65536) {
                                        i = i11 + 1;
                                        if (i11 == 64) {
                                            break;
                                        }
                                        if ((i18 != 10 && i18 != 13 && ((i18 >= 0 && i18 < 32) || (127 <= i18 && i18 < 160))) || i18 == 65533) {
                                            break;
                                        }
                                        i10 += i18 < 65536 ? 1 : 2;
                                        i3 += 4;
                                        i11 = i;
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
            String strP = lVar.p();
            String strS = hc.o.S(hc.o.S(hc.o.S(strP.substring(0, i10), "\\", "\\\\"), "\n", "\\n"), "\r", "\\r");
            if (i10 >= strP.length()) {
                return "[text=" + strS + ']';
            }
            return "[size=" + bArr.length + " text=" + strS + "…]";
        }
        if (bArr.length <= 64) {
            return "[hex=" + lVar.d() + ']';
        }
        StringBuilder sb2 = new StringBuilder("[size=");
        sb2.append(bArr.length);
        sb2.append(" hex=");
        if (64 > bArr.length) {
            f.c(androidx.activity.b.l(new StringBuilder("endIndex > length("), bArr.length, ')'));
            return null;
        }
        if (64 != bArr.length) {
            a.a.n(64, bArr.length);
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 0, 64);
            bArrCopyOfRange.getClass();
            lVar = new l();
            lVar.f9460c = bArrCopyOfRange;
        }
        sb2.append(lVar.d());
        sb2.append("…]");
        return sb2.toString();
    }
}
