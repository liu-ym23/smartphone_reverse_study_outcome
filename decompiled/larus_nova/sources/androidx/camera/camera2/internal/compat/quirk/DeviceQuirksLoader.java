package androidx.camera.camera2.internal.compat.quirk;

import androidx.camera.core.impl.Quirk;
import androidx.camera.core.impl.QuirkSettings;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceQuirksLoader {
    private DeviceQuirksLoader() {
    }

    public static List<Quirk> loadQuirks(QuirkSettings r100) {
        ArrayList r101 = new ArrayList();
        if (r100.shouldEnableQuirk(ImageCapturePixelHDRPlusQuirk.class, ImageCapturePixelHDRPlusQuirk.load()) == false) goto L6;
        r101.add(new ImageCapturePixelHDRPlusQuirk());
    L6:
        if (r100.shouldEnableQuirk(ExtraCroppingQuirk.class, ExtraCroppingQuirk.load()) == false) goto L9;
        r101.add(new ExtraCroppingQuirk());
    L9:
        if (r100.shouldEnableQuirk(Nexus4AndroidLTargetAspectRatioQuirk.class, Nexus4AndroidLTargetAspectRatioQuirk.load()) == false) goto L12;
        r101.add(new Nexus4AndroidLTargetAspectRatioQuirk());
    L12:
        if (r100.shouldEnableQuirk(ExcludedSupportedSizesQuirk.class, ExcludedSupportedSizesQuirk.load()) == false) goto L15;
        r101.add(new ExcludedSupportedSizesQuirk());
    L15:
        if (r100.shouldEnableQuirk(CrashWhenTakingPhotoWithAutoFlashAEModeQuirk.class, CrashWhenTakingPhotoWithAutoFlashAEModeQuirk.load()) == false) goto L18;
        r101.add(new CrashWhenTakingPhotoWithAutoFlashAEModeQuirk());
    L18:
        if (r100.shouldEnableQuirk(PreviewPixelHDRnetQuirk.class, PreviewPixelHDRnetQuirk.load()) == false) goto L21;
        r101.add(new PreviewPixelHDRnetQuirk());
    L21:
        if (r100.shouldEnableQuirk(StillCaptureFlashStopRepeatingQuirk.class, StillCaptureFlashStopRepeatingQuirk.load()) == false) goto L24;
        r101.add(new StillCaptureFlashStopRepeatingQuirk());
    L24:
        if (r100.shouldEnableQuirk(ExtraSupportedSurfaceCombinationsQuirk.class, ExtraSupportedSurfaceCombinationsQuirk.load()) == false) goto L27;
        r101.add(new ExtraSupportedSurfaceCombinationsQuirk());
    L27:
        if (r100.shouldEnableQuirk(FlashAvailabilityBufferUnderflowQuirk.class, FlashAvailabilityBufferUnderflowQuirk.load()) == false) goto L30;
        r101.add(new FlashAvailabilityBufferUnderflowQuirk());
    L30:
        if (r100.shouldEnableQuirk(RepeatingStreamConstraintForVideoRecordingQuirk.class, RepeatingStreamConstraintForVideoRecordingQuirk.load()) == false) goto L33;
        r101.add(new RepeatingStreamConstraintForVideoRecordingQuirk());
    L33:
        if (r100.shouldEnableQuirk(TextureViewIsClosedQuirk.class, TextureViewIsClosedQuirk.load()) == false) goto L36;
        r101.add(new TextureViewIsClosedQuirk());
    L36:
        if (r100.shouldEnableQuirk(CaptureSessionOnClosedNotCalledQuirk.class, CaptureSessionOnClosedNotCalledQuirk.load()) == false) goto L39;
        r101.add(new CaptureSessionOnClosedNotCalledQuirk());
    L39:
        if (r100.shouldEnableQuirk(TorchIsClosedAfterImageCapturingQuirk.class, TorchIsClosedAfterImageCapturingQuirk.load()) == false) goto L42;
        r101.add(new TorchIsClosedAfterImageCapturingQuirk());
    L42:
        if (r100.shouldEnableQuirk(ZslDisablerQuirk.class, ZslDisablerQuirk.load()) == false) goto L45;
        r101.add(new ZslDisablerQuirk());
    L45:
        if (r100.shouldEnableQuirk(ExtraSupportedOutputSizeQuirk.class, ExtraSupportedOutputSizeQuirk.load()) == false) goto L48;
        r101.add(new ExtraSupportedOutputSizeQuirk());
    L48:
        if (r100.shouldEnableQuirk(InvalidVideoProfilesQuirk.class, InvalidVideoProfilesQuirk.load()) == false) goto L51;
        r101.add(new InvalidVideoProfilesQuirk());
    L51:
        if (r100.shouldEnableQuirk(Preview3AThreadCrashQuirk.class, Preview3AThreadCrashQuirk.load()) == false) goto L54;
        r101.add(new Preview3AThreadCrashQuirk());
    L54:
        if (r100.shouldEnableQuirk(SmallDisplaySizeQuirk.class, SmallDisplaySizeQuirk.load()) == false) goto L57;
        r101.add(new SmallDisplaySizeQuirk());
    L57:
        if (r100.shouldEnableQuirk(CaptureSessionShouldUseMrirQuirk.class, CaptureSessionShouldUseMrirQuirk.load()) == false) goto L59;
        r101.add(new CaptureSessionShouldUseMrirQuirk());
    L59:
        return r101;
    }
}
