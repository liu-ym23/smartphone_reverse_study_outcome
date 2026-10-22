package com.stepos.policy.sdk.util;

import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.Socket;
import kd.h;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class SocketHookUtil {
    public static final String TAG = "SocketHookUtil";
    private static h sOriginPlatform;

    public static void recoveryPlatform() {
        if (sOriginPlatform == null) {
            return;
        }
        try {
            Field declaredField = h.class.getDeclaredField("PLATFORM");
            declaredField.setAccessible(true);
            declaredField.set(null, sOriginPlatform);
            sOriginPlatform = null;
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static void replacePlatform() {
        if (sOriginPlatform != null) {
            return;
        }
        Log.d(TAG, "replacePlatform");
        sOriginPlatform = h.get();
        try {
            Field declaredField = h.class.getDeclaredField("PLATFORM");
            declaredField.setAccessible(true);
            declaredField.set(null, new h() { // from class: com.stepos.policy.sdk.util.SocketHookUtil.1
                @Override // kd.h
                public void connectSocket(Socket socket, InetSocketAddress inetSocketAddress, int i10) throws IOException {
                    throw new IOException("not allow connect socket before accept policy");
                }
            });
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
