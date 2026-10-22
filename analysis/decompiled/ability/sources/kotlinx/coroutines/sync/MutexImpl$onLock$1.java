package kotlinx.coroutines.sync;

import C7.r;
import S7.o;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.k;
import v9.InterfaceC2075d;
import w9.c;
import w9.d;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
final /* synthetic */ class MutexImpl$onLock$1 extends FunctionReferenceImpl implements o {

    /* renamed from: a, reason: collision with root package name */
    public static final MutexImpl$onLock$1 f5257a = new MutexImpl$onLock$1();

    public MutexImpl$onLock$1() {
        super(3, a.class, "onLockRegFunction", "onLockRegFunction(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
    }

    @Override // S7.o
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        int andDecrement;
        a aVar = (a) obj;
        InterfaceC2075d interfaceC2075d = (InterfaceC2075d) obj2;
        r rVar = r.f317a;
        if (obj3 == null) {
            aVar.getClass();
        } else if (aVar.holdsLock(obj3)) {
            interfaceC2075d.f(d.b);
            return rVar;
        }
        k.d(interfaceC2075d, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectInstanceInternal<*>");
        c cVar = new c(aVar, interfaceC2075d, obj3);
        do {
            aVar.getClass();
            do {
                andDecrement = b.g.getAndDecrement(aVar);
            } while (andDecrement > aVar.f5261a);
            if (andDecrement > 0) {
                cVar.f(rVar);
                return rVar;
            }
        } while (!aVar.b(cVar));
        return rVar;
    }
}
