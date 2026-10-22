package com.obric.aiagent.executionengine.eventstaskmanager.timertask.alarm;

import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.obric.aiagent.executionengine.eventstaskmanager.b.b;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.eventkit.task.model.TimerTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.g;
import d.h.b.o;

/* JADX INFO: compiled from: AlarmTaskManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static final String TAG = "AlarmManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f17876a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Application f17877b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final f f17878c = null;

    /* JADX INFO: renamed from: lambda$-d4Jaf9RPnTgqG129SSPy8uq3mY, reason: not valid java name */
    public static /* synthetic */ AlarmManager m176lambda$d4Jaf9RPnTgqG129SSPy8uq3mY() {
        return b();
    }

    private a() {
    }

    static {
        f17876a = new a();
        f17877b = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");
        f17878c = g.a($$Lambda$a$d4Jaf9RPnTgqG129SSPy8uq3mY.INSTANCE);
    }

    private final AlarmManager a() {
        return (AlarmManager) ZeusTransformUtils.preCheckCast(f17878c.b(), AlarmManager.class, "com.obric.aiagent.plugin");
    }

    private static final AlarmManager b() {
        Object r0 = f17877b.getSystemService("alarm");
        o.a(r0, "null cannot be cast to non-null type android.app.AlarmManager");
        return (AlarmManager) ZeusTransformUtils.preCheckCast(r0, AlarmManager.class, "com.obric.aiagent.plugin");
    }

    public final void a(TimerTask r4) {
        o.e(r4, "task");
        Integer r0 = r4.getId();
        if (r0 == null) goto L10;
        r0.intValue();
        if (r4.getNextScheduleTime() != null) goto L8;
        b.f16676a.d(TAG, "setAlarm triggerAtMillis is null");
        return;
    L8:
        Integer r1 = r4.getId();
        o.a(r1);
        int r2 = r1.intValue();
        Long r5 = r4.getNextScheduleTime();
        o.a(r5);
        a(r2, r5.longValue());
        return;
    L10:
        a r3 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        b.f16676a.d(TAG, "setAlarm task.id is null");
    }

    public final void a(int r3, long r4) {
        PendingIntent r5 = a(b(r3), r3);
        if (Build.VERSION.SDK_INT < 23) goto L6;
        a(r4, r5);
        return;
    }

    public final void b(TimerTask r2) {
        o.e(r2, "task");
        Integer r0 = r2.getId();
        if (r0 == null) goto L6;
        r0.intValue();
        Integer r3 = r2.getId();
        o.a(r3);
        a(r3.intValue());
        return;
    L6:
        a r1 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        b.f16676a.d(TAG, "cancelAlarm task.id is null");
    }

    public final void a(int r2) {
        PendingIntent r3 = a(b(r2), r2);
        a().cancel(r3);
    }

    private final PendingIntent a(Intent r3, int r4) {
        PendingIntent r2 = PendingIntent.getBroadcast((Context) ZeusTransformUtils.preCheckCast(f17877b, Context.class, "com.obric.aiagent.plugin"), r4, r3, 167772160);
        o.c(r2, "getBroadcast(...)");
        return r2;
    }

    private final Intent b(int r4) {
        Intent r3 = new Intent();
        r3.setComponent(new ComponentName(f17877b.getPackageName(), "com.obric.aiagent.taskmanager.TimerTaskAlarmReceiver"));
        r3.setAction("com.obric.task.action.TIMER_TASK_DISPATCH");
        r3.putExtra("timer_task_id", r4);
        return r3;
    }

    private final void a(long r2, PendingIntent r4) {
        a().setExactAndAllowWhileIdle(0, r2, r4);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        b.f16676a.b(TAG, "setAlarm exception", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }
}
