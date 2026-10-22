package com.baidu.platform.comjni.map.msgcenter;

import com.baidu.platform.comjni.JNIBaseApi;

/* JADX INFO: loaded from: classes39.dex */
public class NAMsgCenter extends JNIBaseApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f33490a;

    private native boolean nativeCancelRequest(long r100);

    private native long nativeCreate();

    private native boolean nativeFetchAccessToken(long r100);

    private native String nativeGetCenterParam(long r100, String r101);

    private native boolean nativeMSGCStartup(long r100);

    private native boolean nativeRegMsgCenter(long r100, String r101);

    private native int nativeRelease(long r100);

    private native boolean nativeSetCenterParam(long r100, String r101);

    public NAMsgCenter() {
        this.f33490a = 0;
    }
}
