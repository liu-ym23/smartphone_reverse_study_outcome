package com.obric.aiagent.executionengine.eventstaskmanager.migration;

import android.content.Context;
import androidx.room.p;
import com.obric.aiagent.executionengine.eventstaskmanager.common.data.e;
import com.obric.aiagent.executionengine.eventstaskmanager.timertask.OldTimerTaskDatabase;
import com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.bean.TimerTaskBean;
import com.obric.capabilitykit.common.intent.BaseSystemAutoActionIntent;
import com.obric.capabilitykit.common.intent.IntentParams;
import com.obric.capabilitykit.common.intent.SystemAutoActionParams;
import com.obric.eventkit.task.model.Condition;
import com.obric.eventkit.task.model.ConditionGroup;
import com.obric.eventkit.task.model.ConditionTask;
import com.obric.eventkit.task.model.ConditionTaskAction;
import com.obric.eventkit.task.model.ConditionTaskResult;
import com.obric.eventkit.task.model.EventTaskExecutionRecord;
import com.obric.eventkit.task.model.PeriodicPolicy;
import com.obric.eventkit.task.model.TimeCondition;
import com.obric.eventkit.task.model.TimerTaskResult;
import com.obric.eventkit.task.model.TriggerControlPolicy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.l.j;
import d.n;
import d.o.k;
import d.x;
import java.io.File;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: TimerTaskMigrationOperation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d implements com.obric.aiagent.executionengine.eventstaskmanager.migration.b<OldTimerTaskDatabase> {
    private static final String TAG = "TimerTaskMigrationOp";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f17456a = null;

    /* JADX INFO: compiled from: TimerTaskMigrationOperation.kt */
    private static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: TimerTaskMigrationOperation.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final PeriodicPolicy f17457a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f17458b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f17457a, r6.f17457a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f17458b, r6.f17458b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            PeriodicPolicy r0 = this.f17457a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.f17458b;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "MigrateResult(periodicPolicy=" + this.f17457a + ", time=" + this.f17458b + ')';
        }

        public b(PeriodicPolicy r1, String r2) {
            this.f17457a = r1;
            this.f17458b = r2;
        }

        public final PeriodicPolicy a() {
            return this.f17457a;
        }

        public final String b() {
            return this.f17458b;
        }
    }

    static {
        f17456a = new a(null);
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.migration.b
    public String b() {
        return "timer_task_backup.db";
    }

    public d() {
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.migration.b
    public /* synthetic */ void a(Context r3, p r4) {
        a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (OldTimerTaskDatabase) ZeusTransformUtils.preCheckCast(r4, OldTimerTaskDatabase.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.migration.b
    public /* synthetic */ p b(Context r3, File r4) {
        return (p) ZeusTransformUtils.preCheckCast(a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4), p.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.migration.b
    public /* synthetic */ p c() {
        return (p) ZeusTransformUtils.preCheckCast(a(), p.class, "com.obric.aiagent.plugin");
    }

    public OldTimerTaskDatabase a() {
        return e.f16691a.a();
    }

    public OldTimerTaskDatabase a(Context r2, File r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        o.e(r3, "importedDbFile");
        return OldTimerTaskDatabase.f17859e.a(r1, r3, "restored_timer_task_db");
    }

    public void a(Context r6, OldTimerTaskDatabase r7) {
        o.e((Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin"), "context");
        o.e(r7, "restoredDb");
        OldTimerTaskDatabase r8 = e.f16691a.a();
        if (r8 == null) goto L7;
        List<TimerTaskBean> r9 = r8.o().a();
        List<TimerTaskBean> r0 = r7.o().a();
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "Start migrating timer tasks, local=" + r9.size() + ", restored=" + r0.size());
        a(r9, true);
        a(r0, false);
        c.f17455a.a((p) ZeusTransformUtils.preCheckCast(r7, p.class, "com.obric.aiagent.plugin"), "timer_task_bean");
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "Merge from restored DB timer_task_db to current DB completed");
        return;
    L7:
        throw new IllegalStateException("Target OldTimerTaskDatabase is null (maybe not logged in)");
    }

    private final void a(List<TimerTaskBean> r7, boolean r8) {
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r9.hasNext() == false) goto L13;
        TimerTaskBean r0 = (TimerTaskBean) ZeusTransformUtils.preCheckCast(r9.next(), TimerTaskBean.class, "com.obric.aiagent.plugin");
        n.a r2 = n.f38560a;     // Catch: Throwable -> L8
        ((d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin")).a(r0, r8);     // Catch: Throwable -> L8
        Object r3 = n.f(x.f38692a);     // Catch: Throwable -> L8
    L10:
        Throwable r4 = n.c(r3);
        if (r4 == null) goto L4;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "Migrate timerTask failed, taskId=" + r0.getTaskId(), r4);
    L8:
        th = move-exception;
        n.a r5 = n.f38560a;
        r3 = n.f(d.o.a(th));
        goto L10
    }

    private final void a(TimerTaskBean r26, boolean r27) {
        String r3 = r26.getAction();
        if (r3 != null) goto L5;
        return;
    L5:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L8;
        r3 = null;
    L8:
        if (r3 == null) goto L28;
        String r4 = String.valueOf(r26.getTaskId());
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "Start migrating timerTask, taskId=" + r4 + ", removeOldTask=" + r27);
        if (r27 == false) goto L17;
        TimerTaskResult r2 = com.obric.aiagent.executionengine.eventstaskmanager.timertask.b.f17879a.a(d.a.p.a(Integer.valueOf(r26.getTaskId())), r26.getSourceFrom());
        if (r2.getCode() == 0) goto L17;
        throw new IllegalStateException(("remove old failed, code=" + r2.getCode() + ", msg=" + r2.getMsg()).toString());
    L17:
        b r5 = a(r26.getCronTime());
        ConditionTaskResult r6 = com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.a(com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.f16741a, r26.getSourceFrom(), d.a.p.a(b(r3)), null, a(r26, r5), b(r26, r5), new TriggerControlPolicy(false, null, 2, null), null, Integer.valueOf(a(r26.getEnableStatus())), 1, null, null, null, 3584, null);
        List<ConditionTask> r7 = r6.getData();
        if (r7 == null) goto L26;
        ConditionTask r8 = (ConditionTask) ZeusTransformUtils.preCheckCast(d.a.p.l(r7), ConditionTask.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L26;
        String r9 = r8.getId();
        if (r9 == null) goto L26;
        a(r26, r4, r9);
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "Finish migrating timerTask, oldTaskId=" + r4 + ", newTaskId=" + r9);
        return;
    L26:
        throw new IllegalStateException(("create new failed, code=" + r6.getCode() + ", msg=" + r6.getMsg()).toString());
    }

    private final b a(String r8) {
        List<String> r0 = new k("\\s+").c((CharSequence) ZeusTransformUtils.preCheckCast(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin")).toString(), CharSequence.class, "com.obric.aiagent.plugin"), 0);
        if (r0.size() == 6) goto L9;
        if (r0.size() == 7) goto L9;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.a(TAG, "Unsupported cron format: " + r8, null);
        return null;
    L9:
        return new b(a((String) ZeusTransformUtils.preCheckCast(r0.get(3), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r0.get(5), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r0.get(4), String.class, "com.obric.aiagent.plugin")), b((String) ZeusTransformUtils.preCheckCast(r0.get(0), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r0.get(1), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r0.get(2), String.class, "com.obric.aiagent.plugin")));
    }

    private final ConditionTaskAction b(String r14) {
        return new ConditionTaskAction(new BaseSystemAutoActionIntent().getName(), (IntentParams) ZeusTransformUtils.preCheckCast(new SystemAutoActionParams(r14, null, null, null, null, null, null, null, 254, null), IntentParams.class, "com.obric.aiagent.plugin"));
    }

    private final ConditionGroup a(TimerTaskBean r9, b r10) {
        if (r10 == null) goto L5;
        String r11 = r10.b();
        if (r11 == null) goto L5;
    L7:
        return new ConditionGroup("or", d.a.p.d(new Condition[]{new TimeCondition(r11, null, 0, 6, null)}));
    L5:
        r11 = d();
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.a(TAG, "Parse time from cron failed, fallback to currentTime, taskId=" + r9.getTaskId(), null);
        goto L7
    }

    private final PeriodicPolicy b(TimerTaskBean r13, b r14) {
        if (r14 == null) goto L5;
        PeriodicPolicy r12 = r14.a();
        if (r12 == null) goto L5;
        return r12;
    L5:
        PeriodicPolicy r15 = new PeriodicPolicy(false, null, 0, null, false, false, null, true, null, 383, null);
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.a(TAG, "Parse periodicPolicy from cron failed, fallback to single task, taskId=" + r13.getTaskId(), null);
        return r15;
    }

    private final int a(int r3) {
        Integer r2 = Integer.valueOf(r3);
        int r4 = ((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.aiagent.plugin")).intValue();
        if (r4 == 0) goto L9;
        if (r4 == 1) goto L9;
        if (r4 == 2) goto L9;
        boolean r5 = false;
    L10:
        if (r5 == true) goto L13;
        r2 = null;
    L13:
        if (r2 != null) goto L15;
        return 1;
    L15:
        return r2.intValue();
    L9:
        r5 = true;
        goto L10
    }

    private final void a(TimerTaskBean r23, String r24, String r25) {
        List<EventTaskExecutionRecord> r1 = com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.d.f17292a.a(r23.getSourceFrom(), r24, 0, Integer.MAX_VALUE);
        if (r1 == null) goto L9;
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r2, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r4 = r2.iterator();
    L6:
        if (r4.hasNext() == false) goto L8;
        r3.add(EventTaskExecutionRecord.copy$default((EventTaskExecutionRecord) ZeusTransformUtils.preCheckCast(r4.next(), EventTaskExecutionRecord.class, "com.obric.aiagent.plugin"), 0, 0, 0, r25, null, 0, 0, 0, null, null, null, 2039, null));
        goto L6
    L8:
        List<EventTaskExecutionRecord> r5 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin");
    L10:
        if (r5 != null) goto L13;
        r5 = d.a.p.b();
    L13:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L17;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "Migrated execution records, taskId=" + r24 + ", count=" + com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.d.f17292a.b(r23.getSourceFrom(), r5));
        return;
    L17:
        return;
    L9:
        r5 = null;
        goto L10
    }

    private final PeriodicPolicy a(String r22, String r23, String r24) {
        if (o.a(r22, "*") == true) goto L5;
    L10:
        boolean r6 = false;
        if (o.a(r23, "*") == true) goto L50;
        if (o.a(r22, "*") == false) goto L50;
        if (o.a(r24, "*") == false) goto L50;
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(d.o.o.b((CharSequence) ZeusTransformUtils.preCheckCast(r23, CharSequence.class, "com.obric.aiagent.plugin"), new String[]{","}, false, 0, 6, null), Iterable.class, "com.obric.aiagent.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r2 = r0.iterator();
    L18:
        if (r2.hasNext() == false) goto L28;
        Integer r3 = d.o.o.d((String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.aiagent.plugin"));
        if (r3 == null) goto L25;
        int r4 = ((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).intValue();
        if (r4 != 0) goto L24;
        r4 = 7;
    L24:
        Integer r5 = Integer.valueOf(r4);
    L26:
        if (r5 == null) goto L18;
        r1.add(r5);
        goto L18
    L25:
        r5 = null;
        goto L26
    L28:
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r9 = r7.iterator();
    L30:
        if (r9.hasNext() == false) goto L39;
        Object r10 = r9.next();
        int r11 = ((Number) ZeusTransformUtils.preCheckCast(r10, Number.class, "com.obric.aiagent.plugin")).intValue();
        if (1 <= r11) goto L34;
    L36:
        boolean r12 = false;
    L37:
        if (r12 == false) goto L30;
        r8.add(r10);
        goto L30
    L34:
        if (r11 >= 8) goto L36;
        r12 = true;
        goto L37
    L39:
        int[] r13 = d.a.p.e((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin"));
        if (r13.length != 0) goto L43;
        r6 = true;
    L43:
        if ((!r6) == false) goto L45;
        int[] r14 = r13;
    L46:
        if (r14 != null) goto L48;
        return null;
    L48:
        return new PeriodicPolicy(false, r14, 0, null, false, false, null, false, null, 509, null);
    L45:
        r14 = null;
    L50:
        if (o.a(r22, "*") == false) goto L52;
    L68:
        return null;
    L52:
        if (o.a(r24, "*") == false) goto L68;
        if (o.a(r23, "?") == false) goto L68;
        Integer r15 = d.o.o.d(r22);
        if (r15 == null) goto L68;
        int r16 = ((Number) ZeusTransformUtils.preCheckCast(r15, Number.class, "com.obric.aiagent.plugin")).intValue();
        if (1 <= r16) goto L60;
    L62:
        if (r6 == true) goto L65;
        r15 = null;
    L65:
        if (r15 == null) goto L68;
        return new PeriodicPolicy(false, null, r15.intValue(), null, false, false, null, false, null, 507, null);
    L60:
        if (r16 >= 31) goto L62;
        r6 = true;
        goto L62
    L5:
        if (o.a(r23, "?") == false) goto L10;
        if (o.a(r24, "*") == false) goto L10;
        return new PeriodicPolicy(true, null, 0, null, false, false, null, false, null, 510, null);
    }

    private final String b(String r4, String r5, String r6) {
        if (o.a(r4, "*") == false) goto L5;
        return null;
    L5:
        if (o.a(r5, "*") == false) goto L7;
        return null;
    L7:
        if (o.a(r6, "*") == true) goto L29;
        Integer r3 = d.o.o.d(r5);
        Integer r7 = d.o.o.d(r6);
        j r8 = new j(0, 59);
        if (r3 != null) goto L12;
    L14:
        boolean r9 = false;
    L15:
        if (r9 == false) goto L27;
        j r10 = new j(0, 23);
        if (r7 != null) goto L19;
    L21:
        boolean r11 = false;
    L22:
        if (r11 == false) goto L28;
        String r0 = String.format("%02d:%02d", Arrays.copyOf(new Object[]{r7, r3}, 2));
        o.c(r0, "format(...)");
        return r0;
    L28:
        return null;
    L19:
        if (r10.a(r7.intValue()) == false) goto L21;
        r11 = true;
        goto L22
    L27:
        return null;
    L12:
        if (r8.a(r3.intValue()) == false) goto L14;
        r9 = true;
        goto L15
    L29:
        return null;
    }

    private final String d() {
        String r1 = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
        o.c(r1, "format(...)");
        return r1;
    }
}
