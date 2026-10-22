package org.apache.commons.math.ode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.ode.sampling.StepHandler;
import org.apache.commons.math.ode.sampling.StepInterpolator;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class ContinuousOutputModel implements StepHandler, Serializable {
    private static final long serialVersionUID = -1417964919405031606L;
    private double finalTime;
    private boolean forward;
    private int index;
    private double initialTime;
    private List<StepInterpolator> steps;

    public ContinuousOutputModel() {
        this.steps = new ArrayList();
        reset();
    }

    public void append(ContinuousOutputModel model) throws DerivativeException {
        if (model.steps.size() != 0) goto L6;
        return;
    L6:
        if (this.steps.size() != 0) goto L9;
        this.initialTime = model.initialTime;
        this.forward = model.forward;
    L14:
        Iterator<StepInterpolator> r2 = model.steps.iterator();
    L16:
        if (r2.hasNext() == false) goto L18;
        StepInterpolator interpolator = r2.next();
        this.steps.add(interpolator.copy());
        goto L16
    L18:
        this.index = this.steps.size() - 1;
        this.finalTime = this.steps.get(this.index).getCurrentTime();
        return;
    L9:
        if (getInterpolatedState().length != model.getInterpolatedState().length) goto L25;
        if ((this.forward ^ model.forward) == true) goto L23;
        StepInterpolator lastInterpolator = this.steps.get(this.index);
        double current = lastInterpolator.getCurrentTime();
        double previous = lastInterpolator.getPreviousTime();
        double step = current - previous;
        double gap = model.getInitialTime() - current;
        if (FastMath.abs(gap) <= (FastMath.abs(step) * 0.001d)) goto L14;
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.HOLE_BETWEEN_MODELS_TIME_RANGES, new Object[]{Double.valueOf(FastMath.abs(gap))});
    L23:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.PROPAGATION_DIRECTION_MISMATCH, new Object[0]);
    L25:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.DIMENSIONS_MISMATCH_SIMPLE, new Object[]{Integer.valueOf(getInterpolatedState().length), Integer.valueOf(model.getInterpolatedState().length)});
    }

    @Override // org.apache.commons.math.ode.sampling.StepHandler
    public boolean requiresDenseOutput() {
        return true;
    }

    @Override // org.apache.commons.math.ode.sampling.StepHandler
    public void reset() {
        this.initialTime = Double.NaN;
        this.finalTime = Double.NaN;
        this.forward = true;
        this.index = 0;
        this.steps.clear();
    }

    @Override // org.apache.commons.math.ode.sampling.StepHandler
    public void handleStep(StepInterpolator interpolator, boolean isLast) throws DerivativeException {
        if (this.steps.size() != 0) goto L5;
        this.initialTime = interpolator.getPreviousTime();
        this.forward = interpolator.isForward();
    L5:
        this.steps.add(interpolator.copy());
        if (isLast == false) goto L9;
        this.finalTime = interpolator.getCurrentTime();
        this.index = this.steps.size() - 1;
        return;
    }

    public double getInitialTime() {
        return this.initialTime;
    }

    public double getFinalTime() {
        return this.finalTime;
    }

    public double getInterpolatedTime() {
        return this.steps.get(this.index).getInterpolatedTime();
    }

    public void setInterpolatedTime(double time) {
        int iMin = 0;
        StepInterpolator sMin = this.steps.get(0);
        double r7 = 0.5d;
        double tMin = (sMin.getPreviousTime() + sMin.getCurrentTime()) * 0.5d;
        int iMax = this.steps.size() - 1;
        StepInterpolator sMax = this.steps.get(iMax);
        double tMax = (sMax.getPreviousTime() + sMax.getCurrentTime()) * 0.5d;
        if (locatePoint(time, sMin) > 0) goto L7;
        this.index = 0;
        sMin.setInterpolatedTime(time);
        return;
    L7:
        if (locatePoint(time, sMax) < 0) goto L11;
        this.index = iMax;
        sMax.setInterpolatedTime(time);
        return;
    L11:
        if ((iMax - iMin) <= 5) goto L34;
        StepInterpolator si = this.steps.get(this.index);
        int location = locatePoint(time, si);
        if (location >= 0) goto L15;
        iMax = this.index;
        tMax = (si.getPreviousTime() + si.getCurrentTime()) * r7;
    L17:
        int iMed = (iMin + iMax) / 2;
        double r16 = r7;
        StepInterpolator sMed = this.steps.get(iMed);
        double tMed = (sMed.getPreviousTime() + sMed.getCurrentTime()) * r16;
        if (FastMath.abs(tMed - tMin) < 1.0E-6d) goto L24;
        if (FastMath.abs(tMax - tMed) < 1.0E-6d) goto L24;
        double d12 = tMax - tMed;
        double d23 = tMed - tMin;
        double d13 = tMax - tMin;
        double dt1 = time - tMax;
        double dt2 = time - tMed;
        double dt3 = time - tMin;
        sMin = sMin;
        tMin = tMin;
        double iLagrange = (((((dt2 * dt3) * d23) * ((double) iMax)) - (((double) iMed) * ((dt1 * dt3) * d13))) + (((double) iMin) * ((dt1 * dt2) * d12))) / ((d12 * d23) * d13);
        this.index = (int) FastMath.rint(iLagrange);
    L25:
        int low = FastMath.max(iMin + 1, ((iMin * 9) + iMax) / 10);
        int high = FastMath.min(iMax - 1, ((iMax * 9) + iMin) / 10);
        if (this.index >= low) goto L29;
        this.index = low;
    L31:
        sMin = sMin;
        r7 = r16;
        tMin = tMin;
        goto L11
    L29:
        if (this.index <= high) goto L31;
        this.index = high;
    L24:
        this.index = iMed;
        goto L25
    L15:
        if (location <= 0) goto L32;
        iMin = this.index;
        tMin = (si.getPreviousTime() + si.getCurrentTime()) * r7;
        goto L17
    L32:
        si.setInterpolatedTime(time);
        return;
    L34:
        this.index = iMin;
    L36:
        if (this.index > iMax) goto L40;
        if (locatePoint(time, this.steps.get(this.index)) <= 0) goto L40;
        this.index++;
    L40:
        this.steps.get(this.index).setInterpolatedTime(time);
    }

    public double[] getInterpolatedState() throws DerivativeException {
        return this.steps.get(this.index).getInterpolatedState();
    }

    private int locatePoint(double time, StepInterpolator interval) {
        if (this.forward == false) goto L12;
        if (time >= interval.getPreviousTime()) goto L8;
        return -1;
    L8:
        if (time <= interval.getCurrentTime()) goto L10;
        return 1;
    L10:
        return 0;
    L12:
        if (time <= interval.getPreviousTime()) goto L15;
        return -1;
    L15:
        if (time >= interval.getCurrentTime()) goto L17;
        return 1;
    L17:
        return 0;
    }
}
