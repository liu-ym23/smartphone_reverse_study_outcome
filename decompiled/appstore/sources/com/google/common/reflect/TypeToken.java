package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ForwardingSet;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.primitives.Primitives;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@Beta
public abstract class TypeToken<T> extends TypeCapture<T> implements Serializable {
    private static final long serialVersionUID = 3637540370352322684L;

    @MonotonicNonNullDecl
    private transient TypeResolver covariantTypeResolver;

    @MonotonicNonNullDecl
    private transient TypeResolver invariantTypeResolver;
    private final Type runtimeType;

    public static class Bounds {
        private final Type[] bounds;
        private final boolean target;

        public Bounds(Type[] r10, boolean r11) {
            this.bounds = r10;
            this.target = r11;
        }

        public boolean isSubtypeOf(Type r10) {
            Type[] r11 = this.bounds;
            int r12 = r11.length;
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L9;
            boolean r14 = TypeToken.of(r11[r13]).isSubtypeOf(r10);
            boolean r15 = this.target;
            if (r14 == r15) goto L6;
            r13 = r13 + 1;
            goto L3
        L6:
            return r15;
        L9:
            return !this.target;
        }

        public boolean isSupertypeOf(Type r10) {
            TypeToken<?> r11 = TypeToken.of(r10);
            Type[] r12 = this.bounds;
            int r13 = r12.length;
            int r14 = 0;
        L3:
            if (r14 >= r13) goto L9;
            boolean r15 = r11.isSubtypeOf(r12[r14]);
            boolean r16 = this.target;
            if (r15 == r16) goto L6;
            r14 = r14 + 1;
            goto L3
        L6:
            return r16;
        L9:
            return !this.target;
        }
    }

    public final class ClassSet extends TypeToken<T>.TypeSet {
        private static final long serialVersionUID = 0;

        @MonotonicNonNullDecl
        private transient ImmutableSet<TypeToken<? super T>> classes;
        final /* synthetic */ TypeToken this$0;

        private ClassSet(TypeToken r10) {
            this.this$0 = r10;
            super(r10);
        }

