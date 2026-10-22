package com.baidu.platform.comjni.base.sdkauth;

import com.baidu.platform.comjni.NativeComponent;

/* loaded from: classes.dex */
public class NASDKAuth extends NativeComponent {
    public NASDKAuth() {
        create();
    }

    private static native long nativeCreate();

    private static native int nativeRelease(long j4);

    public static native boolean nativeSetAuth(long j4, String str, int i4);

    public boolean a(String str, int i4) {
        return nativeSetAuth(this.mNativePointer, str, i4);
    }

    @Override // com.baidu.platform.comjni.NativeComponent
    public long create() {
        this.mNativePointer = nativeCreate();
        return this.mNativePointer;
    }

    @Override // com.baidu.platform.comjni.NativeComponent
    public int dispose() {
        if (this.mNativePointer == 0) {
            return 0;
        }
        int iNativeRelease = nativeRelease(this.mNativePointer);
        this.mNativePointer = 0L;
        return iNativeRelease;
    }
}
