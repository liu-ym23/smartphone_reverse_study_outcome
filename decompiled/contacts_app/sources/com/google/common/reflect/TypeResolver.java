package com.google.common.reflect;

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
import javax.annotation.Nullable;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes2.dex */
public final class TypeResolver {
    private final TypeTable typeTable;

    private static final class TypeMappingIntrospector extends TypeVisitor {
        private static final WildcardCapturer wildcardCapturer = null;
        private final Map<TypeVariableKey, Type> mappings;

        private TypeMappingIntrospector() {
            this.mappings = Maps.newHashMap();
        }

        static {
            wildcardCapturer = new WildcardCapturer(null);
        }

        static ImmutableMap<TypeVariableKey, Type> getTypeMappings(Type r3) {
            TypeMappingIntrospector r0 = new TypeMappingIntrospector();
            r0.visit(new Type[]{wildcardCapturer.capture(r3)});
            return ImmutableMap.copyOf(r0.mappings);
        }

        @Override // com.google.common.reflect.TypeVisitor
        void visitClass(Class<?> r4) {
            visit(new Type[]{r4.getGenericSuperclass()});
            visit(r4.getGenericInterfaces());
        }

        @Override // com.google.common.reflect.TypeVisitor
        void visitParameterizedType(ParameterizedType r9) {
            Class r0 = (Class) r9.getRawType();
            TypeVariable[] r1 = r0.getTypeParameters();
            Type[] r2 = r9.getActualTypeArguments();
            if (r1.length != r2.length) goto L5;
            boolean r3 = true;
        L6:
            Preconditions.checkState(r3);
            int r4 = 0;
        L8:
            if (r4 >= r1.length) goto L10;
            map(new TypeVariableKey(r1[r4]), r2[r4]);
            r4 = r4 + 1;
            goto L8
        L10:
            visit(new Type[]{r0});
            visit(new Type[]{r9.getOwnerType()});
            return;
        L5:
            r3 = false;
            goto L6
        }

        @Override // com.google.common.reflect.TypeVisitor
        void visitTypeVariable(TypeVariable<?> r1) {
            visit(r1.getBounds());
        }

        @Override // com.google.common.reflect.TypeVisitor
        void visitWildcardType(WildcardType r1) {
            visit(r1.getUpperBounds());
        }

        private void map(TypeVariableKey r3, Type r4) {
            if (this.mappings.containsKey(r3) == false) goto L5;
            return;
        L5:
            Type r0 = r4;
        L6:
            if (r0 == null) goto L13;
            if (r3.equalsType(r0) == true) goto L9;
            r0 = this.mappings.get(TypeVariableKey.forLookup(r0));
        L9:
            if (r4 == null) goto L11;
            r4 = this.mappings.remove(TypeVariableKey.forLookup(r4));
            goto L9
        L11:
            return;
        L13:
            this.mappings.put(r3, r4);
        }
    }

    private static class TypeTable {
        private final ImmutableMap<TypeVariableKey, Type> map;

        TypeTable() {
            this.map = ImmutableMap.of();
        }

        private TypeTable(ImmutableMap<TypeVariableKey, Type> r1) {
            this.map = r1;
        }

        final TypeTable where(Map<TypeVariableKey, ? extends Type> r6) {
            ImmutableMap.Builder r0 = ImmutableMap.builder();
            r0.putAll(this.map);
            Iterator<Map.Entry<TypeVariableKey, ? extends Type>> r5 = r6.entrySet().iterator();
        L4:
            if (r5.hasNext() == false) goto L7;
            Map.Entry<TypeVariableKey, ? extends Type> r7 = r5.next();
            TypeVariableKey r1 = r7.getKey();
            Type r8 = r7.getValue();
            Preconditions.checkArgument(!r1.equalsType(r8), "Type variable %s bound to itself", new Object[]{r1});
            r0.put(r1, r8);
            goto L4
        L7:
            return new TypeTable(r0.build());
        }

