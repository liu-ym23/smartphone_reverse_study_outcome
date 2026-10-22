package com.android.server;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.BatteryManagerInternal;
import android.os.PowerManager;
import android.util.Slog;
import com.android.internal.os.CachedDeviceState;

/* JADX INFO: loaded from: classes.dex */
public class CachedDeviceStateService extends SystemService {
    private static final String TAG = "CachedDeviceStateService";
    private final BroadcastReceiver mBroadcastReceiver;
    private final CachedDeviceState mDeviceState;

    /* JADX INFO: renamed from: -$$Nest$fgetmDeviceState, reason: not valid java name */
    static /* bridge */ /* synthetic */ CachedDeviceState m145$$Nest$fgetmDeviceState(CachedDeviceStateService r0) {
        return r0.mDeviceState;
    }

    public CachedDeviceStateService(Context context) {
        super(context);
        this.mDeviceState = new CachedDeviceState();
        this.mBroadcastReceiver = new AnonymousClass1(this);
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        publishLocalService(CachedDeviceState.Readonly.class, this.mDeviceState.getReadonlyClient());
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        if (500 != phase) goto L6;
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.BATTERY_CHANGED");
        filter.addAction("android.intent.action.SCREEN_ON");
        filter.addAction("android.intent.action.SCREEN_OFF");
        filter.setPriority(1000);
        getContext().registerReceiver(this.mBroadcastReceiver, filter);
        this.mDeviceState.setCharging(queryIsCharging());
        this.mDeviceState.setScreenInteractive(queryScreenInteractive(getContext()));
        return;
    }

    private boolean queryIsCharging() {
        BatteryManagerInternal batteryManager = (BatteryManagerInternal) LocalServices.getService(BatteryManagerInternal.class);
        if (batteryManager != null) goto L7;
        Slog.wtf(TAG, "BatteryManager null while starting CachedDeviceStateService");
        return true;
    L7:
        if (batteryManager.getPlugType() != 0) goto L11;
        return false;
    L11:
        return true;
    }

    private boolean queryScreenInteractive(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService(PowerManager.class);
        if (powerManager != null) goto L7;
        Slog.wtf(TAG, "PowerManager null while starting CachedDeviceStateService");
        return false;
    L7:
        return powerManager.isInteractive();
    }
}
