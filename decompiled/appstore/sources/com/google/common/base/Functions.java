package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
public final class Functions {

    /* JADX INFO: renamed from: com.google.common.base.Functions$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class ConstantFunction<E> implements Function<Object, E>, Serializable {
        private static final long serialVersionUID = 0;

        @NullableDecl
        private final E value;

        public ConstantFunction(@NullableDecl E r10) {
            this.value = r10;
        }

        @Override // com.google.common.base.Function
        public E apply(@NullableDecl Object r10) {
            return this.value;
        }

        @Override // com.google.common.base.Function
        public boolean equals(@NullableDecl Object r10) {
            if ((r10 instanceof ConstantFunction) == true) goto L5;
            return false;
        L5:
            return Objects.equal(this.value, ((ConstantFunction) r10).value);
        }

        public int hashCode() {
            E r10 = this.value;
            if (r10 != null) goto L6;
            return 0;
        L6:
            return r10.hashCode();
        }

        public String toString() {
            return "Functions.constant(" + this.value + ")";
        }
    }

    public static class ForMapWithDefault<K, V> implements Function<K, V>, Serializable {
        private static final long serialVersionUID = 0;

        @NullableDecl
        final V defaultValue;
        final Map<K, ? extends V> map;

        public ForMapWithDefault(Map<K, ? extends V> r10, @NullableDecl V r11) {
            this.map = (Map) Preconditions.checkNotNull(r10);
            this.defaultValue = r11;
        }

        @Override // com.google.common.base.Function
        public V apply(@NullableDecl K r10) {
            V r11 = this.map.get(r10);
            if (r11 == null) goto L5;
            return r11;
        L5:
            if (this.map.containsKey(r10) == false) goto L8;
            return r11;
        L8:
            return this.defaultValue;
        }

        @Override // com.google.common.base.Function
        public boolean equals(@NullableDecl Object r10) {
            if ((r10 instanceof ForMapWithDefault) == false) goto L10;
            ForMapWithDefault r11 = (ForMapWithDefault) r10;
            if (this.map.equals(r11.map) == true) goto L7;
            return false;
        L7:
            if (Objects.equal(this.defaultValue, r11.defaultValue) == false) goto L12;
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
            return "Functions.forMap(" + this.map + ", defaultValue=" + this.defaultValue + ")";
        }
    }

    public static class FunctionComposition<A, B, C> implements Function<A, C>, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Function<A, ? extends B> f10331f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final Function<B, C> f10332g;

        public FunctionComposition(Function<B, C> r10, Function<A, ? extends B> r11) {
            this.f10332g = (Function) Preconditions.checkNotNull(r10);
            this.f10331f = (Function) Preconditions.checkNotNull(r11);
        }

        @Override // com.google.common.base.Function
        public C apply(@NullableDecl A r10) {
            return (C) this.f10332g.apply(this.f10331f.apply(r10));
        }

        @Override // com.google.common.base.Function
        public boolean equals(@NullableDecl Object r10) {
            if ((r10 instanceof FunctionComposition) == false) goto L10;
            FunctionComposition r11 = (FunctionComposition) r10;
            if (this.f10331f.equals(r11.f10331f) == true) goto L7;
            return false;
        L7:
            if (this.f10332g.equals(r11.f10332g) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        public int hashCode() {
            int r10 = this.f10331f.hashCode();
            return this.f10332g.hashCode() ^ r10;
        }

        public String toString() {
            return this.f10332g + "(" + this.f10331f + ")";
        }
    }

    public static class FunctionForMapNoDefault<K, V> implements Function<K, V>, Serializable {
        private static final long serialVersionUID = 0;
        final Map<K, V> map;

        public FunctionForMapNoDefault(Map<K, V> r10) {
            this.map = (Map) Preconditions.checkNotNull(r10);
        }

        @Override // com.google.common.base.Function
        public V apply(@NullableDecl K r10) {
            V r11 = this.map.get(r10);
            if (r11 == null) goto L5;
        L8:
            boolean r12 = true;
        L9:
            Preconditions.checkArgument(r12, "Key '%s' not present in map", r10);
            return r11;
        L5:
            if (this.map.containsKey(r10) == true) goto L8;
            r12 = false;
            goto L9
        }

        @Override // com.google.common.base.Function
        public boolean equals(@NullableDecl Object r10) {
            if ((r10 instanceof FunctionForMapNoDefault) == true) goto L5;
            return false;
        L5:
            return this.map.equals(((FunctionForMapNoDefault) r10).map);
        }

        public int hashCode() {
            return this.map.hashCode();
        }

        public String toString() {
            return "Functions.forMap(" + this.map + ")";
        }
    }

    public static final enum IdentityFunction extends Enum<IdentityFunction> implements Function<Object, Object> {
        private static final /* synthetic */ IdentityFunction[] $VALUES = null;
        public static final IdentityFunction INSTANCE = null;

