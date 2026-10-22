package junit.framework;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/* JADX INFO: loaded from: classes4.dex */
public class TestSuite implements Test {
    private String fName;
    private Vector<Test> fTests;

    public static Test createTest(Class<?> r4, String r5) {
        Constructor<?> r6 = getTestConstructor(r4);     // Catch: NoSuchMethodException -> L21
    L12:
        e = move-exception;
        return warning("Cannot access test case: " + r5 + " (" + exceptionToString(e) + ")");
    L18:
        e = move-exception;
        return warning("Cannot instantiate test case: " + r5 + " (" + exceptionToString(e) + ")");
    L15:
        e = move-exception;
        return warning("Exception in constructor: " + r5 + " (" + exceptionToString(e.getTargetException()) + ")");
    L5:
        if (r6.getParameterTypes().length != 0) goto L9;
        Object r7 = r6.newInstance(new Object[0]);     // Catch: IllegalAccessException -> L12 InvocationTargetException -> L15 InstantiationException -> L18
        if ((r7 instanceof TestCase) == false) goto L11;
        ((TestCase) r7).setName(r5);     // Catch: IllegalAccessException -> L12 InvocationTargetException -> L15 InstantiationException -> L18
    L11:
        return (Test) r7;
    L9:
        r7 = r6.newInstance(new Object[]{r5});     // Catch: IllegalAccessException -> L12 InvocationTargetException -> L15 InstantiationException -> L18
    L22:
        return warning("Class " + r4.getName() + " has no public constructor TestCase(String name) or TestCase()");
    }

    public static Constructor<?> getTestConstructor(Class<?> r3) throws NoSuchMethodException {
        return r3.getConstructor(new Class[]{String.class});
    L6:
        return r3.getConstructor(new Class[0]);
    }

    public static Test warning(final String r2) {
        final String r1 = "warning";
        return new AnonymousClass1(r1, r2);
    }

    private static String exceptionToString(Throwable r2) {
        StringWriter r0 = new StringWriter();
        r2.printStackTrace(new PrintWriter(r0));
        return r0.toString();
    }

    public TestSuite() {
        this.fTests = new Vector(10);
    }

    public TestSuite(Class<?> r3) {
        this.fTests = new Vector(10);
        addTestsFromTestCase(r3);
    }

    private void addTestsFromTestCase(Class<?> r7) {
        this.fName = r7.getName();
        getTestConstructor(r7);     // Catch: NoSuchMethodException -> L19
        if (Modifier.isPublic(r7.getModifiers()) == true) goto L8;
        addTest(warning("Class " + r7.getName() + " is not public"));
        return;
    L8:
        ArrayList r0 = new ArrayList();
        Class<?> r1 = r7;
    L10:
        if (Test.class.isAssignableFrom(r1) == false) goto L16;
        Method[] r2 = r1.getDeclaredMethods();
        int r3 = r2.length;
        int r4 = 0;
    L12:
        if (r4 >= r3) goto L14;
        addTestMethod(r2[r4], r0, r7);
        r4 = r4 + 1;
        goto L12
    L14:
        r1 = r1.getSuperclass();
        goto L10
    L16:
        if (this.fTests.size() != 0) goto L25;
        addTest(warning("No tests found in " + r7.getName()));
        return;
    L25:
        return;
    L19:
        addTest(warning("Class " + r7.getName() + " has no public constructor TestCase(String name) or TestCase()"));
    }

    public TestSuite(Class<? extends TestCase> r1, String r2) {
        this(r1);
        setName(r2);
    }

    public TestSuite(String r3) {
        this.fTests = new Vector(10);
        setName(r3);
    }

    public TestSuite(Class<?>... r4) {
        this.fTests = new Vector(10);
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        addTest(testCaseForClass(r4[r1]));
        r1 = r1 + 1;
        goto L3
    }

    private Test testCaseForClass(Class<?> r2) {
        if (TestCase.class.isAssignableFrom(r2) == false) goto L7;
        return new TestSuite(r2.asSubclass(TestCase.class));
    L7:
        return warning(r2.getCanonicalName() + " does not extend TestCase");
    }

    public TestSuite(Class<? extends TestCase>[] r1, String r2) {
        this(r1);
        setName(r2);
    }

    public void addTest(Test r1) {
        this.fTests.add(r1);
    }

    public void addTestSuite(Class<? extends TestCase> r2) {
        addTest(new TestSuite(r2));
    }

    @Override // junit.framework.Test
    public int countTestCases() {
        Iterator<Test> r2 = this.fTests.iterator();
        int r0 = 0;
    L4:
        if (r2.hasNext() == false) goto L6;
        r0 = r0 + r2.next().countTestCases();
        goto L4
    L6:
        return r0;
    }

    public String getName() {
        return this.fName;
    }

    @Override // junit.framework.Test
    public void run(TestResult r4) {
        Iterator<Test> r0 = this.fTests.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Test r1 = r0.next();
        if (r4.shouldStop() == true) goto L12;
        runTest(r1, r4);
        goto L4
    L12:
        return;
    }

    public void runTest(Test r1, TestResult r2) {
        r1.run(r2);
    }

    public void setName(String r1) {
        this.fName = r1;
    }

    public Test testAt(int r1) {
        return this.fTests.get(r1);
    }

    public int testCount() {
        return this.fTests.size();
    }

    public Enumeration<Test> tests() {
        return this.fTests.elements();
    }

    public String toString() {
        if (getName() == null) goto L7;
        return getName();
    L7:
        return super.toString();
    }

    private void addTestMethod(Method r3, List<String> r4, Class<?> r5) {
        String r0 = r3.getName();
        if (r4.contains(r0) == false) goto L6;
        return;
    L6:
        if (isPublicTestMethod(r3) == false) goto L8;
        r4.add(r0);
        addTest(createTest(r5, r0));
        return;
    L8:
        if (isTestMethod(r3) == false) goto L13;
        addTest(warning("Test method isn't public: " + r3.getName() + "(" + r5.getCanonicalName() + ")"));
        return;
    }

    private boolean isPublicTestMethod(Method r1) {
        if (isTestMethod(r1) == true) goto L5;
    L7:
        return false;
    L5:
        if (Modifier.isPublic(r1.getModifiers()) == false) goto L7;
        return true;
    }

    private boolean isTestMethod(Method r2) {
        if (r2.getParameterTypes().length == 0) goto L5;
    L9:
        return false;
    L5:
        if (r2.getName().startsWith("test") == false) goto L9;
        if (r2.getReturnType().equals(Void.TYPE) == false) goto L9;
        return true;
    }
}
