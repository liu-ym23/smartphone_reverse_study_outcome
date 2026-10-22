package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.graphics.DegreesKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a!\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0086\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0000\u001a\u00020\u0004H\u0086\b\u001a&\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\tH\u0086\b¢\u0006\u0004\b\n\u0010\u000b\u001a&\u0010\f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\tH\u0086\b¢\u0006\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"inset", "", "Landroidx/compose/ui/graphics/drawscope/DrawTransform;", "horizontal", "", "vertical", "rotateRad", "radians", "pivot", "Landroidx/compose/ui/geometry/Offset;", "rotateRad-0AR0LA0", "(Landroidx/compose/ui/graphics/drawscope/DrawTransform;FJ)V", "scale", "scale-0AR0LA0", "ui-graphics_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DrawTransformKt {
    public static final void inset(DrawTransform r100, float r101) {
        r100.inset(r101, r101, r101, r101);
    }

    public static final void inset(DrawTransform r100, float r101, float r102) {
        r100.inset(r101, r102, r101, r102);
    }

    /* JADX INFO: renamed from: rotateRad-0AR0LA0, reason: not valid java name */
    public static final void m5475rotateRad0AR0LA0(DrawTransform r100, float r101, long r102) {
        r100.mo5335rotateUv8p0NA(DegreesKt.degrees(r101), r102);
    }

    /* JADX INFO: renamed from: scale-0AR0LA0, reason: not valid java name */
    public static final void m5477scale0AR0LA0(DrawTransform r100, float r101, long r102) {
        r100.mo5336scale0AR0LA0(r101, r101, r102);
    }

    public static /* synthetic */ void inset$default(DrawTransform r100, float r101, float r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = 0.0f;
    L6:
        if ((r103 & 2) == 0) goto L8;
        r102 = 0.0f;
    L8:
        r100.inset(r101, r102, r101, r102);
    }

    /* JADX INFO: renamed from: rotateRad-0AR0LA0$default, reason: not valid java name */
    public static /* synthetic */ void m5476rotateRad0AR0LA0$default(DrawTransform r100, float r101, long r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = r100.mo5333getCenterF1C5BW0();
    L5:
        r100.mo5335rotateUv8p0NA(DegreesKt.degrees(r101), r102);
    }

    /* JADX INFO: renamed from: scale-0AR0LA0$default, reason: not valid java name */
    public static /* synthetic */ void m5478scale0AR0LA0$default(DrawTransform r100, float r101, long r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = r100.mo5333getCenterF1C5BW0();
    L5:
        r100.mo5336scale0AR0LA0(r101, r101, r102);
    }
}
