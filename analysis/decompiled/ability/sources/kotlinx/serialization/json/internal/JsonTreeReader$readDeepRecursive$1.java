package kotlinx.serialization.json.internal;

import C7.r;
import C9.l;
import D9.t;
import S7.o;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;

@J7.c(c = "kotlinx.serialization.json.internal.JsonTreeReader$readDeepRecursive$1", f = "JsonTreeReader.kt", l = {115}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0002*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"LC7/b;", "LC7/r;", "LC9/l;", "it", "<anonymous>", "(Lkotlin/DeepRecursiveScope;V)Lkotlinx/serialization/json/JsonElement;"}, k = 3, mv = {2, 1, 0})
/* loaded from: classes4.dex */
final class JsonTreeReader$readDeepRecursive$1 extends RestrictedSuspendLambda implements o {

    /* renamed from: a, reason: collision with root package name */
    public int f5264a;
    public /* synthetic */ C7.b b;
    public final /* synthetic */ b c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonTreeReader$readDeepRecursive$1(b bVar, H7.c cVar) {
        super(3, cVar);
        this.c = bVar;
    }

    @Override // S7.o
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        JsonTreeReader$readDeepRecursive$1 jsonTreeReader$readDeepRecursive$1 = new JsonTreeReader$readDeepRecursive$1(this.c, (H7.c) obj3);
        jsonTreeReader$readDeepRecursive$1.b = (C7.b) obj;
        return jsonTreeReader$readDeepRecursive$1.invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        b bVar = this.c;
        t tVar = bVar.f5268a;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.f5264a;
        if (i == 0) {
            kotlin.b.b(obj);
            C7.b bVar2 = this.b;
            byte bR = tVar.r();
            if (bR == 1) {
                return bVar.d(true);
            }
            if (bR == 0) {
                return bVar.d(false);
            }
            if (bR != 6) {
                if (bR == 8) {
                    return bVar.c();
                }
                t.o(tVar, "Can't begin reading element, unexpected token", 0, null, 6);
                throw null;
            }
            this.f5264a = 1;
            obj = b.a(bVar, bVar2, this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
        }
        return (l) obj;
    }
}
