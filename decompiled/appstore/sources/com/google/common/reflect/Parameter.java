package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@Beta
public final class Parameter implements AnnotatedElement {
    private final ImmutableList<Annotation> annotations;
    private final Invokable<?, ?> declaration;
    private final int position;
    private final TypeToken<?> type;

    public Parameter(Invokable<?, ?> r10, int r11, TypeToken<?> r12, Annotation[] r13) {
        this.declaration = r10;
        this.position = r11;
        this.type = r12;
        this.annotations = ImmutableList.copyOf(r13);
    }

    public boolean equals(@NullableDecl Object r10) {
        if ((r10 instanceof Parameter) == false) goto L10;
        Parameter r11 = (Parameter) r10;
        if (this.position == r11.position) goto L7;
        return false;
    L7:
        if (this.declaration.equals(r11.declaration) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    @Override // java.lang.reflect.AnnotatedElement
    @NullableDecl
    public <A extends Annotation> A getAnnotation(Class<A> r10) {
        Preconditions.checkNotNull(r10);
        UnmodifiableIterator<Annotation> r11 = this.annotations.iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        Annotation r12 = r11.next();
        if (r10.isInstance(r12) == false) goto L4;
        return r10.cast(r12);
    L9:
        return null;
    }

    @Override // java.lang.reflect.AnnotatedElement
    public Annotation[] getAnnotations() {
        return getDeclaredAnnotations();
    }

    @Override // java.lang.reflect.AnnotatedElement
    public <A extends Annotation> A[] getAnnotationsByType(Class<A> r10) {
        return (A[]) getDeclaredAnnotationsByType(r10);
    }

    @Override // java.lang.reflect.AnnotatedElement
    @NullableDecl
    public <A extends Annotation> A getDeclaredAnnotation(Class<A> r10) {
        Preconditions.checkNotNull(r10);
        return (A) FluentIterable.from(this.annotations).filter(r10).first().orNull();
    }

    @Override // java.lang.reflect.AnnotatedElement
    public Annotation[] getDeclaredAnnotations() {
        ImmutableList<Annotation> r10 = this.annotations;
        return (Annotation[]) r10.toArray(new Annotation[r10.size()]);
    }

    @Override // java.lang.reflect.AnnotatedElement
    public <A extends Annotation> A[] getDeclaredAnnotationsByType(Class<A> r10) {
        return (A[]) ((Annotation[]) FluentIterable.from(this.annotations).filter(r10).toArray(r10));
    }

    public Invokable<?, ?> getDeclaringInvokable() {
        return this.declaration;
    }

    public TypeToken<?> getType() {
        return this.type;
    }

    public int hashCode() {
        return this.position;
    }

    @Override // java.lang.reflect.AnnotatedElement
    public boolean isAnnotationPresent(Class<? extends Annotation> r10) {
        if (getAnnotation(r10) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        return this.type + " arg" + this.position;
    }
}
