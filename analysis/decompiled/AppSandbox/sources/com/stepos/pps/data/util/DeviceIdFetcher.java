package com.stepos.pps.data.util;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes.dex */
public class DeviceIdFetcher {
    private static final int MAX_RETRY_COUNT = 3;
    private static final long RETRY_DELAY_MS = 60000;
    private static final String TAG = "DeviceIdFetcher";

    public interface DeviceIdCallback {
        void onFailure(String str);

        void onSuccess(String str);
    }

    public static void fetchDeviceIdWithRetry(final DeviceIdCallback deviceIdCallback) {
        new Thread(new Runnable() { // from class: com.stepos.pps.data.util.DeviceIdFetcher$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() throws InterruptedException {
                DeviceIdFetcher.lambda$fetchDeviceIdWithRetry$1(deviceIdCallback);
            }
        }).start();
    }

    static /* synthetic */ void lambda$fetchDeviceIdWithRetry$1(final DeviceIdCallback deviceIdCallback) throws InterruptedException {
        int i = 0;
        final String deviceId = null;
        final boolean z = false;
        while (i < 3 && !z) {
            try {
                deviceId = DeviceUtils.getDeviceId();
            } catch (Exception unused) {
                i++;
                if (i < 3) {
                    try {
                        Thread.sleep(RETRY_DELAY_MS);
                    } catch (InterruptedException unused2) {
                        Thread.currentThread().interrupt();
                    }
                } else {
                    continue;
                }
            }
            if (deviceId == null || deviceId.isEmpty()) {
                throw new IllegalStateException("Device ID is empty");
            }
            z = true;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.stepos.pps.data.util.DeviceIdFetcher$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                DeviceIdFetcher.lambda$fetchDeviceIdWithRetry$0(z, deviceIdCallback, deviceId);
            }
        });
    }

    static /* synthetic */ void lambda$fetchDeviceIdWithRetry$0(boolean z, DeviceIdCallback deviceIdCallback, String str) {
        if (z) {
            deviceIdCallback.onSuccess(str);
        } else {
            deviceIdCallback.onFailure("Failed to get device ID after 3 attempts");
        }
    }
}
