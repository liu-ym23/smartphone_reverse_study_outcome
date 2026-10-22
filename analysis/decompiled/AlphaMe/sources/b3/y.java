package b3;

import Z2.I;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* loaded from: classes2.dex */
public final class y extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Function2 f4454a;

    /* renamed from: b, reason: collision with root package name */
    public Ref.ObjectRef f4455b;

    /* renamed from: c, reason: collision with root package name */
    public w f4456c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f4457d;

    /* renamed from: e, reason: collision with root package name */
    public int f4458e;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f4457d = obj;
        this.f4458e |= Integer.MIN_VALUE;
        return I.l(null, null, this);
    }
}
