package rx.exceptions;

/* JADX INFO: loaded from: classes4.dex */
public class OnErrorNotImplementedException extends RuntimeException {
    private static final long serialVersionUID = -6298857009889503852L;

    public OnErrorNotImplementedException(String r10, Throwable r11) {
        if (r11 != null) goto L5;
        r11 = new NullPointerException();
    L5:
        super(r10, r11);
    }

    public OnErrorNotImplementedException(Throwable r10) {
        if (r10 == null) goto L4;
        String r11 = r10.getMessage();
    L5:
        if (r10 != null) goto L8;
        r10 = new NullPointerException();
    L8:
        super(r11, r10);
        return;
    L4:
        r11 = null;
        goto L5
    }
}
