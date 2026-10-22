package org.apache.commons.math.stat.clustering;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.apache.commons.math.exception.ConvergenceException;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.stat.clustering.Clusterable;
import org.apache.commons.math.stat.descriptive.moment.Variance;

/* JADX INFO: loaded from: classes3.dex */
public class KMeansPlusPlusClusterer<T extends Clusterable<T>> {
    private final EmptyClusterStrategy emptyStrategy;
    private final Random random;

    public static final enum EmptyClusterStrategy extends Enum<EmptyClusterStrategy> {
        private static final /* synthetic */ EmptyClusterStrategy[] $VALUES = null;
        public static final EmptyClusterStrategy ERROR = null;
        public static final EmptyClusterStrategy FARTHEST_POINT = null;
        public static final EmptyClusterStrategy LARGEST_POINTS_NUMBER = null;
        public static final EmptyClusterStrategy LARGEST_VARIANCE = null;

        private static /* synthetic */ EmptyClusterStrategy[] $values() {
            return new EmptyClusterStrategy[]{LARGEST_VARIANCE, LARGEST_POINTS_NUMBER, FARTHEST_POINT, ERROR};
        }

        private EmptyClusterStrategy(String r1, int r2) {
            super(r1, r2);
        }

        public static EmptyClusterStrategy valueOf(String name) {
            return (EmptyClusterStrategy) Enum.valueOf(EmptyClusterStrategy.class, name);
        }

        public static EmptyClusterStrategy[] values() {
            return (EmptyClusterStrategy[]) $VALUES.clone();
        }

        static {
            LARGEST_VARIANCE = new EmptyClusterStrategy("LARGEST_VARIANCE", 0);
            LARGEST_POINTS_NUMBER = new EmptyClusterStrategy("LARGEST_POINTS_NUMBER", 1);
            FARTHEST_POINT = new EmptyClusterStrategy("FARTHEST_POINT", 2);
            ERROR = new EmptyClusterStrategy("ERROR", 3);
            $VALUES = $values();
        }
    }

    public KMeansPlusPlusClusterer(Random random) {
        this(random, EmptyClusterStrategy.LARGEST_VARIANCE);
    }

    public KMeansPlusPlusClusterer(Random random, EmptyClusterStrategy emptyStrategy) {
        this.random = random;
        this.emptyStrategy = emptyStrategy;
    }

    public List<Cluster<T>> cluster(Collection<T> points, int k, int maxIterations) {
        List<Cluster<T>> clusters = chooseInitialCenters(points, k, this.random);
        assignPointsToClusters(clusters, points);
        if (maxIterations >= 0) goto L5;
        int max = Integer.MAX_VALUE;
    L6:
        int count = 0;
    L7:
        if (count >= max) goto L29;
        boolean clusteringChanged = false;
        List<Cluster<T>> newClusters = new ArrayList();
        Iterator<Cluster<T>> r5 = clusters.iterator();
    L10:
        if (r5.hasNext() == false) goto L25;
        Cluster<T> cluster = r5.next();
        if (cluster.getPoints().isEmpty() == true) goto L14;
        Clusterable r7 = (Clusterable) cluster.getCenter().centroidOf(cluster.getPoints());
        if (r7.equals(cluster.getCenter()) == true) goto L24;
        clusteringChanged = true;
    L24:
        newClusters.add(new Cluster(r7));
        goto L10
    L14:
        switch(this.emptyStrategy.ordinal()) {
            case 0: goto L19;
            case 1: goto L18;
            case 2: goto L17;
            default: goto L16;
        };
    L17:
        r7 = getFarthestPoint(clusters);
    L20:
        clusteringChanged = true;
        goto L24
    L18:
        r7 = getPointFromLargestNumberCluster(clusters);
        goto L20
    L19:
        r7 = getPointFromLargestVarianceCluster(clusters);
        goto L20
    L16:
        throw new ConvergenceException(LocalizedFormats.EMPTY_CLUSTER_IN_K_MEANS);
    L25:
        if (clusteringChanged == false) goto L26;
        assignPointsToClusters(newClusters, points);
        clusters = newClusters;
        count = count + 1;
        goto L7
    L26:
        return clusters;
    L29:
        return clusters;
    L5:
        max = maxIterations;
        goto L6
    }

    private static <T extends Clusterable<T>> void assignPointsToClusters(Collection<Cluster<T>> clusters, Collection<T> points) {
        Iterator<T> r0 = points.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        T p = r0.next();
        Cluster<T> cluster = getNearestCluster(clusters, p);
        cluster.addPoint(p);
        goto L4
    }

