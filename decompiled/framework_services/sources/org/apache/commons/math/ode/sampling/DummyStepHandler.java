package org.apache.commons.math.ode.sampling;

/* JADX INFO: loaded from: classes3.dex */
public class DummyStepHandler implements StepHandler {

    /* JADX INFO: renamed from: org.apache.commons.math.ode.sampling.DummyStepHandler$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class LazyHolder {
        private static final DummyStepHandler INSTANCE = null;

        private LazyHolder() {
        }

        static /* synthetic */ DummyStepHandler access$000() {
            return INSTANCE;
        }

        static {
            INSTANCE = new DummyStepHandler(null);
        }
    }

    /* synthetic */ DummyStepHandler(AnonymousClass1 x0) {
        this();
    }

    private DummyStepHandler() {
    }

    public static DummyStepHandler getInstance() {
        return LazyHolder.access$000();
    }

    @Override // org.apache.commons.math.ode.sampling.StepHandler
    public boolean requiresDenseOutput() {
        return false;
    }

    @Override // org.apache.commons.math.ode.sampling.StepHandler
    public void reset() {
    }

    @Override // org.apache.commons.math.ode.sampling.StepHandler
    public void handleStep(StepInterpolator interpolator, boolean isLast) {
    }

    private Object readResolve() {
        return LazyHolder.access$000();
    }
}
