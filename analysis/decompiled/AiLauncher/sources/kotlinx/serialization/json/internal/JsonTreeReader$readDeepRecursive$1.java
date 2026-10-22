package kotlinx.serialization.json.internal;

import Y8.b;
import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import g9.h;
import kotlin.C4849c;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import p9.q;
import qb.i;
import rb.JsonReader;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0002*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"LY8/b;", "LY8/t;", "Lqb/i;", "it", "<anonymous>", "(Lkotlin/DeepRecursiveScope;V)Lkotlinx/serialization/json/JsonElement;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "kotlinx.serialization.json.internal.JsonTreeReader$readDeepRecursive$1", f = "JsonTreeReader.kt", l = {115}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class JsonTreeReader$readDeepRecursive$1 extends RestrictedSuspendLambda implements q<b<t, i>, t, InterfaceC4014c<? super i>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f36841a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f36842b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ JsonTreeReader f36843c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonTreeReader$readDeepRecursive$1(JsonTreeReader jsonTreeReader, InterfaceC4014c<? super JsonTreeReader$readDeepRecursive$1> interfaceC4014c) {
        super(3, interfaceC4014c);
        this.f36843c = jsonTreeReader;
    }

    @Override // p9.q
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final Object invoke(b<t, i> bVar, t tVar, InterfaceC4014c<? super i> interfaceC4014c) {
        JsonTreeReader$readDeepRecursive$1 jsonTreeReader$readDeepRecursive$1 = new JsonTreeReader$readDeepRecursive$1(this.f36843c, interfaceC4014c);
        jsonTreeReader$readDeepRecursive$1.f36842b = bVar;
        return jsonTreeReader$readDeepRecursive$1.invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        b bVar = (b) this.f36842b;
        Object objG = C4063a.g();
        int i10 = this.f36841a;
        if (i10 == 0) {
            C4849c.b(obj);
            byte bF = this.f36843c.lexer.F();
            if (bF == 1) {
                return this.f36843c.j(true);
            }
            if (bF == 0) {
                return this.f36843c.j(false);
            }
            if (bF != 6) {
                if (bF == 8) {
                    return this.f36843c.f();
                }
                JsonReader.z(this.f36843c.lexer, "Can't begin reading element, unexpected token", 0, null, 6, null);
                throw new KotlinNothingValueException();
            }
            JsonTreeReader jsonTreeReader = this.f36843c;
            this.f36842b = h.a(bVar);
            this.f36841a = 1;
            obj = jsonTreeReader.h(bVar, this);
            if (obj == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        return (i) obj;
    }
}
