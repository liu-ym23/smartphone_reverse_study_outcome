package com.baidu.platform.comapi.bmsdk.animation;

/* JADX INFO: loaded from: classes39.dex */
public class BmCycleInterpolator extends a {
    private static native long nativeCreate(float r100);

    public BmCycleInterpolator() {
        super(99, nativeCreate(1.0f));
    }
}
