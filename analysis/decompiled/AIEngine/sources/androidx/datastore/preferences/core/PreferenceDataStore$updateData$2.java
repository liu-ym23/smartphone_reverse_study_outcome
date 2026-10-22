package androidx.datastore.preferences.core;

import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import lb.n;
import qb.b;
import rb.c;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "androidx.datastore.preferences.core.PreferenceDataStore$updateData$2", f = "PreferenceDataStoreFactory.kt", l = {85}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class PreferenceDataStore$updateData$2 extends SuspendLambda implements p<g1.a, b<? super g1.a>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f1710a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f1711b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SuspendLambda f1712c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PreferenceDataStore$updateData$2(p<? super g1.a, ? super b<? super g1.a>, ? extends Object> pVar, b<? super PreferenceDataStore$updateData$2> bVar) {
        super(2, bVar);
        this.f1712c = (SuspendLambda) pVar;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.coroutines.jvm.internal.SuspendLambda, zb.p] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final b<n> create(Object obj, b<?> bVar) {
        PreferenceDataStore$updateData$2 preferenceDataStore$updateData$2 = new PreferenceDataStore$updateData$2(this.f1712c, bVar);
        preferenceDataStore$updateData$2.f1711b = obj;
        return preferenceDataStore$updateData$2;
    }

    @Override // zb.p
    public final Object invoke(g1.a aVar, b<? super g1.a> bVar) {
        return ((PreferenceDataStore$updateData$2) create(aVar, bVar)).invokeSuspend(n.f10413a);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.coroutines.jvm.internal.SuspendLambda, zb.p] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.f1710a;
        if (i10 == 0) {
            kotlin.c.b(obj);
            g1.a aVar = (g1.a) this.f1711b;
            this.f1710a = 1;
            obj = this.f1712c.invoke(aVar, this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
        }
        g1.a aVar2 = (g1.a) obj;
        ((MutablePreferences) aVar2).f1707b.set(true);
        return aVar2;
    }
}
