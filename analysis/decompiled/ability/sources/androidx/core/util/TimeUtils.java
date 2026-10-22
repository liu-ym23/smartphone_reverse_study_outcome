package androidx.core.util;

import androidx.annotation.RestrictTo;
import java.io.PrintWriter;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes2.dex */
public final class TimeUtils {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int HUNDRED_DAY_FIELD_LEN = 19;
    private static final int SECONDS_PER_DAY = 86400;
    private static final int SECONDS_PER_HOUR = 3600;
    private static final int SECONDS_PER_MINUTE = 60;
    private static final Object sFormatSync = new Object();
    private static char[] sFormatStr = new char[24];

    private TimeUtils() {
    }

    private static int accumField(int i, int i6, boolean z10, int i10) {
        if (i > 99 || (z10 && i10 >= 3)) {
            return i6 + 3;
        }
        if (i > 9 || (z10 && i10 >= 2)) {
            return i6 + 2;
        }
        if (z10 || i > 0) {
            return i6 + 1;
        }
        return 0;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j5, StringBuilder sb) {
        synchronized (sFormatSync) {
            sb.append(sFormatStr, 0, formatDurationLocked(j5, 0));
        }
    }

    private static int formatDurationLocked(long j5, int i) {
        char c;
        int i6;
        int i10;
        int i11;
        int i12;
        long j6 = j5;
        if (sFormatStr.length < i) {
            sFormatStr = new char[i];
        }
        char[] cArr = sFormatStr;
        if (j6 == 0) {
            int i13 = i - 1;
            while (i13 > 0) {
                cArr[0] = ' ';
            }
            cArr[0] = '0';
            return 1;
        }
        if (j6 > 0) {
            c = '+';
        } else {
            j6 = -j6;
            c = '-';
        }
        int i14 = (int) (j6 % 1000);
        int iFloor = (int) Math.floor(j6 / 1000);
        if (iFloor > 86400) {
            i6 = iFloor / 86400;
            iFloor -= 86400 * i6;
        } else {
            i6 = 0;
        }
        if (iFloor > 3600) {
            i10 = iFloor / 3600;
            iFloor -= i10 * 3600;
        } else {
            i10 = 0;
        }
        if (iFloor > 60) {
            int i15 = iFloor / 60;
            iFloor -= i15 * 60;
            i11 = i15;
        } else {
            i11 = 0;
        }
        if (i != 0) {
            int iAccumField = accumField(i6, 1, false, 0);
            int iAccumField2 = iAccumField + accumField(i10, 1, iAccumField > 0, 2);
            int iAccumField3 = iAccumField2 + accumField(i11, 1, iAccumField2 > 0, 2);
            int iAccumField4 = iAccumField3 + accumField(iFloor, 1, iAccumField3 > 0, 2);
            i12 = 0;
            for (int iAccumField5 = accumField(i14, 2, true, iAccumField4 > 0 ? 3 : 0) + 1 + iAccumField4; iAccumField5 < i; iAccumField5++) {
                cArr[i12] = ' ';
                i12++;
            }
        } else {
            i12 = 0;
        }
        cArr[i12] = c;
        int i16 = i12 + 1;
        boolean z10 = i != 0;
        int iPrintField = printField(cArr, i6, 'd', i16, false, 0);
        int iPrintField2 = printField(cArr, i10, 'h', iPrintField, iPrintField != i16, z10 ? 2 : 0);
        int iPrintField3 = printField(cArr, i11, 'm', iPrintField2, iPrintField2 != i16, z10 ? 2 : 0);
        int iPrintField4 = printField(cArr, iFloor, 's', iPrintField3, iPrintField3 != i16, z10 ? 2 : 0);
        int iPrintField5 = printField(cArr, i14, 'm', iPrintField4, true, (!z10 || iPrintField4 == i16) ? 0 : 3);
        cArr[iPrintField5] = 's';
        return iPrintField5 + 1;
    }

    private static int printField(char[] cArr, int i, char c, int i6, boolean z10, int i10) {
        int i11;
        if (!z10 && i <= 0) {
            return i6;
        }
        if ((!z10 || i10 < 3) && i <= 99) {
            i11 = i6;
        } else {
            int i12 = i / 100;
            cArr[i6] = (char) (i12 + 48);
            i11 = i6 + 1;
            i -= i12 * 100;
        }
        if ((z10 && i10 >= 2) || i > 9 || i6 != i11) {
            int i13 = i / 10;
            cArr[i11] = (char) (i13 + 48);
            i11++;
            i -= i13 * 10;
        }
        cArr[i11] = (char) (i + 48);
        cArr[i11 + 1] = c;
        return i11 + 2;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j5, PrintWriter printWriter, int i) {
        synchronized (sFormatSync) {
            printWriter.print(new String(sFormatStr, 0, formatDurationLocked(j5, i)));
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j5, PrintWriter printWriter) {
        formatDuration(j5, printWriter, 0);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j5, long j6, PrintWriter printWriter) {
        if (j5 == 0) {
            printWriter.print("--");
        } else {
            formatDuration(j5 - j6, printWriter, 0);
        }
    }
}
