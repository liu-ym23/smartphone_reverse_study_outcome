package junit.framework;

/* JADX INFO: loaded from: classes4.dex */
public interface TestListener {
    void addError(Test r1, Throwable r2);

    void addFailure(Test r1, AssertionFailedError r2);

    void endTest(Test r1);

    void startTest(Test r1);
}
