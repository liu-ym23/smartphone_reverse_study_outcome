package d3;

import android.util.Pair;
import g3.C0742e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: d3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0665a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f16605a = "FailureRestrict";

    /* renamed from: b, reason: collision with root package name */
    private static final List<Pair<String, Long>> f16606b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private static final Map<String, Long> f16607c = new HashMap();

    public static synchronized void a(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        C0742e.c(f16605a, "addFail " + str + ", now: " + jCurrentTimeMillis);
        f16606b.add(new Pair<>(str, Long.valueOf(jCurrentTimeMillis)));
    }

    public static synchronized boolean b(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str2 = f16605a;
        C0742e.c(str2, "check " + str + ", now: " + jCurrentTimeMillis);
        Map<String, Long> map = f16607c;
        if (map.containsKey(str)) {
            long jLongValue = map.get(str).longValue();
            C0742e.c(str2, "forbid " + str + ", forbidTime: " + jLongValue);
            if (jCurrentTimeMillis - jLongValue < 300000) {
                return false;
            }
            C0742e.c(str2, "un forbid " + str);
            map.remove(str);
        }
        ArrayList arrayList = new ArrayList();
        long jLongValue2 = 0;
        long jLongValue3 = 0;
        int i5 = 0;
        while (true) {
            List<Pair<String, Long>> list = f16606b;
            if (i5 >= list.size()) {
                break;
            }
            Pair<String, Long> pair = list.get(i5);
            if (((String) pair.first).equals(str)) {
                arrayList.add(Integer.valueOf(i5));
                if (jLongValue2 == 0 || ((Long) pair.second).longValue() < jLongValue2) {
                    jLongValue2 = ((Long) pair.second).longValue();
                }
                if (jLongValue3 == 0 || ((Long) pair.second).longValue() > jLongValue3) {
                    jLongValue3 = ((Long) pair.second).longValue();
                }
            }
            i5++;
        }
        if (arrayList.size() >= 2) {
            C0742e.c(f16605a, "accumulate 2 fail records, methodKey: " + str);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                f16606b.remove(((Integer) arrayList.get(size)).intValue());
            }
            String str3 = f16605a;
            C0742e.c(str3, "latest call: " + jLongValue3 + ", earliest call: " + jLongValue2 + ", methodKey: " + str);
            long j5 = jLongValue3 - jLongValue2;
            if (j5 > 0 && j5 <= 10000) {
                f16607c.put(str, Long.valueOf(jCurrentTimeMillis));
                C0742e.c(str3, "add to forbid: " + str + ", now: " + jCurrentTimeMillis);
                return false;
            }
        }
        return true;
    }
}
