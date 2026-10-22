package d2;

import java.util.ArrayList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e extends l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f8276a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList f8277b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f8278c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ArrayList f8279d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ d f8280e;

    public e(d dVar, Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2) {
        this.f8280e = dVar;
        this.f8276a = obj;
        this.f8277b = arrayList;
        this.f8278c = obj2;
        this.f8279d = arrayList2;
    }

    @Override // d2.l, d2.i.d
    public final void a(i iVar) {
        d dVar = this.f8280e;
        Object obj = this.f8276a;
        if (obj != null) {
            dVar.s(obj, this.f8277b, null);
        }
        Object obj2 = this.f8278c;
        if (obj2 != null) {
            dVar.s(obj2, this.f8279d, null);
        }
    }

    @Override // d2.i.d
    public final void c(i iVar) {
        iVar.x(this);
    }
}
