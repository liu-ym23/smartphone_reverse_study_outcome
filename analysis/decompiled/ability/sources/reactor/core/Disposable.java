package reactor.core;

import java.util.Collection;
import java.util.function.Supplier;
import reactor.util.annotation.Nullable;

@FunctionalInterface
/* loaded from: classes4.dex */
public interface Disposable {

    public interface Composite extends Disposable {
        boolean add(Disposable disposable);

        default boolean addAll(Collection<? extends Disposable> collection) {
            boolean zIsDisposed = isDisposed();
            for (Disposable disposable : collection) {
                if (zIsDisposed) {
                    disposable.dispose();
                } else {
                    zIsDisposed = !add(disposable);
                }
            }
            return !zIsDisposed;
        }

        @Override // reactor.core.Disposable
        void dispose();

        @Override // reactor.core.Disposable
        boolean isDisposed();

        boolean remove(Disposable disposable);

        int size();
    }

    public interface Swap extends Disposable, Supplier<Disposable> {
        boolean replace(@Nullable Disposable disposable);

        boolean update(@Nullable Disposable disposable);
    }

    void dispose();

    default boolean isDisposed() {
        return false;
    }
}
