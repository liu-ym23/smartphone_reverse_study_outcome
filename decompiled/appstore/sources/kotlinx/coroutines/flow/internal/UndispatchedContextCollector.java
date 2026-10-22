package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.ThreadContextKt;

/* JADX INFO: loaded from: classes4.dex */
public final class UndispatchedContextCollector implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineContext f21538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f21539b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function2 f21540c;

    public UndispatchedContextCollector(FlowCollector r10, CoroutineContext r11) {
        this.f21538a = r11;
        this.f21539b = ThreadContextKt.b(r11);
        this.f21540c = new UndispatchedContextCollector$emitRef$1(r10, null);
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public Object emit(Object r10, Continuation r11) {
        Object r12 = d.c(this.f21538a, r10, this.f21539b, this.f21540c, r11);
        if (r12 != kotlin.coroutines.intrinsics.a.d()) goto L6;
        return r12;
    L6:
        return Unit.f21064a;
    }
}
