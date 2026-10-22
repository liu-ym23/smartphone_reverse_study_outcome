package org.apache.commons.math.optimization.fitting;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.math.FunctionEvaluationException;
import org.apache.commons.math.analysis.DifferentiableMultivariateVectorialFunction;
import org.apache.commons.math.analysis.MultivariateMatrixFunction;
import org.apache.commons.math.optimization.DifferentiableMultivariateVectorialOptimizer;
import org.apache.commons.math.optimization.OptimizationException;
import org.apache.commons.math.optimization.VectorialPointValuePair;

/* JADX INFO: loaded from: classes3.dex */
public class CurveFitter {
    private final List<WeightedObservedPoint> observations;
    private final DifferentiableMultivariateVectorialOptimizer optimizer;

    private class TheoreticalValuesFunction implements DifferentiableMultivariateVectorialFunction {
        private final ParametricRealFunction f;
        final /* synthetic */ CurveFitter this$0;

        static /* synthetic */ ParametricRealFunction access$100(TheoreticalValuesFunction x0) {
            return x0.f;
        }

        public TheoreticalValuesFunction(CurveFitter r1, ParametricRealFunction f) {
            this.this$0 = r1;
            this.f = f;
        }

        @Override // org.apache.commons.math.analysis.DifferentiableMultivariateVectorialFunction
        public MultivariateMatrixFunction jacobian() {
            return new AnonymousClass1(this);
        }

        @Override // org.apache.commons.math.analysis.MultivariateVectorialFunction
        public double[] value(double[] point) throws FunctionEvaluationException, IllegalArgumentException {
            double[] values = new double[CurveFitter.access$000(this.this$0).size()];
            int i = 0;
            Iterator r2 = CurveFitter.access$000(this.this$0).iterator();
        L4:
            if (r2.hasNext() == false) goto L6;
            WeightedObservedPoint observed = (WeightedObservedPoint) r2.next();
            values[i] = this.f.value(observed.getX(), point);
            i = i + 1;
            goto L4
        L6:
            return values;
        }
    }

    static /* synthetic */ List access$000(CurveFitter x0) {
        return x0.observations;
    }

    public CurveFitter(DifferentiableMultivariateVectorialOptimizer optimizer) {
        this.optimizer = optimizer;
        this.observations = new ArrayList();
    }

    public void addObservedPoint(double x, double y) {
        addObservedPoint(1.0d, x, y);
    }

    public void addObservedPoint(double weight, double x, double y) {
        this.observations.add(new WeightedObservedPoint(weight, x, y));
    }

    public void addObservedPoint(WeightedObservedPoint observed) {
        this.observations.add(observed);
    }

    public WeightedObservedPoint[] getObservations() {
        return (WeightedObservedPoint[]) this.observations.toArray(new WeightedObservedPoint[this.observations.size()]);
    }

    public void clearObservations() {
        this.observations.clear();
    }

    public double[] fit(ParametricRealFunction f, double[] initialGuess) throws FunctionEvaluationException, OptimizationException, IllegalArgumentException {
        double[] target = new double[this.observations.size()];
        double[] weights = new double[this.observations.size()];
        int i = 0;
        Iterator<WeightedObservedPoint> r3 = this.observations.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        WeightedObservedPoint point = r3.next();
        target[i] = point.getY();
        weights[i] = point.getWeight();
        i = i + 1;
        goto L4
    L6:
        VectorialPointValuePair optimum = this.optimizer.optimize(new TheoreticalValuesFunction(this, f), target, weights, initialGuess);
        return optimum.getPointRef();
    }
}
