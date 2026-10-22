package com.fasterxml.jackson.core.io;

import androidx.collection.SieveCacheKt;
import com.fasterxml.jackson.core.io.schubfach.DoubleToDecimal;
import com.fasterxml.jackson.core.io.schubfach.FloatToDecimal;

/* loaded from: classes2.dex */
public final class NumberOutput {
    private static int BILLION = 1000000000;
    private static long BILLION_L = 1000000000;
    private static long MAX_INT_AS_LONG = 2147483647L;
    private static int MILLION = 1000000;
    private static long MIN_INT_AS_LONG = -2147483648L;
    static final String SMALLEST_INT = String.valueOf(Integer.MIN_VALUE);
    static final String SMALLEST_LONG = String.valueOf(Long.MIN_VALUE);
    private static final int[] TRIPLET_TO_CHARS = new int[1000];
    private static final String[] sSmallIntStrs;
    private static final String[] sSmallIntStrs2;

    static {
        int i = 0;
        for (int i6 = 0; i6 < 10; i6++) {
            for (int i10 = 0; i10 < 10; i10++) {
                int i11 = 0;
                while (i11 < 10) {
                    TRIPLET_TO_CHARS[i] = ((i6 + 48) << 16) | ((i10 + 48) << 8) | (i11 + 48);
                    i11++;
                    i++;
                }
            }
        }
        sSmallIntStrs = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        sSmallIntStrs2 = new String[]{"-1", "-2", "-3", "-4", "-5", "-6", "-7", "-8", "-9", "-10"};
    }

    private static int _full3(int i, char[] cArr, int i6) {
        int i10 = TRIPLET_TO_CHARS[i];
        cArr[i6] = (char) (i10 >> 16);
        int i11 = i6 + 2;
        cArr[i6 + 1] = (char) ((i10 >> 8) & 127);
        int i12 = i6 + 3;
        cArr[i11] = (char) (i10 & 127);
        return i12;
    }

    private static int _leading3(int i, char[] cArr, int i6) {
        int i10 = TRIPLET_TO_CHARS[i];
        if (i > 9) {
            if (i > 99) {
                cArr[i6] = (char) (i10 >> 16);
                i6++;
            }
            cArr[i6] = (char) ((i10 >> 8) & 127);
            i6++;
        }
        int i11 = i6 + 1;
        cArr[i6] = (char) (i10 & 127);
        return i11;
    }

    private static int _outputFullBillion(int i, char[] cArr, int i6) {
        int iDivBy1000 = divBy1000(i);
        int i10 = i - (iDivBy1000 * 1000);
        int iDivBy10002 = divBy1000(iDivBy1000);
        int[] iArr = TRIPLET_TO_CHARS;
        int i11 = iArr[iDivBy10002];
        cArr[i6] = (char) (i11 >> 16);
        cArr[i6 + 1] = (char) ((i11 >> 8) & 127);
        cArr[i6 + 2] = (char) (i11 & 127);
        int i12 = iArr[iDivBy1000 - (iDivBy10002 * 1000)];
        cArr[i6 + 3] = (char) (i12 >> 16);
        cArr[i6 + 4] = (char) ((i12 >> 8) & 127);
        cArr[i6 + 5] = (char) (i12 & 127);
        int i13 = iArr[i10];
        cArr[i6 + 6] = (char) (i13 >> 16);
        int i14 = i6 + 8;
        cArr[i6 + 7] = (char) ((i13 >> 8) & 127);
        int i15 = i6 + 9;
        cArr[i14] = (char) (i13 & 127);
        return i15;
    }

    private static int _outputSmallestI(char[] cArr, int i) {
        String str = SMALLEST_INT;
        int length = str.length();
        str.getChars(0, length, cArr, i);
        return length + i;
    }

    private static int _outputSmallestL(char[] cArr, int i) {
        String str = SMALLEST_LONG;
        int length = str.length();
        str.getChars(0, length, cArr, i);
        return length + i;
    }

