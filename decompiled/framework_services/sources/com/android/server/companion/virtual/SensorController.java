package com.android.server.companion.virtual;

import android.companion.virtual.IVirtualDevice;
import android.companion.virtual.sensor.IVirtualSensorCallback;
import android.companion.virtual.sensor.VirtualSensor;
import android.companion.virtual.sensor.VirtualSensorAdditionalInfo;
import android.companion.virtual.sensor.VirtualSensorConfig;
import android.companion.virtual.sensor.VirtualSensorEvent;
import android.content.AttributionSource;
import android.os.Binder;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.SharedMemory;
import android.os.SystemClock;
import android.util.ArrayMap;
import android.util.Slog;
import android.util.SparseArray;
import com.android.modules.expresslog.Counter;
import com.android.server.LocalServices;
import com.android.server.sensors.SensorManagerInternal;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class SensorController {
    private static final int BAD_VALUE = -22;
    private static final int OK = 0;
    private static final String TAG = "SensorController";
    private static final int UNKNOWN_ERROR = Integer.MIN_VALUE;
    private static AtomicInteger sNextDirectChannelHandle;
    private final AttributionSource mAttributionSource;
    private final Object mLock;
    private final SensorManagerInternal.RuntimeSensorCallback mRuntimeSensorCallback;
    private final ArrayMap<IBinder, SensorDescriptor> mSensorDescriptors;
    private final SensorManagerInternal mSensorManagerInternal;
    private final VirtualDeviceManagerInternal mVdmInternal;
    private final int mVirtualDeviceId;
    private List<VirtualSensor> mVirtualSensorList;
    private SparseArray<VirtualSensor> mVirtualSensors;

    private final class RuntimeSensorCallbackWrapper implements SensorManagerInternal.RuntimeSensorCallback {
        private IVirtualSensorCallback mCallback;
        final /* synthetic */ SensorController this$0;

        RuntimeSensorCallbackWrapper(SensorController r1, IVirtualSensorCallback callback) {
            this.this$0 = r1;
            this.mCallback = callback;
        }

        @Override // com.android.server.sensors.SensorManagerInternal.RuntimeSensorCallback
        public int onConfigurationChanged(int handle, boolean enabled, int samplingPeriodMicros, int batchReportLatencyMicros) {
            if (this.mCallback != null) goto L7;
            Slog.e(SensorController.TAG, "No sensor callback configured for sensor handle " + handle);
            return -22;
        L7:
            if (SensorController.m3002$$Nest$fgetmVdmInternal(this.this$0) != null) goto L10;
            Slog.e(SensorController.TAG, "Virtual Device Manager is not enabled.");
            return -22;
        L10:
            VirtualSensor sensor = SensorController.m3002$$Nest$fgetmVdmInternal(this.this$0).getVirtualSensor(SensorController.m3003$$Nest$fgetmVirtualDeviceId(this.this$0), handle);
            if (sensor != null) goto L20;
            Slog.e(SensorController.TAG, "No sensor found for deviceId=" + SensorController.m3003$$Nest$fgetmVirtualDeviceId(this.this$0) + " and sensor handle=" + handle);
            return -22;
        L20:
            this.mCallback.onConfigurationChanged(sensor, enabled, samplingPeriodMicros, batchReportLatencyMicros);     // Catch: RemoteException -> L17
            return 0;
        L17:
            e = move-exception;
            Slog.e(SensorController.TAG, "Failed to call sensor callback: " + e);
            return Integer.MIN_VALUE;
        }

        @Override // com.android.server.sensors.SensorManagerInternal.RuntimeSensorCallback
        public int onDirectChannelCreated(ParcelFileDescriptor fd) {
            if (this.mCallback != null) goto L6;
            Slog.e(SensorController.TAG, "No sensor callback for virtual deviceId " + SensorController.m3003$$Nest$fgetmVirtualDeviceId(this.this$0));
            return -22;
        L6:
            if (fd != null) goto L21;
            Slog.e(SensorController.TAG, "Received invalid ParcelFileDescriptor");
            return -22;
        L21:
            SharedMemory sharedMemory = SharedMemory.fromFileDescriptor(fd);     // Catch: IllegalArgumentException -> L16
            int channelHandle = SensorController.m3004$$Nest$sfgetsNextDirectChannelHandle().getAndIncrement();
            this.mCallback.onDirectChannelCreated(channelHandle, sharedMemory);     // Catch: RemoteException -> L13
            return channelHandle;
        L13:
            e = move-exception;
            Slog.e(SensorController.TAG, "Failed to call sensor callback: " + e);
            return Integer.MIN_VALUE;
        L16:
            e = move-exception;
            Slog.e(SensorController.TAG, "Failed to create shared memory: " + e);
            return -22;
        }

        @Override // com.android.server.sensors.SensorManagerInternal.RuntimeSensorCallback
        public void onDirectChannelDestroyed(int channelHandle) {
            if (this.mCallback != null) goto L11;
            Slog.e(SensorController.TAG, "No sensor callback for virtual deviceId " + SensorController.m3003$$Nest$fgetmVirtualDeviceId(this.this$0));
            return;
        L11:
            this.mCallback.onDirectChannelDestroyed(channelHandle);     // Catch: RemoteException -> L8
            return;
        L8:
            e = move-exception;
            Slog.e(SensorController.TAG, "Failed to call sensor callback: " + e);
        }

        @Override // com.android.server.sensors.SensorManagerInternal.RuntimeSensorCallback
        public int onDirectChannelConfigured(int channelHandle, int sensorHandle, int rateLevel) {
            if (this.mCallback != null) goto L7;
            Slog.e(SensorController.TAG, "No runtime sensor callback configured.");
            return -22;
        L7:
            if (SensorController.m3002$$Nest$fgetmVdmInternal(this.this$0) != null) goto L10;
            Slog.e(SensorController.TAG, "Virtual Device Manager is not enabled.");
            return -22;
        L10:
            VirtualSensor sensor = SensorController.m3002$$Nest$fgetmVdmInternal(this.this$0).getVirtualSensor(SensorController.m3003$$Nest$fgetmVirtualDeviceId(this.this$0), sensorHandle);
            if (sensor != null) goto L22;
            Slog.e(SensorController.TAG, "No sensor found for deviceId=" + SensorController.m3003$$Nest$fgetmVirtualDeviceId(this.this$0) + " and sensor handle=" + sensorHandle);
            return -22;
        L22:
            this.mCallback.onDirectChannelConfigured(channelHandle, sensor, rateLevel, sensorHandle);     // Catch: RemoteException -> L19
            if (rateLevel != 0) goto L18;
            return 0;
        L18:
            return sensorHandle;
        L19:
            e = move-exception;
            Slog.e(SensorController.TAG, "Failed to call sensor callback: " + e);
            return Integer.MIN_VALUE;
        }
    }

    private static class SensorCreationException extends Exception {
        SensorCreationException(String message) {
            super(message);
        }
    }

    static final class SensorDescriptor {
        private final int mHandle;
        private final String mName;
        private final int mType;

        /* JADX INFO: renamed from: -$$Nest$fgetmHandle, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m3005$$Nest$fgetmHandle(SensorDescriptor r0) {
            return r0.mHandle;
        }

        SensorDescriptor(int handle, int type, String name) {
            this.mHandle = handle;
            this.mType = type;
            this.mName = name;
        }

        public int getHandle() {
            return this.mHandle;
        }

        public int getType() {
            return this.mType;
        }

        public String getName() {
            return this.mName;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$ZcEHmBQisnAe3XHQp_iGjHvd-wM, reason: not valid java name */
    public static /* synthetic */ void m3001$r8$lambda$ZcEHmBQisnAe3XHQp_iGjHvdwM(SensorController r0, SensorDescriptor r1) {
        r0.lambda$close$0(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmVdmInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ VirtualDeviceManagerInternal m3002$$Nest$fgetmVdmInternal(SensorController r0) {
        return r0.mVdmInternal;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmVirtualDeviceId, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m3003$$Nest$fgetmVirtualDeviceId(SensorController r0) {
        return r0.mVirtualDeviceId;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetsNextDirectChannelHandle, reason: not valid java name */
    static /* bridge */ /* synthetic */ AtomicInteger m3004$$Nest$sfgetsNextDirectChannelHandle() {
        return sNextDirectChannelHandle;
    }

    static {
        sNextDirectChannelHandle = new AtomicInteger(1);
    }

    public SensorController(IVirtualDevice virtualDevice, int virtualDeviceId, AttributionSource attributionSource, IVirtualSensorCallback virtualSensorCallback, List<VirtualSensorConfig> sensors) {
        this.mLock = new Object();
        this.mSensorDescriptors = new ArrayMap();
        this.mVirtualSensors = new SparseArray();
        this.mVirtualSensorList = null;
        this.mVirtualDeviceId = virtualDeviceId;
        this.mAttributionSource = attributionSource;
        this.mRuntimeSensorCallback = new RuntimeSensorCallbackWrapper(this, virtualSensorCallback);
        this.mSensorManagerInternal = (SensorManagerInternal) LocalServices.getService(SensorManagerInternal.class);
        this.mVdmInternal = (VirtualDeviceManagerInternal) LocalServices.getService(VirtualDeviceManagerInternal.class);
        createSensors(virtualDevice, sensors);
    }

    void close() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mSensorDescriptors.values().forEach(new SensorController$$ExternalSyntheticLambda0(this));     // Catch: Throwable -> L7
        this.mSensorDescriptors.clear();     // Catch: Throwable -> L7
        this.mVirtualSensors.clear();     // Catch: Throwable -> L7
        this.mVirtualSensorList = null;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$close$0(SensorDescriptor descriptor) {
        this.mSensorManagerInternal.removeRuntimeSensor(SensorDescriptor.m3005$$Nest$fgetmHandle(descriptor));
    }

    private void createSensors(IVirtualDevice virtualDevice, List<VirtualSensorConfig> configs) {
        virtualDevice.getClass();
        long token = Binder.clearCallingIdentity();
        Iterator<VirtualSensorConfig> r2 = configs.iterator();     // Catch: Throwable -> L8 SensorCreationException -> L10
    L5:
        if (r2.hasNext() == false) goto L12;
        VirtualSensorConfig config = r2.next();     // Catch: Throwable -> L8 SensorCreationException -> L10
        createSensorInternal(virtualDevice, config);     // Catch: Throwable -> L8 SensorCreationException -> L10
    L12:
        Binder.restoreCallingIdentity(token);
        return;
    L10:
        e = move-exception;
        throw new RuntimeException("Failed to create virtual sensor", e);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    private void createSensorInternal(IVirtualDevice virtualDevice, VirtualSensorConfig config) throws SensorCreationException {
        config.getClass();
        if (config.getType() <= 0) goto L23;
        SensorManagerInternal r2 = this.mSensorManagerInternal;
        int r3 = this.mVirtualDeviceId;
        int r4 = config.getType();
        String r5 = config.getName();
        if (config.getVendor() != null) goto L8;
        String r0 = "";
    L9:
        int handle = r2.createRuntimeSensor(r3, r4, r5, r0, config.getMaximumRange(), config.getResolution(), config.getPower(), config.getMinDelay(), config.getMaxDelay(), config.getFlags(), this.mRuntimeSensorCallback);
        if (handle <= 0) goto L21;
        SensorDescriptor sensorDescriptor = new SensorDescriptor(handle, config.getType(), config.getName());
        IBinder sensorToken = new Binder("android.hardware.sensor.VirtualSensor:" + config.getName());
        VirtualSensor sensor = new VirtualSensor(handle, config.getType(), config.getName(), config.getFlags(), virtualDevice, sensorToken);
        Object r6 = this.mLock;
        monitor-enter(r6);
        this.mSensorDescriptors.put(sensorToken, sensorDescriptor);     // Catch: Throwable -> L17
        this.mVirtualSensors.put(handle, sensor);     // Catch: Throwable -> L17
        monitor-exit(r6);     // Catch: Throwable -> L17
        Counter.logIncrementWithUid("virtual_devices.value_virtual_sensors_created_count", this.mAttributionSource.getUid());
        return;
    L17:
        th = move-exception;
        throw th;
    L21:
        throw new SensorCreationException("Received an invalid virtual sensor handle '" + config.getName() + "'.");
    L8:
        r0 = config.getVendor();
        goto L9
    L23:
        throw new SensorCreationException("Received an invalid virtual sensor type (config name '" + config.getName() + "').");
    }

    boolean sendSensorEvent(IBinder token, VirtualSensorEvent event) {
        token.getClass();
        event.getClass();
        Object r1 = this.mLock;
        monitor-enter(r1);
        SensorDescriptor sensorDescriptor = this.mSensorDescriptors.get(token);     // Catch: Throwable -> L9
        if (sensorDescriptor == null) goto L12;
        boolean r2 = this.mSensorManagerInternal.sendSensorEvent(sensorDescriptor.getHandle(), sensorDescriptor.getType(), event.getTimestampNanos(), event.getValues());     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return r2;
    L12:
        throw new IllegalArgumentException("Could not send sensor event for given token");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    boolean sendSensorAdditionalInfo(IBinder token, VirtualSensorAdditionalInfo info) {
        token.getClass();
        info.getClass();
        Object r2 = this.mLock;
        monitor-enter(r2);
        SensorDescriptor sensorDescriptor = this.mSensorDescriptors.get(token);     // Catch: Throwable -> L12
        long timestamp = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L12
        if (sensorDescriptor == null) goto L31;
        long timestamp2 = timestamp + 1;     // Catch: Throwable -> L12
        if (this.mSensorManagerInternal.sendSensorAdditionalInfo(sensorDescriptor.getHandle(), 0, 0, timestamp, null) == true) goto L14;
        monitor-exit(r2);     // Catch: Throwable -> L12
        return false;
    L14:
        int i = 0;
        long timestamp3 = timestamp2;
    L16:
        if (i >= info.getValues().size()) goto L23;
        long timestamp4 = timestamp3 + 1;     // Catch: Throwable -> L12
        int i2 = i;
        if (this.mSensorManagerInternal.sendSensorAdditionalInfo(sensorDescriptor.getHandle(), info.getType(), i2, timestamp3, (float[]) info.getValues().get(i)) == false) goto L19;
        i = i2 + 1;     // Catch: Throwable -> L12
        timestamp3 = timestamp4;
        goto L16
    L19:
        monitor-exit(r2);     // Catch: Throwable -> L12
        return false;
    L23:
        if (this.mSensorManagerInternal.sendSensorAdditionalInfo(sensorDescriptor.getHandle(), 1, 0, timestamp3, null) == true) goto L27;
        monitor-exit(r2);     // Catch: Throwable -> L12
        return false;
    L27:
        monitor-exit(r2);     // Catch: Throwable -> L12
        return true;
    L31:
        throw new IllegalArgumentException("Could not send sensor event for given token");     // Catch: Throwable -> L12
    L12:
        th = th;
    L34:
        monitor-exit(r2);     // Catch: Throwable -> L12
        throw th;
    L32:
        th = th;
        goto L34
    }

    VirtualSensor getSensorByHandle(int handle) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        VirtualSensor r1 = this.mVirtualSensors.get(handle);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    List<VirtualSensor> getSensorList() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mVirtualSensorList != null) goto L13;
        this.mVirtualSensorList = new ArrayList(this.mVirtualSensors.size());     // Catch: Throwable -> L10
        int i = 0;
    L8:
        if (i >= this.mVirtualSensors.size()) goto L12;
        this.mVirtualSensorList.add(this.mVirtualSensors.valueAt(i));     // Catch: Throwable -> L10
        i = i + 1;     // Catch: Throwable -> L10
        goto L8
    L12:
        this.mVirtualSensorList = Collections.unmodifiableList(this.mVirtualSensorList);     // Catch: Throwable -> L10
    L13:
        List<VirtualSensor> r1 = this.mVirtualSensorList;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    }

    void dump(PrintWriter fout) {
        fout.println("    SensorController: ");
        Object r0 = this.mLock;
        monitor-enter(r0);
        fout.println("      Active descriptors: ");     // Catch: Throwable -> L8
        Iterator<SensorDescriptor> r1 = this.mSensorDescriptors.values().iterator();     // Catch: Throwable -> L8
    L6:
        if (r1.hasNext() == false) goto L10;
        SensorDescriptor sensorDescriptor = r1.next();     // Catch: Throwable -> L8
        fout.println("        handle: " + sensorDescriptor.getHandle());     // Catch: Throwable -> L8
        fout.println("          type: " + sensorDescriptor.getType());     // Catch: Throwable -> L8
        fout.println("          name: " + sensorDescriptor.getName());     // Catch: Throwable -> L8
        goto L6
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    void addSensorForTesting(IBinder deviceToken, int handle, int type, String name) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mSensorDescriptors.put(deviceToken, new SensorDescriptor(handle, type, name));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    Map<IBinder, SensorDescriptor> getSensorDescriptors() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ArrayMap r1 = new ArrayMap(this.mSensorDescriptors);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }
}
