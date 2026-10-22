package junit.framework;

/* JADX INFO: loaded from: classes4.dex */
public class AssertionFailedError extends AssertionError {
    private static final long serialVersionUID = 1;

    private static String defaultString(String r0) {
        if (r0 != null) goto L5;
        return "";
    L5:
        return r0;
    }

    public AssertionFailedError() {
    }

    public AssertionFailedError(String r1) {
        super(defaultString(r1));
    }
}