        static {
            IdentityFunction r10 = new IdentityFunction("INSTANCE", 0);
            INSTANCE = r10;
            $VALUES = new IdentityFunction[]{r10};
        }

        private IdentityFunction(String r10, int r11) {
            super(r10, r11);
        }

        public static IdentityFunction valueOf(String r10) {
            return (IdentityFunction) Enum.valueOf(IdentityFunction.class, r10);
        }

        public static IdentityFunction[] values() {
            return (IdentityFunction[]) $VALUES.clone();
        }

        @Override // com.google.common.base.Function
        @NullableDecl
        public Object apply(@NullableDecl Object r10) {
            return r10;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Functions.identity()";
        }
    }

    public static class PredicateFunction<T> implements Function<T, Boolean>, Serializable {
        private static final long serialVersionUID = 0;
        private final Predicate<T> predicate;

        public /* synthetic */ PredicateFunction(Predicate r10, AnonymousClass1 r11) {
            this(r10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.base.Function
        public /* bridge */ /* synthetic */ Boolean apply(@NullableDecl Object r10) {
            return apply(r10);
        }

        @Override // com.google.common.base.Function
        public boolean equals(@NullableDecl Object r10) {
            if ((r10 instanceof PredicateFunction) == true) goto L5;
            return false;
        L5:
            return this.predicate.equals(((PredicateFunction) r10).predicate);
        }

        public int hashCode() {
            return this.predicate.hashCode();
        }

        public String toString() {
            return "Functions.forPredicate(" + this.predicate + ")";
        }

        private PredicateFunction(Predicate<T> r10) {
            this.predicate = (Predicate) Preconditions.checkNotNull(r10);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.common.base.Function
        public Boolean apply(@NullableDecl T r10) {
            return Boolean.valueOf(this.predicate.apply(r10));
        }
    }

    public static class SupplierFunction<T> implements Function<Object, T>, Serializable {
        private static final long serialVersionUID = 0;
        private final Supplier<T> supplier;

        public /* synthetic */ SupplierFunction(Supplier r10, AnonymousClass1 r11) {
            this(r10);
        }

        @Override // com.google.common.base.Function
        public T apply(@NullableDecl Object r10) {
            return this.supplier.get();
        }

        @Override // com.google.common.base.Function
        public boolean equals(@NullableDecl Object r10) {
            if ((r10 instanceof SupplierFunction) == true) goto L5;
            return false;
        L5:
            return this.supplier.equals(((SupplierFunction) r10).supplier);
        }

        public int hashCode() {
            return this.supplier.hashCode();
        }

        public String toString() {
            return "Functions.forSupplier(" + this.supplier + ")";
        }

        private SupplierFunction(Supplier<T> r10) {
            this.supplier = (Supplier) Preconditions.checkNotNull(r10);
        }
    }

    public static final enum ToStringFunction extends Enum<ToStringFunction> implements Function<Object, String> {
        private static final /* synthetic */ ToStringFunction[] $VALUES = null;
        public static final ToStringFunction INSTANCE = null;

        static {
            ToStringFunction r10 = new ToStringFunction("INSTANCE", 0);
            INSTANCE = r10;
            $VALUES = new ToStringFunction[]{r10};
        }

        private ToStringFunction(String r10, int r11) {
            super(r10, r11);
        }

        public static ToStringFunction valueOf(String r10) {
            return (ToStringFunction) Enum.valueOf(ToStringFunction.class, r10);
        }

        public static ToStringFunction[] values() {
            return (ToStringFunction[]) $VALUES.clone();
        }

        @Override // com.google.common.base.Function
        public /* bridge */ /* synthetic */ String apply(Object r10) {
            return apply2(r10);
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Functions.toStringFunction()";
        }

        @Override // com.google.common.base.Function
        /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
        public String apply2(Object r10) {
            Preconditions.checkNotNull(r10);
            return r10.toString();
        }
    }

    private Functions() {
    }

    public static <A, B, C> Function<A, C> compose(Function<B, C> r10, Function<A, ? extends B> r11) {
        return new FunctionComposition(r10, r11);
    }

    public static <E> Function<Object, E> constant(@NullableDecl E r10) {
        return new ConstantFunction(r10);
    }

    public static <K, V> Function<K, V> forMap(Map<K, V> r10) {
        return new FunctionForMapNoDefault(r10);
    }

    public static <T> Function<T, Boolean> forPredicate(Predicate<T> r10) {
        return new PredicateFunction(r10, null);
    }

    public static <T> Function<Object, T> forSupplier(Supplier<T> r10) {
        return new SupplierFunction(r10, null);
    }

    public static <E> Function<E, E> identity() {
        return IdentityFunction.INSTANCE;
    }

    public static Function<Object, String> toStringFunction() {
        return ToStringFunction.INSTANCE;
    }

    public static <K, V> Function<K, V> forMap(Map<K, ? extends V> r10, @NullableDecl V r11) {
        return new ForMapWithDefault(r10, r11);
    }
}