        final Type resolve(final TypeVariable<?> r2) {
            return resolveInternal(r2, new AnonymousClass1(this, r2, this));
        }

        Type resolveInternal(TypeVariable<?> r3, TypeTable r4) {
            Type r2 = this.map.get(new TypeVariableKey(r3));
            AnonymousClass1 r0 = null;
            if (r2 != null) goto L15;
            Type[] r5 = r3.getBounds();
            if (r5.length != 0) goto L7;
            return r3;
        L7:
            Type[] r6 = TypeResolver.access$300(new TypeResolver(r4, r0), r5);
            if (Types.NativeTypeVariableEquals.NATIVE_TYPE_VARIABLE_ONLY == false) goto L13;
            if (Arrays.equals(r5, r6) == false) goto L13;
            return r3;
        L13:
            return Types.newArtificialTypeVariable(r3.getGenericDeclaration(), r3.getName(), r6);
        L15:
            return new TypeResolver(r4, r0).resolveType(r2);
        }
    }

    static final class TypeVariableKey {
        private final TypeVariable<?> var;

        TypeVariableKey(TypeVariable<?> r1) {
            this.var = (TypeVariable) Preconditions.checkNotNull(r1);
        }

        public int hashCode() {
            return Objects.hashCode(new Object[]{this.var.getGenericDeclaration(), this.var.getName()});
        }

        public boolean equals(Object r2) {
            if ((r2 instanceof TypeVariableKey) == true) goto L5;
            return false;
        L5:
            return equalsTypeVariable(((TypeVariableKey) r2).var);
        }

        public String toString() {
            return this.var.toString();
        }

        static Object forLookup(Type r1) {
            if ((r1 instanceof TypeVariable) == true) goto L5;
            return null;
        L5:
            return new TypeVariableKey((TypeVariable) r1);
        }

        boolean equalsType(Type r2) {
            if ((r2 instanceof TypeVariable) == true) goto L5;
            return false;
        L5:
            return equalsTypeVariable((TypeVariable) r2);
        }

        private boolean equalsTypeVariable(TypeVariable<?> r3) {
            if (this.var.getGenericDeclaration().equals(r3.getGenericDeclaration()) == true) goto L5;
        L7:
            return false;
        L5:
            if (this.var.getName().equals(r3.getName()) == false) goto L7;
            return true;
        }
    }

    private static final class WildcardCapturer {
        private final AtomicInteger id;

        private WildcardCapturer() {
            this.id = new AtomicInteger();
        }

        /* synthetic */ WildcardCapturer(AnonymousClass1 r1) {
            this();
        }

        Type capture(Type r4) {
            Preconditions.checkNotNull(r4);
            if ((r4 instanceof Class) == false) goto L6;
            return r4;
        L6:
            if ((r4 instanceof TypeVariable) == false) goto L9;
            return r4;
        L9:
            if ((r4 instanceof GenericArrayType) == false) goto L13;
            return Types.newArrayType(capture(((GenericArrayType) r4).getGenericComponentType()));
        L13:
            if ((r4 instanceof ParameterizedType) == false) goto L17;
            ParameterizedType r5 = (ParameterizedType) r4;
            return Types.newParameterizedTypeWithOwner(captureNullable(r5.getOwnerType()), (Class) r5.getRawType(), capture(r5.getActualTypeArguments()));
        L17:
            if ((r4 instanceof WildcardType) == false) goto L24;
            WildcardType r0 = (WildcardType) r4;
            if (r0.getLowerBounds().length == 0) goto L21;
            return r4;
        L21:
            return Types.newArtificialTypeVariable(WildcardCapturer.class, "capture#" + this.id.incrementAndGet() + "-of ? extends " + Joiner.on(Typography.amp).join(r0.getUpperBounds()), r0.getUpperBounds());
        L24:
            throw new AssertionError("must have been one of the known types");
        }

        private Type captureNullable(@Nullable Type r1) {
            if (r1 != null) goto L6;
            return null;
        L6:
            return capture(r1);
        }

