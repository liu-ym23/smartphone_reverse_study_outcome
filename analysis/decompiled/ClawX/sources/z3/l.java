package z3;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class l extends InputStream {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6472a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f6473b;

    public /* synthetic */ l(int i8, Object obj) {
        this.f6472a = i8;
        this.f6473b = obj;
    }

    @Override // java.io.InputStream
    public int available() {
        switch (this.f6472a) {
            case 0:
                return ((l) this.f6473b).available();
            default:
                return super.available();
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        switch (this.f6472a) {
            case 0:
                super.close();
                ((l) this.f6473b).close();
                break;
            default:
                io.ktor.utils.io.h0.b((io.ktor.utils.io.p) this.f6473b);
                break;
        }
    }

    @Override // java.io.InputStream
    public final int read() throws Throwable {
        switch (this.f6472a) {
            case 0:
                return ((l) this.f6473b).read();
            default:
                io.ktor.utils.io.p pVar = (io.ktor.utils.io.p) this.f6473b;
                if (!pVar.e()) {
                    if (pVar.b().q()) {
                        a6.i0.u(f5.i.f2626a, new z4.a(pVar, null));
                    }
                    if (!pVar.e()) {
                        return pVar.b().readByte() & 255;
                    }
                }
                return -1;
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] b9, int i8, int i9) throws Throwable {
        switch (this.f6472a) {
            case 0:
                kotlin.jvm.internal.p.e(b9, "b");
                return ((l) this.f6473b).read(b9, i8, i9);
            default:
                kotlin.jvm.internal.p.e(b9, "b");
                io.ktor.utils.io.p pVar = (io.ktor.utils.io.p) this.f6473b;
                if (!pVar.e()) {
                    if (pVar.b().q()) {
                        a6.i0.u(f5.i.f2626a, new z4.a(pVar, null));
                    }
                    int iB = pVar.b().b(i8, Math.min(io.ktor.utils.io.h0.g(pVar), i9) + i8, b9);
                    if (iB >= 0) {
                        return iB;
                    }
                    if (!pVar.e()) {
                        return 0;
                    }
                }
                return -1;
        }
    }
}
