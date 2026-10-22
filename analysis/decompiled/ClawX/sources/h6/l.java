package h6;

import a6.b0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class l extends b0 {

    /* renamed from: c, reason: collision with root package name */
    public static final l f3070c = new l();

    @Override // a6.b0
    public final void C(f5.h hVar, Runnable runnable) {
        e.d.f3061c.b(runnable, true, false);
    }

    @Override // a6.b0
    public final void E(f5.h hVar, Runnable runnable) {
        e.d.f3061c.b(runnable, true, true);
    }

    @Override // a6.b0
    public final b0 G(int i8) {
        f6.a.a(i8);
        return i8 >= k.d ? this : super.G(i8);
    }

    @Override // a6.b0
    public final String toString() {
        return "Dispatchers.IO";
    }
}
