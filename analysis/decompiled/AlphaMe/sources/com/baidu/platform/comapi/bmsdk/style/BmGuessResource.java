package com.baidu.platform.comapi.bmsdk.style;

/* loaded from: classes.dex */
public class BmGuessResource extends BmDrawableResource {
    private BmGuessResource() {
        super(59, nativeCreate());
    }

    private static native boolean nativeBuildDefaultGradientBkImage(long j4);

    private static native boolean nativeBuildResource(long j4, String str, boolean z4);

    private static native long nativeCreate();

    public BmGuessResource(String str) {
        super(59, nativeCreate());
        nativeBuildResource(this.nativeInstance, str, false);
    }
}
