package androidx.datastore.core;

import com.stepos.deepbinder.core.exception.ErrorCodes;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import lb.n;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2$1$1", f = "DataMigrationInitializer.kt", l = {ErrorCodes.CALLER_NOT_IN_METHOD_WHITE_LIST_ERROR}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class DataMigrationInitializer$Companion$runMigrations$2$1$1 extends SuspendLambda implements l<qb.b<? super n>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f1592a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d1.b<Object> f1593b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataMigrationInitializer$Companion$runMigrations$2$1$1(d1.b<Object> bVar, qb.b<? super DataMigrationInitializer$Companion$runMigrations$2$1$1> bVar2) {
        super(1, bVar2);
        this.f1593b = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<n> create(qb.b<?> bVar) {
        return new DataMigrationInitializer$Companion$runMigrations$2$1$1(this.f1593b, bVar);
    }

    @Override // zb.l
    public final Object invoke(qb.b<? super n> bVar) {
        return ((DataMigrationInitializer$Companion$runMigrations$2$1$1) create(bVar)).invokeSuspend(n.f10413a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.f1592a;
        if (i10 == 0) {
            kotlin.c.b(obj);
            this.f1592a = 1;
            if (this.f1593b.a() == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
        }
        return n.f10413a;
    }
}
