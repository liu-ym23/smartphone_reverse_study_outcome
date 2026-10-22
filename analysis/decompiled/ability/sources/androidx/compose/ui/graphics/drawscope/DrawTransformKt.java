package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.graphics.DegreesKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a(\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0001H\u0086\b¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001c\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0001H\u0086\b¢\u0006\u0004\b\u0005\u0010\u0007\u001a&\u0010\r\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\tH\u0086\b¢\u0006\u0004\b\u000b\u0010\f\u001a&\u0010\u000e\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\tH\u0086\b¢\u0006\u0004\b\u000f\u0010\f¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/graphics/drawscope/DrawTransform;", "", "horizontal", "vertical", "LC7/r;", "inset", "(Landroidx/compose/ui/graphics/drawscope/DrawTransform;FF)V", "(Landroidx/compose/ui/graphics/drawscope/DrawTransform;F)V", "radians", "Landroidx/compose/ui/geometry/Offset;", "pivot", "rotateRad-0AR0LA0", "(Landroidx/compose/ui/graphics/drawscope/DrawTransform;FJ)V", "rotateRad", "scale", "scale-0AR0LA0", "ui-graphics_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DrawTransformKt {
    public static final void inset(DrawTransform drawTransform, float f, float f7) {
        drawTransform.inset(f, f7, f, f7);
    }

    public static /* synthetic */ void inset$default(DrawTransform drawTransform, float f, float f7, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f7 = 0.0f;
        }
        drawTransform.inset(f, f7, f, f7);
    }

    /* renamed from: rotateRad-0AR0LA0, reason: not valid java name */
    public static final void m4772rotateRad0AR0LA0(DrawTransform drawTransform, float f, long j5) {
        drawTransform.mo4634rotateUv8p0NA(DegreesKt.degrees(f), j5);
    }

    /* renamed from: rotateRad-0AR0LA0$default, reason: not valid java name */
    public static /* synthetic */ void m4773rotateRad0AR0LA0$default(DrawTransform drawTransform, float f, long j5, int i, Object obj) {
        if ((i & 2) != 0) {
            j5 = drawTransform.mo4632getCenterF1C5BW0();
        }
        drawTransform.mo4634rotateUv8p0NA(DegreesKt.degrees(f), j5);
    }

    /* renamed from: scale-0AR0LA0, reason: not valid java name */
    public static final void m4774scale0AR0LA0(DrawTransform drawTransform, float f, long j5) {
        drawTransform.mo4635scale0AR0LA0(f, f, j5);
    }

    /* renamed from: scale-0AR0LA0$default, reason: not valid java name */
    public static /* synthetic */ void m4775scale0AR0LA0$default(DrawTransform drawTransform, float f, long j5, int i, Object obj) {
        if ((i & 2) != 0) {
            j5 = drawTransform.mo4632getCenterF1C5BW0();
        }
        drawTransform.mo4635scale0AR0LA0(f, f, j5);
    }

    public static final void inset(DrawTransform drawTransform, float f) {
        drawTransform.inset(f, f, f, f);
    }
}
