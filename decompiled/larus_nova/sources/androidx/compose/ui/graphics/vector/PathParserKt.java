package androidx.compose.ui.graphics.vector;

import androidx.camera.video.AudioStats;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Path;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\u001a\u001a\u0010\u0004\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\u0005\u001aX\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0002\u001aX\u0010\u0017\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\rH\u0002\u001a\r\u0010\u001e\u001a\u00020\r*\u00020\rH\u0082\b\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u001f"}, d2 = {"EmptyArray", "", "getEmptyArray", "()[F", "toPath", "Landroidx/compose/ui/graphics/Path;", "", "Landroidx/compose/ui/graphics/vector/PathNode;", PickerReporterConstants.KEY.TARGET, "drawArc", "", "p", "x0", "", "y0", "x1", "y1", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "theta", "isMoreThanHalf", "", "isPositiveArc", "arcToBezier", "cx", "cy", "e1x", "e1y", "start", "sweep", "toRadians", "ui-graphics_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PathParserKt {
    private static final float[] EmptyArray = null;

    static {
        EmptyArray = new float[0];
    }

    private static final double toRadians(double r100) {
        return (r100 / ((double) 180)) * 3.141592653589793d;
    }

    public static final float[] getEmptyArray() {
        return EmptyArray;
    }

    public static final Path toPath(List<? extends PathNode> r210, Path r211) {
        List<? extends PathNode> r100 = r210;
        Path r110 = r211;
        int r101 = r211.mo4716getFillTypeRgk1Os();
        r211.rewind();
        r110.mo4718setFillTypeoQ8Xj4U(r101);
        if (r210.isEmpty() == false) goto L5;
        PathNode r102 = PathNode.Close.INSTANCE;
    L6:
        int r111 = r100.size();
        float r112 = 0.0f;
        float r103 = 0.0f;
        float r104 = 0.0f;
        float r105 = 0.0f;
        float r106 = 0.0f;
        int r113 = 0;
        float r114 = 0.0f;
        float r115 = 0.0f;
    L7:
        if (r113 >= r111) goto L91;
        PathNode r116 = (PathNode) ListProtector.get(r100, r113);
        if ((r116 instanceof PathNode.Close) == false) goto L13;
        r211.close();
        r103 = r114;
        r105 = r103;
        r104 = r115;
        r106 = r104;
    L88:
        r113 = r113 + 1;
        r110 = r211;
        r102 = r116;
        r111 = r111;
        r112 = 0.0f;
        r100 = r210;
        goto L7
    L13:
        if ((r116 instanceof PathNode.RelativeMoveTo) == false) goto L18;
        PathNode.RelativeMoveTo r107 = (PathNode.RelativeMoveTo) r116;
        r105 = r105 + r107.getDx();
        r106 = r106 + r107.getDy();
        r110.relativeMoveTo(r107.getDx(), r107.getDy());
        r114 = r105;
    L15:
        r115 = r106;
        goto L88
    L18:
        if ((r116 instanceof PathNode.MoveTo) == false) goto L21;
        PathNode.MoveTo r108 = (PathNode.MoveTo) r116;
        float r109 = r108.getX();
        float r117 = r108.getY();
        r110.moveTo(r108.getX(), r108.getY());
        r105 = r109;
        r114 = r105;
        r106 = r117;
        goto L15
    L21:
        if ((r116 instanceof PathNode.RelativeLineTo) == false) goto L25;
        PathNode.RelativeLineTo r118 = (PathNode.RelativeLineTo) r116;
        r110.relativeLineTo(r118.getDx(), r118.getDy());
        r105 = r105 + r118.getDx();
        float r119 = r118.getDy();
    L23:
        r106 = r106 + r119;
        goto L88
    L25:
        if ((r116 instanceof PathNode.LineTo) == false) goto L29;
        PathNode.LineTo r120 = (PathNode.LineTo) r116;
        r110.lineTo(r120.getX(), r120.getY());
        float r121 = r120.getX();
        float r122 = r120.getY();
    L27:
        r106 = r122;
        r105 = r121;
        goto L88
    L29:
        if ((r116 instanceof PathNode.RelativeHorizontalTo) == false) goto L32;
        PathNode.RelativeHorizontalTo r123 = (PathNode.RelativeHorizontalTo) r116;
        r110.relativeLineTo(r123.getDx(), r112);
        r105 = r105 + r123.getDx();
        goto L88
    L32:
        if ((r116 instanceof PathNode.HorizontalTo) == false) goto L35;
        PathNode.HorizontalTo r124 = (PathNode.HorizontalTo) r116;
        r110.lineTo(r124.getX(), r106);
        r105 = r124.getX();
        goto L88
    L35:
        if ((r116 instanceof PathNode.RelativeVerticalTo) == false) goto L38;
        PathNode.RelativeVerticalTo r125 = (PathNode.RelativeVerticalTo) r116;
        r110.relativeLineTo(r112, r125.getDy());
        r119 = r125.getDy();
        goto L23
    L38:
        if ((r116 instanceof PathNode.VerticalTo) == false) goto L41;
        PathNode.VerticalTo r126 = (PathNode.VerticalTo) r116;
        r110.lineTo(r105, r126.getY());
        r106 = r126.getY();
        goto L88
    L41:
        if ((r116 instanceof PathNode.RelativeCurveTo) == false) goto L46;
        PathNode.RelativeCurveTo r127 = (PathNode.RelativeCurveTo) r116;
        r211.relativeCubicTo(r127.getDx1(), r127.getDy1(), r127.getDx2(), r127.getDy2(), r127.getDx3(), r127.getDy3());
        float r128 = r127.getDx2() + r105;
        float r129 = r127.getDy2() + r106;
        r105 = r105 + r127.getDx3();
        float r130 = r127.getDy3();
    L43:
        r106 = r106 + r130;
        r104 = r129;
    L44:
        r103 = r128;
        goto L88
    L46:
        if ((r116 instanceof PathNode.CurveTo) == false) goto L50;
        PathNode.CurveTo r131 = (PathNode.CurveTo) r116;
        r211.cubicTo(r131.getX1(), r131.getY1(), r131.getX2(), r131.getY2(), r131.getX3(), r131.getY3());
        r128 = r131.getX2();
        float r132 = r131.getY2();
        float r133 = r131.getX3();
        float r134 = r131.getY3();
    L48:
        r105 = r133;
        r106 = r134;
        r104 = r132;
        goto L44
    L50:
        if ((r116 instanceof PathNode.RelativeReflectiveCurveTo) == false) goto L57;
        if (r102.isCurve() == false) goto L54;
        float r135 = r106 - r104;
        float r136 = r105 - r103;
    L55:
        PathNode.RelativeReflectiveCurveTo r137 = (PathNode.RelativeReflectiveCurveTo) r116;
        r211.relativeCubicTo(r136, r135, r137.getDx1(), r137.getDy1(), r137.getDx2(), r137.getDy2());
        r128 = r137.getDx1() + r105;
        r129 = r137.getDy1() + r106;
        r105 = r105 + r137.getDx2();
        r130 = r137.getDy2();
        goto L43
    L54:
        r136 = 0.0f;
        r135 = 0.0f;
        goto L55
    L57:
        if ((r116 instanceof PathNode.ReflectiveCurveTo) == false) goto L64;
        if (r102.isCurve() == false) goto L61;
        float r138 = 2;
        float r139 = (r138 * r106) - r104;
        float r140 = (r105 * r138) - r103;
    L62:
        PathNode.ReflectiveCurveTo r141 = (PathNode.ReflectiveCurveTo) r116;
        r211.cubicTo(r140, r139, r141.getX1(), r141.getY1(), r141.getX2(), r141.getY2());
        r128 = r141.getX1();
        r132 = r141.getY1();
        r133 = r141.getX2();
        r134 = r141.getY2();
        goto L48
    L61:
        r140 = r105;
        r139 = r106;
        goto L62
    L64:
        if ((r116 instanceof PathNode.RelativeQuadTo) == false) goto L67;
        PathNode.RelativeQuadTo r142 = (PathNode.RelativeQuadTo) r116;
        r110.relativeQuadraticTo(r142.getDx1(), r142.getDy1(), r142.getDx2(), r142.getDy2());
        r103 = r142.getDx1() + r105;
        r104 = r142.getDy1() + r106;
        r105 = r105 + r142.getDx2();
        r119 = r142.getDy2();
        goto L23
    L67:
        if ((r116 instanceof PathNode.QuadTo) == false) goto L70;
        PathNode.QuadTo r143 = (PathNode.QuadTo) r116;
        r110.quadraticTo(r143.getX1(), r143.getY1(), r143.getX2(), r143.getY2());
        r103 = r143.getX1();
        r104 = r143.getY1();
        r121 = r143.getX2();
        r122 = r143.getY2();
        goto L27
    L70:
        if ((r116 instanceof PathNode.RelativeReflectiveQuadTo) == false) goto L77;
        if (r102.isQuad() == false) goto L74;
        float r144 = r105 - r103;
        float r145 = r106 - r104;
    L75:
        PathNode.RelativeReflectiveQuadTo r146 = (PathNode.RelativeReflectiveQuadTo) r116;
        r110.relativeQuadraticTo(r144, r145, r146.getDx(), r146.getDy());
        r128 = r144 + r105;
        r129 = r145 + r106;
        r105 = r105 + r146.getDx();
        r130 = r146.getDy();
        goto L43
    L74:
        r144 = 0.0f;
        r145 = 0.0f;
        goto L75
    L77:
        if ((r116 instanceof PathNode.ReflectiveQuadTo) == false) goto L83;
        if (r102.isQuad() == false) goto L81;
        float r147 = 2;
        r105 = (r105 * r147) - r103;
        r106 = (r147 * r106) - r104;
    L81:
        PathNode.ReflectiveQuadTo r148 = (PathNode.ReflectiveQuadTo) r116;
        r110.quadraticTo(r105, r106, r148.getX(), r148.getY());
        float r149 = r148.getX();
        r104 = r106;
        r116 = r116;
        r113 = r113;
        r111 = r111;
        r106 = r148.getY();
        float r212 = r105;
        r105 = r149;
        r103 = r212;
        goto L88
    L83:
        if ((r116 instanceof PathNode.RelativeArcTo) == false) goto L85;
        PathNode.RelativeArcTo r150 = (PathNode.RelativeArcTo) r116;
        float r151 = r150.getArcStartDx() + r105;
        float r152 = r150.getArcStartDy() + r106;
        r116 = r116;
        r113 = r113;
        r111 = r111;
        drawArc(r211, r105, r106, r151, r152, r150.getHorizontalEllipseRadius(), r150.getVerticalEllipseRadius(), r150.getTheta(), r150.isMoreThanHalf(), r150.isPositiveArc());
        r104 = r152;
        r106 = r104;
        r103 = r151;
        r105 = r103;
        goto L88
    L85:
        r116 = r116;
        r113 = r113;
        r111 = r111;
        if ((r116 instanceof PathNode.ArcTo) == false) goto L90;
        PathNode.ArcTo r213 = (PathNode.ArcTo) r116;
        drawArc(r211, r105, r106, r213.getArcStartX(), r213.getArcStartY(), r213.getHorizontalEllipseRadius(), r213.getVerticalEllipseRadius(), r213.getTheta(), r213.isMoreThanHalf(), r213.isPositiveArc());
        r105 = r213.getArcStartX();
        r104 = r213.getArcStartY();
        r106 = r104;
        r103 = r105;
        goto L88
    L90:
        throw new NoWhenBranchMatchedException();
    L91:
        return r211;
    L5:
        r102 = (PathNode) ListProtector.get(r100, 0);
        goto L6
    }

    public static /* synthetic */ Path toPath$default(List r100, Path r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = AndroidPath_androidKt.Path();
    L6:
        return toPath(r100, r101);
    }

    private static final void arcToBezier(Path r410, double r411, double r510, double r511, double r512, double r513, double r514, double r610, double r611, double r612) {
        double r100 = r511;
        double r101 = 4;
        int r102 = (int) Math.ceil(Math.abs((r612 * r101) / 3.141592653589793d));
        double r103 = Math.cos(r610);
        double r104 = Math.sin(r610);
        double r105 = Math.cos(r611);
        double r110 = Math.sin(r611);
        double r111 = -r100;
        double r112 = r111 * r103;
        double r113 = r512 * r104;
        double r114 = (r112 * r110) - (r113 * r105);
        double r115 = r111 * r104;
        double r210 = r512 * r103;
        double r116 = (r110 * r115) + (r105 * r210);
        double r106 = r612 / ((double) r102);
        double r515 = r513;
        double r211 = r611;
        double r212 = r116;
        double r213 = r114;
        int r117 = 0;
        double r118 = r514;
    L3:
        if (r117 >= r102) goto L5;
        double r214 = r211 + r106;
        double r310 = Math.sin(r214);
        double r311 = Math.cos(r214);
        int r119 = r102;
        double r107 = (r411 + ((r100 * r103) * r311)) - (r113 * r310);
        double r108 = (r510 + ((r100 * r104) * r311)) + (r210 * r310);
        double r312 = (r112 * r310) - (r113 * r311);
        double r313 = (r310 * r115) + (r311 * r210);
        double r215 = r214 - r211;
        double r109 = Math.tan(r215 / ((double) 2));
        double r314 = r101;
        double r216 = (Math.sin(r215) * (Math.sqrt(r101 + ((3.0d * r109) * r109)) - ((double) 1))) / ((double) 3);
        r410.cubicTo((float) (r515 + (r213 * r216)), (float) (r118 + (r212 * r216)), (float) (r107 - (r216 * r312)), (float) (r108 - (r216 * r313)), (float) r107, (float) r108);
        r117 = r117 + 1;
        r106 = r106;
        r104 = r104;
        r515 = r107;
        r115 = r115;
        r211 = r214;
        r212 = r313;
        r101 = r314;
        r213 = r312;
        r103 = r103;
        r102 = r119;
        r118 = r108;
        r100 = r511;
        goto L3
    }

    private static final void drawArc(Path r310, double r311, double r312, double r313, double r410, double r411, double r412, double r413, boolean r414, boolean r415) {
        double r110 = (r413 / ((double) 180)) * 3.141592653589793d;
        double r100 = Math.cos(r110);
        double r101 = Math.sin(r110);
        double r102 = ((r311 * r100) + (r312 * r101)) / r411;
        double r103 = (((-r311) * r101) + (r312 * r100)) / r412;
        double r111 = ((r313 * r100) + (r410 * r101)) / r411;
        double r112 = (((-r313) * r101) + (r410 * r100)) / r412;
        double r113 = r102 - r111;
        double r210 = r103 - r112;
        double r104 = 2;
        double r211 = (r102 + r111) / r104;
        double r212 = (r103 + r112) / r104;
        double r105 = (r113 * r113) + (r210 * r210);
        if (r105 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
        boolean r213 = true;
    L6:
        if (r213 == false) goto L8;
        return;
    L8:
        double r214 = (1.0d / r105) - 0.25d;
        if (r214 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L12;
        double r106 = (float) (Math.sqrt(r105) / 1.99999d);
        drawArc(r310, r311, r312, r313, r410, r411 * r106, r412 * r106, r413, r414, r415);
        return;
    L12:
        double r107 = Math.sqrt(r214);
        double r114 = r113 * r107;
        double r108 = r107 * r210;
        if (r414 != r415) goto L15;
        double r215 = r211 - r108;
        double r216 = r212 + r114;
    L16:
        double r115 = Math.atan2(r103 - r216, r102 - r215);
        double r109 = Math.atan2(r112 - r216, r111 - r215) - r115;
        if (r109 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L19;
        boolean r116 = true;
    L20:
        if (r415 != r116) goto L22;
    L25:
        double r217 = r215 * r411;
        double r218 = r216 * r412;
        arcToBezier(r310, (r217 * r100) - (r218 * r101), (r217 * r101) + (r218 * r100), r411, r412, r311, r312, r110, r115, r109);
        return;
    L22:
        if (r109 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L24;
        r109 = r109 - 6.283185307179586d;
        goto L25
    L24:
        r109 = r109 + 6.283185307179586d;
        goto L25
    L19:
        r116 = false;
        goto L20
    L15:
        r215 = r211 + r108;
        r216 = r212 - r114;
        goto L16
    L5:
        r213 = false;
        goto L6
    }
}
