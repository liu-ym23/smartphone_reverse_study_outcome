package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Path;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.lynx.serval.svg.SVGRenderEngine;
import kotlin.Metadata;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@DrawScopeMarker
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH&JA\u0010\u0010\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0011\u001a\u00020\u0012H&¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0011\u001a\u00020\u0012H&¢\u0006\u0004\b\u0018\u0010\u0019J\u001c\u0010\u001a\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\fH&J!\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\f2\b\b\u0002\u0010\u001d\u001a\u00020\u0007H&¢\u0006\u0004\b\u001e\u0010\u001fJ)\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\f2\b\b\u0002\u0010\u001d\u001a\u00020\u0007H&¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020'H&¢\u0006\u0004\b(\u0010)R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006*À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/graphics/drawscope/DrawTransform;", "", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "()J", "center", "Landroidx/compose/ui/geometry/Offset;", "getCenter-F1C5BW0", "inset", "", "left", "", "top", "right", "bottom", "clipRect", "clipOp", "Landroidx/compose/ui/graphics/ClipOp;", "clipRect-N_I0leg", "(FFFFI)V", SVGRenderEngine.CLIP_PATH, "path", "Landroidx/compose/ui/graphics/Path;", "clipPath-mtrdD-E", "(Landroidx/compose/ui/graphics/Path;I)V", "translate", "rotate", "degrees", "pivot", "rotate-Uv8p0NA", "(FJ)V", "scale", LiveDegradeFpsAnimator.SCALE_X, LiveDegradeFpsAnimator.SCALE_Y, "scale-0AR0LA0", "(FFJ)V", "transform", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "transform-58bKbWc", "([F)V", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface DrawTransform {

    /* JADX INFO: renamed from: androidx.compose.ui.graphics.drawscope.DrawTransform$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        /* JADX INFO: renamed from: $default$getCenter-F1C5BW0, reason: not valid java name */
        public static long m5464$default$getCenterF1C5BW0(DrawTransform r100) {
            float r101 = Float.intBitsToFloat((int) (r100.mo5334getSizeNHjbRc() >> 32));
            float r102 = 2;
            float r103 = Float.intBitsToFloat((int) (r100.mo5334getSizeNHjbRc() & BodyPartID.bodyIdMax)) / r102;
            return Offset.m4574constructorimpl((Float.floatToRawIntBits(r101 / r102) << 32) | (((long) Float.floatToRawIntBits(r103)) & BodyPartID.bodyIdMax));
        }

        /* JADX INFO: renamed from: access$getCenter-F1C5BW0$jd, reason: not valid java name */
        public static /* synthetic */ long m5465access$getCenterF1C5BW0$jd(DrawTransform r100) {
            return m5464$default$getCenterF1C5BW0(r100);
        }

        /* JADX INFO: renamed from: clipPath-mtrdD-E$default, reason: not valid java name */
        public static /* synthetic */ void m5466clipPathmtrdDE$default(DrawTransform r100, Path r101, int r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = ClipOp.Companion.m4816getIntersectrtfAjoo();
        L6:
            r100.mo5331clipPathmtrdDE(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clipPath-mtrdD-E");
        }

        /* JADX INFO: renamed from: rotate-Uv8p0NA$default, reason: not valid java name */
        public static /* synthetic */ void m5468rotateUv8p0NA$default(DrawTransform r100, float r101, long r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = r100.mo5333getCenterF1C5BW0();
        L6:
            r100.mo5335rotateUv8p0NA(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: rotate-Uv8p0NA");
        }

        public static /* synthetic */ void translate$default(DrawTransform r100, float r101, float r102, int r103, Object r104) {
            if (r104 != null) goto L12;
            if ((r103 & 1) == 0) goto L7;
            r101 = 0.0f;
        L7:
            if ((r103 & 2) == 0) goto L9;
            r102 = 0.0f;
        L9:
            r100.translate(r101, r102);
            return;
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: translate");
        }

        /* JADX INFO: renamed from: scale-0AR0LA0$default, reason: not valid java name */
        public static /* synthetic */ void m5469scale0AR0LA0$default(DrawTransform r100, float r101, float r102, long r103, int r104, Object r105) {
            if (r105 != null) goto L9;
            if ((r104 & 4) == 0) goto L6;
            r103 = r100.mo5333getCenterF1C5BW0();
        L6:
            r100.mo5336scale0AR0LA0(r101, r102, r103);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scale-0AR0LA0");
        }

        /* JADX INFO: renamed from: clipRect-N_I0leg$default, reason: not valid java name */
        public static /* synthetic */ void m5467clipRectN_I0leg$default(DrawTransform r100, float r101, float r102, float r103, float r104, int r105, int r110, Object r111) {
            if (r111 != null) goto L21;
            if ((r110 & 1) == 0) goto L7;
            r101 = 0.0f;
        L7:
            if ((r110 & 2) == 0) goto L10;
            r102 = 0.0f;
        L10:
            if ((r110 & 4) == 0) goto L13;
            r103 = Float.intBitsToFloat((int) (r100.mo5334getSizeNHjbRc() >> 32));
        L13:
            if ((r110 & 8) == 0) goto L16;
            r104 = Float.intBitsToFloat((int) (r100.mo5334getSizeNHjbRc() & BodyPartID.bodyIdMax));
        L16:
            if ((r110 & 16) == 0) goto L18;
            r105 = ClipOp.Companion.m4816getIntersectrtfAjoo();
        L18:
            r100.mo5332clipRectN_I0leg(r101, r102, r103, r104, r105);
            return;
        L21:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clipRect-N_I0leg");
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        /* JADX INFO: renamed from: getCenter-F1C5BW0, reason: not valid java name */
        public static long m5472getCenterF1C5BW0(DrawTransform r100) {
            return CC.m5465access$getCenterF1C5BW0$jd(r100);
        }

        /* JADX INFO: renamed from: clipPath-mtrdD-E$default, reason: not valid java name */
        public static /* synthetic */ void m5470clipPathmtrdDE$default(DrawTransform r100, Path r101, int r102, int r103, Object r104) {
            CC.m5466clipPathmtrdDE$default(r100, r101, r102, r103, r104);
        }

        /* JADX INFO: renamed from: rotate-Uv8p0NA$default, reason: not valid java name */
        public static /* synthetic */ void m5473rotateUv8p0NA$default(DrawTransform r100, float r101, long r102, int r103, Object r104) {
            CC.m5468rotateUv8p0NA$default(r100, r101, r102, r103, r104);
        }

        public static /* synthetic */ void translate$default(DrawTransform r100, float r101, float r102, int r103, Object r104) {
            CC.translate$default(r100, r101, r102, r103, r104);
        }

        /* JADX INFO: renamed from: scale-0AR0LA0$default, reason: not valid java name */
        public static /* synthetic */ void m5474scale0AR0LA0$default(DrawTransform r100, float r101, float r102, long r103, int r104, Object r105) {
            CC.m5469scale0AR0LA0$default(r100, r101, r102, r103, r104, r105);
        }

        /* JADX INFO: renamed from: clipRect-N_I0leg$default, reason: not valid java name */
        public static /* synthetic */ void m5471clipRectN_I0leg$default(DrawTransform r100, float r101, float r102, float r103, float r104, int r105, int r106, Object r107) {
            CC.m5467clipRectN_I0leg$default(r100, r101, r102, r103, r104, r105, r106, r107);
        }
    }

    /* JADX INFO: renamed from: clipPath-mtrdD-E */
    void mo5331clipPathmtrdDE(Path r100, int r101);

    /* JADX INFO: renamed from: clipRect-N_I0leg */
    void mo5332clipRectN_I0leg(float r100, float r101, float r102, float r103, int r104);

    /* JADX INFO: renamed from: getCenter-F1C5BW0 */
    long mo5333getCenterF1C5BW0();

    /* JADX INFO: renamed from: getSize-NH-jbRc */
    long mo5334getSizeNHjbRc();

    void inset(float r100, float r101, float r102, float r103);

    /* JADX INFO: renamed from: rotate-Uv8p0NA */
    void mo5335rotateUv8p0NA(float r100, long r101);

    /* JADX INFO: renamed from: scale-0AR0LA0 */
    void mo5336scale0AR0LA0(float r100, float r101, long r102);

    /* JADX INFO: renamed from: transform-58bKbWc */
    void mo5337transform58bKbWc(float[] r100);

    void translate(float r100, float r101);
}
