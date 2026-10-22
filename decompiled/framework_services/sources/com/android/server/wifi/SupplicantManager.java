package com.android.server.wifi;

import android.annotation.SystemApi;
import android.os.SystemService;
import android.util.Log;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
@SystemApi(client = SystemApi.Client.SYSTEM_SERVER)
public class SupplicantManager {
    private static final String TAG = "SupplicantManager";
    private static final String WPA_SUPPLICANT_DAEMON_NAME = "wpa_supplicant";

    private SupplicantManager() {
    }

    public static void start() {
        SystemService.start(WPA_SUPPLICANT_DAEMON_NAME);     // Catch: RuntimeException -> L4
        return;
    L6:
        throw new NoSuchElementException("Failed to start Supplicant");
    }

    public static void stop() {
        SystemService.stop(WPA_SUPPLICANT_DAEMON_NAME);     // Catch: RuntimeException -> L4
        return;
    L4:
        e = move-exception;
        Log.w(TAG, "Failed to stop Supplicant", e);
    }
}
