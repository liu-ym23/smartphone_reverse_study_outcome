package com.obric.autoaction.presentation.input.states;

import com.obric.autoaction.presentation.input.states.a.e;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.presentation.api.IAssistInputStateManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.c.b.a.d;
import d.c.b.a.f;
import d.h.b.h;
import d.h.b.o;
import d.m;
import d.s;
import java.util.Map;

/* JADX INFO: compiled from: AssistInputStateMachine.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private static final String TAG = "AssistInput-SM";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f25018a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlinx.coroutines.f.a f25019b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<IAssistInputStateManager.StateType, com.obric.autoaction.presentation.input.states.a> f25020c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.obric.autogui.util.c.c f25021d;

    /* JADX INFO: compiled from: AssistInputStateMachine.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: renamed from: com.obric.autoaction.presentation.input.states.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AssistInputStateMachine.kt */
    @f(b = "AssistInputStateMachine.kt", c = {91, 83}, d = "changeStateTo", e = "com.obric.autoaction.presentation.input.states.AssistInputStateMachine")
    static final class C0594b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f25022a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f25023b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f25024c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f25025d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f25026e;
        /* synthetic */ Object f;
        final /* synthetic */ b g;
        int h;

        C0594b(b r3, d.c.d<? super C0594b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.g = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f = r3;
            this.h |= Integer.MIN_VALUE;
            return this.g.a(null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f25018a = new a(null);
    }

    public b() {
        this.f25019b = kotlinx.coroutines.f.c.a(false, 1, null);
        Map<IAssistInputStateManager.StateType, com.obric.autoaction.presentation.input.states.a> r0 = ao.a(new m[]{s.a(IAssistInputStateManager.StateType.Inactivated, new com.obric.autoaction.presentation.input.states.a.b()), s.a(IAssistInputStateManager.StateType.Init, new com.obric.autoaction.presentation.input.states.a.c()), s.a(IAssistInputStateManager.StateType.Idle, new com.obric.autoaction.presentation.input.states.a.a()), s.a(IAssistInputStateManager.StateType.InputStarting, new e()), s.a(IAssistInputStateManager.StateType.Inputting, new com.obric.autoaction.presentation.input.states.a.f()), s.a(IAssistInputStateManager.StateType.InputCompleted, new com.obric.autoaction.presentation.input.states.a.d())});
        this.f25020c = r0;
        com.obric.autoaction.presentation.input.states.a r1 = r0.get(IAssistInputStateManager.StateType.Inactivated);
        o.a(r1);
        this.f25021d = new com.obric.autogui.util.c.c((com.obric.autogui.util.c.b) ZeusTransformUtils.preCheckCast(r1, com.obric.autogui.util.c.b.class, "com.obric.aiagent.plugin"));
    }

    public com.obric.autoaction.presentation.input.states.a a() {
        com.obric.autogui.util.c.b r2 = this.f25021d.a();
        o.a(r2, "null cannot be cast to non-null type com.obric.autoaction.presentation.input.states.AssistInputState");
        return (com.obric.autoaction.presentation.input.states.a) ZeusTransformUtils.preCheckCast(r2, com.obric.autoaction.presentation.input.states.a.class, "com.obric.aiagent.plugin");
    }

    private final Object a(com.obric.autoaction.presentation.input.states.a r7, IAssistInputStateManager.StateType r8, Map<String, ? extends Object> r9, d.c.d<? super com.obric.autogui.common.e> r10) {
        Map<String, ? extends Object> r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.aiagent.plugin");
        d.c.d<? super com.obric.autogui.common.e> r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        com.obric.autoaction.presentation.input.states.a r0 = a();
        if (r8 != IAssistInputStateManager.StateType.Any) goto L5;
    L8:
        Loog.INSTANCE.d(TAG, "StateChange: [" + r0.getType() + "] --> [" + r7.getType() + ']');
        r7.a(r11);
        return this.f25021d.a((com.obric.autogui.util.c.b) ZeusTransformUtils.preCheckCast(r7, com.obric.autogui.util.c.b.class, "com.obric.aiagent.plugin"), r12);
    L5:
        if (r0.getType() == r8) goto L8;
        Loog.INSTANCE.e(TAG, "StateChange Failed: [" + r0.getType() + "] (expected " + r8 + ") --> [" + r7 + ']');
        return com.obric.autogui.common.e.f29014b.b("state-change failed.");
    }

    public final Object a(IAssistInputStateManager.StateType r9, IAssistInputStateManager.StateType r10, Map<String, ? extends Object> r11, d.c.d<? super com.obric.autogui.common.e> r12) {
        Map<String, ? extends Object> r13 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin");
        d.c.d r14 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r14, C0594b.class) == false) goto L7;
        C0594b r0 = (C0594b) ZeusTransformUtils.preCheckCast(r14, C0594b.class, "com.obric.aiagent.plugin");
        if ((r0.h & Integer.MIN_VALUE) == 0) goto L7;
        r0.h -= Integer.MIN_VALUE;
    L8:
        Object r15 = r0.f;
        Object r2 = d.c.a.b.a();
        int r3 = r0.h;
        if (r3 == 0) goto L20;
        if (r3 == 1) goto L19;
        if (r3 != 2) goto L18;
        kotlinx.coroutines.f.a r8 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r0.f25022a, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        d.o.a(r15);     // Catch: Throwable -> L15
    L31:
        com.obric.autogui.common.e r16 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r15, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        r8.b(null);
        return r16;
    L15:
        Throwable th = th;
    L36:
        r8.b(null);
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        kotlinx.coroutines.f.a r17 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r0.f25026e, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        com.obric.autoaction.presentation.input.states.a r18 = (com.obric.autoaction.presentation.input.states.a) ZeusTransformUtils.preCheckCast(r0.f25025d, com.obric.autoaction.presentation.input.states.a.class, "com.obric.aiagent.plugin");
        r13 = (Map) ZeusTransformUtils.preCheckCast(r0.f25024c, Map.class, "com.obric.aiagent.plugin");
        r10 = (IAssistInputStateManager.StateType) ZeusTransformUtils.preCheckCast(r0.f25023b, IAssistInputStateManager.StateType.class, "com.obric.aiagent.plugin");
        b r4 = (b) ZeusTransformUtils.preCheckCast(r0.f25022a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r15);
        com.obric.autoaction.presentation.input.states.a r19 = r18;
        kotlinx.coroutines.f.a r20 = r17;
        b this = r4;
    L38:
        r0.f25022a = r20;     // Catch: Throwable -> L34
        r0.f25023b = null;     // Catch: Throwable -> L34
        r0.f25024c = null;     // Catch: Throwable -> L34
        r0.f25025d = null;     // Catch: Throwable -> L34
        r0.f25026e = null;     // Catch: Throwable -> L34
        r0.h = 2;     // Catch: Throwable -> L34
        r15 = this.a(r19, r10, r13, r0);     // Catch: Throwable -> L34
        if (r15 != r2) goto L30;
        return r2;
    L30:
        r8 = r20;
    L34:
        th = move-exception;
        kotlinx.coroutines.f.a r7 = r20;
        th = th;
        r8 = r7;
        goto L36
    L20:
        d.o.a(r15);
        r19 = (com.obric.autoaction.presentation.input.states.a) ZeusTransformUtils.preCheckCast(this.f25020c.get(r9), com.obric.autoaction.presentation.input.states.a.class, "com.obric.aiagent.plugin");
        if (r19 != null) goto L24;
        Loog.INSTANCE.e(TAG, "Invalid state transition: " + r9);
        return com.obric.autogui.common.e.f29014b.b("Unexpected exception in AssistInputMachine.");
    L24:
        r20 = this.f25019b;
        r0.f25022a = this;
        r0.f25023b = r10;
        r0.f25024c = r13;
        r0.f25025d = r19;
        r0.f25026e = r20;
        r0.h = 1;
        if (r20.a(null, r0) != r2) goto L38;
        return r2;
    L7:
        r0 = new C0594b(this, r14);
        goto L8
    }

    public static /* synthetic */ Object a(b r1, IAssistInputStateManager.StateType r2, IAssistInputStateManager.StateType r3, Map r4, d.c.d r5, int r6, Object r7) {
        Map<String, ? extends Object> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        d.c.d<? super com.obric.autogui.common.e> r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        if ((r6 & 2) == 0) goto L6;
        r3 = IAssistInputStateManager.StateType.Any;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r8 = null;
    L9:
        return r1.a(r2, r3, r8, r9);
    }
}
