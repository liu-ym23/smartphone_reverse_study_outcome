package kotlinx.coroutines.channels;

import S7.o;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import o9.AbstractC1777c;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
final /* synthetic */ class BufferedChannel$onReceive$2 extends FunctionReferenceImpl implements o {

    /* renamed from: a, reason: collision with root package name */
    public static final BufferedChannel$onReceive$2 f5186a = new BufferedChannel$onReceive$2();

    public BufferedChannel$onReceive$2() {
        super(3, a.class, "processResultSelectReceive", "processResultSelectReceive(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    @Override // S7.o
    public final Object invoke(Object obj, Object obj2, Object obj3) throws Throwable {
        a aVar = (a) obj;
        AtomicLongFieldUpdater atomicLongFieldUpdater = a.b;
        aVar.getClass();
        if (obj3 != AbstractC1777c.l) {
            return obj3;
        }
        throw aVar.n();
    }
}
