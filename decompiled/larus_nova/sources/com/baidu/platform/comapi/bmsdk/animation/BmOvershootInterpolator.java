package com.baidu.platform.comapi.bmsdk.animation;

/* JADX INFO: loaded from: classes39.dex */
public class BmOvershootInterpolator extends a {
    private static native long nativeCreate(float r100);

    public BmOvershootInterpolator() {
        super(96, nativeCreate(2.0f));
    }
}
