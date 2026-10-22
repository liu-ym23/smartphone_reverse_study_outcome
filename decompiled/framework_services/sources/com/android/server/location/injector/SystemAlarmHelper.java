package com.android.server.location.injector;

import android.app.AlarmManager;
import android.content.Context;
import android.os.SystemClock;
import android.os.WorkSource;
import com.android.server.FgThread;

/* JADX INFO: loaded from: classes2.dex */
public class SystemAlarmHelper extends AlarmHelper {
    private final Context mContext;

    public SystemAlarmHelper(Context context) {
        this.mContext = context;
    }

    @Override // com.android.server.location.injector.AlarmHelper
    public void setDelayedAlarmInternal(long delayMs, AlarmManager.OnAlarmListener listener, WorkSource workSource) {
        AlarmManager alarmManager = (AlarmManager) this.mContext.getSystemService(AlarmManager.class);
        alarmManager.getClass();
        alarmManager.set(2, SystemClock.elapsedRealtime() + delayMs, 0, 0, listener, FgThread.getHandler(), workSource);
    }

    @Override // com.android.server.location.injector.AlarmHelper
    public void cancel(AlarmManager.OnAlarmListener listener) {
        AlarmManager alarmManager = (AlarmManager) this.mContext.getSystemService(AlarmManager.class);
        alarmManager.getClass();
        alarmManager.cancel(listener);
    }
}
