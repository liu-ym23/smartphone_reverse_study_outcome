package com.baidu.platform.comapi.bmsdk.animation;

/* JADX INFO: loaded from: classes39.dex */
public class BmAccelerateInterpolator extends a {
    private static native long nativeCreate(float r100);

    public BmAccelerateInterpolator() {
        super(93, nativeCreate(1.0f));
    }
}
