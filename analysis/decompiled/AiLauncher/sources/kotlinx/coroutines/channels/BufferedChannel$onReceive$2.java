package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import p9.q;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* synthetic */ class BufferedChannel$onReceive$2 extends FunctionReferenceImpl implements q<BufferedChannel<?>, Object, Object, Object> {

    /* renamed from: a, reason: collision with root package name */
    public static final BufferedChannel$onReceive$2 f36292a = new BufferedChannel$onReceive$2();

    public BufferedChannel$onReceive$2() {
        super(3, BufferedChannel.class, "processResultSelectReceive", "processResultSelectReceive(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    @Override // p9.q
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public final Object invoke(BufferedChannel<?> bufferedChannel, Object obj, Object obj2) {
        return bufferedChannel.T0(obj, obj2);
    }
}
