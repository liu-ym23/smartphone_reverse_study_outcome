package com.bytedance.apm.trace;

import H.h;
import I.a;
import ca.AbstractC0897f;
import java.util.concurrent.ConcurrentHashMap;
import m0.C1671e;

/* loaded from: classes2.dex */
public final class LaunchTrace {
    public static void customLaunchEnd(boolean z10) {
        h.f720z = z10;
    }

    public static void endSpan(String str) {
        ConcurrentHashMap concurrentHashMap = a.f790a;
        C1671e c1671e = (C1671e) concurrentHashMap.get("null#" + str);
        if (c1671e == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String name = Thread.currentThread().getName();
        c1671e.b = jCurrentTimeMillis;
        c1671e.c = name;
        concurrentHashMap.put("null#" + str, c1671e);
    }

    public static void reportLaunchEnd() {
        AbstractC0897f.f2126x = System.currentTimeMillis();
        AbstractC0897f.g(h.i, true);
    }

    public static void startSpan(String str) {
        ConcurrentHashMap concurrentHashMap = a.f790a;
        if (((C1671e) concurrentHashMap.get("null#" + str)) == null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            C1671e c1671e = new C1671e();
            c1671e.f5296a = jCurrentTimeMillis;
            concurrentHashMap.put("null#" + str, c1671e);
        }
    }
}
