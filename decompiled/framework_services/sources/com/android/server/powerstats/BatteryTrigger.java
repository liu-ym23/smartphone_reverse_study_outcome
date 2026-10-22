package com.android.server.powerstats;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* JADX INFO: loaded from: classes3.dex */
public final class BatteryTrigger extends PowerStatsLogTrigger {
    private static final boolean DEBUG = false;
    private static final String TAG = null;
    private int mBatteryLevel;
    private final BroadcastReceiver mBatteryLevelReceiver;

    /* JADX INFO: renamed from: -$$Nest$fgetmBatteryLevel, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m7872$$Nest$fgetmBatteryLevel(BatteryTrigger r0) {
        return r0.mBatteryLevel;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmBatteryLevel, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7873$$Nest$fputmBatteryLevel(BatteryTrigger r0, int r1) {
        r0.mBatteryLevel = r1;
    }

    static {
        TAG = BatteryTrigger.class.getSimpleName();
    }

    public BatteryTrigger(Context context, PowerStatsLogger powerStatsLogger, boolean triggerEnabled) {
        super(context, powerStatsLogger);
        this.mBatteryLevel = 0;
        this.mBatteryLevelReceiver = new AnonymousClass1(this);
        if (triggerEnabled == false) goto L8;
        IntentFilter filter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        Intent batteryStatus = this.mContext.registerReceiver(this.mBatteryLevelReceiver, filter);
        if (batteryStatus == null) goto L9;
        this.mBatteryLevel = batteryStatus.getIntExtra("level", 0);
        return;
    L9:
        return;
    }
}
