package org.apache.commons.math.analysis.solvers;

/* JADX INFO: loaded from: classes3.dex */
public class UnivariateRealSolverFactoryImpl extends UnivariateRealSolverFactory {
    public UnivariateRealSolverFactoryImpl() {
    }

    @Override // org.apache.commons.math.analysis.solvers.UnivariateRealSolverFactory
    public UnivariateRealSolver newDefaultSolver() {
        return newBrentSolver();
    }

    @Override // org.apache.commons.math.analysis.solvers.UnivariateRealSolverFactory
    public UnivariateRealSolver newBisectionSolver() {
        return new BisectionSolver();
    }

    @Override // org.apache.commons.math.analysis.solvers.UnivariateRealSolverFactory
    public UnivariateRealSolver newBrentSolver() {
        return new BrentSolver();
    }

    @Override // org.apache.commons.math.analysis.solvers.UnivariateRealSolverFactory
    public UnivariateRealSolver newNewtonSolver() {
        return new NewtonSolver();
    }

    @Override // org.apache.commons.math.analysis.solvers.UnivariateRealSolverFactory
    public UnivariateRealSolver newSecantSolver() {
        return new SecantSolver();
    }
}
