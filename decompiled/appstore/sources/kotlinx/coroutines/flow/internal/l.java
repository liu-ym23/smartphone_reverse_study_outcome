package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes4.dex */
public final class l implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f21550a = null;

    static {
        f21550a = new l();
    }

    public l() {
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public Object emit(Object r10, Continuation r11) {
        return Unit.f21064a;
    }
}
