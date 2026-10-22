package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.InputConfiguration;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.Image;
import android.media.ImageWriter;
import android.os.Build;
import android.util.Size;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.ZslDisablerQuirk;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Logger;
import androidx.camera.core.MetadataImageReader;
import androidx.camera.core.SafeCloseImageReaderProxy;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.ImmediateSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.utils.CompareSizesByArea;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.internal.compat.ImageWriterCompat;
import androidx.camera.core.internal.utils.ZslRingBuffer;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class ZslControlImpl implements ZslControl {
    static final int MAX_IMAGES = 9;
    static final int RING_BUFFER_CAPACITY = 3;
    private static final String TAG = "ZslControlImpl";
    private final CameraCharacteristicsCompat mCameraCharacteristicsCompat;
    final ZslRingBuffer mImageRingBuffer;
    private boolean mIsPrivateReprocessingSupported;
    private boolean mIsZslDisabledByFlashMode;
    private boolean mIsZslDisabledByUseCaseConfig;
    private CameraCaptureCallback mMetadataMatchingCaptureCallback;
    private DeferrableSurface mReprocessingImageDeferrableSurface;
    SafeCloseImageReaderProxy mReprocessingImageReader;
    ImageWriter mReprocessingImageWriter;
    private boolean mShouldZslDisabledByQuirks;

    public static /* synthetic */ void a(ZslControlImpl r100, ImageReaderProxy r101) {
        r100.lambda$addZslConfig$1(r101);
    }

    public static /* synthetic */ void b(ImageProxy r100) {
        lambda$new$0(r100);
    }

    private void cleanup() {
        ZslRingBuffer r100 = this.mImageRingBuffer;
    L4:
        if (r100.isEmpty() == true) goto L6;
        r100.dequeue().close();
        goto L4
    L6:
        DeferrableSurface r101 = this.mReprocessingImageDeferrableSurface;
        if (r101 == null) goto L12;
        SafeCloseImageReaderProxy r102 = this.mReprocessingImageReader;
        if (r102 == null) goto L11;
        r101.getTerminationFuture().addListener(new v3(r102), CameraXExecutors.mainThreadExecutor());
        this.mReprocessingImageReader = null;
    L11:
        r101.close();
        this.mReprocessingImageDeferrableSurface = null;
    L12:
        ImageWriter r103 = this.mReprocessingImageWriter;
        if (r103 == null) goto L17;
        r103.close();
        this.mReprocessingImageWriter = null;
        return;
    }

    @Override // androidx.camera.camera2.internal.ZslControl
    public ImageProxy dequeueImageFromBuffer() {
        return this.mImageRingBuffer.dequeue();
    L4:
        Logger.e(TAG, "dequeueImageFromBuffer no such element");
        return null;
    }

    @Override // androidx.camera.camera2.internal.ZslControl
    public boolean isZslDisabledByFlashMode() {
        return this.mIsZslDisabledByFlashMode;
    }

    @Override // androidx.camera.camera2.internal.ZslControl
    public boolean isZslDisabledByUserCaseConfig() {
        return this.mIsZslDisabledByUseCaseConfig;
    }

    public ZslControlImpl(CameraCharacteristicsCompat r100) {
        boolean r101 = false;
        this.mIsZslDisabledByUseCaseConfig = false;
        this.mIsZslDisabledByFlashMode = false;
        this.mIsPrivateReprocessingSupported = false;
        this.mShouldZslDisabledByQuirks = false;
        this.mCameraCharacteristicsCompat = r100;
        this.mIsPrivateReprocessingSupported = ZslUtil.isCapabilitySupported(r100, 4);
        if (DeviceQuirks.get(ZslDisablerQuirk.class) == null) goto L5;
        r101 = true;
    L5:
        this.mShouldZslDisabledByQuirks = r101;
        this.mImageRingBuffer = new ZslRingBuffer(3, new w3());
    }

    private Map<Integer, Size> createReprocessingInputSizeMap(CameraCharacteristicsCompat r110) {
        StreamConfigurationMap r111 = (StreamConfigurationMap) r110.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);     // Catch: AssertionError -> L4
    L6:
        if (r111 == null) goto L18;
        if (r111.getInputFormats() == null) goto L18;
        HashMap r100 = new HashMap();
        int[] r101 = r111.getInputFormats();
        int r102 = r101.length;
        int r103 = 0;
    L11:
        if (r103 >= r102) goto L16;
        int r104 = r101[r103];
        Size[] r105 = r111.getInputSizes(r104);
        if (r105 == null) goto L15;
        Arrays.sort(r105, new CompareSizesByArea(true));
        r100.put(Integer.valueOf(r104), r105[0]);
    L15:
        r103 = r103 + 1;
        goto L11
    L16:
        return r100;
    L18:
        return new HashMap();
    L4:
        e = move-exception;
        Logger.e(TAG, "Failed to retrieve StreamConfigurationMap, error = " + e.getMessage());
        r111 = null;
        goto L6
    }

    private /* synthetic */ void lambda$addZslConfig$1(ImageReaderProxy r100) {
        ImageProxy r101 = r100.acquireLatestImage();     // Catch: IllegalStateException -> L6
        if (r101 == null) goto L11;
        this.mImageRingBuffer.enqueue(r101);     // Catch: IllegalStateException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        Logger.e(TAG, "Failed to acquire latest image IllegalStateException = " + e.getMessage());
    }

    private static /* synthetic */ void lambda$new$0(ImageProxy r100) {
        r100.close();
    }

    @Override // androidx.camera.camera2.internal.ZslControl
    public void addZslConfig(SessionConfig.Builder r100) {
        cleanup();
        if (this.mIsZslDisabledByUseCaseConfig == false) goto L7;
        r100.setTemplateType(1);
        return;
    L7:
        if (this.mShouldZslDisabledByQuirks == false) goto L10;
        r100.setTemplateType(1);
        return;
    L10:
        Map<Integer, Size> r101 = createReprocessingInputSizeMap(this.mCameraCharacteristicsCompat);
        if (this.mIsPrivateReprocessingSupported == true) goto L13;
    L21:
        r100.setTemplateType(1);
        return;
    L13:
        if (r101.isEmpty() == true) goto L21;
        if (r101.containsKey(34) == false) goto L21;
        if (isJpegValidOutputForInputFormat(this.mCameraCharacteristicsCompat, 34) == false) goto L21;
        Size r102 = r101.get(34);
        MetadataImageReader r103 = new MetadataImageReader(r102.getWidth(), r102.getHeight(), 34, 9);
        this.mMetadataMatchingCaptureCallback = r103.getCameraCaptureCallback();
        this.mReprocessingImageReader = new SafeCloseImageReaderProxy(r103);
        r103.setOnImageAvailableListener(new u3(this), CameraXExecutors.ioExecutor());
        ImmediateSurface r104 = new ImmediateSurface(this.mReprocessingImageReader.getSurface(), new Size(this.mReprocessingImageReader.getWidth(), this.mReprocessingImageReader.getHeight()), 34);
        this.mReprocessingImageDeferrableSurface = r104;
        SafeCloseImageReaderProxy r105 = this.mReprocessingImageReader;
        ListenableFuture<Void> r106 = r104.getTerminationFuture();
        Objects.requireNonNull(r105);
        r106.addListener(new v3(r105), CameraXExecutors.mainThreadExecutor());
        r100.addSurface(this.mReprocessingImageDeferrableSurface);
        r100.addCameraCaptureCallback(this.mMetadataMatchingCaptureCallback);
        r100.addSessionStateCallback(new AnonymousClass1(this));
        r100.setInputConfiguration(new InputConfiguration(this.mReprocessingImageReader.getWidth(), this.mReprocessingImageReader.getHeight(), this.mReprocessingImageReader.getImageFormat()));
    }

    @Override // androidx.camera.camera2.internal.ZslControl
    public boolean enqueueImageToImageWriter(ImageProxy r100) {
        Image r101 = r100.getImage();
        if (Build.VERSION.SDK_INT < 23) goto L12;
        ImageWriter r102 = this.mReprocessingImageWriter;
        if (r102 == null) goto L12;
        if (r101 == null) goto L12;
        ImageWriterCompat.queueInputImage(r102, r101);     // Catch: IllegalStateException -> L10
        return true;
    L10:
        e = move-exception;
        Logger.e(TAG, "enqueueImageToImageWriter throws IllegalStateException = " + e.getMessage());
    L12:
        return false;
    }

    @Override // androidx.camera.camera2.internal.ZslControl
    public void setZslDisabledByFlashMode(boolean r100) {
        this.mIsZslDisabledByFlashMode = r100;
    }

    @Override // androidx.camera.camera2.internal.ZslControl
    public void setZslDisabledByUserCaseConfig(boolean r100) {
        this.mIsZslDisabledByUseCaseConfig = r100;
    }

    private boolean isJpegValidOutputForInputFormat(CameraCharacteristicsCompat r100, int r101) {
        StreamConfigurationMap r102 = (StreamConfigurationMap) r100.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (r102 != null) goto L5;
        return false;
    L5:
        int[] r103 = r102.getValidOutputFormatsForInput(r101);
        if (r103 != null) goto L8;
        return false;
    L8:
        int r104 = r103.length;
        int r105 = 0;
    L9:
        if (r105 >= r104) goto L15;
        if (r103[r105] == 256) goto L12;
        r105 = r105 + 1;
        goto L9
    L12:
        return true;
    L15:
        return false;
    }
}
