package com.obric.aiagent.executionengine.scheduler.impl.a;

import com.google.gson.Gson;
import com.obric.agent.trace.toolmetrics.IOmniClientToolTraceService;
import com.obric.agent.trace.toolmetrics.z;
import com.obric.capabilitykit.common.AppAction;
import com.obric.capabilitykit.common.FeedbackResult;
import com.obric.capabilitykit.common.IMAppActionExt;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.n;
import d.x;
import org.json.JSONObject;

/* JADX INFO: compiled from: OmniClientIntentExecutionTrace.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f18144a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Gson f18145b = null;

    private m() {
    }

    static {
        f18144a = new m();
        f18145b = new Gson();
    }

    public final void a(AppAction r17, com.obric.aiagent.executionengine.scheduler.impl.job.c r18) {
        o.e(r17, "appAction");
        o.e(r18, "job");
        IMAppActionExt r1 = r18.b().getExt();
        if (r1 == null) goto L23;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r1.get("o_omni_task_id"), String.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L7;
        return;
    L7:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L10;
        r3 = null;
    L10:
        if (r3 == null) goto L25;
        n.a r4 = n.f38560a;     // Catch: Throwable -> L18
        m r5 = (m) ZeusTransformUtils.preCheckCast(this, m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
        IOmniClientToolTraceService r6 = IOmniClientToolTraceService.Companion.a();     // Catch: Throwable -> L18
        if (r6 == null) goto L16;
        r6.append(r6.begin(), new com.obric.agent.trace.toolmetrics.n(new com.obric.agent.trace.toolmetrics.l(MemorySourceLinkType.INTENT, r5.a(r17), r17.getAction()), new com.obric.agent.trace.toolmetrics.k(r3, String.valueOf(r18.d()), String.valueOf(r18.c()), (String) ZeusTransformUtils.preCheckCast(r1.get("o_execute_id"), String.class, "com.obric.aiagent.plugin")), null, null, null, 28, null));     // Catch: Throwable -> L18
    L16:
        n.f(x.f38692a);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        n.a r2 = n.f38560a;
        n.f(d.o.a(th));
        return;
    L25:
        return;
    }

    public final void a(long r1) {
        IOmniClientToolTraceService r0 = IOmniClientToolTraceService.Companion.a();
        if (r0 == null) goto L8;
        z r2 = r0.findByMessageId(String.valueOf(r1));
        if (r2 == null) goto L9;
        r0.markCorePoint(r2, com.obric.agent.trace.toolmetrics.j.f15893a);
        return;
    L9:
        return;
    }

    public final String b(long r4) {
        Object r1 = null;
        n.a r2 = n.f38560a;     // Catch: Throwable -> L11
        m r3 = (m) ZeusTransformUtils.preCheckCast(this, m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        IOmniClientToolTraceService r5 = IOmniClientToolTraceService.Companion.a();     // Catch: Throwable -> L11
        if (r5 == null) goto L8;
        z r6 = r5.findByMessageId(String.valueOf(r4));     // Catch: Throwable -> L11
        if (r6 == null) goto L8;
        String r7 = r6.a();     // Catch: Throwable -> L11
    L9:
        Object r8 = n.f(r7);     // Catch: Throwable -> L11
    L14:
        if (n.b(r8) == true) goto L18;
        r1 = r8;
    L18:
        return (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.aiagent.plugin");
    L8:
        r7 = null;
    L11:
        th = move-exception;
        n.a r9 = n.f38560a;
        r8 = n.f(d.o.a(th));
        goto L14
    }

    public final void a(long r11, com.obric.aiagent.executionengine.scheduler.impl.job.c.C0383c r13) {
        if (r13 != null) goto L4;
        return;
    L4:
        IOmniClientToolTraceService r0 = IOmniClientToolTraceService.Companion.a();
        if (r0 == null) goto L18;
        z r12 = r0.findByMessageId(String.valueOf(r11));
        if (r12 == null) goto L19;
        IntentResult<?> r14 = r13.a();
        boolean r1 = false;
        if (r14 != null) goto L12;
    L14:
        if (r1 == false) goto L16;
        return;
    L16:
        r0.append(r12, new com.obric.agent.trace.toolmetrics.n(null, null, a(r13), null, null, 27, null));
        r0.markCorePoint(r12, com.obric.agent.trace.toolmetrics.j.f15894b);
        return;
    L12:
        if (r14.isFinal() == true) goto L14;
        r1 = true;
        goto L14
    L19:
        return;
    }

    public final void b(long r2, com.obric.aiagent.executionengine.scheduler.impl.job.c.C0383c r4) {
        o.e(r4, "result");
        a(r2, r4);
    }

    private final String a(AppAction r4) {
        n.a r0 = n.f38560a;     // Catch: Throwable -> L11
        String r1 = r4.getParams();     // Catch: Throwable -> L11
        if (r1 != null) goto L6;
        r1 = "";
    L6:
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(new JSONObject(r1).optString("ext"), CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        if (d.o.o.d(r2) == false) goto L9;
        r2 = "{}";
    L9:
        Object r3 = n.f(new JSONObject((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin")).optString("tool_id"));     // Catch: Throwable -> L11
    L13:
        String r5 = null;
        if (n.b(r3) == false) goto L16;
        r3 = null;
    L16:
        String r6 = (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L24;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L21;
        r5 = r6;
    L21:
        if (r5 == null) goto L24;
        return r5;
    L24:
        return r4.getAction();
    L11:
        th = move-exception;
        n.a r7 = n.f38560a;
        r3 = n.f(d.o.a(th));
        goto L13
    }

    private final com.obric.agent.trace.toolmetrics.m a(com.obric.aiagent.executionengine.scheduler.impl.job.c.C0383c r7) {
        IntentResult<?> r0 = r7.a();
        String r1 = "";
        boolean r2 = true;
        String r4 = null;
        if (r0 == null) goto L15;
        String r6 = String.valueOf(r0.getRet());
        String r8 = r0.getDetails();
        if (r0.getRet() != 0) goto L8;
        r2 = false;
    L8:
        if (r2 == false) goto L10;
        r4 = r8;
    L10:
        if (r4 == null) goto L14;
        r1 = r4;
    L14:
        return new com.obric.agent.trace.toolmetrics.m(r6, r1);
    L15:
        String r9 = r7.b().getContent();
        if (r9 != null) goto L38;
    L37:
        return null;
    L38:
        n.a r3 = n.f38560a;     // Catch: Throwable -> L19
        Object r10 = n.f((FeedbackResult) ZeusTransformUtils.preCheckCast(f18145b.fromJson(r9, FeedbackResult.class), FeedbackResult.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L19
    L22:
        if (n.b(r10) == false) goto L24;
        r10 = null;
    L24:
        FeedbackResult r11 = (FeedbackResult) ZeusTransformUtils.preCheckCast(r10, FeedbackResult.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L37;
        String r12 = String.valueOf(r11.getCode());
        String r5 = r11.getMsg();
        if (r11.getCode() != 0) goto L30;
        r2 = false;
    L30:
        if (r2 == false) goto L32;
        r4 = r5;
    L32:
        if (r4 == null) goto L36;
        r1 = r4;
    L36:
        return new com.obric.agent.trace.toolmetrics.m(r12, r1);
    L19:
        th = move-exception;
        n.a r13 = n.f38560a;
        r10 = n.f(d.o.a(th));
        goto L22
    }
}
