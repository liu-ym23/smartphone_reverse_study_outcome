package junit.framework;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* JADX INFO: loaded from: classes4.dex */
public abstract class TestCase extends Assert implements Test {
    private String fName;

    @Override // junit.framework.Test
    public int countTestCases() {
        return 1;
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    public TestCase() {
        this.fName = null;
    }

    public TestCase(String r1) {
        this.fName = r1;
    }

    protected TestResult createResult() {
        return new TestResult();
    }

    public TestResult run() {
        TestResult r0 = createResult();
        run(r0);
        return r0;
    }

    @Override // junit.framework.Test
    public void run(TestResult r1) {
        r1.run(this);
    }

    public void runBare() throws Throwable {
        setUp();
        runTest();     // Catch: Throwable -> L8
        tearDown();     // Catch: Throwable -> L6
        Throwable th = null;
    L11:
        if (th != null) goto L13;
        return;
    L13:
        throw th;
    L6:
        th = th;
    L8:
        th = move-exception;
        tearDown();     // Catch: Throwable -> L14
    L10:
        th = th;
        goto L11
    }

    protected void runTest() throws Throwable {
        assertNotNull("TestCase.fName cannot be null", this.fName);
        Method r1 = null;
        Class[] r4 = (Class[]) null;     // Catch: NoSuchMethodException -> L5
        r1 = getClass().getMethod(this.fName, null);     // Catch: NoSuchMethodException -> L5
    L7:
        if (Modifier.isPublic(r1.getModifiers()) == true) goto L20;
        fail("Method \"" + this.fName + "\" should be public");
    L20:
        r1.invoke(this, new Object[0]);     // Catch: IllegalAccessException -> L12 InvocationTargetException -> L15
        return;
    L12:
        e = move-exception;
        e.fillInStackTrace();
        throw e;
    L15:
        e = move-exception;
        e.fillInStackTrace();
        throw e.getTargetException();
    L5:
        fail("Method \"" + this.fName + "\" not found");
        goto L7
    }

    public String toString() {
        return getName() + "(" + getClass().getName() + ")";
    }

    public String getName() {
        return this.fName;
    }

    public void setName(String r1) {
        this.fName = r1;
    }
}
