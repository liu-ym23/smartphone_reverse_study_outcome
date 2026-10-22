package org.apache.commons.math.analysis.solvers;

/* JADX INFO: loaded from: classes3.dex */
public abstract class UnivariateRealSolverFactory {
    public abstract UnivariateRealSolver newBisectionSolver();

    public abstract UnivariateRealSolver newBrentSolver();

    public abstract UnivariateRealSolver newDefaultSolver();

    public abstract UnivariateRealSolver newNewtonSolver();

    public abstract UnivariateRealSolver newSecantSolver();

    protected UnivariateRealSolverFactory() {
    }

    public static UnivariateRealSolverFactory newInstance() {
        return new UnivariateRealSolverFactoryImpl();
    }
}
