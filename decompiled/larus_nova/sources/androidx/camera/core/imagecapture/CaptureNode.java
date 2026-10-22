package androidx.camera.core.imagecapture;

import android.util.Size;
import android.view.Surface;
import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.ImageReaderProxyProvider;
import androidx.camera.core.ImageReaderProxys;
import androidx.camera.core.Logger;
import androidx.camera.core.MetadataImageReader;
import androidx.camera.core.SafeCloseImageReaderProxy;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureCallbacks;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.ImmediateSurface;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.processing.Edge;
import androidx.camera.core.processing.Node;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
class CaptureNode implements Node<In, ProcessingNode.In> {
    static final int MAX_IMAGES = 4;
    private static final String TAG = "CaptureNode";
    ProcessingRequest mCurrentRequest;
    private In mInputEdge;
    private NoMetadataImageReader mNoMetadataImageReader;
    private ProcessingNode.In mOutputEdge;
    SafeCloseImageReaderProxy mSafeCloseImageReaderForPostview;
    SafeCloseImageReaderProxy mSafeCloseImageReaderProxy;

    /* JADX INFO: renamed from: androidx.camera.core.imagecapture.CaptureNode$1, reason: invalid class name */
    public class AnonymousClass1 extends CameraCaptureCallback {
        final /* synthetic */ CaptureNode this$0;

        public static /* synthetic */ void a(AnonymousClass1 r100) {
            r100.lambda$onCaptureStarted$0();
        }

        public static /* synthetic */ void b(AnonymousClass1 r100, int r101) {
            r100.lambda$onCaptureProcessProgressed$1(r101);
        }

        private /* synthetic */ void lambda$onCaptureStarted$0() {
            ProcessingRequest r100 = this.this$0.mCurrentRequest;
            if (r100 == null) goto L6;
            r100.onCaptureStarted();
            return;
        }

        public AnonymousClass1(CaptureNode r100) {
            this.this$0 = r100;
        }

        private /* synthetic */ void lambda$onCaptureProcessProgressed$1(int r100) {
            ProcessingRequest r101 = this.this$0.mCurrentRequest;
            if (r101 == null) goto L6;
            r101.onCaptureProcessProgressed(r100);
            return;
        }

        @Override // androidx.camera.core.impl.CameraCaptureCallback
        public void onCaptureStarted(int r100) {
            CameraXExecutors.mainThreadExecutor().execute(new h(this));
        }

        @Override // androidx.camera.core.impl.CameraCaptureCallback
        public void onCaptureProcessProgressed(int r100, final int r101) {
            CameraXExecutors.mainThreadExecutor().execute(new i(this, r101));
        }
    }

    public static abstract class In {
        private CameraCaptureCallback mCameraCaptureCallback;
        private DeferrableSurface mPostviewSurface;
        private DeferrableSurface mSurface;

        public abstract Edge<TakePictureManager.CaptureError> getErrorEdge();

        public abstract ImageReaderProxyProvider getImageReaderProxyProvider();

        public abstract int getInputFormat();

        public abstract int getOutputFormat();

        public abstract int getPostviewImageFormat();

        public abstract Size getPostviewSize();

        public abstract Edge<ProcessingRequest> getRequestEdge();

        public abstract Size getSize();

        public abstract boolean isVirtualCamera();

        public DeferrableSurface getSurface() {
            DeferrableSurface r100 = this.mSurface;
            Objects.requireNonNull(r100);
            return r100;
        }

        public In() {
            this.mCameraCaptureCallback = new AnonymousClass1(this);
            this.mPostviewSurface = null;
        }

        public CameraCaptureCallback getCameraCaptureCallback() {
            return this.mCameraCaptureCallback;
        }

        public DeferrableSurface getPostviewSurface() {
            return this.mPostviewSurface;
        }

        public void setCameraCaptureCallback(CameraCaptureCallback r100) {
            this.mCameraCaptureCallback = r100;
        }

