package androidx.compose.ui.graphics;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.Region;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.IntOffset;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.serval.svg.SVGRenderEngine;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0018\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0018\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u0019H\u0016J\u0010\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u0019H\u0016J\u0018\u0010 \u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u0019H\u0016J\u0017\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020#H\u0016¢\u0006\u0004\b$\u0010%J7\u0010&\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u00192\u0006\u0010+\u001a\u00020,H\u0016¢\u0006\u0004\b-\u0010.J\u001f\u0010/\u001a\u00020\u00102\u0006\u00100\u001a\u0002012\u0006\u0010+\u001a\u00020,H\u0016¢\u0006\u0004\b2\u00103J\u0011\u00104\u001a\u000205*\u00020,¢\u0006\u0004\b6\u00107J'\u00108\u001a\u00020\u00102\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020:2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016¢\u0006\u0004\b<\u0010=J0\u0010>\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J@\u0010?\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u00192\u0006\u0010@\u001a\u00020\u00192\u0006\u0010A\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J0\u0010B\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J'\u0010C\u001a\u00020\u00102\u0006\u0010D\u001a\u00020:2\u0006\u0010E\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u0016H\u0016¢\u0006\u0004\bF\u0010GJH\u0010H\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u00192\u0006\u0010I\u001a\u00020\u00192\u0006\u0010J\u001a\u00020\u00192\u0006\u0010K\u001a\u00020L2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010M\u001a\u00020\u00102\u0006\u00100\u001a\u0002012\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J'\u0010N\u001a\u00020\u00102\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020:2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016¢\u0006\u0004\bR\u0010SJ?\u0010T\u001a\u00020\u00102\u0006\u0010O\u001a\u00020P2\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020V2\u0006\u0010Z\u001a\u00020X2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016¢\u0006\u0004\b[\u0010\\J-\u0010]\u001a\u00020\u00102\u0006\u0010^\u001a\u00020_2\f\u0010`\u001a\b\u0012\u0004\u0012\u00020:0a2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016¢\u0006\u0004\bb\u0010cJ\b\u0010d\u001a\u00020\u0010H\u0016J\b\u0010e\u001a\u00020\u0010H\u0016J\u001e\u0010]\u001a\u00020\u00102\f\u0010`\u001a\b\u0012\u0004\u0012\u00020:0a2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J&\u0010f\u001a\u00020\u00102\f\u0010`\u001a\b\u0012\u0004\u0012\u00020:0a2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010g\u001a\u00020hH\u0002J'\u0010i\u001a\u00020\u00102\u0006\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020j2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016¢\u0006\u0004\bk\u0010lJ \u0010i\u001a\u00020\u00102\u0006\u0010`\u001a\u00020j2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010g\u001a\u00020hH\u0002J \u0010m\u001a\u00020\u00102\u0006\u0010`\u001a\u00020j2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010g\u001a\u00020hH\u0002J'\u0010n\u001a\u00020\u00102\u0006\u0010o\u001a\u00020p2\u0006\u0010q\u001a\u00020r2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016¢\u0006\u0004\bs\u0010tR(\u0010\u0004\u001a\u00060\u0005j\u0002`\u00068\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006u"}, d2 = {"Landroidx/compose/ui/graphics/AndroidCanvas;", "Landroidx/compose/ui/graphics/Canvas;", "<init>", "()V", "internalCanvas", "Landroid/graphics/Canvas;", "Landroidx/compose/ui/graphics/NativeCanvas;", "getInternalCanvas$annotations", "getInternalCanvas", "()Landroid/graphics/Canvas;", "setInternalCanvas", "(Landroid/graphics/Canvas;)V", "srcRect", "Landroid/graphics/Rect;", "dstRect", SVGRenderEngine.SAVE, "", SVGRenderEngine.RESTORE, "saveLayer", "bounds", "Landroidx/compose/ui/geometry/Rect;", "paint", "Landroidx/compose/ui/graphics/Paint;", "translate", "dx", "", "dy", "scale", "sx", "sy", "rotate", "degrees", "skew", "concat", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "concat-58bKbWc", "([F)V", "clipRect", "left", "top", "right", "bottom", "clipOp", "Landroidx/compose/ui/graphics/ClipOp;", "clipRect-N_I0leg", "(FFFFI)V", SVGRenderEngine.CLIP_PATH, "path", "Landroidx/compose/ui/graphics/Path;", "clipPath-mtrdD-E", "(Landroidx/compose/ui/graphics/Path;I)V", "toRegionOp", "Landroid/graphics/Region$Op;", "toRegionOp--7u2Bmg", "(I)Landroid/graphics/Region$Op;", "drawLine", "p1", "Landroidx/compose/ui/geometry/Offset;", "p2", "drawLine-Wko1d7g", "(JJLandroidx/compose/ui/graphics/Paint;)V", "drawRect", "drawRoundRect", "radiusX", "radiusY", "drawOval", "drawCircle", "center", "radius", "drawCircle-9KIMszo", "(JFLandroidx/compose/ui/graphics/Paint;)V", "drawArc", "startAngle", "sweepAngle", "useCenter", "", "drawPath", "drawImage", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "topLeftOffset", "drawImage-d-4ec7I", "(Landroidx/compose/ui/graphics/ImageBitmap;JLandroidx/compose/ui/graphics/Paint;)V", "drawImageRect", "srcOffset", "Landroidx/compose/ui/unit/IntOffset;", "srcSize", "Landroidx/compose/ui/unit/IntSize;", "dstOffset", "dstSize", "drawImageRect-HPBpro0", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJLandroidx/compose/ui/graphics/Paint;)V", "drawPoints", "pointMode", "Landroidx/compose/ui/graphics/PointMode;", "points", "", "drawPoints-O7TthRY", "(ILjava/util/List;Landroidx/compose/ui/graphics/Paint;)V", "enableZ", "disableZ", "drawLines", "stepBy", "", "drawRawPoints", "", "drawRawPoints-O7TthRY", "(I[FLandroidx/compose/ui/graphics/Paint;)V", "drawRawLines", "drawVertices", "vertices", "Landroidx/compose/ui/graphics/Vertices;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "drawVertices-TPEHhCM", "(Landroidx/compose/ui/graphics/Vertices;ILandroidx/compose/ui/graphics/Paint;)V", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AndroidCanvas implements Canvas {
    private Rect dstRect;
    private android.graphics.Canvas internalCanvas;
    private Rect srcRect;

    public static /* synthetic */ void getInternalCanvas$annotations() {
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: clipRect-mtrdD-E, reason: not valid java name */
    public final /* synthetic */ void mo4678clipRectmtrdDE(androidx.compose.ui.geometry.Rect r100, int r101) {
        Canvas.CC.m4797$default$clipRectmtrdDE(this, r100, r101);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public final /* synthetic */ void drawArc(androidx.compose.ui.geometry.Rect r100, float r101, float r102, boolean r103, Paint r104) {
        Canvas.CC.$default$drawArc(this, r100, r101, r102, r103, r104);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public final /* synthetic */ void drawArcRad(androidx.compose.ui.geometry.Rect r100, float r101, float r102, boolean r103, Paint r104) {
        Canvas.CC.$default$drawArcRad(this, r100, r101, r102, r103, r104);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public final /* synthetic */ void drawOval(androidx.compose.ui.geometry.Rect r100, Paint r101) {
        Canvas.CC.$default$drawOval(this, r100, r101);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public final /* synthetic */ void drawRect(androidx.compose.ui.geometry.Rect r100, Paint r101) {
        Canvas.CC.$default$drawRect(this, r100, r101);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public final /* synthetic */ void skewRad(float r100, float r101) {
        Canvas.CC.$default$skewRad(this, r100, r101);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void disableZ() {
        CanvasUtils.INSTANCE.enableZ(this.internalCanvas, false);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void enableZ() {
        CanvasUtils.INSTANCE.enableZ(this.internalCanvas, true);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void restore() {
        this.internalCanvas.restore();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void save() {
        this.internalCanvas.save();
    }

    public AndroidCanvas() {
        this.internalCanvas = AndroidCanvas_androidKt.access$getEmptyCanvas$p();
    }

    public final android.graphics.Canvas getInternalCanvas() {
        return this.internalCanvas;
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: concat-58bKbWc, reason: not valid java name */
    public void mo4679concat58bKbWc(float[] r100) {
        if (MatrixKt.m5102isIdentity58bKbWc(r100) == true) goto L6;
        android.graphics.Matrix r101 = new android.graphics.Matrix();
        AndroidMatrixConversions_androidKt.m4695setFromEL8BTi8(r101, r100);
        this.internalCanvas.concat(r101);
        return;
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void rotate(float r100) {
        this.internalCanvas.rotate(r100);
    }

    public final void setInternalCanvas(android.graphics.Canvas r100) {
        this.internalCanvas = r100;
    }

    /* JADX INFO: renamed from: toRegionOp--7u2Bmg, reason: not valid java name */
    public final Region.Op m4687toRegionOp7u2Bmg(int r100) {
        if (ClipOp.m4811equalsimpl0(r100, ClipOp.Companion.m4815getDifferencertfAjoo()) == false) goto L6;
        return Region.Op.DIFFERENCE;
    L6:
        return Region.Op.INTERSECT;
    }

    private final void drawPoints(List<Offset> r100, Paint r110) {
        int r101 = r100.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        long r103 = ((Offset) ListProtector.get(r100, r102)).m4592unboximpl();
        this.internalCanvas.drawPoint(Float.intBitsToFloat((int) (r103 >> 32)), Float.intBitsToFloat((int) (r103 & BodyPartID.bodyIdMax)), r110.asFrameworkPaint());
        r102 = r102 + 1;
        goto L3
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: clipPath-mtrdD-E, reason: not valid java name */
    public void mo4676clipPathmtrdDE(Path r100, int r101) {
        android.graphics.Canvas r102 = this.internalCanvas;
        if ((r100 instanceof AndroidPath) == false) goto L7;
        r102.clipPath(((AndroidPath) r100).getInternalPath(), m4687toRegionOp7u2Bmg(r101));
        return;
    L7:
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void drawPath(Path r100, Paint r101) {
        android.graphics.Canvas r102 = this.internalCanvas;
        if ((r100 instanceof AndroidPath) == false) goto L7;
        r102.drawPath(((AndroidPath) r100).getInternalPath(), r101.asFrameworkPaint());
        return;
    L7:
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void saveLayer(androidx.compose.ui.geometry.Rect r100, Paint r101) {
        this.internalCanvas.saveLayer(r100.getLeft(), r100.getTop(), r100.getRight(), r100.getBottom(), r101.asFrameworkPaint(), 31);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void scale(float r100, float r101) {
        this.internalCanvas.scale(r100, r101);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void skew(float r100, float r101) {
        this.internalCanvas.skew(r100, r101);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void translate(float r100, float r101) {
        this.internalCanvas.translate(r100, r101);
    }

    private final void drawLines(List<Offset> r110, Paint r111, int r112) {
        if (r110.size() < 2) goto L8;
        android.graphics.Paint r113 = r111.asFrameworkPaint();
        int r100 = 0;
    L6:
        if (r100 >= (r110.size() - 1)) goto L10;
        long r101 = ((Offset) ListProtector.get(r110, r100)).m4592unboximpl();
        long r102 = ((Offset) ListProtector.get(r110, r100 + 1)).m4592unboximpl();
        this.internalCanvas.drawLine(Float.intBitsToFloat((int) (r101 >> 32)), Float.intBitsToFloat((int) (r101 & BodyPartID.bodyIdMax)), Float.intBitsToFloat((int) (r102 >> 32)), Float.intBitsToFloat((int) (r102 & BodyPartID.bodyIdMax)), r113);
        r100 = r100 + r112;
        goto L6
    L10:
        return;
    }

    private final void drawRawLines(float[] r100, Paint r101, int r110) {
        if (r100.length >= 4) goto L5;
        return;
    L5:
        if ((r100.length % 2) != 0) goto L12;
        android.graphics.Paint r102 = r101.asFrameworkPaint();
        int r103 = 0;
    L8:
        if (r103 >= (r100.length - 3)) goto L13;
        this.internalCanvas.drawLine(r100[r103], r100[r103 + 1], r100[r103 + 2], r100[r103 + 3], r102);
        r103 = r103 + (r110 * 2);
        goto L8
    L13:
        return;
    }

    private final void drawRawPoints(float[] r100, Paint r101, int r102) {
        if ((r100.length % 2) != 0) goto L8;
        android.graphics.Paint r103 = r101.asFrameworkPaint();
        int r104 = 0;
    L6:
        if (r104 >= (r100.length - 1)) goto L10;
        this.internalCanvas.drawPoint(r100[r104], r100[r104 + 1], r103);
        r104 = r104 + r102;
        goto L6
    L10:
        return;
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: drawCircle-9KIMszo, reason: not valid java name */
    public void mo4680drawCircle9KIMszo(long r100, float r101, Paint r102) {
        this.internalCanvas.drawCircle(Float.intBitsToFloat((int) (r100 >> 32)), Float.intBitsToFloat((int) (r100 & BodyPartID.bodyIdMax)), r101, r102.asFrameworkPaint());
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: drawImage-d-4ec7I, reason: not valid java name */
    public void mo4681drawImaged4ec7I(ImageBitmap r100, long r101, Paint r102) {
        this.internalCanvas.drawBitmap(AndroidImageBitmap_androidKt.asAndroidBitmap(r100), Float.intBitsToFloat((int) (r101 >> 32)), Float.intBitsToFloat((int) (r101 & BodyPartID.bodyIdMax)), r102.asFrameworkPaint());
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: drawLine-Wko1d7g, reason: not valid java name */
    public void mo4683drawLineWko1d7g(long r100, long r110, Paint r111) {
        this.internalCanvas.drawLine(Float.intBitsToFloat((int) (r100 >> 32)), Float.intBitsToFloat((int) (r100 & BodyPartID.bodyIdMax)), Float.intBitsToFloat((int) (r110 >> 32)), Float.intBitsToFloat((int) (r110 & BodyPartID.bodyIdMax)), r111.asFrameworkPaint());
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: drawPoints-O7TthRY, reason: not valid java name */
    public void mo4684drawPointsO7TthRY(int r100, List<Offset> r101, Paint r102) {
        PointMode.Companion r103 = PointMode.Companion;
        if (PointMode.m5149equalsimpl0(r100, r103.m5153getLinesr_lszbg()) == false) goto L6;
        drawLines(r101, r102, 2);
        return;
    L6:
        if (PointMode.m5149equalsimpl0(r100, r103.m5155getPolygonr_lszbg()) == false) goto L9;
        drawLines(r101, r102, 1);
        return;
    L9:
        if (PointMode.m5149equalsimpl0(r100, r103.m5154getPointsr_lszbg()) == false) goto L14;
        drawPoints(r101, r102);
        return;
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: drawRawPoints-O7TthRY, reason: not valid java name */
    public void mo4685drawRawPointsO7TthRY(int r100, float[] r101, Paint r102) {
        if ((r101.length % 2) != 0) goto L15;
        PointMode.Companion r103 = PointMode.Companion;
        if (PointMode.m5149equalsimpl0(r100, r103.m5153getLinesr_lszbg()) == false) goto L8;
        drawRawLines(r101, r102, 2);
        return;
    L8:
        if (PointMode.m5149equalsimpl0(r100, r103.m5155getPolygonr_lszbg()) == false) goto L11;
        drawRawLines(r101, r102, 1);
        return;
    L11:
        if (PointMode.m5149equalsimpl0(r100, r103.m5154getPointsr_lszbg()) == false) goto L18;
        drawRawPoints(r101, r102, 2);
        return;
    L18:
        return;
    L15:
        throw new IllegalArgumentException("points must have an even number of values");
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: drawVertices-TPEHhCM, reason: not valid java name */
    public void mo4686drawVerticesTPEHhCM(Vertices r110, int r111, Paint r112) {
        this.internalCanvas.drawVertices(AndroidVertexMode_androidKt.m4732toAndroidVertexModeJOOmi9M(r110.m5256getVertexModec2xauaI()), r110.getPositions().length, r110.getPositions(), 0, r110.getTextureCoordinates(), 0, r110.getColors(), 0, r110.getIndices(), 0, r110.getIndices().length, r112.asFrameworkPaint());
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: clipRect-N_I0leg, reason: not valid java name */
    public void mo4677clipRectN_I0leg(float r100, float r101, float r102, float r110, int r111) {
        this.internalCanvas.clipRect(r100, r101, r102, r110, m4687toRegionOp7u2Bmg(r111));
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void drawOval(float r100, float r101, float r102, float r110, Paint r111) {
        this.internalCanvas.drawOval(r100, r101, r102, r110, r111.asFrameworkPaint());
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void drawRect(float r100, float r101, float r102, float r110, Paint r111) {
        this.internalCanvas.drawRect(r100, r101, r102, r110, r111.asFrameworkPaint());
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: drawImageRect-HPBpro0, reason: not valid java name */
    public void mo4682drawImageRectHPBpro0(ImageBitmap r110, long r111, long r112, long r113, long r114, Paint r210) {
        if (this.srcRect != null) goto L5;
        this.srcRect = new Rect();
        this.dstRect = new Rect();
    L5:
        android.graphics.Canvas r100 = this.internalCanvas;
        Bitmap r101 = AndroidImageBitmap_androidKt.asAndroidBitmap(r110);
        Rect r102 = this.srcRect;
        Intrinsics.checkNotNull(r102);
        r102.left = IntOffset.m7676getXimpl(r111);
        r102.top = IntOffset.m7677getYimpl(r111);
        r102.right = IntOffset.m7676getXimpl(r111) + ((int) (r112 >> 32));
        r102.bottom = IntOffset.m7677getYimpl(r111) + ((int) (r112 & BodyPartID.bodyIdMax));
        Unit r103 = Unit.INSTANCE;
        Rect r104 = this.dstRect;
        Intrinsics.checkNotNull(r104);
        r104.left = IntOffset.m7676getXimpl(r113);
        r104.top = IntOffset.m7677getYimpl(r113);
        r104.right = IntOffset.m7676getXimpl(r113) + ((int) (r114 >> 32));
        r104.bottom = IntOffset.m7677getYimpl(r113) + ((int) (r114 & BodyPartID.bodyIdMax));
        r100.drawBitmap(r101, r102, r104, r210.asFrameworkPaint());
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void drawRoundRect(float r100, float r110, float r111, float r112, float r113, float r114, Paint r115) {
        this.internalCanvas.drawRoundRect(r100, r110, r111, r112, r113, r114, r115.asFrameworkPaint());
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void drawArc(float r110, float r111, float r112, float r113, float r114, float r115, boolean r116, Paint r117) {
        this.internalCanvas.drawArc(r110, r111, r112, r113, r114, r115, r116, r117.asFrameworkPaint());
    }
}
