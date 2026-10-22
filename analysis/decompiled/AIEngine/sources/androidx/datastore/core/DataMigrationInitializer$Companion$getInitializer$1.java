package androidx.datastore.core;

import d1.e;
import java.util.List;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import lb.n;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "androidx.datastore.core.DataMigrationInitializer$Companion$getInitializer$1", f = "DataMigrationInitializer.kt", l = {33}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class DataMigrationInitializer$Companion$getInitializer$1 extends SuspendLambda implements p<e<Object>, qb.b<? super n>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f1579a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f1580b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List<d1.b<Object>> f1581c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DataMigrationInitializer$Companion$getInitializer$1(List<? extends d1.b<Object>> list, qb.b<? super DataMigrationInitializer$Companion$getInitializer$1> bVar) {
        super(2, bVar);
        this.f1581c = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<n> create(Object obj, qb.b<?> bVar) {
        DataMigrationInitializer$Companion$getInitializer$1 dataMigrationInitializer$Companion$getInitializer$1 = new DataMigrationInitializer$Companion$getInitializer$1(this.f1581c, bVar);
        dataMigrationInitializer$Companion$getInitializer$1.f1580b = obj;
        return dataMigrationInitializer$Companion$getInitializer$1;
    }

    @Override // zb.p
    public final Object invoke(e<Object> eVar, qb.b<? super n> bVar) {
        return ((DataMigrationInitializer$Companion$getInitializer$1) create(eVar, bVar)).invokeSuspend(n.f10413a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.f1579a;
        if (i10 == 0) {
            kotlin.c.b(obj);
            e eVar = (e) this.f1580b;
            this.f1579a = 1;
            if (a.a(this.f1581c, eVar, this) == coroutineSingletons) {
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
