package androidx.camera.core.impl.utils;

import androidx.core.util.Preconditions;
import androidx.core.util.Supplier;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Optional<T> implements Serializable {
    private static final long serialVersionUID = 0;

    public abstract boolean equals(Object r100);

    public abstract T get();

    public abstract int hashCode();

    public abstract boolean isPresent();

    public abstract Optional<T> or(Optional<? extends T> r100);

    public abstract T or(Supplier<? extends T> r100);

    public abstract T or(T r100);

    public abstract T orNull();

    public abstract String toString();

    public static <T> Optional<T> absent() {
        return Absent.withType();
    }

    public Optional() {
    }

    public static <T> Optional<T> fromNullable(T r100) {
        if (r100 != null) goto L5;
        return absent();
    L5:
        return new Present(r100);
    }

    public static <T> Optional<T> of(T r100) {
        return new Present(Preconditions.checkNotNull(r100));
    }
}
