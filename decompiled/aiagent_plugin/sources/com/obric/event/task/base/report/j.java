package com.obric.event.task.base.report;

import com.obric.aiagent.applog.IAppLog;
import com.obric.eventkit.task.model.ConditionTask;
import com.obric.eventkit.task.model.ConditionTaskResult;
import com.obric.eventkit.task.model.EventTask;
import com.obric.eventkit.task.model.EventTaskResult;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.br;
import kotlinx.coroutines.ca;
import org.json.JSONObject;

/* JADX INFO: compiled from: EventTaskTracer.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class j {
    private static final String TAG = "EventTaskTracer";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f32784a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final am f32785b = null;

    /* JADX INFO: compiled from: EventTaskTracer.kt */
    @d.c.b.a.f(b = "EventTaskTracer.kt", c = {}, d = "invokeSuspend", e = "com.obric.event.task.base.report.EventTaskTracer$traceAddConditionTaskResult$1")
    static final class a extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f32786a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ConditionTaskResult f32787b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f32788c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f32789d;

        a(ConditionTaskResult r3, String r4, long r5, d.c.d<? super a> r7) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f32787b = r3;
            this.f32788c = r4;
            this.f32789d = r5;
            super(2, r8);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r8, d.c.d<?> r9) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f32787b, this.f32788c, this.f32789d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            d.c.a.b.a();
            if (this.f32786a != 0) goto L19;
            d.o.a(r5);
            ConditionTaskResult r6 = this.f32787b;
            if (r6 == null) goto L17;
            String r0 = this.f32788c;
            long r1 = this.f32789d;
            JSONObject r4 = new JSONObject();
            r4.put("package_name", r0);
            r4.put("error_code", r6.getCode());
            r4.put("error_msg", r6.getMsg());
            if (r6.getCode() != 0) goto L13;
            List<ConditionTask> r7 = r6.getData();
            if (r7 == null) goto L11;
            int r8 = r7.size();
        L12:
            r4.put("task_count", r8);
            goto L13
        L11:
            r8 = 0;
        L13:
            r4.put("event_task_type", 2);
            r4.put("time_cost", r1);
            IAppLog r9 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
            if (r9 == null) goto L17;
            r9.reportToFlow("o_add_event_task", r4);
        L17:
            return x.f38692a;
        L19:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: EventTaskTracer.kt */
    @d.c.b.a.f(b = "EventTaskTracer.kt", c = {}, d = "invokeSuspend", e = "com.obric.event.task.base.report.EventTaskTracer$traceAddEventTaskExecutionRecords$1")
    static final class b extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f32790a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f32791b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f32792c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f32793d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f32794e;

        b(String r3, int r4, int r5, long r6, d.c.d<? super b> r8) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
            this.f32791b = r3;
            this.f32792c = r4;
            this.f32793d = r5;
            this.f32794e = r6;
            super(2, r9);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r9, d.c.d<?> r10) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f32791b, this.f32792c, this.f32793d, this.f32794e, r7), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f32790a != 0) goto L10;
            d.o.a(r3);
            JSONObject r4 = new JSONObject();
            r4.put("package_name", this.f32791b);
            r4.put("records_remove_size", this.f32792c - this.f32793d);
            r4.put("time_cost", this.f32794e);
            IAppLog r2 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L8;
            r2.reportToFlow("o_add_event_task_records", r4);
        L8:
            return x.f38692a;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: EventTaskTracer.kt */
    @d.c.b.a.f(b = "EventTaskTracer.kt", c = {}, d = "invokeSuspend", e = "com.obric.event.task.base.report.EventTaskTracer$traceAddEventTaskResult$1")
    static final class c extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f32795a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ EventTaskResult f32796b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f32797c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f32798d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f32799e;

        c(EventTaskResult r3, String r4, int r5, long r6, d.c.d<? super c> r8) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
            this.f32796b = r3;
            this.f32797c = r4;
            this.f32798d = r5;
            this.f32799e = r6;
            super(2, r9);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r9, d.c.d<?> r10) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f32796b, this.f32797c, this.f32798d, this.f32799e, r7), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            d.c.a.b.a();
            if (this.f32795a != 0) goto L19;
            d.o.a(r6);
            EventTaskResult r7 = this.f32796b;
            if (r7 == null) goto L17;
            String r0 = this.f32797c;
            int r1 = this.f32798d;
            long r2 = this.f32799e;
            JSONObject r5 = new JSONObject();
            r5.put("package_name", r0);
            r5.put("error_code", r7.getCode());
            r5.put("error_msg", r7.getMsg());
            if (r7.getCode() != 0) goto L13;
            List<EventTask> r8 = r7.getData();
            if (r8 == null) goto L11;
            int r9 = r8.size();
        L12:
            r5.put("task_count", r9);
            goto L13
        L11:
            r9 = 0;
        L13:
            r5.put("event_task_type", r1);
            r5.put("time_cost", r2);
            IAppLog r10 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
            if (r10 == null) goto L17;
            r10.reportToFlow("o_add_event_task", r5);
        L17:
            return x.f38692a;
        L19:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: EventTaskTracer.kt */
    @d.c.b.a.f(b = "EventTaskTracer.kt", c = {}, d = "invokeSuspend", e = "com.obric.event.task.base.report.EventTaskTracer$traceConditionTaskDoAction$1")
    static final class d extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f32800a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f32801b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f32802c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f32803d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f32804e;

        d(String r3, long r4, long r6, int r8, d.c.d<? super d> r9) {
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            this.f32801b = r3;
            this.f32802c = r4;
            this.f32803d = r6;
            this.f32804e = r8;
            super(2, r10);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r10, d.c.d<?> r11) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f32801b, this.f32802c, this.f32803d, this.f32804e, r8), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            d.c.a.b.a();
            if (this.f32800a != 0) goto L10;
            d.o.a(r4);
            JSONObject r5 = new JSONObject();
            r5.put("package_name", this.f32801b);
            r5.put("trigger_time", this.f32802c);
            r5.put("time_cost", this.f32803d);
            r5.put("error_code", this.f32804e);
            r5.put("event_task_type", 2);
            IAppLog r3 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
            if (r3 == null) goto L8;
            r3.reportToFlow("o_trigger_event_task", r5);
        L8:
            return x.f38692a;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: EventTaskTracer.kt */
    @d.c.b.a.f(b = "EventTaskTracer.kt", c = {}, d = "invokeSuspend", e = "com.obric.event.task.base.report.EventTaskTracer$traceDeleteConditionTaskResult$1")
    static final class e extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f32805a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ConditionTaskResult f32806b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f32807c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f32808d;

        e(ConditionTaskResult r3, String r4, long r5, d.c.d<? super e> r7) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f32806b = r3;
            this.f32807c = r4;
            this.f32808d = r5;
            super(2, r8);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r8, d.c.d<?> r9) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f32806b, this.f32807c, this.f32808d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            d.c.a.b.a();
            if (this.f32805a != 0) goto L19;
            d.o.a(r5);
            ConditionTaskResult r6 = this.f32806b;
            if (r6 == null) goto L17;
            String r0 = this.f32807c;
            long r1 = this.f32808d;
            JSONObject r4 = new JSONObject();
            r4.put("package_name", r0);
            r4.put("error_code", r6.getCode());
            r4.put("error_msg", r6.getMsg());
            if (r6.getCode() != 0) goto L13;
            List<ConditionTask> r7 = r6.getData();
            if (r7 == null) goto L11;
            int r8 = r7.size();
        L12:
            r4.put("task_count", r8);
            goto L13
        L11:
            r8 = 0;
        L13:
            r4.put("event_task_type", 2);
            r4.put("time_cost", r1);
            IAppLog r9 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
            if (r9 == null) goto L17;
            r9.reportToFlow("o_delete_event_task", r4);
        L17:
            return x.f38692a;
        L19:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: EventTaskTracer.kt */
    @d.c.b.a.f(b = "EventTaskTracer.kt", c = {}, d = "invokeSuspend", e = "com.obric.event.task.base.report.EventTaskTracer$traceDeleteEventTaskResult$1")
    static final class f extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f32809a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ EventTaskResult f32810b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f32811c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f32812d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f32813e;

        f(EventTaskResult r3, String r4, int r5, long r6, d.c.d<? super f> r8) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
            this.f32810b = r3;
            this.f32811c = r4;
            this.f32812d = r5;
            this.f32813e = r6;
            super(2, r9);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r9, d.c.d<?> r10) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new f(this.f32810b, this.f32811c, this.f32812d, this.f32813e, r7), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            d.c.a.b.a();
            if (this.f32809a != 0) goto L19;
            d.o.a(r6);
            EventTaskResult r7 = this.f32810b;
            if (r7 == null) goto L17;
            String r0 = this.f32811c;
            int r1 = this.f32812d;
            long r2 = this.f32813e;
            JSONObject r5 = new JSONObject();
            r5.put("package_name", r0);
            r5.put("error_code", r7.getCode());
            r5.put("error_msg", r7.getMsg());
            if (r7.getCode() != 0) goto L13;
            List<EventTask> r8 = r7.getData();
            if (r8 == null) goto L11;
            int r9 = r8.size();
        L12:
            r5.put("task_count", r9);
            goto L13
        L11:
            r9 = 0;
        L13:
            r5.put("event_task_type", r1);
            r5.put("time_cost", r2);
            IAppLog r10 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
            if (r10 == null) goto L17;
            r10.reportToFlow("o_delete_event_task", r5);
        L17:
            return x.f38692a;
        L19:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: EventTaskTracer.kt */
    @d.c.b.a.f(b = "EventTaskTracer.kt", c = {}, d = "invokeSuspend", e = "com.obric.event.task.base.report.EventTaskTracer$traceEventTaskDoAction$1")
    static final class g extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f32814a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f32815b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f32816c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f32817d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f32818e;
        final /* synthetic */ int f;

        g(String r3, long r4, long r6, int r8, int r9, d.c.d<? super g> r10) {
            d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            this.f32815b = r3;
            this.f32816c = r4;
            this.f32817d = r6;
            this.f32818e = r8;
            this.f = r9;
            super(2, r11);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((g) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), g.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r11, d.c.d<?> r12) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new g(this.f32815b, this.f32816c, this.f32817d, this.f32818e, this.f, r9), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            d.c.a.b.a();
            if (this.f32814a != 0) goto L10;
            d.o.a(r4);
            JSONObject r5 = new JSONObject();
            r5.put("package_name", this.f32815b);
            r5.put("trigger_time", this.f32816c);
            r5.put("time_cost", this.f32817d);
            r5.put("error_code", this.f32818e);
            r5.put("event_task_type", this.f);
            IAppLog r3 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
            if (r3 == null) goto L8;
            r3.reportToFlow("o_trigger_event_task", r5);
        L8:
            return x.f38692a;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: EventTaskTracer.kt */
    @d.c.b.a.f(b = "EventTaskTracer.kt", c = {}, d = "invokeSuspend", e = "com.obric.event.task.base.report.EventTaskTracer$traceRemoveAllConditionTaskRecord$1")
    static final class h extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f32819a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f32820b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f32821c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f32822d;

        h(String r3, int r4, long r5, d.c.d<? super h> r7) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f32820b = r3;
            this.f32821c = r4;
            this.f32822d = r5;
            super(2, r8);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((h) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r8, d.c.d<?> r9) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new h(this.f32820b, this.f32821c, this.f32822d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f32819a != 0) goto L10;
            d.o.a(r3);
            JSONObject r4 = new JSONObject();
            r4.put("package_name", this.f32820b);
            r4.put("records_remove_size", this.f32821c);
            r4.put("time_cost", this.f32822d);
            r4.put("event_task_type", 2);
            IAppLog r2 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L8;
            r2.reportToFlow("o_delete_all_event_task_records", r4);
        L8:
            return x.f38692a;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: EventTaskTracer.kt */
    @d.c.b.a.f(b = "EventTaskTracer.kt", c = {}, d = "invokeSuspend", e = "com.obric.event.task.base.report.EventTaskTracer$traceRemoveAllEventTaskRecords$1")
    static final class i extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f32823a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f32824b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f32825c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f32826d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f32827e;

        i(String r3, int r4, int r5, long r6, d.c.d<? super i> r8) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
            this.f32824b = r3;
            this.f32825c = r4;
            this.f32826d = r5;
            this.f32827e = r6;
            super(2, r9);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((i) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), i.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r9, d.c.d<?> r10) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new i(this.f32824b, this.f32825c, this.f32826d, this.f32827e, r7), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f32823a != 0) goto L10;
            d.o.a(r3);
            JSONObject r4 = new JSONObject();
            r4.put("package_name", this.f32824b);
            r4.put("records_remove_size", this.f32825c);
            r4.put("event_task_type", this.f32826d);
            r4.put("time_cost", this.f32827e);
            IAppLog r2 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L8;
            r2.reportToFlow("o_delete_all_event_task_records", r4);
        L8:
            return x.f38692a;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.event.task.base.report.j$j, reason: collision with other inner class name */
    /* JADX INFO: compiled from: EventTaskTracer.kt */
    @d.c.b.a.f(b = "EventTaskTracer.kt", c = {}, d = "invokeSuspend", e = "com.obric.event.task.base.report.EventTaskTracer$traceRemoveConditionTaskRecordById$1")
    static final class C0900j extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f32828a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f32829b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f32830c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f32831d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f32832e;

        C0900j(String r3, int r4, int r5, long r6, d.c.d<? super C0900j> r8) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
            this.f32829b = r3;
            this.f32830c = r4;
            this.f32831d = r5;
            this.f32832e = r6;
            super(2, r9);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((C0900j) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0900j.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r9, d.c.d<?> r10) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new C0900j(this.f32829b, this.f32830c, this.f32831d, this.f32832e, r7), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f32828a != 0) goto L10;
            d.o.a(r3);
            JSONObject r4 = new JSONObject();
            r4.put("package_name", this.f32829b);
            r4.put("records_remove_size", this.f32830c - this.f32831d);
            r4.put("time_cost", this.f32832e);
            r4.put("event_task_type", 2);
            IAppLog r2 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L8;
            r2.reportToFlow("o_delete_event_task_records", r4);
        L8:
            return x.f38692a;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: EventTaskTracer.kt */
    @d.c.b.a.f(b = "EventTaskTracer.kt", c = {}, d = "invokeSuspend", e = "com.obric.event.task.base.report.EventTaskTracer$traceRemoveEventTaskExecutionRecordsById$1")
    static final class k extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f32833a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f32834b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f32835c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f32836d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f32837e;

        k(String r3, int r4, int r5, long r6, d.c.d<? super k> r8) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
            this.f32834b = r3;
            this.f32835c = r4;
            this.f32836d = r5;
            this.f32837e = r6;
            super(2, r9);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((k) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), k.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r9, d.c.d<?> r10) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new k(this.f32834b, this.f32835c, this.f32836d, this.f32837e, r7), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f32833a != 0) goto L10;
            d.o.a(r3);
            JSONObject r4 = new JSONObject();
            r4.put("package_name", this.f32834b);
            r4.put("records_remove_size", this.f32835c - this.f32836d);
            r4.put("time_cost", this.f32837e);
            IAppLog r2 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L8;
            r2.reportToFlow("o_delete_event_task_records", r4);
        L8:
            return x.f38692a;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: EventTaskTracer.kt */
    @d.c.b.a.f(b = "EventTaskTracer.kt", c = {}, d = "invokeSuspend", e = "com.obric.event.task.base.report.EventTaskTracer$traceRemoveEventTaskExecutionRecordsByTaskId$1")
    static final class l extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f32838a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f32839b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f32840c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f32841d;

        l(String r3, boolean r4, long r5, d.c.d<? super l> r7) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f32839b = r3;
            this.f32840c = r4;
            this.f32841d = r5;
            super(2, r8);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((l) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), l.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r8, d.c.d<?> r9) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new l(this.f32839b, this.f32840c, this.f32841d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f32838a != 0) goto L10;
            d.o.a(r3);
            JSONObject r4 = new JSONObject();
            r4.put("package_name", this.f32839b);
            r4.put("records_remove_size", !this.f32840c ? 1 : 0);
            r4.put("time_cost", this.f32841d);
            IAppLog r2 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L8;
            r2.reportToFlow("o_delete_event_task_records", r4);
        L8:
            return x.f38692a;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: EventTaskTracer.kt */
    @d.c.b.a.f(b = "EventTaskTracer.kt", c = {}, d = "invokeSuspend", e = "com.obric.event.task.base.report.EventTaskTracer$traceRemoveEventTaskRecordsById$1")
    static final class m extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f32842a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f32843b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f32844c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f32845d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f32846e;
        final /* synthetic */ long f;

        m(String r3, int r4, int r5, int r6, long r7, d.c.d<? super m> r9) {
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            this.f32843b = r3;
            this.f32844c = r4;
            this.f32845d = r5;
            this.f32846e = r6;
            this.f = r7;
            super(2, r10);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((m) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), m.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r10, d.c.d<?> r11) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new m(this.f32843b, this.f32844c, this.f32845d, this.f32846e, this.f, r8), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f32842a != 0) goto L10;
            d.o.a(r3);
            JSONObject r4 = new JSONObject();
            r4.put("package_name", this.f32843b);
            r4.put("records_remove_size", this.f32844c - this.f32845d);
            r4.put("event_task_type", this.f32846e);
            r4.put("time_cost", this.f);
            IAppLog r2 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L8;
            r2.reportToFlow("o_delete_event_task_records", r4);
        L8:
            return x.f38692a;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: EventTaskTracer.kt */
    @d.c.b.a.f(b = "EventTaskTracer.kt", c = {}, d = "invokeSuspend", e = "com.obric.event.task.base.report.EventTaskTracer$traceUpdateConditionTaskResult$1")
    static final class n extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f32847a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ConditionTaskResult f32848b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f32849c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f32850d;

        n(ConditionTaskResult r3, String r4, long r5, d.c.d<? super n> r7) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f32848b = r3;
            this.f32849c = r4;
            this.f32850d = r5;
            super(2, r8);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((n) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), n.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r8, d.c.d<?> r9) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new n(this.f32848b, this.f32849c, this.f32850d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            d.c.a.b.a();
            if (this.f32847a != 0) goto L19;
            d.o.a(r5);
            ConditionTaskResult r6 = this.f32848b;
            if (r6 == null) goto L17;
            String r0 = this.f32849c;
            long r1 = this.f32850d;
            JSONObject r4 = new JSONObject();
            r4.put("package_name", r0);
            r4.put("error_code", r6.getCode());
            r4.put("error_msg", r6.getMsg());
            if (r6.getCode() != 0) goto L13;
            List<ConditionTask> r7 = r6.getData();
            if (r7 == null) goto L11;
            int r8 = r7.size();
        L12:
            r4.put("task_count", r8);
            goto L13
        L11:
            r8 = 0;
        L13:
            r4.put("event_task_type", 2);
            r4.put("time_cost", r1);
            IAppLog r9 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
            if (r9 == null) goto L17;
            r9.reportToFlow("o_update_event_task", r4);
        L17:
            return x.f38692a;
        L19:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: EventTaskTracer.kt */
    @d.c.b.a.f(b = "EventTaskTracer.kt", c = {}, d = "invokeSuspend", e = "com.obric.event.task.base.report.EventTaskTracer$traceUpdateEventTaskExecutionRecord$1")
    static final class o extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f32851a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f32852b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f32853c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f32854d;

        o(String r3, boolean r4, long r5, d.c.d<? super o> r7) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f32852b = r3;
            this.f32853c = r4;
            this.f32854d = r5;
            super(2, r8);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((o) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), o.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r8, d.c.d<?> r9) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new o(this.f32852b, this.f32853c, this.f32854d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f32851a != 0) goto L10;
            d.o.a(r3);
            JSONObject r4 = new JSONObject();
            r4.put("package_name", this.f32852b);
            r4.put("update_success", this.f32853c);
            r4.put("time_cost", this.f32854d);
            IAppLog r2 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L8;
            r2.reportToFlow("o_update_event_task_record", r4);
        L8:
            return x.f38692a;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: EventTaskTracer.kt */
    @d.c.b.a.f(b = "EventTaskTracer.kt", c = {}, d = "invokeSuspend", e = "com.obric.event.task.base.report.EventTaskTracer$traceUpdateEventTaskResult$1")
    static final class p extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f32855a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ EventTaskResult f32856b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f32857c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f32858d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f32859e;

        p(EventTaskResult r3, String r4, int r5, long r6, d.c.d<? super p> r8) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
            this.f32856b = r3;
            this.f32857c = r4;
            this.f32858d = r5;
            this.f32859e = r6;
            super(2, r9);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((p) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), p.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r9, d.c.d<?> r10) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new p(this.f32856b, this.f32857c, this.f32858d, this.f32859e, r7), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            d.c.a.b.a();
            if (this.f32855a != 0) goto L19;
            d.o.a(r6);
            EventTaskResult r7 = this.f32856b;
            if (r7 == null) goto L17;
            String r0 = this.f32857c;
            int r1 = this.f32858d;
            long r2 = this.f32859e;
            JSONObject r5 = new JSONObject();
            r5.put("package_name", r0);
            r5.put("error_code", r7.getCode());
            r5.put("error_msg", r7.getMsg());
            if (r7.getCode() != 0) goto L13;
            List<EventTask> r8 = r7.getData();
            if (r8 == null) goto L11;
            int r9 = r8.size();
        L12:
            r5.put("task_count", r9);
            goto L13
        L11:
            r9 = 0;
        L13:
            r5.put("event_task_type", r1);
            r5.put("time_cost", r2);
            IAppLog r10 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
            if (r10 == null) goto L17;
            r10.reportToFlow("o_update_event_task", r5);
        L17:
            return x.f38692a;
        L19:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: lambda$yireC6Izw0cOWthh-yrw_qdANbQ, reason: not valid java name */
    public static /* synthetic */ Thread m943lambda$yireC6Izw0cOWthhyrw_qdANbQ(Runnable r0) {
        return a(r0);
    }

    private j() {
    }

    static {
        f32784a = new j();
        ExecutorService r0 = Executors.newSingleThreadExecutor($$Lambda$j$yireC6Izw0cOWthhyrw_qdANbQ.INSTANCE);
        d.h.b.o.c(r0, "newSingleThreadExecutor(...)");
        f32785b = an.a((d.c.g) ZeusTransformUtils.preCheckCast(br.a(r0), d.c.g.class, "com.obric.aiagent.plugin"));
    }

    private static final Thread a(Runnable r2) {
        return new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin"), "eventTracer-dispatcher");
    }

    public final ca a(String r10, ConditionTaskResult r11, long r12) {
        return kotlinx.coroutines.i.a(f32785b, (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new a(r11, r10, r12, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
    }

    public final ca b(String r10, ConditionTaskResult r11, long r12) {
        return kotlinx.coroutines.i.a(f32785b, (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new e(r11, r10, r12, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
    }

    public final ca c(String r10, ConditionTaskResult r11, long r12) {
        return kotlinx.coroutines.i.a(f32785b, (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new n(r11, r10, r12, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
    }

    public final ca a(String r11, int r12, int r13, long r14) {
        return kotlinx.coroutines.i.a(f32785b, (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new C0900j(r11, r12, r13, r14, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
    }

    public final ca a(String r10, int r11, long r12) {
        return kotlinx.coroutines.i.a(f32785b, (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new h(r10, r11, r12, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
    }

    public final ca a(long r13, String r15, int r16, long r17) {
        return kotlinx.coroutines.i.a(f32785b, (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new d(r15, r13, r17, r16, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
    }

    public final ca a(long r14, String r16, int r17, int r18, long r19) {
        return kotlinx.coroutines.i.a(f32785b, (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new g(r16, r14, r19, r17, r18, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
    }

    public final ca a(String r11, EventTaskResult r12, int r13, long r14) {
        return kotlinx.coroutines.i.a(f32785b, (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new c(r12, r11, r13, r14, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
    }

    public final ca b(String r11, EventTaskResult r12, int r13, long r14) {
        return kotlinx.coroutines.i.a(f32785b, (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new f(r12, r11, r13, r14, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
    }

    public final ca c(String r11, EventTaskResult r12, int r13, long r14) {
        return kotlinx.coroutines.i.a(f32785b, (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new p(r12, r11, r13, r14, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
    }

    public final ca a(String r13, int r14, int r15, int r16, long r17) {
        return kotlinx.coroutines.i.a(f32785b, (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new m(r13, r14, r16, r15, r17, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
    }

    public final ca b(String r11, int r12, int r13, long r14) {
        return kotlinx.coroutines.i.a(f32785b, (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new i(r11, r12, r13, r14, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
    }

    public final ca c(String r11, int r12, int r13, long r14) {
        return kotlinx.coroutines.i.a(f32785b, (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(r11, r12, r13, r14, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
    }

    public final ca a(String r10, boolean r11, long r12) {
        return kotlinx.coroutines.i.a(f32785b, (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new o(r10, r11, r12, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
    }

    public final ca d(String r11, int r12, int r13, long r14) {
        return kotlinx.coroutines.i.a(f32785b, (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new k(r11, r13, r12, r14, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
    }

    public final ca b(String r10, boolean r11, long r12) {
        return kotlinx.coroutines.i.a(f32785b, (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new l(r10, r11, r12, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
    }
}
