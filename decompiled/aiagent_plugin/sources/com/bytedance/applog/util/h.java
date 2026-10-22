package com.bytedance.applog.util;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Constructor;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;

/* JADX INFO: compiled from: EventsSenderUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<String> f6041a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, i> f6042b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final a<Boolean> f6043c = null;

    static {
        f6041a = Collections.singletonList("EventsSenderUtils");
        f6042b = new ConcurrentHashMap();
        f6043c = new AnonymousClass1();
    }

    private static i b(String r3) {
        if (((Boolean) ZeusTransformUtils.preCheckCast(f6043c.c(new Object[0]), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L6;
        return null;
    L6:
        Map<String, i> r0 = f6042b;
        if (r0.containsKey(r3) == true) goto L11;
        i r1 = c(r3);
        r0.put(r3, r1);
        return r1;
    L11:
        return (i) ZeusTransformUtils.preCheckCast(r0.get(r3), i.class, "com.obric.aiagent.plugin");
    }

    public static void a(String r2, boolean r3, Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        i r6 = b(r2);
        if (r6 == null) goto L5;
        r6.setEnable(r3, r5);
        return;
    L5:
        com.bytedance.applog.log.m.a().d(f6041a, "can't find ET, should compile with ET", new Object[0]);
    }

    public static void a(String r0, String r1, JSONArray r2) {
        i r3 = b(r0);
        if (r3 == null) goto L6;
        r3.putEvent(r1, r2);
        return;
    }

    public static boolean a(String r4) {
        if (((Boolean) ZeusTransformUtils.preCheckCast(f6043c.c(new Object[0]), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L5;
        return false;
    L5:
        i r5 = b(r4);
        if (r5 != null) goto L9;
        return false;
    L9:
        return r5.isEnable();
    }

    public static void a(String r2, String r3) {
        i r4 = b(r2);
        if (r4 == null) goto L5;
        r4.setEventVerifyUrl(r3);
        return;
    L5:
        com.bytedance.applog.log.m.a().d(f6041a, "can't find ET, should compile with ET", new Object[0]);
    }

    public static String getType(com.bytedance.applog.store.a r1) {
        if (ZeusTransformUtils.instanceOf(r1, com.bytedance.applog.store.b.class) == false) goto L7;
        return "event";
    L7:
        if (ZeusTransformUtils.instanceOf(r1, com.bytedance.applog.store.d.class) == false) goto L11;
        return "event_v3";
    L11:
        if (ZeusTransformUtils.instanceOf(r1, com.bytedance.applog.store.c.class) == false) goto L15;
        return "log_data";
    L15:
        if (ZeusTransformUtils.instanceOf(r1, com.bytedance.applog.store.f.class) == false) goto L19;
        return "launch";
    L19:
        if (ZeusTransformUtils.instanceOf(r1, com.bytedance.applog.store.i.class) == false) goto L22;
        return "terminate";
    L22:
        return null;
    }

    private static i c(String r8) {
        if (((Boolean) ZeusTransformUtils.preCheckCast(f6043c.c(new Object[0]), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L5;
        return null;
    L5:
        com.bytedance.applog.c r9 = com.bytedance.applog.b.b(r8);
        if (r9 != null) goto L18;
        r9 = (com.bytedance.applog.c) ZeusTransformUtils.preCheckCast(com.bytedance.applog.a.a(), com.bytedance.applog.c.class, "com.obric.aiagent.plugin");
    L18:
        Constructor r1 = ZeusTransformUtils.forName("com.bytedance.applog.et_verify.EventVerify", "com.obric.aiagent.plugin").getConstructor(new Class[]{com.bytedance.applog.c.class});     // Catch: Throwable -> L13 Exception -> L16
        r1.setAccessible(true);     // Catch: Throwable -> L13 Exception -> L16
        i r10 = (i) ZeusTransformUtils.preCheckCast(r1.newInstance(new Object[]{r9}), i.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13 Exception -> L16
        if (r10 != null) goto L11;
        com.bytedance.applog.log.m.a().c(f6041a, "can't find event verify, should compile with ET", new Object[0]);
    L20:
        return r10;
    L11:
        com.bytedance.applog.log.m.a().b(f6041a, "found event sender: {}", new Object[]{r10});
        goto L20
    L16:
        com.bytedance.applog.log.m.a().c(f6041a, "can't find event verify, should compile with ET", new Object[0]);
        return null;
    L13:
        th = move-exception;
        com.bytedance.applog.log.m.a().c(f6041a, "can't find event verify, should compile with ET", new Object[0]);
        throw th;
    }
}
