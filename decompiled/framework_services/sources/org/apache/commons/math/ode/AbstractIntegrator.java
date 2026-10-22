package org.apache.commons.math.ode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import org.apache.commons.math.ConvergenceException;
import org.apache.commons.math.MaxEvaluationsExceededException;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.ode.events.CombinedEventsManager;
import org.apache.commons.math.ode.events.EventException;
import org.apache.commons.math.ode.events.EventHandler;
import org.apache.commons.math.ode.events.EventState;
import org.apache.commons.math.ode.sampling.AbstractStepInterpolator;
import org.apache.commons.math.ode.sampling.StepHandler;
import org.apache.commons.math.util.FastMath;
import org.apache.commons.math.util.MathUtils;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractIntegrator implements FirstOrderIntegrator {
    private transient FirstOrderDifferentialEquations equations;
    private int evaluations;
    private Collection<EventState> eventsStates;
    protected boolean isLastStep;
    private int maxEvaluations;
    private final String name;
    protected boolean resetOccurred;
    private boolean statesInitialized;
    protected Collection<StepHandler> stepHandlers;
    protected double stepSize;
    protected double stepStart;

    @Deprecated
    private static class EndTimeChecker implements EventHandler {
        private final double endTime;

        public EndTimeChecker(double endTime) {
            this.endTime = endTime;
        }

        @Override // org.apache.commons.math.ode.events.EventHandler
        public int eventOccurred(double t, double[] y, boolean increasing) {
            return 0;
        }

        @Override // org.apache.commons.math.ode.events.EventHandler
        public double g(double t, double[] y) {
            return t - this.endTime;
        }

        @Override // org.apache.commons.math.ode.events.EventHandler
        public void resetState(double t, double[] y) {
        }
    }

    public AbstractIntegrator(String name) {
        this.name = name;
        this.stepHandlers = new ArrayList();
        this.stepStart = Double.NaN;
        this.stepSize = Double.NaN;
        this.eventsStates = new ArrayList();
        this.statesInitialized = false;
        setMaxEvaluations(-1);
        resetEvaluations();
    }

    protected AbstractIntegrator() {
        this(null);
    }

    @Override // org.apache.commons.math.ode.ODEIntegrator
    public String getName() {
        return this.name;
    }

    @Override // org.apache.commons.math.ode.ODEIntegrator
    public void addStepHandler(StepHandler handler) {
        this.stepHandlers.add(handler);
    }

    @Override // org.apache.commons.math.ode.ODEIntegrator
    public Collection<StepHandler> getStepHandlers() {
        return Collections.unmodifiableCollection(this.stepHandlers);
    }

    @Override // org.apache.commons.math.ode.ODEIntegrator
    public void clearStepHandlers() {
        this.stepHandlers.clear();
    }

    @Override // org.apache.commons.math.ode.ODEIntegrator
    public void addEventHandler(EventHandler handler, double maxCheckInterval, double convergence, int maxIterationCount) {
        this.eventsStates.add(new EventState(handler, maxCheckInterval, convergence, maxIterationCount));
    }

    @Override // org.apache.commons.math.ode.ODEIntegrator
    public Collection<EventHandler> getEventHandlers() {
        List<EventHandler> list = new ArrayList();
        Iterator<EventState> r1 = this.eventsStates.iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        EventState state = r1.next();
        list.add(state.getEventHandler());
        goto L4
    L7:
        return Collections.unmodifiableCollection(list);
    }

    @Override // org.apache.commons.math.ode.ODEIntegrator
    public void clearEventHandlers() {
        this.eventsStates.clear();
    }

    protected boolean requiresDenseOutput() {
        if (this.eventsStates.isEmpty() == true) goto L5;
        return true;
    L5:
        Iterator<StepHandler> r0 = this.stepHandlers.iterator();
    L7:
        if (r0.hasNext() == false) goto L12;
        StepHandler handler = r0.next();
        if (handler.requiresDenseOutput() == false) goto L7;
        return true;
    L12:
        return false;
    }

    @Override // org.apache.commons.math.ode.ODEIntegrator
    public double getCurrentStepStart() {
        return this.stepStart;
    }

    @Override // org.apache.commons.math.ode.ODEIntegrator
    public double getCurrentSignedStepsize() {
        return this.stepSize;
    }

    @Override // org.apache.commons.math.ode.ODEIntegrator
    public void setMaxEvaluations(int maxEvaluations) {
        if (maxEvaluations >= 0) goto L4;
        int r0 = Integer.MAX_VALUE;
    L5:
        this.maxEvaluations = r0;
        return;
    L4:
        r0 = maxEvaluations;
        goto L5
    }

    @Override // org.apache.commons.math.ode.ODEIntegrator
    public int getMaxEvaluations() {
        return this.maxEvaluations;
    }

    @Override // org.apache.commons.math.ode.ODEIntegrator
    public int getEvaluations() {
        return this.evaluations;
    }

    protected void resetEvaluations() {
        this.evaluations = 0;
    }

    protected void setEquations(FirstOrderDifferentialEquations equations) {
        this.equations = equations;
    }

    public void computeDerivatives(double t, double[] y, double[] yDot) throws DerivativeException {
        int r0 = this.evaluations + 1;
        this.evaluations = r0;
        if (r0 > this.maxEvaluations) goto L7;
        this.equations.computeDerivatives(t, y, yDot);
        return;
    L7:
        throw new DerivativeException(new MaxEvaluationsExceededException(this.maxEvaluations));
    }

    protected void setStateInitialized(boolean stateInitialized) {
        this.statesInitialized = stateInitialized;
    }

    protected double acceptStep(AbstractStepInterpolator interpolator, double[] y, double[] yDot, double tEnd) throws DerivativeException, IntegratorException {
        double previousT = interpolator.getGlobalPreviousTime();     // Catch: ConvergenceException -> L9 EventException -> L12
        double currentT = interpolator.getGlobalCurrentTime();     // Catch: ConvergenceException -> L9 EventException -> L12
        boolean r0 = false;
        this.resetOccurred = false;     // Catch: ConvergenceException -> L9 EventException -> L12
        if (this.statesInitialized == true) goto L17;
        Iterator<EventState> r8 = this.eventsStates.iterator();     // Catch: ConvergenceException -> L9 EventException -> L12
    L7:
        if (r8.hasNext() == false) goto L15;
        r8.next().reinitializeBegin(interpolator);     // Catch: ConvergenceException -> L9 EventException -> L12
        goto L7
    L15:
        this.statesInitialized = true;     // Catch: ConvergenceException -> L9 EventException -> L12
    L17:
        if (interpolator.isForward() == false) goto L19;
        final int orderingSign = 1;
    L20:
        SortedSet<EventState> occuringEvents = new TreeSet(new AnonymousClass1(this, orderingSign));     // Catch: ConvergenceException -> L9 EventException -> L12
        Iterator<EventState> r11 = this.eventsStates.iterator();     // Catch: ConvergenceException -> L9 EventException -> L12
    L22:
        if (r11.hasNext() == false) goto L28;
        EventState state = r11.next();     // Catch: ConvergenceException -> L9 EventException -> L12
        if (state.evaluateStep(interpolator) == false) goto L22;
        occuringEvents.add(state);     // Catch: ConvergenceException -> L9 EventException -> L12
    L28:
        if (occuringEvents.isEmpty() == true) goto L51;
        Iterator<EventState> iterator = occuringEvents.iterator();     // Catch: ConvergenceException -> L9 EventException -> L12
        EventState currentEvent = iterator.next();     // Catch: ConvergenceException -> L9 EventException -> L12
        iterator.remove();     // Catch: ConvergenceException -> L9 EventException -> L12
        double eventT = currentEvent.getEventTime();     // Catch: ConvergenceException -> L9 EventException -> L12
        interpolator.setSoftPreviousTime(previousT);     // Catch: ConvergenceException -> L9 EventException -> L12
        interpolator.setSoftCurrentTime(eventT);     // Catch: ConvergenceException -> L9 EventException -> L12
        interpolator.setInterpolatedTime(eventT);     // Catch: ConvergenceException -> L9 EventException -> L12
        double[] eventY = interpolator.getInterpolatedState();     // Catch: ConvergenceException -> L9 EventException -> L12
        currentEvent.stepAccepted(eventT, eventY);     // Catch: ConvergenceException -> L9 EventException -> L12
        this.isLastStep = currentEvent.stop();     // Catch: ConvergenceException -> L9 EventException -> L12
        Iterator<StepHandler> r9 = this.stepHandlers.iterator();     // Catch: ConvergenceException -> L9 EventException -> L12
    L31:
        if (r9.hasNext() == false) goto L34;
        StepHandler handler = r9.next();     // Catch: ConvergenceException -> L9 EventException -> L12
        handler.handleStep(interpolator, this.isLastStep);     // Catch: ConvergenceException -> L9 EventException -> L12
        previousT = previousT;
        goto L31
    L34:
        if (this.isLastStep == true) goto L35;
        if (currentEvent.reset(eventT, eventY) == true) goto L39;
        interpolator.setSoftPreviousTime(eventT);     // Catch: ConvergenceException -> L43 EventException -> L45
        interpolator.setSoftCurrentTime(currentT);     // Catch: ConvergenceException -> L43 EventException -> L45
        if (currentEvent.evaluateStep(interpolator) == false) goto L50;
        occuringEvents.add(currentEvent);     // Catch: ConvergenceException -> L43 EventException -> L45
    L50:
        r0 = false;
        previousT = eventT;
    L43:
        ce = e;
    L81:
        throw new IntegratorException(ce);
    L45:
        se = e;
    L82:
        Throwable cause = se.getCause();
        if (cause == null) goto L89;
        if ((cause instanceof DerivativeException) == false) goto L89;
        throw ((DerivativeException) cause);
    L89:
        throw new IntegratorException(se);
    L39:
        System.arraycopy(eventY, 0, y, 0, y.length);     // Catch: ConvergenceException -> L9 EventException -> L12
        computeDerivatives(eventT, y, yDot);     // Catch: ConvergenceException -> L43 EventException -> L45
        this.resetOccurred = true;     // Catch: ConvergenceException -> L43 EventException -> L45
        return eventT;
    L35:
        System.arraycopy(eventY, 0, y, 0, y.length);     // Catch: ConvergenceException -> L9 EventException -> L12
        return eventT;
    L51:
        boolean r4 = r0;
        interpolator.setInterpolatedTime(currentT);     // Catch: ConvergenceException -> L43 EventException -> L45
        double[] currentY = interpolator.getInterpolatedState();     // Catch: ConvergenceException -> L43 EventException -> L45
        Iterator<EventState> r10 = this.eventsStates.iterator();     // Catch: ConvergenceException -> L43 EventException -> L45
    L53:
        if (r10.hasNext() == false) goto L63;
        EventState state2 = r10.next();     // Catch: ConvergenceException -> L43 EventException -> L45
        state2.stepAccepted(currentT, currentY);     // Catch: ConvergenceException -> L43 EventException -> L45
        if (this.isLastStep == true) goto L60;
        if (state2.stop() == true) goto L60;
        boolean r12 = r4;
    L61:
        this.isLastStep = r12;     // Catch: ConvergenceException -> L43 EventException -> L45
    L60:
        r12 = true;
        goto L61
    L63:
        if (this.isLastStep == true) goto L72;
        boolean r13 = true;
    L68:
        ce = e;
    L70:
        se = e;
        goto L82
    L66:
        if (MathUtils.equals(currentT, tEnd, 1) == true) goto L73;
    L74:
        this.isLastStep = r4;     // Catch: ConvergenceException -> L68 EventException -> L70
        Iterator<StepHandler> r5 = this.stepHandlers.iterator();     // Catch: ConvergenceException -> L68 EventException -> L70
    L75:
        if (r5.hasNext() == false) goto L79;
        StepHandler handler2 = r5.next();     // Catch: ConvergenceException -> L68 EventException -> L70
        handler2.handleStep(interpolator, this.isLastStep);     // Catch: ConvergenceException -> L68 EventException -> L70
        goto L75
    L79:
        return currentT;
    L73:
        r4 = r13;
        goto L74
    L72:
        r13 = true;
        goto L73
    L19:
        orderingSign = -1;
    L9:
        ce = e;
    L12:
        se = e;
        goto L82
    }

    protected void sanityChecks(FirstOrderDifferentialEquations ode, double t0, double[] y0, double t, double[] y) throws IntegratorException {
        if (ode.getDimension() != y0.length) goto L14;
        if (ode.getDimension() != y.length) goto L12;
        if (FastMath.abs(t - t0) <= (FastMath.max(FastMath.abs(t0), FastMath.abs(t)) * 1.0E-12d)) goto L10;
        return;
    L10:
        throw new IntegratorException(LocalizedFormats.TOO_SMALL_INTEGRATION_INTERVAL, new Object[]{Double.valueOf(FastMath.abs(t - t0))});
    L12:
        throw new IntegratorException(LocalizedFormats.DIMENSIONS_MISMATCH_SIMPLE, new Object[]{Integer.valueOf(ode.getDimension()), Integer.valueOf(y.length)});
    L14:
        throw new IntegratorException(LocalizedFormats.DIMENSIONS_MISMATCH_SIMPLE, new Object[]{Integer.valueOf(ode.getDimension()), Integer.valueOf(y0.length)});
    }

    @Deprecated
    protected CombinedEventsManager addEndTimeChecker(double startTime, double endTime, CombinedEventsManager manager) {
        CombinedEventsManager newManager = new CombinedEventsManager();
        Iterator<EventState> r0 = manager.getEventsStates().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        EventState state = r0.next();
        newManager.addEventHandler(state.getEventHandler(), state.getMaxCheckInterval(), state.getConvergence(), state.getMaxIterationCount());
        goto L4
    L6:
        newManager.addEventHandler(new EndTimeChecker(endTime), Double.POSITIVE_INFINITY, FastMath.ulp(FastMath.max(FastMath.abs(startTime), FastMath.abs(endTime))), 100);
        return newManager;
    }
}
