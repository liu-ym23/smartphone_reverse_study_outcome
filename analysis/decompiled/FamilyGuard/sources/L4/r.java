package L4;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class r implements f {

    /* renamed from: a, reason: collision with root package name */
    public final e f3966a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f3967b;

    /* renamed from: c, reason: collision with root package name */
    public final w f3968c;

    public r(w wVar) {
        j4.k.h(wVar, "sink");
        this.f3968c = wVar;
        this.f3966a = new e();
    }

    @Override // L4.f
    public f H(String str) {
        j4.k.h(str, "string");
        if (this.f3967b) {
            throw new IllegalStateException("closed");
        }
        this.f3966a.H(str);
        return a();
    }

    @Override // L4.f
    public f Q(long j5) {
        if (this.f3967b) {
            throw new IllegalStateException("closed");
        }
        this.f3966a.Q(j5);
        return a();
    }

    @Override // L4.f
    public f R(h hVar) {
        j4.k.h(hVar, "byteString");
        if (this.f3967b) {
            throw new IllegalStateException("closed");
        }
        this.f3966a.R(hVar);
        return a();
    }

    public f a() {
        if (this.f3967b) {
            throw new IllegalStateException("closed");
        }
        long jW = this.f3966a.w();
        if (jW > 0) {
            this.f3968c.y0(this.f3966a, jW);
        }
        return this;
    }

    @Override // L4.w
    public z b() {
        return this.f3968c.b();
    }

    @Override // L4.w, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.f3967b) {
            return;
        }
        try {
            if (this.f3966a.size() > 0) {
                w wVar = this.f3968c;
                e eVar = this.f3966a;
                wVar.y0(eVar, eVar.size());
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.f3968c.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.f3967b = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // L4.f, L4.w, java.io.Flushable
    public void flush() {
        if (this.f3967b) {
            throw new IllegalStateException("closed");
        }
        if (this.f3966a.size() > 0) {
            w wVar = this.f3968c;
            e eVar = this.f3966a;
            wVar.y0(eVar, eVar.size());
        }
        this.f3968c.flush();
    }

    @Override // L4.f
    public e i() {
        return this.f3966a;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f3967b;
    }

    @Override // L4.f
    public f r0(long j5) {
        if (this.f3967b) {
            throw new IllegalStateException("closed");
        }
        this.f3966a.r0(j5);
        return a();
    }

    public String toString() {
        return "buffer(" + this.f3968c + ')';
    }

    @Override // L4.f
    public f write(byte[] bArr) {
        j4.k.h(bArr, "source");
        if (this.f3967b) {
            throw new IllegalStateException("closed");
        }
        this.f3966a.write(bArr);
        return a();
    }

    @Override // L4.f
    public f writeByte(int i5) {
        if (this.f3967b) {
            throw new IllegalStateException("closed");
        }
        this.f3966a.writeByte(i5);
        return a();
    }

    @Override // L4.f
    public f writeInt(int i5) {
        if (this.f3967b) {
            throw new IllegalStateException("closed");
        }
        this.f3966a.writeInt(i5);
        return a();
    }

    @Override // L4.f
    public f writeShort(int i5) {
        if (this.f3967b) {
            throw new IllegalStateException("closed");
        }
        this.f3966a.writeShort(i5);
        return a();
    }

    @Override // L4.w
    public void y0(e eVar, long j5) {
        j4.k.h(eVar, "source");
        if (this.f3967b) {
            throw new IllegalStateException("closed");
        }
        this.f3966a.y0(eVar, j5);
        a();
    }

    @Override // L4.f
    public f write(byte[] bArr, int i5, int i6) {
        j4.k.h(bArr, "source");
        if (!this.f3967b) {
            this.f3966a.write(bArr, i5, i6);
            return a();
        }
        throw new IllegalStateException("closed");
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        j4.k.h(byteBuffer, "source");
        if (!this.f3967b) {
            int iWrite = this.f3966a.write(byteBuffer);
            a();
            return iWrite;
        }
        throw new IllegalStateException("closed");
    }
}
