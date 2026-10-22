package kotlinx.serialization.json.internal;

import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import lb.n;
import rb.c;
import uc.g;
import vc.m;
import zb.q;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "kotlinx.serialization.json.internal.JsonTreeReader$readDeepRecursive$1", f = "JsonTreeReader.kt", l = {115}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class JsonTreeReader$readDeepRecursive$1 extends RestrictedSuspendLambda implements q<lb.a<n, g>, n, qb.b<? super g>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f10127a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ lb.a f10128b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a f10129c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonTreeReader$readDeepRecursive$1(a aVar, qb.b<? super JsonTreeReader$readDeepRecursive$1> bVar) {
        super(3, bVar);
        this.f10129c = aVar;
    }

    @Override // zb.q
    public final Object invoke(lb.a<n, g> aVar, n nVar, qb.b<? super g> bVar) {
        JsonTreeReader$readDeepRecursive$1 jsonTreeReader$readDeepRecursive$1 = new JsonTreeReader$readDeepRecursive$1(this.f10129c, bVar);
        jsonTreeReader$readDeepRecursive$1.f10128b = aVar;
        return jsonTreeReader$readDeepRecursive$1.invokeSuspend(n.f10413a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        a aVar = this.f10129c;
        m mVar = aVar.f10143a;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.f10127a;
        if (i10 == 0) {
            kotlin.c.b(obj);
            lb.a aVar2 = this.f10128b;
            byte bR = mVar.r();
            if (bR == 1) {
                return aVar.d(true);
            }
            if (bR == 0) {
                return aVar.d(false);
            }
            if (bR != 6) {
                if (bR == 8) {
                    return aVar.c();
                }
                m.n(mVar, "Can't begin reading element, unexpected token", 0, 6);
                throw null;
            }
            this.f10127a = 1;
            obj = a.a(aVar, aVar2, this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
        }
        return (g) obj;
    }
}
