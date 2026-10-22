package kotlin.reflect.jvm.internal.impl.protobuf;

/* loaded from: classes4.dex */
public class UninitializedMessageException extends RuntimeException {
    public UninitializedMessageException() {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }
}
