package com.obric.aiagent.executionengine.eventstaskmanager.timertask.alarm;

import android.content.Context;
import android.content.Intent;
import com.obric.aiagent.executionengine.eventstaskmanager.b.b;
import com.obric.aiagent.executionengine.eventstaskmanager.common.d;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: AlarmReceiver.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AlarmReceiver extends PluginBroadcastReceiver {
    private static final String TAG = "TimerTaskAlarmReceiver";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f17875a = null;

    /* JADX INFO: compiled from: AlarmReceiver.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f17875a = new a(null);
    }

    public AlarmReceiver() {
    }

    public void onReceive(Context r3, Intent r4) {
        o.e((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "context");
        o.e(r4, MemorySourceLinkType.INTENT);
        b.f16676a.a(TAG, "TimerTask Alarm triggered! " + r4.getAction());
        if (d.f16682a.a() == true) goto L6;
        return;
    L6:
        if (o.a("com.obric.task.action.TIMER_TASK_DISPATCH", r4.getAction()) == false) goto L12;
        int r2 = r4.getIntExtra("timer_task_id", -1);
        if (r2 == (-1)) goto L10;
        com.obric.aiagent.executionengine.eventstaskmanager.timertask.b.f17879a.a(r2);
    L10:
        b.f16676a.b(TAG, "TimerTask Alarm triggered! " + r2);
        return;
    }
}
