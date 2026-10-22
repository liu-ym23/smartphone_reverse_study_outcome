package com.android.server.common;

import android.util.Log;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
public class MethodProxy {
    private static final Lazy<MethodProxy> INSTANCE = null;
    public static final String TAG = "GameAssist.FunctionProxy";
    private final Map<String, Method> mMethodMap;

    protected static class Lazy<T> implements Supplier<T> {
        private volatile T mInstance;
        private final Supplier<T> mSupplier;

        public Lazy(Supplier<T> supplier) {
            this.mSupplier = supplier;
        }

        @Override // java.util.function.Supplier
        public final T get() {
            if (this.mInstance != null) goto L16;
            monitor-enter(MethodProxy.class);
        L9:
            th = move-exception;
            throw th;
        L7:
            if (this.mInstance != null) goto L11;
            this.mInstance = this.mSupplier.get();     // Catch: Throwable -> L9
        L11:
            monitor-exit(MethodProxy.class);     // Catch: Throwable -> L9
        L16:
            return this.mInstance;
        }
    }

    public interface Method {
    }

    @FunctionalInterface
    public interface Method0<O> extends Method {
        void execute(O r1);
    }

    @FunctionalInterface
    public interface Method1<O, P0> extends Method {
        void execute(O r1, P0 r2);
    }

    @FunctionalInterface
    public interface Method10<O, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9> extends Method {
        void execute(O r1, P0 r2, P1 r3, P2 r4, P3 r5, P4 r6, P5 r7, P6 r8, P7 r9, P8 r10, P9 r11);
    }

    @FunctionalInterface
    public interface Method2<O, P0, P1> extends Method {
        void execute(O r1, P0 r2, P1 r3);
    }

    @FunctionalInterface
    public interface Method3<O, P0, P1, P2> extends Method {
        void execute(O r1, P0 r2, P1 r3, P2 r4);
    }

    @FunctionalInterface
    public interface Method4<O, P0, P1, P2, P3> extends Method {
        void execute(O r1, P0 r2, P1 r3, P2 r4, P3 r5);
    }

    @FunctionalInterface
    public interface Method5<O, P0, P1, P2, P3, P4> extends Method {
        void execute(O r1, P0 r2, P1 r3, P2 r4, P3 r5, P4 r6);
    }

    @FunctionalInterface
    public interface Method6<O, P0, P1, P2, P3, P4, P5> extends Method {
        void execute(O r1, P0 r2, P1 r3, P2 r4, P3 r5, P4 r6, P5 r7);
    }

    @FunctionalInterface
    public interface Method7<O, P0, P1, P2, P3, P4, P5, P6> extends Method {
        void execute(O r1, P0 r2, P1 r3, P2 r4, P3 r5, P4 r6, P5 r7, P6 r8);
    }

    @FunctionalInterface
    public interface Method8<O, P0, P1, P2, P3, P4, P5, P6, P7> extends Method {
        void execute(O r1, P0 r2, P1 r3, P2 r4, P3 r5, P4 r6, P5 r7, P6 r8, P7 r9);
    }

    @FunctionalInterface
    public interface Method9<O, P0, P1, P2, P3, P4, P5, P6, P7, P8> extends Method {
        void execute(O r1, P0 r2, P1 r3, P2 r4, P3 r5, P4 r6, P5 r7, P6 r8, P7 r9, P8 r10);
    }

    @FunctionalInterface
    public interface RMethod0<O, R> extends Method {
        R execute(O r1);
    }

    @FunctionalInterface
    public interface RMethod1<O, P0, R> extends Method {
        R execute(O r1, P0 r2);
    }

    @FunctionalInterface
    public interface RMethod10<O, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, R> extends Method {
        R execute(O r1, P0 r2, P1 r3, P2 r4, P3 r5, P4 r6, P5 r7, P6 r8, P7 r9, P8 r10, P9 r11);
    }

    @FunctionalInterface
    public interface RMethod2<O, P0, P1, R> extends Method {
        R execute(O r1, P0 r2, P1 r3);
    }

    @FunctionalInterface
    public interface RMethod3<O, P0, P1, P2, R> extends Method {
        R execute(O r1, P0 r2, P1 r3, P2 r4);
    }

    @FunctionalInterface
    public interface RMethod4<O, P0, P1, P2, P3, R> extends Method {
        R execute(O r1, P0 r2, P1 r3, P2 r4, P3 r5);
    }

    @FunctionalInterface
    public interface RMethod5<O, P0, P1, P2, P3, P4, R> extends Method {
        R execute(O r1, P0 r2, P1 r3, P2 r4, P3 r5, P4 r6);
    }

    @FunctionalInterface
    public interface RMethod6<O, P0, P1, P2, P3, P4, P5, R> extends Method {
        R execute(O r1, P0 r2, P1 r3, P2 r4, P3 r5, P4 r6, P5 r7);
    }

    @FunctionalInterface
    public interface RMethod7<O, P0, P1, P2, P3, P4, P5, P6, R> extends Method {
        R execute(O r1, P0 r2, P1 r3, P2 r4, P3 r5, P4 r6, P5 r7, P6 r8);
    }

    @FunctionalInterface
    public interface RMethod8<O, P0, P1, P2, P3, P4, P5, P6, P7, R> extends Method {
        R execute(O r1, P0 r2, P1 r3, P2 r4, P3 r5, P4 r6, P5 r7, P6 r8, P7 r9);
    }

    @FunctionalInterface
    public interface RMethod9<O, P0, P1, P2, P3, P4, P5, P6, P7, P8, R> extends Method {
        R execute(O r1, P0 r2, P1 r3, P2 r4, P3 r5, P4 r6, P5 r7, P6 r8, P7 r9, P8 r10);
    }

    public MethodProxy() {
        this.mMethodMap = new ConcurrentHashMap();
    }

    static {
        INSTANCE = new Lazy(new MethodProxy$$ExternalSyntheticLambda0());
    }

    public static MethodProxy getInstance() {
        return INSTANCE.get();
    }

    public <T extends Method> void registerMethod(String name, T function) {
        if (this.mMethodMap.containsKey(name) == true) goto L5;
        this.mMethodMap.put(name, function);
        return;
    L5:
        Log.w("GameAssist.FunctionProxy", "multiple registration name=" + name + " function=" + function);
    }

    public void unregisterMethod(String name) {
        if (this.mMethodMap.containsKey(name) == false) goto L5;
        this.mMethodMap.remove(name);
        return;
    L5:
        Log.w("GameAssist.FunctionProxy", "multiple unregisterMethod name=" + name);
    }

    public static <T extends Method> void invocation(String name, Consumer<T> function) {
        getInstance().executeMethod(name, function);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends Method> void executeMethod(String name, Consumer<T> r7) {
        Method method = this.mMethodMap.get(name);
        if (method != null) goto L5;
        Log.w("GameAssist.FunctionProxy", "executeFunction, but method is null, name=" + name);
    L5:
        if (r7 == 0) goto L13;
        r7.accept(method);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        Log.e("GameAssist.FunctionProxy", "Error executing function: " + e.getMessage(), e);
        return;
    }

    public <T extends Method> T getMethod(String name) {
        return (T) this.mMethodMap.get(name);
    }
}
