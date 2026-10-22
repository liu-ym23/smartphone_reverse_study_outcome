package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.List;

/* loaded from: classes5.dex */
public class UninitializedMessageException extends RuntimeException {

    /* renamed from: a, reason: collision with root package name */
    public final List<String> f35850a;

    public UninitializedMessageException(h hVar) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.f35850a = null;
    }

    public InvalidProtocolBufferException a() {
        return new InvalidProtocolBufferException(getMessage());
    }
}
