package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.MiscUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ShapeData {
    private boolean closed;
    private final List<CubicCurveData> curves;
    private PointF initialPoint;

    public ShapeData(PointF pointF, boolean z10, List<CubicCurveData> list) {
        this.initialPoint = pointF;
        this.closed = z10;
        this.curves = new ArrayList(list);
    }

    public List<CubicCurveData> getCurves() {
        return this.curves;
    }

    public PointF getInitialPoint() {
        return this.initialPoint;
    }

    public void interpolateBetween(ShapeData shapeData, ShapeData shapeData2, float f10) {
        if (this.initialPoint == null) {
            this.initialPoint = new PointF();
        }
        this.closed = shapeData.isClosed() || shapeData2.isClosed();
        if (shapeData.getCurves().size() != shapeData2.getCurves().size()) {
            Logger.warning("Curves must have the same number of control points. Shape 1: " + shapeData.getCurves().size() + "\tShape 2: " + shapeData2.getCurves().size());
        }
        int iMin = Math.min(shapeData.getCurves().size(), shapeData2.getCurves().size());
        if (this.curves.size() < iMin) {
            for (int size = this.curves.size(); size < iMin; size++) {
                this.curves.add(new CubicCurveData());
            }
        } else if (this.curves.size() > iMin) {
            for (int size2 = this.curves.size() - 1; size2 >= iMin; size2--) {
                List<CubicCurveData> list = this.curves;
                list.remove(list.size() - 1);
            }
        }
        PointF initialPoint = shapeData.getInitialPoint();
        PointF initialPoint2 = shapeData2.getInitialPoint();
        setInitialPoint(MiscUtils.lerp(initialPoint.x, initialPoint2.x, f10), MiscUtils.lerp(initialPoint.y, initialPoint2.y, f10));
        for (int size3 = this.curves.size() - 1; size3 >= 0; size3--) {
            CubicCurveData cubicCurveData = shapeData.getCurves().get(size3);
            CubicCurveData cubicCurveData2 = shapeData2.getCurves().get(size3);
            PointF controlPoint1 = cubicCurveData.getControlPoint1();
            PointF controlPoint2 = cubicCurveData.getControlPoint2();
            PointF vertex = cubicCurveData.getVertex();
            PointF controlPoint12 = cubicCurveData2.getControlPoint1();
            PointF controlPoint22 = cubicCurveData2.getControlPoint2();
            PointF vertex2 = cubicCurveData2.getVertex();
            this.curves.get(size3).setControlPoint1(MiscUtils.lerp(controlPoint1.x, controlPoint12.x, f10), MiscUtils.lerp(controlPoint1.y, controlPoint12.y, f10));
            this.curves.get(size3).setControlPoint2(MiscUtils.lerp(controlPoint2.x, controlPoint22.x, f10), MiscUtils.lerp(controlPoint2.y, controlPoint22.y, f10));
            this.curves.get(size3).setVertex(MiscUtils.lerp(vertex.x, vertex2.x, f10), MiscUtils.lerp(vertex.y, vertex2.y, f10));
        }
    }

    public boolean isClosed() {
        return this.closed;
    }

    public void setClosed(boolean z10) {
        this.closed = z10;
    }

    public void setInitialPoint(float f10, float f11) {
        if (this.initialPoint == null) {
            this.initialPoint = new PointF();
        }
        this.initialPoint.set(f10, f11);
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.curves.size() + "closed=" + this.closed + '}';
    }

    public ShapeData() {
        this.curves = new ArrayList();
    }
}
