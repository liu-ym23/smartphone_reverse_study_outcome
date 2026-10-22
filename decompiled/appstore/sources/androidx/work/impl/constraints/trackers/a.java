package androidx.work.impl.constraints.trackers;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
public final class a extends BroadcastReceiverConstraintTracker {
    public a(Context r10, TaskExecutor r11) {
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
        r10.addAction("android.os.action.CHARGING");
        r10.addAction("android.os.action.DISCHARGING");
        return r10;
    }

    @Override // androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker
    public void k(Intent r10) {
        q.g(r10, MemorySourceLinkType.INTENT);
        String r11 = r10.getAction();
        if (r11 != null) goto L5;
        return;
    L5:
        androidx.work.i.e().a(b.a(), "Received " + r11);
        switch(r11.hashCode()) {
            case -1886648615: goto L21;
            case -54942926: goto L17;
            case 948344062: goto L13;
            case 1019184907: goto L9;
            default: goto L28;
        };
    L28:
        return;
    L9:
        if (r11.equals("android.intent.action.ACTION_POWER_CONNECTED") == false) goto L29;
        g(Boolean.TRUE);
        return;
    L29:
        return;
    L13:
        if (r11.equals("android.os.action.CHARGING") == false) goto L30;
        g(Boolean.TRUE);
        return;
    L30:
        return;
    L17:
        if (r11.equals("android.os.action.DISCHARGING") == false) goto L31;
        g(Boolean.FALSE);
        return;
    L31:
        return;
    L21:
        if (r11.equals("android.intent.action.ACTION_POWER_DISCONNECTED") == false) goto L32;
        g(Boolean.FALSE);
        return;
    }

    public Boolean l() {
        IntentFilter r10 = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        Intent r11 = d().registerReceiver(null, r10);
        if (r11 != null) goto L7;
        androidx.work.i.e().c(b.a(), "getInitialState - null intent received");
        return Boolean.FALSE;
    L7:
        return Boolean.valueOf(m(r11));
    }

    public final boolean m(Intent r10) {
        int r11 = r10.getIntExtra("status", -1);
        if (r11 != 2) goto L5;
    L8:
        return true;
    L5:
        if (r11 == 5) goto L8;
        return false;
    }
}
