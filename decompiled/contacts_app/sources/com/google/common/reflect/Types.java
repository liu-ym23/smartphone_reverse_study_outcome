package com.google.common.reflect;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.UnmodifiableIterator;
import java.io.Serializable;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.security.AccessControlException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
final class Types {
    private static final Joiner COMMA_JOINER = null;
    private static final Function<Type, String> TYPE_NAME = null;

    private static abstract enum ClassOwnership extends Enum<ClassOwnership> {
        private static final /* synthetic */ ClassOwnership[] $VALUES = null;
        static final ClassOwnership JVM_BEHAVIOR = null;
        public static final ClassOwnership LOCAL_CLASS_HAS_NO_OWNER = null;
        public static final ClassOwnership OWNED_BY_ENCLOSING_CLASS = null;

        @Nullable
        abstract Class<?> getOwnerType(Class<?> r1);

        private ClassOwnership(String r1, int r2) {
            super(r1, r2);
        }

        /* synthetic */ ClassOwnership(String r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        public static ClassOwnership valueOf(String r1) {
            return (ClassOwnership) Enum.valueOf(ClassOwnership.class, r1);
        }

        public static ClassOwnership[] values() {
            return (ClassOwnership[]) $VALUES.clone();
        }

        static {
            final String r1 = "OWNED_BY_ENCLOSING_CLASS";
            final int r2 = 0;
            ClassOwnership r0 = new AnonymousClass1(r1, r2);
            OWNED_BY_ENCLOSING_CLASS = r0;
            final String r3 = "LOCAL_CLASS_HAS_NO_OWNER";
            final int r4 = 1;
            ClassOwnership r5 = new AnonymousClass2(r3, r4);
            LOCAL_CLASS_HAS_NO_OWNER = r5;
            $VALUES = new ClassOwnership[]{r0, r5};
            JVM_BEHAVIOR = detectJvmBehavior();
        }

        private static ClassOwnership detectJvmBehavior() {
            ParameterizedType r0 = (ParameterizedType) new AnonymousClass3().getClass().getGenericSuperclass();
            ClassOwnership[] r1 = values();
            int r2 = r1.length;
            int r3 = 0;
        L3:
            if (r3 >= r2) goto L9;
            ClassOwnership r4 = r1[r3];
            if (r4.getOwnerType(C1LocalClass.class) == r0.getOwnerType()) goto L6;
            r3 = r3 + 1;
            goto L3
        L6:
            return r4;
        L9:
            throw new AssertionError();
        }
    }

    private static final class GenericArrayTypeImpl implements GenericArrayType, Serializable {
        private static final long serialVersionUID = 0;
        private final Type componentType;

        GenericArrayTypeImpl(Type r2) {
            this.componentType = JavaVersion.CURRENT.usedInGenericType(r2);
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.componentType;
        }

        public String toString() {
            return Types.toString(this.componentType) + "[]";
        }

        public int hashCode() {
            return this.componentType.hashCode();
        }

        public boolean equals(Object r2) {
            if ((r2 instanceof GenericArrayType) == true) goto L5;
            return false;
        L5:
            return Objects.equal(getGenericComponentType(), ((GenericArrayType) r2).getGenericComponentType());
        }
    }

    static abstract enum JavaVersion extends Enum<JavaVersion> {
        private static final /* synthetic */ JavaVersion[] $VALUES = null;
        static final JavaVersion CURRENT = null;
        public static final JavaVersion JAVA6 = null;
        public static final JavaVersion JAVA7 = null;
        public static final JavaVersion JAVA8 = null;

        abstract Type newArrayType(Type r1);

        abstract Type usedInGenericType(Type r1);

        private JavaVersion(String r1, int r2) {
            super(r1, r2);
        }

        /* synthetic */ JavaVersion(String r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        public static JavaVersion valueOf(String r1) {
            return (JavaVersion) Enum.valueOf(JavaVersion.class, r1);
        }

        public static JavaVersion[] values() {
            return (JavaVersion[]) $VALUES.clone();
        }

        static {
            final String r1 = "JAVA6";
            final int r2 = 0;
            JavaVersion r0 = new AnonymousClass1(r1, r2);
            JAVA6 = r0;
            final String r3 = "JAVA7";
            final int r4 = 1;
            JavaVersion r5 = new AnonymousClass2(r3, r4);
            JAVA7 = r5;
            final String r6 = "JAVA8";
            final int r7 = 2;
            JavaVersion r8 = new AnonymousClass3(r6, r7);
            JAVA8 = r8;
            $VALUES = new JavaVersion[]{r0, r5, r8};
            if (AnnotatedElement.class.isAssignableFrom(TypeVariable.class) == false) goto L6;
            CURRENT = r8;
            return;
        L6:
            if ((new AnonymousClass4().capture() instanceof Class) == false) goto L8;
            CURRENT = r5;
            return;
        L8:
            CURRENT = r0;
        }

        String typeName(Type r1) {
            return Types.toString(r1);
        }

        final ImmutableList<Type> usedInGenericType(Type[] r5) {
            ImmutableList.Builder r0 = ImmutableList.builder();
            int r1 = r5.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L6;
            r0.add(usedInGenericType(r5[r2]));
            r2 = r2 + 1;
            goto L3
        L6:
            return r0.build();
        }
    }

