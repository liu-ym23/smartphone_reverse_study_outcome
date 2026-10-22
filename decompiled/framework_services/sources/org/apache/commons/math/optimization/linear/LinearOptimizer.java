package org.apache.commons.math.optimization.linear;

import java.util.Collection;
import org.apache.commons.math.optimization.GoalType;
import org.apache.commons.math.optimization.OptimizationException;
import org.apache.commons.math.optimization.RealPointValuePair;

/* JADX INFO: loaded from: classes3.dex */
public interface LinearOptimizer {
    int getIterations();

    int getMaxIterations();

    RealPointValuePair optimize(LinearObjectiveFunction r1, Collection<LinearConstraint> r2, GoalType r3, boolean r4) throws OptimizationException;

    void setMaxIterations(int r1);
}
