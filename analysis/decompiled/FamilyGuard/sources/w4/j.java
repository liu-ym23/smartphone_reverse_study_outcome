package w4;

import V3.v;
import i4.q;
import j4.z;
import v4.InterfaceC1194c;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    private static final q<InterfaceC1194c<Object>, Object, Z3.e<? super v>, Object> f23730a;

    /* synthetic */ class a extends j4.j implements q<InterfaceC1194c<? super Object>, Object, Z3.e<? super v>, Object> {

        /* renamed from: j, reason: collision with root package name */
        public static final a f23731j = new a();

        a() {
            super(3, InterfaceC1194c.class, "emit", "emit(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // i4.q
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public final Object a(InterfaceC1194c<Object> interfaceC1194c, Object obj, Z3.e<? super v> eVar) {
            return interfaceC1194c.g(obj, eVar);
        }
    }

    static {
        a aVar = a.f23731j;
        j4.k.e(aVar, "null cannot be cast to non-null type kotlin.Function3<kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>, kotlin.Any?, kotlin.coroutines.Continuation<kotlin.Unit>, kotlin.Any?>");
        f23730a = (q) z.b(aVar, 3);
    }
}
