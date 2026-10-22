package k3;

import ch.qos.logback.core.CoreConstants;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import kotlin.UByte;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import l3.AbstractC0766b;

/* loaded from: classes2.dex */
public class l implements Serializable, Comparable {

    /* renamed from: d, reason: collision with root package name */
    public static final l f13358d = new l(new byte[0]);

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f13359a;

    /* renamed from: b, reason: collision with root package name */
    public transient int f13360b;

    /* renamed from: c, reason: collision with root package name */
    public transient String f13361c;

    public l(byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.f13359a = data;
    }

    public String a() {
        byte[] map = AbstractC0684F.f13338a;
        byte[] bArr = this.f13359a;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(map, "map");
        byte[] bArr2 = new byte[((bArr.length + 2) / 3) * 4];
        int length = bArr.length - (bArr.length % 3);
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            byte b4 = bArr[i4];
            int i6 = i4 + 2;
            byte b5 = bArr[i4 + 1];
            i4 += 3;
            byte b6 = bArr[i6];
            bArr2[i5] = map[(b4 & UByte.MAX_VALUE) >> 2];
            bArr2[i5 + 1] = map[((b4 & 3) << 4) | ((b5 & UByte.MAX_VALUE) >> 4)];
            int i7 = i5 + 3;
            bArr2[i5 + 2] = map[((b5 & 15) << 2) | ((b6 & UByte.MAX_VALUE) >> 6)];
            i5 += 4;
            bArr2[i7] = map[b6 & 63];
        }
        int length2 = bArr.length - length;
        if (length2 == 1) {
            byte b7 = bArr[i4];
            bArr2[i5] = map[(b7 & UByte.MAX_VALUE) >> 2];
            bArr2[i5 + 1] = map[(b7 & 3) << 4];
            byte b8 = (byte) 61;
            bArr2[i5 + 2] = b8;
            bArr2[i5 + 3] = b8;
        } else if (length2 == 2) {
            int i8 = i4 + 1;
            byte b9 = bArr[i4];
            byte b10 = bArr[i8];
            bArr2[i5] = map[(b9 & UByte.MAX_VALUE) >> 2];
            bArr2[i5 + 1] = map[((b9 & 3) << 4) | ((b10 & UByte.MAX_VALUE) >> 4)];
            bArr2[i5 + 2] = map[(b10 & 15) << 2];
            bArr2[i5 + 3] = (byte) 61;
        }
        Intrinsics.checkNotNullParameter(bArr2, "<this>");
        return new String(bArr2, Charsets.UTF_8);
    }

    public l b(String algorithm) throws NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        messageDigest.update(this.f13359a, 0, c());
        byte[] digestBytes = messageDigest.digest();
        Intrinsics.checkNotNullExpressionValue(digestBytes, "digestBytes");
        return new l(digestBytes);
    }

    public int c() {
        return this.f13359a.length;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0033, code lost:
    
        if (r0 < r1) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0036, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:?, code lost:
    
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x002a, code lost:
    
        if (r7 < r8) goto L9;
     */
    @Override // java.lang.Comparable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int compareTo(java.lang.Object r10) {
        /*
            r9 = this;
            k3.l r10 = (k3.l) r10
            java.lang.String r0 = "other"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            int r0 = r9.c()
            int r1 = r10.c()
            int r2 = java.lang.Math.min(r0, r1)
            r3 = 0
            r4 = r3
        L15:
            r5 = 1
            r6 = -1
            if (r4 >= r2) goto L30
            byte r7 = r9.f(r4)
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r8 = r10.f(r4)
            r8 = r8 & 255(0xff, float:3.57E-43)
            if (r7 != r8) goto L2a
            int r4 = r4 + 1
            goto L15
        L2a:
            if (r7 >= r8) goto L2e
        L2c:
            r3 = r6
            goto L36
        L2e:
            r3 = r5
            goto L36
        L30:
            if (r0 != r1) goto L33
            goto L36
        L33:
            if (r0 >= r1) goto L2e
            goto L2c
        L36:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: k3.l.compareTo(java.lang.Object):int");
    }

    public String d() {
        byte[] bArr = this.f13359a;
        char[] cArr = new char[bArr.length * 2];
        int i4 = 0;
        for (byte b4 : bArr) {
            int i5 = i4 + 1;
            char[] cArr2 = AbstractC0766b.f13506a;
            cArr[i4] = cArr2[(b4 >> 4) & 15];
            i4 += 2;
            cArr[i5] = cArr2[b4 & 15];
        }
        return StringsKt.concatToString(cArr);
    }

    public byte[] e() {
        return this.f13359a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof l) {
            l lVar = (l) obj;
            int iC = lVar.c();
            byte[] bArr = this.f13359a;
            if (iC == bArr.length && lVar.h(bArr, 0, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public byte f(int i4) {
        return this.f13359a[i4];
    }

    public boolean g(l other, int i4) {
        Intrinsics.checkNotNullParameter(other, "other");
        return other.h(this.f13359a, 0, 0, i4);
    }

    public boolean h(byte[] other, int i4, int i5, int i6) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (i4 >= 0) {
            byte[] bArr = this.f13359a;
            if (i4 <= bArr.length - i6 && i5 >= 0 && i5 <= other.length - i6 && AbstractC0685G.a(bArr, i4, i5, other, i6)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i4 = this.f13360b;
        if (i4 != 0) {
            return i4;
        }
        int iHashCode = Arrays.hashCode(this.f13359a);
        this.f13360b = iHashCode;
        return iHashCode;
    }

    public l i() {
        byte b4;
        int i4 = 0;
        while (true) {
            byte[] bArr = this.f13359a;
            if (i4 >= bArr.length) {
                return this;
            }
            byte b5 = bArr[i4];
            byte b6 = (byte) 65;
            if (b5 >= b6 && b5 <= (b4 = (byte) 90)) {
                byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
                Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(this, size)");
                bArrCopyOf[i4] = (byte) (b5 + 32);
                for (int i5 = i4 + 1; i5 < bArrCopyOf.length; i5++) {
                    byte b7 = bArrCopyOf[i5];
                    if (b7 >= b6 && b7 <= b4) {
                        bArrCopyOf[i5] = (byte) (b7 + 32);
                    }
                }
                return new l(bArrCopyOf);
            }
            i4++;
        }
    }

    public final String j() {
        String str = this.f13361c;
        if (str != null) {
            return str;
        }
        byte[] bArrE = e();
        Intrinsics.checkNotNullParameter(bArrE, "<this>");
        String str2 = new String(bArrE, Charsets.UTF_8);
        this.f13361c = str2;
        return str2;
    }

    public void k(C0694i buffer, int i4) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        buffer.S(0, i4, this.f13359a);
    }

    public String toString() {
        byte b4;
        int i4;
        l lVar = this;
        byte[] bArr = lVar.f13359a;
        if (bArr.length == 0) {
            return "[size=0]";
        }
        int length = bArr.length;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        loop0: while (true) {
            if (i5 >= length) {
                break;
            }
            byte b5 = bArr[i5];
            if (b5 >= 0) {
                int i8 = i7 + 1;
                if (i7 == 64) {
                    break;
                }
                if ((b5 != 10 && b5 != 13 && ((b5 >= 0 && b5 < 32) || (127 <= b5 && b5 < 160))) || b5 == 65533) {
                    break;
                }
                i6 += b5 < 65536 ? 1 : 2;
                i5++;
                while (true) {
                    i7 = i8;
                    if (i5 < length && (b4 = bArr[i5]) >= 0) {
                        i5++;
                        i8 = i7 + 1;
                        if (i7 == 64) {
                            break loop0;
                        }
                        if ((b4 != 10 && b4 != 13 && ((b4 >= 0 && b4 < 32) || (127 <= b4 && b4 < 160))) || b4 == 65533) {
                            break loop0;
                        }
                        i6 += b4 < 65536 ? 1 : 2;
                    } else {
                        break;
                    }
                }
            } else if ((b5 >> 5) == -2) {
                int i9 = i5 + 1;
                if (length > i9) {
                    byte b6 = bArr[i9];
                    if ((b6 & 192) == 128) {
                        int i10 = (b6 ^ ByteCompanionObject.MIN_VALUE) ^ (b5 << 6);
                        if (i10 >= 128) {
                            i4 = i7 + 1;
                            if (i7 == 64) {
                                break;
                            }
                            if ((i10 != 10 && i10 != 13 && ((i10 >= 0 && i10 < 32) || (127 <= i10 && i10 < 160))) || i10 == 65533) {
                                break;
                            }
                            i6 += i10 < 65536 ? 1 : 2;
                            i5 += 2;
                            i7 = i4;
                        } else if (i7 != 64) {
                            break;
                        }
                    } else if (i7 != 64) {
                        break;
                    }
                } else if (i7 != 64) {
                    break;
                }
            } else if ((b5 >> 4) == -2) {
                int i11 = i5 + 2;
                if (length > i11) {
                    byte b7 = bArr[i5 + 1];
                    if ((b7 & 192) == 128) {
                        byte b8 = bArr[i11];
                        if ((b8 & 192) == 128) {
                            int i12 = ((b8 ^ ByteCompanionObject.MIN_VALUE) ^ (b7 << 6)) ^ (b5 << 12);
                            if (i12 < 2048) {
                                if (i7 != 64) {
                                    break;
                                }
                            } else if (55296 > i12 || i12 >= 57344) {
                                i4 = i7 + 1;
                                if (i7 == 64) {
                                    break;
                                }
                                if ((i12 != 10 && i12 != 13 && ((i12 >= 0 && i12 < 32) || (127 <= i12 && i12 < 160))) || i12 == 65533) {
                                    break;
                                }
                                i6 += i12 < 65536 ? 1 : 2;
                                i5 += 3;
                                i7 = i4;
                            } else if (i7 != 64) {
                                break;
                            }
                        } else if (i7 != 64) {
                            break;
                        }
                    } else if (i7 != 64) {
                        break;
                    }
                } else if (i7 != 64) {
                    break;
                }
            } else if ((b5 >> 3) == -2) {
                int i13 = i5 + 3;
                if (length > i13) {
                    byte b9 = bArr[i5 + 1];
                    if ((b9 & 192) == 128) {
                        byte b10 = bArr[i5 + 2];
                        if ((b10 & 192) == 128) {
                            byte b11 = bArr[i13];
                            if ((b11 & 192) == 128) {
                                int i14 = (((b11 ^ ByteCompanionObject.MIN_VALUE) ^ (b10 << 6)) ^ (b9 << 12)) ^ (b5 << 18);
                                if (i14 > 1114111) {
                                    if (i7 != 64) {
                                        break;
                                    }
                                } else if (55296 > i14 || i14 >= 57344) {
                                    if (i14 >= 65536) {
                                        i4 = i7 + 1;
                                        if (i7 == 64) {
                                            break;
                                        }
                                        if ((i14 != 10 && i14 != 13 && ((i14 >= 0 && i14 < 32) || (127 <= i14 && i14 < 160))) || i14 == 65533) {
                                            break;
                                        }
                                        i6 += i14 < 65536 ? 1 : 2;
                                        i5 += 4;
                                        i7 = i4;
                                    } else if (i7 != 64) {
                                        break;
                                    }
                                } else if (i7 != 64) {
                                    break;
                                }
                            } else if (i7 != 64) {
                                break;
                            }
                        } else if (i7 != 64) {
                            break;
                        }
                    } else if (i7 != 64) {
                        break;
                    }
                } else if (i7 != 64) {
                    break;
                }
            } else if (i7 != 64) {
                break;
            }
        }
        i6 = -1;
        if (i6 != -1) {
            String strJ = j();
            String strSubstring = strJ.substring(0, i6);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            String strS = StringsKt.s(StringsKt.s(StringsKt.s(strSubstring, "\\", "\\\\"), "\n", "\\n"), "\r", "\\r");
            if (i6 >= strJ.length()) {
                return "[text=" + strS + ']';
            }
            return "[size=" + bArr.length + " text=" + strS + "…]";
        }
        if (bArr.length <= 64) {
            return "[hex=" + d() + ']';
        }
        StringBuilder sb = new StringBuilder("[size=");
        sb.append(bArr.length);
        sb.append(" hex=");
        Intrinsics.checkNotNullParameter(lVar, "<this>");
        if (64 > bArr.length) {
            throw new IllegalArgumentException(B0.g.o(new StringBuilder("endIndex > length("), bArr.length, CoreConstants.RIGHT_PARENTHESIS_CHAR).toString());
        }
        if (64 != bArr.length) {
            lVar = new l(ArraysKt.copyOfRange(bArr, 0, 64));
        }
        sb.append(lVar.d());
        sb.append("…]");
        return sb.toString();
    }
}
