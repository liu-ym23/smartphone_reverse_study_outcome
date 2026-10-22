package androidx.camera.view;

import android.content.Context;
import androidx.camera.core.Camera;
import androidx.camera.core.UseCaseGroup;
import androidx.camera.core.impl.utils.Threads;
import androidx.lifecycle.LifecycleOwner;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes2.dex */
public final class LifecycleCameraController extends CameraController {
    private static final String TAG = "CamLifecycleController";
    private LifecycleOwner mLifecycleOwner;

    public void shutDownForTests() {
        ProcessCameraProviderWrapper r100 = this.mCameraProvider;
        if (r100 == null) goto L6;
        r100.shutdownAsync();
        return;
    }

    @Override // androidx.camera.view.CameraController
    public Camera startCamera() {
        if (this.mLifecycleOwner != null) goto L6;
        return null;
    L6:
        if (this.mCameraProvider != null) goto L8;
        return null;
    L8:
        UseCaseGroup r100 = createUseCaseGroup();
        if (r100 != null) goto L16;
        return null;
    L16:
        return this.mCameraProvider.bindToLifecycle(this.mLifecycleOwner, this.mCameraSelector, r100);
    L13:
        e = move-exception;
        throw new IllegalStateException("The selected camera does not support the enabled use cases. Please disable use case and/or select a different camera. e.g. #setVideoCaptureEnabled(false)", e);
    }

    public void unbind() {
        Threads.checkMainThread();
        this.mLifecycleOwner = null;
        this.mCamera = null;
        ProcessCameraProviderWrapper r100 = this.mCameraProvider;
        if (r100 == null) goto L6;
        r100.unbindAll();
        return;
    }

    public LifecycleCameraController(Context r100) {
        super(r100);
    }

    public void bindToLifecycle(LifecycleOwner r100) {
        Threads.checkMainThread();
        this.mLifecycleOwner = r100;
        startCameraAndTrackStates();
    }

    public LifecycleCameraController(Context r100, ListenableFuture<ProcessCameraProviderWrapper> r101) {
        super(r100, r101);
    }
}
