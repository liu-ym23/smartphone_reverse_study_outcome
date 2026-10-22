package com.fasterxml.jackson.databind.h;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.aa;
import com.fasterxml.jackson.databind.h.g;
import com.fasterxml.jackson.databind.k;
import java.util.Collection;

/* JADX INFO: compiled from: TypeResolverBuilder.java */
/* JADX INFO: loaded from: classes2.dex */
public interface g<T extends g<T>> {
    e a(com.fasterxml.jackson.databind.g r1, k r2, Collection<b> r3);

    T a(JsonTypeInfo.As r1);

    T a(JsonTypeInfo.Id r1, f r2);

    T a(Class<?> r1);

    T a(String r1);

    T a(boolean r1);

    h a(aa r1, k r2, Collection<b> r3);

    Class<?> a();

    default T b(Class<?> r1) {
        return (T) a(r1);
    }
}
