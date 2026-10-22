package com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail;

import com.obric.eventkit.task.model.EventTaskExecutionDetailRecord;
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

/* JADX INFO: compiled from: ExecutionDetailRecordRepo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final am f17349a;

    /* JADX INFO: compiled from: ExecutionDetailRecordRepo.kt */
    @d.c.b.a.f(b = "ExecutionDetailRecordRepo.kt", c = {28, 32}, d = "addExecutionDetailRecord", e = "com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.ExecutionDetailRecordRepo")
    static final class a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f17350a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f17351b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ e f17352c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f17353d;

        a(e r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17352c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f17351b = r3;
            this.f17353d |= Integer.MIN_VALUE;
            return this.f17352c.a(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ExecutionDetailRecordRepo.kt */
    @d.c.b.a.f(b = "ExecutionDetailRecordRepo.kt", c = {32}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.ExecutionDetailRecordRepo$addExecutionDetailRecord$2")
    static final class b extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super List<? extends EventTaskExecutionDetailRecord>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17354a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f17355b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ List<Long> f17356c;

        b(e r3, List<Long> r4, d.c.d<? super b> r5) {
            List<Long> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17355b = r3;
            this.f17356c = r6;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super List<EventTaskExecutionDetailRecord>> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f17355b, this.f17356c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super List<? extends EventTaskExecutionDetailRecord>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17354a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L11:
            com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a r6 = (com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L20;
            List<ExecutionDetailRecordBean> r7 = r6.a(this.f17356c);
            if (r7 == null) goto L20;
            Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin");
            e r4 = this.f17355b;
            Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r8, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r9 = r8.iterator();
        L17:
            if (r9.hasNext() == false) goto L23;
            r2.add(e.a(r4, (ExecutionDetailRecordBean) ZeusTransformUtils.preCheckCast(r9.next(), ExecutionDetailRecordBean.class, "com.obric.aiagent.plugin")));
            goto L17
        L23:
            return (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin");
        L20:
            return null;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            e r10 = this.f17355b;
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17354a = 1;
            r5 = e.a(r10, r3);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ExecutionDetailRecordRepo.kt */
    @d.c.b.a.f(b = "ExecutionDetailRecordRepo.kt", c = {28}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.ExecutionDetailRecordRepo$addExecutionDetailRecord$ids$1")
    static final class c extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super List<? extends Long>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17357a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f17358b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ List<ExecutionDetailRecordBean> f17359c;

        c(e r3, List<ExecutionDetailRecordBean> r4, d.c.d<? super c> r5) {
            List<ExecutionDetailRecordBean> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17358b = r3;
            this.f17359c = r6;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super List<Long>> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f17358b, this.f17359c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super List<? extends Long>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17357a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L11:
            com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a r6 = (com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a.class, "com.obric.aiagent.plugin");
            if (r6 != null) goto L16;
            return null;
        L16:
            return r6.insert(this.f17359c);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            e r7 = this.f17358b;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17357a = 1;
            r5 = e.a(r7, r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ExecutionDetailRecordRepo.kt */
    @d.c.b.a.f(b = "ExecutionDetailRecordRepo.kt", c = {36}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.ExecutionDetailRecordRepo$getExecutionDetailRecord$2")
    static final class d extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super EventTaskExecutionDetailRecord>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17360a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f17361b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f17362c;

        d(e r3, long r4, d.c.d<? super d> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17361b = r3;
            this.f17362c = r4;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super EventTaskExecutionDetailRecord> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r5, d.c.d<?> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f17361b, this.f17362c, r7), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super EventTaskExecutionDetailRecord> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17360a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L11:
            com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a r6 = (com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L18;
            List<ExecutionDetailRecordBean> r7 = r6.a(p.a(d.c.b.a.b.a(this.f17362c)));
            if (r7 == null) goto L18;
            ExecutionDetailRecordBean r8 = (ExecutionDetailRecordBean) ZeusTransformUtils.preCheckCast(p.l(r7), ExecutionDetailRecordBean.class, "com.obric.aiagent.plugin");
            if (r8 == null) goto L18;
            return e.a(this.f17361b, r8);
        L18:
            return null;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            e r9 = this.f17361b;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17360a = 1;
            r5 = e.a(r9, r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ExecutionDetailRecordRepo.kt */
    @d.c.b.a.f(b = "ExecutionDetailRecordRepo.kt", c = {40}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.ExecutionDetailRecordRepo$getExecutionDetailRecords$2")
    static final class C0357e extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super List<? extends EventTaskExecutionDetailRecord>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17363a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f17364b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f17365c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f17366d;

        C0357e(e r3, int r4, int r5, d.c.d<? super C0357e> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17364b = r3;
            this.f17365c = r4;
            this.f17366d = r5;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super List<EventTaskExecutionDetailRecord>> r4) {
            return ((C0357e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0357e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new C0357e(this.f17364b, this.f17365c, this.f17366d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super List<? extends EventTaskExecutionDetailRecord>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17363a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L11:
            com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a r6 = (com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L20;
            List<ExecutionDetailRecordBean> r7 = r6.a(this.f17365c, this.f17366d);
            if (r7 == null) goto L20;
            Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin");
            e r4 = this.f17364b;
            Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r8, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r9 = r8.iterator();
        L17:
            if (r9.hasNext() == false) goto L23;
            r2.add(e.a(r4, (ExecutionDetailRecordBean) ZeusTransformUtils.preCheckCast(r9.next(), ExecutionDetailRecordBean.class, "com.obric.aiagent.plugin")));
            goto L17
        L23:
            return (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin");
        L20:
            return null;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            e r10 = this.f17364b;
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17363a = 1;
            r5 = e.a(r10, r3);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ExecutionDetailRecordRepo.kt */
    @d.c.b.a.f(b = "ExecutionDetailRecordRepo.kt", c = {44}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.ExecutionDetailRecordRepo$getExecutionDetailRecordsBySessionId$2")
    static final class f extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super List<? extends EventTaskExecutionDetailRecord>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17367a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f17368b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f17369c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f17370d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f17371e;

        f(e r3, String r4, int r5, int r6, d.c.d<? super f> r7) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17368b = r3;
            this.f17369c = r4;
            this.f17370d = r5;
            this.f17371e = r6;
            super(2, r8);
        }

        public final Object a(am r3, d.c.d<? super List<EventTaskExecutionDetailRecord>> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r8, d.c.d<?> r9) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new f(this.f17368b, this.f17369c, this.f17370d, this.f17371e, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super List<? extends EventTaskExecutionDetailRecord>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17367a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L11:
            com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a r6 = (com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L20;
            List<ExecutionDetailRecordBean> r7 = r6.a(this.f17369c, this.f17370d, this.f17371e);
            if (r7 == null) goto L20;
            Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin");
            e r4 = this.f17368b;
            Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r8, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r9 = r8.iterator();
        L17:
            if (r9.hasNext() == false) goto L23;
            r2.add(e.a(r4, (ExecutionDetailRecordBean) ZeusTransformUtils.preCheckCast(r9.next(), ExecutionDetailRecordBean.class, "com.obric.aiagent.plugin")));
            goto L17
        L23:
            return (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin");
        L20:
            return null;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            e r10 = this.f17368b;
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17367a = 1;
            r5 = e.a(r10, r3);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ExecutionDetailRecordRepo.kt */
    @d.c.b.a.f(b = "ExecutionDetailRecordRepo.kt", c = {92}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.ExecutionDetailRecordRepo$removeExecutionDetailRecordsById$2")
    static final class g extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super Integer>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17372a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f17373b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long[] f17374c;

        g(e r3, long[] r4, d.c.d<? super g> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17373b = r3;
            this.f17374c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super Integer> r4) {
            return ((g) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), g.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new g(this.f17373b, this.f17374c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Integer> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17372a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L11:
            com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a r6 = (com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L14;
            int r4 = r6.c(d.a.i.b(this.f17374c));
        L16:
            return d.c.b.a.b.a(r4);
        L14:
            r4 = 0;
            goto L16
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            e r7 = this.f17373b;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17372a = 1;
            r5 = e.a(r7, r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ExecutionDetailRecordRepo.kt */
    @d.c.b.a.f(b = "ExecutionDetailRecordRepo.kt", c = {96}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.ExecutionDetailRecordRepo$removeExecutionDetailRecordsBySessionId$2")
    static final class h extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super Integer>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17375a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f17376b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f17377c;

        h(e r3, String r4, d.c.d<? super h> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17376b = r3;
            this.f17377c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super Integer> r4) {
            return ((h) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new h(this.f17376b, this.f17377c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Integer> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17375a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L11:
            com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a r6 = (com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L14;
            int r4 = r6.a(this.f17377c);
        L16:
            return d.c.b.a.b.a(r4);
        L14:
            r4 = 0;
            goto L16
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            e r7 = this.f17376b;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17375a = 1;
            r5 = e.a(r7, r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ExecutionDetailRecordRepo.kt */
    @d.c.b.a.f(b = "ExecutionDetailRecordRepo.kt", c = {48, 62}, d = "updateExecutionDetailRecord", e = "com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.ExecutionDetailRecordRepo")
    static final class i extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f17378a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f17379b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f17380c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ e f17381d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f17382e;

        i(e r3, d.c.d<? super i> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17381d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f17380c = r3;
            this.f17382e |= Integer.MIN_VALUE;
            return this.f17381d.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ExecutionDetailRecordRepo.kt */
    @d.c.b.a.f(b = "ExecutionDetailRecordRepo.kt", c = {48}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.ExecutionDetailRecordRepo$updateExecutionDetailRecord$bean$1")
    static final class j extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super ExecutionDetailRecordBean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17383a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f17384b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ EventTaskExecutionDetailRecord f17385c;

        j(e r3, EventTaskExecutionDetailRecord r4, d.c.d<? super j> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17384b = r3;
            this.f17385c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super ExecutionDetailRecordBean> r4) {
            return ((j) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), j.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new j(this.f17384b, this.f17385c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super ExecutionDetailRecordBean> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17383a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L11:
            com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a r6 = (com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L16;
            List<ExecutionDetailRecordBean> r4 = r6.a(p.a(d.c.b.a.b.a(this.f17385c.getId())));
            if (r4 == null) goto L16;
            return (ExecutionDetailRecordBean) ZeusTransformUtils.preCheckCast(p.l(r4), ExecutionDetailRecordBean.class, "com.obric.aiagent.plugin");
        L16:
            return null;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            e r7 = this.f17384b;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17383a = 1;
            r5 = e.a(r7, r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ExecutionDetailRecordRepo.kt */
    @d.c.b.a.f(b = "ExecutionDetailRecordRepo.kt", c = {62}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.ExecutionDetailRecordRepo$updateExecutionDetailRecord$result$1")
    static final class k extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super Integer>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17386a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f17387b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ExecutionDetailRecordBean f17388c;

        k(e r3, ExecutionDetailRecordBean r4, d.c.d<? super k> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17387b = r3;
            this.f17388c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super Integer> r4) {
            return ((k) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), k.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new k(this.f17387b, this.f17388c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Integer> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17386a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L11:
            com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a r6 = (com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L14;
            int r4 = r6.update(this.f17388c);
        L16:
            return d.c.b.a.b.a(r4);
        L14:
            r4 = 0;
            goto L16
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            e r7 = this.f17387b;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17386a = 1;
            r5 = e.a(r7, r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ExecutionDetailRecordRepo.kt */
    @d.c.b.a.f(b = "ExecutionDetailRecordRepo.kt", c = {70, 87}, d = "updateExecutionDetailRecords", e = "com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.ExecutionDetailRecordRepo")
    static final class l extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f17389a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f17390b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f17391c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ e f17392d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f17393e;

        l(e r3, d.c.d<? super l> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17392d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f17391c = r3;
            this.f17393e |= Integer.MIN_VALUE;
            return this.f17392d.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ExecutionDetailRecordRepo.kt */
    @d.c.b.a.f(b = "ExecutionDetailRecordRepo.kt", c = {70}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.ExecutionDetailRecordRepo$updateExecutionDetailRecords$beans$1")
    static final class m extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super List<? extends ExecutionDetailRecordBean>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17394a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f17395b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ List<EventTaskExecutionDetailRecord> f17396c;

        m(e r3, List<EventTaskExecutionDetailRecord> r4, d.c.d<? super m> r5) {
            List<EventTaskExecutionDetailRecord> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17395b = r3;
            this.f17396c = r6;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super List<ExecutionDetailRecordBean>> r4) {
            return ((m) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), m.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new m(this.f17395b, this.f17396c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super List<? extends ExecutionDetailRecordBean>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17394a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L11:
            com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a r6 = (com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L18;
            Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(this.f17396c, Iterable.class, "com.obric.aiagent.plugin");
            Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r4, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r7 = r4.iterator();
        L15:
            if (r7.hasNext() == false) goto L21;
            r2.add(d.c.b.a.b.a(((EventTaskExecutionDetailRecord) ZeusTransformUtils.preCheckCast(r7.next(), EventTaskExecutionDetailRecord.class, "com.obric.aiagent.plugin")).getId()));
            goto L15
        L21:
            return r6.a((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin"));
        L18:
            return null;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            e r8 = this.f17395b;
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17394a = 1;
            r5 = e.a(r8, r3);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ExecutionDetailRecordRepo.kt */
    @d.c.b.a.f(b = "ExecutionDetailRecordRepo.kt", c = {87}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.ExecutionDetailRecordRepo$updateExecutionDetailRecords$result$1")
    static final class n extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super Integer>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17397a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f17398b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ List<ExecutionDetailRecordBean> f17399c;

        n(e r3, List<ExecutionDetailRecordBean> r4, d.c.d<? super n> r5) {
            List<ExecutionDetailRecordBean> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17398b = r3;
            this.f17399c = r6;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super Integer> r4) {
            return ((n) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), n.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new n(this.f17398b, this.f17399c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Integer> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17397a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L11:
            com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a r6 = (com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L14;
            int r4 = r6.b(this.f17399c);
        L16:
            return d.c.b.a.b.a(r4);
        L14:
            r4 = 0;
            goto L16
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            e r7 = this.f17398b;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17397a = 1;
            r5 = e.a(r7, r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    public e() {
        this.f17349a = an.a((d.c.g) ZeusTransformUtils.preCheckCast(com.obric.aiagent.executionengine.eventstaskmanager.common.a.f16677a.a(), d.c.g.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ EventTaskExecutionDetailRecord a(e r0, ExecutionDetailRecordBean r1) {
        return r0.a(r1);
    }

    public static final /* synthetic */ Object a(e r2, d.c.d r3) {
        return r2.a((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    private final Object a(d.c.d<? super com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a> r2) {
        d.c.d<? super com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a> r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.executionengine.eventstaskmanager.common.data.e.f16691a.h(r1);
    }

    public final Object a(String r24, List<EventTaskExecutionDetailRecord> r25, d.c.d<? super List<EventTaskExecutionDetailRecord>> r26) {
        e r0 = this;
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r25, List.class, "com.obric.aiagent.plugin");
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r26, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, a.class) == false) goto L7;
        a r4 = (a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.aiagent.plugin");
        if ((r4.f17353d & Integer.MIN_VALUE) == 0) goto L7;
        r4.f17353d -= Integer.MIN_VALUE;
    L8:
        Object r5 = r4.f17351b;
        Object r6 = d.c.a.b.a();
        int r7 = r4.f17353d;
        if (r7 == 0) goto L16;
        if (r7 == 1) goto L15;
        if (r7 != 2) goto L14;
        o.a(r5);
    L29:
        return r5;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r0 = (e) ZeusTransformUtils.preCheckCast(r4.f17350a, e.class, "com.obric.aiagent.plugin");
        o.a(r5);
    L23:
        List r2 = (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L26;
        return null;
    L26:
        au r8 = kotlinx.coroutines.i.b(r0.f17349a, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(r0, r2, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        r4.f17350a = null;
        r4.f17353d = 2;
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
        EventTaskExecutionDetailRecord r12 = (EventTaskExecutionDetailRecord) ZeusTransformUtils.preCheckCast(r11.next(), EventTaskExecutionDetailRecord.class, "com.obric.aiagent.plugin");
        r10.add(new ExecutionDetailRecordBean(r12.getSessionId(), r12.getExecTime(), r12.getPackageName(), r12.getAppName(), r12.getDetailText(), r12.getDetailType(), r12.getExt(), 0, 128, null));
        goto L18
    L20:
        au r13 = kotlinx.coroutines.i.b(r0.f17349a, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new c(r0, (List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.aiagent.plugin"), null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        r4.f17350a = r0;
        r4.f17353d = 1;
        r5 = r13.a(r4);
        if (r5 != r6) goto L23;
        return r6;
    L7:
        r4 = new a(r0, r3);
        goto L8
    }

    public final Object a(long r9, d.c.d<? super EventTaskExecutionDetailRecord> r11) {
        d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.b(this.f17349a, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new d(this, r9, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null).a(r12);
    }

    public final Object a(int r9, int r10, d.c.d<? super List<EventTaskExecutionDetailRecord>> r11) {
        d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.b(this.f17349a, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new C0357e(this, r9, r10, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null).a(r12);
    }

    public final Object a(String r10, int r11, int r12, d.c.d<? super List<EventTaskExecutionDetailRecord>> r13) {
        d.c.d r14 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.b(this.f17349a, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new f(this, r10, r11, r12, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null).a(r14);
    }

    public final Object a(EventTaskExecutionDetailRecord r30, d.c.d<? super EventTaskExecutionDetailRecord> r31) {
        e r0 = this;
        EventTaskExecutionDetailRecord r1 = r30;
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r31, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, i.class) == false) goto L7;
        i r5 = (i) ZeusTransformUtils.preCheckCast(r3, i.class, "com.obric.aiagent.plugin");
        if ((r5.f17382e & Integer.MIN_VALUE) == 0) goto L7;
        r5.f17382e -= Integer.MIN_VALUE;
    L8:
        Object r4 = r5.f17380c;
        Object r6 = d.c.a.b.a();
        int r7 = r5.f17382e;
        if (r7 == 0) goto L16;
        if (r7 == 1) goto L15;
        if (r7 != 2) goto L14;
        ExecutionDetailRecordBean r2 = (ExecutionDetailRecordBean) ZeusTransformUtils.preCheckCast(r5.f17379b, ExecutionDetailRecordBean.class, "com.obric.aiagent.plugin");
        e r8 = (e) ZeusTransformUtils.preCheckCast(r5.f17378a, e.class, "com.obric.aiagent.plugin");
        o.a(r4);
    L27:
        if (((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).intValue() > 0) goto L29;
        return null;
    L29:
        return r8.a(r2);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        EventTaskExecutionDetailRecord r9 = (EventTaskExecutionDetailRecord) ZeusTransformUtils.preCheckCast(r5.f17379b, EventTaskExecutionDetailRecord.class, "com.obric.aiagent.plugin");
        e r10 = (e) ZeusTransformUtils.preCheckCast(r5.f17378a, e.class, "com.obric.aiagent.plugin");
        o.a(r4);
        r1 = r9;
        r0 = r10;
    L20:
        if (((ExecutionDetailRecordBean) ZeusTransformUtils.preCheckCast(r4, ExecutionDetailRecordBean.class, "com.obric.aiagent.plugin")) != null) goto L22;
        return null;
    L22:
        ExecutionDetailRecordBean r11 = new ExecutionDetailRecordBean(r1.getSessionId(), r1.getExecTime(), r1.getPackageName(), r1.getAppName(), r1.getDetailText(), r1.getDetailType(), r1.getExt(), r1.getId());
        au r12 = kotlinx.coroutines.i.b(r0.f17349a, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new k(r0, r11, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        r5.f17378a = r0;
        r5.f17379b = r11;
        r5.f17382e = 2;
        r4 = r12.a(r5);
        if (r4 != r6) goto L25;
        return r6;
    L25:
        r8 = r0;
        r2 = r11;
        goto L27
    L16:
        o.a(r4);
        au r13 = kotlinx.coroutines.i.b(r0.f17349a, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new j(r0, r1, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        r5.f17378a = r0;
        r5.f17379b = r1;
        r5.f17382e = 1;
        r4 = r13.a(r5);
        if (r4 != r6) goto L20;
        return r6;
    L7:
        r5 = new i(r0, r3);
        goto L8
    }

    public final Object a(List<EventTaskExecutionDetailRecord> r25, d.c.d<? super Integer> r26) {
        e r0 = this;
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r25, List.class, "com.obric.aiagent.plugin");
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r26, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, l.class) == false) goto L7;
        l r4 = (l) ZeusTransformUtils.preCheckCast(r3, l.class, "com.obric.aiagent.plugin");
        if ((r4.f17393e & Integer.MIN_VALUE) == 0) goto L7;
        r4.f17393e -= Integer.MIN_VALUE;
    L8:
        Object r5 = r4.f17391c;
        Object r6 = d.c.a.b.a();
        int r7 = r4.f17393e;
        if (r7 == 0) goto L16;
        if (r7 == 1) goto L15;
        if (r7 != 2) goto L14;
        o.a(r5);
    L52:
        return d.c.b.a.b.a(((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.aiagent.plugin")).intValue());
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r1 = (List) ZeusTransformUtils.preCheckCast(r4.f17390b, List.class, "com.obric.aiagent.plugin");
        r0 = (e) ZeusTransformUtils.preCheckCast(r4.f17389a, e.class, "com.obric.aiagent.plugin");
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
        ExecutionDetailRecordBean r14 = (ExecutionDetailRecordBean) ZeusTransformUtils.preCheckCast(r13.next(), ExecutionDetailRecordBean.class, "com.obric.aiagent.plugin");
        Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L34:
        if (r15.hasNext() == false) goto L41;
        Object r16 = r15.next();
        if (((EventTaskExecutionDetailRecord) ZeusTransformUtils.preCheckCast(r16, EventTaskExecutionDetailRecord.class, "com.obric.aiagent.plugin")).getId() != r14.getId()) goto L38;
        boolean r17 = true;
    L39:
        if (r17 == false) goto L34;
    L42:
        EventTaskExecutionDetailRecord r18 = (EventTaskExecutionDetailRecord) ZeusTransformUtils.preCheckCast(r16, EventTaskExecutionDetailRecord.class, "com.obric.aiagent.plugin");
        if (r18 != null) goto L45;
        ExecutionDetailRecordBean r19 = null;
    L46:
        if (r19 == null) goto L31;
        r12.add(r19);
        goto L31
    L45:
        r19 = new ExecutionDetailRecordBean(r18.getSessionId(), r18.getExecTime(), r18.getPackageName(), r18.getAppName(), r18.getDetailText(), r18.getDetailType(), r18.getExt(), r18.getId());
        goto L46
    L38:
        r17 = false;
        goto L39
    L41:
        r16 = null;
        goto L42
    L48:
        au r2 = kotlinx.coroutines.i.b(r0.f17349a, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new n(r0, (List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.aiagent.plugin"), null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        r4.f17389a = null;
        r4.f17390b = null;
        r4.f17393e = 2;
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
        au r20 = kotlinx.coroutines.i.b(r0.f17349a, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new m(r0, r1, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        r4.f17389a = r0;
        r4.f17390b = r1;
        r4.f17393e = 1;
        r5 = r20.a(r4);
        if (r5 != r6) goto L19;
        return r6;
    L7:
        r4 = new l(r0, r3);
        goto L8
    }

    public final Object a(long[] r9, d.c.d<? super Integer> r10) {
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.b(this.f17349a, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new g(this, r9, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null).a(r11);
    }

    public final Object a(String r9, d.c.d<? super Integer> r10) {
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.b(this.f17349a, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new h(this, r9, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null).a(r11);
    }

    private final EventTaskExecutionDetailRecord a(ExecutionDetailRecordBean r12) {
        return new EventTaskExecutionDetailRecord(r12.getId(), r12.getSessionId(), r12.getExecTime(), r12.getPackageName(), r12.getAppName(), r12.getDetailText(), r12.getDetailType(), r12.getExt());
    }
}
