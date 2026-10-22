package com.obric.aiagent.executionengine.eventstaskmanager.executionrecord;

import com.obric.eventkit.task.model.EventTaskExecutionRecord;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.o;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.au;

/* JADX INFO: compiled from: ExecutionRecordRepo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final am f17400a;

    /* JADX INFO: compiled from: ExecutionRecordRepo.kt */
    @d.c.b.a.f(b = "ExecutionRecordRepo.kt", c = {32, 36}, d = "addExecutionRecord", e = "com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.ExecutionRecordRepo")
    static final class a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f17401a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f17402b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ e f17403c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f17404d;

        a(e r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17403c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f17402b = r3;
            this.f17404d |= Integer.MIN_VALUE;
            return this.f17403c.a(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ExecutionRecordRepo.kt */
    @d.c.b.a.f(b = "ExecutionRecordRepo.kt", c = {36}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.ExecutionRecordRepo$addExecutionRecord$2")
    static final class b extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super List<? extends EventTaskExecutionRecord>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17405a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f17406b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ List<Long> f17407c;

        b(e r3, List<Long> r4, d.c.d<? super b> r5) {
            List<Long> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17406b = r3;
            this.f17407c = r6;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super List<EventTaskExecutionRecord>> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f17406b, this.f17407c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super List<? extends EventTaskExecutionRecord>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17405a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L11:
            com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a r6 = (com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L20;
            List<ExecutionRecordBean> r7 = r6.a(this.f17407c);
            if (r7 == null) goto L20;
            Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin");
            e r4 = this.f17406b;
            Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r8, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r9 = r8.iterator();
        L17:
            if (r9.hasNext() == false) goto L23;
            r2.add(e.a(r4, (ExecutionRecordBean) ZeusTransformUtils.preCheckCast(r9.next(), ExecutionRecordBean.class, "com.obric.aiagent.plugin")));
            goto L17
        L23:
            return (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin");
        L20:
            return null;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            e r10 = this.f17406b;
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17405a = 1;
            r5 = e.a(r10, r3);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ExecutionRecordRepo.kt */
    @d.c.b.a.f(b = "ExecutionRecordRepo.kt", c = {32}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.ExecutionRecordRepo$addExecutionRecord$ids$1")
    static final class c extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super List<? extends Long>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17408a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f17409b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ List<ExecutionRecordBean> f17410c;

        c(e r3, List<ExecutionRecordBean> r4, d.c.d<? super c> r5) {
            List<ExecutionRecordBean> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17409b = r3;
            this.f17410c = r6;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super List<Long>> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f17409b, this.f17410c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super List<? extends Long>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17408a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L11:
            com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a r6 = (com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a.class, "com.obric.aiagent.plugin");
            if (r6 != null) goto L16;
            return null;
        L16:
            return r6.insert(this.f17410c);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            e r7 = this.f17409b;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17408a = 1;
            r5 = e.a(r7, r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ExecutionRecordRepo.kt */
    @d.c.b.a.f(b = "ExecutionRecordRepo.kt", c = {40}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.ExecutionRecordRepo$getExecutionRecord$2")
    static final class d extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super EventTaskExecutionRecord>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17411a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f17412b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f17413c;

        d(e r3, long r4, d.c.d<? super d> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17412b = r3;
            this.f17413c = r4;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super EventTaskExecutionRecord> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r5, d.c.d<?> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f17412b, this.f17413c, r7), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super EventTaskExecutionRecord> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17411a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L11:
            com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a r6 = (com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L18;
            List<ExecutionRecordBean> r7 = r6.a(p.a(d.c.b.a.b.a(this.f17413c)));
            if (r7 == null) goto L18;
            ExecutionRecordBean r8 = (ExecutionRecordBean) ZeusTransformUtils.preCheckCast(p.l(r7), ExecutionRecordBean.class, "com.obric.aiagent.plugin");
            if (r8 == null) goto L18;
            return e.a(this.f17412b, r8);
        L18:
            return null;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            e r9 = this.f17412b;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17411a = 1;
            r5 = e.a(r9, r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ExecutionRecordRepo.kt */
    @d.c.b.a.f(b = "ExecutionRecordRepo.kt", c = {44}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.ExecutionRecordRepo$getExecutionRecords$2")
    static final class C0358e extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super List<? extends EventTaskExecutionRecord>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17414a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f17415b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f17416c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f17417d;

        C0358e(e r3, int r4, int r5, d.c.d<? super C0358e> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17415b = r3;
            this.f17416c = r4;
            this.f17417d = r5;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super List<EventTaskExecutionRecord>> r4) {
            return ((C0358e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0358e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new C0358e(this.f17415b, this.f17416c, this.f17417d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super List<? extends EventTaskExecutionRecord>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17414a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L11:
            com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a r6 = (com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L20;
            List<ExecutionRecordBean> r7 = r6.a(this.f17416c, this.f17417d);
            if (r7 == null) goto L20;
            Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin");
            e r4 = this.f17415b;
            Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r8, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r9 = r8.iterator();
        L17:
            if (r9.hasNext() == false) goto L23;
            r2.add(e.a(r4, (ExecutionRecordBean) ZeusTransformUtils.preCheckCast(r9.next(), ExecutionRecordBean.class, "com.obric.aiagent.plugin")));
            goto L17
        L23:
            return (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin");
        L20:
            return null;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            e r10 = this.f17415b;
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17414a = 1;
            r5 = e.a(r10, r3);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ExecutionRecordRepo.kt */
    @d.c.b.a.f(b = "ExecutionRecordRepo.kt", c = {48}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.ExecutionRecordRepo$getExecutionRecordsByTaskId$2")
    static final class f extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super List<? extends EventTaskExecutionRecord>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17418a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f17419b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f17420c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f17421d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f17422e;

        f(e r3, String r4, int r5, int r6, d.c.d<? super f> r7) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17419b = r3;
            this.f17420c = r4;
            this.f17421d = r5;
            this.f17422e = r6;
            super(2, r8);
        }

        public final Object a(am r3, d.c.d<? super List<EventTaskExecutionRecord>> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r8, d.c.d<?> r9) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new f(this.f17419b, this.f17420c, this.f17421d, this.f17422e, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super List<? extends EventTaskExecutionRecord>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17418a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L11:
            com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a r6 = (com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L20;
            List<ExecutionRecordBean> r7 = r6.a(this.f17420c, this.f17421d, this.f17422e);
            if (r7 == null) goto L20;
            Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin");
            e r4 = this.f17419b;
            Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r8, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r9 = r8.iterator();
        L17:
            if (r9.hasNext() == false) goto L23;
            r2.add(e.a(r4, (ExecutionRecordBean) ZeusTransformUtils.preCheckCast(r9.next(), ExecutionRecordBean.class, "com.obric.aiagent.plugin")));
            goto L17
        L23:
            return (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin");
        L20:
            return null;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            e r10 = this.f17419b;
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17418a = 1;
            r5 = e.a(r10, r3);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ExecutionRecordRepo.kt */
    @d.c.b.a.f(b = "ExecutionRecordRepo.kt", c = {106}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.ExecutionRecordRepo$removeExecutionRecordsById$2")
    static final class g extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super Integer>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17423a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f17424b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long[] f17425c;

        g(e r3, long[] r4, d.c.d<? super g> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17424b = r3;
            this.f17425c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super Integer> r4) {
            return ((g) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), g.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new g(this.f17424b, this.f17425c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Integer> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17423a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L11:
            com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a r6 = (com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L14;
            int r4 = r6.c(d.a.i.b(this.f17425c));
        L16:
            return d.c.b.a.b.a(r4);
        L14:
            r4 = 0;
            goto L16
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            e r7 = this.f17424b;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17423a = 1;
            r5 = e.a(r7, r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ExecutionRecordRepo.kt */
    @d.c.b.a.f(b = "ExecutionRecordRepo.kt", c = {110}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.ExecutionRecordRepo$removeExecutionRecordsByTaskId$2")
    static final class h extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super Integer>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17426a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f17427b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f17428c;

        h(e r3, String r4, d.c.d<? super h> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17427b = r3;
            this.f17428c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super Integer> r4) {
            return ((h) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new h(this.f17427b, this.f17428c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Integer> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17426a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L11:
            com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a r6 = (com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L14;
            int r4 = r6.a(this.f17428c);
        L16:
            return d.c.b.a.b.a(r4);
        L14:
            r4 = 0;
            goto L16
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            e r7 = this.f17427b;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17426a = 1;
            r5 = e.a(r7, r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ExecutionRecordRepo.kt */
    @d.c.b.a.f(b = "ExecutionRecordRepo.kt", c = {52, 71}, d = "updateExecutionRecord", e = "com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.ExecutionRecordRepo")
    static final class i extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f17429a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f17430b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f17431c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ e f17432d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f17433e;

        i(e r3, d.c.d<? super i> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17432d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f17431c = r3;
            this.f17433e |= Integer.MIN_VALUE;
            return this.f17432d.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ExecutionRecordRepo.kt */
    @d.c.b.a.f(b = "ExecutionRecordRepo.kt", c = {52}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.ExecutionRecordRepo$updateExecutionRecord$bean$1")
    static final class j extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super ExecutionRecordBean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17434a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f17435b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ EventTaskExecutionRecord f17436c;

        j(e r3, EventTaskExecutionRecord r4, d.c.d<? super j> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17435b = r3;
            this.f17436c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super ExecutionRecordBean> r4) {
            return ((j) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), j.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new j(this.f17435b, this.f17436c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super ExecutionRecordBean> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17434a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L11:
            com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a r6 = (com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L16;
            List<ExecutionRecordBean> r4 = r6.a(p.a(d.c.b.a.b.a(this.f17436c.getId())));
            if (r4 == null) goto L16;
            return (ExecutionRecordBean) ZeusTransformUtils.preCheckCast(p.l(r4), ExecutionRecordBean.class, "com.obric.aiagent.plugin");
        L16:
            return null;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            e r7 = this.f17435b;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17434a = 1;
            r5 = e.a(r7, r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ExecutionRecordRepo.kt */
    @d.c.b.a.f(b = "ExecutionRecordRepo.kt", c = {71}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.ExecutionRecordRepo$updateExecutionRecord$result$1")
    static final class k extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super Integer>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17437a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f17438b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ExecutionRecordBean f17439c;

        k(e r3, ExecutionRecordBean r4, d.c.d<? super k> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17438b = r3;
            this.f17439c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super Integer> r4) {
            return ((k) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), k.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new k(this.f17438b, this.f17439c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Integer> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17437a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L11:
            com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a r6 = (com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L14;
            int r4 = r6.update(this.f17439c);
        L16:
            return d.c.b.a.b.a(r4);
        L14:
            r4 = 0;
            goto L16
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            e r7 = this.f17438b;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17437a = 1;
            r5 = e.a(r7, r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ExecutionRecordRepo.kt */
    @d.c.b.a.f(b = "ExecutionRecordRepo.kt", c = {79, 101}, d = "updateExecutionRecords", e = "com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.ExecutionRecordRepo")
    static final class l extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f17440a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f17441b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f17442c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ e f17443d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f17444e;

        l(e r3, d.c.d<? super l> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17443d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f17442c = r3;
            this.f17444e |= Integer.MIN_VALUE;
            return this.f17443d.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ExecutionRecordRepo.kt */
    @d.c.b.a.f(b = "ExecutionRecordRepo.kt", c = {79}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.ExecutionRecordRepo$updateExecutionRecords$beans$1")
    static final class m extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super List<? extends ExecutionRecordBean>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17445a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f17446b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ List<EventTaskExecutionRecord> f17447c;

        m(e r3, List<EventTaskExecutionRecord> r4, d.c.d<? super m> r5) {
            List<EventTaskExecutionRecord> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17446b = r3;
            this.f17447c = r6;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super List<ExecutionRecordBean>> r4) {
            return ((m) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), m.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new m(this.f17446b, this.f17447c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super List<? extends ExecutionRecordBean>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17445a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L11:
            com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a r6 = (com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L18;
            Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(this.f17447c, Iterable.class, "com.obric.aiagent.plugin");
            Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r4, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r7 = r4.iterator();
        L15:
            if (r7.hasNext() == false) goto L21;
            r2.add(d.c.b.a.b.a(((EventTaskExecutionRecord) ZeusTransformUtils.preCheckCast(r7.next(), EventTaskExecutionRecord.class, "com.obric.aiagent.plugin")).getId()));
            goto L15
        L21:
            return r6.a((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin"));
        L18:
            return null;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            e r8 = this.f17446b;
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17445a = 1;
            r5 = e.a(r8, r3);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ExecutionRecordRepo.kt */
    @d.c.b.a.f(b = "ExecutionRecordRepo.kt", c = {101}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.ExecutionRecordRepo$updateExecutionRecords$result$1")
    static final class n extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super Integer>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17448a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f17449b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ List<ExecutionRecordBean> f17450c;

        n(e r3, List<ExecutionRecordBean> r4, d.c.d<? super n> r5) {
            List<ExecutionRecordBean> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17449b = r3;
            this.f17450c = r6;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super Integer> r4) {
            return ((n) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), n.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new n(this.f17449b, this.f17450c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Integer> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17448a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L11:
            com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a r6 = (com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L14;
            int r4 = r6.b(this.f17450c);
        L16:
            return d.c.b.a.b.a(r4);
        L14:
            r4 = 0;
            goto L16
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            e r7 = this.f17449b;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17448a = 1;
            r5 = e.a(r7, r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    public e() {
        this.f17400a = an.a((d.c.g) ZeusTransformUtils.preCheckCast(com.obric.aiagent.executionengine.eventstaskmanager.common.a.f16677a.a(), d.c.g.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ EventTaskExecutionRecord a(e r0, ExecutionRecordBean r1) {
        return r0.a(r1);
    }

    public static final /* synthetic */ Object a(e r2, d.c.d r3) {
        return r2.a((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    private final Object a(d.c.d<? super com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a> r2) {
        d.c.d<? super com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a> r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.executionengine.eventstaskmanager.common.data.e.f16691a.g(r1);
    }

    public final Object a(String r31, List<EventTaskExecutionRecord> r32, d.c.d<? super List<EventTaskExecutionRecord>> r33) {
        e r0 = this;
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r32, List.class, "com.obric.aiagent.plugin");
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r33, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, a.class) == false) goto L7;
        a r4 = (a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.aiagent.plugin");
        if ((r4.f17404d & Integer.MIN_VALUE) == 0) goto L7;
        r4.f17404d -= Integer.MIN_VALUE;
    L8:
        Object r5 = r4.f17402b;
        Object r6 = d.c.a.b.a();
        int r7 = r4.f17404d;
        if (r7 == 0) goto L16;
        if (r7 == 1) goto L15;
        if (r7 != 2) goto L14;
        o.a(r5);
    L29:
        return r5;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r0 = (e) ZeusTransformUtils.preCheckCast(r4.f17401a, e.class, "com.obric.aiagent.plugin");
        o.a(r5);
    L23:
        List r2 = (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L26;
        return null;
    L26:
        au r8 = kotlinx.coroutines.i.b(r0.f17400a, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(r0, r2, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        r4.f17401a = null;
        r4.f17404d = 2;
        r5 = r8.a(r4);
        if (r5 != r6) goto L29;
        return r6;
    L16:
        o.a(r5);
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin");
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r9, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r11 = r9.iterator();
    L18:
        if (r11.hasNext() == false) goto L20;
        EventTaskExecutionRecord r12 = (EventTaskExecutionRecord) ZeusTransformUtils.preCheckCast(r11.next(), EventTaskExecutionRecord.class, "com.obric.aiagent.plugin");
        r10.add(new ExecutionRecordBean(r12.getTaskId(), r12.getTaskType(), r12.getTaskMode(), r12.getQuery(), r12.getTriggerTime(), r12.getDuration(), r12.getResultCode(), r12.getResultMessage(), r12.getComplexTaskModel(), r12.getExt(), r31, 0, 0, 6144, null));
        goto L18
    L20:
        au r13 = kotlinx.coroutines.i.b(r0.f17400a, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new c(r0, (List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.aiagent.plugin"), null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        r4.f17401a = r0;
        r4.f17404d = 1;
        r5 = r13.a(r4);
        if (r5 != r6) goto L23;
        return r6;
    L7:
        r4 = new a(r0, r3);
        goto L8
    }

    public final Object a(long r9, d.c.d<? super EventTaskExecutionRecord> r11) {
        d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.b(this.f17400a, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new d(this, r9, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null).a(r12);
    }

    public final Object a(int r9, int r10, d.c.d<? super List<EventTaskExecutionRecord>> r11) {
        d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.b(this.f17400a, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new C0358e(this, r9, r10, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null).a(r12);
    }

    public final Object a(String r10, int r11, int r12, d.c.d<? super List<EventTaskExecutionRecord>> r13) {
        d.c.d r14 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.b(this.f17400a, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new f(this, r10, r11, r12, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null).a(r14);
    }

    public final Object a(EventTaskExecutionRecord r37, d.c.d<? super EventTaskExecutionRecord> r38) {
        e r0 = this;
        EventTaskExecutionRecord r1 = r37;
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r38, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, i.class) == false) goto L7;
        i r5 = (i) ZeusTransformUtils.preCheckCast(r3, i.class, "com.obric.aiagent.plugin");
        if ((r5.f17433e & Integer.MIN_VALUE) == 0) goto L7;
        r5.f17433e -= Integer.MIN_VALUE;
    L8:
        Object r4 = r5.f17431c;
        Object r6 = d.c.a.b.a();
        int r7 = r5.f17433e;
        if (r7 == 0) goto L16;
        if (r7 == 1) goto L15;
        if (r7 != 2) goto L14;
        ExecutionRecordBean r2 = (ExecutionRecordBean) ZeusTransformUtils.preCheckCast(r5.f17430b, ExecutionRecordBean.class, "com.obric.aiagent.plugin");
        e r8 = (e) ZeusTransformUtils.preCheckCast(r5.f17429a, e.class, "com.obric.aiagent.plugin");
        o.a(r4);
    L27:
        if (((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).intValue() > 0) goto L29;
        return null;
    L29:
        return r8.a(r2);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        EventTaskExecutionRecord r9 = (EventTaskExecutionRecord) ZeusTransformUtils.preCheckCast(r5.f17430b, EventTaskExecutionRecord.class, "com.obric.aiagent.plugin");
        e r10 = (e) ZeusTransformUtils.preCheckCast(r5.f17429a, e.class, "com.obric.aiagent.plugin");
        o.a(r4);
        r1 = r9;
        r0 = r10;
    L19:
        ExecutionRecordBean r11 = (ExecutionRecordBean) ZeusTransformUtils.preCheckCast(r4, ExecutionRecordBean.class, "com.obric.aiagent.plugin");
        if (r11 != null) goto L22;
        return null;
    L22:
        ExecutionRecordBean r12 = new ExecutionRecordBean(r1.getTaskId(), r1.getTaskType(), r1.getTaskMode(), r1.getQuery(), r1.getTriggerTime(), r1.getDuration(), r1.getResultCode(), r1.getResultMessage(), r1.getComplexTaskModel(), r1.getExt(), r11.getSourceFrom(), r11.getCreateTime(), r1.getId());
        au r13 = kotlinx.coroutines.i.b(r0.f17400a, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new k(r0, r12, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        r5.f17429a = r0;
        r5.f17430b = r12;
        r5.f17433e = 2;
        Object r14 = r13.a(r5);
        if (r14 != r6) goto L25;
        return r6;
    L25:
        r8 = r0;
        r2 = r12;
        r4 = r14;
        goto L27
    L16:
        o.a(r4);
        au r15 = kotlinx.coroutines.i.b(r0.f17400a, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new j(r0, r1, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        r5.f17429a = r0;
        r5.f17430b = r1;
        r5.f17433e = 1;
        r4 = r15.a(r5);
        if (r4 != r6) goto L19;
        return r6;
    L7:
        r5 = new i(r0, r3);
        goto L8
    }

    public final Object a(List<EventTaskExecutionRecord> r33, d.c.d<? super Integer> r34) {
        e r0 = this;
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r33, List.class, "com.obric.aiagent.plugin");
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r34, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, l.class) == false) goto L7;
        l r4 = (l) ZeusTransformUtils.preCheckCast(r3, l.class, "com.obric.aiagent.plugin");
        if ((r4.f17444e & Integer.MIN_VALUE) == 0) goto L7;
        r4.f17444e -= Integer.MIN_VALUE;
    L8:
        Object r5 = r4.f17442c;
        Object r6 = d.c.a.b.a();
        int r7 = r4.f17444e;
        if (r7 == 0) goto L16;
        if (r7 == 1) goto L15;
        if (r7 != 2) goto L14;
        o.a(r5);
    L52:
        return d.c.b.a.b.a(((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.aiagent.plugin")).intValue());
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r1 = (List) ZeusTransformUtils.preCheckCast(r4.f17441b, List.class, "com.obric.aiagent.plugin");
        r0 = (e) ZeusTransformUtils.preCheckCast(r4.f17440a, e.class, "com.obric.aiagent.plugin");
        o.a(r5);
    L19:
        List r8 = (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.aiagent.plugin");
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.aiagent.plugin");
        if (r9 != null) goto L22;
    L25:
        boolean r10 = true;
    L26:
        if (r10 == true) goto L28;
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin");
        Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r13 = r11.iterator();
    L31:
        if (r13.hasNext() == false) goto L48;
        ExecutionRecordBean r14 = (ExecutionRecordBean) ZeusTransformUtils.preCheckCast(r13.next(), ExecutionRecordBean.class, "com.obric.aiagent.plugin");
        Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L34:
        if (r15.hasNext() == false) goto L41;
        Object r16 = r15.next();
        if (((EventTaskExecutionRecord) ZeusTransformUtils.preCheckCast(r16, EventTaskExecutionRecord.class, "com.obric.aiagent.plugin")).getId() != r14.getId()) goto L38;
        boolean r17 = true;
    L39:
        if (r17 == false) goto L34;
    L42:
        EventTaskExecutionRecord r18 = (EventTaskExecutionRecord) ZeusTransformUtils.preCheckCast(r16, EventTaskExecutionRecord.class, "com.obric.aiagent.plugin");
        if (r18 != null) goto L45;
        ExecutionRecordBean r19 = null;
    L46:
        if (r19 == null) goto L31;
        r12.add(r19);
        goto L31
    L45:
        r19 = new ExecutionRecordBean(r18.getTaskId(), r18.getTaskType(), r18.getTaskMode(), r18.getQuery(), r18.getTriggerTime(), r18.getDuration(), r18.getResultCode(), r18.getResultMessage(), r18.getComplexTaskModel(), r18.getExt(), r14.getSourceFrom(), r14.getCreateTime(), r18.getId());
        goto L46
    L38:
        r17 = false;
        goto L39
    L41:
        r16 = null;
        goto L42
    L48:
        au r2 = kotlinx.coroutines.i.b(r0.f17400a, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new n(r0, (List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.aiagent.plugin"), null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        r4.f17440a = null;
        r4.f17441b = null;
        r4.f17444e = 2;
        r5 = r2.a(r4);
        if (r5 != r6) goto L52;
        return r6;
    L28:
        return d.c.b.a.b.a(0);
    L22:
        if (r9.isEmpty() == true) goto L25;
        r10 = false;
        goto L26
    L16:
        o.a(r5);
        au r20 = kotlinx.coroutines.i.b(r0.f17400a, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new m(r0, r1, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        r4.f17440a = r0;
        r4.f17441b = r1;
        r4.f17444e = 1;
        r5 = r20.a(r4);
        if (r5 != r6) goto L19;
        return r6;
    L7:
        r4 = new l(r0, r3);
        goto L8
    }

    public final Object a(long[] r9, d.c.d<? super Integer> r10) {
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.b(this.f17400a, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new g(this, r9, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null).a(r11);
    }

    public final Object a(String r9, d.c.d<? super Integer> r10) {
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.b(this.f17400a, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new h(this, r9, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null).a(r11);
    }

    private final EventTaskExecutionRecord a(ExecutionRecordBean r17) {
        return new EventTaskExecutionRecord(r17.getId(), r17.getTaskType(), r17.getTaskMode(), r17.getTaskId(), r17.getQuery(), r17.getTriggerTime(), r17.getDuration(), r17.getResultCode(), r17.getResultMessage(), r17.getExt(), r17.getComplexTaskModel());
    }
}
