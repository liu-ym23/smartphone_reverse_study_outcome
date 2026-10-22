package com.baidu.platform.comjni.map.searchengine;

import com.baidu.platform.comjni.NativeComponent;

/* JADX INFO: loaded from: classes39.dex */
public class NASearchEngine extends NativeComponent {
    private static native boolean nativeCancelRequest(long r100, int r101);

    private static native long nativeCreate();

    private static native String nativeGetJsonResult(long r100, int r101);

    private static native String nativeGetLogId(long r100, int r101);

    private static native byte[] nativeGetProtobufResult(long r100, int r101);

    private static native boolean nativeInit(long r100, int r101);

    private static native boolean nativeInitWithBundle(long r100, String r101);

    private static native int nativeRelease(long r100);

    private static native int nativeRequest(long r100, String r101);

    private static native boolean nativeRequestData(long r100, byte[] r101);

    private static native void nativeUpdateOfflineSearchPath(long r100, String r101);

    @Override // com.baidu.platform.comjni.NativeComponent
    public int dispose() {
        if (this.mNativePointer != 0) goto L5;
        return 0;
    L5:
        return nativeRelease(this.mNativePointer);
    }

    public NASearchEngine() {
        create();
    }

    @Override // com.baidu.platform.comjni.NativeComponent
    public long create() {
        this.mNativePointer = nativeCreate();
        return this.mNativePointer;
    }
}
