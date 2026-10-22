package org.bouncycastle.util;

import org.bouncycastle.crypto.digests.Blake2xsDigest;

/* loaded from: classes.dex */
public class IPAddress {
    private static boolean isParseable(String str, int i8, int i9, int i10, int i11, boolean z, int i12, int i13) {
        int i14 = i9 - i8;
        if ((i14 > i11) || (i14 < 1)) {
            return false;
        }
        if (((i14 > 1) && (!z)) && Character.digit(str.charAt(i8), i10) <= 0) {
            return false;
        }
        int i15 = 0;
        while (i8 < i9) {
            int i16 = i8 + 1;
            int iDigit = Character.digit(str.charAt(i8), i10);
            if (iDigit < 0) {
                return false;
            }
            i15 = (i15 * i10) + iDigit;
            i8 = i16;
        }
        return (i15 >= i12) & (i15 <= i13);
    }

    private static boolean isParseableIPv4Mask(String str) {
        return isParseable(str, 0, str.length(), 10, 2, false, 0, 32);
    }

    private static boolean isParseableIPv4Octet(String str, int i8, int i9) {
        return isParseable(str, i8, i9, 10, 3, true, 0, 255);
    }

    private static boolean isParseableIPv6Mask(String str) {
        return isParseable(str, 0, str.length(), 10, 3, false, 1, 128);
    }

    private static boolean isParseableIPv6Segment(String str, int i8, int i9) {
        return isParseable(str, i8, i9, 16, 4, true, 0, Blake2xsDigest.UNKNOWN_DIGEST_LENGTH);
    }

    public static boolean isValid(String str) {
        return isValidIPv4(str) || isValidIPv6(str);
    }

    public static boolean isValidIPv4(String str) {
        int length = str.length();
        if (length < 7 || length > 15) {
            return false;
        }
        int i8 = 0;
        for (int i9 = 0; i9 < 3; i9++) {
            int iIndexOf = str.indexOf(46, i8);
            if (!isParseableIPv4Octet(str, i8, iIndexOf)) {
                return false;
            }
            i8 = iIndexOf + 1;
        }
        return isParseableIPv4Octet(str, i8, length);
    }

    public static boolean isValidIPv4WithNetmask(String str) {
        int iIndexOf = str.indexOf("/");
        if (iIndexOf < 1) {
            return false;
        }
        String strSubstring = str.substring(0, iIndexOf);
        String strSubstring2 = str.substring(iIndexOf + 1);
        return isValidIPv4(strSubstring) && (isValidIPv4(strSubstring2) || isParseableIPv4Mask(strSubstring2));
    }

    public static boolean isValidIPv6(String str) {
        int iIndexOf;
        if (str.length() == 0) {
            return false;
        }
        char cCharAt = str.charAt(0);
        if (cCharAt != ':' && Character.digit(cCharAt, 16) < 0) {
            return false;
        }
        String strConcat = str.concat(":");
        int i8 = 0;
        int i9 = 0;
        boolean z = false;
        while (i8 < strConcat.length() && (iIndexOf = strConcat.indexOf(58, i8)) >= i8) {
            if (i9 == 8) {
                return false;
            }
            if (i8 != iIndexOf) {
                String strSubstring = strConcat.substring(i8, iIndexOf);
                if (iIndexOf == strConcat.length() - 1 && strSubstring.indexOf(46) > 0) {
                    i9++;
                    if (i9 == 8 || !isValidIPv4(strSubstring)) {
                        return false;
                    }
                } else if (!isParseableIPv6Segment(strConcat, i8, iIndexOf)) {
                    return false;
                }
            } else {
                if (iIndexOf != 1 && iIndexOf != strConcat.length() - 1 && z) {
                    return false;
                }
                z = true;
            }
            i8 = iIndexOf + 1;
            i9++;
        }
        return i9 == 8 || z;
    }

    public static boolean isValidIPv6WithNetmask(String str) {
        int iIndexOf = str.indexOf("/");
        if (iIndexOf < 1) {
            return false;
        }
        String strSubstring = str.substring(0, iIndexOf);
        String strSubstring2 = str.substring(iIndexOf + 1);
        return isValidIPv6(strSubstring) && (isValidIPv6(strSubstring2) || isParseableIPv6Mask(strSubstring2));
    }

    public static boolean isValidWithNetMask(String str) {
        return isValidIPv4WithNetmask(str) || isValidIPv6WithNetmask(str);
    }
}
