package w4;

import V3.n;
import V3.v;
import Z3.i;
import a4.C0428b;
import i4.p;
import i4.q;
import j4.l;
import r4.C1031n;
import s4.r0;
import v4.InterfaceC1194c;

/* loaded from: classes.dex */
public final class i<T> extends kotlin.coroutines.jvm.internal.d implements InterfaceC1194c<T>, kotlin.coroutines.jvm.internal.e {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC1194c<T> f23724a;

    /* renamed from: b, reason: collision with root package name */
    public final Z3.i f23725b;

    /* renamed from: c, reason: collision with root package name */
    public final int f23726c;

    /* renamed from: d, reason: collision with root package name */
    private Z3.i f23727d;

    /* renamed from: e, reason: collision with root package name */
    private Z3.e<? super v> f23728e;

    static final class a extends l implements p<Integer, i.b, Integer> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f23729a = new a();

        a() {
            super(2);
        }

        public final Integer b(int i5, i.b bVar) {
            return Integer.valueOf(i5 + 1);
        }

        @Override // i4.p
        public /* bridge */ /* synthetic */ Integer invoke(Integer num, i.b bVar) {
            return b(num.intValue(), bVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i(InterfaceC1194c<? super T> interfaceC1194c, Z3.i iVar) {
        super(g.f23719a, Z3.j.f6656a);
        this.f23724a = interfaceC1194c;
        this.f23725b = iVar;
        this.f23726c = ((Number) iVar.o(0, a.f23729a)).intValue();
    }

    private final void i(Z3.i iVar, Z3.i iVar2, T t5) {
        if (iVar2 instanceof e) {
            k((e) iVar2, t5);
        }
        k.a(this, iVar);
    }

    private final Object j(Z3.e<? super v> eVar, T t5) {
        Z3.i context = eVar.getContext();
        r0.e(context);
        Z3.i iVar = this.f23727d;
        if (iVar != context) {
            i(context, iVar, t5);
            this.f23727d = context;
        }
        this.f23728e = eVar;
        q qVar = j.f23730a;
        InterfaceC1194c<T> interfaceC1194c = this.f23724a;
        j4.k.e(interfaceC1194c, "null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>");
        j4.k.e(this, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Unit>");
        Object objA = qVar.a(interfaceC1194c, t5, this);
        if (!j4.k.b(objA, C0428b.e())) {
            this.f23728e = null;
        }
        return objA;
    }

    private final void k(e eVar, Object obj) {
        throw new IllegalStateException(C1031n.i("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + eVar.f23717a + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ").toString());
    }

    @Override // v4.InterfaceC1194c
    public Object g(T t5, Z3.e<? super v> eVar) {
        try {
            Object objJ = j(eVar, t5);
            if (objJ == C0428b.e()) {
                kotlin.coroutines.jvm.internal.h.c(eVar);
            }
            return objJ == C0428b.e() ? objJ : v.f5542a;
        } catch (Throwable th) {
            this.f23727d = new e(th, eVar.getContext());
            throw th;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.a, kotlin.coroutines.jvm.internal.e
    public kotlin.coroutines.jvm.internal.e getCallerFrame() {
        Z3.e<? super v> eVar = this.f23728e;
        if (eVar instanceof kotlin.coroutines.jvm.internal.e) {
            return (kotlin.coroutines.jvm.internal.e) eVar;
        }
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.d, Z3.e
    public Z3.i getContext() {
        Z3.i iVar = this.f23727d;
        return iVar == null ? Z3.j.f6656a : iVar;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public Object invokeSuspend(Object obj) {
        Throwable thB = n.b(obj);
        if (thB != null) {
            this.f23727d = new e(thB, getContext());
        }
        Z3.e<? super v> eVar = this.f23728e;
        if (eVar != null) {
            eVar.resumeWith(obj);
        }
        return C0428b.e();
    }

    @Override // kotlin.coroutines.jvm.internal.d, kotlin.coroutines.jvm.internal.a
    public void releaseIntercepted() {
        super.releaseIntercepted();
    }
}
