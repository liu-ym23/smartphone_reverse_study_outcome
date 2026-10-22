package reactor.core.scheduler;

import java.util.Collection;
import reactor.core.Disposable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class EmptyCompositeDisposable implements Disposable.Composite {
    @Override // reactor.core.Disposable.Composite
    public boolean add(Disposable disposable) {
        return false;
    }

    @Override // reactor.core.Disposable.Composite
    public boolean addAll(Collection<? extends Disposable> collection) {
        return false;
    }

    @Override // reactor.core.Disposable.Composite, reactor.core.Disposable
    public boolean isDisposed() {
        return false;
    }

    @Override // reactor.core.Disposable.Composite
    public boolean remove(Disposable disposable) {
        return false;
    }

    @Override // reactor.core.Disposable.Composite
    public int size() {
        return 0;
    }

    @Override // reactor.core.Disposable.Composite, reactor.core.Disposable
    public void dispose() {
    }
}
