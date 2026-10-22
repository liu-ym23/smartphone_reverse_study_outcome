package com.stepos.pps.logpull;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class LogPullCollector {
    public static List<String> resolveLogdTypes(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        if (strArr != null) {
            for (String str : strArr) {
                if (("logcat".equals(str) || "kernel".equals(str)) && !arrayList.contains(str)) {
                    arrayList.add(str);
                }
            }
        }
        return arrayList;
    }
}
