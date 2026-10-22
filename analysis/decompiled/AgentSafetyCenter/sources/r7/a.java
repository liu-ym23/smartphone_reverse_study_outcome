package r7;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a extends ac.a {
    @Override // ac.a
    public final boolean D(Class cls) {
        return false;
    }

    @Override // ac.a
    public final Method u(Class cls, Field field) {
        throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
    }

    @Override // ac.a
    public final Constructor v(Class cls) {
        throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
    }

    @Override // ac.a
    public final String[] y(Class cls) {
        throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
    }
}
