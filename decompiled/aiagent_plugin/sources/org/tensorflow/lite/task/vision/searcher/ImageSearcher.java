package org.tensorflow.lite.task.vision.searcher;

import java.nio.ByteBuffer;
import java.util.List;
import org.tensorflow.lite.task.processor.NearestNeighbor;
import org.tensorflow.lite.task.vision.core.BaseVisionTaskApi;

/* JADX INFO: loaded from: classes5.dex */
public final class ImageSearcher extends BaseVisionTaskApi {
    private native void deinitJni(long r1);

    private static native long initJniWithByteBuffer(ByteBuffer r0, long r1, boolean r3, boolean r4, int r5, int r6);

    private static native long initJniWithModelFdAndOptions(int r0, long r1, long r3, long r5, boolean r7, boolean r8, int r9, int r10);

    private static native List<NearestNeighbor> searchNative(long r0, long r2, int[] r4);

    @Override // org.tensorflow.lite.task.core.d
    public void a(long r1) {
        deinitJni(r1);
    }
}
