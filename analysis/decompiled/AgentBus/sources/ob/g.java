package ob;

import java.io.Closeable;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class g implements Closeable {

    /* renamed from: f, reason: collision with root package name */
    public h f7982f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f7983g;

    /* renamed from: h, reason: collision with root package name */
    public f0 f7984h;

    /* renamed from: j, reason: collision with root package name */
    public byte[] f7986j;

    /* renamed from: i, reason: collision with root package name */
    public long f7985i = -1;

    /* renamed from: k, reason: collision with root package name */
    public int f7987k = -1;

    /* renamed from: l, reason: collision with root package name */
    public int f7988l = -1;

    public final void a(long j2) {
        h hVar = this.f7982f;
        if (hVar == null) {
            throw new IllegalStateException("not attached to a buffer");
        }
        if (!this.f7983g) {
            throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers");
        }
        long j4 = hVar.f7993g;
        if (j2 <= j4) {
            if (j2 < 0) {
                throw new IllegalArgumentException(a1.a.h("newSize < 0: ", j2).toString());
            }
            long j10 = j4 - j2;
            while (true) {
                if (j10 <= 0) {
                    break;
                }
                f0 f0Var = hVar.f7992f;
                q7.k.b(f0Var);
                f0 f0Var2 = f0Var.f7981g;
                q7.k.b(f0Var2);
                int i2 = f0Var2.f7977c;
                long j11 = i2 - f0Var2.f7976b;
                if (j11 > j10) {
                    f0Var2.f7977c = i2 - ((int) j10);
                    break;
                } else {
                    hVar.f7992f = f0Var2.a();
                    g0.a(f0Var2);
                    j10 -= j11;
                }
            }
            this.f7984h = null;
            this.f7985i = j2;
            this.f7986j = null;
            this.f7987k = -1;
            this.f7988l = -1;
        } else if (j2 > j4) {
            long j12 = j2 - j4;
            int i10 = 1;
            boolean z4 = true;
            for (long j13 = 0; j12 > j13; j13 = 0) {
                f0 f0VarE = hVar.E(i10);
                int iMin = (int) Math.min(j12, 8192 - f0VarE.f7977c);
                int i11 = f0VarE.f7977c + iMin;
                f0VarE.f7977c = i11;
                j12 -= iMin;
                if (z4) {
                    this.f7984h = f0VarE;
                    this.f7985i = j4;
                    this.f7986j = f0VarE.f7975a;
                    this.f7987k = i11 - iMin;
                    this.f7988l = i11;
                    z4 = false;
                }
                i10 = 1;
            }
        }
        hVar.f7993g = j2;
    }

    public final int b(long j2) {
        h hVar = this.f7982f;
        if (hVar == null) {
            throw new IllegalStateException("not attached to a buffer");
        }
        if (j2 >= -1) {
            long j4 = hVar.f7993g;
            if (j2 <= j4) {
                if (j2 == -1 || j2 == j4) {
                    this.f7984h = null;
                    this.f7985i = j2;
                    this.f7986j = null;
                    this.f7987k = -1;
                    this.f7988l = -1;
                    return -1;
                }
                f0 f0Var = hVar.f7992f;
                f0 f0Var2 = this.f7984h;
                long j10 = 0;
                if (f0Var2 != null) {
                    long j11 = this.f7985i - (this.f7987k - f0Var2.f7976b);
                    if (j11 > j2) {
                        f0Var2 = f0Var;
                        f0Var = f0Var2;
                        j4 = j11;
                    } else {
                        j10 = j11;
                    }
                } else {
                    f0Var2 = f0Var;
                }
                if (j4 - j2 > j2 - j10) {
                    while (true) {
                        q7.k.b(f0Var2);
                        long j12 = (f0Var2.f7977c - f0Var2.f7976b) + j10;
                        if (j2 < j12) {
                            break;
                        }
                        f0Var2 = f0Var2.f7980f;
                        j10 = j12;
                    }
                } else {
                    while (j4 > j2) {
                        q7.k.b(f0Var);
                        f0Var = f0Var.f7981g;
                        q7.k.b(f0Var);
                        j4 -= f0Var.f7977c - f0Var.f7976b;
                    }
                    f0Var2 = f0Var;
                    j10 = j4;
                }
                if (this.f7983g) {
                    q7.k.b(f0Var2);
                    if (f0Var2.f7978d) {
                        byte[] bArr = f0Var2.f7975a;
                        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
                        q7.k.d(bArrCopyOf, "copyOf(...)");
                        f0 f0Var3 = new f0(bArrCopyOf, f0Var2.f7976b, f0Var2.f7977c, false, true);
                        if (hVar.f7992f == f0Var2) {
                            hVar.f7992f = f0Var3;
                        }
                        f0Var2.b(f0Var3);
                        f0 f0Var4 = f0Var3.f7981g;
                        q7.k.b(f0Var4);
                        f0Var4.a();
                        f0Var2 = f0Var3;
                    }
                }
                this.f7984h = f0Var2;
                this.f7985i = j2;
                q7.k.b(f0Var2);
                this.f7986j = f0Var2.f7975a;
                int i2 = f0Var2.f7976b + ((int) (j2 - j10));
                this.f7987k = i2;
                int i10 = f0Var2.f7977c;
                this.f7988l = i10;
                return i10 - i2;
            }
        }
        throw new ArrayIndexOutOfBoundsException("offset=" + j2 + " > size=" + hVar.f7993g);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f7982f == null) {
            throw new IllegalStateException("not attached to a buffer");
        }
        this.f7982f = null;
        this.f7984h = null;
        this.f7985i = -1L;
        this.f7986j = null;
        this.f7987k = -1;
        this.f7988l = -1;
    }
}
