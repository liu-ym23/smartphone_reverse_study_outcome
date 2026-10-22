package com.bytedance.location.protobuf;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class UninitializedMessageException extends RuntimeException {
    private static final long serialVersionUID = -7466929953374883507L;
    private final List<String> missingFields;

    public UninitializedMessageException(MessageLite message) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.missingFields = null;
    }

    public UninitializedMessageException(List<String> missingFields) {
        super(buildDescription(missingFields));
        this.missingFields = missingFields;
    }

    public List<String> getMissingFields() {
        return Collections.unmodifiableList(this.missingFields);
    }

    public InvalidProtocolBufferException asInvalidProtocolBufferException() {
        return new InvalidProtocolBufferException(getMessage());
    }

    private static String buildDescription(List<String> missingFields) {
        StringBuilder description = new StringBuilder("Message missing required fields: ");
        boolean first = true;
        Iterator<String> r2 = missingFields.iterator();
    L4:
        if (r2.hasNext() == false) goto L11;
        String field = r2.next();
        if (first == false) goto L8;
        first = false;
    L9:
        description.append(field);
        goto L4
    L8:
        description.append(", ");
        goto L9
    L11:
        return description.toString();
    }
}
