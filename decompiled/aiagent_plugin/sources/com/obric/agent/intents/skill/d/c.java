package com.obric.agent.intents.skill.d;

import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.aiagent.skill.manager.api.ISkillInstallAttributionService;
import com.obric.aiagent.skill.manager.api.q;
import com.obric.assistant.dm.api.statemachine.core.DMState;
import com.obric.assistant.dm.api.statemachine.core.State;
import com.obric.assistant.dm.api.statemachine.core.TaskInfo;
import com.obric.assistant.dm.api.statemachine.core.TaskState;
import com.obric.assistant.dm.api.statemachine.manager.IDialogStateManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.h.b.p;
import d.n;
import d.n.m;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SkillInstallMethodResolver.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f15092a = null;

    /* JADX INFO: compiled from: _Sequences.kt */
    public static final class b extends p implements d.h.a.b<Object, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f15094a = null;

        static {
            f15094a = new b();
        }

        public b() {
            super(1);
        }

        public final Boolean a(Object r1) {
            return Boolean.valueOf(ZeusTransformUtils.instanceOf(r1, TaskState.class));
        }

        @Override // d.h.a.b
        public /* synthetic */ Boolean invoke(Object r1) {
            return a(r1);
        }
    }

    static {
        f15092a = new c();
    }

    private c() {
    }

    public final Object a(q r9, String r10, String r11, d.c.d<? super q> r12) {
        d.c.d r13 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        if (r9 == q.f19298d) goto L5;
        return r9;
    L5:
        IDialogStateManager r14 = (IDialogStateManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IDialogStateManager.class), IDialogStateManager.class, "com.obric.aiagent.plugin");
        boolean r1 = true;
        String r3 = null;
        if (r11 != null) goto L8;
    L24:
        TaskInfo r4 = null;
    L119:
        n.a r5 = n.f38560a;     // Catch: Throwable -> L52
        c r6 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L52
        if (r14 == null) goto L49;
        DMState r15 = r14.getCurrentDMState();     // Catch: Throwable -> L52
        if (r15 == null) goto L49;
        List<State> r16 = r15.getActiveTasks();     // Catch: Throwable -> L52
        if (r16 == null) goto L49;
        d.n.j r17 = d.a.p.y((Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L52
        if (r17 == null) goto L49;
        d.n.j r18 = m.a(r17, (d.h.a.b) ZeusTransformUtils.preCheckCast(b.f15094a, d.h.a.b.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L52
        o.a(r18, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");     // Catch: Throwable -> L52
        if (r18 == null) goto L49;
        d.n.j r19 = m.e(r18, (d.h.a.b) ZeusTransformUtils.preCheckCast(a.f15093a, d.h.a.b.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L52
        if (r19 == null) goto L49;
        Iterator r110 = r19.a();     // Catch: Throwable -> L52
    L39:
        if (r110.hasNext() == false) goto L47;
        Object r7 = r110.next();     // Catch: Throwable -> L52
        Map<String, String> r8 = ((TaskInfo) ZeusTransformUtils.preCheckCast(r7, TaskInfo.class, "com.obric.aiagent.plugin")).getExt();     // Catch: Throwable -> L52
        if (r8 == null) goto L43;
        String r20 = (String) ZeusTransformUtils.preCheckCast(r8.get("o_omni_task_id"), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L52
    L45:
        if (o.a(r20, r10) == false) goto L39;
    L48:
        TaskInfo r111 = (TaskInfo) ZeusTransformUtils.preCheckCast(r7, TaskInfo.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L52
    L50:
        Object r112 = n.f(r111);     // Catch: Throwable -> L52
    L55:
        if (n.b(r112) == false) goto L57;
        r112 = null;
    L57:
        TaskInfo r113 = (TaskInfo) ZeusTransformUtils.preCheckCast(r112, TaskInfo.class, "com.obric.aiagent.plugin");
        String[] r114 = new String[5];
        if (r11 != null) goto L60;
    L62:
        r11 = null;
    L63:
        r114[0] = r11;
        if (r4 == null) goto L70;
        String r115 = r4.getQueryId();
        if (r115 == null) goto L70;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r115, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L70;
    L71:
        r114[1] = r115;
        if (r4 == null) goto L80;
        IMMessage r21 = r4.getMessage();
        if (r21 == null) goto L80;
        String r22 = r21.getMessageId();
        if (r22 == null) goto L80;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r22, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L80;
    L81:
        r114[2] = r22;
        if (r113 == null) goto L88;
        String r23 = r113.getQueryId();
        if (r23 == null) goto L88;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r23, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L88;
    L89:
        r114[3] = r23;
        if (r113 == null) goto L98;
        IMMessage r116 = r113.getMessage();
        if (r116 == null) goto L98;
        String r117 = r116.getMessageId();
        if (r117 == null) goto L98;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r117, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L98;
        r3 = r117;
    L98:
        r114[4] = r3;
        List<String> r118 = d.a.p.s((Iterable) ZeusTransformUtils.preCheckCast(d.a.p.e(r114), Iterable.class, "com.obric.aiagent.plugin"));
        n.a r119 = n.f38560a;     // Catch: Throwable -> L107
        c r24 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L107
        ISkillInstallAttributionService r25 = (ISkillInstallAttributionService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ISkillInstallAttributionService.class), ISkillInstallAttributionService.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L107
        if (r25 != null) goto L102;
    L104:
        r1 = false;
    L105:
        Object r26 = n.f(d.c.b.a.b.a(r1));     // Catch: Throwable -> L107
    L109:
        Boolean r120 = d.c.b.a.b.a(false);
        if (n.b(r26) == false) goto L113;
        r26 = r120;
    L113:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r26, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L115;
        return r9;
    L115:
        return q.i;
    L102:
        if (r25.consumeGuiLinkImport(r118) != true) goto L104;
    L107:
        th = move-exception;
        n.a r121 = n.f38560a;
        r26 = n.f(d.o.a(th));
    L88:
        r23 = null;
    L80:
        r22 = null;
    L70:
        r115 = null;
        goto L71
    L60:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L62;
    L43:
        r20 = null;
        goto L45
    L47:
        r7 = null;
    L49:
        r111 = null;
    L52:
        th = move-exception;
        n.a r122 = n.f38560a;
        r112 = n.f(d.o.a(th));
        goto L55
    L8:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L10;
        String r27 = r11;
    L11:
        if (r27 == null) goto L24;
        n.a r28 = n.f38560a;     // Catch: Throwable -> L18
        if (r14 == null) goto L15;
        TaskInfo r29 = r14.getStateMachinesFromQuestionId(r27);     // Catch: Throwable -> L18
    L16:
        Object r30 = n.f(r29);     // Catch: Throwable -> L18
    L21:
        if (n.b(r30) == false) goto L23;
        r30 = null;
    L23:
        r4 = (TaskInfo) ZeusTransformUtils.preCheckCast(r30, TaskInfo.class, "com.obric.aiagent.plugin");
        goto L119
    L15:
        r29 = null;
    L18:
        th = move-exception;
        n.a r31 = n.f38560a;
        r30 = n.f(d.o.a(th));
        goto L21
    L10:
        r27 = null;
        goto L11
    }
}
