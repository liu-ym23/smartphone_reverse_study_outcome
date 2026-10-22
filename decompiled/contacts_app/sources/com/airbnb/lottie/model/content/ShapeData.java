package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.MiscUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ShapeData {
    private boolean closed;
    private final List<CubicCurveData> curves;
    private PointF initialPoint;

    public ShapeData(PointF r1, boolean r2, List<CubicCurveData> r3) {
        this.initialPoint = r1;
        this.closed = r2;
        this.curves = new ArrayList(r3);
    }

    public ShapeData() {
        this.curves = new ArrayList();
    }

    public void setInitialPoint(float r2, float r3) {
        if (this.initialPoint != null) goto L5;
        this.initialPoint = new PointF();
    L5:
        this.initialPoint.set(r2, r3);
    }

    public PointF getInitialPoint() {
        return this.initialPoint;
    }

    public void setClosed(boolean r1) {
        this.closed = r1;
    }

    public boolean isClosed() {
        return this.closed;
    }

    public List<CubicCurveData> getCurves() {
        return this.curves;
    }

    public void interpolateBetween(ShapeData r11, ShapeData r12, float r13) {
        if (this.initialPoint != null) goto L6;
        this.initialPoint = new PointF();
    L6:
        if (r11.isClosed() == false) goto L8;
    L11:
        boolean r0 = true;
    L12:
        this.closed = r0;
        if (r11.getCurves().size() == r12.getCurves().size()) goto L15;
        Logger.warning("Curves must have the same number of control points. Shape 1: " + r11.getCurves().size() + "\tShape 2: " + r12.getCurves().size());
    L15:
        int r1 = Math.min(r11.getCurves().size(), r12.getCurves().size());
        if (this.curves.size() >= r1) goto L21;
        int r2 = this.curves.size();
    L18:
        if (r2 >= r1) goto L25;
        this.curves.add(new CubicCurveData());
        r2 = r2 + 1;
    L25:
        PointF r3 = r11.getInitialPoint();
        PointF r4 = r12.getInitialPoint();
        setInitialPoint(MiscUtils.lerp(r3.x, r4.x, r13), MiscUtils.lerp(r3.y, r4.y, r13));
        int r5 = this.curves.size() - 1;
    L26:
        if (r5 < 0) goto L28;
        CubicCurveData r6 = r11.getCurves().get(r5);
        CubicCurveData r7 = r12.getCurves().get(r5);
        PointF r8 = r6.getControlPoint1();
        PointF r9 = r6.getControlPoint2();
        PointF r10 = r6.getVertex();
        PointF r14 = r7.getControlPoint1();
        PointF r15 = r7.getControlPoint2();
        PointF r16 = r7.getVertex();
        this.curves.get(r5).setControlPoint1(MiscUtils.lerp(r8.x, r14.x, r13), MiscUtils.lerp(r8.y, r14.y, r13));
        this.curves.get(r5).setControlPoint2(MiscUtils.lerp(r9.x, r15.x, r13), MiscUtils.lerp(r9.y, r15.y, r13));
        this.curves.get(r5).setVertex(MiscUtils.lerp(r10.x, r16.x, r13), MiscUtils.lerp(r10.y, r16.y, r13));
        r5 = r5 - 1;
        goto L26
    L28:
        return;
    L21:
        if (this.curves.size() <= r1) goto L25;
        int r17 = this.curves.size() - 1;
    L23:
        if (r17 < r1) goto L25;
        List<CubicCurveData> r18 = this.curves;
        r18.remove(r18.size() - 1);
        r17 = r17 - 1;
        goto L23
    L8:
        if (r12.isClosed() == true) goto L11;
        r0 = false;
        goto L12
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.curves.size() + "closed=" + this.closed + '}';
    }
}
