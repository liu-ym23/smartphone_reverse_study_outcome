package com.networknt.schema;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* loaded from: classes2.dex */
public class FailFastAssertionException extends RuntimeException {
    private static final long serialVersionUID = 1;
    private final Error error;

    public FailFastAssertionException(Error error) {
        Objects.requireNonNull(error);
        this.error = error;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }

    public Error getError() {
        return this.error;
    }

    public List<Error> getErrors() {
        return Collections.singletonList(this.error);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        Error error = this.error;
        return error != null ? error.getMessage() : super.getMessage();
    }
}
