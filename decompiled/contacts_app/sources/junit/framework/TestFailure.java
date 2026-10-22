package junit.framework;

import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: loaded from: classes4.dex */
public class TestFailure {
    protected Test fFailedTest;
    protected Throwable fThrownException;

    public TestFailure(Test r1, Throwable r2) {
        this.fFailedTest = r1;
        this.fThrownException = r2;
    }

    public Test failedTest() {
        return this.fFailedTest;
    }

    public Throwable thrownException() {
        return this.fThrownException;
    }

    public String toString() {
        StringBuffer r0 = new StringBuffer();
        r0.append(this.fFailedTest + ": " + this.fThrownException.getMessage());
        return r0.toString();
    }

    public String trace() {
        StringWriter r0 = new StringWriter();
        PrintWriter r1 = new PrintWriter(r0);
        thrownException().printStackTrace(r1);
        return r0.getBuffer().toString();
    }

    public String exceptionMessage() {
        return thrownException().getMessage();
    }

    public boolean isFailure() {
        return thrownException() instanceof AssertionFailedError;
    }
}
