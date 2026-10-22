package androidx.camera.core.processing;

import androidx.camera.core.CameraEffect;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProcessor;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class InternalImageProcessor {
    private final Consumer<Throwable> mErrorListener;
    private final Executor mExecutor;
    private final ImageProcessor mImageProcessor;

    public static /* synthetic */ void a(InternalImageProcessor r100, ImageProcessor.Request r101, CallbackToFutureAdapter.Completer r102) {
        r100.lambda$safeProcess$0(r101, r102);
    }

    public static /* synthetic */ Object b(InternalImageProcessor r100, ImageProcessor.Request r101, CallbackToFutureAdapter.Completer r102) {
        return r100.lambda$safeProcess$1(r101, r102);
    }

    public InternalImageProcessor(CameraEffect r100) {
        if (r100.getTargets() != 4) goto L5;
        boolean r101 = true;
    L6:
        Preconditions.checkArgument(r101);
        this.mExecutor = r100.getExecutor();
        ImageProcessor r102 = r100.getImageProcessor();
        Objects.requireNonNull(r102);
        this.mImageProcessor = r102;
        this.mErrorListener = r100.getErrorListener();
        return;
    L5:
        r101 = false;
        goto L6
    }

    public ImageProcessor.Response safeProcess(final ImageProcessor.Request r100) throws ImageCaptureException {
        return (ImageProcessor.Response) CallbackToFutureAdapter.getFuture(new r(this, r100)).get();
    L4:
        e = move-exception;
        Throwable r101 = e.getCause();
        Exception r102 = e;
        if (r101 == null) goto L9;
        r102 = e.getCause();
    L9:
        throw new ImageCaptureException(0, "Failed to invoke ImageProcessor.", r102);
    }

    private /* synthetic */ void lambda$safeProcess$0(ImageProcessor.Request r100, CallbackToFutureAdapter.Completer r101) {
        r101.set(this.mImageProcessor.process(r100));
        return;
    L5:
        e = move-exception;
        this.mErrorListener.accept(e);
        r101.setException(e);
    }

    private /* synthetic */ Object lambda$safeProcess$1(final ImageProcessor.Request r100, final CallbackToFutureAdapter.Completer r101) throws Exception {
        this.mExecutor.execute(new q(this, r100, r101));
        return "InternalImageProcessor#process " + r100.hashCode();
    }
}
