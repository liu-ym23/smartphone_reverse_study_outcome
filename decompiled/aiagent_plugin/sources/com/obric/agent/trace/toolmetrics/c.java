package com.obric.agent.trace.toolmetrics;

import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.funcall_api.bean.IntentAppAction;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OmniClientIntentCallbackTrace.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f15872a = null;

    static {
        f15872a = new c();
    }

    private c() {
    }

    public final Long a(IntentAppAction r12, IntentResult<?> r13) {
        d.h.b.o.e(r13, "result");
        if (r12 == null) goto L23;
        Long r14 = Long.valueOf(r12.getMessageId());
        if (((Number) ZeusTransformUtils.preCheckCast(r14, Number.class, "com.obric.aiagent.plugin")).longValue() < 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L11;
        r14 = null;
    L11:
        if (r14 == null) goto L24;
        long r1 = ((Number) ZeusTransformUtils.preCheckCast(r14, Number.class, "com.obric.aiagent.plugin")).longValue();
        if (r13.isFinal() == false) goto L22;
        c r11 = f15872a;
        IOmniClientToolTraceService r2 = IOmniClientToolTraceService.Companion.a();
        if (r2 == null) goto L22;
        z r3 = r2.findByMessageId(String.valueOf(r1));
        if (r3 == null) goto L22;
        r2.append(r3, new n(null, null, r11.a(r13), null, null, 27, null));
        r2.markCorePoint(r3, j.f15894b);
    L22:
        return r14;
    L24:
        return null;
    L7:
        r0 = false;
        goto L8
    L23:
        return null;
    }

    public final void a(Long r9, IntentResult<?> r10, Exception r11) {
        d.h.b.o.e(r10, "result");
        if (r9 != null) goto L5;
        return;
    L5:
        if (r10.isFinal() == false) goto L24;
        if (r11 == null) goto L9;
    L11:
        g.f15887a.b(r9.longValue());
        long r8 = r9.longValue();
        IOmniClientToolTraceService r12 = IOmniClientToolTraceService.Companion.a();
        if (r12 == null) goto L25;
        z r13 = r12.findByMessageId(String.valueOf(r8));
        if (r13 != null) goto L18;
        return;
    L18:
        if (r11 == null) goto L20;
        m r14 = new m(r11.getClass().getName(), r11.getMessage());
    L21:
        r12.append(r13, new n(null, null, null, r14, null, 23, null));
        r12.finish(r13);
        return;
    L20:
        r14 = null;
        goto L21
    L25:
        return;
    L9:
        if (g.f15887a.a(r9.longValue()) == false) goto L11;
        return;
    }

    private final m a(IntentResult<?> r2) {
        String r1 = String.valueOf(r2.getRet());
        String r0 = r2.getDetails();
        if (r2.getRet() == 0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == true) goto L9;
        r0 = null;
    L9:
        if (r0 != null) goto L12;
        r0 = "";
    L12:
        return new m(r1, r0);
    L5:
        r3 = false;
        goto L6
    }

    public final void a(long r9, boolean r11, Throwable r12) {
        if (r11 == true) goto L4;
        return;
    L4:
        IOmniClientToolTraceService r8 = IOmniClientToolTraceService.Companion.a();
        if (r8 == null) goto L16;
        z r10 = r8.findByMessageId(String.valueOf(r9));
        if (r10 != null) goto L11;
        return;
    L11:
        if (r12 == null) goto L13;
        m r13 = new m(r12.getClass().getName(), r12.getMessage());
    L14:
        r8.append(r10, new n(null, null, null, r13, null, 23, null));
        r8.finish(r10);
        return;
    L13:
        r13 = null;
        goto L14
    }
}
