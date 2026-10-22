package com.android.server.biometrics.sensors;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class BiometricNotificationImpl implements BiometricNotification {
    public BiometricNotificationImpl() {
    }

    @Override // com.android.server.biometrics.sensors.BiometricNotification
    public void sendFaceEnrollNotification(Context context) {
        BiometricNotificationUtils.showFaceEnrollNotification(context);
    }

    @Override // com.android.server.biometrics.sensors.BiometricNotification
    public void sendFpEnrollNotification(Context context) {
        BiometricNotificationUtils.showFingerprintEnrollNotification(context);
    }

    @Override // com.android.server.biometrics.sensors.BiometricNotification
    public boolean sendCustomizeFpFrrNotification(Context context) {
        return BiometricNotificationUtils.showCustomizeFpFrrNotification(context);
    }
}
