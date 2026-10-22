package com.bytedance.applog.log;

import com.bytedance.applog.util.p;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;

/* JADX INFO: compiled from: LogUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile Boolean f5718a;

    static {
        f5718a = false;
    }

    public static boolean a() {
        return !f5718a.booleanValue();
    }

    public static void a(String r3, EventBus.a r4) {
        EventBus.a r5 = (EventBus.a) ZeusTransformUtils.wrapperContextForParams(r4, EventBus.a.class, "com.obric.aiagent.plugin");
        if (a() == false) goto L5;
        return;
    L5:
        if (p.b(r3) == true) goto L10;
        ((EventBus) ZeusTransformUtils.preCheckCast(EventBus.global.b(new Object[0]), EventBus.class, "com.obric.aiagent.plugin")).emit(a(r3), r5);
        return;
    }

    public static void a(String r3, String r4) {
        if (a() == false) goto L5;
        return;
    L5:
        if (p.b(r3) == true) goto L10;
        ((EventBus) ZeusTransformUtils.preCheckCast(EventBus.global.b(new Object[0]), EventBus.class, "com.obric.aiagent.plugin")).emit(a(r3), r4);
        return;
    }

    public static void a(String r3, final Object r4) {
        if (a() == false) goto L5;
        return;
    L5:
        if (p.b(r3) == false) goto L8;
        return;
    L8:
        if (ZeusTransformUtils.instanceOf(r4, com.bytedance.applog.store.a.class) == false) goto L10;
        ((EventBus) ZeusTransformUtils.preCheckCast(EventBus.global.b(new Object[0]), EventBus.class, "com.obric.aiagent.plugin")).emit(a(r3), new AnonymousClass1(r4));
        return;
    L10:
        ((EventBus) ZeusTransformUtils.preCheckCast(EventBus.global.b(new Object[0]), EventBus.class, "com.obric.aiagent.plugin")).emit(a(r3), r4);
    }

    private static String a(String r2) {
        return "applog_" + r2;
    }

    public static String a(com.bytedance.applog.store.a r4) {
        if (r4 != null) goto L6;
        return "";
    L6:
        if (ZeusTransformUtils.instanceOf(r4, com.bytedance.applog.store.e.class) == false) goto L10;
        return "FORWARD_EVENT";
    L10:
        if (ZeusTransformUtils.instanceOf(r4, com.bytedance.applog.store.d.class) == false) goto L17;
        if ("applog_trace".equals(((com.bytedance.applog.store.d) ZeusTransformUtils.preCheckCast(r4, com.bytedance.applog.store.d.class, "com.obric.aiagent.plugin")).s()) == false) goto L15;
        return "TRACE";
    L15:
        return "EVENT_V3";
    L17:
        if (ZeusTransformUtils.instanceOf(r4, com.bytedance.applog.store.h.class) == false) goto L20;
        return "EVENT_V3";
    L20:
        if (ZeusTransformUtils.instanceOf(r4, com.bytedance.applog.store.b.class) == false) goto L24;
        return ((com.bytedance.applog.store.b) ZeusTransformUtils.preCheckCast(r4, com.bytedance.applog.store.b.class, "com.obric.aiagent.plugin")).u.toUpperCase(Locale.ROOT);
    L24:
        if (ZeusTransformUtils.instanceOf(r4, com.bytedance.applog.store.f.class) == false) goto L28;
        return "LAUNCH";
    L28:
        if (ZeusTransformUtils.instanceOf(r4, com.bytedance.applog.store.i.class) == false) goto L32;
        return "TERMINATE";
    L32:
        if (ZeusTransformUtils.instanceOf(r4, com.bytedance.applog.store.c.class) == false) goto L35;
        return "LOG_DATA";
    L35:
        return "";
    }
}
