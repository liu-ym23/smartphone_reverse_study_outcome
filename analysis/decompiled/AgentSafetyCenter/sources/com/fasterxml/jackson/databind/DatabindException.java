package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonProcessingException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class DatabindException extends JsonProcessingException {
    private static final long serialVersionUID = 3;

    public DatabindException(String str, JsonLocation jsonLocation) {
        this(str, jsonLocation, null);
    }

    public abstract void prependPath(Object obj, int i);

    public abstract void prependPath(Object obj, String str);

    public DatabindException(String str) {
        super(str);
    }

    public DatabindException(String str, JsonLocation jsonLocation, Throwable th) {
        super(str, jsonLocation, th);
    }

    public DatabindException(String str, Throwable th) {
        this(str, null, th);
    }
}
