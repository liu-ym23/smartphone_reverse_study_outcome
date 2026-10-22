package retrofit2;

import android.os.Handler;
import android.os.Looper;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes4.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f24066a = null;

    public static class a extends f {

        /* JADX INFO: renamed from: retrofit2.f$a$a, reason: collision with other inner class name */
        public static class ExecutorC0360a implements Executor {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Handler f24067a;

            public ExecutorC0360a() {
                this.f24067a = new Handler(Looper.getMainLooper());
            }

            @Override // java.util.concurrent.Executor
            public void execute(Runnable r10) {
                this.f24067a.post(r10);
            }
        }

        public a() {
        }

        @Override // retrofit2.f
        public CallAdapter.a a(Executor r10) {
            if (r10 == null) goto L6;
            return new c(r10);
        L6:
            throw new AssertionError();
        }

        @Override // retrofit2.f
        public Executor b() {
            return new ExecutorC0360a();
        }
    }

    public static class b extends f {
        public b() {
        }

        @Override // retrofit2.f
        public Object e(Method r10, Class r11, Object r12, Object... r13) {
            Constructor r14 = MethodHandles.Lookup.class.getDeclaredConstructor(new Class[]{Class.class, Integer.TYPE});
            r14.setAccessible(true);
            return ((MethodHandles.Lookup) r14.newInstance(new Object[]{r11, -1})).unreflectSpecial(r10, r11).bindTo(r12).invokeWithArguments(r13);
        }

        @Override // retrofit2.f
        public boolean f(Method r10) {
            return r10.isDefault();
        }
    }

    static {
        f24066a = c();
    }

    public f() {
    }

    public static f c() {
        Class.forName("android.os.Build");     // Catch: ClassNotFoundException -> L4
        return new a();
    L4:
        Class.forName("java.util.Optional");     // Catch: ClassNotFoundException -> L6
        return new b();
    L7:
        return new f();
    }

    public static f d() {
        return f24066a;
    }

    public CallAdapter.a a(Executor r10) {
        if (r10 == null) goto L6;
        return new c(r10);
    L6:
        return retrofit2.b.f24006a;
    }

    public Executor b() {
        return null;
    }

    public Object e(Method r10, Class r11, Object r12, Object... r13) {
        throw new UnsupportedOperationException();
    }

    public boolean f(Method r10) {
        return false;
    }
}
