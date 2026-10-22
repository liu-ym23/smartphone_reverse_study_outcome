package g3;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* loaded from: classes2.dex */
public final /* synthetic */ class g extends FunctionReferenceImpl implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public static final g f12670a = new g();

    public g() {
        super(2, i.class, "createSegment", "createSegment(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        int i4 = i.f12678a;
        return new j(((Number) obj).longValue(), (j) obj2, 0);
    }
}
