package com.android.server.sensors;

import android.os.ParcelFileDescriptor;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public abstract class SensorManagerInternal {

    public interface ProximityActiveListener {
        void onProximityActive(boolean r1);
    }

    public interface RuntimeSensorCallback {
        int onConfigurationChanged(int r1, boolean r2, int r3, int r4);

        int onDirectChannelConfigured(int r1, int r2, int r3);

        int onDirectChannelCreated(ParcelFileDescriptor r1);

        void onDirectChannelDestroyed(int r1);
    }

    public abstract void addProximityActiveListener(Executor r1, ProximityActiveListener r2);

    public abstract int createRuntimeSensor(int r1, int r2, String r3, String r4, float r5, float r6, float r7, int r8, int r9, int r10, RuntimeSensorCallback r11);

    public abstract void removeProximityActiveListener(ProximityActiveListener r1);

    public abstract void removeRuntimeSensor(int r1);

    public abstract boolean sendSensorAdditionalInfo(int r1, int r2, int r3, long r4, float[] r6);

    public abstract boolean sendSensorEvent(int r1, int r2, long r3, float[] r5);

    public SensorManagerInternal() {
    }
}