    private static <T extends Clusterable<T>> List<Cluster<T>> chooseInitialCenters(Collection<T> points, int k, Random random) {
        List<T> pointSet = new ArrayList(points);
        List<Cluster<T>> resultSet = new ArrayList();
        T firstPoint = pointSet.remove(random.nextInt(pointSet.size()));
        resultSet.add(new Cluster(firstPoint));
        double[] dx2 = new double[pointSet.size()];
    L4:
        if (resultSet.size() >= k) goto L17;
        int sum = 0;
        int i = 0;
    L7:
        if (i >= pointSet.size()) goto L9;
        T p = pointSet.get(i);
        Cluster<T> nearest = getNearestCluster(resultSet, p);
        double d = p.distanceFrom(nearest.getCenter());
        sum = (int) (((double) sum) + (d * d));
        dx2[i] = sum;
        i = i + 1;
        goto L7
    L9:
        double r = random.nextDouble() * ((double) sum);
        int i2 = 0;
    L11:
        if (i2 >= dx2.length) goto L4;
        if (dx2[i2] >= r) goto L14;
        i2 = i2 + 1;
        goto L11
    L14:
        resultSet.add(new Cluster(pointSet.remove(i2)));
        goto L4
    L17:
        return resultSet;
    }

    private T getPointFromLargestVarianceCluster(Collection<Cluster<T>> clusters) {
        double maxVariance = Double.NEGATIVE_INFINITY;
        Cluster<T> selected = null;
        Iterator<Cluster<T>> r3 = clusters.iterator();
    L4:
        if (r3.hasNext() == false) goto L15;
        Cluster<T> cluster = r3.next();
        if (cluster.getPoints().isEmpty() == true) goto L4;
        Clusterable r5 = cluster.getCenter();
        Variance stat = new Variance();
        Iterator<T> r7 = cluster.getPoints().iterator();
    L9:
        if (r7.hasNext() == false) goto L11;
        T point = r7.next();
        stat.increment(point.distanceFrom(r5));
        goto L9
    L11:
        double variance = stat.getResult();
        if (variance <= maxVariance) goto L4;
        maxVariance = variance;
        selected = cluster;
        goto L4
    L15:
        if (selected == null) goto L19;
        List<T> selectedPoints = selected.getPoints();
        return selectedPoints.remove(this.random.nextInt(selectedPoints.size()));
    L19:
        throw new ConvergenceException(LocalizedFormats.EMPTY_CLUSTER_IN_K_MEANS);
    }

    private T getPointFromLargestNumberCluster(Collection<Cluster<T>> clusters) {
        int maxNumber = 0;
        Cluster<T> selected = null;
        Iterator<Cluster<T>> r2 = clusters.iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        Cluster<T> cluster = r2.next();
        int number = cluster.getPoints().size();
        if (number <= maxNumber) goto L4;
        maxNumber = number;
        selected = cluster;
        goto L4
    L9:
        if (selected == null) goto L13;
        List<T> selectedPoints = selected.getPoints();
        return selectedPoints.remove(this.random.nextInt(selectedPoints.size()));
    L13:
        throw new ConvergenceException(LocalizedFormats.EMPTY_CLUSTER_IN_K_MEANS);
    }

    private T getFarthestPoint(Collection<Cluster<T>> clusters) {
        double maxDistance = Double.NEGATIVE_INFINITY;
        Cluster<T> selectedCluster = null;
        int selectedPoint = -1;
        Iterator<Cluster<T>> r4 = clusters.iterator();
    L4:
        if (r4.hasNext() == false) goto L13;
        Cluster<T> cluster = r4.next();
        Clusterable r6 = cluster.getCenter();
        List<T> points = cluster.getPoints();
        int i = 0;
    L7:
        if (i >= points.size()) goto L4;
        double distance = points.get(i).distanceFrom(r6);
        if (distance <= maxDistance) goto L11;
        maxDistance = distance;
        selectedCluster = cluster;
        selectedPoint = i;
    L11:
        i = i + 1;
        goto L7
    L13:
        if (selectedCluster == null) goto L17;
        return selectedCluster.getPoints().remove(selectedPoint);
    L17:
        throw new ConvergenceException(LocalizedFormats.EMPTY_CLUSTER_IN_K_MEANS);
    }

    private static <T extends Clusterable<T>> Cluster<T> getNearestCluster(Collection<Cluster<T>> clusters, T point) {
        double minDistance = Double.MAX_VALUE;
        Cluster<T> minCluster = null;
        Iterator<Cluster<T>> r3 = clusters.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        Cluster<T> c = r3.next();
        double distance = point.distanceFrom(c.getCenter());
        if (distance >= minDistance) goto L4;
        minDistance = distance;
        minCluster = c;
        goto L4
    L9:
        return minCluster;
    }
}
