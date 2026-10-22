package com.networknt.schema;

/* loaded from: classes2.dex */
public class InvalidSchemaRefException extends InvalidSchemaException {
    private static final long serialVersionUID = 1;

    public InvalidSchemaRefException(Error error, Exception exc) {
        super(error, exc);
    }

    public InvalidSchemaRefException(Error error) {
        super(error);
    }
}
