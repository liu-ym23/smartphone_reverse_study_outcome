package com.bytedance.bdinstall.j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: SystemPropertiesWithCache.java */
/* JADX INFO: loaded from: classes.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final t f6339a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, Object> f6340b = null;

    static {
        f6339a = new t();
        f6340b = new ConcurrentHashMap();
    }

    public static Object a(String r2) {
        Map<String, Object> r0 = f6340b;
        Object r1 = r0.get(r2);
        if (r1 == null) goto L5;
        return r1;
    L5:
        String r3 = f6339a.a(r2);
        if (r3 == null) goto L8;
        r0.put(r2, r3);
    L8:
        return r3;
    }
}
