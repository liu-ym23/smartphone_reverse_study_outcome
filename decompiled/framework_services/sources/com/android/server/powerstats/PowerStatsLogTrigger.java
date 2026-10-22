package com.android.server.powerstats;

import android.content.Context;
import android.os.Message;

/* JADX INFO: loaded from: classes3.dex */
public abstract class PowerStatsLogTrigger {
    private static final String TAG = null;
    protected Context mContext;
    private PowerStatsLogger mPowerStatsLogger;

    static {
        TAG = PowerStatsLogTrigger.class.getSimpleName();
    }

    protected void logPowerStatsData(int msgType) {
        Message.obtain(this.mPowerStatsLogger, msgType).sendToTarget();
    }

    public PowerStatsLogTrigger(Context context, PowerStatsLogger powerStatsLogger) {
        this.mContext = context;
        this.mPowerStatsLogger = powerStatsLogger;
    }
}
