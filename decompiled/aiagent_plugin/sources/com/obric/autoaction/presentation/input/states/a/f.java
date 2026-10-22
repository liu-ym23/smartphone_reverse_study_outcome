package com.obric.autoaction.presentation.input.states.a;

import com.obric.autogui.common.api.agent.AutoActionAgent;
import com.obric.autogui.common.api.assistant.AssistantAbilityHelper;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.presentation.AutoActionUIContext;
import com.obric.autogui.common.api.presentation.GlobalUIContext;
import com.obric.autogui.common.api.presentation.IAutoActionPresentationApi;
import com.obric.autogui.common.api.presentation.api.IAssistInputStateManager;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.h;
import d.o;
import d.x;
import kotlinx.coroutines.am;
import kotlinx.coroutines.b.i;
import kotlinx.coroutines.b.j;

/* JADX INFO: compiled from: StateInputting.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f extends com.obric.autoaction.presentation.input.states.a {
    private static final String TAG = "AssI-Inputting";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f25007a = null;

    /* JADX INFO: compiled from: StateInputting.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: StateInputting.kt */
    @d.c.b.a.f(b = "StateInputting.kt", c = {96}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.input.states.impl.StateInputting$afterTransit$1")
    static final class b extends l implements m<am, d.c.d<? super com.obric.autogui.common.e>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f25008a;

        b(d.c.d<? super b> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d.c.d<? super com.obric.autogui.common.e> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super com.obric.autogui.common.e> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f25008a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L11:
            return r5;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            AutoActionAgent r6 = AutoActionAgent.INSTANCE;
            d.c.d<? super com.obric.autogui.common.e> r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25008a = 1;
            r5 = r6.exitUserAddition("", r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: StateInputting.kt */
    @d.c.b.a.f(b = "StateInputting.kt", c = {54}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.input.states.impl.StateInputting$onEnter$1")
    static final class c extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f25009a;

        /* JADX INFO: compiled from: SafeCollector.common.kt */
        public static final class a implements kotlinx.coroutines.b.h<Boolean> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.b.h f25011a;

            /* JADX INFO: renamed from: com.obric.autoaction.presentation.input.states.a.f$c$a$1, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            public static final class AnonymousClass1<T> implements i {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ i f25012a;

                /* JADX INFO: renamed from: com.obric.autoaction.presentation.input.states.a.f$c$a$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @d.c.b.a.f(b = "StateInputting.kt", c = {219}, d = "emit", e = "com.obric.autoaction.presentation.input.states.impl.StateInputting$onEnter$1$invokeSuspend$$inlined$map$1$2")
                public static final class C05931 extends d.c.b.a.d {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    /* synthetic */ Object f25013a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    int f25014b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    final /* synthetic */ AnonymousClass1 f25015c;

                    public C05931(AnonymousClass1 r3, d.c.d r4) {
                        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                        this.f25015c = r3;
                        super(r5);
                    }

                    @Override // d.c.b.a.a
                    public final Object invokeSuspend(Object r3) {
                        this.f25013a = r3;
                        this.f25014b |= Integer.MIN_VALUE;
                        return this.f25015c.emit(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
                    }
                }

                public AnonymousClass1(i r3) {
                    this.f25012a = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
                }

                @Override // kotlinx.coroutines.b.i
                public final Object emit(Object r6, d.c.d r7) {
                    d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                    if (ZeusTransformUtils.instanceOf(r8, C05931.class) == false) goto L7;
                    C05931 r0 = (C05931) ZeusTransformUtils.preCheckCast(r8, C05931.class, "com.obric.aiagent.plugin");
                    if ((r0.f25014b & Integer.MIN_VALUE) == 0) goto L7;
                    r0.f25014b -= Integer.MIN_VALUE;
                L8:
                    Object r9 = r0.f25013a;
                    Object r2 = d.c.a.b.a();
                    int r3 = r0.f25014b;
                    if (r3 == 0) goto L14;
                    if (r3 != 1) goto L13;
                    o.a(r9);
                L18:
                    return x.f38692a;
                L13:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L14:
                    o.a(r9);
                    i r5 = this.f25012a;
                    d.c.d r10 = (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
                    Boolean r11 = d.c.b.a.b.a(((GlobalUIContext) ZeusTransformUtils.preCheckCast(r6, GlobalUIContext.class, "com.obric.aiagent.plugin")).getAssistState().getVisible());
                    r0.f25014b = 1;
                    if (r5.emit(r11, r0) != r2) goto L18;
                    return r2;
                L7:
                    r0 = new C05931(this, r8);
                    goto L8
                }
            }

            public a(kotlinx.coroutines.b.h r3) {
                this.f25011a = (kotlinx.coroutines.b.h) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");
            }

            @Override // kotlinx.coroutines.b.h
            public Object collect(i<? super Boolean> r3, d.c.d r4) {
                i r5 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
                d.c.d<? super x> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                Object r2 = this.f25011a.collect((i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r5), i.class, "com.obric.aiagent.plugin"), r6);
                if (r2 != d.c.a.b.a()) goto L6;
                return r2;
            L6:
                return x.f38692a;
            }
        }

        c(d.c.d<? super c> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f25009a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            kotlinx.coroutines.b.h r7 = j.b((kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(new a((kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(AutoActionUIContext.INSTANCE.getState(), kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin")), kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin"));
            i r2 = (i) ZeusTransformUtils.preCheckCast(AnonymousClass1.f25010a, i.class, "com.obric.aiagent.plugin");
            d.c.d<? super x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25009a = 1;
            if (r7.collect(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: StateInputting.kt */
    @d.c.b.a.f(b = "StateInputting.kt", c = {ITaskManager.Stub.TRANSACTION_tryActiveAgent}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.input.states.impl.StateInputting$onEnter$2")
    static final class d extends l implements m<am, d.c.d<? super com.obric.autogui.common.e>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f25016a;

        d(d.c.d<? super d> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d.c.d<? super com.obric.autogui.common.e> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super com.obric.autogui.common.e> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f25016a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L11:
            return r5;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            AutoActionAgent r6 = AutoActionAgent.INSTANCE;
            d.c.d<? super com.obric.autogui.common.e> r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25016a = 1;
            r5 = r6.startFunction("ManualOperating", r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: StateInputting.kt */
    @d.c.b.a.f(b = "StateInputting.kt", c = {82}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.input.states.impl.StateInputting$onEnter$3")
    static final class e extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f25017a;

        e(d.c.d<? super e> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f25017a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L11:
            IAutoActionPresentationApi r4 = (IAutoActionPresentationApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionPresentationApi.class), IAutoActionPresentationApi.class, "com.obric.aiagent.plugin");
            if (r4 == null) goto L14;
            r4.enterAssistInputMode();
            return x.f38692a;
        L14:
            return null;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            AutoActionAgent r6 = AutoActionAgent.INSTANCE;
            d.c.d<? super com.obric.autogui.common.e> r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25017a = 1;
            if (r6.enterUserAddition(r2) != r0) goto L11;
            return r0;
        }
    }

    static {
        f25007a = new a(null);
    }

    public f() {
        super(IAssistInputStateManager.StateType.Inputting);
    }

    @Override // com.obric.autogui.util.c.b
    public Object b(com.obric.autogui.util.c.b r3, d.c.d<? super com.obric.autogui.common.e> r4) {
        com.obric.autogui.util.c.b r2 = (com.obric.autogui.util.c.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autogui.util.c.b.class, "com.obric.aiagent.plugin");
        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.d(TAG, " - [AssistInput] exiting Inputting mode to " + r2 + '.');
        if (ZeusTransformUtils.instanceOf(r2, com.obric.autoaction.presentation.input.states.a.d.class) == true) goto L8;
        IAutoActionPresentationApi r6 = (IAutoActionPresentationApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionPresentationApi.class), IAutoActionPresentationApi.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L8;
        r6.exitAssistInputMode();
    L8:
        return com.obric.autogui.common.e.f29014b.a();
    }

    @Override // com.obric.autogui.util.c.b
    public void b(com.obric.autogui.util.c.b r10) {
        d.h.b.o.e((com.obric.autogui.util.c.b) ZeusTransformUtils.wrapperContextForParams(r10, com.obric.autogui.util.c.b.class, "com.obric.aiagent.plugin"), "fromState");
        Loog.INSTANCE.d(TAG, " - [AssistInput] entered Inputting mode.");
        am r3 = a();
        if (r3 == null) goto L6;
        kotlinx.coroutines.i.a(r3, null, null, (m) ZeusTransformUtils.preCheckCast(new c(null), m.class, "com.obric.aiagent.plugin"), 3, null);
    L6:
        if (com.obric.autoaction.presentation.input.states.c.f25027a.getAssistInputMode() != IAssistInputStateManager.AssistInputMode.CLARIFY) goto L12;
        IAutoActionPresentationApi r9 = (IAutoActionPresentationApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionPresentationApi.class), IAutoActionPresentationApi.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L17;
        r9.enterAssistInputMode();
        return;
    L17:
        return;
    L12:
        if (AssistantAbilityHelper.INSTANCE.isChatPageInVD() == false) goto L15;
        Loog.INSTANCE.d(TAG, " - [AssistInput] (state-inputting-entered-while-chat-page-in-vd)");
        AOThreadingTools.INSTANCE.launchIO((m) ZeusTransformUtils.preCheckCast(new d(null), m.class, "com.obric.aiagent.plugin"));
        return;
    L15:
        AOThreadingTools.INSTANCE.launchIO((m) ZeusTransformUtils.preCheckCast(new e(null), m.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autoaction.presentation.input.states.a, com.obric.autogui.util.c.b
    public void a(com.obric.autogui.util.c.b r3) {
        com.obric.autogui.util.c.b r4 = (com.obric.autogui.util.c.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autogui.util.c.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "toState");
        super.a(r4);
        if (ZeusTransformUtils.instanceOf(r4, com.obric.autoaction.presentation.input.states.a.d.class) == false) goto L5;
        return;
    L5:
        if (com.obric.autoaction.presentation.input.states.c.f25027a.getAssistInputMode() != IAssistInputStateManager.AssistInputMode.ADDITION) goto L9;
        AOThreadingTools.INSTANCE.launchIO((m) ZeusTransformUtils.preCheckCast(new b(null), m.class, "com.obric.aiagent.plugin"));
        return;
    }
}
