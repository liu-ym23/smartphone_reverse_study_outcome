package kotlinx.coroutines.flow.internal;

import C7.r;
import Z6.k;
import java.util.Iterator;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;
import o9.C1785k;
import o9.InterfaceC1786l;
import o9.n;

/* loaded from: classes4.dex */
public final class e extends a {
    public final Iterable d;

    public e(Iterable iterable, H7.h hVar, int i, BufferOverflow bufferOverflow) {
        super(hVar, i, bufferOverflow);
        this.d = iterable;
    }

    @Override // kotlinx.coroutines.flow.internal.a
    public final Object e(InterfaceC1786l interfaceC1786l, H7.c cVar) {
        q9.j jVar = new q9.j(interfaceC1786l);
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            AbstractC1683A.n(interfaceC1786l, null, new ChannelLimitedFlowMerge$collectTo$2$1((p9.c) it.next(), jVar, null), 3);
        }
        return r.f317a;
    }

    @Override // kotlinx.coroutines.flow.internal.a
    public final a f(H7.h hVar, int i, BufferOverflow bufferOverflow) {
        return new e(this.d, hVar, i, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.a
    public final n h(InterfaceC1733z interfaceC1733z) {
        S7.n channelFlow$collectToFun$1 = new ChannelFlow$collectToFun$1(this, null);
        BufferOverflow bufferOverflow = BufferOverflow.f5184a;
        CoroutineStart coroutineStart = CoroutineStart.f5175a;
        C1785k c1785k = new C1785k(AbstractC1683A.o(interfaceC1733z, this.f5244a), k.b(this.b, 4, bufferOverflow));
        c1785k.i0(coroutineStart, c1785k, channelFlow$collectToFun$1);
        return c1785k;
    }
}
