package com.google.common.reflect;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ForwardingSet;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Primitives;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class TypeToken<T> extends TypeCapture<T> implements Serializable {
    private final Type runtimeType;
    private transient TypeResolver typeResolver;

    private final class ClassSet extends TypeToken<T>.TypeSet {
        private static final long serialVersionUID = 0;
        private transient ImmutableSet<TypeToken<? super T>> classes;
        final /* synthetic */ TypeToken this$0;

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet classes() {
            return this;
        }

        private ClassSet(TypeToken r1) {
            this.this$0 = r1;
            super(r1);
        }

        /* synthetic */ ClassSet(TypeToken r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected Set<TypeToken<? super T>> delegate() {
            ImmutableSet<TypeToken<? super T>> r0 = this.classes;
            if (r0 != null) goto L6;
            ImmutableSet<TypeToken<? super T>> r1 = FluentIterable.from(TypeCollector.FOR_GENERIC_TYPE.classesOnly().collectTypes(this.this$0)).filter(TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD).toSet();
            this.classes = r1;
            return r1;
        L6:
            return r0;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public Set<Class<? super T>> rawTypes() {
            return ImmutableSet.copyOf(TypeCollector.FOR_RAW_TYPE.classesOnly().collectTypes(TypeToken.access$200(this.this$0)));
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet interfaces() {
            throw new UnsupportedOperationException("classes().interfaces() not supported.");
        }

        private Object readResolve() {
            return this.this$0.getTypes().classes();
        }
    }

    private final class InterfaceSet extends TypeToken<T>.TypeSet {
        private static final long serialVersionUID = 0;
        private final transient TypeToken<T>.TypeSet allTypes;
        private transient ImmutableSet<TypeToken<? super T>> interfaces;
        final /* synthetic */ TypeToken this$0;

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet interfaces() {
            return this;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        InterfaceSet(TypeToken r1, TypeToken<T>.TypeSet r2) {
            this.this$0 = r1;
            super(r1);
            this.allTypes = r2;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected Set<TypeToken<? super T>> delegate() {
            ImmutableSet<TypeToken<? super T>> r0 = this.interfaces;
            if (r0 != null) goto L6;
            ImmutableSet<TypeToken<? super T>> r1 = FluentIterable.from(this.allTypes).filter(TypeFilter.INTERFACE_ONLY).toSet();
            this.interfaces = r1;
            return r1;
        L6:
            return r0;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public Set<Class<? super T>> rawTypes() {
            return FluentIterable.from(TypeCollector.FOR_RAW_TYPE.collectTypes(TypeToken.access$200(this.this$0))).filter(new AnonymousClass1(this)).toSet();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet classes() {
            throw new UnsupportedOperationException("interfaces().classes() not supported.");
        }

        private Object readResolve() {
            return this.this$0.getTypes().interfaces();
        }
    }

    private static final class SimpleTypeToken<T> extends TypeToken<T> {
        private static final long serialVersionUID = 0;

        SimpleTypeToken(Type r2) {
            super(r2, null);
        }
    }

    private static abstract class TypeCollector<K> {
        static final TypeCollector<TypeToken<?>> FOR_GENERIC_TYPE = null;
        static final TypeCollector<Class<?>> FOR_RAW_TYPE = null;

        private static class ForwardingTypeCollector<K> extends TypeCollector<K> {
            private final TypeCollector<K> delegate;

            ForwardingTypeCollector(TypeCollector<K> r2) {
                super(null);
                this.delegate = r2;
            }

            @Override // com.google.common.reflect.TypeToken.TypeCollector
            Class<?> getRawType(K r1) {
                return this.delegate.getRawType(r1);
            }

            @Override // com.google.common.reflect.TypeToken.TypeCollector
            Iterable<? extends K> getInterfaces(K r1) {
                return this.delegate.getInterfaces(r1);
            }

            @Override // com.google.common.reflect.TypeToken.TypeCollector
            K getSuperclass(K r1) {
                return this.delegate.getSuperclass(r1);
            }
        }

        abstract Iterable<? extends K> getInterfaces(K r1);

        abstract Class<?> getRawType(K r1);

        @Nullable
        abstract K getSuperclass(K r1);

        private TypeCollector() {
        }

        /* synthetic */ TypeCollector(AnonymousClass1 r1) {
            this();
        }

        static {
            FOR_GENERIC_TYPE = new AnonymousClass1();
            FOR_RAW_TYPE = new AnonymousClass2();
        }

        final TypeCollector<K> classesOnly() {
            return new AnonymousClass3(this, this);
        }

        final ImmutableList<K> collectTypes(K r1) {
            return collectTypes(ImmutableList.of(r1));
        }

        ImmutableList<K> collectTypes(Iterable<? extends K> r3) {
            HashMap r0 = Maps.newHashMap();
            Iterator<? extends K> r4 = r3.iterator();
        L4:
            if (r4.hasNext() == false) goto L7;
            collectTypes(r4.next(), r0);
            goto L4
        L7:
            return sortKeysByValue(r0, Ordering.natural().reverse());
        }

        /* JADX WARN: Multi-variable type inference failed */
        private int collectTypes(K r4, Map<? super K, Integer> r5) {
            Integer r0 = r5.get(this);
            if (r0 != null) goto L5;
            boolean r1 = getRawType(r4).isInterface();
            Iterator<? extends K> r2 = getInterfaces(r4).iterator();
            int r3 = r1;
        L8:
            if (r2.hasNext() == false) goto L10;
            r3 = Math.max(r3, collectTypes(r2.next(), r5));
            goto L8
        L10:
            K r6 = getSuperclass(r4);
            int r7 = r3;
            if (r6 == null) goto L13;
            r7 = Math.max(r3, collectTypes(r6, r5));
        L13:
            int r8 = r7 + 1;
            r5.put(r4, Integer.valueOf(r8));
            return r8;
        L5:
            return r0.intValue();
        }

        private static <K, V> ImmutableList<K> sortKeysByValue(final Map<K, V> r1, final Comparator<? super V> r2) {
            return (ImmutableList<K>) new AnonymousClass4(r2, r1).immutableSortedCopy(r1.keySet());
        }
    }

    private static abstract enum TypeFilter extends Enum<TypeFilter> implements Predicate<TypeToken<?>> {
        private static final /* synthetic */ TypeFilter[] $VALUES = null;
        public static final TypeFilter IGNORE_TYPE_VARIABLE_OR_WILDCARD = null;
        public static final TypeFilter INTERFACE_ONLY = null;

        private TypeFilter(String r1, int r2) {
            super(r1, r2);
        }

        /* synthetic */ TypeFilter(String r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        public static TypeFilter valueOf(String r1) {
            return (TypeFilter) Enum.valueOf(TypeFilter.class, r1);
        }

        public static TypeFilter[] values() {
            return (TypeFilter[]) $VALUES.clone();
        }

        static {
            final String r1 = "IGNORE_TYPE_VARIABLE_OR_WILDCARD";
            final int r2 = 0;
            TypeFilter r0 = new AnonymousClass1(r1, r2);
            IGNORE_TYPE_VARIABLE_OR_WILDCARD = r0;
            final String r3 = "INTERFACE_ONLY";
            final int r4 = 1;
            TypeFilter r5 = new AnonymousClass2(r3, r4);
            INTERFACE_ONLY = r5;
            $VALUES = new TypeFilter[]{r0, r5};
        }
    }

    public class TypeSet extends ForwardingSet<TypeToken<? super T>> implements Serializable {
        private static final long serialVersionUID = 0;
        final /* synthetic */ TypeToken this$0;
        private transient ImmutableSet<TypeToken<? super T>> types;

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        TypeSet(TypeToken r1) {
            this.this$0 = r1;
        }

        public TypeToken<T>.TypeSet interfaces() {
            return new InterfaceSet(this.this$0, this);
        }

        public TypeToken<T>.TypeSet classes() {
            return new ClassSet(this.this$0, null);
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected Set<TypeToken<? super T>> delegate() {
            ImmutableSet<TypeToken<? super T>> r0 = this.types;
            if (r0 != null) goto L6;
            ImmutableSet<TypeToken<? super T>> r1 = FluentIterable.from(TypeCollector.FOR_GENERIC_TYPE.collectTypes(this.this$0)).filter(TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD).toSet();
            this.types = r1;
            return r1;
        L6:
            return r0;
        }

        public Set<Class<? super T>> rawTypes() {
            return ImmutableSet.copyOf(TypeCollector.FOR_RAW_TYPE.collectTypes(TypeToken.access$200(this.this$0)));
        }
    }

    /* synthetic */ TypeToken(Type r1, AnonymousClass1 r2) {
        this(r1);
    }

    static /* synthetic */ Type[] access$000(TypeToken r0, Type[] r1) {
        return r0.resolveInPlace(r1);
    }

    static /* synthetic */ ImmutableSet access$200(TypeToken r0) {
        return r0.getImmediateRawTypes();
    }

    static /* synthetic */ Type access$400(TypeToken r0) {
        return r0.runtimeType;
    }

    protected TypeToken() {
        Type r0 = capture();
        this.runtimeType = r0;
        Preconditions.checkState(!(r0 instanceof TypeVariable), "Cannot construct a TypeToken for a type variable.\nYou probably meant to call new TypeToken<%s>(getClass()) that can resolve the type variable for you.\nIf you do need to create a TypeToken of a type variable, please use TypeToken.of() instead.", new Object[]{r0});
    }

    protected TypeToken(Class<?> r3) {
        Type r0 = super.capture();
        if ((r0 instanceof Class) == false) goto L5;
        this.runtimeType = r0;
        return;
    L5:
        this.runtimeType = of(r3).resolveType(r0).runtimeType;
    }

    private TypeToken(Type r1) {
        this.runtimeType = (Type) Preconditions.checkNotNull(r1);
    }

    public static <T> TypeToken<T> of(Class<T> r1) {
        return new SimpleTypeToken(r1);
    }

    public static TypeToken<?> of(Type r1) {
        return new SimpleTypeToken(r1);
    }

    public final Class<? super T> getRawType() {
        return (Class<? super T>) getRawType(this.runtimeType);
    }

    private ImmutableSet<Class<? super T>> getImmediateRawTypes() {
        return (ImmutableSet<Class<? super T>>) getRawTypes(this.runtimeType);
    }

    public final Type getType() {
        return this.runtimeType;
    }

    public final <X> TypeToken<T> where(TypeParameter<X> r3, TypeToken<X> r4) {
        return new SimpleTypeToken(new TypeResolver().where(ImmutableMap.of(new TypeResolver.TypeVariableKey(r3.typeVariable), r4.runtimeType)).resolveType(this.runtimeType));
    }

    public final <X> TypeToken<T> where(TypeParameter<X> r1, Class<X> r2) {
        return where(r1, of(r2));
    }

    public final TypeToken<?> resolveType(Type r2) {
        Preconditions.checkNotNull(r2);
        TypeResolver r0 = this.typeResolver;
        if (r0 != null) goto L6;
        r0 = TypeResolver.accordingTo(this.runtimeType);
        this.typeResolver = r0;
    L6:
        return of(r0.resolveType(r2));
    }

    private Type[] resolveInPlace(Type[] r3) {
        int r0 = 0;
    L4:
        if (r0 >= r3.length) goto L6;
        r3[r0] = resolveType(r3[r0]).getType();
        r0 = r0 + 1;
        goto L4
    L6:
        return r3;
    }

    private TypeToken<?> resolveSupertype(Type r1) {
        TypeToken<?> r2 = resolveType(r1);
        r2.typeResolver = this.typeResolver;
        return r2;
    }

    @Nullable
    final TypeToken<? super T> getGenericSuperclass() {
        Type r0 = this.runtimeType;
        if ((r0 instanceof TypeVariable) == false) goto L7;
        return boundAsSuperclass(((TypeVariable) r0).getBounds()[0]);
    L7:
        if ((r0 instanceof WildcardType) == true) goto L9;
        Type r1 = getRawType().getGenericSuperclass();
        if (r1 != null) goto L15;
        return null;
    L15:
        return (TypeToken<? super T>) resolveSupertype(r1);
    L9:
        return boundAsSuperclass(((WildcardType) r0).getUpperBounds()[0]);
    }

    @Nullable
    private TypeToken<? super T> boundAsSuperclass(Type r1) {
        TypeToken<? super T> r0 = (TypeToken<? super T>) of(r1);
        if (r0.getRawType().isInterface() == false) goto L6;
        return null;
    L6:
        return r0;
    }

    final ImmutableList<TypeToken<? super T>> getGenericInterfaces() {
        Type r0 = this.runtimeType;
        if ((r0 instanceof TypeVariable) == false) goto L7;
        return boundsAsInterfaces(((TypeVariable) r0).getBounds());
    L7:
        if ((r0 instanceof WildcardType) == true) goto L9;
        ImmutableList.Builder r1 = ImmutableList.builder();
        Type[] r2 = getRawType().getGenericInterfaces();
        int r3 = r2.length;
        int r4 = 0;
    L11:
        if (r4 >= r3) goto L14;
        r1.add(resolveSupertype(r2[r4]));
        r4 = r4 + 1;
        goto L11
    L14:
        return r1.build();
    L9:
        return boundsAsInterfaces(((WildcardType) r0).getUpperBounds());
    }

    private ImmutableList<TypeToken<? super T>> boundsAsInterfaces(Type[] r5) {
        ImmutableList.Builder r4 = ImmutableList.builder();
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        TypeToken<?> r2 = of(r5[r1]);
        if (r2.getRawType().isInterface() == false) goto L7;
        r4.add(r2);
    L7:
        r1 = r1 + 1;
        goto L3
    L9:
        return r4.build();
    }

    public final TypeToken<T>.TypeSet getTypes() {
        return new TypeSet(this);
    }

    public final TypeToken<? super T> getSupertype(Class<? super T> r4) {
        Preconditions.checkArgument(r4.isAssignableFrom(getRawType()), "%s is not a super class of %s", new Object[]{r4, this});
        Type r0 = this.runtimeType;
        if ((r0 instanceof TypeVariable) == false) goto L7;
        return getSupertypeFromUpperBounds(r4, ((TypeVariable) r0).getBounds());
    L7:
        if ((r0 instanceof WildcardType) == false) goto L11;
        return getSupertypeFromUpperBounds(r4, ((WildcardType) r0).getUpperBounds());
    L11:
        if (r4.isArray() == false) goto L15;
        return getArraySupertype(r4);
    L15:
        return (TypeToken<? super T>) resolveSupertype(toGenericType(r4).runtimeType);
    }

    public final TypeToken<? extends T> getSubtype(Class<?> r6) {
        Preconditions.checkArgument(!(this.runtimeType instanceof TypeVariable), "Cannot get subtype of type variable <%s>", new Object[]{this});
        Type r0 = this.runtimeType;
        if ((r0 instanceof WildcardType) == true) goto L5;
        Preconditions.checkArgument(getRawType().isAssignableFrom(r6), "%s isn't a subclass of %s", new Object[]{r6, this});
        if (isArray() == false) goto L11;
        return getArraySubtype(r6);
    L11:
        return (TypeToken<? extends T>) of(resolveTypeArgsForSubclass(r6));
    L5:
        return getSubtypeFromLowerBounds(r6, ((WildcardType) r0).getLowerBounds());
    }

    public final boolean isAssignableFrom(TypeToken<?> r1) {
        return isAssignableFrom(r1.runtimeType);
    }

    public final boolean isAssignableFrom(Type r1) {
        return isAssignable((Type) Preconditions.checkNotNull(r1), this.runtimeType);
    }

    public final boolean isArray() {
        if (getComponentType() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isPrimitive() {
        Type r1 = this.runtimeType;
        if ((r1 instanceof Class) == true) goto L5;
    L7:
        return false;
    L5:
        if (((Class) r1).isPrimitive() == false) goto L7;
        return true;
    }

    public final TypeToken<T> wrap() {
        if (isPrimitive() == true) goto L5;
        return this;
    L5:
        return of(Primitives.wrap((Class) this.runtimeType));
    }

    private boolean isWrapper() {
        return Primitives.allWrapperTypes().contains(this.runtimeType);
    }

    public final TypeToken<T> unwrap() {
        if (isWrapper() == true) goto L5;
        return this;
    L5:
        return of(Primitives.unwrap((Class) this.runtimeType));
    }

    @Nullable
    public final TypeToken<?> getComponentType() {
        Type r0 = Types.getComponentType(this.runtimeType);
        if (r0 != null) goto L7;
        return null;
    L7:
        return of(r0);
    }

    public final Invokable<T, Object> method(final Method r4) {
        Preconditions.checkArgument(of(r4.getDeclaringClass()).isAssignableFrom(this), "%s not declared by %s", new Object[]{r4, this});
        return new AnonymousClass1(this, r4);
    }

    public final Invokable<T, T> constructor(final Constructor<?> r5) {
        if (r5.getDeclaringClass() != getRawType()) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "%s not declared by %s", new Object[]{r5, getRawType()});
        return new AnonymousClass2(this, r5);
    L5:
        r0 = false;
        goto L6
    }

    public boolean equals(@Nullable Object r2) {
        if ((r2 instanceof TypeToken) == true) goto L5;
        return false;
    L5:
        return this.runtimeType.equals(((TypeToken) r2).runtimeType);
    }

    public int hashCode() {
        return this.runtimeType.hashCode();
    }

    public String toString() {
        return Types.toString(this.runtimeType);
    }

    protected Object writeReplace() {
        return of(new TypeResolver().resolveType(this.runtimeType));
    }

    final TypeToken<T> rejectTypeVariables() {
        new AnonymousClass3(this).visit(new Type[]{this.runtimeType});
        return this;
    }

    private static boolean isAssignable(Type r1, Type r2) {
        if (r2.equals(r1) == false) goto L7;
        return true;
    L7:
        if ((r2 instanceof WildcardType) == false) goto L11;
        return isAssignableToWildcardType(r1, (WildcardType) r2);
    L11:
        if ((r1 instanceof TypeVariable) == false) goto L15;
        return isAssignableFromAny(((TypeVariable) r1).getBounds(), r2);
    L15:
        if ((r1 instanceof WildcardType) == false) goto L19;
        return isAssignableFromAny(((WildcardType) r1).getUpperBounds(), r2);
    L19:
        if ((r1 instanceof GenericArrayType) == false) goto L23;
        return isAssignableFromGenericArrayType((GenericArrayType) r1, r2);
    L23:
        if ((r2 instanceof Class) == false) goto L27;
        return isAssignableToClass(r1, (Class) r2);
    L27:
        if ((r2 instanceof ParameterizedType) == false) goto L31;
        return isAssignableToParameterizedType(r1, (ParameterizedType) r2);
    L31:
        if ((r2 instanceof GenericArrayType) == true) goto L33;
        return false;
    L33:
        return isAssignableToGenericArrayType(r1, (GenericArrayType) r2);
    }

    private static boolean isAssignableFromAny(Type[] r4, Type r5) {
        int r0 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (isAssignable(r4[r2], r5) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private static boolean isAssignableToClass(Type r0, Class<?> r1) {
        return r1.isAssignableFrom(getRawType(r0));
    }

    private static boolean isAssignableToWildcardType(Type r1, WildcardType r2) {
        if (isAssignable(r1, supertypeBound(r2)) == true) goto L5;
    L7:
        return false;
    L5:
        if (isAssignableBySubtypeBound(r1, r2) == false) goto L7;
        return true;
    }

    private static boolean isAssignableBySubtypeBound(Type r0, WildcardType r1) {
        Type r2 = subtypeBound(r1);
        if (r2 != null) goto L6;
        return true;
    L6:
        Type r3 = subtypeBound(r0);
        if (r3 != null) goto L11;
        return false;
    L11:
        return isAssignable(r2, r3);
    }

    private static boolean isAssignableToParameterizedType(Type r5, ParameterizedType r6) {
        Class<?> r0 = getRawType(r6);
        if (r0.isAssignableFrom(getRawType(r5)) == true) goto L5;
        return false;
    L5:
        TypeVariable<Class<?>>[] r1 = r0.getTypeParameters();
        Type[] r7 = r6.getActualTypeArguments();
        TypeToken<?> r8 = of(r5);
        int r2 = 0;
    L7:
        if (r2 >= r1.length) goto L12;
        if (matchTypeArgument(((TypeToken) r8.resolveType(r1[r2])).runtimeType, r7[r2]) == false) goto L10;
        r2 = r2 + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    }

    private static boolean isAssignableToGenericArrayType(Type r2, GenericArrayType r3) {
        if ((r2 instanceof Class) == false) goto L10;
        Class r4 = (Class) r2;
        if (r4.isArray() == true) goto L8;
        return false;
    L8:
        return isAssignable(r4.getComponentType(), r3.getGenericComponentType());
    L10:
        if ((r2 instanceof GenericArrayType) == true) goto L12;
        return false;
    L12:
        return isAssignable(((GenericArrayType) r2).getGenericComponentType(), r3.getGenericComponentType());
    }

    private static boolean isAssignableFromGenericArrayType(GenericArrayType r2, Type r3) {
        if ((r3 instanceof Class) == false) goto L13;
        Class r4 = (Class) r3;
        if (r4.isArray() == true) goto L11;
        if (r4 != Object.class) goto L17;
        return true;
    L17:
        return false;
    L11:
        return isAssignable(r2.getGenericComponentType(), r4.getComponentType());
    L13:
        if ((r3 instanceof GenericArrayType) == true) goto L15;
        return false;
    L15:
        return isAssignable(r2.getGenericComponentType(), ((GenericArrayType) r3).getGenericComponentType());
    }

    private static boolean matchTypeArgument(Type r1, Type r2) {
        if (r1.equals(r2) == false) goto L7;
        return true;
    L7:
        if ((r2 instanceof WildcardType) == true) goto L9;
        return false;
    L9:
        return isAssignableToWildcardType(r1, (WildcardType) r2);
    }

    private static Type supertypeBound(Type r1) {
        if ((r1 instanceof WildcardType) == true) goto L5;
        return r1;
    L5:
        return supertypeBound((WildcardType) r1);
    }

    private static Type supertypeBound(WildcardType r3) {
        Type[] r0 = r3.getUpperBounds();
        if (r0.length != 1) goto L7;
        return supertypeBound(r0[0]);
    L7:
        if (r0.length != 0) goto L11;
        return Object.class;
    L11:
        throw new AssertionError("There should be at most one upper bound for wildcard type: " + r3);
    }

    @Nullable
    private static Type subtypeBound(Type r1) {
        if ((r1 instanceof WildcardType) == true) goto L5;
        return r1;
    L5:
        return subtypeBound((WildcardType) r1);
    }

    @Nullable
    private static Type subtypeBound(WildcardType r3) {
        Type[] r0 = r3.getLowerBounds();
        if (r0.length != 1) goto L7;
        return subtypeBound(r0[0]);
    L7:
        if (r0.length != 0) goto L11;
        return null;
    L11:
        throw new AssertionError("Wildcard should have at most one lower bound: " + r3);
    }

    static Class<?> getRawType(Type r0) {
        return getRawTypes(r0).iterator().next();
    }

    static ImmutableSet<Class<?>> getRawTypes(Type r4) {
        Preconditions.checkNotNull(r4);
        final ImmutableSet.Builder r0 = ImmutableSet.builder();
        new AnonymousClass4(r0).visit(new Type[]{r4});
        return r0.build();
    }

    static <T> TypeToken<? extends T> toGenericType(Class<T> r2) {
        if (r2.isArray() == true) goto L5;
        TypeVariable<Class<T>>[] r0 = r2.getTypeParameters();
        if (r0.length <= 0) goto L11;
        return (TypeToken<? extends T>) of(Types.newParameterizedType(r2, r0));
    L11:
        return of(r2);
    L5:
        return (TypeToken<? extends T>) of(Types.newArrayType(toGenericType(r2.getComponentType()).runtimeType));
    }

    private TypeToken<? super T> getSupertypeFromUpperBounds(Class<? super T> r5, Type[] r6) {
        int r0 = r6.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        TypeToken<?> r2 = of(r6[r1]);
        if (of(r5).isAssignableFrom(r2) == true) goto L7;
        r1 = r1 + 1;
        goto L3
    L7:
        return (TypeToken<? super T>) r2.getSupertype(r5);
    L10:
        throw new IllegalArgumentException(r5 + " isn't a super type of " + this);
    }

    private TypeToken<? extends T> getSubtypeFromLowerBounds(Class<?> r2, Type[] r3) {
        if (r3.length <= 0) goto L7;
        return (TypeToken<? extends T>) of(r3[0]).getSubtype(r2);
    L7:
        throw new IllegalArgumentException(r2 + " isn't a subclass of " + this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private TypeToken<? super T> getArraySupertype(Class<? super T> r4) {
        return (TypeToken<? super T>) of(newArrayClassOrGenericArrayType(((TypeToken) Preconditions.checkNotNull(getComponentType(), "%s isn't a super type of %s", new Object[]{r4, this})).getSupertype(r4.getComponentType()).runtimeType));
    }

    private TypeToken<? extends T> getArraySubtype(Class<?> r1) {
        return (TypeToken<? extends T>) of(newArrayClassOrGenericArrayType(getComponentType().getSubtype(r1.getComponentType()).runtimeType));
    }

    private Type resolveTypeArgsForSubclass(Class<?> r3) {
        if ((this.runtimeType instanceof Class) == false) goto L5;
        return r3;
    L5:
        TypeToken r4 = toGenericType(r3);
        Type r0 = r4.getSupertype(getRawType()).runtimeType;
        return new TypeResolver().where(r0, this.runtimeType).resolveType(r4.runtimeType);
    }

    private static Type newArrayClassOrGenericArrayType(Type r1) {
        return Types.JavaVersion.JAVA7.newArrayType(r1);
    }
}
