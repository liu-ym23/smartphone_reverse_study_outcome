package androidx.work.impl.constraints.trackers;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
public final class c extends BroadcastReceiverConstraintTracker {
    public c(Context r10, TaskExecutor r11) {
        q.g(r10, "context");
        q.g(r11, "taskExecutor");
        super(r10, r11);
    }

    @Override // androidx.work.impl.constraints.trackers.g
    public /* bridge */ /* synthetic */ Object e() {
        return l();
    }

    @Override // androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker
    public IntentFilter j() {
        IntentFilter r10 = new IntentFilter();
        r10.addAction("android.intent.action.BATTERY_OKAY");
        r10.addAction("android.intent.action.BATTERY_LOW");
        return r10;
    }

    @Override // androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker
    public void k(Intent r10) {
        q.g(r10, MemorySourceLinkType.INTENT);
        if (r10.getAction() != null) goto L5;
        return;
    L5:
        androidx.work.i.e().a(d.a(), "Received " + r10.getAction());
        String r11 = r10.getAction();
        if (r11 == null) goto L21;
        int r12 = r11.hashCode();
        if (r12 == (-1980154005)) goto L17;
        if (r12 == 490310653) goto L13;
        return;
    L13:
        if (r11.equals("android.intent.action.BATTERY_LOW") == false) goto L24;
        g(Boolean.FALSE);
        return;
    L24:
        return;
    L17:
        if (r11.equals("android.intent.action.BATTERY_OKAY") == false) goto L25;
        g(Boolean.TRUE);
        return;
    L25:
        return;
    }

    public Boolean l() {
        Intent r10 = d().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (r10 != null) goto L6;
        androidx.work.i.e().c(d.a(), "getInitialState - null intent received");
        return Boolean.FALSE;
    L6:
        int r11 = r10.getIntExtra("status", -1);
        float r12 = r10.getIntExtra("level", -1) / r10.getIntExtra("scale", -1);
        boolean r13 = true;
        if (r11 == 1) goto L13;
        if (r12 > 0.15f) goto L13;
        r13 = false;
    L13:
        return Boolean.valueOf(r13);
    }
}
