package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: LocationMonitorModels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f17157a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final d.f f17158b = null;

    /* JADX INFO: renamed from: lambda$-ornCabuAuSZp3v6Xf6arVugcYA, reason: not valid java name */
    public static /* synthetic */ p m168lambda$ornCabuAuSZp3v6Xf6arVugcYA() {
        return c();
    }

    private q() {
    }

    static {
        f17157a = new q();
        f17158b = d.g.a($$Lambda$q$ornCabuAuSZp3v6Xf6arVugcYA.INSTANCE);
    }

    private final p b() {
        return (p) ZeusTransformUtils.preCheckCast(f17158b.b(), p.class, "com.obric.aiagent.plugin");
    }

    private static final p c() {
        Integer r0 = Integer.valueOf(com.obric.event.task.base.a.c.a(com.obric.event.task.base.a.b.f32673b));
        boolean r3 = true;
        if (((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.aiagent.plugin")).intValue() <= 0) goto L5;
        boolean r1 = true;
    L6:
        Integer r5 = null;
        if (r1 == true) goto L10;
        r0 = null;
    L10:
        if (r0 == null) goto L12;
        int r2 = r0.intValue();
    L13:
        Integer r4 = Integer.valueOf(com.obric.event.task.base.a.c.a(com.obric.event.task.base.a.b.f32674c));
        if (((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).intValue() > 0) goto L17;
        r3 = false;
    L17:
        if (r3 == false) goto L19;
        r5 = r4;
    L19:
        if (r5 == null) goto L21;
        int r6 = r5.intValue();
    L23:
        return f17157a.a(r2, r6);
    L21:
        r6 = ((Number) ZeusTransformUtils.preCheckCast(com.obric.event.task.base.a.b.f32674c.b(), Number.class, "com.obric.aiagent.plugin")).intValue();
        goto L23
    L12:
        r2 = ((Number) ZeusTransformUtils.preCheckCast(com.obric.event.task.base.a.b.f32673b.b(), Number.class, "com.obric.aiagent.plugin")).intValue();
        goto L13
    L5:
        r1 = false;
        goto L6
    }

    public final p a() {
        return b();
    }

    private final p a(int r5, int r6) {
        long r4 = ((long) r5) * 60000;
        return new p(r4, d.l.n.b(((long) r6) * 1000, r4));
    }
}
