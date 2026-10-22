package R;

import K.s0;
import K.t0;
import androidx.camera.core.internal.compat.quirk.CaptureFailedRetryQuirk;
import androidx.camera.core.internal.compat.quirk.ImageCaptureFailedForSpecificCombinationQuirk;
import androidx.camera.core.internal.compat.quirk.ImageCaptureRotationOptionQuirk;
import androidx.camera.core.internal.compat.quirk.IncorrectJpegMetadataQuirk;
import androidx.camera.core.internal.compat.quirk.LargeJpegImageQuirk;
import androidx.camera.core.internal.compat.quirk.LowMemoryQuirk;
import androidx.camera.core.internal.compat.quirk.PreviewGreenTintQuirk;
import androidx.camera.core.internal.compat.quirk.SurfaceOrderQuirk;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class d {
    public static List<s0> a(t0 t0Var) {
        ArrayList arrayList = new ArrayList();
        if (t0Var.a(ImageCaptureRotationOptionQuirk.class, ImageCaptureRotationOptionQuirk.f())) {
            arrayList.add(new ImageCaptureRotationOptionQuirk());
        }
        if (t0Var.a(SurfaceOrderQuirk.class, SurfaceOrderQuirk.c())) {
            arrayList.add(new SurfaceOrderQuirk());
        }
        if (t0Var.a(CaptureFailedRetryQuirk.class, CaptureFailedRetryQuirk.d())) {
            arrayList.add(new CaptureFailedRetryQuirk());
        }
        if (t0Var.a(LowMemoryQuirk.class, LowMemoryQuirk.c())) {
            arrayList.add(new LowMemoryQuirk());
        }
        if (t0Var.a(LargeJpegImageQuirk.class, LargeJpegImageQuirk.f())) {
            arrayList.add(new LargeJpegImageQuirk());
        }
        if (t0Var.a(IncorrectJpegMetadataQuirk.class, IncorrectJpegMetadataQuirk.g())) {
            arrayList.add(new IncorrectJpegMetadataQuirk());
        }
        if (t0Var.a(ImageCaptureFailedForSpecificCombinationQuirk.class, ImageCaptureFailedForSpecificCombinationQuirk.f())) {
            arrayList.add(new ImageCaptureFailedForSpecificCombinationQuirk());
        }
        if (t0Var.a(PreviewGreenTintQuirk.class, PreviewGreenTintQuirk.d())) {
            arrayList.add(PreviewGreenTintQuirk.f11601b);
        }
        return arrayList;
    }
}
