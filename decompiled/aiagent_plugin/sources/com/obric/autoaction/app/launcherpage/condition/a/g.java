package com.obric.autoaction.app.launcherpage.condition.a;

import com.obric.autoaction.app.launcherpage.condition.config.condition.DayTimeCondition;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.presentation.ITimerTaskListener;
import com.obric.capabilitykit.common.intent.IntentParams;
import com.obric.capabilitykit.common.intent.SystemAutoActionParams;
import com.obric.eventkit.task.api.IEventTaskApi;
import com.obric.eventkit.task.api.IEventTaskRecordApi;
import com.obric.eventkit.task.api.ILegacyTimerApi;
import com.obric.eventkit.task.model.Condition;
import com.obric.eventkit.task.model.ConditionGroup;
import com.obric.eventkit.task.model.ConditionTaskAction;
import com.obric.eventkit.task.model.ConditionTaskSpec;
import com.obric.eventkit.task.model.EventTask;
import com.obric.eventkit.task.model.EventTaskExecutionRecord;
import com.obric.eventkit.task.model.EventTaskResult;
import com.obric.eventkit.task.model.EventTaskSpec;
import com.obric.eventkit.task.model.PeriodicPolicy;
import com.obric.eventkit.task.model.TimeCondition;
import com.obric.eventkit.task.model.TimerTaskResult;
import com.obric.eventkit.task.model.TimerTaskV2;
import com.obric.eventkit.task.model.TriggerControlPolicy;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.o;
import d.l.j;
import d.o.k;
import d.x;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.am;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: TimerTaskMigrationUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f22923a = null;

    /* JADX INFO: compiled from: TimerTaskMigrationUtils.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final PeriodicPolicy f22924a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final DayTimeCondition f22925b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f22924a, r6.f22924a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f22925b, r6.f22925b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            PeriodicPolicy r0 = this.f22924a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            DayTimeCondition r4 = this.f22925b;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "MigrateResult(periodicPolicy=" + this.f22924a + ", condition=" + this.f22925b + ')';
        }

        public a(PeriodicPolicy r1, DayTimeCondition r2) {
            this.f22924a = r1;
            this.f22925b = r2;
        }

        public final PeriodicPolicy a() {
            return this.f22924a;
        }

        public final DayTimeCondition b() {
            return this.f22925b;
        }
    }

    /* JADX INFO: compiled from: TimerTaskMigrationUtils.kt */
    @d.c.b.a.f(b = "TimerTaskMigrationUtils.kt", c = {65, 75, 79, 114, 117}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.condition.utils.TimerTaskMigrationUtils$migrateToConditionTask$2")
    static final class b extends l implements m<am, d.c.d<? super EventTaskResult>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f22926a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f22927b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f22928c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f22929d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.obric.autoaction.app.launcherpage.module.datasource.f.c f22930e;

        b(com.obric.autoaction.app.launcherpage.module.datasource.f.c r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22930e = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super EventTaskResult> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f22930e, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super EventTaskResult> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:101:0x03ab -> B:102:0x03ad). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:98:0x039f -> B:100:0x03a2). Please report as a decompilation issue!!! */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r44) {
            Object r1 = d.c.a.b.a();
            int r2 = this.f22929d;
            if (r2 == 0) goto L17;
            if (r2 == 1) goto L16;
            if (r2 == 2) goto L14;
            if (r2 == 3) goto L13;
            if (r2 == 4) goto L12;
            if (r2 != 5) goto L11;
            String r3 = (String) ZeusTransformUtils.preCheckCast(this.f22928c, String.class, "com.obric.aiagent.plugin");
            EventTask r4 = (EventTask) ZeusTransformUtils.preCheckCast(this.f22927b, EventTask.class, "com.obric.aiagent.plugin");
            EventTaskResult r6 = (EventTaskResult) ZeusTransformUtils.preCheckCast(this.f22926a, EventTaskResult.class, "com.obric.aiagent.plugin");
            d.o.a(r44);
            Object r5 = r44;
        L100:
            Integer r7 = (Integer) ZeusTransformUtils.preCheckCast(r5, Integer.class, "com.obric.aiagent.plugin");
        L102:
            Loog.INSTANCE.d("UpdateConditionTaskUseCase", "update " + r7 + " records");
        L81:
            IEventTaskRecordApi r8 = (IEventTaskRecordApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskRecordApi.class), IEventTaskRecordApi.class, "com.obric.aiagent.plugin");
            if (r8 == null) goto L87;
            this.f22926a = r6;
            this.f22927b = r4;
            this.f22928c = r3;
            this.f22929d = 4;
            Object r9 = r8.getExecutionRecordsByTaskId(r3, 0, 500, this);
            if (r9 != r1) goto L86;
            return r1;
        L86:
            List r13 = (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.aiagent.plugin");
        L88:
            if (r13 != null) goto L90;
        L103:
            EventTaskResult r14 = r6;
        L104:
            Loog.INSTANCE.d("UpdateConditionTaskUseCase", "upgrade done");
            com.obric.event.task.base.report.b.a(com.obric.event.task.base.report.b.f32757a, true, null, 2, null);
            if (r14 == null) goto L107;
            List<EventTask> r17 = r14.getData();
        L109:
            return new EventTaskResult(0, "", r17, null, 8, null);
        L107:
            r17 = null;
            goto L109
        L90:
            if ((!((Collection) ZeusTransformUtils.preCheckCast(r13, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L103;
            IEventTaskRecordApi r10 = (IEventTaskRecordApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskRecordApi.class), IEventTaskRecordApi.class, "com.obric.aiagent.plugin");
            if (r10 == null) goto L101;
            Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.aiagent.plugin");
            Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r11, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r12 = r11.iterator();
        L95:
            if (r12.hasNext() == false) goto L97;
            r15.add(EventTaskExecutionRecord.copy$default((EventTaskExecutionRecord) ZeusTransformUtils.preCheckCast(r12.next(), EventTaskExecutionRecord.class, "com.obric.aiagent.plugin"), 0, 0, 0, r4.getId(), null, 0, 0, 0, null, null, null, 2039, null));
            goto L95
        L97:
            List<EventTaskExecutionRecord> r16 = (List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.aiagent.plugin");
            this.f22926a = r6;
            this.f22927b = r4;
            this.f22928c = r3;
            this.f22929d = 5;
            r5 = r10.updateExecutionRecords(r16, this);
            if (r5 != r1) goto L100;
            return r1;
        L101:
            r7 = null;
            goto L102
        L87:
            r13 = null;
            goto L88
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            r3 = (String) ZeusTransformUtils.preCheckCast(this.f22928c, String.class, "com.obric.aiagent.plugin");
            r4 = (EventTask) ZeusTransformUtils.preCheckCast(this.f22927b, EventTask.class, "com.obric.aiagent.plugin");
            r6 = (EventTaskResult) ZeusTransformUtils.preCheckCast(this.f22926a, EventTaskResult.class, "com.obric.aiagent.plugin");
            d.o.a(r44);
            r9 = r44;
            goto L86
        L13:
            TimerTaskV2 r18 = (TimerTaskV2) ZeusTransformUtils.preCheckCast(this.f22926a, TimerTaskV2.class, "com.obric.aiagent.plugin");
            d.o.a(r44);
            Object r19 = r44;
        L64:
            r14 = (EventTaskResult) ZeusTransformUtils.preCheckCast(r19, EventTaskResult.class, "com.obric.aiagent.plugin");
        L66:
            if (r14 == null) goto L70;
            List<EventTask> r20 = r14.getData();
            if (r20 == null) goto L70;
            EventTask r21 = (EventTask) ZeusTransformUtils.preCheckCast(p.l(r20), EventTask.class, "com.obric.aiagent.plugin");
        L71:
            if (r14 != null) goto L73;
        L110:
            Loog r0 = Loog.INSTANCE;
            StringBuilder r22 = new StringBuilder().append("taskId: ").append(r18.getId()).append(", create new failed: ");
            if (r14 == null) goto L113;
            String r23 = r14.getMsg();
        L114:
            StringBuilder r24 = r22.append(r23).append(' ');
            if (r14 == null) goto L117;
            Integer r110 = d.c.b.a.b.a(r14.getCode());
        L118:
            r0.e("UpdateConditionTaskUseCase", r24.append(r110).toString());
            com.obric.event.task.base.report.b.f32757a.a(false, "create new failed");
            return r14;
        L117:
            r110 = null;
            goto L118
        L113:
            r23 = null;
            goto L114
        L73:
            if (r14.getCode() != 0) goto L110;
            if (r21 == null) goto L110;
            if (r21.getId() == null) goto L110;
            r3 = r18.getId();
            if (r3 == null) goto L104;
            r4 = r21;
            r6 = r14;
        L70:
            r21 = null;
            goto L71
        L14:
            ConditionGroup r25 = (ConditionGroup) ZeusTransformUtils.preCheckCast(this.f22928c, ConditionGroup.class, "com.obric.aiagent.plugin");
            a r111 = (a) ZeusTransformUtils.preCheckCast(this.f22927b, a.class, "com.obric.aiagent.plugin");
            TimerTaskV2 r112 = (TimerTaskV2) ZeusTransformUtils.preCheckCast(this.f22926a, TimerTaskV2.class, "com.obric.aiagent.plugin");
            d.o.a(r44);
            Object r26 = r44;
        L15:
            ConditionGroup r30 = r25;
            r18 = r112;
            if (((Number) ZeusTransformUtils.preCheckCast(r26, Number.class, "com.obric.aiagent.plugin")).intValue() < com.obric.autoaction.app.launcherpage.detail.condition.b.a()) goto L48;
            boolean r27 = true;
        L49:
            if (r27 == false) goto L51;
            Integer r28 = d.c.b.a.b.a(1);
        L52:
            Integer r29 = r28;
            IEventTaskApi r31 = (IEventTaskApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskApi.class), IEventTaskApi.class, "com.obric.aiagent.plugin");
            if (r31 == null) goto L65;
            Integer r210 = d.c.b.a.b.a(com.obric.autoaction.app.launcherpage.detail.shortcut.data.f.f23535b.a());
            List r211 = p.a(new ConditionTaskAction("System_AutoAction", (IntentParams) ZeusTransformUtils.preCheckCast(new SystemAutoActionParams(com.obric.autoaction.app.launcherpage.module.datasource.g.a((com.obric.autoaction.app.launcherpage.module.datasource.f) ZeusTransformUtils.preCheckCast(this.f22930e, com.obric.autoaction.app.launcherpage.module.datasource.f.class, "com.obric.aiagent.plugin")), null, null, null, null, null, null, null, 254, null), IntentParams.class, "com.obric.aiagent.plugin")));
            if (r111 == null) goto L60;
            PeriodicPolicy r32 = r111.a();
            if (r32 == null) goto L60;
            PeriodicPolicy r33 = r32;
        L61:
            EventTaskSpec r34 = (EventTaskSpec) ZeusTransformUtils.preCheckCast(new ConditionTaskSpec(null, r210, null, null, null, null, r29, null, r211, r30, r33, new TriggerControlPolicy(d.c.b.a.b.a(false), null, 2, null), 16, null), EventTaskSpec.class, "com.obric.aiagent.plugin");
            d.c.d<? super EventTaskResult> r35 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22926a = r18;
            this.f22927b = null;
            this.f22928c = null;
            this.f22929d = 3;
            r19 = r31.addEventTask(r34, r35);
            if (r19 != r1) goto L64;
            return r1;
        L60:
            r33 = new PeriodicPolicy(false, null, 0, null, false, false, null, true, null, 383, null);
            goto L61
        L65:
            r14 = null;
            goto L66
        L51:
            r28 = r18.getEnableStatus();
            goto L52
        L48:
            r27 = false;
            goto L49
        L16:
            r25 = (ConditionGroup) ZeusTransformUtils.preCheckCast(this.f22928c, ConditionGroup.class, "com.obric.aiagent.plugin");
            r111 = (a) ZeusTransformUtils.preCheckCast(this.f22927b, a.class, "com.obric.aiagent.plugin");
            r112 = (TimerTaskV2) ZeusTransformUtils.preCheckCast(this.f22926a, TimerTaskV2.class, "com.obric.aiagent.plugin");
            d.o.a(r44);
            Object r36 = r44;
        L36:
            TimerTaskResult r37 = (TimerTaskResult) ZeusTransformUtils.preCheckCast(r36, TimerTaskResult.class, "com.obric.aiagent.plugin");
        L38:
            if (r37 != null) goto L40;
        L120:
            String r38 = null;
            Loog r39 = Loog.INSTANCE;
            StringBuilder r40 = new StringBuilder().append("taskId: ").append(r112.getId()).append(", remove failed: ");
            if (r37 == null) goto L123;
            String r113 = r37.getMsg();
        L124:
            r39.e("UpdateConditionTaskUseCase", r40.append(r113).toString());
            com.obric.event.task.base.report.b.f32757a.a(false, "remove old failed");
            if (r37 == null) goto L127;
            int r41 = r37.getCode();
        L128:
            int r114 = r41;
            if (r37 == null) goto L132;
            r38 = r37.getMsg();
        L132:
            return new EventTaskResult(r114, r38, p.b(), null, 8, null);
        L127:
            r41 = -1;
            goto L128
        L123:
            r113 = null;
            goto L124
        L40:
            if (r37.getCode() != 0) goto L120;
            d.c.d r42 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22926a = r112;
            this.f22927b = r111;
            this.f22928c = r25;
            this.f22929d = 2;
            r26 = com.obric.autoaction.app.launcherpage.detail.condition.b.a(r42);
            if (r26 != r1) goto L15;
            return r1;
        L17:
            d.o.a(r44);
            r112 = this.f22930e.b();
            r111 = g.f22923a.a(r112.getCronExpr());
            if (r111 == null) goto L23;
            DayTimeCondition r43 = r111.b();
            if (r43 == null) goto L23;
            String r45 = r43.getDayTime();
            if (r45 == null) goto L23;
        L24:
            r25 = new ConditionGroup("or", p.d(new Condition[]{new TimeCondition(r45, null, 0, 6, null)}));
            ITimerTaskListener r46 = (ITimerTaskListener) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ITimerTaskListener.class), ITimerTaskListener.class, "com.obric.aiagent.plugin");
            String r115 = r112.getId();
            if (r115 != null) goto L27;
            r115 = "";
        L27:
            r46.onTimerTaskRemoved(p.a(new ITimerTaskListener.TimerTask(r115, r112.getAction(), r112.getExt())), true);
            String r47 = r112.getId();
            if (r47 == null) goto L134;
            Integer r48 = d.o.o.d(r47);
            if (r48 == null) goto L134;
            int r49 = r48.intValue();
            ILegacyTimerApi r50 = (ILegacyTimerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ILegacyTimerApi.class), ILegacyTimerApi.class, "com.obric.aiagent.plugin");
            if (r50 == null) goto L37;
            List<Integer> r51 = p.a(d.c.b.a.b.a(r49));
            d.c.d<? super TimerTaskResult> r52 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22926a = r112;
            this.f22927b = r111;
            this.f22928c = r25;
            this.f22929d = 1;
            r36 = r50.removeTimerTasksByTaskId(r51, r52);
            if (r36 != r1) goto L36;
            return r1;
        L37:
            r37 = null;
        L134:
            return new EventTaskResult(-1, "invalid legacy timer task id", p.b(), null, 8, null);
        L23:
            r45 = g.a(g.f22923a);
            goto L24
        }
    }

    static {
        f22923a = new g();
    }

    private g() {
    }

    public static final /* synthetic */ String a(g r0) {
        return r0.a();
    }

    public final Object a(com.obric.autoaction.app.launcherpage.module.datasource.f.c r4, d.c.d<? super EventTaskResult> r5) {
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (m) ZeusTransformUtils.preCheckCast(new b(r4, null), m.class, "com.obric.aiagent.plugin"), r3);
    }

    private final String a() {
        String r1 = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
        o.a(r1);
        return r1;
    }

    public final a a(String r10) {
        o.e(r10, "cron");
        CharSequence r11 = (CharSequence) ZeusTransformUtils.preCheckCast(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin")).toString(), CharSequence.class, "com.obric.aiagent.plugin");
        List<String> r12 = new k("\\s+").c(r11, 0);
        if (r12.size() != 6) goto L5;
    L8:
        String r0 = (String) ZeusTransformUtils.preCheckCast(r12.get(0), String.class, "com.obric.aiagent.plugin");
        String r2 = (String) ZeusTransformUtils.preCheckCast(r12.get(1), String.class, "com.obric.aiagent.plugin");
        String r4 = (String) ZeusTransformUtils.preCheckCast(r12.get(2), String.class, "com.obric.aiagent.plugin");
        String r5 = (String) ZeusTransformUtils.preCheckCast(r12.get(3), String.class, "com.obric.aiagent.plugin");
        String r6 = (String) ZeusTransformUtils.preCheckCast(r12.get(4), String.class, "com.obric.aiagent.plugin");
        String r7 = (String) ZeusTransformUtils.preCheckCast(r12.get(5), String.class, "com.obric.aiagent.plugin");
        String r13 = (String) ZeusTransformUtils.preCheckCast(p.d(r12, 6), String.class, "com.obric.aiagent.plugin");
        DayTimeCondition r14 = b(r0, r2, r4);
        return new a(a(r5, r7, r6), r14);
    L5:
        if (r12.size() == 7) goto L8;
        return null;
    }

    private final PeriodicPolicy a(String r21, String r22, String r23) {
        if (o.a(r21, "*") == false) goto L11;
        if (o.a(r22, "?") == false) goto L11;
        if (o.a(r23, "*") == false) goto L11;
        return new PeriodicPolicy(true, null, 0, null, false, false, null, false, null, 510, null);
    L11:
        if (o.a(r22, "*") == true) goto L46;
        if (o.a(r21, "*") == false) goto L46;
        if (o.a(r23, "*") == false) goto L46;
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(d.o.o.b((CharSequence) ZeusTransformUtils.preCheckCast(r22, CharSequence.class, "com.obric.aiagent.plugin"), new String[]{","}, false, 0, 6, null), Iterable.class, "com.obric.aiagent.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r2 = r0.iterator();
    L18:
        if (r2.hasNext() == false) goto L27;
        Integer r3 = d.o.o.d((String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.aiagent.plugin"));
        if (r3 != null) goto L23;
    L25:
        if (r3 == null) goto L18;
        r1.add(r3);
        goto L18
    L23:
        if (r3.intValue() != 0) goto L25;
        r3 = 7;
        goto L25
    L27:
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r6 = r4.iterator();
    L28:
        boolean r7 = true;
        if (r6.hasNext() == false) goto L37;
        Object r8 = r6.next();
        int r9 = ((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.aiagent.plugin")).intValue();
        if (r9 < 0) goto L34;
        if (r9 > 7) goto L34;
    L35:
        if (r7 == false) goto L28;
        r5.add(r8);
    L34:
        r7 = false;
        goto L35
    L37:
        int[] r10 = p.e((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin"));
        if (r10.length == 0) goto L41;
        r7 = false;
    L41:
        if (r7 == false) goto L44;
        return null;
    L44:
        return new PeriodicPolicy(false, r10, 0, null, false, false, null, false, null, 509, null);
    L46:
        if (o.a(r21, "*") == false) goto L48;
    L60:
        return null;
    L48:
        if (o.a(r23, "*") == false) goto L60;
        if (o.a(r22, "?") == false) goto L60;
        Integer r11 = d.o.o.d(r21);
        if (r11 == null) goto L60;
        if (r11.intValue() <= 0) goto L60;
        if (r11.intValue() >= 31) goto L60;
        return new PeriodicPolicy(false, null, r11.intValue(), null, false, false, null, false, null, 507, null);
    }

    private final DayTimeCondition b(String r3, String r4, String r5) {
        if (o.a(r3, "*") == false) goto L5;
    L18:
        return null;
    L5:
        if (o.a(r4, "*") == true) goto L18;
        if (o.a(r5, "*") == true) goto L18;
        Integer r2 = d.o.o.d(r4);
        Integer r6 = d.o.o.d(r5);
        if (r2 == null) goto L18;
        if (r6 == null) goto L18;
        if (new j(0, 59).a(r2.intValue()) == false) goto L18;
        if (new j(0, 23).a(r6.intValue()) == false) goto L18;
        String r7 = String.format("%02d:%02d", Arrays.copyOf(new Object[]{r6, r2}, 2));
        o.c(r7, "format(...)");
        return new DayTimeCondition(r7);
    }
}
