package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
public final class Suppliers {

    @VisibleForTesting
    public static class ExpiringMemoizingSupplier<T> implements Supplier<T>, Serializable {
        private static final long serialVersionUID = 0;
        final Supplier<T> delegate;
        final long durationNanos;
        volatile transient long expirationNanos;

        @NullableDecl
        volatile transient T value;

        public ExpiringMemoizingSupplier(Supplier<T> r10, long r11, TimeUnit r12) {
            this.delegate = (Supplier) Preconditions.checkNotNull(r10);
            this.durationNanos = r12.toNanos(r11);
            if (r11 <= 0) goto L5;
            boolean r13 = true;
        L6:
            Preconditions.checkArgument(r13, "duration (%s %s) must be > 0", r11, r12);
            return;
        L5:
            r13 = false;
            goto L6
        }

        @Override // com.google.common.base.Supplier
        public T get() {
            long r10 = this.expirationNanos;
            long r11 = Platform.systemNanoTime();
            if (r10 != 0) goto L5;
        L6:
            monitor-enter(this);
        L15:
            th = move-exception;
            throw th;
        L8:
            if (r10 != this.expirationNanos) goto L17;
            T r12 = this.delegate.get();     // Catch: Throwable -> L15
            this.value = r12;     // Catch: Throwable -> L15
            long r13 = r11 + this.durationNanos;     // Catch: Throwable -> L15
            if (r13 != 0) goto L12;
            r13 = 1;
        L12:
            this.expirationNanos = r13;     // Catch: Throwable -> L15
            monitor-exit(this);     // Catch: Throwable -> L15
            return r12;
        L17:
            monitor-exit(this);     // Catch: Throwable -> L15
        L19:
            return this.value;
        L5:
            if ((r11 - r10) < 0) goto L19;
            goto L6
        }

        public String toString() {
            return "Suppliers.memoizeWithExpiration(" + this.delegate + ", " + this.durationNanos + ", NANOS)";
        }
    }

    @VisibleForTesting
    public static class MemoizingSupplier<T> implements Supplier<T>, Serializable {
        private static final long serialVersionUID = 0;
        final Supplier<T> delegate;
        volatile transient boolean initialized;

        @NullableDecl
        transient T value;

        public MemoizingSupplier(Supplier<T> r10) {
            this.delegate = (Supplier) Preconditions.checkNotNull(r10);
        }

        @Override // com.google.common.base.Supplier
        public T get() {
            if (this.initialized == true) goto L17;
            monitor-enter(this);
        L10:
            th = move-exception;
            throw th;
        L6:
            if (this.initialized == true) goto L12;
            T r10 = this.delegate.get();     // Catch: Throwable -> L10
            this.value = r10;     // Catch: Throwable -> L10
            this.initialized = true;     // Catch: Throwable -> L10
            monitor-exit(this);     // Catch: Throwable -> L10
            return r10;
        L12:
            monitor-exit(this);     // Catch: Throwable -> L10
        L17:
            return this.value;
        }

        public String toString() {
            StringBuilder r10 = new StringBuilder();
            r10.append("Suppliers.memoize(");
            if (this.initialized == false) goto L5;
            Object r11 = "<supplier that returned " + this.value + ">";
        L6:
            r10.append(r11);
            r10.append(")");
            return r10.toString();
        L5:
            r11 = this.delegate;
            goto L6
        }
    }

    @VisibleForTesting
    public static class NonSerializableMemoizingSupplier<T> implements Supplier<T> {
        volatile Supplier<T> delegate;
        volatile boolean initialized;

        @NullableDecl
        T value;

        public NonSerializableMemoizingSupplier(Supplier<T> r10) {
            this.delegate = (Supplier) Preconditions.checkNotNull(r10);
        }

        @Override // com.google.common.base.Supplier
        public T get() {
            if (this.initialized == true) goto L17;
            monitor-enter(this);
        L10:
            th = move-exception;
            throw th;
        L6:
            if (this.initialized == true) goto L12;
            T r10 = this.delegate.get();     // Catch: Throwable -> L10
            this.value = r10;     // Catch: Throwable -> L10
            this.initialized = true;     // Catch: Throwable -> L10
            this.delegate = null;     // Catch: Throwable -> L10
            monitor-exit(this);     // Catch: Throwable -> L10
            return r10;
        L12:
            monitor-exit(this);     // Catch: Throwable -> L10
        L17:
            return this.value;
        }

        public String toString() {
            Object r10 = this.delegate;
            StringBuilder r11 = new StringBuilder();
            r11.append("Suppliers.memoize(");
            if (r10 != null) goto L5;
            r10 = "<supplier that returned " + this.value + ">";
        L5:
            r11.append(r10);
            r11.append(")");
            return r11.toString();
        }
    }

    public static class SupplierComposition<F, T> implements Supplier<T>, Serializable {
        private static final long serialVersionUID = 0;
        final Function<? super F, T> function;
        final Supplier<F> supplier;

