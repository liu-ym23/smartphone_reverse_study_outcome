package b7;

import c7.m;
import java.io.Closeable;
import java.util.zip.Deflater;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f931a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f932b;

    /* renamed from: c, reason: collision with root package name */
    public final c7.f f933c;
    public Object d;

    /* renamed from: e, reason: collision with root package name */
    public Closeable f934e;

    public a(boolean z, int i8) {
        this.f931a = i8;
        switch (i8) {
            case 1:
                this.f932b = z;
                this.f933c = new c7.f();
                break;
            default:
                this.f932b = z;
                c7.f fVar = new c7.f();
                this.f933c = fVar;
                Deflater deflater = new Deflater(-1, true);
                this.d = deflater;
                this.f934e = new c7.j(fVar, deflater);
                break;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        switch (this.f931a) {
            case 0:
                ((c7.j) this.f934e).close();
                break;
            default:
                m mVar = (m) this.f934e;
                if (mVar != null) {
                    mVar.close();
                }
                this.f934e = null;
                this.d = null;
                break;
        }
    }
}
