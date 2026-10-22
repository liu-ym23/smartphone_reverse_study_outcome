package kotlinx.coroutines.channels;

import Wa.k;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import p9.p;

/* JADX INFO: Add missing generic type declarations: [E] */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* synthetic */ class BufferedChannelKt$createSegmentFunction$1<E> extends FunctionReferenceImpl implements p<Long, k<E>, k<E>> {

    /* renamed from: a, reason: collision with root package name */
    public static final BufferedChannelKt$createSegmentFunction$1 f36336a = new BufferedChannelKt$createSegmentFunction$1();

    public BufferedChannelKt$createSegmentFunction$1() {
        super(2, BufferedChannelKt.class, "createSegment", "createSegment(JLkotlinx/coroutines/channels/ChannelSegment;)Lkotlinx/coroutines/channels/ChannelSegment;", 1);
    }

    @Override // p9.p
    public /* bridge */ /* synthetic */ Object invoke(Long l10, Object obj) {
        return l(l10.longValue(), (k) obj);
    }

    public final k<E> l(long j10, k<E> kVar) {
        return BufferedChannelKt.x(j10, kVar);
    }
}
