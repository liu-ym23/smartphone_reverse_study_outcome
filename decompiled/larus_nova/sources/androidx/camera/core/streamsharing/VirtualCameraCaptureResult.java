package androidx.camera.core.streamsharing;

import android.hardware.camera2.CaptureResult;
import androidx.camera.core.impl.CameraCaptureMetaData;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.utils.ExifData;

/* JADX INFO: loaded from: classes2.dex */
public class VirtualCameraCaptureResult implements CameraCaptureResult {
    private static final long INVALID_TIMESTAMP = -1;
    private final CameraCaptureResult mBaseCameraCaptureResult;
    private final TagBundle mTagBundle;
    private final long mTimestamp;

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public final /* synthetic */ CaptureResult getCaptureResult() {
        return CameraCaptureResult.CC.$default$getCaptureResult(this);
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public final /* synthetic */ void populateExifData(ExifData.Builder r100) {
        CameraCaptureResult.CC.$default$populateExifData(this, r100);
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public CameraCaptureMetaData.AeMode getAeMode() {
        CameraCaptureResult r100 = this.mBaseCameraCaptureResult;
        if (r100 == null) goto L6;
        return r100.getAeMode();
    L6:
        return CameraCaptureMetaData.AeMode.UNKNOWN;
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public CameraCaptureMetaData.AeState getAeState() {
        CameraCaptureResult r100 = this.mBaseCameraCaptureResult;
        if (r100 == null) goto L6;
        return r100.getAeState();
    L6:
        return CameraCaptureMetaData.AeState.UNKNOWN;
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public CameraCaptureMetaData.AfMode getAfMode() {
        CameraCaptureResult r100 = this.mBaseCameraCaptureResult;
        if (r100 == null) goto L6;
        return r100.getAfMode();
    L6:
        return CameraCaptureMetaData.AfMode.UNKNOWN;
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public CameraCaptureMetaData.AfState getAfState() {
        CameraCaptureResult r100 = this.mBaseCameraCaptureResult;
        if (r100 == null) goto L6;
        return r100.getAfState();
    L6:
        return CameraCaptureMetaData.AfState.UNKNOWN;
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public CameraCaptureMetaData.AwbMode getAwbMode() {
        CameraCaptureResult r100 = this.mBaseCameraCaptureResult;
        if (r100 == null) goto L6;
        return r100.getAwbMode();
    L6:
        return CameraCaptureMetaData.AwbMode.UNKNOWN;
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public CameraCaptureMetaData.AwbState getAwbState() {
        CameraCaptureResult r100 = this.mBaseCameraCaptureResult;
        if (r100 == null) goto L6;
        return r100.getAwbState();
    L6:
        return CameraCaptureMetaData.AwbState.UNKNOWN;
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public CameraCaptureMetaData.FlashState getFlashState() {
        CameraCaptureResult r100 = this.mBaseCameraCaptureResult;
        if (r100 == null) goto L6;
        return r100.getFlashState();
    L6:
        return CameraCaptureMetaData.FlashState.UNKNOWN;
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public long getTimestamp() {
        CameraCaptureResult r100 = this.mBaseCameraCaptureResult;
        if (r100 != null) goto L5;
        long r101 = this.mTimestamp;
        if (r101 == (-1)) goto L10;
        return r101;
    L10:
        throw new IllegalStateException("No timestamp is available.");
    L5:
        return r100.getTimestamp();
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public TagBundle getTagBundle() {
        return this.mTagBundle;
    }

    public VirtualCameraCaptureResult(TagBundle r100, CameraCaptureResult r101) {
        this(r101, r100, -1);
    }

    public VirtualCameraCaptureResult(TagBundle r100, long r101) {
        this(null, r100, r101);
    }

    private VirtualCameraCaptureResult(CameraCaptureResult r100, TagBundle r101, long r102) {
        this.mBaseCameraCaptureResult = r100;
        this.mTagBundle = r101;
        this.mTimestamp = r102;
    }
}
