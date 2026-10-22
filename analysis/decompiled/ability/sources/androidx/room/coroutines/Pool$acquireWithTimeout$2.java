package androidx.room.coroutines;

import C7.r;
import J7.c;
import S7.n;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import m9.InterfaceC1733z;

@c(c = "androidx.room.coroutines.Pool$acquireWithTimeout$2", f = "ConnectionPoolImpl.kt", l = {214}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 1, 0})
/* loaded from: classes2.dex */
public final class Pool$acquireWithTimeout$2 extends SuspendLambda implements n {
    final /* synthetic */ Ref$ObjectRef<ConnectionWithLock> $connection;
    Object L$0;
    int label;
    final /* synthetic */ Pool this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Pool$acquireWithTimeout$2(Ref$ObjectRef<ConnectionWithLock> ref$ObjectRef, Pool pool, H7.c<? super Pool$acquireWithTimeout$2> cVar) {
        super(2, cVar);
        this.$connection = ref$ObjectRef;
        this.this$0 = pool;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        return new Pool$acquireWithTimeout$2(this.$connection, this.this$0, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Ref$ObjectRef<ConnectionWithLock> ref$ObjectRef;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.label;
        if (i == 0) {
            b.b(obj);
            Ref$ObjectRef<ConnectionWithLock> ref$ObjectRef2 = this.$connection;
            Pool pool = this.this$0;
            this.L$0 = ref$ObjectRef2;
            this.label = 1;
            Object objAcquire = pool.acquire(this);
            if (objAcquire == coroutineSingletons) {
                return coroutineSingletons;
            }
            obj = objAcquire;
            ref$ObjectRef = ref$ObjectRef2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ref$ObjectRef = (Ref$ObjectRef) this.L$0;
            b.b(obj);
        }
        ref$ObjectRef.f4920a = obj;
        return r.f317a;
    }

    @Override // S7.n
    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
        return ((Pool$acquireWithTimeout$2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
    }
}
