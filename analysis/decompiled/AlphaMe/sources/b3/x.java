package b3;

import Z2.I;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref;

/* loaded from: classes2.dex */
public final class x extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Ref.ObjectRef f4450a;

    /* renamed from: b, reason: collision with root package name */
    public u f4451b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f4452c;

    /* renamed from: d, reason: collision with root package name */
    public int f4453d;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f4452c = obj;
        this.f4453d |= Integer.MIN_VALUE;
        return I.k(null, this);
    }
}
