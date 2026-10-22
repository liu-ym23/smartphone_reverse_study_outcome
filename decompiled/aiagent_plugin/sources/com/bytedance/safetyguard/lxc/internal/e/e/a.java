package com.bytedance.safetyguard.lxc.internal.e.e;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ax;
import d.a.p;
import d.h.b.o;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: HeaderSanitizer.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10773a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<String> f10774b = null;

    private a() {
    }

    static {
        f10773a = new a();
        Locale r1 = Locale.US;
        o.c(r1, "US");
        String r2 = "Connection".toLowerCase(r1);
        o.c(r2, "toLowerCase(...)");
        Locale r3 = Locale.US;
        o.c(r3, "US");
        String r4 = "Authorization".toLowerCase(r3);
        o.c(r4, "toLowerCase(...)");
        Locale r5 = Locale.US;
        o.c(r5, "US");
        String r6 = "X-Lark-MCP-UAT".toLowerCase(r5);
        o.c(r6, "toLowerCase(...)");
        Locale r7 = Locale.US;
        o.c(r7, "US");
        String r8 = "X-Lark-MCP-TAT".toLowerCase(r7);
        o.c(r8, "toLowerCase(...)");
        Locale r9 = Locale.US;
        o.c(r9, "US");
        String r10 = "x-lark-body-sha256".toLowerCase(r9);
        o.c(r10, "toLowerCase(...)");
        f10774b = ax.a(new String[]{"host", "content-length", "transfer-encoding", r2, "keep-alive", "proxy-authenticate", "proxy-authorization", "te", "trailer", "upgrade", r4, r6, r8, r10});
    }

    public final Map<String, String> a(Map<String, String> r18, String r19, String r20) {
        String r1 = r20;
        Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r18, Map.class, "com.obric.aiagent.plugin");
        o.e(r2, "incomingHeaders");
        o.e(r19, "authHeader");
        o.e(r1, "token");
        Set r4 = p.t((Iterable) ZeusTransformUtils.preCheckCast(f10774b, Iterable.class, "com.obric.aiagent.plugin"));
        Iterator r5 = r2.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L12;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r11 = (String) ZeusTransformUtils.preCheckCast(r6.getKey(), String.class, "com.obric.aiagent.plugin");
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6.getValue(), String.class, "com.obric.aiagent.plugin");
        if (d.o.o.a(r11, "Connection", true) == false) goto L4;
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"), new char[]{','}, false, 0, 6, null), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L9:
        if (r8.hasNext() == false) goto L11;
        Object r9 = r8.next();
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.aiagent.plugin");
        String r12 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r9, String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin")).toString();
        Locale r13 = Locale.US;
        o.c(r13, "US");
        String r14 = r12.toLowerCase(r13);
        o.c(r14, "toLowerCase(...)");
        r10.add(r14);
        goto L9
    L11:
        Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.aiagent.plugin");
        goto L4
    L12:
        LinkedHashMap r16 = new LinkedHashMap();
        Iterator r3 = r2.entrySet().iterator();
    L14:
        if (r3.hasNext() == false) goto L20;
        Map.Entry r17 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r110 = (String) ZeusTransformUtils.preCheckCast(r17.getKey(), String.class, "com.obric.aiagent.plugin");
        String r21 = (String) ZeusTransformUtils.preCheckCast(r17.getValue(), String.class, "com.obric.aiagent.plugin");
        Locale r111 = Locale.US;
        o.c(r111, "US");
        String r112 = r110.toLowerCase(r111);
        o.c(r112, "toLowerCase(...)");
        Locale r113 = Locale.US;
        o.c(r113, "US");
        String r114 = "x-lark-proxy-".toLowerCase(r113);
        o.c(r114, "toLowerCase(...)");
        if (d.o.o.b(r112, r114, false, 2, null) == true) goto L14;
        if (r4.contains(r112) == true) goto L14;
        ((Map) ZeusTransformUtils.preCheckCast(r16, Map.class, "com.obric.aiagent.plugin")).put(r110, r21);
        goto L14
    L20:
        Map r22 = (Map) ZeusTransformUtils.preCheckCast(r16, Map.class, "com.obric.aiagent.plugin");
        if (d.o.o.a(r19, "Authorization", true) == false) goto L23;
        r1 = "Bearer " + r1;
    L23:
        r22.put(r19, r1);
        return (Map) ZeusTransformUtils.preCheckCast(r16, Map.class, "com.obric.aiagent.plugin");
    }

    public final Map<String, String> a(Map<String, String> r7) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
        o.e(r6, "headers");
        Set r8 = ax.b(f10774b, "set-cookie");
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator r9 = r6.entrySet().iterator();
    L4:
        if (r9.hasNext() == false) goto L9;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.aiagent.plugin");
        Locale r4 = Locale.US;
        o.c(r4, "US");
        String r5 = r3.toLowerCase(r4);
        o.c(r5, "toLowerCase(...)");
        if ((!r8.contains(r5)) == false) goto L4;
        r1.put(r2.getKey(), r2.getValue());
        goto L4
    L9:
        return (Map) ZeusTransformUtils.preCheckCast(r1, Map.class, "com.obric.aiagent.plugin");
    }
}
