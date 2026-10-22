package com.baidu.platform.comapi.bmsdk.style;

/* loaded from: classes.dex */
public class BmGifResource extends BmDrawableResource {
    private BmGifResource() {
        super(58, nativeCreate());
    }

    private static native long nativeCreate();

    private static native boolean nativeSetData(long j4, byte[] bArr, int i4, int i5, int i6);
}
