package com.fasterxml.jackson.databind.l;

import java.lang.annotation.Annotation;

/* JADX INFO: compiled from: Annotations.java */
/* JADX INFO: loaded from: classes2.dex */
public interface b {
    int a();

    <A extends Annotation> A a(Class<A> r1);

    boolean a(Class<? extends Annotation>[] r1);

    boolean b(Class<?> r1);
}
