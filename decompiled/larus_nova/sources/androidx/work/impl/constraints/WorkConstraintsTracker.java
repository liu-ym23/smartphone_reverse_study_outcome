package androidx.work.impl.constraints;

import android.content.Context;
import androidx.work.Logger;
import androidx.work.impl.constraints.controllers.BatteryChargingController;
import androidx.work.impl.constraints.controllers.BatteryNotLowController;
import androidx.work.impl.constraints.controllers.ConstraintController;
import androidx.work.impl.constraints.controllers.NetworkConnectedController;
import androidx.work.impl.constraints.controllers.NetworkMeteredController;
import androidx.work.impl.constraints.controllers.NetworkNotRoamingController;
import androidx.work.impl.constraints.controllers.NetworkUnmeteredController;
import androidx.work.impl.constraints.controllers.StorageNotLowController;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class WorkConstraintsTracker implements ConstraintController.OnConstraintUpdatedCallback {
    private static final String TAG = null;
    private final WorkConstraintsCallback mCallback;
    private final ConstraintController<?>[] mConstraintControllers;
    private final Object mLock;

    static {
        TAG = Logger.tagWithPrefix("WorkConstraintsTracker");
    }

    public void reset() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        ConstraintController<?>[] r101 = this.mConstraintControllers;     // Catch: Throwable -> L9
        int r102 = r101.length;     // Catch: Throwable -> L9
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L7;
        r101[r103].reset();     // Catch: Throwable -> L9
        r103 = r103 + 1;     // Catch: Throwable -> L9
        goto L5
    L7:
        monitor-exit(r100);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public boolean areAllConstraintsMet(String r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        ConstraintController<?>[] r102 = this.mConstraintControllers;     // Catch: Throwable -> L15
        int r103 = r102.length;     // Catch: Throwable -> L15
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L13;
        ConstraintController<?> r105 = r102[r104];     // Catch: Throwable -> L15
        if (r105.isWorkSpecConstrained(r100) == true) goto L9;
        r104 = r104 + 1;     // Catch: Throwable -> L15
        goto L6
    L9:
        Logger.get().debug(TAG, String.format("Work %s constrained by %s", new Object[]{r100, r105.getClass().getSimpleName()}), new Throwable[0]);     // Catch: Throwable -> L15
        monitor-exit(r101);     // Catch: Throwable -> L15
        return false;
    L13:
        monitor-exit(r101);     // Catch: Throwable -> L15
        return true;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController.OnConstraintUpdatedCallback
    public void onConstraintMet(List<String> r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        ArrayList r102 = new ArrayList();     // Catch: Throwable -> L15
        Iterator<String> r103 = r100.iterator();     // Catch: Throwable -> L15
    L6:
        if (r103.hasNext() == false) goto L10;
        String r104 = r103.next();     // Catch: Throwable -> L15
        if (areAllConstraintsMet(r104) == false) goto L6;
        Logger.get().debug(TAG, String.format("Constraints met for %s", new Object[]{r104}), new Throwable[0]);     // Catch: Throwable -> L15
        r102.add(r104);     // Catch: Throwable -> L15
        goto L6
    L10:
        WorkConstraintsCallback r105 = this.mCallback;     // Catch: Throwable -> L15
        if (r105 == null) goto L13;
        r105.onAllConstraintsMet(r102);     // Catch: Throwable -> L15
    L13:
        monitor-exit(r101);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController.OnConstraintUpdatedCallback
    public void onConstraintNotMet(List<String> r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        WorkConstraintsCallback r102 = this.mCallback;     // Catch: Throwable -> L9
        if (r102 == null) goto L7;
        r102.onAllConstraintsNotMet(r100);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r101);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void replace(Iterable<WorkSpec> r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        ConstraintController<?>[] r102 = this.mConstraintControllers;     // Catch: Throwable -> L15
        int r103 = r102.length;     // Catch: Throwable -> L15
        int r104 = 0;
        int r105 = 0;
    L5:
        if (r105 >= r103) goto L7;
        r102[r105].setCallback(null);     // Catch: Throwable -> L15
        r105 = r105 + 1;     // Catch: Throwable -> L15
        goto L5
    L7:
        ConstraintController<?>[] r106 = this.mConstraintControllers;     // Catch: Throwable -> L15
        int r107 = r106.length;     // Catch: Throwable -> L15
        int r108 = 0;
    L8:
        if (r108 >= r107) goto L10;
        r106[r108].replace(r100);     // Catch: Throwable -> L15
        r108 = r108 + 1;     // Catch: Throwable -> L15
        goto L8
    L10:
        ConstraintController<?>[] r109 = this.mConstraintControllers;     // Catch: Throwable -> L15
        int r110 = r109.length;     // Catch: Throwable -> L15
    L11:
        if (r104 >= r110) goto L13;
        r109[r104].setCallback(this);     // Catch: Throwable -> L15
        r104 = r104 + 1;     // Catch: Throwable -> L15
        goto L11
    L13:
        monitor-exit(r101);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public WorkConstraintsTracker(WorkConstraintsCallback r100, ConstraintController<?>[] r101) {
        this.mCallback = r100;
        this.mConstraintControllers = r101;
        this.mLock = new Object();
    }

    public WorkConstraintsTracker(Context r100, TaskExecutor r101, WorkConstraintsCallback r102) {
        Context r103 = r100.getApplicationContext();
        this.mCallback = r102;
        this.mConstraintControllers = new ConstraintController[]{new BatteryChargingController(r103, r101), new BatteryNotLowController(r103, r101), new StorageNotLowController(r103, r101), new NetworkConnectedController(r103, r101), new NetworkUnmeteredController(r103, r101), new NetworkNotRoamingController(r103, r101), new NetworkMeteredController(r103, r101)};
        this.mLock = new Object();
    }
}
