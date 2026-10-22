package com.baidu.platform.comjni.map.commonmemcache;

import com.baidu.platform.comjni.NativeComponent;

/* loaded from: classes.dex */
public class NACommonMemCache extends NativeComponent {
    public NACommonMemCache() {
        create();
    }

    private static native long nativeCreate();

    private static native String nativeDecodeUsync(long j4, String str);

    private static native String nativeEnCrypt(long j4, String str);

    private static native String nativeEnCryptWithType(long j4, String str, String str2);

    private static native String nativeEnCryptWithUsync(long j4, String str);

    private static native String nativeGetKeyBundleString(long j4, String str);

    private static native String nativeGetKeyString(long j4, String str);

    private static native String nativeGetPhoneInfoBundle(long j4, boolean z4);

    private static native String nativeGetPhoneInfoUrl(long j4);

    private static native String nativeGetSataInfo(long j4, boolean z4, int i4, int i5);

    private static native void nativeIncCountOfPolicyCodes(long j4, int[] iArr, int i4);

    private static native void nativeInit(long j4, String str);

    private static native int nativeRelease(long j4);

    private static native void nativeSetAuthBlkBid(long j4, boolean z4, String[] strArr);

    private static native void nativeSetKeyBundle(long j4, String str, String str2);

    private static native void nativeSetKeyDouble(long j4, String str, double d4);

    private static native void nativeSetKeyFloat(long j4, String str, float f4);

    private static native void nativeSetKeyInt(long j4, String str, int i4);

    private static native void nativeSetKeyString(long j4, String str, String str2);

    public void a(String str, String str2) {
        nativeSetKeyString(this.mNativePointer, str, str2);
    }

    public void b(String str) {
        nativeInit(this.mNativePointer, str);
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

    public String a(String str) {
        return nativeGetKeyBundleString(this.mNativePointer, str);
    }

    public void b(String str, String str2) {
        nativeSetKeyBundle(this.mNativePointer, str, str2);
    }
}
