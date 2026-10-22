package kotlinx.coroutines.flow.internal;

import C7.r;
import S7.n;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@J7.c(c = "kotlinx.coroutines.flow.internal.ChannelFlow$collect$2", f = "ChannelFlow.kt", l = {119}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 0, 0})
/* loaded from: classes4.dex */
final class ChannelFlow$collect$2 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public int f5230a;
    public /* synthetic */ Object b;
    public final /* synthetic */ p9.d c;
    public final /* synthetic */ a d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelFlow$collect$2(p9.d dVar, a aVar, H7.c cVar) {
        super(2, cVar);
        this.c = dVar;
        this.d = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        ChannelFlow$collect$2 channelFlow$collect$2 = new ChannelFlow$collect$2(this.c, this.d, cVar);
        channelFlow$collect$2.b = obj;
        return channelFlow$collect$2;
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((ChannelFlow$collect$2) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.f5230a;
        r rVar = r.f317a;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
            return rVar;
        }
        kotlin.b.b(obj);
        o9.n nVarH = this.d.h((InterfaceC1733z) this.b);
        this.f5230a = 1;
        Object objG = kotlinx.coroutines.flow.d.g(this.c, nVarH, true, this);
        if (objG != coroutineSingletons) {
            objG = rVar;
        }
        return objG == coroutineSingletons ? coroutineSingletons : rVar;
    }
}