    static final class NativeTypeVariableEquals<X> {
        static final boolean NATIVE_TYPE_VARIABLE_ONLY = false;

        NativeTypeVariableEquals() {
        }

        static {
            NATIVE_TYPE_VARIABLE_ONLY = !NativeTypeVariableEquals.class.getTypeParameters()[0].equals(Types.newArtificialTypeVariable(NativeTypeVariableEquals.class, "X", new Type[0]));
        }
    }

    private static final class ParameterizedTypeImpl implements ParameterizedType, Serializable {
        private static final long serialVersionUID = 0;
        private final ImmutableList<Type> argumentsList;
        private final Type ownerType;
        private final Class<?> rawType;

        ParameterizedTypeImpl(@Nullable Type r3, Class<?> r4, Type[] r5) {
            Preconditions.checkNotNull(r4);
            if (r5.length != r4.getTypeParameters().length) goto L5;
            boolean r0 = true;
        L6:
            Preconditions.checkArgument(r0);
            Types.access$200(r5, "type parameter");
            this.ownerType = r3;
            this.rawType = r4;
            this.argumentsList = JavaVersion.CURRENT.usedInGenericType(r5);
            return;
        L5:
            r0 = false;
            goto L6
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return Types.access$300(this.argumentsList);
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.rawType;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.ownerType;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            if (this.ownerType == null) goto L5;
            r0.append(JavaVersion.CURRENT.typeName(this.ownerType)).append('.');
        L5:
            r0.append(this.rawType.getName()).append('<').append(Types.access$500().join(Iterables.transform(this.argumentsList, Types.access$400()))).append('>');
            return r0.toString();
        }

        public int hashCode() {
            Type r0 = this.ownerType;
            if (r0 != null) goto L5;
            int r1 = 0;
        L6:
            int r2 = r1 ^ this.argumentsList.hashCode();
            return this.rawType.hashCode() ^ r2;
        L5:
            r1 = r0.hashCode();
            goto L6
        }

        public boolean equals(Object r4) {
            if ((r4 instanceof ParameterizedType) == true) goto L5;
            return false;
        L5:
            ParameterizedType r5 = (ParameterizedType) r4;
            if (getRawType().equals(r5.getRawType()) == true) goto L8;
            return false;
        L8:
            if (Objects.equal(getOwnerType(), r5.getOwnerType()) == true) goto L10;
            return false;
        L10:
            if (Arrays.equals(getActualTypeArguments(), r5.getActualTypeArguments()) == false) goto L15;
            return true;
        L15:
            return false;
        }
    }

    private static final class TypeVariableImpl<D extends GenericDeclaration> {
        private final ImmutableList<Type> bounds;
        private final D genericDeclaration;
        private final String name;

        TypeVariableImpl(D r2, String r3, Type[] r4) {
            Types.access$200(r4, "bound for type variable");
            this.genericDeclaration = (D) Preconditions.checkNotNull(r2);
            this.name = (String) Preconditions.checkNotNull(r3);
            this.bounds = ImmutableList.copyOf(r4);
        }

        public Type[] getBounds() {
            return Types.access$300(this.bounds);
        }

        public D getGenericDeclaration() {
            return this.genericDeclaration;
        }

        public String getName() {
            return this.name;
        }

        public String getTypeName() {
            return this.name;
        }

        public String toString() {
            return this.name;
        }

        public int hashCode() {
            int r0 = this.genericDeclaration.hashCode();
            return this.name.hashCode() ^ r0;
        }

