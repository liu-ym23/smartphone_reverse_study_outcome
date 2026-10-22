package com.bytedance.applog.monitor;

import com.bytedance.applog.monitor.v3.MonitorV3Helper;
import com.bytedance.applog.monitor.v3.h;
import com.bytedance.applog.store.d;
import com.bytedance.applog.store.f;
import com.bytedance.applog.store.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: MonitorUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    public static boolean a(MonitorV3Helper r3, com.bytedance.applog.store.a r4) {
        if (r3.isStageEnabled() == true) goto L6;
        return false;
    L6:
        if (ZeusTransformUtils.instanceOf(r4, com.bytedance.applog.store.b.class) == false) goto L10;
        return r3.isEventHitStage(((com.bytedance.applog.store.b) ZeusTransformUtils.preCheckCast(r4, com.bytedance.applog.store.b.class, "com.obric.aiagent.plugin")).w);
    L10:
        if (ZeusTransformUtils.instanceOf(r4, d.class) == false) goto L14;
        return r3.isEventHitStage(((d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin")).s());
    L14:
        if (ZeusTransformUtils.instanceOf(r4, com.bytedance.applog.store.c.class) == false) goto L18;
        return r3.isEventHitStage(((com.bytedance.applog.store.c) ZeusTransformUtils.preCheckCast(r4, com.bytedance.applog.store.c.class, "com.obric.aiagent.plugin")).r());
    L18:
        if (ZeusTransformUtils.instanceOf(r4, f.class) == false) goto L22;
        return r3.isEventHitStage("launch");
    L22:
        if (ZeusTransformUtils.instanceOf(r4, i.class) == true) goto L24;
        return false;
    L24:
        return r3.isEventHitStage("terminate");
    }

    public static boolean b(MonitorV3Helper r3, com.bytedance.applog.store.a r4) {
        if (r3.isStageEnabled() == true) goto L6;
        return false;
    L6:
        if (ZeusTransformUtils.instanceOf(r4, com.bytedance.applog.store.b.class) == false) goto L10;
        return r3.isEventMaybeAccepted(((com.bytedance.applog.store.b) ZeusTransformUtils.preCheckCast(r4, com.bytedance.applog.store.b.class, "com.obric.aiagent.plugin")).w);
    L10:
        if (ZeusTransformUtils.instanceOf(r4, d.class) == false) goto L14;
        return r3.isEventMaybeAccepted(((d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin")).s());
    L14:
        if (ZeusTransformUtils.instanceOf(r4, com.bytedance.applog.store.c.class) == false) goto L18;
        return r3.isEventMaybeAccepted(((com.bytedance.applog.store.c) ZeusTransformUtils.preCheckCast(r4, com.bytedance.applog.store.c.class, "com.obric.aiagent.plugin")).r());
    L18:
        if (ZeusTransformUtils.instanceOf(r4, f.class) == false) goto L22;
        return r3.isEventMaybeAccepted("launch");
    L22:
        if (ZeusTransformUtils.instanceOf(r4, i.class) == true) goto L24;
        return false;
    L24:
        return r3.isEventMaybeAccepted("terminate");
    }

    public static void a(MonitorV3Helper r9, com.bytedance.applog.monitor.v3.a r10, com.bytedance.applog.store.a r11) {
        if (r9.isStageEnabled() == true) goto L6;
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r11, com.bytedance.applog.store.b.class) == false) goto L9;
        r9.stageEvent(r10, ((com.bytedance.applog.store.b) ZeusTransformUtils.preCheckCast(r11, com.bytedance.applog.store.b.class, "com.obric.aiagent.plugin")).v, String.valueOf(r11.r), r11.f5992b, com.bytedance.applog.monitor.v3.i.f5807b);
        return;
    L9:
        if (ZeusTransformUtils.instanceOf(r11, d.class) == false) goto L12;
        r9.stageEvent(r10, ((d) ZeusTransformUtils.preCheckCast(r11, d.class, "com.obric.aiagent.plugin")).s(), String.valueOf(r11.r), r11.f5992b, com.bytedance.applog.monitor.v3.i.f5806a);
        return;
    L12:
        if (ZeusTransformUtils.instanceOf(r11, com.bytedance.applog.store.c.class) == false) goto L15;
        r9.stageEvent(r10, ((com.bytedance.applog.store.c) ZeusTransformUtils.preCheckCast(r11, com.bytedance.applog.store.c.class, "com.obric.aiagent.plugin")).r(), String.valueOf(r11.r), r11.f5992b, com.bytedance.applog.monitor.v3.i.f5808c);
        return;
    L15:
        if (ZeusTransformUtils.instanceOf(r11, f.class) == false) goto L18;
        r9.stageEvent(r10, "launch", String.valueOf(r11.r), r11.f5992b, com.bytedance.applog.monitor.v3.i.f5809d);
        return;
    L18:
        if (ZeusTransformUtils.instanceOf(r11, i.class) == false) goto L25;
        r9.stageEvent(r10, "terminate", String.valueOf(r11.r), r11.f5992b, com.bytedance.applog.monitor.v3.i.f5810e);
        return;
    }

    public static void a(MonitorV3Helper r10, com.bytedance.applog.monitor.v3.a r11, h r12) {
        if (r10.isStageEnabled() == true) goto L5;
        return;
    L5:
        r10.stageEvent(r12.f5805e, r12.f, r11, r12.f5801a, r12.f5802b, r12.f5803c, r12.f5804d);
    }

    public static int c(MonitorV3Helper r0, com.bytedance.applog.store.a r1) {
        if (a(r0, r1) == true) goto L5;
        return 0;
    L5:
        if (r0.isDebugMode() == false) goto L9;
        return 3;
    L9:
        return 1;
    }

    public static void a(com.bytedance.applog.store.a r5) {
        if (com.bytedance.applog.monitor.a.b.a().b() == true) goto L6;
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, com.bytedance.applog.store.b.class) == false) goto L9;
        com.bytedance.applog.monitor.a.b.a().a(com.bytedance.applog.monitor.v3.i.f5807b, ((com.bytedance.applog.store.b) ZeusTransformUtils.preCheckCast(r5, com.bytedance.applog.store.b.class, "com.obric.aiagent.plugin")).v, r5.f5992b);
        return;
    L9:
        if (ZeusTransformUtils.instanceOf(r5, d.class) == false) goto L12;
        com.bytedance.applog.monitor.a.b.a().a(com.bytedance.applog.monitor.v3.i.f5806a, ((d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin")).s(), r5.f5992b);
        return;
    L12:
        if (ZeusTransformUtils.instanceOf(r5, com.bytedance.applog.store.c.class) == false) goto L17;
        com.bytedance.applog.monitor.a.b.a().a(com.bytedance.applog.monitor.v3.i.f5808c, ((com.bytedance.applog.store.c) ZeusTransformUtils.preCheckCast(r5, com.bytedance.applog.store.c.class, "com.obric.aiagent.plugin")).r(), r5.f5992b);
        return;
    }
}
