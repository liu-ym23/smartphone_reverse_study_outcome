package com.obric.autoaction.app.launcherpage.detail.condition.c;

import com.obric.autoaction.app.launcherpage.condition.config.condition.DayTimeCondition;
import com.obric.autoaction.app.launcherpage.utils.k;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.presentation.IAutoActionPresentationApi;
import com.obric.autogui.database.service.EventTaskService;
import com.obric.cae.libs.useraware.ApWakeEvent;
import com.obric.capabilitykit.common.intent.IntentParams;
import com.obric.capabilitykit.common.intent.SystemAutoActionParams;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.eventkit.task.api.IEventTaskApi;
import com.obric.eventkit.task.api.IEventTaskExecutionApi;
import com.obric.eventkit.task.model.Condition;
import com.obric.eventkit.task.model.ConditionGroup;
import com.obric.eventkit.task.model.ConditionTask;
import com.obric.eventkit.task.model.ConditionTaskAction;
import com.obric.eventkit.task.model.ConditionTaskSpec;
import com.obric.eventkit.task.model.EventTask;
import com.obric.eventkit.task.model.EventTaskResult;
import com.obric.eventkit.task.model.EventTaskSpec;
import com.obric.eventkit.task.model.PeriodicPolicy;
import com.obric.eventkit.task.model.TaskKnowledge;
import com.obric.eventkit.task.model.TimeCondition;
import com.obric.eventkit.task.model.TimerTaskV2;
import com.obric.eventkit.task.model.TriggerControlPolicy;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.p;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.h;
import d.o;
import d.x;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.au;
import kotlinx.coroutines.b.i;
import kotlinx.coroutines.b.j;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.ca;

