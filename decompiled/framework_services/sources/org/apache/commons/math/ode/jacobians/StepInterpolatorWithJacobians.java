package org.apache.commons.math.ode.jacobians;

import java.io.Externalizable;
import org.apache.commons.math.ode.DerivativeException;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public interface StepInterpolatorWithJacobians extends Externalizable {
    StepInterpolatorWithJacobians copy() throws DerivativeException;

    double getCurrentTime();

    double[][] getInterpolatedDyDp() throws DerivativeException;

    double[][] getInterpolatedDyDpDot() throws DerivativeException;

    double[][] getInterpolatedDyDy0() throws DerivativeException;

    double[][] getInterpolatedDyDy0Dot() throws DerivativeException;

    double getInterpolatedTime();

    double[] getInterpolatedY() throws DerivativeException;

    double[] getInterpolatedYDot() throws DerivativeException;

    double getPreviousTime();

    boolean isForward();

    void setInterpolatedTime(double r1);
}
