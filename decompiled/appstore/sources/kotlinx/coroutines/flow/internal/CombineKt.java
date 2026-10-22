package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes4.dex */
public abstract class CombineKt {
    public static final Object a(FlowCollector r10, Flow[] r11, Function0 r12, Function3 r13, Continuation r14) {
        Object r15 = i.a(new CombineKt$combineInternal$2(r11, r12, r13, r10, null), r14);
        if (r15 != kotlin.coroutines.intrinsics.a.d()) goto L6;
        return r15;
    L6:
        return Unit.f21064a;
    }
}
