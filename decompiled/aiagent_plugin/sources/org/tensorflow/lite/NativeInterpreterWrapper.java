package org.tensorflow.lite;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
class NativeInterpreterWrapper implements AutoCloseable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final d f40568c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    long f40569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    long f40570b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f40571d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f40572e;
    private ByteBuffer f;
    private Map<String, Integer> g;
    private Map<String, Integer> h;
    private TensorImpl[] i;
    private long inferenceDurationNanoseconds;
    private TensorImpl[] j;
    private boolean k;
    private final List<b> l;
    private final List<b> m;

    private static native long allocateTensors(long r0, long r2);

    private static native void allowBufferHandleOutput(long r0, boolean r2);

    private static native void allowFp16PrecisionForFp32(long r0, boolean r2);

    private static native long createCancellationFlag(long r0);

    private static native long createErrorReporter(int r0);

    private static native long createInterpreter(long r0, long r2, int r4, boolean r5, List<Long> r6);

    private static native long createModel(String r0, long r1);

    private static native long createModelWithBuffer(ByteBuffer r0, long r1);

    private static native void delete(long r0, long r2, long r4);

    private static native long deleteCancellationFlag(long r0);

    private static native int getExecutionPlanLength(long r0);

    private static native int getInputCount(long r0);

    private static native String[] getInputNames(long r0);

    private static native int getInputTensorIndex(long r0, int r2);

    private static native int getOutputCount(long r0);

    private static native String[] getOutputNames(long r0);

    private static native int getOutputTensorIndex(long r0, int r2);

    private static native String[] getSignatureKeys(long r0);

    private static native boolean hasUnresolvedFlexOp(long r0);

    private static native boolean resizeInput(long r0, long r2, int r4, int[] r5, boolean r6);

    private static native void run(long r0, long r2);

    private static native void setCancelled(long r0, long r2, boolean r4);

    static {
        f40568c = d.f40589a;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        int r1 = 0;
    L3:
        TensorImpl[] r2 = this.i;
        if (r1 >= r2.length) goto L9;
        if (r2[r1] == null) goto L8;
        r2[r1].a();
        this.i[r1] = null;
    L8:
        r1 = r1 + 1;
        goto L3
    L9:
        int r3 = 0;
    L10:
        TensorImpl[] r4 = this.j;
        if (r3 >= r4.length) goto L16;
        if (r4[r3] == null) goto L15;
        r4[r3].a();
        this.j[r3] = null;
    L15:
        r3 = r3 + 1;
        goto L10
    L16:
        delete(this.f40569a, this.f40571d, this.f40570b);
        deleteCancellationFlag(this.f40572e);
        this.f40569a = 0;
        this.f40571d = 0;
        this.f40570b = 0;
        this.f40572e = 0;
        this.f = null;
        this.g = null;
        this.h = null;
        this.k = false;
        this.l.clear();
        Iterator<b> r0 = this.m.iterator();
    L18:
        if (r0.hasNext() == false) goto L20;
        ((b) ZeusTransformUtils.preCheckCast(r0.next(), b.class, "com.obric.aiagent.plugin")).close();
        goto L18
    L20:
        this.m.clear();
    }
}
