package n4;

import b5.a0;
import io.ktor.utils.io.d0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a extends d {

    /* renamed from: a, reason: collision with root package name */
    public final c4.a f3975a;

    /* renamed from: b, reason: collision with root package name */
    public final k4.g f3976b;

    public a(c4.a aVar, k4.g gVar) {
        this.f3975a = aVar;
        this.f3976b = gVar;
    }

    @Override // n4.e
    public final Long a() {
        return null;
    }

    @Override // n4.e
    public final k4.g b() {
        return this.f3976b;
    }

    @Override // n4.d
    public final Object d(d0 d0Var, f5.c cVar) {
        Object objInvoke = this.f3975a.invoke(d0Var, cVar);
        return objInvoke == g5.a.f2984a ? objInvoke : a0.f883a;
    }
}
