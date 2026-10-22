package com.obric.autoaction.presentation.input.states;

import com.obric.autogui.common.api.presentation.api.IAssistInputStateManager;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.o;
import d.x;
import java.util.Map;

/* JADX INFO: compiled from: AssistInputStateManager.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements IAssistInputStateManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f25027a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final com.obric.autoaction.presentation.input.states.b f25028b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AOThreadingTools.SingleThreadCoroutineScopeWrapper f25029c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static IAssistInputStateManager.AssistInputMode f25030d;

    /* JADX INFO: compiled from: AssistInputStateManager.kt */
    @f(b = "AssistInputStateManager.kt", c = {81}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.input.states.AssistInputStateManager$inactivate$1")
    static final class a extends l implements d.h.a.b<d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f25031a;

        a(d.c.d<? super a> r3) {
            super(1, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(d.c.d<? super x> r3) {
            return ((a) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new a((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super x> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f25031a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r11);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r11);
            c r12 = c.f25027a;
            c.a(IAssistInputStateManager.AssistInputMode.NONE);
            com.obric.autoaction.presentation.input.states.b r3 = c.f();
            IAssistInputStateManager.StateType r4 = IAssistInputStateManager.StateType.Inactivated;
            d.c.d r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25031a = 1;
            if (com.obric.autoaction.presentation.input.states.b.a(r3, r4, null, null, r7, 6, null) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: AssistInputStateManager.kt */
    @f(b = "AssistInputStateManager.kt", c = {34}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.input.states.AssistInputStateManager$launchStateChange$1")
    static final class b extends l implements d.h.a.b<d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f25032a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ IAssistInputStateManager.StateType f25033b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ IAssistInputStateManager.StateType f25034c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Map<String, Object> f25035d;

        b(IAssistInputStateManager.StateType r3, IAssistInputStateManager.StateType r4, Map<String, ? extends Object> r5, d.c.d<? super b> r6) {
            Map<String, Object> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25033b = r3;
            this.f25034c = r4;
            this.f25035d = r7;
            super(1, r8);
        }

        public final Object a(d.c.d<? super x> r3) {
            return ((b) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f25033b, this.f25034c, this.f25035d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super x> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f25032a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r8);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r8);
            com.obric.autoaction.presentation.input.states.b r9 = c.f();
            IAssistInputStateManager.StateType r2 = this.f25033b;
            IAssistInputStateManager.StateType r3 = this.f25034c;
            Map<String, ? extends Object> r4 = this.f25035d;
            d.c.d<? super com.obric.autogui.common.e> r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25032a = 1;
            if (r9.a(r2, r3, r4, r5) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.autoaction.presentation.input.states.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AssistInputStateManager.kt */
    @f(b = "AssistInputStateManager.kt", c = {69}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.input.states.AssistInputStateManager$launchStateChange$2")
    static final class C0595c extends l implements d.h.a.b<d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f25036a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.h.a.b<d.c.d<? super x>, Object> f25037b;

        C0595c(d.h.a.b<? super d.c.d<? super x>, ? extends Object> r3, d.c.d<? super C0595c> r4) {
            d.h.a.b<d.c.d<? super x>, Object> r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25037b = r5;
            super(1, r6);
        }

        public final Object a(d.c.d<? super x> r3) {
            return ((C0595c) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), C0595c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new C0595c(this.f25037b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super x> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f25036a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r4);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r4);
            d.h.a.b<d.c.d<? super x>, Object> r5 = this.f25037b;
            this.f25036a = 1;
            if (r5.invoke(this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: AssistInputStateManager.kt */
    @f(b = "AssistInputStateManager.kt", c = {56}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.input.states.AssistInputStateManager$startClarifyProcedure$1")
    static final class d extends l implements d.h.a.b<d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f25038a;

        d(d.c.d<? super d> r3) {
            super(1, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(d.c.d<? super x> r3) {
            return ((d) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super x> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f25038a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r11);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r11);
            c r12 = c.f25027a;
            c.a(IAssistInputStateManager.AssistInputMode.CLARIFY);
            com.obric.autoaction.presentation.input.states.b r3 = c.f();
            IAssistInputStateManager.StateType r4 = IAssistInputStateManager.StateType.Init;
            d.c.d r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25038a = 1;
            if (com.obric.autoaction.presentation.input.states.b.a(r3, r4, null, null, r7, 6, null) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: AssistInputStateManager.kt */
    @f(b = "AssistInputStateManager.kt", c = {63}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.input.states.AssistInputStateManager$startUserAdditionProcedure$1")
    static final class e extends l implements d.h.a.b<d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f25039a;

        e(d.c.d<? super e> r3) {
            super(1, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(d.c.d<? super x> r3) {
            return ((e) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super x> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f25039a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r11);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r11);
            c r12 = c.f25027a;
            c.a(IAssistInputStateManager.AssistInputMode.ADDITION);
            com.obric.autoaction.presentation.input.states.b r3 = c.f();
            IAssistInputStateManager.StateType r4 = IAssistInputStateManager.StateType.Init;
            d.c.d r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25039a = 1;
            if (com.obric.autoaction.presentation.input.states.b.a(r3, r4, null, null, r7, 6, null) != r0) goto L12;
            return r0;
        }
    }

    private c() {
    }

    public static final /* synthetic */ void a(IAssistInputStateManager.AssistInputMode r0) {
        f25030d = r0;
    }

    public static final /* synthetic */ com.obric.autoaction.presentation.input.states.b f() {
        return f25028b;
    }

    static {
        f25027a = new c();
        f25028b = new com.obric.autoaction.presentation.input.states.b();
        f25029c = AOThreadingTools.createSingleThreadCoroutineScope$default(AOThreadingTools.INSTANCE, "assistinput-state-change-th", false, 2, null);
        f25030d = IAssistInputStateManager.AssistInputMode.NONE;
    }

    public final com.obric.autoaction.presentation.input.states.b a() {
        return f25028b;
    }

    @Override // com.obric.autogui.common.api.presentation.api.IAssistInputStateManager
    public IAssistInputStateManager.StateType getCurrentState() {
        return f25028b.a().getType();
    }

    @Override // com.obric.autogui.common.api.presentation.api.IAssistInputStateManager
    public void launchStateChange(IAssistInputStateManager.StateType r4, IAssistInputStateManager.StateType r5, Map<String, ? extends Object> r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "to");
        d.h.b.o.e(r5, "from");
        a((d.h.a.b) ZeusTransformUtils.preCheckCast(new b(r4, r5, r7, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.common.api.presentation.api.IAssistInputStateManager
    public IAssistInputStateManager.AssistInputMode getAssistInputMode() {
        return f25030d;
    }

    public final void b() {
        a((d.h.a.b) ZeusTransformUtils.preCheckCast(new d(null), d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    public final void c() {
        a((d.h.a.b) ZeusTransformUtils.preCheckCast(new e(null), d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    public final void a(d.h.a.b<? super d.c.d<? super x>, ? extends Object> r4) {
        d.h.a.b r3 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "toLaunch");
        f25029c.launch((d.h.a.b) ZeusTransformUtils.preCheckCast(new C0595c(r3, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    public final void d() {
        e();
    }

    public final void e() {
        a((d.h.a.b) ZeusTransformUtils.preCheckCast(new a(null), d.h.a.b.class, "com.obric.aiagent.plugin"));
    }
}
