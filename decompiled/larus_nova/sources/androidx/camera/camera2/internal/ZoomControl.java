package androidx.camera.camera2.internal;

import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Build;
import android.os.Looper;
import android.util.Range;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.CameraControl;
import androidx.camera.core.Logger;
import androidx.camera.core.ZoomState;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.internal.ImmutableZoomState;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
final class ZoomControl {
    public static final float DEFAULT_ZOOM_RATIO = 1.0f;
    private static final String TAG = "ZoomControl";
    private final Camera2CameraControlImpl mCamera2CameraControlImpl;
    private Camera2CameraControlImpl.CaptureResultListener mCaptureResultListener;
    private final ZoomStateImpl mCurrentZoomState;
    private final Executor mExecutor;
    private boolean mIsActive;
    final ZoomImpl mZoomImpl;
    private final MutableLiveData<ZoomState> mZoomStateLiveData;

    public interface ZoomImpl {
        void addRequestOption(Camera2ImplConfig.Builder r100);

        Rect getCropSensorRegion();

        float getMaxZoom();

        float getMinZoom();

        void onCaptureResult(TotalCaptureResult r100);

        void resetZoom();

        void setZoomRatio(float r100, CallbackToFutureAdapter.Completer<Void> r101);
    }

    public static /* synthetic */ void a(ZoomControl r100, CallbackToFutureAdapter.Completer r101, ZoomState r102) {
        r100.lambda$setZoomRatio$0(r101, r102);
    }

    public static /* synthetic */ Object b(ZoomControl r100, ZoomState r101, CallbackToFutureAdapter.Completer r102) {
        return r100.lambda$setZoomRatio$1(r101, r102);
    }

    public static /* synthetic */ Object c(ZoomControl r100, ZoomState r101, CallbackToFutureAdapter.Completer r102) {
        return r100.lambda$setLinearZoom$3(r101, r102);
    }

    public static /* synthetic */ void d(ZoomControl r100, CallbackToFutureAdapter.Completer r101, ZoomState r102) {
        r100.lambda$setLinearZoom$2(r101, r102);
    }

    public Rect getCropSensorRegion() {
        return this.mZoomImpl.getCropSensorRegion();
    }

    public LiveData<ZoomState> getZoomState() {
        return this.mZoomStateLiveData;
    }

    private static ZoomImpl createZoomImpl(CameraCharacteristicsCompat r100) {
        if (isAndroidRZoomSupported(r100) == false) goto L7;
        return new AndroidRZoomImpl(r100);
    L7:
        return new CropRegionZoomImpl(r100);
    }

    public static ZoomState getDefaultZoomState(CameraCharacteristicsCompat r100) {
        ZoomImpl r101 = createZoomImpl(r100);
        ZoomStateImpl r102 = new ZoomStateImpl(r101.getMaxZoom(), r101.getMinZoom());
        r102.setZoomRatio(1.0f);
        return ImmutableZoomState.create(r102);
    }

    private static Range<Float> getZoomRatioRange(CameraCharacteristicsCompat r100) {
        return (Range) r100.get(CameraCharacteristics.CONTROL_ZOOM_RATIO_RANGE);
    L4:
        e = move-exception;
        Logger.w(TAG, "AssertionError, fail to get camera characteristic.", e);
        return null;
    }

    public static boolean isAndroidRZoomSupported(CameraCharacteristicsCompat r100) {
        if (Build.VERSION.SDK_INT >= 30) goto L5;
    L7:
        return false;
    L5:
        if (getZoomRatioRange(r100) == null) goto L7;
        return true;
    }

    private void updateLiveData(ZoomState r100) {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        this.mZoomStateLiveData.setValue(r100);
        return;
    L5:
        this.mZoomStateLiveData.postValue(r100);
    }

    public void addZoomOption(Camera2ImplConfig.Builder r100) {
        this.mZoomImpl.addRequestOption(r100);
    }

