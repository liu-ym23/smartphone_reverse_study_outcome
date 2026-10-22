package com.fasterxml.jackson.databind.e;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

/* JADX INFO: compiled from: Annotated.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b {
    public abstract <A extends Annotation> A a(Class<A> r1);

    public abstract AnnotatedElement a();

    public abstract boolean a(Class<? extends Annotation>[] r1);

    public abstract String b();

    public abstract boolean b(Class<?> r1);

    public abstract Class<?> c();

    public abstract boolean equals(Object r1);

    public abstract com.fasterxml.jackson.databind.k getType();

    public abstract int hashCode();

    public abstract String toString();

    public b() {
    }
}
