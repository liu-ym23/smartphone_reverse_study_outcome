package h3;

import java.io.IOException;

/* renamed from: h3.f, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0597f extends k3.n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0599h f12902a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0598g f12903b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0597f(C0599h c0599h, C0598g c0598g, k3.z zVar) {
        super(zVar);
        this.f12902a = c0599h;
        this.f12903b = c0598g;
    }

    @Override // k3.n, k3.z, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        C0599h c0599h = this.f12902a;
        C0598g c0598g = this.f12903b;
        synchronized (c0599h) {
            if (c0598g.f12907d) {
                return;
            }
            c0598g.f12907d = true;
            super.close();
            this.f12903b.f12904a.commit();
        }
    }
}
