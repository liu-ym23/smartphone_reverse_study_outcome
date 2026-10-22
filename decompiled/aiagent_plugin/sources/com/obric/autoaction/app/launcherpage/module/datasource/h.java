package com.obric.autoaction.app.launcherpage.module.datasource;

import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.app.foundation.AutoActionFoundation;
import com.obric.autogui.common.api.app.foundation.FoundationStatus;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.cae.libs.useraware.ApWakeEvent;
import com.obric.eventkit.task.api.IEventTaskApi;
import com.obric.eventkit.task.api.IEventTaskListenerApi;
import com.obric.eventkit.task.api.IEventTaskRecordApi;
import com.obric.eventkit.task.api.ILegacyTimerApi;
import com.obric.eventkit.task.model.ConditionTaskRecord;
import com.obric.eventkit.task.model.EventTask;
import com.obric.eventkit.task.model.TimerTask;
import com.obric.eventkit.task.model.TimerTaskRecord;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.l;
import d.h.a.m;
import d.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.b.x;
import kotlinx.coroutines.bd;

/* JADX INFO: compiled from: TimerTaskRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h {
    private static final String TAG = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f24228a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final x<List<f>> f24229b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final x<List<TimerTaskRecord>> f24230c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final x<List<ConditionTaskRecord>> f24231d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final com.obric.eventkit.task.api.a f24232e = null;

    /* JADX INFO: compiled from: TimerTaskRepository.kt */
    @d.c.b.a.f(b = "TimerTaskRepository.kt", c = {121, 123}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.module.datasource.TimerTaskDataStore$loadAllFailedTriggerRecords$1")
    static final class a extends l implements m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24233a;

        a(d.c.d<? super a> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new a((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r12) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24233a;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            o.a(r12);
        L32:
            return d.x.f38692a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            o.a(r12);
        L15:
            List r13 = (List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.aiagent.plugin");
            if (r13 == null) goto L27;
            Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.aiagent.plugin");
            Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r15 = r14.iterator();
        L19:
            if (r15.hasNext() == false) goto L26;
            Object r5 = r15.next();
            if (((TimerTaskRecord) ZeusTransformUtils.preCheckCast(r5, TimerTaskRecord.class, "com.obric.aiagent.plugin")).getTaskStatus() != 3) goto L23;
            boolean r6 = true;
        L24:
            if (r6 == false) goto L19;
            r2.add(r5);
            goto L19
        L23:
            r6 = false;
            goto L24
        L26:
            List<TimerTaskRecord> r16 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin");
        L28:
            x<List<TimerTaskRecord>> r3 = h.f24228a.b();
            d.c.d<? super d.x> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24233a = 2;
            if (r3.emit(r16, r4) != r0) goto L32;
            return r0;
        L27:
            r16 = null;
            goto L28
        L10:
            o.a(r12);
            ILegacyTimerApi r7 = (ILegacyTimerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ILegacyTimerApi.class), ILegacyTimerApi.class, "com.obric.aiagent.plugin");
            if (r7 == null) goto L27;
            long r8 = AOSystemTools.INSTANCE.nowTimeMillis();
            d.c.d<? super List<TimerTaskRecord>> r10 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24233a = 1;
            r12 = r7.getAllTimerTaskRecords(0, r8, r10);
            if (r12 != r0) goto L15;
            return r0;
        }
    }

    /* JADX INFO: compiled from: TimerTaskRepository.kt */
    @d.c.b.a.f(b = "TimerTaskRepository.kt", c = {128, ApWakeEvent.ACCELERATING_END}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.module.datasource.TimerTaskDataStore$loadAllFailedTriggerRecords$2")
    static final class b extends l implements m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24234a;

        b(d.c.d<? super b> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r12) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24234a;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            o.a(r12);
        L34:
            return d.x.f38692a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            o.a(r12);
        L15:
            List r13 = (List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.aiagent.plugin");
            if (r13 == null) goto L29;
            List r14 = p.k((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.aiagent.plugin"));
            if (r14 == null) goto L29;
            Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin");
            Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r16 = r15.iterator();
        L21:
            if (r16.hasNext() == false) goto L28;
            Object r5 = r16.next();
            if (((ConditionTaskRecord) ZeusTransformUtils.preCheckCast(r5, ConditionTaskRecord.class, "com.obric.aiagent.plugin")).getResult() == 0) goto L25;
            boolean r6 = true;
        L26:
            if (r6 == false) goto L21;
            r2.add(r5);
            goto L21
        L25:
            r6 = false;
            goto L26
        L28:
            List<ConditionTaskRecord> r17 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin");
        L30:
            x<List<ConditionTaskRecord>> r3 = h.f24228a.c();
            d.c.d<? super d.x> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24234a = 2;
            if (r3.emit(r17, r4) != r0) goto L34;
            return r0;
        L29:
            r17 = null;
            goto L30
        L10:
            o.a(r12);
            IEventTaskRecordApi r7 = (IEventTaskRecordApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskRecordApi.class), IEventTaskRecordApi.class, "com.obric.aiagent.plugin");
            if (r7 == null) goto L29;
            long r8 = AOSystemTools.INSTANCE.nowTimeMillis();
            d.c.d<? super List<ConditionTaskRecord>> r10 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24234a = 1;
            r12 = r7.getAllConditionTaskRecords(0, r8, r10);
            if (r12 != r0) goto L15;
            return r0;
        }
    }

    /* JADX INFO: compiled from: TimerTaskRepository.kt */
    @d.c.b.a.f(b = "TimerTaskRepository.kt", c = {99, 103, 112}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.module.datasource.TimerTaskDataStore$loadAllTimerTask$1")
    static final class c extends l implements m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f24235a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f24236b;

        c(d.c.d<? super c> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24236b;
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 != 3) goto L9;
            o.a(r10);
        L48:
            return d.x.f38692a;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            List r2 = (List) ZeusTransformUtils.preCheckCast(this.f24235a, List.class, "com.obric.aiagent.plugin");
            o.a(r10);
        L32:
            List r11 = (List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.aiagent.plugin");
            if (r11 != null) goto L35;
        L34:
            r11 = p.b();
        L35:
            Loog.INSTANCE.i(h.e(), "loadAllTimerTask timerTask size = " + r2.size() + ", conditionTask size = " + r11.size());
            List r12 = p.c((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.aiagent.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.aiagent.plugin"));
            x<List<f>> r3 = h.f24228a.a();
            Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.aiagent.plugin");
            Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r14 = r13.iterator();
        L37:
            if (r14.hasNext() == false) goto L44;
            EventTask r5 = (EventTask) ZeusTransformUtils.preCheckCast(r14.next(), EventTask.class, "com.obric.aiagent.plugin");
            if (r5 == null) goto L41;
            f r6 = g.a(r5);
        L42:
            if (r6 == null) goto L37;
            r4.add(r6);
            goto L37
        L41:
            r6 = null;
            goto L42
        L44:
            List<f> r15 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin");
            d.c.d<? super d.x> r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24235a = null;
            this.f24236b = 3;
            if (r3.emit(r15, r7) != r0) goto L48;
            return r0;
        L11:
            o.a(r10);
        L17:
            List r16 = (List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.aiagent.plugin");
            if (r16 == null) goto L24;
            Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.aiagent.plugin");
            Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r17, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r18 = r17.iterator();
        L21:
            if (r18.hasNext() == false) goto L23;
            r8.add(((TimerTask) ZeusTransformUtils.preCheckCast(r18.next(), TimerTask.class, "com.obric.aiagent.plugin")).toTimerTaskV2());
            goto L21
        L23:
            List r19 = (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin");
        L25:
            if (r19 != null) goto L27;
            r19 = p.b();
        L27:
            r2 = r19;
            IEventTaskApi r110 = (IEventTaskApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskApi.class), IEventTaskApi.class, "com.obric.aiagent.plugin");
            if (r110 == null) goto L34;
            d.c.d<? super List<? extends EventTask>> r9 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24235a = r2;
            this.f24236b = 2;
            r10 = r110.getEventTasksByType(2, 0, Integer.MAX_VALUE, r9);
            if (r10 != r0) goto L32;
            return r0;
        L24:
            r19 = null;
            goto L25
        L12:
            o.a(r10);
            ILegacyTimerApi r111 = (ILegacyTimerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ILegacyTimerApi.class), ILegacyTimerApi.class, "com.obric.aiagent.plugin");
            if (r111 == null) goto L24;
            d.c.d<? super List<TimerTask>> r20 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24236b = 1;
            r10 = r111.getAllTimerTasks(r20);
            if (r10 != r0) goto L17;
            return r0;
        }
    }

    public static /* synthetic */ void lambda$SLNh2mtjlhUgJcagiIGgD3JQlQw(int r0) {
        a(r0);
    }

    private h() {
    }

    public static final /* synthetic */ String e() {
        return TAG;
    }

    static {
        h r0 = new h();
        f24228a = r0;
        TAG = "TimerTaskDataStore";
        f24229b = kotlinx.coroutines.b.am.a(null);
        f24230c = kotlinx.coroutines.b.am.a(null);
        f24231d = kotlinx.coroutines.b.am.a(null);
        f24232e = $$Lambda$h$SLNh2mtjlhUgJcagiIGgD3JQlQw.INSTANCE;
        r0.d();
        r0.f();
    }

    public final x<List<f>> a() {
        return f24229b;
    }

    public final x<List<TimerTaskRecord>> b() {
        return f24230c;
    }

    public final x<List<ConditionTaskRecord>> c() {
        return f24231d;
    }

    private static final void a(int r1) {
        if (r1 != 1) goto L5;
    L11:
        f24228a.d();
        return;
    L5:
        if (r1 == 2) goto L11;
        if (r1 == 3) goto L11;
        if (r1 == 4) goto L11;
    }

    private final void f() {
        if (AutoActionFoundation.INSTANCE.getStatus() != FoundationStatus.NotInitialised) goto L6;
        Loog.INSTANCE.e(TAG, "registerTimerTaskChangeListener: the app isn't initialised.");
        return;
    L6:
        Loog.INSTANCE.i(TAG, "listen timer task change");
        IEventTaskListenerApi r2 = (IEventTaskListenerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskListenerApi.class), IEventTaskListenerApi.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L10;
        r2.registerEventTaskChangeListener(f24232e);
        return;
    }

    public final void d() {
        if (AutoActionFoundation.INSTANCE.getStatus() != FoundationStatus.NotInitialised) goto L6;
        Loog.INSTANCE.e(TAG, "load all records: the app isn't initialised.");
        return;
    L6:
        Loog.INSTANCE.d(TAG, "load all records");
        g();
        h();
    }

    private final void g() {
        kotlinx.coroutines.i.a(an.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin")), null, null, (m) ZeusTransformUtils.preCheckCast(new c(null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final void h() {
        kotlinx.coroutines.i.a(an.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin")), null, null, (m) ZeusTransformUtils.preCheckCast(new a(null), m.class, "com.obric.aiagent.plugin"), 3, null);
        kotlinx.coroutines.i.a(an.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin")), null, null, (m) ZeusTransformUtils.preCheckCast(new b(null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final f a(String r5) {
        Object r4 = null;
        if (r5 != null) goto L5;
        return null;
    L5:
        List r0 = (List) ZeusTransformUtils.preCheckCast(f24229b.c(), List.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L18;
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L9:
        if (r1.hasNext() == false) goto L14;
        Object r2 = r1.next();
        if (d.h.b.o.a(((f) ZeusTransformUtils.preCheckCast(r2, f.class, "com.obric.aiagent.plugin")).a().getId(), r5) == false) goto L9;
        r4 = r2;
    L14:
        return (f) ZeusTransformUtils.preCheckCast(r4, f.class, "com.obric.aiagent.plugin");
    L18:
        return null;
    }
}
