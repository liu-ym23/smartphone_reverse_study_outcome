package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.vector.PathNode;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u00000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0014\n\u0002\b\u0005\u001a!\u0010\u0004\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a_\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0013\u0010\u0014\u001a_\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0014\u0010\u001d\u001a\u00020\u0007*\u00020\u0007H\u0082\b¢\u0006\u0004\b\u001d\u0010\u001e\"\u001a\u0010 \u001a\u00020\u001f8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#¨\u0006$"}, d2 = {"", "Landroidx/compose/ui/graphics/vector/PathNode;", "Landroidx/compose/ui/graphics/Path;", TypedValues.AttributesType.S_TARGET, "toPath", "(Ljava/util/List;Landroidx/compose/ui/graphics/Path;)Landroidx/compose/ui/graphics/Path;", "p", "", "x0", "y0", "x1", "y1", "a", "b", "theta", "", "isMoreThanHalf", "isPositiveArc", "LC7/r;", "drawArc", "(Landroidx/compose/ui/graphics/Path;DDDDDDDZZ)V", "cx", "cy", "e1x", "e1y", "start", "sweep", "arcToBezier", "(Landroidx/compose/ui/graphics/Path;DDDDDDDDD)V", "toRadians", "(D)D", "", "EmptyArray", "[F", "getEmptyArray", "()[F", "ui-graphics_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PathParserKt {
    private static final float[] EmptyArray = new float[0];

    private static final void arcToBezier(Path path, double d, double d6, double d10, double d11, double d12, double d13, double d14, double d15, double d16) {
        double d17 = 4;
        int iCeil = (int) Math.ceil(Math.abs((d16 * d17) / 3.141592653589793d));
        double dCos = Math.cos(d14);
        double dSin = Math.sin(d14);
        double dCos2 = Math.cos(d15);
        double dSin2 = Math.sin(d15);
        double d18 = -d10;
        double d19 = d18 * dCos;
        double d20 = d11 * dSin;
        double d21 = (d19 * dSin2) - (d20 * dCos2);
        double d22 = d18 * dSin;
        double d23 = d11 * dCos;
        double d24 = (dCos2 * d23) + (dSin2 * d22);
        double d25 = d16 / iCeil;
        double d26 = d24;
        double d27 = d21;
        int i = 0;
        double d28 = d12;
        double d29 = d13;
        double d30 = d15;
        while (i < iCeil) {
            double d31 = d30 + d25;
            double dSin3 = Math.sin(d31);
            double dCos3 = Math.cos(d31);
            int i6 = i;
            double d32 = (((d10 * dCos) * dCos3) + d) - (d20 * dSin3);
            double d33 = d17;
            double d34 = (d23 * dSin3) + (d10 * dSin * dCos3) + d6;
            double d35 = (d19 * dSin3) - (d20 * dCos3);
            double d36 = (dCos3 * d23) + (dSin3 * d22);
            double d37 = d31 - d30;
            int i10 = iCeil;
            double dTan = Math.tan(d37 / 2);
            double dSqrt = ((Math.sqrt(((3.0d * dTan) * dTan) + d33) - 1) * Math.sin(d37)) / 3;
            path.cubicTo((float) ((d27 * dSqrt) + d28), (float) ((d26 * dSqrt) + d29), (float) (d32 - (dSqrt * d35)), (float) (d34 - (dSqrt * d36)), (float) d32, (float) d34);
            dSin = dSin;
            d25 = d25;
            d28 = d32;
            d29 = d34;
            i = i6 + 1;
            d30 = d31;
            d26 = d36;
            iCeil = i10;
            d27 = d35;
            dCos = dCos;
            d17 = d33;
        }
    }

    private static final void drawArc(Path path, double d, double d6, double d10, double d11, double d12, double d13, double d14, boolean z10, boolean z11) {
        double d15;
        double d16;
        double d17 = (d14 / 180) * 3.141592653589793d;
        double dCos = Math.cos(d17);
        double dSin = Math.sin(d17);
        double d18 = ((d6 * dSin) + (d * dCos)) / d12;
        double d19 = ((d6 * dCos) + ((-d) * dSin)) / d13;
        double d20 = ((d11 * dSin) + (d10 * dCos)) / d12;
        double d21 = ((d11 * dCos) + ((-d10) * dSin)) / d13;
        double d22 = d18 - d20;
        double d23 = d19 - d21;
        double d24 = 2;
        double d25 = (d18 + d20) / d24;
        double d26 = (d19 + d21) / d24;
        double d27 = (d23 * d23) + (d22 * d22);
        if (d27 == 0.0d) {
            return;
        }
        double d28 = (1.0d / d27) - 0.25d;
        if (d28 < 0.0d) {
            double dSqrt = (float) (Math.sqrt(d27) / 1.99999d);
            drawArc(path, d, d6, d10, d11, d12 * dSqrt, d13 * dSqrt, d14, z10, z11);
            return;
        }
        double dSqrt2 = Math.sqrt(d28);
        double d29 = d22 * dSqrt2;
        double d30 = dSqrt2 * d23;
        if (z10 == z11) {
            d15 = d25 - d30;
            d16 = d26 + d29;
        } else {
            d15 = d25 + d30;
            d16 = d26 - d29;
        }
        double dAtan2 = Math.atan2(d19 - d16, d18 - d15);
        double dAtan22 = Math.atan2(d21 - d16, d20 - d15) - dAtan2;
        if (z11 != (dAtan22 >= 0.0d)) {
            dAtan22 = dAtan22 > 0.0d ? dAtan22 - 6.283185307179586d : dAtan22 + 6.283185307179586d;
        }
        double d31 = d15 * d12;
        double d32 = d16 * d13;
        arcToBezier(path, (d31 * dCos) - (d32 * dSin), (d32 * dCos) + (d31 * dSin), d12, d13, d, d6, d17, dAtan2, dAtan22);
    }

    public static final float[] getEmptyArray() {
        return EmptyArray;
    }

    public static final Path toPath(List<? extends PathNode> list, Path path) {
        int i;
        float f;
        int i6;
        PathNode pathNode;
        float f7;
        float f9;
        float x12;
        float y12;
        float x22;
        float y22;
        float dy2;
        float f10;
        float f11;
        float dx1;
        float dy1;
        float dx2;
        float dy22;
        float y32;
        float y;
        float x10;
        float x11;
        float y9;
        List<? extends PathNode> list2 = list;
        Path path2 = path;
        int iMo4028getFillTypeRgk1Os = path2.mo4028getFillTypeRgk1Os();
        path2.rewind();
        path2.mo4030setFillTypeoQ8Xj4U(iMo4028getFillTypeRgk1Os);
        PathNode pathNode2 = list2.isEmpty() ? PathNode.Close.INSTANCE : list2.get(0);
        int size = list2.size();
        float f12 = 0.0f;
        int i10 = 0;
        float arcStartX = 0.0f;
        float arcStartY = 0.0f;
        float x13 = 0.0f;
        float y10 = 0.0f;
        float f13 = 0.0f;
        float f14 = 0.0f;
        while (i10 < size) {
            PathNode pathNode3 = list2.get(i10);
            if (pathNode3 instanceof PathNode.Close) {
                path2.close();
                i = size;
                f = f12;
                i6 = i10;
                pathNode = pathNode3;
                arcStartX = f13;
                x13 = arcStartX;
                arcStartY = f14;
            } else {
                if (pathNode3 instanceof PathNode.RelativeMoveTo) {
                    PathNode.RelativeMoveTo relativeMoveTo = (PathNode.RelativeMoveTo) pathNode3;
                    x11 = relativeMoveTo.getDx() + x13;
                    y9 = relativeMoveTo.getDy() + y10;
                    path2.relativeMoveTo(relativeMoveTo.getDx(), relativeMoveTo.getDy());
                } else if (pathNode3 instanceof PathNode.MoveTo) {
                    PathNode.MoveTo moveTo = (PathNode.MoveTo) pathNode3;
                    x11 = moveTo.getX();
                    y9 = moveTo.getY();
                    path2.moveTo(moveTo.getX(), moveTo.getY());
                } else {
                    if (pathNode3 instanceof PathNode.RelativeLineTo) {
                        PathNode.RelativeLineTo relativeLineTo = (PathNode.RelativeLineTo) pathNode3;
                        path2.relativeLineTo(relativeLineTo.getDx(), relativeLineTo.getDy());
                        x22 = relativeLineTo.getDx() + x13;
                        dy2 = relativeLineTo.getDy();
                    } else {
                        if (pathNode3 instanceof PathNode.LineTo) {
                            PathNode.LineTo lineTo = (PathNode.LineTo) pathNode3;
                            path2.lineTo(lineTo.getX(), lineTo.getY());
                            x22 = lineTo.getX();
                            y22 = lineTo.getY();
                        } else {
                            if (pathNode3 instanceof PathNode.RelativeHorizontalTo) {
                                PathNode.RelativeHorizontalTo relativeHorizontalTo = (PathNode.RelativeHorizontalTo) pathNode3;
                                path2.relativeLineTo(relativeHorizontalTo.getDx(), f12);
                                x10 = relativeHorizontalTo.getDx() + x13;
                            } else if (pathNode3 instanceof PathNode.HorizontalTo) {
                                PathNode.HorizontalTo horizontalTo = (PathNode.HorizontalTo) pathNode3;
                                path2.lineTo(horizontalTo.getX(), y10);
                                x10 = horizontalTo.getX();
                            } else {
                                if (pathNode3 instanceof PathNode.RelativeVerticalTo) {
                                    PathNode.RelativeVerticalTo relativeVerticalTo = (PathNode.RelativeVerticalTo) pathNode3;
                                    path2.relativeLineTo(f12, relativeVerticalTo.getDy());
                                    y = relativeVerticalTo.getDy() + y10;
                                } else if (pathNode3 instanceof PathNode.VerticalTo) {
                                    PathNode.VerticalTo verticalTo = (PathNode.VerticalTo) pathNode3;
                                    path2.lineTo(x13, verticalTo.getY());
                                    y = verticalTo.getY();
                                } else {
                                    if (pathNode3 instanceof PathNode.RelativeCurveTo) {
                                        PathNode.RelativeCurveTo relativeCurveTo = (PathNode.RelativeCurveTo) pathNode3;
                                        path2.relativeCubicTo(relativeCurveTo.getDx1(), relativeCurveTo.getDy1(), relativeCurveTo.getDx2(), relativeCurveTo.getDy2(), relativeCurveTo.getDx3(), relativeCurveTo.getDy3());
                                        dx1 = relativeCurveTo.getDx2() + x13;
                                        dy1 = relativeCurveTo.getDy2() + y10;
                                        dx2 = relativeCurveTo.getDx3() + x13;
                                        dy22 = relativeCurveTo.getDy3();
                                    } else if (pathNode3 instanceof PathNode.CurveTo) {
                                        PathNode.CurveTo curveTo = (PathNode.CurveTo) pathNode3;
                                        path.cubicTo(curveTo.getX1(), curveTo.getY1(), curveTo.getX2(), curveTo.getY2(), curveTo.getX3(), curveTo.getY3());
                                        dx1 = curveTo.getX2();
                                        dy1 = curveTo.getY2();
                                        dx2 = curveTo.getX3();
                                        y32 = curveTo.getY3();
                                        x13 = dx2;
                                        y10 = y32;
                                        i = size;
                                        f = f12;
                                        i6 = i10;
                                        pathNode = pathNode3;
                                        arcStartX = dx1;
                                        arcStartY = dy1;
                                        i10 = i6 + 1;
                                        path2 = path;
                                        pathNode2 = pathNode;
                                        size = i;
                                        f12 = f;
                                        list2 = list;
                                    } else if (pathNode3 instanceof PathNode.RelativeReflectiveCurveTo) {
                                        if (pathNode2.getIsCurve()) {
                                            float f15 = x13 - arcStartX;
                                            f11 = y10 - arcStartY;
                                            f10 = f15;
                                        } else {
                                            f10 = f12;
                                            f11 = f10;
                                        }
                                        PathNode.RelativeReflectiveCurveTo relativeReflectiveCurveTo = (PathNode.RelativeReflectiveCurveTo) pathNode3;
                                        path.relativeCubicTo(f10, f11, relativeReflectiveCurveTo.getDx1(), relativeReflectiveCurveTo.getDy1(), relativeReflectiveCurveTo.getDx2(), relativeReflectiveCurveTo.getDy2());
                                        dx1 = relativeReflectiveCurveTo.getDx1() + x13;
                                        dy1 = relativeReflectiveCurveTo.getDy1() + y10;
                                        dx2 = relativeReflectiveCurveTo.getDx2() + x13;
                                        dy22 = relativeReflectiveCurveTo.getDy2();
                                    } else {
                                        if (pathNode3 instanceof PathNode.ReflectiveCurveTo) {
                                            if (pathNode2.getIsCurve()) {
                                                float f16 = 2;
                                                x13 = (x13 * f16) - arcStartX;
                                                y10 = (f16 * y10) - arcStartY;
                                            }
                                            PathNode.ReflectiveCurveTo reflectiveCurveTo = (PathNode.ReflectiveCurveTo) pathNode3;
                                            path.cubicTo(x13, y10, reflectiveCurveTo.getX1(), reflectiveCurveTo.getY1(), reflectiveCurveTo.getX2(), reflectiveCurveTo.getY2());
                                            x12 = reflectiveCurveTo.getX1();
                                            y12 = reflectiveCurveTo.getY1();
                                            float x23 = reflectiveCurveTo.getX2();
                                            float y23 = reflectiveCurveTo.getY2();
                                            x13 = x23;
                                            y10 = y23;
                                        } else if (pathNode3 instanceof PathNode.RelativeQuadTo) {
                                            PathNode.RelativeQuadTo relativeQuadTo = (PathNode.RelativeQuadTo) pathNode3;
                                            path.relativeQuadraticTo(relativeQuadTo.getDx1(), relativeQuadTo.getDy1(), relativeQuadTo.getDx2(), relativeQuadTo.getDy2());
                                            arcStartX = relativeQuadTo.getDx1() + x13;
                                            arcStartY = relativeQuadTo.getDy1() + y10;
                                            x22 = relativeQuadTo.getDx2() + x13;
                                            dy2 = relativeQuadTo.getDy2();
                                        } else if (pathNode3 instanceof PathNode.QuadTo) {
                                            PathNode.QuadTo quadTo = (PathNode.QuadTo) pathNode3;
                                            path.quadraticTo(quadTo.getX1(), quadTo.getY1(), quadTo.getX2(), quadTo.getY2());
                                            arcStartX = quadTo.getX1();
                                            arcStartY = quadTo.getY1();
                                            x22 = quadTo.getX2();
                                            y22 = quadTo.getY2();
                                        } else if (pathNode3 instanceof PathNode.RelativeReflectiveQuadTo) {
                                            if (pathNode2.getIsQuad()) {
                                                f7 = x13 - arcStartX;
                                                f9 = y10 - arcStartY;
                                            } else {
                                                f7 = f12;
                                                f9 = f7;
                                            }
                                            PathNode.RelativeReflectiveQuadTo relativeReflectiveQuadTo = (PathNode.RelativeReflectiveQuadTo) pathNode3;
                                            path.relativeQuadraticTo(f7, f9, relativeReflectiveQuadTo.getDx(), relativeReflectiveQuadTo.getDy());
                                            x12 = f7 + x13;
                                            y12 = f9 + y10;
                                            float dx = relativeReflectiveQuadTo.getDx() + x13;
                                            y10 = relativeReflectiveQuadTo.getDy() + y10;
                                            x13 = dx;
                                        } else if (pathNode3 instanceof PathNode.ReflectiveQuadTo) {
                                            if (pathNode2.getIsQuad()) {
                                                float f17 = 2;
                                                x13 = (x13 * f17) - arcStartX;
                                                y10 = (f17 * y10) - arcStartY;
                                            }
                                            PathNode.ReflectiveQuadTo reflectiveQuadTo = (PathNode.ReflectiveQuadTo) pathNode3;
                                            path.quadraticTo(x13, y10, reflectiveQuadTo.getX(), reflectiveQuadTo.getY());
                                            float f18 = x13;
                                            x13 = reflectiveQuadTo.getX();
                                            arcStartX = f18;
                                            i = size;
                                            f = f12;
                                            i6 = i10;
                                            arcStartY = y10;
                                            pathNode = pathNode3;
                                            y10 = reflectiveQuadTo.getY();
                                            i10 = i6 + 1;
                                            path2 = path;
                                            pathNode2 = pathNode;
                                            size = i;
                                            f12 = f;
                                            list2 = list;
                                        } else if (pathNode3 instanceof PathNode.RelativeArcTo) {
                                            PathNode.RelativeArcTo relativeArcTo = (PathNode.RelativeArcTo) pathNode3;
                                            float arcStartDx = relativeArcTo.getArcStartDx() + x13;
                                            float arcStartDy = relativeArcTo.getArcStartDy() + y10;
                                            f = f12;
                                            pathNode = pathNode3;
                                            i = size;
                                            i6 = i10;
                                            drawArc(path, x13, y10, arcStartDx, arcStartDy, relativeArcTo.getHorizontalEllipseRadius(), relativeArcTo.getVerticalEllipseRadius(), relativeArcTo.getTheta(), relativeArcTo.isMoreThanHalf(), relativeArcTo.isPositiveArc());
                                            arcStartX = arcStartDx;
                                            x13 = arcStartX;
                                            arcStartY = arcStartDy;
                                        } else {
                                            i = size;
                                            f = f12;
                                            i6 = i10;
                                            pathNode = pathNode3;
                                            if (!(pathNode instanceof PathNode.ArcTo)) {
                                                throw new NoWhenBranchMatchedException();
                                            }
                                            PathNode.ArcTo arcTo = (PathNode.ArcTo) pathNode;
                                            drawArc(path, x13, y10, arcTo.getArcStartX(), arcTo.getArcStartY(), arcTo.getHorizontalEllipseRadius(), arcTo.getVerticalEllipseRadius(), arcTo.getTheta(), arcTo.isMoreThanHalf(), arcTo.isPositiveArc());
                                            arcStartX = arcTo.getArcStartX();
                                            x13 = arcStartX;
                                            arcStartY = arcTo.getArcStartY();
                                        }
                                        i = size;
                                        f = f12;
                                        i6 = i10;
                                        pathNode = pathNode3;
                                        arcStartY = y12;
                                        arcStartX = x12;
                                        i10 = i6 + 1;
                                        path2 = path;
                                        pathNode2 = pathNode;
                                        size = i;
                                        f12 = f;
                                        list2 = list;
                                    }
                                    y32 = dy22 + y10;
                                    x13 = dx2;
                                    y10 = y32;
                                    i = size;
                                    f = f12;
                                    i6 = i10;
                                    pathNode = pathNode3;
                                    arcStartX = dx1;
                                    arcStartY = dy1;
                                    i10 = i6 + 1;
                                    path2 = path;
                                    pathNode2 = pathNode;
                                    size = i;
                                    f12 = f;
                                    list2 = list;
                                }
                                y10 = y;
                                i = size;
                                f = f12;
                                i6 = i10;
                                pathNode = pathNode3;
                                i10 = i6 + 1;
                                path2 = path;
                                pathNode2 = pathNode;
                                size = i;
                                f12 = f;
                                list2 = list;
                            }
                            x13 = x10;
                            i = size;
                            f = f12;
                            i6 = i10;
                            pathNode = pathNode3;
                            i10 = i6 + 1;
                            path2 = path;
                            pathNode2 = pathNode;
                            size = i;
                            f12 = f;
                            list2 = list;
                        }
                        y10 = y22;
                        x13 = x22;
                        i = size;
                        f = f12;
                        i6 = i10;
                        pathNode = pathNode3;
                        i10 = i6 + 1;
                        path2 = path;
                        pathNode2 = pathNode;
                        size = i;
                        f12 = f;
                        list2 = list;
                    }
                    y22 = dy2 + y10;
                    y10 = y22;
                    x13 = x22;
                    i = size;
                    f = f12;
                    i6 = i10;
                    pathNode = pathNode3;
                    i10 = i6 + 1;
                    path2 = path;
                    pathNode2 = pathNode;
                    size = i;
                    f12 = f;
                    list2 = list;
                }
                x13 = x11;
                f13 = x13;
                y10 = y9;
                f14 = y10;
                i = size;
                f = f12;
                i6 = i10;
                pathNode = pathNode3;
                i10 = i6 + 1;
                path2 = path;
                pathNode2 = pathNode;
                size = i;
                f12 = f;
                list2 = list;
            }
            y10 = arcStartY;
            i10 = i6 + 1;
            path2 = path;
            pathNode2 = pathNode;
            size = i;
            f12 = f;
            list2 = list;
        }
        return path;
    }

    public static /* synthetic */ Path toPath$default(List list, Path path, int i, Object obj) {
        if ((i & 1) != 0) {
            path = AndroidPath_androidKt.Path();
        }
        return toPath(list, path);
    }

    private static final double toRadians(double d) {
        return (d / 180) * 3.141592653589793d;
    }
}
