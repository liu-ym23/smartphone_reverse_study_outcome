package b3;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* renamed from: b3.g, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0378g implements InterfaceC0379h {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0379h f4405a;

    /* renamed from: b, reason: collision with root package name */
    public final Function1 f4406b;

    /* renamed from: c, reason: collision with root package name */
    public final Function2 f4407c;

    public C0378g(x0.h hVar) {
        C0383l c0383l = m.f4416a;
        C0382k c0382k = m.f4417b;
        this.f4405a = hVar;
        this.f4406b = c0383l;
        this.f4407c = c0382k;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [T, X.r] */
    @Override // b3.InterfaceC0379h
    public final Object collect(InterfaceC0380i interfaceC0380i, Continuation continuation) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = c3.m.f4505a;
        Object objCollect = this.f4405a.collect(new C0377f(this, objectRef, interfaceC0380i), continuation);
        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
    }
}
