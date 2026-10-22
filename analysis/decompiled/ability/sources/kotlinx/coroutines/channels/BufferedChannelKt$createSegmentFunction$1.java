package kotlinx.coroutines.channels;

import S7.n;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.k;
import o9.AbstractC1777c;
import o9.C1783i;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
final /* synthetic */ class BufferedChannelKt$createSegmentFunction$1 extends FunctionReferenceImpl implements n {

    /* renamed from: a, reason: collision with root package name */
    public static final BufferedChannelKt$createSegmentFunction$1 f5191a = new BufferedChannelKt$createSegmentFunction$1();

    public BufferedChannelKt$createSegmentFunction$1() {
        super(2, AbstractC1777c.class, "createSegment", "createSegment(JLkotlinx/coroutines/channels/ChannelSegment;)Lkotlinx/coroutines/channels/ChannelSegment;", 1);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        long jLongValue = ((Number) obj).longValue();
        C1783i c1783i = (C1783i) obj2;
        C1783i c1783i2 = AbstractC1777c.f5449a;
        a aVar = c1783i.e;
        k.c(aVar);
        return new C1783i(jLongValue, c1783i, aVar, 0);
    }
}
