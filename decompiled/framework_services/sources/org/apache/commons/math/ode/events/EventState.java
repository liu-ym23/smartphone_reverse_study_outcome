package org.apache.commons.math.ode.events;

import org.apache.commons.math.ConvergenceException;
import org.apache.commons.math.FunctionEvaluationException;
import org.apache.commons.math.analysis.UnivariateRealFunction;
import org.apache.commons.math.analysis.solvers.BrentSolver;
import org.apache.commons.math.exception.MathInternalError;
import org.apache.commons.math.ode.DerivativeException;
import org.apache.commons.math.ode.sampling.StepInterpolator;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class EventState {
    private final double convergence;
    private boolean forward;
    private double g0;
    private boolean g0Positive;
    private final EventHandler handler;
    private boolean increasing;
    private final double maxCheckInterval;
    private final int maxIterationCount;
    private int nextAction;
    private boolean pendingEvent;
    private double pendingEventTime;
    private double previousEventTime;
    private double t0;

    private static class EmbeddedDerivativeException extends RuntimeException {
        private static final long serialVersionUID = 3574188382434584610L;
        private final DerivativeException derivativeException;

        public EmbeddedDerivativeException(DerivativeException derivativeException) {
            this.derivativeException = derivativeException;
        }

        public DerivativeException getDerivativeException() {
            return this.derivativeException;
        }
    }

    private static class EmbeddedEventException extends RuntimeException {
        private static final long serialVersionUID = -1337749250090455474L;
        private final EventException eventException;

        public EmbeddedEventException(EventException eventException) {
            this.eventException = eventException;
        }

        public EventException getEventException() {
            return this.eventException;
        }
    }

    static /* synthetic */ EventHandler access$000(EventState x0) {
        return x0.handler;
    }

    public EventState(EventHandler handler, double maxCheckInterval, double convergence, int maxIterationCount) {
        this.handler = handler;
        this.maxCheckInterval = maxCheckInterval;
        this.convergence = FastMath.abs(convergence);
        this.maxIterationCount = maxIterationCount;
        this.t0 = Double.NaN;
        this.g0 = Double.NaN;
        this.g0Positive = true;
        this.pendingEvent = false;
        this.pendingEventTime = Double.NaN;
        this.previousEventTime = Double.NaN;
        this.increasing = true;
        this.nextAction = 3;
    }

    public EventHandler getEventHandler() {
        return this.handler;
    }

    public double getMaxCheckInterval() {
        return this.maxCheckInterval;
    }

    public double getConvergence() {
        return this.convergence;
    }

    public int getMaxIterationCount() {
        return this.maxIterationCount;
    }

    public void reinitializeBegin(StepInterpolator interpolator) throws EventException {
    L5:
        mue = move-exception;
        throw new EventException(mue);
    L3:
        if (interpolator.isForward() == false) goto L7;
        double ignoreZone = getConvergence();     // Catch: DerivativeException -> L5
    L8:
        this.t0 = interpolator.getPreviousTime() + ignoreZone;     // Catch: DerivativeException -> L5
        interpolator.setInterpolatedTime(this.t0);     // Catch: DerivativeException -> L5
        this.g0 = this.handler.g(this.t0, interpolator.getInterpolatedState());     // Catch: DerivativeException -> L5
        boolean r3 = false;
        if (this.g0 != 0.0d) goto L15;
        double tStart = interpolator.getPreviousTime();     // Catch: DerivativeException -> L5
        interpolator.setInterpolatedTime(tStart);     // Catch: DerivativeException -> L5
        if (this.handler.g(tStart, interpolator.getInterpolatedState()) > 0.0d) goto L13;
        r3 = true;
    L13:
        this.g0Positive = r3;     // Catch: DerivativeException -> L5
        return;
    L15:
        if (this.g0 < 0.0d) goto L17;
        r3 = true;
    L17:
        this.g0Positive = r3;     // Catch: DerivativeException -> L5
        return;
    L7:
        ignoreZone = -getConvergence();
        goto L8
    }

    public boolean evaluateStep(StepInterpolator interpolator) throws DerivativeException, EventException, ConvergenceException {
        final StepInterpolator r2 = interpolator;
        this.forward = r2.isForward();     // Catch: EmbeddedEventException -> L9 EmbeddedDerivativeException -> L11
        double t1 = r2.getCurrentTime();     // Catch: EmbeddedEventException -> L9 EmbeddedDerivativeException -> L11
        if (FastMath.abs(t1 - this.t0) >= this.convergence) goto L7;
        return false;
    L7:
        if (this.forward == false) goto L13;
        double start = this.t0 + this.convergence;     // Catch: EmbeddedEventException -> L9 EmbeddedDerivativeException -> L11
    L14:
        double dt = t1 - start;     // Catch: EmbeddedEventException -> L9 EmbeddedDerivativeException -> L11
        int n = FastMath.max(1, (int) FastMath.ceil(FastMath.abs(dt) / this.maxCheckInterval));     // Catch: EmbeddedEventException -> L9 EmbeddedDerivativeException -> L11
        double h = dt / ((double) n);     // Catch: EmbeddedEventException -> L9 EmbeddedDerivativeException -> L11
        double ta = this.t0;     // Catch: EmbeddedEventException -> L9 EmbeddedDerivativeException -> L11
        double start2 = start;
        double ga = this.g0;     // Catch: EmbeddedEventException -> L9 EmbeddedDerivativeException -> L11
        int i = 0;
    L15:
        if (i >= n) goto L85;
        int n2 = n;
        double tb = start2 + (((double) (i + 1)) * h);     // Catch: EmbeddedEventException -> L9 EmbeddedDerivativeException -> L11
        r2.setInterpolatedTime(tb);     // Catch: EmbeddedEventException -> L9 EmbeddedDerivativeException -> L11
        double t2 = t1;
        double gb = this.handler.g(tb, r2.getInterpolatedState());     // Catch: EmbeddedEventException -> L9 EmbeddedDerivativeException -> L11
        boolean r0 = this.g0Positive;     // Catch: EmbeddedEventException -> L9 EmbeddedDerivativeException -> L11
        if (gb < 0.0d) goto L19;
        boolean r21 = true;
    L21:
        if ((r0 ^ r21) == true) goto L23;
        boolean r1 = true;
        ta = tb;
        ga = gb;
    L84:
        i = i + 1;     // Catch: EmbeddedEventException -> L9 EmbeddedDerivativeException -> L11
        r2 = interpolator;
        n = n2;
        t1 = t2;
        goto L15
    L23:
        if (gb < ga) goto L25;
        boolean r3 = true;
    L26:
        this.increasing = r3;     // Catch: EmbeddedEventException -> L9 EmbeddedDerivativeException -> L11
        UnivariateRealFunction f = new AnonymousClass1(this, r2);     // Catch: EmbeddedEventException -> L9 EmbeddedDerivativeException -> L11
        BrentSolver solver = new BrentSolver(this.convergence);     // Catch: EmbeddedEventException -> L9 EmbeddedDerivativeException -> L11
        if ((ga * gb) >= 0.0d) goto L29;
        double ta2 = ta;
    L52:
        if (ta2 <= tb) goto L93;
        double tb2 = tb;
        double root = solver.solve(this.maxIterationCount, f, tb2, ta2);     // Catch: EmbeddedEventException -> L9 EmbeddedDerivativeException -> L11 FunctionEvaluationException -> L80
    L65:
        if (Double.isNaN(this.previousEventTime) == false) goto L67;
    L71:
        double ta3 = this.previousEventTime;     // Catch: EmbeddedEventException -> L9 EmbeddedDerivativeException -> L11
        if (Double.isNaN(ta3) == true) goto L78;
        if (FastMath.abs(this.previousEventTime - root) > this.convergence) goto L78;
    L77:
        ta = tb2;
        r1 = true;
        ga = gb;
    L78:
        this.pendingEventTime = root;     // Catch: EmbeddedEventException -> L9 EmbeddedDerivativeException -> L11
        this.pendingEvent = true;     // Catch: EmbeddedEventException -> L9 EmbeddedDerivativeException -> L11
        return true;
    L67:
        if (FastMath.abs(root - ta2) > this.convergence) goto L71;
        if (FastMath.abs(root - this.previousEventTime) > this.convergence) goto L71;
    L80:
        ex = e;
    L82:
        throw new DerivativeException(ex);     // Catch: EmbeddedEventException -> L9 EmbeddedDerivativeException -> L11
    L93:
        double ta4 = ta2;
        root = r2.solve(this.maxIterationCount, f, ta4, tb);     // Catch: EmbeddedEventException -> L9 EmbeddedDerivativeException -> L11 FunctionEvaluationException -> L57
        ta2 = ta4;
        tb2 = tb;
    L57:
        ex = e;
    L59:
        ex = e;
        goto L82
    L29:
        if (this.forward == false) goto L31;
        double r4 = 0.25d;
    L33:
        double epsilon = r4 * this.convergence;
        int r5 = 0;
    L34:
        int k = r5;
        if (k >= 4) goto L46;
        if ((ga * gb) <= 0.0d) goto L46;
        ta = ta + epsilon;
        UnivariateRealFunction f2 = f;
        ga = f2.value(ta);     // Catch: EmbeddedEventException -> L9 EmbeddedDerivativeException -> L11 FunctionEvaluationException -> L41
        r5 = k + 1;
        f = f2;
    L41:
        ex = move-exception;
        throw new DerivativeException(ex);     // Catch: EmbeddedEventException -> L9 EmbeddedDerivativeException -> L11
    L46:
        if ((ga * gb) > 0.0d) goto L49;
        ta2 = ta;
        goto L52
    L49:
        throw new MathInternalError();     // Catch: EmbeddedEventException -> L9 EmbeddedDerivativeException -> L11
    L31:
        r4 = -0.25d;
        goto L33
    L25:
        r3 = false;
        goto L26
    L19:
        r21 = false;
        goto L21
    L85:
        this.pendingEvent = false;     // Catch: EmbeddedEventException -> L9 EmbeddedDerivativeException -> L11
        this.pendingEventTime = Double.NaN;     // Catch: EmbeddedEventException -> L9 EmbeddedDerivativeException -> L11
        return false;
    L13:
        start = this.t0 - this.convergence;     // Catch: EmbeddedEventException -> L9 EmbeddedDerivativeException -> L11
    L11:
        ede = move-exception;
        throw ede.getDerivativeException();
    L9:
        eee = move-exception;
        throw eee.getEventException();
    }

    public double getEventTime() {
        if (this.pendingEvent == true) goto L7;
        return Double.POSITIVE_INFINITY;
    L7:
        return this.pendingEventTime;
    }

    public void stepAccepted(double t, double[] y) throws EventException {
        this.t0 = t;
        this.g0 = this.handler.g(t, y);
        boolean r1 = true;
        if (this.pendingEvent == false) goto L8;
        if (FastMath.abs(this.pendingEventTime - t) > this.convergence) goto L8;
        this.previousEventTime = t;
        this.g0Positive = this.increasing;
        this.nextAction = this.handler.eventOccurred(t, y, true ^ (this.increasing ^ this.forward));
        return;
    L8:
        if (this.g0 >= 0.0d) goto L11;
        r1 = false;
    L11:
        this.g0Positive = r1;
        this.nextAction = 3;
    }

    public boolean stop() {
        if (this.nextAction != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean reset(double t, double[] y) throws EventException {
        if (this.pendingEvent == true) goto L5;
    L16:
        return false;
    L5:
        if (FastMath.abs(this.pendingEventTime - t) > this.convergence) goto L16;
        if (this.nextAction != 1) goto L10;
        this.handler.resetState(t, y);
    L10:
        this.pendingEvent = false;
        this.pendingEventTime = Double.NaN;
        if (this.nextAction == 1) goto L15;
        if (this.nextAction == 2) goto L15;
        return false;
    L15:
        return true;
    }
}
