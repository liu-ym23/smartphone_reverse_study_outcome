package com.obric.autoaction.app.launcherpage.module.datasource;

import android.content.Context;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.google.gson.Gson;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.presentation.ITimerTaskListener;
import com.obric.autogui.database.AutoActionDatabase;
import com.obric.capabilitykit.common.intent.IntentParams;
import com.obric.capabilitykit.common.intent.SystemAutoActionParams;
import com.obric.eventkit.task.api.IEventTaskApi;
import com.obric.eventkit.task.api.IEventTaskRecordApi;
import com.obric.eventkit.task.api.ILegacyTimerApi;
import com.obric.eventkit.task.model.Condition;
import com.obric.eventkit.task.model.ConditionTask;
import com.obric.eventkit.task.model.ConditionTaskAction;
import com.obric.eventkit.task.model.ConditionTaskRecord;
import com.obric.eventkit.task.model.ConditionTaskResult;
import com.obric.eventkit.task.model.EventTask;
import com.obric.eventkit.task.model.PeriodicPolicy;
import com.obric.eventkit.task.model.TimeCondition;
import com.obric.eventkit.task.model.TimerTask;
import com.obric.eventkit.task.model.TimerTaskAction;
import com.obric.eventkit.task.model.TimerTaskRecord;
import com.obric.eventkit.task.model.TimerTaskResult;
import com.obric.eventkit.task.model.TimerTaskV2;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.l;
import d.h.a.m;
import d.h.a.r;
import d.n;
import d.o;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.MonthDay;
import java.time.ZoneId;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.am;
import kotlinx.coroutines.b.x;
import kotlinx.coroutines.bd;

