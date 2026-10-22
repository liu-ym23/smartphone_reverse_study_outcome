package org.apache.commons.math.ode.jacobians;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.MaxEvaluationsExceededException;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.ode.DerivativeException;
import org.apache.commons.math.ode.ExtendedFirstOrderDifferentialEquations;
import org.apache.commons.math.ode.FirstOrderIntegrator;
import org.apache.commons.math.ode.IntegratorException;
import org.apache.commons.math.ode.events.EventException;
import org.apache.commons.math.ode.events.EventHandler;
import org.apache.commons.math.ode.sampling.StepHandler;
import org.apache.commons.math.ode.sampling.StepInterpolator;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class FirstOrderIntegratorWithJacobians {
    private int evaluations;
    private final FirstOrderIntegrator integrator;
    private int maxEvaluations;
    private final ODEWithJacobians ode;

    private static class EventHandlerWrapper implements EventHandler {
        private double[][] dydp;
        private double[][] dydy0;
        private final EventHandlerWithJacobians handler;
        private double[] y;

        public EventHandlerWrapper(EventHandlerWithJacobians handler, int n, int k) {
            this.handler = handler;
            this.y = new double[n];
            this.dydy0 = (double[][]) Array.newInstance(Double.TYPE, new int[]{n, n});
            this.dydp = (double[][]) Array.newInstance(Double.TYPE, new int[]{n, k});
        }

        public EventHandlerWithJacobians getHandler() {
            return this.handler;
        }

        @Override // org.apache.commons.math.ode.events.EventHandler
        public int eventOccurred(double t, double[] z, boolean increasing) throws EventException {
            FirstOrderIntegratorWithJacobians.access$300(z, this.y, this.dydy0, this.dydp);
            return this.handler.eventOccurred(t, this.y, this.dydy0, this.dydp, increasing);
        }

        @Override // org.apache.commons.math.ode.events.EventHandler
        public double g(double t, double[] z) throws EventException {
            FirstOrderIntegratorWithJacobians.access$300(z, this.y, this.dydy0, this.dydp);
            return this.handler.g(t, this.y, this.dydy0, this.dydp);
        }

        @Override // org.apache.commons.math.ode.events.EventHandler
        public void resetState(double t, double[] z) throws EventException {
            FirstOrderIntegratorWithJacobians.access$300(z, this.y, this.dydy0, this.dydp);
            this.handler.resetState(t, this.y, this.dydy0, this.dydp);
        }
    }

    private class FiniteDifferencesWrapper implements ODEWithJacobians {
        private final double[] hP;
        private final double[] hY;
        private final ParameterizedODE ode;
        private final double[] p;
        final /* synthetic */ FirstOrderIntegratorWithJacobians this$0;
        private final double[] tmpDot;

        public FiniteDifferencesWrapper(FirstOrderIntegratorWithJacobians r1, ParameterizedODE ode, double[] p, double[] hY, double[] hP) {
            this.this$0 = r1;
            this.ode = ode;
            this.p = (double[]) p.clone();
            this.hY = (double[]) hY.clone();
            this.hP = (double[]) hP.clone();
            this.tmpDot = new double[ode.getDimension()];
        }

        @Override // org.apache.commons.math.ode.FirstOrderDifferentialEquations
        public int getDimension() {
            return this.ode.getDimension();
        }

        @Override // org.apache.commons.math.ode.FirstOrderDifferentialEquations
        public void computeDerivatives(double t, double[] y, double[] yDot) throws DerivativeException {
            this.ode.computeDerivatives(t, y, yDot);
        }

        @Override // org.apache.commons.math.ode.jacobians.ODEWithJacobians
        public int getParametersDimension() {
            return this.ode.getParametersDimension();
        }

        @Override // org.apache.commons.math.ode.jacobians.ODEWithJacobians
        public void computeJacobians(double t, double[] y, double[] yDot, double[][] dFdY, double[][] dFdP) throws DerivativeException {
            int n = this.hY.length;
            int k = this.hP.length;
            FirstOrderIntegratorWithJacobians.access$112(this.this$0, n + k);
            if (FirstOrderIntegratorWithJacobians.access$100(this.this$0) > FirstOrderIntegratorWithJacobians.access$200(this.this$0)) goto L19;
            int j = 0;
        L5:
            if (j >= n) goto L10;
            double savedYj = y[j];
            y[j] = y[j] + this.hY[j];
            this.ode.computeDerivatives(t, y, this.tmpDot);
            int i = 0;
        L7:
            if (i >= n) goto L9;
            dFdY[i][j] = (this.tmpDot[i] - yDot[i]) / this.hY[j];
            i = i + 1;
            goto L7
        L9:
            y[j] = savedYj;
            j = j + 1;
            goto L5
        L10:
            int j2 = 0;
        L11:
            if (j2 >= k) goto L17;
            this.ode.setParameter(j2, this.p[j2] + this.hP[j2]);
            this.ode.computeDerivatives(t, y, this.tmpDot);
            int i2 = 0;
        L13:
            if (i2 >= n) goto L15;
            dFdP[i2][j2] = (this.tmpDot[i2] - yDot[i2]) / this.hP[j2];
            i2 = i2 + 1;
            goto L13
        L15:
            this.ode.setParameter(j2, this.p[j2]);
            j2 = j2 + 1;
            goto L11
        L17:
            return;
        L19:
            throw new DerivativeException(new MaxEvaluationsExceededException(FirstOrderIntegratorWithJacobians.access$200(this.this$0)));
        }
    }

    private class MappingWrapper implements ExtendedFirstOrderDifferentialEquations {
        private final double[][] dFdP;
        private final double[][] dFdY;
        final /* synthetic */ FirstOrderIntegratorWithJacobians this$0;
        private final double[] y;
        private final double[] yDot;

        public MappingWrapper(FirstOrderIntegratorWithJacobians r7) {
            this.this$0 = r7;
            int n = FirstOrderIntegratorWithJacobians.access$000(r7).getDimension();
            int k = FirstOrderIntegratorWithJacobians.access$000(r7).getParametersDimension();
            this.y = new double[n];
            this.yDot = new double[n];
            this.dFdY = (double[][]) Array.newInstance(Double.TYPE, new int[]{n, n});
            this.dFdP = (double[][]) Array.newInstance(Double.TYPE, new int[]{n, k});
        }

        @Override // org.apache.commons.math.ode.FirstOrderDifferentialEquations
        public int getDimension() {
            int n = this.y.length;
            int k = this.dFdP[0].length;
            return ((n + 1) + k) * n;
        }

        @Override // org.apache.commons.math.ode.ExtendedFirstOrderDifferentialEquations
        public int getMainSetDimension() {
            return FirstOrderIntegratorWithJacobians.access$000(this.this$0).getDimension();
        }

        @Override // org.apache.commons.math.ode.FirstOrderDifferentialEquations
        public void computeDerivatives(double t, double[] z, double[] zDot) throws DerivativeException {
            int n = this.y.length;
            int k = this.dFdP[0].length;
            System.arraycopy(z, 0, this.y, 0, n);
            if (FirstOrderIntegratorWithJacobians.access$104(this.this$0) > FirstOrderIntegratorWithJacobians.access$200(this.this$0)) goto L25;
            FirstOrderIntegratorWithJacobians.access$000(this.this$0).computeDerivatives(t, this.y, this.yDot);
            FirstOrderIntegratorWithJacobians.access$000(this.this$0).computeJacobians(t, this.y, this.yDot, this.dFdY, this.dFdP);
            System.arraycopy(this.yDot, 0, zDot, 0, n);
            int i = 0;
        L5:
            if (i >= n) goto L13;
            double[] dFdYi = this.dFdY[i];
            int j = 0;
        L7:
            if (j >= n) goto L12;
            double s = 0.0d;
            int startIndex = n + j;
            int zIndex = startIndex;
            int l = 0;
        L9:
            if (l >= n) goto L11;
            s = s + (dFdYi[l] * z[zIndex]);
            zIndex = zIndex + n;
            l = l + 1;
            goto L9
        L11:
            int l2 = i * n;
            zDot[l2 + startIndex] = s;
            j = j + 1;
            goto L7
        L12:
            i = i + 1;
            goto L5
        L13:
            int i2 = 0;
        L14:
            if (i2 >= n) goto L23;
            double[] dFdYi2 = this.dFdY[i2];
            double[] dFdPi = this.dFdP[i2];
            int j2 = 0;
        L16:
            if (j2 >= k) goto L21;
            double s2 = dFdPi[j2];
            int startIndex2 = ((n + 1) * n) + j2;
            int zIndex2 = startIndex2;
            int l3 = 0;
        L18:
            if (l3 >= n) goto L20;
            s2 = s2 + (dFdYi2[l3] * z[zIndex2]);
            zIndex2 = zIndex2 + k;
            l3 = l3 + 1;
            goto L18
        L20:
            int l4 = i2 * k;
            zDot[l4 + startIndex2] = s2;
            j2 = j2 + 1;
            goto L16
        L21:
            i2 = i2 + 1;
            goto L14
        L23:
            return;
        L25:
            throw new DerivativeException(new MaxEvaluationsExceededException(FirstOrderIntegratorWithJacobians.access$200(this.this$0)));
        }
    }

    private static class StepHandlerWrapper implements StepHandler {
        private final StepHandlerWithJacobians handler;
        private final int k;
        private final int n;

        public StepHandlerWrapper(StepHandlerWithJacobians handler, int n, int k) {
            this.handler = handler;
            this.n = n;
            this.k = k;
        }

        public StepHandlerWithJacobians getHandler() {
            return this.handler;
        }

        @Override // org.apache.commons.math.ode.sampling.StepHandler
        public void handleStep(StepInterpolator interpolator, boolean isLast) throws DerivativeException {
            this.handler.handleStep(new StepInterpolatorWrapper(interpolator, this.n, this.k), isLast);
        }

        @Override // org.apache.commons.math.ode.sampling.StepHandler
        public boolean requiresDenseOutput() {
            return this.handler.requiresDenseOutput();
        }

        @Override // org.apache.commons.math.ode.sampling.StepHandler
        public void reset() {
            this.handler.reset();
        }
    }

    private static class StepInterpolatorWrapper implements StepInterpolatorWithJacobians {
        private double[][] dydp;
        private double[][] dydpDot;
        private double[][] dydy0;
        private double[][] dydy0Dot;
        private StepInterpolator interpolator;
        private double[] y;
        private double[] yDot;

        public StepInterpolatorWrapper() {
        }

        public StepInterpolatorWrapper(StepInterpolator interpolator, int n, int k) {
            this.interpolator = interpolator;
            this.y = new double[n];
            this.dydy0 = (double[][]) Array.newInstance(Double.TYPE, new int[]{n, n});
            this.dydp = (double[][]) Array.newInstance(Double.TYPE, new int[]{n, k});
            this.yDot = new double[n];
            this.dydy0Dot = (double[][]) Array.newInstance(Double.TYPE, new int[]{n, n});
            this.dydpDot = (double[][]) Array.newInstance(Double.TYPE, new int[]{n, k});
        }

        @Override // org.apache.commons.math.ode.jacobians.StepInterpolatorWithJacobians
        public void setInterpolatedTime(double time) {
            this.interpolator.setInterpolatedTime(time);
        }

        @Override // org.apache.commons.math.ode.jacobians.StepInterpolatorWithJacobians
        public boolean isForward() {
            return this.interpolator.isForward();
        }

        @Override // org.apache.commons.math.ode.jacobians.StepInterpolatorWithJacobians
        public double getPreviousTime() {
            return this.interpolator.getPreviousTime();
        }

        @Override // org.apache.commons.math.ode.jacobians.StepInterpolatorWithJacobians
        public double getInterpolatedTime() {
            return this.interpolator.getInterpolatedTime();
        }

        @Override // org.apache.commons.math.ode.jacobians.StepInterpolatorWithJacobians
        public double[] getInterpolatedY() throws DerivativeException {
            double[] extendedState = this.interpolator.getInterpolatedState();
            System.arraycopy(extendedState, 0, this.y, 0, this.y.length);
            return this.y;
        }

        @Override // org.apache.commons.math.ode.jacobians.StepInterpolatorWithJacobians
        public double[][] getInterpolatedDyDy0() throws DerivativeException {
            double[] extendedState = this.interpolator.getInterpolatedState();
            int n = this.y.length;
            int start = n;
            int i = 0;
        L3:
            if (i >= n) goto L6;
            System.arraycopy(extendedState, start, this.dydy0[i], 0, n);
            start = start + n;
            i = i + 1;
            goto L3
        L6:
            return this.dydy0;
        }

        @Override // org.apache.commons.math.ode.jacobians.StepInterpolatorWithJacobians
        public double[][] getInterpolatedDyDp() throws DerivativeException {
            double[] extendedState = this.interpolator.getInterpolatedState();
            int n = this.y.length;
            int k = this.dydp[0].length;
            int start = (n + 1) * n;
            int i = 0;
        L3:
            if (i >= n) goto L6;
            System.arraycopy(extendedState, start, this.dydp[i], 0, k);
            start = start + k;
            i = i + 1;
            goto L3
        L6:
            return this.dydp;
        }

        @Override // org.apache.commons.math.ode.jacobians.StepInterpolatorWithJacobians
        public double[] getInterpolatedYDot() throws DerivativeException {
            double[] extendedDerivatives = this.interpolator.getInterpolatedDerivatives();
            System.arraycopy(extendedDerivatives, 0, this.yDot, 0, this.yDot.length);
            return this.yDot;
        }

        @Override // org.apache.commons.math.ode.jacobians.StepInterpolatorWithJacobians
        public double[][] getInterpolatedDyDy0Dot() throws DerivativeException {
            double[] extendedDerivatives = this.interpolator.getInterpolatedDerivatives();
            int n = this.y.length;
            int start = n;
            int i = 0;
        L3:
            if (i >= n) goto L6;
            System.arraycopy(extendedDerivatives, start, this.dydy0Dot[i], 0, n);
            start = start + n;
            i = i + 1;
            goto L3
        L6:
            return this.dydy0Dot;
        }

        @Override // org.apache.commons.math.ode.jacobians.StepInterpolatorWithJacobians
        public double[][] getInterpolatedDyDpDot() throws DerivativeException {
            double[] extendedDerivatives = this.interpolator.getInterpolatedDerivatives();
            int n = this.y.length;
            int k = this.dydpDot[0].length;
            int start = (n + 1) * n;
            int i = 0;
        L3:
            if (i >= n) goto L6;
            System.arraycopy(extendedDerivatives, start, this.dydpDot[i], 0, k);
            start = start + k;
            i = i + 1;
            goto L3
        L6:
            return this.dydpDot;
        }

        @Override // org.apache.commons.math.ode.jacobians.StepInterpolatorWithJacobians
        public double getCurrentTime() {
            return this.interpolator.getCurrentTime();
        }

        @Override // org.apache.commons.math.ode.jacobians.StepInterpolatorWithJacobians
        public StepInterpolatorWithJacobians copy() throws DerivativeException {
            int n = this.y.length;
            int k = this.dydp[0].length;
            StepInterpolatorWrapper copied = new StepInterpolatorWrapper(this.interpolator.copy(), n, k);
            copyArray(this.y, copied.y);
            copyArray(this.dydy0, copied.dydy0);
            copyArray(this.dydp, copied.dydp);
            copyArray(this.yDot, copied.yDot);
            copyArray(this.dydy0Dot, copied.dydy0Dot);
            copyArray(this.dydpDot, copied.dydpDot);
            return copied;
        }

        @Override // java.io.Externalizable
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(this.interpolator);
            out.writeInt(this.y.length);
            out.writeInt(this.dydp[0].length);
            writeArray(out, this.y);
            writeArray(out, this.dydy0);
            writeArray(out, this.dydp);
            writeArray(out, this.yDot);
            writeArray(out, this.dydy0Dot);
            writeArray(out, this.dydpDot);
        }

        @Override // java.io.Externalizable
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            this.interpolator = (StepInterpolator) in.readObject();
            int n = in.readInt();
            int k = in.readInt();
            this.y = new double[n];
            this.dydy0 = (double[][]) Array.newInstance(Double.TYPE, new int[]{n, n});
            this.dydp = (double[][]) Array.newInstance(Double.TYPE, new int[]{n, k});
            this.yDot = new double[n];
            this.dydy0Dot = (double[][]) Array.newInstance(Double.TYPE, new int[]{n, n});
            this.dydpDot = (double[][]) Array.newInstance(Double.TYPE, new int[]{n, k});
            readArray(in, this.y);
            readArray(in, this.dydy0);
            readArray(in, this.dydp);
            readArray(in, this.yDot);
            readArray(in, this.dydy0Dot);
            readArray(in, this.dydpDot);
        }

        private static void copyArray(double[] src, double[] dest) {
            System.arraycopy(src, 0, dest, 0, src.length);
        }

        private static void copyArray(double[][] src, double[][] dest) {
            int i = 0;
        L4:
            if (i >= src.length) goto L7;
            copyArray(src[i], dest[i]);
            i = i + 1;
            goto L4
        }

        private static void writeArray(ObjectOutput out, double[] array) throws IOException {
            int i = 0;
        L4:
            if (i >= array.length) goto L7;
            out.writeDouble(array[i]);
            i = i + 1;
            goto L4
        }

        private static void writeArray(ObjectOutput out, double[][] array) throws IOException {
            int i = 0;
        L4:
            if (i >= array.length) goto L7;
            writeArray(out, array[i]);
            i = i + 1;
            goto L4
        }

        private static void readArray(ObjectInput in, double[] array) throws IOException {
            int i = 0;
        L4:
            if (i >= array.length) goto L7;
            array[i] = in.readDouble();
            i = i + 1;
            goto L4
        }

        private static void readArray(ObjectInput in, double[][] array) throws IOException {
            int i = 0;
        L4:
            if (i >= array.length) goto L7;
            readArray(in, array[i]);
            i = i + 1;
            goto L4
        }
    }

    static /* synthetic */ ODEWithJacobians access$000(FirstOrderIntegratorWithJacobians x0) {
        return x0.ode;
    }

    static /* synthetic */ int access$100(FirstOrderIntegratorWithJacobians x0) {
        return x0.evaluations;
    }

    static /* synthetic */ int access$104(FirstOrderIntegratorWithJacobians x0) {
        int r0 = x0.evaluations + 1;
        x0.evaluations = r0;
        return r0;
    }

    static /* synthetic */ int access$112(FirstOrderIntegratorWithJacobians x0, int x1) {
        int r0 = x0.evaluations + x1;
        x0.evaluations = r0;
        return r0;
    }

    static /* synthetic */ int access$200(FirstOrderIntegratorWithJacobians x0) {
        return x0.maxEvaluations;
    }

    static /* synthetic */ void access$300(double[] x0, double[] x1, double[][] x2, double[][] x3) {
        dispatchCompoundState(x0, x1, x2, x3);
    }

    public FirstOrderIntegratorWithJacobians(FirstOrderIntegrator integrator, ParameterizedODE ode, double[] p, double[] hY, double[] hP) {
        checkDimension(ode.getDimension(), hY);
        checkDimension(ode.getParametersDimension(), p);
        checkDimension(ode.getParametersDimension(), hP);
        this.integrator = integrator;
        this.ode = new FiniteDifferencesWrapper(this, ode, p, hY, hP);
        setMaxEvaluations(-1);
    }

    public FirstOrderIntegratorWithJacobians(FirstOrderIntegrator integrator, ODEWithJacobians ode) {
        this.integrator = integrator;
        this.ode = ode;
        setMaxEvaluations(-1);
    }

    public void addStepHandler(StepHandlerWithJacobians handler) {
        int n = this.ode.getDimension();
        int k = this.ode.getParametersDimension();
        this.integrator.addStepHandler(new StepHandlerWrapper(handler, n, k));
    }

    public Collection<StepHandlerWithJacobians> getStepHandlers() {
        Collection<StepHandlerWithJacobians> handlers = new ArrayList();
        Iterator<StepHandler> r1 = this.integrator.getStepHandlers().iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        StepHandler handler = r1.next();
        if ((handler instanceof StepHandlerWrapper) == false) goto L4;
        handlers.add(((StepHandlerWrapper) handler).getHandler());
        goto L4
    L9:
        return handlers;
    }

    public void clearStepHandlers() {
        this.integrator.clearStepHandlers();
    }

    public void addEventHandler(EventHandlerWithJacobians handler, double maxCheckInterval, double convergence, int maxIterationCount) {
        int n = this.ode.getDimension();
        int k = this.ode.getParametersDimension();
        this.integrator.addEventHandler(new EventHandlerWrapper(handler, n, k), maxCheckInterval, convergence, maxIterationCount);
    }

    public Collection<EventHandlerWithJacobians> getEventHandlers() {
        Collection<EventHandlerWithJacobians> handlers = new ArrayList();
        Iterator<EventHandler> r1 = this.integrator.getEventHandlers().iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        EventHandler handler = r1.next();
        if ((handler instanceof EventHandlerWrapper) == false) goto L4;
        handlers.add(((EventHandlerWrapper) handler).getHandler());
        goto L4
    L9:
        return handlers;
    }

    public void clearEventHandlers() {
        this.integrator.clearEventHandlers();
    }

    public double integrate(double t0, double[] y0, double[][] dY0dP, double t, double[] y, double[][] dYdY0, double[][] dYdP) throws DerivativeException, IntegratorException {
        int n = this.ode.getDimension();
        int k = this.ode.getParametersDimension();
        checkDimension(n, y0);
        checkDimension(n, y);
        checkDimension(n, dYdY0);
        checkDimension(n, dYdY0[0]);
        if (k == 0) goto L5;
        checkDimension(n, dY0dP);
        checkDimension(k, dY0dP[0]);
        checkDimension(n, dYdP);
        checkDimension(k, dYdP[0]);
    L5:
        double[] z = new double[((n + 1) + k) * n];
        System.arraycopy(y0, 0, z, 0, n);
        int i = 0;
    L6:
        if (i >= n) goto L8;
        z[((n + 1) * i) + n] = 1.0d;
        System.arraycopy(dY0dP[i], 0, z, ((n + 1) * n) + (i * k), k);
        i = i + 1;
        goto L6
    L8:
        this.evaluations = 0;
        double stopTime = this.integrator.integrate(new MappingWrapper(this), t0, z, t, z);
        dispatchCompoundState(z, y, dYdY0, dYdP);
        return stopTime;
    }

    private static void dispatchCompoundState(double[] z, double[] y, double[][] dydy0, double[][] dydp) {
        int n = y.length;
        int k = dydp[0].length;
        System.arraycopy(z, 0, y, 0, n);
        int i = 0;
    L3:
        if (i >= n) goto L5;
        System.arraycopy(z, (i + 1) * n, dydy0[i], 0, n);
        i = i + 1;
        goto L3
    L5:
        int i2 = 0;
    L6:
        if (i2 >= n) goto L9;
        System.arraycopy(z, ((n + 1) * n) + (i2 * k), dydp[i2], 0, k);
        i2 = i2 + 1;
        goto L6
    }

    public double getCurrentStepStart() {
        return this.integrator.getCurrentStepStart();
    }

    public double getCurrentSignedStepsize() {
        return this.integrator.getCurrentSignedStepsize();
    }

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

    public int getMaxEvaluations() {
        return this.maxEvaluations;
    }

    public int getEvaluations() {
        return this.evaluations;
    }

    private void checkDimension(int expected, Object array) throws IllegalArgumentException {
        if (array != null) goto L4;
        int arrayDimension = 0;
    L5:
        if (arrayDimension != expected) goto L8;
        return;
    L8:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.DIMENSIONS_MISMATCH_SIMPLE, new Object[]{Integer.valueOf(arrayDimension), Integer.valueOf(expected)});
    L4:
        arrayDimension = Array.getLength(array);
        goto L5
    }
}
