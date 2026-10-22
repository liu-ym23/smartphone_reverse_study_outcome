package org.apache.commons.math.ode.events;

/* JADX INFO: loaded from: classes3.dex */
public interface EventHandler {
    public static final int CONTINUE = 3;
    public static final int RESET_DERIVATIVES = 2;
    public static final int RESET_STATE = 1;
    public static final int STOP = 0;

    int eventOccurred(double r1, double[] r3, boolean r4) throws EventException;

    double g(double r1, double[] r3) throws EventException;

    void resetState(double r1, double[] r3) throws EventException;
}
