package com.google.common.reflect;

import com.google.common.annotations.VisibleForTesting;
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
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
final class Types {
    private static final Joiner COMMA_JOINER = null;
    private static final Function<Type, String> TYPE_NAME = null;

    public static abstract enum ClassOwnership extends Enum<ClassOwnership> {
        private static final /* synthetic */ ClassOwnership[] $VALUES = null;
        static final ClassOwnership JVM_BEHAVIOR = null;
        public static final ClassOwnership LOCAL_CLASS_HAS_NO_OWNER = null;
        public static final ClassOwnership OWNED_BY_ENCLOSING_CLASS = null;

        static {
            final String r10 = "OWNED_BY_ENCLOSING_CLASS";
            final int r11 = 0;
            ClassOwnership r12 = new AnonymousClass1(r10, r11);
            OWNED_BY_ENCLOSING_CLASS = r12;
            final String r13 = "LOCAL_CLASS_HAS_NO_OWNER";
            final int r14 = 1;
            ClassOwnership r15 = new AnonymousClass2(r13, r14);
            LOCAL_CLASS_HAS_NO_OWNER = r15;
            $VALUES = new ClassOwnership[]{r12, r15};
            JVM_BEHAVIOR = detectJvmBehavior();
        }

        private ClassOwnership(String r10, int r11) {
            super(r10, r11);
        }

        private static ClassOwnership detectJvmBehavior() {
            new AnonymousClass3();
            ParameterizedType r10 = (ParameterizedType) AnonymousClass3.class.getGenericSuperclass();
            ClassOwnership[] r11 = values();
            int r12 = r11.length;
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L9;
            ClassOwnership r14 = r11[r13];
            if (r14.getOwnerType(C1LocalClass.class) == r10.getOwnerType()) goto L6;
            r13 = r13 + 1;
            goto L3
        L6:
            return r14;
        L9:
            throw new AssertionError();
        }

        public static ClassOwnership valueOf(String r10) {
            return (ClassOwnership) Enum.valueOf(ClassOwnership.class, r10);
        }

        public static ClassOwnership[] values() {
            return (ClassOwnership[]) $VALUES.clone();
        }

        @NullableDecl
        public abstract Class<?> getOwnerType(Class<?> r10);

        public /* synthetic */ ClassOwnership(String r10, int r11, AnonymousClass1 r12) {
            this(r10, r11);
        }
    }

    public static final class GenericArrayTypeImpl implements GenericArrayType, Serializable {
        private static final long serialVersionUID = 0;
        private final Type componentType;

        public GenericArrayTypeImpl(Type r10) {
            this.componentType = JavaVersion.CURRENT.usedInGenericType(r10);
        }

        public boolean equals(Object r10) {
            if ((r10 instanceof GenericArrayType) == true) goto L5;
            return false;
        L5:
            return Objects.equal(getGenericComponentType(), ((GenericArrayType) r10).getGenericComponentType());
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.componentType;
        }

        public int hashCode() {
            return this.componentType.hashCode();
        }

        public String toString() {
            return Types.toString(this.componentType) + "[]";
        }
    }

    public static abstract enum JavaVersion extends Enum<JavaVersion> {
        private static final /* synthetic */ JavaVersion[] $VALUES = null;
        static final JavaVersion CURRENT = null;
        public static final JavaVersion JAVA6 = null;
        public static final JavaVersion JAVA7 = null;
        public static final JavaVersion JAVA8 = null;
        public static final JavaVersion JAVA9 = null;

        static {
            final String r10 = "JAVA6";
            final int r11 = 0;
            JavaVersion r12 = new AnonymousClass1(r10, r11);
            JAVA6 = r12;
            final String r13 = "JAVA7";
            final int r14 = 1;
            JavaVersion r15 = new AnonymousClass2(r13, r14);
            JAVA7 = r15;
            final String r16 = "JAVA8";
            final int r17 = 2;
            JavaVersion r18 = new AnonymousClass3(r16, r17);
            JAVA8 = r18;
            final String r19 = "JAVA9";
            final int r20 = 3;
            JavaVersion r21 = new AnonymousClass4(r19, r20);
            JAVA9 = r21;
            $VALUES = new JavaVersion[]{r12, r15, r18, r21};
            if (AnnotatedElement.class.isAssignableFrom(TypeVariable.class) == false) goto L9;
            if (new AnonymousClass5().capture().toString().contains("java.util.Map.java.util.Map") == false) goto L7;
            CURRENT = r18;
            return;
        L7:
            CURRENT = r21;
            return;
        L9:
            if ((new AnonymousClass6().capture() instanceof Class) == false) goto L11;
            CURRENT = r15;
            return;
        L11:
            CURRENT = r12;
        }

        private JavaVersion(String r10, int r11) {
            super(r10, r11);
        }

