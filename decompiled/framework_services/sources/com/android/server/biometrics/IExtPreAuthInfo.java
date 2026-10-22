package com.android.server.biometrics;

import android.pico.utils.IExtBase;
import android.util.Pair;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface IExtPreAuthInfo extends IExtBase {
    default void disableUdfpsIfNeed(String opPackageName, int requestedStrength, List<BiometricSensor> eligibleSensors, List<Pair<BiometricSensor, Integer>> ineligibleSensors) {
    }
}
