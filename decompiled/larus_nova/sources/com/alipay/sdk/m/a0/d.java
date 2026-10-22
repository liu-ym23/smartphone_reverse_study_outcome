package com.alipay.sdk.m.a0;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes28.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, a> f25225a = null;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f25226a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f25227b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f25228c;

        public a() {
        }
    }

    static {
        f25225a = new ConcurrentHashMap();
    }

    public static String a(String r100) {
        Map<String, a> r101 = f25225a;
        if (r101 != null) goto L5;
        return null;
    L5:
        a r102 = r101.get(r100);
        if (r102 != null) goto L8;
        return null;
    L8:
        long r103 = r102.f25227b;
        long r104 = r102.f25228c;
        if ((System.currentTimeMillis() - r103) >= r104) goto L11;
        boolean r105 = true;
    L12:
        if (r105 == false) goto L16;
        String r106 = r102.f25226a;
        if (r106 == null) goto L16;
        return r106;
    L16:
        r101.remove(r100);
        return null;
    L11:
        r105 = false;
        goto L12
    }

    public static void a(String r100, String r101) {
        if (r101 != null) goto L4;
        r101 = "";
    L4:
        Map<String, a> r102 = f25225a;
        a r103 = r102.get(r100);
        if (r103 != null) goto L7;
        r103 = new a();
    L7:
        r103.f25226a = r101;
        r103.f25228c = 86400000;
        r103.f25227b = System.currentTimeMillis();
        r102.put(r100, r103);
    }
}
