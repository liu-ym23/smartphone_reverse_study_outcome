package androidx.compose.ui.graphics;

import android.graphics.RectF;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.lynx.serval.svg.SVGRenderEngine;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0018\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0018H\u0016J\u0018\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0018\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0018H\u0016J(\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u0018H\u0016J(\u0010$\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u0018H\u0016J(\u0010%\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u0018H\u0016J(\u0010*\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u0018H\u0016J8\u0010+\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u00182\u0006\u0010,\u001a\u00020\u00182\u0006\u0010-\u001a\u00020\u0018H\u0016J8\u0010.\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\u00182\u0006\u00100\u001a\u00020\u0018H\u0016J(\u00101\u001a\u00020\u00162\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u00182\u0006\u00105\u001a\u00020\u00182\u0006\u00106\u001a\u000207H\u0016J\u0010\u00108\u001a\u00020\u00162\u0006\u00102\u001a\u000203H\u0016J\u0018\u00108\u001a\u00020\u00162\u0006\u00102\u001a\u0002032\u0006\u00109\u001a\u00020:H\u0016J\u0010\u0010;\u001a\u00020\u00162\u0006\u0010<\u001a\u000203H\u0016J\u0018\u0010;\u001a\u00020\u00162\u0006\u0010<\u001a\u0002032\u0006\u00109\u001a\u00020:H\u0016J\u0010\u0010=\u001a\u00020\u00162\u0006\u0010>\u001a\u00020?H\u0016J\u0018\u0010=\u001a\u00020\u00162\u0006\u0010>\u001a\u00020?2\u0006\u00109\u001a\u00020:H\u0016J \u0010@\u001a\u00020\u00162\u0006\u0010<\u001a\u0002032\u0006\u0010A\u001a\u00020\u00182\u0006\u0010B\u001a\u00020\u0018H\u0016J \u0010C\u001a\u00020\u00162\u0006\u0010<\u001a\u0002032\u0006\u00104\u001a\u00020\u00182\u0006\u00105\u001a\u00020\u0018H\u0016J\u001f\u0010D\u001a\u00020\u00162\u0006\u0010E\u001a\u00020\u00012\u0006\u0010F\u001a\u00020GH\u0016¢\u0006\u0004\bH\u0010IJ\b\u0010J\u001a\u00020\u0016H\u0016J\b\u0010K\u001a\u00020\u0016H\u0016J\b\u0010L\u001a\u00020\u0016H\u0016J\u0017\u0010M\u001a\u00020\u00162\u0006\u0010F\u001a\u00020GH\u0016¢\u0006\u0004\bN\u0010OJ\u0017\u0010P\u001a\u00020\u00162\u0006\u0010Q\u001a\u00020RH\u0016¢\u0006\u0004\bS\u0010TJ\b\u0010U\u001a\u000203H\u0016J'\u0010V\u001a\u0002072\u0006\u0010W\u001a\u00020\u00012\u0006\u0010X\u001a\u00020\u00012\u0006\u0010Y\u001a\u00020ZH\u0016¢\u0006\u0004\b[\u0010\\J\u0010\u0010b\u001a\u00020\u00162\u0006\u00102\u001a\u000203H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010]\u001a\u0002078VX\u0096\u0004¢\u0006\f\u0012\u0004\b^\u0010_\u001a\u0004\b]\u0010`R\u0014\u0010a\u001a\u0002078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\ba\u0010`¨\u0006c"}, d2 = {"Landroidx/compose/ui/graphics/AndroidPath;", "Landroidx/compose/ui/graphics/Path;", "internalPath", "Landroid/graphics/Path;", "<init>", "(Landroid/graphics/Path;)V", "getInternalPath", "()Landroid/graphics/Path;", "rectF", "Landroid/graphics/RectF;", "radii", "", "mMatrix", "Landroid/graphics/Matrix;", "value", "Landroidx/compose/ui/graphics/PathFillType;", "fillType", "getFillType-Rg-k1Os", "()I", "setFillType-oQ8Xj4U", "(I)V", "moveTo", "", "x", "", "y", "relativeMoveTo", "dx", "dy", "lineTo", "relativeLineTo", "quadraticBezierTo", "x1", "y1", "x2", "y2", "quadraticTo", "relativeQuadraticBezierTo", "dx1", "dy1", "dx2", "dy2", "relativeQuadraticTo", "cubicTo", "x3", "y3", "relativeCubicTo", "dx3", "dy3", "arcTo", SVGRenderEngine.RECT, "Landroidx/compose/ui/geometry/Rect;", "startAngleDegrees", "sweepAngleDegrees", "forceMoveTo", "", "addRect", "direction", "Landroidx/compose/ui/graphics/Path$Direction;", "addOval", "oval", "addRoundRect", "roundRect", "Landroidx/compose/ui/geometry/RoundRect;", "addArcRad", "startAngleRadians", "sweepAngleRadians", "addArc", "addPath", "path", "offset", "Landroidx/compose/ui/geometry/Offset;", "addPath-Uv8p0NA", "(Landroidx/compose/ui/graphics/Path;J)V", "close", BasicTestActionHandler.TEST_ACTION_RESET, "rewind", "translate", "translate-k-4lQ0M", "(J)V", "transform", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "transform-58bKbWc", "([F)V", "getBounds", "op", "path1", "path2", WikiFolderPushPlugin.OPT, "Landroidx/compose/ui/graphics/PathOperation;", "op-N5in7k0", "(Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/Path;I)Z", "isConvex", "isConvex$annotations", "()V", "()Z", "isEmpty", "validateRectangle", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AndroidPath implements Path {
    private final android.graphics.Path internalPath;
    private android.graphics.Matrix mMatrix;
    private float[] radii;
    private RectF rectF;

    /* JADX WARN: Multi-variable type inference failed */
    public AndroidPath() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ void isConvex$annotations() {
    }

    @Override // androidx.compose.ui.graphics.Path
    public final /* synthetic */ Path and(Path r100) {
        return Path.CC.$default$and(this, r100);
    }

    @Override // androidx.compose.ui.graphics.Path
    public final /* synthetic */ void arcToRad(Rect r100, float r101, float r102, boolean r103) {
        Path.CC.$default$arcToRad(this, r100, r101, r102, r103);
    }

    @Override // androidx.compose.ui.graphics.Path
    public final /* synthetic */ PathIterator iterator() {
        return Path.CC.$default$iterator(this);
    }

    @Override // androidx.compose.ui.graphics.Path
    public final /* synthetic */ PathIterator iterator(PathIterator.ConicEvaluation r100, float r101) {
        return Path.CC.$default$iterator(this, r100, r101);
    }

    @Override // androidx.compose.ui.graphics.Path
    public final /* synthetic */ Path minus(Path r100) {
        return Path.CC.$default$minus(this, r100);
    }

    @Override // androidx.compose.ui.graphics.Path
    public final /* synthetic */ Path or(Path r100) {
        return Path.CC.$default$or(this, r100);
    }

    @Override // androidx.compose.ui.graphics.Path
    public final /* synthetic */ Path plus(Path r100) {
        return Path.CC.$default$plus(this, r100);
    }

    @Override // androidx.compose.ui.graphics.Path
    public final /* synthetic */ Path xor(Path r100) {
        return Path.CC.$default$xor(this, r100);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void close() {
        this.internalPath.close();
    }

    @Override // androidx.compose.ui.graphics.Path
    public Rect getBounds() {
        if (this.rectF != null) goto L5;
        this.rectF = new RectF();
    L5:
        RectF r100 = this.rectF;
        Intrinsics.checkNotNull(r100);
        this.internalPath.computeBounds(r100, true);
        return new Rect(r100.left, r100.top, r100.right, r100.bottom);
    }

    @Override // androidx.compose.ui.graphics.Path
    /* JADX INFO: renamed from: getFillType-Rg-k1Os, reason: not valid java name */
    public int mo4716getFillTypeRgk1Os() {
        if (this.internalPath.getFillType() != android.graphics.Path.FillType.EVEN_ODD) goto L6;
        return PathFillType.Companion.m5130getEvenOddRgk1Os();
    L6:
        return PathFillType.Companion.m5131getNonZeroRgk1Os();
    }

    @Override // androidx.compose.ui.graphics.Path
    public boolean isConvex() {
        return this.internalPath.isConvex();
    }

    @Override // androidx.compose.ui.graphics.Path
    public boolean isEmpty() {
        return this.internalPath.isEmpty();
    }

    @Override // androidx.compose.ui.graphics.Path
    public void reset() {
        this.internalPath.reset();
    }

    @Override // androidx.compose.ui.graphics.Path
    public void rewind() {
        this.internalPath.rewind();
    }

    public final android.graphics.Path getInternalPath() {
        return this.internalPath;
    }

    public AndroidPath(android.graphics.Path r100) {
        this.internalPath = r100;
    }

    private final void validateRectangle(Rect r100) {
        if (Float.isNaN(r100.getLeft()) == false) goto L5;
    L10:
        AndroidPath_androidKt.throwIllegalStateException("Invalid rectangle, make sure no value is NaN");
        return;
    L5:
        if (Float.isNaN(r100.getTop()) == true) goto L10;
        if (Float.isNaN(r100.getRight()) == true) goto L10;
        if (Float.isNaN(r100.getBottom()) == true) goto L10;
    }

    @Override // androidx.compose.ui.graphics.Path
    public void addOval(Rect r100) {
        addOval(r100, Path.Direction.CounterClockwise);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void addRect(Rect r100) {
        addRect(r100, Path.Direction.CounterClockwise);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void addRoundRect(RoundRect r100) {
        addRoundRect(r100, Path.Direction.CounterClockwise);
    }

    @Override // androidx.compose.ui.graphics.Path
    /* JADX INFO: renamed from: setFillType-oQ8Xj4U, reason: not valid java name */
    public void mo4718setFillTypeoQ8Xj4U(int r100) {
        android.graphics.Path r101 = this.internalPath;
        if (PathFillType.m5126equalsimpl0(r100, PathFillType.Companion.m5130getEvenOddRgk1Os()) == false) goto L5;
        android.graphics.Path.FillType r102 = android.graphics.Path.FillType.EVEN_ODD;
    L6:
        r101.setFillType(r102);
        return;
    L5:
        r102 = android.graphics.Path.FillType.WINDING;
        goto L6
    }

    @Override // androidx.compose.ui.graphics.Path
    /* JADX INFO: renamed from: transform-58bKbWc, reason: not valid java name */
    public void mo4719transform58bKbWc(float[] r100) {
        if (this.mMatrix != null) goto L5;
        this.mMatrix = new android.graphics.Matrix();
    L5:
        android.graphics.Matrix r101 = this.mMatrix;
        Intrinsics.checkNotNull(r101);
        AndroidMatrixConversions_androidKt.m4695setFromEL8BTi8(r101, r100);
        android.graphics.Path r102 = this.internalPath;
        android.graphics.Matrix r103 = this.mMatrix;
        Intrinsics.checkNotNull(r103);
        r102.transform(r103);
    }

    @Override // androidx.compose.ui.graphics.Path
    /* JADX INFO: renamed from: translate-k-4lQ0M, reason: not valid java name */
    public void mo4720translatek4lQ0M(long r100) {
        android.graphics.Matrix r101 = this.mMatrix;
        if (r101 != null) goto L5;
        this.mMatrix = new android.graphics.Matrix();
    L6:
        android.graphics.Matrix r102 = this.mMatrix;
        Intrinsics.checkNotNull(r102);
        r102.setTranslate(Float.intBitsToFloat((int) (r100 >> 32)), Float.intBitsToFloat((int) (r100 & BodyPartID.bodyIdMax)));
        android.graphics.Path r103 = this.internalPath;
        android.graphics.Matrix r104 = this.mMatrix;
        Intrinsics.checkNotNull(r104);
        r103.transform(r104);
        return;
    L5:
        Intrinsics.checkNotNull(r101);
        r101.reset();
        goto L6
    }

    @Override // androidx.compose.ui.graphics.Path
    public void addOval(Rect r100, Path.Direction r101) {
        if (this.rectF != null) goto L5;
        this.rectF = new RectF();
    L5:
        RectF r102 = this.rectF;
        Intrinsics.checkNotNull(r102);
        r102.set(r100.getLeft(), r100.getTop(), r100.getRight(), r100.getBottom());
        android.graphics.Path r103 = this.internalPath;
        RectF r104 = this.rectF;
        Intrinsics.checkNotNull(r104);
        r103.addOval(r104, AndroidPath_androidKt.access$toPlatformPathDirection(r101));
    }

    @Override // androidx.compose.ui.graphics.Path
    /* JADX INFO: renamed from: addPath-Uv8p0NA, reason: not valid java name */
    public void mo4715addPathUv8p0NA(Path r100, long r101) {
        android.graphics.Path r102 = this.internalPath;
        if ((r100 instanceof AndroidPath) == false) goto L7;
        r102.addPath(((AndroidPath) r100).getInternalPath(), Float.intBitsToFloat((int) (r101 >> 32)), Float.intBitsToFloat((int) (r101 & BodyPartID.bodyIdMax)));
        return;
    L7:
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }

    @Override // androidx.compose.ui.graphics.Path
    public void addRect(Rect r100, Path.Direction r101) {
        validateRectangle(r100);
        if (this.rectF != null) goto L5;
        this.rectF = new RectF();
    L5:
        RectF r102 = this.rectF;
        Intrinsics.checkNotNull(r102);
        r102.set(r100.getLeft(), r100.getTop(), r100.getRight(), r100.getBottom());
        android.graphics.Path r103 = this.internalPath;
        RectF r104 = this.rectF;
        Intrinsics.checkNotNull(r104);
        r103.addRect(r104, AndroidPath_androidKt.access$toPlatformPathDirection(r101));
    }

    @Override // androidx.compose.ui.graphics.Path
    public void addRoundRect(RoundRect r100, Path.Direction r101) {
        if (this.rectF != null) goto L5;
        this.rectF = new RectF();
    L5:
        RectF r102 = this.rectF;
        Intrinsics.checkNotNull(r102);
        r102.set(r100.getLeft(), r100.getTop(), r100.getRight(), r100.getBottom());
        if (this.radii != null) goto L8;
        this.radii = new float[8];
    L8:
        float[] r103 = this.radii;
        Intrinsics.checkNotNull(r103);
        r103[0] = Float.intBitsToFloat((int) (r100.m4632getTopLeftCornerRadiuskKHJgLs() >> 32));
        r103[1] = Float.intBitsToFloat((int) (r100.m4632getTopLeftCornerRadiuskKHJgLs() & BodyPartID.bodyIdMax));
        r103[2] = Float.intBitsToFloat((int) (r100.m4633getTopRightCornerRadiuskKHJgLs() >> 32));
        r103[3] = Float.intBitsToFloat((int) (r100.m4633getTopRightCornerRadiuskKHJgLs() & BodyPartID.bodyIdMax));
        r103[4] = Float.intBitsToFloat((int) (r100.m4631getBottomRightCornerRadiuskKHJgLs() >> 32));
        r103[5] = Float.intBitsToFloat((int) (r100.m4631getBottomRightCornerRadiuskKHJgLs() & BodyPartID.bodyIdMax));
        r103[6] = Float.intBitsToFloat((int) (r100.m4630getBottomLeftCornerRadiuskKHJgLs() >> 32));
        r103[7] = Float.intBitsToFloat((int) (r100.m4630getBottomLeftCornerRadiuskKHJgLs() & BodyPartID.bodyIdMax));
        android.graphics.Path r104 = this.internalPath;
        RectF r105 = this.rectF;
        Intrinsics.checkNotNull(r105);
        float[] r106 = this.radii;
        Intrinsics.checkNotNull(r106);
        r104.addRoundRect(r105, r106, AndroidPath_androidKt.access$toPlatformPathDirection(r101));
    }

    @Override // androidx.compose.ui.graphics.Path
    public void lineTo(float r100, float r101) {
        this.internalPath.lineTo(r100, r101);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void moveTo(float r100, float r101) {
        this.internalPath.moveTo(r100, r101);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void relativeLineTo(float r100, float r101) {
        this.internalPath.rLineTo(r100, r101);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void relativeMoveTo(float r100, float r101) {
        this.internalPath.rMoveTo(r100, r101);
    }

    public /* synthetic */ AndroidPath(android.graphics.Path r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = new android.graphics.Path();
    L5:
        this(r100);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void addArc(Rect r100, float r101, float r102) {
        validateRectangle(r100);
        if (this.rectF != null) goto L5;
        this.rectF = new RectF();
    L5:
        RectF r103 = this.rectF;
        Intrinsics.checkNotNull(r103);
        r103.set(r100.getLeft(), r100.getTop(), r100.getRight(), r100.getBottom());
        android.graphics.Path r104 = this.internalPath;
        RectF r105 = this.rectF;
        Intrinsics.checkNotNull(r105);
        r104.addArc(r105, r101, r102);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void addArcRad(Rect r100, float r101, float r102) {
        addArc(r100, DegreesKt.degrees(r101), DegreesKt.degrees(r102));
    }

    @Override // androidx.compose.ui.graphics.Path
    /* JADX INFO: renamed from: op-N5in7k0, reason: not valid java name */
    public boolean mo4717opN5in7k0(Path r100, Path r101, int r102) {
        PathOperation.Companion r103 = PathOperation.Companion;
        if (PathOperation.m5136equalsimpl0(r102, r103.m5140getDifferenceb3I0S0c()) == false) goto L6;
        android.graphics.Path.Op r104 = android.graphics.Path.Op.DIFFERENCE;
    L15:
        android.graphics.Path r105 = this.internalPath;
        if ((r100 instanceof AndroidPath) == false) goto L24;
        android.graphics.Path r106 = ((AndroidPath) r100).getInternalPath();
        if ((r101 instanceof AndroidPath) == false) goto L22;
        return r105.op(r106, ((AndroidPath) r101).getInternalPath(), r104);
    L22:
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    L24:
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    L6:
        if (PathOperation.m5136equalsimpl0(r102, r103.m5141getIntersectb3I0S0c()) == false) goto L9;
        r104 = android.graphics.Path.Op.INTERSECT;
        goto L15
    L9:
        if (PathOperation.m5136equalsimpl0(r102, r103.m5142getReverseDifferenceb3I0S0c()) == false) goto L12;
        r104 = android.graphics.Path.Op.REVERSE_DIFFERENCE;
        goto L15
    L12:
        if (PathOperation.m5136equalsimpl0(r102, r103.m5143getUnionb3I0S0c()) == false) goto L14;
        r104 = android.graphics.Path.Op.UNION;
        goto L15
    L14:
        r104 = android.graphics.Path.Op.XOR;
        goto L15
    }

    @Override // androidx.compose.ui.graphics.Path
    public void arcTo(Rect r100, float r101, float r102, boolean r103) {
        float r104 = r100.getLeft();
        float r105 = r100.getTop();
        float r106 = r100.getRight();
        float r107 = r100.getBottom();
        if (this.rectF != null) goto L5;
        this.rectF = new RectF();
    L5:
        RectF r108 = this.rectF;
        Intrinsics.checkNotNull(r108);
        r108.set(r104, r105, r106, r107);
        android.graphics.Path r109 = this.internalPath;
        RectF r110 = this.rectF;
        Intrinsics.checkNotNull(r110);
        r109.arcTo(r110, r101, r102, r103);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void quadraticBezierTo(float r100, float r101, float r102, float r103) {
        this.internalPath.quadTo(r100, r101, r102, r103);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void quadraticTo(float r100, float r101, float r102, float r103) {
        this.internalPath.quadTo(r100, r101, r102, r103);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void relativeQuadraticBezierTo(float r100, float r101, float r102, float r103) {
        this.internalPath.rQuadTo(r100, r101, r102, r103);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void relativeQuadraticTo(float r100, float r101, float r102, float r103) {
        this.internalPath.rQuadTo(r100, r101, r102, r103);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void cubicTo(float r100, float r101, float r110, float r111, float r112, float r113) {
        this.internalPath.cubicTo(r100, r101, r110, r111, r112, r113);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void relativeCubicTo(float r100, float r101, float r110, float r111, float r112, float r113) {
        this.internalPath.rCubicTo(r100, r101, r110, r111, r112, r113);
    }
}
