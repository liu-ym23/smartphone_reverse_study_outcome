package com.obric.aiagent.executionengine.eventstaskmanager.timertask;

import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import com.obric.aiagent.assistant.idl.r;
import com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.b.g;
import com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.b.h;
import com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.bean.TimerTaskBean;
import com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.bean.TimerTaskRecordBean;
import com.obric.aiagent.platform.depend.ISecureLogDepend;
import com.obric.autoaction.view.DraggableFloatingLayout;
import com.obric.capabilitykit.entity.EntityContentProvider;
import com.obric.eventkit.eventstaskmanager.ITimerTaskChangeListener;
import com.obric.eventkit.task.model.TimerTask;
import com.obric.eventkit.task.model.TimerTaskAction;
import com.obric.eventkit.task.model.TimerTaskRecord;
import com.obric.eventkit.task.model.TimerTaskResult;
import com.obric.eventkit.task.utils.CronHelper;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.aa;
import d.n;
import d.o;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.ce;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: TimerTaskManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private static final String TAG = "TimerTaskManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f17879a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final h f17880b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final g f17881c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final am f17882d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ConcurrentHashMap<String, List<ITimerTaskChangeListener>> f17883e = null;
    private static String f;
    private static volatile ca g;

    /* JADX INFO: compiled from: TimerTaskManager.kt */
    @d.c.b.a.f(b = "TimerTaskManager.kt", c = {399}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.timertask.TimerTaskManager$dispatchTask$1")
    static final class a extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17884a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f17885b;

        /* JADX INFO: renamed from: com.obric.aiagent.executionengine.eventstaskmanager.timertask.b$a$1, reason: invalid class name */
        /* JADX INFO: compiled from: TimerTaskManager.kt */
        @d.c.b.a.f(b = "TimerTaskManager.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.timertask.TimerTaskManager$dispatchTask$1$1")
        static final class AnonymousClass1 extends l implements m<am, d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f17886a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f17887b;

            AnonymousClass1(int r3, d.c.d<? super AnonymousClass1> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f17887b = r3;
                super(2, r5);
            }

            public final Object a(am r3, d.c.d<? super x> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
                d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f17887b, r4), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r2) {
                d.c.a.b.a();
                if (this.f17886a != 0) goto L7;
                o.a(r2);
                b.a(b.f17879a, this.f17887b);
                return x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        a(int r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17885b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f17885b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17884a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r7);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r7);
            d.c.g r8 = (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin");
            m r2 = (m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f17885b, null), m.class, "com.obric.aiagent.plugin");
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17884a = 1;
            if (i.a(r8, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aiagent.executionengine.eventstaskmanager.timertask.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: TimerTaskManager.kt */
    @d.c.b.a.f(b = "TimerTaskManager.kt", c = {646}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.timertask.TimerTaskManager$notifyChange$1")
    static final class C0366b extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17888a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f17889b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f17890c;

        /* JADX INFO: renamed from: com.obric.aiagent.executionengine.eventstaskmanager.timertask.b$b$1, reason: invalid class name */
        /* JADX INFO: compiled from: TimerTaskManager.kt */
        @d.c.b.a.f(b = "TimerTaskManager.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.timertask.TimerTaskManager$notifyChange$1$1")
        static final class AnonymousClass1 extends l implements m<am, d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f17891a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f17892b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ int f17893c;

            AnonymousClass1(String r3, int r4, d.c.d<? super AnonymousClass1> r5) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                this.f17892b = r3;
                this.f17893c = r4;
                super(2, r6);
            }

            public static /* synthetic */ boolean lambda$JnmDihCuSGkBEQO2Y34kyhTwBdM(ITimerTaskChangeListener r0) {
                return a(r0);
            }

            public final Object a(am r3, d.c.d<? super x> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f17892b, this.f17893c, r5), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r5) {
                d.c.a.b.a();
                if (this.f17891a != 0) goto L18;
                o.a(r5);
                List r6 = (List) ZeusTransformUtils.preCheckCast(b.e().get(this.f17892b), List.class, "com.obric.aiagent.plugin");
                if (r6 == null) goto L7;
                d.c.b.a.b.a(p.a(r6, $$Lambda$b$b$1$JnmDihCuSGkBEQO2Y34kyhTwBdM.INSTANCE));
            L7:
                List r7 = (List) ZeusTransformUtils.preCheckCast(b.e().get(this.f17892b), List.class, "com.obric.aiagent.plugin");
                if (r7 == null) goto L15;
                Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin");
                int r0 = this.f17893c;
                Iterator r9 = r8.iterator();
            L11:
                if (r9.hasNext() == false) goto L15;
                ITimerTaskChangeListener r2 = (ITimerTaskChangeListener) ZeusTransformUtils.preCheckCast(r9.next(), ITimerTaskChangeListener.class, "com.obric.aiagent.plugin");
                if (r2.asBinder().isBinderAlive() == false) goto L11;
                r2.onChanged(r0);
            L15:
                com.obric.aiagent.executionengine.eventstaskmanager.b.f16672a.a(this.f17892b, this.f17893c);
                return x.f38692a;
            L18:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            private static final boolean a(ITimerTaskChangeListener r2) {
                return !((ITimerTaskChangeListener) ZeusTransformUtils.wrapperContextForParams(r2, ITimerTaskChangeListener.class, "com.obric.aiagent.plugin")).asBinder().isBinderAlive();
            }
        }

        C0366b(String r3, int r4, d.c.d<? super C0366b> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17889b = r3;
            this.f17890c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((C0366b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0366b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new C0366b(this.f17889b, this.f17890c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17888a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r8);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r8);
            d.c.g r9 = (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin");
            m r2 = (m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f17889b, this.f17890c, null), m.class, "com.obric.aiagent.plugin");
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17888a = 1;
            if (i.a(r9, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: TimerTaskManager.kt */
    @d.c.b.a.f(b = "TimerTaskManager.kt", c = {71, 84}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.timertask.TimerTaskManager$registerAllTasks$1$1")
    static final class c extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17894a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ IFlowAppIntentIDL f17895b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private /* synthetic */ Object f17896c;

        /* JADX INFO: renamed from: com.obric.aiagent.executionengine.eventstaskmanager.timertask.b$c$1, reason: invalid class name */
        /* JADX INFO: compiled from: TimerTaskManager.kt */
        @d.c.b.a.f(b = "TimerTaskManager.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.timertask.TimerTaskManager$registerAllTasks$1$1$1")
        static final class AnonymousClass1 extends l implements m<am, d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f17897a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f17898b;

            AnonymousClass1(String r3, d.c.d<? super AnonymousClass1> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f17898b = r3;
                super(2, r5);
            }

            public final Object a(am r3, d.c.d<? super x> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
                d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f17898b, r4), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r2) {
                d.c.a.b.a();
                if (this.f17897a != 0) goto L7;
                o.a(r2);
                b.a(b.f17879a, this.f17898b);
                b.f17879a.c();
                return x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        c(IFlowAppIntentIDL r3, d.c.d<? super c> r4) {
            IFlowAppIntentIDL r5 = (IFlowAppIntentIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowAppIntentIDL.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17895b = r5;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            c r0 = new c(this.f17895b, r5);
            r0.f17896c = r3;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17894a;
            boolean r3 = false;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            o.a(r10);
        L42:
            return x.f38692a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            o.a(r10);
        L29:
            String r11 = (String) ZeusTransformUtils.preCheckCast(r10, String.class, "com.obric.aiagent.plugin");
        L30:
            CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin");
            if (r2 != null) goto L33;
        L34:
            r3 = true;
        L35:
            if (r3 == false) goto L38;
            com.obric.event.task.base.report.e.f32759a.a(b.TAG, "retryUserId still empty after 3 retries");
            com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.d(b.TAG, "registerAllTasks skip, userId still empty after 3 retries");
            return x.f38692a;
        L38:
            String r4 = b.d();
            b r5 = b.f17879a;
            b.c(r11);
            com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(b.TAG, "registerAllTasks uidWithRegisterTask = " + b.d());
            d.c.g r12 = (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin");
            m r6 = (m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r4, null), m.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17894a = 2;
            if (i.a(r12, r6, r7) != r0) goto L42;
            return r0;
        L33:
            if (r2.length() != 0) goto L35;
        L10:
            o.a(r10);
            am r13 = (am) ZeusTransformUtils.preCheckCast(this.f17896c, am.class, "com.obric.aiagent.plugin");
            IFlowAppIntentIDL r14 = this.f17895b;
            n.a r8 = n.f38560a;     // Catch: Throwable -> L13
            Object r15 = n.f(r14.getUserId());     // Catch: Throwable -> L13
        L16:
            if (n.b(r15) == false) goto L18;
            r15 = null;
        L18:
            r11 = (String) ZeusTransformUtils.preCheckCast(r15, String.class, "com.obric.aiagent.plugin");
            CharSequence r9 = (CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin");
            if (r9 != null) goto L21;
        L24:
            boolean r16 = true;
        L25:
            if (r16 == false) goto L30;
            com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.c(b.TAG, "registerAllTasks userId empty, start retry");
            b r17 = b.f17879a;
            IFlowAppIntentIDL r18 = this.f17895b;
            d.c.d r19 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17894a = 1;
            r10 = b.a(r17, r18, r19);
            if (r10 != r0) goto L29;
            return r0;
        L21:
            if (r9.length() == 0) goto L24;
            r16 = false;
        L13:
            th = move-exception;
            n.a r20 = n.f38560a;
            r15 = n.f(o.a(th));
            goto L16
        }
    }

    /* JADX INFO: compiled from: TimerTaskManager.kt */
    @d.c.b.a.f(b = "TimerTaskManager.kt", c = {103}, d = "retryUserId", e = "com.obric.aiagent.executionengine.eventstaskmanager.timertask.TimerTaskManager")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f17899a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f17900b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f17901c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f17902d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f17903e;
        final /* synthetic */ b f;
        int g;

        d(b r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f17903e = r3;
            this.g |= Integer.MIN_VALUE;
            return b.a(this.f, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: TimerTaskManager.kt */
    @d.c.b.a.f(b = "TimerTaskManager.kt", c = {126, 129}, d = "unregisterAllTasks", e = "com.obric.aiagent.executionengine.eventstaskmanager.timertask.TimerTaskManager")
    static final class e extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f17904a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f17905b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f17906c;

        e(b r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17905b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f17904a = r3;
            this.f17906c |= Integer.MIN_VALUE;
            return this.f17905b.a((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: TimerTaskManager.kt */
    @d.c.b.a.f(b = "TimerTaskManager.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.timertask.TimerTaskManager$unregisterAllTasks$2")
    static final class f extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17907a;

        f(d.c.d<? super f> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new f((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r1) {
            d.c.a.b.a();
            if (this.f17907a != 0) goto L7;
            o.a(r1);
            b.a(b.f17879a, b.d());
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static /* synthetic */ void lambda$tQt4VaEjNcsWeotnU3fGzWd074Y(IFlowAppIntentIDL r0) {
        a(r0);
    }

    private b() {
    }

    public static final /* synthetic */ Object a(b r2, IFlowAppIntentIDL r3, d.c.d r4) {
        return r2.a((IFlowAppIntentIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowAppIntentIDL.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void a(b r0, int r1) {
        r0.c(r1);
    }

    public static final /* synthetic */ void a(b r0, String r1) {
        r0.d(r1);
    }

    public static final /* synthetic */ void c(String r0) {
        f = r0;
    }

    public static final /* synthetic */ String d() {
        return f;
    }

    public static final /* synthetic */ ConcurrentHashMap e() {
        return f17883e;
    }

    static {
        f17879a = new b();
        f17880b = new h();
        f17881c = new g();
        f17882d = an.a((d.c.g) ZeusTransformUtils.preCheckCast(com.obric.aiagent.executionengine.eventstaskmanager.timertask.c.f17908a.b(), d.c.g.class, "com.obric.aiagent.plugin"));
        f17883e = new ConcurrentHashMap();
        f = "";
    }

    public final void a() {
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "TimerTaskManager init");
        b();
    }

    public final void b() {
        r.a(aa.b(IFlowAppIntentIDL.class), false, false, $$Lambda$b$tQt4VaEjNcsWeotnU3fGzWd074Y.INSTANCE, 3, null);
    }

    private static final void a(IFlowAppIntentIDL r10) {
        IFlowAppIntentIDL r11 = (IFlowAppIntentIDL) ZeusTransformUtils.wrapperContextForParams(r10, IFlowAppIntentIDL.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r11, "ipc");
        ca r0 = g;
        if (r0 == null) goto L5;
        ca.a.a(r0, null, 1, null);
    L5:
        g = i.a(f17882d, null, null, (m) ZeusTransformUtils.preCheckCast(new c(r11, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x007c -> B:52:0x007d). Please report as a decompilation issue!!! */
    private final Object a(IFlowAppIntentIDL r12, d.c.d<? super String> r13) {
        IFlowAppIntentIDL r14 = (IFlowAppIntentIDL) ZeusTransformUtils.wrapperContextForParams(r12, IFlowAppIntentIDL.class, "com.obric.aiagent.plugin");
        d.c.d r15 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r15, d.class) == false) goto L7;
        d r0 = (d) ZeusTransformUtils.preCheckCast(r15, d.class, "com.obric.aiagent.plugin");
        if ((r0.g & Integer.MIN_VALUE) == 0) goto L7;
        r0.g -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.f17903e;
        Object r16 = d.c.a.b.a();
        int r2 = r0.g;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        int r17 = r0.f17902d;
        int r3 = r0.f17901c;
        int r6 = r0.f17900b;
        IFlowAppIntentIDL r7 = (IFlowAppIntentIDL) ZeusTransformUtils.preCheckCast(r0.f17899a, IFlowAppIntentIDL.class, "com.obric.aiagent.plugin");
        o.a(r11);
        IFlowAppIntentIDL r18 = r7;
    L52:
        n.a r8 = n.f38560a;     // Catch: Throwable -> L22
        Object r9 = n.f(r18.getUserId());     // Catch: Throwable -> L22
    L25:
        if (n.b(r9) == false) goto L27;
        r9 = null;
    L27:
        String r10 = (String) ZeusTransformUtils.preCheckCast(r9, String.class, "com.obric.aiagent.plugin");
        CharSequence r19 = (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin");
        if (r19 != null) goto L30;
    L33:
        boolean r20 = true;
    L34:
        if (r20 == false) goto L39;
        IFlowAppIntentIDL r21 = r.a(aa.b(IFlowAppIntentIDL.class));
        if (r21 == null) goto L38;
        r10 = r21.getUserId();
        goto L39
    L38:
        r10 = null;
    L39:
        CharSequence r22 = (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin");
        if (r22 != null) goto L42;
    L45:
        boolean r23 = true;
    L47:
        if (r23 == true) goto L50;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "retryUserId success after " + (r17 + 1) + " retries");
        return r10;
    L50:
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.c(TAG, "retryUserId still empty, attempt=" + (r17 + 1) + "/3");
        r17 = r3 + 1;
    L15:
        if (r17 >= r6) goto L51;
        r0.f17899a = r18;
        r0.f17900b = r6;
        r0.f17901c = r17;
        r0.f17902d = r17;
        r0.g = 1;
        if (ax.a(EntityContentProvider.g, r0) != r16) goto L19;
        return r16;
    L19:
        r3 = r17;
        goto L52
    L51:
        return null;
    L42:
        if (r22.length() == 0) goto L45;
        r23 = false;
        goto L47
    L30:
        if (r19.length() == 0) goto L33;
        r20 = false;
    L22:
        th = move-exception;
        n.a r24 = n.f38560a;
        r9 = n.f(o.a(th));
        goto L25
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r11);
        r6 = 3;
        r18 = r14;
        r17 = 0;
    L7:
        r0 = new d(this, r15);
        goto L8
    }

    public final Object a(d.c.d<? super x> r11) {
        d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, e.class) == false) goto L7;
        e r0 = (e) ZeusTransformUtils.preCheckCast(r12, e.class, "com.obric.aiagent.plugin");
        if ((r0.f17906c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f17906c -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.f17904a;
        Object r13 = d.c.a.b.a();
        int r2 = r0.f17906c;
        if (r2 == 0) goto L16;
        if (r2 == 1) goto L15;
        if (r2 != 2) goto L14;
        o.a(r10);
    L25:
        return x.f38692a;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        o.a(r10);
    L21:
        ca r14 = i.a(f17882d, null, null, (m) ZeusTransformUtils.preCheckCast(new f(null), m.class, "com.obric.aiagent.plugin"), 3, null);
        r0.f17906c = 2;
        if (r14.b(r0) != r13) goto L25;
        return r13;
    L16:
        o.a(r10);
        ca r15 = g;
        if (r15 == null) goto L21;
        r0.f17906c = 1;
        if (ce.a(r15, r0) != r13) goto L21;
        return r13;
    L7:
        r0 = new e(this, r12);
        goto L8
    }

    private final void d(String r5) {
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r4 = true;
    L7:
        if (r4 == false) goto L10;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "cancelAllAlarms skip, uid is empty");
        return;
    L10:
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "cancelAllAlarms, uid = " + r5);
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(f17880b.a(r5), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L12:
        if (r6.hasNext() == false) goto L14;
        com.obric.aiagent.executionengine.eventstaskmanager.timertask.alarm.a.f17876a.b((TimerTask) ZeusTransformUtils.preCheckCast(r6.next(), TimerTask.class, "com.obric.aiagent.plugin"));
        goto L12
    L14:
        return;
    L5:
        r4 = false;
        goto L7
    }

    public final void c() {
        List<TimerTask> r0 = f17880b.a();
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "restartAllAlarm allTasks:" + r0.size());
        ISecureLogDepend.Companion.i(TAG, "restartAllAlarm allTasks:" + r0);
        long r1 = System.currentTimeMillis();
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r2.hasNext() == false) goto L30;
        TimerTask r3 = (TimerTask) ZeusTransformUtils.preCheckCast(r2.next(), TimerTask.class, "com.obric.aiagent.plugin");
        b r5 = f17879a;
        Integer r6 = r3.getId();
        d.h.b.o.a(r6);
        TimerTaskBean r7 = r5.b(r6.intValue());
        if (r7 == null) goto L4;
        if (r7.getEnableStatus() == 3) goto L4;
        Long r15 = CronHelper.INSTANCE.getNextScheduleTime(r7.getCronTime(), Long.valueOf(r1));
        if (r15 == null) goto L14;
    L16:
        if (r15 != null) goto L18;
    L20:
        Long r27 = r15;
        f17880b.a(TimerTaskBean.copy$default(r7, null, false, null, null, null, 0, null, 0, 0, r27, null, null, 3583, null));
    L21:
        Integer r8 = r3.getId();
        d.h.b.o.a(r8);
        TimerTaskBean r9 = r5.b(r8.intValue());
        if (r9 == null) goto L4;
        Long r10 = r27;
        if (r10 == null) goto L29;
        long r11 = ((Number) ZeusTransformUtils.preCheckCast(r10, Number.class, "com.obric.aiagent.plugin")).longValue();
        if (r9.isEnable() == false) goto L29;
        com.obric.aiagent.executionengine.eventstaskmanager.timertask.alarm.a r12 = com.obric.aiagent.executionengine.eventstaskmanager.timertask.alarm.a.f17876a;
        Integer r4 = r3.getId();
        d.h.b.o.a(r4);
        r12.a(r4.intValue(), r11);
    L29:
        r5.a(r7.getSourceFrom(), 1);
        goto L4
    L18:
        if (r7.getEnableStatus() != 1) goto L20;
        r27 = r15;
        f17880b.a(TimerTaskBean.copy$default(r7, null, false, null, null, null, 0, null, 0, 0, r27, null, null, 3327, null));
        goto L21
    L14:
        if (r7.isEnable() == false) goto L16;
        r27 = r15;
        f17880b.a(TimerTaskBean.copy$default(r7, null, false, null, null, null, 0, null, 0, 1, r27, null, null, 3327, null));
        goto L21
    }

    private final void a(TimerTaskBean r19, long r20) {
        if (r19.isRepeat() == false) goto L15;
        Long r15 = CronHelper.INSTANCE.getNextScheduleTime(r19.getCronTime(), r19.getNextScheduleTime());
    L6:
        if (r15 == null) goto L10;
        if (((Number) ZeusTransformUtils.preCheckCast(r15, Number.class, "com.obric.aiagent.plugin")).longValue() >= r20) goto L10;
        r15 = CronHelper.INSTANCE.getNextScheduleTime(r19.getCronTime(), Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(r15, Number.class, "com.obric.aiagent.plugin")).longValue() + 1));
    L10:
        if (r15 != null) goto L13;
        a(r19, 3);
        return;
    L13:
        TimerTaskBean r0 = TimerTaskBean.copy$default(r19, null, false, null, null, null, 0, null, 0, 0, r15, null, null, 3583, null);
        f17880b.a(r0);
        com.obric.aiagent.executionengine.eventstaskmanager.timertask.alarm.a.f17876a.a(r0.getTaskId(), ((Number) ZeusTransformUtils.preCheckCast(r15, Number.class, "com.obric.aiagent.plugin")).longValue());
        f17879a.a(r0.getSourceFrom(), 1);
        return;
    L15:
        a(r19, 3);
    }

    private final void a(TimerTaskBean r17, int r18) {
        f17880b.a(TimerTaskBean.copy$default(r17, null, false, null, null, null, 0, null, r18, 1, null, null, null, 3711, null));
        a(r17.getSourceFrom(), 1);
    }

    public final TimerTaskResult a(TimerTask r13, String r14) {
        d.h.b.o.e(r13, "task");
        TimerTask r1 = null;
        if (r14 != null) goto L7;
        return new TimerTaskResult(-201, "Package name is null", null);
    L7:
        if (com.obric.aiagent.executionengine.eventstaskmanager.common.c.a(r14) == false) goto L9;
        n.a r2 = n.f38560a;     // Catch: Throwable -> L12
        Object r3 = n.f((TimerTaskAction) ZeusTransformUtils.preCheckCast(com.obric.eventkit.task.model.b.a().fromJson(r13.getAction(), TimerTaskAction.class), TimerTaskAction.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L12
    L14:
        Throwable r4 = n.c(r3);
        if (r4 == null) goto L19;
        return new TimerTaskResult(-301, "Action is invalid:" + r4 + "，please use TimerTaskAction Format", null);
    L19:
        if (n.b(r3) == false) goto L21;
        r3 = null;
    L21:
        TimerTaskAction r8 = (TimerTaskAction) ZeusTransformUtils.preCheckCast(r3, TimerTaskAction.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L24;
        String r7 = r13.getCronExpr();
        n.a r0 = n.f38560a;     // Catch: Throwable -> L28
        CronHelper.INSTANCE.isValidCronException(r7);     // Catch: Throwable -> L28
        Object r5 = n.f(x.f38692a);     // Catch: Throwable -> L28
    L30:
        Throwable r6 = n.c(r5);
        if (r6 != null) goto L33;
        Long r9 = CronHelper.getNextScheduleTime$default(CronHelper.INSTANCE, r7, null, 2, null);
        if (r9 == null) goto L37;
        int r15 = f17880b.a(r13, r7, r8, r9.longValue(), r14);
        a(r14, 1);
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "addTimerTask return taskId: " + r15);
        TimerTask r12 = a(r15, r14);
        if (r12 == null) goto L42;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "getTimerTaskByTaskId " + r15 + " timerTask");
        ISecureLogDepend.Companion.i(TAG, "getTimerTaskByTaskId " + r15 + " timerTask:" + r12);
        com.obric.aiagent.executionengine.eventstaskmanager.timertask.alarm.a.f17876a.a(r12);
        r1 = r12;
    L42:
        return new TimerTaskResult(0, "Success", p.a(r1));
    L37:
        return new TimerTaskResult(-303, "Cron (" + r7 + ") expression is out of date", null);
    L33:
        return new TimerTaskResult(-302, "Cron (" + r7 + ") expression is invalid:" + r6, null);
    L28:
        th = move-exception;
        n.a r10 = n.f38560a;
        r5 = n.f(o.a(th));
        goto L30
    L24:
        return new TimerTaskResult(-301, "Action is invalid，please use TimerTaskAction Format", null);
    L12:
        th = move-exception;
        n.a r11 = n.f38560a;
        r3 = n.f(o.a(th));
        goto L14
    L9:
        return new TimerTaskResult(-100, "Permission denied", null);
    }

    public final TimerTaskResult b(TimerTask r2, String r3) {
        d.h.b.o.e(r2, "task");
        return c(r2, r3);
    L5:
        e = move-exception;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b r4 = com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a;
        StringBuilder r5 = new StringBuilder().append("updateTimerTask error: ").append(e).append(' ');
        e.printStackTrace();
        r4.d(TAG, r5.append(x.f38692a).toString());
        return new TimerTaskResult(-999, "Update error", null);
    }

    private final TimerTaskResult c(TimerTask r18, String r19) {
        if (r19 != null) goto L7;
        return new TimerTaskResult(-201, "Package name is null", null);
    L7:
        if (com.obric.aiagent.executionengine.eventstaskmanager.common.c.a(r19) == true) goto L11;
        return new TimerTaskResult(-100, "Permission denied", null);
    L11:
        if (r18.getId() == null) goto L13;
        Integer r1 = r18.getId();
        d.h.b.o.a(r1);
        TimerTaskBean r2 = b(r1.intValue());
        if (r2 != null) goto L19;
        return a(r18, r19);
    L19:
        if (d.h.b.o.a(r2.getSourceFrom(), r19) == false) goto L21;
        TimerTaskAction r3 = com.obric.eventkit.task.model.b.a(r18.getAction());
        Long r16 = CronHelper.getNextScheduleTime$default(CronHelper.INSTANCE, r18.getCronExpr(), null, 2, null);
        if (r16 == null) goto L25;
        Integer r4 = r18.getId();
        d.h.b.o.a(r4);
        int r7 = r4.intValue();
        String r5 = r18.getName();
        if (r5 != null) goto L29;
        r5 = r2.getName();
    L29:
        String r6 = r5;
        String r8 = r18.getCronExpr();
        if (r3 == null) goto L33;
        String r9 = r3.getQuery();
        if (r9 == null) goto L33;
    L34:
        if (r3 == null) goto L37;
        String r10 = r3.getIntent();
        if (r10 == null) goto L37;
    L38:
        String r11 = r10;
        boolean r12 = CronHelper.INSTANCE.isTimeRecurring(r18.getCronExpr());
        Integer r13 = r18.getTaskStatus();
        if (r13 == null) goto L41;
        int r14 = r13.intValue();
    L42:
        int r15 = r14;
        Integer r17 = r18.getEnableStatus();
        if (r17 == null) goto L45;
        int r20 = r17.intValue();
    L46:
        int r110 = r20;
        Long r21 = r18.getCreateTime();
        if (r21 != null) goto L49;
        Long r111 = r2.getCreateTime();
    L50:
        Map<String, String> r22 = r18.getExt();
        if (r22 == null) goto L53;
        String r112 = com.obric.eventkit.task.model.b.a().toJson(r22);
    L54:
        TimerTaskBean r113 = new TimerTaskBean(r8, r12, r6, r9, r11, r7, r19, r15, r110, r16, r111, r112);
        com.obric.aiagent.executionengine.eventstaskmanager.timertask.alarm.a.f17876a.b(r18);
        if (f17880b.a(r113) <= 0) goto L58;
        a(r19, 1);
        com.obric.aiagent.executionengine.eventstaskmanager.timertask.alarm.a r0 = com.obric.aiagent.executionengine.eventstaskmanager.timertask.alarm.a.f17876a;
        Integer r23 = r18.getId();
        d.h.b.o.a(r23);
        r0.a(r23.intValue(), r16.longValue());
        return new TimerTaskResult(0, "Success", p.a(r113.toTimerTask()));
    L58:
        return new TimerTaskResult(-999, "no data update, error", null);
    L53:
        r112 = null;
        goto L54
    L49:
        r111 = r21;
        goto L50
    L45:
        r20 = r2.getEnableStatus();
        goto L46
    L41:
        r14 = r2.getTaskStatus();
    L37:
        r10 = r2.getIntent();
    L33:
        r9 = r2.getAction();
        goto L34
    L25:
        return new TimerTaskResult(-303, "Cron expression is invalid or out of date", null);
    L21:
        return new TimerTaskResult(-100, "Task id is not belong to this package", null);
    L13:
        return new TimerTaskResult(-304, "Task id is null", null);
    }

    public final TimerTaskResult a(List<Integer> r6, String r7) {
        List<Integer> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r8, DBDefinition.TASK_ID);
        d.h.b.o.e(r7, "packageName");
        if (com.obric.aiagent.executionengine.eventstaskmanager.common.c.a(r7) == true) goto L7;
        return new TimerTaskResult(-100, "Permission denied", null);
    L7:
        if (r8.isEmpty() == true) goto L9;
        List<TimerTask> r0 = f17880b.a(r8, r7);
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "removeTimerTasksByTaskId size:" + r8.size() + " return " + r0.size());
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L12:
        if (r9.hasNext() == false) goto L14;
        TimerTask r2 = (TimerTask) ZeusTransformUtils.preCheckCast(r9.next(), TimerTask.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.eventstaskmanager.timertask.alarm.a.f17876a.b(r2);
        b r3 = f17879a;
        Integer r4 = r2.getId();
        d.h.b.o.a(r4);
        r3.c(r4.intValue(), r7);
        goto L12
    L14:
        a(r7, 1);
        return new TimerTaskResult(0, "Success", r0);
    L9:
        return new TimerTaskResult(-400, "Task id is empty", null);
    }

    public final TimerTask a(int r1, String r2) {
        d.h.b.o.e(r2, "checkPackage");
        return f17880b.a(r1, r2);
    }

    private final TimerTaskBean b(int r1) {
        return f17880b.a(r1);
    }

    public final Long b(int r1, String r2) {
        d.h.b.o.e(r2, "packageName");
        return f17880b.b(r1, r2);
    }

    public final void a(int r7) {
        i.a(f17882d, null, null, (m) ZeusTransformUtils.preCheckCast(new a(r7, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final void c(int r22) {
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "dispatchTask, taskId: " + r22);
        TimerTaskBean r2 = b(r22);
        if (r2 != null) goto L6;
        return;
    L6:
        if (r2.isEnable() == true) goto L10;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.d(TAG, "dispatchTask, taskId: " + r22 + ". is not enable!, return");
        return;
    L10:
        if (r2.getAction() == null) goto L12;
    L15:
        long r6 = System.currentTimeMillis();
        Long r3 = r2.getNextScheduleTime();
        if (r3 != null) goto L20;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.d(TAG, "dispatchTask, taskId: " + r22 + ". nextScheduleTime is null!, return");
        return;
    L20:
        if (r3.longValue() >= (r6 - DraggableFloatingLayout.DEFAULT_RIGHT_REVEAL_AUTO_RETRACT_DELAY_MS)) goto L24;
        a(r2, r6);
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.d(TAG, "dispatchTask error, taskId: " + r22 + ". out of time no dispatch, return");
        return;
    L24:
        if (r3.longValue() <= (r6 + DraggableFloatingLayout.DEFAULT_RIGHT_REVEAL_AUTO_RETRACT_DELAY_MS)) goto L27;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.d(TAG, "dispatchTask error, taskId: " + r22 + ". time is too small than " + r3);
        return;
    L27:
        String r4 = r2.getAction();
        if (r4 == null) goto L30;
        String r7 = r2.getSourceFrom();
        com.obric.aiagent.executionengine.eventstaskmanager.common.b.f16681a.a(r22, r4, r7);
        f17881c.a(r2, System.currentTimeMillis(), 2);
        f17879a.a(r7, 2);
    L30:
        String r5 = r2.getIntent();
        if (r5 == null) goto L34;
        com.obric.aiagent.executionengine.eventstaskmanager.common.b.f16681a.b(r22, r5, r2.getSourceFrom());
        f17881c.a(r2, System.currentTimeMillis(), 2);
        f17879a.a(r2.getSourceFrom(), 2);
    L34:
        if (r2.isRepeat() == false) goto L40;
        Long r8 = CronHelper.INSTANCE.getNextScheduleTime(r2.getCronTime(), r2.getNextScheduleTime());
        if (r8 != null) goto L39;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.d(TAG, "getNextScheduleTime return null, taskId: " + r22);
        a(r2, 2);
        return;
    L39:
        f17880b.a(TimerTaskBean.copy$default(r2, null, false, null, null, null, 0, null, 0, 0, r8, null, null, 3583, null));
        a(r2.getSourceFrom(), 1);
        com.obric.aiagent.executionengine.eventstaskmanager.timertask.alarm.a.f17876a.a(r22, r8.longValue());
        return;
    L40:
        a(r2, 2);
        return;
    L12:
        if (r2.getIntent() != null) goto L15;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.d(TAG, "dispatchTask, taskId: " + r22 + ". action and intent is null!, return");
    }

    public final List<TimerTask> a(Map<Object, Object> r6, String r7) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "parameters");
        d.h.b.o.e(r7, "packageName");
        StringBuilder r8 = new StringBuilder("SELECT * FROM timer_task_bean WHERE `source_from` = ?");
        List r9 = p.c(new Object[]{r7});
        Iterator r10 = r5.entrySet().iterator();     // Catch: Exception -> L28
    L5:
        if (r10.hasNext() == false) goto L26;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L28
        Object r3 = r1.getKey();     // Catch: Exception -> L28
        Object r2 = r1.getValue();     // Catch: Exception -> L28
        if (r2 == null) goto L5;
        if (d.h.b.o.a(r3, DbHelper.COL_ID) == true) goto L11;
        if (d.h.b.o.a(r3, "name") == true) goto L14;
        if (d.h.b.o.a(r3, "time") == true) goto L17;
        if (d.h.b.o.a(r3, "action") == false) goto L5;
        TimerTaskAction r4 = (TimerTaskAction) ZeusTransformUtils.preCheckCast(com.obric.eventkit.task.model.b.a().fromJson((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin"), TimerTaskAction.class), TimerTaskAction.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L28
        if (r4.getQuery() == null) goto L24;
        r8.append(" And `action` = ?");     // Catch: Exception -> L28
        String r11 = r4.getQuery();     // Catch: Exception -> L28
        d.h.b.o.a(r11);     // Catch: Exception -> L28
        r9.add(r11);     // Catch: Exception -> L28
    L24:
        if (r4.getIntent() == null) goto L5;
        r8.append(" And `intent` = ?");     // Catch: Exception -> L28
        String r12 = r4.getIntent();     // Catch: Exception -> L28
        d.h.b.o.a(r12);     // Catch: Exception -> L28
        r9.add(r12);     // Catch: Exception -> L28
        goto L5
    L17:
        r8.append(" And `cronTime` = ?");     // Catch: Exception -> L28
        r9.add((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L28
        goto L5
    L14:
        r8.append(" And `name` = ?");     // Catch: Exception -> L28
        r9.add((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L28
        goto L5
    L11:
        r8.append(" And `task_id` = ?");     // Catch: Exception -> L28
        r9.add((Integer) ZeusTransformUtils.preCheckCast(r2, Integer.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L28
        goto L5
    L26:
        return f17880b.a((androidx.sqlite.db.f) ZeusTransformUtils.preCheckCast(new androidx.sqlite.db.a(r8.toString(), ((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.aiagent.plugin")).toArray(new Object[0])), androidx.sqlite.db.f.class, "com.obric.aiagent.plugin"));
    L28:
        e = move-exception;
        e.printStackTrace();
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.d(TAG, "query timer task error " + e + ", return empty list");
        return (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
    }

    public final List<TimerTask> a(String r2) {
        d.h.b.o.e(r2, "packageName");
        if (com.obric.aiagent.executionengine.eventstaskmanager.common.c.a(r2) == true) goto L7;
        return (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
    L7:
        return f17880b.b(r2);
    }

    public final List<TimerTask> a(String r1, int r2, int r3) {
        if (r1 != null) goto L4;
    L8:
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.d(TAG, "getTimerTaskByPackageNamePaged pkgName check error");
        return (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
    L4:
        if (com.obric.aiagent.executionengine.eventstaskmanager.common.c.a(r1) == false) goto L8;
        return f17880b.a(r1, r2, r3);
    }

    public final TimerTaskResult a(List<Integer> r18, List<Long> r19, String r20) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.aiagent.plugin");
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, DBDefinition.TASK_ID);
        d.h.b.o.e(r3, "timeStamp");
        d.h.b.o.e(r20, "packageName");
        if (r1.size() != r3.size()) goto L5;
        List r4 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        int r7 = 0;
    L8:
        if (r2.hasNext() == false) goto L34;
        Object r8 = r2.next();
        int r10 = r7 + 1;
        if (r7 >= 0) goto L12;
        p.c();
    L12:
        int r9 = ((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.aiagent.plugin")).intValue();
        long r11 = ((Number) ZeusTransformUtils.preCheckCast(r3.get(r7), Number.class, "com.obric.aiagent.plugin")).longValue();
        b r12 = f17879a;
        TimerTaskBean r13 = r12.b(r9);
        if (r13 != null) goto L15;
        int r110 = r10;
    L32:
        r7 = r110;
        goto L8
    L15:
        if (d.h.b.o.a(r13.getSourceFrom(), r20) == false) goto L17;
        Long r5 = CronHelper.INSTANCE.getNextScheduleTime(r13.getCronTime(), Long.valueOf(r11));
        if (r5 == null) goto L30;
        r110 = r10;
        long r14 = r5.longValue();
        Long r6 = r13.getNextScheduleTime();
        if (r6 != null) goto L23;
    L26:
        com.obric.aiagent.executionengine.eventstaskmanager.timertask.alarm.a.f17876a.a(r13.getTaskId());
        List<TimerTask> r15 = f17880b.a(r13, r11);
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L32;
        com.obric.aiagent.executionengine.eventstaskmanager.timertask.alarm.a.f17876a.a(r13.getTaskId(), r14);
        r12.a(r20, 1);
        r4.addAll((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.aiagent.plugin"));
        goto L32
    L23:
        if (r6.longValue() < r14) goto L26;
        return new TimerTaskResult(-501, "nextScheduleTime:" + r6 + " > " + r14 + ", no need to skip", null);
    L30:
        return new TimerTaskResult(-501, "skip error, NextScheduleTime is null, taskId: " + r9, null);
    L17:
        return new TimerTaskResult(-100, "skip timerTask not belong to packageName = " + r20, null);
    L34:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L38;
        return new TimerTaskResult(0, "skipTimerTasksOnceByTaskId success", r4);
    L38:
        return new TimerTaskResult(-999, "no timer task need to skip", null);
    L5:
        return new TimerTaskResult(-305, "Task id and time stamp size not match", null);
    }

    public final List<TimerTaskRecord> a(long r7, long r9, String r11) {
        d.h.b.o.e(r11, "packageName");
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(f17881c.a(r7, r9, r11), Iterable.class, "com.obric.aiagent.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r6, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r10 = r6.iterator();
    L4:
        if (r10.hasNext() == false) goto L7;
        r8.add(((TimerTaskRecordBean) ZeusTransformUtils.preCheckCast(r10.next(), TimerTaskRecordBean.class, "com.obric.aiagent.plugin")).toTimerTaskRecord());
        goto L4
    L7:
        return p.g((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin"));
    }

    public final List<TimerTaskRecord> a(int r8, long r9, long r11, String r13) {
        d.h.b.o.e(r13, "packageName");
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(f17881c.a(r8, r9, r11, r13), Iterable.class, "com.obric.aiagent.plugin");
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r7, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r12 = r7.iterator();
    L4:
        if (r12.hasNext() == false) goto L7;
        r10.add(((TimerTaskRecordBean) ZeusTransformUtils.preCheckCast(r12.next(), TimerTaskRecordBean.class, "com.obric.aiagent.plugin")).toTimerTaskRecord());
        goto L4
    L7:
        return p.g((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin"));
    }

    public final int b(String r3) {
        d.h.b.o.e(r3, "packageName");
        int r0 = f17881c.a(r3);
        if (r0 <= 0) goto L5;
        a(r3, 2);
    L5:
        return r0;
    }

    public final int b(List<Integer> r3, String r4) {
        List<Integer> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "ids");
        d.h.b.o.e(r4, "packageName");
        int r6 = f17881c.a(r5, r4);
        if (r6 <= 0) goto L5;
        a(r4, 2);
    L5:
        return r6;
    }

    private final int c(int r2, String r3) {
        int r4 = f17881c.a(r2);
        if (r4 <= 0) goto L5;
        a(r3, 2);
    L5:
        return r4;
    }

    public final void a(String r7, int r8) {
        d.h.b.o.e(r7, "packageName");
        i.a(f17882d, null, null, (m) ZeusTransformUtils.preCheckCast(new C0366b(r7, r8, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }
}
