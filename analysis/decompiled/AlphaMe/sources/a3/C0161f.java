package a3;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: a3.f, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0161f extends FunctionReferenceImpl implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public static final C0161f f2289a = new C0161f();

    public C0161f() {
        super(2, AbstractC0162g.class, "createSegment", "createSegment(JLkotlinx/coroutines/channels/ChannelSegment;)Lkotlinx/coroutines/channels/ChannelSegment;", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        long jLongValue = ((Number) obj).longValue();
        C0169n c0169n = (C0169n) obj2;
        C0169n c0169n2 = AbstractC0162g.f2290a;
        C0160e c0160e = c0169n.f2316e;
        Intrinsics.checkNotNull(c0160e);
        return new C0169n(jLongValue, c0169n, c0160e, 0);
    }
}
