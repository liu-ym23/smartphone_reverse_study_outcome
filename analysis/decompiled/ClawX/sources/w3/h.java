package w3;

import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class h implements f5.f {

    /* renamed from: b, reason: collision with root package name */
    public static final p0.b f6195b = new p0.b(15);

    /* renamed from: a, reason: collision with root package name */
    public final f5.h f6196a;

    public h(f5.h callContext) {
        p.e(callContext, "callContext");
        this.f6196a = callContext;
    }

    @Override // f5.f
    public final f5.g getKey() {
        return f6195b;
    }

    @Override // f5.h
    public final f5.f o(f5.g gVar) {
        return b8.h.o(this, gVar);
    }

    @Override // f5.h
    public final f5.h s(f5.g gVar) {
        return b8.h.y(this, gVar);
    }

    @Override // f5.h
    public final f5.h t(f5.h hVar) {
        return b8.h.I(this, hVar);
    }

    @Override // f5.h
    public final Object z(Object obj, p5.p pVar) {
        return pVar.invoke(obj, this);
    }
}
