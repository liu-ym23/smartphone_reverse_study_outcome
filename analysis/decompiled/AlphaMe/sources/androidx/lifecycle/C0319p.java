package androidx.lifecycle;

import b3.InterfaceC0380i;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* renamed from: androidx.lifecycle.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0319p implements InterfaceC0380i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ S f3975a;

    public C0319p(S s4) {
        this.f3975a = s4;
    }

    @Override // b3.InterfaceC0380i
    public final Object emit(Object obj, Continuation continuation) throws Throwable {
        S s4 = this.f3975a;
        s4.getClass();
        Object objO = t0.J.O(continuation, s4.f3903b, new Q(s4, obj, null));
        if (objO != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            objO = Unit.INSTANCE;
        }
        return objO == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objO : Unit.INSTANCE;
    }
}
