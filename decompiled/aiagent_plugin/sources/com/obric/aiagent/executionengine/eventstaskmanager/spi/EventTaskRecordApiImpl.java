package com.obric.aiagent.executionengine.eventstaskmanager.spi;

import android.os.SystemClock;
import com.obric.eventkit.task.api.IEventTaskRecordApi;
import com.obric.eventkit.task.model.ConditionTaskRecord;
import com.obric.eventkit.task.model.ConditionTaskRecordV2;
import com.obric.eventkit.task.model.EventTaskExecutionDetailRecord;
import com.obric.eventkit.task.model.EventTaskExecutionRecord;
import com.obric.eventkit.task.model.EventTaskRecord;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: EventTaskRecordApiImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EventTaskRecordApiImpl implements IEventTaskRecordApi {
    public static final a Companion = null;
    private static final String TAG = "EventTaskRecordApiImpl";

    /* JADX INFO: compiled from: EventTaskRecordApiImpl.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: EventTaskRecordApiImpl.kt */
    @d.c.b.a.f(b = "EventTaskRecordApiImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.spi.EventTaskRecordApiImpl$addExecutionDetailRecords$2")
    static final class b extends d.c.b.a.l implements d.h.a.m<String, d.c.d<? super List<? extends EventTaskExecutionDetailRecord>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17694a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f17695b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ EventTaskRecordApiImpl f17696c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ List<EventTaskExecutionDetailRecord> f17697d;

        b(EventTaskRecordApiImpl r3, List<EventTaskExecutionDetailRecord> r4, d.c.d<? super b> r5) {
            List<EventTaskExecutionDetailRecord> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17696c = r3;
            this.f17697d = r6;
            super(2, r7);
        }

        public final Object a(String r3, d.c.d<? super List<EventTaskExecutionDetailRecord>> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            b r0 = new b(this.f17696c, this.f17697d, r6);
            r0.f17695b = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(String r3, d.c.d<? super List<? extends EventTaskExecutionDetailRecord>> r4) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            d.c.a.b.a();
            if (this.f17694a != 0) goto L17;
            d.o.a(r8);
            String r1 = (String) ZeusTransformUtils.preCheckCast(this.f17695b, String.class, "com.obric.aiagent.plugin");
            if (com.obric.aiagent.executionengine.eventstaskmanager.common.d.f16682a.a() == false) goto L7;
            long r2 = SystemClock.elapsedRealtime();
            List<EventTaskExecutionDetailRecord> r9 = com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.d.f17327a.a(r1, this.f17697d);
            com.obric.event.task.base.report.j r0 = com.obric.event.task.base.report.j.f32784a;
            List<EventTaskExecutionDetailRecord> r7 = this.f17697d;
            int r4 = 0;
            if (r7 == null) goto L11;
            int r10 = r7.size();
        L12:
            if (r9 == null) goto L14;
            r4 = r9.size();
        L14:
            r0.c(r1, r10, r4, SystemClock.elapsedRealtime() - r2);
            return r9;
        L11:
            r10 = 0;
            goto L12
        L7:
            return EventTaskRecordApiImpl.access$disabled(this.f17696c, "addExecutionDetailRecords");
        L17:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: EventTaskRecordApiImpl.kt */
    @d.c.b.a.f(b = "EventTaskRecordApiImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.spi.EventTaskRecordApiImpl$addExecutionRecords$2")
    static final class c extends d.c.b.a.l implements d.h.a.m<String, d.c.d<? super List<? extends EventTaskExecutionRecord>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17698a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f17699b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ EventTaskRecordApiImpl f17700c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ List<EventTaskExecutionRecord> f17701d;

        c(EventTaskRecordApiImpl r3, List<EventTaskExecutionRecord> r4, d.c.d<? super c> r5) {
            List<EventTaskExecutionRecord> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17700c = r3;
            this.f17701d = r6;
            super(2, r7);
        }

        public final Object a(String r3, d.c.d<? super List<EventTaskExecutionRecord>> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            c r0 = new c(this.f17700c, this.f17701d, r6);
            r0.f17699b = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(String r3, d.c.d<? super List<? extends EventTaskExecutionRecord>> r4) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            d.c.a.b.a();
            if (this.f17698a != 0) goto L17;
            d.o.a(r8);
            String r1 = (String) ZeusTransformUtils.preCheckCast(this.f17699b, String.class, "com.obric.aiagent.plugin");
            if (com.obric.aiagent.executionengine.eventstaskmanager.common.d.f16682a.a() == false) goto L7;
            long r2 = SystemClock.elapsedRealtime();
            List<EventTaskExecutionRecord> r9 = com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.d.f17292a.a(r1, this.f17701d);
            com.obric.event.task.base.report.j r0 = com.obric.event.task.base.report.j.f32784a;
            List<EventTaskExecutionRecord> r7 = this.f17701d;
            int r4 = 0;
            if (r7 == null) goto L11;
            int r10 = r7.size();
        L12:
            if (r9 == null) goto L14;
            r4 = r9.size();
        L14:
            r0.c(r1, r10, r4, SystemClock.elapsedRealtime() - r2);
            return r9;
        L11:
            r10 = 0;
            goto L12
        L7:
            return EventTaskRecordApiImpl.access$disabled(this.f17700c, "addExecutionRecords");
        L17:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: EventTaskRecordApiImpl.kt */
    @d.c.b.a.f(b = "EventTaskRecordApiImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.spi.EventTaskRecordApiImpl$getAllConditionTaskRecords$2")
    static final class d extends d.c.b.a.l implements d.h.a.m<String, d.c.d<? super List<? extends ConditionTaskRecord>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17702a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f17703b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ EventTaskRecordApiImpl f17704c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f17705d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f17706e;

        d(EventTaskRecordApiImpl r3, long r4, long r6, d.c.d<? super d> r8) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17704c = r3;
            this.f17705d = r4;
            this.f17706e = r6;
            super(2, r9);
        }

        public final Object a(String r3, d.c.d<? super List<ConditionTaskRecord>> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r10, d.c.d<?> r11) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
            d r12 = new d(this.f17704c, this.f17705d, this.f17706e, r8);
            r12.f17703b = r10;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r12, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(String r3, d.c.d<? super List<? extends ConditionTaskRecord>> r4) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            d.c.a.b.a();
            if (this.f17702a != 0) goto L10;
            d.o.a(r9);
            String r3 = (String) ZeusTransformUtils.preCheckCast(this.f17703b, String.class, "com.obric.aiagent.plugin");
            if (com.obric.aiagent.executionengine.eventstaskmanager.common.d.f16682a.a() == true) goto L8;
            return (List) ZeusTransformUtils.preCheckCast(EventTaskRecordApiImpl.access$disabled(this.f17704c, "getAllConditionTaskRecords"), List.class, "com.obric.aiagent.plugin");
        L8:
            return com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.f16741a.a(r3, this.f17705d, this.f17706e);
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: EventTaskRecordApiImpl.kt */
    @d.c.b.a.f(b = "EventTaskRecordApiImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.spi.EventTaskRecordApiImpl$getAllEventTaskRecords$2")
    static final class e extends d.c.b.a.l implements d.h.a.m<String, d.c.d<? super List<? extends EventTaskRecord>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17707a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f17708b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ EventTaskRecordApiImpl f17709c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f17710d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f17711e;
        final /* synthetic */ long f;

        e(EventTaskRecordApiImpl r3, int r4, long r5, long r7, d.c.d<? super e> r9) {
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17709c = r3;
            this.f17710d = r4;
            this.f17711e = r5;
            this.f = r7;
            super(2, r10);
        }

        public final Object a(String r3, d.c.d<? super List<? extends EventTaskRecord>> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r11, d.c.d<?> r12) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
            e r13 = new e(this.f17709c, this.f17710d, this.f17711e, this.f, r9);
            r13.f17708b = r11;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r13, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(String r3, d.c.d<? super List<? extends EventTaskRecord>> r4) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r12) {
            d.c.a.b.a();
            if (this.f17707a != 0) goto L23;
            d.o.a(r12);
            String r3 = (String) ZeusTransformUtils.preCheckCast(this.f17708b, String.class, "com.obric.aiagent.plugin");
            if (com.obric.aiagent.executionengine.eventstaskmanager.common.d.f16682a.a() == false) goto L7;
            int r13 = this.f17710d;
            if (r13 != 2) goto L11;
            List<ConditionTaskRecord> r11 = com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.f16741a.a(r3, this.f17711e, this.f);
            if (r11 == null) goto L26;
            Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.aiagent.plugin");
            Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r14, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r16 = r14.iterator();
        L18:
            if (r16.hasNext() == false) goto L21;
            ConditionTaskRecord r0 = (ConditionTaskRecord) ZeusTransformUtils.preCheckCast(r16.next(), ConditionTaskRecord.class, "com.obric.aiagent.plugin");
            r15.add(new ConditionTaskRecordV2(r0.getId(), r0.getTaskId(), r0.getTriggerTime(), r0.getSourceFrom(), r0.getResult()));
            goto L18
        L21:
            return (List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.aiagent.plugin");
        L26:
            return null;
        L11:
            if (r13 == 3) goto L25;
            return null;
        L25:
            return com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.a.f17459a.a(r3, this.f17711e, this.f);
        L7:
            return EventTaskRecordApiImpl.access$disabled(this.f17709c, "getAllEventTaskRecords");
        L23:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: EventTaskRecordApiImpl.kt */
    @d.c.b.a.f(b = "EventTaskRecordApiImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.spi.EventTaskRecordApiImpl$getConditionTaskRecordsByTaskId$2")
    static final class f extends d.c.b.a.l implements d.h.a.m<String, d.c.d<? super List<? extends ConditionTaskRecord>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17712a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f17713b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ EventTaskRecordApiImpl f17714c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f17715d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f17716e;
        final /* synthetic */ String f;

        f(EventTaskRecordApiImpl r3, long r4, long r6, String r8, d.c.d<? super f> r9) {
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17714c = r3;
            this.f17715d = r4;
            this.f17716e = r6;
            this.f = r8;
            super(2, r10);
        }

        public final Object a(String r3, d.c.d<? super List<ConditionTaskRecord>> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r11, d.c.d<?> r12) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
            f r13 = new f(this.f17714c, this.f17715d, this.f17716e, this.f, r9);
            r13.f17713b = r11;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r13, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(String r3, d.c.d<? super List<? extends ConditionTaskRecord>> r4) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            d.c.a.b.a();
            if (this.f17712a != 0) goto L10;
            d.o.a(r10);
            String r3 = (String) ZeusTransformUtils.preCheckCast(this.f17713b, String.class, "com.obric.aiagent.plugin");
            if (com.obric.aiagent.executionengine.eventstaskmanager.common.d.f16682a.a() == true) goto L8;
            return (List) ZeusTransformUtils.preCheckCast(EventTaskRecordApiImpl.access$disabled(this.f17714c, "getConditionTaskRecordsByTaskId"), List.class, "com.obric.aiagent.plugin");
        L8:
            return com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.f16741a.a(r3, this.f17715d, this.f17716e, this.f);
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: EventTaskRecordApiImpl.kt */
    @d.c.b.a.f(b = "EventTaskRecordApiImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.spi.EventTaskRecordApiImpl$getEventTaskRecordsByTaskId$2")
    static final class g extends d.c.b.a.l implements d.h.a.m<String, d.c.d<? super List<? extends EventTaskRecord>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17717a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f17718b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ EventTaskRecordApiImpl f17719c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f17720d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f17721e;
        final /* synthetic */ long f;

        g(EventTaskRecordApiImpl r3, String r4, long r5, long r7, d.c.d<? super g> r9) {
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17719c = r3;
            this.f17720d = r4;
            this.f17721e = r5;
            this.f = r7;
            super(2, r10);
        }

        public final Object a(String r3, d.c.d<? super List<? extends EventTaskRecord>> r4) {
            return ((g) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), g.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r11, d.c.d<?> r12) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
            g r13 = new g(this.f17719c, this.f17720d, this.f17721e, this.f, r9);
            r13.f17718b = r11;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r13, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(String r3, d.c.d<? super List<? extends EventTaskRecord>> r4) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r12) {
            d.c.a.b.a();
            if (this.f17717a != 0) goto L22;
            d.o.a(r12);
            String r3 = (String) ZeusTransformUtils.preCheckCast(this.f17718b, String.class, "com.obric.aiagent.plugin");
            if (com.obric.aiagent.executionengine.eventstaskmanager.common.d.f16682a.a() == true) goto L9;
            return EventTaskRecordApiImpl.access$disabled(this.f17719c, "getEventTaskRecordsByTaskId");
        L9:
            if (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.f16741a.l(this.f17720d) == false) goto L18;
            List<ConditionTaskRecord> r11 = com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.f16741a.a(r3, this.f17721e, this.f, this.f17720d);
            if (r11 == null) goto L24;
            Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.aiagent.plugin");
            Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r13, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r15 = r13.iterator();
        L14:
            if (r15.hasNext() == false) goto L25;
            ConditionTaskRecord r0 = (ConditionTaskRecord) ZeusTransformUtils.preCheckCast(r15.next(), ConditionTaskRecord.class, "com.obric.aiagent.plugin");
            r14.add(new ConditionTaskRecordV2(r0.getId(), r0.getTaskId(), r0.getTriggerTime(), r0.getSourceFrom(), r0.getResult()));
            goto L14
        L25:
            return (List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.aiagent.plugin");
        L24:
            return null;
        L18:
            if (com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.a.f17459a.a(this.f17720d) == true) goto L20;
            return null;
        L20:
            return com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.a.f17459a.a(r3, this.f17721e, this.f, this.f17720d);
        L22:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: EventTaskRecordApiImpl.kt */
    @d.c.b.a.f(b = "EventTaskRecordApiImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.spi.EventTaskRecordApiImpl$getExecutionDetailRecordById$2")
    static final class h extends d.c.b.a.l implements d.h.a.m<String, d.c.d<? super EventTaskExecutionDetailRecord>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17722a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f17723b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ EventTaskRecordApiImpl f17724c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f17725d;

        h(EventTaskRecordApiImpl r3, long r4, d.c.d<? super h> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17724c = r3;
            this.f17725d = r4;
            super(2, r7);
        }

        public final Object a(String r3, d.c.d<? super EventTaskExecutionDetailRecord> r4) {
            return ((h) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r6, d.c.d<?> r7) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            h r0 = new h(this.f17724c, this.f17725d, r8);
            r0.f17723b = r6;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(String r3, d.c.d<? super EventTaskExecutionDetailRecord> r4) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            d.c.a.b.a();
            if (this.f17722a != 0) goto L10;
            d.o.a(r4);
            String r5 = (String) ZeusTransformUtils.preCheckCast(this.f17723b, String.class, "com.obric.aiagent.plugin");
            if (com.obric.aiagent.executionengine.eventstaskmanager.common.d.f16682a.a() == true) goto L8;
            return (EventTaskExecutionDetailRecord) ZeusTransformUtils.preCheckCast(EventTaskRecordApiImpl.access$disabled(this.f17724c, "getExecutionDetailRecordById"), EventTaskExecutionDetailRecord.class, "com.obric.aiagent.plugin");
        L8:
            return com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.d.f17327a.a(r5, this.f17725d);
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: EventTaskRecordApiImpl.kt */
    @d.c.b.a.f(b = "EventTaskRecordApiImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.spi.EventTaskRecordApiImpl$getExecutionDetailRecords$2")
    static final class i extends d.c.b.a.l implements d.h.a.m<String, d.c.d<? super List<? extends EventTaskExecutionDetailRecord>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17726a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f17727b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ EventTaskRecordApiImpl f17728c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f17729d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f17730e;

        i(EventTaskRecordApiImpl r3, int r4, int r5, d.c.d<? super i> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17728c = r3;
            this.f17729d = r4;
            this.f17730e = r5;
            super(2, r7);
        }

        public final Object a(String r3, d.c.d<? super List<EventTaskExecutionDetailRecord>> r4) {
            return ((i) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), i.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r5, d.c.d<?> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            i r0 = new i(this.f17728c, this.f17729d, this.f17730e, r7);
            r0.f17727b = r5;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(String r3, d.c.d<? super List<? extends EventTaskExecutionDetailRecord>> r4) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f17726a != 0) goto L10;
            d.o.a(r3);
            String r4 = (String) ZeusTransformUtils.preCheckCast(this.f17727b, String.class, "com.obric.aiagent.plugin");
            if (com.obric.aiagent.executionengine.eventstaskmanager.common.d.f16682a.a() == true) goto L8;
            return (List) ZeusTransformUtils.preCheckCast(EventTaskRecordApiImpl.access$disabled(this.f17728c, "getExecutionDetailRecords"), List.class, "com.obric.aiagent.plugin");
        L8:
            return com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.d.f17327a.a(r4, this.f17729d, this.f17730e);
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: EventTaskRecordApiImpl.kt */
    @d.c.b.a.f(b = "EventTaskRecordApiImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.spi.EventTaskRecordApiImpl$getExecutionDetailRecordsBySessionId$2")
    static final class j extends d.c.b.a.l implements d.h.a.m<String, d.c.d<? super List<? extends EventTaskExecutionDetailRecord>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17731a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f17732b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ EventTaskRecordApiImpl f17733c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f17734d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f17735e;
        final /* synthetic */ int f;

        j(EventTaskRecordApiImpl r3, String r4, int r5, int r6, d.c.d<? super j> r7) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17733c = r3;
            this.f17734d = r4;
            this.f17735e = r5;
            this.f = r6;
            super(2, r8);
        }

        public final Object a(String r3, d.c.d<? super List<EventTaskExecutionDetailRecord>> r4) {
            return ((j) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), j.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r9, d.c.d<?> r10) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            j r11 = new j(this.f17733c, this.f17734d, this.f17735e, this.f, r7);
            r11.f17732b = r9;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r11, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(String r3, d.c.d<? super List<? extends EventTaskExecutionDetailRecord>> r4) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            d.c.a.b.a();
            if (this.f17731a != 0) goto L10;
            d.o.a(r4);
            String r5 = (String) ZeusTransformUtils.preCheckCast(this.f17732b, String.class, "com.obric.aiagent.plugin");
            if (com.obric.aiagent.executionengine.eventstaskmanager.common.d.f16682a.a() == true) goto L8;
            return (List) ZeusTransformUtils.preCheckCast(EventTaskRecordApiImpl.access$disabled(this.f17733c, "getExecutionDetailRecordsBySessionId"), List.class, "com.obric.aiagent.plugin");
        L8:
            return com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.d.f17327a.a(r5, this.f17734d, this.f17735e, this.f);
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: EventTaskRecordApiImpl.kt */
    @d.c.b.a.f(b = "EventTaskRecordApiImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.spi.EventTaskRecordApiImpl$getExecutionRecordById$2")
    static final class k extends d.c.b.a.l implements d.h.a.m<String, d.c.d<? super EventTaskExecutionRecord>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17736a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f17737b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ EventTaskRecordApiImpl f17738c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f17739d;

        k(EventTaskRecordApiImpl r3, long r4, d.c.d<? super k> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17738c = r3;
            this.f17739d = r4;
            super(2, r7);
        }

        public final Object a(String r3, d.c.d<? super EventTaskExecutionRecord> r4) {
            return ((k) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), k.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r6, d.c.d<?> r7) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            k r0 = new k(this.f17738c, this.f17739d, r8);
            r0.f17737b = r6;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(String r3, d.c.d<? super EventTaskExecutionRecord> r4) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            d.c.a.b.a();
            if (this.f17736a != 0) goto L10;
            d.o.a(r4);
            String r5 = (String) ZeusTransformUtils.preCheckCast(this.f17737b, String.class, "com.obric.aiagent.plugin");
            if (com.obric.aiagent.executionengine.eventstaskmanager.common.d.f16682a.a() == true) goto L8;
            return (EventTaskExecutionRecord) ZeusTransformUtils.preCheckCast(EventTaskRecordApiImpl.access$disabled(this.f17738c, "getExecutionRecordById"), EventTaskExecutionRecord.class, "com.obric.aiagent.plugin");
        L8:
            return com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.d.f17292a.a(r5, this.f17739d);
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: EventTaskRecordApiImpl.kt */
    @d.c.b.a.f(b = "EventTaskRecordApiImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.spi.EventTaskRecordApiImpl$getExecutionRecords$2")
    static final class l extends d.c.b.a.l implements d.h.a.m<String, d.c.d<? super List<? extends EventTaskExecutionRecord>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17740a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f17741b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ EventTaskRecordApiImpl f17742c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f17743d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f17744e;

        l(EventTaskRecordApiImpl r3, int r4, int r5, d.c.d<? super l> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17742c = r3;
            this.f17743d = r4;
            this.f17744e = r5;
            super(2, r7);
        }

        public final Object a(String r3, d.c.d<? super List<EventTaskExecutionRecord>> r4) {
            return ((l) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), l.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r5, d.c.d<?> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            l r0 = new l(this.f17742c, this.f17743d, this.f17744e, r7);
            r0.f17741b = r5;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(String r3, d.c.d<? super List<? extends EventTaskExecutionRecord>> r4) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f17740a != 0) goto L10;
            d.o.a(r3);
            String r4 = (String) ZeusTransformUtils.preCheckCast(this.f17741b, String.class, "com.obric.aiagent.plugin");
            if (com.obric.aiagent.executionengine.eventstaskmanager.common.d.f16682a.a() == true) goto L8;
            return (List) ZeusTransformUtils.preCheckCast(EventTaskRecordApiImpl.access$disabled(this.f17742c, "getExecutionRecords"), List.class, "com.obric.aiagent.plugin");
        L8:
            return com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.d.f17292a.a(r4, this.f17743d, this.f17744e);
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: EventTaskRecordApiImpl.kt */
    @d.c.b.a.f(b = "EventTaskRecordApiImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.spi.EventTaskRecordApiImpl$getExecutionRecordsByTaskId$2")
    static final class m extends d.c.b.a.l implements d.h.a.m<String, d.c.d<? super List<? extends EventTaskExecutionRecord>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17745a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f17746b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ EventTaskRecordApiImpl f17747c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f17748d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f17749e;
        final /* synthetic */ int f;

        m(EventTaskRecordApiImpl r3, String r4, int r5, int r6, d.c.d<? super m> r7) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17747c = r3;
            this.f17748d = r4;
            this.f17749e = r5;
            this.f = r6;
            super(2, r8);
        }

        public final Object a(String r3, d.c.d<? super List<EventTaskExecutionRecord>> r4) {
            return ((m) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), m.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r9, d.c.d<?> r10) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            m r11 = new m(this.f17747c, this.f17748d, this.f17749e, this.f, r7);
            r11.f17746b = r9;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r11, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(String r3, d.c.d<? super List<? extends EventTaskExecutionRecord>> r4) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            d.c.a.b.a();
            if (this.f17745a != 0) goto L10;
            d.o.a(r4);
            String r5 = (String) ZeusTransformUtils.preCheckCast(this.f17746b, String.class, "com.obric.aiagent.plugin");
            if (com.obric.aiagent.executionengine.eventstaskmanager.common.d.f16682a.a() == true) goto L8;
            return (List) ZeusTransformUtils.preCheckCast(EventTaskRecordApiImpl.access$disabled(this.f17747c, "getExecutionRecordsByTaskId"), List.class, "com.obric.aiagent.plugin");
        L8:
            return com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.d.f17292a.a(r5, this.f17748d, this.f17749e, this.f);
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: EventTaskRecordApiImpl.kt */
    @d.c.b.a.f(b = "EventTaskRecordApiImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.spi.EventTaskRecordApiImpl$removeAllConditionTaskRecords$2")
    static final class n extends d.c.b.a.l implements d.h.a.m<String, d.c.d<? super Integer>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17750a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f17751b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ EventTaskRecordApiImpl f17752c;

        n(EventTaskRecordApiImpl r3, d.c.d<? super n> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17752c = r3;
            super(2, r5);
        }

        public final Object a(String r3, d.c.d<? super Integer> r4) {
            return ((n) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), n.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            n r0 = new n(this.f17752c, r5);
            r0.f17751b = r3;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(String r3, d.c.d<? super Integer> r4) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            d.c.a.b.a();
            if (this.f17750a != 0) goto L11;
            d.o.a(r6);
            String r7 = (String) ZeusTransformUtils.preCheckCast(this.f17751b, String.class, "com.obric.aiagent.plugin");
            if (com.obric.aiagent.executionengine.eventstaskmanager.common.d.f16682a.a() == false) goto L7;
            long r0 = SystemClock.elapsedRealtime();
            int r5 = com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.f16741a.d(r7);
            com.obric.event.task.base.report.j.f32784a.a(r7, r5, SystemClock.elapsedRealtime() - r0);
            return d.c.b.a.b.a(r5);
        L7:
            return d.c.b.a.b.a(EventTaskRecordApiImpl.access$disabledCount(this.f17752c, "removeAllConditionTaskRecords"));
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: EventTaskRecordApiImpl.kt */
    @d.c.b.a.f(b = "EventTaskRecordApiImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.spi.EventTaskRecordApiImpl$removeAllEventTaskRecords$2")
    static final class o extends d.c.b.a.l implements d.h.a.m<String, d.c.d<? super Integer>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17753a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f17754b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ EventTaskRecordApiImpl f17755c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f17756d;

        o(EventTaskRecordApiImpl r3, int r4, d.c.d<? super o> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17755c = r3;
            this.f17756d = r4;
            super(2, r6);
        }

        public final Object a(String r3, d.c.d<? super Integer> r4) {
            return ((o) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), o.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            o r0 = new o(this.f17755c, this.f17756d, r6);
            r0.f17754b = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(String r3, d.c.d<? super Integer> r4) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            d.c.a.b.a();
            if (this.f17753a != 0) goto L18;
            d.o.a(r7);
            String r1 = (String) ZeusTransformUtils.preCheckCast(this.f17754b, String.class, "com.obric.aiagent.plugin");
            if (com.obric.aiagent.executionengine.eventstaskmanager.common.d.f16682a.a() == false) goto L7;
            long r2 = SystemClock.elapsedRealtime();
            int r8 = this.f17756d;
            if (r8 != 2) goto L11;
            int r9 = com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.f16741a.d(r1);
        L15:
            com.obric.event.task.base.report.j r0 = com.obric.event.task.base.report.j.f32784a;
            int r6 = this.f17756d;
            long r4 = SystemClock.elapsedRealtime() - r2;
            r0.b(r1, r9, r6, r4);
            return d.c.b.a.b.a(r9);
        L11:
            if (r8 == 3) goto L13;
            r9 = 0;
            goto L15
        L13:
            r9 = com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.a.f17459a.e(r1);
            goto L15
        L7:
            return d.c.b.a.b.a(EventTaskRecordApiImpl.access$disabledCount(this.f17755c, "removeAllEventTaskRecords"));
        L18:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: EventTaskRecordApiImpl.kt */
    @d.c.b.a.f(b = "EventTaskRecordApiImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.spi.EventTaskRecordApiImpl$removeConditionTaskRecordsById$2")
    static final class p extends d.c.b.a.l implements d.h.a.m<String, d.c.d<? super Integer>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17757a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f17758b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ EventTaskRecordApiImpl f17759c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ long[] f17760d;

        p(EventTaskRecordApiImpl r3, long[] r4, d.c.d<? super p> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17759c = r3;
            this.f17760d = r4;
            super(2, r6);
        }

        public final Object a(String r3, d.c.d<? super Integer> r4) {
            return ((p) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), p.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            p r0 = new p(this.f17759c, this.f17760d, r6);
            r0.f17758b = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(String r3, d.c.d<? super Integer> r4) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            d.c.a.b.a();
            if (this.f17757a != 0) goto L15;
            d.o.a(r7);
            String r1 = (String) ZeusTransformUtils.preCheckCast(this.f17758b, String.class, "com.obric.aiagent.plugin");
            if (com.obric.aiagent.executionengine.eventstaskmanager.common.d.f16682a.a() == false) goto L7;
            long r2 = SystemClock.elapsedRealtime();
            int r8 = com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.f16741a.a(r1, this.f17760d);
            com.obric.event.task.base.report.j r0 = com.obric.event.task.base.report.j.f32784a;
            long[] r6 = this.f17760d;
            if (r6 == null) goto L11;
            int r9 = r6.length;
        L12:
            long r4 = SystemClock.elapsedRealtime() - r2;
            r0.a(r1, r9, r8, r4);
            return d.c.b.a.b.a(r8);
        L11:
            r9 = 0;
            goto L12
        L7:
            return d.c.b.a.b.a(EventTaskRecordApiImpl.access$disabledCount(this.f17759c, "removeConditionTaskRecordsById"));
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: EventTaskRecordApiImpl.kt */
    @d.c.b.a.f(b = "EventTaskRecordApiImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.spi.EventTaskRecordApiImpl$removeEventTaskRecordsById$2")
    static final class q extends d.c.b.a.l implements d.h.a.m<String, d.c.d<? super Integer>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17761a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f17762b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ EventTaskRecordApiImpl f17763c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f17764d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ long[] f17765e;

        q(EventTaskRecordApiImpl r3, int r4, long[] r5, d.c.d<? super q> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17763c = r3;
            this.f17764d = r4;
            this.f17765e = r5;
            super(2, r7);
        }

        public final Object a(String r3, d.c.d<? super Integer> r4) {
            return ((q) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), q.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r5, d.c.d<?> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            q r0 = new q(this.f17763c, this.f17764d, this.f17765e, r7);
            r0.f17762b = r5;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(String r3, d.c.d<? super Integer> r4) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            d.c.a.b.a();
            if (this.f17761a != 0) goto L21;
            d.o.a(r8);
            String r1 = (String) ZeusTransformUtils.preCheckCast(this.f17762b, String.class, "com.obric.aiagent.plugin");
            if (com.obric.aiagent.executionengine.eventstaskmanager.common.d.f16682a.a() == false) goto L7;
            long r2 = SystemClock.elapsedRealtime();
            int r9 = this.f17764d;
            int r4 = 0;
            if (r9 != 2) goto L11;
            int r10 = com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.f16741a.a(r1, this.f17765e);
        L15:
            com.obric.event.task.base.report.j r0 = com.obric.event.task.base.report.j.f32784a;
            long[] r5 = this.f17765e;
            if (r5 == null) goto L18;
            r4 = r5.length;
        L18:
            r0.a(r1, r4, this.f17764d, r10, SystemClock.elapsedRealtime() - r2);
            return d.c.b.a.b.a(r10);
        L11:
            if (r9 == 3) goto L13;
            r10 = 0;
            goto L15
        L13:
            r10 = com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.a.f17459a.a(r1, this.f17765e);
            goto L15
        L7:
            return d.c.b.a.b.a(EventTaskRecordApiImpl.access$disabledCount(this.f17763c, "removeEventTaskRecordsById"));
        L21:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: EventTaskRecordApiImpl.kt */
    @d.c.b.a.f(b = "EventTaskRecordApiImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.spi.EventTaskRecordApiImpl$removeExecutionDetailRecordsById$2")
    static final class r extends d.c.b.a.l implements d.h.a.m<String, d.c.d<? super Integer>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17766a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f17767b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ EventTaskRecordApiImpl f17768c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ long[] f17769d;

        r(EventTaskRecordApiImpl r3, long[] r4, d.c.d<? super r> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17768c = r3;
            this.f17769d = r4;
            super(2, r6);
        }

        public final Object a(String r3, d.c.d<? super Integer> r4) {
            return ((r) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), r.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            r r0 = new r(this.f17768c, this.f17769d, r6);
            r0.f17767b = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(String r3, d.c.d<? super Integer> r4) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            d.c.a.b.a();
            if (this.f17766a != 0) goto L15;
            d.o.a(r7);
            String r1 = (String) ZeusTransformUtils.preCheckCast(this.f17767b, String.class, "com.obric.aiagent.plugin");
            if (com.obric.aiagent.executionengine.eventstaskmanager.common.d.f16682a.a() == false) goto L7;
            long r2 = SystemClock.elapsedRealtime();
            int r8 = com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.d.f17327a.a(r1, this.f17769d);
            com.obric.event.task.base.report.j r0 = com.obric.event.task.base.report.j.f32784a;
            long[] r6 = this.f17769d;
            if (r6 == null) goto L11;
            int r9 = r6.length;
        L12:
            int r3 = r9;
            r0.d(r1, r8, r3, SystemClock.elapsedRealtime() - r2);
            return d.c.b.a.b.a(r8);
        L11:
            r9 = 0;
            goto L12
        L7:
            return d.c.b.a.b.a(EventTaskRecordApiImpl.access$disabledCount(this.f17768c, "removeExecutionDetailRecordsById"));
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: EventTaskRecordApiImpl.kt */
    @d.c.b.a.f(b = "EventTaskRecordApiImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.spi.EventTaskRecordApiImpl$removeExecutionDetailRecordsBySessionId$2")
    static final class s extends d.c.b.a.l implements d.h.a.m<String, d.c.d<? super Integer>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17770a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f17771b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ EventTaskRecordApiImpl f17772c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f17773d;

        s(EventTaskRecordApiImpl r3, String r4, d.c.d<? super s> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17772c = r3;
            this.f17773d = r4;
            super(2, r6);
        }

        public final Object a(String r3, d.c.d<? super Integer> r4) {
            return ((s) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), s.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            s r0 = new s(this.f17772c, this.f17773d, r6);
            r0.f17771b = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(String r3, d.c.d<? super Integer> r4) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            d.c.a.b.a();
            if (this.f17770a != 0) goto L15;
            d.o.a(r7);
            String r8 = (String) ZeusTransformUtils.preCheckCast(this.f17771b, String.class, "com.obric.aiagent.plugin");
            if (com.obric.aiagent.executionengine.eventstaskmanager.common.d.f16682a.a() == false) goto L7;
            long r0 = SystemClock.elapsedRealtime();
            int r6 = com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.d.f17327a.a(r8, this.f17773d);
            com.obric.event.task.base.report.j r2 = com.obric.event.task.base.report.j.f32784a;
            if (r6 <= 0) goto L11;
            boolean r3 = true;
        L12:
            r2.b(r8, r3, SystemClock.elapsedRealtime() - r0);
            return d.c.b.a.b.a(r6);
        L11:
            r3 = false;
            goto L12
        L7:
            return d.c.b.a.b.a(EventTaskRecordApiImpl.access$disabledCount(this.f17772c, "removeExecutionDetailRecordsBySessionId"));
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: EventTaskRecordApiImpl.kt */
    @d.c.b.a.f(b = "EventTaskRecordApiImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.spi.EventTaskRecordApiImpl$removeExecutionRecordsById$2")
    static final class t extends d.c.b.a.l implements d.h.a.m<String, d.c.d<? super Integer>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17774a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f17775b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ EventTaskRecordApiImpl f17776c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ long[] f17777d;

        t(EventTaskRecordApiImpl r3, long[] r4, d.c.d<? super t> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17776c = r3;
            this.f17777d = r4;
            super(2, r6);
        }

        public final Object a(String r3, d.c.d<? super Integer> r4) {
            return ((t) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), t.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            t r0 = new t(this.f17776c, this.f17777d, r6);
            r0.f17775b = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(String r3, d.c.d<? super Integer> r4) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            d.c.a.b.a();
            if (this.f17774a != 0) goto L15;
            d.o.a(r7);
            String r1 = (String) ZeusTransformUtils.preCheckCast(this.f17775b, String.class, "com.obric.aiagent.plugin");
            if (com.obric.aiagent.executionengine.eventstaskmanager.common.d.f16682a.a() == false) goto L7;
            long r2 = SystemClock.elapsedRealtime();
            int r8 = com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.d.f17292a.a(r1, this.f17777d);
            com.obric.event.task.base.report.j r0 = com.obric.event.task.base.report.j.f32784a;
            long[] r6 = this.f17777d;
            if (r6 == null) goto L11;
            int r9 = r6.length;
        L12:
            int r3 = r9;
            r0.d(r1, r8, r3, SystemClock.elapsedRealtime() - r2);
            return d.c.b.a.b.a(r8);
        L11:
            r9 = 0;
            goto L12
        L7:
            return d.c.b.a.b.a(EventTaskRecordApiImpl.access$disabledCount(this.f17776c, "removeExecutionRecordsById"));
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: EventTaskRecordApiImpl.kt */
    @d.c.b.a.f(b = "EventTaskRecordApiImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.spi.EventTaskRecordApiImpl$removeExecutionRecordsByTaskId$2")
    static final class u extends d.c.b.a.l implements d.h.a.m<String, d.c.d<? super Integer>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17778a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f17779b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ EventTaskRecordApiImpl f17780c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f17781d;

        u(EventTaskRecordApiImpl r3, String r4, d.c.d<? super u> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17780c = r3;
            this.f17781d = r4;
            super(2, r6);
        }

        public final Object a(String r3, d.c.d<? super Integer> r4) {
            return ((u) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), u.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            u r0 = new u(this.f17780c, this.f17781d, r6);
            r0.f17779b = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(String r3, d.c.d<? super Integer> r4) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            d.c.a.b.a();
            if (this.f17778a != 0) goto L15;
            d.o.a(r7);
            String r8 = (String) ZeusTransformUtils.preCheckCast(this.f17779b, String.class, "com.obric.aiagent.plugin");
            if (com.obric.aiagent.executionengine.eventstaskmanager.common.d.f16682a.a() == false) goto L7;
            long r0 = SystemClock.elapsedRealtime();
            int r6 = com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.d.f17292a.a(r8, this.f17781d);
            com.obric.event.task.base.report.j r2 = com.obric.event.task.base.report.j.f32784a;
            if (r6 <= 0) goto L11;
            boolean r3 = true;
        L12:
            r2.b(r8, r3, SystemClock.elapsedRealtime() - r0);
            return d.c.b.a.b.a(r6);
        L11:
            r3 = false;
            goto L12
        L7:
            return d.c.b.a.b.a(EventTaskRecordApiImpl.access$disabledCount(this.f17780c, "removeExecutionRecordsByTaskId"));
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: EventTaskRecordApiImpl.kt */
    @d.c.b.a.f(b = "EventTaskRecordApiImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.spi.EventTaskRecordApiImpl$updateExecutionDetailRecord$2")
    static final class v extends d.c.b.a.l implements d.h.a.m<String, d.c.d<? super EventTaskExecutionDetailRecord>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17782a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f17783b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ EventTaskRecordApiImpl f17784c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ EventTaskExecutionDetailRecord f17785d;

        v(EventTaskRecordApiImpl r3, EventTaskExecutionDetailRecord r4, d.c.d<? super v> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17784c = r3;
            this.f17785d = r4;
            super(2, r6);
        }

        public final Object a(String r3, d.c.d<? super EventTaskExecutionDetailRecord> r4) {
            return ((v) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), v.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            v r0 = new v(this.f17784c, this.f17785d, r6);
            r0.f17783b = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(String r3, d.c.d<? super EventTaskExecutionDetailRecord> r4) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f17782a != 0) goto L10;
            d.o.a(r3);
            String r4 = (String) ZeusTransformUtils.preCheckCast(this.f17783b, String.class, "com.obric.aiagent.plugin");
            if (com.obric.aiagent.executionengine.eventstaskmanager.common.d.f16682a.a() == true) goto L8;
            return (EventTaskExecutionDetailRecord) ZeusTransformUtils.preCheckCast(EventTaskRecordApiImpl.access$disabled(this.f17784c, "updateExecutionDetailRecord"), EventTaskExecutionDetailRecord.class, "com.obric.aiagent.plugin");
        L8:
            return EventTaskRecordApiImpl.access$updateExecutionDetailRecordInternal(this.f17784c, r4, this.f17785d);
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: EventTaskRecordApiImpl.kt */
    @d.c.b.a.f(b = "EventTaskRecordApiImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.spi.EventTaskRecordApiImpl$updateExecutionDetailRecords$2")
    static final class w extends d.c.b.a.l implements d.h.a.m<String, d.c.d<? super Integer>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17786a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f17787b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ EventTaskRecordApiImpl f17788c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ List<EventTaskExecutionDetailRecord> f17789d;

        w(EventTaskRecordApiImpl r3, List<EventTaskExecutionDetailRecord> r4, d.c.d<? super w> r5) {
            List<EventTaskExecutionDetailRecord> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17788c = r3;
            this.f17789d = r6;
            super(2, r7);
        }

        public final Object a(String r3, d.c.d<? super Integer> r4) {
            return ((w) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), w.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            w r0 = new w(this.f17788c, this.f17789d, r6);
            r0.f17787b = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(String r3, d.c.d<? super Integer> r4) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            d.c.a.b.a();
            if (this.f17786a != 0) goto L20;
            d.o.a(r8);
            String r9 = (String) ZeusTransformUtils.preCheckCast(this.f17787b, String.class, "com.obric.aiagent.plugin");
            if (com.obric.aiagent.executionengine.eventstaskmanager.common.d.f16682a.a() == false) goto L7;
            long r0 = SystemClock.elapsedRealtime();
            int r2 = com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.d.f17327a.b(r9, this.f17789d);
            com.obric.event.task.base.report.j r3 = com.obric.event.task.base.report.j.f32784a;
            boolean r4 = false;
            if (r2 <= 0) goto L17;
            List<EventTaskExecutionDetailRecord> r7 = this.f17789d;
            if (r7 == null) goto L13;
            int r10 = r7.size();
        L15:
            if ((r2 - r10) != 0) goto L17;
            r4 = true;
            goto L17
        L13:
            r10 = 0;
        L17:
            r3.a(r9, r4, SystemClock.elapsedRealtime() - r0);
            return d.c.b.a.b.a(r2);
        L7:
            return d.c.b.a.b.a(EventTaskRecordApiImpl.access$disabledCount(this.f17788c, "updateExecutionDetailRecords"));
        L20:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: EventTaskRecordApiImpl.kt */
    @d.c.b.a.f(b = "EventTaskRecordApiImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.spi.EventTaskRecordApiImpl$updateExecutionRecord$2")
    static final class x extends d.c.b.a.l implements d.h.a.m<String, d.c.d<? super EventTaskExecutionRecord>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17790a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f17791b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ EventTaskRecordApiImpl f17792c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ EventTaskExecutionRecord f17793d;

        x(EventTaskRecordApiImpl r3, EventTaskExecutionRecord r4, d.c.d<? super x> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17792c = r3;
            this.f17793d = r4;
            super(2, r6);
        }

        public final Object a(String r3, d.c.d<? super EventTaskExecutionRecord> r4) {
            return ((x) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), x.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            x r0 = new x(this.f17792c, this.f17793d, r6);
            r0.f17791b = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(String r3, d.c.d<? super EventTaskExecutionRecord> r4) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f17790a != 0) goto L10;
            d.o.a(r3);
            String r4 = (String) ZeusTransformUtils.preCheckCast(this.f17791b, String.class, "com.obric.aiagent.plugin");
            if (com.obric.aiagent.executionengine.eventstaskmanager.common.d.f16682a.a() == true) goto L8;
            return (EventTaskExecutionRecord) ZeusTransformUtils.preCheckCast(EventTaskRecordApiImpl.access$disabled(this.f17792c, "updateExecutionRecord"), EventTaskExecutionRecord.class, "com.obric.aiagent.plugin");
        L8:
            return EventTaskRecordApiImpl.access$updateExecutionRecordInternal(this.f17792c, r4, this.f17793d);
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: EventTaskRecordApiImpl.kt */
    @d.c.b.a.f(b = "EventTaskRecordApiImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.spi.EventTaskRecordApiImpl$updateExecutionRecords$2")
    static final class y extends d.c.b.a.l implements d.h.a.m<String, d.c.d<? super Integer>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17794a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f17795b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ EventTaskRecordApiImpl f17796c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ List<EventTaskExecutionRecord> f17797d;

        y(EventTaskRecordApiImpl r3, List<EventTaskExecutionRecord> r4, d.c.d<? super y> r5) {
            List<EventTaskExecutionRecord> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17796c = r3;
            this.f17797d = r6;
            super(2, r7);
        }

        public final Object a(String r3, d.c.d<? super Integer> r4) {
            return ((y) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), y.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            y r0 = new y(this.f17796c, this.f17797d, r6);
            r0.f17795b = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(String r3, d.c.d<? super Integer> r4) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            d.c.a.b.a();
            if (this.f17794a != 0) goto L20;
            d.o.a(r8);
            String r9 = (String) ZeusTransformUtils.preCheckCast(this.f17795b, String.class, "com.obric.aiagent.plugin");
            if (com.obric.aiagent.executionengine.eventstaskmanager.common.d.f16682a.a() == false) goto L7;
            long r0 = SystemClock.elapsedRealtime();
            int r2 = com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.d.f17292a.b(r9, this.f17797d);
            com.obric.event.task.base.report.j r3 = com.obric.event.task.base.report.j.f32784a;
            boolean r4 = false;
            if (r2 <= 0) goto L17;
            List<EventTaskExecutionRecord> r7 = this.f17797d;
            if (r7 == null) goto L13;
            int r10 = r7.size();
        L15:
            if ((r2 - r10) != 0) goto L17;
            r4 = true;
            goto L17
        L13:
            r10 = 0;
        L17:
            r3.a(r9, r4, SystemClock.elapsedRealtime() - r0);
            return d.c.b.a.b.a(r2);
        L7:
            return d.c.b.a.b.a(EventTaskRecordApiImpl.access$disabledCount(this.f17796c, "updateExecutionRecords"));
        L20:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new a(null);
    }

    public EventTaskRecordApiImpl() {
    }

    public static final /* synthetic */ Object access$disabled(EventTaskRecordApiImpl r0, String r1) {
        return r0.disabled(r1);
    }

    public static final /* synthetic */ int access$disabledCount(EventTaskRecordApiImpl r0, String r1) {
        return r0.disabledCount(r1);
    }

    public static final /* synthetic */ EventTaskExecutionDetailRecord access$updateExecutionDetailRecordInternal(EventTaskRecordApiImpl r0, String r1, EventTaskExecutionDetailRecord r2) {
        return r0.updateExecutionDetailRecordInternal(r1, r2);
    }

    public static final /* synthetic */ EventTaskExecutionRecord access$updateExecutionRecordInternal(EventTaskRecordApiImpl r0, String r1, EventTaskExecutionRecord r2) {
        return r0.updateExecutionRecordInternal(r1, r2);
    }

    @Override // com.obric.eventkit.task.api.IEventTaskRecordApi
    public Object getConditionTaskRecordsByTaskId(long r12, long r14, String r16, d.c.d<? super List<ConditionTaskRecord>> r17) {
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r17, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.executionengine.eventstaskmanager.spi.a.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new f(this, r12, r14, r16, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r0);
    }

    @Override // com.obric.eventkit.task.api.IEventTaskRecordApi
    public Object getAllConditionTaskRecords(long r10, long r12, d.c.d<? super List<ConditionTaskRecord>> r14) {
        d.c.d r15 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.executionengine.eventstaskmanager.spi.a.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new d(this, r10, r12, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r15);
    }

    @Override // com.obric.eventkit.task.api.IEventTaskRecordApi
    public Object removeConditionTaskRecordsById(long[] r4, d.c.d<? super Integer> r5) {
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.executionengine.eventstaskmanager.spi.a.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new p(this, r4, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r6);
    }

    @Override // com.obric.eventkit.task.api.IEventTaskRecordApi
    public Object removeAllConditionTaskRecords(d.c.d<? super Integer> r4) {
        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.executionengine.eventstaskmanager.spi.a.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new n(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r5);
    }

    @Override // com.obric.eventkit.task.api.IEventTaskRecordApi
    public Object getEventTaskRecordsByTaskId(long r12, long r14, String r16, d.c.d<? super List<? extends EventTaskRecord>> r17) {
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r17, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.executionengine.eventstaskmanager.spi.a.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new g(this, r16, r12, r14, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r0);
    }

    @Override // com.obric.eventkit.task.api.IEventTaskRecordApi
    public Object getAllEventTaskRecords(long r12, long r14, int r16, d.c.d<? super List<? extends EventTaskRecord>> r17) {
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r17, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.executionengine.eventstaskmanager.spi.a.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new e(this, r16, r12, r14, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r0);
    }

    @Override // com.obric.eventkit.task.api.IEventTaskRecordApi
    public Object removeEventTaskRecordsById(int r4, long[] r5, d.c.d<? super Integer> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.executionengine.eventstaskmanager.spi.a.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new q(this, r4, r5, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r7);
    }

    @Override // com.obric.eventkit.task.api.IEventTaskRecordApi
    public Object removeAllEventTaskRecords(int r4, d.c.d<? super Integer> r5) {
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.executionengine.eventstaskmanager.spi.a.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new o(this, r4, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r6);
    }

    @Override // com.obric.eventkit.task.api.IEventTaskRecordApi
    public Object addExecutionRecords(List<EventTaskExecutionRecord> r4, d.c.d<? super List<EventTaskExecutionRecord>> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.executionengine.eventstaskmanager.spi.a.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new c(this, r6, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r7);
    }

    @Override // com.obric.eventkit.task.api.IEventTaskRecordApi
    public Object getExecutionRecords(int r4, int r5, d.c.d<? super List<EventTaskExecutionRecord>> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.executionengine.eventstaskmanager.spi.a.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new l(this, r4, r5, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r7);
    }

    @Override // com.obric.eventkit.task.api.IEventTaskRecordApi
    public Object getExecutionRecordsByTaskId(String r9, int r10, int r11, d.c.d<? super List<EventTaskExecutionRecord>> r12) {
        d.c.d r13 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.executionengine.eventstaskmanager.spi.a.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new m(this, r9, r10, r11, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r13);
    }

    @Override // com.obric.eventkit.task.api.IEventTaskRecordApi
    public Object getExecutionRecordById(long r4, d.c.d<? super EventTaskExecutionRecord> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.executionengine.eventstaskmanager.spi.a.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new k(this, r4, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r7);
    }

    @Override // com.obric.eventkit.task.api.IEventTaskRecordApi
    public Object updateExecutionRecord(EventTaskExecutionRecord r4, d.c.d<? super EventTaskExecutionRecord> r5) {
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.executionengine.eventstaskmanager.spi.a.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new x(this, r4, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r6);
    }

    @Override // com.obric.eventkit.task.api.IEventTaskRecordApi
    public Object updateExecutionRecords(List<EventTaskExecutionRecord> r4, d.c.d<? super Integer> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.executionengine.eventstaskmanager.spi.a.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new y(this, r6, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r7);
    }

    @Override // com.obric.eventkit.task.api.IEventTaskRecordApi
    public Object removeExecutionRecordsById(long[] r4, d.c.d<? super Integer> r5) {
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.executionengine.eventstaskmanager.spi.a.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new t(this, r4, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r6);
    }

    @Override // com.obric.eventkit.task.api.IEventTaskRecordApi
    public Object removeExecutionRecordsByTaskId(String r4, d.c.d<? super Integer> r5) {
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.executionengine.eventstaskmanager.spi.a.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new u(this, r4, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r6);
    }

    @Override // com.obric.eventkit.task.api.IEventTaskRecordApi
    public Object addExecutionDetailRecords(List<EventTaskExecutionDetailRecord> r4, d.c.d<? super List<EventTaskExecutionDetailRecord>> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.executionengine.eventstaskmanager.spi.a.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new b(this, r6, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r7);
    }

    @Override // com.obric.eventkit.task.api.IEventTaskRecordApi
    public Object getExecutionDetailRecords(int r4, int r5, d.c.d<? super List<EventTaskExecutionDetailRecord>> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.executionengine.eventstaskmanager.spi.a.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new i(this, r4, r5, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r7);
    }

    @Override // com.obric.eventkit.task.api.IEventTaskRecordApi
    public Object getExecutionDetailRecordsBySessionId(String r9, int r10, int r11, d.c.d<? super List<EventTaskExecutionDetailRecord>> r12) {
        d.c.d r13 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.executionengine.eventstaskmanager.spi.a.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new j(this, r9, r10, r11, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r13);
    }

    @Override // com.obric.eventkit.task.api.IEventTaskRecordApi
    public Object getExecutionDetailRecordById(long r4, d.c.d<? super EventTaskExecutionDetailRecord> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.executionengine.eventstaskmanager.spi.a.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new h(this, r4, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r7);
    }

    @Override // com.obric.eventkit.task.api.IEventTaskRecordApi
    public Object updateExecutionDetailRecord(EventTaskExecutionDetailRecord r4, d.c.d<? super EventTaskExecutionDetailRecord> r5) {
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.executionengine.eventstaskmanager.spi.a.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new v(this, r4, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r6);
    }

    @Override // com.obric.eventkit.task.api.IEventTaskRecordApi
    public Object updateExecutionDetailRecords(List<EventTaskExecutionDetailRecord> r4, d.c.d<? super Integer> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.executionengine.eventstaskmanager.spi.a.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new w(this, r6, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r7);
    }

    @Override // com.obric.eventkit.task.api.IEventTaskRecordApi
    public Object removeExecutionDetailRecordsById(long[] r4, d.c.d<? super Integer> r5) {
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.executionengine.eventstaskmanager.spi.a.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new r(this, r4, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r6);
    }

    @Override // com.obric.eventkit.task.api.IEventTaskRecordApi
    public Object removeExecutionDetailRecordsBySessionId(String r4, d.c.d<? super Integer> r5) {
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.executionengine.eventstaskmanager.spi.a.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new s(this, r4, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r6);
    }

    private final EventTaskExecutionRecord updateExecutionRecordInternal(String r6, EventTaskExecutionRecord r7) {
        long r0 = SystemClock.elapsedRealtime();
        EventTaskExecutionRecord r5 = com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.d.f17292a.a(r6, r7);
        com.obric.event.task.base.report.j r8 = com.obric.event.task.base.report.j.f32784a;
        if (r5 == null) goto L5;
        boolean r2 = true;
    L6:
        r8.a(r6, r2, SystemClock.elapsedRealtime() - r0);
        return r5;
    L5:
        r2 = false;
        goto L6
    }

    private final EventTaskExecutionDetailRecord updateExecutionDetailRecordInternal(String r6, EventTaskExecutionDetailRecord r7) {
        long r0 = SystemClock.elapsedRealtime();
        EventTaskExecutionDetailRecord r5 = com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.d.f17327a.a(r6, r7);
        com.obric.event.task.base.report.j r8 = com.obric.event.task.base.report.j.f32784a;
        if (r5 == null) goto L5;
        boolean r2 = true;
    L6:
        r8.a(r6, r2, SystemClock.elapsedRealtime() - r0);
        return r5;
    L5:
        r2 = false;
        goto L6
    }

    private final <T> T disabled(String r2) {
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.d(TAG, r2 + " not enable");
        return null;
    }

    private final int disabledCount(String r2) {
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.d(TAG, r2 + " not enable");
        return 0;
    }
}
