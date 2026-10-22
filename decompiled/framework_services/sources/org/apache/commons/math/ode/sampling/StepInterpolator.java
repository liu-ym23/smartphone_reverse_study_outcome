package org.apache.commons.math.ode.sampling;

import java.io.Externalizable;
import org.apache.commons.math.ode.DerivativeException;

/* JADX INFO: loaded from: classes3.dex */
public interface StepInterpolator extends Externalizable {
    StepInterpolator copy() throws DerivativeException;

    double getCurrentTime();

    double[] getInterpolatedDerivatives() throws DerivativeException;

    double[] getInterpolatedState() throws DerivativeException;

    double getInterpolatedTime();

    double getPreviousTime();

    boolean isForward();

    void setInterpolatedTime(double r1);
}
