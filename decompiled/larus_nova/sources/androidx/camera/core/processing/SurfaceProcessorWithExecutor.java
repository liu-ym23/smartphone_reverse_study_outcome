package androidx.camera.core.processing;

import androidx.camera.core.CameraEffect;
import androidx.camera.core.Logger;
import androidx.camera.core.ProcessingException;
import androidx.camera.core.SurfaceOutput;
import androidx.camera.core.SurfaceProcessor;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.core.util.Consumer;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class SurfaceProcessorWithExecutor implements SurfaceProcessorInternal {
    private static final String TAG = "SurfaceProcessor";
    private final Consumer<Throwable> mErrorListener;
    private final Executor mExecutor;
    private final SurfaceProcessor mSurfaceProcessor;

    public static /* synthetic */ void a(SurfaceProcessorWithExecutor r100, SurfaceRequest r101) {
        r100.lambda$onInputSurface$0(r101);
    }

    public static /* synthetic */ void b(SurfaceProcessorWithExecutor r100, SurfaceOutput r101) {
        r100.lambda$onOutputSurface$1(r101);
    }

    @Override // androidx.camera.core.processing.SurfaceProcessorInternal
    public void release() {
    }

    public Executor getExecutor() {
        return this.mExecutor;
    }

    public SurfaceProcessor getProcessor() {
        return this.mSurfaceProcessor;
    }

    public SurfaceProcessorWithExecutor(CameraEffect r100) {
        SurfaceProcessor r101 = r100.getSurfaceProcessor();
        Objects.requireNonNull(r101);
        this.mSurfaceProcessor = r101;
        this.mExecutor = r100.getExecutor();
        this.mErrorListener = r100.getErrorListener();
    }

    private /* synthetic */ void lambda$onInputSurface$0(SurfaceRequest r100) {
        this.mSurfaceProcessor.onInputSurface(r100);     // Catch: ProcessingException -> L4
        return;
    L4:
        e = move-exception;
        Logger.e(TAG, "Failed to setup SurfaceProcessor input.", e);
        this.mErrorListener.accept(e);
    }

    private /* synthetic */ void lambda$onOutputSurface$1(SurfaceOutput r100) {
        this.mSurfaceProcessor.onOutputSurface(r100);     // Catch: ProcessingException -> L4
        return;
    L4:
        e = move-exception;
        Logger.e(TAG, "Failed to setup SurfaceProcessor output.", e);
        this.mErrorListener.accept(e);
    }

    @Override // androidx.camera.core.SurfaceProcessor
    public void onInputSurface(final SurfaceRequest r100) {
        this.mExecutor.execute(new h0(this, r100));
    }

    @Override // androidx.camera.core.SurfaceProcessor
    public void onOutputSurface(final SurfaceOutput r100) {
        this.mExecutor.execute(new i0(this, r100));
    }

    @Override // androidx.camera.core.processing.SurfaceProcessorInternal
    public ListenableFuture<Void> snapshot(int r100, int r101) {
        return Futures.immediateFailedFuture(new Exception("Snapshot not supported by external SurfaceProcessor"));
    }
}
