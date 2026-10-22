package junit.framework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/* JADX INFO: loaded from: classes4.dex */
public class TestResult {
    protected Vector<TestFailure> fErrors;
    protected Vector<TestFailure> fFailures;
    protected Vector<TestListener> fListeners;
    protected int fRunTests;
    private boolean fStop;

    public TestResult() {
        this.fFailures = new Vector();
        this.fErrors = new Vector();
        this.fListeners = new Vector();
        this.fRunTests = 0;
        this.fStop = false;
    }

    public synchronized void addError(Test r3, Throwable r4) {
        monitor-enter(this);
        this.fErrors.add(new TestFailure(r3, r4));     // Catch: Throwable -> L10
        Iterator<TestListener> r0 = cloneListeners().iterator();     // Catch: Throwable -> L10
    L5:
        if (r0.hasNext() == false) goto L8;
        r0.next().addError(r3, r4);     // Catch: Throwable -> L10
        goto L5
    L8:
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public synchronized void addFailure(Test r3, AssertionFailedError r4) {
        monitor-enter(this);
        this.fFailures.add(new TestFailure(r3, r4));     // Catch: Throwable -> L10
        Iterator<TestListener> r0 = cloneListeners().iterator();     // Catch: Throwable -> L10
    L5:
        if (r0.hasNext() == false) goto L8;
        r0.next().addFailure(r3, r4);     // Catch: Throwable -> L10
        goto L5
    L8:
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public synchronized void addListener(TestListener r2) {
        monitor-enter(this);
        this.fListeners.add(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void removeListener(TestListener r2) {
        monitor-enter(this);
        this.fListeners.remove(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private synchronized List<TestListener> cloneListeners() {
        monitor-enter(this);
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L6
        r0.addAll(this.fListeners);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public void endTest(Test r2) {
        Iterator<TestListener> r1 = cloneListeners().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().endTest(r2);
        goto L4
    }

    public synchronized int errorCount() {
        monitor-enter(this);
        int r0 = this.fErrors.size();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized Enumeration<TestFailure> errors() {
        monitor-enter(this);
        Enumeration<TestFailure> r0 = Collections.enumeration(this.fErrors);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized int failureCount() {
        monitor-enter(this);
        int r0 = this.fFailures.size();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized Enumeration<TestFailure> failures() {
        monitor-enter(this);
        Enumeration<TestFailure> r0 = Collections.enumeration(this.fFailures);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    protected void run(final TestCase r2) {
        startTest(r2);
        runProtected(r2, new AnonymousClass1(this, r2));
        endTest(r2);
    }

    public synchronized int runCount() {
        monitor-enter(this);
        int r0 = this.fRunTests;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public void runProtected(Test r1, Protectable r2) {
        r2.protect();     // Catch: Throwable -> L4 ThreadDeath -> L6 AssertionFailedError -> L8
    L14:
        return;
    L6:
        e = move-exception;
        throw e;
    L8:
        e = move-exception;
        addFailure(r1, e);
        return;
    L4:
        th = move-exception;
        addError(r1, th);
    }

    public synchronized boolean shouldStop() {
        monitor-enter(this);
        boolean r0 = this.fStop;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public void startTest(Test r3) {
        int r0 = r3.countTestCases();
        monitor-enter(this);
        this.fRunTests += r0;     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        Iterator<TestListener> r2 = cloneListeners().iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        r2.next().startTest(r3);
        goto L8
    L10:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public synchronized void stop() {
        monitor-enter(this);
        this.fStop = true;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized boolean wasSuccessful() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (failureCount() != 0) goto L8;
        if (errorCount() != 0) goto L8;
        boolean r0 = true;
    L9:
        monitor-exit(this);
        return r0;
    L8:
        r0 = false;
        goto L9
    }
}
