package c7;

import java.nio.ByteBuffer;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class o implements g {

    /* renamed from: a, reason: collision with root package name */
    public final t f1181a;

    /* renamed from: b, reason: collision with root package name */
    public final f f1182b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f1183c;

    public o(t sink) {
        kotlin.jvm.internal.p.e(sink, "sink");
        this.f1181a = sink;
        this.f1182b = new f();
    }

    @Override // c7.g
    public final g B(String string) {
        kotlin.jvm.internal.p.e(string, "string");
        if (this.f1183c) {
            throw new IllegalStateException("closed");
        }
        this.f1182b.I(string);
        a();
        return this;
    }

    public final g a() {
        if (this.f1183c) {
            throw new IllegalStateException("closed");
        }
        f fVar = this.f1182b;
        long j4 = fVar.f1164b;
        if (j4 == 0) {
            j4 = 0;
        } else {
            q qVar = fVar.f1163a;
            kotlin.jvm.internal.p.b(qVar);
            q qVar2 = qVar.f1192g;
            kotlin.jvm.internal.p.b(qVar2);
            if (qVar2.f1189c < 8192 && qVar2.f1190e) {
                j4 -= r6 - qVar2.f1188b;
            }
        }
        if (j4 > 0) {
            this.f1181a.x(j4, fVar);
        }
        return this;
    }

    @Override // c7.g
    public final f c() {
        return this.f1182b;
    }

    @Override // c7.t, java.lang.AutoCloseable, java.nio.channels.Channel
    public final void close() throws Throwable {
        t tVar = this.f1181a;
        if (this.f1183c) {
            return;
        }
        try {
            f fVar = this.f1182b;
            long j4 = fVar.f1164b;
            if (j4 > 0) {
                tVar.x(j4, fVar);
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            tVar.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.f1183c = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // c7.t
    public final x d() {
        return this.f1181a.d();
    }

    @Override // c7.g, c7.t, java.io.Flushable
    public final void flush() {
        if (this.f1183c) {
            throw new IllegalStateException("closed");
        }
        f fVar = this.f1182b;
        long j4 = fVar.f1164b;
        t tVar = this.f1181a;
        if (j4 > 0) {
            tVar.x(j4, fVar);
        }
        tVar.flush();
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.f1183c;
    }

    @Override // c7.g
    public final g r(i byteString) {
        kotlin.jvm.internal.p.e(byteString, "byteString");
        if (this.f1183c) {
            throw new IllegalStateException("closed");
        }
        this.f1182b.u(byteString);
        a();
        return this;
    }

    public final String toString() {
        return "buffer(" + this.f1181a + ')';
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer source) {
        kotlin.jvm.internal.p.e(source, "source");
        if (this.f1183c) {
            throw new IllegalStateException("closed");
        }
        int iWrite = this.f1182b.write(source);
        a();
        return iWrite;
    }

    @Override // c7.g
    public final g writeByte(int i8) {
        if (this.f1183c) {
            throw new IllegalStateException("closed");
        }
        this.f1182b.A(i8);
        a();
        return this;
    }

    @Override // c7.g
    public final g writeInt(int i8) {
        if (this.f1183c) {
            throw new IllegalStateException("closed");
        }
        this.f1182b.F(i8);
        a();
        return this;
    }

    @Override // c7.g
    public final g writeShort(int i8) {
        if (this.f1183c) {
            throw new IllegalStateException("closed");
        }
        this.f1182b.G(i8);
        a();
        return this;
    }

    @Override // c7.t
    public final void x(long j4, f source) {
        kotlin.jvm.internal.p.e(source, "source");
        if (this.f1183c) {
            throw new IllegalStateException("closed");
        }
        this.f1182b.x(j4, source);
        a();
    }

    @Override // c7.g
    public final g write(byte[] bArr) {
        if (!this.f1183c) {
            this.f1182b.v(bArr, bArr.length);
            a();
            return this;
        }
        throw new IllegalStateException("closed");
    }
}
