package ai.onnxruntime;

import java.io.IOException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class OnnxTensorLike implements OnnxValue {
    protected final long allocatorHandle;
    protected boolean closed = false;
    protected final TensorInfo info;
    protected final long nativeHandle;

    static {
        try {
            OnnxRuntime.init();
        } catch (IOException e10) {
            throw new RuntimeException("Failed to load onnx-runtime library", e10);
        }
    }

    public OnnxTensorLike(long j10, long j11, TensorInfo tensorInfo) {
        this.nativeHandle = j10;
        this.allocatorHandle = j11;
        this.info = tensorInfo;
    }

    public void checkClosed() {
        if (this.closed) {
            throw new IllegalStateException("Trying to use a closed OnnxValue");
        }
    }

    public long getNativeHandle() {
        return this.nativeHandle;
    }

    @Override // ai.onnxruntime.OnnxValue
    public synchronized boolean isClosed() {
        return this.closed;
    }

    @Override // ai.onnxruntime.OnnxValue
    public TensorInfo getInfo() {
        return this.info;
    }
}
