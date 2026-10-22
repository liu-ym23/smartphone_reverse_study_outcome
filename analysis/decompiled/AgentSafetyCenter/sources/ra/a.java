package ra;

import android.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import ua.c;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final ArrayList f10515a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap f10516b = new HashMap();

    public static synchronized void a(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        c.a("FailureRestrict", "addFail " + str + ", now: " + jCurrentTimeMillis);
        f10515a.add(new Pair(str, Long.valueOf(jCurrentTimeMillis)));
    }

    public static synchronized boolean b(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        c.a("FailureRestrict", "check " + str + ", now: " + jCurrentTimeMillis);
        HashMap map = f10516b;
        if (map.containsKey(str)) {
            long jLongValue = ((Long) map.get(str)).longValue();
            c.a("FailureRestrict", "forbid " + str + ", forbidTime: " + jLongValue);
            if (jCurrentTimeMillis - jLongValue < 300000) {
                return false;
            }
            c.a("FailureRestrict", "un forbid ".concat(str));
            map.remove(str);
        }
        ArrayList arrayList = new ArrayList();
        long jLongValue2 = 0;
        long jLongValue3 = 0;
        int i = 0;
        while (true) {
            ArrayList arrayList2 = f10515a;
            if (i >= arrayList2.size()) {
                break;
            }
            Pair pair = (Pair) arrayList2.get(i);
            if (((String) pair.first).equals(str)) {
                arrayList.add(Integer.valueOf(i));
                if (jLongValue2 == 0 || ((Long) pair.second).longValue() < jLongValue2) {
                    jLongValue2 = ((Long) pair.second).longValue();
                }
                if (jLongValue3 == 0 || ((Long) pair.second).longValue() > jLongValue3) {
                    jLongValue3 = ((Long) pair.second).longValue();
                }
            }
            i++;
        }
        if (arrayList.size() >= 2) {
            c.a("FailureRestrict", "accumulate 2 fail records, methodKey: " + str);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                f10515a.remove(((Integer) arrayList.get(size)).intValue());
            }
            c.a("FailureRestrict", "latest call: " + jLongValue3 + ", earliest call: " + jLongValue2 + ", methodKey: " + str);
            long j10 = jLongValue3 - jLongValue2;
            if (j10 > 0 && j10 <= 10000) {
                f10516b.put(str, Long.valueOf(jCurrentTimeMillis));
                c.a("FailureRestrict", "add to forbid: " + str + ", now: " + jCurrentTimeMillis);
                return false;
            }
        }
        return true;
    }
}
