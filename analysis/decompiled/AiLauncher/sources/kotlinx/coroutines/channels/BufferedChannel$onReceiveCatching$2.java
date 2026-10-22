package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import p9.q;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* synthetic */ class BufferedChannel$onReceiveCatching$2 extends FunctionReferenceImpl implements q<BufferedChannel<?>, Object, Object, Object> {

    /* renamed from: a, reason: collision with root package name */
    public static final BufferedChannel$onReceiveCatching$2 f36294a = new BufferedChannel$onReceiveCatching$2();

    public BufferedChannel$onReceiveCatching$2() {
        super(3, BufferedChannel.class, "processResultSelectReceiveCatching", "processResultSelectReceiveCatching(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    @Override // p9.q
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public final Object invoke(BufferedChannel<?> bufferedChannel, Object obj, Object obj2) {
        return bufferedChannel.U0(obj, obj2);
    }
}
