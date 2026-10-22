package android.test;

import android.app.Instrumentation;
import junit.framework.Test;
import junit.framework.TestResult;
import junit.framework.TestSuite;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class InstrumentationTestSuite extends TestSuite {
    private final Instrumentation mInstrumentation;

    public InstrumentationTestSuite(Instrumentation r1) {
        this.mInstrumentation = r1;
    }

    public InstrumentationTestSuite(String r1, Instrumentation r2) {
        super(r1);
        this.mInstrumentation = r2;
    }

    public InstrumentationTestSuite(Class r1, Instrumentation r2) {
        super(r1);
        this.mInstrumentation = r2;
    }

    @Override // junit.framework.TestSuite
    public void addTestSuite(Class r3) {
        addTest(new InstrumentationTestSuite(r3, this.mInstrumentation));
    }

    @Override // junit.framework.TestSuite
    public void runTest(Test r3, TestResult r4) {
        if ((r3 instanceof InstrumentationTestCase) == false) goto L5;
        ((InstrumentationTestCase) r3).injectInstrumentation(this.mInstrumentation);
    L5:
        super.runTest(r3, r4);
    }
}
