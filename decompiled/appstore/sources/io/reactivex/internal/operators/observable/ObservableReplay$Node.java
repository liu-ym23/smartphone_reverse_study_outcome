package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class ObservableReplay$Node extends AtomicReference<ObservableReplay$Node> {
    private static final long serialVersionUID = 245354315435971818L;
    final Object value;

    public ObservableReplay$Node(Object r10) {
        this.value = r10;
    }
}
