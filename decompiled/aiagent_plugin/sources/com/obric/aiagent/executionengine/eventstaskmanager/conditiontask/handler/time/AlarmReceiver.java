package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.time;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.obric.aiagent.executionengine.eventstaskmanager.b.b;
import com.obric.aiagent.executionengine.eventstaskmanager.common.d;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: AlarmReceiver.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AlarmReceiver extends PluginBroadcastReceiver {
    private static final String TAG = "EventTaskAlarmReceiver";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f17276a = null;

    /* JADX INFO: compiled from: AlarmReceiver.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final Intent a(Context r3, String r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            o.e(r5, "context");
            Intent r2 = b(r5);
            r2.setAction("com.obric.task.action.EVENT_TASK_DISPATCH");
            r2.putExtra("event_task_id", r4);
            return r2;
        }

        public final Intent a(Context r3) {
            Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            o.e(r4, "context");
            Intent r2 = b(r4);
            r2.setAction("com.obric.task.action.CONDITION_TASK_CHECK");
            return r2;
        }

        private final Intent b(Context r3) {
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            Intent r4 = new Intent();
            r4.setComponent(new ComponentName(r2.getPackageName(), "com.obric.aiagent.taskmanager.ConditionTaskAlarmReceiver"));
            return r4;
        }
    }

    static {
        f17276a = new a(null);
    }

    /* JADX INFO: renamed from: lambda$LdMbW3zKs-UALDNOtGoCc7ccxPw, reason: not valid java name */
    public static /* synthetic */ x m170lambda$LdMbW3zKsUALDNOtGoCc7ccxPw(Intent r0) {
        return a(r0);
    }

    public AlarmReceiver() {
    }

    public void onReceive(Context r2, final Intent r3) {
        o.e((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), "context");
        o.e(r3, MemorySourceLinkType.INTENT);
        b.f16676a.b(TAG, "EventTask Alarm triggered! " + r3.getAction() + ' ' + d.f16682a.a());
        if (d.f16682a.a() == true) goto L5;
        return;
    L5:
        com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.f16741a.a("alarm:" + r3.getAction(), new $$Lambda$AlarmReceiver$LdMbW3zKsUALDNOtGoCc7ccxPw(r3));
    }

    private static final x a(Intent r4) {
        if (o.a("com.obric.task.action.EVENT_TASK_DISPATCH", r4.getAction()) == false) goto L9;
        String r5 = r4.getStringExtra("event_task_id");
        if (r5 == null) goto L7;
        com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.f16741a.e(r5);
    L7:
        b.f16676a.b(TAG, "EventTask Alarm triggered! " + r5);
    L12:
        return x.f38692a;
    L9:
        if (o.a("com.obric.task.action.CONDITION_TASK_CHECK", r4.getAction()) == false) goto L12;
        com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.f16741a.b();
        b.f16676a.b(TAG, "Condition task check");
        goto L12
    }
}
