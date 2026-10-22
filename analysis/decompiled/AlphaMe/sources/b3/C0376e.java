package b3;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* renamed from: b3.e, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0376e extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f4399a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0377f f4400b;

    /* renamed from: c, reason: collision with root package name */
    public int f4401c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0376e(C0377f c0377f, Continuation continuation) {
        super(continuation);
        this.f4400b = c0377f;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f4399a = obj;
        this.f4401c |= Integer.MIN_VALUE;
        return this.f4400b.emit(null, this);
    }
}
