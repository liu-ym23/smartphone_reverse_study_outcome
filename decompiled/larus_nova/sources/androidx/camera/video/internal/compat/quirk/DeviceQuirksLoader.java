package androidx.camera.video.internal.compat.quirk;

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
        if (r100.shouldEnableQuirk(MediaFormatMustNotUseFrameRateToFindEncoderQuirk.class, MediaFormatMustNotUseFrameRateToFindEncoderQuirk.load()) == false) goto L6;
        r101.add(new MediaFormatMustNotUseFrameRateToFindEncoderQuirk());
    L6:
        if (r100.shouldEnableQuirk(MediaCodecInfoReportIncorrectInfoQuirk.class, MediaCodecInfoReportIncorrectInfoQuirk.load()) == false) goto L9;
        r101.add(new MediaCodecInfoReportIncorrectInfoQuirk());
    L9:
        if (r100.shouldEnableQuirk(DeactivateEncoderSurfaceBeforeStopEncoderQuirk.class, DeactivateEncoderSurfaceBeforeStopEncoderQuirk.load()) == false) goto L12;
        r101.add(new DeactivateEncoderSurfaceBeforeStopEncoderQuirk());
    L12:
        if (r100.shouldEnableQuirk(CameraUseInconsistentTimebaseQuirk.class, CameraUseInconsistentTimebaseQuirk.load()) == false) goto L15;
        r101.add(new CameraUseInconsistentTimebaseQuirk());
    L15:
        if (r100.shouldEnableQuirk(ReportedVideoQualityNotSupportedQuirk.class, ReportedVideoQualityNotSupportedQuirk.load()) == false) goto L18;
        r101.add(new ReportedVideoQualityNotSupportedQuirk());
    L18:
        if (r100.shouldEnableQuirk(EncoderNotUsePersistentInputSurfaceQuirk.class, EncoderNotUsePersistentInputSurfaceQuirk.load()) == false) goto L21;
        r101.add(new EncoderNotUsePersistentInputSurfaceQuirk());
    L21:
        if (r100.shouldEnableQuirk(VideoEncoderCrashQuirk.class, VideoEncoderCrashQuirk.load()) == false) goto L24;
        r101.add(new VideoEncoderCrashQuirk());
    L24:
        if (r100.shouldEnableQuirk(ExcludeStretchedVideoQualityQuirk.class, ExcludeStretchedVideoQualityQuirk.load()) == false) goto L27;
        r101.add(new ExcludeStretchedVideoQualityQuirk());
    L27:
        if (r100.shouldEnableQuirk(MediaStoreVideoCannotWrite.class, MediaStoreVideoCannotWrite.load()) == false) goto L30;
        r101.add(new MediaStoreVideoCannotWrite());
    L30:
        if (r100.shouldEnableQuirk(AudioEncoderIgnoresInputTimestampQuirk.class, AudioEncoderIgnoresInputTimestampQuirk.load()) == false) goto L33;
        r101.add(new AudioEncoderIgnoresInputTimestampQuirk());
    L33:
        if (r100.shouldEnableQuirk(VideoEncoderSuspendDoesNotIncludeSuspendTimeQuirk.class, VideoEncoderSuspendDoesNotIncludeSuspendTimeQuirk.load()) == false) goto L36;
        r101.add(new VideoEncoderSuspendDoesNotIncludeSuspendTimeQuirk());
    L36:
        if (r100.shouldEnableQuirk(NegativeLatLongSavesIncorrectlyQuirk.class, NegativeLatLongSavesIncorrectlyQuirk.load()) == false) goto L39;
        r101.add(new NegativeLatLongSavesIncorrectlyQuirk());
    L39:
        if (r100.shouldEnableQuirk(AudioTimestampFramePositionIncorrectQuirk.class, AudioTimestampFramePositionIncorrectQuirk.load()) == false) goto L42;
        r101.add(new AudioTimestampFramePositionIncorrectQuirk());
    L42:
        if (r100.shouldEnableQuirk(ExtraSupportedResolutionQuirk.class, ExtraSupportedResolutionQuirk.load()) == false) goto L45;
        r101.add(new ExtraSupportedResolutionQuirk());
    L45:
        if (r100.shouldEnableQuirk(StretchedVideoResolutionQuirk.class, StretchedVideoResolutionQuirk.load()) == false) goto L48;
        r101.add(new StretchedVideoResolutionQuirk());
    L48:
        if (r100.shouldEnableQuirk(CodecStuckOnFlushQuirk.class, CodecStuckOnFlushQuirk.load()) == false) goto L51;
        r101.add(new CodecStuckOnFlushQuirk());
    L51:
        if (r100.shouldEnableQuirk(StopCodecAfterSurfaceRemovalCrashMediaServerQuirk.class, StopCodecAfterSurfaceRemovalCrashMediaServerQuirk.load()) == false) goto L54;
        r101.add(new StopCodecAfterSurfaceRemovalCrashMediaServerQuirk());
    L54:
        if (r100.shouldEnableQuirk(ExtraSupportedQualityQuirk.class, ExtraSupportedQualityQuirk.load()) == false) goto L57;
        r101.add(new ExtraSupportedQualityQuirk());
    L57:
        if (r100.shouldEnableQuirk(SignalEosOutputBufferNotComeQuirk.class, SignalEosOutputBufferNotComeQuirk.load()) == false) goto L60;
        r101.add(new SignalEosOutputBufferNotComeQuirk());
    L60:
        if (r100.shouldEnableQuirk(SizeCannotEncodeVideoQuirk.class, SizeCannotEncodeVideoQuirk.load()) == false) goto L62;
        r101.add(new SizeCannotEncodeVideoQuirk());
    L62:
        return r101;
    }
}
