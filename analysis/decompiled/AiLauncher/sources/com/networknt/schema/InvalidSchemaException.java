package com.networknt.schema;

import java.util.Objects;

/* loaded from: classes2.dex */
public class InvalidSchemaException extends SchemaException {
    private static final long serialVersionUID = 1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InvalidSchemaException(Error error, Exception exc) {
        super(error);
        Objects.requireNonNull(error);
        initCause(exc);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InvalidSchemaException(Error error) {
        super(error);
        Objects.requireNonNull(error);
    }
}
