package b3;

import Z2.I;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref;

/* loaded from: classes2.dex */
public final class p extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Ref.ObjectRef f4425a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f4426b;

    /* renamed from: c, reason: collision with root package name */
    public int f4427c;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f4426b = obj;
        this.f4427c |= Integer.MIN_VALUE;
        return I.d(this, null, null);
    }
}
