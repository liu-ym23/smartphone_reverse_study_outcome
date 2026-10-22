package com.google.common.reflect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Invokable<T, R> extends Element implements GenericDeclaration {

    static class ConstructorInvokable<T> extends Invokable<T, T> {
        final Constructor<?> constructor;

        @Override // com.google.common.reflect.Invokable
        public final boolean isOverridable() {
            return false;
        }

        ConstructorInvokable(Constructor<?> r1) {
            super(r1);
            this.constructor = r1;
        }

        @Override // com.google.common.reflect.Invokable
        final Object invokeInternal(@Nullable Object r2, Object[] r3) throws InvocationTargetException, IllegalAccessException {
            return this.constructor.newInstance(r3);
        L4:
            e = move-exception;
            throw new RuntimeException(this.constructor + " failed.", e);
        }

        @Override // com.google.common.reflect.Invokable
        Type getGenericReturnType() {
            Class<? super T> r2 = getDeclaringClass();
            TypeVariable<Class<? super T>>[] r0 = r2.getTypeParameters();
            if (r0.length > 0) goto L5;
            return r2;
        L5:
            return Types.newParameterizedType(r2, r0);
        }

        @Override // com.google.common.reflect.Invokable
        Type[] getGenericParameterTypes() {
            Type[] r0 = this.constructor.getGenericParameterTypes();
            if (r0.length > 0) goto L5;
        L12:
            return r0;
        L5:
            if (mayNeedHiddenThis() == false) goto L12;
            Class<?>[] r1 = this.constructor.getParameterTypes();
            if (r0.length != r1.length) goto L12;
            if (r1[0] != getDeclaringClass().getEnclosingClass()) goto L12;
            return (Type[]) Arrays.copyOfRange(r0, 1, r0.length);
        }

        @Override // com.google.common.reflect.Invokable
        Type[] getGenericExceptionTypes() {
            return this.constructor.getGenericExceptionTypes();
        }

        @Override // com.google.common.reflect.Invokable
        final Annotation[][] getParameterAnnotations() {
            return this.constructor.getParameterAnnotations();
        }

        @Override // java.lang.reflect.GenericDeclaration
        public final TypeVariable<?>[] getTypeParameters() {
            TypeVariable<Class<? super T>>[] r0 = getDeclaringClass().getTypeParameters();
            TypeVariable<Constructor<?>>[] r4 = this.constructor.getTypeParameters();
            TypeVariable<?>[] r1 = new TypeVariable[r0.length + r4.length];
            System.arraycopy(r0, 0, r1, 0, r0.length);
            System.arraycopy(r4, 0, r1, r0.length, r4.length);
            return r1;
        }

        @Override // com.google.common.reflect.Invokable
        public final boolean isVarArgs() {
            return this.constructor.isVarArgs();
        }

        private boolean mayNeedHiddenThis() {
            Class<?> r2 = this.constructor.getDeclaringClass();
            if (r2.getEnclosingConstructor() == null) goto L5;
            return true;
        L5:
            Method r0 = r2.getEnclosingMethod();
            if (r0 == null) goto L10;
            return !Modifier.isStatic(r0.getModifiers());
        L10:
            if (r2.getEnclosingClass() != null) goto L12;
        L14:
            return false;
        L12:
            if (Modifier.isStatic(r2.getModifiers()) == true) goto L14;
            return true;
        }
    }

    static class MethodInvokable<T> extends Invokable<T, Object> {
        final Method method;

        MethodInvokable(Method r1) {
            super(r1);
            this.method = r1;
        }

        @Override // com.google.common.reflect.Invokable
        final Object invokeInternal(@Nullable Object r1, Object[] r2) throws InvocationTargetException, IllegalAccessException {
            return this.method.invoke(r1, r2);
        }

        @Override // com.google.common.reflect.Invokable
        Type getGenericReturnType() {
            return this.method.getGenericReturnType();
        }

        @Override // com.google.common.reflect.Invokable
        Type[] getGenericParameterTypes() {
            return this.method.getGenericParameterTypes();
        }

        @Override // com.google.common.reflect.Invokable
        Type[] getGenericExceptionTypes() {
            return this.method.getGenericExceptionTypes();
        }

        @Override // com.google.common.reflect.Invokable
        final Annotation[][] getParameterAnnotations() {
            return this.method.getParameterAnnotations();
        }

        @Override // java.lang.reflect.GenericDeclaration
        public final TypeVariable<?>[] getTypeParameters() {
            return this.method.getTypeParameters();
        }

        @Override // com.google.common.reflect.Invokable
        public final boolean isOverridable() {
            if (isFinal() == false) goto L5;
        L11:
            return false;
        L5:
            if (isPrivate() == true) goto L11;
            if (isStatic() == true) goto L11;
            if (Modifier.isFinal(getDeclaringClass().getModifiers()) == true) goto L11;
            return true;
        }

        @Override // com.google.common.reflect.Invokable
        public final boolean isVarArgs() {
            return this.method.isVarArgs();
        }
    }

    abstract Type[] getGenericExceptionTypes();

    abstract Type[] getGenericParameterTypes();

    abstract Type getGenericReturnType();

    abstract Annotation[][] getParameterAnnotations();

    abstract Object invokeInternal(@Nullable Object r1, Object[] r2) throws InvocationTargetException, IllegalAccessException;

    public abstract boolean isOverridable();

    public abstract boolean isVarArgs();

    @Override // com.google.common.reflect.Element
    public /* bridge */ /* synthetic */ boolean equals(@Nullable Object r1) {
        return super.equals(r1);
    }

    @Override // com.google.common.reflect.Element
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.reflect.Element
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    <M extends AccessibleObject & Member> Invokable(M r1) {
        super(r1);
    }

    public static Invokable<?, Object> from(Method r1) {
        return new MethodInvokable(r1);
    }

    public static <T> Invokable<T, T> from(Constructor<T> r1) {
        return new ConstructorInvokable(r1);
    }

    public final R invoke(@Nullable T r1, Object... r2) throws InvocationTargetException, IllegalAccessException {
        return (R) invokeInternal(r1, (Object[]) Preconditions.checkNotNull(r2));
    }

    public final TypeToken<? extends R> getReturnType() {
        return (TypeToken<? extends R>) TypeToken.of(getGenericReturnType());
    }

    public final ImmutableList<Parameter> getParameters() {
        Type[] r0 = getGenericParameterTypes();
        Annotation[][] r1 = getParameterAnnotations();
        ImmutableList.Builder r2 = ImmutableList.builder();
        int r3 = 0;
    L4:
        if (r3 >= r0.length) goto L7;
        r2.add(new Parameter(this, r3, TypeToken.of(r0[r3]), r1[r3]));
        r3 = r3 + 1;
        goto L4
    L7:
        return r2.build();
    }

    public final ImmutableList<TypeToken<? extends Throwable>> getExceptionTypes() {
        ImmutableList.Builder r0 = ImmutableList.builder();
        Type[] r4 = getGenericExceptionTypes();
        int r1 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L6;
        r0.add(TypeToken.of(r4[r2]));
        r2 = r2 + 1;
        goto L3
    L6:
        return r0.build();
    }

    public final <R1 extends R> Invokable<T, R1> returning(Class<R1> r1) {
        return returning(TypeToken.of(r1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R1 extends R> Invokable<T, R1> returning(TypeToken<R1> r4) {
        if (r4.isAssignableFrom(getReturnType()) == false) goto L6;
        return this;
    L6:
        throw new IllegalArgumentException("Invokable is known to return " + getReturnType() + ", not " + r4);
    }

    @Override // com.google.common.reflect.Element, java.lang.reflect.Member
    public final Class<? super T> getDeclaringClass() {
        return (Class<? super T>) super.getDeclaringClass();
    }

    @Override // com.google.common.reflect.Element
    public TypeToken<T> getOwnerType() {
        return TypeToken.of(getDeclaringClass());
    }
}
