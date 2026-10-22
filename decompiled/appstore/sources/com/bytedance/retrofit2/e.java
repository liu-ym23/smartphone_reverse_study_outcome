package com.bytedance.retrofit2;

import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import retrofit2.Retrofit;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f7997a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f7998b = false;

    public static class a extends e {

        /* JADX INFO: renamed from: com.bytedance.retrofit2.e$a$a, reason: collision with other inner class name */
        public static class ExecutorC0103a implements Executor {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Handler f7999a;

            public ExecutorC0103a() {
                this.f7999a = new Handler(Looper.getMainLooper());
            }

            @Override // java.util.concurrent.Executor
            public void execute(Runnable r10) {
                this.f7999a.post(r10);
            }
        }

        public a() {
        }

        @Override // com.bytedance.retrofit2.e
        public CallAdapter.a a(Executor r10) {
            return new c(r10);
        }

        @Override // com.bytedance.retrofit2.e
        public Executor b() {
            return new ExecutorC0103a();
        }
    }

    public static class b extends e {

        public static class a implements Executor {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static Object f8000a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static Method f8001b;

            static {
                Class<?> r10 = Class.forName("org.robovm.apple.foundation.NSOperationQueue");     // Catch: Exception -> L4
                f8000a = r10.getDeclaredMethod("getMainQueue", null).invoke(null, null);     // Catch: Exception -> L4
                f8001b = r10.getDeclaredMethod("addOperation", new Class[]{Runnable.class});     // Catch: Exception -> L4
                return;
            L4:
                e = move-exception;
                throw new AssertionError(e);
            }

            public a() {
            }

            @Override // java.util.concurrent.Executor
            public void execute(Runnable r10) {
                f8001b.invoke(f8000a, new Object[]{r10});     // Catch: InvocationTargetException -> L4 Throwable -> L6
                return;
            L6:
                e = move-exception;
                throw new AssertionError(e);
            L4:
                e = move-exception;
                Throwable r11 = e.getCause();
                if ((r11 instanceof RuntimeException) == true) goto L17;
                if ((r11 instanceof Error) == false) goto L15;
                throw ((Error) r11);
            L15:
                throw new RuntimeException(r11);
            L17:
                throw ((RuntimeException) r11);
            }
        }

        public b() {
        }

        @Override // com.bytedance.retrofit2.e
        public CallAdapter.a a(Executor r10) {
            return new c(r10);
        }

        @Override // com.bytedance.retrofit2.e
        public Executor b() {
            return new a();
        }
    }

    static {
        f7997a = c();
        f7998b = d();
    }

    public e() {
    }

    public static e c() {
        Class.forName("android.os.Build");     // Catch: ClassNotFoundException -> L4
        return new a();
    L4:
        Class.forName("org.robovm.apple.foundation.NSObject");     // Catch: ClassNotFoundException -> L6
        return new b();
    L7:
        return new e();
    }

    public static boolean d() {
        new Retrofit.b();     // Catch: NoClassDefFoundError -> L5
        return true;
    L5:
        return false;
    }

    public static e e() {
        return f7997a;
    }

    public static boolean h() {
        return f7998b;
    }

    public CallAdapter.a a(Executor r10) {
        if (r10 == null) goto L6;
        return new c(r10);
    L6:
        return com.bytedance.retrofit2.b.f7946a;
    }

    public Executor b() {
        return null;
    }

    public Object f(Method r10, Class r11, Object r12, Object... r13) {
        throw new UnsupportedOperationException();
    }

    public boolean g(Method r10) {
        return false;
    }
}
