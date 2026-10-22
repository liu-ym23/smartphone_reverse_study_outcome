package com.android.server.common;

import android.util.Log;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
public class FunctionProxy {
    private static final Lazy<FunctionProxy> INSTANCE = null;
    public static final String TAG = "GameAssist.FunctionProxy";
    private final Map<String, Function> mFunctionMap;

    public interface Function {
    }

    @FunctionalInterface
    public interface Function0 extends Function {
        void execute();
    }

    @FunctionalInterface
    public interface Function1<P0> extends Function {
        void execute(P0 r1);
    }

    @FunctionalInterface
    public interface Function10<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9> extends Function {
        void execute(P0 r1, P1 r2, P2 r3, P3 r4, P4 r5, P5 r6, P6 r7, P7 r8, P8 r9, P9 r10);
    }

    @FunctionalInterface
    public interface Function2<P0, P1> extends Function {
        void execute(P0 r1, P1 r2);
    }

    @FunctionalInterface
    public interface Function3<P0, P1, P2> extends Function {
        void execute(P0 r1, P1 r2, P2 r3);
    }

    @FunctionalInterface
    public interface Function4<P0, P1, P2, P3> extends Function {
        void execute(P0 r1, P1 r2, P2 r3, P3 r4);
    }

    @FunctionalInterface
    public interface Function5<P0, P1, P2, P3, P4> extends Function {
        void execute(P0 r1, P1 r2, P2 r3, P3 r4, P4 r5);
    }

    @FunctionalInterface
    public interface Function6<P0, P1, P2, P3, P4, P5> extends Function {
        void execute(P0 r1, P1 r2, P2 r3, P3 r4, P4 r5, P5 r6);
    }

    @FunctionalInterface
    public interface Function7<P0, P1, P2, P3, P4, P5, P6> extends Function {
        void execute(P0 r1, P1 r2, P2 r3, P3 r4, P4 r5, P5 r6, P6 r7);
    }

    @FunctionalInterface
    public interface Function8<P0, P1, P2, P3, P4, P5, P6, P7> extends Function {
        void execute(P0 r1, P1 r2, P2 r3, P3 r4, P4 r5, P5 r6, P6 r7, P7 r8);
    }

    @FunctionalInterface
    public interface Function9<P0, P1, P2, P3, P4, P5, P6, P7, P8> extends Function {
        void execute(P0 r1, P1 r2, P2 r3, P3 r4, P4 r5, P5 r6, P6 r7, P7 r8, P8 r9);
    }

    protected static class Lazy<T> implements Supplier<T> {
        private volatile T mInstance;
        private final Supplier<T> mSupplier;

        public Lazy(Supplier<T> supplier) {
            this.mSupplier = supplier;
        }

        @Override // java.util.function.Supplier
        public final T get() {
            if (this.mInstance != null) goto L16;
            monitor-enter(FunctionProxy.class);
        L9:
            th = move-exception;
            throw th;
        L7:
            if (this.mInstance != null) goto L11;
            this.mInstance = this.mSupplier.get();     // Catch: Throwable -> L9
        L11:
            monitor-exit(FunctionProxy.class);     // Catch: Throwable -> L9
        L16:
            return this.mInstance;
        }
    }

    @FunctionalInterface
    public interface RFunction0<R> extends Function {
        R execute();
    }

    @FunctionalInterface
    public interface RFunction1<P0, R> extends Function {
        R execute(P0 r1);
    }

    @FunctionalInterface
    public interface RFunction10<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, R> extends Function {
        R execute(P0 r1, P1 r2, P2 r3, P3 r4, P4 r5, P5 r6, P6 r7, P7 r8, P8 r9, P9 r10);
    }

    @FunctionalInterface
    public interface RFunction2<P0, P1, R> extends Function {
        R execute(P0 r1, P1 r2);
    }

    @FunctionalInterface
    public interface RFunction3<P0, P1, P2, R> extends Function {
        R execute(P0 r1, P1 r2, P2 r3);
    }

    @FunctionalInterface
    public interface RFunction4<P0, P1, P2, P3, R> extends Function {
        R execute(P0 r1, P1 r2, P2 r3, P3 r4);
    }

    @FunctionalInterface
    public interface RFunction5<P0, P1, P2, P3, P4, R> extends Function {
        R execute(P0 r1, P1 r2, P2 r3, P3 r4, P4 r5);
    }

    @FunctionalInterface
    public interface RFunction6<P0, P1, P2, P3, P4, P5, R> extends Function {
        R execute(P0 r1, P1 r2, P2 r3, P3 r4, P4 r5, P5 r6);
    }

    @FunctionalInterface
    public interface RFunction7<P0, P1, P2, P3, P4, P5, P6, R> extends Function {
        R execute(P0 r1, P1 r2, P2 r3, P3 r4, P4 r5, P5 r6, P6 r7);
    }

    @FunctionalInterface
    public interface RFunction8<P0, P1, P2, P3, P4, P5, P6, P7, R> extends Function {
        R execute(P0 r1, P1 r2, P2 r3, P3 r4, P4 r5, P5 r6, P6 r7, P7 r8);
    }

    @FunctionalInterface
    public interface RFunction9<P0, P1, P2, P3, P4, P5, P6, P7, P8, R> extends Function {
        R execute(P0 r1, P1 r2, P2 r3, P3 r4, P4 r5, P5 r6, P6 r7, P7 r8, P8 r9);
    }

    public static /* synthetic */ Function $r8$lambda$Oqs4mGbvgcItZ86prNmhjENuC8U(String r0, Function r1, String r2) {
        return lambda$registerFunction$0(r0, r1, r2);
    }

    public FunctionProxy() {
        this.mFunctionMap = new ConcurrentHashMap();
    }

    static {
        INSTANCE = new Lazy(new FunctionProxy$$ExternalSyntheticLambda0());
    }

    public static FunctionProxy getInstance() {
        return INSTANCE.get();
    }

    public <T extends Function> void registerFunction(final String name, final T function) {
        this.mFunctionMap.computeIfAbsent(name, new FunctionProxy$$ExternalSyntheticLambda1(name, function));
    }

    private static /* synthetic */ Function lambda$registerFunction$0(String name, Function function, String k) {
        Log.w("GameAssist.FunctionProxy", "multiple registration name=" + name + " function=" + function);
        return function;
    }

    public void unregisterFunction(String name) {
        if (this.mFunctionMap.remove(name) != null) goto L6;
        Log.w("GameAssist.FunctionProxy", "multiple unregisterFunction name=" + name);
        return;
    }

    public static <T extends Function> void invocation(String name, Consumer<T> function) {
        getInstance().executeFunction(name, function);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends Function> void executeFunction(String name, Consumer<T> r7) {
        Function function = this.mFunctionMap.get(name);
        if (function != null) goto L6;
        Log.w("GameAssist.FunctionProxy", "executeFunction, but function is null, name=" + name);
        return;
    L6:
        if (r7 == 0) goto L14;
        r7.accept(function);     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        Log.e("GameAssist.FunctionProxy", "Error executing function: " + e.getMessage(), e);
        return;
    }

    public <T extends Function> T getFunction(String name) {
        return (T) this.mFunctionMap.get(name);
    }
}
