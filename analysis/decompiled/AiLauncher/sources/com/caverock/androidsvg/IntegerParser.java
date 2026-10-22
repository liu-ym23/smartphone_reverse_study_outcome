package com.caverock.androidsvg;

/* loaded from: classes.dex */
class IntegerParser {
    private int pos;
    private long value;

    public IntegerParser(long j10, int i10) {
        this.value = j10;
        this.pos = i10;
    }

    public static IntegerParser parseHex(String str, int i10, int i11) {
        long j10;
        int i12;
        if (i10 >= i11) {
            return null;
        }
        long j11 = 0;
        int i13 = i10;
        while (i13 < i11) {
            char cCharAt = str.charAt(i13);
            if (cCharAt < '0' || cCharAt > '9') {
                if (cCharAt >= 'A' && cCharAt <= 'F') {
                    j10 = j11 * 16;
                    i12 = cCharAt - 'A';
                } else {
                    if (cCharAt < 'a' || cCharAt > 'f') {
                        break;
                    }
                    j10 = j11 * 16;
                    i12 = cCharAt - 'a';
                }
                j11 = j10 + i12 + 10;
            } else {
                j11 = (j11 * 16) + (cCharAt - '0');
            }
            if (j11 > 4294967295L) {
                return null;
            }
            i13++;
        }
        if (i13 == i10) {
            return null;
        }
        return new IntegerParser(j11, i13);
    }

    public static IntegerParser parseInt(String str, int i10, int i11, boolean z10) {
        if (i10 >= i11) {
            return null;
        }
        boolean z11 = false;
        if (z10) {
            char cCharAt = str.charAt(i10);
            if (cCharAt == '+') {
                i10++;
            } else if (cCharAt == '-') {
                z11 = true;
                i10++;
            }
        }
        long j10 = 0;
        int i12 = i10;
        while (i12 < i11) {
            char cCharAt2 = str.charAt(i12);
            if (cCharAt2 < '0' || cCharAt2 > '9') {
                break;
            }
            if (z11) {
                j10 = (j10 * 10) - (cCharAt2 - '0');
                if (j10 < -2147483648L) {
                    return null;
                }
            } else {
                j10 = (j10 * 10) + (cCharAt2 - '0');
                if (j10 > 2147483647L) {
                    return null;
                }
            }
            i12++;
        }
        if (i12 == i10) {
            return null;
        }
        return new IntegerParser(j10, i12);
    }

    public int getEndPos() {
        return this.pos;
    }

    public int value() {
        return (int) this.value;
    }
}
