package org.apache.commons.math.estimation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class SimpleEstimationProblem implements EstimationProblem {
    private final List<WeightedMeasurement> measurements;
    private final List<EstimatedParameter> parameters;

    public SimpleEstimationProblem() {
        this.parameters = new ArrayList();
        this.measurements = new ArrayList();
    }

    @Override // org.apache.commons.math.estimation.EstimationProblem
    public EstimatedParameter[] getAllParameters() {
        return (EstimatedParameter[]) this.parameters.toArray(new EstimatedParameter[this.parameters.size()]);
    }

    @Override // org.apache.commons.math.estimation.EstimationProblem
    public EstimatedParameter[] getUnboundParameters() {
        List<EstimatedParameter> unbound = new ArrayList(this.parameters.size());
        Iterator<EstimatedParameter> r1 = this.parameters.iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        EstimatedParameter p = r1.next();
        if (p.isBound() == true) goto L4;
        unbound.add(p);
        goto L4
    L10:
        return (EstimatedParameter[]) unbound.toArray(new EstimatedParameter[unbound.size()]);
    }

    @Override // org.apache.commons.math.estimation.EstimationProblem
    public WeightedMeasurement[] getMeasurements() {
        return (WeightedMeasurement[]) this.measurements.toArray(new WeightedMeasurement[this.measurements.size()]);
    }

    protected void addParameter(EstimatedParameter p) {
        this.parameters.add(p);
    }

    protected void addMeasurement(WeightedMeasurement m) {
        this.measurements.add(m);
    }
}
