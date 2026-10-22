package androidx.room.util;

import C7.r;
import J7.c;
import S7.n;
import androidx.room.TransactionScope;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@c(c = "androidx.room.util.DBUtil__DBUtilKt$internalPerform$2$result$1", f = "DBUtil.kt", l = {59}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002H\n"}, d2 = {"<anonymous>", "R", "Landroidx/room/TransactionScope;"}, k = 3, mv = {2, 1, 0}, xi = 176)
/* loaded from: classes2.dex */
public final class DBUtil__DBUtilKt$internalPerform$2$result$1 extends SuspendLambda implements n {
    final /* synthetic */ n $block;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DBUtil__DBUtilKt$internalPerform$2$result$1(n nVar, H7.c<? super DBUtil__DBUtilKt$internalPerform$2$result$1> cVar) {
        super(2, cVar);
        this.$block = nVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        DBUtil__DBUtilKt$internalPerform$2$result$1 dBUtil__DBUtilKt$internalPerform$2$result$1 = new DBUtil__DBUtilKt$internalPerform$2$result$1(this.$block, cVar);
        dBUtil__DBUtilKt$internalPerform$2$result$1.L$0 = obj;
        return dBUtil__DBUtilKt$internalPerform$2$result$1;
    }

    @Override // S7.n
    public final Object invoke(TransactionScope<R> transactionScope, H7.c<? super R> cVar) {
        return ((DBUtil__DBUtilKt$internalPerform$2$result$1) create(transactionScope, cVar)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
            return obj;
        }
        b.b(obj);
        TransactionScope transactionScope = (TransactionScope) this.L$0;
        n nVar = this.$block;
        this.label = 1;
        Object objInvoke = nVar.invoke(transactionScope, this);
        return objInvoke == coroutineSingletons ? coroutineSingletons : objInvoke;
    }

    public final Object invokeSuspend$$forInline(Object obj) {
        return this.$block.invoke((TransactionScope) this.L$0, this);
    }
}
