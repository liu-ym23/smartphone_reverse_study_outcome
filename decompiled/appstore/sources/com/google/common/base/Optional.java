package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(serializable = true)
public abstract class Optional<T> implements Serializable {
    private static final long serialVersionUID = 0;

    public Optional() {
    }

    public static <T> Optional<T> absent() {
        return Absent.withType();
    }

    public static <T> Optional<T> fromNullable(@NullableDecl T r10) {
        if (r10 != null) goto L5;
        return absent();
    L5:
        return new Present(r10);
    }

    public static <T> Optional<T> of(T r10) {
        return new Present(Preconditions.checkNotNull(r10));
    }

    @Beta
    public static <T> Iterable<T> presentInstances(final Iterable<? extends Optional<? extends T>> r10) {
        Preconditions.checkNotNull(r10);
        return new AnonymousClass1(r10);
    }

    public abstract Set<T> asSet();

    public abstract boolean equals(@NullableDecl Object r10);

    public abstract T get();

    public abstract int hashCode();

    public abstract boolean isPresent();

    public abstract Optional<T> or(Optional<? extends T> r10);

    @Beta
    public abstract T or(Supplier<? extends T> r10);

    public abstract T or(T r10);

    @NullableDecl
    public abstract T orNull();

    public abstract String toString();

    public abstract <V> Optional<V> transform(Function<? super T, V> r10);
}
