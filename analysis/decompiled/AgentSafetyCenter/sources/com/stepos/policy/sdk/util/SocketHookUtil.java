package com.stepos.policy.sdk.util;

import android.util.Log;
import id.n;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.Socket;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class SocketHookUtil {
    public static final String TAG = "SocketHookUtil";
    private static n sOriginPlatform;

    public static void recoveryPlatform() {
        if (sOriginPlatform == null) {
            return;
        }
        try {
            Field declaredField = n.class.getDeclaredField("PLATFORM");
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
        sOriginPlatform = n.get();
        try {
            Field declaredField = n.class.getDeclaredField("PLATFORM");
            declaredField.setAccessible(true);
            declaredField.set(null, new n() { // from class: com.stepos.policy.sdk.util.SocketHookUtil.1
                @Override // id.n
                public void connectSocket(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
                    throw new IOException("not allow connect socket before accept policy");
                }
            });
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
