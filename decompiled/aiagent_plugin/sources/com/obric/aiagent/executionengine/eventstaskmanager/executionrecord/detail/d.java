package com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail;

import com.obric.eventkit.task.model.EventTaskExecutionDetailRecord;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.l;
import d.h.a.m;
import d.o;
import d.x;
import java.util.Collection;
import java.util.List;
import kotlinx.coroutines.am;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: ExecutionDetailRecordManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d {
    private static final String TAG = "ExecutionDetailRecordManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f17327a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.e f17328b = null;

    /* JADX INFO: compiled from: ExecutionDetailRecordManager.kt */
    @d.c.b.a.f(b = "ExecutionDetailRecordManager.kt", c = {20}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.ExecutionDetailRecordManager$addExecutionDetailRecord$result$1")
    static final class a extends l implements m<am, d.c.d<? super List<? extends EventTaskExecutionDetailRecord>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17329a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f17330b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ List<EventTaskExecutionDetailRecord> f17331c;

        a(String r3, List<EventTaskExecutionDetailRecord> r4, d.c.d<? super a> r5) {
            List<EventTaskExecutionDetailRecord> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17330b = r3;
            this.f17331c = r6;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super List<EventTaskExecutionDetailRecord>> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f17330b, this.f17331c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super List<? extends EventTaskExecutionDetailRecord>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17329a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r7);
        L11:
            return r7;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r7);
            com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.e r8 = d.a();
            String r2 = this.f17330b;
            List<EventTaskExecutionDetailRecord> r3 = this.f17331c;
            d.c.d<? super List<EventTaskExecutionDetailRecord>> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17329a = 1;
            r7 = r8.a(r2, r3, r4);
            if (r7 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ExecutionDetailRecordManager.kt */
    @d.c.b.a.f(b = "ExecutionDetailRecordManager.kt", c = {57}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.ExecutionDetailRecordManager$getEventTaskExecutionDetailRecordById$1")
    static final class b extends l implements m<am, d.c.d<? super EventTaskExecutionDetailRecord>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17332a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f17333b;

        b(long r3, d.c.d<? super b> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17333b = r3;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super EventTaskExecutionDetailRecord> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f17333b, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super EventTaskExecutionDetailRecord> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17332a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r7);
        L11:
            return r7;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r7);
            com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.e r8 = d.a();
            long r3 = this.f17333b;
            d.c.d<? super EventTaskExecutionDetailRecord> r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17332a = 1;
            r7 = r8.a(r3, r2);
            if (r7 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ExecutionDetailRecordManager.kt */
    @d.c.b.a.f(b = "ExecutionDetailRecordManager.kt", c = {36}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.ExecutionDetailRecordManager$getExecutionDetailRecords$1")
    static final class c extends l implements m<am, d.c.d<? super List<? extends EventTaskExecutionDetailRecord>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17334a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f17335b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f17336c;

        c(int r3, int r4, d.c.d<? super c> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17335b = r3;
            this.f17336c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super List<EventTaskExecutionDetailRecord>> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f17335b, this.f17336c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super List<? extends EventTaskExecutionDetailRecord>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17334a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r7);
        L11:
            return r7;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r7);
            com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.e r8 = d.a();
            int r2 = this.f17335b;
            int r3 = this.f17336c;
            d.c.d<? super List<EventTaskExecutionDetailRecord>> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17334a = 1;
            r7 = r8.a(r2, r3, r4);
            if (r7 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ExecutionDetailRecordManager.kt */
    @d.c.b.a.f(b = "ExecutionDetailRecordManager.kt", c = {49}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.ExecutionDetailRecordManager$getExecutionDetailRecordsBySessionId$1")
    static final class C0356d extends l implements m<am, d.c.d<? super List<? extends EventTaskExecutionDetailRecord>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17337a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f17338b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f17339c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f17340d;

        C0356d(String r3, int r4, int r5, d.c.d<? super C0356d> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17338b = r3;
            this.f17339c = r4;
            this.f17340d = r5;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super List<EventTaskExecutionDetailRecord>> r4) {
            return ((C0356d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0356d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new C0356d(this.f17338b, this.f17339c, this.f17340d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super List<? extends EventTaskExecutionDetailRecord>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17337a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r8);
        L11:
            return r8;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r8);
            com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.e r9 = d.a();
            String r2 = this.f17338b;
            int r3 = this.f17339c;
            int r4 = this.f17340d;
            d.c.d<? super List<EventTaskExecutionDetailRecord>> r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17337a = 1;
            r8 = r9.a(r2, r3, r4, r5);
            if (r8 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ExecutionDetailRecordManager.kt */
    @d.c.b.a.f(b = "ExecutionDetailRecordManager.kt", c = {86}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.ExecutionDetailRecordManager$removeExecutionDetailRecordsById$result$1")
    static final class e extends l implements m<am, d.c.d<? super Integer>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17341a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long[] f17342b;

        e(long[] r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17342b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super Integer> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f17342b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Integer> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17341a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L11:
            return r6;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.e r7 = d.a();
            long[] r2 = this.f17342b;
            d.c.d<? super Integer> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17341a = 1;
            r6 = r7.a(r2, r3);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ExecutionDetailRecordManager.kt */
    @d.c.b.a.f(b = "ExecutionDetailRecordManager.kt", c = {98}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.ExecutionDetailRecordManager$removeExecutionDetailRecordsBySessionId$result$1")
    static final class f extends l implements m<am, d.c.d<? super Integer>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17343a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f17344b;

        f(String r3, d.c.d<? super f> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17344b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super Integer> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new f(this.f17344b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Integer> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17343a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L11:
            return r6;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.e r7 = d.a();
            String r2 = this.f17344b;
            d.c.d<? super Integer> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17343a = 1;
            r6 = r7.a(r2, r3);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ExecutionDetailRecordManager.kt */
    @d.c.b.a.f(b = "ExecutionDetailRecordManager.kt", c = {65}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.ExecutionDetailRecordManager$updateEventTaskExecutionDetailRecord$result$1")
    static final class g extends l implements m<am, d.c.d<? super EventTaskExecutionDetailRecord>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17345a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ EventTaskExecutionDetailRecord f17346b;

        g(EventTaskExecutionDetailRecord r3, d.c.d<? super g> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17346b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super EventTaskExecutionDetailRecord> r4) {
            return ((g) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), g.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new g(this.f17346b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super EventTaskExecutionDetailRecord> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17345a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L11:
            return r6;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.e r7 = d.a();
            EventTaskExecutionDetailRecord r2 = this.f17346b;
            d.c.d<? super EventTaskExecutionDetailRecord> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17345a = 1;
            r6 = r7.a(r2, r3);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ExecutionDetailRecordManager.kt */
    @d.c.b.a.f(b = "ExecutionDetailRecordManager.kt", c = {77}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.ExecutionDetailRecordManager$updateEventTaskExecutionDetailRecords$result$1")
    static final class h extends l implements m<am, d.c.d<? super Integer>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17347a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ List<EventTaskExecutionDetailRecord> f17348b;

        h(List<EventTaskExecutionDetailRecord> r3, d.c.d<? super h> r4) {
            List<EventTaskExecutionDetailRecord> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17348b = r5;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super Integer> r4) {
            return ((h) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new h(this.f17348b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Integer> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17347a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L11:
            return r6;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.e r7 = d.a();
            List<EventTaskExecutionDetailRecord> r2 = this.f17348b;
            d.c.d<? super Integer> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17347a = 1;
            r6 = r7.a(r2, r3);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    private d() {
    }

    public static final /* synthetic */ com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.e a() {
        return f17328b;
    }

    static {
        f17327a = new d();
        f17328b = new com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.e();
    }

    public final List<EventTaskExecutionDetailRecord> a(String r4, List<EventTaskExecutionDetailRecord> r5) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "addExecutionDetailRecord " + r4);
        if (r4 != null) goto L5;
    L17:
        return null;
    L5:
        if (com.obric.aiagent.executionengine.eventstaskmanager.common.c.a(r4) == false) goto L17;
        if (r3 == null) goto L17;
        boolean r1 = true;
        List<EventTaskExecutionDetailRecord> r6 = (List) ZeusTransformUtils.preCheckCast(i.a(null, (m) ZeusTransformUtils.preCheckCast(new a(r4, r3, null), m.class, "com.obric.aiagent.plugin"), 1, null), List.class, "com.obric.aiagent.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L11;
    L14:
        if (r1 == true) goto L16;
        com.obric.aiagent.executionengine.eventstaskmanager.b.f16672a.a(r4, 8);
    L16:
        return r6;
    L11:
        if (r7.isEmpty() == true) goto L14;
        r1 = false;
        goto L14
    }

    public final List<EventTaskExecutionDetailRecord> a(String r3, int r4, int r5) {
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "getExecutionDetailRecords " + r3 + ' ' + r4 + ' ' + r5);
        if (r3 != null) goto L5;
        return null;
    L5:
        if (com.obric.aiagent.executionengine.eventstaskmanager.common.c.a(r3) == true) goto L8;
        return null;
    L8:
        return (List) ZeusTransformUtils.preCheckCast(i.a(null, (m) ZeusTransformUtils.preCheckCast(new c(r4, r5, null), m.class, "com.obric.aiagent.plugin"), 1, null), List.class, "com.obric.aiagent.plugin");
    }

    public final List<EventTaskExecutionDetailRecord> a(String r3, String r4, int r5, int r6) {
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "getEventTaskExecutionDetailRecordBySessionId " + r3 + ' ' + r4);
        if (r3 != null) goto L5;
        return null;
    L5:
        if (com.obric.aiagent.executionengine.eventstaskmanager.common.c.a(r3) == false) goto L11;
        if (r4 != null) goto L9;
        return null;
    L9:
        return (List) ZeusTransformUtils.preCheckCast(i.a(null, (m) ZeusTransformUtils.preCheckCast(new C0356d(r4, r5, r6, null), m.class, "com.obric.aiagent.plugin"), 1, null), List.class, "com.obric.aiagent.plugin");
    L11:
        return null;
    }

    public final EventTaskExecutionDetailRecord a(String r3, long r4) {
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "getEventTaskExecutionDetailRecordById " + r3);
        if (r3 != null) goto L5;
        return null;
    L5:
        if (com.obric.aiagent.executionengine.eventstaskmanager.common.c.a(r3) == true) goto L8;
        return null;
    L8:
        return (EventTaskExecutionDetailRecord) ZeusTransformUtils.preCheckCast(i.a(null, (m) ZeusTransformUtils.preCheckCast(new b(r4, null), m.class, "com.obric.aiagent.plugin"), 1, null), EventTaskExecutionDetailRecord.class, "com.obric.aiagent.plugin");
    }

    public final EventTaskExecutionDetailRecord a(String r3, EventTaskExecutionDetailRecord r4) {
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "updateEventTaskExecutionDetailRecord " + r3);
        EventTaskExecutionDetailRecord r2 = null;
        if (r3 != null) goto L5;
    L11:
        return r2;
    L5:
        if (com.obric.aiagent.executionengine.eventstaskmanager.common.c.a(r3) == false) goto L11;
        if (r4 == null) goto L11;
        r2 = (EventTaskExecutionDetailRecord) ZeusTransformUtils.preCheckCast(i.a(null, (m) ZeusTransformUtils.preCheckCast(new g(r4, null), m.class, "com.obric.aiagent.plugin"), 1, null), EventTaskExecutionDetailRecord.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L11;
        com.obric.aiagent.executionengine.eventstaskmanager.b.f16672a.a(r3, 8);
        goto L11
    }

    public final int b(String r4, List<EventTaskExecutionDetailRecord> r5) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "updateEventTaskExecutionDetailRecords " + r4);
        if (r4 != null) goto L5;
    L17:
        return 0;
    L5:
        if (com.obric.aiagent.executionengine.eventstaskmanager.common.c.a(r4) == false) goto L17;
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L9;
    L12:
        boolean r7 = true;
    L13:
        if (r7 == true) goto L17;
        return ((Number) ZeusTransformUtils.preCheckCast(i.a(null, (m) ZeusTransformUtils.preCheckCast(new h(r3, null), m.class, "com.obric.aiagent.plugin"), 1, null), Number.class, "com.obric.aiagent.plugin")).intValue();
    L9:
        if (r6.isEmpty() == true) goto L12;
        r7 = false;
        goto L13
    }

    public final int a(String r3, long[] r4) {
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "removeExecutionDetailRecordsById " + r3);
        if (r3 != null) goto L5;
        return 0;
    L5:
        if (com.obric.aiagent.executionengine.eventstaskmanager.common.c.a(r3) == false) goto L14;
        if (r4 == null) goto L15;
        int r2 = ((Number) ZeusTransformUtils.preCheckCast(i.a(null, (m) ZeusTransformUtils.preCheckCast(new e(r4, null), m.class, "com.obric.aiagent.plugin"), 1, null), Number.class, "com.obric.aiagent.plugin")).intValue();
        if (r2 <= 0) goto L11;
        com.obric.aiagent.executionengine.eventstaskmanager.b.f16672a.a(r3, 8);
    L11:
        return r2;
    L15:
        return 0;
    L14:
        return 0;
    }

    public final int a(String r3, String r4) {
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "removeExecutionDetailRecordsBySessionId " + r3 + ' ' + r4);
        if (r3 != null) goto L5;
        return 0;
    L5:
        if (com.obric.aiagent.executionengine.eventstaskmanager.common.c.a(r3) == false) goto L14;
        if (r4 == null) goto L15;
        int r2 = ((Number) ZeusTransformUtils.preCheckCast(i.a(null, (m) ZeusTransformUtils.preCheckCast(new f(r4, null), m.class, "com.obric.aiagent.plugin"), 1, null), Number.class, "com.obric.aiagent.plugin")).intValue();
        if (r2 <= 0) goto L11;
        com.obric.aiagent.executionengine.eventstaskmanager.b.f16672a.a(r3, 8);
    L11:
        return r2;
    L15:
        return 0;
    L14:
        return 0;
    }
}
