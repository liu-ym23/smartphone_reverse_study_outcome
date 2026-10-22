package com.google.common.base;

import java.io.Serializable;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Optional<T> implements Serializable {
    private static final long serialVersionUID = 0;

    public abstract Set<T> asSet();

    public abstract boolean equals(@Nullable Object r1);

    public abstract T get();

    public abstract int hashCode();

    public abstract boolean isPresent();

    public abstract Optional<T> or(Optional<? extends T> r1);

    public abstract T or(Supplier<? extends T> r1);

    public abstract T or(T r1);

    @Nullable
    public abstract T orNull();

    public abstract String toString();

    public abstract <V> Optional<V> transform(Function<? super T, V> r1);

    public static <T> Optional<T> absent() {
        return Absent.withType();
    }

    public static <T> Optional<T> of(T r1) {
        return new Present(Preconditions.checkNotNull(r1));
    }

    public static <T> Optional<T> fromNullable(@Nullable T r1) {
        if (r1 != null) goto L5;
        return absent();
    L5:
        return new Present(r1);
    }

    Optional() {
    }

    public static <T> Iterable<T> presentInstances(final Iterable<? extends Optional<? extends T>> r1) {
        Preconditions.checkNotNull(r1);
        return new AnonymousClass1(r1);
    }
}
