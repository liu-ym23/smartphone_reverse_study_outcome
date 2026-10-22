package b4;

import b5.a0;
import java.util.List;
import java.util.Set;
import p5.s;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class e extends h5.i implements s {

    /* renamed from: a, reason: collision with root package name */
    public int f856a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ f4.c f857b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f858c;
    public final /* synthetic */ List d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Set f859e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ a4.c f860f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(a4.c cVar, f5.c cVar2, List list, Set set) {
        super(5, cVar2);
        this.d = list;
        this.f859e = set;
        this.f860f = cVar;
    }

    @Override // p5.s
    public final Object b(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        Set set = this.f859e;
        e eVar = new e(this.f860f, (f5.c) obj5, this.d, set);
        eVar.f857b = (f4.c) obj2;
        eVar.f858c = obj3;
        return eVar.invokeSuspend(a0.f883a);
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) throws a {
        g5.a aVar = g5.a.f2984a;
        int i8 = this.f856a;
        if (i8 != 0) {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            a.a.c0(obj);
            return obj;
        }
        a.a.c0(obj);
        f4.c cVar = this.f857b;
        Object obj2 = this.f858c;
        this.f857b = null;
        this.f856a = 1;
        Object objA = i.a(this.d, this.f859e, this.f860f, cVar, obj2, this);
        return objA == aVar ? aVar : objA;
    }
}
