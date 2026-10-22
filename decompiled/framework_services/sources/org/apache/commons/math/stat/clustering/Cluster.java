package org.apache.commons.math.stat.clustering;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math.stat.clustering.Clusterable;

/* JADX INFO: loaded from: classes3.dex */
public class Cluster<T extends Clusterable<T>> implements Serializable {
    private static final long serialVersionUID = -3442297081515880464L;
    private final T center;
    private final List<T> points;

    public Cluster(T center) {
        this.center = center;
        this.points = new ArrayList();
    }

    public void addPoint(T point) {
        this.points.add(point);
    }

    public List<T> getPoints() {
        return this.points;
    }

    public T getCenter() {
        return this.center;
    }
}
