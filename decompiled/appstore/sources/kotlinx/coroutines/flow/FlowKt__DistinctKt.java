package kotlinx.coroutines.flow;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes4.dex */
public abstract /* synthetic */ class FlowKt__DistinctKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Function1 f21439a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Function2 f21440b = null;

    static {
        f21439a = FlowKt__DistinctKt$defaultKeySelector$1.INSTANCE;
        f21440b = FlowKt__DistinctKt$defaultAreEquivalent$1.INSTANCE;
    }

    public static final Flow a(Flow r10) {
        if ((r10 instanceof StateFlow) == false) goto L6;
        return r10;
    L6:
        return c(r10, f21439a, f21440b);
    }

    public static final Flow b(Flow r10, Function1 r11) {
        return c(r10, r11, f21440b);
    }

    public static final Flow c(Flow r10, Function1 r11, Function2 r12) {
        if ((r10 instanceof DistinctFlowImpl) == false) goto L10;
        DistinctFlowImpl r13 = (DistinctFlowImpl) r10;
        if (r13.f21428b != r11) goto L10;
        if (r13.f21429c != r12) goto L10;
        return r10;
    L10:
        return new DistinctFlowImpl(r10, r11, r12);
    }
}
