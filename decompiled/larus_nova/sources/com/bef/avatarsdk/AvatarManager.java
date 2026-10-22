package com.bef.avatarsdk;

import android.content.Context;
import com.ss.android.tecommonenvinitializer.diagnosis.b;
import java.util.Collections;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes39.dex */
public class AvatarManager {
    private native long nativeCreateAvatarApp(Context r100, String r101);

    private native long nativeCreateBuiltInDriver(long r100, int r101, String r102);

    private native int nativeDestroyAvatarApp(long r100);

    private static native String nativeGetAvatarCoreVersion();

    private static native long nativeGetSDKCaps();

    private native int nativeInitResourceFinder(long r100, long r101);

    private native long nativeLoadBuiltInCVAvatar(long r100, String r101, String r102, int r103, String r104);

    static {
        new AvatarManager();
        b.a(Collections.singletonList("effect"));
    }

    public AvatarManager() {
        new ReentrantLock();
    }
}