/* JADX INFO: compiled from: ConditionTaskDetailRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements com.obric.autoaction.app.launcherpage.detail.base.a.b<ConditionTask, ConditionTaskSpec> {
    private static final String TAG = "ConditionTaskRepo";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0510a f23408a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.autoaction.app.launcherpage.detail.base.a.c f23409b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.obric.autoaction.app.launcherpage.module.datasource.b f23410c;

    /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.detail.condition.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ConditionTaskDetailRepository.kt */
    public static final class C0510a {
        public /* synthetic */ C0510a(h r1) {
            this();
        }

        private C0510a() {
        }
    }

    /* JADX INFO: compiled from: ConditionTaskDetailRepository.kt */
    @d.c.b.a.f(b = "ConditionTaskDetailRepository.kt", c = {ITaskManager.Stub.TRANSACTION_removeEventTaskExecutionDetailRecordsBySessionId, 80}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.detail.condition.repository.ConditionTaskDetailRepository$add$1")
    static final class b extends l implements m<i<? super EventTaskResult>, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23411a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ConditionTaskSpec f23412b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f23413c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f23414d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private /* synthetic */ Object f23415e;

        /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.detail.condition.c.a$b$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ConditionTaskDetailRepository.kt */
        @d.c.b.a.f(b = "ConditionTaskDetailRepository.kt", c = {74, 78, 78}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.detail.condition.repository.ConditionTaskDetailRepository$add$1$result$1")
        static final class C0511a extends l implements m<am, d.c.d<? super EventTaskResult>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f23416a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            Object f23417b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            int f23418c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ a f23419d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f23420e;
            final /* synthetic */ String f;
            final /* synthetic */ ConditionTaskSpec g;
            private /* synthetic */ Object h;

            /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.detail.condition.c.a$b$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: ConditionTaskDetailRepository.kt */
            @d.c.b.a.f(b = "ConditionTaskDetailRepository.kt", c = {ITaskManager.Stub.TRANSACTION_tryActiveAgent}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.detail.condition.repository.ConditionTaskDetailRepository$add$1$result$1$extDeferred$1")
            static final class C0512a extends l implements m<am, d.c.d<? super Map<String, ? extends String>>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f23421a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ String f23422b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ String f23423c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                final /* synthetic */ ConditionTaskSpec f23424d;

                C0512a(String r3, String r4, ConditionTaskSpec r5, d.c.d<? super C0512a> r6) {
                    d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
                    this.f23422b = r3;
                    this.f23423c = r4;
                    this.f23424d = r5;
                    super(2, r7);
                }

                public final Object a(am r3, d.c.d<? super Map<String, String>> r4) {
                    return ((C0512a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0512a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
                }

                @Override // d.c.b.a.a
                public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
                    d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                    return (d.c.d) ZeusTransformUtils.preCheckCast(new C0512a(this.f23422b, this.f23423c, this.f23424d, r6), d.c.d.class, "com.obric.aiagent.plugin");
                }

                @Override // d.h.a.m
                public /* synthetic */ Object invoke(am r3, d.c.d<? super Map<String, ? extends String>> r4) {
                    return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
                }

                @Override // d.c.b.a.a
                public final Object invokeSuspend(Object r8) {
                    Object r0 = d.c.a.b.a();
                    int r1 = this.f23421a;
                    if (r1 == 0) goto L8;
                    if (r1 != 1) goto L7;
                    o.a(r8);
                L11:
                    return r8;
                L7:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L8:
                    o.a(r8);
                    k r9 = k.f24509a;
                    String r2 = this.f23422b;
                    String r3 = this.f23423c;
                    Map<String, String> r4 = this.f23424d.getExt();
                    d.c.d<? super Map<String, String>> r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                    this.f23421a = 1;
                    r8 = r9.a(r2, r3, r4, r5);
                    if (r8 != r0) goto L11;
                    return r0;
                }
            }

            C0511a(a r3, String r4, String r5, ConditionTaskSpec r6, d.c.d<? super C0511a> r7) {
                d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                this.f23419d = r3;
                this.f23420e = r4;
                this.f = r5;
                this.g = r6;
                super(2, r8);
            }

            public final Object a(am r3, d.c.d<? super EventTaskResult> r4) {
                return ((C0511a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0511a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r9, d.c.d<?> r10) {
                d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
                C0511a r11 = new C0511a(this.f23419d, this.f23420e, this.f, this.g, r7);
                r11.h = r9;
                return (d.c.d) ZeusTransformUtils.preCheckCast(r11, d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super EventTaskResult> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r14) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f23418c;
                if (r1 == 0) goto L12;
                if (r1 == 1) goto L11;
                if (r1 == 2) goto L10;
                if (r1 != 3) goto L9;
                o.a(r14);
            L29:
                return (EventTaskResult) ZeusTransformUtils.preCheckCast(r14, EventTaskResult.class, "com.obric.aiagent.plugin");
            L9:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L10:
                ConditionTaskSpec r2 = (ConditionTaskSpec) ZeusTransformUtils.preCheckCast(this.f23417b, ConditionTaskSpec.class, "com.obric.aiagent.plugin");
                a r3 = (a) ZeusTransformUtils.preCheckCast(this.f23416a, a.class, "com.obric.aiagent.plugin");
                IEventTaskApi r4 = (IEventTaskApi) ZeusTransformUtils.preCheckCast(this.h, IEventTaskApi.class, "com.obric.aiagent.plugin");
                o.a(r14);
            L25:
                EventTaskSpec r15 = (EventTaskSpec) ZeusTransformUtils.preCheckCast(a.a(r3, r2, (Map) ZeusTransformUtils.preCheckCast(r14, Map.class, "com.obric.aiagent.plugin")), EventTaskSpec.class, "com.obric.aiagent.plugin");
                d.c.d<? super EventTaskResult> r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.h = null;
                this.f23416a = null;
                this.f23417b = null;
                this.f23418c = 3;
                r14 = r4.addEventTask(r15, r5);
                if (r14 != r0) goto L29;
                return r0;
            L11:
                au r6 = (au) ZeusTransformUtils.preCheckCast(this.h, au.class, "com.obric.aiagent.plugin");
                o.a(r14);
            L15:
                EventTaskResult r16 = com.obric.autoaction.app.launcherpage.detail.condition.c.b.a((com.obric.autoaction.app.launcherpage.detail.base.a.d) ZeusTransformUtils.preCheckCast(r14, com.obric.autoaction.app.launcherpage.detail.base.a.d.class, "com.obric.aiagent.plugin"));
                if (r16 == null) goto L19;
                ca.a.a((ca) ZeusTransformUtils.preCheckCast(r6, ca.class, "com.obric.aiagent.plugin"), null, 1, null);
                return r16;
            L19:
                r4 = (IEventTaskApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskApi.class), IEventTaskApi.class, "com.obric.aiagent.plugin");
                if (r4 == null) goto L30;
                a r17 = this.f23419d;
                ConditionTaskSpec r7 = this.g;
                d.c.d r8 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.h = r4;
                this.f23416a = r17;
                this.f23417b = r7;
                this.f23418c = 2;
                Object r9 = r6.a(r8);
                if (r9 != r0) goto L24;
                return r0;
            L24:
                r3 = r17;
                r14 = r9;
                r2 = r7;
                goto L25
            L30:
                return null;
            L12:
                o.a(r14);
                r6 = kotlinx.coroutines.i.b((am) ZeusTransformUtils.preCheckCast(this.h, am.class, "com.obric.aiagent.plugin"), null, null, (m) ZeusTransformUtils.preCheckCast(new C0512a(this.f23420e, this.f, this.g, null), m.class, "com.obric.aiagent.plugin"), 3, null);
                com.obric.autoaction.app.launcherpage.detail.base.a.c r18 = a.a(this.f23419d);
                String r10 = this.f23420e;
                String r11 = this.f;
                d.c.d<? super com.obric.autoaction.app.launcherpage.detail.base.a.d> r12 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.h = r6;
                this.f23418c = 1;
                r14 = r18.a(r10, r11, "condition", r12);
                if (r14 != r0) goto L15;
                return r0;
            }
        }

        b(ConditionTaskSpec r3, a r4, String r5, d.c.d<? super b> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23412b = r3;
            this.f23413c = r4;
            this.f23414d = r5;
            super(2, r7);
        }

        public final Object a(i<? super EventTaskResult> r3, d.c.d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r5, d.c.d<?> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            b r0 = new b(this.f23412b, this.f23413c, this.f23414d, r7);
            r0.f23415e = r5;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(i<? super EventTaskResult> r3, d.c.d<? super x> r4) {
            return a((i) ZeusTransformUtils.preCheckCast(r3, i.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r12) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f23411a;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            o.a(r12);
        L17:
            return x.f38692a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            i r2 = (i) ZeusTransformUtils.preCheckCast(this.f23415e, i.class, "com.obric.aiagent.plugin");
            o.a(r12);
        L13:
            EventTaskResult r13 = (EventTaskResult) ZeusTransformUtils.preCheckCast(r12, EventTaskResult.class, "com.obric.aiagent.plugin");
            d.c.d<? super x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23415e = null;
            this.f23411a = 2;
            if (r2.emit(r13, r3) != r0) goto L17;
            return r0;
        L10:
            o.a(r12);
            r2 = (i) ZeusTransformUtils.preCheckCast(this.f23415e, i.class, "com.obric.aiagent.plugin");
            String r8 = com.obric.autoaction.app.launcherpage.detail.condition.a.a.a(this.f23412b);
            m r14 = (m) ZeusTransformUtils.preCheckCast(new C0511a(this.f23413c, this.f23414d, r8, this.f23412b, null), m.class, "com.obric.aiagent.plugin");
            d.c.d r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23415e = r2;
            this.f23411a = 1;
            r12 = an.a(r14, r5);
            if (r12 != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ConditionTaskDetailRepository.kt */
    @d.c.b.a.f(b = "ConditionTaskDetailRepository.kt", c = {116, 117}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.detail.condition.repository.ConditionTaskDetailRepository$delete$1")
    static final class c extends l implements m<i<? super EventTaskResult>, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23425a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f23426b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private /* synthetic */ Object f23427c;

        c(String r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23426b = r3;
            super(2, r5);
        }

        public final Object a(i<? super EventTaskResult> r3, d.c.d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            c r0 = new c(this.f23426b, r5);
            r0.f23427c = r3;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(i<? super EventTaskResult> r3, d.c.d<? super x> r4) {
            return a((i) ZeusTransformUtils.preCheckCast(r3, i.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f23425a;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            o.a(r10);
        L21:
            return x.f38692a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            i r2 = (i) ZeusTransformUtils.preCheckCast(this.f23427c, i.class, "com.obric.aiagent.plugin");
            o.a(r10);
        L15:
            EventTaskResult r11 = (EventTaskResult) ZeusTransformUtils.preCheckCast(r10, EventTaskResult.class, "com.obric.aiagent.plugin");
        L17:
            d.c.d<? super x> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23427c = null;
            this.f23425a = 2;
            if (r2.emit(r11, r4) != r0) goto L21;
            return r0;
        L10:
            o.a(r10);
            r2 = (i) ZeusTransformUtils.preCheckCast(this.f23427c, i.class, "com.obric.aiagent.plugin");
            EventTaskService r12 = (EventTaskService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(EventTaskService.class), EventTaskService.class, "com.obric.aiagent.plugin");
            if (r12 == null) goto L16;
            String[] r6 = {this.f23426b};
            d.c.d<? super EventTaskResult> r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23427c = r2;
            this.f23425a = 1;
            r10 = r12.removeEventTask(r6, r7);
            if (r10 != r0) goto L15;
            return r0;
        L16:
            r11 = null;
            goto L17
        }
    }

    /* JADX INFO: compiled from: ConditionTaskDetailRepository.kt */
    @d.c.b.a.f(b = "ConditionTaskDetailRepository.kt", c = {59}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.detail.condition.repository.ConditionTaskDetailRepository$getTask$2")
    static final class d extends l implements m<am, d.c.d<? super ConditionTask>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23428a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f23429b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f23430c;

        d(String r3, a r4, d.c.d<? super d> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23429b = r3;
            this.f23430c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super ConditionTask> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f23429b, this.f23430c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super ConditionTask> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f23428a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r7);
        L13:
            EventTask r8 = (EventTask) ZeusTransformUtils.preCheckCast(r7, EventTask.class, "com.obric.aiagent.plugin");
            if (r8 == null) goto L16;
            com.obric.autoaction.app.launcherpage.module.datasource.f r9 = com.obric.autoaction.app.launcherpage.module.datasource.g.a(r8);
        L18:
            if (ZeusTransformUtils.instanceOf(r9, com.obric.autoaction.app.launcherpage.module.datasource.f.a.class) == false) goto L21;
            return ((com.obric.autoaction.app.launcherpage.module.datasource.f.a) ZeusTransformUtils.preCheckCast(r9, com.obric.autoaction.app.launcherpage.module.datasource.f.a.class, "com.obric.aiagent.plugin")).b();
        L21:
            if (ZeusTransformUtils.instanceOf(r9, com.obric.autoaction.app.launcherpage.module.datasource.f.c.class) == true) goto L26;
            Loog.INSTANCE.e(a.TAG, "getTask, taskId: " + this.f23429b + " is not condition/timer task");
            return null;
        L26:
            return a.a(this.f23430c, (com.obric.autoaction.app.launcherpage.module.datasource.f.c) ZeusTransformUtils.preCheckCast(r9, com.obric.autoaction.app.launcherpage.module.datasource.f.c.class, "com.obric.aiagent.plugin"));
        L16:
            r9 = null;
            goto L18
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r7);
            IEventTaskApi r10 = (IEventTaskApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskApi.class), IEventTaskApi.class, "com.obric.aiagent.plugin");
            if (r10 == null) goto L16;
            String r2 = this.f23429b;
            d.c.d<? super EventTask> r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23428a = 1;
            r7 = r10.getEventTask(r2, r5);
            if (r7 != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ConditionTaskDetailRepository.kt */
    @d.c.b.a.f(b = "ConditionTaskDetailRepository.kt", c = {ApWakeEvent.OTHER_END, 144, 145}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.detail.condition.repository.ConditionTaskDetailRepository$historyCount$1")
    static final class e extends l implements m<i<? super String>, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23431a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f23432b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f23433c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private /* synthetic */ Object f23434d;

        e(String r3, a r4, d.c.d<? super e> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23432b = r3;
            this.f23433c = r4;
            super(2, r6);
        }

        public final Object a(i<? super String> r3, d.c.d<? super x> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            e r0 = new e(this.f23432b, this.f23433c, r6);
            r0.f23434d = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(i<? super String> r3, d.c.d<? super x> r4) {
            return a((i) ZeusTransformUtils.preCheckCast(r3, i.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f23431a;
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 != 3) goto L9;
            o.a(r9);
        L38:
            return x.f38692a;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            i r2 = (i) ZeusTransformUtils.preCheckCast(this.f23434d, i.class, "com.obric.aiagent.plugin");
            o.a(r9);
        L30:
            int r10 = ((List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.aiagent.plugin")).size();
            if (r10 < 1000) goto L33;
            String r11 = "999+";
        L34:
            d.c.d<? super x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23434d = null;
            this.f23431a = 3;
            if (r2.emit(r11, r3) != r0) goto L38;
            return r0;
        L33:
            r11 = String.valueOf(r10);
            goto L34
        L11:
            o.a(r9);
        L26:
            return x.f38692a;
        L12:
            o.a(r9);
            r2 = (i) ZeusTransformUtils.preCheckCast(this.f23434d, i.class, "com.obric.aiagent.plugin");
            String r12 = this.f23432b;
            if (r12 != null) goto L15;
        L20:
            r12 = null;
        L21:
            if (r12 != null) goto L27;
            d.c.d<? super x> r13 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23431a = 1;
            if (r2.emit("0", r13) != r0) goto L26;
            return r0;
        L27:
            com.obric.autoaction.app.launcherpage.module.datasource.b r5 = a.b(this.f23433c);
            d.c.d<? super List<com.obric.autoaction.app.launcherpage.module.datasource.d>> r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23434d = r2;
            this.f23431a = 2;
            r9 = r5.b(r12, r7);
            if (r9 != r0) goto L30;
            return r0;
        L15:
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L17;
            boolean r8 = true;
        L18:
            if (r8 == false) goto L20;
        L17:
            r8 = false;
            goto L18
        }
    }

    /* JADX INFO: compiled from: ConditionTaskDetailRepository.kt */
    @d.c.b.a.f(b = "ConditionTaskDetailRepository.kt", c = {122, 128}, d = "testRun", e = "com.obric.autoaction.app.launcherpage.detail.condition.repository.ConditionTaskDetailRepository")
    static final class f extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f23435a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f23436b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f23437c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f23438d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f23439e;

        f(a r3, d.c.d<? super f> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23438d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f23437c = r3;
            this.f23439e |= Integer.MIN_VALUE;
            return this.f23438d.a(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ConditionTaskDetailRepository.kt */
    @d.c.b.a.f(b = "ConditionTaskDetailRepository.kt", c = {91, 111}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.detail.condition.repository.ConditionTaskDetailRepository$update$1")
    static final class g extends l implements m<i<? super EventTaskResult>, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23440a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ConditionTaskSpec f23441b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f23442c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f23443d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f23444e;
        private /* synthetic */ Object f;

        /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.detail.condition.c.a$g$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ConditionTaskDetailRepository.kt */
        @d.c.b.a.f(b = "ConditionTaskDetailRepository.kt", c = {93, 97, 98, 100}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.detail.condition.repository.ConditionTaskDetailRepository$update$1$result$1")
        static final class C0513a extends l implements m<am, d.c.d<? super EventTaskResult>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f23445a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            int f23446b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ a f23447c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f23448d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f23449e;
            final /* synthetic */ ConditionTaskSpec f;
            final /* synthetic */ String g;
            private /* synthetic */ Object h;

            /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.detail.condition.c.a$g$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: ConditionTaskDetailRepository.kt */
            @d.c.b.a.f(b = "ConditionTaskDetailRepository.kt", c = {92}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.detail.condition.repository.ConditionTaskDetailRepository$update$1$result$1$extDeferred$1")
            static final class C0514a extends l implements m<am, d.c.d<? super Map<String, ? extends String>>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f23450a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ String f23451b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ String f23452c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                final /* synthetic */ ConditionTaskSpec f23453d;

                C0514a(String r3, String r4, ConditionTaskSpec r5, d.c.d<? super C0514a> r6) {
                    d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
                    this.f23451b = r3;
                    this.f23452c = r4;
                    this.f23453d = r5;
                    super(2, r7);
                }

                public final Object a(am r3, d.c.d<? super Map<String, String>> r4) {
                    return ((C0514a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0514a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
                }

                @Override // d.c.b.a.a
                public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
                    d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                    return (d.c.d) ZeusTransformUtils.preCheckCast(new C0514a(this.f23451b, this.f23452c, this.f23453d, r6), d.c.d.class, "com.obric.aiagent.plugin");
                }

                @Override // d.h.a.m
                public /* synthetic */ Object invoke(am r3, d.c.d<? super Map<String, ? extends String>> r4) {
                    return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
                }

                @Override // d.c.b.a.a
                public final Object invokeSuspend(Object r8) {
                    Object r0 = d.c.a.b.a();
                    int r1 = this.f23450a;
                    if (r1 == 0) goto L8;
                    if (r1 != 1) goto L7;
                    o.a(r8);
                L11:
                    return r8;
                L7:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L8:
                    o.a(r8);
                    k r9 = k.f24509a;
                    String r2 = this.f23451b;
                    String r3 = this.f23452c;
                    Map<String, String> r4 = this.f23453d.getExt();
                    d.c.d<? super Map<String, String>> r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                    this.f23450a = 1;
                    r8 = r9.a(r2, r3, r4, r5);
                    if (r8 != r0) goto L11;
                    return r0;
                }
            }

            C0513a(a r3, String r4, String r5, ConditionTaskSpec r6, String r7, d.c.d<? super C0513a> r8) {
                d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
                this.f23447c = r3;
                this.f23448d = r4;
                this.f23449e = r5;
                this.f = r6;
                this.g = r7;
                super(2, r9);
            }

            public final Object a(am r3, d.c.d<? super EventTaskResult> r4) {
                return ((C0513a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0513a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r10, d.c.d<?> r11) {
                d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
                C0513a r12 = new C0513a(this.f23447c, this.f23448d, this.f23449e, this.f, this.g, r8);
                r12.h = r10;
                return (d.c.d) ZeusTransformUtils.preCheckCast(r12, d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super EventTaskResult> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r15) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f23446b;
                if (r1 == 0) goto L14;
                if (r1 == 1) goto L13;
                if (r1 == 2) goto L12;
                if (r1 == 3) goto L11;
                if (r1 != 4) goto L10;
                o.a(r15);
            L49:
                return (EventTaskResult) ZeusTransformUtils.preCheckCast(r15, EventTaskResult.class, "com.obric.aiagent.plugin");
            L10:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L11:
                ConditionTaskSpec r2 = (ConditionTaskSpec) ZeusTransformUtils.preCheckCast(this.h, ConditionTaskSpec.class, "com.obric.aiagent.plugin");
                o.a(r15);
            L30:
                EventTask r16 = (EventTask) ZeusTransformUtils.preCheckCast(r15, EventTask.class, "com.obric.aiagent.plugin");
            L33:
                if (ZeusTransformUtils.instanceOf(r16, ConditionTask.class) == false) goto L41;
                IEventTaskApi r17 = (IEventTaskApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskApi.class), IEventTaskApi.class, "com.obric.aiagent.plugin");
                if (r17 == null) goto L48;
                String r3 = this.g;
                EventTaskSpec r4 = (EventTaskSpec) ZeusTransformUtils.preCheckCast(r2, EventTaskSpec.class, "com.obric.aiagent.plugin");
                d.c.d<? super EventTaskResult> r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.h = null;
                this.f23445a = null;
                this.f23446b = 4;
                r15 = r17.updateEventTask(r3, r4, r5);
                if (r15 != r0) goto L49;
                return r0;
            L48:
                return null;
            L41:
                if (ZeusTransformUtils.instanceOf(r16, TimerTaskV2.class) == true) goto L43;
            L45:
                Loog.INSTANCE.e(a.TAG, "taskId: " + this.g + ", this task is not condition task");
                EventTaskResult r14 = new EventTaskResult(-1, "task type error", p.b(), null, 8, null);
            L47:
                return r14;
            L43:
                if (((TimerTaskV2) ZeusTransformUtils.preCheckCast(r16, TimerTaskV2.class, "com.obric.aiagent.plugin")).getId() == null) goto L45;
                Loog.INSTANCE.e(a.TAG, "taskId: " + this.g + ", unexpected timer task reached condition update flow");
                r14 = new EventTaskResult(-1, "task type error", p.b(), null, 8, null);
                goto L47
            L12:
                ConditionTaskSpec r6 = (ConditionTaskSpec) ZeusTransformUtils.preCheckCast(this.f23445a, ConditionTaskSpec.class, "com.obric.aiagent.plugin");
                a r7 = (a) ZeusTransformUtils.preCheckCast(this.h, a.class, "com.obric.aiagent.plugin");
                o.a(r15);
            L25:
                r2 = a.a(r7, r6, (Map) ZeusTransformUtils.preCheckCast(r15, Map.class, "com.obric.aiagent.plugin"));
                IEventTaskApi r18 = (IEventTaskApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskApi.class), IEventTaskApi.class, "com.obric.aiagent.plugin");
                if (r18 == null) goto L31;
                String r8 = this.g;
                d.c.d<? super EventTask> r9 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.h = r2;
                this.f23445a = null;
                this.f23446b = 3;
                r15 = r18.getEventTask(r8, r9);
                if (r15 != r0) goto L30;
                return r0;
            L31:
                r16 = null;
                goto L33
            L13:
                au r10 = (au) ZeusTransformUtils.preCheckCast(this.h, au.class, "com.obric.aiagent.plugin");
                o.a(r15);
            L17:
                EventTaskResult r19 = com.obric.autoaction.app.launcherpage.detail.condition.c.b.a((com.obric.autoaction.app.launcherpage.detail.base.a.d) ZeusTransformUtils.preCheckCast(r15, com.obric.autoaction.app.launcherpage.detail.base.a.d.class, "com.obric.aiagent.plugin"));
                if (r19 == null) goto L21;
                ca.a.a((ca) ZeusTransformUtils.preCheckCast(r10, ca.class, "com.obric.aiagent.plugin"), null, 1, null);
                return r19;
            L21:
                a r110 = this.f23447c;
                ConditionTaskSpec r11 = this.f;
                d.c.d r12 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.h = r110;
                this.f23445a = r11;
                this.f23446b = 2;
                Object r13 = r10.a(r12);
                if (r13 != r0) goto L24;
                return r0;
            L24:
                r7 = r110;
                r15 = r13;
                r6 = r11;
                goto L25
            L14:
                o.a(r15);
                r10 = kotlinx.coroutines.i.b((am) ZeusTransformUtils.preCheckCast(this.h, am.class, "com.obric.aiagent.plugin"), null, null, (m) ZeusTransformUtils.preCheckCast(new C0514a(this.f23448d, this.f23449e, this.f, null), m.class, "com.obric.aiagent.plugin"), 3, null);
                com.obric.autoaction.app.launcherpage.detail.base.a.c r111 = a.a(this.f23447c);
                String r20 = this.f23448d;
                String r21 = this.f23449e;
                d.c.d<? super com.obric.autoaction.app.launcherpage.detail.base.a.d> r112 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.h = r10;
                this.f23446b = 1;
                r15 = r111.a(r20, r21, "condition", r112);
                if (r15 != r0) goto L17;
                return r0;
            }
        }

        g(ConditionTaskSpec r3, a r4, String r5, String r6, d.c.d<? super g> r7) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23441b = r3;
            this.f23442c = r4;
            this.f23443d = r5;
            this.f23444e = r6;
            super(2, r8);
        }

        public final Object a(i<? super EventTaskResult> r3, d.c.d<? super x> r4) {
            return ((g) ZeusTransformUtils.preCheckCast(create((i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), g.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r9, d.c.d<?> r10) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            g r11 = new g(this.f23441b, this.f23442c, this.f23443d, this.f23444e, r7);
            r11.f = r9;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r11, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(i<? super EventTaskResult> r3, d.c.d<? super x> r4) {
            return a((i) ZeusTransformUtils.preCheckCast(r3, i.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r13) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f23440a;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            o.a(r13);
        L17:
            return x.f38692a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            i r2 = (i) ZeusTransformUtils.preCheckCast(this.f, i.class, "com.obric.aiagent.plugin");
            o.a(r13);
        L13:
            EventTaskResult r14 = (EventTaskResult) ZeusTransformUtils.preCheckCast(r13, EventTaskResult.class, "com.obric.aiagent.plugin");
            d.c.d<? super x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = null;
            this.f23440a = 2;
            if (r2.emit(r14, r3) != r0) goto L17;
            return r0;
        L10:
            o.a(r13);
            r2 = (i) ZeusTransformUtils.preCheckCast(this.f, i.class, "com.obric.aiagent.plugin");
            String r8 = com.obric.autoaction.app.launcherpage.detail.condition.a.a.a(this.f23441b);
            m r15 = (m) ZeusTransformUtils.preCheckCast(new C0513a(this.f23442c, this.f23443d, r8, this.f23441b, this.f23444e, null), m.class, "com.obric.aiagent.plugin");
            d.c.d r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r2;
            this.f23440a = 1;
            r13 = an.a(r15, r5);
            if (r13 != r0) goto L13;
            return r0;
        }
    }

    static {
        f23408a = new C0510a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public a(com.obric.autoaction.app.launcherpage.detail.base.a.c r3, com.obric.autoaction.app.launcherpage.module.datasource.b r4) {
        com.obric.autoaction.app.launcherpage.module.datasource.b r5 = (com.obric.autoaction.app.launcherpage.module.datasource.b) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.autoaction.app.launcherpage.module.datasource.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "validator");
        d.h.b.o.e(r5, "timerTaskRepo");
        this.f23409b = r3;
        this.f23410c = r5;
    }

    public static final /* synthetic */ com.obric.autoaction.app.launcherpage.detail.base.a.c a(a r0) {
        return r0.f23409b;
    }

    public static final /* synthetic */ ConditionTask a(a r0, com.obric.autoaction.app.launcherpage.module.datasource.f.c r1) {
        return r0.a(r1);
    }

    public static final /* synthetic */ ConditionTaskSpec a(a r2, ConditionTaskSpec r3, Map r4) {
        return r2.a(r3, (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ com.obric.autoaction.app.launcherpage.module.datasource.b b(a r0) {
        return r0.f23410c;
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.a.b
    public /* synthetic */ Object a(String r3, EventTask r4, d.c.d r5) {
        d.c.d<? super x> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return a(r3, (ConditionTask) ZeusTransformUtils.preCheckCast(r4, ConditionTask.class, "com.obric.aiagent.plugin"), r6);
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.a.b
    public /* synthetic */ kotlinx.coroutines.b.h a(EventTaskSpec r3, String r4, String r5) {
        return a((ConditionTaskSpec) ZeusTransformUtils.preCheckCast(r3, ConditionTaskSpec.class, "com.obric.aiagent.plugin"), r4, r5);
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.a.b
    public /* synthetic */ kotlinx.coroutines.b.h update(String r3, EventTaskSpec r4, String r5, boolean r6) {
        return update(r3, (ConditionTaskSpec) ZeusTransformUtils.preCheckCast(r4, ConditionTaskSpec.class, "com.obric.aiagent.plugin"), r5, r6);
    }

    public /* synthetic */ a(com.obric.autoaction.app.launcherpage.detail.base.a.c r2, com.obric.autoaction.app.launcherpage.module.datasource.b r3, int r4, h r5) {
        com.obric.autoaction.app.launcherpage.module.datasource.b r6 = (com.obric.autoaction.app.launcherpage.module.datasource.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autoaction.app.launcherpage.module.datasource.b.class, "com.obric.aiagent.plugin");
        if ((r4 & 1) == 0) goto L6;
        r2 = new com.obric.autoaction.app.launcherpage.detail.base.a.c();
    L6:
        if ((r4 & 2) == 0) goto L8;
        r6 = (com.obric.autoaction.app.launcherpage.module.datasource.b) ZeusTransformUtils.preCheckCast(new com.obric.autoaction.app.launcherpage.module.datasource.i(), com.obric.autoaction.app.launcherpage.module.datasource.b.class, "com.obric.aiagent.plugin");
    L8:
        this(r2, r6);
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.a.b
    public Object a(String r5, d.c.d<? super ConditionTask> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (m) ZeusTransformUtils.preCheckCast(new d(r5, this, null), m.class, "com.obric.aiagent.plugin"), r7);
    }

    public kotlinx.coroutines.b.h<EventTaskResult> a(ConditionTaskSpec r2, String r3, String r4) {
        d.h.b.o.e(r2, "spec");
        d.h.b.o.e(r3, "oldQuery");
        return j.a(j.a((m) ZeusTransformUtils.preCheckCast(new b(r2, this, r3, null), m.class, "com.obric.aiagent.plugin")), (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"));
    }

    public kotlinx.coroutines.b.h<EventTaskResult> update(String r7, ConditionTaskSpec r8, String r9, boolean r10) {
        d.h.b.o.e(r7, DBDefinition.TASK_ID);
        d.h.b.o.e(r8, "spec");
        d.h.b.o.e(r9, "oldQuery");
        return j.a(j.a((m) ZeusTransformUtils.preCheckCast(new g(r8, this, r9, r7, null), m.class, "com.obric.aiagent.plugin")), (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.a.b
    public kotlinx.coroutines.b.h<EventTaskResult> delete(String r3) {
        d.h.b.o.e(r3, DBDefinition.TASK_ID);
        return j.a(j.a((m) ZeusTransformUtils.preCheckCast(new c(r3, null), m.class, "com.obric.aiagent.plugin")), (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"));
    }

    public Object a(String r10, ConditionTask r11, d.c.d<? super x> r12) {
        d.c.d r13 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r13, f.class) == false) goto L7;
        f r0 = (f) ZeusTransformUtils.preCheckCast(r13, f.class, "com.obric.aiagent.plugin");
        if ((r0.f23439e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f23439e -= Integer.MIN_VALUE;
    L8:
        f r8 = r0;
        Object r9 = r8.f23437c;
        Object r14 = d.c.a.b.a();
        int r1 = r8.f23439e;
        if (r1 == 0) goto L16;
        if (r1 == 1) goto L15;
        if (r1 != 2) goto L14;
        o.a(r9);
    L48:
        return x.f38692a;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r11 = (ConditionTask) ZeusTransformUtils.preCheckCast(r8.f23436b, ConditionTask.class, "com.obric.aiagent.plugin");
        r10 = (String) ZeusTransformUtils.preCheckCast(r8.f23435a, String.class, "com.obric.aiagent.plugin");
        o.a(r9);
    L25:
        EventTask r15 = (EventTask) ZeusTransformUtils.preCheckCast(r9, EventTask.class, "com.obric.aiagent.plugin");
    L28:
        if (ZeusTransformUtils.instanceOf(r15, TimerTaskV2.class) == false) goto L32;
        String r16 = com.obric.autoaction.app.launcherpage.detail.condition.a.a.a(r11, null, 1, null);
        IAutoActionPresentationApi r17 = (IAutoActionPresentationApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionPresentationApi.class), IAutoActionPresentationApi.class, "com.obric.aiagent.plugin");
        if (r17 == null) goto L50;
        r17.postTestRunTaskWithQuery(r16);
    L50:
        return x.f38692a;
    L32:
        ConditionTaskSpec r18 = com.obric.autoaction.app.launcherpage.detail.condition.a.a.a(r11, null, null, 2, null);
        IEventTaskExecutionApi r2 = (IEventTaskExecutionApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskExecutionApi.class), IEventTaskExecutionApi.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L50;
        List<ConditionTaskAction> r3 = r18.getActions();
        if (r3 != null) goto L37;
        r3 = p.b();
    L37:
        if (r15 == null) goto L39;
        TaskKnowledge r5 = r15.getTaskKnowledge();
    L40:
        Integer r19 = r18.getTaskMode();
        if (r19 == null) goto L43;
        int r20 = r19.intValue();
    L44:
        r8.f23435a = null;
        r8.f23436b = null;
        r8.f23439e = 2;
        if (r2.tryScheduleConditionTask(r10, r3, r5, r20, "auto_detail_test_run", r8) != r14) goto L48;
        return r14;
    L43:
        r20 = 0;
        goto L44
    L39:
        r5 = null;
        goto L40
    L16:
        o.a(r9);
        if (r10 == null) goto L19;
        IEventTaskApi r21 = (IEventTaskApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskApi.class), IEventTaskApi.class, "com.obric.aiagent.plugin");
        if (r21 == null) goto L26;
        r8.f23435a = r10;
        r8.f23436b = r11;
        r8.f23439e = 1;
        r9 = r21.getEventTask(r10, r8);
        if (r9 != r14) goto L25;
        return r14;
    L26:
        r15 = null;
        goto L28
    L19:
        return x.f38692a;
    L7:
        r0 = new f(this, r13);
        goto L8
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.a.b
    public kotlinx.coroutines.b.h<String> a(String r3) {
        return j.a(j.a((m) ZeusTransformUtils.preCheckCast(new e(r3, this, null), m.class, "com.obric.aiagent.plugin")), (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"));
    }

    private final ConditionTaskSpec a(ConditionTaskSpec r14, Map<String, String> r15) {
        Map r13 = (Map) ZeusTransformUtils.wrapperContextForParams(r15, Map.class, "com.obric.aiagent.plugin");
        if (r13 != null) goto L5;
    L8:
        boolean r16 = true;
    L9:
        if (r16 == false) goto L12;
        Map<String, String> r17 = r14.getExt();
    L11:
        Map<String, String> r8 = r17;
        String r1 = r14.getName();
        Integer r2 = r14.getTaskMode();
        TaskKnowledge r3 = r14.getTaskKnowledge();
        String r4 = r14.getTemplateId();
        Integer r6 = r14.getTaskStatus();
        Integer r7 = r14.getEnableStatus();
        List<ConditionTaskAction> r9 = r14.getActions();
        ConditionGroup r10 = r14.getConditions();
        PeriodicPolicy r11 = r14.getPeriodicPolicy();
        return new ConditionTaskSpec(r1, r2, r3, r4, r14.getOmniModel(), r6, r7, r8, r9, r10, r11, r14.getTriggerControlPolicy());
    L12:
        Map<String, String> r5 = r14.getExt();
        if (r5 != null) goto L15;
        r5 = ao.b();
    L15:
        LinkedHashMap r18 = new LinkedHashMap(r5);
        r18.putAll(r13);
        r17 = (Map) ZeusTransformUtils.preCheckCast(r18, Map.class, "com.obric.aiagent.plugin");
        goto L11
    L5:
        if (r13.isEmpty() == true) goto L8;
        r16 = false;
        goto L9
    }

    private final ConditionTask a(com.obric.autoaction.app.launcherpage.module.datasource.f.c r28) {
        com.obric.autoaction.app.launcherpage.condition.a.g.a r0 = com.obric.autoaction.app.launcherpage.condition.a.g.f22923a.a(r28.b().getCronExpr());
        if (r0 == null) goto L9;
        DayTimeCondition r4 = r0.b();
        if (r4 == null) goto L9;
        String r6 = r4.getDayTime();
        if (r6 == null) goto L9;
        ConditionGroup r5 = new ConditionGroup("or", p.d(new Condition[]{new TimeCondition(r6, null, 0, 6, null)}));
    L10:
        String r7 = r28.b().getId();
        if (r5 != null) goto L13;
        r5 = new ConditionGroup("or", new ArrayList());
    L13:
        ConditionGroup r14 = r5;
        Integer r9 = r28.b().getTaskStatus();
        Integer r10 = r28.b().getEnableStatus();
        List r13 = p.a(new ConditionTaskAction("System_AutoAction", (IntentParams) ZeusTransformUtils.preCheckCast(new SystemAutoActionParams(com.obric.autoaction.app.launcherpage.module.datasource.g.a((com.obric.autoaction.app.launcherpage.module.datasource.f) ZeusTransformUtils.preCheckCast(r28, com.obric.autoaction.app.launcherpage.module.datasource.f.class, "com.obric.aiagent.plugin")), null, null, null, null, null, null, null, 254, null), IntentParams.class, "com.obric.aiagent.plugin")));
        if (r0 == null) goto L19;
        PeriodicPolicy r1 = r0.a();
        if (r1 == null) goto L19;
        PeriodicPolicy r15 = r1;
    L21:
        return new ConditionTask(r7, null, r9, r10, r28.b().getCreateTime(), r28.b().getExt(), r13, r14, r15, new TriggerControlPolicy(false, null, 2, null), 0, 1024, null);
    L19:
        r15 = new PeriodicPolicy(false, null, 0, null, false, false, null, true, null, 383, null);
    L9:
        r5 = null;
        goto L10
    }
}
