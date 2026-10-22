package androidx.room.util;

import C7.r;
import J7.c;
import S7.k;
import S7.n;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@c(c = "androidx.room.util.DBUtil__DBUtil_androidKt$compatCoroutineExecute$2", f = "DBUtil.android.kt", l = {118}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\n"}, d2 = {"R", "Lm9/z;", "<anonymous>"}, k = 3, mv = {2, 1, 0})
/* loaded from: classes2.dex */
public final class DBUtil__DBUtil_androidKt$compatCoroutineExecute$2 extends SuspendLambda implements n {
    final /* synthetic */ k $block;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DBUtil__DBUtil_androidKt$compatCoroutineExecute$2(k kVar, H7.c<? super DBUtil__DBUtil_androidKt$compatCoroutineExecute$2> cVar) {
        super(2, cVar);
        this.$block = kVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        return new DBUtil__DBUtil_androidKt$compatCoroutineExecute$2(this.$block, cVar);
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
        k kVar = this.$block;
        this.label = 1;
        Object objInvoke = kVar.invoke(this);
        return objInvoke == coroutineSingletons ? coroutineSingletons : objInvoke;
    }

    public final Object invokeSuspend$$forInline(Object obj) {
        return this.$block.invoke(this);
    }

    @Override // S7.n
    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super R> cVar) {
        return ((DBUtil__DBUtil_androidKt$compatCoroutineExecute$2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
    }
}
