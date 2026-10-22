package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.time;

import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.obric.aiagent.executionengine.eventstaskmanager.b.b;
import com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c;
import com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.e;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.eventkit.task.model.Condition;
import com.obric.eventkit.task.model.ConditionTask;
import com.obric.eventkit.task.model.TimeCondition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.f;
import d.g;
import d.h.b.aa;
import d.h.b.h;
import d.h.b.o;
import d.x;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: TimeConditionHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements e<TimeCondition> {
    private static final String TAG = "TimeConditionHandler";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0354a f17277a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final f f17278b;

    /* JADX INFO: renamed from: com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.time.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: TimeConditionHandler.kt */
    public static final class C0354a {
        public /* synthetic */ C0354a(h r1) {
            this();
        }

        private C0354a() {
        }
    }

    static {
        f17277a = new C0354a(null);
    }

    public static /* synthetic */ AlarmManager lambda$HJapQWfpBTWcJvNwXDM9muLSDLk() {
        return b();
    }

    public a() {
        this.f17278b = g.a($$Lambda$a$HJapQWfpBTWcJvNwXDM9muLSDLk.INSTANCE);
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.e
    public /* synthetic */ com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.a a(ConditionTask r3, Condition r4) {
        return a(r3, (TimeCondition) ZeusTransformUtils.preCheckCast((Condition) ZeusTransformUtils.wrapperContextForParams(r4, Condition.class, "com.obric.aiagent.plugin"), TimeCondition.class, "com.obric.aiagent.plugin"));
    }

    private final AlarmManager a() {
        return (AlarmManager) ZeusTransformUtils.preCheckCast(this.f17278b.b(), AlarmManager.class, "com.obric.aiagent.plugin");
    }

    private static final AlarmManager b() {
        Object r0 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getSystemService("alarm");
        o.a(r0, "null cannot be cast to non-null type android.app.AlarmManager");
        return (AlarmManager) ZeusTransformUtils.preCheckCast(r0, AlarmManager.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.e
    public Object a(ConditionTask r7, List<TimeCondition> r8, d<? super c> r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        d r11 = (d) ZeusTransformUtils.wrapperContextForParams(r9, d.class, "com.obric.aiagent.plugin");
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        if (r12.hasNext() == false) goto L20;
        long r2 = com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.f.a((TimeCondition) ZeusTransformUtils.preCheckCast(r12.next(), TimeCondition.class, "com.obric.aiagent.plugin"), r7.getPeriodicPolicy(), b(r7));
    L6:
        if (r12.hasNext() == false) goto L10;
        long r4 = com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.f.a((TimeCondition) ZeusTransformUtils.preCheckCast(r12.next(), TimeCondition.class, "com.obric.aiagent.plugin"), r7.getPeriodicPolicy(), b(r7));
        if (r2 <= r4) goto L6;
        r2 = r4;
        goto L6
    L10:
        b.f16676a.b(TAG, "registerTask " + r7.getId() + ' ' + r2);
        a().setExactAndAllowWhileIdle(0, r2, a(r7));     // Catch: Exception -> L13
        return c.a.a(c.f17052a, 0, 1, null);
    L13:
        e = move-exception;
        b.f16676a.b(TAG, "registerTask exception", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        c.a r13 = c.f17052a;
        String r6 = e.getMessage();
        if (r6 != null) goto L18;
        r6 = "setExactAndAllowWhileIdle failed";
    L18:
        return c.a.a(r13, r6, 0, 2, null);
    L20:
        throw new NoSuchElementException();
    }

    public com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.a a(ConditionTask r2, TimeCondition r3) {
        o.e(r2, "task");
        o.e(r3, "condition");
        if (r3.getEnd() != null) goto L6;
        r3.getStart();
    L6:
        if (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.f.a(r2.getPeriodicPolicy()) == false) goto L11;
        if (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.f.a(r3, b(r2)) == false) goto L11;
        return com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.a.f17016b;
    L11:
        return com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.a.f17018d;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.e
    public Object b(ConditionTask r3, List<TimeCondition> r4, d<? super x> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        b.f16676a.b(TAG, "unregisterTask " + r3.getId());
        a().cancel(a(r3));
        return x.f38692a;
    }

    private final PendingIntent a(ConditionTask r5) {
        Application r4 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");
        Intent r1 = AlarmReceiver.f17276a.a((Context) ZeusTransformUtils.preCheckCast(r4, Context.class, "com.obric.aiagent.plugin"), r5.getId());
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(r4, Context.class, "com.obric.aiagent.plugin");
        String r7 = r5.getId();
        if (r7 == null) goto L5;
        int r8 = r7.hashCode();
    L6:
        PendingIntent r9 = PendingIntent.getBroadcast(r6, r8, r1, 167772160);
        o.c(r9, "getBroadcast(...)");
        return r9;
    L5:
        r8 = 0;
        goto L6
    }

    private final long b(ConditionTask r1) {
        com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.d.b(r1.getConditions(), aa.b(TimeCondition.class));
        return 0;
    }
}
