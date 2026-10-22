package f2;

import com.stepos.digitalwellbeing.server.data.NotificationTimesStats;
import com.stepos.digitalwellbeing.server.data.PickupTimesStats;
import com.stepos.digitalwellbeing.server.data.StepOSUsageStats;
import com.stepos.digitalwellbeing.server.data.UsingTimeStats;

/* renamed from: f2.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0712q {
    public static <T extends StepOSUsageStats> long a(T[] tArr) {
        long[] jArrC;
        long j5 = 0;
        if (tArr == null || (jArrC = c(tArr)) == null) {
            return 0L;
        }
        for (long j6 : jArrC) {
            if (j5 < j6) {
                j5 = j6;
            }
        }
        return j5;
    }

    public static <T extends StepOSUsageStats> long b(T[] tArr) {
        long[] jArrC;
        long j5 = 0;
        if (tArr == null || (jArrC = c(tArr)) == null) {
            return 0L;
        }
        for (long j6 : jArrC) {
            j5 += j6;
        }
        return j5;
    }

    public static <T extends StepOSUsageStats> long[] c(T[] tArr) {
        if (tArr == null) {
            return null;
        }
        int length = tArr.length;
        long[] jArr = new long[length];
        for (int i5 = 0; i5 < length; i5++) {
            T t5 = tArr[i5];
            if (t5 instanceof UsingTimeStats) {
                jArr[i5] = C0711p.l(t5 != null ? ((UsingTimeStats) t5).getUsingTime() : 0L);
            } else if (t5 instanceof PickupTimesStats) {
                jArr[i5] = t5 != null ? ((PickupTimesStats) t5).getPickupTimes() : 0L;
            } else if (t5 instanceof NotificationTimesStats) {
                jArr[i5] = t5 != null ? ((NotificationTimesStats) t5).getNotificationTimes() : 0L;
            }
        }
        return jArr;
    }
}
