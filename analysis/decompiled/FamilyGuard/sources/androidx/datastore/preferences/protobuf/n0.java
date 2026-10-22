package androidx.datastore.preferences.protobuf;

import java.util.List;

/* loaded from: classes.dex */
public class n0 extends RuntimeException {

    /* renamed from: a, reason: collision with root package name */
    private final List<String> f10097a;

    public n0(S s5) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.f10097a = null;
    }

    public B a() {
        return new B(getMessage());
    }
}
