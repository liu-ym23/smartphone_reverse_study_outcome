package org.apache.http;

import java.nio.charset.CharacterCodingException;

/* JADX INFO: loaded from: classes4.dex */
public class MessageConstraintException extends CharacterCodingException {
    private static final long serialVersionUID = 6077207720446368695L;
    private final String message;

    public MessageConstraintException(String r10) {
        this.message = r10;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }
}
