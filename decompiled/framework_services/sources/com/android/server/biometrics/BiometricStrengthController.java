package com.android.server.biometrics;

import android.provider.DeviceConfig;
import android.util.Slog;
import com.android.internal.os.BackgroundThread;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class BiometricStrengthController {
    private static final String KEY_BIOMETRIC_STRENGTHS = "biometric_strengths";
    private static final String TAG = "BiometricStrengthController";
    private DeviceConfig.OnPropertiesChangedListener mDeviceConfigListener;
    private final BiometricService mService;

    /* JADX INFO: renamed from: $r8$lambda$6_DDeUmKK-vfzjtJW97cEXczAbk, reason: not valid java name */
    public static /* synthetic */ void m2596$r8$lambda$6_DDeUmKKvfzjtJW97cEXczAbk(BiometricStrengthController r0, DeviceConfig.Properties r1) {
        r0.lambda$new$0(r1);
    }

    private /* synthetic */ void lambda$new$0(DeviceConfig.Properties properties) {
        if (properties.getKeyset().contains(KEY_BIOMETRIC_STRENGTHS) == false) goto L6;
        updateStrengths();
        return;
    }

    public BiometricStrengthController(BiometricService service) {
        this.mDeviceConfigListener = new BiometricStrengthController$$ExternalSyntheticLambda0(this);
        this.mService = service;
    }

    public void startListening() {
        DeviceConfig.addOnPropertiesChangedListener("biometrics", BackgroundThread.getExecutor(), this.mDeviceConfigListener);
    }

    public void updateStrengths() {
        String newValue = DeviceConfig.getString("biometrics", KEY_BIOMETRIC_STRENGTHS, "null");
        if ("null".equals(newValue) == false) goto L5;
    L8:
        revertStrengths();
        return;
    L5:
        if (newValue.isEmpty() == true) goto L8;
        updateStrengths(newValue);
    }

    private void updateStrengths(String flags) {
        Map<Integer, Integer> idToStrength = getIdToStrengthMap(flags);
        if (idToStrength != null) goto L5;
        return;
    L5:
        Iterator<BiometricSensor> r1 = this.mService.mSensors.iterator();
    L7:
        if (r1.hasNext() == false) goto L12;
        BiometricSensor sensor = r1.next();
        int id = sensor.id;
        if (idToStrength.containsKey(Integer.valueOf(id)) == false) goto L7;
        int newStrength = idToStrength.get(Integer.valueOf(id)).intValue();
        Slog.d(TAG, "updateStrengths: update sensorId=" + id + " to newStrength=" + newStrength);
        sensor.updateStrength(newStrength);
        goto L7
    }

    private void revertStrengths() {
        Iterator<BiometricSensor> r0 = this.mService.mSensors.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        BiometricSensor sensor = r0.next();
        Slog.d(TAG, "updateStrengths: revert sensorId=" + sensor.id + " to oemStrength=" + sensor.oemStrength);
        sensor.updateStrength(sensor.oemStrength);
        goto L4
    }

    private static Map<Integer, Integer> getIdToStrengthMap(String flags) {
        if (flags != null) goto L5;
    L17:
        Slog.d(TAG, "Flags are null or empty");
        return null;
    L5:
        if (flags.isEmpty() == true) goto L17;
        Map<Integer, Integer> map = new HashMap();
        String[] r2 = flags.split(",");     // Catch: Exception -> L12
        int r3 = r2.length;     // Catch: Exception -> L12
        int r5 = 0;
    L9:
        if (r5 >= r3) goto L22;
        String item = r2[r5];     // Catch: Exception -> L12
        String[] elems = item.split(":");     // Catch: Exception -> L12
        int id = Integer.parseInt(elems[0]);     // Catch: Exception -> L12
        int strength = Integer.parseInt(elems[1]);     // Catch: Exception -> L12
        map.put(Integer.valueOf(id), Integer.valueOf(strength));     // Catch: Exception -> L12
        r5 = r5 + 1;
        goto L9
    L22:
        return map;
    L15:
        Slog.e(TAG, "Can't parse flag: " + flags);
        return null;
    }
}
