package com.baidu.platform.comjni.map.commonmemcache;

import com.baidu.platform.comjni.NativeComponent;

/* JADX INFO: loaded from: classes39.dex */
public class NACommonMemCache extends NativeComponent {
    private static native long nativeCreate();

    private static native String nativeDecodeUsync(long r100, String r101);

    private static native String nativeEnCrypt(long r100, String r101);

    private static native String nativeEnCryptWithType(long r100, String r101, String r102);

    private static native String nativeEnCryptWithUsync(long r100, String r101);

    private static native String nativeGetKeyBundleString(long r100, String r101);

    private static native String nativeGetKeyString(long r100, String r101);

    private static native String nativeGetPhoneInfoBundle(long r100, boolean r101);

    private static native String nativeGetPhoneInfoUrl(long r100);

    private static native String nativeGetSataInfo(long r100, boolean r101, int r102, int r103);

    private static native void nativeIncCountOfPolicyCodes(long r100, int[] r101, int r102);

    private static native void nativeInit(long r100, String r101);

    private static native int nativeRelease(long r100);

    private static native void nativeSetAuthBlkBid(long r100, boolean r101, String[] r102);

    private static native void nativeSetKeyBundle(long r100, String r101, String r102);

    private static native void nativeSetKeyDouble(long r100, String r101, double r102);

    private static native void nativeSetKeyFloat(long r100, String r101, float r102);

    private static native void nativeSetKeyInt(long r100, String r101, int r102);

    private static native void nativeSetKeyString(long r100, String r101, String r102);

    @Override // com.baidu.platform.comjni.NativeComponent
    public int dispose() {
        if (this.mNativePointer == 0) goto L5;
        int r100 = nativeRelease(this.mNativePointer);
        this.mNativePointer = 0;
        return r100;
    L5:
        return 0;
    }

    public NACommonMemCache() {
        create();
    }

    @Override // com.baidu.platform.comjni.NativeComponent
    public long create() {
        this.mNativePointer = nativeCreate();
        return this.mNativePointer;
    }

    public String a(String r100) {
        return nativeGetKeyBundleString(this.mNativePointer, r100);
    }

    public void b(String r100) {
        nativeInit(this.mNativePointer, r100);
    }

    public void a(String r100, String r101) {
        nativeSetKeyString(this.mNativePointer, r100, r101);
    }

    public void b(String r100, String r101) {
        nativeSetKeyBundle(this.mNativePointer, r100, r101);
    }
}
