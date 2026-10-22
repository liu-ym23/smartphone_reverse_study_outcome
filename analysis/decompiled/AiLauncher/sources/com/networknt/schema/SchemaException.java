package com.networknt.schema;

import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class SchemaException extends RuntimeException {
    private static final long serialVersionUID = -7805792737596582110L;
    private final Error error;

    public SchemaException(Error error) {
        this.error = error;
    }

    public Error getError() {
        return this.error;
    }

    public List<Error> getErrors() {
        Error error = this.error;
        return error == null ? Collections.EMPTY_LIST : Collections.singletonList(error);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        Error error = this.error;
        return error != null ? error.getMessage() : super.getMessage();
    }

    public SchemaException(String str) {
        super(str);
        this.error = null;
    }

    public SchemaException(Throwable th) {
        super(th);
        this.error = null;
    }
}
