package com.google.common.base;

import java.util.Collections;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
final class Absent<T> extends Optional<T> {
    static final Absent<Object> INSTANCE = null;
    private static final long serialVersionUID = 0;

    @Override // com.google.common.base.Optional
    public boolean equals(@Nullable Object r1) {
        if (r1 != this) goto L4;
        return true;
    L4:
        return false;
    }

    @Override // com.google.common.base.Optional
    public int hashCode() {
        return 1502476572;
    }

    @Override // com.google.common.base.Optional
    public boolean isPresent() {
        return false;
    }

    @Override // com.google.common.base.Optional
    @Nullable
    public T orNull() {
        return null;
    }

    @Override // com.google.common.base.Optional
    public String toString() {
        return "Optional.absent()";
    }

    static {
        INSTANCE = new Absent();
    }

    static <T> Optional<T> withType() {
        return INSTANCE;
    }

    private Absent() {
    }

    @Override // com.google.common.base.Optional
    public T get() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    @Override // com.google.common.base.Optional
    public T or(T r1) {
        return (T) Preconditions.checkNotNull(r1, "use Optional.orNull() instead of Optional.or(null)");
    }

    @Override // com.google.common.base.Optional
    public Optional<T> or(Optional<? extends T> r1) {
        return (Optional) Preconditions.checkNotNull(r1);
    }

    @Override // com.google.common.base.Optional
    public T or(Supplier<? extends T> r1) {
        return (T) Preconditions.checkNotNull(r1.get(), "use Optional.orNull() instead of a Supplier that returns null");
    }

    @Override // com.google.common.base.Optional
    public Set<T> asSet() {
        return Collections.emptySet();
    }

    @Override // com.google.common.base.Optional
    public <V> Optional<V> transform(Function<? super T, V> r1) {
        Preconditions.checkNotNull(r1);
        return Optional.absent();
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
