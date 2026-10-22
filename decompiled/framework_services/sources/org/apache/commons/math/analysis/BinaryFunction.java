package org.apache.commons.math.analysis;

import org.apache.commons.math.FunctionEvaluationException;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public abstract class BinaryFunction implements BivariateRealFunction {
    public static final BinaryFunction ADD = null;
    public static final BinaryFunction ATAN2 = null;
    public static final BinaryFunction DIVIDE = null;
    public static final BinaryFunction MULTIPLY = null;
    public static final BinaryFunction POW = null;
    public static final BinaryFunction SUBTRACT = null;

    @Override // org.apache.commons.math.analysis.BivariateRealFunction
    public abstract double value(double r1, double r3) throws FunctionEvaluationException;

    public BinaryFunction() {
    }

    static {
        ADD = new AnonymousClass1();
        SUBTRACT = new AnonymousClass2();
        MULTIPLY = new AnonymousClass3();
        DIVIDE = new AnonymousClass4();
        POW = new AnonymousClass5();
        ATAN2 = new AnonymousClass6();
    }

    public ComposableFunction fix1stArgument(final double fixedX) {
        return new AnonymousClass7(this, fixedX);
    }

    public ComposableFunction fix2ndArgument(final double fixedY) {
        return new AnonymousClass8(this, fixedY);
    }
}
