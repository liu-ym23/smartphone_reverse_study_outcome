package androidx.work.impl.constraints.controllers;

import android.content.Context;
import android.os.Build;
import androidx.work.NetworkType;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

/* JADX INFO: loaded from: classes3.dex */
public class NetworkUnmeteredController extends ConstraintController<NetworkState> {
    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public boolean hasConstraint(WorkSpec r100) {
        if (r100.constraints.getRequiredNetworkType() != NetworkType.UNMETERED) goto L5;
    L10:
        return true;
    L5:
        if (Build.VERSION.SDK_INT >= 30) goto L7;
    L9:
        return false;
    L7:
        if (r100.constraints.getRequiredNetworkType() != NetworkType.TEMPORARILY_UNMETERED) goto L9;
        goto L9
    }

    /* JADX INFO: renamed from: isConstrained, reason: avoid collision after fix types in other method */
    public boolean isConstrained2(NetworkState r100) {
        if (r100.isConnected() == true) goto L5;
    L8:
        return true;
    L5:
        if (r100.isMetered() == true) goto L8;
        return false;
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public /* bridge */ /* synthetic */ boolean isConstrained(NetworkState r100) {
        return isConstrained2(r100);
    }

    public NetworkUnmeteredController(Context r100, TaskExecutor r101) {
        super(Trackers.getInstance(r100, r101).getNetworkStateTracker());
    }
}
