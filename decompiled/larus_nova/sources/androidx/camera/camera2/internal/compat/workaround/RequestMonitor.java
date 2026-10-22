package androidx.camera.camera2.internal.compat.workaround;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.camera2.internal.Camera2CaptureCallbacks;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class RequestMonitor {
    private static final String TAG = "RequestMonitor";
    private final boolean mQuirkEnabled;
    private final List<ListenableFuture<Void>> mRequestTasks;

    public static class RequestCompleteListener extends CameraCaptureSession.CaptureCallback {
        CallbackToFutureAdapter.Completer<Void> mStartRequestCompleter;
        final ListenableFuture<Void> mStartRequestFuture;

        public static /* synthetic */ Object a(RequestCompleteListener r100, CallbackToFutureAdapter.Completer r101) {
            return r100.lambda$new$0(r101);
        }

        private void completeFuture() {
            CallbackToFutureAdapter.Completer<Void> r100 = this.mStartRequestCompleter;
            if (r100 == null) goto L6;
            r100.set(null);
            this.mStartRequestCompleter = null;
            return;
        }

        public RequestCompleteListener() {
            this.mStartRequestFuture = CallbackToFutureAdapter.getFuture(new c(this));
        }

        private /* synthetic */ Object lambda$new$0(CallbackToFutureAdapter.Completer r100) throws Exception {
            this.mStartRequestCompleter = r100;
            return "RequestCompleteListener[" + this + "]";
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureSequenceAborted(CameraCaptureSession r100, int r101) {
            completeFuture();
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureCompleted(CameraCaptureSession r100, CaptureRequest r101, TotalCaptureResult r102) {
            completeFuture();
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureFailed(CameraCaptureSession r100, CaptureRequest r101, CaptureFailure r102) {
            completeFuture();
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureSequenceCompleted(CameraCaptureSession r100, int r101, long r102) {
            completeFuture();
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureStarted(CameraCaptureSession r100, CaptureRequest r101, long r102, long r103) {
            completeFuture();
        }
    }

    public static /* synthetic */ Void a(List r100) {
        return lambda$getRequestsProcessedFuture$0(r100);
    }

    public static /* synthetic */ void b(RequestMonitor r100, RequestCompleteListener r101, ListenableFuture r102) {
        r100.lambda$createMonitorListener$1(r101, r102);
    }

    private static /* synthetic */ Void lambda$getRequestsProcessedFuture$0(List r100) {
        return null;
    }

    private CameraCaptureSession.CaptureCallback createMonitorListener() {
        final RequestCompleteListener r100 = new RequestCompleteListener();
        final ListenableFuture<Void> r101 = r100.mStartRequestFuture;
        this.mRequestTasks.add(r101);
        toString();
        r101.addListener(new a(this, r100, r101), CameraXExecutors.directExecutor());
        return r100;
    }

    public ListenableFuture<Void> getRequestsProcessedFuture() {
        if (this.mRequestTasks.isEmpty() == false) goto L7;
        return Futures.immediateFuture(null);
    L7:
        return Futures.nonCancellationPropagating(Futures.transform(Futures.successfulAsList(new ArrayList(this.mRequestTasks)), new b(), CameraXExecutors.directExecutor()));
    }

    public void stop() {
        LinkedList r100 = new LinkedList(this.mRequestTasks);
    L4:
        if (r100.isEmpty() == true) goto L6;
        ListenableFuture r101 = (ListenableFuture) r100.poll();
        Objects.requireNonNull(r101);
        r101.cancel(true);
        goto L4
    }

    public boolean shouldMonitorRequest() {
        return this.mQuirkEnabled;
    }

    public RequestMonitor(boolean r100) {
        this.mRequestTasks = Collections.synchronizedList(new ArrayList());
        this.mQuirkEnabled = r100;
    }

    public CameraCaptureSession.CaptureCallback createMonitorListener(CameraCaptureSession.CaptureCallback r100) {
        if (shouldMonitorRequest() == true) goto L5;
        return r100;
    L5:
        return Camera2CaptureCallbacks.createComboCallback(new CameraCaptureSession.CaptureCallback[]{createMonitorListener(), r100});
    }

    private /* synthetic */ void lambda$createMonitorListener$1(RequestCompleteListener r100, ListenableFuture r101) {
        Objects.toString(r100);
        toString();
        this.mRequestTasks.remove(r101);
    }
}
