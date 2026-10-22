package d2;

import android.text.TextUtils;
import com.stepos.digitalwellbeing.server.data.NotificationTimesStats;
import com.stepos.digitalwellbeing.server.data.PackageNotificationTimesStats;
import com.stepos.digitalwellbeing.server.data.PackageUsingTimeStats;
import com.stepos.digitalwellbeing.server.data.PickupTimesStats;
import com.stepos.digitalwellbeing.server.data.UsingTimeStats;
import com.stepos.digitalwellbeing.utils.PackageUtils;
import f2.C0711p;
import java.util.HashMap;
import java.util.Map;

/* renamed from: d2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0653a {
    private static <In extends InterfaceC0658f> com.stepos.digitalwellbeing.server.data.a a(In in, boolean z5) {
        return in == null ? com.stepos.digitalwellbeing.server.data.a.HOUR : in instanceof C0661i ? z5 ? com.stepos.digitalwellbeing.server.data.a.HOUR : com.stepos.digitalwellbeing.server.data.a.DAY : in instanceof C0663k ? z5 ? com.stepos.digitalwellbeing.server.data.a.DAY : com.stepos.digitalwellbeing.server.data.a.WEEK : com.stepos.digitalwellbeing.server.data.a.HOUR;
    }

    private static <In extends InterfaceC0658f> int b(In in) {
        if (in == null) {
            return -1;
        }
        if (in instanceof C0661i) {
            return 24;
        }
        return in instanceof C0663k ? 7 : -1;
    }

    private static <In extends InterfaceC0658f> long c(In in, int i5) {
        int iB = b(in);
        if (i5 < 0 || i5 >= iB) {
            return -1L;
        }
        if (in instanceof C0661i) {
            return C0711p.y() + (i5 * 3600000);
        }
        if (in instanceof C0663k) {
            return C0711p.y() - (((iB - i5) - 1) * 86400000);
        }
        return -1L;
    }

    private static <In extends InterfaceC0658f> long d(In in) {
        if (in instanceof C0661i) {
            return C0711p.y();
        }
        if (in instanceof C0663k) {
            return C0711p.y() - 604800000;
        }
        return -1L;
    }

    private static boolean e(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith("quick_")) {
            return true;
        }
        return str.startsWith("quickgame_");
    }

    public static NotificationTimesStats[] f(InterfaceC0659g interfaceC0659g) {
        NotificationTimesStats[] notificationTimesStatsArr = null;
        if (interfaceC0659g == null) {
            return null;
        }
        int iB = b(interfaceC0659g);
        int[] iArrE = interfaceC0659g.e();
        if (iArrE != null && iArrE.length == iB) {
            notificationTimesStatsArr = new NotificationTimesStats[iB];
            for (int i5 = 0; i5 < iB; i5++) {
                notificationTimesStatsArr[i5] = new NotificationTimesStats(a(interfaceC0659g, true).ordinal(), c(interfaceC0659g, i5), interfaceC0659g.f(), iArrE[i5]);
            }
        }
        return notificationTimesStatsArr;
    }

    public static HashMap<String, PackageNotificationTimesStats[]> g(InterfaceC0655c interfaceC0655c) {
        if (interfaceC0655c == null) {
            return null;
        }
        HashMap<String, PackageNotificationTimesStats[]> map = new HashMap<>();
        for (Map.Entry<String, int[]> entry : interfaceC0655c.h().entrySet()) {
            String key = entry.getKey();
            int[] value = entry.getValue();
            PackageNotificationTimesStats[] packageNotificationTimesStatsArr = new PackageNotificationTimesStats[value.length];
            boolean z5 = true;
            int i5 = 0;
            while (i5 < value.length) {
                boolean z6 = value[i5] > 0 ? false : z5;
                packageNotificationTimesStatsArr[i5] = new PackageNotificationTimesStats(a(interfaceC0655c, false).ordinal(), c(interfaceC0655c, i5), interfaceC0655c.f(), value[i5], key);
                i5++;
                z5 = z6;
            }
            if (!z5) {
                map.put(key, packageNotificationTimesStatsArr);
            }
        }
        return map;
    }

    public static HashMap<String, PackageNotificationTimesStats> h(InterfaceC0654b interfaceC0654b) {
        int i5;
        if (interfaceC0654b == null) {
            return null;
        }
        HashMap<String, PackageNotificationTimesStats> map = new HashMap<>();
        int i6 = 0;
        for (Map.Entry<String, Integer> entry : interfaceC0654b.c().entrySet()) {
            String key = entry.getKey();
            int iIntValue = entry.getValue().intValue();
            if (e(key)) {
                i6 += iIntValue;
                key = "com.stepos.directservice";
                i5 = i6;
            } else {
                i5 = iIntValue;
            }
            String str = key;
            if (PackageUtils.h(P1.a.a()).p(str)) {
                map.put(str, new PackageNotificationTimesStats(a(interfaceC0654b, false).ordinal(), d(interfaceC0654b), interfaceC0654b.f(), i5, str));
            }
        }
        return map;
    }

    public static HashMap<String, PackageUsingTimeStats[]> i(InterfaceC0657e interfaceC0657e) {
        if (interfaceC0657e == null) {
            return null;
        }
        HashMap<String, PackageUsingTimeStats[]> map = new HashMap<>();
        for (Map.Entry<String, long[]> entry : interfaceC0657e.g().entrySet()) {
            String key = entry.getKey();
            long[] value = entry.getValue();
            PackageUsingTimeStats[] packageUsingTimeStatsArr = new PackageUsingTimeStats[value.length];
            boolean z5 = true;
            int i5 = 0;
            while (i5 < value.length) {
                boolean z6 = value[i5] > 0 ? false : z5;
                packageUsingTimeStatsArr[i5] = new PackageUsingTimeStats(a(interfaceC0657e, false).ordinal(), c(interfaceC0657e, i5), interfaceC0657e.f(), value[i5], key);
                i5++;
                z5 = z6;
            }
            if (!z5) {
                map.put(key, packageUsingTimeStatsArr);
            }
        }
        return map;
    }

    public static HashMap<String, PackageUsingTimeStats> j(InterfaceC0656d interfaceC0656d) {
        long j5;
        if (interfaceC0656d == null) {
            return null;
        }
        HashMap<String, PackageUsingTimeStats> map = new HashMap<>();
        long j6 = 0;
        for (Map.Entry<String, Long> entry : interfaceC0656d.a().entrySet()) {
            String key = entry.getKey();
            long jLongValue = entry.getValue().longValue();
            if (e(key)) {
                key = "com.stepos.directservice";
                j6 = jLongValue + j6;
                j5 = j6;
            } else {
                j5 = jLongValue;
            }
            String str = key;
            if (PackageUtils.h(P1.a.a()).p(str)) {
                map.put(str, new PackageUsingTimeStats(a(interfaceC0656d, false).ordinal(), d(interfaceC0656d), interfaceC0656d.f(), j5, str));
            }
        }
        return map;
    }

    public static PickupTimesStats[] k(InterfaceC0660h interfaceC0660h) {
        PickupTimesStats[] pickupTimesStatsArr = null;
        if (interfaceC0660h == null) {
            return null;
        }
        int iB = b(interfaceC0660h);
        int[] iArrD = interfaceC0660h.d();
        if (iArrD != null && iArrD.length == iB) {
            pickupTimesStatsArr = new PickupTimesStats[iB];
            for (int i5 = 0; i5 < iB; i5++) {
                pickupTimesStatsArr[i5] = new PickupTimesStats(a(interfaceC0660h, true).ordinal(), c(interfaceC0660h, i5), interfaceC0660h.f(), iArrD[i5]);
            }
        }
        return pickupTimesStatsArr;
    }

    public static UsingTimeStats[] l(InterfaceC0662j interfaceC0662j) {
        UsingTimeStats[] usingTimeStatsArr = null;
        if (interfaceC0662j == null) {
            return null;
        }
        int iB = b(interfaceC0662j);
        long[] jArrB = interfaceC0662j.b();
        if (jArrB != null && jArrB.length == iB) {
            usingTimeStatsArr = new UsingTimeStats[iB];
            for (int i5 = 0; i5 < iB; i5++) {
                usingTimeStatsArr[i5] = new UsingTimeStats(a(interfaceC0662j, true).ordinal(), c(interfaceC0662j, i5), interfaceC0662j.f(), jArrB[i5]);
            }
        }
        return usingTimeStatsArr;
    }
}
