package com.stepos.policy.sdk.util;

import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.Socket;
import okhttp3.internal.platform.Platform;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes.dex */
public final class SocketHookUtil {

    @NotNull
    public static final String TAG = "SocketHookUtil";

    @Nullable
    private static Platform sOriginPlatform;

    public static void recoveryPlatform() {
        if (sOriginPlatform == null) {
            return;
        }
        try {
            Field declaredField = Platform.class.getDeclaredField("PLATFORM");
            declaredField.setAccessible(true);
            declaredField.set(null, sOriginPlatform);
            sOriginPlatform = null;
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public static void replacePlatform() {
        if (sOriginPlatform != null) {
            return;
        }
        Log.d(TAG, "replacePlatform");
        sOriginPlatform = Platform.get();
        try {
            Field declaredField = Platform.class.getDeclaredField("PLATFORM");
            declaredField.setAccessible(true);
            declaredField.set(null, new Platform() { // from class: com.stepos.policy.sdk.util.SocketHookUtil.1
                @Override // okhttp3.internal.platform.Platform
                public void connectSocket(@Nullable Socket socket, @Nullable InetSocketAddress inetSocketAddress, int i4) throws IOException {
                    throw new IOException("not allow connect socket before accept policy");
                }
            });
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }
}