/* JADX INFO: compiled from: TimerTaskRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i implements com.obric.autoaction.app.launcherpage.module.datasource.b {
    private static final String TAG = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f24237a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Gson f24238b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final x<List<com.obric.autoaction.app.launcherpage.module.datasource.f>> f24239c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final x<List<com.obric.autoaction.app.launcherpage.module.datasource.j>> f24240d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final x<List<com.obric.autoaction.app.launcherpage.module.datasource.j>> f24241e;
    private final x<List<ConditionTaskRecord>> f;
    private final x<List<com.obric.autoaction.app.launcherpage.module.datasource.j>> g;
    private String h;

    /* JADX INFO: compiled from: TimerTaskRepository.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: TimerTaskRepository.kt */
    @d.c.b.a.f(b = "TimerTaskRepository.kt", c = {566}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.module.datasource.TimerTaskRepository$deleteConditionRecordByRecordsId$2")
    static final class b extends l implements m<am, d.c.d<? super Integer>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24242a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ List<Long> f24243b;

        b(List<Long> r3, d.c.d<? super b> r4) {
            List<Long> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24243b = r5;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super Integer> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f24243b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Integer> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24242a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L16:
            return (Integer) ZeusTransformUtils.preCheckCast(r6, Integer.class, "com.obric.aiagent.plugin");
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            IEventTaskRecordApi r7 = (IEventTaskRecordApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskRecordApi.class), IEventTaskRecordApi.class, "com.obric.aiagent.plugin");
            if (r7 == null) goto L14;
            long[] r2 = p.f((Collection) ZeusTransformUtils.preCheckCast(this.f24243b, Collection.class, "com.obric.aiagent.plugin"));
            d.c.d<? super Integer> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24242a = 1;
            r6 = r7.removeConditionTaskRecordsById(r2, r4);
            if (r6 != r0) goto L16;
            return r0;
        L14:
            return null;
        }
    }

    /* JADX INFO: compiled from: TimerTaskRepository.kt */
    @d.c.b.a.f(b = "TimerTaskRepository.kt", c = {512, 516}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.module.datasource.TimerTaskRepository$deleteTimerTask$2")
    static final class c extends l implements m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f24244a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f24245b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ List<String> f24246c;

        c(List<String> r3, d.c.d<? super c> r4) {
            List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24246c = r5;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f24246c, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r15) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24245b;
            Integer r4 = null;
            boolean r5 = true;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            o.a(r15);
        L103:
            ConditionTaskResult r14 = (ConditionTaskResult) ZeusTransformUtils.preCheckCast(r15, ConditionTaskResult.class, "com.obric.aiagent.plugin");
        L105:
            com.obric.event.task.base.report.l r16 = com.obric.event.task.base.report.l.f32861a;
            if (r14 == null) goto L112;
            List<ConditionTask> r17 = r14.getData();
            if (r17 == null) goto L112;
            ConditionTask r18 = (ConditionTask) ZeusTransformUtils.preCheckCast(p.l(r17), ConditionTask.class, "com.obric.aiagent.plugin");
            if (r18 == null) goto L112;
            r4 = d.c.b.a.b.a(r18.getTaskMode());
        L112:
            r16.a("condition", r4);
        L114:
            return d.x.f38692a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            List r2 = (List) ZeusTransformUtils.preCheckCast(this.f24244a, List.class, "com.obric.aiagent.plugin");
            o.a(r15);
        L91:
            TimerTaskResult r19 = (TimerTaskResult) ZeusTransformUtils.preCheckCast(r15, TimerTaskResult.class, "com.obric.aiagent.plugin");
            List r110 = r2;
        L92:
            if (r110 != null) goto L94;
        L96:
            r5 = false;
        L97:
            if (r5 == false) goto L114;
            IEventTaskApi r3 = (IEventTaskApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskApi.class), IEventTaskApi.class, "com.obric.aiagent.plugin");
            if (r3 == null) goto L104;
            String[] r111 = (String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(r110, Collection.class, "com.obric.aiagent.plugin")).toArray(new String[0]), String[].class, "com.obric.aiagent.plugin");
            d.c.d<? super ConditionTaskResult> r6 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24244a = null;
            this.f24245b = 2;
            r15 = r3.removeConditionTask(r111, r6);
            if (r15 != r0) goto L103;
            return r0;
        L104:
            r14 = null;
            goto L105
        L94:
            if ((!((Collection) ZeusTransformUtils.preCheckCast(r110, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) != true) goto L96;
        L10:
            o.a(r15);
            List r112 = (List) ZeusTransformUtils.preCheckCast(com.obric.autoaction.app.launcherpage.module.datasource.h.f24228a.a().c(), List.class, "com.obric.aiagent.plugin");
            if (r112 == null) goto L19;
            Iterable r113 = (Iterable) ZeusTransformUtils.preCheckCast(r112, Iterable.class, "com.obric.aiagent.plugin");
            List<String> r7 = this.f24246c;
            Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r114 = r113.iterator();
        L14:
            if (r114.hasNext() == false) goto L18;
            Object r9 = r114.next();
            if (p.a((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin"), ((com.obric.autoaction.app.launcherpage.module.datasource.f) ZeusTransformUtils.preCheckCast(r9, com.obric.autoaction.app.launcherpage.module.datasource.f.class, "com.obric.aiagent.plugin")).a().getId()) == false) goto L14;
            r8.add(r9);
            goto L14
        L18:
            List r115 = (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin");
        L20:
            if (r115 != null) goto L22;
        L43:
            if (r115 == null) goto L57;
            Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r115, Iterable.class, "com.obric.aiagent.plugin");
            Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r12 = r10.iterator();
        L46:
            if (r12.hasNext() == false) goto L50;
            Object r13 = r12.next();
            if (ZeusTransformUtils.instanceOf((com.obric.autoaction.app.launcherpage.module.datasource.f) ZeusTransformUtils.preCheckCast(r13, com.obric.autoaction.app.launcherpage.module.datasource.f.class, "com.obric.aiagent.plugin"), com.obric.autoaction.app.launcherpage.module.datasource.f.c.class) == false) goto L46;
            r11.add(r13);
            goto L46
        L50:
            Iterable r20 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
            Collection r21 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r22 = r20.iterator();
        L52:
            if (r22.hasNext() == false) goto L56;
            String r23 = ((com.obric.autoaction.app.launcherpage.module.datasource.f) ZeusTransformUtils.preCheckCast(r22.next(), com.obric.autoaction.app.launcherpage.module.datasource.f.class, "com.obric.aiagent.plugin")).a().getId();
            if (r23 == null) goto L52;
            r21.add(r23);
            goto L52
        L56:
            List r24 = (List) ZeusTransformUtils.preCheckCast(r21, List.class, "com.obric.aiagent.plugin");
        L58:
            if (r115 == null) goto L72;
            Iterable r116 = (Iterable) ZeusTransformUtils.preCheckCast(r115, Iterable.class, "com.obric.aiagent.plugin");
            Collection r25 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r117 = r116.iterator();
        L61:
            if (r117.hasNext() == false) goto L65;
            Object r26 = r117.next();
            if (ZeusTransformUtils.instanceOf((com.obric.autoaction.app.launcherpage.module.datasource.f) ZeusTransformUtils.preCheckCast(r26, com.obric.autoaction.app.launcherpage.module.datasource.f.class, "com.obric.aiagent.plugin"), com.obric.autoaction.app.launcherpage.module.datasource.f.a.class) == false) goto L61;
            r25.add(r26);
            goto L61
        L65:
            Iterable r118 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r25, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
            Collection r27 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r119 = r118.iterator();
        L67:
            if (r119.hasNext() == false) goto L71;
            String r28 = ((com.obric.autoaction.app.launcherpage.module.datasource.f) ZeusTransformUtils.preCheckCast(r119.next(), com.obric.autoaction.app.launcherpage.module.datasource.f.class, "com.obric.aiagent.plugin")).a().getId();
            if (r28 == null) goto L67;
            r27.add(r28);
            goto L67
        L71:
            r110 = (List) ZeusTransformUtils.preCheckCast(r27, List.class, "com.obric.aiagent.plugin");
        L73:
            if (r24 != null) goto L75;
        L77:
            boolean r29 = false;
        L78:
            if (r29 == false) goto L92;
            ILegacyTimerApi r30 = (ILegacyTimerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ILegacyTimerApi.class), ILegacyTimerApi.class, "com.obric.aiagent.plugin");
            if (r30 == null) goto L92;
            Iterable r31 = (Iterable) ZeusTransformUtils.preCheckCast(r24, Iterable.class, "com.obric.aiagent.plugin");
            Collection r32 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r33 = r31.iterator();
        L83:
            if (r33.hasNext() == false) goto L87;
            Integer r34 = d.o.o.d((String) ZeusTransformUtils.preCheckCast(r33.next(), String.class, "com.obric.aiagent.plugin"));
            if (r34 == null) goto L83;
            r32.add(r34);
            goto L83
        L87:
            List<Integer> r35 = (List) ZeusTransformUtils.preCheckCast(r32, List.class, "com.obric.aiagent.plugin");
            d.c.d<? super TimerTaskResult> r36 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24244a = r110;
            this.f24245b = 1;
            Object r37 = r30.removeTimerTasksByTaskId(r35, r36);
            if (r37 != r0) goto L90;
            return r0;
        L90:
            r2 = r110;
            r15 = r37;
            goto L91
        L75:
            if ((!((Collection) ZeusTransformUtils.preCheckCast(r24, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) != true) goto L77;
            r29 = true;
            goto L78
        L72:
            r110 = null;
            goto L73
        L57:
            r24 = null;
            goto L58
        L22:
            if ((!((Collection) ZeusTransformUtils.preCheckCast(r115, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L43;
            ITimerTaskListener r38 = (ITimerTaskListener) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ITimerTaskListener.class), ITimerTaskListener.class, "com.obric.aiagent.plugin");
            Iterable r39 = (Iterable) ZeusTransformUtils.preCheckCast(r115, Iterable.class, "com.obric.aiagent.plugin");
            Collection r40 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r41 = r39.iterator();
        L25:
            if (r41.hasNext() == false) goto L35;
            com.obric.autoaction.app.launcherpage.module.datasource.f r42 = (com.obric.autoaction.app.launcherpage.module.datasource.f) ZeusTransformUtils.preCheckCast(r41.next(), com.obric.autoaction.app.launcherpage.module.datasource.f.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r42, com.obric.autoaction.app.launcherpage.module.datasource.f.c.class) == false) goto L29;
            com.obric.autoaction.app.launcherpage.module.datasource.f.c r43 = (com.obric.autoaction.app.launcherpage.module.datasource.f.c) ZeusTransformUtils.preCheckCast(r42, com.obric.autoaction.app.launcherpage.module.datasource.f.c.class, "com.obric.aiagent.plugin");
        L30:
            if (r43 == null) goto L32;
            TimerTaskV2 r44 = r43.b();
        L33:
            if (r44 == null) goto L25;
            r40.add(r44);
            goto L25
        L32:
            r44 = null;
            goto L33
        L29:
            r43 = null;
            goto L30
        L35:
            Iterable r45 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r40, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
            Collection r46 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r45, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r47 = r45.iterator();
        L37:
            if (r47.hasNext() == false) goto L42;
            TimerTaskV2 r48 = (TimerTaskV2) ZeusTransformUtils.preCheckCast(r47.next(), TimerTaskV2.class, "com.obric.aiagent.plugin");
            String r120 = r48.getId();
            if (r120 != null) goto L41;
            r120 = "";
        L41:
            r46.add(new ITimerTaskListener.TimerTask(r120, r48.getAction(), r48.getExt()));
            goto L37
        L42:
            ITimerTaskListener.DefaultImpls.onTimerTaskRemoved$default(r38, (List) ZeusTransformUtils.preCheckCast(r46, List.class, "com.obric.aiagent.plugin"), false, 2, null);
            goto L43
        L19:
            r115 = null;
            goto L20
        }
    }

    /* JADX INFO: compiled from: TimerTaskRepository.kt */
    @d.c.b.a.f(b = "TimerTaskRepository.kt", c = {525}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.module.datasource.TimerTaskRepository$deleteTriggerRecordByRecordsId$2")
    static final class d extends l implements m<am, d.c.d<? super Integer>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24247a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ List<Integer> f24248b;

        d(List<Integer> r3, d.c.d<? super d> r4) {
            List<Integer> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24248b = r5;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super Integer> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f24248b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Integer> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24247a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L16:
            return (Integer) ZeusTransformUtils.preCheckCast(r6, Integer.class, "com.obric.aiagent.plugin");
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            ILegacyTimerApi r7 = (ILegacyTimerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ILegacyTimerApi.class), ILegacyTimerApi.class, "com.obric.aiagent.plugin");
            if (r7 == null) goto L14;
            int[] r2 = p.e((Collection) ZeusTransformUtils.preCheckCast(this.f24248b, Collection.class, "com.obric.aiagent.plugin"));
            d.c.d<? super Integer> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24247a = 1;
            r6 = r7.removeTimerTaskRecordsById(r2, r4);
            if (r6 != r0) goto L16;
            return r0;
        L14:
            return null;
        }
    }

    /* JADX INFO: compiled from: TimerTaskRepository.kt */
    @d.c.b.a.f(b = "TimerTaskRepository.kt", c = {532, 536, 544, 549, 557}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.module.datasource.TimerTaskRepository$deleteTriggerRecordByTimerTaskId$2")
    static final class e extends l implements m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24249a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f24250b;

        e(String r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24250b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f24250b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r18) {
            Object r1 = d.c.a.b.a();
            int r2 = this.f24249a;
            List r8 = null;
            if (r2 == 0) goto L16;
            if (r2 == 1) goto L15;
            if (r2 == 2) goto L14;
            if (r2 == 3) goto L13;
            if (r2 == 4) goto L12;
            if (r2 != 5) goto L11;
            o.a(r18);
            Object r0 = r18;
        L78:
            Integer r3 = (Integer) ZeusTransformUtils.preCheckCast(r0, Integer.class, "com.obric.aiagent.plugin");
        L80:
            return d.x.f38692a;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            o.a(r18);
            Object r4 = r18;
        L60:
            List r5 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin");
            if (r5 == null) goto L72;
            Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin");
            Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r9 = r6.iterator();
        L64:
            if (r9.hasNext() == false) goto L71;
            ConditionTaskRecord r10 = (ConditionTaskRecord) ZeusTransformUtils.preCheckCast(r9.next(), ConditionTaskRecord.class, "com.obric.aiagent.plugin");
            if (r10 == null) goto L68;
            Long r11 = d.c.b.a.b.a(r10.getId());
        L69:
            if (r11 == null) goto L64;
            r7.add(r11);
            goto L64
        L68:
            r11 = null;
            goto L69
        L71:
            r8 = (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.aiagent.plugin");
        L72:
            if (r8 == null) goto L80;
            IEventTaskRecordApi r12 = (IEventTaskRecordApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskRecordApi.class), IEventTaskRecordApi.class, "com.obric.aiagent.plugin");
            if (r12 == null) goto L80;
            long[] r13 = p.f((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.aiagent.plugin"));
            d.c.d<? super Integer> r14 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24249a = 5;
            r0 = r12.removeConditionTaskRecordsById(r13, r14);
            if (r0 != r1) goto L78;
            return r1;
        L13:
            o.a(r18);
            Object r15 = r18;
        L52:
            Integer r16 = (Integer) ZeusTransformUtils.preCheckCast(r15, Integer.class, "com.obric.aiagent.plugin");
            goto L80
        L14:
            o.a(r18);
            Object r17 = r18;
        L32:
            List r19 = (List) ZeusTransformUtils.preCheckCast(r17, List.class, "com.obric.aiagent.plugin");
            if (r19 == null) goto L46;
            Iterable r20 = (Iterable) ZeusTransformUtils.preCheckCast(r19, Iterable.class, "com.obric.aiagent.plugin");
            Collection r21 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r22 = r20.iterator();
        L36:
            if (r22.hasNext() == false) goto L43;
            TimerTaskRecord r23 = (TimerTaskRecord) ZeusTransformUtils.preCheckCast(r22.next(), TimerTaskRecord.class, "com.obric.aiagent.plugin");
            if (r23 == null) goto L40;
            Integer r24 = d.c.b.a.b.a(r23.getId());
        L41:
            if (r24 == null) goto L36;
            r21.add(r24);
            goto L36
        L40:
            r24 = null;
            goto L41
        L43:
            r8 = (List) ZeusTransformUtils.preCheckCast(r21, List.class, "com.obric.aiagent.plugin");
        L46:
            if (r8 == null) goto L80;
            ILegacyTimerApi r25 = (ILegacyTimerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ILegacyTimerApi.class), ILegacyTimerApi.class, "com.obric.aiagent.plugin");
            if (r25 == null) goto L80;
            int[] r26 = p.e((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.aiagent.plugin"));
            d.c.d<? super Integer> r27 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24249a = 3;
            r15 = r25.removeTimerTaskRecordsById(r26, r27);
            if (r15 != r1) goto L52;
            return r1;
        L15:
            o.a(r18);
            Object r28 = r18;
        L21:
            EventTask r29 = (EventTask) ZeusTransformUtils.preCheckCast(r28, EventTask.class, "com.obric.aiagent.plugin");
        L24:
            if (ZeusTransformUtils.instanceOf(r29, TimerTaskV2.class) == false) goto L54;
            ILegacyTimerApi r110 = (ILegacyTimerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ILegacyTimerApi.class), ILegacyTimerApi.class, "com.obric.aiagent.plugin");
            if (r110 == null) goto L46;
            long r111 = AOSystemTools.INSTANCE.nowTimeMillis();
            Integer r30 = d.o.o.d(this.f24250b);
            if (r30 == null) goto L45;
            int r112 = r30.intValue();
            d.c.d<? super List<TimerTaskRecord>> r113 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24249a = 2;
            r17 = r110.getTimerTaskRecordsByTaskId(0, r111, r112, r113);
            if (r17 != r1) goto L32;
            return r1;
        L45:
            return d.x.f38692a;
        L54:
            if (ZeusTransformUtils.instanceOf(r29, ConditionTask.class) == false) goto L80;
            IEventTaskRecordApi r114 = (IEventTaskRecordApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskRecordApi.class), IEventTaskRecordApi.class, "com.obric.aiagent.plugin");
            if (r114 == null) goto L72;
            long r115 = AOSystemTools.INSTANCE.nowTimeMillis();
            String r116 = this.f24250b;
            d.c.d<? super List<ConditionTaskRecord>> r117 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24249a = 4;
            r4 = r114.getConditionTaskRecordsByTaskId(0, r115, r116, r117);
            if (r4 != r1) goto L60;
            return r1;
        L16:
            o.a(r18);
            IEventTaskApi r31 = (IEventTaskApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskApi.class), IEventTaskApi.class, "com.obric.aiagent.plugin");
            if (r31 == null) goto L22;
            String r118 = this.f24250b;
            d.c.d<? super EventTask> r119 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24249a = 1;
            r28 = r31.getEventTask(r118, r119);
            if (r28 != r1) goto L21;
            return r1;
        L22:
            r29 = null;
            goto L24
        }
    }

    /* JADX INFO: compiled from: TimerTaskRepository.kt */
    @d.c.b.a.f(b = "TimerTaskRepository.kt", c = {176}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.module.datasource.TimerTaskRepository$init$1")
    static final class f extends l implements m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24251a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i f24252b;

        /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.module.datasource.i$f$1, reason: invalid class name */
        /* JADX INFO: compiled from: TimerTaskRepository.kt */
        @d.c.b.a.f(b = "TimerTaskRepository.kt", c = {182}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.module.datasource.TimerTaskRepository$init$1$1")
        static final class AnonymousClass1 extends l implements m<List<? extends com.obric.autoaction.app.launcherpage.module.datasource.f>, d.c.d<? super d.x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f24253a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f24254b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ i f24255c;

            AnonymousClass1(i r3, d.c.d<? super AnonymousClass1> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f24255c = r3;
                super(2, r5);
            }

            public final Object a(List<? extends com.obric.autoaction.app.launcherpage.module.datasource.f> r3, d.c.d<? super d.x> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                AnonymousClass1 r0 = new AnonymousClass1(this.f24255c, r5);
                r0.f24254b = r3;
                return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(List<? extends com.obric.autoaction.app.launcherpage.module.datasource.f> r3, d.c.d<? super d.x> r4) {
                return a((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r9) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f24253a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                o.a(r9);
            L24:
                return d.x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                o.a(r9);
                List<com.obric.autoaction.app.launcherpage.module.datasource.f> r10 = (List) ZeusTransformUtils.preCheckCast(this.f24254b, List.class, "com.obric.aiagent.plugin");
                if (this.f24255c.e() == null) goto L20;
                if (r10 == null) goto L19;
                Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin");
                i r2 = this.f24255c;
                Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
                Iterator r12 = r11.iterator();
            L14:
                if (r12.hasNext() == false) goto L18;
                Object r5 = r12.next();
                if (d.h.b.o.a(((com.obric.autoaction.app.launcherpage.module.datasource.f) ZeusTransformUtils.preCheckCast(r5, com.obric.autoaction.app.launcherpage.module.datasource.f.class, "com.obric.aiagent.plugin")).a().getId(), r2.e()) == false) goto L14;
                r4.add(r5);
                goto L14
            L18:
                r10 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin");
                goto L20
            L19:
                r10 = null;
            L20:
                x<List<com.obric.autoaction.app.launcherpage.module.datasource.f>> r3 = this.f24255c.a();
                d.c.d<? super d.x> r6 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f24253a = 1;
                if (r3.emit(r10, r6) != r0) goto L24;
                return r0;
            }
        }

        f(i r3, d.c.d<? super f> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24252b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new f(this.f24252b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24251a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r7);
        L12:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r7);
            kotlinx.coroutines.b.h r8 = (kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(com.obric.autoaction.app.launcherpage.module.datasource.h.f24228a.a(), kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");
            m r2 = (m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f24252b, null), m.class, "com.obric.aiagent.plugin");
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24251a = 1;
            if (kotlinx.coroutines.b.j.a(r8, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: TimerTaskRepository.kt */
    @d.c.b.a.f(b = "TimerTaskRepository.kt", c = {}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.module.datasource.TimerTaskRepository$init$2")
    static final class g extends l implements r<List<? extends com.obric.autoaction.app.launcherpage.module.datasource.f>, List<? extends TimerTaskRecord>, List<? extends ConditionTaskRecord>, d.c.d<? super d.r<? extends List<? extends com.obric.autoaction.app.launcherpage.module.datasource.j>, ? extends List<? extends com.obric.autoaction.app.launcherpage.module.datasource.j>, ? extends List<? extends com.obric.autoaction.app.launcherpage.module.datasource.j>>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24256a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f24257b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f24258c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f24259d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ i f24260e;

        g(i r3, d.c.d<? super g> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24260e = r3;
            super(4, r5);
        }

        @Override // d.h.a.r
        public /* synthetic */ Object a(List<? extends com.obric.autoaction.app.launcherpage.module.datasource.f> r3, List<? extends TimerTaskRecord> r4, List<? extends ConditionTaskRecord> r5, d.c.d<? super d.r<? extends List<? extends com.obric.autoaction.app.launcherpage.module.datasource.j>, ? extends List<? extends com.obric.autoaction.app.launcherpage.module.datasource.j>, ? extends List<? extends com.obric.autoaction.app.launcherpage.module.datasource.j>>> r6) {
            return a2((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin"), (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin"), (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r6, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public final Object a2(List<? extends com.obric.autoaction.app.launcherpage.module.datasource.f> r3, List<TimerTaskRecord> r4, List<ConditionTaskRecord> r5, d.c.d<? super d.r<? extends List<com.obric.autoaction.app.launcherpage.module.datasource.j>, ? extends List<com.obric.autoaction.app.launcherpage.module.datasource.j>, ? extends List<com.obric.autoaction.app.launcherpage.module.datasource.j>>> r6) {
            List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            g r0 = new g(this.f24260e, r10);
            r0.f24257b = r7;
            r0.f24258c = r8;
            r0.f24259d = r9;
            return r0.invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r15) {
            d.c.a.b.a();
            if (this.f24256a != 0) goto L126;
            o.a(r15);
            List r16 = (List) ZeusTransformUtils.preCheckCast(this.f24257b, List.class, "com.obric.aiagent.plugin");
            List r0 = (List) ZeusTransformUtils.preCheckCast(this.f24258c, List.class, "com.obric.aiagent.plugin");
            List r2 = (List) ZeusTransformUtils.preCheckCast(this.f24259d, List.class, "com.obric.aiagent.plugin");
            List r5 = null;
            if (r16 == null) goto L25;
            Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.aiagent.plugin");
            Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r8 = r6.iterator();
        L8:
            if (r8.hasNext() == false) goto L18;
            Object r9 = r8.next();
            Integer r10 = ((com.obric.autoaction.app.launcherpage.module.datasource.f) ZeusTransformUtils.preCheckCast(r9, com.obric.autoaction.app.launcherpage.module.datasource.f.class, "com.obric.aiagent.plugin")).a().getEnableStatus();
            if (r10 != null) goto L13;
        L15:
            boolean r11 = false;
        L16:
            if (r11 == false) goto L8;
            r7.add(r9);
            goto L8
        L13:
            if (r10.intValue() != 0) goto L15;
            r11 = true;
            goto L16
        L18:
            Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
            i r13 = this.f24260e;
            Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r17 = r12.iterator();
        L20:
            if (r17.hasNext() == false) goto L24;
            com.obric.autoaction.app.launcherpage.module.datasource.j r18 = i.a(r13, (com.obric.autoaction.app.launcherpage.module.datasource.f) ZeusTransformUtils.preCheckCast(r17.next(), com.obric.autoaction.app.launcherpage.module.datasource.f.class, "com.obric.aiagent.plugin"));
            if (r18 == null) goto L20;
            r14.add(r18);
            goto L20
        L24:
            List r19 = (List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.aiagent.plugin");
        L26:
            if (r19 != null) goto L28;
            r19 = p.b();
        L28:
            if (r0 == null) goto L73;
            Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin");
            Collection r20 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r3 = r1.iterator();
        L31:
            if (r3.hasNext() == false) goto L38;
            Object r21 = r3.next();
            if (((TimerTaskRecord) ZeusTransformUtils.preCheckCast(r21, TimerTaskRecord.class, "com.obric.aiagent.plugin")).getTaskStatus() != 3) goto L35;
            boolean r22 = true;
        L36:
            if (r22 == false) goto L31;
            r20.add(r21);
            goto L31
        L35:
            r22 = false;
            goto L36
        L38:
            Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r20, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
            i r23 = this.f24260e;
            Collection r24 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r25 = r4.iterator();
        L40:
            if (r25.hasNext() == false) goto L50;
            Object r26 = r25.next();
            TimerTaskRecord r110 = (TimerTaskRecord) ZeusTransformUtils.preCheckCast(r26, TimerTaskRecord.class, "com.obric.aiagent.plugin");
            if (r23.e() != null) goto L44;
        L47:
            boolean r111 = true;
        L48:
            if (r111 == false) goto L40;
            r24.add(r26);
            goto L40
        L44:
            if (d.h.b.o.a(r110.getTaskId().toString(), r23.e()) == true) goto L47;
            r111 = false;
            goto L48
        L50:
            Iterable r27 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r24, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
            i r28 = this.f24260e;
            Collection r29 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r30 = r27.iterator();
        L52:
            if (r30.hasNext() == false) goto L72;
            TimerTaskRecord r31 = (TimerTaskRecord) ZeusTransformUtils.preCheckCast(r30.next(), TimerTaskRecord.class, "com.obric.aiagent.plugin");
            if (r16 == null) goto L68;
            Iterable r112 = (Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.aiagent.plugin");
            Collection r113 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r114 = r112.iterator();
        L57:
            if (r114.hasNext() == false) goto L67;
            com.obric.autoaction.app.launcherpage.module.datasource.f r115 = (com.obric.autoaction.app.launcherpage.module.datasource.f) ZeusTransformUtils.preCheckCast(r114.next(), com.obric.autoaction.app.launcherpage.module.datasource.f.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r115, com.obric.autoaction.app.launcherpage.module.datasource.f.c.class) == false) goto L61;
            com.obric.autoaction.app.launcherpage.module.datasource.f.c r116 = (com.obric.autoaction.app.launcherpage.module.datasource.f.c) ZeusTransformUtils.preCheckCast(r115, com.obric.autoaction.app.launcherpage.module.datasource.f.c.class, "com.obric.aiagent.plugin");
        L62:
            if (r116 == null) goto L64;
            TimerTaskV2 r117 = r116.b();
        L65:
            if (r117 == null) goto L57;
            r113.add(r117);
            goto L57
        L64:
            r117 = null;
            goto L65
        L61:
            r116 = null;
            goto L62
        L67:
            List r118 = (List) ZeusTransformUtils.preCheckCast(r113, List.class, "com.obric.aiagent.plugin");
        L69:
            com.obric.autoaction.app.launcherpage.module.datasource.j r32 = i.a(r28, r31, r118);
            if (r32 == null) goto L52;
            r29.add(r32);
            goto L52
        L68:
            r118 = p.b();
            goto L69
        L72:
            List r33 = (List) ZeusTransformUtils.preCheckCast(r29, List.class, "com.obric.aiagent.plugin");
        L74:
            if (r33 != null) goto L76;
            r33 = p.b();
        L76:
            if (r2 == null) goto L121;
            Iterable r34 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin");
            Collection r35 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r36 = r34.iterator();
        L79:
            if (r36.hasNext() == false) goto L86;
            Object r37 = r36.next();
            if (((ConditionTaskRecord) ZeusTransformUtils.preCheckCast(r37, ConditionTaskRecord.class, "com.obric.aiagent.plugin")).getResult() == 0) goto L83;
            boolean r38 = true;
        L84:
            if (r38 == false) goto L79;
            r35.add(r37);
            goto L79
        L83:
            r38 = false;
            goto L84
        L86:
            Iterable r39 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r35, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
            i r40 = this.f24260e;
            Collection r41 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r42 = r39.iterator();
        L88:
            if (r42.hasNext() == false) goto L98;
            Object r43 = r42.next();
            ConditionTaskRecord r119 = (ConditionTaskRecord) ZeusTransformUtils.preCheckCast(r43, ConditionTaskRecord.class, "com.obric.aiagent.plugin");
            if (r40.e() != null) goto L92;
        L95:
            boolean r120 = true;
        L96:
            if (r120 == false) goto L88;
            r41.add(r43);
            goto L88
        L92:
            if (d.h.b.o.a(String.valueOf(r119.getTaskId()), r40.e()) == true) goto L95;
            r120 = false;
            goto L96
        L98:
            Iterable r44 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r41, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
            i r121 = this.f24260e;
            Collection r45 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r46 = r44.iterator();
        L100:
            if (r46.hasNext() == false) goto L120;
            ConditionTaskRecord r47 = (ConditionTaskRecord) ZeusTransformUtils.preCheckCast(r46.next(), ConditionTaskRecord.class, "com.obric.aiagent.plugin");
            if (r16 == null) goto L116;
            Iterable r48 = (Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.aiagent.plugin");
            Collection r49 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r50 = r48.iterator();
        L105:
            if (r50.hasNext() == false) goto L115;
            com.obric.autoaction.app.launcherpage.module.datasource.f r51 = (com.obric.autoaction.app.launcherpage.module.datasource.f) ZeusTransformUtils.preCheckCast(r50.next(), com.obric.autoaction.app.launcherpage.module.datasource.f.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r51, com.obric.autoaction.app.launcherpage.module.datasource.f.a.class) == false) goto L109;
            com.obric.autoaction.app.launcherpage.module.datasource.f.a r52 = (com.obric.autoaction.app.launcherpage.module.datasource.f.a) ZeusTransformUtils.preCheckCast(r51, com.obric.autoaction.app.launcherpage.module.datasource.f.a.class, "com.obric.aiagent.plugin");
        L110:
            if (r52 == null) goto L112;
            ConditionTask r53 = r52.b();
        L113:
            if (r53 == null) goto L105;
            r49.add(r53);
            goto L105
        L112:
            r53 = null;
            goto L113
        L109:
            r52 = null;
            goto L110
        L115:
            List r54 = (List) ZeusTransformUtils.preCheckCast(r49, List.class, "com.obric.aiagent.plugin");
        L117:
            com.obric.autoaction.app.launcherpage.module.datasource.j r55 = i.a(r121, r47, r54);
            if (r55 == null) goto L100;
            r45.add(r55);
            goto L100
        L116:
            r54 = p.b();
            goto L117
        L120:
            r5 = (List) ZeusTransformUtils.preCheckCast(r45, List.class, "com.obric.aiagent.plugin");
        L121:
            if (r5 != null) goto L124;
            r5 = p.b();
        L124:
            return new d.r(r19, r33, r5);
        L73:
            r33 = null;
            goto L74
        L25:
            r19 = null;
            goto L26
        L126:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: TimerTaskRepository.kt */
    @d.c.b.a.f(b = "TimerTaskRepository.kt", c = {}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.module.datasource.TimerTaskRepository$init$3")
    static final class h extends l implements m<d.r<? extends List<? extends com.obric.autoaction.app.launcherpage.module.datasource.j>, ? extends List<? extends com.obric.autoaction.app.launcherpage.module.datasource.j>, ? extends List<? extends com.obric.autoaction.app.launcherpage.module.datasource.j>>, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24261a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f24262b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ i f24263c;

        h(i r3, d.c.d<? super h> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24263c = r3;
            super(2, r5);
        }

        public final Object a(d.r<? extends List<com.obric.autoaction.app.launcherpage.module.datasource.j>, ? extends List<com.obric.autoaction.app.launcherpage.module.datasource.j>, ? extends List<com.obric.autoaction.app.launcherpage.module.datasource.j>> r3, d.c.d<? super d.x> r4) {
            return ((h) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            h r0 = new h(this.f24263c, r5);
            r0.f24262b = r3;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(d.r<? extends List<? extends com.obric.autoaction.app.launcherpage.module.datasource.j>, ? extends List<? extends com.obric.autoaction.app.launcherpage.module.datasource.j>, ? extends List<? extends com.obric.autoaction.app.launcherpage.module.datasource.j>> r3, d.c.d<? super d.x> r4) {
            return a((d.r) ZeusTransformUtils.preCheckCast(r3, d.r.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            d.c.a.b.a();
            if (this.f24261a != 0) goto L16;
            o.a(r8);
            d.r r9 = (d.r) ZeusTransformUtils.preCheckCast(this.f24262b, d.r.class, "com.obric.aiagent.plugin");
            List<com.obric.autoaction.app.launcherpage.module.datasource.j> r0 = (List) ZeusTransformUtils.preCheckCast(r9.d(), List.class, "com.obric.aiagent.plugin");
            List r2 = (List) ZeusTransformUtils.preCheckCast(r9.e(), List.class, "com.obric.aiagent.plugin");
            List r10 = (List) ZeusTransformUtils.preCheckCast(r9.f(), List.class, "com.obric.aiagent.plugin");
            x<List<com.obric.autoaction.app.launcherpage.module.datasource.j>> r3 = this.f24263c.c();
        L5:
            List<com.obric.autoaction.app.launcherpage.module.datasource.j> r4 = r3.c();
            List r5 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin");
            if (r3.a(r4, p.c((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.aiagent.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin"))) == false) goto L5;
            x<List<com.obric.autoaction.app.launcherpage.module.datasource.j>> r6 = this.f24263c.d();
        L8:
            List<com.obric.autoaction.app.launcherpage.module.datasource.j> r7 = r6.c();
            List r11 = (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.aiagent.plugin");
            if (r6.a(r7, r0) == false) goto L8;
            x<List<com.obric.autoaction.app.launcherpage.module.datasource.j>> r12 = this.f24263c.b();
        L11:
            List<com.obric.autoaction.app.launcherpage.module.datasource.j> r13 = r12.c();
            List r14 = (List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.aiagent.plugin");
            if (r12.a(r13, p.c((Collection) ZeusTransformUtils.preCheckCast(p.c((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.aiagent.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin")), Collection.class, "com.obric.aiagent.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin"))) == false) goto L11;
            return d.x.f38692a;
        L16:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.module.datasource.i$i, reason: collision with other inner class name */
    /* JADX INFO: compiled from: TimerTaskRepository.kt */
    @d.c.b.a.f(b = "TimerTaskRepository.kt", c = {455}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.module.datasource.TimerTaskRepository$queryTimerTaskTriggerRecord$2")
    static final class C0555i extends l implements m<am, d.c.d<? super List<? extends com.obric.autoaction.app.launcherpage.module.datasource.d>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24264a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i f24265b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f24266c;

        /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.module.datasource.i$i$a */
        /* JADX INFO: compiled from: Comparisons.kt */
        public static final class a<T> implements Comparator {
            public a() {
            }

            @Override // java.util.Comparator
            public final int compare(T r4, T r5) {
                return d.b.a.a((Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((com.obric.autoaction.app.launcherpage.module.datasource.d) ZeusTransformUtils.preCheckCast(r5, com.obric.autoaction.app.launcherpage.module.datasource.d.class, "com.obric.aiagent.plugin")).a()), Comparable.class, "com.obric.aiagent.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((com.obric.autoaction.app.launcherpage.module.datasource.d) ZeusTransformUtils.preCheckCast(r4, com.obric.autoaction.app.launcherpage.module.datasource.d.class, "com.obric.aiagent.plugin")).a()), Comparable.class, "com.obric.aiagent.plugin"));
            }
        }

        C0555i(i r3, String r4, d.c.d<? super C0555i> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24265b = r3;
            this.f24266c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super List<com.obric.autoaction.app.launcherpage.module.datasource.d>> r4) {
            return ((C0555i) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0555i.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new C0555i(this.f24265b, this.f24266c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super List<? extends com.obric.autoaction.app.launcherpage.module.datasource.d>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r14) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24264a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r14);
        L15:
            List r15 = (List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.aiagent.plugin");
            if (r15 != null) goto L18;
            r15 = p.b();
        L18:
            List r2 = (List) ZeusTransformUtils.preCheckCast(com.obric.autoaction.app.launcherpage.module.datasource.h.f24228a.b().c(), List.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L47;
            Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin");
            String r6 = this.f24266c;
            Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r4 = r3.iterator();
        L22:
            if (r4.hasNext() == false) goto L26;
            Object r8 = r4.next();
            if (d.h.b.o.a(((TimerTaskRecord) ZeusTransformUtils.preCheckCast(r8, TimerTaskRecord.class, "com.obric.aiagent.plugin")).getTaskId(), r6) == false) goto L22;
            r7.add(r8);
            goto L22
        L26:
            Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
            i r9 = this.f24265b;
            Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r5, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r11 = r5.iterator();
        L28:
            if (r11.hasNext() == false) goto L46;
            TimerTaskRecord r12 = (TimerTaskRecord) ZeusTransformUtils.preCheckCast(r11.next(), TimerTaskRecord.class, "com.obric.aiagent.plugin");
            List r13 = (List) ZeusTransformUtils.preCheckCast(com.obric.autoaction.app.launcherpage.module.datasource.h.f24228a.a().c(), List.class, "com.obric.aiagent.plugin");
            if (r13 == null) goto L44;
            Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.aiagent.plugin");
            Collection r17 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r18 = r16.iterator();
        L33:
            if (r18.hasNext() == false) goto L43;
            com.obric.autoaction.app.launcherpage.module.datasource.f r19 = (com.obric.autoaction.app.launcherpage.module.datasource.f) ZeusTransformUtils.preCheckCast(r18.next(), com.obric.autoaction.app.launcherpage.module.datasource.f.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r19, com.obric.autoaction.app.launcherpage.module.datasource.f.c.class) == false) goto L37;
            com.obric.autoaction.app.launcherpage.module.datasource.f.c r110 = (com.obric.autoaction.app.launcherpage.module.datasource.f.c) ZeusTransformUtils.preCheckCast(r19, com.obric.autoaction.app.launcherpage.module.datasource.f.c.class, "com.obric.aiagent.plugin");
        L38:
            if (r110 == null) goto L40;
            TimerTaskV2 r111 = r110.b();
        L41:
            if (r111 == null) goto L33;
            r17.add(r111);
            goto L33
        L40:
            r111 = null;
            goto L41
        L37:
            r110 = null;
            goto L38
        L43:
            List r20 = (List) ZeusTransformUtils.preCheckCast(r17, List.class, "com.obric.aiagent.plugin");
        L45:
            r10.add(i.a(r9, r12, r20));
            goto L28
        L44:
            r20 = p.b();
            goto L45
        L46:
            List r21 = (List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.aiagent.plugin");
        L48:
            List r22 = (List) ZeusTransformUtils.preCheckCast(com.obric.autoaction.app.launcherpage.module.datasource.h.f24228a.c().c(), List.class, "com.obric.aiagent.plugin");
            if (r22 == null) goto L77;
            Iterable r23 = (Iterable) ZeusTransformUtils.preCheckCast(r22, Iterable.class, "com.obric.aiagent.plugin");
            String r24 = this.f24266c;
            Collection r25 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r26 = r23.iterator();
        L52:
            if (r26.hasNext() == false) goto L56;
            Object r27 = r26.next();
            if (d.h.b.o.a(((ConditionTaskRecord) ZeusTransformUtils.preCheckCast(r27, ConditionTaskRecord.class, "com.obric.aiagent.plugin")).getTaskId(), r24) == false) goto L52;
            r25.add(r27);
            goto L52
        L56:
            Iterable r28 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r25, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
            i r112 = this.f24265b;
            Collection r29 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r28, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r30 = r28.iterator();
        L58:
            if (r30.hasNext() == false) goto L76;
            ConditionTaskRecord r31 = (ConditionTaskRecord) ZeusTransformUtils.preCheckCast(r30.next(), ConditionTaskRecord.class, "com.obric.aiagent.plugin");
            List r32 = (List) ZeusTransformUtils.preCheckCast(com.obric.autoaction.app.launcherpage.module.datasource.h.f24228a.a().c(), List.class, "com.obric.aiagent.plugin");
            if (r32 == null) goto L74;
            Iterable r33 = (Iterable) ZeusTransformUtils.preCheckCast(r32, Iterable.class, "com.obric.aiagent.plugin");
            Collection r113 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r34 = r33.iterator();
        L63:
            if (r34.hasNext() == false) goto L73;
            com.obric.autoaction.app.launcherpage.module.datasource.f r114 = (com.obric.autoaction.app.launcherpage.module.datasource.f) ZeusTransformUtils.preCheckCast(r34.next(), com.obric.autoaction.app.launcherpage.module.datasource.f.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r114, com.obric.autoaction.app.launcherpage.module.datasource.f.a.class) == false) goto L67;
            com.obric.autoaction.app.launcherpage.module.datasource.f.a r115 = (com.obric.autoaction.app.launcherpage.module.datasource.f.a) ZeusTransformUtils.preCheckCast(r114, com.obric.autoaction.app.launcherpage.module.datasource.f.a.class, "com.obric.aiagent.plugin");
        L68:
            if (r115 == null) goto L70;
            ConditionTask r116 = r115.b();
        L71:
            if (r116 == null) goto L63;
            r113.add(r116);
            goto L63
        L70:
            r116 = null;
            goto L71
        L67:
            r115 = null;
            goto L68
        L73:
            List r35 = (List) ZeusTransformUtils.preCheckCast(r113, List.class, "com.obric.aiagent.plugin");
        L75:
            r29.add(i.a(r112, r31, r35));
            goto L58
        L74:
            r35 = p.b();
            goto L75
        L76:
            List r117 = (List) ZeusTransformUtils.preCheckCast(r29, List.class, "com.obric.aiagent.plugin");
        L78:
            List r118 = p.k((Iterable) ZeusTransformUtils.preCheckCast(p.c((Collection) ZeusTransformUtils.preCheckCast(r21, Collection.class, "com.obric.aiagent.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r117, Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin"));
            Iterable r119 = (Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.aiagent.plugin");
            Collection r36 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r120 = r119.iterator();
        L80:
            if (r120.hasNext() == false) goto L84;
            Object r37 = r120.next();
            if (com.obric.autoaction.app.launcherpage.module.a.a.l.f24026a.a((com.obric.autogui.database.entity.a) ZeusTransformUtils.preCheckCast(r37, com.obric.autogui.database.entity.a.class, "com.obric.aiagent.plugin")) == false) goto L80;
            r36.add(r37);
            goto L80
        L84:
            Iterable r121 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r36, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
            Collection r38 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r121, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r122 = r121.iterator();
        L86:
            if (r122.hasNext() == false) goto L94;
            com.obric.autogui.database.entity.a r39 = (com.obric.autogui.database.entity.a) ZeusTransformUtils.preCheckCast(r122.next(), com.obric.autogui.database.entity.a.class, "com.obric.aiagent.plugin");
            if (r39.j() != 3) goto L90;
        L92:
            boolean r40 = false;
        L93:
            r38.add(new com.obric.autoaction.app.launcherpage.module.datasource.d(r40, r39.d(), r39.g()));
            goto L86
        L90:
            if (r39.j() == 4) goto L92;
            r40 = true;
            goto L93
        L94:
            Collection r123 = (Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r38, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin");
            Iterable r124 = (Iterable) ZeusTransformUtils.preCheckCast(r118, Iterable.class, "com.obric.aiagent.plugin");
            Collection r41 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r124, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r125 = r124.iterator();
        L96:
            if (r125.hasNext() == false) goto L99;
            r41.add(new com.obric.autoaction.app.launcherpage.module.datasource.d(false, ((com.obric.autoaction.app.launcherpage.module.datasource.j) ZeusTransformUtils.preCheckCast(r125.next(), com.obric.autoaction.app.launcherpage.module.datasource.j.class, "com.obric.aiagent.plugin")).d(), 0));
            goto L96
        L99:
            return p.a((Iterable) ZeusTransformUtils.preCheckCast(p.c(r123, (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r41, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new a(), Comparator.class, "com.obric.aiagent.plugin"));
        L77:
            r117 = p.b();
            goto L78
        L47:
            r21 = p.b();
            goto L48
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r14);
            com.obric.autogui.database.a r126 = i.a(this.f24265b);
            if (r126 != null) goto L12;
            Loog.INSTANCE.e(i.f(), "queryTimerTaskTriggerRecord: dbUtils is null");
            return p.b();
        L12:
            kotlinx.coroutines.b.h<List<com.obric.autogui.database.entity.a>> r127 = r126.a(1000, 0, this.f24266c);
            d.c.d r42 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24264a = 1;
            r14 = kotlinx.coroutines.b.j.c(r127, r42);
            if (r14 != r0) goto L15;
            return r0;
        }
    }

    /* JADX INFO: compiled from: TimerTaskRepository.kt */
    @d.c.b.a.f(b = "TimerTaskRepository.kt", c = {575}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.module.datasource.TimerTaskRepository$skipTimerTask$2")
    static final class j extends l implements m<am, d.c.d<? super TimerTaskResult>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24267a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f24268b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ List<Long> f24269c;

        j(String r3, List<Long> r4, d.c.d<? super j> r5) {
            List<Long> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24268b = r3;
            this.f24269c = r6;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super TimerTaskResult> r4) {
            return ((j) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), j.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new j(this.f24268b, this.f24269c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super TimerTaskResult> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24267a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r7);
        L16:
            return (TimerTaskResult) ZeusTransformUtils.preCheckCast(r7, TimerTaskResult.class, "com.obric.aiagent.plugin");
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r7);
            Integer r8 = d.o.o.d(this.f24268b);
            if (r8 == null) goto L17;
            int r9 = r8.intValue();
            ILegacyTimerApi r2 = (ILegacyTimerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ILegacyTimerApi.class), ILegacyTimerApi.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L18;
            long[] r3 = p.f((Collection) ZeusTransformUtils.preCheckCast(this.f24269c, Collection.class, "com.obric.aiagent.plugin"));
            d.c.d<? super TimerTaskResult> r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24267a = 1;
            r7 = r2.skipTimerTasksByTaskId(r9, r3, r5);
            if (r7 != r0) goto L16;
            return r0;
        L18:
            return null;
        L17:
            return null;
        }
    }

    /* JADX INFO: compiled from: TimerTaskRepository.kt */
    @d.c.b.a.f(b = "TimerTaskRepository.kt", c = {587, 588, 588}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.module.datasource.TimerTaskRepository$updateTimerTask$2")
    static final class k extends l implements m<am, d.c.d<? super TimerTaskResult>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f24270a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f24271b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f24272c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ m<TimerTaskV2, d.c.d<? super TimerTaskV2>, Object> f24273d;

        k(String r3, m<? super TimerTaskV2, ? super d.c.d<? super TimerTaskV2>, ? extends Object> r4, d.c.d<? super k> r5) {
            m<TimerTaskV2, d.c.d<? super TimerTaskV2>, Object> r6 = (m) ZeusTransformUtils.wrapperContextForParams(r4, m.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24272c = r3;
            this.f24273d = r6;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super TimerTaskResult> r4) {
            return ((k) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), k.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new k(this.f24272c, this.f24273d, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super TimerTaskResult> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24271b;
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 != 3) goto L9;
            o.a(r9);
        L31:
            return (TimerTaskResult) ZeusTransformUtils.preCheckCast(r9, TimerTaskResult.class, "com.obric.aiagent.plugin");
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ILegacyTimerApi r2 = (ILegacyTimerApi) ZeusTransformUtils.preCheckCast(this.f24270a, ILegacyTimerApi.class, "com.obric.aiagent.plugin");
            o.a(r9);
        L27:
            TimerTask r10 = ((TimerTaskV2) ZeusTransformUtils.preCheckCast(r9, TimerTaskV2.class, "com.obric.aiagent.plugin")).toTimerTask();
            this.f24270a = null;
            this.f24271b = 3;
            r9 = r2.updateTimerTask(r10, this);
            if (r9 != r0) goto L31;
            return r0;
        L11:
            o.a(r9);
        L19:
            TimerTask r11 = (TimerTask) ZeusTransformUtils.preCheckCast(r9, TimerTask.class, "com.obric.aiagent.plugin");
            if (r11 == null) goto L34;
            m<TimerTaskV2, d.c.d<? super TimerTaskV2>, Object> r3 = this.f24273d;
            ILegacyTimerApi r4 = (ILegacyTimerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ILegacyTimerApi.class), ILegacyTimerApi.class, "com.obric.aiagent.plugin");
            if (r4 == null) goto L35;
            TimerTaskV2 r12 = r11.toTimerTaskV2();
            this.f24270a = r4;
            this.f24271b = 2;
            r9 = r3.invoke(r12, this);
            if (r9 != r0) goto L26;
            return r0;
        L26:
            r2 = r4;
            goto L27
        L35:
            return null;
        L34:
            return null;
        L12:
            o.a(r9);
            Integer r13 = d.o.o.d(this.f24272c);
            if (r13 == null) goto L32;
            int r14 = r13.intValue();
            ILegacyTimerApi r5 = (ILegacyTimerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ILegacyTimerApi.class), ILegacyTimerApi.class, "com.obric.aiagent.plugin");
            if (r5 == null) goto L33;
            d.c.d<? super TimerTask> r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24271b = 1;
            r9 = r5.getTimerTaskByTaskId(r14, r7);
            if (r9 != r0) goto L19;
            return r0;
        L33:
            return null;
        L32:
            return null;
        }
    }

    public i() {
        this.f24238b = new Gson();
        this.f24239c = kotlinx.coroutines.b.am.a(null);
        this.f24240d = kotlinx.coroutines.b.am.a(null);
        this.f24241e = kotlinx.coroutines.b.am.a(null);
        this.f = kotlinx.coroutines.b.am.a(null);
        this.g = kotlinx.coroutines.b.am.a(null);
    }

    public static final /* synthetic */ com.obric.autoaction.app.launcherpage.module.datasource.j a(i r0, com.obric.autoaction.app.launcherpage.module.datasource.f r1) {
        return r0.a(r1);
    }

    public static final /* synthetic */ com.obric.autoaction.app.launcherpage.module.datasource.j a(i r2, ConditionTaskRecord r3, List r4) {
        return r2.a(r3, (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ com.obric.autoaction.app.launcherpage.module.datasource.j a(i r2, TimerTaskRecord r3, List r4) {
        return r2.a(r3, (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ com.obric.autogui.database.a a(i r0) {
        return r0.g();
    }

    public static final /* synthetic */ String f() {
        return TAG;
    }

    private final com.obric.autogui.database.a g() {
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContextOrNull(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) != null) goto L6;
        Loog.INSTANCE.e(TAG, "dbUtils: the app isn't initialised.");
        return null;
    L6:
        return new com.obric.autogui.database.a(AutoActionDatabase.f29019e.a());
    }

    @Override // com.obric.autoaction.app.launcherpage.module.datasource.b
    public x<List<com.obric.autoaction.app.launcherpage.module.datasource.f>> a() {
        return this.f24239c;
    }

    @Override // com.obric.autoaction.app.launcherpage.module.datasource.b
    public x<List<com.obric.autoaction.app.launcherpage.module.datasource.j>> b() {
        return this.f24240d;
    }

    @Override // com.obric.autoaction.app.launcherpage.module.datasource.b
    public x<List<com.obric.autoaction.app.launcherpage.module.datasource.j>> c() {
        return this.f24241e;
    }

    public x<List<com.obric.autoaction.app.launcherpage.module.datasource.j>> d() {
        return this.g;
    }

    public String e() {
        return this.h;
    }

    @Override // com.obric.autoaction.app.launcherpage.module.datasource.b
    public void a(String r4) {
        this.h = r4;
        x<List<com.obric.autoaction.app.launcherpage.module.datasource.f>> r5 = a();
    L3:
        List<com.obric.autoaction.app.launcherpage.module.datasource.f> r0 = r5.c();
        List r1 = (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin");
        if (r5.a(r0, p.b()) == false) goto L3;
        x<List<com.obric.autoaction.app.launcherpage.module.datasource.j>> r2 = b();
    L6:
        List<com.obric.autoaction.app.launcherpage.module.datasource.j> r3 = r2.c();
        List r6 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin");
        if (r2.a(r3, p.b()) == false) goto L6;
    }

    @Override // com.obric.autoaction.app.launcherpage.module.datasource.b
    public void a(am r10) {
        am r11 = (am) ZeusTransformUtils.wrapperContextForParams(r10, am.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r11, "scope");
        kotlinx.coroutines.i.a(r11, null, null, (m) ZeusTransformUtils.preCheckCast(new f(this, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        kotlinx.coroutines.b.j.a(kotlinx.coroutines.b.j.c(kotlinx.coroutines.b.j.a((kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(com.obric.autoaction.app.launcherpage.module.datasource.h.f24228a.a(), kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin"), (kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(com.obric.autoaction.app.launcherpage.module.datasource.h.f24228a.b(), kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin"), (kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(com.obric.autoaction.app.launcherpage.module.datasource.h.f24228a.c(), kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin"), (r) ZeusTransformUtils.preCheckCast(new g(this, null), r.class, "com.obric.aiagent.plugin")), (m) ZeusTransformUtils.preCheckCast(new h(this, null), m.class, "com.obric.aiagent.plugin")), r11);
    }

    private final com.obric.autoaction.app.launcherpage.module.datasource.j a(ConditionTaskRecord r18, List<ConditionTask> r19) {
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r2 = r0.next();
        if (d.h.b.o.a(((ConditionTask) ZeusTransformUtils.preCheckCast(r2, ConditionTask.class, "com.obric.aiagent.plugin")).getId(), String.valueOf(r18.getTaskId())) == false) goto L4;
    L9:
        ConditionTask r1 = (ConditionTask) ZeusTransformUtils.preCheckCast(r2, ConditionTask.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L13;
        Loog.INSTANCE.e(TAG, "can not found timer task");
        return null;
    L13:
        String r3 = com.obric.autoaction.app.launcherpage.module.datasource.g.a((com.obric.autoaction.app.launcherpage.module.datasource.f) ZeusTransformUtils.preCheckCast(new com.obric.autoaction.app.launcherpage.module.datasource.f.a(r1), com.obric.autoaction.app.launcherpage.module.datasource.f.class, "com.obric.aiagent.plugin"));
        int r4 = r18.getResult();
        String r5 = String.valueOf(r18.getTaskId());
        long r6 = r18.getId();
        long r8 = r18.getTriggerTime();
        String r11 = r1.getName();
        if (r3 != null) goto L16;
        String r12 = "";
    L17:
        String r7 = r18.getSourceFrom();
        if (r7 != null) goto L20;
        String r13 = "";
    L22:
        if (r18.getResult() != 2) goto L24;
        String r9 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_condition_task_error_no_location_permission, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_condition_task_error_no_location_permission"));
    L25:
        Integer r16 = r1.getEnableStatus();
        return new com.obric.autoaction.app.launcherpage.module.datasource.j(r4, r5, Long.valueOf(r6), r8, -1L, "", r11, r12, r13, r9, true, r16);
    L24:
        r9 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.task_trigger_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "task_trigger_failed"));
        goto L25
    L20:
        r13 = r7;
        goto L22
    L16:
        r12 = r3;
        goto L17
    L8:
        r2 = null;
        goto L9
    }

    private final com.obric.autoaction.app.launcherpage.module.datasource.j a(TimerTaskRecord r18, List<TimerTaskV2> r19) {
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r2 = r0.next();
        if (d.h.b.o.a(((TimerTaskV2) ZeusTransformUtils.preCheckCast(r2, TimerTaskV2.class, "com.obric.aiagent.plugin")).getId(), r18.getTaskId().toString()) == false) goto L4;
    L9:
        TimerTaskV2 r1 = (TimerTaskV2) ZeusTransformUtils.preCheckCast(r2, TimerTaskV2.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L13;
        Loog.INSTANCE.e(TAG, "can not found timer task");
        return null;
    L13:
        String r3 = ((TimerTaskAction) ZeusTransformUtils.preCheckCast(this.f24238b.fromJson(r1.getAction(), TimerTaskAction.class), TimerTaskAction.class, "com.obric.aiagent.plugin")).getQuery();
        if (r3 != null) goto L16;
        r3 = "";
    L16:
        String r12 = r3;
        int r4 = r18.getTaskStatus();
        String r5 = r18.getTaskId().toString();
        long r6 = r18.getId();
        long r7 = r18.getTriggerTime();
        Long r9 = r18.getRealActionTime();
        String r10 = r1.getCronExpr();
        String r11 = r1.getName();
        String r13 = r18.getSourceFrom();
        Integer r16 = r1.getEnableStatus();
        boolean r15 = r1.isRepeat();
        return new com.obric.autoaction.app.launcherpage.module.datasource.j(r4, r5, Long.valueOf(r6), r7, r9, r10, r11, r12, r13, ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.task_trigger_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "task_trigger_failed")), r15, r16);
    L8:
        r2 = null;
        goto L9
    }

    private final com.obric.autoaction.app.launcherpage.module.datasource.j a(com.obric.autoaction.app.launcherpage.module.datasource.f r3) {
        if (ZeusTransformUtils.instanceOf(r3, com.obric.autoaction.app.launcherpage.module.datasource.f.a.class) == false) goto L6;
        return a(((com.obric.autoaction.app.launcherpage.module.datasource.f.a) ZeusTransformUtils.preCheckCast(r3, com.obric.autoaction.app.launcherpage.module.datasource.f.a.class, "com.obric.aiagent.plugin")).b());
    L6:
        if (ZeusTransformUtils.instanceOf(r3, com.obric.autoaction.app.launcherpage.module.datasource.f.c.class) == false) goto L9;
        return a(((com.obric.autoaction.app.launcherpage.module.datasource.f.c) ZeusTransformUtils.preCheckCast(r3, com.obric.autoaction.app.launcherpage.module.datasource.f.c.class, "com.obric.aiagent.plugin")).b());
    L9:
        if (ZeusTransformUtils.instanceOf(r3, com.obric.autoaction.app.launcherpage.module.datasource.f.b.class) == false) goto L13;
        return null;
    L13:
        throw new d.k();
    }

    private final com.obric.autoaction.app.launcherpage.module.datasource.j a(ConditionTask r17) {
        ConditionTaskAction r0 = (ConditionTaskAction) ZeusTransformUtils.preCheckCast(p.l(r17.getActions()), ConditionTaskAction.class, "com.obric.aiagent.plugin");
        String r1 = null;
        if (r0 == null) goto L5;
        IntentParams r2 = r0.getParams();
    L7:
        if (ZeusTransformUtils.instanceOf(r2, SystemAutoActionParams.class) == false) goto L9;
        SystemAutoActionParams r3 = (SystemAutoActionParams) ZeusTransformUtils.preCheckCast(r2, SystemAutoActionParams.class, "com.obric.aiagent.plugin");
    L10:
        if (r3 == null) goto L12;
        r1 = r3.getInstruction();
    L12:
        Integer r4 = r17.getTaskStatus();
        if (r4 == null) goto L15;
        int r5 = r4.intValue();
    L16:
        int r6 = r5;
        String r7 = r17.getId();
        if (r7 != null) goto L19;
        String r8 = "";
    L20:
        long r9 = b(r17);
        String r10 = r17.getName();
        if (r1 != null) goto L23;
        String r11 = "";
    L25:
        return new com.obric.autoaction.app.launcherpage.module.datasource.j(r6, r8, null, r9, -1L, "", r10, r11, "", null, true, r17.getEnableStatus());
    L23:
        r11 = r1;
        goto L25
    L19:
        r8 = r7;
        goto L20
    L15:
        r5 = 0;
        goto L16
    L9:
        r3 = null;
        goto L10
    L5:
        r2 = null;
        goto L7
    }

    /* JADX WARN: Type inference failed for: r7v12, types: [java.time.ZonedDateTime] */
    /* JADX WARN: Type inference failed for: r7v18, types: [java.time.ZonedDateTime] */
    private final long b(ConditionTask r8) {
        TimeCondition r2 = null;
        Object r3 = null;
        LocalDate r4 = null;
        r4 = null;
        if (r8.getNextTriggerTime() != 0) goto L60;
        LocalDate r7 = LocalDate.now();
        String r9 = r8.getPeriodicPolicy().getStartDate();
        if (r9 != null) goto L7;
    L20:
        if (r4 == null) goto L66;
        if (r7.isBefore((ChronoLocalDate) ZeusTransformUtils.preCheckCast(r4, ChronoLocalDate.class, "com.obric.aiagent.plugin")) == false) goto L66;
        r7 = r4;
    L66:
        return r7.atTime(LocalTime.MAX).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    L7:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L10;
        r9 = null;
    L10:
        if (r9 == null) goto L20;
        n.a r0 = n.f38560a;     // Catch: Throwable -> L13
        Object r10 = n.f(LocalDate.parse((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin"), DateTimeFormatter.ofPattern("yyyy-MM-dd")));     // Catch: Throwable -> L13
    L16:
        if (n.b(r10) == true) goto L19;
        r3 = r10;
    L19:
        r4 = (LocalDate) ZeusTransformUtils.preCheckCast(r3, LocalDate.class, "com.obric.aiagent.plugin");
    L13:
        th = move-exception;
        n.a r1 = n.f38560a;
        r10 = n.f(o.a(th));
        goto L16
    L60:
        n.a r5 = n.f38560a;     // Catch: Throwable -> L51
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r8.getConditions().getConditions(), Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L51
    L27:
        if (r6.hasNext() == false) goto L36;
        Object r11 = r6.next();     // Catch: Throwable -> L51
        Condition r12 = (Condition) ZeusTransformUtils.preCheckCast(r11, Condition.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L51
        if (ZeusTransformUtils.instanceOf(r12, TimeCondition.class) == true) goto L31;
    L33:
        boolean r13 = false;
    L34:
        if (r13 == false) goto L27;
    L38:
        if (ZeusTransformUtils.instanceOf(r11, TimeCondition.class) == false) goto L40;
        r2 = (TimeCondition) ZeusTransformUtils.preCheckCast(r11, TimeCondition.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L51
    L40:
        if (r2 != null) goto L42;
    L49:
        Object r14 = n.f(d.x.f38692a);     // Catch: Throwable -> L51
    L53:
        Throwable r15 = n.c(r14);
        if (r15 == null) goto L57;
        Loog.INSTANCE.e(TAG, "calculateTriggerTime error", r15);
    L57:
        return r8.getNextTriggerTime();
    L42:
        if (r8.getConditions().getConditions().size() <= 1) goto L49;
        if (a(r2.getStart(), String.valueOf(r2.getEnd())) == false) goto L49;
        if (a(r8.getPeriodicPolicy()) == false) goto L49;
        return LocalDate.now().atTime(LocalTime.parse((CharSequence) ZeusTransformUtils.preCheckCast(r2.getStart(), CharSequence.class, "com.obric.aiagent.plugin"))).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    L31:
        if (((TimeCondition) ZeusTransformUtils.preCheckCast(r12, TimeCondition.class, "com.obric.aiagent.plugin")).getEnd() == null) goto L33;
        r13 = true;
        goto L34
    L36:
        r11 = null;
    L51:
        th = move-exception;
        n.a r16 = n.f38560a;
        r14 = n.f(o.a(th));
        goto L53
    }

    public final boolean a(String r4, String r5) {
        d.h.b.o.e(r4, "start");
        d.h.b.o.e(r5, "end");
        DateTimeFormatter r3 = DateTimeFormatter.ofPattern("H:mm");
        LocalTime r6 = LocalTime.parse((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"), r3);
        LocalTime r7 = LocalTime.parse((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"), r3);
        LocalTime r8 = LocalTime.now().withSecond(0).withNano(0);
        if (d.h.b.o.a(r6, r7) == false) goto L7;
        return d.h.b.o.a(r8, r6);
    L7:
        if (r6.compareTo(r7) >= 0) goto L10;
        Comparable r9 = (Comparable) ZeusTransformUtils.preCheckCast(r6, Comparable.class, "com.obric.aiagent.plugin");
        d.h.b.o.a(r7);
        return d.l.n.a(r9, (Comparable) ZeusTransformUtils.preCheckCast(r7, Comparable.class, "com.obric.aiagent.plugin")).a((Comparable) ZeusTransformUtils.preCheckCast(r8, Comparable.class, "com.obric.aiagent.plugin"));
    L10:
        if (r8.compareTo(r6) < 0) goto L12;
    L13:
        return true;
    L12:
        if (r8.compareTo(r7) <= 0) goto L13;
        return false;
    }

    public final boolean a(PeriodicPolicy r8) {
        d.h.b.o.e(r8, "policy");
        LocalDate r0 = LocalDate.now();
        String r1 = r8.getStartDate();
        if (r1 == null) goto L23;
        Object r6 = null;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L8;
        r1 = null;
    L8:
        if (r1 == null) goto L23;
        n.a r5 = n.f38560a;     // Catch: Throwable -> L11
        i r7 = (i) ZeusTransformUtils.preCheckCast(this, i.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        Object r9 = n.f(LocalDate.parse((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"), DateTimeFormatter.ofPattern("yyyy-MM-dd")));     // Catch: Throwable -> L11
    L14:
        if (n.b(r9) == true) goto L17;
        r6 = r9;
    L17:
        LocalDate r10 = (LocalDate) ZeusTransformUtils.preCheckCast(r6, LocalDate.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L23;
        if (r0.isBefore((ChronoLocalDate) ZeusTransformUtils.preCheckCast(r10, ChronoLocalDate.class, "com.obric.aiagent.plugin")) == false) goto L23;
        return false;
    L11:
        th = move-exception;
        n.a r2 = n.f38560a;
        r9 = n.f(o.a(th));
    L23:
        if (r8.getDaily() == false) goto L25;
        return true;
    L25:
        int[] r11 = r8.getWeekly();
        if (r11 != null) goto L28;
    L30:
        int r12 = r8.getMonthly();
        if (1 <= r12) goto L33;
    L35:
        boolean r13 = false;
    L36:
        if (r13 == true) goto L38;
    L40:
        String r14 = r8.getYearly();
        if (r14 != null) goto L49;
    L45:
        return false;
    L49:
        if (d.h.b.o.a(r0, MonthDay.parse((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin"), DateTimeFormatter.ofPattern("MM-dd")).atYear(r0.getYear())) == false) goto L45;
        return true;
    L38:
        if (r0.getDayOfMonth() != r8.getMonthly()) goto L40;
        return true;
    L33:
        if (r12 >= 32) goto L35;
        r13 = true;
        goto L36
    L28:
        if (d.a.i.a(r11, r0.getDayOfWeek().getValue()) == false) goto L30;
        return true;
    }

    private final com.obric.autoaction.app.launcherpage.module.datasource.j a(TimerTaskV2 r17) {
        String r0 = ((TimerTaskAction) ZeusTransformUtils.preCheckCast(this.f24238b.fromJson(r17.getAction(), TimerTaskAction.class), TimerTaskAction.class, "com.obric.aiagent.plugin")).getQuery();
        Integer r1 = r17.getTaskStatus();
        if (r1 == null) goto L5;
        int r2 = r1.intValue();
    L6:
        int r3 = r2;
        String r4 = String.valueOf(r17.getId());
        Long r5 = r17.getNextScheduleTime();
        if (r5 == null) goto L9;
        long r6 = r5.longValue();
    L10:
        long r7 = r6;
        String r9 = r17.getCronExpr();
        String r10 = r17.getName();
        if (r0 != null) goto L14;
        r0 = "";
    L14:
        return new com.obric.autoaction.app.launcherpage.module.datasource.j(r3, r4, null, r7, null, r9, r10, r0, "", null, r17.isRepeat(), r17.getEnableStatus());
    L9:
        r6 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    @Override // com.obric.autoaction.app.launcherpage.module.datasource.b
    public Object b(String r5, d.c.d<? super List<com.obric.autoaction.app.launcherpage.module.datasource.d>> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L7;
        return p.b();
    L7:
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (m) ZeusTransformUtils.preCheckCast(new C0555i(this, r5, null), m.class, "com.obric.aiagent.plugin"), r7);
    }

    @Override // com.obric.autoaction.app.launcherpage.module.datasource.b
    public Object a(List<String> r4, d.c.d<? super d.x> r5) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        Object r7 = kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (m) ZeusTransformUtils.preCheckCast(new c(r3, null), m.class, "com.obric.aiagent.plugin"), r6);
        if (r7 != d.c.a.b.a()) goto L6;
        return r7;
    L6:
        return d.x.f38692a;
    }

    @Override // com.obric.autoaction.app.launcherpage.module.datasource.b
    public Object b(List<Integer> r4, d.c.d<? super d.x> r5) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        Object r7 = kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (m) ZeusTransformUtils.preCheckCast(new d(r3, null), m.class, "com.obric.aiagent.plugin"), r6);
        if (r7 != d.c.a.b.a()) goto L6;
        return r7;
    L6:
        return d.x.f38692a;
    }

    @Override // com.obric.autoaction.app.launcherpage.module.datasource.b
    public Object a(String r4, d.c.d<? super d.x> r5) {
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        Object r6 = kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (m) ZeusTransformUtils.preCheckCast(new e(r4, null), m.class, "com.obric.aiagent.plugin"), r3);
        if (r6 != d.c.a.b.a()) goto L6;
        return r6;
    L6:
        return d.x.f38692a;
    }

    @Override // com.obric.autoaction.app.launcherpage.module.datasource.b
    public Object c(List<Long> r4, d.c.d<? super d.x> r5) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        Object r7 = kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (m) ZeusTransformUtils.preCheckCast(new b(r3, null), m.class, "com.obric.aiagent.plugin"), r6);
        if (r7 != d.c.a.b.a()) goto L6;
        return r7;
    L6:
        return d.x.f38692a;
    }

    @Override // com.obric.autoaction.app.launcherpage.module.datasource.b
    public Object a(String r4, List<Long> r5, d.c.d<? super TimerTaskResult> r6) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (m) ZeusTransformUtils.preCheckCast(new j(r4, r3, null), m.class, "com.obric.aiagent.plugin"), r7);
    }

    @Override // com.obric.autoaction.app.launcherpage.module.datasource.b
    public Object a(String r4, m<? super TimerTaskV2, ? super d.c.d<? super TimerTaskV2>, ? extends Object> r5, d.c.d<? super TimerTaskResult> r6) {
        m r3 = (m) ZeusTransformUtils.wrapperContextForParams(r5, m.class, "com.obric.aiagent.plugin");
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (m) ZeusTransformUtils.preCheckCast(new k(r4, r3, null), m.class, "com.obric.aiagent.plugin"), r7);
    }

    static {
        f24237a = new a(null);
        TAG = "TimerTaskRepo";
    }
}
