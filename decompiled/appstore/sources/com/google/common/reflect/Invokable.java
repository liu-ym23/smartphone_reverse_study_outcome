package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
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
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@Beta
public abstract class Invokable<T, R> extends Element implements GenericDeclaration {

    public static class ConstructorInvokable<T> extends Invokable<T, T> {
        final Constructor<?> constructor;

        public ConstructorInvokable(Constructor<?> r10) {
            super(r10);
            this.constructor = r10;
        }

        private boolean mayNeedHiddenThis() {
            Class<?> r10 = this.constructor.getDeclaringClass();
            if (r10.getEnclosingConstructor() == null) goto L5;
            return true;
        L5:
            Method r11 = r10.getEnclosingMethod();
            if (r11 == null) goto L10;
            return !Modifier.isStatic(r11.getModifiers());
        L10:
            if (r10.getEnclosingClass() != null) goto L12;
        L14:
            return false;
        L12:
            if (Modifier.isStatic(r10.getModifiers()) == true) goto L14;
            return true;
        }

        @Override // com.google.common.reflect.Invokable
        public Type[] getGenericExceptionTypes() {
            return this.constructor.getGenericExceptionTypes();
        }

        @Override // com.google.common.reflect.Invokable
        public Type[] getGenericParameterTypes() {
            Type[] r10 = this.constructor.getGenericParameterTypes();
            if (r10.length > 0) goto L5;
        L12:
            return r10;
        L5:
            if (mayNeedHiddenThis() == false) goto L12;
            Class<?>[] r11 = this.constructor.getParameterTypes();
            if (r10.length != r11.length) goto L12;
            if (r11[0] != getDeclaringClass().getEnclosingClass()) goto L12;
            return (Type[]) Arrays.copyOfRange(r10, 1, r10.length);
        }

        @Override // com.google.common.reflect.Invokable
        public Type getGenericReturnType() {
            Class<? super T> r10 = getDeclaringClass();
            TypeVariable<Class<? super T>>[] r11 = r10.getTypeParameters();
            if (r11.length > 0) goto L5;
            return r10;
        L5:
            return Types.newParameterizedType(r10, r11);
        }

        @Override // com.google.common.reflect.Invokable
        public final Annotation[][] getParameterAnnotations() {
            return this.constructor.getParameterAnnotations();
        }

        @Override // java.lang.reflect.GenericDeclaration
        public final TypeVariable<?>[] getTypeParameters() {
            TypeVariable<Class<? super T>>[] r10 = getDeclaringClass().getTypeParameters();
            TypeVariable<Constructor<?>>[] r11 = this.constructor.getTypeParameters();
            TypeVariable<?>[] r12 = new TypeVariable[r10.length + r11.length];
            System.arraycopy(r10, 0, r12, 0, r10.length);
            System.arraycopy(r11, 0, r12, r10.length, r11.length);
            return r12;
        }

        @Override // com.google.common.reflect.Invokable
        public final Object invokeInternal(@NullableDecl Object r10, Object[] r11) throws InvocationTargetException, IllegalAccessException {
            return this.constructor.newInstance(r11);
        L4:
            e = move-exception;
            throw new RuntimeException(this.constructor + " failed.", e);
        }

        @Override // com.google.common.reflect.Invokable
        public final boolean isOverridable() {
            return false;
        }

        @Override // com.google.common.reflect.Invokable
        public final boolean isVarArgs() {
            return this.constructor.isVarArgs();
        }
    }

    public static class MethodInvokable<T> extends Invokable<T, Object> {
        final Method method;

        public MethodInvokable(Method r10) {
            super(r10);
            this.method = r10;
        }

        @Override // com.google.common.reflect.Invokable
        public Type[] getGenericExceptionTypes() {
            return this.method.getGenericExceptionTypes();
        }

        @Override // com.google.common.reflect.Invokable
        public Type[] getGenericParameterTypes() {
            return this.method.getGenericParameterTypes();
        }

        @Override // com.google.common.reflect.Invokable
        public Type getGenericReturnType() {
            return this.method.getGenericReturnType();
        }

        @Override // com.google.common.reflect.Invokable
        public final Annotation[][] getParameterAnnotations() {
            return this.method.getParameterAnnotations();
        }

        @Override // java.lang.reflect.GenericDeclaration
        public final TypeVariable<?>[] getTypeParameters() {
            return this.method.getTypeParameters();
        }

        @Override // com.google.common.reflect.Invokable
        public final Object invokeInternal(@NullableDecl Object r10, Object[] r11) throws InvocationTargetException, IllegalAccessException {
            return this.method.invoke(r10, r11);
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

    public <M extends AccessibleObject & Member> Invokable(M r10) {
        super(r10);
    }

    public static Invokable<?, Object> from(Method r10) {
        return new MethodInvokable(r10);
    }

    @Override // com.google.common.reflect.Element
    public /* bridge */ /* synthetic */ boolean equals(@NullableDecl Object r10) {
        return super.equals(r10);
    }

    @Override // com.google.common.reflect.Element, java.lang.reflect.Member
    public final Class<? super T> getDeclaringClass() {
        return (Class<? super T>) super.getDeclaringClass();
    }

    public final ImmutableList<TypeToken<? extends Throwable>> getExceptionTypes() {
        ImmutableList.Builder r10 = ImmutableList.builder();
        Type[] r11 = getGenericExceptionTypes();
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L6;
        r10.add(TypeToken.of(r11[r13]));
        r13 = r13 + 1;
        goto L3
    L6:
        return r10.build();
    }

    public abstract Type[] getGenericExceptionTypes();

    public abstract Type[] getGenericParameterTypes();

    public abstract Type getGenericReturnType();

    @Override // com.google.common.reflect.Element
    public TypeToken<T> getOwnerType() {
        return TypeToken.of(getDeclaringClass());
    }

    public abstract Annotation[][] getParameterAnnotations();

    public final ImmutableList<Parameter> getParameters() {
        Type[] r10 = getGenericParameterTypes();
        Annotation[][] r11 = getParameterAnnotations();
        ImmutableList.Builder r12 = ImmutableList.builder();
        int r13 = 0;
    L4:
        if (r13 >= r10.length) goto L7;
        r12.add(new Parameter(this, r13, TypeToken.of(r10[r13]), r11[r13]));
        r13 = r13 + 1;
        goto L4
    L7:
        return r12.build();
    }

    public final TypeToken<? extends R> getReturnType() {
        return (TypeToken<? extends R>) TypeToken.of(getGenericReturnType());
    }

    @Override // com.google.common.reflect.Element
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @CanIgnoreReturnValue
    public final R invoke(@NullableDecl T r10, Object... r11) throws InvocationTargetException, IllegalAccessException {
        return (R) invokeInternal(r10, (Object[]) Preconditions.checkNotNull(r11));
    }

    public abstract Object invokeInternal(@NullableDecl Object r10, Object[] r11) throws InvocationTargetException, IllegalAccessException;

    public abstract boolean isOverridable();

    public abstract boolean isVarArgs();

    public final <R1 extends R> Invokable<T, R1> returning(Class<R1> r10) {
        return returning(TypeToken.of(r10));
    }

    @Override // com.google.common.reflect.Element
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public static <T> Invokable<T, T> from(Constructor<T> r10) {
        return new ConstructorInvokable(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R1 extends R> Invokable<T, R1> returning(TypeToken<R1> r10) {
        if (r10.isSupertypeOf(getReturnType()) == false) goto L6;
        return this;
    L6:
        throw new IllegalArgumentException("Invokable is known to return " + getReturnType() + ", not " + r10);
    }
}
