package p9;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlinx.coroutines.channels.BufferOverflow;
import m9.InterfaceC1733z;
import o9.InterfaceC1786l;

/* renamed from: p9.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1792a extends kotlinx.coroutines.flow.internal.a {
    public static final /* synthetic */ AtomicIntegerFieldUpdater f = AtomicIntegerFieldUpdater.newUpdater(C1792a.class, "consumed$volatile");
    private volatile /* synthetic */ int consumed$volatile;
    public final o9.n d;
    public final boolean e;

    public /* synthetic */ C1792a(o9.n nVar, boolean z10) {
        this(nVar, z10, EmptyCoroutineContext.f4908a, -3, BufferOverflow.f5184a);
    }

    @Override // kotlinx.coroutines.flow.internal.a, p9.c
    public final Object collect(d dVar, H7.c cVar) throws Throwable {
        if (this.b == -3) {
            boolean z10 = this.e;
            if (z10 && f.getAndSet(this, 1) != 0) {
                throw new IllegalStateException("ReceiveChannel.consumeAsFlow can be collected just once");
            }
            Object objG = kotlinx.coroutines.flow.d.g(dVar, this.d, z10, cVar);
            if (objG == CoroutineSingletons.f4909a) {
                return objG;
            }
        } else {
            Object objCollect = super.collect(dVar, cVar);
            if (objCollect == CoroutineSingletons.f4909a) {
                return objCollect;
            }
        }
        return C7.r.f317a;
    }

    @Override // kotlinx.coroutines.flow.internal.a
    public final String d() {
        return "channel=" + this.d;
    }

    @Override // kotlinx.coroutines.flow.internal.a
    public final Object e(InterfaceC1786l interfaceC1786l, H7.c cVar) throws Throwable {
        Object objG = kotlinx.coroutines.flow.d.g(new q9.j(interfaceC1786l), this.d, this.e, cVar);
        return objG == CoroutineSingletons.f4909a ? objG : C7.r.f317a;
    }

    @Override // kotlinx.coroutines.flow.internal.a
    public final kotlinx.coroutines.flow.internal.a f(H7.h hVar, int i, BufferOverflow bufferOverflow) {
        return new C1792a(this.d, this.e, hVar, i, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.a
    public final c g() {
        return new C1792a(this.d, this.e);
    }

    @Override // kotlinx.coroutines.flow.internal.a
    public final o9.n h(InterfaceC1733z interfaceC1733z) {
        if (!this.e || f.getAndSet(this, 1) == 0) {
            return this.b == -3 ? this.d : super.h(interfaceC1733z);
        }
        throw new IllegalStateException("ReceiveChannel.consumeAsFlow can be collected just once");
    }

    public C1792a(o9.n nVar, boolean z10, H7.h hVar, int i, BufferOverflow bufferOverflow) {
        super(hVar, i, bufferOverflow);
        this.d = nVar;
        this.e = z10;
        this.consumed$volatile = 0;
    }
}
