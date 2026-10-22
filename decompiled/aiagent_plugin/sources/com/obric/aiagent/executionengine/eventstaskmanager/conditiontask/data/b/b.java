package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.b;

import com.obric.aiagent.executionengine.eventstaskmanager.common.data.TaskDatabase;
import com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.bean.ConditionTaskBean;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.eventkit.task.model.ConditionGroup;
import com.obric.eventkit.task.model.ConditionTask;
import com.obric.eventkit.task.model.ConditionTaskAction;
import com.obric.eventkit.task.model.PeriodicPolicy;
import com.obric.eventkit.task.model.TaskKnowledge;
import com.obric.eventkit.task.model.TimeCondition;
import com.obric.eventkit.task.model.TriggerControlPolicy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.aa;
import d.h.b.z;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.au;

/* JADX INFO: compiled from: ConditionTaskRepo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private static final String TAG = "ConditionTaskRepo";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f16949a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final am f16950b;

    /* JADX INFO: compiled from: ConditionTaskRepo.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: renamed from: com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.b.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ConditionTaskRepo.kt */
    @d.c.b.a.f(b = "ConditionTaskRepo.kt", c = {71}, d = "addConditionTask", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.repo.ConditionTaskRepo")
    static final class C0346b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f16951a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f16952b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f16953c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f16954d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f16955e;

        C0346b(b r3, d.c.d<? super C0346b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16954d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r15) {
            this.f16953c = r15;
            this.f16955e |= Integer.MIN_VALUE;
            return this.f16954d.a(null, null, null, null, null, null, null, 0, null, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ConditionTaskRepo.kt */
    @d.c.b.a.f(b = "ConditionTaskRepo.kt", c = {71}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.repo.ConditionTaskRepo$addConditionTask$2")
    static final class c extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16956a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f16957b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ConditionTaskBean f16958c;

        c(b r3, ConditionTaskBean r4, d.c.d<? super c> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16957b = r3;
            this.f16958c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f16957b, this.f16958c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f16956a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L11:
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a r6 = (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L14;
            r6.insert(this.f16958c);
            return x.f38692a;
        L14:
            return null;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            b r7 = this.f16957b;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16956a = 1;
            r5 = b.a(r7, r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ConditionTaskRepo.kt */
    @d.c.b.a.f(b = "ConditionTaskRepo.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.repo.ConditionTaskRepo$getAllEnabledTasks$4")
    static final class d extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super List<? extends ConditionTask>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16959a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f16960b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f16961c;

        d(b r3, String r4, d.c.d<? super d> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16960b = r3;
            this.f16961c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super List<ConditionTask>> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f16960b, this.f16961c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super List<? extends ConditionTask>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            d.c.a.b.a();
            if (this.f16959a != 0) goto L16;
            d.o.a(r5);
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a r6 = b.a(this.f16960b, this.f16961c);
            if (r6 == null) goto L13;
            List<ConditionTaskBean> r7 = r6.a();
            if (r7 == null) goto L13;
            Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin");
            b r4 = this.f16960b;
            Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r8, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r9 = r8.iterator();
        L10:
            if (r9.hasNext() == false) goto L18;
            r0.add(b.a(r4, (ConditionTaskBean) ZeusTransformUtils.preCheckCast(r9.next(), ConditionTaskBean.class, "com.obric.aiagent.plugin")));
            goto L10
        L18:
            return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin");
        L13:
            return null;
        L16:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: ConditionTaskRepo.kt */
    @d.c.b.a.f(b = "ConditionTaskRepo.kt", c = {104}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.repo.ConditionTaskRepo$getKnowledgeSessionIdNotNullTasks$2")
    static final class e extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super List<? extends ConditionTask>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16962a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f16963b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f16964c;

        e(b r3, String r4, d.c.d<? super e> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16963b = r3;
            this.f16964c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super List<ConditionTask>> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f16963b, this.f16964c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super List<? extends ConditionTask>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f16962a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L11:
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a r6 = (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L20;
            List<ConditionTaskBean> r7 = r6.c(this.f16964c);
            if (r7 == null) goto L20;
            Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin");
            b r4 = this.f16963b;
            Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r8, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r9 = r8.iterator();
        L17:
            if (r9.hasNext() == false) goto L23;
            r2.add(b.a(r4, (ConditionTaskBean) ZeusTransformUtils.preCheckCast(r9.next(), ConditionTaskBean.class, "com.obric.aiagent.plugin")));
            goto L17
        L23:
            return (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin");
        L20:
            return null;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            b r10 = this.f16963b;
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16962a = 1;
            r5 = b.a(r10, r3);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ConditionTaskRepo.kt */
    @d.c.b.a.f(b = "ConditionTaskRepo.kt", c = {76}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.repo.ConditionTaskRepo$getTaskById$2$1")
    static final class f extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super ConditionTask>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16965a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f16966b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f16967c;

        f(b r3, String r4, d.c.d<? super f> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16966b = r3;
            this.f16967c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super ConditionTask> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new f(this.f16966b, this.f16967c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super ConditionTask> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f16965a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L11:
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a r6 = (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L16;
            ConditionTaskBean r7 = r6.a(this.f16967c);
            if (r7 == null) goto L16;
            return b.a(this.f16966b, r7);
        L16:
            return null;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            b r8 = this.f16966b;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16965a = 1;
            r5 = b.a(r8, r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ConditionTaskRepo.kt */
    @d.c.b.a.f(b = "ConditionTaskRepo.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.repo.ConditionTaskRepo$getTaskById$4$1")
    static final class g extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super ConditionTask>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16968a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f16969b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f16970c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f16971d;

        g(b r3, String r4, String r5, d.c.d<? super g> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16969b = r3;
            this.f16970c = r4;
            this.f16971d = r5;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super ConditionTask> r4) {
            return ((g) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), g.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new g(this.f16969b, this.f16970c, this.f16971d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super ConditionTask> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f16968a != 0) goto L12;
            d.o.a(r2);
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a r3 = b.a(this.f16969b, this.f16970c);
            if (r3 == null) goto L9;
            ConditionTaskBean r4 = r3.a(this.f16971d);
            if (r4 == null) goto L9;
            return b.a(this.f16969b, r4);
        L9:
            return null;
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: ConditionTaskRepo.kt */
    @d.c.b.a.f(b = "ConditionTaskRepo.kt", c = {92}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.repo.ConditionTaskRepo$getTaskSourceFrom$2$1")
    static final class h extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super String>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16972a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f16973b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f16974c;

        h(b r3, String r4, d.c.d<? super h> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16973b = r3;
            this.f16974c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super String> r4) {
            return ((h) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new h(this.f16973b, this.f16974c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super String> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f16972a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L11:
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a r6 = (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L16;
            ConditionTaskBean r4 = r6.a(this.f16974c);
            if (r4 == null) goto L16;
            return r4.getSourceFrom();
        L16:
            return null;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            b r7 = this.f16973b;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16972a = 1;
            r5 = b.a(r7, r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ConditionTaskRepo.kt */
    @d.c.b.a.f(b = "ConditionTaskRepo.kt", c = {96}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.repo.ConditionTaskRepo$getTasksByPackageName$2")
    static final class i extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super List<? extends ConditionTask>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16975a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f16976b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f16977c;

        i(b r3, String r4, d.c.d<? super i> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16976b = r3;
            this.f16977c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super List<ConditionTask>> r4) {
            return ((i) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), i.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new i(this.f16976b, this.f16977c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super List<? extends ConditionTask>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f16975a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L11:
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a r6 = (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L20;
            List<ConditionTaskBean> r7 = r6.b(this.f16977c);
            if (r7 == null) goto L20;
            Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin");
            b r4 = this.f16976b;
            Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r8, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r9 = r8.iterator();
        L17:
            if (r9.hasNext() == false) goto L23;
            r2.add(b.a(r4, (ConditionTaskBean) ZeusTransformUtils.preCheckCast(r9.next(), ConditionTaskBean.class, "com.obric.aiagent.plugin")));
            goto L17
        L23:
            return (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin");
        L20:
            return null;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            b r10 = this.f16976b;
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16975a = 1;
            r5 = b.a(r10, r3);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ConditionTaskRepo.kt */
    @d.c.b.a.f(b = "ConditionTaskRepo.kt", c = {100}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.repo.ConditionTaskRepo$getTasksByPackageNamePaged$2")
    static final class j extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super List<? extends ConditionTask>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16978a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f16979b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f16980c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f16981d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f16982e;

        j(b r3, String r4, int r5, int r6, d.c.d<? super j> r7) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16979b = r3;
            this.f16980c = r4;
            this.f16981d = r5;
            this.f16982e = r6;
            super(2, r8);
        }

        public final Object a(am r3, d.c.d<? super List<ConditionTask>> r4) {
            return ((j) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), j.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r8, d.c.d<?> r9) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new j(this.f16979b, this.f16980c, this.f16981d, this.f16982e, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super List<? extends ConditionTask>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f16978a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L11:
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a r6 = (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L20;
            List<ConditionTaskBean> r7 = r6.a(this.f16980c, this.f16981d, this.f16982e);
            if (r7 == null) goto L20;
            Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin");
            b r4 = this.f16979b;
            Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r8, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r9 = r8.iterator();
        L17:
            if (r9.hasNext() == false) goto L23;
            r2.add(b.a(r4, (ConditionTaskBean) ZeusTransformUtils.preCheckCast(r9.next(), ConditionTaskBean.class, "com.obric.aiagent.plugin")));
            goto L17
        L23:
            return (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin");
        L20:
            return null;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            b r10 = this.f16979b;
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16978a = 1;
            r5 = b.a(r10, r3);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ConditionTaskRepo.kt */
    @d.c.b.a.f(b = "ConditionTaskRepo.kt", c = {108}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.repo.ConditionTaskRepo$getTemplateIdNotNullTasks$2")
    static final class k extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super List<? extends ConditionTask>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16983a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f16984b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f16985c;

        k(b r3, String r4, d.c.d<? super k> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16984b = r3;
            this.f16985c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super List<ConditionTask>> r4) {
            return ((k) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), k.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new k(this.f16984b, this.f16985c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super List<? extends ConditionTask>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f16983a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L11:
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a r6 = (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L20;
            List<ConditionTaskBean> r7 = r6.d(this.f16985c);
            if (r7 == null) goto L20;
            Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin");
            b r4 = this.f16984b;
            Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r8, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r9 = r8.iterator();
        L17:
            if (r9.hasNext() == false) goto L23;
            r2.add(b.a(r4, (ConditionTaskBean) ZeusTransformUtils.preCheckCast(r9.next(), ConditionTaskBean.class, "com.obric.aiagent.plugin")));
            goto L17
        L23:
            return (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin");
        L20:
            return null;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            b r10 = this.f16984b;
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16983a = 1;
            r5 = b.a(r10, r3);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ConditionTaskRepo.kt */
    @d.c.b.a.f(b = "ConditionTaskRepo.kt", c = {EntityType.SIM_CARD, 209}, d = "removeTasks", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.repo.ConditionTaskRepo")
    static final class l extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f16986a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f16987b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f16988c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f16989d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f16990e;
        int f;
        int g;
        /* synthetic */ Object h;
        final /* synthetic */ b i;
        int j;

        l(b r3, d.c.d<? super l> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.i = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.h = r3;
            this.j |= Integer.MIN_VALUE;
            return this.i.a(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ConditionTaskRepo.kt */
    @d.c.b.a.f(b = "ConditionTaskRepo.kt", c = {EntityType.SIM_CARD}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.repo.ConditionTaskRepo$removeTasks$2$bean$1")
    static final class m extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super ConditionTaskBean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16991a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f16992b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f16993c;

        m(b r3, String r4, d.c.d<? super m> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16992b = r3;
            this.f16993c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super ConditionTaskBean> r4) {
            return ((m) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), m.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new m(this.f16992b, this.f16993c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super ConditionTaskBean> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f16991a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L11:
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a r6 = (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a.class, "com.obric.aiagent.plugin");
            if (r6 != null) goto L16;
            return null;
        L16:
            return r6.a(this.f16993c);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            b r7 = this.f16992b;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16991a = 1;
            r5 = b.a(r7, r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ConditionTaskRepo.kt */
    @d.c.b.a.f(b = "ConditionTaskRepo.kt", c = {209}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.repo.ConditionTaskRepo$removeTasks$2$result$1")
    static final class n extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super Integer>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16994a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f16995b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ConditionTaskBean f16996c;

        n(b r3, ConditionTaskBean r4, d.c.d<? super n> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16995b = r3;
            this.f16996c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super Integer> r4) {
            return ((n) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), n.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new n(this.f16995b, this.f16996c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Integer> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f16994a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L11:
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a r6 = (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L14;
            int r4 = r6.delete(this.f16996c);
        L16:
            return d.c.b.a.b.a(r4);
        L14:
            r4 = 0;
            goto L16
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            b r7 = this.f16995b;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16994a = 1;
            r5 = b.a(r7, r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ConditionTaskRepo.kt */
    @d.c.b.a.f(b = "ConditionTaskRepo.kt", c = {113}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.repo.ConditionTaskRepo$updateDisplayOrders$2")
    static final class o extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super Integer>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16997a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ List<String> f16998b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f16999c;

        o(List<String> r3, String r4, d.c.d<? super o> r5) {
            List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16998b = r6;
            this.f16999c = r4;
            super(2, r7);
        }

        /* JADX INFO: renamed from: lambda$eJThP9Hyio_-u41JPjTNd4Vnqm4, reason: not valid java name */
        public static /* synthetic */ void m166lambda$eJThP9Hyio_u41JPjTNd4Vnqm4(com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a r0, String r1, List r2, z.d r3) {
            a(r0, r1, r2, r3);
        }

        public final Object a(am r3, d.c.d<? super Integer> r4) {
            return ((o) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), o.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new o(this.f16998b, this.f16999c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Integer> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f16997a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L11:
            TaskDatabase r7 = (TaskDatabase) ZeusTransformUtils.preCheckCast(r6, TaskDatabase.class, "com.obric.aiagent.plugin");
            if (r7 == null) goto L14;
            final com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a r2 = r7.o();
            final List r3 = d.a.p.s((Iterable) ZeusTransformUtils.preCheckCast(this.f16998b, Iterable.class, "com.obric.aiagent.plugin"));
            final z.d r4 = new z.d();
            final String r5 = this.f16999c;
            r7.a(new $$Lambda$b$o$eJThP9Hyio_u41JPjTNd4Vnqm4(r2, r5, r3, r4));
            ILogDepend.Companion.i(b.TAG, "updateDisplayOrders result package=" + this.f16999c + ", request=" + r3.size() + ", updated=" + r4.f38502a);
            return d.c.b.a.b.a(r4.f38502a);
        L14:
            return d.c.b.a.b.a(0);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            com.obric.aiagent.executionengine.eventstaskmanager.common.data.e r8 = com.obric.aiagent.executionengine.eventstaskmanager.common.data.e.f16691a;
            d.c.d<? super TaskDatabase> r9 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16997a = 1;
            r6 = r8.a(r9);
            if (r6 != r0) goto L11;
            return r0;
        }

        private static final void a(com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a r5, String r6, List r7, z.d r8) {
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a r9 = (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a.class, "com.obric.aiagent.plugin");
            List<String> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
            List<Long> r0 = r9.a(r6, r10);
            ILogDepend.Companion.i(b.TAG, "updateDisplayOrders package=" + r6 + ", request=" + r10 + ", slots=" + r0);
            Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(d.a.p.c((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            d.m r1 = (d.m) ZeusTransformUtils.preCheckCast(r11.next(), d.m.class, "com.obric.aiagent.plugin");
            r8.f38502a += r9.a(r6, (String) ZeusTransformUtils.preCheckCast(r1.c(), String.class, "com.obric.aiagent.plugin"), ((Number) ZeusTransformUtils.preCheckCast(r1.d(), Number.class, "com.obric.aiagent.plugin")).longValue());
            goto L4
        }
    }

    /* JADX INFO: compiled from: ConditionTaskRepo.kt */
    @d.c.b.a.f(b = "ConditionTaskRepo.kt", c = {137}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.repo.ConditionTaskRepo$updateExt$2")
    static final class p extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17000a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f17001b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f17002c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Map<String, String> f17003d;

        p(b r3, String r4, Map<String, String> r5, d.c.d<? super p> r6) {
            Map<String, String> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17001b = r3;
            this.f17002c = r4;
            this.f17003d = r7;
            super(2, r8);
        }

        public final Object a(am r3, d.c.d<? super Boolean> r4) {
            return ((p) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), p.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new p(this.f17001b, this.f17002c, this.f17003d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Boolean> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17000a;
            boolean r3 = true;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L11:
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a r6 = (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L14;
            ConditionTaskBean r2 = r6.a(this.f17002c);
            if (r2 == null) goto L18;
            r2.setExt(this.f17003d);
            if (r6.update(r2) > 0) goto L24;
            r3 = false;
        L24:
            return d.c.b.a.b.a(r3);
        L18:
            return d.c.b.a.b.a(false);
        L14:
            return d.c.b.a.b.a(false);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            b r7 = this.f17001b;
            d.c.d r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17000a = 1;
            r5 = b.a(r7, r4);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ConditionTaskRepo.kt */
    @d.c.b.a.f(b = "ConditionTaskRepo.kt", c = {158, 195}, d = "updateTask", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.repo.ConditionTaskRepo")
    static final class q extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f17004a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f17005b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f17006c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f17007d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f17008e;
        Object f;
        Object g;
        Object h;
        Object i;
        Object j;
        int k;
        int l;
        /* synthetic */ Object m;
        final /* synthetic */ b n;
        int o;

        q(b r3, d.c.d<? super q> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.n = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r15) {
            this.m = r15;
            this.o |= Integer.MIN_VALUE;
            return this.n.a(null, null, null, null, null, null, 0, null, 0, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ConditionTaskRepo.kt */
    @d.c.b.a.f(b = "ConditionTaskRepo.kt", c = {195}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.repo.ConditionTaskRepo$updateTask$2")
    static final class r extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super Integer>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17009a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f17010b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ConditionTaskBean f17011c;

        r(b r3, ConditionTaskBean r4, d.c.d<? super r> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17010b = r3;
            this.f17011c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super Integer> r4) {
            return ((r) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), r.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new r(this.f17010b, this.f17011c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Integer> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17009a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L11:
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a r6 = (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L14;
            int r4 = r6.update(this.f17011c);
        L16:
            return d.c.b.a.b.a(r4);
        L14:
            r4 = 0;
            goto L16
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            b r7 = this.f17010b;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17009a = 1;
            r5 = b.a(r7, r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ConditionTaskRepo.kt */
    @d.c.b.a.f(b = "ConditionTaskRepo.kt", c = {158}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.repo.ConditionTaskRepo$updateTask$bean$1$1")
    static final class s extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super ConditionTaskBean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17012a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f17013b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f17014c;

        s(b r3, String r4, d.c.d<? super s> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17013b = r3;
            this.f17014c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super ConditionTaskBean> r4) {
            return ((s) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), s.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new s(this.f17013b, this.f17014c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super ConditionTaskBean> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17012a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L11:
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a r6 = (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a.class, "com.obric.aiagent.plugin");
            if (r6 != null) goto L16;
            return null;
        L16:
            return r6.a(this.f17014c);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            b r7 = this.f17013b;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17012a = 1;
            r5 = b.a(r7, r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    static {
        f16949a = new a(null);
    }

    public b() {
        this.f16950b = an.a((d.c.g) ZeusTransformUtils.preCheckCast(com.obric.aiagent.executionengine.eventstaskmanager.common.a.f16677a.a(), d.c.g.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a a(b r0, String r1) {
        return r0.a(r1);
    }

    public static final /* synthetic */ ConditionTask a(b r0, ConditionTaskBean r1) {
        return r0.a(r1);
    }

    public static final /* synthetic */ Object a(b r2, d.c.d r3) {
        return r2.a((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    private final Object a(d.c.d<? super com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a> r2) {
        d.c.d<? super com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a> r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.executionengine.eventstaskmanager.common.data.e.f16691a.c(r1);
    }

    private final com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a a(String r1) {
        return com.obric.aiagent.executionengine.eventstaskmanager.common.data.e.f16691a.a(r1);
    }

    public final Object a(String r25, List<ConditionTaskAction> r26, String r27, ConditionGroup r28, PeriodicPolicy r29, TriggerControlPolicy r30, Map<String, String> r31, int r32, Integer r33, TaskKnowledge r34, String r35, String r36, d.c.d<? super ConditionTask> r37) {
        b r0 = this;
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r26, List.class, "com.obric.aiagent.plugin");
        Map r17 = (Map) ZeusTransformUtils.wrapperContextForParams(r31, Map.class, "com.obric.aiagent.plugin");
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r37, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, C0346b.class) == false) goto L7;
        C0346b r3 = (C0346b) ZeusTransformUtils.preCheckCast(r1, C0346b.class, "com.obric.aiagent.plugin");
        if ((r3.f16955e & Integer.MIN_VALUE) == 0) goto L7;
        r3.f16955e -= Integer.MIN_VALUE;
    L8:
        C0346b r2 = r3;
        Object r4 = r2.f16953c;
        Object r12 = d.c.a.b.a();
        int r6 = r2.f16955e;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        ConditionTaskBean r7 = (ConditionTaskBean) ZeusTransformUtils.preCheckCast(r2.f16952b, ConditionTaskBean.class, "com.obric.aiagent.plugin");
        b r8 = (b) ZeusTransformUtils.preCheckCast(r2.f16951a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r4);
        ConditionTaskBean r9 = r7;
        r0 = r8;
    L18:
        return r0.a(r9);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r4);
        long r10 = System.currentTimeMillis();
        r9 = new ConditionTaskBean("ct_" + r10, r5, r27, r28, r29, r30, r25, 0, r32, r10, r10, r17, r33, r34, r35, r36);
        au r11 = kotlinx.coroutines.i.b(r0.f16950b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new c(r0, r9, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        r2.f16951a = r0;
        r2.f16952b = r9;
        r2.f16955e = 1;
        if (r11.a(r2) != r12) goto L18;
        return r12;
    L7:
        r3 = new C0346b(r0, r1);
        goto L8
    }

    public final Object a(String r9, d.c.d<? super ConditionTask> r10) {
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L9;
        Object r8 = kotlinx.coroutines.i.b(this.f16950b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new f(this, r9, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null).a(r11);
        if (r8 != d.c.a.b.a()) goto L8;
        return r8;
    L8:
        return (ConditionTask) ZeusTransformUtils.preCheckCast(r8, ConditionTask.class, "com.obric.aiagent.plugin");
    L9:
        return null;
    }

    public final Object a(String r9, String r10, d.c.d<? super ConditionTask> r11) {
        d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L9;
        Object r8 = kotlinx.coroutines.i.b(this.f16950b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new g(this, r10, r9, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null).a(r12);
        if (r8 != d.c.a.b.a()) goto L8;
        return r8;
    L8:
        return (ConditionTask) ZeusTransformUtils.preCheckCast(r8, ConditionTask.class, "com.obric.aiagent.plugin");
    L9:
        return null;
    }

    public final Object b(String r9, d.c.d<? super List<ConditionTask>> r10) {
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.b(this.f16950b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new d(this, r9, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null).a(r11);
    }

    public final Object c(String r9, d.c.d<? super String> r10) {
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L9;
        Object r8 = kotlinx.coroutines.i.b(this.f16950b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new h(this, r9, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null).a(r11);
        if (r8 != d.c.a.b.a()) goto L8;
        return r8;
    L8:
        return (String) ZeusTransformUtils.preCheckCast(r8, String.class, "com.obric.aiagent.plugin");
    L9:
        return null;
    }

    public final Object d(String r9, d.c.d<? super List<ConditionTask>> r10) {
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.b(this.f16950b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new i(this, r9, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null).a(r11);
    }

    public final Object a(String r10, int r11, int r12, d.c.d<? super List<ConditionTask>> r13) {
        d.c.d r14 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.b(this.f16950b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new j(this, r10, r11, r12, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null).a(r14);
    }

    public final Object e(String r9, d.c.d<? super List<ConditionTask>> r10) {
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.b(this.f16950b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new e(this, r9, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null).a(r11);
    }

    public final Object f(String r9, d.c.d<? super List<ConditionTask>> r10) {
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.b(this.f16950b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new k(this, r9, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null).a(r11);
    }

    public final Object a(String r9, List<String> r10, d.c.d<? super Integer> r11) {
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        d.c.d r13 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.b(this.f16950b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new o(r12, r9, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null).a(r13);
    }

    public final Object a(String r9, Map<String, String> r10, d.c.d<? super Boolean> r11) {
        Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.aiagent.plugin");
        d.c.d r13 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.b(this.f16950b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new p(this, r9, r12, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null).a(r13);
    }

    public static /* synthetic */ Object a(b r13, String r14, List r15, String r16, ConditionGroup r17, PeriodicPolicy r18, TriggerControlPolicy r19, int r20, Map r21, int r22, TaskKnowledge r23, String r24, String r25, d.c.d r26, int r27, Object r28) {
        List<ConditionTaskAction> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.aiagent.plugin");
        Map<String, String> r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r21, Map.class, "com.obric.aiagent.plugin");
        d.c.d<? super ConditionTask> r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r26, d.c.d.class, "com.obric.aiagent.plugin");
        String r5 = null;
        if ((r27 & 2) == 0) goto L6;
        r1 = null;
    L6:
        if ((r27 & 4) == 0) goto L8;
        String r4 = null;
    L10:
        if ((r27 & 8) == 0) goto L12;
        ConditionGroup r6 = null;
    L14:
        if ((r27 & 16) == 0) goto L16;
        PeriodicPolicy r7 = null;
    L18:
        if ((r27 & 32) == 0) goto L20;
        TriggerControlPolicy r8 = null;
    L21:
        int r10 = -1;
        if ((r27 & 64) == 0) goto L24;
        int r9 = -1;
    L26:
        if ((r27 & 128) == 0) goto L29;
        r3 = null;
    L29:
        if ((r27 & 256) != 0) goto L33;
        r10 = r22;
    L33:
        if ((r27 & 512) == 0) goto L35;
        TaskKnowledge r11 = null;
    L37:
        if ((r27 & 1024) == 0) goto L39;
        String r12 = null;
    L41:
        if ((r27 & 2048) != 0) goto L45;
        r5 = r25;
    L45:
        return r13.a(r14, r1, r4, r6, r7, r8, r9, r3, r10, r11, r12, r5, r2);
    L39:
        r12 = r24;
        goto L41
    L35:
        r11 = r23;
        goto L37
    L24:
        r9 = r20;
        goto L26
    L20:
        r8 = r19;
        goto L21
    L16:
        r7 = r18;
        goto L18
    L12:
        r6 = r17;
        goto L14
    L8:
        r4 = r16;
        goto L10
    }

    public final Object a(String r23, List<ConditionTaskAction> r24, String r25, ConditionGroup r26, PeriodicPolicy r27, TriggerControlPolicy r28, int r29, Map<String, String> r30, int r31, TaskKnowledge r32, String r33, String r34, d.c.d<? super ConditionTask> r35) {
        List<ConditionTaskAction> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r24, List.class, "com.obric.aiagent.plugin");
        Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r30, Map.class, "com.obric.aiagent.plugin");
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r35, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, q.class) == false) goto L7;
        q r7 = (q) ZeusTransformUtils.preCheckCast(r6, q.class, "com.obric.aiagent.plugin");
        if ((r7.o & Integer.MIN_VALUE) == 0) goto L7;
        r7.o -= Integer.MIN_VALUE;
    L8:
        Object r8 = r7.m;
        Object r9 = d.c.a.b.a();
        int r10 = r7.o;
        if (r10 == 0) goto L16;
        if (r10 == 1) goto L15;
        if (r10 != 2) goto L14;
        ConditionTaskBean r0 = (ConditionTaskBean) ZeusTransformUtils.preCheckCast(r7.f17005b, ConditionTaskBean.class, "com.obric.aiagent.plugin");
        b r1 = (b) ZeusTransformUtils.preCheckCast(r7.f17004a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r8);
    L54:
        if (((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.aiagent.plugin")).intValue() > 0) goto L56;
        return null;
    L56:
        return r1.a(r0);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        int r2 = r7.l;
        int r4 = r7.k;
        String r11 = (String) ZeusTransformUtils.preCheckCast(r7.j, String.class, "com.obric.aiagent.plugin");
        String r12 = (String) ZeusTransformUtils.preCheckCast(r7.i, String.class, "com.obric.aiagent.plugin");
        TaskKnowledge r13 = (TaskKnowledge) ZeusTransformUtils.preCheckCast(r7.h, TaskKnowledge.class, "com.obric.aiagent.plugin");
        Map<String, String> r14 = (Map) ZeusTransformUtils.preCheckCast(r7.g, Map.class, "com.obric.aiagent.plugin");
        TriggerControlPolicy r15 = (TriggerControlPolicy) ZeusTransformUtils.preCheckCast(r7.f, TriggerControlPolicy.class, "com.obric.aiagent.plugin");
        PeriodicPolicy r16 = (PeriodicPolicy) ZeusTransformUtils.preCheckCast(r7.f17008e, PeriodicPolicy.class, "com.obric.aiagent.plugin");
        ConditionGroup r17 = (ConditionGroup) ZeusTransformUtils.preCheckCast(r7.f17007d, ConditionGroup.class, "com.obric.aiagent.plugin");
        String r18 = (String) ZeusTransformUtils.preCheckCast(r7.f17006c, String.class, "com.obric.aiagent.plugin");
        int r22 = r2;
        List<ConditionTaskAction> r19 = (List) ZeusTransformUtils.preCheckCast(r7.f17005b, List.class, "com.obric.aiagent.plugin");
        b r20 = (b) ZeusTransformUtils.preCheckCast(r7.f17004a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r8);
        int r110 = r4;
        TaskKnowledge r21 = r13;
        PeriodicPolicy r36 = r16;
        Object r111 = r8;
        ConditionGroup r37 = r17;
        TriggerControlPolicy r112 = r15;
        Map<String, String> r113 = r14;
        List<ConditionTaskAction> r114 = r19;
    L22:
        ConditionTaskBean r38 = (ConditionTaskBean) ZeusTransformUtils.preCheckCast(r111, ConditionTaskBean.class, "com.obric.aiagent.plugin");
        Map<String, String> r115 = r113;
        List<ConditionTaskAction> r116 = r114;
        ConditionTaskBean r117 = r38;
        int r39 = r22;
    L24:
        if (r117 != null) goto L27;
        return null;
    L27:
        if (r116 == null) goto L29;
        r117.setActions(r116);
    L29:
        if (r18 == null) goto L31;
        r117.setName(r18);
    L31:
        if (r37 == null) goto L33;
        r117.setConditions(r37);
    L33:
        if (r36 == null) goto L35;
        r117.setPeriodicPolicy(r36);
    L35:
        if (r112 == null) goto L37;
        r117.setTriggerControlPolicy(r112);
    L37:
        if (r110 < 0) goto L39;
        r117.setEnableStatus(r110);
    L39:
        if (r115 == null) goto L41;
        r117.setExt(r115);
    L41:
        if (r39 < 0) goto L43;
        r117.setTaskMode(d.c.b.a.b.a(r39));
    L43:
        if (r21 == null) goto L45;
        r117.setTaskKnowledge(r21);
    L45:
        if (r12 == null) goto L47;
        r117.setTemplateId(r12);
    L47:
        if (r11 == null) goto L49;
        r117.setOmniModel(r11);
    L49:
        au r40 = kotlinx.coroutines.i.b(r20.f16950b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new r(r20, r117, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        r7.f17004a = r20;
        r7.f17005b = r117;
        r7.f17006c = null;
        r7.f17007d = null;
        r7.f17008e = null;
        r7.f = null;
        r7.g = null;
        r7.h = null;
        r7.i = null;
        r7.j = null;
        r7.o = 2;
        r8 = r40.a(r7);
        if (r8 != r9) goto L52;
        return r9;
    L52:
        r1 = r20;
        r0 = r117;
        goto L54
    L16:
        d.o.a(r8);
        if (r23 == null) goto L23;
        au r41 = kotlinx.coroutines.i.b(this.f16950b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new s(this, r23, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        r7.f17004a = this;
        r7.f17005b = r3;
        r7.f17006c = r25;
        r37 = r26;
        r7.f17007d = r37;
        r36 = r27;
        r7.f17008e = r36;
        r112 = r28;
        r7.f = r112;
        r7.g = r5;
        r7.h = r32;
        r7.i = r33;
        r7.j = r34;
        r110 = r29;
        r7.k = r110;
        r7.l = r31;
        r7.o = 1;
        Object r42 = r41.a(r7);
        if (r42 != r9) goto L21;
        return r9;
    L21:
        r114 = r3;
        r11 = r34;
        r111 = r42;
        r21 = r32;
        r18 = r25;
        r20 = this;
        r22 = r31;
        r113 = r5;
        r12 = r33;
        goto L22
    L23:
        r37 = r26;
        r36 = r27;
        r112 = r28;
        r110 = r29;
        r39 = r31;
        r21 = r32;
        r117 = null;
        r18 = r25;
        r20 = this;
        r116 = r3;
        r11 = r34;
        r115 = r5;
        r12 = r33;
    L7:
        r7 = new q(this, r6);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x012d -> B:38:0x01af). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0168 -> B:13:0x007c). Please report as a decompilation issue!!! */
    public final Object a(String r34, String[] r35, d.c.d<? super List<ConditionTask>> r36) {
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r36, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, l.class) == false) goto L7;
        l r3 = (l) ZeusTransformUtils.preCheckCast(r1, l.class, "com.obric.aiagent.plugin");
        if ((r3.j & Integer.MIN_VALUE) == 0) goto L7;
        r3.j -= Integer.MIN_VALUE;
        b r4 = this;
    L8:
        Object r2 = r3.h;
        Object r5 = d.c.a.b.a();
        int r6 = r3.j;
        if (r6 == 0) goto L17;
        if (r6 == 1) goto L16;
        if (r6 != 2) goto L15;
        int r7 = r3.g;
        int r8 = r3.f;
        ConditionTaskBean r10 = (ConditionTaskBean) ZeusTransformUtils.preCheckCast(r3.f16990e, ConditionTaskBean.class, "com.obric.aiagent.plugin");
        String[] r11 = (String[]) ZeusTransformUtils.preCheckCast(r3.f16989d, String[].class, "com.obric.aiagent.plugin");
        List r12 = (List) ZeusTransformUtils.preCheckCast(r3.f16988c, List.class, "com.obric.aiagent.plugin");
        String r13 = (String) ZeusTransformUtils.preCheckCast(r3.f16987b, String.class, "com.obric.aiagent.plugin");
        b r0 = (b) ZeusTransformUtils.preCheckCast(r3.f16986a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r2);
    L13:
        String[] r31 = r11;
        List r15 = r12;
        String r32 = r13;
        if (((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.aiagent.plugin")).intValue() <= 0) goto L36;
        List r9 = r15;
        r9.add(r0.a(ConditionTaskBean.copy$default(r10, null, null, null, null, null, null, null, 0, 3, 0, 0, null, null, null, null, null, 65279, null)));
    L37:
        int r14 = r7;
        Object r16 = r5;
        List r17 = r9;
        r4 = r0;
        l r18 = r3;
        String r19 = r32;
    L38:
        int r20 = r8 + 1;
        String[] r21 = r31;
    L18:
        if (r20 >= r14) goto L39;
        au r22 = kotlinx.coroutines.i.b(r4.f16950b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new m(r4, r21[r20], null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        r18.f16986a = r4;
        r18.f16987b = r19;
        r18.f16988c = r17;
        r18.f16989d = r21;
        r18.f16990e = null;
        r18.f = r20;
        r18.g = r14;
        r18.j = 1;
        Object r23 = r22.a(r18);
        if (r23 != r16) goto L22;
        return r16;
    L22:
        r13 = r19;
        r12 = r17;
        r0 = r4;
        r2 = r23;
        r7 = r14;
        r11 = r21;
        r8 = r20;
        r3 = r18;
        r5 = r16;
    L23:
        r10 = (ConditionTaskBean) ZeusTransformUtils.preCheckCast(r2, ConditionTaskBean.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L26;
        String r24 = r10.getSourceFrom();
    L28:
        if (d.h.b.o.a(r24, r13) == true) goto L30;
        r16 = r5;
        r31 = r11;
        r17 = r12;
        r18 = r3;
        r14 = r7;
        r4 = r0;
        r19 = r13;
        goto L38
    L30:
        au r25 = kotlinx.coroutines.i.b(r0.f16950b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new n(r0, r10, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        r3.f16986a = r0;
        r3.f16987b = r13;
        r3.f16988c = r12;
        r3.f16989d = r11;
        r3.f16990e = r10;
        r3.f = r8;
        r3.g = r7;
        r3.j = 2;
        r2 = r25.a(r3);
        if (r2 != r5) goto L13;
        return r5;
    L26:
        r24 = null;
        goto L28
    L39:
        return r17;
    L36:
        r9 = r15;
        goto L37
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r7 = r3.g;
        r8 = r3.f;
        String[] r110 = (String[]) ZeusTransformUtils.preCheckCast(r3.f16989d, String[].class, "com.obric.aiagent.plugin");
        List r111 = (List) ZeusTransformUtils.preCheckCast(r3.f16988c, List.class, "com.obric.aiagent.plugin");
        String r112 = (String) ZeusTransformUtils.preCheckCast(r3.f16987b, String.class, "com.obric.aiagent.plugin");
        r0 = (b) ZeusTransformUtils.preCheckCast(r3.f16986a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r2);
        r13 = r112;
        r12 = r111;
        r11 = r110;
        goto L23
    L17:
        d.o.a(r2);
        List r26 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        r21 = r35;
        r14 = r21.length;
        r16 = r5;
        r18 = r3;
        r20 = 0;
        r17 = r26;
        r19 = r34;
    L7:
        r4 = this;
        r3 = new l(r4, r1);
        goto L8
    }

    private final ConditionTask a(ConditionTaskBean r15) {
        ConditionTask r13 = new ConditionTask(r15.getTaskId(), r15.getName(), Integer.valueOf(r15.getTaskStatus()), Integer.valueOf(r15.getEnableStatus()), Long.valueOf(r15.getCreateTime()), r15.getExt(), r15.getActions(), r15.getConditions(), r15.getPeriodicPolicy(), r15.getTriggerControlPolicy(), b(r15));
        r13.setTaskMode(1);
        r13.setTaskKnowledge(r15.getTaskKnowledge());
        r13.setTemplateId(r15.getTemplateId());
        r13.setOmniModel(r15.getOmniModel());
        return r13;
    }

    private final long b(ConditionTaskBean r11) {
        List r10 = com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.d.c(r11.getConditions(), aa.b(TimeCondition.class));
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == true) goto L6;
        r10 = null;
    L6:
        if (r10 == null) goto L17;
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        if (r12.hasNext() == false) goto L16;
        long r2 = com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.f.a((TimeCondition) ZeusTransformUtils.preCheckCast(r12.next(), TimeCondition.class, "com.obric.aiagent.plugin"), r11.getPeriodicPolicy(), 0, 4, null);
    L11:
        if (r12.hasNext() == false) goto L24;
        long r4 = com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.f.a((TimeCondition) ZeusTransformUtils.preCheckCast(r12.next(), TimeCondition.class, "com.obric.aiagent.plugin"), r11.getPeriodicPolicy(), 0, 4, null);
        if (r2 <= r4) goto L11;
        r2 = r4;
        goto L11
    L24:
        return r2;
    L16:
        throw new NoSuchElementException();
    L17:
        return 0;
    }
}
