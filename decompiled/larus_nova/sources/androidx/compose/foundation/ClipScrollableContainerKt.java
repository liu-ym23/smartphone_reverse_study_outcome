package androidx.compose.foundation;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.unit.Dp;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\"\u0016\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"clipScrollableContainer", "Landroidx/compose/ui/Modifier;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "MaxSupportedElevation", "Landroidx/compose/ui/unit/Dp;", "getMaxSupportedElevation", "()F", FaceService.girlLabel, "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ClipScrollableContainerKt {
    private static final float MaxSupportedElevation = 0.0f;

    static {
        MaxSupportedElevation = Dp.m7544constructorimpl(30);
    }

    public static final float getMaxSupportedElevation() {
        return MaxSupportedElevation;
    }

    public static final Modifier clipScrollableContainer(Modifier r100, Orientation r101) {
        if (r101 != Orientation.Vertical) goto L5;
        Modifier r102 = ClipKt.clip(Modifier.Companion, VerticalScrollableClipShape.INSTANCE);
    L7:
        return r100.then(r102);
    L5:
        r102 = ClipKt.clip(Modifier.Companion, HorizontalScrollableClipShape.INSTANCE);
        goto L7
    }
}
