package S;

import androidx.camera.core.UseCase;
import androidx.camera.core.internal.compat.quirk.ImageCaptureFailedForSpecificCombinationQuirk;
import androidx.camera.core.internal.compat.quirk.PreviewGreenTintQuirk;
import java.util.Collection;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public final ImageCaptureFailedForSpecificCombinationQuirk f5637a = (ImageCaptureFailedForSpecificCombinationQuirk) R.c.b(ImageCaptureFailedForSpecificCombinationQuirk.class);

    /* renamed from: b, reason: collision with root package name */
    public final PreviewGreenTintQuirk f5638b = (PreviewGreenTintQuirk) R.c.b(PreviewGreenTintQuirk.class);

    public boolean a(String str, Collection<UseCase> collection) {
        ImageCaptureFailedForSpecificCombinationQuirk imageCaptureFailedForSpecificCombinationQuirk = this.f5637a;
        if (imageCaptureFailedForSpecificCombinationQuirk != null) {
            return imageCaptureFailedForSpecificCombinationQuirk.g(str, collection);
        }
        if (this.f5638b != null) {
            return PreviewGreenTintQuirk.e(str, collection);
        }
        return false;
    }
}
