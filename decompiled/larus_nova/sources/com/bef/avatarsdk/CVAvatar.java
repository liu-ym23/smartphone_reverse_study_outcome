package com.bef.avatarsdk;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes39.dex */
public class CVAvatar {
    private native int nativeDestroy(long r100);

    private native int nativeFaceBSInputUpdateOutput(long r100, float[] r101, int r102, double r103);

    private native int nativeFeedBsAamTensor(long r100, long r101, float[] r102, int r103, int r104);

    private native long nativeGetInputSignalHandleOfVideoTalkingAvatar(long r100, int r101);

    private native int nativeSetBsAamIndex(long r100, int r101);

    private native Bitmap nativeSetOutputAlphaFrameBufferAsBitmap(long r100);

    private native Bitmap nativeSetOutputFrameBufferAsBitmap(long r100);

    private native Bitmap nativeSetOutputRGBFrameBufferAsBitmap(long r100);

    private native int nativeSetVideoFrameIndex(long r100, int r101);

    private native int nativeUpdateCVAvatar(long r100);
}
