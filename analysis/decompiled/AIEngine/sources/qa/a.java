package qa;

import android.util.Pair;
import com.stepos.core.ability.speech.TtsCloudConfig;
import com.stepos.core.ota.confirm.InteractiveSessionRegistry;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final ArrayList f11630a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap f11631b = new HashMap();

    public static synchronized void a(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        ta.c.a("FailureRestrict", "addFail " + str + ", now: " + jCurrentTimeMillis);
        f11630a.add(new Pair(str, Long.valueOf(jCurrentTimeMillis)));
    }

    public static synchronized boolean b(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        ta.c.a("FailureRestrict", "check " + str + ", now: " + jCurrentTimeMillis);
        HashMap map = f11631b;
        if (map.containsKey(str)) {
            long jLongValue = ((Long) map.get(str)).longValue();
            ta.c.a("FailureRestrict", "forbid " + str + ", forbidTime: " + jLongValue);
            if (jCurrentTimeMillis - jLongValue < InteractiveSessionRegistry.DEFAULT_TTL_MS) {
                return false;
            }
            ta.c.a("FailureRestrict", "un forbid ".concat(str));
            map.remove(str);
        }
        ArrayList arrayList = new ArrayList();
        long jLongValue2 = 0;
        long jLongValue3 = 0;
        int i10 = 0;
        while (true) {
            ArrayList arrayList2 = f11630a;
            if (i10 >= arrayList2.size()) {
                break;
            }
            Pair pair = (Pair) arrayList2.get(i10);
            if (((String) pair.first).equals(str)) {
                arrayList.add(Integer.valueOf(i10));
                if (jLongValue2 == 0 || ((Long) pair.second).longValue() < jLongValue2) {
                    jLongValue2 = ((Long) pair.second).longValue();
                }
                if (jLongValue3 == 0 || ((Long) pair.second).longValue() > jLongValue3) {
                    jLongValue3 = ((Long) pair.second).longValue();
                }
            }
            i10++;
        }
        if (arrayList.size() >= 2) {
            ta.c.a("FailureRestrict", "accumulate 2 fail records, methodKey: " + str);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                f11630a.remove(((Integer) arrayList.get(size)).intValue());
            }
            ta.c.a("FailureRestrict", "latest call: " + jLongValue3 + ", earliest call: " + jLongValue2 + ", methodKey: " + str);
            long j10 = jLongValue3 - jLongValue2;
            if (j10 > 0 && j10 <= TtsCloudConfig.DEFAULT_AUDIO_DONE_IDLE_WATCHDOG_MS) {
                f11631b.put(str, Long.valueOf(jCurrentTimeMillis));
                ta.c.a("FailureRestrict", "add to forbid: " + str + ", now: " + jCurrentTimeMillis);
                return false;
            }
        }
        return true;
    }
}
