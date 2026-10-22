package com.android.server.biometrics.sensors;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public interface BiometricNotification {
    boolean sendCustomizeFpFrrNotification(Context r1);

    void sendFaceEnrollNotification(Context r1);

    void sendFpEnrollNotification(Context r1);
}
