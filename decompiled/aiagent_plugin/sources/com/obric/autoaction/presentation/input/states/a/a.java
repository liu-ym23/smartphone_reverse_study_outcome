package com.obric.autoaction.presentation.input.states.a;

import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.presentation.AutoActionUIContext;
import com.obric.autogui.common.api.presentation.GlobalUIContext;
import com.obric.autogui.common.api.presentation.IAutoActionPresentationApi;
import com.obric.autogui.common.api.presentation.api.IAssistInputHost;
import com.obric.autogui.common.api.presentation.api.IAssistInputStateManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.h;
import d.o;
import d.s;
import d.x;
import kotlinx.coroutines.am;
import kotlinx.coroutines.b.i;
import kotlinx.coroutines.b.j;

/* JADX INFO: compiled from: StateIdle.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends com.obric.autoaction.presentation.input.states.a {
    private static final String TAG = "AssistInput-Idle";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0585a f24971a = null;

    /* JADX INFO: renamed from: com.obric.autoaction.presentation.input.states.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: StateIdle.kt */
    public static final class C0585a {
        public /* synthetic */ C0585a(h r1) {
            this();
        }

        private C0585a() {
        }
    }

    /* JADX INFO: compiled from: StateIdle.kt */
    @d.c.b.a.f(b = "StateIdle.kt", c = {45}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.input.states.impl.StateIdle$onEnter$1")
    static final class b extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24972a;

        /* JADX INFO: renamed from: com.obric.autoaction.presentation.input.states.a.a$b$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SafeCollector.common.kt */
        public static final class C0587a implements kotlinx.coroutines.b.h<d.m<? extends IAutoActionPresentationApi.PlayerVisibility, ? extends Boolean>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.b.h f24975a;

            /* JADX INFO: renamed from: com.obric.autoaction.presentation.input.states.a.a$b$a$1, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            public static final class AnonymousClass1<T> implements i {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ i f24976a;

                /* JADX INFO: renamed from: com.obric.autoaction.presentation.input.states.a.a$b$a$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @d.c.b.a.f(b = "StateIdle.kt", c = {219}, d = "emit", e = "com.obric.autoaction.presentation.input.states.impl.StateIdle$onEnter$1$invokeSuspend$$inlined$map$1$2")
                public static final class C05881 extends d.c.b.a.d {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    /* synthetic */ Object f24977a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    int f24978b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    final /* synthetic */ AnonymousClass1 f24979c;

                    public C05881(AnonymousClass1 r3, d.c.d r4) {
                        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                        this.f24979c = r3;
                        super(r5);
                    }

                    @Override // d.c.b.a.a
                    public final Object invokeSuspend(Object r3) {
                        this.f24977a = r3;
                        this.f24978b |= Integer.MIN_VALUE;
                        return this.f24979c.emit(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
                    }
                }

                public AnonymousClass1(i r3) {
                    this.f24976a = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
                }

                @Override // kotlinx.coroutines.b.i
                public final Object emit(Object r6, d.c.d r7) {
                    d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                    if (ZeusTransformUtils.instanceOf(r8, C05881.class) == false) goto L7;
                    C05881 r0 = (C05881) ZeusTransformUtils.preCheckCast(r8, C05881.class, "com.obric.aiagent.plugin");
                    if ((r0.f24978b & Integer.MIN_VALUE) == 0) goto L7;
                    r0.f24978b -= Integer.MIN_VALUE;
                L8:
                    Object r9 = r0.f24977a;
                    Object r2 = d.c.a.b.a();
                    int r3 = r0.f24978b;
                    if (r3 == 0) goto L14;
                    if (r3 != 1) goto L13;
                    o.a(r9);
                L18:
                    return x.f38692a;
                L13:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L14:
                    o.a(r9);
                    i r5 = this.f24976a;
                    d.c.d r10 = (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
                    GlobalUIContext r11 = (GlobalUIContext) ZeusTransformUtils.preCheckCast(r6, GlobalUIContext.class, "com.obric.aiagent.plugin");
                    d.m r12 = s.a(r11.getPlayer().getVisible(), d.c.b.a.b.a(r11.getIsland().getInDialogueMode()));
                    r0.f24978b = 1;
                    if (r5.emit(r12, r0) != r2) goto L18;
                    return r2;
                L7:
                    r0 = new C05881(this, r8);
                    goto L8
                }
            }

            public C0587a(kotlinx.coroutines.b.h r3) {
                this.f24975a = (kotlinx.coroutines.b.h) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");
            }

            @Override // kotlinx.coroutines.b.h
            public Object collect(i<? super d.m<? extends IAutoActionPresentationApi.PlayerVisibility, ? extends Boolean>> r3, d.c.d r4) {
                i r5 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
                d.c.d<? super x> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                Object r2 = this.f24975a.collect((i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r5), i.class, "com.obric.aiagent.plugin"), r6);
                if (r2 != d.c.a.b.a()) goto L6;
                return r2;
            L6:
                return x.f38692a;
            }
        }

        b(d.c.d<? super b> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24972a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            kotlinx.coroutines.b.h r7 = j.b((kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(new C0587a((kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(AutoActionUIContext.INSTANCE.getState(), kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin")), kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin"));
            i r2 = (i) ZeusTransformUtils.preCheckCast(AnonymousClass1.f24973a, i.class, "com.obric.aiagent.plugin");
            d.c.d<? super x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24972a = 1;
            if (r7.collect(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    static {
        f24971a = new C0585a(null);
    }

    public a() {
        super(IAssistInputStateManager.StateType.Idle);
    }

    @Override // com.obric.autogui.util.c.b
    public Object b(com.obric.autogui.util.c.b r2, d.c.d<? super com.obric.autogui.common.e> r3) {
        com.obric.autogui.util.c.b r1 = (com.obric.autogui.util.c.b) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.autogui.util.c.b.class, "com.obric.aiagent.plugin");
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.autogui.common.e.f29014b.a();
    }

    @Override // com.obric.autogui.util.c.b
    public void b(com.obric.autogui.util.c.b r9) {
        d.h.b.o.e((com.obric.autogui.util.c.b) ZeusTransformUtils.wrapperContextForParams(r9, com.obric.autogui.util.c.b.class, "com.obric.aiagent.plugin"), "fromState");
        Loog.INSTANCE.i(TAG, " - [AssistInput] cancel input.");
        IAssistInputHost r10 = (IAssistInputHost) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAssistInputHost.class), IAssistInputHost.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L5;
        r10.cancelInput();
    L5:
        am r2 = a();
        if (r2 == null) goto L9;
        kotlinx.coroutines.i.a(r2, null, null, (m) ZeusTransformUtils.preCheckCast(new b(null), m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    }

    @Override // com.obric.autoaction.presentation.input.states.a, com.obric.autogui.util.c.b
    public void a(com.obric.autogui.util.c.b r3) {
        com.obric.autogui.util.c.b r4 = (com.obric.autogui.util.c.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autogui.util.c.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "toState");
        super.a(r4);
    }
}
