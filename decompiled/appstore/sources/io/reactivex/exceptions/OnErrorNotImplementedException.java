package io.reactivex.exceptions;

import io.reactivex.annotations.NonNull;

/* JADX INFO: loaded from: classes4.dex */
public final class OnErrorNotImplementedException extends RuntimeException {
    private static final long serialVersionUID = -6298857009889503852L;

    public OnErrorNotImplementedException(String r10, @NonNull Throwable r11) {
        if (r11 != null) goto L5;
        r11 = new NullPointerException();
    L5:
        super(r10, r11);
    }

    public OnErrorNotImplementedException(@NonNull Throwable r10) {
        this("The exception was not handled due to missing onError handler in the subscribe() method call. Further reading: https://github.com/ReactiveX/RxJava/wiki/Error-Handling | " + r10, r10);
    }
}
