package com.obric.aiagent.executionengine.eventstaskmanager.spi;

import com.obric.eventkit.task.api.IEventTaskExecutionApi;
import com.obric.eventkit.task.model.ConditionTaskAction;
import com.obric.eventkit.task.model.TaskKnowledge;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.h;
import d.o;
import d.x;
import java.util.List;

/* JADX INFO: compiled from: EventTaskExecutionApiImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EventTaskExecutionApiImpl implements IEventTaskExecutionApi {
    public static final a Companion = null;
    private static final String TAG = "EventTaskExecutionApiImpl";

    /* JADX INFO: compiled from: EventTaskExecutionApiImpl.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: EventTaskExecutionApiImpl.kt */
    @f(b = "EventTaskExecutionApiImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.spi.EventTaskExecutionApiImpl$scheduleShortcutTask$2")
    static final class b extends l implements m<String, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17682a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f17683b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f17684c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f17685d;

        b(String r3, String r4, d.c.d<? super b> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17684c = r3;
            this.f17685d = r4;
            super(2, r6);
        }

        public final Object a(String r3, d.c.d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            b r0 = new b(this.f17684c, this.f17685d, r6);
            r0.f17683b = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(String r3, d.c.d<? super x> r4) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f17682a != 0) goto L11;
            o.a(r3);
            String r4 = (String) ZeusTransformUtils.preCheckCast(this.f17683b, String.class, "com.obric.aiagent.plugin");
            if (com.obric.aiagent.executionengine.eventstaskmanager.common.d.f16682a.a() == true) goto L8;
            com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.d(EventTaskExecutionApiImpl.TAG, "scheduleShortcutTask not enable");
            return x.f38692a;
        L8:
            com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.a.f17459a.a(r4, this.f17684c, this.f17685d);
            return x.f38692a;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: EventTaskExecutionApiImpl.kt */
    @f(b = "EventTaskExecutionApiImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.spi.EventTaskExecutionApiImpl$skipConditionTaskSchedule$2")
    static final class c extends l implements m<String, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17686a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f17687b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f17688c;

        c(String r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17688c = r3;
            super(2, r5);
        }

        public final Object a(String r3, d.c.d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            c r0 = new c(this.f17688c, r5);
            r0.f17687b = r3;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(String r3, d.c.d<? super x> r4) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f17686a != 0) goto L11;
            o.a(r3);
            String r4 = (String) ZeusTransformUtils.preCheckCast(this.f17687b, String.class, "com.obric.aiagent.plugin");
            if (com.obric.aiagent.executionengine.eventstaskmanager.common.d.f16682a.a() == true) goto L8;
            com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.d(EventTaskExecutionApiImpl.TAG, "skipConditionTaskSchedule not enable");
            return x.f38692a;
        L8:
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.f16741a.b(r4, this.f17688c);
            return x.f38692a;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: EventTaskExecutionApiImpl.kt */
    @f(b = "EventTaskExecutionApiImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.spi.EventTaskExecutionApiImpl$tryScheduleConditionTask$2")
    static final class d extends l implements m<String, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17689a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f17690b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f17691c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ List<ConditionTaskAction> f17692d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ TaskKnowledge f17693e;
        final /* synthetic */ int f;
        final /* synthetic */ String g;

        d(String r3, List<ConditionTaskAction> r4, TaskKnowledge r5, int r6, String r7, d.c.d<? super d> r8) {
            List<ConditionTaskAction> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17691c = r3;
            this.f17692d = r9;
            this.f17693e = r5;
            this.f = r6;
            this.g = r7;
            super(2, r10);
        }

        public final Object a(String r3, d.c.d<? super x> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r10, d.c.d<?> r11) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
            d r12 = new d(this.f17691c, this.f17692d, this.f17693e, this.f, this.g, r8);
            r12.f17690b = r10;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r12, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(String r3, d.c.d<? super x> r4) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            d.c.a.b.a();
            if (this.f17689a != 0) goto L11;
            o.a(r8);
            String r1 = (String) ZeusTransformUtils.preCheckCast(this.f17690b, String.class, "com.obric.aiagent.plugin");
            if (com.obric.aiagent.executionengine.eventstaskmanager.common.d.f16682a.a() == true) goto L8;
            com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.d(EventTaskExecutionApiImpl.TAG, "tryScheduleConditionTask not enable");
            return x.f38692a;
        L8:
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.f16741a.a(r1, this.f17691c, this.f17692d, this.f17693e, this.f, this.g);
            return x.f38692a;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new a(null);
    }

    public EventTaskExecutionApiImpl() {
    }

    @Override // com.obric.eventkit.task.api.IEventTaskExecutionApi
    public Object scheduleShortcutTask(String r3, String r4, d.c.d<? super x> r5) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        Object r6 = com.obric.aiagent.executionengine.eventstaskmanager.spi.a.a((m) ZeusTransformUtils.preCheckCast(new b(r3, r4, null), m.class, "com.obric.aiagent.plugin"), r2);
        if (r6 != d.c.a.b.a()) goto L6;
        return r6;
    L6:
        return x.f38692a;
    }

    @Override // com.obric.eventkit.task.api.IEventTaskExecutionApi
    public Object skipConditionTaskSchedule(String r3, d.c.d<? super x> r4) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        Object r5 = com.obric.aiagent.executionengine.eventstaskmanager.spi.a.a((m) ZeusTransformUtils.preCheckCast(new c(r3, null), m.class, "com.obric.aiagent.plugin"), r2);
        if (r5 != d.c.a.b.a()) goto L6;
        return r5;
    L6:
        return x.f38692a;
    }

    @Override // com.obric.eventkit.task.api.IEventTaskExecutionApi
    public Object tryScheduleConditionTask(String r9, List<ConditionTaskAction> r10, TaskKnowledge r11, int r12, String r13, d.c.d<? super x> r14) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
        Object r15 = com.obric.aiagent.executionengine.eventstaskmanager.spi.a.a((m) ZeusTransformUtils.preCheckCast(new d(r9, r3, r11, r12, r13, null), m.class, "com.obric.aiagent.plugin"), r8);
        if (r15 != d.c.a.b.a()) goto L6;
        return r15;
    L6:
        return x.f38692a;
    }
}
