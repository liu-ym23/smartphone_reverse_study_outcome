package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@Beta
public final class TypeResolver {
    private final TypeTable typeTable;

    public static final class TypeMappingIntrospector extends TypeVisitor {
        private final Map<TypeVariableKey, Type> mappings;

        private TypeMappingIntrospector() {
            this.mappings = Maps.newHashMap();
        }

        public static ImmutableMap<TypeVariableKey, Type> getTypeMappings(Type r10) {
            Preconditions.checkNotNull(r10);
            TypeMappingIntrospector r11 = new TypeMappingIntrospector();
            r11.visit(new Type[]{r10});
            return ImmutableMap.copyOf(r11.mappings);
        }

        private void map(TypeVariableKey r10, Type r11) {
            if (this.mappings.containsKey(r10) == false) goto L5;
            return;
        L5:
            Type r12 = r11;
        L6:
            if (r12 == null) goto L13;
            if (r10.equalsType(r12) == true) goto L9;
            r12 = this.mappings.get(TypeVariableKey.forLookup(r12));
        L9:
            if (r11 == null) goto L11;
            r11 = this.mappings.remove(TypeVariableKey.forLookup(r11));
            goto L9
        L11:
            return;
        L13:
            this.mappings.put(r10, r11);
        }

        @Override // com.google.common.reflect.TypeVisitor
        public void visitClass(Class<?> r10) {
            visit(new Type[]{r10.getGenericSuperclass()});
            visit(r10.getGenericInterfaces());
        }

        @Override // com.google.common.reflect.TypeVisitor
        public void visitParameterizedType(ParameterizedType r10) {
            Class r11 = (Class) r10.getRawType();
            TypeVariable[] r12 = r11.getTypeParameters();
            Type[] r13 = r10.getActualTypeArguments();
            if (r12.length != r13.length) goto L5;
            boolean r14 = true;
        L6:
            Preconditions.checkState(r14);
            int r15 = 0;
        L8:
            if (r15 >= r12.length) goto L10;
            map(new TypeVariableKey(r12[r15]), r13[r15]);
            r15 = r15 + 1;
            goto L8
        L10:
            visit(new Type[]{r11});
            visit(new Type[]{r10.getOwnerType()});
            return;
        L5:
            r14 = false;
            goto L6
        }

        @Override // com.google.common.reflect.TypeVisitor
        public void visitTypeVariable(TypeVariable<?> r10) {
            visit(r10.getBounds());
        }

        @Override // com.google.common.reflect.TypeVisitor
        public void visitWildcardType(WildcardType r10) {
            visit(r10.getUpperBounds());
        }
    }

    public static class TypeTable {
        private final ImmutableMap<TypeVariableKey, Type> map;

        public TypeTable() {
            this.map = ImmutableMap.of();
        }

        public final Type resolve(final TypeVariable<?> r10) {
            return resolveInternal(r10, new AnonymousClass1(this, r10, this));
        }

        public Type resolveInternal(TypeVariable<?> r10, TypeTable r11) {
            Type r12 = this.map.get(new TypeVariableKey(r10));
            AnonymousClass1 r13 = null;
            if (r12 != null) goto L15;
            Type[] r14 = r10.getBounds();
            if (r14.length != 0) goto L7;
            return r10;
        L7:
            Type[] r15 = TypeResolver.access$300(new TypeResolver(r11, r13), r14);
            if (Types.NativeTypeVariableEquals.NATIVE_TYPE_VARIABLE_ONLY == false) goto L13;
            if (Arrays.equals(r14, r15) == false) goto L13;
            return r10;
        L13:
            return Types.newArtificialTypeVariable(r10.getGenericDeclaration(), r10.getName(), r15);
        L15:
            return new TypeResolver(r11, r13).resolveType(r12);
        }

        public final TypeTable where(Map<TypeVariableKey, ? extends Type> r10) {
            ImmutableMap.Builder r11 = ImmutableMap.builder();
            r11.putAll(this.map);
            Iterator<Map.Entry<TypeVariableKey, ? extends Type>> r12 = r10.entrySet().iterator();
        L4:
            if (r12.hasNext() == false) goto L7;
            Map.Entry<TypeVariableKey, ? extends Type> r13 = r12.next();
            TypeVariableKey r14 = r13.getKey();
            Type r15 = r13.getValue();
            Preconditions.checkArgument(!r14.equalsType(r15), "Type variable %s bound to itself", r14);
            r11.put(r14, r15);
            goto L4
        L7:
            return new TypeTable(r11.build());
        }

