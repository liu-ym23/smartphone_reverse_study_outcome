package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.util.Collections;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
final class Absent<T> extends Optional<T> {
    static final Absent<Object> INSTANCE = null;
    private static final long serialVersionUID = 0;

    static {
        INSTANCE = new Absent();
    }

    private Absent() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    public static <T> Optional<T> withType() {
        return INSTANCE;
    }

    @Override // com.google.common.base.Optional
    public Set<T> asSet() {
        return Collections.emptySet();
    }

    @Override // com.google.common.base.Optional
    public boolean equals(@NullableDecl Object r10) {
        if (r10 != this) goto L4;
        return true;
    L4:
        return false;
    }

    @Override // com.google.common.base.Optional
    public T get() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    @Override // com.google.common.base.Optional
    public int hashCode() {
        return 2040732332;
    }

    @Override // com.google.common.base.Optional
    public boolean isPresent() {
        return false;
    }

    @Override // com.google.common.base.Optional
    public T or(T r10) {
        return (T) Preconditions.checkNotNull(r10, "use Optional.orNull() instead of Optional.or(null)");
    }

    @Override // com.google.common.base.Optional
    @NullableDecl
    public T orNull() {
        return null;
    }

    @Override // com.google.common.base.Optional
    public String toString() {
        return "Optional.absent()";
    }

    @Override // com.google.common.base.Optional
    public <V> Optional<V> transform(Function<? super T, V> r10) {
        Preconditions.checkNotNull(r10);
        return Optional.absent();
    }

    @Override // com.google.common.base.Optional
    public Optional<T> or(Optional<? extends T> r10) {
        return (Optional) Preconditions.checkNotNull(r10);
    }

    @Override // com.google.common.base.Optional
    public T or(Supplier<? extends T> r10) {
        return (T) Preconditions.checkNotNull(r10.get(), "use Optional.orNull() instead of a Supplier that returns null");
    }
}
