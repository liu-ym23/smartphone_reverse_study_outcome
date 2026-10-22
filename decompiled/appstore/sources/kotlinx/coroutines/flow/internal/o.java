package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes4.dex */
public final class o implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SendChannel f21554a;

    public o(SendChannel r10) {
        this.f21554a = r10;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public Object emit(Object r10, Continuation r11) {
        Object r12 = this.f21554a.send(r10, r11);
        if (r12 != kotlin.coroutines.intrinsics.a.d()) goto L6;
        return r12;
    L6:
        return Unit.f21064a;
    }
}
