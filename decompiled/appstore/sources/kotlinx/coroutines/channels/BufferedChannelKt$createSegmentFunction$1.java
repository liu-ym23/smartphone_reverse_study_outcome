package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public /* synthetic */ class BufferedChannelKt$createSegmentFunction$1 extends FunctionReferenceImpl implements Function2<Long, g, g> {
    public static final BufferedChannelKt$createSegmentFunction$1 INSTANCE = null;

    static {
        INSTANCE = new BufferedChannelKt$createSegmentFunction$1();
    }

    public BufferedChannelKt$createSegmentFunction$1() {
        super(2, BufferedChannelKt.class, "createSegment", "createSegment(JLkotlinx/coroutines/channels/ChannelSegment;)Lkotlinx/coroutines/channels/ChannelSegment;", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ g mo0invoke(Long r10, g r11) {
        return invoke(r10.longValue(), r11);
    }

    @NotNull
    public final g invoke(long r10, @NotNull g r11) {
        return BufferedChannelKt.c(r10, r11);
    }
}
