package com.obric.autoaction.presentation.input.states.a;

import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.presentation.AutoActionUIContext;
import com.obric.autogui.common.api.presentation.GlobalUIContext;
import com.obric.autogui.common.api.presentation.IAutoActionPresentationApi;
import com.obric.autogui.common.api.presentation.api.IAssistInputStateManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.l;
import d.h.b.h;
import d.n;
import d.o;
import d.x;

/* JADX INFO: compiled from: StateInit.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends com.obric.autoaction.presentation.input.states.a {
    private static final String TAG = "AssistInput-Init";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f24981a = null;

    /* JADX INFO: compiled from: StateInit.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: StateInit.kt */
    @d.c.b.a.f(b = "StateInit.kt", c = {42}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.input.states.impl.StateInit$onEnter$1")
    static final class b extends l implements d.h.a.b<d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24982a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f24983b;

        b(c r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24983b = r3;
            super(1, r5);
        }

        public final Object a(d.c.d<? super x> r3) {
            return ((b) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f24983b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super x> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r13) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24982a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r13);
        L21:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r13);
            c r14 = this.f24983b;
            n.a r2 = n.f38560a;     // Catch: Throwable -> L11
            Object r15 = n.f(c.a(r14));     // Catch: Throwable -> L11
        L13:
            Throwable r3 = n.c(r15);
            if (r3 == null) goto L17;
            Loog.INSTANCE.e(c.TAG, " - [SpState] computeNextState() failed: " + r3);
            r15 = IAssistInputStateManager.StateType.Init;
        L17:
            IAssistInputStateManager.StateType r6 = (IAssistInputStateManager.StateType) ZeusTransformUtils.preCheckCast(r15, IAssistInputStateManager.StateType.class, "com.obric.aiagent.plugin");
            Loog.INSTANCE.d(c.TAG, " - [SpState] computeNextState() to " + r6);
            com.obric.autoaction.presentation.input.states.b r5 = com.obric.autoaction.presentation.input.states.c.f25027a.a();
            d.c.d r9 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24982a = 1;
            if (com.obric.autoaction.presentation.input.states.b.a(r5, r6, null, null, r9, 6, null) != r0) goto L21;
            return r0;
        L11:
            th = move-exception;
            n.a r4 = n.f38560a;
            r15 = n.f(o.a(th));
            goto L13
        }
    }

    static {
        f24981a = new a(null);
    }

    public static final /* synthetic */ IAssistInputStateManager.StateType a(c r0) {
        return r0.d();
    }

    public c() {
        super(IAssistInputStateManager.StateType.Init);
    }

    @Override // com.obric.autogui.util.c.b
    public Object b(com.obric.autogui.util.c.b r2, d.c.d<? super com.obric.autogui.common.e> r3) {
        com.obric.autogui.util.c.b r1 = (com.obric.autogui.util.c.b) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.autogui.util.c.b.class, "com.obric.aiagent.plugin");
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.autogui.common.e.f29014b.a();
    }

    @Override // com.obric.autogui.util.c.b
    public void b(com.obric.autogui.util.c.b r4) {
        d.h.b.o.e((com.obric.autogui.util.c.b) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.autogui.util.c.b.class, "com.obric.aiagent.plugin"), "fromState");
        com.obric.autoaction.presentation.input.states.c.f25027a.a((d.h.a.b) ZeusTransformUtils.preCheckCast(new b(this, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    private final IAssistInputStateManager.StateType d() {
        GlobalUIContext r3 = (GlobalUIContext) ZeusTransformUtils.preCheckCast(AutoActionUIContext.INSTANCE.getState().c(), GlobalUIContext.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.d(TAG, " - [SpState] computeNextState() by presState=" + r3);
        if (r3.getPlayer().getVisible() != IAutoActionPresentationApi.PlayerVisibility.Visible) goto L7;
        return IAssistInputStateManager.StateType.InputStarting;
    L7:
        if (r3.getPlayer().getVisible() == IAutoActionPresentationApi.PlayerVisibility.Invisible) goto L9;
        Loog.INSTANCE.e(TAG, " - [SpState] invalid presentation state. not triggering state-change.");
        return IAssistInputStateManager.StateType.Init;
    L9:
        if (r3.getIsland().getInDialogueMode() == false) goto L14;
        if (com.obric.autoaction.presentation.input.states.c.f25027a.getAssistInputMode() != IAssistInputStateManager.AssistInputMode.CLARIFY) goto L14;
        return IAssistInputStateManager.StateType.InputStarting;
    L14:
        return IAssistInputStateManager.StateType.Idle;
    }
}
