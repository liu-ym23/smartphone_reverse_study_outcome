package rx.internal.operators;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class OnSubscribeAmb$Selection<T> extends AtomicReference<c> {
    final Collection<c> ambSubscribers;

    public OnSubscribeAmb$Selection() {
        this.ambSubscribers = new ConcurrentLinkedQueue();
    }

    public void unsubscribeLosers() {
        androidx.appcompat.widget.p.a(get());
    }

    public void unsubscribeOthers(c r10) {
        Iterator<c> r11 = this.ambSubscribers.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        androidx.appcompat.widget.p.a(r11.next());
        goto L4
    L6:
        this.ambSubscribers.clear();
    }
}
