package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.b;

import com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.bean.ConditionTaskRecordBean;
import com.obric.event.task.base.report.j;
import com.obric.eventkit.task.model.ConditionTaskRecord;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.i;
import d.a.p;
import d.c.b.a.l;
import d.h.a.m;
import d.o;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;

/* JADX INFO: compiled from: ConditionTaskRecordRepo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final am f16922a;

    /* JADX INFO: renamed from: com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ConditionTaskRecordRepo.kt */
    @d.c.b.a.f(b = "ConditionTaskRecordRepo.kt", c = {27}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.repo.ConditionTaskRecordRepo$addConditionTaskRecord$2")
    static final class C0345a extends l implements m<am, d.c.d<? super Long>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16923a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f16924b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ConditionTaskRecordBean f16925c;

        C0345a(a r3, ConditionTaskRecordBean r4, d.c.d<? super C0345a> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16924b = r3;
            this.f16925c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super Long> r4) {
            return ((C0345a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0345a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new C0345a(this.f16924b, this.f16925c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Long> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f16923a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L11:
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d r6 = (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d.class, "com.obric.aiagent.plugin");
            if (r6 != null) goto L16;
            return null;
        L16:
            return d.c.b.a.b.a(r6.insert(this.f16925c));
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            a r7 = this.f16924b;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16923a = 1;
            r5 = a.a(r7, r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ConditionTaskRecordRepo.kt */
    @d.c.b.a.f(b = "ConditionTaskRecordRepo.kt", c = {34}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.repo.ConditionTaskRecordRepo$getLastTriggerTimeByTaskId$2")
    static final class b extends l implements m<am, d.c.d<? super Long>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16926a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f16927b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f16928c;

        b(a r3, String r4, d.c.d<? super b> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16927b = r3;
            this.f16928c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super Long> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f16927b, this.f16928c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Long> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f16926a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L11:
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d r6 = (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d.class, "com.obric.aiagent.plugin");
            if (r6 != null) goto L16;
            return null;
        L16:
            return r6.a(this.f16928c);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            a r7 = this.f16927b;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16926a = 1;
            r5 = a.a(r7, r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ConditionTaskRecordRepo.kt */
    @d.c.b.a.f(b = "ConditionTaskRecordRepo.kt", c = {62}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.repo.ConditionTaskRecordRepo$getRecordsByPackageName$2")
    static final class c extends l implements m<am, d.c.d<? super List<? extends ConditionTaskRecord>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16929a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f16930b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f16931c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f16932d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f16933e;

        c(a r3, long r4, long r6, String r8, d.c.d<? super c> r9) {
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16930b = r3;
            this.f16931c = r4;
            this.f16932d = r6;
            this.f16933e = r8;
            super(2, r10);
        }

        public final Object a(am r3, d.c.d<? super List<ConditionTaskRecord>> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r10, d.c.d<?> r11) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f16930b, this.f16931c, this.f16932d, this.f16933e, r8), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super List<? extends ConditionTaskRecord>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f16929a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r11);
        L11:
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d r4 = (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d) ZeusTransformUtils.preCheckCast(r11, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d.class, "com.obric.aiagent.plugin");
            if (r4 == null) goto L20;
            List<ConditionTaskRecordBean> r12 = r4.a(this.f16931c, this.f16932d, this.f16933e);
            if (r12 == null) goto L20;
            Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.aiagent.plugin");
            a r10 = this.f16930b;
            Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r13, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r14 = r13.iterator();
        L17:
            if (r14.hasNext() == false) goto L23;
            r2.add(a.a(r10, (ConditionTaskRecordBean) ZeusTransformUtils.preCheckCast(r14.next(), ConditionTaskRecordBean.class, "com.obric.aiagent.plugin")));
            goto L17
        L23:
            return (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin");
        L20:
            return null;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r11);
            a r15 = this.f16930b;
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16929a = 1;
            r11 = a.a(r15, r3);
            if (r11 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ConditionTaskRecordRepo.kt */
    @d.c.b.a.f(b = "ConditionTaskRecordRepo.kt", c = {47}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.repo.ConditionTaskRecordRepo$getRecordsByTaskIdAndPackageName$2")
    static final class d extends l implements m<am, d.c.d<? super List<? extends ConditionTaskRecord>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16934a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f16935b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f16936c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f16937d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f16938e;
        final /* synthetic */ String f;

        d(a r3, String r4, long r5, long r7, String r9, d.c.d<? super d> r10) {
            d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16935b = r3;
            this.f16936c = r4;
            this.f16937d = r5;
            this.f16938e = r7;
            this.f = r9;
            super(2, r11);
        }

        public final Object a(am r3, d.c.d<? super List<ConditionTaskRecord>> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r11, d.c.d<?> r12) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f16935b, this.f16936c, this.f16937d, this.f16938e, this.f, r9), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super List<? extends ConditionTaskRecord>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r12) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f16934a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r12);
        L11:
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d r4 = (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d) ZeusTransformUtils.preCheckCast(r12, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d.class, "com.obric.aiagent.plugin");
            if (r4 == null) goto L20;
            List<ConditionTaskRecordBean> r13 = r4.a(this.f16936c, this.f16937d, this.f16938e, this.f);
            if (r13 == null) goto L20;
            Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.aiagent.plugin");
            a r11 = this.f16935b;
            Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r14, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r15 = r14.iterator();
        L17:
            if (r15.hasNext() == false) goto L23;
            r2.add(a.a(r11, (ConditionTaskRecordBean) ZeusTransformUtils.preCheckCast(r15.next(), ConditionTaskRecordBean.class, "com.obric.aiagent.plugin")));
            goto L17
        L23:
            return (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin");
        L20:
            return null;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r12);
            a r16 = this.f16935b;
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16934a = 1;
            r12 = a.a(r16, r3);
            if (r12 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ConditionTaskRecordRepo.kt */
    @d.c.b.a.f(b = "ConditionTaskRecordRepo.kt", c = {78}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.repo.ConditionTaskRecordRepo$removeAllRecords$2")
    static final class e extends l implements m<am, d.c.d<? super Integer>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16939a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f16940b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f16941c;

        e(a r3, String r4, d.c.d<? super e> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16940b = r3;
            this.f16941c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super Integer> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f16940b, this.f16941c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Integer> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f16939a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L11:
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d r6 = (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L14;
            int r4 = r6.b(this.f16941c);
        L16:
            return d.c.b.a.b.a(r4);
        L14:
            r4 = 0;
            goto L16
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            a r7 = this.f16940b;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16939a = 1;
            r5 = a.a(r7, r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ConditionTaskRecordRepo.kt */
    @d.c.b.a.f(b = "ConditionTaskRecordRepo.kt", c = {74}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.repo.ConditionTaskRecordRepo$removeRecordsById$2")
    static final class f extends l implements m<am, d.c.d<? super Integer>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16942a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f16943b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long[] f16944c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f16945d;

        f(a r3, long[] r4, String r5, d.c.d<? super f> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16943b = r3;
            this.f16944c = r4;
            this.f16945d = r5;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super Integer> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new f(this.f16943b, this.f16944c, this.f16945d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Integer> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f16942a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L11:
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d r6 = (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L14;
            int r4 = r6.a(i.b(this.f16944c), this.f16945d);
        L16:
            return d.c.b.a.b.a(r4);
        L14:
            r4 = 0;
            goto L16
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            a r7 = this.f16943b;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16942a = 1;
            r5 = a.a(r7, r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ConditionTaskRecordRepo.kt */
    @d.c.b.a.f(b = "ConditionTaskRecordRepo.kt", c = {82}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.repo.ConditionTaskRecordRepo$removeRecordsByTaskId$2")
    static final class g extends l implements m<am, d.c.d<? super Integer>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16946a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f16947b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f16948c;

        g(a r3, String r4, d.c.d<? super g> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16947b = r3;
            this.f16948c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super Integer> r4) {
            return ((g) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), g.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new g(this.f16947b, this.f16948c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Integer> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f16946a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L11:
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d r6 = (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L14;
            int r4 = r6.c(this.f16948c);
        L16:
            return d.c.b.a.b.a(r4);
        L14:
            r4 = 0;
            goto L16
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            a r7 = this.f16947b;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16946a = 1;
            r5 = a.a(r7, r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    public a() {
        this.f16922a = an.a((d.c.g) ZeusTransformUtils.preCheckCast(com.obric.aiagent.executionengine.eventstaskmanager.common.a.f16677a.a(), d.c.g.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ ConditionTaskRecord a(a r0, ConditionTaskRecordBean r1) {
        return r0.a(r1);
    }

    public static final /* synthetic */ Object a(a r2, d.c.d r3) {
        return r2.a((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    private final Object a(d.c.d<? super com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d> r2) {
        d.c.d<? super com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d> r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.executionengine.eventstaskmanager.common.data.e.f16691a.d(r1);
    }

    public final Object a(String r17, long r18, String r20, int r21, long r22, d.c.d<? super x> r24) {
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r24, d.c.d.class, "com.obric.aiagent.plugin");
        if (r17 == null) goto L5;
        j.f32784a.a(r18, r20, r21, r22);
        ConditionTaskRecordBean r15 = new ConditionTaskRecordBean(r17, r18, r20, r21, 0, 0, 48, null);
        Object r0 = kotlinx.coroutines.i.b(this.f16922a, null, null, (m) ZeusTransformUtils.preCheckCast(new C0345a(this, r15, null), m.class, "com.obric.aiagent.plugin"), 3, null).a(r1);
        if (r0 != d.c.a.b.a()) goto L10;
        return r0;
    L10:
        return x.f38692a;
    L5:
        return x.f38692a;
    }

    public final Object a(String r9, d.c.d<? super Long> r10) {
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.b(this.f16922a, null, null, (m) ZeusTransformUtils.preCheckCast(new b(this, r9, null), m.class, "com.obric.aiagent.plugin"), 3, null).a(r11);
    }

    public final Object a(String r14, long r15, long r17, String r19, d.c.d<? super List<ConditionTaskRecord>> r20) {
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r20, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.b(this.f16922a, null, null, (m) ZeusTransformUtils.preCheckCast(new d(this, r19, r15, r17, r14, null), m.class, "com.obric.aiagent.plugin"), 3, null).a(r0);
    }

    public final Object a(String r13, long r14, long r16, d.c.d<? super List<ConditionTaskRecord>> r18) {
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r18, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.b(this.f16922a, null, null, (m) ZeusTransformUtils.preCheckCast(new c(this, r14, r16, r13, null), m.class, "com.obric.aiagent.plugin"), 3, null).a(r0);
    }

    public final Object a(String r9, long[] r10, d.c.d<? super Integer> r11) {
        d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.b(this.f16922a, null, null, (m) ZeusTransformUtils.preCheckCast(new f(this, r10, r9, null), m.class, "com.obric.aiagent.plugin"), 3, null).a(r12);
    }

    public final Object b(String r9, d.c.d<? super Integer> r10) {
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.b(this.f16922a, null, null, (m) ZeusTransformUtils.preCheckCast(new e(this, r9, null), m.class, "com.obric.aiagent.plugin"), 3, null).a(r11);
    }

    public final Object c(String r9, d.c.d<? super Integer> r10) {
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.b(this.f16922a, null, null, (m) ZeusTransformUtils.preCheckCast(new g(this, r9, null), m.class, "com.obric.aiagent.plugin"), 3, null).a(r11);
    }

    private final ConditionTaskRecord a(ConditionTaskRecordBean r9) {
        return new ConditionTaskRecord(r9.getId(), r9.getTaskId(), r9.getTriggerTime(), r9.getSourceFrom(), r9.getResult());
    }
}
