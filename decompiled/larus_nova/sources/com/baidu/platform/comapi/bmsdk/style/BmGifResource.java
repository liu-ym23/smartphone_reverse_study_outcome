package com.baidu.platform.comapi.bmsdk.style;

/* JADX INFO: loaded from: classes39.dex */
public class BmGifResource extends BmDrawableResource {
    private static native long nativeCreate();

    private static native boolean nativeSetData(long r100, byte[] r101, int r102, int r103, int r104);

    private BmGifResource() {
        super(58, nativeCreate());
    }
}
