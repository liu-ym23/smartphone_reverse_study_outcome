package com.obric.autogui.evaluation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.obric.aiagent.assistant.idl.IFlowNetworkIDL;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.autogui.common.api.agent.IAutoActionAgentApi;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.obric.autogui.common.e;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.c.b.a.f;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.aa;
import d.h.b.h;
import d.h.b.o;
import d.h.b.z;
import d.s;
import d.x;
import kotlinx.coroutines.am;

/* JADX INFO: compiled from: AutoGUITaskEvaluatingReceiverImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoGUITaskEvaluatingReceiverImpl extends PluginBroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f29051a = null;

    /* JADX INFO: compiled from: AutoGUITaskEvaluatingReceiverImpl.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: AutoGUITaskEvaluatingReceiverImpl.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f29052a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f29053b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f29054c;

        /* JADX INFO: compiled from: AutoGUITaskEvaluatingReceiverImpl.kt */
        public static final class a {
            public /* synthetic */ a(h r1) {
                this();
            }

            private a() {
            }
        }

        /* JADX INFO: renamed from: com.obric.autogui.evaluation.AutoGUITaskEvaluatingReceiverImpl$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AutoGUITaskEvaluatingReceiverImpl.kt */
        @f(b = "AutoGUITaskEvaluatingReceiverImpl.kt", c = {94}, d = "start", e = "com.obric.autogui.evaluation.AutoGUITaskEvaluatingReceiverImpl$EvalTaskAction")
        static final class C0729b extends d.c.b.a.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            /* synthetic */ Object f29055a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ b f29056b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            int f29057c;

            C0729b(b r3, d.c.d<? super C0729b> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f29056b = r3;
                super(r5);
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r3) {
                this.f29055a = r3;
                this.f29057c |= Integer.MIN_VALUE;
                return this.f29056b.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            }
        }

        static {
            f29052a = new a(null);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f29053b, r6.f29053b) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f29054c, r6.f29054c) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            String r0 = this.f29053b;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.f29054c;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "EvalTaskAction(taskInstr=" + this.f29053b + ", tag=" + this.f29054c + ')';
        }

        public b(String r1, String r2) {
            this.f29053b = r1;
            this.f29054c = r2;
        }

        public final Object a(Bundle r11, d.c.d<? super x> r12) {
            d.c.d r13 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r13, C0729b.class) == false) goto L7;
            C0729b r0 = (C0729b) ZeusTransformUtils.preCheckCast(r13, C0729b.class, "com.obric.aiagent.plugin");
            if ((r0.f29057c & Integer.MIN_VALUE) == 0) goto L7;
            r0.f29057c -= Integer.MIN_VALUE;
        L8:
            C0729b r7 = r0;
            Object r14 = r7.f29055a;
            Object r1 = d.c.a.b.a();
            int r2 = r7.f29057c;
            boolean r9 = true;
            if (r2 == 0) goto L14;
            if (r2 != 1) goto L13;
            d.o.a(r14);
        L23:
            e r10 = (e) ZeusTransformUtils.preCheckCast(r14, e.class, "com.obric.aiagent.plugin");
        L26:
            if (r10 != null) goto L28;
        L30:
            r9 = false;
        L31:
            if (r9 == true) goto L34;
            Loog.INSTANCE.e("AutoGUIEval", "cannot fire new AO task: " + r10);
        L34:
            return x.f38692a;
        L28:
            if (r10.g() != true) goto L30;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            d.o.a(r14);
            IAutoActionAgentApi r3 = (IAutoActionAgentApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionAgentApi.class), IAutoActionAgentApi.class, "com.obric.aiagent.plugin");
            if (r3 != null) goto L18;
            Loog.INSTANCE.e("AutoGUIEval", "service: IAutoActionAgentApi not found");
            return x.f38692a;
        L18:
            String r4 = this.f29053b;
            if (r4 == null) goto L24;
            r7.f29057c = 1;
            r14 = r3.postUserQuery(r4, false, r11, 17, r7);
            if (r14 != r1) goto L23;
            return r1;
        L24:
            r10 = null;
        L7:
            r0 = new C0729b(this, r13);
            goto L8
        }
    }

    /* JADX INFO: compiled from: AutoGUITaskEvaluatingReceiverImpl.kt */
    @f(b = "AutoGUITaskEvaluatingReceiverImpl.kt", c = {123}, d = "invokeSuspend", e = "com.obric.autogui.evaluation.AutoGUITaskEvaluatingReceiverImpl$actionEval$1")
    static final class c extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f29058a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f29059b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ z.a f29060c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Bundle f29061d;

        c(b r3, z.a r4, Bundle r5, d.c.d<? super c> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29059b = r3;
            this.f29060c = r4;
            this.f29061d = r5;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f29059b, this.f29060c, this.f29061d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f29058a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L16:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            b r7 = this.f29059b;
            if (this.f29060c.f38499a == false) goto L11;
            Bundle r2 = this.f29061d;
        L12:
            d.c.d<? super x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29058a = 1;
            if (r7.a(r2, r3) != r0) goto L16;
            return r0;
        L11:
            r2 = null;
            goto L12
        }
    }

    /* JADX INFO: compiled from: AutoGUITaskEvaluatingReceiverImpl.kt */
    @f(b = "AutoGUITaskEvaluatingReceiverImpl.kt", c = {138}, d = "invokeSuspend", e = "com.obric.autogui.evaluation.AutoGUITaskEvaluatingReceiverImpl$actionTerminate$1")
    static final class d extends l implements m<am, d.c.d<? super e>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f29062a;

        d(d.c.d<? super d> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d.c.d<? super e> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super e> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f29062a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r7);
        L17:
            return (e) ZeusTransformUtils.preCheckCast(r7, e.class, "com.obric.aiagent.plugin");
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r7);
            IFlowNetworkIDL r8 = com.obric.aiagent.assistant.idl.am.a(aa.b(IFlowNetworkIDL.class));
            if (r8 == null) goto L11;
            r8.clearOmniTasks(ao.a(s.a("stop_scene", "auto_test")), null);
        L11:
            IAutoActionAgentApi r9 = (IAutoActionAgentApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionAgentApi.class), IAutoActionAgentApi.class, "com.obric.aiagent.plugin");
            if (r9 == null) goto L18;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29062a = 1;
            r7 = IAutoActionAgentApi.DefaultImpls.userTerminateQuery$default(r9, null, r2, 1, null);
            if (r7 != r0) goto L17;
            return r0;
        L18:
            return null;
        }
    }

    static {
        f29051a = new a(null);
    }

    public AutoGUITaskEvaluatingReceiverImpl() {
    }

    public void onReceive(Context r3, Intent r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        o.e(r4, MemorySourceLinkType.INTENT);
        if (a(r5, r4) == true) goto L6;
        return;
    L6:
        if (o.a(r4.getAction(), "com.obric.autogui.evaluation.ACTION_EVAL") == false) goto L9;
        a(r4);
        return;
    L9:
        if (o.a(r4.getAction(), "com.obric.autogui.evaluation.ACTION_TERM") == false) goto L12;
        a();
        return;
    L12:
        if (o.a(r4.getAction(), "com.obric.autogui.evaluation.ACTION_ONLINE") == false) goto L17;
        b(r5, r4);
        return;
    }

    private final boolean a(Context r2, Intent r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L14;
        if (r1 == null) goto L14;
        if (IAppContext.Companion.isDebug() == false) goto L9;
        return true;
    L9:
        if (((Number) ZeusTransformUtils.preCheckCast(com.obric.autogui.common.a.m.f28999a.a(r1).h().d(), Number.class, "com.obric.aiagent.plugin")).intValue() != 0) goto L15;
        Loog.INSTANCE.e("AutoGUIEval", "task-evaluating is only available in debug build or if EvaluationMode enabled.");
        return false;
    L15:
        return true;
    L14:
        return false;
    }

    private final void a(Intent r5) {
        b r4 = new b(r5.getStringExtra("instruction"), r5.getStringExtra("tag"));
        z.a r0 = new z.a();
        Bundle r1 = new Bundle();
        if (r5.getBooleanExtra("bring_top_task", false) == false) goto L5;
        r0.f38499a = true;
        r1.putBoolean("bring_top_task", true);
    L5:
        Loog.INSTANCE.i("AutoGUIEval", "[ACTION_EVAL] " + r4);
        AOThreadingTools.INSTANCE.launchIO((m) ZeusTransformUtils.preCheckCast(new c(r4, r0, r1, null), m.class, "com.obric.aiagent.plugin"));
    }

    private final void a() {
        Loog.INSTANCE.i("AutoGUIEval", "[ACTION_TERM]");
        AOThreadingTools.INSTANCE.launchIO((m) ZeusTransformUtils.preCheckCast(new d(null), m.class, "com.obric.aiagent.plugin"));
    }

    private final void b(Context r4, Intent r5) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        String r6 = r5.getStringExtra("test_type");
        if (r6 != null) goto L5;
        return;
    L5:
        Loog.INSTANCE.i("AutoGUIEval", " - [DEBUG] test_type=" + r6);
        if (o.a(r6, "signed_calling") == false) goto L9;
        com.obric.autogui.evaluation.a.a.f29065a.a();
        com.obric.autogui.evaluation.a.f.f29088a.a();
        com.obric.autogui.evaluation.a.c.f29072a.a();
        com.obric.autogui.evaluation.a.e.f29086a.a();
        com.obric.autogui.evaluation.a.d.f29074a.a(r3, r5);
    L9:
        if (o.a(r6, "model_hook_reply") == false) goto L12;
        com.obric.autogui.agents.vlm.models.impl.request.a.b.f28023a.a().onReceive(r3, r5);
        return;
    }
}