        public boolean equals(Object r5) {
            if (NativeTypeVariableEquals.NATIVE_TYPE_VARIABLE_ONLY == false) goto L20;
            if (r5 != null) goto L6;
        L18:
            return false;
        L6:
            if (Proxy.isProxyClass(r5.getClass()) == false) goto L18;
            if ((Proxy.getInvocationHandler(r5) instanceof TypeVariableInvocationHandler) == false) goto L18;
            TypeVariableImpl r6 = TypeVariableInvocationHandler.access$600((TypeVariableInvocationHandler) Proxy.getInvocationHandler(r5));
            if (this.name.equals(r6.getName()) == false) goto L17;
            if (this.genericDeclaration.equals(r6.getGenericDeclaration()) == false) goto L17;
            if (this.bounds.equals(r6.bounds) == false) goto L17;
            return true;
        L17:
            return false;
        L20:
            if ((r5 instanceof TypeVariable) == false) goto L28;
            TypeVariable r7 = (TypeVariable) r5;
            if (this.name.equals(r7.getName()) == false) goto L27;
            if (this.genericDeclaration.equals(r7.getGenericDeclaration()) == false) goto L27;
            return true;
        L27:
            return false;
        L28:
            return false;
        }
    }

    private static final class TypeVariableInvocationHandler implements InvocationHandler {
        private static final ImmutableMap<String, Method> typeVariableMethods = null;
        private final TypeVariableImpl<?> typeVariableImpl;

        static /* synthetic */ TypeVariableImpl access$600(TypeVariableInvocationHandler r0) {
            return r0.typeVariableImpl;
        }

        static {
            ImmutableMap.Builder r0 = ImmutableMap.builder();
            Method[] r1 = TypeVariableImpl.class.getMethods();
            int r2 = r1.length;
            int r3 = 0;
        L3:
            if (r3 >= r2) goto L10;
            Method r4 = r1[r3];
            if (r4.getDeclaringClass().equals(TypeVariableImpl.class) == false) goto L9;
            r4.setAccessible(true);     // Catch: AccessControlException -> L12
        L8:
            r0.put(r4.getName(), r4);
        L9:
            r3 = r3 + 1;
            goto L3
        L10:
            typeVariableMethods = r0.build();
        }

        TypeVariableInvocationHandler(TypeVariableImpl<?> r1) {
            this.typeVariableImpl = r1;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object r1, Method r2, Object[] r3) throws Throwable {
            String r4 = r2.getName();
            Method r5 = typeVariableMethods.get(r4);
            if (r5 == null) goto L10;
            return r5.invoke(this.typeVariableImpl, r3);
        L6:
            e = move-exception;
            throw e.getCause();
        L10:
            throw new UnsupportedOperationException(r4);
        }
    }

    static final class WildcardTypeImpl implements WildcardType, Serializable {
        private static final long serialVersionUID = 0;
        private final ImmutableList<Type> lowerBounds;
        private final ImmutableList<Type> upperBounds;

        WildcardTypeImpl(Type[] r2, Type[] r3) {
            Types.access$200(r2, "lower bound for wildcard");
            Types.access$200(r3, "upper bound for wildcard");
            this.lowerBounds = JavaVersion.CURRENT.usedInGenericType(r2);
            this.upperBounds = JavaVersion.CURRENT.usedInGenericType(r3);
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            return Types.access$300(this.lowerBounds);
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return Types.access$300(this.upperBounds);
        }