    private static int _outputUptoBillion(int i, char[] cArr, int i6) {
        if (i < MILLION) {
            if (i < 1000) {
                return _leading3(i, cArr, i6);
            }
            int iDivBy1000 = divBy1000(i);
            return _outputUptoMillion(cArr, i6, iDivBy1000, i - (iDivBy1000 * 1000));
        }
        int iDivBy10002 = divBy1000(i);
        int i10 = i - (iDivBy10002 * 1000);
        int iDivBy10003 = divBy1000(iDivBy10002);
        int i11 = iDivBy10002 - (iDivBy10003 * 1000);
        int i_leading3 = _leading3(iDivBy10003, cArr, i6);
        int[] iArr = TRIPLET_TO_CHARS;
        int i12 = iArr[i11];
        cArr[i_leading3] = (char) (i12 >> 16);
        cArr[i_leading3 + 1] = (char) ((i12 >> 8) & 127);
        cArr[i_leading3 + 2] = (char) (i12 & 127);
        int i13 = iArr[i10];
        cArr[i_leading3 + 3] = (char) (i13 >> 16);
        int i14 = i_leading3 + 5;
        cArr[i_leading3 + 4] = (char) ((i13 >> 8) & 127);
        int i15 = i_leading3 + 6;
        cArr[i14] = (char) (i13 & 127);
        return i15;
    }

    private static int _outputUptoMillion(char[] cArr, int i, int i6, int i10) {
        int[] iArr = TRIPLET_TO_CHARS;
        int i11 = iArr[i6];
        if (i6 > 9) {
            if (i6 > 99) {
                cArr[i] = (char) (i11 >> 16);
                i++;
            }
            cArr[i] = (char) ((i11 >> 8) & 127);
            i++;
        }
        cArr[i] = (char) (i11 & 127);
        int i12 = iArr[i10];
        cArr[i + 1] = (char) (i12 >> 16);
        int i13 = i + 3;
        cArr[i + 2] = (char) ((i12 >> 8) & 127);
        int i14 = i + 4;
        cArr[i13] = (char) (i12 & 127);
        return i14;
    }

    public static int divBy1000(int i) {
        return (int) ((i * 274877907) >>> 38);
    }

    public static boolean notFinite(double d) {
        return !Double.isFinite(d);
    }

    public static int outputInt(int i, char[] cArr, int i6) {
        int i10;
        if (i < 0) {
            if (i == Integer.MIN_VALUE) {
                return _outputSmallestI(cArr, i6);
            }
            cArr[i6] = '-';
            i = -i;
            i6++;
        }
        if (i < MILLION) {
            if (i >= 1000) {
                int iDivBy1000 = divBy1000(i);
                return _full3(i - (iDivBy1000 * 1000), cArr, _leading3(iDivBy1000, cArr, i6));
            }
            if (i >= 10) {
                return _leading3(i, cArr, i6);
            }
            cArr[i6] = (char) (i + 48);
            return i6 + 1;
        }
        int i11 = BILLION;
        if (i < i11) {
            int iDivBy10002 = divBy1000(i);
            int i12 = i - (iDivBy10002 * 1000);
            int iDivBy10003 = divBy1000(iDivBy10002);
            return _full3(i12, cArr, _full3(iDivBy10002 - (iDivBy10003 * 1000), cArr, _leading3(iDivBy10003, cArr, i6)));
        }
        int i13 = i - i11;
        if (i13 >= i11) {
            i13 -= i11;
            i10 = i6 + 1;
            cArr[i6] = '2';
        } else {
            i10 = i6 + 1;
            cArr[i6] = '1';
        }
        return _outputFullBillion(i13, cArr, i10);
    }

    public static int outputLong(long j5, char[] cArr, int i) {
        int i_outputFullBillion;
        if (j5 < 0) {
            if (j5 > MIN_INT_AS_LONG) {
                return outputInt((int) j5, cArr, i);
            }
            if (j5 == Long.MIN_VALUE) {
                return _outputSmallestL(cArr, i);
            }
            cArr[i] = '-';
            j5 = -j5;
            i++;
        } else if (j5 <= MAX_INT_AS_LONG) {
            return outputInt((int) j5, cArr, i);
        }
        long j6 = BILLION_L;
        long j10 = j5 / j6;
        long j11 = j5 - (j10 * j6);
        if (j10 < j6) {
            i_outputFullBillion = _outputUptoBillion((int) j10, cArr, i);
        } else {
            long j12 = j10 / j6;
            int i_leading3 = _leading3((int) j12, cArr, i);
            i_outputFullBillion = _outputFullBillion((int) (j10 - (j6 * j12)), cArr, i_leading3);
        }
        return _outputFullBillion((int) j11, cArr, i_outputFullBillion);
    }

