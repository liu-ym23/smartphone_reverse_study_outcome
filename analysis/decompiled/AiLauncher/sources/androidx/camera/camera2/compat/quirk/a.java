package androidx.camera.camera2.compat.quirk;

import D.C0761b0;
import K.t0;
import K.u0;
import K.w0;
import Y8.h;
import android.util.Log;
import androidx.camera.camera2.pipe.g;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import kotlin.C4848b;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p.q;
import p9.InterfaceC5063a;
import t.C5473b;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\bB\u001b\b\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001b\u0010\u0010\u001a\u00020\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\n\u0010\u000f¨\u0006\u0012"}, d2 = {"Landroidx/camera/camera2/compat/quirk/a;", "", "Landroidx/camera/camera2/pipe/g;", "cameraMetadata", "Lp/q;", "streamConfigurationMapCompat", "<init>", "(Landroidx/camera/camera2/pipe/g;Lp/q;)V", Const.INTENT_KEY_APIKEY, "Landroidx/camera/camera2/pipe/g;", Const.INTENT_KEY_PKGNAME, "Lp/q;", "LK/w0;", "c", "LY8/h;", "()LK/w0;", "quirks", Const.INTENT_KEY_UMID, "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final g cameraMetadata;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final q streamConfigurationMapCompat;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final h quirks;

    public a(g gVar, q streamConfigurationMapCompat) {
        p.i(streamConfigurationMapCompat, "streamConfigurationMapCompat");
        this.cameraMetadata = gVar;
        this.streamConfigurationMapCompat = streamConfigurationMapCompat;
        this.quirks = C4848b.b(new InterfaceC5063a() { // from class: q.c
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return androidx.camera.camera2.compat.quirk.a.c(this.f38468a);
            }
        });
    }

    public static final w0 c(a aVar) {
        t0 t0VarA = u0.b().a();
        p.h(t0VarA, "get(...)");
        ArrayList arrayList = new ArrayList();
        g gVar = aVar.cameraMetadata;
        if (gVar == null) {
            C5473b c5473b = C5473b.f41865a;
            if (C0761b0.g("CXCP")) {
                Log.e(C5473b.TRUNCATED_TAG, "Failed to enable quirks: camera metadata injection failed");
            }
            return new w0(arrayList);
        }
        if (t0VarA.a(AeFpsRangeLegacyQuirk.class, AeFpsRangeLegacyQuirk.INSTANCE.a(gVar))) {
            arrayList.add(new AeFpsRangeLegacyQuirk(aVar.cameraMetadata));
        }
        if (t0VarA.a(AfRegionFlipHorizontallyQuirk.class, AfRegionFlipHorizontallyQuirk.INSTANCE.a(aVar.cameraMetadata))) {
            arrayList.add(new AfRegionFlipHorizontallyQuirk());
        }
        if (t0VarA.a(AspectRatioLegacyApi21Quirk.class, AspectRatioLegacyApi21Quirk.INSTANCE.a(aVar.cameraMetadata))) {
            arrayList.add(new AspectRatioLegacyApi21Quirk());
        }
        if (t0VarA.a(CamcorderProfileResolutionQuirk.class, CamcorderProfileResolutionQuirk.INSTANCE.a(aVar.cameraMetadata))) {
            arrayList.add(new CamcorderProfileResolutionQuirk(aVar.streamConfigurationMapCompat));
        }
        if (t0VarA.a(CameraNoResponseWhenEnablingFlashQuirk.class, CameraNoResponseWhenEnablingFlashQuirk.INSTANCE.b(aVar.cameraMetadata))) {
            arrayList.add(new CameraNoResponseWhenEnablingFlashQuirk());
        }
        if (t0VarA.a(CaptureSessionStuckQuirk.class, CaptureSessionStuckQuirk.INSTANCE.a())) {
            arrayList.add(new CaptureSessionStuckQuirk());
        }
        if (t0VarA.a(CloseCaptureSessionOnVideoQuirk.class, CloseCaptureSessionOnVideoQuirk.INSTANCE.a())) {
            arrayList.add(new CloseCaptureSessionOnVideoQuirk());
        }
        if (t0VarA.a(ConfigureSurfaceToSecondarySessionFailQuirk.class, ConfigureSurfaceToSecondarySessionFailQuirk.INSTANCE.a(aVar.cameraMetadata))) {
            arrayList.add(new ConfigureSurfaceToSecondarySessionFailQuirk());
        }
        if (t0VarA.a(FinalizeSessionOnCloseQuirk.class, FinalizeSessionOnCloseQuirk.INSTANCE.b())) {
            arrayList.add(new FinalizeSessionOnCloseQuirk());
        }
        if (t0VarA.a(FlashTooSlowQuirk.class, FlashTooSlowQuirk.INSTANCE.b(aVar.cameraMetadata))) {
            arrayList.add(new FlashTooSlowQuirk());
        }
        if (t0VarA.a(ImageCaptureFailWithAutoFlashQuirk.class, ImageCaptureFailWithAutoFlashQuirk.INSTANCE.a(aVar.cameraMetadata))) {
            arrayList.add(new ImageCaptureFailWithAutoFlashQuirk());
        }
        if (t0VarA.a(ImageCaptureFlashNotFireQuirk.class, ImageCaptureFlashNotFireQuirk.INSTANCE.a(aVar.cameraMetadata))) {
            arrayList.add(new ImageCaptureFlashNotFireQuirk());
        }
        if (t0VarA.a(ImageCaptureWashedOutImageQuirk.class, ImageCaptureWashedOutImageQuirk.INSTANCE.b(aVar.cameraMetadata))) {
            arrayList.add(new ImageCaptureWashedOutImageQuirk());
        }
        if (t0VarA.a(ImageCaptureWithFlashUnderexposureQuirk.class, ImageCaptureWithFlashUnderexposureQuirk.INSTANCE.a(aVar.cameraMetadata))) {
            arrayList.add(new ImageCaptureWithFlashUnderexposureQuirk());
        }
        if (t0VarA.a(JpegHalCorruptImageQuirk.class, JpegHalCorruptImageQuirk.INSTANCE.a())) {
            arrayList.add(new JpegHalCorruptImageQuirk());
        }
        JpegCaptureDownsizingQuirk jpegCaptureDownsizingQuirk = JpegCaptureDownsizingQuirk.f9468b;
        if (t0VarA.a(JpegCaptureDownsizingQuirk.class, jpegCaptureDownsizingQuirk.c(aVar.cameraMetadata))) {
            arrayList.add(jpegCaptureDownsizingQuirk);
        }
        if (t0VarA.a(PreviewOrientationIncorrectQuirk.class, PreviewOrientationIncorrectQuirk.INSTANCE.a(aVar.cameraMetadata))) {
            arrayList.add(new PreviewOrientationIncorrectQuirk());
        }
        if (t0VarA.a(TextureViewIsClosedQuirk.class, TextureViewIsClosedQuirk.INSTANCE.a(aVar.cameraMetadata))) {
            arrayList.add(new TextureViewIsClosedQuirk());
        }
        if (t0VarA.a(TorchFlashRequiredFor3aUpdateQuirk.class, TorchFlashRequiredFor3aUpdateQuirk.INSTANCE.c(aVar.cameraMetadata))) {
            arrayList.add(new TorchFlashRequiredFor3aUpdateQuirk(aVar.cameraMetadata));
        }
        if (t0VarA.a(YuvImageOnePixelShiftQuirk.class, YuvImageOnePixelShiftQuirk.INSTANCE.a())) {
            arrayList.add(new YuvImageOnePixelShiftQuirk());
        }
        if (t0VarA.a(PreviewStretchWhenVideoCaptureIsBoundQuirk.class, PreviewStretchWhenVideoCaptureIsBoundQuirk.INSTANCE.a())) {
            arrayList.add(new PreviewStretchWhenVideoCaptureIsBoundQuirk());
        }
        if (t0VarA.a(PreviewDelayWhenVideoCaptureIsBoundQuirk.class, PreviewDelayWhenVideoCaptureIsBoundQuirk.INSTANCE.a())) {
            arrayList.add(new PreviewDelayWhenVideoCaptureIsBoundQuirk());
        }
        if (t0VarA.a(QuickSuccessiveImageCaptureFailsRepeatingRequestQuirk.class, QuickSuccessiveImageCaptureFailsRepeatingRequestQuirk.INSTANCE.a(aVar.cameraMetadata))) {
            arrayList.add(new QuickSuccessiveImageCaptureFailsRepeatingRequestQuirk());
        }
        if (t0VarA.a(ImageCaptureFailedWhenVideoCaptureIsBoundQuirk.class, ImageCaptureFailedWhenVideoCaptureIsBoundQuirk.INSTANCE.f())) {
            arrayList.add(new ImageCaptureFailedWhenVideoCaptureIsBoundQuirk());
        }
        if (t0VarA.a(TemporalNoiseQuirk.class, TemporalNoiseQuirk.INSTANCE.a(aVar.cameraMetadata))) {
            arrayList.add(new TemporalNoiseQuirk());
        }
        if (t0VarA.a(ImageCaptureFailedForVideoSnapshotQuirk.class, ImageCaptureFailedForVideoSnapshotQuirk.INSTANCE.a())) {
            arrayList.add(new ImageCaptureFailedForVideoSnapshotQuirk());
        }
        if (t0VarA.a(AbnormalStreamWhenImageAnalysisBindWithTemplateRecordQuirk.class, AbnormalStreamWhenImageAnalysisBindWithTemplateRecordQuirk.INSTANCE.b())) {
            arrayList.add(new AbnormalStreamWhenImageAnalysisBindWithTemplateRecordQuirk());
        }
        if (t0VarA.a(UltraWideFlashCaptureUnderexposureQuirk.class, UltraWideFlashCaptureUnderexposureQuirk.INSTANCE.b(aVar.cameraMetadata))) {
            arrayList.add(new UltraWideFlashCaptureUnderexposureQuirk());
        }
        w0 w0Var = new w0(arrayList);
        C0761b0.a("CameraQuirks", "camera2 CameraQuirks = " + w0.d(w0Var));
        return w0Var;
    }

    public final w0 b() {
        return (w0) this.quirks.getValue();
    }
}
