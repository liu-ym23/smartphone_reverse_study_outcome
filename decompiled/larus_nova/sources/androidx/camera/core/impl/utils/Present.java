package androidx.camera.core.impl.utils;

import androidx.core.util.Preconditions;
import androidx.core.util.Supplier;

/* JADX INFO: loaded from: classes2.dex */
final class Present<T> extends Optional<T> {
    private static final long serialVersionUID = 0;
    private final T mReference;

    @Override // androidx.camera.core.impl.utils.Optional
    public boolean isPresent() {
        return true;
    }

    @Override // androidx.camera.core.impl.utils.Optional
    public int hashCode() {
        return this.mReference.hashCode() + 1502476572;
    }

    @Override // androidx.camera.core.impl.utils.Optional
    public String toString() {
        return "Optional.of(" + this.mReference + ")";
    }

    @Override // androidx.camera.core.impl.utils.Optional
    public T get() {
        return this.mReference;
    }

    @Override // androidx.camera.core.impl.utils.Optional
    public T orNull() {
        return this.mReference;
    }

    public Present(T r100) {
        this.mReference = r100;
    }

    @Override // androidx.camera.core.impl.utils.Optional
    public boolean equals(Object r100) {
        if ((r100 instanceof Present) == true) goto L5;
        return false;
    L5:
        return this.mReference.equals(((Present) r100).mReference);
    }

    @Override // androidx.camera.core.impl.utils.Optional
    public T or(T r100) {
        Preconditions.checkNotNull(r100, "use Optional.orNull() instead of Optional.or(null)");
        return this.mReference;
    }

    @Override // androidx.camera.core.impl.utils.Optional
    public T or(Supplier<? extends T> r100) {
        Preconditions.checkNotNull(r100);
        return this.mReference;
    }

    @Override // androidx.camera.core.impl.utils.Optional
    public Optional<T> or(Optional<? extends T> r100) {
        Preconditions.checkNotNull(r100);
        return this;
    }
}