        public static JavaVersion valueOf(String r10) {
            return (JavaVersion) Enum.valueOf(JavaVersion.class, r10);
        }

        public static JavaVersion[] values() {
            return (JavaVersion[]) $VALUES.clone();
        }

        public boolean jdkTypeDuplicatesOwnerName() {
            return true;
        }

        public abstract Type newArrayType(Type r10);

        public String typeName(Type r10) {
            return Types.toString(r10);
        }

        public final ImmutableList<Type> usedInGenericType(Type[] r10) {
            ImmutableList.Builder r11 = ImmutableList.builder();
            int r12 = r10.length;
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L6;
            r11.add(usedInGenericType(r10[r13]));
            r13 = r13 + 1;
            goto L3
        L6:
            return r11.build();
        }

        public abstract Type usedInGenericType(Type r10);

        public /* synthetic */ JavaVersion(String r10, int r11, AnonymousClass1 r12) {
            this(r10, r11);
        }
    }

    public static final class NativeTypeVariableEquals<X> {
        static final boolean NATIVE_TYPE_VARIABLE_ONLY = false;

        static {
            NATIVE_TYPE_VARIABLE_ONLY = !NativeTypeVariableEquals.class.getTypeParameters()[0].equals(Types.newArtificialTypeVariable(NativeTypeVariableEquals.class, "X", new Type[0]));
        }

        public NativeTypeVariableEquals() {
        }
    }

    public static final class ParameterizedTypeImpl implements ParameterizedType, Serializable {
        private static final long serialVersionUID = 0;
        private final ImmutableList<Type> argumentsList;

        @NullableDecl
        private final Type ownerType;
        private final Class<?> rawType;

        public ParameterizedTypeImpl(@NullableDecl Type r10, Class<?> r11, Type[] r12) {
            Preconditions.checkNotNull(r11);
            if (r12.length != r11.getTypeParameters().length) goto L5;
            boolean r13 = true;
        L6:
            Preconditions.checkArgument(r13);
            Types.access$200(r12, "type parameter");
            this.ownerType = r10;
            this.rawType = r11;
            this.argumentsList = JavaVersion.CURRENT.usedInGenericType(r12);
            return;
        L5:
            r13 = false;
            goto L6
        }

        public boolean equals(Object r10) {
            if ((r10 instanceof ParameterizedType) == true) goto L5;
            return false;
        L5:
            ParameterizedType r11 = (ParameterizedType) r10;
            if (getRawType().equals(r11.getRawType()) == true) goto L8;
            return false;
        L8:
            if (Objects.equal(getOwnerType(), r11.getOwnerType()) == true) goto L10;
            return false;
        L10:
            if (Arrays.equals(getActualTypeArguments(), r11.getActualTypeArguments()) == false) goto L15;
            return true;
        L15:
            return false;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return Types.access$300(this.argumentsList);
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.ownerType;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.rawType;
        }

        public int hashCode() {
            Type r10 = this.ownerType;
            if (r10 != null) goto L5;
            int r11 = 0;
        L6:
            int r12 = r11 ^ this.argumentsList.hashCode();
            return this.rawType.hashCode() ^ r12;
        L5:
            r11 = r10.hashCode();
            goto L6
        }

        public String toString() {
            StringBuilder r10 = new StringBuilder();
            if (this.ownerType == null) goto L7;
            JavaVersion r11 = JavaVersion.CURRENT;
            if (r11.jdkTypeDuplicatesOwnerName() == false) goto L7;
            r10.append(r11.typeName(this.ownerType));
            r10.append('.');
        L7:
            r10.append(this.rawType.getName());
            r10.append('<');
            r10.append(Types.access$500().join(Iterables.transform(this.argumentsList, Types.access$400())));
            r10.append('>');
            return r10.toString();
        }
    }

    public static final class TypeVariableImpl<D extends GenericDeclaration> {
        private final ImmutableList<Type> bounds;
        private final D genericDeclaration;
        private final String name;

        public TypeVariableImpl(D r10, String r11, Type[] r12) {
            Types.access$200(r12, "bound for type variable");
            this.genericDeclaration = (D) Preconditions.checkNotNull(r10);
            this.name = (String) Preconditions.checkNotNull(r11);
            this.bounds = ImmutableList.copyOf(r12);
        }

