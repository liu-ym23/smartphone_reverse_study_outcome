package com.obric.autoaction.presentation.input.states.a;

import com.obric.autogui.common.api.AOSystemTools;
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

/* JADX INFO: compiled from: StateInputStarting.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends com.obric.autoaction.presentation.input.states.a {
    private static final String TAG = "AssI-InputStarting";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f24988a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f24989b;

    /* JADX INFO: compiled from: StateInputStarting.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: StateInputStarting.kt */
    @d.c.b.a.f(b = "StateInputStarting.kt", c = {}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.input.states.impl.StateInputStarting$onEnter$1")
    static final class b extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24990a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f24991b;

        /* JADX INFO: renamed from: com.obric.autoaction.presentation.input.states.a.e$b$1, reason: invalid class name */
        /* JADX INFO: compiled from: StateInputStarting.kt */
        @d.c.b.a.f(b = "StateInputStarting.kt", c = {64}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.input.states.impl.StateInputStarting$onEnter$1$1")
        static final class AnonymousClass1 extends l implements m<am, d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f24992a;

            /* JADX INFO: renamed from: com.obric.autoaction.presentation.input.states.a.e$b$1$a */
            /* JADX INFO: compiled from: SafeCollector.common.kt */
            public static final class a implements kotlinx.coroutines.b.h<d.m<? extends IAutoActionPresentationApi.PlayerVisibility, ? extends Boolean>> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ kotlinx.coroutines.b.h f24995a;

                /* JADX INFO: renamed from: com.obric.autoaction.presentation.input.states.a.e$b$1$a$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: Emitters.kt */
                public static final class C05901<T> implements i {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    final /* synthetic */ i f24996a;

                    /* JADX INFO: renamed from: com.obric.autoaction.presentation.input.states.a.e$b$1$a$1$1, reason: invalid class name and collision with other inner class name */
                    /* JADX INFO: compiled from: Emitters.kt */
                    @d.c.b.a.f(b = "StateInputStarting.kt", c = {219}, d = "emit", e = "com.obric.autoaction.presentation.input.states.impl.StateInputStarting$onEnter$1$1$invokeSuspend$$inlined$map$1$2")
                    public static final class C05911 extends d.c.b.a.d {

                        /* JADX INFO: renamed from: a, reason: collision with root package name */
                        /* synthetic */ Object f24997a;

                        /* JADX INFO: renamed from: b, reason: collision with root package name */
                        int f24998b;

                        /* JADX INFO: renamed from: c, reason: collision with root package name */
                        final /* synthetic */ C05901 f24999c;

                        public C05911(C05901 r3, d.c.d r4) {
                            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                            this.f24999c = r3;
                            super(r5);
                        }

                        @Override // d.c.b.a.a
                        public final Object invokeSuspend(Object r3) {
                            this.f24997a = r3;
                            this.f24998b |= Integer.MIN_VALUE;
                            return this.f24999c.emit(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
                        }
                    }

                    public C05901(i r3) {
                        this.f24996a = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
                    }

                    @Override // kotlinx.coroutines.b.i
                    public final Object emit(Object r6, d.c.d r7) {
                        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                        if (ZeusTransformUtils.instanceOf(r8, C05911.class) == false) goto L7;
                        C05911 r0 = (C05911) ZeusTransformUtils.preCheckCast(r8, C05911.class, "com.obric.aiagent.plugin");
                        if ((r0.f24998b & Integer.MIN_VALUE) == 0) goto L7;
                        r0.f24998b -= Integer.MIN_VALUE;
                    L8:
                        Object r9 = r0.f24997a;
                        Object r2 = d.c.a.b.a();
                        int r3 = r0.f24998b;
                        if (r3 == 0) goto L14;
                        if (r3 != 1) goto L13;
                        o.a(r9);
                    L18:
                        return x.f38692a;
                    L13:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    L14:
                        o.a(r9);
                        i r5 = this.f24996a;
                        d.c.d r10 = (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
                        GlobalUIContext r11 = (GlobalUIContext) ZeusTransformUtils.preCheckCast(r6, GlobalUIContext.class, "com.obric.aiagent.plugin");
                        d.m r12 = s.a(r11.getPlayer().getVisible(), d.c.b.a.b.a(r11.getIsland().getInDialogueMode()));
                        r0.f24998b = 1;
                        if (r5.emit(r12, r0) != r2) goto L18;
                        return r2;
                    L7:
                        r0 = new C05911(this, r8);
                        goto L8
                    }
                }

                public a(kotlinx.coroutines.b.h r3) {
                    this.f24995a = (kotlinx.coroutines.b.h) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");
                }

                @Override // kotlinx.coroutines.b.h
                public Object collect(i<? super d.m<? extends IAutoActionPresentationApi.PlayerVisibility, ? extends Boolean>> r3, d.c.d r4) {
                    i r5 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
                    d.c.d<? super x> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                    Object r2 = this.f24995a.collect((i) ZeusTransformUtils.preCheckCast(new C05901(r5), i.class, "com.obric.aiagent.plugin"), r6);
                    if (r2 != d.c.a.b.a()) goto L6;
                    return r2;
                L6:
                    return x.f38692a;
                }
            }

            AnonymousClass1(d.c.d<? super AnonymousClass1> r3) {
                super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            public final Object a(am r3, d.c.d<? super x> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r1, d.c.d<?> r2) {
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r6) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f24992a;
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
                i r2 = (i) ZeusTransformUtils.preCheckCast(C05891.f24993a, i.class, "com.obric.aiagent.plugin");
                d.c.d<? super x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f24992a = 1;
                if (r7.collect(r2, r3) != r0) goto L12;
                return r0;
            }
        }

        /* JADX INFO: renamed from: com.obric.autoaction.presentation.input.states.a.e$b$2, reason: invalid class name */
        /* JADX INFO: compiled from: StateInputStarting.kt */
        @d.c.b.a.f(b = "StateInputStarting.kt", c = {85}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.input.states.impl.StateInputStarting$onEnter$1$2")
        static final class AnonymousClass2 extends l implements m<am, d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f25000a;

            /* JADX INFO: renamed from: com.obric.autoaction.presentation.input.states.a.e$b$2$a */
            /* JADX INFO: compiled from: SafeCollector.common.kt */
            public static final class a implements kotlinx.coroutines.b.h<Boolean> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ kotlinx.coroutines.b.h f25002a;

                /* JADX INFO: renamed from: com.obric.autoaction.presentation.input.states.a.e$b$2$a$1, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                public static final class AnonymousClass1<T> implements i {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    final /* synthetic */ i f25003a;

                    /* JADX INFO: renamed from: com.obric.autoaction.presentation.input.states.a.e$b$2$a$1$1, reason: invalid class name and collision with other inner class name */
                    /* JADX INFO: compiled from: Emitters.kt */
                    @d.c.b.a.f(b = "StateInputStarting.kt", c = {219}, d = "emit", e = "com.obric.autoaction.presentation.input.states.impl.StateInputStarting$onEnter$1$2$invokeSuspend$$inlined$map$1$2")
                    public static final class C05921 extends d.c.b.a.d {

                        /* JADX INFO: renamed from: a, reason: collision with root package name */
                        /* synthetic */ Object f25004a;

                        /* JADX INFO: renamed from: b, reason: collision with root package name */
                        int f25005b;

                        /* JADX INFO: renamed from: c, reason: collision with root package name */
                        final /* synthetic */ AnonymousClass1 f25006c;

                        public C05921(AnonymousClass1 r3, d.c.d r4) {
                            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                            this.f25006c = r3;
                            super(r5);
                        }

                        @Override // d.c.b.a.a
                        public final Object invokeSuspend(Object r3) {
                            this.f25004a = r3;
                            this.f25005b |= Integer.MIN_VALUE;
                            return this.f25006c.emit(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
                        }
                    }

                    public AnonymousClass1(i r3) {
                        this.f25003a = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
                    }

                    @Override // kotlinx.coroutines.b.i
                    public final Object emit(Object r6, d.c.d r7) {
                        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                        if (ZeusTransformUtils.instanceOf(r8, C05921.class) == false) goto L7;
                        C05921 r0 = (C05921) ZeusTransformUtils.preCheckCast(r8, C05921.class, "com.obric.aiagent.plugin");
                        if ((r0.f25005b & Integer.MIN_VALUE) == 0) goto L7;
                        r0.f25005b -= Integer.MIN_VALUE;
                    L8:
                        Object r9 = r0.f25004a;
                        Object r2 = d.c.a.b.a();
                        int r3 = r0.f25005b;
                        if (r3 == 0) goto L14;
                        if (r3 != 1) goto L13;
                        o.a(r9);
                    L18:
                        return x.f38692a;
                    L13:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    L14:
                        o.a(r9);
                        i r5 = this.f25003a;
                        d.c.d r10 = (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
                        Boolean r11 = d.c.b.a.b.a(((GlobalUIContext) ZeusTransformUtils.preCheckCast(r6, GlobalUIContext.class, "com.obric.aiagent.plugin")).getAssistState().getVisible());
                        r0.f25005b = 1;
                        if (r5.emit(r11, r0) != r2) goto L18;
                        return r2;
                    L7:
                        r0 = new C05921(this, r8);
                        goto L8
                    }
                }

                public a(kotlinx.coroutines.b.h r3) {
                    this.f25002a = (kotlinx.coroutines.b.h) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");
                }

                @Override // kotlinx.coroutines.b.h
                public Object collect(i<? super Boolean> r3, d.c.d r4) {
                    i r5 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
                    d.c.d<? super x> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                    Object r2 = this.f25002a.collect((i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r5), i.class, "com.obric.aiagent.plugin"), r6);
                    if (r2 != d.c.a.b.a()) goto L6;
                    return r2;
                L6:
                    return x.f38692a;
                }
            }

            AnonymousClass2(d.c.d<? super AnonymousClass2> r3) {
                super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            public final Object a(am r3, d.c.d<? super x> r4) {
                return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass2.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r1, d.c.d<?> r2) {
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass2((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r6) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f25000a;
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
                i r2 = (i) ZeusTransformUtils.preCheckCast(AnonymousClass1.f25001a, i.class, "com.obric.aiagent.plugin");
                d.c.d<? super x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f25000a = 1;
                if (r7.collect(r2, r3) != r0) goto L12;
                return r0;
            }
        }

        b(d.c.d<? super b> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            b r4 = new b((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
            r4.f24991b = r2;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            d.c.a.b.a();
            if (this.f24990a != 0) goto L7;
            o.a(r9);
            am r8 = (am) ZeusTransformUtils.preCheckCast(this.f24991b, am.class, "com.obric.aiagent.plugin");
            kotlinx.coroutines.i.a(r8, null, null, (m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(null), m.class, "com.obric.aiagent.plugin"), 3, null);
            kotlinx.coroutines.i.a(r8, null, null, (m) ZeusTransformUtils.preCheckCast(new AnonymousClass2(null), m.class, "com.obric.aiagent.plugin"), 3, null);
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        f24988a = new a(null);
    }

    public e() {
        super(IAssistInputStateManager.StateType.InputStarting);
    }

    @Override // com.obric.autogui.util.c.b
    public Object b(com.obric.autogui.util.c.b r5, d.c.d<? super com.obric.autogui.common.e> r6) {
        com.obric.autogui.util.c.b r7 = (com.obric.autogui.util.c.b) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.autogui.util.c.b.class, "com.obric.aiagent.plugin");
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.d(TAG, " - [AssistInput] exiting InputStarting mode to: " + r7 + " mode (stayed=" + (AOSystemTools.INSTANCE.nowTimeMillis() - this.f24989b) + "ms).");
        return com.obric.autogui.common.e.f29014b.a();
    }

    @Override // com.obric.autogui.util.c.b
    public void b(com.obric.autogui.util.c.b r9) {
        d.h.b.o.e((com.obric.autogui.util.c.b) ZeusTransformUtils.wrapperContextForParams(r9, com.obric.autogui.util.c.b.class, "com.obric.aiagent.plugin"), "fromState");
        Loog.INSTANCE.d(TAG, " - [AssistInput] entered InputStarting mode.");
        this.f24989b = AOSystemTools.INSTANCE.nowTimeMillis();
        IAssistInputHost r10 = (IAssistInputHost) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAssistInputHost.class), IAssistInputHost.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L5;
        r10.startInput();
    L5:
        am r2 = a();
        if (r2 == null) goto L9;
        kotlinx.coroutines.i.a(r2, null, null, (m) ZeusTransformUtils.preCheckCast(new b(null), m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    }
}
