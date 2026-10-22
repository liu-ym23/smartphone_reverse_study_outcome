package androidx.room.coroutines;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "androidx.room.coroutines.Pool", f = "ConnectionPoolImpl.kt", l = {253}, m = "acquire")
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Pool$acquire$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f14737a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Pool f14738b;

    /* renamed from: c, reason: collision with root package name */
    public int f14739c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Pool$acquire$1(Pool pool, InterfaceC4014c<? super Pool$acquire$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f14738b = pool;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f14737a = obj;
        this.f14739c |= Integer.MIN_VALUE;
        return this.f14738b.a(this);
    }
}