        public void setSurface(Surface r100) {
            if (this.mSurface != null) goto L5;
            boolean r101 = true;
        L6:
            Preconditions.checkState(r101, "The surface is already set.");
            this.mSurface = new ImmediateSurface(r100, getSize(), getInputFormat());
            return;
        L5:
            r101 = false;
            goto L6
        }

        public void setPostviewSurface(Surface r100, Size r101, int r102) {
            this.mPostviewSurface = new ImmediateSurface(r100, r101, r102);
        }

        public static In of(Size r110, int r111, int r112, boolean r113, ImageReaderProxyProvider r114) {
            return new AutoValue_CaptureNode_In(r110, r111, r112, r113, r114, null, 35, new Edge(), new Edge());
        }

        public static In of(Size r110, int r111, int r112, boolean r113, ImageReaderProxyProvider r114, Size r115, int r116) {
            return new AutoValue_CaptureNode_In(r110, r111, r112, r113, r114, r115, r116, new Edge(), new Edge());
        }
    }

    public static /* synthetic */ void a(CaptureNode r100, ImageReaderProxy r101) {
        r100.lambda$transform$1(r101);
    }

    public static /* synthetic */ void b(CaptureNode r100, ProcessingRequest r101) {
        r100.lambda$transform$0(r101);
    }

    public static /* synthetic */ void c(SafeCloseImageReaderProxy r100) {
        lambda$releaseInputResources$3(r100);
    }

    public static /* synthetic */ void d(SafeCloseImageReaderProxy r100) {
        lambda$releaseInputResources$4(r100);
    }

    public static /* synthetic */ void e(CaptureNode r100, ImageReaderProxy r101) {
        r100.lambda$transform$2(r101);
    }

    public In getInputEdge() {
        In r100 = this.mInputEdge;
        Objects.requireNonNull(r100);
        return r100;
    }

    public SafeCloseImageReaderProxy getSafeCloseImageReaderProxy() {
        SafeCloseImageReaderProxy r100 = this.mSafeCloseImageReaderProxy;
        Objects.requireNonNull(r100);
        return r100;
    }

    public CaptureNode() {
        this.mCurrentRequest = null;
        this.mNoMetadataImageReader = null;
    }

    public int getCapacity() {
        Threads.checkMainThread();
        if (this.mSafeCloseImageReaderProxy == null) goto L5;
        boolean r100 = true;
    L6:
        Preconditions.checkState(r100, "The ImageReader is not initialized.");
        return this.mSafeCloseImageReaderProxy.getCapacity();
    L5:
        r100 = false;
        goto L6
    }

    @Override // androidx.camera.core.processing.Node
    public void release() {
        Threads.checkMainThread();
        In r100 = this.mInputEdge;
        Objects.requireNonNull(r100);
        SafeCloseImageReaderProxy r101 = this.mSafeCloseImageReaderProxy;
        Objects.requireNonNull(r101);
        releaseInputResources(r100, r101, this.mSafeCloseImageReaderForPostview);
    }

    public static /* synthetic */ NoMetadataImageReader access$000(CaptureNode r100) {
        return r100.mNoMetadataImageReader;
    }

    private static /* synthetic */ void lambda$releaseInputResources$3(SafeCloseImageReaderProxy r100) {
        r100.safeClose();
    }

    private static /* synthetic */ void lambda$releaseInputResources$4(SafeCloseImageReaderProxy r100) {
        if (r100 == null) goto L5;
        r100.safeClose();
        return;
    }

    private /* synthetic */ void lambda$transform$0(ProcessingRequest r100) {
        onRequestAvailable(r100);
        this.mNoMetadataImageReader.acceptProcessingRequest(r100);
    }

