package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"lerp", "Landroidx/compose/ui/graphics/Shadow;", "start", "stop", "fraction", "", "ui-graphics_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ShadowKt {
    public static final Shadow lerp(Shadow r100, Shadow r101, float r110) {
        return new Shadow(ColorKt.m4878lerpjxsXWHM(r100.m5176getColor0d7_KjU(), r101.m5176getColor0d7_KjU(), r110), OffsetKt.m4605lerpWko1d7g(r100.m5177getOffsetF1C5BW0(), r101.m5177getOffsetF1C5BW0(), r110), MathHelpersKt.lerp(r100.getBlurRadius(), r101.getBlurRadius(), r110), null);
    }
}
