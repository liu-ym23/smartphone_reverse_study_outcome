package kotlinx.coroutines;

import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

/* JADX INFO: loaded from: classes4.dex */
public abstract class y extends LockFreeLinkedListNode implements Function1 {
    public y() {
    }

    public abstract void o(Throwable r10);
}
