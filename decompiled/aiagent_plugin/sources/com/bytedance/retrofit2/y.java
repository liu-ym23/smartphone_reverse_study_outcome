package com.bytedance.retrofit2;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import retrofit2.Retrofit;

/* JADX INFO: compiled from: Platform.java */
/* JADX INFO: loaded from: classes.dex */
class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final y f9681a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final boolean f9682b = false;

    /* JADX INFO: compiled from: Platform.java */
    static class a extends y {

        /* JADX INFO: renamed from: com.bytedance.retrofit2.y$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Platform.java */
        static class ExecutorC0219a implements Executor {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Handler f9683a;

            ExecutorC0219a() {
                this.f9683a = new Handler(Looper.getMainLooper());
            }

            @Override // java.util.concurrent.Executor
            public void execute(Runnable r3) {
                Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
                this.f9683a.post(r4);
            }
        }

        @Override // com.bytedance.retrofit2.y
        int e() {
            return 0;
        }

        a() {
        }

        @Override // com.bytedance.retrofit2.y
        boolean a(Method r2) {
            if (Build.VERSION.SDK_INT >= 24) goto L7;
            return false;
        L7:
            return r2.isDefault();
        }

        @Override // com.bytedance.retrofit2.y
        public Executor c() {
            return new ExecutorC0219a();
        }

        @Override // com.bytedance.retrofit2.y
        List<? extends f.a> a(Executor r2) {
            Executor r1 = (Executor) ZeusTransformUtils.wrapperContextForParams(r2, Executor.class, "com.obric.aiagent.plugin");
            if (r1 == null) goto L7;
            return Collections.singletonList(new m(r1));
        L7:
            throw new AssertionError();
        }

        @Override // com.bytedance.retrofit2.y
        List<? extends i.a> d() {
            return Collections.emptyList();
        }
    }

    boolean a(Method r1) {
        return false;
    }

    public Executor c() {
        return null;
    }

    int e() {
        return 0;
    }

    y() {
    }

    static {
        f9681a = f();
        f9682b = g();
    }

    static y a() {
        return f9681a;
    }

    static boolean b() {
        return f9682b;
    }

    private static y f() {
        ZeusTransformUtils.forName("android.os.Build", "com.obric.aiagent.plugin");     // Catch: ClassNotFoundException -> L8
        if (Build.VERSION.SDK_INT == 0) goto L7;
        return new a();
    L7:
        return new y();
    }

    private static boolean g() {
        new Retrofit.Builder();     // Catch: NoClassDefFoundError -> L5
        return true;
    L5:
        return false;
    }

    List<? extends f.a> a(Executor r2) {
        Executor r1 = (Executor) ZeusTransformUtils.wrapperContextForParams(r2, Executor.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L7;
        return Collections.singletonList(new m(r1));
    L7:
        return Collections.singletonList(j.f9555a);
    }

    List<? extends i.a> d() {
        return Collections.emptyList();
    }

    Object a(Method r1, Class<?> r2, Object r3, Object... r4) {
        throw new UnsupportedOperationException();
    }
}