        public boolean equals(Object r10) {
            if (NativeTypeVariableEquals.NATIVE_TYPE_VARIABLE_ONLY == false) goto L20;
            if (r10 != null) goto L6;
        L18:
            return false;
        L6:
            if (Proxy.isProxyClass(r10.getClass()) == false) goto L18;
            if ((Proxy.getInvocationHandler(r10) instanceof TypeVariableInvocationHandler) == false) goto L18;
            TypeVariableImpl r11 = TypeVariableInvocationHandler.access$600((TypeVariableInvocationHandler) Proxy.getInvocationHandler(r10));
            if (this.name.equals(r11.getName()) == false) goto L17;
            if (this.genericDeclaration.equals(r11.getGenericDeclaration()) == false) goto L17;
            if (this.bounds.equals(r11.bounds) == false) goto L17;
            return true;
        L17:
            return false;
        L20:
            if ((r10 instanceof TypeVariable) == false) goto L28;
            TypeVariable r12 = (TypeVariable) r10;
            if (this.name.equals(r12.getName()) == false) goto L27;
            if (this.genericDeclaration.equals(r12.getGenericDeclaration()) == false) goto L27;
            return true;
        L27:
            return false;
        L28:
            return false;
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

        public int hashCode() {
            int r10 = this.genericDeclaration.hashCode();
            return this.name.hashCode() ^ r10;
        }

        public String toString() {
            return this.name;
        }
    }

    public static final class TypeVariableInvocationHandler implements InvocationHandler {
        private static final ImmutableMap<String, Method> typeVariableMethods = null;
        private final TypeVariableImpl<?> typeVariableImpl;

        static {
            ImmutableMap.Builder r10 = ImmutableMap.builder();
            Method[] r11 = TypeVariableImpl.class.getMethods();
            int r12 = r11.length;
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L10;
            Method r14 = r11[r13];
            if (r14.getDeclaringClass().equals(TypeVariableImpl.class) == false) goto L9;
            r14.setAccessible(true);     // Catch: AccessControlException -> L12
        L8:
            r10.put(r14.getName(), r14);
        L9:
            r13 = r13 + 1;
            goto L3
        L10:
            typeVariableMethods = r10.build();
        }

        public TypeVariableInvocationHandler(TypeVariableImpl<?> r10) {
            this.typeVariableImpl = r10;
        }

        public static /* synthetic */ TypeVariableImpl access$600(TypeVariableInvocationHandler r10) {
            return r10.typeVariableImpl;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object r10, Method r11, Object[] r12) throws Throwable {
            String r13 = r11.getName();
            Method r14 = typeVariableMethods.get(r13);
            if (r14 == null) goto L10;
            return r14.invoke(this.typeVariableImpl, r12);
        L6:
            e = move-exception;
            throw e.getCause();
        L10:
            throw new UnsupportedOperationException(r13);
        }
    }

    public static final class WildcardTypeImpl implements WildcardType, Serializable {
        private static final long serialVersionUID = 0;
        private final ImmutableList<Type> lowerBounds;
        private final ImmutableList<Type> upperBounds;

        public WildcardTypeImpl(Type[] r10, Type[] r11) {
            Types.access$200(r10, "lower bound for wildcard");
            Types.access$200(r11, "upper bound for wildcard");
            JavaVersion r12 = JavaVersion.CURRENT;
            this.lowerBounds = r12.usedInGenericType(r10);
            this.upperBounds = r12.usedInGenericType(r11);
        }

        public boolean equals(Object r10) {
            if ((r10 instanceof WildcardType) == false) goto L10;
            WildcardType r11 = (WildcardType) r10;
            if (this.lowerBounds.equals(Arrays.asList(r11.getLowerBounds())) == true) goto L7;
            return false;
        L7:
            if (this.upperBounds.equals(Arrays.asList(r11.getUpperBounds())) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            return Types.access$300(this.lowerBounds);
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return Types.access$300(this.upperBounds);
        }

        public int hashCode() {
            int r10 = this.lowerBounds.hashCode();
            return this.upperBounds.hashCode() ^ r10;
        }

        public String toString() {
            StringBuilder r10 = new StringBuilder("?");
            UnmodifiableIterator<Type> r11 = this.lowerBounds.iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            Type r12 = r11.next();
            r10.append(" super ");
            r10.append(JavaVersion.CURRENT.typeName(r12));
            goto L4
        L6:
            Iterator r13 = Types.access$700(this.upperBounds).iterator();
        L8:
            if (r13.hasNext() == false) goto L11;
            Type r14 = (Type) r13.next();
            r10.append(" extends ");
            r10.append(JavaVersion.CURRENT.typeName(r14));
            goto L8
        L11:
            return r10.toString();
        }
    }

    static {
        TYPE_NAME = new AnonymousClass1();
        COMMA_JOINER = Joiner.on(", ").useForNull("null");
    }

    private Types() {
    }

    public static /* synthetic */ Type access$100(Type[] r10) {
        return subtypeOfComponentType(r10);
    }

    public static /* synthetic */ void access$200(Type[] r10, String r11) {
        disallowPrimitiveType(r10, r11);
    }

    public static /* synthetic */ Type[] access$300(Collection r10) {
        return toArray(r10);
    }

