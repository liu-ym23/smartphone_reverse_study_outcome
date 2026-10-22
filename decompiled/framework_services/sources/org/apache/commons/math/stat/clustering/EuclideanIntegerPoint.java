package org.apache.commons.math.stat.clustering;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.math.util.MathUtils;

/* JADX INFO: loaded from: classes3.dex */
public class EuclideanIntegerPoint implements Clusterable<EuclideanIntegerPoint>, Serializable {
    private static final long serialVersionUID = 3946024775784901369L;
    private final int[] point;

    @Override // org.apache.commons.math.stat.clustering.Clusterable
    public /* bridge */ /* synthetic */ EuclideanIntegerPoint centroidOf(Collection<EuclideanIntegerPoint> r1) {
        return centroidOf2(r1);
    }

    @Override // org.apache.commons.math.stat.clustering.Clusterable
    public /* bridge */ /* synthetic */ double distanceFrom(EuclideanIntegerPoint r3) {
        return distanceFrom2(r3);
    }

    public EuclideanIntegerPoint(int[] point) {
        this.point = point;
    }

    public int[] getPoint() {
        return this.point;
    }

    /* JADX INFO: renamed from: distanceFrom, reason: avoid collision after fix types in other method */
    public double distanceFrom2(EuclideanIntegerPoint p) {
        return MathUtils.distance(this.point, p.getPoint());
    }

    @Override // org.apache.commons.math.stat.clustering.Clusterable
    /* JADX INFO: renamed from: centroidOf, reason: avoid collision after fix types in other method */
    public EuclideanIntegerPoint centroidOf2(Collection<EuclideanIntegerPoint> points) {
        int[] centroid = new int[getPoint().length];
        Iterator<EuclideanIntegerPoint> r1 = points.iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        EuclideanIntegerPoint p = r1.next();
        int i = 0;
    L7:
        if (i >= centroid.length) goto L4;
        centroid[i] = centroid[i] + p.getPoint()[i];
        i = i + 1;
        goto L7
    L10:
        int i2 = 0;
    L12:
        if (i2 >= centroid.length) goto L15;
        centroid[i2] = centroid[i2] / points.size();
        i2 = i2 + 1;
        goto L12
    L15:
        return new EuclideanIntegerPoint(centroid);
    }

    public boolean equals(Object other) {
        if ((other instanceof EuclideanIntegerPoint) == true) goto L5;
        return false;
    L5:
        int[] otherPoint = ((EuclideanIntegerPoint) other).getPoint();
        if (this.point.length == otherPoint.length) goto L8;
        return false;
    L8:
        int i = 0;
    L10:
        if (i >= this.point.length) goto L15;
        if (this.point[i] != otherPoint[i]) goto L13;
        i = i + 1;
        goto L10
    L13:
        return false;
    L15:
        return true;
    }

    public int hashCode() {
        int hashCode = 0;
        int[] r1 = this.point;
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        Integer i = Integer.valueOf(r1[r3]);
        hashCode = hashCode + ((i.hashCode() * 13) + 7);
        r3 = r3 + 1;
        goto L3
    L5:
        return hashCode;
    }

    public String toString() {
        StringBuilder buff = new StringBuilder("(");
        int[] coordinates = getPoint();
        int i = 0;
    L4:
        if (i >= coordinates.length) goto L9;
        buff.append(coordinates[i]);
        if (i >= (coordinates.length - 1)) goto L8;
        buff.append(",");
    L8:
        i = i + 1;
        goto L4
    L9:
        buff.append(")");
        return buff.toString();
    }
}
