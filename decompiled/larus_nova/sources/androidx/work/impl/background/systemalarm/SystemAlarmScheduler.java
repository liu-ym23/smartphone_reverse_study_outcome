package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import androidx.work.Logger;
import androidx.work.impl.Scheduler;
import androidx.work.impl.model.WorkSpec;

/* JADX INFO: loaded from: classes17.dex */
public class SystemAlarmScheduler implements Scheduler {
    private static final String TAG = null;
    private final Context mContext;

    @Override // androidx.work.impl.Scheduler
    public boolean hasLimitedSchedulingSlots() {
        return true;
    }

    static {
        TAG = Logger.tagWithPrefix("SystemAlarmScheduler");
    }

    public SystemAlarmScheduler(Context r100) {
        this.mContext = r100.getApplicationContext();
    }

    private void scheduleWorkSpec(WorkSpec r100) {
        Logger.get().debug(TAG, String.format("Scheduling work with workSpecId %s", new Object[]{r100.f15686id}), new Throwable[0]);
        this.mContext.startService(CommandHandler.createScheduleWorkIntent(this.mContext, r100.f15686id));
    }

    @Override // androidx.work.impl.Scheduler
    public void cancel(String r100) {
        Intent r101 = CommandHandler.createStopWorkIntent(this.mContext, r100);
        this.mContext.startService(r101);
    }

    @Override // androidx.work.impl.Scheduler
    public void schedule(WorkSpec... r100) {
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        scheduleWorkSpec(r100[r102]);
        r102 = r102 + 1;
        goto L3
    }
}