        private Type[] capture(Type[] r4) {
            Type[] r0 = new Type[r4.length];
            int r1 = 0;
        L4:
            if (r1 >= r4.length) goto L6;
            r0[r1] = capture(r4[r1]);
            r1 = r1 + 1;
            goto L4
        L6:
            return r0;
        }
    }

    /* synthetic */ TypeResolver(TypeTable r1, AnonymousClass1 r2) {
        this(r1);
    }

    static /* synthetic */ Object access$000(Class r0, Object r1) {
        return expectArgument(r0, r1);
    }

    static /* synthetic */ void access$100(Map r0, Type r1, Type r2) {
        populateTypeMappings(r0, r1, r2);
    }

    static /* synthetic */ Type[] access$300(TypeResolver r0, Type[] r1) {
        return r0.resolveTypes(r1);
    }

    public TypeResolver() {
        this.typeTable = new TypeTable();
    }

    private TypeResolver(TypeTable r1) {
        this.typeTable = r1;
    }

    static TypeResolver accordingTo(Type r1) {
        return new TypeResolver().where(TypeMappingIntrospector.getTypeMappings(r1));
    }

    public TypeResolver where(Type r2, Type r3) {
        HashMap r0 = Maps.newHashMap();
        populateTypeMappings(r0, (Type) Preconditions.checkNotNull(r2), (Type) Preconditions.checkNotNull(r3));
        return where(r0);
    }

    TypeResolver where(Map<TypeVariableKey, ? extends Type> r2) {
        return new TypeResolver(this.typeTable.where(r2));
    }

    private static void populateTypeMappings(final Map<TypeVariableKey, Type> r1, Type r2, final Type r3) {
        if (r2.equals(r3) == false) goto L5;
        return;
    L5:
        new AnonymousClass1(r1, r3).visit(new Type[]{r2});
    }

    public Type resolveType(Type r2) {
        Preconditions.checkNotNull(r2);
        if ((r2 instanceof TypeVariable) == false) goto L7;
        return this.typeTable.resolve((TypeVariable) r2);
    L7:
        if ((r2 instanceof ParameterizedType) == false) goto L11;
        return resolveParameterizedType((ParameterizedType) r2);
    L11:
        if ((r2 instanceof GenericArrayType) == false) goto L15;
        return resolveGenericArrayType((GenericArrayType) r2);
    L15:
        if ((r2 instanceof WildcardType) == true) goto L17;
        return r2;
    L17:
        return resolveWildcardType((WildcardType) r2);
    }

    private Type[] resolveTypes(Type[] r4) {
        Type[] r0 = new Type[r4.length];
        int r1 = 0;
    L4:
        if (r1 >= r4.length) goto L6;
        r0[r1] = resolveType(r4[r1]);
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    private WildcardType resolveWildcardType(WildcardType r3) {
        Type[] r0 = r3.getLowerBounds();
        Type[] r4 = r3.getUpperBounds();
        return new Types.WildcardTypeImpl(resolveTypes(r0), resolveTypes(r4));
    }

    private Type resolveGenericArrayType(GenericArrayType r1) {
        return Types.newArrayType(resolveType(r1.getGenericComponentType()));
    }

    private ParameterizedType resolveParameterizedType(ParameterizedType r3) {
        Type r0 = r3.getOwnerType();
        if (r0 != null) goto L5;
        Type r1 = null;
    L6:
        Type r2 = resolveType(r3.getRawType());
        Class r4 = (Class) r2;
        return Types.newParameterizedTypeWithOwner(r1, r4, resolveTypes(r3.getActualTypeArguments()));
    L5:
        r1 = resolveType(r0);
        goto L6
    }

    private static <T> T expectArgument(Class<T> r2, Object r3) {
        return r2.cast(r3);
    L5:
        throw new IllegalArgumentException(r3 + " is not a " + r2.getSimpleName());
    }
}
