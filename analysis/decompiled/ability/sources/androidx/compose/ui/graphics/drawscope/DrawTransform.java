package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Path;
import com.stepos.aiengine.args.SingleFileBundle;
import kotlin.Metadata;

@DrawScopeMarker
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J/\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\tJA\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0014\u001a\u00020\u00072\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0019\u0010\u001aJ)\u0010 \u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010%\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020!H&¢\u0006\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8&X¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0014\u0010+\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010(ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006,À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/graphics/drawscope/DrawTransform;", "", "", "left", "top", "right", "bottom", "LC7/r;", "inset", "(FFFF)V", "Landroidx/compose/ui/graphics/ClipOp;", "clipOp", "clipRect-N_I0leg", "(FFFFI)V", "clipRect", "Landroidx/compose/ui/graphics/Path;", SingleFileBundle.KEY_PATH, "clipPath-mtrdD-E", "(Landroidx/compose/ui/graphics/Path;I)V", "clipPath", "translate", "(FF)V", "degrees", "Landroidx/compose/ui/geometry/Offset;", "pivot", "rotate-Uv8p0NA", "(FJ)V", "rotate", "scaleX", "scaleY", "scale-0AR0LA0", "(FFJ)V", "scale", "Landroidx/compose/ui/graphics/Matrix;", "matrix", "transform-58bKbWc", "([F)V", "transform", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "()J", "size", "getCenter-F1C5BW0", "center", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public interface DrawTransform {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        /* renamed from: getCenter-F1C5BW0, reason: not valid java name */
        public static long m4769getCenterF1C5BW0(DrawTransform drawTransform) {
            return DrawTransform.super.mo4632getCenterF1C5BW0();
        }
    }

    /* renamed from: clipPath-mtrdD-E$default, reason: not valid java name */
    static /* synthetic */ void m4763clipPathmtrdDE$default(DrawTransform drawTransform, Path path, int i, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clipPath-mtrdD-E");
        }
        if ((i6 & 2) != 0) {
            i = ClipOp.INSTANCE.m4128getIntersectrtfAjoo();
        }
        drawTransform.mo4630clipPathmtrdDE(path, i);
    }

    /* renamed from: clipRect-N_I0leg$default, reason: not valid java name */
    static /* synthetic */ void m4764clipRectN_I0leg$default(DrawTransform drawTransform, float f, float f7, float f9, float f10, int i, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clipRect-N_I0leg");
        }
        if ((i6 & 1) != 0) {
            f = 0.0f;
        }
        if ((i6 & 2) != 0) {
            f7 = 0.0f;
        }
        if ((i6 & 4) != 0) {
            f9 = Float.intBitsToFloat((int) (drawTransform.mo4633getSizeNHjbRc() >> 32));
        }
        if ((i6 & 8) != 0) {
            f10 = Float.intBitsToFloat((int) (drawTransform.mo4633getSizeNHjbRc() & 4294967295L));
        }
        if ((i6 & 16) != 0) {
            i = ClipOp.INSTANCE.m4128getIntersectrtfAjoo();
        }
        drawTransform.mo4631clipRectN_I0leg(f, f7, f9, f10, i);
    }

    /* renamed from: rotate-Uv8p0NA$default, reason: not valid java name */
    static /* synthetic */ void m4765rotateUv8p0NA$default(DrawTransform drawTransform, float f, long j5, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: rotate-Uv8p0NA");
        }
        if ((i & 2) != 0) {
            j5 = drawTransform.mo4632getCenterF1C5BW0();
        }
        drawTransform.mo4634rotateUv8p0NA(f, j5);
    }

    /* renamed from: scale-0AR0LA0$default, reason: not valid java name */
    static /* synthetic */ void m4766scale0AR0LA0$default(DrawTransform drawTransform, float f, float f7, long j5, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scale-0AR0LA0");
        }
        if ((i & 4) != 0) {
            j5 = drawTransform.mo4632getCenterF1C5BW0();
        }
        drawTransform.mo4635scale0AR0LA0(f, f7, j5);
    }

    static /* synthetic */ void translate$default(DrawTransform drawTransform, float f, float f7, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: translate");
        }
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f7 = 0.0f;
        }
        drawTransform.translate(f, f7);
    }

    /* renamed from: clipPath-mtrdD-E */
    void mo4630clipPathmtrdDE(Path path, int clipOp);

    /* renamed from: clipRect-N_I0leg */
    void mo4631clipRectN_I0leg(float left, float top, float right, float bottom, int clipOp);

    /* renamed from: getCenter-F1C5BW0 */
    default long mo4632getCenterF1C5BW0() {
        float f = 2;
        float fIntBitsToFloat = Float.intBitsToFloat((int) (mo4633getSizeNHjbRc() >> 32)) / f;
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (mo4633getSizeNHjbRc() & 4294967295L)) / f;
        return Offset.m3887constructorimpl((Float.floatToRawIntBits(fIntBitsToFloat) << 32) | (Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L));
    }

    /* renamed from: getSize-NH-jbRc */
    long mo4633getSizeNHjbRc();

    void inset(float left, float top, float right, float bottom);

    /* renamed from: rotate-Uv8p0NA */
    void mo4634rotateUv8p0NA(float degrees, long pivot);

    /* renamed from: scale-0AR0LA0 */
    void mo4635scale0AR0LA0(float scaleX, float scaleY, long pivot);

    /* renamed from: transform-58bKbWc */
    void mo4636transform58bKbWc(float[] matrix);

    void translate(float left, float top);
}
