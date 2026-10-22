package s;

import androidx.camera.camera2.compat.workaround.CapturePipelineTorchCorrection;
import androidx.camera.camera2.impl.CapturePipelineImpl;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import t.InterfaceC5495w;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b'\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Ls/C;", "", Const.INTENT_KEY_APIKEY, "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: s.C, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC5421C {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\n\u001a\u00020\t2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004H\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Ls/C$a;", "", "<init>", "()V", "LX8/a;", "Landroidx/camera/camera2/impl/CapturePipelineImpl;", "capturePipelineImplProvider", "Landroidx/camera/camera2/compat/workaround/CapturePipelineTorchCorrection;", "capturePipelineTorchCorrectionProvider", "Lt/w;", Const.INTENT_KEY_APIKEY, "(LX8/a;LX8/a;)Lt/w;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: s.C$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final InterfaceC5495w a(X8.a<CapturePipelineImpl> capturePipelineImplProvider, X8.a<CapturePipelineTorchCorrection> capturePipelineTorchCorrectionProvider) {
            kotlin.jvm.internal.p.i(capturePipelineImplProvider, "capturePipelineImplProvider");
            kotlin.jvm.internal.p.i(capturePipelineTorchCorrectionProvider, "capturePipelineTorchCorrectionProvider");
            if (CapturePipelineTorchCorrection.INSTANCE.a()) {
                CapturePipelineTorchCorrection capturePipelineTorchCorrection = capturePipelineTorchCorrectionProvider.get();
                kotlin.jvm.internal.p.h(capturePipelineTorchCorrection, "get(...)");
                return capturePipelineTorchCorrection;
            }
            CapturePipelineImpl capturePipelineImpl = capturePipelineImplProvider.get();
            kotlin.jvm.internal.p.h(capturePipelineImpl, "get(...)");
            return capturePipelineImpl;
        }

        public Companion() {
        }
    }
}
