package androidx.work.impl.constraints.controllers;

import android.content.Context;
import android.os.Build;
import androidx.work.NetworkType;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

/* JADX INFO: loaded from: classes3.dex */
public class NetworkConnectedController extends ConstraintController<NetworkState> {
    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public boolean hasConstraint(WorkSpec r100) {
        if (r100.constraints.getRequiredNetworkType() != NetworkType.CONNECTED) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: isConstrained, reason: avoid collision after fix types in other method */
    public boolean isConstrained2(NetworkState r100) {
        if (Build.VERSION.SDK_INT < 26) goto L12;
        if (r100.isConnected() == true) goto L7;
        return true;
    L7:
        if (r100.isValidated() == false) goto L14;
        return false;
    L14:
        return true;
    L12:
        return !r100.isConnected();
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public /* bridge */ /* synthetic */ boolean isConstrained(NetworkState r100) {
        return isConstrained2(r100);
    }

    public NetworkConnectedController(Context r100, TaskExecutor r101) {
        super(Trackers.getInstance(r100, r101).getNetworkStateTracker());
    }
}
