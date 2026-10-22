package com.baidu.platform.comjni.map.searchengine;

import com.baidu.platform.comjni.NativeComponent;

/* loaded from: classes.dex */
public class NASearchEngine extends NativeComponent {
    public NASearchEngine() {
        create();
    }

    private static native boolean nativeCancelRequest(long j4, int i4);

    private static native long nativeCreate();

    private static native String nativeGetJsonResult(long j4, int i4);

    private static native String nativeGetLogId(long j4, int i4);

    private static native byte[] nativeGetProtobufResult(long j4, int i4);

    private static native boolean nativeInit(long j4, int i4);

    private static native boolean nativeInitWithBundle(long j4, String str);

    private static native int nativeRelease(long j4);

    private static native int nativeRequest(long j4, String str);

    private static native boolean nativeRequestData(long j4, byte[] bArr);

    private static native void nativeUpdateOfflineSearchPath(long j4, String str);

    @Override // com.baidu.platform.comjni.NativeComponent
    public long create() {
        this.mNativePointer = nativeCreate();
        return this.mNativePointer;
    }

    @Override // com.baidu.platform.comjni.NativeComponent
    public int dispose() {
        if (this.mNativePointer != 0) {
            return nativeRelease(this.mNativePointer);
        }
        return 0;
    }
}
