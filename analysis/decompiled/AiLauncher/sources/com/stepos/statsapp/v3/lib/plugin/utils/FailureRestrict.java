package com.stepos.statsapp.v3.lib.plugin.utils;

import android.util.Pair;
import com.stepos.statsapp.v3.utils.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class FailureRestrict {
    private static final String TAG = "FailureRestrict";
    private static final List<Pair<String, Long>> failRecords = new ArrayList();
    private static final Map<String, Long> forbids = new HashMap();

    public static synchronized void addFail(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Logger.d(TAG, "addFail " + str + ", now: " + jCurrentTimeMillis);
        failRecords.add(new Pair<>(str, Long.valueOf(jCurrentTimeMillis)));
    }

    public static synchronized boolean check(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str2 = TAG;
        Logger.d(str2, "check " + str + ", now: " + jCurrentTimeMillis);
        Map<String, Long> map = forbids;
        if (map.containsKey(str)) {
            long jLongValue = map.get(str).longValue();
            Logger.d(str2, "forbid " + str + ", forbidTime: " + jLongValue);
            if (jCurrentTimeMillis - jLongValue < 300000) {
                return false;
            }
            Logger.d(str2, "un forbid " + str);
            map.remove(str);
        }
        ArrayList arrayList = new ArrayList();
        long jLongValue2 = 0;
        long jLongValue3 = 0;
        int i10 = 0;
        while (true) {
            List<Pair<String, Long>> list = failRecords;
            if (i10 >= list.size()) {
                break;
            }
            Pair<String, Long> pair = list.get(i10);
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
            Logger.d(TAG, "accumulate 2 fail records, methodKey: " + str);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                failRecords.remove(((Integer) arrayList.get(size)).intValue());
            }
            String str3 = TAG;
            Logger.d(str3, "latest call: " + jLongValue3 + ", earliest call: " + jLongValue2 + ", methodKey: " + str);
            long j10 = jLongValue3 - jLongValue2;
            if (j10 > 0 && j10 <= 10000) {
                forbids.put(str, Long.valueOf(jCurrentTimeMillis));
                Logger.d(str3, "add to forbid: " + str + ", now: " + jCurrentTimeMillis);
                return false;
            }
        }
        return true;
    }
}
