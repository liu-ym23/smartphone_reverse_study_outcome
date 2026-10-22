package com.obric.autogui.b;

import android.content.Context;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.AutoOperateTask;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.agent.BizStatus;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.d;
import d.c.b.a.f;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: TaskExecutor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f28935a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f28936b;

    /* JADX INFO: compiled from: TaskExecutor.kt */
    @f(b = "TaskExecutor.kt", c = {118}, d = "activateSession", e = "com.obric.autogui.tasks.TaskExecutor")
    static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f28937a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f28938b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f28939c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f28940d;

        a(b r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28939c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f28938b = r3;
            this.f28940d |= Integer.MIN_VALUE;
            return b.a(this.f28939c, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public final void a() {
    }

    private b() {
    }

    public static final /* synthetic */ Object a(b r2, com.obric.autogui.session.a r3, d.c.d r4) {
        return r2.a(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    static {
        f28935a = new b();
        f28936b = "";
    }

    public final Object a(com.obric.autogui.session.a r3, e r4, int r5, d.c.d<? super x> r6) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        AOSystemTools.INSTANCE.nowTimeMillis();
        StringBuilder r7 = new StringBuilder().append("AutoGUIEndOfRunning");
        int r0 = 0;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(f28936b, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L5;
        boolean r8 = true;
    L6:
        if (r8 == false) goto L8;
        r7.append(" -- [" + f28936b + ']');
        f28936b = "";
    L8:
        if (r4 == null) goto L11;
        r7.append(" ++ (" + r4.h() + ", " + r5 + ')');
    L11:
        if (r3 != null) goto L13;
    L17:
        Loog.INSTANCE.i("AutoGUI", r7.toString());
        return x.f38692a;
    L13:
        if (r3.m() == null) goto L17;
        if (r5 != 2) goto L16;
        r0 = 1101;
    L16:
        com.obric.autogui.session.state.d.f31396a.a(r3, r4, r0);
        goto L17
    L5:
        r8 = false;
        goto L6
    }

    public final void a(com.obric.autogui.session.a r3) {
        StringBuilder r2 = new StringBuilder().append("AutoGUIStartOfRunning");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(f28936b, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L8;
        r2.append(" -- [" + f28936b + ']');
        f28936b = "";
    L8:
        Loog.INSTANCE.i("AutoGUI", r2.toString());
        return;
    L5:
        r4 = false;
        goto L6
    }

    public final Object a(Context r3, AutoOperateTask r4, d.c.d<? super e> r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        d.c.d<? super e> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return a(new com.obric.autogui.session.a.C0830a().a(r6).a(r4).a(), r7);
    }

    public final com.obric.autogui.session.a a(Context r2, AutoOperateTask r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "appContext");
        o.e(r3, "task");
        return new com.obric.autogui.session.a.C0830a().a(r1).a(r3).a();
    }

    public final Object a(com.obric.autogui.session.a r3, AutoOperateTask r4, d.c.d<? super e> r5) {
        d.c.d<? super e> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        r3.b(r4);
        return a(r3, r6);
    }

    private final Object a(com.obric.autogui.session.a r19, d.c.d<? super e> r20) {
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r20, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, a.class) == false) goto L7;
        a r2 = (a) ZeusTransformUtils.preCheckCast(r0, a.class, "com.obric.aiagent.plugin");
        if ((r2.f28940d & Integer.MIN_VALUE) == 0) goto L7;
        r2.f28940d -= Integer.MIN_VALUE;
    L8:
        Object r1 = r2.f28938b;
        Object r3 = d.c.a.b.a();
        int r4 = r2.f28940d;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        com.obric.autogui.session.a r5 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r2.f28937a, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
        d.o.a(r1);
    L18:
        e r6 = (e) ZeusTransformUtils.preCheckCast(r1, e.class, "com.obric.aiagent.plugin");
        com.obric.autogui.session.c.a.b(r5.O(), "ses_queue", "launch", 0, 4, null);
        return r6;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r1);
        com.obric.autogui.session.c.a.a(r19.O(), "ses_all", "all", 0, 4, null);
        com.obric.autogui.session.c.a.a(r19.O(), "ses_queue", "launch", 0, 4, null);
        com.obric.autogui.session.state.b r7 = r19.m();
        BizStatus r8 = BizStatus.QUEUEING;
        BizStatus.StatusChangedReasonStruct r9 = BizStatus.StatusChangedReasonStruct.Companion.getDEFAULT();
        r2.f28937a = r19;
        r2.f28940d = 1;
        r1 = r7.a(r8, r9, r2);
        if (r1 != r3) goto L17;
        return r3;
    L17:
        r5 = r19;
    L7:
        r2 = new a(this, r0);
        goto L8
    }

    public final e a(String r5) {
        com.obric.autogui.session.a r4 = com.obric.autogui.session.c.f30777a.b();
        if (r4 == null) goto L5;
        if (r5 != null) goto L8;
    L11:
        e r6 = r4.J().c();
        if (r6.g() == false) goto L14;
        com.obric.autogui.agents.vlm.cocreation.a.a(com.obric.autogui.agents.vlm.cocreation.a.f27230a, r4, null, 2, null);
    L14:
        return r6;
    L8:
        if (o.a(r5, r4.a()) == true) goto L11;
        return e.f29014b.b("当前session已不在运行，无法stop");
    L5:
        return e.a.a(e.f29014b, ZeusTransformUtils.mapRes(R.string.agent_task_not_started_cannot_terminate, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_task_not_started_cannot_terminate"), null, 2, null);
    }
}
