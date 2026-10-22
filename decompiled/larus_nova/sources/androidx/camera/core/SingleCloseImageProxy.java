package androidx.camera.core;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
final class SingleCloseImageProxy extends ForwardingImageProxy {
    private final AtomicBoolean mClosed;

    @Override // androidx.camera.core.ForwardingImageProxy, androidx.camera.core.ImageProxy, java.lang.AutoCloseable
    public void close() {
        if (this.mClosed.getAndSet(true) == true) goto L6;
        super.close();
        return;
    }

    public SingleCloseImageProxy(ImageProxy r100) {
        super(r100);
        this.mClosed = new AtomicBoolean(false);
    }
}
