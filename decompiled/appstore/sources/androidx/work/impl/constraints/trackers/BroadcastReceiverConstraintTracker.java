package androidx.work.impl.constraints.trackers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
public abstract class BroadcastReceiverConstraintTracker extends g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final BroadcastReceiver f5532f;

    public BroadcastReceiverConstraintTracker(Context r10, TaskExecutor r11) {
        q.g(r10, "context");
        q.g(r11, "taskExecutor");
        super(r10, r11);
        this.f5532f = new BroadcastReceiverConstraintTracker$broadcastReceiver$1(this);
    }

    @Override // androidx.work.impl.constraints.trackers.g
    public void h() {
        androidx.work.i.e().a(e.a(), getClass().getSimpleName() + ": registering receiver");
        d().registerReceiver(this.f5532f, j());
    }

    @Override // androidx.work.impl.constraints.trackers.g
    public void i() {
        androidx.work.i.e().a(e.a(), getClass().getSimpleName() + ": unregistering receiver");
        d().unregisterReceiver(this.f5532f);
    }

    public abstract IntentFilter j();

    public abstract void k(Intent r10);
}
