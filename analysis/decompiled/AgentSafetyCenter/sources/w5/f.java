package w5;

import java.io.EOFException;
import java.io.IOException;
import od.i;
import od.p;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f extends p {

    /* renamed from: f, reason: collision with root package name */
    public a9.e f15262f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f15263g;

    @Override // od.p, od.g0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        try {
            super.close();
        } catch (IOException e10) {
            this.f15263g = true;
            this.f15262f.invoke(e10);
        }
    }

    @Override // od.p, od.g0
    public final void f(i iVar, long j10) throws EOFException {
        if (this.f15263g) {
            iVar.W(j10);
            return;
        }
        try {
            super.f(iVar, j10);
        } catch (IOException e10) {
            this.f15263g = true;
            this.f15262f.invoke(e10);
        }
    }

    @Override // od.p, od.g0, java.io.Flushable
    public final void flush() {
        try {
            super.flush();
        } catch (IOException e10) {
            this.f15263g = true;
            this.f15262f.invoke(e10);
        }
    }
}
