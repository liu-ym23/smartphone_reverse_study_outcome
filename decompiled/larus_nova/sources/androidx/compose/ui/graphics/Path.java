package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.lynx.serval.svg.SVGRenderEngine;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\bf\u0018\u0000 _2\u00020\u0001:\u0002^_J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH&J\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000fH&J\u0018\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH&J\u0018\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000fH&J(\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u000fH'J(\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u000fH\u0016J(\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u000fH'J(\u0010!\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u000fH\u0016J8\u0010\"\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u000fH&J8\u0010%\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u000fH&J(\u0010(\u001a\u00020\r2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020\tH\u0016J(\u0010.\u001a\u00020\r2\u0006\u0010)\u001a\u00020*2\u0006\u0010/\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020\tH&J\u0010\u00101\u001a\u00020\r2\u0006\u0010)\u001a\u00020*H'J\u001a\u00101\u001a\u00020\r2\u0006\u0010)\u001a\u00020*2\b\b\u0002\u00102\u001a\u000203H&J\u0010\u00104\u001a\u00020\r2\u0006\u00105\u001a\u00020*H'J\u001a\u00104\u001a\u00020\r2\u0006\u00105\u001a\u00020*2\b\b\u0002\u00102\u001a\u000203H&J\u0010\u00106\u001a\u00020\r2\u0006\u00107\u001a\u000208H'J\u001a\u00106\u001a\u00020\r2\u0006\u00107\u001a\u0002082\b\b\u0002\u00102\u001a\u000203H&J \u00109\u001a\u00020\r2\u0006\u00105\u001a\u00020*2\u0006\u0010+\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020\u000fH&J \u0010:\u001a\u00020\r2\u0006\u00105\u001a\u00020*2\u0006\u0010/\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\u000fH&J!\u0010;\u001a\u00020\r2\u0006\u0010<\u001a\u00020\u00002\b\b\u0002\u0010=\u001a\u00020>H&¢\u0006\u0004\b?\u0010@J\b\u0010A\u001a\u00020\rH&J\b\u0010B\u001a\u00020\rH&J\b\u0010C\u001a\u00020\rH\u0016J\u0017\u0010D\u001a\u00020\r2\u0006\u0010=\u001a\u00020>H&¢\u0006\u0004\bE\u0010FJ\u0017\u0010G\u001a\u00020\r2\u0006\u0010H\u001a\u00020IH\u0016¢\u0006\u0004\bJ\u0010KJ\b\u0010L\u001a\u00020*H&J\t\u0010M\u001a\u00020NH\u0096\u0002J\u001a\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020P2\b\b\u0002\u0010Q\u001a\u00020\u000fH\u0016J'\u0010R\u001a\u00020\t2\u0006\u0010S\u001a\u00020\u00002\u0006\u0010T\u001a\u00020\u00002\u0006\u0010U\u001a\u00020VH&¢\u0006\u0004\bW\u0010XJ\u0011\u0010Y\u001a\u00020\u00002\u0006\u0010<\u001a\u00020\u0000H\u0096\u0002J\u0011\u0010Z\u001a\u00020\u00002\u0006\u0010<\u001a\u00020\u0000H\u0096\u0002J\u0011\u0010[\u001a\u00020\u00002\u0006\u0010<\u001a\u00020\u0000H\u0096\u0004J\u0011\u0010\\\u001a\u00020\u00002\u0006\u0010<\u001a\u00020\u0000H\u0096\u0004J\u0011\u0010]\u001a\u00020\u00002\u0006\u0010<\u001a\u00020\u0000H\u0096\u0004R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\nR\u0012\u0010\u000b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006`À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/graphics/Path;", "", "fillType", "Landroidx/compose/ui/graphics/PathFillType;", "getFillType-Rg-k1Os", "()I", "setFillType-oQ8Xj4U", "(I)V", "isConvex", "", "()Z", "isEmpty", "moveTo", "", "x", "", "y", "relativeMoveTo", "dx", "dy", "lineTo", "relativeLineTo", "quadraticBezierTo", "x1", "y1", "x2", "y2", "quadraticTo", "relativeQuadraticBezierTo", "dx1", "dy1", "dx2", "dy2", "relativeQuadraticTo", "cubicTo", "x3", "y3", "relativeCubicTo", "dx3", "dy3", "arcToRad", SVGRenderEngine.RECT, "Landroidx/compose/ui/geometry/Rect;", "startAngleRadians", "sweepAngleRadians", "forceMoveTo", "arcTo", "startAngleDegrees", "sweepAngleDegrees", "addRect", "direction", "Landroidx/compose/ui/graphics/Path$Direction;", "addOval", "oval", "addRoundRect", "roundRect", "Landroidx/compose/ui/geometry/RoundRect;", "addArcRad", "addArc", "addPath", "path", "offset", "Landroidx/compose/ui/geometry/Offset;", "addPath-Uv8p0NA", "(Landroidx/compose/ui/graphics/Path;J)V", "close", BasicTestActionHandler.TEST_ACTION_RESET, "rewind", "translate", "translate-k-4lQ0M", "(J)V", "transform", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "transform-58bKbWc", "([F)V", "getBounds", "iterator", "Landroidx/compose/ui/graphics/PathIterator;", "conicEvaluation", "Landroidx/compose/ui/graphics/PathIterator$ConicEvaluation;", "tolerance", "op", "path1", "path2", WikiFolderPushPlugin.OPT, "Landroidx/compose/ui/graphics/PathOperation;", "op-N5in7k0", "(Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/Path;I)Z", "plus", "minus", SRStrategy.KEY_ORIGIN_RESOLUTION, "and", "xor", "Direction", "Companion", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface Path {
    public static final Companion Companion = null;

    /* JADX INFO: renamed from: androidx.compose.ui.graphics.Path$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        /* JADX INFO: renamed from: $default$transform-58bKbWc, reason: not valid java name */
        public static void m5116$default$transform58bKbWc(Path r100, float[] r101) {
        }

        static {
            Companion r100 = Path.Companion;
        }

        public static PathIterator $default$iterator(Path r100) {
            return AndroidPathIterator_androidKt.PathIterator$default(r100, null, 0.0f, 6, null);
        }

        public static void $default$rewind(Path r100) {
            r100.reset();
        }

        public static /* synthetic */ PathIterator access$iterator$jd(Path r100) {
            return $default$iterator(r100);
        }

        public static /* synthetic */ void access$rewind$jd(Path r100) {
            $default$rewind(r100);
        }

        public static Path $default$and(Path r100, Path r101) {
            Path r102 = AndroidPath_androidKt.Path();
            r102.mo4717opN5in7k0(r100, r101, PathOperation.Companion.m5141getIntersectb3I0S0c());
            return r102;
        }

        public static Path $default$minus(Path r100, Path r101) {
            Path r102 = AndroidPath_androidKt.Path();
            r102.mo4717opN5in7k0(r100, r101, PathOperation.Companion.m5140getDifferenceb3I0S0c());
            return r102;
        }

        public static Path $default$or(Path r100, Path r101) {
            return r100.plus(r101);
        }

        public static Path $default$plus(Path r100, Path r101) {
            Path r102 = AndroidPath_androidKt.Path();
            r102.mo4717opN5in7k0(r100, r101, PathOperation.Companion.m5143getUnionb3I0S0c());
            return r102;
        }

        public static Path $default$xor(Path r100, Path r101) {
            Path r102 = AndroidPath_androidKt.Path();
            r102.mo4717opN5in7k0(r100, r101, PathOperation.Companion.m5144getXorb3I0S0c());
            return r102;
        }

        public static /* synthetic */ Path access$and$jd(Path r100, Path r101) {
            return $default$and(r100, r101);
        }

        public static /* synthetic */ Path access$minus$jd(Path r100, Path r101) {
            return $default$minus(r100, r101);
        }

        public static /* synthetic */ Path access$or$jd(Path r100, Path r101) {
            return $default$or(r100, r101);
        }

        public static /* synthetic */ Path access$plus$jd(Path r100, Path r101) {
            return $default$plus(r100, r101);
        }

        /* JADX INFO: renamed from: access$transform-58bKbWc$jd, reason: not valid java name */
        public static /* synthetic */ void m5117access$transform58bKbWc$jd(Path r100, float[] r101) {
            m5116$default$transform58bKbWc(r100, r101);
        }

        public static /* synthetic */ Path access$xor$jd(Path r100, Path r101) {
            return $default$xor(r100, r101);
        }

        public static PathIterator $default$iterator(Path r100, PathIterator.ConicEvaluation r101, float r102) {
            return AndroidPathIterator_androidKt.PathIterator(r100, r101, r102);
        }

        public static /* synthetic */ PathIterator access$iterator$jd(Path r100, PathIterator.ConicEvaluation r101, float r102) {
            return $default$iterator(r100, r101, r102);
        }

        public static void $default$arcToRad(Path r100, Rect r101, float r102, float r103, boolean r104) {
            r100.arcTo(r101, DegreesKt.degrees(r102), DegreesKt.degrees(r103), r104);
        }

        public static void $default$quadraticTo(Path r100, float r101, float r102, float r103, float r104) {
            r100.quadraticBezierTo(r101, r102, r103, r104);
        }

        public static void $default$relativeQuadraticTo(Path r100, float r101, float r102, float r103, float r104) {
            r100.relativeQuadraticBezierTo(r101, r102, r103, r104);
        }

        public static /* synthetic */ void access$arcToRad$jd(Path r100, Rect r101, float r102, float r103, boolean r104) {
            $default$arcToRad(r100, r101, r102, r103, r104);
        }

        public static /* synthetic */ void access$quadraticTo$jd(Path r100, float r101, float r102, float r103, float r104) {
            $default$quadraticTo(r100, r101, r102, r103, r104);
        }

        public static /* synthetic */ void access$relativeQuadraticTo$jd(Path r100, float r101, float r102, float r103, float r104) {
            $default$relativeQuadraticTo(r100, r101, r102, r103, r104);
        }

        public static /* synthetic */ void addOval$default(Path r100, Rect r101, Direction r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = Direction.CounterClockwise;
        L6:
            r100.addOval(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addOval");
        }

        /* JADX INFO: renamed from: addPath-Uv8p0NA$default, reason: not valid java name */
        public static /* synthetic */ void m5118addPathUv8p0NA$default(Path r100, Path r101, long r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = Offset.Companion.m4598getZeroF1C5BW0();
        L6:
            r100.mo4715addPathUv8p0NA(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addPath-Uv8p0NA");
        }

        public static /* synthetic */ void addRect$default(Path r100, Rect r101, Direction r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = Direction.CounterClockwise;
        L6:
            r100.addRect(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addRect");
        }

        public static /* synthetic */ void addRoundRect$default(Path r100, RoundRect r101, Direction r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = Direction.CounterClockwise;
        L6:
            r100.addRoundRect(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addRoundRect");
        }

        public static /* synthetic */ PathIterator iterator$default(Path r100, PathIterator.ConicEvaluation r101, float r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L7;
            r102 = 0.25f;
        L7:
            return r100.iterator(r101, r102);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: iterator");
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/compose/ui/graphics/Path$Companion;", "", "<init>", "()V", "combine", "Landroidx/compose/ui/graphics/Path;", WikiFolderPushPlugin.OPT, "Landroidx/compose/ui/graphics/PathOperation;", "path1", "path2", "combine-xh6zSI8", "(ILandroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/Path;)Landroidx/compose/ui/graphics/Path;", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: combine-xh6zSI8, reason: not valid java name */
        public final Path m5119combinexh6zSI8(int r100, Path r101, Path r102) {
            Path r103 = AndroidPath_androidKt.Path();
            if (r103.mo4717opN5in7k0(r101, r102, r100) == false) goto L6;
            return r103;
        L6:
            throw new IllegalArgumentException("Path.combine() failed.  This may be due an invalid path; in particular, check for NaN values.");
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static PathIterator iterator(Path r100) {
            return CC.access$iterator$jd(r100);
        }

        public static void rewind(Path r100) {
            CC.access$rewind$jd(r100);
        }

        public static Path and(Path r100, Path r101) {
            return CC.access$and$jd(r100, r101);
        }

        public static Path minus(Path r100, Path r101) {
            return CC.access$minus$jd(r100, r101);
        }

        public static Path or(Path r100, Path r101) {
            return CC.access$or$jd(r100, r101);
        }

        public static Path plus(Path r100, Path r101) {
            return CC.access$plus$jd(r100, r101);
        }

        /* JADX INFO: renamed from: transform-58bKbWc, reason: not valid java name */
        public static void m5121transform58bKbWc(Path r100, float[] r101) {
            CC.m5117access$transform58bKbWc$jd(r100, r101);
        }

        public static Path xor(Path r100, Path r101) {
            return CC.access$xor$jd(r100, r101);
        }

        public static PathIterator iterator(Path r100, PathIterator.ConicEvaluation r101, float r102) {
            return CC.access$iterator$jd(r100, r101, r102);
        }

        public static /* synthetic */ void addOval$default(Path r100, Rect r101, Direction r102, int r103, Object r104) {
            CC.addOval$default(r100, r101, r102, r103, r104);
        }

        /* JADX INFO: renamed from: addPath-Uv8p0NA$default, reason: not valid java name */
        public static /* synthetic */ void m5120addPathUv8p0NA$default(Path r100, Path r101, long r102, int r103, Object r104) {
            CC.m5118addPathUv8p0NA$default(r100, r101, r102, r103, r104);
        }

        public static /* synthetic */ void addRect$default(Path r100, Rect r101, Direction r102, int r103, Object r104) {
            CC.addRect$default(r100, r101, r102, r103, r104);
        }

        public static /* synthetic */ void addRoundRect$default(Path r100, RoundRect r101, Direction r102, int r103, Object r104) {
            CC.addRoundRect$default(r100, r101, r102, r103, r104);
        }

        public static void arcToRad(Path r100, Rect r101, float r102, float r103, boolean r104) {
            CC.access$arcToRad$jd(r100, r101, r102, r103, r104);
        }

        public static /* synthetic */ PathIterator iterator$default(Path r100, PathIterator.ConicEvaluation r101, float r102, int r103, Object r104) {
            return CC.iterator$default(r100, r101, r102, r103, r104);
        }

        public static void quadraticTo(Path r100, float r101, float r102, float r103, float r104) {
            CC.access$quadraticTo$jd(r100, r101, r102, r103, r104);
        }

        public static void relativeQuadraticTo(Path r100, float r101, float r102, float r103, float r104) {
            CC.access$relativeQuadraticTo$jd(r100, r101, r102, r103, r104);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/ui/graphics/Path$Direction;", "", "<init>", "(Ljava/lang/String;I)V", "CounterClockwise", "Clockwise", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum Direction extends Enum<Direction> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ Direction[] $VALUES = null;
        public static final Direction Clockwise = null;
        public static final Direction CounterClockwise = null;

        private static final /* synthetic */ Direction[] $values() {
            return new Direction[]{CounterClockwise, Clockwise};
        }

        public static EnumEntries<Direction> getEntries() {
            return $ENTRIES;
        }

        static {
            CounterClockwise = new Direction("CounterClockwise", 0);
            Clockwise = new Direction("Clockwise", 1);
            Direction[] r100 = $values();
            $VALUES = r100;
            $ENTRIES = EnumEntriesKt.enumEntries(r100);
        }

        public static Direction[] values() {
            return (Direction[]) $VALUES.clone();
        }

        public static Direction valueOf(String r100) {
            return (Direction) r27.a.a(Direction.class, r100);
        }

        private Direction(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    void addArc(Rect r100, float r101, float r102);

    void addArcRad(Rect r100, float r101, float r102);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Prefer usage of addOval() with a winding direction", replaceWith = @ReplaceWith(expression = "addOval(oval)", imports = {}))
    /* synthetic */ void addOval(Rect r100);

    void addOval(Rect r100, Direction r101);

    /* JADX INFO: renamed from: addPath-Uv8p0NA */
    void mo4715addPathUv8p0NA(Path r100, long r101);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Prefer usage of addRect() with a winding direction", replaceWith = @ReplaceWith(expression = "addRect(rect)", imports = {}))
    /* synthetic */ void addRect(Rect r100);

    void addRect(Rect r100, Direction r101);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Prefer usage of addRoundRect() with a winding direction", replaceWith = @ReplaceWith(expression = "addRoundRect(roundRect)", imports = {}))
    /* synthetic */ void addRoundRect(RoundRect r100);

    void addRoundRect(RoundRect r100, Direction r101);

    Path and(Path r100);

    void arcTo(Rect r100, float r101, float r102, boolean r103);

    void arcToRad(Rect r100, float r101, float r102, boolean r103);

    void close();

    void cubicTo(float r100, float r101, float r102, float r103, float r104, float r105);

    Rect getBounds();

    /* JADX INFO: renamed from: getFillType-Rg-k1Os */
    int mo4716getFillTypeRgk1Os();

    boolean isConvex();

    boolean isEmpty();

    PathIterator iterator();

    PathIterator iterator(PathIterator.ConicEvaluation r100, float r101);

    void lineTo(float r100, float r101);

    Path minus(Path r100);

    void moveTo(float r100, float r101);

    /* JADX INFO: renamed from: op-N5in7k0 */
    boolean mo4717opN5in7k0(Path r100, Path r101, int r102);

    Path or(Path r100);

    Path plus(Path r100);

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use quadraticTo() for consistency with cubicTo()", replaceWith = @ReplaceWith(expression = "quadraticTo(x1, y1, x2, y2)", imports = {}))
    void quadraticBezierTo(float r100, float r101, float r102, float r103);

    void quadraticTo(float r100, float r101, float r102, float r103);

    void relativeCubicTo(float r100, float r101, float r102, float r103, float r104, float r105);

    void relativeLineTo(float r100, float r101);

    void relativeMoveTo(float r100, float r101);

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use relativeQuadraticTo() for consistency with relativeCubicTo()", replaceWith = @ReplaceWith(expression = "relativeQuadraticTo(dx1, dy1, dx2, dy2)", imports = {}))
    void relativeQuadraticBezierTo(float r100, float r101, float r102, float r103);

    void relativeQuadraticTo(float r100, float r101, float r102, float r103);

    void reset();

    void rewind();

    /* JADX INFO: renamed from: setFillType-oQ8Xj4U */
    void mo4718setFillTypeoQ8Xj4U(int r100);

    /* JADX INFO: renamed from: transform-58bKbWc */
    void mo4719transform58bKbWc(float[] r100);

    /* JADX INFO: renamed from: translate-k-4lQ0M */
    void mo4720translatek4lQ0M(long r100);

    Path xor(Path r100);
}