    public void setActive(boolean r100) {
        if (this.mIsActive != r100) goto L5;
        return;
    L5:
        this.mIsActive = r100;
        if (r100 == true) goto L15;
        ZoomStateImpl r101 = this.mCurrentZoomState;
        monitor-enter(r101);
        this.mCurrentZoomState.setZoomRatio(1.0f);     // Catch: Throwable -> L12
        ZoomState r102 = ImmutableZoomState.create(this.mCurrentZoomState);     // Catch: Throwable -> L12
        monitor-exit(r101);     // Catch: Throwable -> L12
        updateLiveData(r102);
        this.mZoomImpl.resetZoom();
        this.mCamera2CameraControlImpl.updateSessionConfigSynchronous();
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public ListenableFuture<Void> setLinearZoom(float r100) {
        ZoomStateImpl r101 = this.mCurrentZoomState;
        monitor-enter(r101);
        this.mCurrentZoomState.setLinearZoom(r100);     // Catch: Throwable -> L8 IllegalArgumentException -> L10
        final ZoomState r102 = ImmutableZoomState.create(this.mCurrentZoomState);     // Catch: Throwable -> L8 IllegalArgumentException -> L10
        monitor-exit(r101);     // Catch: Throwable -> L8
        updateLiveData(r102);
        return CallbackToFutureAdapter.getFuture(new t3(this, r102));
    L10:
        e = move-exception;
        return Futures.immediateFailedFuture(e);
    L8:
        th = move-exception;
        throw th;
    }

    public ListenableFuture<Void> setZoomRatio(float r100) {
        ZoomStateImpl r101 = this.mCurrentZoomState;
        monitor-enter(r101);
        this.mCurrentZoomState.setZoomRatio(r100);     // Catch: Throwable -> L8 IllegalArgumentException -> L10
        final ZoomState r102 = ImmutableZoomState.create(this.mCurrentZoomState);     // Catch: Throwable -> L8 IllegalArgumentException -> L10
        monitor-exit(r101);     // Catch: Throwable -> L8
        updateLiveData(r102);
        return CallbackToFutureAdapter.getFuture(new q3(this, r102));
    L10:
        e = move-exception;
        return Futures.immediateFailedFuture(e);
    L8:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$setLinearZoom$2(CallbackToFutureAdapter.Completer r100, ZoomState r101) {
        submitCameraZoomRatio(r100, r101);
    }

    private /* synthetic */ Object lambda$setLinearZoom$3(final ZoomState r100, final CallbackToFutureAdapter.Completer r101) throws Exception {
        this.mExecutor.execute(new r3(this, r101, r100));
        return "setLinearZoom";
    }

    private /* synthetic */ void lambda$setZoomRatio$0(CallbackToFutureAdapter.Completer r100, ZoomState r101) {
        submitCameraZoomRatio(r100, r101);
    }

    private /* synthetic */ Object lambda$setZoomRatio$1(final ZoomState r100, final CallbackToFutureAdapter.Completer r101) throws Exception {
        this.mExecutor.execute(new s3(this, r101, r100));
        return "setZoomRatio";
    }

    private void submitCameraZoomRatio(CallbackToFutureAdapter.Completer<Void> r100, ZoomState r101) {
        if (this.mIsActive == true) goto L13;
        ZoomStateImpl r102 = this.mCurrentZoomState;
        monitor-enter(r102);
        this.mCurrentZoomState.setZoomRatio(1.0f);     // Catch: Throwable -> L10
        ZoomState r103 = ImmutableZoomState.create(this.mCurrentZoomState);     // Catch: Throwable -> L10
        monitor-exit(r102);     // Catch: Throwable -> L10
        updateLiveData(r103);
        r100.setException(new CameraControl.OperationCanceledException("Camera is not active."));
        return;
    L10:
        th = move-exception;
        throw th;
    L13:
        this.mZoomImpl.setZoomRatio(r101.getZoomRatio(), r100);
        this.mCamera2CameraControlImpl.updateSessionConfigSynchronous();
    }

    public ZoomControl(Camera2CameraControlImpl r100, CameraCharacteristicsCompat r101, Executor r102) {
        this.mIsActive = false;
        this.mCaptureResultListener = new AnonymousClass1(this);
        this.mCamera2CameraControlImpl = r100;
        this.mExecutor = r102;
        ZoomImpl r103 = createZoomImpl(r101);
        this.mZoomImpl = r103;
        ZoomStateImpl r104 = new ZoomStateImpl(r103.getMaxZoom(), r103.getMinZoom());
        this.mCurrentZoomState = r104;
        r104.setZoomRatio(1.0f);
        this.mZoomStateLiveData = new MutableLiveData(ImmutableZoomState.create(r104));
        r100.addCaptureResultListener(this.mCaptureResultListener);
    }
}
