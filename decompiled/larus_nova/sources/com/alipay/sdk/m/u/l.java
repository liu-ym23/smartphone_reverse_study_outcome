package com.alipay.sdk.m.u;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes28.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f25863a = "resultStatus";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f25864b = "memo";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f25865c = "result";

    public static Map<String, String> a() {
        com.alipay.sdk.m.j.c r100 = com.alipay.sdk.m.j.c.b(com.alipay.sdk.m.j.c.f25364e.b());
        HashMap r101 = new HashMap();
        r101.put(f25863a, Integer.toString(r100.b()));
        r101.put(f25864b, r100.a());
        r101.put("result", "");
        return r101;
    }

    public l() {
    }

    public static Map<String, String> a(String r100) {
        String[] r101 = r100.split(i.f25853b);
        HashMap r102 = new HashMap();
        int r103 = r101.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        String r105 = r101[r104];
        String r106 = r105.substring(0, r105.indexOf("={"));
        r102.put(r106, b(r105, r106));
        r104 = r104 + 1;
        goto L3
    L5:
        return r102;
    }

    public static String a(String r100, String r101) {
        Matcher r102 = Pattern.compile("(^|;)" + r101 + "=\\{([^}]*?)\\}").matcher(r100);     // Catch: Throwable -> L7
        if (r102.find() == false) goto L9;
        return r102.group(2);
    L9:
        return "?";
    L7:
        th = move-exception;
        e.a(th);
        goto L9
    }

    public static String b(String r100, String r101) {
        String r102 = r101 + "={";
        return r100.substring(r100.indexOf(r102) + r102.length(), r100.lastIndexOf(i.f25855d));
    }

    public static Map<String, String> a(com.alipay.sdk.m.s.a r100, String r101) {
        Map<String, String> r102 = a();
        return a(r101);
    L5:
        th = move-exception;
        com.alipay.sdk.m.k.a.a(r100, "biz", com.alipay.sdk.m.k.b.f25418q, th);
        return r102;
    }
}
