package com.obric.agent.utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: ClientToolReportHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f16043a = null;

    static {
        f16043a = new l();
    }

    private l() {
    }

    public final k a(String r4, g r5) {
        d.h.b.o.e(r4, "questionId");
        d.h.b.o.e(r5, "toolInfo");
        com.obric.agent.trace.omni.a r6 = com.obric.agent.trace.omni.k.f15686a.b(r4);
        if (r6 != null) goto L5;
        return null;
    L5:
        List r7 = (List) ZeusTransformUtils.preCheckCast(r6.b().get("dispatch_intent_start"), List.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L13;
        Object r8 = d.a.p.n(r7);
        if (r8 == null) goto L13;
        if (ZeusTransformUtils.instanceOf(r8, com.obric.agent.trace.omni.t.class) == false) goto L13;
    L14:
        com.obric.agent.trace.omni.t r9 = (com.obric.agent.trace.omni.t) ZeusTransformUtils.preCheckCast(r8, com.obric.agent.trace.omni.t.class, "com.obric.aiagent.plugin");
        if (r9 != null) goto L17;
        return null;
    L17:
        if (f16043a.a(r9, r5) == true) goto L20;
        r9 = null;
    L20:
        if (r9 != null) goto L22;
        return null;
    L22:
        return a(r9);
    L13:
        r8 = null;
        goto L14
    }

    private final boolean a(com.obric.agent.trace.omni.t r5, g r6) {
        boolean r0 = false;
        if (d.h.b.o.a(r5.b(), r6.a()) == true) goto L6;
        return false;
    L6:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r6.b(), CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == false) goto L14;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5.a(), CharSequence.class, "com.obric.aiagent.plugin")).length() == 0) goto L21;
        return false;
    L21:
        return true;
    L14:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5.a(), CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L16;
        r0 = true;
    L16:
        if (r0 == true) goto L21;
        return d.h.b.o.a(r5.a(), r6.b());
    L8:
        r4 = false;
        goto L9
    }

    private final k a(com.obric.agent.trace.omni.t r8) {
        long r5 = System.currentTimeMillis();
        return new k(d.l.n.a(r5 - r8.c(), 0), r8.c(), r5);
    }
}
