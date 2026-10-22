package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Vertices;
import com.lynx.serval.svg.SVGRenderEngine;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u000eH\u0016J\u0018\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u0017\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ7\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020!H\u0016¢\u0006\u0004\b\"\u0010#J\u001f\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020&2\u0006\u0010 \u001a\u00020!H\u0016¢\u0006\u0004\b'\u0010(J'\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0004\b-\u0010.J0\u0010/\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0016J@\u00100\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u00101\u001a\u00020\u000e2\u0006\u00102\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0016J0\u00103\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0016J'\u00104\u001a\u00020\u00052\u0006\u00105\u001a\u00020+2\u0006\u00106\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0004\b7\u00108JH\u00109\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020\u000e2\u0006\u0010;\u001a\u00020\u000e2\u0006\u0010<\u001a\u00020=2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010>\u001a\u00020\u00052\u0006\u0010%\u001a\u00020&2\u0006\u0010\n\u001a\u00020\u000bH\u0016J'\u0010?\u001a\u00020\u00052\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020+2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0004\bC\u0010DJ?\u0010E\u001a\u00020\u00052\u0006\u0010@\u001a\u00020A2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020G2\u0006\u0010K\u001a\u00020I2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0004\bL\u0010MJ-\u0010N\u001a\u00020\u00052\u0006\u0010O\u001a\u00020P2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020+0R2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0004\bS\u0010TJ'\u0010U\u001a\u00020\u00052\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020V2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0004\bW\u0010XJ'\u0010Y\u001a\u00020\u00052\u0006\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020]2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0004\b^\u0010_J\b\u0010`\u001a\u00020\u0005H\u0016J\b\u0010a\u001a\u00020\u0005H\u0016¨\u0006b"}, d2 = {"Landroidx/compose/ui/graphics/drawscope/EmptyCanvas;", "Landroidx/compose/ui/graphics/Canvas;", "<init>", "()V", SVGRenderEngine.SAVE, "", SVGRenderEngine.RESTORE, "saveLayer", "bounds", "Landroidx/compose/ui/geometry/Rect;", "paint", "Landroidx/compose/ui/graphics/Paint;", "translate", "dx", "", "dy", "scale", "sx", "sy", "rotate", "degrees", "skew", "concat", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "concat-58bKbWc", "([F)V", "clipRect", "left", "top", "right", "bottom", "clipOp", "Landroidx/compose/ui/graphics/ClipOp;", "clipRect-N_I0leg", "(FFFFI)V", SVGRenderEngine.CLIP_PATH, "path", "Landroidx/compose/ui/graphics/Path;", "clipPath-mtrdD-E", "(Landroidx/compose/ui/graphics/Path;I)V", "drawLine", "p1", "Landroidx/compose/ui/geometry/Offset;", "p2", "drawLine-Wko1d7g", "(JJLandroidx/compose/ui/graphics/Paint;)V", "drawRect", "drawRoundRect", "radiusX", "radiusY", "drawOval", "drawCircle", "center", "radius", "drawCircle-9KIMszo", "(JFLandroidx/compose/ui/graphics/Paint;)V", "drawArc", "startAngle", "sweepAngle", "useCenter", "", "drawPath", "drawImage", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "topLeftOffset", "drawImage-d-4ec7I", "(Landroidx/compose/ui/graphics/ImageBitmap;JLandroidx/compose/ui/graphics/Paint;)V", "drawImageRect", "srcOffset", "Landroidx/compose/ui/unit/IntOffset;", "srcSize", "Landroidx/compose/ui/unit/IntSize;", "dstOffset", "dstSize", "drawImageRect-HPBpro0", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJLandroidx/compose/ui/graphics/Paint;)V", "drawPoints", "pointMode", "Landroidx/compose/ui/graphics/PointMode;", "points", "", "drawPoints-O7TthRY", "(ILjava/util/List;Landroidx/compose/ui/graphics/Paint;)V", "drawRawPoints", "", "drawRawPoints-O7TthRY", "(I[FLandroidx/compose/ui/graphics/Paint;)V", "drawVertices", "vertices", "Landroidx/compose/ui/graphics/Vertices;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "drawVertices-TPEHhCM", "(Landroidx/compose/ui/graphics/Vertices;ILandroidx/compose/ui/graphics/Paint;)V", "enableZ", "disableZ", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class EmptyCanvas implements Canvas {
    public static final EmptyCanvas INSTANCE = null;

    static {
        INSTANCE = new EmptyCanvas();
    }

    private EmptyCanvas() {
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: clipRect-mtrdD-E */
    public final /* synthetic */ void mo4678clipRectmtrdDE(Rect r100, int r101) {
        Canvas.CC.m4797$default$clipRectmtrdDE(this, r100, r101);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public final /* synthetic */ void drawArc(Rect r100, float r101, float r102, boolean r103, Paint r104) {
        Canvas.CC.$default$drawArc(this, r100, r101, r102, r103, r104);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public final /* synthetic */ void drawArcRad(Rect r100, float r101, float r102, boolean r103, Paint r104) {
        Canvas.CC.$default$drawArcRad(this, r100, r101, r102, r103, r104);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public final /* synthetic */ void drawOval(Rect r100, Paint r101) {
        Canvas.CC.$default$drawOval(this, r100, r101);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public final /* synthetic */ void drawRect(Rect r100, Paint r101) {
        Canvas.CC.$default$drawRect(this, r100, r101);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public final /* synthetic */ void skewRad(float r100, float r101) {
        Canvas.CC.$default$skewRad(this, r100, r101);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void disableZ() {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void enableZ() {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void restore() {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void save() {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: concat-58bKbWc */
    public void mo4679concat58bKbWc(float[] r100) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void rotate(float r100) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: clipPath-mtrdD-E */
    public void mo4676clipPathmtrdDE(Path r100, int r101) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void drawPath(Path r100, Paint r101) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void saveLayer(Rect r100, Paint r101) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void scale(float r100, float r101) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void skew(float r100, float r101) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void translate(float r100, float r101) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: drawCircle-9KIMszo */
    public void mo4680drawCircle9KIMszo(long r100, float r101, Paint r102) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: drawImage-d-4ec7I */
    public void mo4681drawImaged4ec7I(ImageBitmap r100, long r101, Paint r102) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: drawLine-Wko1d7g */
    public void mo4683drawLineWko1d7g(long r100, long r101, Paint r102) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: drawPoints-O7TthRY */
    public void mo4684drawPointsO7TthRY(int r100, List<Offset> r101, Paint r102) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: drawRawPoints-O7TthRY */
    public void mo4685drawRawPointsO7TthRY(int r100, float[] r101, Paint r102) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: drawVertices-TPEHhCM */
    public void mo4686drawVerticesTPEHhCM(Vertices r100, int r101, Paint r102) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: clipRect-N_I0leg */
    public void mo4677clipRectN_I0leg(float r100, float r101, float r102, float r103, int r104) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void drawOval(float r100, float r101, float r102, float r103, Paint r104) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void drawRect(float r100, float r101, float r102, float r103, Paint r104) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: drawImageRect-HPBpro0 */
    public void mo4682drawImageRectHPBpro0(ImageBitmap r100, long r101, long r102, long r103, long r104, Paint r110) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void drawRoundRect(float r100, float r101, float r102, float r103, float r104, float r105, Paint r106) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void drawArc(float r100, float r101, float r102, float r103, float r104, float r105, boolean r106, Paint r107) {
        throw new UnsupportedOperationException();
    }
}