        public SupplierComposition(Function<? super F, T> r10, Supplier<F> r11) {
            this.function = (Function) Preconditions.checkNotNull(r10);
            this.supplier = (Supplier) Preconditions.checkNotNull(r11);
        }

        public boolean equals(@NullableDecl Object r10) {
            if ((r10 instanceof SupplierComposition) == false) goto L10;
            SupplierComposition r11 = (SupplierComposition) r10;
            if (this.function.equals(r11.function) == true) goto L7;
            return false;
        L7:
            if (this.supplier.equals(r11.supplier) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        @Override // com.google.common.base.Supplier
        public T get() {
            return this.function.apply(this.supplier.get());
        }

        public int hashCode() {
            return Objects.hashCode(new Object[]{this.function, this.supplier});
        }

        public String toString() {
            return "Suppliers.compose(" + this.function + ", " + this.supplier + ")";
        }
    }

    public interface SupplierFunction<T> extends Function<Supplier<T>, T> {
    }

    public static final enum SupplierFunctionImpl extends Enum<SupplierFunctionImpl> implements SupplierFunction<Object> {
        private static final /* synthetic */ SupplierFunctionImpl[] $VALUES = null;
        public static final SupplierFunctionImpl INSTANCE = null;

        static {
            SupplierFunctionImpl r10 = new SupplierFunctionImpl("INSTANCE", 0);
            INSTANCE = r10;
            $VALUES = new SupplierFunctionImpl[]{r10};
        }

        private SupplierFunctionImpl(String r10, int r11) {
            super(r10, r11);
        }

        public static SupplierFunctionImpl valueOf(String r10) {
            return (SupplierFunctionImpl) Enum.valueOf(SupplierFunctionImpl.class, r10);
        }

        public static SupplierFunctionImpl[] values() {
            return (SupplierFunctionImpl[]) $VALUES.clone();
        }

        @Override // com.google.common.base.Function
        public /* bridge */ /* synthetic */ Object apply(Object r10) {
            return apply((Supplier) r10);
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Suppliers.supplierFunction()";
        }

        public Object apply(Supplier<Object> r10) {
            return r10.get();
        }
    }

    public static class SupplierOfInstance<T> implements Supplier<T>, Serializable {
        private static final long serialVersionUID = 0;

        @NullableDecl
        final T instance;

        public SupplierOfInstance(@NullableDecl T r10) {
            this.instance = r10;
        }

        public boolean equals(@NullableDecl Object r10) {
            if ((r10 instanceof SupplierOfInstance) == true) goto L5;
            return false;
        L5:
            return Objects.equal(this.instance, ((SupplierOfInstance) r10).instance);
        }

        @Override // com.google.common.base.Supplier
        public T get() {
            return this.instance;
        }

        public int hashCode() {
            return Objects.hashCode(new Object[]{this.instance});
        }

        public String toString() {
            return "Suppliers.ofInstance(" + this.instance + ")";
        }
    }

    public static class ThreadSafeSupplier<T> implements Supplier<T>, Serializable {
        private static final long serialVersionUID = 0;
        final Supplier<T> delegate;

        public ThreadSafeSupplier(Supplier<T> r10) {
            this.delegate = (Supplier) Preconditions.checkNotNull(r10);
        }

        @Override // com.google.common.base.Supplier
        public T get() {
            Supplier<T> r10 = this.delegate;
            monitor-enter(r10);
            T r11 = this.delegate.get();     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        L7:
            th = move-exception;
            throw th;
        }

        public String toString() {
            return "Suppliers.synchronizedSupplier(" + this.delegate + ")";
        }
    }

    private Suppliers() {
    }

    public static <F, T> Supplier<T> compose(Function<? super F, T> r10, Supplier<F> r11) {
        return new SupplierComposition(r10, r11);
    }

    public static <T> Supplier<T> memoize(Supplier<T> r10) {
        if ((r10 instanceof NonSerializableMemoizingSupplier) == false) goto L5;
    L12:
        return r10;
    L5:
        if ((r10 instanceof MemoizingSupplier) == true) goto L12;
        if ((r10 instanceof Serializable) == false) goto L11;
        return new MemoizingSupplier(r10);
    L11:
        return new NonSerializableMemoizingSupplier(r10);
    }

    public static <T> Supplier<T> memoizeWithExpiration(Supplier<T> r10, long r11, TimeUnit r12) {
        return new ExpiringMemoizingSupplier(r10, r11, r12);
    }

    public static <T> Supplier<T> ofInstance(@NullableDecl T r10) {
        return new SupplierOfInstance(r10);
    }

    public static <T> Function<Supplier<T>, T> supplierFunction() {
        return SupplierFunctionImpl.INSTANCE;
    }

    public static <T> Supplier<T> synchronizedSupplier(Supplier<T> r10) {
        return new ThreadSafeSupplier(r10);
    }
}
