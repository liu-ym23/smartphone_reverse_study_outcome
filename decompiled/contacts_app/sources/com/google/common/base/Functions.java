package com.google.common.base;

import com.ss.android.http.legacy.protocol.HTTP;
import java.io.Serializable;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class Functions {

    /* JADX INFO: renamed from: com.google.common.base.Functions$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class ConstantFunction<E> implements Function<Object, E>, Serializable {
        private static final long serialVersionUID = 0;
        private final E value;

        public ConstantFunction(@Nullable E r1) {
            this.value = r1;
        }

        @Override // com.google.common.base.Function
        public E apply(@Nullable Object r1) {
            return this.value;
        }

        @Override // com.google.common.base.Function
        public boolean equals(@Nullable Object r2) {
            if ((r2 instanceof ConstantFunction) == true) goto L5;
            return false;
        L5:
            return Objects.equal(this.value, ((ConstantFunction) r2).value);
        }

        public int hashCode() {
            E r0 = this.value;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public String toString() {
            return "constant(" + this.value + ")";
        }
    }

    private static class ForMapWithDefault<K, V> implements Function<K, V>, Serializable {
        private static final long serialVersionUID = 0;
        final V defaultValue;
        final Map<K, ? extends V> map;

        ForMapWithDefault(Map<K, ? extends V> r1, @Nullable V r2) {
            this.map = (Map) Preconditions.checkNotNull(r1);
            this.defaultValue = r2;
        }

        @Override // com.google.common.base.Function
        public V apply(@Nullable K r3) {
            V r0 = this.map.get(r3);
            if (r0 == null) goto L5;
            return r0;
        L5:
            if (this.map.containsKey(r3) == false) goto L8;
            return r0;
        L8:
            return this.defaultValue;
        }

        @Override // com.google.common.base.Function
        public boolean equals(@Nullable Object r4) {
            if ((r4 instanceof ForMapWithDefault) == false) goto L10;
            ForMapWithDefault r5 = (ForMapWithDefault) r4;
            if (this.map.equals(r5.map) == true) goto L7;
            return false;
        L7:
            if (Objects.equal(this.defaultValue, r5.defaultValue) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        public int hashCode() {
            return Objects.hashCode(new Object[]{this.map, this.defaultValue});
        }

        public String toString() {
            return "forMap(" + this.map + ", defaultValue=" + this.defaultValue + ")";
        }
    }

    private static class FunctionComposition<A, B, C> implements Function<A, C>, Serializable {
        private static final long serialVersionUID = 0;
        private final Function<A, ? extends B> f;
        private final Function<B, C> g;

        public FunctionComposition(Function<B, C> r1, Function<A, ? extends B> r2) {
            this.g = (Function) Preconditions.checkNotNull(r1);
            this.f = (Function) Preconditions.checkNotNull(r2);
        }

        @Override // com.google.common.base.Function
        public C apply(@Nullable A r2) {
            return (C) this.g.apply(this.f.apply(r2));
        }

        @Override // com.google.common.base.Function
        public boolean equals(@Nullable Object r4) {
            if ((r4 instanceof FunctionComposition) == false) goto L10;
            FunctionComposition r5 = (FunctionComposition) r4;
            if (this.f.equals(r5.f) == true) goto L7;
            return false;
        L7:
            if (this.g.equals(r5.g) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        public int hashCode() {
            int r0 = this.f.hashCode();
            return this.g.hashCode() ^ r0;
        }

        public String toString() {
            return this.g + "(" + this.f + ")";
        }
    }

    private static class FunctionForMapNoDefault<K, V> implements Function<K, V>, Serializable {
        private static final long serialVersionUID = 0;
        final Map<K, V> map;

        FunctionForMapNoDefault(Map<K, V> r1) {
            this.map = (Map) Preconditions.checkNotNull(r1);
        }

        @Override // com.google.common.base.Function
        public V apply(@Nullable K r4) {
            V r0 = this.map.get(r4);
            if (r0 == null) goto L5;
        L8:
            boolean r3 = true;
        L9:
            Preconditions.checkArgument(r3, "Key '%s' not present in map", new Object[]{r4});
            return r0;
        L5:
            if (this.map.containsKey(r4) == true) goto L8;
            r3 = false;
            goto L9
        }

        @Override // com.google.common.base.Function
        public boolean equals(@Nullable Object r2) {
            if ((r2 instanceof FunctionForMapNoDefault) == true) goto L5;
            return false;
        L5:
            return this.map.equals(((FunctionForMapNoDefault) r2).map);
        }

        public int hashCode() {
            return this.map.hashCode();
        }

        public String toString() {
            return "forMap(" + this.map + ")";
        }
    }

    private static final enum IdentityFunction extends Enum<IdentityFunction> implements Function<Object, Object> {
        private static final /* synthetic */ IdentityFunction[] $VALUES = null;
        public static final IdentityFunction INSTANCE = null;

        @Override // com.google.common.base.Function
        @Nullable
        public Object apply(@Nullable Object r1) {
            return r1;
        }

        @Override // java.lang.Enum
        public String toString() {
            return HTTP.IDENTITY_CODING;
        }

        private IdentityFunction(String r1, int r2) {
            super(r1, r2);
        }

        public static IdentityFunction valueOf(String r1) {
            return (IdentityFunction) Enum.valueOf(IdentityFunction.class, r1);
        }

        public static IdentityFunction[] values() {
            return (IdentityFunction[]) $VALUES.clone();
        }

        static {
            IdentityFunction r0 = new IdentityFunction("INSTANCE", 0);
            INSTANCE = r0;
            $VALUES = new IdentityFunction[]{r0};
        }
    }

    private static class PredicateFunction<T> implements Function<T, Boolean>, Serializable {
        private static final long serialVersionUID = 0;
        private final Predicate<T> predicate;

        /* synthetic */ PredicateFunction(Predicate r1, AnonymousClass1 r2) {
            this(r1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.base.Function
        public /* bridge */ /* synthetic */ Boolean apply(@Nullable Object r1) {
            return apply(r1);
        }

        private PredicateFunction(Predicate<T> r1) {
            this.predicate = (Predicate) Preconditions.checkNotNull(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.common.base.Function
        public Boolean apply(@Nullable T r1) {
            return Boolean.valueOf(this.predicate.apply(r1));
        }

        @Override // com.google.common.base.Function
        public boolean equals(@Nullable Object r2) {
            if ((r2 instanceof PredicateFunction) == true) goto L5;
            return false;
        L5:
            return this.predicate.equals(((PredicateFunction) r2).predicate);
        }

        public int hashCode() {
            return this.predicate.hashCode();
        }

        public String toString() {
            return "forPredicate(" + this.predicate + ")";
        }
    }

    private static class SupplierFunction<T> implements Function<Object, T>, Serializable {
        private static final long serialVersionUID = 0;
        private final Supplier<T> supplier;

        /* synthetic */ SupplierFunction(Supplier r1, AnonymousClass1 r2) {
            this(r1);
        }

        private SupplierFunction(Supplier<T> r1) {
            this.supplier = (Supplier) Preconditions.checkNotNull(r1);
        }

        @Override // com.google.common.base.Function
        public T apply(@Nullable Object r1) {
            return this.supplier.get();
        }

        @Override // com.google.common.base.Function
        public boolean equals(@Nullable Object r2) {
            if ((r2 instanceof SupplierFunction) == true) goto L5;
            return false;
        L5:
            return this.supplier.equals(((SupplierFunction) r2).supplier);
        }

        public int hashCode() {
            return this.supplier.hashCode();
        }

        public String toString() {
            return "forSupplier(" + this.supplier + ")";
        }
    }

    private static final enum ToStringFunction extends Enum<ToStringFunction> implements Function<Object, String> {
        private static final /* synthetic */ ToStringFunction[] $VALUES = null;
        public static final ToStringFunction INSTANCE = null;

        @Override // java.lang.Enum
        public String toString() {
            return "toString";
        }

        private ToStringFunction(String r1, int r2) {
            super(r1, r2);
        }

        public static ToStringFunction valueOf(String r1) {
            return (ToStringFunction) Enum.valueOf(ToStringFunction.class, r1);
        }

        public static ToStringFunction[] values() {
            return (ToStringFunction[]) $VALUES.clone();
        }

        @Override // com.google.common.base.Function
        public /* bridge */ /* synthetic */ String apply(Object r1) {
            return apply2(r1);
        }

        static {
            ToStringFunction r0 = new ToStringFunction("INSTANCE", 0);
            INSTANCE = r0;
            $VALUES = new ToStringFunction[]{r0};
        }

        @Override // com.google.common.base.Function
        /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
        public String apply2(Object r1) {
            Preconditions.checkNotNull(r1);
            return r1.toString();
        }
    }

    private Functions() {
    }

    public static Function<Object, String> toStringFunction() {
        return ToStringFunction.INSTANCE;
    }

    public static <E> Function<E, E> identity() {
        return IdentityFunction.INSTANCE;
    }

    public static <K, V> Function<K, V> forMap(Map<K, V> r1) {
        return new FunctionForMapNoDefault(r1);
    }

    public static <K, V> Function<K, V> forMap(Map<K, ? extends V> r1, @Nullable V r2) {
        return new ForMapWithDefault(r1, r2);
    }

    public static <A, B, C> Function<A, C> compose(Function<B, C> r1, Function<A, ? extends B> r2) {
        return new FunctionComposition(r1, r2);
    }

    public static <T> Function<T, Boolean> forPredicate(Predicate<T> r2) {
        return new PredicateFunction(r2, null);
    }

    public static <E> Function<Object, E> constant(@Nullable E r1) {
        return new ConstantFunction(r1);
    }

    public static <T> Function<Object, T> forSupplier(Supplier<T> r2) {
        return new SupplierFunction(r2, null);
    }
}
