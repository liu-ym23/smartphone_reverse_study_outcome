package androidx.work.impl.constraints.controllers;

import android.content.Context;
import android.os.Build;
import androidx.work.Logger;
import androidx.work.NetworkType;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

/* JADX INFO: loaded from: classes3.dex */
public class NetworkNotRoamingController extends ConstraintController<NetworkState> {
    private static final String TAG = null;

    static {
        TAG = Logger.tagWithPrefix("NetworkNotRoamingCtrlr");
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public boolean hasConstraint(WorkSpec r100) {
        if (r100.constraints.getRequiredNetworkType() != NetworkType.NOT_ROAMING) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: isConstrained, reason: avoid collision after fix types in other method */
    public boolean isConstrained2(NetworkState r100) {
        if (Build.VERSION.SDK_INT >= 24) goto L7;
        Logger.get().debug(TAG, "Not-roaming network constraint is not supported before API 24, only checking for connected state.", new Throwable[0]);
        return !r100.isConnected();
    L7:
        if (r100.isConnected() == true) goto L9;
        return true;
    L9:
        if (r100.isNotRoaming() == false) goto L14;
        return false;
    L14:
        return true;
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public /* bridge */ /* synthetic */ boolean isConstrained(NetworkState r100) {
        return isConstrained2(r100);
    }

    public NetworkNotRoamingController(Context r100, TaskExecutor r101) {
        super(Trackers.getInstance(r100, r101).getNetworkStateTracker());
    }
}
