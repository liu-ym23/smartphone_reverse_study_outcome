package ai.onnxruntime;

import java.io.IOException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
class OrtAllocator implements AutoCloseable {
    private boolean closed = false;
    final long handle;
    private final boolean isDefault;

    static {
        try {
            OnnxRuntime.init();
        } catch (IOException e10) {
            throw new RuntimeException("Failed to load onnx-runtime library", e10);
        }
    }

    public OrtAllocator(long j10, boolean z) {
        this.handle = j10;
        this.isDefault = z;
    }

    private native void closeAllocator(long j10, long j11);

    @Override // java.lang.AutoCloseable
    public void close() {
        if (this.closed) {
            throw new IllegalStateException("Trying to close an already closed OrtAllocator.");
        }
        if (this.isDefault) {
            return;
        }
        closeAllocator(OnnxRuntime.ortApiHandle, this.handle);
        this.closed = true;
    }

    public boolean isClosed() {
        return this.closed;
    }

    public boolean isDefault() {
        return this.isDefault;
    }
}
