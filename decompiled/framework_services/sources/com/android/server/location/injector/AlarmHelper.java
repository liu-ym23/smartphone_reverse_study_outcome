package com.android.server.location.injector;

import android.app.AlarmManager;
import android.os.WorkSource;
import com.android.internal.util.Preconditions;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AlarmHelper {
    public abstract void cancel(AlarmManager.OnAlarmListener r1);

    protected abstract void setDelayedAlarmInternal(long r1, AlarmManager.OnAlarmListener r3, WorkSource r4);

    public AlarmHelper() {
    }

    public final void setDelayedAlarm(long delayMs, AlarmManager.OnAlarmListener listener, WorkSource workSource) {
        if (delayMs <= 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0);
        setDelayedAlarmInternal(delayMs, listener, workSource);
        return;
    L5:
        r0 = false;
        goto L6
    }
}
