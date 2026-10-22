package reactor.core;

import java.util.Collection;
import java.util.function.Supplier;
import reactor.util.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
@FunctionalInterface
/* loaded from: classes.dex */
public interface Disposable {

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
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

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public interface Swap extends Disposable, Supplier<Disposable> {
        boolean replace(@Nullable Disposable disposable);

        boolean update(@Nullable Disposable disposable);
    }

    void dispose();

    default boolean isDisposed() {
        return false;
    }
}