        private TypeTable(ImmutableMap<TypeVariableKey, Type> r10) {
            this.map = r10;
        }
    }

    public static final class TypeVariableKey {
        private final TypeVariable<?> var;

        public TypeVariableKey(TypeVariable<?> r10) {
            this.var = (TypeVariable) Preconditions.checkNotNull(r10);
        }

        private boolean equalsTypeVariable(TypeVariable<?> r10) {
            if (this.var.getGenericDeclaration().equals(r10.getGenericDeclaration()) == true) goto L5;
        L7:
            return false;
        L5:
            if (this.var.getName().equals(r10.getName()) == false) goto L7;
            return true;
        }

        public static TypeVariableKey forLookup(Type r10) {
            if ((r10 instanceof TypeVariable) == true) goto L5;
            return null;
        L5:
            return new TypeVariableKey((TypeVariable) r10);
        }

        public boolean equals(Object r10) {
            if ((r10 instanceof TypeVariableKey) == true) goto L5;
            return false;
        L5:
            return equalsTypeVariable(((TypeVariableKey) r10).var);
        }

        public boolean equalsType(Type r10) {
            if ((r10 instanceof TypeVariable) == true) goto L5;
            return false;
        L5:
            return equalsTypeVariable((TypeVariable) r10);
        }

        public int hashCode() {
            return Objects.hashCode(new Object[]{this.var.getGenericDeclaration(), this.var.getName()});
        }

        public String toString() {
            return this.var.toString();
        }
    }

    public static class WildcardCapturer {
        static final WildcardCapturer INSTANCE = null;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private final AtomicInteger f10387id;

        static {
            INSTANCE = new WildcardCapturer();
        }

        public /* synthetic */ WildcardCapturer(AtomicInteger r10, AnonymousClass1 r11) {
            this(r10);
        }

        private Type captureNullable(@NullableDecl Type r10) {
            if (r10 != null) goto L6;
            return null;
        L6:
            return capture(r10);
        }

        private WildcardCapturer forTypeVariable(final TypeVariable<?> r10) {
            final AtomicInteger r11 = this.f10387id;
            return new AnonymousClass1(this, r11, r10);
        }

        private WildcardCapturer notForTypeVariable() {
            return new WildcardCapturer(this.f10387id);
        }

        public final Type capture(Type r10) {
            Preconditions.checkNotNull(r10);
            if ((r10 instanceof Class) == false) goto L6;
            return r10;
        L6:
            if ((r10 instanceof TypeVariable) == false) goto L9;
            return r10;
        L9:
            if ((r10 instanceof GenericArrayType) == false) goto L13;
            return Types.newArrayType(notForTypeVariable().capture(((GenericArrayType) r10).getGenericComponentType()));
        L13:
            if ((r10 instanceof ParameterizedType) == false) goto L21;
            ParameterizedType r11 = (ParameterizedType) r10;
            Class r12 = (Class) r11.getRawType();
            TypeVariable<?>[] r13 = r12.getTypeParameters();
            Type[] r14 = r11.getActualTypeArguments();
            int r15 = 0;
        L16:
            if (r15 >= r14.length) goto L19;
            r14[r15] = forTypeVariable(r13[r15]).capture(r14[r15]);
            r15 = r15 + 1;
            goto L16
        L19:
            return Types.newParameterizedTypeWithOwner(notForTypeVariable().captureNullable(r11.getOwnerType()), r12, r14);
        L21:
            if ((r10 instanceof WildcardType) == false) goto L28;
            WildcardType r16 = (WildcardType) r10;
            if (r16.getLowerBounds().length == 0) goto L25;
            return r10;
        L25:
            return captureAsTypeVariable(r16.getUpperBounds());
        L28:
            throw new AssertionError("must have been one of the known types");
        }

        public TypeVariable<?> captureAsTypeVariable(Type[] r10) {
            return Types.newArtificialTypeVariable(WildcardCapturer.class, "capture#" + this.f10387id.incrementAndGet() + "-of ? extends " + Joiner.on('&').join(r10), r10);
        }

