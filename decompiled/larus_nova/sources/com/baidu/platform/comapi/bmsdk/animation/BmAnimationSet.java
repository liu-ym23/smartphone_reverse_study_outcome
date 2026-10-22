package com.baidu.platform.comapi.bmsdk.animation;

/* JADX INFO: loaded from: classes39.dex */
public class BmAnimationSet extends BmAnimation {
    private static native boolean nativeAddAnimation(long r100, long r101, int r102);

    private static native long nativeCreate();

    public BmAnimationSet() {
        super(86, nativeCreate());
    }

    public boolean a(BmAnimation r100, int r101) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return nativeAddAnimation(this.nativeInstance, r100.getNativeInstance(), r101);
    }
}
