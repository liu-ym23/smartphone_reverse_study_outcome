package com.baidu.platform.comjni.map.msgcenter;

import com.baidu.platform.comjni.JNIBaseApi;

/* loaded from: classes.dex */
public class NAMsgCenter extends JNIBaseApi {

    /* renamed from: a, reason: collision with root package name */
    private long f9367a = 0;

    private native boolean nativeCancelRequest(long j4);

    private native long nativeCreate();

    private native boolean nativeFetchAccessToken(long j4);

    private native String nativeGetCenterParam(long j4, String str);

    private native boolean nativeMSGCStartup(long j4);

    private native boolean nativeRegMsgCenter(long j4, String str);

    private native int nativeRelease(long j4);

    private native boolean nativeSetCenterParam(long j4, String str);
}