        private WildcardCapturer() {
            this(new AtomicInteger());
        }

        private WildcardCapturer(AtomicInteger r10) {
            this.f10387id = r10;
        }
    }

    public /* synthetic */ TypeResolver(TypeTable r10, AnonymousClass1 r11) {
        this(r10);
    }

    public static /* synthetic */ void access$000(Map r10, Type r11, Type r12) {
        populateTypeMappings(r10, r11, r12);
    }

    public static /* synthetic */ Object access$100(Class r10, Object r11) {
        return expectArgument(r10, r11);
    }

    public static /* synthetic */ Type[] access$300(TypeResolver r10, Type[] r11) {
        return r10.resolveTypes(r11);
    }

    public static TypeResolver covariantly(Type r10) {
        return new TypeResolver().where(TypeMappingIntrospector.getTypeMappings(r10));
    }

    private static <T> T expectArgument(Class<T> r10, Object r11) {
        return r10.cast(r11);
    L5:
        throw new IllegalArgumentException(r11 + " is not a " + r10.getSimpleName());
    }

    public static TypeResolver invariantly(Type r10) {
        Type r11 = WildcardCapturer.INSTANCE.capture(r10);
        return new TypeResolver().where(TypeMappingIntrospector.getTypeMappings(r11));
    }

    private static void populateTypeMappings(final Map<TypeVariableKey, Type> r10, Type r11, final Type r12) {
        if (r11.equals(r12) == false) goto L5;
        return;
    L5:
        new AnonymousClass1(r10, r12).visit(new Type[]{r11});
    }

    private Type resolveGenericArrayType(GenericArrayType r10) {
        return Types.newArrayType(resolveType(r10.getGenericComponentType()));
    }

    private ParameterizedType resolveParameterizedType(ParameterizedType r10) {
        Type r11 = r10.getOwnerType();
        if (r11 != null) goto L5;
        Type r12 = null;
    L6:
        Type r13 = resolveType(r10.getRawType());
        Class r14 = (Class) r13;
        return Types.newParameterizedTypeWithOwner(r12, r14, resolveTypes(r10.getActualTypeArguments()));
    L5:
        r12 = resolveType(r11);
        goto L6
    }

    private Type[] resolveTypes(Type[] r10) {
        Type[] r11 = new Type[r10.length];
        int r12 = 0;
    L4:
        if (r12 >= r10.length) goto L6;
        r11[r12] = resolveType(r10[r12]);
        r12 = r12 + 1;
        goto L4
    L6:
        return r11;
    }

    private WildcardType resolveWildcardType(WildcardType r10) {
        Type[] r11 = r10.getLowerBounds();
        Type[] r12 = r10.getUpperBounds();
        return new Types.WildcardTypeImpl(resolveTypes(r11), resolveTypes(r12));
    }

    public Type resolveType(Type r10) {
        Preconditions.checkNotNull(r10);
        if ((r10 instanceof TypeVariable) == false) goto L7;
        return this.typeTable.resolve((TypeVariable) r10);
    L7:
        if ((r10 instanceof ParameterizedType) == false) goto L11;
        return resolveParameterizedType((ParameterizedType) r10);
    L11:
        if ((r10 instanceof GenericArrayType) == false) goto L15;
        return resolveGenericArrayType((GenericArrayType) r10);
    L15:
        if ((r10 instanceof WildcardType) == true) goto L17;
        return r10;
    L17:
        return resolveWildcardType((WildcardType) r10);
    }

    public Type[] resolveTypesInPlace(Type[] r10) {
        int r11 = 0;
    L4:
        if (r11 >= r10.length) goto L6;
        r10[r11] = resolveType(r10[r11]);
        r11 = r11 + 1;
        goto L4
    L6:
        return r10;
    }

    public TypeResolver where(Type r10, Type r11) {
        HashMap r12 = Maps.newHashMap();
        populateTypeMappings(r12, (Type) Preconditions.checkNotNull(r10), (Type) Preconditions.checkNotNull(r11));
        return where(r12);
    }

    public TypeResolver() {
        this.typeTable = new TypeTable();
    }

    private TypeResolver(TypeTable r10) {
        this.typeTable = r10;
    }

    public TypeResolver where(Map<TypeVariableKey, ? extends Type> r10) {
        return new TypeResolver(this.typeTable.where(r10));
    }
}
