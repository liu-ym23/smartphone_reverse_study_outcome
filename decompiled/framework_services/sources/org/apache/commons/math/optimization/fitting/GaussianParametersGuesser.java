package org.apache.commons.math.optimization.fitting;

import java.util.Arrays;
import java.util.Comparator;
import org.apache.commons.math.exception.NullArgumentException;
import org.apache.commons.math.exception.NumberIsTooSmallException;
import org.apache.commons.math.exception.OutOfRangeException;
import org.apache.commons.math.exception.ZeroException;
import org.apache.commons.math.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes3.dex */
public class GaussianParametersGuesser {
    private final WeightedObservedPoint[] observations;
    private double[] parameters;

    public GaussianParametersGuesser(WeightedObservedPoint[] observations) {
        if (observations == null) goto L11;
        if (observations.length < 3) goto L9;
        this.observations = (WeightedObservedPoint[]) observations.clone();
        return;
    L9:
        throw new NumberIsTooSmallException(Integer.valueOf(observations.length), 3, true);
    L11:
        throw new NullArgumentException(LocalizedFormats.INPUT_ARRAY);
    }

    public double[] guess() {
        if (this.parameters != null) goto L6;
        this.parameters = basicGuess(this.observations);
    L6:
        return (double[]) this.parameters.clone();
    }

    private double[] basicGuess(WeightedObservedPoint[] points) {
        WeightedObservedPoint[] r2 = points;
        Arrays.sort(r2, createWeightedObservedPointComparator());
        double[] params = new double[4];
        int minYIdx = findMinY(points);
        params[0] = r2[minYIdx].getY();
        int maxYIdx = findMaxY(points);
        params[1] = r2[maxYIdx].getY();
        params[2] = r2[maxYIdx].getX();
        double halfY = params[0] + ((params[1] - params[0]) / 2.0d);     // Catch: OutOfRangeException -> L5
        double fwhmX1 = interpolateXAtY(r2, maxYIdx, -1, halfY);     // Catch: OutOfRangeException -> L5
        r2 = points;
        double fwhmX2 = interpolateXAtY(r2, maxYIdx, 1, halfY);     // Catch: OutOfRangeException -> L5
        double fwhmX3 = fwhmX2 - fwhmX1;
    L7:
        params[3] = fwhmX3 / (Math.sqrt(Math.log(2.0d) * 2.0d) * 2.0d);
        return params;
    L6:
        fwhmX3 = r2[r2.length - 1].getX() - r2[0].getX();
        goto L7
    }

    private int findMinY(WeightedObservedPoint[] points) {
        int minYIdx = 0;
        int i = 1;
    L4:
        if (i >= points.length) goto L10;
        if (points[i].getY() >= points[minYIdx].getY()) goto L8;
        minYIdx = i;
    L8:
        i = i + 1;
        goto L4
    L10:
        return minYIdx;
    }

    private int findMaxY(WeightedObservedPoint[] points) {
        int maxYIdx = 0;
        int i = 1;
    L4:
        if (i >= points.length) goto L10;
        if (points[i].getY() <= points[maxYIdx].getY()) goto L8;
        maxYIdx = i;
    L8:
        i = i + 1;
        goto L4
    L10:
        return maxYIdx;
    }

    private double interpolateXAtY(WeightedObservedPoint[] points, int startIdx, int idxStep, double y) throws OutOfRangeException {
        if (idxStep == 0) goto L14;
        WeightedObservedPoint[] twoPoints = getInterpolationPointsForY(points, startIdx, idxStep, y);
        WeightedObservedPoint pointA = twoPoints[0];
        WeightedObservedPoint pointB = twoPoints[1];
        if (pointA.getY() != y) goto L8;
        return pointA.getX();
    L8:
        if (pointB.getY() != y) goto L12;
        return pointB.getX();
    L12:
        return pointA.getX() + (((y - pointA.getY()) * (pointB.getX() - pointA.getX())) / (pointB.getY() - pointA.getY()));
    L14:
        throw new ZeroException();
    }

    private WeightedObservedPoint[] getInterpolationPointsForY(WeightedObservedPoint[] points, int startIdx, int idxStep, double y) throws OutOfRangeException {
        if (idxStep == 0) goto L27;
        int i = startIdx;
    L4:
        int r1 = 0;
        int r2 = i + idxStep;
        if (idxStep >= 0) goto L10;
        if (r2 < 0) goto L21;
    L12:
        double y2 = y;
        if (isBetween(y2, points[i].getY(), points[i + idxStep].getY()) == true) goto L15;
        i = i + idxStep;
        y = y2;
        goto L4
    L15:
        if (idxStep >= 0) goto L18;
        return new WeightedObservedPoint[]{points[i + idxStep], points[i]};
    L18:
        return new WeightedObservedPoint[]{points[i], points[i + idxStep]};
    L21:
        double minY = Double.POSITIVE_INFINITY;
        double maxY = Double.NEGATIVE_INFINITY;
        int r0 = points.length;
    L22:
        if (r1 >= r0) goto L25;
        WeightedObservedPoint point = points[r1];
        minY = Math.min(minY, point.getY());
        maxY = Math.max(maxY, point.getY());
        r1 = r1 + 1;
        goto L22
    L25:
        throw new OutOfRangeException(Double.valueOf(y), Double.valueOf(minY), Double.valueOf(maxY));
    L10:
        if (r2 >= points.length) goto L21;
    L27:
        throw new ZeroException();
    }

    private boolean isBetween(double value, double boundary1, double boundary2) {
        if (value < boundary1) goto L7;
        if (value > boundary2) goto L7;
    L10:
        return true;
    L7:
        if (value >= boundary2) goto L9;
    L11:
        return false;
    L9:
        if (value > boundary1) goto L11;
        goto L10
    }

    private Comparator<WeightedObservedPoint> createWeightedObservedPointComparator() {
        return new AnonymousClass1(this);
    }
}
