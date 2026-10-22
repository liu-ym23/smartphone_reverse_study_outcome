package f5;

import p5.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class a implements f {

    /* renamed from: a, reason: collision with root package name */
    public final g f2622a;

    public a(g gVar) {
        this.f2622a = gVar;
    }

    @Override // f5.f
    public final g getKey() {
        return this.f2622a;
    }

    @Override // f5.h
    public /* bridge */ f o(g gVar) {
        return b8.h.o(this, gVar);
    }

    @Override // f5.h
    public /* bridge */ h s(g gVar) {
        return b8.h.y(this, gVar);
    }

    @Override // f5.h
    public final /* bridge */ h t(h hVar) {
        return b8.h.I(this, hVar);
    }

    @Override // f5.h
    public final Object z(Object obj, p pVar) {
        return pVar.invoke(obj, this);
    }
}
