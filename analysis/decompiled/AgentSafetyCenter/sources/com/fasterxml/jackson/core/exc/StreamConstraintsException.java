package com.fasterxml.jackson.core.exc;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonProcessingException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class StreamConstraintsException extends JsonProcessingException {
    private static final long serialVersionUID = 2;

    public StreamConstraintsException(String str) {
        super(str);
    }

    public StreamConstraintsException(String str, JsonLocation jsonLocation) {
        super(str, jsonLocation);
    }
}
