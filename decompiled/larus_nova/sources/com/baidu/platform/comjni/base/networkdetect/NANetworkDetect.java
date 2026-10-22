package com.baidu.platform.comjni.base.networkdetect;

import com.baidu.platform.comjni.NativeComponent;

/* JADX INFO: loaded from: classes39.dex */
public class NANetworkDetect extends NativeComponent {
    private native long nativeCreate();

    private native int nativeGetNetworkIP();

    private native boolean nativeIsNetWeak(long r100);

    private native boolean nativeNetworkDetect(long r100, String r101);

    private native int nativeRelease(long r100);

    private native boolean nativeSetNetStateDetectParams(long r100, String r101);

    @Override // com.baidu.platform.comjni.NativeComponent
    public int dispose() {
        return nativeRelease(this.mNativePointer);
    }

    public NANetworkDetect() {
        create();
    }

    @Override // com.baidu.platform.comjni.NativeComponent
    public long create() {
        this.mNativePointer = nativeCreate();
        return this.mNativePointer;
    }

    public boolean a(String r100) {
        return nativeNetworkDetect(this.mNativePointer, r100);
    }
}
