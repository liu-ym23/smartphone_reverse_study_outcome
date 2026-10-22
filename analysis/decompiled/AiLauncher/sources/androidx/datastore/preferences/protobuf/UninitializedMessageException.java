package androidx.datastore.preferences.protobuf;

import java.util.List;

/* loaded from: classes.dex */
public class UninitializedMessageException extends RuntimeException {

    /* renamed from: a, reason: collision with root package name */
    public final List<String> f13487a;

    public UninitializedMessageException(K k10) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.f13487a = null;
    }

    public InvalidProtocolBufferException a() {
        return new InvalidProtocolBufferException(getMessage());
    }
}
