package org.apache.commons.math.analysis;

import org.apache.commons.math.FunctionEvaluationException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ComposableFunction implements UnivariateRealFunction {
    public static final ComposableFunction ABS = null;
    public static final ComposableFunction ACOS = null;
    public static final ComposableFunction ASIN = null;
    public static final ComposableFunction ATAN = null;
    public static final ComposableFunction CBRT = null;
    public static final ComposableFunction CEIL = null;
    public static final ComposableFunction COS = null;
    public static final ComposableFunction COSH = null;
    public static final ComposableFunction EXP = null;
    public static final ComposableFunction EXPM1 = null;
    public static final ComposableFunction FLOOR = null;
    public static final ComposableFunction IDENTITY = null;
    public static final ComposableFunction INVERT = null;
    public static final ComposableFunction LOG = null;
    public static final ComposableFunction LOG10 = null;
    public static final ComposableFunction LOG1P = null;
    public static final ComposableFunction NEGATE = null;
    public static final ComposableFunction ONE = null;
    public static final ComposableFunction RINT = null;
    public static final ComposableFunction SIGNUM = null;
    public static final ComposableFunction SIN = null;
    public static final ComposableFunction SINH = null;
    public static final ComposableFunction SQRT = null;
    public static final ComposableFunction TAN = null;
    public static final ComposableFunction TANH = null;
    public static final ComposableFunction ULP = null;
    public static final ComposableFunction ZERO = null;

    @Override // org.apache.commons.math.analysis.UnivariateRealFunction
    public abstract double value(double r1) throws FunctionEvaluationException;

    public ComposableFunction() {
    }

    static {
        ZERO = new AnonymousClass1();
        ONE = new AnonymousClass2();
        IDENTITY = new AnonymousClass3();
        ABS = new AnonymousClass4();
        NEGATE = new AnonymousClass5();
        INVERT = new AnonymousClass6();
        SIN = new AnonymousClass7();
        SQRT = new AnonymousClass8();
        SINH = new AnonymousClass9();
        EXP = new AnonymousClass10();
        EXPM1 = new AnonymousClass11();
        ASIN = new AnonymousClass12();
        ATAN = new AnonymousClass13();
        TAN = new AnonymousClass14();
        TANH = new AnonymousClass15();
        CBRT = new AnonymousClass16();
        CEIL = new AnonymousClass17();
        FLOOR = new AnonymousClass18();
        LOG = new AnonymousClass19();
        LOG10 = new AnonymousClass20();
        LOG1P = new AnonymousClass21();
        COS = new AnonymousClass22();
        ACOS = new AnonymousClass23();
        COSH = new AnonymousClass24();
        RINT = new AnonymousClass25();
        SIGNUM = new AnonymousClass26();
        ULP = new AnonymousClass27();
    }

    public ComposableFunction of(final UnivariateRealFunction f) {
        return new AnonymousClass28(this, f);
    }

    public ComposableFunction postCompose(final UnivariateRealFunction f) {
        return new AnonymousClass29(this, f);
    }

    public ComposableFunction combine(final UnivariateRealFunction f, final BivariateRealFunction combiner) {
        return new AnonymousClass30(this, combiner, f);
    }

    public ComposableFunction add(final UnivariateRealFunction f) {
        return new AnonymousClass31(this, f);
    }

    public ComposableFunction add(final double a) {
        return new AnonymousClass32(this, a);
    }

    public ComposableFunction subtract(final UnivariateRealFunction f) {
        return new AnonymousClass33(this, f);
    }

    public ComposableFunction multiply(final UnivariateRealFunction f) {
        return new AnonymousClass34(this, f);
    }

    public ComposableFunction multiply(final double scaleFactor) {
        return new AnonymousClass35(this, scaleFactor);
    }

    public ComposableFunction divide(final UnivariateRealFunction f) {
        return new AnonymousClass36(this, f);
    }

    public MultivariateRealFunction asCollector(final BivariateRealFunction combiner, final double initialValue) {
        return new AnonymousClass37(this, initialValue, combiner);
    }

    public MultivariateRealFunction asCollector(BivariateRealFunction combiner) {
        return asCollector(combiner, 0.0d);
    }

    public MultivariateRealFunction asCollector(double initialValue) {
        return asCollector(BinaryFunction.ADD, initialValue);
    }

    public MultivariateRealFunction asCollector() {
        return asCollector(BinaryFunction.ADD, 0.0d);
    }
}