    private /* synthetic */ void lambda$transform$1(ImageReaderProxy r100) {
        ImageProxy r101 = r100.acquireLatestImage();     // Catch: IllegalStateException -> L10
        if (r101 == null) goto L6;
        onImageProxyAvailable(r101);     // Catch: IllegalStateException -> L10
    L15:
        return;
    L6:
        ProcessingRequest r102 = this.mCurrentRequest;     // Catch: IllegalStateException -> L10
        if (r102 == null) goto L15;
        sendCaptureError(TakePictureManager.CaptureError.of(r102.getRequestId(), new ImageCaptureException(2, "Failed to acquire latest image", null)));     // Catch: IllegalStateException -> L10
    L10:
        e = move-exception;
        ProcessingRequest r103 = this.mCurrentRequest;
        if (r103 == null) goto L19;
        sendCaptureError(TakePictureManager.CaptureError.of(r103.getRequestId(), new ImageCaptureException(2, "Failed to acquire latest image", e)));
        return;
    }

    private /* synthetic */ void lambda$transform$2(ImageReaderProxy r100) {
        ImageProxy r101 = r100.acquireLatestImage();     // Catch: IllegalStateException -> L6
        if (r101 == null) goto L11;
        propagatePostviewImage(r101);     // Catch: IllegalStateException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        Logger.e(TAG, "Failed to acquire latest image of postview", e);
    }

    private void matchAndPropagateImage(ImageProxy r100) {
        Threads.checkMainThread();
        ProcessingNode.In r101 = this.mOutputEdge;
        Objects.requireNonNull(r101);
        r101.getEdge().accept(ProcessingNode.InputPacket.of(this.mCurrentRequest, r100));
        ProcessingRequest r102 = this.mCurrentRequest;
        this.mCurrentRequest = null;
        r102.onImageCaptured();
    }

    private void propagatePostviewImage(ImageProxy r100) {
        if (this.mCurrentRequest != null) goto L6;
        Logger.w(TAG, "Postview image is closed due to request completed or aborted");
        r100.close();
        return;
    L6:
        ProcessingNode.In r101 = this.mOutputEdge;
        Objects.requireNonNull(r101);
        r101.getPostviewEdge().accept(ProcessingNode.InputPacket.of(this.mCurrentRequest, r100));
    }

    public void onImageProxyAvailable(ImageProxy r100) {
        Threads.checkMainThread();
        if (this.mCurrentRequest != null) goto L6;
        Logger.w(TAG, "Discarding ImageProxy which was inadvertently acquired: " + r100);
        r100.close();
        return;
    L6:
        if (((Integer) r100.getImageInfo().getTagBundle().getTag(this.mCurrentRequest.getTagBundleKey())) != null) goto L9;
        Logger.w(TAG, "Discarding ImageProxy which was acquired for aborted request");
        r100.close();
        return;
    L9:
        matchAndPropagateImage(r100);
    }

    public void onRequestAvailable(final ProcessingRequest r100) {
        Threads.checkMainThread();
        boolean r101 = false;
        if (r100.getStageIds().size() != 1) goto L5;
        boolean r102 = true;
    L6:
        Preconditions.checkState(r102, "only one capture stage is supported.");
        if (getCapacity() <= 0) goto L9;
        r101 = true;
    L9:
        Preconditions.checkState(r101, "Too many acquire images. Close image to be able to process next.");
        this.mCurrentRequest = r100;
        Futures.addCallback(r100.getCaptureFuture(), new AnonymousClass2(this, r100), CameraXExecutors.directExecutor());
        return;
    L5:
        r102 = false;
        goto L6
    }

