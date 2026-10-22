package com.baidu.platform.comapi.basestruct;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class ComplexPt {
    public static final int TEN_THOUSAND = 100000;
    public static final int TYPE_LINE = 2;
    public static final int TYPE_NONE = 0;
    public static final int TYPE_POINT = 1;
    public static final int TYPE_POLYGON = 3;
    public int eType;
    public ArrayList<ArrayList<Point>> mGeoPt;
    public Point mLL;
    public ArrayList<Point> mOriginPoints;
    public Point mRu;

    public String toString() {
        return "ComplexPt [eType=" + this.eType + ", mLL=" + this.mLL + ", mRu=" + this.mRu + ", mGeoPt=" + this.mGeoPt + "]";
    }

    public ComplexPt() {
    }

    public static ComplexPt createComplexPt(List<? extends Number> r110) {
        if (r110 != null) goto L4;
        return null;
    L4:
        if (r110.size() < 2) goto L21;
        ComplexPt r100 = new ComplexPt();
        int r101 = r110.size();
        if (r101 < 5) goto L15;
        r100.mLL = new Point(((Number) ListProtector.get(r110, 0)).doubleValue(), ((Number) ListProtector.get(r110, 1)).doubleValue());
        r100.mRu = new Point(((Number) ListProtector.get(r110, 2)).doubleValue(), ((Number) ListProtector.get(r110, 3)).doubleValue());
        r100.eType = (int) ((Number) ListProtector.get(r110, 4)).doubleValue();
        r100.mGeoPt = new ArrayList();
        int r102 = 7;
        if (r101 < 7) goto L17;
        ArrayList<Point> r103 = new ArrayList();
        Point r104 = new Point(((Number) ListProtector.get(r110, 5)).doubleValue(), ((Number) ListProtector.get(r110, 6)).doubleValue());
        r103.add(r104);
    L11:
        int r105 = r102 + 1;
        if (r105 >= r101) goto L14;
        Point r106 = new Point(r104.getDoubleX() + ((Number) ListProtector.get(r110, r102)).doubleValue(), r104.getDoubleY() + ((Number) ListProtector.get(r110, r105)).doubleValue());
        r103.add(r106);
        r102 = r102 + 2;
        r104 = r106;
        goto L11
    L14:
        r100.mGeoPt.add(r103);
    L17:
        return r100;
    L15:
        if (r101 < 2) goto L17;
        Point r107 = new Point(((Number) ListProtector.get(r110, 0)).doubleValue(), ((Number) ListProtector.get(r110, 1)).doubleValue());
        ArrayList<Point> r111 = new ArrayList();
        r111.add(r107);
        r100.mLL = new Point(r107);
        r100.mRu = new Point(r107);
        r100.eType = 1;
        ArrayList<ArrayList<Point>> r108 = new ArrayList();
        r100.mGeoPt = r108;
        r108.add(r111);
        goto L17
    L21:
        return null;
    }
}
