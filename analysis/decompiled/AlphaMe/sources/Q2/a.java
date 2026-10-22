package Q2;

import T2.d;
import android.util.Pair;
import ch.qos.logback.core.spi.AbstractComponentTracker;
import com.stepos.alphame.bluetooth.VehicleBluetoothManager;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final ArrayList f1642a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap f1643b = new HashMap();

    public static synchronized void a(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        d.a("FailureRestrict", "addFail " + str + ", now: " + jCurrentTimeMillis);
        f1642a.add(new Pair(str, Long.valueOf(jCurrentTimeMillis)));
    }

    public static synchronized boolean b(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        d.a("FailureRestrict", "check " + str + ", now: " + jCurrentTimeMillis);
        HashMap map = f1643b;
        if (map.containsKey(str)) {
            long jLongValue = ((Long) map.get(str)).longValue();
            d.a("FailureRestrict", "forbid " + str + ", forbidTime: " + jLongValue);
            if (jCurrentTimeMillis - jLongValue < VehicleBluetoothManager.FAIL_RETRY_TIMEOUT) {
                return false;
            }
            d.a("FailureRestrict", "un forbid ".concat(str));
            map.remove(str);
        }
        ArrayList arrayList = new ArrayList();
        long jLongValue2 = 0;
        long jLongValue3 = 0;
        int i4 = 0;
        while (true) {
            ArrayList arrayList2 = f1642a;
            if (i4 >= arrayList2.size()) {
                break;
            }
            Pair pair = (Pair) arrayList2.get(i4);
            if (((String) pair.first).equals(str)) {
                arrayList.add(Integer.valueOf(i4));
                if (jLongValue2 == 0 || ((Long) pair.second).longValue() < jLongValue2) {
                    jLongValue2 = ((Long) pair.second).longValue();
                }
                if (jLongValue3 == 0 || ((Long) pair.second).longValue() > jLongValue3) {
                    jLongValue3 = ((Long) pair.second).longValue();
                }
            }
            i4++;
        }
        if (arrayList.size() >= 2) {
            d.a("FailureRestrict", "accumulate 2 fail records, methodKey: " + str);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                f1642a.remove(((Integer) arrayList.get(size)).intValue());
            }
            d.a("FailureRestrict", "latest call: " + jLongValue3 + ", earliest call: " + jLongValue2 + ", methodKey: " + str);
            long j4 = jLongValue3 - jLongValue2;
            if (j4 > 0 && j4 <= AbstractComponentTracker.LINGERING_TIMEOUT) {
                f1643b.put(str, Long.valueOf(jCurrentTimeMillis));
                d.a("FailureRestrict", "add to forbid: " + str + ", now: " + jCurrentTimeMillis);
                return false;
            }
        }
        return true;
    }
}
