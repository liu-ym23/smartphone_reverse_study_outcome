package rx.exceptions;

/* JADX INFO: loaded from: classes4.dex */
public final class OnCompletedFailedException extends RuntimeException {
    private static final long serialVersionUID = 8622579378868820554L;

    public OnCompletedFailedException(Throwable r10) {
        if (r10 != null) goto L5;
        r10 = new NullPointerException();
    L5:
        super(r10);
    }

    public OnCompletedFailedException(String r10, Throwable r11) {
        if (r11 != null) goto L5;
        r11 = new NullPointerException();
    L5:
        super(r10, r11);
    }
}
