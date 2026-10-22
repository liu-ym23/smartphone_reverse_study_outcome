package S;

import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* renamed from: S.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0101g extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public Iterator f1747a;

    /* renamed from: b, reason: collision with root package name */
    public Object f1748b;

    /* renamed from: c, reason: collision with root package name */
    public int f1749c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f1750d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ List f1751e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ List f1752f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0101g(List list, List list2, Continuation continuation) {
        super(2, continuation);
        this.f1751e = list;
        this.f1752f = list2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        C0101g c0101g = new C0101g(this.f1751e, this.f1752f, continuation);
        c0101g.f1750d = obj;
        return c0101g;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C0101g) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Iterator it;
        List list;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = this.f1749c;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj);
            obj = this.f1750d;
            it = this.f1751e.iterator();
            list = this.f1752f;
        } else if (i4 == 1) {
            Object obj2 = this.f1748b;
            Iterator it2 = this.f1747a;
            List list2 = (List) this.f1750d;
            ResultKt.throwOnFailure(obj);
            if (((Boolean) obj).booleanValue()) {
                list2.add(new C0100f(1, null));
                this.f1750d = list2;
                this.f1747a = it2;
                this.f1748b = null;
                this.f1749c = 2;
                throw null;
            }
            obj = obj2;
            it = it2;
            list = list2;
        } else {
            if (i4 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            it = this.f1747a;
            list = (List) this.f1750d;
            ResultKt.throwOnFailure(obj);
        }
        if (!it.hasNext()) {
            return obj;
        }
        B0.g.y(it.next());
        this.f1750d = list;
        this.f1747a = it;
        this.f1748b = obj;
        this.f1749c = 1;
        throw null;
    }
}
