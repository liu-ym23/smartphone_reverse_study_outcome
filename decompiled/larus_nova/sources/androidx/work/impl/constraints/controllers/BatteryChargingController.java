package androidx.work.impl.constraints.controllers;

import android.content.Context;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

/* JADX INFO: loaded from: classes3.dex */
public class BatteryChargingController extends ConstraintController<Boolean> {
    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public boolean hasConstraint(WorkSpec r100) {
        return r100.constraints.requiresCharging();
    }

    /* JADX INFO: renamed from: isConstrained, reason: avoid collision after fix types in other method */
    public boolean isConstrained2(Boolean r100) {
        return !r100.booleanValue();
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public /* bridge */ /* synthetic */ boolean isConstrained(Boolean r100) {
        return isConstrained2(r100);
    }

    public BatteryChargingController(Context r100, TaskExecutor r101) {
        super(Trackers.getInstance(r100, r101).getBatteryChargingTracker());
    }
}