    public static String toString(int i) {
        String[] strArr = sSmallIntStrs;
        if (i < strArr.length) {
            if (i >= 0) {
                return strArr[i];
            }
            int i6 = (-i) - 1;
            String[] strArr2 = sSmallIntStrs2;
            if (i6 < strArr2.length) {
                return strArr2[i6];
            }
        }
        return Integer.toString(i);
    }

    public static boolean notFinite(float f) {
        return !Float.isFinite(f);
    }

    private static int _outputSmallestI(byte[] bArr, int i) {
        int length = SMALLEST_INT.length();
        int i6 = 0;
        while (i6 < length) {
            bArr[i] = (byte) SMALLEST_INT.charAt(i6);
            i6++;
            i++;
        }
        return i;
    }

    private static int _outputSmallestL(byte[] bArr, int i) {
        int length = SMALLEST_LONG.length();
        int i6 = 0;
        while (i6 < length) {
            bArr[i] = (byte) SMALLEST_LONG.charAt(i6);
            i6++;
            i++;
        }
        return i;
    }

    private static int _full3(int i, byte[] bArr, int i6) {
        int i10 = TRIPLET_TO_CHARS[i];
        bArr[i6] = (byte) (i10 >> 16);
        int i11 = i6 + 2;
        bArr[i6 + 1] = (byte) (i10 >> 8);
        int i12 = i6 + 3;
        bArr[i11] = (byte) i10;
        return i12;
    }

    private static int _leading3(int i, byte[] bArr, int i6) {
        int i10 = TRIPLET_TO_CHARS[i];
        if (i > 9) {
            if (i > 99) {
                bArr[i6] = (byte) (i10 >> 16);
                i6++;
            }
            bArr[i6] = (byte) (i10 >> 8);
            i6++;
        }
        int i11 = i6 + 1;
        bArr[i6] = (byte) i10;
        return i11;
    }

    public static String toString(long j5) {
        if (j5 <= SieveCacheKt.NodeLinkMask && j5 >= SieveCacheKt.NodeMetaAndPreviousMask) {
            return toString((int) j5);
        }
        return Long.toString(j5);
    }

    public static String toString(double d) {
        return toString(d, false);
    }

    private static int _outputUptoMillion(byte[] bArr, int i, int i6, int i10) {
        int[] iArr = TRIPLET_TO_CHARS;
        int i11 = iArr[i6];
        if (i6 > 9) {
            if (i6 > 99) {
                bArr[i] = (byte) (i11 >> 16);
                i++;
            }
            bArr[i] = (byte) (i11 >> 8);
            i++;
        }
        bArr[i] = (byte) i11;
        int i12 = iArr[i10];
        bArr[i + 1] = (byte) (i12 >> 16);
        int i13 = i + 3;
        bArr[i + 2] = (byte) (i12 >> 8);
        int i14 = i + 4;
        bArr[i13] = (byte) i12;
        return i14;
    }

    public static String toString(double d, boolean z10) {
        return z10 ? DoubleToDecimal.toString(d) : Double.toString(d);
    }

    public static String toString(float f) {
        return toString(f, false);
    }

    public static String toString(float f, boolean z10) {
        return z10 ? FloatToDecimal.toString(f) : Float.toString(f);
    }

    public static int outputLong(long j5, byte[] bArr, int i) {
        int i_outputFullBillion;
        if (j5 < 0) {
            if (j5 > MIN_INT_AS_LONG) {
                return outputInt((int) j5, bArr, i);
            }
            if (j5 == Long.MIN_VALUE) {
                return _outputSmallestL(bArr, i);
            }
            bArr[i] = 45;
            j5 = -j5;
            i++;
        } else if (j5 <= MAX_INT_AS_LONG) {
            return outputInt((int) j5, bArr, i);
        }
        long j6 = BILLION_L;
        long j10 = j5 / j6;
        long j11 = j5 - (j10 * j6);
        if (j10 < j6) {
            i_outputFullBillion = _outputUptoBillion((int) j10, bArr, i);
        } else {
            long j12 = j10 / j6;
            int i_leading3 = _leading3((int) j12, bArr, i);
            i_outputFullBillion = _outputFullBillion((int) (j10 - (j6 * j12)), bArr, i_leading3);
        }
        return _outputFullBillion((int) j11, bArr, i_outputFullBillion);
    }

