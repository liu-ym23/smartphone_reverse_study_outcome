package eb;

import java.io.Closeable;

/* loaded from: classes.dex */
public final class l implements Closeable {

    /* renamed from: f, reason: collision with root package name */
    public final ob.j f3293f;

    /* renamed from: g, reason: collision with root package name */
    public final ob.i f3294g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ c1.o f3295h;

    public l(ob.j jVar, ob.i iVar, c1.o oVar) {
        this.f3295h = oVar;
        q7.k.e(jVar, "source");
        q7.k.e(iVar, "sink");
        this.f3293f = jVar;
        this.f3294g = iVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f3295h.a(true, true, null);
    }
}
