package com.baidu.platform.comjni.base.sdkauth;

import com.baidu.platform.comjni.NativeComponent;

/* JADX INFO: loaded from: classes39.dex */
public class NASDKAuth extends NativeComponent {
    private static native long nativeCreate();

    private static native int nativeRelease(long r100);

    public static native boolean nativeSetAuth(long r100, String r101, int r102);

    @Override // com.baidu.platform.comjni.NativeComponent
    public int dispose() {
        if (this.mNativePointer == 0) goto L7;
        this.mNativePointer = 0;
        return 0;
    L7:
        return 0;
    }

    public NASDKAuth() {
        create();
    }

    @Override // com.baidu.platform.comjni.NativeComponent
    public long create() {
        this.mNativePointer = nativeCreate();
        return this.mNativePointer;
    }

    public boolean a(String r100, int r101) {
        return nativeSetAuth(this.mNativePointer, r100, r101);
    }
}
