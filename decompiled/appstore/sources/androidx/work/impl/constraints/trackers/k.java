package androidx.work.impl.constraints.trackers;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
public final class k extends BroadcastReceiverConstraintTracker {
    public k(Context r10, TaskExecutor r11) {
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
        r10.addAction("android.intent.action.DEVICE_STORAGE_OK");
        r10.addAction("android.intent.action.DEVICE_STORAGE_LOW");
        return r10;
    }

    @Override // androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker
    public void k(Intent r10) {
        q.g(r10, MemorySourceLinkType.INTENT);
        if (r10.getAction() != null) goto L5;
        return;
    L5:
        androidx.work.i.e().a(l.a(), "Received " + r10.getAction());
        String r11 = r10.getAction();
        if (r11 == null) goto L21;
        int r12 = r11.hashCode();
        if (r12 == (-1181163412)) goto L17;
        if (r12 == (-730838620)) goto L13;
        return;
    L13:
        if (r11.equals("android.intent.action.DEVICE_STORAGE_OK") == false) goto L24;
        g(Boolean.TRUE);
        return;
    L24:
        return;
    L17:
        if (r11.equals("android.intent.action.DEVICE_STORAGE_LOW") == false) goto L25;
        g(Boolean.FALSE);
        return;
    L25:
        return;
    }

    public Boolean l() {
        Intent r10 = d().registerReceiver(null, j());
        boolean r11 = true;
        if (r10 == null) goto L20;
        if (r10.getAction() == null) goto L20;
        String r12 = r10.getAction();
        if (r12 == null) goto L18;
        int r13 = r12.hashCode();
        if (r13 != (-1181163412)) goto L12;
        r12.equals("android.intent.action.DEVICE_STORAGE_LOW");
        goto L18
    L12:
        if (r13 != (-730838620)) goto L18;
        if (r12.equals("android.intent.action.DEVICE_STORAGE_OK") == true) goto L20;
    L18:
        r11 = false;
    L20:
        return Boolean.valueOf(r11);
    }
}
