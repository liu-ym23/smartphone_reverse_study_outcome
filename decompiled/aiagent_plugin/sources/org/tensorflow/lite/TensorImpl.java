package org.tensorflow.lite;

import java.nio.Buffer;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
final class TensorImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f40578a;

    private static native ByteBuffer buffer(long r0);

    private static native long create(long r0, int r2, int r3);

    private static native long createSignatureInputTensor(long r0, String r2);

    private static native long createSignatureOutputTensor(long r0, String r2);

    private static native void delete(long r0);

    private static native int dtype(long r0);

    private static native boolean hasDelegateBufferHandle(long r0);

    private static native int index(long r0);

    private static native String name(long r0);

    private static native int numBytes(long r0);

    private static native float quantizationScale(long r0);

    private static native int quantizationZeroPoint(long r0);

    private static native void readMultiDimensionalArray(long r0, Object r2);

    private static native int[] shape(long r0);

    private static native int[] shapeSignature(long r0);

    private static native void writeDirectBuffer(long r0, Buffer r2);

    private static native void writeMultiDimensionalArray(long r0, Object r2);

    private static native void writeScalar(long r0, Object r2);

    void a() {
        delete(this.f40578a);
        this.f40578a = 0;
    }
}
