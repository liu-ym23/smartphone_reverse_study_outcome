package b3;

import java.util.ArrayList;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;

/* renamed from: b3.d, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0375d implements InterfaceC0379h {

    /* renamed from: a, reason: collision with root package name */
    public final CoroutineContext f4395a;

    /* renamed from: b, reason: collision with root package name */
    public final int f4396b;

    /* renamed from: c, reason: collision with root package name */
    public final int f4397c;

    /* renamed from: d, reason: collision with root package name */
    public final Function2 f4398d;

    public AbstractC0375d(y0.c cVar, CoroutineContext coroutineContext, int i4, int i5) {
        this.f4395a = coroutineContext;
        this.f4396b = i4;
        this.f4397c = i5;
        this.f4398d = cVar;
    }

    public abstract Object a(a3.t tVar, Continuation continuation);

    public final String b() {
        ArrayList arrayList = new ArrayList(4);
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        CoroutineContext coroutineContext = this.f4395a;
        if (coroutineContext != emptyCoroutineContext) {
            arrayList.add("context=" + coroutineContext);
        }
        int i4 = this.f4396b;
        if (i4 != -3) {
            arrayList.add("capacity=" + i4);
        }
        int i5 = this.f4397c;
        if (i5 != 1) {
            arrayList.add("onBufferOverflow=".concat(B0.g.D(i5)));
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append('[');
        return B0.g.q(sb, CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", null, null, 0, null, null, 62, null), ']');
    }

    @Override // b3.InterfaceC0379h
    public final Object collect(InterfaceC0380i interfaceC0380i, Continuation continuation) {
        c3.d dVar = new c3.d(null, this, interfaceC0380i);
        d3.u uVar = new d3.u(continuation, continuation.get$context());
        Object objO = com.stepos.statsrpk.c.O(uVar, uVar, dVar);
        if (objO == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return objO == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objO : Unit.INSTANCE;
    }

    public final String toString() {
        return "block[" + this.f4398d + "] -> " + b();
    }
}
