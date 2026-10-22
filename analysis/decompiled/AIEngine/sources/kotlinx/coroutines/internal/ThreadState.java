package kotlinx.coroutines.internal;

import kotlin.coroutines.d;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.ThreadContextElement;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
final class ThreadState {
    public final d context;
    private final ThreadContextElement<Object>[] elements;

    /* renamed from: i, reason: collision with root package name */
    private int f10116i;
    private final Object[] values;

    public ThreadState(d dVar, int i10) {
        this.context = dVar;
        this.values = new Object[i10];
        this.elements = new ThreadContextElement[i10];
    }

    public final void append(ThreadContextElement<?> threadContextElement, Object obj) {
        Object[] objArr = this.values;
        int i10 = this.f10116i;
        objArr[i10] = obj;
        ThreadContextElement<Object>[] threadContextElementArr = this.elements;
        this.f10116i = i10 + 1;
        g.d(threadContextElement, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        threadContextElementArr[i10] = threadContextElement;
    }

    public final void restore(d dVar) {
        int length = this.elements.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i10 = length - 1;
            ThreadContextElement<Object> threadContextElement = this.elements[length];
            g.c(threadContextElement);
            threadContextElement.restoreThreadContext(dVar, this.values[length]);
            if (i10 < 0) {
                return;
            } else {
                length = i10;
            }
        }
    }
}