        private Object readResolve() {
            return this.this$0.getTypes().classes();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet classes() {
            return this;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet interfaces() {
            throw new UnsupportedOperationException("classes().interfaces() not supported.");
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public Set<Class<? super T>> rawTypes() {
            return ImmutableSet.copyOf(TypeCollector.FOR_RAW_TYPE.classesOnly().collectTypes(TypeToken.access$300(this.this$0)));
        }

        public /* synthetic */ ClassSet(TypeToken r10, AnonymousClass1 r11) {
            this(r10);
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public Set<TypeToken<? super T>> delegate() {
            ImmutableSet<TypeToken<? super T>> r10 = this.classes;
            if (r10 != null) goto L6;
            ImmutableSet<TypeToken<? super T>> r11 = FluentIterable.from(TypeCollector.FOR_GENERIC_TYPE.classesOnly().collectTypes(this.this$0)).filter(TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD).toSet();
            this.classes = r11;
            return r11;
        L6:
            return r10;
        }
    }

    public final class InterfaceSet extends TypeToken<T>.TypeSet {
        private static final long serialVersionUID = 0;
        private final transient TypeToken<T>.TypeSet allTypes;

        @MonotonicNonNullDecl
        private transient ImmutableSet<TypeToken<? super T>> interfaces;
        final /* synthetic */ TypeToken this$0;

        public InterfaceSet(TypeToken r10, TypeToken<T>.TypeSet r11) {
            this.this$0 = r10;
            super(r10);
            this.allTypes = r11;
        }

        private Object readResolve() {
            return this.this$0.getTypes().interfaces();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet classes() {
            throw new UnsupportedOperationException("interfaces().classes() not supported.");
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet interfaces() {
            return this;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public Set<Class<? super T>> rawTypes() {
            return FluentIterable.from(TypeCollector.FOR_RAW_TYPE.collectTypes(TypeToken.access$300(this.this$0))).filter(new AnonymousClass1(this)).toSet();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public Set<TypeToken<? super T>> delegate() {
            ImmutableSet<TypeToken<? super T>> r10 = this.interfaces;
            if (r10 != null) goto L6;
            ImmutableSet<TypeToken<? super T>> r11 = FluentIterable.from(this.allTypes).filter(TypeFilter.INTERFACE_ONLY).toSet();
            this.interfaces = r11;
            return r11;
        L6:
            return r10;
        }
    }

    public static final class SimpleTypeToken<T> extends TypeToken<T> {
        private static final long serialVersionUID = 0;

        public SimpleTypeToken(Type r10) {
            super(r10, null);
        }
    }

    public static abstract class TypeCollector<K> {
        static final TypeCollector<TypeToken<?>> FOR_GENERIC_TYPE = null;
        static final TypeCollector<Class<?>> FOR_RAW_TYPE = null;

        public static class ForwardingTypeCollector<K> extends TypeCollector<K> {
            private final TypeCollector<K> delegate;

            public ForwardingTypeCollector(TypeCollector<K> r10) {
                super(null);
                this.delegate = r10;
            }

            @Override // com.google.common.reflect.TypeToken.TypeCollector
            public Iterable<? extends K> getInterfaces(K r10) {
                return this.delegate.getInterfaces(r10);
            }

            @Override // com.google.common.reflect.TypeToken.TypeCollector
            public Class<?> getRawType(K r10) {
                return this.delegate.getRawType(r10);
            }

            @Override // com.google.common.reflect.TypeToken.TypeCollector
            public K getSuperclass(K r10) {
                return this.delegate.getSuperclass(r10);
            }
        }

        static {
            FOR_GENERIC_TYPE = new AnonymousClass1();
            FOR_RAW_TYPE = new AnonymousClass2();
        }

        private TypeCollector() {
        }

        private static <K, V> ImmutableList<K> sortKeysByValue(final Map<K, V> r10, final Comparator<? super V> r11) {
            return (ImmutableList<K>) new AnonymousClass4(r11, r10).immutableSortedCopy(r10.keySet());
        }

        public final TypeCollector<K> classesOnly() {
            return new AnonymousClass3(this, this);
        }

        public final ImmutableList<K> collectTypes(K r10) {
            return collectTypes(ImmutableList.of(r10));
        }

        public abstract Iterable<? extends K> getInterfaces(K r10);

        public abstract Class<?> getRawType(K r10);

        @NullableDecl
        public abstract K getSuperclass(K r10);

        public /* synthetic */ TypeCollector(AnonymousClass1 r10) {
            this();
        }

        public ImmutableList<K> collectTypes(Iterable<? extends K> r10) {
            HashMap r11 = Maps.newHashMap();
            Iterator<? extends K> r12 = r10.iterator();
        L4:
            if (r12.hasNext() == false) goto L7;
            collectTypes(r12.next(), r11);
            goto L4
        L7:
            return sortKeysByValue(r11, Ordering.natural().reverse());
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        private int collectTypes(K r10, Map<? super K, Integer> r11) {
            Integer r12 = r11.get(r10);
            if (r12 != null) goto L5;
            boolean r13 = getRawType(r10).isInterface();
            Iterator<? extends K> r14 = getInterfaces(r10).iterator();
            int r15 = r13;
        L8:
            if (r14.hasNext() == false) goto L10;
            r15 = Math.max(r15, collectTypes(r14.next(), r11));
            goto L8
        L10:
            K r16 = getSuperclass(r10);
            int r17 = r15;
            if (r16 == null) goto L13;
            r17 = Math.max(r15, collectTypes(r16, r11));
        L13:
            int r18 = r17 + 1;
            r11.put(r10, Integer.valueOf(r18));
            return r18;
        L5:
            return r12.intValue();
        }
    }

    public static abstract enum TypeFilter extends Enum<TypeFilter> implements Predicate<TypeToken<?>> {
        private static final /* synthetic */ TypeFilter[] $VALUES = null;
        public static final TypeFilter IGNORE_TYPE_VARIABLE_OR_WILDCARD = null;
        public static final TypeFilter INTERFACE_ONLY = null;

        static {
            final String r10 = "IGNORE_TYPE_VARIABLE_OR_WILDCARD";
            final int r11 = 0;
            TypeFilter r12 = new AnonymousClass1(r10, r11);
            IGNORE_TYPE_VARIABLE_OR_WILDCARD = r12;
            final String r13 = "INTERFACE_ONLY";
            final int r14 = 1;
            TypeFilter r15 = new AnonymousClass2(r13, r14);
            INTERFACE_ONLY = r15;
            $VALUES = new TypeFilter[]{r12, r15};
        }

        private TypeFilter(String r10, int r11) {
            super(r10, r11);
        }

        public static TypeFilter valueOf(String r10) {
            return (TypeFilter) Enum.valueOf(TypeFilter.class, r10);
        }

        public static TypeFilter[] values() {
            return (TypeFilter[]) $VALUES.clone();
        }

        public /* synthetic */ TypeFilter(String r10, int r11, AnonymousClass1 r12) {
            this(r10, r11);
        }
    }

    public class TypeSet extends ForwardingSet<TypeToken<? super T>> implements Serializable {
        private static final long serialVersionUID = 0;
        final /* synthetic */ TypeToken this$0;

        @MonotonicNonNullDecl
        private transient ImmutableSet<TypeToken<? super T>> types;

        public TypeSet(TypeToken r10) {
            this.this$0 = r10;
        }

        public TypeToken<T>.TypeSet classes() {
            return new ClassSet(this.this$0, null);
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        public TypeToken<T>.TypeSet interfaces() {
            return new InterfaceSet(this.this$0, this);
        }

        public Set<Class<? super T>> rawTypes() {
            return ImmutableSet.copyOf(TypeCollector.FOR_RAW_TYPE.collectTypes(TypeToken.access$300(this.this$0)));
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public Set<TypeToken<? super T>> delegate() {
            ImmutableSet<TypeToken<? super T>> r10 = this.types;
            if (r10 != null) goto L6;
            ImmutableSet<TypeToken<? super T>> r11 = FluentIterable.from(TypeCollector.FOR_GENERIC_TYPE.collectTypes(this.this$0)).filter(TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD).toSet();
            this.types = r11;
            return r11;
        L6:
            return r10;
        }
    }

    public /* synthetic */ TypeToken(Type r10, AnonymousClass1 r11) {
        this(r10);
    }

    public static /* synthetic */ TypeResolver access$000(TypeToken r10) {
        return r10.getCovariantTypeResolver();
    }

    public static /* synthetic */ TypeResolver access$100(TypeToken r10) {
        return r10.getInvariantTypeResolver();
    }

    public static /* synthetic */ ImmutableSet access$300(TypeToken r10) {
        return r10.getRawTypes();
    }

    public static /* synthetic */ Type access$500(TypeToken r10) {
        return r10.runtimeType;
    }

    private static Bounds any(Type[] r10) {
        return new Bounds(r10, true);
    }

    @NullableDecl
    private TypeToken<? super T> boundAsSuperclass(Type r10) {
        TypeToken<? super T> r11 = (TypeToken<? super T>) of(r10);
        if (r11.getRawType().isInterface() == false) goto L6;
        return null;
    L6:
        return r11;
    }

    private ImmutableList<TypeToken<? super T>> boundsAsInterfaces(Type[] r10) {
        ImmutableList.Builder r11 = ImmutableList.builder();
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        TypeToken<?> r14 = of(r10[r13]);
        if (r14.getRawType().isInterface() == false) goto L7;
        r11.add(r14);
    L7:
        r13 = r13 + 1;
        goto L3
    L9:
        return r11.build();
    }

    private static Type canonicalizeTypeArg(TypeVariable<?> r10, Type r11) {
        if ((r11 instanceof WildcardType) == false) goto L6;
        return canonicalizeWildcardType(r10, (WildcardType) r11);
    L6:
        return canonicalizeWildcardsInType(r11);
    }

    private static WildcardType canonicalizeWildcardType(TypeVariable<?> r10, WildcardType r11) {
        Type[] r12 = r10.getBounds();
        ArrayList r13 = new ArrayList();
        Type[] r14 = r11.getUpperBounds();
        int r15 = r14.length;
        int r16 = 0;
    L3:
        if (r16 >= r15) goto L9;
        Type r17 = r14[r16];
        if (any(r12).isSubtypeOf(r17) == true) goto L7;
        r13.add(canonicalizeWildcardsInType(r17));
    L7:
        r16 = r16 + 1;
        goto L3
    L9:
        return new Types.WildcardTypeImpl(r11.getLowerBounds(), (Type[]) r13.toArray(new Type[0]));
    }

    private static ParameterizedType canonicalizeWildcardsInParameterizedType(ParameterizedType r10) {
        Class r11 = (Class) r10.getRawType();
        TypeVariable<Class<T>>[] r12 = r11.getTypeParameters();
        Type[] r13 = r10.getActualTypeArguments();
        int r14 = 0;
    L4:
        if (r14 >= r13.length) goto L7;
        r13[r14] = canonicalizeTypeArg(r12[r14], r13[r14]);
        r14 = r14 + 1;
        goto L4
    L7:
        return Types.newParameterizedTypeWithOwner(r10.getOwnerType(), r11, r13);
    }

    private static Type canonicalizeWildcardsInType(Type r10) {
        if ((r10 instanceof ParameterizedType) == false) goto L7;
        return canonicalizeWildcardsInParameterizedType((ParameterizedType) r10);
    L7:
        if ((r10 instanceof GenericArrayType) == true) goto L9;
        return r10;
    L9:
        return Types.newArrayType(canonicalizeWildcardsInType(((GenericArrayType) r10).getGenericComponentType()));
    }

    private static Bounds every(Type[] r10) {
        return new Bounds(r10, false);
    }

    private TypeToken<? extends T> getArraySubtype(Class<?> r10) {
        return (TypeToken<? extends T>) of(newArrayClassOrGenericArrayType(getComponentType().getSubtype(r10.getComponentType()).runtimeType));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private TypeToken<? super T> getArraySupertype(Class<? super T> r10) {
        return (TypeToken<? super T>) of(newArrayClassOrGenericArrayType(((TypeToken) Preconditions.checkNotNull(getComponentType(), "%s isn't a super type of %s", r10, this)).getSupertype(r10.getComponentType()).runtimeType));
    }

    private TypeResolver getCovariantTypeResolver() {
        TypeResolver r10 = this.covariantTypeResolver;
        if (r10 != null) goto L6;
        TypeResolver r11 = TypeResolver.covariantly(this.runtimeType);
        this.covariantTypeResolver = r11;
        return r11;
    L6:
        return r10;
    }

    private TypeResolver getInvariantTypeResolver() {
        TypeResolver r10 = this.invariantTypeResolver;
        if (r10 != null) goto L6;
        TypeResolver r11 = TypeResolver.invariantly(this.runtimeType);
        this.invariantTypeResolver = r11;
        return r11;
    L6:
        return r10;
    }

    @NullableDecl
    private Type getOwnerTypeIfPresent() {
        Type r10 = this.runtimeType;
        if ((r10 instanceof ParameterizedType) == false) goto L7;
        return ((ParameterizedType) r10).getOwnerType();
    L7:
        if ((r10 instanceof Class) == true) goto L9;
        return null;
    L9:
        return ((Class) r10).getEnclosingClass();
    }

    private ImmutableSet<Class<? super T>> getRawTypes() {
        final ImmutableSet.Builder r10 = ImmutableSet.builder();
        new AnonymousClass4(this, r10).visit(new Type[]{this.runtimeType});
        return r10.build();
    }

    private TypeToken<? extends T> getSubtypeFromLowerBounds(Class<?> r10, Type[] r11) {
        if (r11.length <= 0) goto L7;
        return (TypeToken<? extends T>) of(r11[0]).getSubtype(r10);
    L7:
        throw new IllegalArgumentException(r10 + " isn't a subclass of " + this);
    }

    private TypeToken<? super T> getSupertypeFromUpperBounds(Class<? super T> r10, Type[] r11) {
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L10;
        TypeToken<?> r14 = of(r11[r13]);
        if (r14.isSubtypeOf(r10) == true) goto L7;
        r13 = r13 + 1;
        goto L3
    L7:
        return (TypeToken<? super T>) r14.getSupertype(r10);
    L10:
        throw new IllegalArgumentException(r10 + " isn't a super type of " + this);
    }

    private boolean is(Type r10, TypeVariable<?> r11) {
        if (this.runtimeType.equals(r10) == false) goto L6;
        return true;
    L6:
        if ((r10 instanceof WildcardType) == false) goto L15;
        WildcardType r12 = canonicalizeWildcardType(r11, (WildcardType) r10);
        if (every(r12.getUpperBounds()).isSupertypeOf(this.runtimeType) == true) goto L10;
    L12:
        return false;
    L10:
        if (every(r12.getLowerBounds()).isSubtypeOf(this.runtimeType) == false) goto L12;
        return true;
    L15:
        return canonicalizeWildcardsInType(this.runtimeType).equals(canonicalizeWildcardsInType(r10));
    }

    private boolean isOwnedBySubtypeOf(Type r10) {
        Iterator<TypeToken<? super T>> r11 = getTypes().iterator();
    L4:
        if (r11.hasNext() == false) goto L11;
        Type r12 = r11.next().getOwnerTypeIfPresent();
        if (r12 == null) goto L4;
        if (of(r12).isSubtypeOf(r10) == false) goto L4;
        return true;
    L11:
        return false;
    }

    private boolean isSubtypeOfArrayType(GenericArrayType r10) {
        Type r11 = this.runtimeType;
        if ((r11 instanceof Class) == false) goto L10;
        Class r12 = (Class) r11;
        if (r12.isArray() == true) goto L8;
        return false;
    L8:
        return of(r12.getComponentType()).isSubtypeOf(r10.getGenericComponentType());
    L10:
        if ((r11 instanceof GenericArrayType) == true) goto L12;
        return false;
    L12:
        return of(((GenericArrayType) r11).getGenericComponentType()).isSubtypeOf(r10.getGenericComponentType());
    }

    private boolean isSubtypeOfParameterizedType(ParameterizedType r10) {
        Class<? super Object> r11 = of(r10).getRawType();
        if (someRawTypeIsSubclassOf(r11) == true) goto L5;
        return false;
    L5:
        TypeVariable<Class<? super Object>>[] r12 = r11.getTypeParameters();
        Type[] r13 = r10.getActualTypeArguments();
        int r14 = 0;
    L7:
        if (r14 >= r12.length) goto L13;
        if (of(getCovariantTypeResolver().resolveType(r12[r14])).is(r13[r14], r12[r14]) == false) goto L10;
        r14 = r14 + 1;
        goto L7
    L10:
        return false;
    L13:
        if (Modifier.isStatic(((Class) r10.getRawType()).getModifiers()) == false) goto L15;
    L18:
        return true;
    L15:
        if (r10.getOwnerType() == null) goto L18;
        if (isOwnedBySubtypeOf(r10.getOwnerType()) == true) goto L18;
        return false;
    }

    private boolean isSupertypeOfArray(GenericArrayType r10) {
        Type r11 = this.runtimeType;
        if ((r11 instanceof Class) == false) goto L11;
        Class r12 = (Class) r11;
        if (r12.isArray() == true) goto L9;
        return r12.isAssignableFrom(Object[].class);
    L9:
        return of(r10.getGenericComponentType()).isSubtypeOf(r12.getComponentType());
    L11:
        if ((r11 instanceof GenericArrayType) == true) goto L13;
        return false;
    L13:
        return of(r10.getGenericComponentType()).isSubtypeOf(((GenericArrayType) this.runtimeType).getGenericComponentType());
    }

    private boolean isWrapper() {
        return Primitives.allWrapperTypes().contains(this.runtimeType);
    }

    private static Type newArrayClassOrGenericArrayType(Type r10) {
        return Types.JavaVersion.JAVA7.newArrayType(r10);
    }

    public static <T> TypeToken<T> of(Class<T> r10) {
        return new SimpleTypeToken(r10);
    }

    private TypeToken<?> resolveSupertype(Type r10) {
        TypeToken<?> r11 = of(getCovariantTypeResolver().resolveType(r10));
        r11.covariantTypeResolver = this.covariantTypeResolver;
        r11.invariantTypeResolver = this.invariantTypeResolver;
        return r11;
    }

    private Type resolveTypeArgsForSubclass(Class<?> r10) {
        if ((this.runtimeType instanceof Class) == true) goto L5;
    L9:
        TypeToken r11 = toGenericType(r10);
        Type r12 = r11.getSupertype(getRawType()).runtimeType;
        return new TypeResolver().where(r12, this.runtimeType).resolveType(r11.runtimeType);
    L5:
        if (r10.getTypeParameters().length != 0) goto L7;
    L8:
        return r10;
    L7:
        if (getRawType().getTypeParameters().length == 0) goto L9;
        goto L8
    }

    private boolean someRawTypeIsSubclassOf(Class<?> r10) {
        UnmodifiableIterator<Class<? super T>> r11 = getRawTypes().iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        if (r10.isAssignableFrom(r11.next()) == false) goto L4;
        return true;
    L9:
        return false;
    }

    @VisibleForTesting
    public static <T> TypeToken<? extends T> toGenericType(Class<T> r10) {
        if (r10.isArray() == true) goto L5;
        TypeVariable<Class<T>>[] r11 = r10.getTypeParameters();
        if (r10.isMemberClass() == true) goto L9;
    L11:
        Type r12 = null;
    L13:
        if (r11.length > 0) goto L21;
        if (r12 == null) goto L19;
        if (r12 != r10.getEnclosingClass()) goto L21;
    L19:
        return of(r10);
    L21:
        return (TypeToken<? extends T>) of(Types.newParameterizedTypeWithOwner(r12, r10, r11));
    L9:
        if (Modifier.isStatic(r10.getModifiers()) == true) goto L11;
        r12 = toGenericType(r10.getEnclosingClass()).runtimeType;
        goto L13
    L5:
        return (TypeToken<? extends T>) of(Types.newArrayType(toGenericType(r10.getComponentType()).runtimeType));
    }

    public final Invokable<T, T> constructor(final Constructor<?> r10) {
        if (r10.getDeclaringClass() != getRawType()) goto L5;
        boolean r11 = true;
    L6:
        Preconditions.checkArgument(r11, "%s not declared by %s", r10, getRawType());
        return new AnonymousClass2(this, r10);
    L5:
        r11 = false;
        goto L6
    }

    public boolean equals(@NullableDecl Object r10) {
        if ((r10 instanceof TypeToken) == true) goto L5;
        return false;
    L5:
        return this.runtimeType.equals(((TypeToken) r10).runtimeType);
    }

    @NullableDecl
    public final TypeToken<?> getComponentType() {
        Type r10 = Types.getComponentType(this.runtimeType);
        if (r10 != null) goto L7;
        return null;
    L7:
        return of(r10);
    }

    public final ImmutableList<TypeToken<? super T>> getGenericInterfaces() {
        Type r10 = this.runtimeType;
        if ((r10 instanceof TypeVariable) == false) goto L7;
        return boundsAsInterfaces(((TypeVariable) r10).getBounds());
    L7:
        if ((r10 instanceof WildcardType) == true) goto L9;
        ImmutableList.Builder r11 = ImmutableList.builder();
        Type[] r12 = getRawType().getGenericInterfaces();
        int r13 = r12.length;
        int r14 = 0;
    L11:
        if (r14 >= r13) goto L14;
        r11.add(resolveSupertype(r12[r14]));
        r14 = r14 + 1;
        goto L11
    L14:
        return r11.build();
    L9:
        return boundsAsInterfaces(((WildcardType) r10).getUpperBounds());
    }

    @NullableDecl
    public final TypeToken<? super T> getGenericSuperclass() {
        Type r10 = this.runtimeType;
        if ((r10 instanceof TypeVariable) == false) goto L7;
        return boundAsSuperclass(((TypeVariable) r10).getBounds()[0]);
    L7:
        if ((r10 instanceof WildcardType) == true) goto L9;
        Type r11 = getRawType().getGenericSuperclass();
        if (r11 != null) goto L15;
        return null;
    L15:
        return (TypeToken<? super T>) resolveSupertype(r11);
    L9:
        return boundAsSuperclass(((WildcardType) r10).getUpperBounds()[0]);
    }

    public final Class<? super T> getRawType() {
        return getRawTypes().iterator().next();
    }

    public final TypeToken<? extends T> getSubtype(Class<?> r10) {
        Preconditions.checkArgument(!(this.runtimeType instanceof TypeVariable), "Cannot get subtype of type variable <%s>", this);
        Type r11 = this.runtimeType;
        if ((r11 instanceof WildcardType) == false) goto L7;
        return getSubtypeFromLowerBounds(r10, ((WildcardType) r11).getLowerBounds());
    L7:
        if (isArray() == true) goto L9;
        Preconditions.checkArgument(getRawType().isAssignableFrom(r10), "%s isn't a subclass of %s", r10, this);
        TypeToken<? extends T> r12 = (TypeToken<? extends T>) of(resolveTypeArgsForSubclass(r10));
        Preconditions.checkArgument(r12.isSubtypeOf(this), "%s does not appear to be a subtype of %s", r12, this);
        return r12;
    L9:
        return getArraySubtype(r10);
    }

    public final TypeToken<? super T> getSupertype(Class<? super T> r10) {
        Preconditions.checkArgument(someRawTypeIsSubclassOf(r10), "%s is not a super class of %s", r10, this);
        Type r11 = this.runtimeType;
        if ((r11 instanceof TypeVariable) == false) goto L7;
        return getSupertypeFromUpperBounds(r10, ((TypeVariable) r11).getBounds());
    L7:
        if ((r11 instanceof WildcardType) == false) goto L11;
        return getSupertypeFromUpperBounds(r10, ((WildcardType) r11).getUpperBounds());
    L11:
        if (r10.isArray() == false) goto L15;
        return getArraySupertype(r10);
    L15:
        return (TypeToken<? super T>) resolveSupertype(toGenericType(r10).runtimeType);
    }

    public final Type getType() {
        return this.runtimeType;
    }

    public final TypeToken<T>.TypeSet getTypes() {
        return new TypeSet(this);
    }

    public int hashCode() {
        return this.runtimeType.hashCode();
    }

    public final boolean isArray() {
        if (getComponentType() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isPrimitive() {
        Type r10 = this.runtimeType;
        if ((r10 instanceof Class) == true) goto L5;
    L7:
        return false;
    L5:
        if (((Class) r10).isPrimitive() == false) goto L7;
        return true;
    }

    public final boolean isSubtypeOf(TypeToken<?> r10) {
        return isSubtypeOf(r10.getType());
    }

    public final boolean isSupertypeOf(TypeToken<?> r10) {
        return r10.isSubtypeOf(getType());
    }

    public final Invokable<T, Object> method(final Method r10) {
        Preconditions.checkArgument(someRawTypeIsSubclassOf(r10.getDeclaringClass()), "%s not declared by %s", r10, this);
        return new AnonymousClass1(this, r10);
    }

    @CanIgnoreReturnValue
    public final TypeToken<T> rejectTypeVariables() {
        new AnonymousClass3(this).visit(new Type[]{this.runtimeType});
        return this;
    }

    public final TypeToken<?> resolveType(Type r10) {
        Preconditions.checkNotNull(r10);
        return of(getInvariantTypeResolver().resolveType(r10));
    }

    public String toString() {
        return Types.toString(this.runtimeType);
    }

    public final TypeToken<T> unwrap() {
        if (isWrapper() == true) goto L5;
        return this;
    L5:
        return of(Primitives.unwrap((Class) this.runtimeType));
    }

    public final <X> TypeToken<T> where(TypeParameter<X> r10, TypeToken<X> r11) {
        return new SimpleTypeToken(new TypeResolver().where(ImmutableMap.of(new TypeResolver.TypeVariableKey(r10.typeVariable), r11.runtimeType)).resolveType(this.runtimeType));
    }

    public final TypeToken<T> wrap() {
        if (isPrimitive() == true) goto L5;
        return this;
    L5:
        return of(Primitives.wrap((Class) this.runtimeType));
    }

    public Object writeReplace() {
        return of(new TypeResolver().resolveType(this.runtimeType));
    }

    public TypeToken() {
        Type r10 = capture();
        this.runtimeType = r10;
        Preconditions.checkState(!(r10 instanceof TypeVariable), "Cannot construct a TypeToken for a type variable.\nYou probably meant to call new TypeToken<%s>(getClass()) that can resolve the type variable for you.\nIf you do need to create a TypeToken of a type variable, please use TypeToken.of() instead.", r10);
    }

    public static TypeToken<?> of(Type r10) {
        return new SimpleTypeToken(r10);
    }

    public final boolean isSubtypeOf(Type r10) {
        Preconditions.checkNotNull(r10);
        if ((r10 instanceof WildcardType) == true) goto L5;
        Type r11 = this.runtimeType;
        if ((r11 instanceof WildcardType) == false) goto L11;
        return any(((WildcardType) r11).getUpperBounds()).isSubtypeOf(r10);
    L11:
        if ((r11 instanceof TypeVariable) == false) goto L19;
        if (r11.equals(r10) == false) goto L15;
    L16:
        return true;
    L15:
        if (any(((TypeVariable) this.runtimeType).getBounds()).isSubtypeOf(r10) == true) goto L16;
        return false;
    L19:
        if ((r11 instanceof GenericArrayType) == false) goto L23;
        return of(r10).isSupertypeOfArray((GenericArrayType) this.runtimeType);
    L23:
        if ((r10 instanceof Class) == false) goto L27;
        return someRawTypeIsSubclassOf((Class) r10);
    L27:
        if ((r10 instanceof ParameterizedType) == false) goto L31;
        return isSubtypeOfParameterizedType((ParameterizedType) r10);
    L31:
        if ((r10 instanceof GenericArrayType) == true) goto L33;
        return false;
    L33:
        return isSubtypeOfArrayType((GenericArrayType) r10);
    L5:
        return any(((WildcardType) r10).getLowerBounds()).isSupertypeOf(this.runtimeType);
    }

    public final boolean isSupertypeOf(Type r10) {
        return of(r10).isSubtypeOf(getType());
    }

    public TypeToken(Class<?> r10) {
        Type r11 = super.capture();
        if ((r11 instanceof Class) == false) goto L5;
        this.runtimeType = r11;
        return;
    L5:
        this.runtimeType = TypeResolver.covariantly(r10).resolveType(r11);
    }

    public final <X> TypeToken<T> where(TypeParameter<X> r10, Class<X> r11) {
        return where(r10, of(r11));
    }

    private TypeToken(Type r10) {
        this.runtimeType = (Type) Preconditions.checkNotNull(r10);
    }
}
