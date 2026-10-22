package m8;

import android.app.Application;
import android.content.res.Resources;
import java.util.LinkedHashMap;
import java.util.Set;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public int f8434c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Application f8435f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Set f8436g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ long f8437h;
    public final /* synthetic */ LinkedHashMap i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ k0 f8438j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Resources f8439k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(Application application, Set set, long j10, LinkedHashMap linkedHashMap, k0 k0Var, Resources resources, nb.c cVar) {
        super(2, cVar);
        this.f8435f = application;
        this.f8436g = set;
        this.f8437h = j10;
        this.i = linkedHashMap;
        this.f8438j = k0Var;
        this.f8439k = resources;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        return new l(this.f8435f, this.f8436g, this.f8437h, this.i, this.f8438j, this.f8439k, cVar);
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        return ((l) create((kc.t) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        ob.a aVar = ob.a.f9351c;
        int i = this.f8434c;
        if (i == 0) {
            id.c.I(obj);
            t8.c cVarL = t8.c.f13223h.l(this.f8435f);
            Set set = this.f8436g;
            cVarL.i(set, this.f8437h, this.i);
            this.f8439k.getClass();
            this.f8434c = 1;
            if (k0.j(this.f8438j, set, this) == aVar) {
                return aVar;
            }
        } else {
            if (i != 1) {
                od.f.e("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            id.c.I(obj);
        }
        return jb.v.f6774a;
    }
}
