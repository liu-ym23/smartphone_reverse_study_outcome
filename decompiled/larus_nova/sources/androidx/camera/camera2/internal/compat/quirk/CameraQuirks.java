package androidx.camera.camera2.internal.compat.quirk;

import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.QuirkSettings;
import androidx.camera.core.impl.QuirkSettingsHolder;
import androidx.camera.core.impl.Quirks;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class CameraQuirks {
    private static final String TAG = "CameraQuirks";

    private CameraQuirks() {
    }

    public static Quirks get(String r100, CameraCharacteristicsCompat r101) {
        QuirkSettings r102 = QuirkSettingsHolder.instance().get();
        ArrayList r103 = new ArrayList();
        if (r102.shouldEnableQuirk(AeFpsRangeLegacyQuirk.class, AeFpsRangeLegacyQuirk.load(r101)) == false) goto L6;
        r103.add(new AeFpsRangeLegacyQuirk(r101));
    L6:
        if (r102.shouldEnableQuirk(AspectRatioLegacyApi21Quirk.class, AspectRatioLegacyApi21Quirk.load(r101)) == false) goto L9;
        r103.add(new AspectRatioLegacyApi21Quirk());
    L9:
        if (r102.shouldEnableQuirk(JpegHalCorruptImageQuirk.class, JpegHalCorruptImageQuirk.load(r101)) == false) goto L12;
        r103.add(new JpegHalCorruptImageQuirk());
    L12:
        if (r102.shouldEnableQuirk(JpegCaptureDownsizingQuirk.class, JpegCaptureDownsizingQuirk.load(r101)) == false) goto L15;
        r103.add(new JpegCaptureDownsizingQuirk());
    L15:
        if (r102.shouldEnableQuirk(CamcorderProfileResolutionQuirk.class, CamcorderProfileResolutionQuirk.load(r101)) == false) goto L18;
        r103.add(new CamcorderProfileResolutionQuirk(r101));
    L18:
        if (r102.shouldEnableQuirk(CaptureNoResponseQuirk.class, CaptureNoResponseQuirk.load(r101)) == false) goto L21;
        r103.add(new CaptureNoResponseQuirk());
    L21:
        if (r102.shouldEnableQuirk(LegacyCameraOutputConfigNullPointerQuirk.class, LegacyCameraOutputConfigNullPointerQuirk.load(r101)) == false) goto L24;
        r103.add(new LegacyCameraOutputConfigNullPointerQuirk());
    L24:
        if (r102.shouldEnableQuirk(LegacyCameraSurfaceCleanupQuirk.class, LegacyCameraSurfaceCleanupQuirk.load(r101)) == false) goto L27;
        r103.add(new LegacyCameraSurfaceCleanupQuirk());
    L27:
        if (r102.shouldEnableQuirk(ImageCaptureWashedOutImageQuirk.class, ImageCaptureWashedOutImageQuirk.load(r101)) == false) goto L30;
        r103.add(new ImageCaptureWashedOutImageQuirk());
    L30:
        if (r102.shouldEnableQuirk(CameraNoResponseWhenEnablingFlashQuirk.class, CameraNoResponseWhenEnablingFlashQuirk.load(r101)) == false) goto L33;
        r103.add(new CameraNoResponseWhenEnablingFlashQuirk());
    L33:
        if (r102.shouldEnableQuirk(YuvImageOnePixelShiftQuirk.class, YuvImageOnePixelShiftQuirk.load(r101)) == false) goto L36;
        r103.add(new YuvImageOnePixelShiftQuirk());
    L36:
        if (r102.shouldEnableQuirk(FlashTooSlowQuirk.class, FlashTooSlowQuirk.load(r101)) == false) goto L39;
        r103.add(new FlashTooSlowQuirk());
    L39:
        if (r102.shouldEnableQuirk(AfRegionFlipHorizontallyQuirk.class, AfRegionFlipHorizontallyQuirk.load(r101)) == false) goto L42;
        r103.add(new AfRegionFlipHorizontallyQuirk());
    L42:
        if (r102.shouldEnableQuirk(ConfigureSurfaceToSecondarySessionFailQuirk.class, ConfigureSurfaceToSecondarySessionFailQuirk.load(r101)) == false) goto L45;
        r103.add(new ConfigureSurfaceToSecondarySessionFailQuirk());
    L45:
        if (r102.shouldEnableQuirk(PreviewOrientationIncorrectQuirk.class, PreviewOrientationIncorrectQuirk.load(r101)) == false) goto L48;
        r103.add(new PreviewOrientationIncorrectQuirk());
    L48:
        if (r102.shouldEnableQuirk(CaptureSessionStuckQuirk.class, CaptureSessionStuckQuirk.load(r101)) == false) goto L51;
        r103.add(new CaptureSessionStuckQuirk());
    L51:
        if (r102.shouldEnableQuirk(ImageCaptureFlashNotFireQuirk.class, ImageCaptureFlashNotFireQuirk.load(r101)) == false) goto L54;
        r103.add(new ImageCaptureFlashNotFireQuirk());
    L54:
        if (r102.shouldEnableQuirk(ImageCaptureWithFlashUnderexposureQuirk.class, ImageCaptureWithFlashUnderexposureQuirk.load(r101)) == false) goto L57;
        r103.add(new ImageCaptureWithFlashUnderexposureQuirk());
    L57:
        if (r102.shouldEnableQuirk(ImageCaptureFailWithAutoFlashQuirk.class, ImageCaptureFailWithAutoFlashQuirk.load(r101)) == false) goto L60;
        r103.add(new ImageCaptureFailWithAutoFlashQuirk());
    L60:
        if (r102.shouldEnableQuirk(IncorrectCaptureStateQuirk.class, IncorrectCaptureStateQuirk.load(r101)) == false) goto L63;
        r103.add(new IncorrectCaptureStateQuirk());
    L63:
        if (r102.shouldEnableQuirk(TorchFlashRequiredFor3aUpdateQuirk.class, TorchFlashRequiredFor3aUpdateQuirk.load(r101)) == false) goto L66;
        r103.add(new TorchFlashRequiredFor3aUpdateQuirk(r101));
    L66:
        if (r102.shouldEnableQuirk(PreviewStretchWhenVideoCaptureIsBoundQuirk.class, PreviewStretchWhenVideoCaptureIsBoundQuirk.load()) == false) goto L69;
        r103.add(new PreviewStretchWhenVideoCaptureIsBoundQuirk());
    L69:
        if (r102.shouldEnableQuirk(PreviewDelayWhenVideoCaptureIsBoundQuirk.class, PreviewDelayWhenVideoCaptureIsBoundQuirk.load()) == false) goto L72;
        r103.add(new PreviewDelayWhenVideoCaptureIsBoundQuirk());
    L72:
        if (r102.shouldEnableQuirk(ImageCaptureFailedWhenVideoCaptureIsBoundQuirk.class, ImageCaptureFailedWhenVideoCaptureIsBoundQuirk.load()) == false) goto L75;
        r103.add(new ImageCaptureFailedWhenVideoCaptureIsBoundQuirk());
    L75:
        if (r102.shouldEnableQuirk(TemporalNoiseQuirk.class, TemporalNoiseQuirk.load(r101)) == false) goto L78;
        r103.add(new TemporalNoiseQuirk());
    L78:
        if (r102.shouldEnableQuirk(ImageCaptureFailedForVideoSnapshotQuirk.class, ImageCaptureFailedForVideoSnapshotQuirk.load()) == false) goto L80;
        r103.add(new ImageCaptureFailedForVideoSnapshotQuirk());
    L80:
        Quirks r104 = new Quirks(r103);
        Logger.d(TAG, "camera2 CameraQuirks = " + Quirks.toString(r104));
        return r104;
    }
}
