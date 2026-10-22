package B1;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;

/* loaded from: classes2.dex */
public final class d extends c {
    public final BufferedOutputStream c;
    public int d;
    public final ByteArrayOutputStream e;

    public d(BufferedOutputStream bufferedOutputStream) {
        super(null);
        this.d = 0;
        this.e = new ByteArrayOutputStream();
        this.c = bufferedOutputStream;
    }

    @Override // B1.c
    public final b a(int i, int i6, long j5) {
        try {
            return new b(this, i, 1);
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    @Override // B1.c
    public final void b() {
        try {
            this.c.flush();
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    @Override // B1.c
    public final void c(int i, int i6, long j5, byte[] bArr) {
        if (i == 44) {
            try {
                this.c.write(i);
            } catch (Throwable th) {
                throw new RuntimeException(th);
            }
        }
    }

    @Override // B1.c
    public final void d(int i, int i6, e[] eVarArr, int i10, long j5) {
    }

    @Override // B1.c
    public final void e(int i, e eVar, int i6, e eVar2, int i10, long j5) {
        BufferedOutputStream bufferedOutputStream = this.c;
        try {
            bufferedOutputStream.write(2);
            bufferedOutputStream.write(eVar.f181a);
            bufferedOutputStream.write(eVar2.f181a);
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    @Override // B1.c
    public final void g(int i, String str, long j5) {
        try {
            this.d = i;
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    @Override // B1.c
    public final void h(e eVar, e eVar2, e eVar3, e eVar4, int i, int i6, int i10, long j5) {
    }

    @Override // B1.c
    public final void i(e eVar, String str, int i, long j5) {
        BufferedOutputStream bufferedOutputStream = this.c;
        try {
            bufferedOutputStream.write(1);
            S0.b.m0(bufferedOutputStream, (int) j5);
            bufferedOutputStream.write(eVar.f181a);
            byte[] bytes = str.getBytes(Charset.forName("UTF-8"));
            bufferedOutputStream.write(bytes, 0, bytes.length);
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }
}
