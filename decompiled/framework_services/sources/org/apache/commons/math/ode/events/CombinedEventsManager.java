package org.apache.commons.math.ode.events;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.math.ConvergenceException;
import org.apache.commons.math.ode.DerivativeException;
import org.apache.commons.math.ode.IntegratorException;
import org.apache.commons.math.ode.sampling.StepInterpolator;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class CombinedEventsManager {
    private EventState first;
    private boolean initialized;
    private final List<EventState> states;

    public CombinedEventsManager() {
        this.states = new ArrayList();
        this.first = null;
        this.initialized = false;
    }

    public void addEventHandler(EventHandler handler, double maxCheckInterval, double convergence, int maxIterationCount) {
        this.states.add(new EventState(handler, maxCheckInterval, convergence, maxIterationCount));
    }

    public Collection<EventHandler> getEventsHandlers() {
        List<EventHandler> list = new ArrayList();
        Iterator<EventState> r1 = this.states.iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        EventState state = r1.next();
        list.add(state.getEventHandler());
        goto L4
    L7:
        return Collections.unmodifiableCollection(list);
    }

    public void clearEventsHandlers() {
        this.states.clear();
    }

    public Collection<EventState> getEventsStates() {
        return this.states;
    }

    public boolean isEmpty() {
        return this.states.isEmpty();
    }

    public boolean evaluateStep(StepInterpolator interpolator) throws DerivativeException, IntegratorException {
        this.first = null;     // Catch: ConvergenceException -> L12 EventException -> L14
        if (this.states.isEmpty() == false) goto L7;
        return false;
    L7:
        if (this.initialized == true) goto L17;
        Iterator<EventState> r0 = this.states.iterator();     // Catch: ConvergenceException -> L12 EventException -> L14
    L10:
        if (r0.hasNext() == false) goto L16;
        r0.next().reinitializeBegin(interpolator);     // Catch: ConvergenceException -> L12 EventException -> L14
        goto L10
    L16:
        this.initialized = true;     // Catch: ConvergenceException -> L12 EventException -> L14
    L17:
        Iterator<EventState> r1 = this.states.iterator();     // Catch: ConvergenceException -> L12 EventException -> L14
    L19:
        if (r1.hasNext() == false) goto L34;
        EventState state = r1.next();     // Catch: ConvergenceException -> L12 EventException -> L14
        if (state.evaluateStep(interpolator) == false) goto L19;
        if (this.first != null) goto L26;
        this.first = state;     // Catch: ConvergenceException -> L12 EventException -> L14
        goto L19
    L26:
        if (interpolator.isForward() == false) goto L31;
        if (state.getEventTime() >= this.first.getEventTime()) goto L19;
        this.first = state;     // Catch: ConvergenceException -> L12 EventException -> L14
        goto L19
    L31:
        if (state.getEventTime() <= this.first.getEventTime()) goto L19;
        this.first = state;     // Catch: ConvergenceException -> L12 EventException -> L14
        goto L19
    L34:
        if (this.first != null) goto L37;
        return false;
    L37:
        return true;
    L12:
        ce = move-exception;
        throw new IntegratorException(ce);
    L14:
        se = move-exception;
        Throwable cause = se.getCause();
        if (cause == null) goto L47;
        if ((cause instanceof DerivativeException) == false) goto L47;
        throw ((DerivativeException) cause);
    L47:
        throw new IntegratorException(se);
    }

    public double getEventTime() {
        if (this.first != null) goto L6;
        return Double.NaN;
    L6:
        return this.first.getEventTime();
    }

    public void stepAccepted(double t, double[] y) throws IntegratorException {
        Iterator<EventState> r0 = this.states.iterator();     // Catch: EventException -> L7
    L4:
        if (r0.hasNext() == false) goto L10;
        EventState state = r0.next();     // Catch: EventException -> L7
        state.stepAccepted(t, y);     // Catch: EventException -> L7
        goto L4
    L10:
        return;
    L7:
        se = move-exception;
        throw new IntegratorException(se);
    }

    public boolean stop() {
        Iterator<EventState> r0 = this.states.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        EventState state = r0.next();
        if (state.stop() == false) goto L4;
        return true;
    L10:
        return false;
    }

    public boolean reset(double t, double[] y) throws IntegratorException {
        boolean resetDerivatives = false;
        Iterator<EventState> r1 = this.states.iterator();     // Catch: EventException -> L10
    L5:
        if (r1.hasNext() == false) goto L12;
        EventState state = r1.next();     // Catch: EventException -> L10
        if (state.reset(t, y) == false) goto L5;
        resetDerivatives = true;
        goto L5
    L12:
        return resetDerivatives;
    L10:
        se = move-exception;
        throw new IntegratorException(se);
    }
}
