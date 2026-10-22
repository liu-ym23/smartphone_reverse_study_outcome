package com.obric.autoaction.presentation.input.states.a;

import com.obric.autogui.common.api.agent.AutoActionAgent;
import com.obric.autogui.common.api.agent.IAutoActionAgentApi;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.presentation.IAutoActionPresentationApi;
import com.obric.autogui.common.api.presentation.api.IAssistInputHost;
import com.obric.autogui.common.api.presentation.api.IAssistInputStateManager;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.h;
import d.h.b.z;
import d.o;
import d.x;
import java.util.Map;
import kotlinx.coroutines.am;

/* JADX INFO: compiled from: StateInputCompleted.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends com.obric.autoaction.presentation.input.states.a {
    private static final String TAG = "AssI-InputCompl";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f24984a = null;

    /* JADX INFO: compiled from: StateInputCompleted.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: StateInputCompleted.kt */
    @d.c.b.a.f(b = "StateInputCompleted.kt", c = {57, 59}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.input.states.impl.StateInputCompleted$onEnter$1")
    static final class b extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24985a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ IAssistInputStateManager.AssistInputMode f24986b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ z.f<String> f24987c;

        b(IAssistInputStateManager.AssistInputMode r3, z.f<String> r4, d.c.d<? super b> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24986b = r3;
            this.f24987c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f24986b, this.f24987c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r12) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24985a;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            o.a(r12);
        L18:
            x r13 = x.f38692a;
        L19:
            Loog.INSTANCE.d(d.TAG, " - [AssistInput] submitted text for `" + this.f24986b + "`.");
            return x.f38692a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            o.a(r12);
            goto L19
        L10:
            o.a(r12);
            if (this.f24986b != IAssistInputStateManager.AssistInputMode.CLARIFY) goto L15;
            IAutoActionAgentApi r5 = (IAutoActionAgentApi) ZeusTransformUtils.preCheckCast(AutoActionAgent.INSTANCE, IAutoActionAgentApi.class, "com.obric.aiagent.plugin");
            String r6 = (String) ZeusTransformUtils.preCheckCast(this.f24987c.f38504a, String.class, "com.obric.aiagent.plugin");
            d.c.d r8 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24985a = 1;
            if (IAutoActionAgentApi.DefaultImpls.exitUserClarify$default(r5, r6, null, r8, 2, null) != r0) goto L19;
            return r0;
        L15:
            AutoActionAgent r14 = AutoActionAgent.INSTANCE;
            String r2 = (String) ZeusTransformUtils.preCheckCast(this.f24987c.f38504a, String.class, "com.obric.aiagent.plugin");
            d.c.d<? super x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24985a = 2;
            if (r14.exitApplyAddition(r2, r3) != r0) goto L18;
            return r0;
        }
    }

    static {
        f24984a = new a(null);
    }

    public d() {
        super(IAssistInputStateManager.StateType.InputCompleted);
    }

    @Override // com.obric.autogui.util.c.b
    public Object b(com.obric.autogui.util.c.b r2, d.c.d<? super com.obric.autogui.common.e> r3) {
        com.obric.autogui.util.c.b r1 = (com.obric.autogui.util.c.b) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.autogui.util.c.b.class, "com.obric.aiagent.plugin");
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.autogui.common.e.f29014b.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.obric.autogui.util.c.b
    public void b(com.obric.autogui.util.c.b r8) {
        d.h.b.o.e((com.obric.autogui.util.c.b) ZeusTransformUtils.wrapperContextForParams(r8, com.obric.autogui.util.c.b.class, "com.obric.aiagent.plugin"), "fromState");
        IAssistInputStateManager r9 = (IAssistInputStateManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAssistInputStateManager.class), IAssistInputStateManager.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L5;
        IAssistInputStateManager.AssistInputMode r10 = r9.getAssistInputMode();
    L7:
        if (r10 != null) goto L10;
        Loog.INSTANCE.e(TAG, " - [AssistInput] input completed but no assist input mode.");
        return;
    L10:
        z.f r3 = new z.f();
        Map<String, Object> r7 = b();
        if (r7 == null) goto L13;
        Object r11 = r7.get("sc_inputted_text");
    L15:
        if (ZeusTransformUtils.instanceOf(r11, String.class) == false) goto L17;
        T r12 = (String) ZeusTransformUtils.preCheckCast(r11, String.class, "com.obric.aiagent.plugin");
    L18:
        r3.f38504a = r12;
        CharSequence r13 = (CharSequence) ZeusTransformUtils.preCheckCast(r3.f38504a, CharSequence.class, "com.obric.aiagent.plugin");
        if (r13 != null) goto L21;
    L24:
        boolean r14 = true;
    L25:
        if (r14 == false) goto L28;
        Loog.INSTANCE.e(TAG, " - [AssistInput] input completed but no inputted text.");
        r3.f38504a = "";
    L28:
        if (com.obric.autogui.common.b.b.f29001a.a() == false) goto L30;
        Loog.INSTANCE.d(TAG, " - [AssistInput] input completed (" + r10 + "). inputted text = " + ((String) ZeusTransformUtils.preCheckCast(r3.f38504a, String.class, "com.obric.aiagent.plugin")));
    L31:
        AOThreadingTools.INSTANCE.launchIO((m) ZeusTransformUtils.preCheckCast(new b(r10, r3, null), m.class, "com.obric.aiagent.plugin"));
        IAssistInputHost r15 = (IAssistInputHost) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAssistInputHost.class), IAssistInputHost.class, "com.obric.aiagent.plugin");
        if (r15 == null) goto L34;
        r15.completedInput(r10, (String) ZeusTransformUtils.preCheckCast(r3.f38504a, String.class, "com.obric.aiagent.plugin"));
    L34:
        IAutoActionPresentationApi r16 = (IAutoActionPresentationApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionPresentationApi.class), IAutoActionPresentationApi.class, "com.obric.aiagent.plugin");
        if (r16 == null) goto L38;
        r16.exitAssistInputMode();
        return;
    L38:
        return;
    L30:
        Loog.INSTANCE.d(TAG, " - [AssistInput] input completed (" + r10 + "). input text size=" + ((String) ZeusTransformUtils.preCheckCast(r3.f38504a, String.class, "com.obric.aiagent.plugin")).length());
        goto L31
    L21:
        if (d.o.o.d(r13) == true) goto L24;
        r14 = false;
        goto L25
    L17:
        r12 = 0;
        goto L18
    L13:
        r11 = null;
        goto L15
    L5:
        r10 = null;
        goto L7
    }
}
