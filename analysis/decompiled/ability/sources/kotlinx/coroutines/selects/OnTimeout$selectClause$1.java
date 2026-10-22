package kotlinx.coroutines.selects;

import C7.r;
import H7.h;
import S7.o;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.k;
import v9.C2072a;
import v9.InterfaceC2075d;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
final /* synthetic */ class OnTimeout$selectClause$1 extends FunctionReferenceImpl implements o {

    /* renamed from: a, reason: collision with root package name */
    public static final OnTimeout$selectClause$1 f5253a = new OnTimeout$selectClause$1();

    public OnTimeout$selectClause$1() {
        super(3, C2072a.class, "register", "register(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
    }

    @Override // S7.o
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        C2072a c2072a = (C2072a) obj;
        InterfaceC2075d interfaceC2075d = (InterfaceC2075d) obj2;
        long j5 = c2072a.f6794a;
        r rVar = r.f317a;
        if (j5 <= 0) {
            interfaceC2075d.f(rVar);
            return rVar;
        }
        A.a aVar = new A.a(22, interfaceC2075d, false, c2072a);
        k.d(interfaceC2075d, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
        b bVar = (b) interfaceC2075d;
        h hVar = bVar.f5256a;
        bVar.c = kotlinx.coroutines.a.h(hVar).l(j5, aVar, hVar);
        return rVar;
    }
}
