package kotlinx.coroutines.channels;

import S7.o;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import o9.AbstractC1777c;
import o9.C1780f;
import o9.C1782h;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
final /* synthetic */ class BufferedChannel$onReceiveCatching$2 extends FunctionReferenceImpl implements o {

    /* renamed from: a, reason: collision with root package name */
    public static final BufferedChannel$onReceiveCatching$2 f5188a = new BufferedChannel$onReceiveCatching$2();

    public BufferedChannel$onReceiveCatching$2() {
        super(3, a.class, "processResultSelectReceiveCatching", "processResultSelectReceiveCatching(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    @Override // S7.o
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        a aVar = (a) obj;
        AtomicLongFieldUpdater atomicLongFieldUpdater = a.b;
        aVar.getClass();
        if (obj3 == AbstractC1777c.l) {
            obj3 = new C1780f(aVar.l());
        }
        return new C1782h(obj3);
    }
}
