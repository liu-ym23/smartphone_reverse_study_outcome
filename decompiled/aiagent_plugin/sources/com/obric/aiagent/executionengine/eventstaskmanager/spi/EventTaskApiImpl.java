package com.obric.aiagent.executionengine.eventstaskmanager.spi;

import android.os.SystemClock;
import com.obric.eventkit.task.api.IEventTaskApi;
import com.obric.eventkit.task.model.ConditionGroup;
import com.obric.eventkit.task.model.ConditionTask;
import com.obric.eventkit.task.model.ConditionTaskAction;
import com.obric.eventkit.task.model.ConditionTaskResult;
import com.obric.eventkit.task.model.ConditionTaskSpec;
import com.obric.eventkit.task.model.EventTask;
import com.obric.eventkit.task.model.EventTaskResult;
import com.obric.eventkit.task.model.EventTaskSpec;
import com.obric.eventkit.task.model.PeriodicPolicy;
import com.obric.eventkit.task.model.ShortcutTask;
import com.obric.eventkit.task.model.ShortcutTaskSpec;
import com.obric.eventkit.task.model.TimerTask;
import com.obric.eventkit.task.model.TimerTaskResult;
import com.obric.eventkit.task.model.TimerTaskV2;
import com.obric.eventkit.task.model.TriggerControlPolicy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: EventTaskApiImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EventTaskApiImpl implements IEventTaskApi {
    public static final a Companion = null;
    private static final String TAG = "EventTaskApiImpl";

    /* JADX INFO: compiled from: EventTaskApiImpl.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: EventTaskApiImpl.kt */
    @d.c.b.a.f(b = "EventTaskApiImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.spi.EventTaskApiImpl$addConditionTask$2")
    static final class b extends d.c.b.a.l implements d.h.a.m<String, d.c.d<? super ConditionTaskResult>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17626a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f17627b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ EventTaskApiImpl f17628c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ List<ConditionTaskAction> f17629d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f17630e;
        final /* synthetic */ ConditionGroup f;
        final /* synthetic */ PeriodicPolicy g;
        final /* synthetic */ TriggerControlPolicy h;
        final /* synthetic */ Map<String, String> i;

        b(EventTaskApiImpl r3, List<ConditionTaskAction> r4, String r5, ConditionGroup r6, PeriodicPolicy r7, TriggerControlPolicy r8, Map<String, String> r9, d.c.d<? super b> r10) {
            List<ConditionTaskAction> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            Map<String, String> r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.aiagent.plugin");
            d.c.d r13 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17628c = r3;
            this.f17629d = r11;
            this.f17630e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
            this.i = r12;
            super(2, r13);
        }

        public final Object a(String r3, d.c.d<? super ConditionTaskResult> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r12, d.c.d<?> r13) {
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
            b r14 = new b(this.f17628c, this.f17629d, this.f17630e, this.f, this.g, this.h, this.i, r10);
            r14.f17627b = r12;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r14, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(String r3, d.c.d<? super ConditionTaskResult> r4) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r20) {
            d.c.a.b.a();
            if (this.f17626a != 0) goto L11;
            d.o.a(r20);
            String r1 = (String) ZeusTransformUtils.preCheckCast(this.f17627b, String.class, "com.obric.aiagent.plugin");
            if (com.obric.aiagent.executionengine.eventstaskmanager.common.d.f16682a.a() == false) goto L7;
            long r17 = SystemClock.elapsedRealtime();
            ConditionTaskResult r0 = com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.a(com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.f16741a, r1, this.f17629d, this.f17630e, this.f, this.g, this.h, this.i, null, 0, null, null, null, 3968, null);
            com.obric.event.task.base.report.j.f32784a.a(r1, r0, SystemClock.elapsedRealtime() - r17);
            return r0;
        L7:
            return EventTaskApiImpl.access$disabled(this.f17628c, "addConditionTask");
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: EventTaskApiImpl.kt */
    @d.c.b.a.f(b = "EventTaskApiImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.spi.EventTaskApiImpl$addEventTask$2")
    static final class c extends d.c.b.a.l implements d.h.a.m<String, d.c.d<? super EventTaskResult>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17631a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f17632b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ EventTaskApiImpl f17633c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ EventTaskSpec f17634d;

        c(EventTaskApiImpl r3, EventTaskSpec r4, d.c.d<? super c> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17633c = r3;
            this.f17634d = r4;
            super(2, r6);
        }

        public final Object a(String r3, d.c.d<? super EventTaskResult> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            c r0 = new c(this.f17633c, this.f17634d, r6);
            r0.f17632b = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(String r3, d.c.d<? super EventTaskResult> r4) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            d.c.a.b.a();
            if (this.f17631a != 0) goto L18;
            d.o.a(r10);
            String r3 = (String) ZeusTransformUtils.preCheckCast(this.f17632b, String.class, "com.obric.aiagent.plugin");
            if (com.obric.aiagent.executionengine.eventstaskmanager.common.d.f16682a.a() == false) goto L7;
            long r4 = SystemClock.elapsedRealtime();
            EventTaskSpec r11 = this.f17634d;
            if (ZeusTransformUtils.instanceOf(r11, ShortcutTaskSpec.class) == false) goto L12;
            int r12 = 3;
            EventTaskResult r9 = com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.a.f17459a.a(r3, (ShortcutTaskSpec) ZeusTransformUtils.preCheckCast(this.f17634d, ShortcutTaskSpec.class, "com.obric.aiagent.plugin"));
        L15:
            com.obric.event.task.base.report.j.f32784a.a(r3, r9, r12, SystemClock.elapsedRealtime() - r4);
            return r9;
        L12:
            if (ZeusTransformUtils.instanceOf(r11, ConditionTaskSpec.class) == false) goto L14;
            r12 = 2;
            r9 = com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.f16741a.a(r3, (ConditionTaskSpec) ZeusTransformUtils.preCheckCast(this.f17634d, ConditionTaskSpec.class, "com.obric.aiagent.plugin"));
            goto L15
        L14:
            r12 = 0;
            r9 = null;
            goto L15
        L7:
            return EventTaskApiImpl.access$disabled(this.f17633c, "addEventTask");
        L18:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: EventTaskApiImpl.kt */
    @d.c.b.a.f(b = "EventTaskApiImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.spi.EventTaskApiImpl$getAllEventTasks$2")
    static final class d extends d.c.b.a.l implements d.h.a.m<String, d.c.d<? super List<? extends EventTask>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17635a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f17636b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ EventTaskApiImpl f17637c;

        d(EventTaskApiImpl r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17637c = r3;
            super(2, r5);
        }

        public final Object a(String r3, d.c.d<? super List<? extends EventTask>> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            d r0 = new d(this.f17637c, r5);
            r0.f17636b = r3;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(String r3, d.c.d<? super List<? extends EventTask>> r4) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            d.c.a.b.a();
            if (this.f17635a != 0) goto L27;
            d.o.a(r5);
            String r6 = (String) ZeusTransformUtils.preCheckCast(this.f17636b, String.class, "com.obric.aiagent.plugin");
            if (com.obric.aiagent.executionengine.eventstaskmanager.common.d.f16682a.a() == false) goto L7;
            List<ConditionTask> r4 = com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.f16741a.a(r6);
            if (r6 == null) goto L17;
            List<TimerTask> r7 = com.obric.aiagent.executionengine.eventstaskmanager.timertask.b.f17879a.a(r6);
            if (r7 == null) goto L17;
            Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin");
            Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r8, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r9 = r8.iterator();
        L14:
            if (r9.hasNext() == false) goto L16;
            r0.add(((TimerTask) ZeusTransformUtils.preCheckCast(r9.next(), TimerTask.class, "com.obric.aiagent.plugin")).toTimerTaskV2());
            goto L14
        L16:
            List r10 = (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin");
        L18:
            if (r10 != null) goto L20;
            r10 = p.b();
        L20:
            if (r4 == null) goto L29;
            List r11 = p.c((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.aiagent.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin"));
            if (r11 != null) goto L25;
            return r10;
        L25:
            return r11;
        L29:
            return r10;
        L17:
            r10 = null;
            goto L18
        L7:
            return EventTaskApiImpl.access$disabled(this.f17637c, "getAllEventTasks");
        L27:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: EventTaskApiImpl.kt */
    @d.c.b.a.f(b = "EventTaskApiImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.spi.EventTaskApiImpl$getConditionTask$2")
    static final class e extends d.c.b.a.l implements d.h.a.m<String, d.c.d<? super ConditionTask>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17638a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f17639b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ EventTaskApiImpl f17640c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f17641d;

        e(EventTaskApiImpl r3, String r4, d.c.d<? super e> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17640c = r3;
            this.f17641d = r4;
            super(2, r6);
        }

        public final Object a(String r3, d.c.d<? super ConditionTask> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            e r0 = new e(this.f17640c, this.f17641d, r6);
            r0.f17639b = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(String r3, d.c.d<? super ConditionTask> r4) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f17638a != 0) goto L10;
            d.o.a(r3);
            String r4 = (String) ZeusTransformUtils.preCheckCast(this.f17639b, String.class, "com.obric.aiagent.plugin");
            if (com.obric.aiagent.executionengine.eventstaskmanager.common.d.f16682a.a() == true) goto L8;
            return (ConditionTask) ZeusTransformUtils.preCheckCast(EventTaskApiImpl.access$disabled(this.f17640c, "getConditionTask"), ConditionTask.class, "com.obric.aiagent.plugin");
        L8:
            return com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.f16741a.a(r4, this.f17641d);
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: EventTaskApiImpl.kt */
    @d.c.b.a.f(b = "EventTaskApiImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.spi.EventTaskApiImpl$getEventTask$2")
    static final class f extends d.c.b.a.l implements d.h.a.m<String, d.c.d<? super EventTask>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17642a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f17643b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ EventTaskApiImpl f17644c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f17645d;

        f(EventTaskApiImpl r3, String r4, d.c.d<? super f> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17644c = r3;
            this.f17645d = r4;
            super(2, r6);
        }

        public final Object a(String r3, d.c.d<? super EventTask> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            f r0 = new f(this.f17644c, this.f17645d, r6);
            r0.f17643b = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(String r3, d.c.d<? super EventTask> r4) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            d.c.a.b.a();
            if (this.f17642a != 0) goto L28;
            d.o.a(r5);
            String r6 = (String) ZeusTransformUtils.preCheckCast(this.f17643b, String.class, "com.obric.aiagent.plugin");
            if (com.obric.aiagent.executionengine.eventstaskmanager.common.d.f16682a.a() == false) goto L7;
            TimerTaskV2 r2 = null;
            if (this.f17645d != null) goto L12;
            return null;
        L12:
            if (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.f16741a.l(this.f17645d) == false) goto L15;
            return (EventTask) ZeusTransformUtils.preCheckCast(com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.f16741a.a(r6, this.f17645d), EventTask.class, "com.obric.aiagent.plugin");
        L15:
            if (com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.a.f17459a.a(this.f17645d) == true) goto L30;
            Integer r4 = d.o.o.d(this.f17645d);
            if (r4 == null) goto L26;
            int r7 = ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).intValue();
            com.obric.aiagent.executionengine.eventstaskmanager.timertask.b r0 = com.obric.aiagent.executionengine.eventstaskmanager.timertask.b.f17879a;
            if (r6 != null) goto L22;
            r6 = "";
        L22:
            TimerTask r8 = r0.a(r7, r6);
            if (r8 == null) goto L26;
            r2 = r8.toTimerTaskV2();
        L26:
            return (EventTask) ZeusTransformUtils.preCheckCast(r2, EventTask.class, "com.obric.aiagent.plugin");
        L30:
            return (EventTask) ZeusTransformUtils.preCheckCast(com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.a.f17459a.a(r6, this.f17645d), EventTask.class, "com.obric.aiagent.plugin");
        L7:
            return EventTaskApiImpl.access$disabled(this.f17644c, "getEventTask");
        L28:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: EventTaskApiImpl.kt */
    @d.c.b.a.f(b = "EventTaskApiImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.spi.EventTaskApiImpl$getEventTasksByType$2")
    static final class g extends d.c.b.a.l implements d.h.a.m<String, d.c.d<? super List<? extends EventTask>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17646a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f17647b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ EventTaskApiImpl f17648c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f17649d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f17650e;
        final /* synthetic */ int f;

        g(EventTaskApiImpl r3, int r4, int r5, int r6, d.c.d<? super g> r7) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17648c = r3;
            this.f17649d = r4;
            this.f17650e = r5;
            this.f = r6;
            super(2, r8);
        }

        public final Object a(String r3, d.c.d<? super List<? extends EventTask>> r4) {
            return ((g) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), g.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r9, d.c.d<?> r10) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            g r11 = new g(this.f17648c, this.f17649d, this.f17650e, this.f, r7);
            r11.f17647b = r9;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r11, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(String r3, d.c.d<? super List<? extends EventTask>> r4) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            d.c.a.b.a();
            if (this.f17646a != 0) goto L24;
            d.o.a(r4);
            String r5 = (String) ZeusTransformUtils.preCheckCast(this.f17647b, String.class, "com.obric.aiagent.plugin");
            if (com.obric.aiagent.executionengine.eventstaskmanager.common.d.f16682a.a() == false) goto L7;
            int r0 = this.f17649d;
            if (r0 != 1) goto L11;
            Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(com.obric.aiagent.executionengine.eventstaskmanager.timertask.b.f17879a.a(r5, this.f17650e, this.f), Iterable.class, "com.obric.aiagent.plugin");
            Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r3, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r7 = r3.iterator();
        L19:
            if (r7.hasNext() == false) goto L22;
            r6.add(((TimerTask) ZeusTransformUtils.preCheckCast(r7.next(), TimerTask.class, "com.obric.aiagent.plugin")).toTimerTaskV2());
            goto L19
        L22:
            return (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.aiagent.plugin");
        L11:
            if (r0 == 2) goto L28;
            if (r0 == 3) goto L27;
            return null;
        L27:
            return com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.a.f17459a.a(r5, this.f17650e, this.f);
        L28:
            return com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.f16741a.a(r5, this.f17650e, this.f);
        L7:
            return EventTaskApiImpl.access$disabled(this.f17648c, "getEventTasksByType");
        L24:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: EventTaskApiImpl.kt */
    @d.c.b.a.f(b = "EventTaskApiImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.spi.EventTaskApiImpl$getKnowledgeSessionIdNotNullEventTasks$2")
    static final class h extends d.c.b.a.l implements d.h.a.m<String, d.c.d<? super List<? extends EventTask>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17651a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f17652b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ EventTaskApiImpl f17653c;

        h(EventTaskApiImpl r3, d.c.d<? super h> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17653c = r3;
            super(2, r5);
        }

        public final Object a(String r3, d.c.d<? super List<? extends EventTask>> r4) {
            return ((h) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            h r0 = new h(this.f17653c, r5);
            r0.f17652b = r3;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(String r3, d.c.d<? super List<? extends EventTask>> r4) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f17651a != 0) goto L11;
            d.o.a(r3);
            String r4 = (String) ZeusTransformUtils.preCheckCast(this.f17652b, String.class, "com.obric.aiagent.plugin");
            if (com.obric.aiagent.executionengine.eventstaskmanager.common.d.f16682a.a() == true) goto L9;
            return EventTaskApiImpl.access$disabled(this.f17653c, "getKnowledgeSessionIdNotNullEventTasks");
        L9:
            return EventTaskApiImpl.access$mergeTaskLists(this.f17653c, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.f16741a.b(r4), com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.a.f17459a.b(r4));
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: EventTaskApiImpl.kt */
    @d.c.b.a.f(b = "EventTaskApiImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.spi.EventTaskApiImpl$getShortInstructNotNullShortcutTasks$2")
    static final class i extends d.c.b.a.l implements d.h.a.m<String, d.c.d<? super List<? extends ShortcutTask>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17654a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f17655b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ EventTaskApiImpl f17656c;

        i(EventTaskApiImpl r3, d.c.d<? super i> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17656c = r3;
            super(2, r5);
        }

        public final Object a(String r3, d.c.d<? super List<ShortcutTask>> r4) {
            return ((i) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), i.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            i r0 = new i(this.f17656c, r5);
            r0.f17655b = r3;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(String r3, d.c.d<? super List<? extends ShortcutTask>> r4) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f17654a != 0) goto L10;
            d.o.a(r3);
            String r4 = (String) ZeusTransformUtils.preCheckCast(this.f17655b, String.class, "com.obric.aiagent.plugin");
            if (com.obric.aiagent.executionengine.eventstaskmanager.common.d.f16682a.a() == true) goto L8;
            return (List) ZeusTransformUtils.preCheckCast(EventTaskApiImpl.access$disabled(this.f17656c, "getShortInstructNotNullShortcutTasks"), List.class, "com.obric.aiagent.plugin");
        L8:
            return com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.a.f17459a.d(r4);
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: EventTaskApiImpl.kt */
    @d.c.b.a.f(b = "EventTaskApiImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.spi.EventTaskApiImpl$getTemplateIdNotNullEventTasks$2")
    static final class j extends d.c.b.a.l implements d.h.a.m<String, d.c.d<? super List<? extends EventTask>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17657a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f17658b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ EventTaskApiImpl f17659c;

        j(EventTaskApiImpl r3, d.c.d<? super j> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17659c = r3;
            super(2, r5);
        }

        public final Object a(String r3, d.c.d<? super List<? extends EventTask>> r4) {
            return ((j) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), j.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            j r0 = new j(this.f17659c, r5);
            r0.f17658b = r3;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(String r3, d.c.d<? super List<? extends EventTask>> r4) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f17657a != 0) goto L11;
            d.o.a(r3);
            String r4 = (String) ZeusTransformUtils.preCheckCast(this.f17658b, String.class, "com.obric.aiagent.plugin");
            if (com.obric.aiagent.executionengine.eventstaskmanager.common.d.f16682a.a() == true) goto L9;
            return EventTaskApiImpl.access$disabled(this.f17659c, "getTemplateIdNotNullEventTasks");
        L9:
            return EventTaskApiImpl.access$mergeTaskLists(this.f17659c, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.f16741a.c(r4), com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.a.f17459a.c(r4));
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: EventTaskApiImpl.kt */
    @d.c.b.a.f(b = "EventTaskApiImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.spi.EventTaskApiImpl$removeConditionTask$2")
    static final class k extends d.c.b.a.l implements d.h.a.m<String, d.c.d<? super ConditionTaskResult>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17660a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f17661b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ EventTaskApiImpl f17662c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String[] f17663d;

        k(EventTaskApiImpl r3, String[] r4, d.c.d<? super k> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17662c = r3;
            this.f17663d = r4;
            super(2, r6);
        }

        public final Object a(String r3, d.c.d<? super ConditionTaskResult> r4) {
            return ((k) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), k.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            k r0 = new k(this.f17662c, this.f17663d, r6);
            r0.f17661b = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(String r3, d.c.d<? super ConditionTaskResult> r4) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            d.c.a.b.a();
            if (this.f17660a != 0) goto L11;
            d.o.a(r6);
            String r7 = (String) ZeusTransformUtils.preCheckCast(this.f17661b, String.class, "com.obric.aiagent.plugin");
            if (com.obric.aiagent.executionengine.eventstaskmanager.common.d.f16682a.a() == false) goto L7;
            long r0 = SystemClock.elapsedRealtime();
            ConditionTaskResult r5 = com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.f16741a.a(r7, this.f17663d);
            com.obric.event.task.base.report.j.f32784a.b(r7, r5, SystemClock.elapsedRealtime() - r0);
            return r5;
        L7:
            return EventTaskApiImpl.access$disabled(this.f17662c, "removeConditionTask");
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: EventTaskApiImpl.kt */
    @d.c.b.a.f(b = "EventTaskApiImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.spi.EventTaskApiImpl$removeEventTask$2")
    static final class l extends d.c.b.a.l implements d.h.a.m<String, d.c.d<? super EventTaskResult>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17664a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f17665b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ EventTaskApiImpl f17666c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String[] f17667d;

        l(EventTaskApiImpl r3, String[] r4, d.c.d<? super l> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17666c = r3;
            this.f17667d = r4;
            super(2, r6);
        }

        public final Object a(String r3, d.c.d<? super EventTaskResult> r4) {
            return ((l) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), l.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            l r0 = new l(this.f17666c, this.f17667d, r6);
            r0.f17665b = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(String r3, d.c.d<? super EventTaskResult> r4) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r14) {
            d.c.a.b.a();
            if (this.f17664a != 0) goto L52;
            d.o.a(r14);
            String r3 = (String) ZeusTransformUtils.preCheckCast(this.f17665b, String.class, "com.obric.aiagent.plugin");
            if (com.obric.aiagent.executionengine.eventstaskmanager.common.d.f16682a.a() == false) goto L7;
            long r4 = SystemClock.elapsedRealtime();
            String[] r15 = this.f17667d;
            List r0 = null;
            if (r15 == null) goto L11;
            String r16 = (String) ZeusTransformUtils.preCheckCast(d.a.i.c(r15), String.class, "com.obric.aiagent.plugin");
        L12:
            String r2 = "";
            if (r16 != null) goto L16;
            r16 = "";
        L16:
            if (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.f16741a.l(r16) == false) goto L19;
            int r17 = 2;
            ConditionTaskResult r13 = com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.f16741a.a(r3, this.f17667d);
            EventTaskResult r1 = new EventTaskResult(r13.getCode(), r13.getMsg(), r13.getData(), null, 8, null);
        L49:
            com.obric.event.task.base.report.j.f32784a.b(r3, r1, r17, SystemClock.elapsedRealtime() - r4);
            return r1;
        L19:
            if (com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.a.f17459a.a(r16) == false) goto L21;
            r17 = 3;
            r1 = com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.a.f17459a.a(r3, this.f17667d);
            goto L49
        L21:
            com.obric.aiagent.executionengine.eventstaskmanager.timertask.b r18 = com.obric.aiagent.executionengine.eventstaskmanager.timertask.b.f17879a;
            String[] r19 = this.f17667d;
            if (r19 == null) goto L30;
            Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            int r7 = 0;
            int r8 = r19.length;
        L24:
            if (r7 >= r8) goto L29;
            Integer r9 = d.o.o.d(r19[r7]);
            if (r9 == null) goto L28;
            r6.add(r9);
        L28:
            r7 = r7 + 1;
            goto L24
        L29:
            List<Integer> r110 = (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.aiagent.plugin");
        L31:
            if (r110 != null) goto L33;
            r110 = p.b();
        L33:
            if (r3 == null) goto L36;
            r2 = r3;
        L36:
            TimerTaskResult r111 = r18.a(r110, r2);
            int r10 = r111.getCode();
            String r11 = r111.getMsg();
            List<TimerTask> r112 = r111.getData();
            if (r112 == null) goto L48;
            Iterable r113 = (Iterable) ZeusTransformUtils.preCheckCast(r112, Iterable.class, "com.obric.aiagent.plugin");
            Collection r114 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r115 = r113.iterator();
        L40:
            if (r115.hasNext() == false) goto L47;
            TimerTask r5 = (TimerTask) ZeusTransformUtils.preCheckCast(r115.next(), TimerTask.class, "com.obric.aiagent.plugin");
            if (r5 == null) goto L44;
            TimerTaskV2 r12 = r5.toTimerTaskV2();
        L45:
            if (r12 == null) goto L40;
            r114.add(r12);
            goto L40
        L44:
            r12 = null;
            goto L45
        L47:
            r0 = (List) ZeusTransformUtils.preCheckCast(r114, List.class, "com.obric.aiagent.plugin");
        L48:
            r1 = new EventTaskResult(r10, r11, r0, null, 8, null);
            r17 = 1;
            goto L49
        L30:
            r110 = null;
            goto L31
        L11:
            r16 = null;
            goto L12
        L7:
            return EventTaskApiImpl.access$disabled(this.f17666c, "removeEventTask");
        L52:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: EventTaskApiImpl.kt */
    @d.c.b.a.f(b = "EventTaskApiImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.spi.EventTaskApiImpl$updateConditionTask$2")
    static final class m extends d.c.b.a.l implements d.h.a.m<String, d.c.d<? super ConditionTaskResult>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17668a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f17669b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ EventTaskApiImpl f17670c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f17671d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ List<ConditionTaskAction> f17672e;
        final /* synthetic */ String f;
        final /* synthetic */ ConditionGroup g;
        final /* synthetic */ PeriodicPolicy h;
        final /* synthetic */ TriggerControlPolicy i;
        final /* synthetic */ int j;
        final /* synthetic */ Map<String, String> k;

        m(EventTaskApiImpl r3, String r4, List<ConditionTaskAction> r5, String r6, ConditionGroup r7, PeriodicPolicy r8, TriggerControlPolicy r9, int r10, Map<String, String> r11, d.c.d<? super m> r12) {
            List<ConditionTaskAction> r13 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
            Map<String, String> r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin");
            d.c.d r15 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17670c = r3;
            this.f17671d = r4;
            this.f17672e = r13;
            this.f = r6;
            this.g = r7;
            this.h = r8;
            this.i = r9;
            this.j = r10;
            this.k = r14;
            super(2, r15);
        }

        public final Object a(String r3, d.c.d<? super ConditionTaskResult> r4) {
            return ((m) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), m.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r14, d.c.d<?> r15) {
            d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin");
            m r16 = new m(this.f17670c, this.f17671d, this.f17672e, this.f, this.g, this.h, this.i, this.j, this.k, r12);
            r16.f17669b = r14;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r16, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(String r3, d.c.d<? super ConditionTaskResult> r4) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r21) {
            d.c.a.b.a();
            if (this.f17668a != 0) goto L11;
            d.o.a(r21);
            String r1 = (String) ZeusTransformUtils.preCheckCast(this.f17669b, String.class, "com.obric.aiagent.plugin");
            if (com.obric.aiagent.executionengine.eventstaskmanager.common.d.f16682a.a() == false) goto L7;
            long r18 = SystemClock.elapsedRealtime();
            ConditionTaskResult r0 = com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.a(com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.f16741a, r1, this.f17671d, this.f17672e, this.f, this.g, this.h, this.i, d.c.b.a.b.a(this.j), this.k, 0, null, null, null, 7680, null);
            com.obric.event.task.base.report.j.f32784a.c(r1, r0, SystemClock.elapsedRealtime() - r18);
            return r0;
        L7:
            return EventTaskApiImpl.access$disabled(this.f17670c, "updateConditionTask");
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: EventTaskApiImpl.kt */
    @d.c.b.a.f(b = "EventTaskApiImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.spi.EventTaskApiImpl$updateEventTask$2")
    static final class n extends d.c.b.a.l implements d.h.a.m<String, d.c.d<? super EventTaskResult>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17673a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f17674b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ EventTaskApiImpl f17675c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ EventTaskSpec f17676d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f17677e;

        n(EventTaskApiImpl r3, EventTaskSpec r4, String r5, d.c.d<? super n> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17675c = r3;
            this.f17676d = r4;
            this.f17677e = r5;
            super(2, r7);
        }

        public final Object a(String r3, d.c.d<? super EventTaskResult> r4) {
            return ((n) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), n.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r5, d.c.d<?> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            n r0 = new n(this.f17675c, this.f17676d, this.f17677e, r7);
            r0.f17674b = r5;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(String r3, d.c.d<? super EventTaskResult> r4) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            d.c.a.b.a();
            if (this.f17673a != 0) goto L18;
            d.o.a(r10);
            String r3 = (String) ZeusTransformUtils.preCheckCast(this.f17674b, String.class, "com.obric.aiagent.plugin");
            if (com.obric.aiagent.executionengine.eventstaskmanager.common.d.f16682a.a() == false) goto L7;
            long r4 = SystemClock.elapsedRealtime();
            EventTaskSpec r11 = this.f17676d;
            if (ZeusTransformUtils.instanceOf(r11, ShortcutTaskSpec.class) == false) goto L12;
            int r12 = 3;
            EventTaskResult r9 = com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.a.f17459a.a(r3, this.f17677e, (ShortcutTaskSpec) ZeusTransformUtils.preCheckCast(this.f17676d, ShortcutTaskSpec.class, "com.obric.aiagent.plugin"));
        L15:
            com.obric.event.task.base.report.j.f32784a.c(r3, r9, r12, SystemClock.elapsedRealtime() - r4);
            return r9;
        L12:
            if (ZeusTransformUtils.instanceOf(r11, ConditionTaskSpec.class) == false) goto L14;
            r12 = 2;
            r9 = com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.f16741a.a(r3, this.f17677e, (ConditionTaskSpec) ZeusTransformUtils.preCheckCast(this.f17676d, ConditionTaskSpec.class, "com.obric.aiagent.plugin"));
            goto L15
        L14:
            r12 = 0;
            r9 = null;
            goto L15
        L7:
            return EventTaskApiImpl.access$disabled(this.f17675c, "updateEventTask");
        L18:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: EventTaskApiImpl.kt */
    @d.c.b.a.f(b = "EventTaskApiImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.spi.EventTaskApiImpl$updateEventTaskDisplayOrder$2")
    static final class o extends d.c.b.a.l implements d.h.a.m<String, d.c.d<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17678a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f17679b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f17680c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ List<String> f17681d;

        o(int r3, List<String> r4, d.c.d<? super o> r5) {
            List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17680c = r3;
            this.f17681d = r6;
            super(2, r7);
        }

        public final Object a(String r3, d.c.d<? super Boolean> r4) {
            return ((o) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), o.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            o r0 = new o(this.f17680c, this.f17681d, r6);
            r0.f17679b = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(String r3, d.c.d<? super Boolean> r4) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            d.c.a.b.a();
            if (this.f17678a != 0) goto L22;
            d.o.a(r5);
            String r6 = (String) ZeusTransformUtils.preCheckCast(this.f17679b, String.class, "com.obric.aiagent.plugin");
            boolean r1 = false;
            if (com.obric.aiagent.executionengine.eventstaskmanager.common.d.f16682a.a() == true) goto L8;
            com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.d(EventTaskApiImpl.TAG, "updateEventTaskDisplayOrder not enable");
            return d.c.b.a.b.a(false);
        L8:
            int r0 = this.f17680c;
            if (r0 == 2) goto L17;
            if (r0 != 3) goto L20;
            if (com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.a.f17459a.a(r6, this.f17681d).getCode() != 0) goto L20;
        L18:
            r1 = true;
        L20:
            return d.c.b.a.b.a(r1);
        L17:
            if (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.f16741a.a(r6, this.f17681d).getCode() != 0) goto L20;
        L22:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new a(null);
    }

    public EventTaskApiImpl() {
    }

    public static final /* synthetic */ Object access$disabled(EventTaskApiImpl r0, String r1) {
        return r0.disabled(r1);
    }

    public static final /* synthetic */ List access$mergeTaskLists(EventTaskApiImpl r2, List r3, List r4) {
        return r2.mergeTaskLists((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.eventkit.task.api.IEventTaskApi
    public Object addConditionTask(List<ConditionTaskAction> r13, String r14, ConditionGroup r15, PeriodicPolicy r16, TriggerControlPolicy r17, Map<String, String> r18, d.c.d<? super ConditionTaskResult> r19) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.aiagent.plugin");
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r18, Map.class, "com.obric.aiagent.plugin");
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r19, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.executionengine.eventstaskmanager.spi.a.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new b(this, r4, r14, r15, r16, r17, r9, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r0);
    }

    @Override // com.obric.eventkit.task.api.IEventTaskApi
    public Object updateConditionTask(String r15, List<ConditionTaskAction> r16, String r17, ConditionGroup r18, PeriodicPolicy r19, TriggerControlPolicy r20, int r21, Map<String, String> r22, d.c.d<? super ConditionTaskResult> r23) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.aiagent.plugin");
        Map r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r22, Map.class, "com.obric.aiagent.plugin");
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r23, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.executionengine.eventstaskmanager.spi.a.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new m(this, r15, r5, r17, r18, r19, r20, r21, r11, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r0);
    }

    @Override // com.obric.eventkit.task.api.IEventTaskApi
    public Object removeConditionTask(String[] r4, d.c.d<? super ConditionTaskResult> r5) {
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.executionengine.eventstaskmanager.spi.a.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new k(this, r4, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r6);
    }

    @Override // com.obric.eventkit.task.api.IEventTaskApi
    public Object getConditionTask(String r4, d.c.d<? super ConditionTask> r5) {
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.executionengine.eventstaskmanager.spi.a.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new e(this, r4, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r6);
    }

    @Override // com.obric.eventkit.task.api.IEventTaskApi
    public Object getAllEventTasks(d.c.d<? super List<? extends EventTask>> r4) {
        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.executionengine.eventstaskmanager.spi.a.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new d(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r5);
    }

    @Override // com.obric.eventkit.task.api.IEventTaskApi
    public Object getEventTask(String r4, d.c.d<? super EventTask> r5) {
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.executionengine.eventstaskmanager.spi.a.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new f(this, r4, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r6);
    }

    @Override // com.obric.eventkit.task.api.IEventTaskApi
    public Object getEventTasksByType(int r9, int r10, int r11, d.c.d<? super List<? extends EventTask>> r12) {
        d.c.d r13 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.executionengine.eventstaskmanager.spi.a.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new g(this, r9, r10, r11, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r13);
    }

    @Override // com.obric.eventkit.task.api.IEventTaskApi
    public Object getKnowledgeSessionIdNotNullEventTasks(d.c.d<? super List<? extends EventTask>> r4) {
        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.executionengine.eventstaskmanager.spi.a.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new h(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r5);
    }

    @Override // com.obric.eventkit.task.api.IEventTaskApi
    public Object getTemplateIdNotNullEventTasks(d.c.d<? super List<? extends EventTask>> r4) {
        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.executionengine.eventstaskmanager.spi.a.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new j(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r5);
    }

    @Override // com.obric.eventkit.task.api.IEventTaskApi
    public Object getShortInstructNotNullShortcutTasks(d.c.d<? super List<ShortcutTask>> r4) {
        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.executionengine.eventstaskmanager.spi.a.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new i(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r5);
    }

    @Override // com.obric.eventkit.task.api.IEventTaskApi
    public Object updateEventTaskDisplayOrder(int r3, List<String> r4, d.c.d<? super Boolean> r5) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.executionengine.eventstaskmanager.spi.a.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new o(r3, r2, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r6);
    }

    @Override // com.obric.eventkit.task.api.IEventTaskApi
    public Object addEventTask(EventTaskSpec r4, d.c.d<? super EventTaskResult> r5) {
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.executionengine.eventstaskmanager.spi.a.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new c(this, r4, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r6);
    }

    @Override // com.obric.eventkit.task.api.IEventTaskApi
    public Object updateEventTask(String r4, EventTaskSpec r5, d.c.d<? super EventTaskResult> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.executionengine.eventstaskmanager.spi.a.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new n(this, r5, r4, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r7);
    }

    @Override // com.obric.eventkit.task.api.IEventTaskApi
    public Object removeEventTask(String[] r4, d.c.d<? super EventTaskResult> r5) {
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.executionengine.eventstaskmanager.spi.a.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new l(this, r4, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r6);
    }

    private final <T> T disabled(String r2) {
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.d(TAG, r2 + " not enable");
        return null;
    }

    private final List<EventTask> mergeTaskLists(List<? extends EventTask> r2, List<? extends EventTask> r3) {
        List<EventTask> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        List<EventTask> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L9;
        if (r4 != null) goto L8;
        return r1;
    L8:
        return p.c((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.aiagent.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin"));
    L9:
        return r4;
    }
}
