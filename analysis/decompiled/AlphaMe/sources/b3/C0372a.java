package b3;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* renamed from: b3.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0372a extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public c3.o f4386a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f4387b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ x0.h f4388c;

    /* renamed from: d, reason: collision with root package name */
    public int f4389d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0372a(x0.h hVar, Continuation continuation) {
        super(continuation);
        this.f4388c = hVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f4387b = obj;
        this.f4389d |= Integer.MIN_VALUE;
        return this.f4388c.collect(null, this);
    }
}
