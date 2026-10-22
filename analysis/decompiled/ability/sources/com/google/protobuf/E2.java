package com.google.protobuf;

import androidx.collection.SieveCacheKt;
import com.google.protobuf.ByteString;
import java.lang.Character;
import java.math.BigInteger;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public abstract class E2 {

    /* renamed from: a, reason: collision with root package name */
    public static final Logger f2828a = Logger.getLogger(E2.class.getName());

    static {
        int i = G2.b;
        G2 g22 = F2.f2830a;
    }

    public static int a(byte b) {
        return (48 > b || b > 57) ? (97 > b || b > 122) ? b - 55 : b - 87 : b - 48;
    }

    public static boolean b(byte b) {
        if (48 <= b && b <= 57) {
            return true;
        }
        if (97 > b || b > 102) {
            return 65 <= b && b <= 70;
        }
        return true;
    }

    public static long c(String str, boolean z10, boolean z11) throws NumberFormatException {
        int i;
        int i6 = 0;
        if (str.startsWith("-", 0)) {
            if (!z10) {
                throw new NumberFormatException("Number must be positive: ".concat(str));
            }
            i6 = 1;
        }
        int i10 = i6;
        if (str.startsWith("0x", i6)) {
            i6 += 2;
            i = 16;
        } else {
            i = str.startsWith("0", i6) ? 8 : 10;
        }
        String strSubstring = str.substring(i6);
        if (strSubstring.length() < 16) {
            long j5 = Long.parseLong(strSubstring, i);
            if (i10 != 0) {
                j5 = -j5;
            }
            if (!z11) {
                if (z10) {
                    if (j5 > SieveCacheKt.NodeLinkMask || j5 < SieveCacheKt.NodeMetaAndPreviousMask) {
                        throw new NumberFormatException("Number out of range for 32-bit signed integer: ".concat(str));
                    }
                } else if (j5 >= 4294967296L || j5 < 0) {
                    throw new NumberFormatException("Number out of range for 32-bit unsigned integer: ".concat(str));
                }
            }
            return j5;
        }
        BigInteger bigInteger = new BigInteger(strSubstring, i);
        if (i10 != 0) {
            bigInteger = bigInteger.negate();
        }
        if (z11) {
            if (z10) {
                if (bigInteger.bitLength() > 63) {
                    throw new NumberFormatException("Number out of range for 64-bit signed integer: ".concat(str));
                }
            } else if (bigInteger.bitLength() > 64) {
                throw new NumberFormatException("Number out of range for 64-bit unsigned integer: ".concat(str));
            }
        } else if (z10) {
            if (bigInteger.bitLength() > 31) {
                throw new NumberFormatException("Number out of range for 32-bit signed integer: ".concat(str));
            }
        } else if (bigInteger.bitLength() > 32) {
            throw new NumberFormatException("Number out of range for 32-bit unsigned integer: ".concat(str));
        }
        return bigInteger.longValue();
    }

    public static ByteString d(String str) throws TextFormat$InvalidEscapeSequenceException {
        int i;
        int i6;
        int length;
        int i10;
        byte b;
        byte b5;
        ByteString byteStringF = ByteString.f(str.toString());
        byte[] bArr = ((ByteString.LiteralByteString) byteStringF).d;
        int length2 = bArr.length;
        byte[] bArr2 = new byte[length2];
        int i11 = 0;
        int i12 = 0;
        while (i11 < bArr.length) {
            byte b10 = bArr[i11];
            if (b10 == 92) {
                int i13 = i11 + 1;
                if (i13 >= bArr.length) {
                    throw new TextFormat$InvalidEscapeSequenceException("Invalid escape sequence: '\\' at end of string.");
                }
                byte b11 = bArr[i13];
                if (48 > b11 || b11 > 55) {
                    if (b11 == 34) {
                        i = i12 + 1;
                        bArr2[i12] = 34;
                    } else if (b11 == 39) {
                        i = i12 + 1;
                        bArr2[i12] = 39;
                    } else if (b11 != 63) {
                        if (b11 == 85) {
                            int i14 = i11 + 2;
                            i6 = i11 + 9;
                            if (i6 >= bArr.length) {
                                throw new TextFormat$InvalidEscapeSequenceException("Invalid escape sequence: '\\U' with too few hex chars");
                            }
                            int iA = 0;
                            int i15 = i14;
                            while (true) {
                                int i16 = i11 + 10;
                                if (i15 < i16) {
                                    byte b12 = bArr[i15];
                                    if (!b(b12)) {
                                        throw new TextFormat$InvalidEscapeSequenceException("Invalid escape sequence: '\\U' with too few hex chars");
                                    }
                                    iA = (iA << 4) | a(b12);
                                    i15++;
                                } else {
                                    if (!Character.isValidCodePoint(iA)) {
                                        throw new TextFormat$InvalidEscapeSequenceException("Invalid escape sequence: '\\U" + byteStringF.n(i14, i16).q() + "' is not a valid code point value");
                                    }
                                    Character.UnicodeBlock unicodeBlockOf = Character.UnicodeBlock.of(iA);
                                    if (unicodeBlockOf != null && (unicodeBlockOf.equals(Character.UnicodeBlock.LOW_SURROGATES) || unicodeBlockOf.equals(Character.UnicodeBlock.HIGH_SURROGATES) || unicodeBlockOf.equals(Character.UnicodeBlock.HIGH_PRIVATE_USE_SURROGATES))) {
                                        throw new TextFormat$InvalidEscapeSequenceException("Invalid escape sequence: '\\U" + byteStringF.n(i14, i16).q() + "' refers to a surrogate code unit");
                                    }
                                    byte[] bytes = new String(new int[]{iA}, 0, 1).getBytes(AbstractC0989s1.f2940a);
                                    System.arraycopy(bytes, 0, bArr2, i12, bytes.length);
                                    length = bytes.length;
                                }
                            }
                        } else if (b11 == 92) {
                            i = i12 + 1;
                            bArr2[i12] = 92;
                        } else if (b11 == 102) {
                            i = i12 + 1;
                            bArr2[i12] = 12;
                        } else if (b11 == 110) {
                            i = i12 + 1;
                            bArr2[i12] = 10;
                        } else if (b11 == 114) {
                            i = i12 + 1;
                            bArr2[i12] = 13;
                        } else if (b11 == 120) {
                            int i17 = i11 + 2;
                            if (i17 >= bArr.length || !b(bArr[i17])) {
                                throw new TextFormat$InvalidEscapeSequenceException("Invalid escape sequence: '\\x' with no digits");
                            }
                            int iA2 = a(bArr[i17]);
                            i11 += 3;
                            if (i11 >= bArr.length || !b(bArr[i11])) {
                                i11 = i17;
                            } else {
                                iA2 = (iA2 * 16) + a(bArr[i11]);
                            }
                            i10 = i12 + 1;
                            bArr2[i12] = (byte) iA2;
                        } else if (b11 == 97) {
                            i = i12 + 1;
                            bArr2[i12] = 7;
                        } else if (b11 != 98) {
                            switch (b11) {
                                case 116:
                                    i = i12 + 1;
                                    bArr2[i12] = 9;
                                    break;
                                case 117:
                                    int i18 = i11 + 2;
                                    i6 = i11 + 5;
                                    if (i6 < bArr.length && b(bArr[i18])) {
                                        int i19 = i11 + 3;
                                        if (b(bArr[i19])) {
                                            int i20 = i11 + 4;
                                            if (b(bArr[i20]) && b(bArr[i6])) {
                                                char cA = (char) ((a(bArr[i20]) << 4) | (a(bArr[i18]) << 12) | (a(bArr[i19]) << 8) | a(bArr[i6]));
                                                if (cA >= 55296 && cA <= 57343) {
                                                    throw new TextFormat$InvalidEscapeSequenceException("Invalid escape sequence: '\\u' refers to a surrogate");
                                                }
                                                byte[] bytes2 = Character.toString(cA).getBytes(AbstractC0989s1.f2940a);
                                                System.arraycopy(bytes2, 0, bArr2, i12, bytes2.length);
                                                length = bytes2.length;
                                                break;
                                            }
                                        }
                                    }
                                    throw new TextFormat$InvalidEscapeSequenceException("Invalid escape sequence: '\\u' with too few hex chars");
                                case 118:
                                    i = i12 + 1;
                                    bArr2[i12] = 11;
                                    break;
                                default:
                                    throw new TextFormat$InvalidEscapeSequenceException("Invalid escape sequence: '\\" + ((char) b11) + '\'');
                            }
                        } else {
                            i = i12 + 1;
                            bArr2[i12] = 8;
                        }
                        i12 += length;
                        i11 = i6;
                    } else {
                        i = i12 + 1;
                        bArr2[i12] = 63;
                    }
                    i12 = i;
                    i11 = i13;
                } else {
                    int iA3 = a(b11);
                    int i21 = i11 + 2;
                    if (i21 < bArr.length && 48 <= (b5 = bArr[i21]) && b5 <= 55) {
                        iA3 = (iA3 * 8) + a(b5);
                        i13 = i21;
                    }
                    i11 = i13 + 1;
                    if (i11 >= bArr.length || 48 > (b = bArr[i11]) || b > 55) {
                        i11 = i13;
                    } else {
                        iA3 = (iA3 * 8) + a(b);
                    }
                    i10 = i12 + 1;
                    bArr2[i12] = (byte) iA3;
                }
                i12 = i10;
            } else {
                bArr2[i12] = b10;
                i12++;
            }
            i11++;
        }
        return length2 == i12 ? new ByteString.LiteralByteString(bArr2) : ByteString.e(bArr2, 0, i12);
    }
}
