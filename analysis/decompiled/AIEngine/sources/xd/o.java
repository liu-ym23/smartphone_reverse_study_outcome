package xd;

import android.os.Handler;
import android.os.Looper;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class o {

    /* renamed from: b, reason: collision with root package name */
    public static final o f13857b;

    /* renamed from: a, reason: collision with root package name */
    public final Constructor<MethodHandles.Lookup> f13858a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a extends o {

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        /* renamed from: xd.o$a$a, reason: collision with other inner class name */
        public static final class ExecutorC0175a implements Executor {

            /* renamed from: a, reason: collision with root package name */
            public final Handler f13859a = new Handler(Looper.getMainLooper());

            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                this.f13859a.post(runnable);
            }
        }

        @Override // xd.o
        public final Executor a() {
            return new ExecutorC0175a();
        }
    }

    static {
        f13857b = "Dalvik".equals(System.getProperty("java.vm.name")) ? new a() : new o();
    }

    public o() throws NoSuchMethodException, SecurityException {
        Constructor<MethodHandles.Lookup> declaredConstructor = null;
        try {
            declaredConstructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, Integer.TYPE);
            declaredConstructor.setAccessible(true);
        } catch (NoClassDefFoundError | NoSuchMethodException unused) {
        }
        this.f13858a = declaredConstructor;
    }

    public Executor a() {
        return null;
    }
}
