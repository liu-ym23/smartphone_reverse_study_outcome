package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import com.lynx.serval.svg.SVGRenderEngine;
import java.util.List;
import kotlin.Metadata;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0018\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH&J\u001a\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\fH&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\fH&J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH&J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\fH\u0016J\u0017\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0019H&¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00072\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010!J9\u0010\u001c\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\f2\b\b\u0002\u0010\u001e\u001a\u00020\u001fH&¢\u0006\u0004\b&\u0010'J!\u0010(\u001a\u00020\u00032\u0006\u0010)\u001a\u00020*2\b\b\u0002\u0010\u001e\u001a\u00020\u001fH&¢\u0006\u0004\b+\u0010,J'\u0010-\u001a\u00020\u00032\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/2\u0006\u0010\b\u001a\u00020\tH&¢\u0006\u0004\b1\u00102J\u0018\u00103\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J0\u00103\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\tH&J@\u00104\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\f2\u0006\u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\tH&J\u0018\u00107\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J0\u00107\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\tH&J'\u00108\u001a\u00020\u00032\u0006\u00109\u001a\u00020/2\u0006\u0010:\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\tH&¢\u0006\u0004\b;\u0010<J0\u0010=\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\f2\u0006\u0010?\u001a\u00020\f2\u0006\u0010@\u001a\u00020A2\u0006\u0010\b\u001a\u00020\tH\u0016JH\u0010=\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\f2\u0006\u0010>\u001a\u00020\f2\u0006\u0010?\u001a\u00020\f2\u0006\u0010@\u001a\u00020A2\u0006\u0010\b\u001a\u00020\tH&J0\u0010B\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010C\u001a\u00020\f2\u0006\u0010D\u001a\u00020\f2\u0006\u0010@\u001a\u00020A2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010E\u001a\u00020\u00032\u0006\u0010)\u001a\u00020*2\u0006\u0010\b\u001a\u00020\tH&J'\u0010F\u001a\u00020\u00032\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020/2\u0006\u0010\b\u001a\u00020\tH&¢\u0006\u0004\bJ\u0010KJG\u0010L\u001a\u00020\u00032\u0006\u0010G\u001a\u00020H2\b\b\u0002\u0010M\u001a\u00020N2\b\b\u0002\u0010O\u001a\u00020P2\b\b\u0002\u0010Q\u001a\u00020N2\b\b\u0002\u0010R\u001a\u00020P2\u0006\u0010\b\u001a\u00020\tH&¢\u0006\u0004\bS\u0010TJ-\u0010U\u001a\u00020\u00032\u0006\u0010V\u001a\u00020W2\f\u0010X\u001a\b\u0012\u0004\u0012\u00020/0Y2\u0006\u0010\b\u001a\u00020\tH&¢\u0006\u0004\bZ\u0010[J'\u0010\\\u001a\u00020\u00032\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020]2\u0006\u0010\b\u001a\u00020\tH&¢\u0006\u0004\b^\u0010_J'\u0010`\u001a\u00020\u00032\u0006\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020d2\u0006\u0010\b\u001a\u00020\tH&¢\u0006\u0004\be\u0010fJ\b\u0010g\u001a\u00020\u0003H&J\b\u0010h\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006iÀ\u0006\u0003"}, d2 = {"Landroidx/compose/ui/graphics/Canvas;", "", SVGRenderEngine.SAVE, "", SVGRenderEngine.RESTORE, "saveLayer", "bounds", "Landroidx/compose/ui/geometry/Rect;", "paint", "Landroidx/compose/ui/graphics/Paint;", "translate", "dx", "", "dy", "scale", "sx", "sy", "rotate", "degrees", "skew", "skewRad", "sxRad", "syRad", "concat", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "concat-58bKbWc", "([F)V", "clipRect", SVGRenderEngine.RECT, "clipOp", "Landroidx/compose/ui/graphics/ClipOp;", "clipRect-mtrdD-E", "(Landroidx/compose/ui/geometry/Rect;I)V", "left", "top", "right", "bottom", "clipRect-N_I0leg", "(FFFFI)V", SVGRenderEngine.CLIP_PATH, "path", "Landroidx/compose/ui/graphics/Path;", "clipPath-mtrdD-E", "(Landroidx/compose/ui/graphics/Path;I)V", "drawLine", "p1", "Landroidx/compose/ui/geometry/Offset;", "p2", "drawLine-Wko1d7g", "(JJLandroidx/compose/ui/graphics/Paint;)V", "drawRect", "drawRoundRect", "radiusX", "radiusY", "drawOval", "drawCircle", "center", "radius", "drawCircle-9KIMszo", "(JFLandroidx/compose/ui/graphics/Paint;)V", "drawArc", "startAngle", "sweepAngle", "useCenter", "", "drawArcRad", "startAngleRad", "sweepAngleRad", "drawPath", "drawImage", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "topLeftOffset", "drawImage-d-4ec7I", "(Landroidx/compose/ui/graphics/ImageBitmap;JLandroidx/compose/ui/graphics/Paint;)V", "drawImageRect", "srcOffset", "Landroidx/compose/ui/unit/IntOffset;", "srcSize", "Landroidx/compose/ui/unit/IntSize;", "dstOffset", "dstSize", "drawImageRect-HPBpro0", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJLandroidx/compose/ui/graphics/Paint;)V", "drawPoints", "pointMode", "Landroidx/compose/ui/graphics/PointMode;", "points", "", "drawPoints-O7TthRY", "(ILjava/util/List;Landroidx/compose/ui/graphics/Paint;)V", "drawRawPoints", "", "drawRawPoints-O7TthRY", "(I[FLandroidx/compose/ui/graphics/Paint;)V", "drawVertices", "vertices", "Landroidx/compose/ui/graphics/Vertices;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "drawVertices-TPEHhCM", "(Landroidx/compose/ui/graphics/Vertices;ILandroidx/compose/ui/graphics/Paint;)V", "enableZ", "disableZ", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface Canvas {

    /* JADX INFO: renamed from: androidx.compose.ui.graphics.Canvas$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        /* JADX INFO: renamed from: $default$clipRect-mtrdD-E, reason: not valid java name */
        public static void m4797$default$clipRectmtrdDE(Canvas r100, Rect r101, int r102) {
            r100.mo4677clipRectN_I0leg(r101.getLeft(), r101.getTop(), r101.getRight(), r101.getBottom(), r102);
        }

        public static void $default$drawOval(Canvas r100, Rect r101, Paint r102) {
            r100.drawOval(r101.getLeft(), r101.getTop(), r101.getRight(), r101.getBottom(), r102);
        }

        public static void $default$drawRect(Canvas r100, Rect r101, Paint r102) {
            r100.drawRect(r101.getLeft(), r101.getTop(), r101.getRight(), r101.getBottom(), r102);
        }

        public static void $default$skewRad(Canvas r100, float r101, float r102) {
            r100.skew(DegreesKt.degrees(r101), DegreesKt.degrees(r102));
        }

        /* JADX INFO: renamed from: access$clipRect-mtrdD-E$jd, reason: not valid java name */
        public static /* synthetic */ void m4798access$clipRectmtrdDE$jd(Canvas r100, Rect r101, int r102) {
            m4797$default$clipRectmtrdDE(r100, r101, r102);
        }

        public static /* synthetic */ void access$drawOval$jd(Canvas r100, Rect r101, Paint r102) {
            $default$drawOval(r100, r101, r102);
        }

        public static /* synthetic */ void access$drawRect$jd(Canvas r100, Rect r101, Paint r102) {
            $default$drawRect(r100, r101, r102);
        }

        public static /* synthetic */ void access$skewRad$jd(Canvas r100, float r101, float r102) {
            $default$skewRad(r100, r101, r102);
        }

        /* JADX INFO: renamed from: clipPath-mtrdD-E$default, reason: not valid java name */
        public static /* synthetic */ void m4799clipPathmtrdDE$default(Canvas r100, Path r101, int r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = ClipOp.Companion.m4816getIntersectrtfAjoo();
        L6:
            r100.mo4676clipPathmtrdDE(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clipPath-mtrdD-E");
        }

        /* JADX INFO: renamed from: clipRect-mtrdD-E$default, reason: not valid java name */
        public static /* synthetic */ void m4801clipRectmtrdDE$default(Canvas r100, Rect r101, int r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = ClipOp.Companion.m4816getIntersectrtfAjoo();
        L6:
            r100.mo4678clipRectmtrdDE(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clipRect-mtrdD-E");
        }

        public static /* synthetic */ void scale$default(Canvas r100, float r101, float r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = r101;
        L6:
            r100.scale(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scale");
        }

        public static void $default$drawArc(Canvas r100, Rect r110, float r111, float r112, boolean r113, Paint r114) {
            r100.drawArc(r110.getLeft(), r110.getTop(), r110.getRight(), r110.getBottom(), r111, r112, r113, r114);
        }

        public static void $default$drawArcRad(Canvas r100, Rect r101, float r102, float r103, boolean r110, Paint r111) {
            r100.drawArc(r101, DegreesKt.degrees(r102), DegreesKt.degrees(r103), r110, r111);
        }

        public static /* synthetic */ void access$drawArc$jd(Canvas r100, Rect r101, float r102, float r103, boolean r104, Paint r105) {
            $default$drawArc(r100, r101, r102, r103, r104, r105);
        }

        public static /* synthetic */ void access$drawArcRad$jd(Canvas r100, Rect r101, float r102, float r103, boolean r104, Paint r105) {
            $default$drawArcRad(r100, r101, r102, r103, r104, r105);
        }

        /* JADX INFO: renamed from: clipRect-N_I0leg$default, reason: not valid java name */
        public static /* synthetic */ void m4800clipRectN_I0leg$default(Canvas r100, float r101, float r102, float r103, float r110, int r111, int r112, Object r113) {
            if (r113 != null) goto L9;
            if ((r112 & 16) == 0) goto L6;
            r111 = ClipOp.Companion.m4816getIntersectrtfAjoo();
        L6:
            r100.mo4677clipRectN_I0leg(r101, r102, r103, r110, r111);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clipRect-N_I0leg");
        }

        /* JADX INFO: renamed from: drawImageRect-HPBpro0$default, reason: not valid java name */
        public static /* synthetic */ void m4802drawImageRectHPBpro0$default(Canvas r110, ImageBitmap r111, long r112, long r113, long r114, long r210, Paint r211, int r212, Object r213) {
            if (r213 != null) goto L22;
            if ((r212 & 2) == 0) goto L6;
            long r100 = IntOffset.Companion.m7687getZeronOccac();
        L8:
            if ((r212 & 4) == 0) goto L10;
            int r101 = r111.getWidth();
            long r102 = ((long) r101) << 32;
            long r103 = IntSize.m7714constructorimpl((((long) r111.getHeight()) & BodyPartID.bodyIdMax) | r102);
        L12:
            if ((r212 & 8) == 0) goto L14;
            long r104 = IntOffset.Companion.m7687getZeronOccac();
        L16:
            if ((r212 & 16) == 0) goto L18;
            long r115 = r103;
        L19:
            r110.mo4682drawImageRectHPBpro0(r111, r100, r103, r104, r115, r211);
            return;
        L18:
            r115 = r210;
            goto L19
        L14:
            r104 = r114;
            goto L16
        L10:
            r103 = r113;
            goto L12
        L6:
            r100 = r112;
            goto L8
        L22:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawImageRect-HPBpro0");
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        /* JADX INFO: renamed from: clipRect-mtrdD-E, reason: not valid java name */
        public static void m4805clipRectmtrdDE(Canvas r100, Rect r101, int r102) {
            CC.m4798access$clipRectmtrdDE$jd(r100, r101, r102);
        }

        public static void drawOval(Canvas r100, Rect r101, Paint r102) {
            CC.access$drawOval$jd(r100, r101, r102);
        }

        public static void drawRect(Canvas r100, Rect r101, Paint r102) {
            CC.access$drawRect$jd(r100, r101, r102);
        }

        public static void skewRad(Canvas r100, float r101, float r102) {
            CC.access$skewRad$jd(r100, r101, r102);
        }

        /* JADX INFO: renamed from: clipPath-mtrdD-E$default, reason: not valid java name */
        public static /* synthetic */ void m4803clipPathmtrdDE$default(Canvas r100, Path r101, int r102, int r103, Object r104) {
            CC.m4799clipPathmtrdDE$default(r100, r101, r102, r103, r104);
        }

        /* JADX INFO: renamed from: clipRect-mtrdD-E$default, reason: not valid java name */
        public static /* synthetic */ void m4806clipRectmtrdDE$default(Canvas r100, Rect r101, int r102, int r103, Object r104) {
            CC.m4801clipRectmtrdDE$default(r100, r101, r102, r103, r104);
        }

        public static /* synthetic */ void scale$default(Canvas r100, float r101, float r102, int r103, Object r104) {
            CC.scale$default(r100, r101, r102, r103, r104);
        }

        public static void drawArc(Canvas r100, Rect r101, float r102, float r103, boolean r104, Paint r105) {
            CC.access$drawArc$jd(r100, r101, r102, r103, r104, r105);
        }

        public static void drawArcRad(Canvas r100, Rect r101, float r102, float r103, boolean r104, Paint r105) {
            CC.access$drawArcRad$jd(r100, r101, r102, r103, r104, r105);
        }

        /* JADX INFO: renamed from: clipRect-N_I0leg$default, reason: not valid java name */
        public static /* synthetic */ void m4804clipRectN_I0leg$default(Canvas r100, float r101, float r102, float r103, float r104, int r105, int r106, Object r107) {
            CC.m4800clipRectN_I0leg$default(r100, r101, r102, r103, r104, r105, r106, r107);
        }

        /* JADX INFO: renamed from: drawImageRect-HPBpro0$default, reason: not valid java name */
        public static /* synthetic */ void m4807drawImageRectHPBpro0$default(Canvas r100, ImageBitmap r101, long r102, long r103, long r104, long r105, Paint r110, int r111, Object r112) {
            CC.m4802drawImageRectHPBpro0$default(r100, r101, r102, r103, r104, r105, r110, r111, r112);
        }
    }

    /* JADX INFO: renamed from: clipPath-mtrdD-E */
    void mo4676clipPathmtrdDE(Path r100, int r101);

    /* JADX INFO: renamed from: clipRect-N_I0leg */
    void mo4677clipRectN_I0leg(float r100, float r101, float r102, float r103, int r104);

    /* JADX INFO: renamed from: clipRect-mtrdD-E */
    void mo4678clipRectmtrdDE(Rect r100, int r101);

    /* JADX INFO: renamed from: concat-58bKbWc */
    void mo4679concat58bKbWc(float[] r100);

    void disableZ();

    void drawArc(float r100, float r101, float r102, float r103, float r104, float r105, boolean r106, Paint r107);

    void drawArc(Rect r100, float r101, float r102, boolean r103, Paint r104);

    void drawArcRad(Rect r100, float r101, float r102, boolean r103, Paint r104);

    /* JADX INFO: renamed from: drawCircle-9KIMszo */
    void mo4680drawCircle9KIMszo(long r100, float r101, Paint r102);

    /* JADX INFO: renamed from: drawImage-d-4ec7I */
    void mo4681drawImaged4ec7I(ImageBitmap r100, long r101, Paint r102);

    /* JADX INFO: renamed from: drawImageRect-HPBpro0 */
    void mo4682drawImageRectHPBpro0(ImageBitmap r100, long r101, long r102, long r103, long r104, Paint r110);

    /* JADX INFO: renamed from: drawLine-Wko1d7g */
    void mo4683drawLineWko1d7g(long r100, long r101, Paint r102);

    void drawOval(float r100, float r101, float r102, float r103, Paint r104);

    void drawOval(Rect r100, Paint r101);

    void drawPath(Path r100, Paint r101);

    /* JADX INFO: renamed from: drawPoints-O7TthRY */
    void mo4684drawPointsO7TthRY(int r100, List<Offset> r101, Paint r102);

    /* JADX INFO: renamed from: drawRawPoints-O7TthRY */
    void mo4685drawRawPointsO7TthRY(int r100, float[] r101, Paint r102);

    void drawRect(float r100, float r101, float r102, float r103, Paint r104);

    void drawRect(Rect r100, Paint r101);

    void drawRoundRect(float r100, float r101, float r102, float r103, float r104, float r105, Paint r106);

    /* JADX INFO: renamed from: drawVertices-TPEHhCM */
    void mo4686drawVerticesTPEHhCM(Vertices r100, int r101, Paint r102);

    void enableZ();

    void restore();

    void rotate(float r100);

    void save();

    void saveLayer(Rect r100, Paint r101);

    void scale(float r100, float r101);

    void skew(float r100, float r101);

    void skewRad(float r100, float r101);

    void translate(float r100, float r101);
}
