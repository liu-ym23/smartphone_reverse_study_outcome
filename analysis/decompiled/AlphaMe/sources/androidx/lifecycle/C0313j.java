package androidx.lifecycle;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* renamed from: androidx.lifecycle.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0313j extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f3954a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0314k f3955b;

    /* renamed from: c, reason: collision with root package name */
    public int f3956c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0313j(C0314k c0314k, Continuation continuation) {
        super(continuation);
        this.f3955b = c0314k;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f3954a = obj;
        this.f3956c |= Integer.MIN_VALUE;
        return this.f3955b.i(this);
    }
}
