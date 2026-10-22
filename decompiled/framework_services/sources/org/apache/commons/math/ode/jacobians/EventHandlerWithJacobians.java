package org.apache.commons.math.ode.jacobians;

import org.apache.commons.math.ode.events.EventException;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public interface EventHandlerWithJacobians {
    public static final int CONTINUE = 3;
    public static final int RESET_DERIVATIVES = 2;
    public static final int RESET_STATE = 1;
    public static final int STOP = 0;

    int eventOccurred(double r1, double[] r3, double[][] r4, double[][] r5, boolean r6) throws EventException;

    double g(double r1, double[] r3, double[][] r4, double[][] r5) throws EventException;

    void resetState(double r1, double[] r3, double[][] r4, double[][] r5) throws EventException;
}