        public boolean equals(Object r4) {
            if ((r4 instanceof WildcardType) == false) goto L10;
            WildcardType r5 = (WildcardType) r4;
            if (this.lowerBounds.equals(Arrays.asList(r5.getLowerBounds())) == true) goto L7;
            return false;
        L7:
            if (this.upperBounds.equals(Arrays.asList(r5.getUpperBounds())) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        public int hashCode() {
            int r0 = this.lowerBounds.hashCode();
            return this.upperBounds.hashCode() ^ r0;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder("?");
            UnmodifiableIterator<Type> r1 = this.lowerBounds.iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            Type r2 = r1.next();
            r0.append(" super ").append(JavaVersion.CURRENT.typeName(r2));
            goto L4
        L6:
            Iterator r5 = Types.access$700(this.upperBounds).iterator();
        L8:
            if (r5.hasNext() == false) goto L11;
            Type r3 = (Type) r5.next();
            r0.append(" extends ").append(JavaVersion.CURRENT.typeName(r3));
            goto L8
        L11:
            return r0.toString();
        }
    }

    static /* synthetic */ Type access$100(Type[] r0) {
        return subtypeOfComponentType(r0);
    }

    static /* synthetic */ void access$200(Type[] r0, String r1) {
        disallowPrimitiveType(r0, r1);
    }

    static /* synthetic */ Type[] access$300(Collection r0) {
        return toArray(r0);
    }

    static /* synthetic */ Function access$400() {
        return TYPE_NAME;
    }

    static /* synthetic */ Joiner access$500() {
        return COMMA_JOINER;
    }

    static /* synthetic */ Iterable access$700(Iterable r0) {
        return filterUpperBounds(r0);
    }

    static {
        TYPE_NAME = new AnonymousClass1();
        COMMA_JOINER = Joiner.on(", ").useForNull("null");
    }

    static Type newArrayType(Type r5) {
        if ((r5 instanceof WildcardType) == false) goto L19;
        WildcardType r6 = (WildcardType) r5;
        Type[] r0 = r6.getLowerBounds();
        boolean r3 = true;
        if (r0.length > 1) goto L7;
        boolean r1 = true;
    L8:
        Preconditions.checkArgument(r1, "Wildcard cannot have more than one lower bounds.");
        if (r0.length == 1) goto L11;
        Type[] r7 = r6.getUpperBounds();
        if (r7.length == 1) goto L16;
        r3 = false;
    L16:
        Preconditions.checkArgument(r3, "Wildcard should have only one upper bound.");
        return subtypeOf(newArrayType(r7[0]));
    L11:
        return supertypeOf(newArrayType(r0[0]));
    L7:
        r1 = false;
        goto L8
    L19:
        return JavaVersion.CURRENT.newArrayType(r5);
    }

    static ParameterizedType newParameterizedTypeWithOwner(@Nullable Type r3, Class<?> r4, Type... r5) {
        if (r3 == null) goto L4;
        Preconditions.checkNotNull(r5);
        if (r4.getEnclosingClass() == null) goto L8;
        boolean r0 = true;
    L9:
        Preconditions.checkArgument(r0, "Owner type for unenclosed %s", new Object[]{r4});
        return new ParameterizedTypeImpl(r3, r4, r5);
    L8:
        r0 = false;
        goto L9
    L4:
        return newParameterizedType(r4, r5);
    }

    static ParameterizedType newParameterizedType(Class<?> r2, Type... r3) {
        return new ParameterizedTypeImpl(ClassOwnership.JVM_BEHAVIOR.getOwnerType(r2), r2, r3);
    }

    static <D extends GenericDeclaration> TypeVariable<D> newArtificialTypeVariable(D r2, String r3, Type... r4) {
        if (r4.length != 0) goto L6;
        r4 = new Type[]{Object.class};
    L6:
        return newTypeVariableImpl(r2, r3, r4);
    }

    static WildcardType subtypeOf(Type r4) {
        return new WildcardTypeImpl(new Type[0], new Type[]{r4});
    }

    static WildcardType supertypeOf(Type r4) {
        return new WildcardTypeImpl(new Type[]{r4}, new Type[]{Object.class});
    }

    static String toString(Type r1) {
        if ((r1 instanceof Class) == false) goto L6;
        return ((Class) r1).getName();
    L6:
        return r1.toString();
    }

    @Nullable
    static Type getComponentType(Type r4) {
        Preconditions.checkNotNull(r4);
        final AtomicReference r0 = new AtomicReference();
        new AnonymousClass2(r0).visit(new Type[]{r4});
        return (Type) r0.get();
    }

    @Nullable
    private static Type subtypeOfComponentType(Type[] r3) {
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L14;
        Type r2 = getComponentType(r3[r1]);
        if (r2 != null) goto L7;
        r1 = r1 + 1;
        goto L3
    L7:
        if ((r2 instanceof Class) == false) goto L12;
        Class r4 = (Class) r2;
        if (r4.isPrimitive() == false) goto L12;
        return r4;
    L12:
        return subtypeOf(r2);
    L14:
        return null;
    }

    private static <D extends GenericDeclaration> TypeVariable<D> newTypeVariableImpl(D r1, String r2, Type[] r3) {
        return (TypeVariable) Reflection.newProxy(TypeVariable.class, new TypeVariableInvocationHandler(new TypeVariableImpl(r1, r2, r3)));
    }

    private static Type[] toArray(Collection<Type> r1) {
        return (Type[]) r1.toArray(new Type[r1.size()]);
    }

    private static Iterable<Type> filterUpperBounds(Iterable<Type> r1) {
        return Iterables.filter(r1, Predicates.not(Predicates.equalTo(Object.class)));
    }

    private static void disallowPrimitiveType(Type[] r7, String r8) {
        int r0 = r7.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        Type r3 = r7[r2];
        if ((r3 instanceof Class) == false) goto L7;
        Class r4 = (Class) r3;
        Preconditions.checkArgument(!r4.isPrimitive(), "Primitive type '%s' used as %s", new Object[]{r4, r8});
    L7:
        r2 = r2 + 1;
        goto L3
    }

    static Class<?> getArrayClass(Class<?> r1) {
        return Array.newInstance(r1, 0).getClass();
    }

    private Types() {
    }
}
