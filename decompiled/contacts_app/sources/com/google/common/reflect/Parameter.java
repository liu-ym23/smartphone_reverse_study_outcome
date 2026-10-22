package com.google.common.reflect;

import com.google.common.base.Preconditions;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class Parameter implements AnnotatedElement {
    private final ImmutableList<Annotation> annotations;
    private final Invokable<?, ?> declaration;
    private final int position;
    private final TypeToken<?> type;

    Parameter(Invokable<?, ?> r1, int r2, TypeToken<?> r3, Annotation[] r4) {
        this.declaration = r1;
        this.position = r2;
        this.type = r3;
        this.annotations = ImmutableList.copyOf(r4);
    }

    public TypeToken<?> getType() {
        return this.type;
    }

    public Invokable<?, ?> getDeclaringInvokable() {
        return this.declaration;
    }

    @Override // java.lang.reflect.AnnotatedElement
    public boolean isAnnotationPresent(Class<? extends Annotation> r1) {
        if (getAnnotation(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.lang.reflect.AnnotatedElement
    @Nullable
    public <A extends Annotation> A getAnnotation(Class<A> r3) {
        Preconditions.checkNotNull(r3);
        UnmodifiableIterator<Annotation> r2 = this.annotations.iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        Annotation r0 = r2.next();
        if (r3.isInstance(r0) == false) goto L4;
        return r3.cast(r0);
    L9:
        return null;
    }

    @Override // java.lang.reflect.AnnotatedElement
    public Annotation[] getAnnotations() {
        return getDeclaredAnnotations();
    }

    @Override // java.lang.reflect.AnnotatedElement
    public <A extends Annotation> A[] getAnnotationsByType(Class<A> r1) {
        return (A[]) getDeclaredAnnotationsByType(r1);
    }

    @Override // java.lang.reflect.AnnotatedElement
    public Annotation[] getDeclaredAnnotations() {
        ImmutableList<Annotation> r1 = this.annotations;
        return (Annotation[]) r1.toArray(new Annotation[r1.size()]);
    }

    @Override // java.lang.reflect.AnnotatedElement
    @Nullable
    public <A extends Annotation> A getDeclaredAnnotation(Class<A> r1) {
        Preconditions.checkNotNull(r1);
        return (A) FluentIterable.from(this.annotations).filter(r1).first().orNull();
    }

    @Override // java.lang.reflect.AnnotatedElement
    public <A extends Annotation> A[] getDeclaredAnnotationsByType(Class<A> r1) {
        return (A[]) ((Annotation[]) FluentIterable.from(this.annotations).filter(r1).toArray(r1));
    }

    public boolean equals(@Nullable Object r4) {
        if ((r4 instanceof Parameter) == false) goto L10;
        Parameter r5 = (Parameter) r4;
        if (this.position == r5.position) goto L7;
        return false;
    L7:
        if (this.declaration.equals(r5.declaration) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public int hashCode() {
        return this.position;
    }

    public String toString() {
        return this.type + " arg" + this.position;
    }
}
