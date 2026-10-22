package ie;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public class k0 {

    /* renamed from: b, reason: collision with root package name */
    public static final k0 f6003b;

    /* renamed from: a, reason: collision with root package name */
    public final Constructor f6004a;

    static {
        f6003b = "Dalvik".equals(System.getProperty("java.vm.name")) ? new j0() : new k0();
    }

    public k0() throws NoSuchMethodException, SecurityException {
        Constructor declaredConstructor = null;
        try {
            declaredConstructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, Integer.TYPE);
            declaredConstructor.setAccessible(true);
        } catch (NoClassDefFoundError | NoSuchMethodException unused) {
        }
        this.f6004a = declaredConstructor;
    }

    public Executor a() {
        return null;
    }
}