    public void sendCaptureError(TakePictureManager.CaptureError r100) {
        Threads.checkMainThread();
        ProcessingRequest r101 = this.mCurrentRequest;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.getRequestId() != r100.getRequestId()) goto L9;
        this.mCurrentRequest.onCaptureFailure(r100.getImageCaptureException());
        return;
    }

    public void setOnImageCloseListener(ForwardingImageProxy.OnImageCloseListener r100) {
        Threads.checkMainThread();
        if (this.mSafeCloseImageReaderProxy == null) goto L5;
        boolean r101 = true;
    L6:
        Preconditions.checkState(r101, "The ImageReader is not initialized.");
        this.mSafeCloseImageReaderProxy.setOnImageCloseListener(r100);
        return;
    L5:
        r101 = false;
        goto L6
    }

    /* JADX INFO: renamed from: transform, reason: avoid collision after fix types in other method */
    public ProcessingNode.In transform2(In r100) {
        if (this.mInputEdge == null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        Preconditions.checkState(r101, "CaptureNode does not support recreation yet.");
        this.mInputEdge = r100;
        Size r102 = r100.getSize();
        int r103 = r100.getInputFormat();
        boolean r104 = !r100.isVirtualCamera();
        CameraCaptureCallback r105 = new AnonymousClass1(this);
        if (r104 == true) goto L11;
    L13:
        NoMetadataImageReader r106 = new NoMetadataImageReader(createImageReaderProxy(r100.getImageReaderProxyProvider(), r102.getWidth(), r102.getHeight(), r103));
        this.mNoMetadataImageReader = r106;
        Consumer<ProcessingRequest> r107 = new b(this);
        ImageReaderProxy r108 = r106;
    L14:
        r100.setCameraCaptureCallback(r105);
        Surface r109 = r108.getSurface();
        Objects.requireNonNull(r109);
        r100.setSurface(r109);
        this.mSafeCloseImageReaderProxy = new SafeCloseImageReaderProxy(r108);
        r108.setOnImageAvailableListener(new c(this), CameraXExecutors.mainThreadExecutor());
        if (r100.getPostviewSize() == null) goto L17;
        ImageReaderProxy r110 = createImageReaderProxy(r100.getImageReaderProxyProvider(), r100.getPostviewSize().getWidth(), r100.getPostviewSize().getHeight(), r100.getPostviewImageFormat());
        r110.setOnImageAvailableListener(new d(this), CameraXExecutors.mainThreadExecutor());
        this.mSafeCloseImageReaderForPostview = new SafeCloseImageReaderProxy(r110);
        r100.setPostviewSurface(r110.getSurface(), r100.getPostviewSize(), r100.getPostviewImageFormat());
    L17:
        r100.getRequestEdge().setListener(r107);
        r100.getErrorEdge().setListener(new e(this));
        ProcessingNode.In r111 = ProcessingNode.In.of(r100.getInputFormat(), r100.getOutputFormat());
        this.mOutputEdge = r111;
        return r111;
    L11:
        if (r100.getImageReaderProxyProvider() != null) goto L13;
        MetadataImageReader r112 = new MetadataImageReader(r102.getWidth(), r102.getHeight(), r103, 4);
        r105 = CameraCaptureCallbacks.createComboCallback(new CameraCaptureCallback[]{r105, r112.getCameraCaptureCallback()});
        r107 = new a(this);
        r108 = r112;
        goto L14
    L5:
        if (this.mSafeCloseImageReaderProxy != null) goto L7;
        r101 = true;
        goto L8
    }

    @Override // androidx.camera.core.processing.Node
    public /* bridge */ /* synthetic */ ProcessingNode.In transform(In r100) {
        return transform2(r100);
    }

    private void releaseInputResources(In r100, final SafeCloseImageReaderProxy r101, final SafeCloseImageReaderProxy r102) {
        r100.getSurface().close();
        r100.getSurface().getTerminationFuture().addListener(new f(r101), CameraXExecutors.mainThreadExecutor());
        if (r100.getPostviewSurface() == null) goto L6;
        r100.getPostviewSurface().close();
        r100.getPostviewSurface().getTerminationFuture().addListener(new g(r102), CameraXExecutors.mainThreadExecutor());
        return;
    }

    private static ImageReaderProxy createImageReaderProxy(ImageReaderProxyProvider r100, int r101, int r102, int r110) {
        if (r100 == null) goto L6;
        return r100.newInstance(r101, r102, r110, 4, 0);
    L6:
        return ImageReaderProxys.createIsolatedReader(r101, r102, r110, 4);
    }
}
