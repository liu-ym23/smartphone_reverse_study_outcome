package com.baidu.platform.comapi.bmsdk.style;

/* JADX INFO: loaded from: classes39.dex */
public class BmGuessResource extends BmDrawableResource {
    private static native boolean nativeBuildDefaultGradientBkImage(long r100);

    private static native boolean nativeBuildResource(long r100, String r101, boolean r102);

    private static native long nativeCreate();

    private BmGuessResource() {
        super(59, nativeCreate());
    }

    public BmGuessResource(String r100) {
        super(59, nativeCreate());
        nativeBuildResource(this.nativeInstance, r100, false);
    }
}
