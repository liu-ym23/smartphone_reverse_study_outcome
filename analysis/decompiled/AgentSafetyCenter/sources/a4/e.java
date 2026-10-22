package a4;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public j f164a;

    /* renamed from: b, reason: collision with root package name */
    public volatile p5.m f165b;

    /* renamed from: c, reason: collision with root package name */
    public volatile p5.i f166c;

    public final void a() {
        j jVar = this.f164a;
        try {
            d dVar = new d();
            dVar.f163c = this;
            VarHandle.storeStoreFence();
            jVar.f180f.a(dVar);
        } catch (Throwable th) {
            jVar.e(th);
        }
    }
}
