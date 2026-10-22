package nb;

import java.io.Closeable;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import ob.t;

/* loaded from: classes.dex */
public final class a implements Closeable {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f6934f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f6935g;

    /* renamed from: h, reason: collision with root package name */
    public final ob.h f6936h;

    /* renamed from: i, reason: collision with root package name */
    public final Object f6937i;

    /* renamed from: j, reason: collision with root package name */
    public final Closeable f6938j;

    public a(boolean z4, int i2) {
        this.f6934f = i2;
        switch (i2) {
            case 1:
                this.f6935g = z4;
                ob.h hVar = new ob.h();
                this.f6936h = hVar;
                Inflater inflater = new Inflater(true);
                this.f6937i = inflater;
                this.f6938j = new t(ob.b.c(hVar), inflater);
                break;
            default:
                this.f6935g = z4;
                ob.h hVar2 = new ob.h();
                this.f6936h = hVar2;
                Deflater deflater = new Deflater(-1, true);
                this.f6937i = deflater;
                this.f6938j = new gb.f(hVar2, deflater);
                break;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        switch (this.f6934f) {
            case 0:
                ((gb.f) this.f6938j).close();
                break;
            default:
                ((t) this.f6938j).close();
                break;
        }
    }
}
