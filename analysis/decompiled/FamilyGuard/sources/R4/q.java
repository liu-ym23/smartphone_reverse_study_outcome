package R4;

import R4.c;
import R4.f;
import android.os.Handler;
import android.os.Looper;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
class q {

    /* renamed from: c, reason: collision with root package name */
    private static final q f5108c = e();

    /* renamed from: a, reason: collision with root package name */
    private final boolean f5109a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private final Constructor<MethodHandles.Lookup> f5110b;

    static final class a extends q {

        /* renamed from: R4.q$a$a, reason: collision with other inner class name */
        static final class ExecutorC0078a implements Executor {

            /* renamed from: a, reason: collision with root package name */
            private final Handler f5111a = new Handler(Looper.getMainLooper());

            ExecutorC0078a() {
            }

            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                this.f5111a.post(runnable);
            }
        }

        a() {
            super(true);
        }

        @Override // R4.q
        public Executor b() {
            return new ExecutorC0078a();
        }

        @Override // R4.q
        @Nullable
        Object g(Method method, Class<?> cls, Object obj, Object... objArr) {
            return super.g(method, cls, obj, objArr);
        }
    }

    q(boolean z5) throws NoSuchMethodException, SecurityException {
        this.f5109a = z5;
        Constructor<MethodHandles.Lookup> declaredConstructor = null;
        if (z5) {
            try {
                declaredConstructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, Integer.TYPE);
                declaredConstructor.setAccessible(true);
            } catch (NoClassDefFoundError | NoSuchMethodException unused) {
            }
        }
        this.f5110b = declaredConstructor;
    }

    private static q e() {
        return "Dalvik".equals(System.getProperty("java.vm.name")) ? new a() : new q(true);
    }

    static q f() {
        return f5108c;
    }

    List<? extends c.a> a(@Nullable Executor executor) {
        g gVar = new g(executor);
        return this.f5109a ? Arrays.asList(e.f5000a, gVar) : Collections.singletonList(gVar);
    }

    @Nullable
    Executor b() {
        return null;
    }

    List<? extends f.a> c() {
        return this.f5109a ? Collections.singletonList(o.f5061a) : Collections.EMPTY_LIST;
    }

    int d() {
        return this.f5109a ? 1 : 0;
    }

    @Nullable
    Object g(Method method, Class<?> cls, Object obj, Object... objArr) {
        Constructor<MethodHandles.Lookup> constructor = this.f5110b;
        return (constructor != null ? constructor.newInstance(cls, -1) : MethodHandles.lookup()).unreflectSpecial(method, cls).bindTo(obj).invokeWithArguments(objArr);
    }

    boolean h(Method method) {
        return this.f5109a && method.isDefault();
    }
}
