package com.baidu.platform.comapi.bmsdk.animation;

/* loaded from: classes.dex */
public class BmAnimationSet extends BmAnimation {
    public BmAnimationSet() {
        super(86, nativeCreate());
    }

    private static native boolean nativeAddAnimation(long j4, long j5, int i4);

    private static native long nativeCreate();

    public boolean a(BmAnimation bmAnimation, int i4) {
        if (bmAnimation == null) {
            return false;
        }
        return nativeAddAnimation(this.nativeInstance, bmAnimation.getNativeInstance(), i4);
    }
}
