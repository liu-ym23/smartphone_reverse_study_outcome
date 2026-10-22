package com.obric.agent.card.weather;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: TimeStrNormalizer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f14288a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<String> f14289b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final List<String> f14290c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final List<String> f14291d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final List<String> f14292e = null;
    private static final List<String> f = null;
    private static final List<String> g = null;
    private static final List<String> h = null;
    private static final List<String> i = null;
    private static final List<String> j = null;
    private static final List<String> k = null;
    private static final List<String> l = null;
    private static final List<String> m = null;
    private static final List<String> n = null;
    private static final List<String> o = null;
    private static final List<String> p = null;
    private static final List<String> q = null;
    private static final List<String> r = null;

    private f() {
    }

    static {
        f14288a = new f();
        f14289b = p.b(new String[]{"今日", "今天"});
        f14290c = p.b(new String[]{"明日", "明天"});
        f14291d = p.a("星期一");
        f14292e = p.a("星期二");
        f = p.a("星期三");
        g = p.a("星期四");
        h = p.a("星期五");
        i = p.a("星期六");
        j = p.a("星期日");
        k = p.a("下周一");
        l = p.a("下周二");
        m = p.a("下周三");
        n = p.a("下周四");
        o = p.a("下周五");
        p = p.a("下周六");
        q = p.a("下周日");
        r = p.a("周末");
    }

    public final String a(String r9, Date r10, String r11) {
        o.e(r10, "date");
        o.e(r11, "defaultStr");
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        return r11;
    L12:
        if (a(r9, f14289b) == false) goto L17;
        if (b.a(r10) == false) goto L92;
        return "今日";
    L92:
        return r11;
    L17:
        if (a(r9, f14290c) == false) goto L22;
        if (b.b(r10) == false) goto L94;
        return "明日";
    L94:
        return r11;
    L22:
        if (a(r9, f14291d) == false) goto L27;
        if (b.c(r10) != 2) goto L96;
        return "星期一";
    L96:
        return r11;
    L27:
        if (a(r9, f14292e) == false) goto L32;
        if (b.c(r10) != 3) goto L98;
        return "星期二";
    L98:
        return r11;
    L32:
        if (a(r9, f) == false) goto L37;
        if (b.c(r10) != 4) goto L100;
        return "星期三";
    L100:
        return r11;
    L37:
        if (a(r9, g) == false) goto L42;
        if (b.c(r10) != 5) goto L102;
        return "星期四";
    L102:
        return r11;
    L42:
        if (a(r9, h) == false) goto L47;
        if (b.c(r10) != 6) goto L104;
        return "星期五";
    L104:
        return r11;
    L47:
        if (a(r9, i) == false) goto L52;
        if (b.c(r10) != 7) goto L106;
        return "星期六";
    L106:
        return r11;
    L52:
        if (a(r9, j) == false) goto L57;
        if (b.c(r10) != 1) goto L108;
        return "星期日";
    L108:
        return r11;
    L57:
        if (a(r9, k) == false) goto L62;
        if (b.c(r10) != 2) goto L110;
        return "下周一";
    L110:
        return r11;
    L62:
        if (a(r9, l) == false) goto L67;
        if (b.c(r10) != 3) goto L112;
        return "下周二";
    L112:
        return r11;
    L67:
        if (a(r9, m) == false) goto L72;
        if (b.c(r10) != 4) goto L114;
        return "下周三";
    L114:
        return r11;
    L72:
        if (a(r9, n) == false) goto L77;
        if (b.c(r10) != 5) goto L116;
        return "下周四";
    L116:
        return r11;
    L77:
        if (a(r9, o) == false) goto L82;
        if (b.c(r10) != 6) goto L118;
        return "下周五";
    L118:
        return r11;
    L82:
        if (a(r9, p) == false) goto L87;
        if (b.c(r10) != 7) goto L120;
        return "下周六";
    L120:
        return r11;
    L87:
        if (a(r9, q) == true) goto L89;
        return r11;
    L89:
        if (b.c(r10) != 1) goto L123;
        return "下周日";
    L123:
        return r11;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public final String a(String r3, List<? extends Date> r4, String r5) {
        List<? extends Date> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        o.e(r6, "dates");
        o.e(r5, "defaultStr");
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        return r5;
    L12:
        if (a(r3, r) == true) goto L14;
        return r5;
    L14:
        if (a(r6) == false) goto L18;
        return "周末";
    L18:
        return r5;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public final boolean a(List<? extends Date> r4) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        o.e(r3, "dates");
        if (r3.size() == 2) goto L5;
    L9:
        return false;
    L5:
        if (b.c((Date) ZeusTransformUtils.preCheckCast(p.k(r3), Date.class, "com.obric.aiagent.plugin")) != 7) goto L9;
        if (b.c((Date) ZeusTransformUtils.preCheckCast(p.m(r3), Date.class, "com.obric.aiagent.plugin")) != 1) goto L9;
        return true;
    }

    private final boolean a(String r6, List<String> r7) {
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, Collection.class) == true) goto L5;
    L7:
        Iterator r8 = r5.iterator();
    L9:
        if (r8.hasNext() == false) goto L18;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.aiagent.plugin");
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L7;
        return false;
    }
}
