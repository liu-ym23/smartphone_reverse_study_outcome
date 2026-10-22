package com.bytedance.apm.perf;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.GlobalProxyLancet;
import com.bytedance.apm.ApmContext;

/* JADX INFO: loaded from: classes2.dex */
public class TemperatureDataManager {
    private BroadcastReceiver batteryReceiver;
    private IntentFilter intentFilter;
    private boolean isRegistered;
    private int mPlugged;
    private int mStatus;
    private float mTemperature;

    private static class Holder {
        private static final TemperatureDataManager INSTANCE = null;

        private Holder() {
        }

        static /* synthetic */ TemperatureDataManager access$100() {
            return INSTANCE;
        }

        static {
            INSTANCE = new TemperatureDataManager(null);
        }
    }

    /* synthetic */ TemperatureDataManager(AnonymousClass1 r1) {
        this();
    }

    static /* synthetic */ float access$202(TemperatureDataManager r0, float r1) {
        r0.mTemperature = r1;
        return r1;
    }

    static /* synthetic */ int access$302(TemperatureDataManager r0, int r1) {
        r0.mStatus = r1;
        return r1;
    }

    static /* synthetic */ int access$402(TemperatureDataManager r0, int r1) {
        r0.mPlugged = r1;
        return r1;
    }

    private TemperatureDataManager() {
        onInit();
    }

    public static TemperatureDataManager getInstance() {
        return Holder.access$100();
    }

    private void onInit() {
        this.batteryReceiver = new AnonymousClass1(this);
        this.intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    }

    public synchronized void registerTemperatureReceiver() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.isRegistered == false) goto L17;
        monitor-exit(this);
        return;
    L17:
        this.isRegistered = true;     // Catch: Exception -> L14 Throwable -> L11
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(ApmContext.getContext(), this.batteryReceiver, this.intentFilter);     // Catch: Exception -> L14 Throwable -> L11
    L9:
        monitor-exit(this);
    }

    public synchronized void unRegisterTemperatureReceiver() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.isRegistered == true) goto L16;
        monitor-exit(this);
        return;
    L16:
        ApmContext.getContext().unregisterReceiver(this.batteryReceiver);     // Catch: Exception -> L13 Throwable -> L10
        this.isRegistered = false;     // Catch: Exception -> L13 Throwable -> L10
    L8:
        monitor-exit(this);
    }

    public float getTemperature() {
        return this.mTemperature;
    }

    public boolean isRegistered() {
        return this.isRegistered;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public int getPlugged() {
        return this.mPlugged;
    }
}
