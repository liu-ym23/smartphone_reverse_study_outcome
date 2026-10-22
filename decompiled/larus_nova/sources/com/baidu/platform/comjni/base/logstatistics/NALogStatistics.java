package com.baidu.platform.comjni.base.logstatistics;

import com.baidu.platform.comjni.NativeComponent;

/* JADX INFO: loaded from: classes39.dex */
public class NALogStatistics extends NativeComponent {
    public static native boolean nativeAddLog(long r100, int r101, int r102, String r103, String r104, String r105);

    public static native long nativeCreate();

    public static native boolean nativeRegisterCallback(long r100);

    public static native int nativeRelease(long r100);

    public static native boolean nativeSave(long r100);

    @Override // com.baidu.platform.comjni.NativeComponent
    public int dispose() {
        if (this.mNativePointer == 0) goto L5;
        int r100 = nativeRelease(this.mNativePointer);
        this.mNativePointer = 0;
        return r100;
    L5:
        return 0;
    }

    public NALogStatistics() {
        create();
    }

    @Override // com.baidu.platform.comjni.NativeComponent
    public long create() {
        this.mNativePointer = nativeCreate();
        return this.mNativePointer;
    }

    public boolean a(int r100, int r101, String r110, String r111, String r112) {
        return nativeAddLog(this.mNativePointer, r100, r101, r110, r111, r112);
    }
}
