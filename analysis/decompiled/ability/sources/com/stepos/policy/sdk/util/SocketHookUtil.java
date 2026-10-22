package com.stepos.policy.sdk.util;

import N9.m;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.Socket;

/* loaded from: classes3.dex */
public final class SocketHookUtil {
    public static final String TAG = "SocketHookUtil";
    private static m sOriginPlatform;

    public static void recoveryPlatform() {
        if (sOriginPlatform == null) {
            return;
        }
        try {
            Field declaredField = m.class.getDeclaredField("PLATFORM");
            declaredField.setAccessible(true);
            declaredField.set(null, sOriginPlatform);
            sOriginPlatform = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void replacePlatform() {
        if (sOriginPlatform != null) {
            return;
        }
        Log.d(TAG, "replacePlatform");
        sOriginPlatform = m.get();
        try {
            Field declaredField = m.class.getDeclaredField("PLATFORM");
            declaredField.setAccessible(true);
            declaredField.set(null, new m() { // from class: com.stepos.policy.sdk.util.SocketHookUtil.1
                @Override // N9.m
                public void connectSocket(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
                    throw new IOException("not allow connect socket before accept policy");
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
