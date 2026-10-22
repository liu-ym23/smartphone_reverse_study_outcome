package androidx.camera.core.imagecapture;

import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.core.util.Pair;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class TakePictureManager implements ForwardingImageProxy.OnImageCloseListener, TakePictureRequest.RetryControl {
    private static final String TAG = "TakePictureManager";
    private RequestWithCallback mCapturingRequest;
    final ImageCaptureControl mImageCaptureControl;
    ImagePipeline mImagePipeline;
    private final List<RequestWithCallback> mIncompleteRequests;
    final Deque<TakePictureRequest> mNewRequests;
    boolean mPaused;

    public static abstract class CaptureError {
        public CaptureError() {
        }

        public abstract ImageCaptureException getImageCaptureException();

        public abstract int getRequestId();

        public static CaptureError of(int r100, ImageCaptureException r101) {
            return new AutoValue_TakePictureManager_CaptureError(r100, r101);
        }
    }

    public static /* synthetic */ void a(TakePictureManager r100, RequestWithCallback r101) {
        r100.lambda$trackCurrentRequests$1(r101);
    }

    public static /* synthetic */ void b(TakePictureManager r100) {
        r100.lambda$trackCurrentRequests$0();
    }

    private /* synthetic */ void lambda$trackCurrentRequests$0() {
        this.mCapturingRequest = null;
        issueNextRequest();
    }

    public boolean hasCapturingRequest() {
        if (this.mCapturingRequest == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void abortRequests() {
        Threads.checkMainThread();
        ImageCaptureException r100 = new ImageCaptureException(3, "Camera is closed.", null);
        Iterator<TakePictureRequest> r101 = this.mNewRequests.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onError(r100);
        goto L4
    L6:
        this.mNewRequests.clear();
        Iterator r102 = new ArrayList(this.mIncompleteRequests).iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        ((RequestWithCallback) r102.next()).abortAndSendErrorToApp(r100);
        goto L8
    }

    public void issueNextRequest() {
        Threads.checkMainThread();
        if (hasCapturingRequest() == false) goto L6;
        return;
    L6:
        if (this.mPaused == false) goto L9;
        return;
    L9:
        if (this.mImagePipeline.getCapacity() != 0) goto L11;
        return;
    L11:
        TakePictureRequest r100 = this.mNewRequests.poll();
        if (r100 != null) goto L14;
        return;
    L14:
        RequestWithCallback r101 = new RequestWithCallback(r100, this);
        trackCurrentRequests(r101);
        Pair<CameraRequest, ProcessingRequest> r102 = this.mImagePipeline.createRequests(r100, r101, r101.getCaptureFuture());
        CameraRequest r103 = r102.first;
        Objects.requireNonNull(r103);
        ProcessingRequest r104 = r102.second;
        Objects.requireNonNull(r104);
        this.mImagePipeline.submitProcessingRequest(r104);
        r101.setCaptureRequestFuture(submitCameraRequest(r103));
    }

    public void pause() {
        Threads.checkMainThread();
        this.mPaused = true;
        RequestWithCallback r100 = this.mCapturingRequest;
        if (r100 == null) goto L6;
        r100.abortSilentlyAndRetry();
        return;
    }

    public void resume() {
        Threads.checkMainThread();
        this.mPaused = false;
        issueNextRequest();
    }

    public RequestWithCallback getCapturingRequest() {
        return this.mCapturingRequest;
    }

    public ImagePipeline getImagePipeline() {
        return this.mImagePipeline;
    }

    public List<RequestWithCallback> getIncompleteRequests() {
        return this.mIncompleteRequests;
    }

    public TakePictureManager(ImageCaptureControl r100) {
        this.mNewRequests = new ArrayDeque();
        this.mPaused = false;
        Threads.checkMainThread();
        this.mImageCaptureControl = r100;
        this.mIncompleteRequests = new ArrayList();
    }

    private /* synthetic */ void lambda$trackCurrentRequests$1(RequestWithCallback r100) {
        this.mIncompleteRequests.remove(r100);
    }

    private ListenableFuture<Void> submitCameraRequest(final CameraRequest r100) {
        Threads.checkMainThread();
        this.mImageCaptureControl.lockFlashMode();
        ListenableFuture<Void> r101 = this.mImageCaptureControl.submitStillCaptureRequests(r100.getCaptureConfigs());
        Futures.addCallback(r101, new AnonymousClass1(this, r100), CameraXExecutors.mainThreadExecutor());
        return r101;
    }

    private void trackCurrentRequests(final RequestWithCallback r100) {
        Preconditions.checkState(!hasCapturingRequest());
        this.mCapturingRequest = r100;
        r100.getCaptureFuture().addListener(new u(this), CameraXExecutors.directExecutor());
        this.mIncompleteRequests.add(r100);
        r100.getCompleteFuture().addListener(new v(this, r100), CameraXExecutors.directExecutor());
    }

    public void offerRequest(TakePictureRequest r100) {
        Threads.checkMainThread();
        this.mNewRequests.offer(r100);
        issueNextRequest();
    }

    @Override // androidx.camera.core.ForwardingImageProxy.OnImageCloseListener
    public void onImageClose(ImageProxy r100) {
        CameraXExecutors.mainThreadExecutor().execute(new w(this));
    }

    @Override // androidx.camera.core.imagecapture.TakePictureRequest.RetryControl
    public void retryRequest(TakePictureRequest r100) {
        Threads.checkMainThread();
        Logger.d(TAG, "Add a new request for retrying.");
        this.mNewRequests.addFirst(r100);
        issueNextRequest();
    }

    public void setImagePipeline(ImagePipeline r100) {
        Threads.checkMainThread();
        this.mImagePipeline = r100;
        r100.setOnImageCloseListener(this);
    }
}
