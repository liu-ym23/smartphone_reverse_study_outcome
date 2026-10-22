package org.tensorflow;

import androidx.room.AbstractC0351g;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Arrays;
import r3.a;

/* loaded from: classes2.dex */
public final class Tensor implements AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public long f13824a;

    /* renamed from: b, reason: collision with root package name */
    public a f13825b;

    /* renamed from: c, reason: collision with root package name */
    public long[] f13826c = null;

    static {
        TensorFlow.a();
    }

    private static native long allocate(int i4, long[] jArr, long j4);

    public static Tensor b(long[] jArr, FloatBuffer floatBuffer) {
        a aVar = a.FLOAT;
        int iRemaining = floatBuffer.remaining();
        int i4 = 1;
        for (long j4 : jArr) {
            i4 *= (int) j4;
        }
        if (iRemaining != i4) {
            throw new IllegalArgumentException(String.format("buffer with %d elements is not compatible with a Tensor with shape %s", Integer.valueOf(iRemaining), Arrays.toString(jArr)));
        }
        Tensor tensor = new Tensor();
        tensor.f13825b = aVar;
        long[] jArrCopyOf = Arrays.copyOf(jArr, jArr.length);
        tensor.f13826c = jArrCopyOf;
        tensor.f13824a = allocate(tensor.f13825b.f14087a, jArrCopyOf, i4 * 4);
        tensor.a().asFloatBuffer().put(floatBuffer);
        return tensor;
    }

    private static native ByteBuffer buffer(long j4);

    public static Tensor d(long j4) {
        Tensor tensor = new Tensor();
        tensor.f13825b = a.a(dtype(j4));
        tensor.f13826c = shape(j4);
        tensor.f13824a = j4;
        return tensor;
    }

    private static native void delete(long j4);

    private static native int dtype(long j4);

    private static native long[] shape(long j4);

    public final ByteBuffer a() {
        return buffer(this.f13824a).order(ByteOrder.nativeOrder());
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        long j4 = this.f13824a;
        if (j4 != 0) {
            delete(j4);
            this.f13824a = 0L;
        }
    }

    public final String toString() {
        return AbstractC0351g.q(this.f13825b.toString(), " tensor with shape ", Arrays.toString(this.f13826c));
    }
}
