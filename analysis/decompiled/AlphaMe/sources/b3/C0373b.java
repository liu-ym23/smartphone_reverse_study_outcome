package b3;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* renamed from: b3.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0373b extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public a3.t f4390a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f4391b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C0374c f4392c;

    /* renamed from: d, reason: collision with root package name */
    public int f4393d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0373b(C0374c c0374c, Continuation continuation) {
        super(continuation);
        this.f4392c = c0374c;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f4391b = obj;
        this.f4393d |= Integer.MIN_VALUE;
        return this.f4392c.a(null, this);
    }
}
