package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.GeneratedMessageLite;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class s implements h0 {

    /* renamed from: a, reason: collision with root package name */
    public static final s f1879a = new s();

    @Override // androidx.datastore.preferences.protobuf.h0
    public final g0 a(Class<?> cls) {
        if (!GeneratedMessageLite.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
        }
        try {
            return (g0) GeneratedMessageLite.j(cls.asSubclass(GeneratedMessageLite.class)).i(GeneratedMessageLite.MethodToInvoke.f1742c);
        } catch (Exception e10) {
            throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e10);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public final boolean b(Class<?> cls) {
        return GeneratedMessageLite.class.isAssignableFrom(cls);
    }
}
