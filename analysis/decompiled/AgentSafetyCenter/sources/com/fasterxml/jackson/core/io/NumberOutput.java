package com.fasterxml.jackson.core.io;

import com.fasterxml.jackson.core.io.schubfach.DoubleToDecimal;
import com.fasterxml.jackson.core.io.schubfach.FloatToDecimal;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
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
        for (int i3 = 0; i3 < 10; i3++) {
            for (int i10 = 0; i10 < 10; i10++) {
                int i11 = 0;
                while (i11 < 10) {
                    TRIPLET_TO_CHARS[i] = ((i3 + 48) << 16) | ((i10 + 48) << 8) | (i11 + 48);
                    i11++;
                    i++;
                }
            }
        }
        sSmallIntStrs = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        sSmallIntStrs2 = new String[]{"-1", "-2", "-3", "-4", "-5", "-6", "-7", "-8", "-9", "-10"};
    }

    private static int _full3(int i, char[] cArr, int i3) {
        int i10 = TRIPLET_TO_CHARS[i];
        cArr[i3] = (char) (i10 >> 16);
        int i11 = i3 + 2;
        cArr[i3 + 1] = (char) ((i10 >> 8) & 127);
        int i12 = i3 + 3;
        cArr[i11] = (char) (i10 & 127);
        return i12;
    }

    private static int _leading3(int i, char[] cArr, int i3) {
        int i10 = TRIPLET_TO_CHARS[i];
        if (i > 9) {
            if (i > 99) {
                cArr[i3] = (char) (i10 >> 16);
                i3++;
            }
            cArr[i3] = (char) ((i10 >> 8) & 127);
            i3++;
        }
        int i11 = i3 + 1;
        cArr[i3] = (char) (i10 & 127);
        return i11;
    }

    private static int _outputFullBillion(int i, char[] cArr, int i3) {
        int iDivBy1000 = divBy1000(i);
        int i10 = i - (iDivBy1000 * 1000);
        int iDivBy10002 = divBy1000(iDivBy1000);
        int[] iArr = TRIPLET_TO_CHARS;
        int i11 = iArr[iDivBy10002];
        cArr[i3] = (char) (i11 >> 16);
        cArr[i3 + 1] = (char) ((i11 >> 8) & 127);
        cArr[i3 + 2] = (char) (i11 & 127);
        int i12 = iArr[iDivBy1000 - (iDivBy10002 * 1000)];
        cArr[i3 + 3] = (char) (i12 >> 16);
        cArr[i3 + 4] = (char) ((i12 >> 8) & 127);
        cArr[i3 + 5] = (char) (i12 & 127);
        int i13 = iArr[i10];
        cArr[i3 + 6] = (char) (i13 >> 16);
        int i14 = i3 + 8;
        cArr[i3 + 7] = (char) ((i13 >> 8) & 127);
        int i15 = i3 + 9;
        cArr[i14] = (char) (i13 & 127);
        return i15;
    }

    private static int _outputSmallestI(byte[] bArr, int i) {
        int length = SMALLEST_INT.length();
        int i3 = 0;
        while (i3 < length) {
            bArr[i] = (byte) SMALLEST_INT.charAt(i3);
            i3++;
            i++;
        }
        return i;
    }

    private static int _outputSmallestL(byte[] bArr, int i) {
        int length = SMALLEST_LONG.length();
        int i3 = 0;
        while (i3 < length) {
            bArr[i] = (byte) SMALLEST_LONG.charAt(i3);
            i3++;
            i++;
        }
        return i;
    }

    private static int _outputUptoBillion(int i, char[] cArr, int i3) {
        if (i < MILLION) {
            if (i < 1000) {
                return _leading3(i, cArr, i3);
            }
            int iDivBy1000 = divBy1000(i);
            return _outputUptoMillion(cArr, i3, iDivBy1000, i - (iDivBy1000 * 1000));
        }
        int iDivBy10002 = divBy1000(i);
        int i10 = i - (iDivBy10002 * 1000);
        int iDivBy10003 = divBy1000(iDivBy10002);
        int i11 = iDivBy10002 - (iDivBy10003 * 1000);
        int i_leading3 = _leading3(iDivBy10003, cArr, i3);
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

    private static int _outputUptoMillion(char[] cArr, int i, int i3, int i10) {
        int[] iArr = TRIPLET_TO_CHARS;
        int i11 = iArr[i3];
        if (i3 > 9) {
            if (i3 > 99) {
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

    public static boolean notFinite(double d7) {
        return !Double.isFinite(d7);
    }

    public static int outputInt(int i, char[] cArr, int i3) {
        int i10;
        if (i < 0) {
            if (i == Integer.MIN_VALUE) {
                return _outputSmallestI(cArr, i3);
            }
            cArr[i3] = '-';
            i = -i;
            i3++;
        }
        if (i < MILLION) {
            if (i >= 1000) {
                int iDivBy1000 = divBy1000(i);
                return _full3(i - (iDivBy1000 * 1000), cArr, _leading3(iDivBy1000, cArr, i3));
            }
            if (i >= 10) {
                return _leading3(i, cArr, i3);
            }
            cArr[i3] = (char) (i + 48);
            return i3 + 1;
        }
        int i11 = BILLION;
        if (i < i11) {
            int iDivBy10002 = divBy1000(i);
            int i12 = i - (iDivBy10002 * 1000);
            int iDivBy10003 = divBy1000(iDivBy10002);
            return _full3(i12, cArr, _full3(iDivBy10002 - (iDivBy10003 * 1000), cArr, _leading3(iDivBy10003, cArr, i3)));
        }
        int i13 = i - i11;
        if (i13 >= i11) {
            i13 -= i11;
            i10 = i3 + 1;
            cArr[i3] = '2';
        } else {
            i10 = i3 + 1;
            cArr[i3] = '1';
        }
        return _outputFullBillion(i13, cArr, i10);
    }

    public static int outputLong(long j10, char[] cArr, int i) {
        int i_outputFullBillion;
        if (j10 < 0) {
            if (j10 > MIN_INT_AS_LONG) {
                return outputInt((int) j10, cArr, i);
            }
            if (j10 == Long.MIN_VALUE) {
                return _outputSmallestL(cArr, i);
            }
            cArr[i] = '-';
            j10 = -j10;
            i++;
        } else if (j10 <= MAX_INT_AS_LONG) {
            return outputInt((int) j10, cArr, i);
        }
        long j11 = BILLION_L;
        long j12 = j10 / j11;
        long j13 = j10 - (j12 * j11);
        if (j12 < j11) {
            i_outputFullBillion = _outputUptoBillion((int) j12, cArr, i);
        } else {
            long j14 = j12 / j11;
            int i_leading3 = _leading3((int) j14, cArr, i);
            i_outputFullBillion = _outputFullBillion((int) (j12 - (j11 * j14)), cArr, i_leading3);
        }
        return _outputFullBillion((int) j13, cArr, i_outputFullBillion);
    }

    public static String toString(int i) {
        String[] strArr = sSmallIntStrs;
        if (i < strArr.length) {
            if (i >= 0) {
                return strArr[i];
            }
            int i3 = (-i) - 1;
            String[] strArr2 = sSmallIntStrs2;
            if (i3 < strArr2.length) {
                return strArr2[i3];
            }
        }
        return Integer.toString(i);
    }

    public static boolean notFinite(float f5) {
        return !Float.isFinite(f5);
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

    public static String toString(long j10) {
        if (j10 <= 2147483647L && j10 >= -2147483648L) {
            return toString((int) j10);
        }
        return Long.toString(j10);
    }

    private static int _full3(int i, byte[] bArr, int i3) {
        int i10 = TRIPLET_TO_CHARS[i];
        bArr[i3] = (byte) (i10 >> 16);
        int i11 = i3 + 2;
        bArr[i3 + 1] = (byte) (i10 >> 8);
        int i12 = i3 + 3;
        bArr[i11] = (byte) i10;
        return i12;
    }

    public static String toString(double d7) {
        return toString(d7, false);
    }

    public static String toString(double d7, boolean z10) {
        return z10 ? DoubleToDecimal.toString(d7) : Double.toString(d7);
    }

    public static String toString(float f5) {
        return toString(f5, false);
    }

    public static String toString(float f5, boolean z10) {
        return z10 ? FloatToDecimal.toString(f5) : Float.toString(f5);
    }

    private static int _leading3(int i, byte[] bArr, int i3) {
        int i10 = TRIPLET_TO_CHARS[i];
        if (i > 9) {
            if (i > 99) {
                bArr[i3] = (byte) (i10 >> 16);
                i3++;
            }
            bArr[i3] = (byte) (i10 >> 8);
            i3++;
        }
        int i11 = i3 + 1;
        bArr[i3] = (byte) i10;
        return i11;
    }

    private static int _outputUptoMillion(byte[] bArr, int i, int i3, int i10) {
        int[] iArr = TRIPLET_TO_CHARS;
        int i11 = iArr[i3];
        if (i3 > 9) {
            if (i3 > 99) {
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

    public static int outputLong(long j10, byte[] bArr, int i) {
        int i_outputFullBillion;
        if (j10 < 0) {
            if (j10 > MIN_INT_AS_LONG) {
                return outputInt((int) j10, bArr, i);
            }
            if (j10 == Long.MIN_VALUE) {
                return _outputSmallestL(bArr, i);
            }
            bArr[i] = 45;
            j10 = -j10;
            i++;
        } else if (j10 <= MAX_INT_AS_LONG) {
            return outputInt((int) j10, bArr, i);
        }
        long j11 = BILLION_L;
        long j12 = j10 / j11;
        long j13 = j10 - (j12 * j11);
        if (j12 < j11) {
            i_outputFullBillion = _outputUptoBillion((int) j12, bArr, i);
        } else {
            long j14 = j12 / j11;
            int i_leading3 = _leading3((int) j14, bArr, i);
            i_outputFullBillion = _outputFullBillion((int) (j12 - (j11 * j14)), bArr, i_leading3);
        }
        return _outputFullBillion((int) j13, bArr, i_outputFullBillion);
    }

    private static int _outputFullBillion(int i, byte[] bArr, int i3) {
        int iDivBy1000 = divBy1000(i);
        int i10 = i - (iDivBy1000 * 1000);
        int iDivBy10002 = divBy1000(iDivBy1000);
        int i11 = iDivBy1000 - (iDivBy10002 * 1000);
        int[] iArr = TRIPLET_TO_CHARS;
        int i12 = iArr[iDivBy10002];
        bArr[i3] = (byte) (i12 >> 16);
        bArr[i3 + 1] = (byte) (i12 >> 8);
        bArr[i3 + 2] = (byte) i12;
        int i13 = iArr[i11];
        bArr[i3 + 3] = (byte) (i13 >> 16);
        bArr[i3 + 4] = (byte) (i13 >> 8);
        bArr[i3 + 5] = (byte) i13;
        int i14 = iArr[i10];
        bArr[i3 + 6] = (byte) (i14 >> 16);
        int i15 = i3 + 8;
        bArr[i3 + 7] = (byte) (i14 >> 8);
        int i16 = i3 + 9;
        bArr[i15] = (byte) i14;
        return i16;
    }

    private static int _outputUptoBillion(int i, byte[] bArr, int i3) {
        if (i < MILLION) {
            if (i < 1000) {
                return _leading3(i, bArr, i3);
            }
            int iDivBy1000 = divBy1000(i);
            return _outputUptoMillion(bArr, i3, iDivBy1000, i - (iDivBy1000 * 1000));
        }
        int iDivBy10002 = divBy1000(i);
        int i10 = i - (iDivBy10002 * 1000);
        int iDivBy10003 = divBy1000(iDivBy10002);
        int i11 = iDivBy10002 - (iDivBy10003 * 1000);
        int i_leading3 = _leading3(iDivBy10003, bArr, i3);
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

    public static int outputInt(int i, byte[] bArr, int i3) {
        int i10;
        if (i < 0) {
            if (i == Integer.MIN_VALUE) {
                return _outputSmallestI(bArr, i3);
            }
            bArr[i3] = 45;
            i = -i;
            i3++;
        }
        if (i < MILLION) {
            if (i >= 1000) {
                int iDivBy1000 = divBy1000(i);
                return _full3(i - (iDivBy1000 * 1000), bArr, _leading3(iDivBy1000, bArr, i3));
            }
            if (i < 10) {
                int i11 = i3 + 1;
                bArr[i3] = (byte) (i + 48);
                return i11;
            }
            return _leading3(i, bArr, i3);
        }
        int i12 = BILLION;
        if (i >= i12) {
            int i13 = i - i12;
            if (i13 >= i12) {
                i13 -= i12;
                i10 = i3 + 1;
                bArr[i3] = 50;
            } else {
                i10 = i3 + 1;
                bArr[i3] = 49;
            }
            return _outputFullBillion(i13, bArr, i10);
        }
        int iDivBy10002 = divBy1000(i);
        int i14 = i - (iDivBy10002 * 1000);
        int iDivBy10003 = divBy1000(iDivBy10002);
        return _full3(i14, bArr, _full3(iDivBy10002 - (iDivBy10003 * 1000), bArr, _leading3(iDivBy10003, bArr, i3)));
    }
}