    public static /* synthetic */ Function access$400() {
        return TYPE_NAME;
    }

    public static /* synthetic */ Joiner access$500() {
        return COMMA_JOINER;
    }

    public static /* synthetic */ Iterable access$700(Iterable r10) {
        return filterUpperBounds(r10);
    }

    private static void disallowPrimitiveType(Type[] r10, String r11) {
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        Type r14 = r10[r13];
        if ((r14 instanceof Class) == false) goto L7;
        Class r15 = (Class) r14;
        Preconditions.checkArgument(!r15.isPrimitive(), "Primitive type '%s' used as %s", r15, r11);
    L7:
        r13 = r13 + 1;
        goto L3
    }

    private static Iterable<Type> filterUpperBounds(Iterable<Type> r10) {
        return Iterables.filter(r10, Predicates.not(Predicates.equalTo(Object.class)));
    }

    public static Class<?> getArrayClass(Class<?> r10) {
        return Array.newInstance(r10, 0).getClass();
    }

    @NullableDecl
    public static Type getComponentType(Type r10) {
        Preconditions.checkNotNull(r10);
        final AtomicReference r11 = new AtomicReference();
        new AnonymousClass2(r11).visit(new Type[]{r10});
        return (Type) r11.get();
    }

    public static Type newArrayType(Type r10) {
        if ((r10 instanceof WildcardType) == false) goto L19;
        WildcardType r11 = (WildcardType) r10;
        Type[] r12 = r11.getLowerBounds();
        boolean r13 = true;
        if (r12.length > 1) goto L7;
        boolean r14 = true;
    L8:
        Preconditions.checkArgument(r14, "Wildcard cannot have more than one lower bounds.");
        if (r12.length == 1) goto L11;
        Type[] r15 = r11.getUpperBounds();
        if (r15.length == 1) goto L16;
        r13 = false;
    L16:
        Preconditions.checkArgument(r13, "Wildcard should have only one upper bound.");
        return subtypeOf(newArrayType(r15[0]));
    L11:
        return supertypeOf(newArrayType(r12[0]));
    L7:
        r14 = false;
        goto L8
    L19:
        return JavaVersion.CURRENT.newArrayType(r10);
    }

    public static <D extends GenericDeclaration> TypeVariable<D> newArtificialTypeVariable(D r10, String r11, Type... r12) {
        if (r12.length != 0) goto L6;
        r12 = new Type[]{Object.class};
    L6:
        return newTypeVariableImpl(r10, r11, r12);
    }

    public static ParameterizedType newParameterizedType(Class<?> r10, Type... r11) {
        return new ParameterizedTypeImpl(ClassOwnership.JVM_BEHAVIOR.getOwnerType(r10), r10, r11);
    }

    public static ParameterizedType newParameterizedTypeWithOwner(@NullableDecl Type r10, Class<?> r11, Type... r12) {
        if (r10 == null) goto L4;
        Preconditions.checkNotNull(r12);
        if (r11.getEnclosingClass() == null) goto L8;
        boolean r13 = true;
    L9:
        Preconditions.checkArgument(r13, "Owner type for unenclosed %s", r11);
        return new ParameterizedTypeImpl(r10, r11, r12);
    L8:
        r13 = false;
        goto L9
    L4:
        return newParameterizedType(r11, r12);
    }

    private static <D extends GenericDeclaration> TypeVariable<D> newTypeVariableImpl(D r10, String r11, Type[] r12) {
        return (TypeVariable) Reflection.newProxy(TypeVariable.class, new TypeVariableInvocationHandler(new TypeVariableImpl(r10, r11, r12)));
    }

    @VisibleForTesting
    public static WildcardType subtypeOf(Type r10) {
        return new WildcardTypeImpl(new Type[0], new Type[]{r10});
    }

    @NullableDecl
    private static Type subtypeOfComponentType(Type[] r10) {
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L14;
        Type r13 = getComponentType(r10[r12]);
        if (r13 != null) goto L7;
        r12 = r12 + 1;
        goto L3
    L7:
        if ((r13 instanceof Class) == false) goto L12;
        Class r14 = (Class) r13;
        if (r14.isPrimitive() == false) goto L12;
        return r14;
    L12:
        return subtypeOf(r13);
    L14:
        return null;
    }

    @VisibleForTesting
    public static WildcardType supertypeOf(Type r10) {
        return new WildcardTypeImpl(new Type[]{r10}, new Type[]{Object.class});
    }

    private static Type[] toArray(Collection<Type> r10) {
        return (Type[]) r10.toArray(new Type[r10.size()]);
    }

    public static String toString(Type r10) {
        if ((r10 instanceof Class) == false) goto L6;
        return ((Class) r10).getName();
    L6:
        return r10.toString();
    }
}
