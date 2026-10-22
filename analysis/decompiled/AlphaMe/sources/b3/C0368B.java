package b3;

import Z2.o0;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* renamed from: b3.B, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0368B extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public C0369C f4373a;

    /* renamed from: b, reason: collision with root package name */
    public InterfaceC0380i f4374b;

    /* renamed from: c, reason: collision with root package name */
    public C0371E f4375c;

    /* renamed from: d, reason: collision with root package name */
    public o0 f4376d;

    /* renamed from: e, reason: collision with root package name */
    public Object f4377e;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f4378f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ C0369C f4379g;

    /* renamed from: h, reason: collision with root package name */
    public int f4380h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0368B(C0369C c0369c, Continuation continuation) {
        super(continuation);
        this.f4379g = c0369c;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f4378f = obj;
        this.f4380h |= Integer.MIN_VALUE;
        return this.f4379g.collect(null, this);
    }
}
