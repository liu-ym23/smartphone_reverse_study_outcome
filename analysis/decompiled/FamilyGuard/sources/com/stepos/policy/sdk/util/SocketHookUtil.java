package com.stepos.policy.sdk.util;

import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.Socket;

/* loaded from: classes.dex */
public final class SocketHookUtil {
    public static final String TAG = "SocketHookUtil";
    private static okhttp3.internal.platform.f sOriginPlatform;

    public static void recoveryPlatform() throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        if (sOriginPlatform == null) {
            return;
        }
        try {
            Field declaredField = okhttp3.internal.platform.f.class.getDeclaredField("PLATFORM");
            declaredField.setAccessible(true);
            declaredField.set(null, sOriginPlatform);
            sOriginPlatform = null;
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public static void replacePlatform() throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        if (sOriginPlatform != null) {
            return;
        }
        Log.d(TAG, "replacePlatform");
        sOriginPlatform = okhttp3.internal.platform.f.get();
        try {
            Field declaredField = okhttp3.internal.platform.f.class.getDeclaredField("PLATFORM");
            declaredField.setAccessible(true);
            declaredField.set(null, new okhttp3.internal.platform.f() { // from class: com.stepos.policy.sdk.util.SocketHookUtil.1
                @Override // okhttp3.internal.platform.f
                public void connectSocket(Socket socket, InetSocketAddress inetSocketAddress, int i5) throws IOException {
                    throw new IOException("not allow connect socket before accept policy");
                }
            });
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }
}
