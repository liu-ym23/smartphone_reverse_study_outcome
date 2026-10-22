package com.fasterxml.jackson.core;

import java.io.IOException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class JacksonException extends IOException {
    private static final long serialVersionUID = 123;

    public JacksonException(String str) {
        super(str);
    }

    public abstract JsonLocation getLocation();

    public abstract String getOriginalMessage();

    public abstract Object getProcessor();

    public JacksonException(Throwable th) {
        super(th);
    }

    public JacksonException(String str, Throwable th) {
        super(str, th);
    }
}