    private static int _outputFullBillion(int i, byte[] bArr, int i6) {
        int iDivBy1000 = divBy1000(i);
        int i10 = i - (iDivBy1000 * 1000);
        int iDivBy10002 = divBy1000(iDivBy1000);
        int i11 = iDivBy1000 - (iDivBy10002 * 1000);
        int[] iArr = TRIPLET_TO_CHARS;
        int i12 = iArr[iDivBy10002];
        bArr[i6] = (byte) (i12 >> 16);
        bArr[i6 + 1] = (byte) (i12 >> 8);
        bArr[i6 + 2] = (byte) i12;
        int i13 = iArr[i11];
        bArr[i6 + 3] = (byte) (i13 >> 16);
        bArr[i6 + 4] = (byte) (i13 >> 8);
        bArr[i6 + 5] = (byte) i13;
        int i14 = iArr[i10];
        bArr[i6 + 6] = (byte) (i14 >> 16);
        int i15 = i6 + 8;
        bArr[i6 + 7] = (byte) (i14 >> 8);
        int i16 = i6 + 9;
        bArr[i15] = (byte) i14;
        return i16;
    }

    private static int _outputUptoBillion(int i, byte[] bArr, int i6) {
        if (i < MILLION) {
            if (i < 1000) {
                return _leading3(i, bArr, i6);
            }
            int iDivBy1000 = divBy1000(i);
            return _outputUptoMillion(bArr, i6, iDivBy1000, i - (iDivBy1000 * 1000));
        }
        int iDivBy10002 = divBy1000(i);
        int i10 = i - (iDivBy10002 * 1000);
        int iDivBy10003 = divBy1000(iDivBy10002);
        int i11 = iDivBy10002 - (iDivBy10003 * 1000);
        int i_leading3 = _leading3(iDivBy10003, bArr, i6);
        int[] iArr = TRIPLET_TO_CHARS;
        int i12 = iArr[i11];
        bArr[i_leading3] = (byte) (i12 >> 16);
        bArr[i_leading3 + 1] = (byte) (i12 >> 8);
        bArr[i_leading3 + 2] = (byte) i12;
        int i13 = iArr[i10];
        bArr[i_leading3 + 3] = (byte) (i13 >> 16);
        int i14 = i_leading3 + 5;
        bArr[i_leading3 + 4] = (byte) (i13 >> 8);
        int i15 = i_leading3 + 6;
        bArr[i14] = (byte) i13;
        return i15;
    }

    public static int outputInt(int i, byte[] bArr, int i6) {
        int i10;
        if (i < 0) {
            if (i == Integer.MIN_VALUE) {
                return _outputSmallestI(bArr, i6);
            }
            bArr[i6] = 45;
            i = -i;
            i6++;
        }
        if (i < MILLION) {
            if (i >= 1000) {
                int iDivBy1000 = divBy1000(i);
                return _full3(i - (iDivBy1000 * 1000), bArr, _leading3(iDivBy1000, bArr, i6));
            }
            if (i < 10) {
                int i11 = i6 + 1;
                bArr[i6] = (byte) (i + 48);
                return i11;
            }
            return _leading3(i, bArr, i6);
        }
        int i12 = BILLION;
        if (i >= i12) {
            int i13 = i - i12;
            if (i13 >= i12) {
                i13 -= i12;
                i10 = i6 + 1;
                bArr[i6] = 50;
            } else {
                i10 = i6 + 1;
                bArr[i6] = 49;
            }
            return _outputFullBillion(i13, bArr, i10);
        }
        int iDivBy10002 = divBy1000(i);
        int i14 = i - (iDivBy10002 * 1000);
        int iDivBy10003 = divBy1000(iDivBy10002);
        return _full3(i14, bArr, _full3(iDivBy10002 - (iDivBy10003 * 1000), bArr, _leading3(iDivBy10003, bArr, i6)));
    }
}
