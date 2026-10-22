package k3;

import java.io.IOException;
import java.io.InputStream;
import kotlin.UByte;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: k3.h, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0693h extends InputStream {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13354a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ InterfaceC0696k f13355b;

    public /* synthetic */ C0693h(InterfaceC0696k interfaceC0696k, int i4) {
        this.f13354a = i4;
        this.f13355b = interfaceC0696k;
    }

    @Override // java.io.InputStream
    public final int available() throws IOException {
        int i4 = this.f13354a;
        InterfaceC0696k interfaceC0696k = this.f13355b;
        switch (i4) {
            case 0:
                return (int) Math.min(((C0694i) interfaceC0696k).f13357b, Integer.MAX_VALUE);
            default:
                v vVar = (v) interfaceC0696k;
                if (vVar.f13384c) {
                    throw new IOException("closed");
                }
                return (int) Math.min(vVar.f13383b.f13357b, Integer.MAX_VALUE);
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        switch (this.f13354a) {
            case 0:
                break;
            default:
                ((v) this.f13355b).close();
                break;
        }
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        int i4 = this.f13354a;
        InterfaceC0696k interfaceC0696k = this.f13355b;
        switch (i4) {
            case 0:
                C0694i c0694i = (C0694i) interfaceC0696k;
                if (c0694i.f13357b > 0) {
                    return c0694i.readByte() & UByte.MAX_VALUE;
                }
                return -1;
            default:
                v vVar = (v) interfaceC0696k;
                if (vVar.f13384c) {
                    throw new IOException("closed");
                }
                C0694i c0694i2 = vVar.f13383b;
                if (c0694i2.f13357b == 0 && vVar.f13382a.read(c0694i2, 8192L) == -1) {
                    return -1;
                }
                return c0694i2.readByte() & UByte.MAX_VALUE;
        }
    }

    public final String toString() {
        int i4 = this.f13354a;
        InterfaceC0696k interfaceC0696k = this.f13355b;
        switch (i4) {
            case 0:
                return ((C0694i) interfaceC0696k) + ".inputStream()";
            default:
                return ((v) interfaceC0696k) + ".inputStream()";
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] sink, int i4, int i5) throws IOException {
        int i6 = this.f13354a;
        InterfaceC0696k interfaceC0696k = this.f13355b;
        switch (i6) {
            case 0:
                Intrinsics.checkNotNullParameter(sink, "sink");
                return ((C0694i) interfaceC0696k).w(sink, i4, i5);
            default:
                Intrinsics.checkNotNullParameter(sink, "data");
                v vVar = (v) interfaceC0696k;
                if (!vVar.f13384c) {
                    AbstractC0685G.b(sink.length, i4, i5);
                    C0694i c0694i = vVar.f13383b;
                    if (c0694i.f13357b == 0 && vVar.f13382a.read(c0694i, 8192L) == -1) {
                        return -1;
                    }
                    return c0694i.w(sink, i4, i5);
                }
                throw new IOException("closed");
        }
    }
}
