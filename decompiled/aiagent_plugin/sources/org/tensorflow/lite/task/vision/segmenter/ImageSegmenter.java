package org.tensorflow.lite.task.vision.segmenter;

import java.nio.ByteBuffer;
import java.util.List;
import org.tensorflow.lite.task.vision.core.BaseVisionTaskApi;

/* JADX INFO: loaded from: classes5.dex */
public final class ImageSegmenter extends BaseVisionTaskApi {
    private native void deinitJni(long r1);

    private static native long initJniWithByteBuffer(ByteBuffer r0, String r1, int r2, long r3);

    private static native long initJniWithModelFdAndOptions(int r0, long r1, long r3, String r5, int r6, long r7);

    private static native void segmentNative(long r0, long r2, List<byte[]> r4, int[] r5, List<ColoredLabel> r6);

    @Override // org.tensorflow.lite.task.core.d
    public void a(long r1) {
        deinitJni(r1);
    }
}
