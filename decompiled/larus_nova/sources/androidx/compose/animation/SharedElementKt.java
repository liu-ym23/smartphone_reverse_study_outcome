package androidx.compose.animation;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0019\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0000¢\u0006\u0002\u0010\b\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\t"}, d2 = {"targetBounds", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/animation/TargetData;", "getTargetBounds", "(Landroidx/compose/animation/TargetData;)Landroidx/compose/ui/geometry/Rect;", "calculateOffsetFromDirectManipulation", "Landroidx/compose/ui/geometry/Offset;", "animatedBounds", "(Landroidx/compose/animation/TargetData;Landroidx/compose/ui/geometry/Rect;)J", GXTemplateKey.GAIAX_ANIMATION}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SharedElementKt {
    public static final Rect getTargetBounds(TargetData r100) {
        return RectKt.m4622Recttz77jQw(Offset.m4587plusMKHz9U(r100.m121getInitialMfrOffsetF1C5BW0(), r100.m123getTargetStructuralOffsetF1C5BW0()), r100.m122getSizeNHjbRc());
    }

    public static final long calculateOffsetFromDirectManipulation(TargetData r100, Rect r101) {
        return Offset.m4587plusMKHz9U(Offset.m4586minusMKHz9U(r101.m4617getTopLeftF1C5BW0(), r100.m121getInitialMfrOffsetF1C5BW0()), r100.m120getCurrentMfrOffsetF1C5BW0());
    }
}
