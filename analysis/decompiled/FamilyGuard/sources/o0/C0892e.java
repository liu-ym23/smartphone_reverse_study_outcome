package o0;

import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.MathContext;

/* renamed from: o0.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0892e extends AbstractC0891d {

    /* renamed from: w, reason: collision with root package name */
    private static final ThreadLocal<char[]> f19011w = new ThreadLocal<>();

    /* renamed from: t, reason: collision with root package name */
    private Reader f19012t;

    /* renamed from: u, reason: collision with root package name */
    private char[] f19013u;

    /* renamed from: v, reason: collision with root package name */
    private int f19014v;

    @Override // o0.AbstractC0891d
    protected final void A0(int i5, char[] cArr, int i6, int i7) {
        System.arraycopy(this.f19013u, i5, cArr, i6, i7);
    }

    @Override // o0.AbstractC0891d
    public final boolean B0(char[] cArr) {
        for (int i5 = 0; i5 < cArr.length; i5++) {
            if (C0(this.f18999e + i5) != cArr[i5]) {
                return false;
            }
        }
        return true;
    }

    @Override // o0.AbstractC0891d, o0.InterfaceC0890c
    public final BigDecimal C() throws IOException {
        int i5 = this.f19003i;
        if (i5 == -1) {
            i5 = 0;
        }
        char cC0 = C0((this.f19002h + i5) - 1);
        int i6 = this.f19002h;
        if (cC0 == 'L' || cC0 == 'S' || cC0 == 'B' || cC0 == 'F' || cC0 == 'D') {
            i6--;
        }
        if (i6 <= 65535) {
            return new BigDecimal(this.f19013u, i5, i6, MathContext.UNLIMITED);
        }
        throw new l0.d("decimal overflow");
    }

    @Override // o0.AbstractC0891d
    public final char C0(int i5) throws IOException {
        int i6 = this.f19014v;
        if (i5 >= i6) {
            if (i6 == -1) {
                if (i5 < this.f19002h) {
                    return this.f19013u[i5];
                }
                return (char) 26;
            }
            int i7 = this.f18999e;
            if (i7 == 0) {
                char[] cArr = this.f19013u;
                int length = (cArr.length * 3) / 2;
                char[] cArr2 = new char[length];
                System.arraycopy(cArr, i7, cArr2, 0, i6);
                int i8 = this.f19014v;
                try {
                    this.f19014v += this.f19012t.read(cArr2, i8, length - i8);
                    this.f19013u = cArr2;
                } catch (IOException e6) {
                    throw new l0.d(e6.getMessage(), e6);
                }
            } else {
                int i9 = i6 - i7;
                if (i9 > 0) {
                    char[] cArr3 = this.f19013u;
                    System.arraycopy(cArr3, i7, cArr3, 0, i9);
                }
                try {
                    Reader reader = this.f19012t;
                    char[] cArr4 = this.f19013u;
                    int i10 = reader.read(cArr4, i9, cArr4.length - i9);
                    this.f19014v = i10;
                    if (i10 == 0) {
                        throw new l0.d("illegal state, textLength is zero");
                    }
                    if (i10 == -1) {
                        return (char) 26;
                    }
                    this.f19014v = i10 + i9;
                    int i11 = this.f18999e;
                    i5 -= i11;
                    this.f19003i -= i11;
                    this.f18999e = 0;
                } catch (IOException e7) {
                    throw new l0.d(e7.getMessage(), e7);
                }
            }
        }
        return this.f19013u[i5];
    }

    @Override // o0.AbstractC0891d
    protected final void D0(int i5, int i6, char[] cArr) {
        System.arraycopy(this.f19013u, i5, cArr, 0, i6);
    }

    @Override // o0.InterfaceC0890c
    public byte[] G() {
        if (this.f18995a != 26) {
            return u0.g.d(this.f19013u, this.f19003i + 1, this.f19002h);
        }
        throw new l0.d("TODO");
    }

    @Override // o0.AbstractC0891d
    public final int G0(char c6, int i5) throws IOException {
        int i6 = i5 - this.f18999e;
        while (true) {
            char cC0 = C0(this.f18999e + i6);
            if (c6 == cC0) {
                return i6 + this.f18999e;
            }
            if (cC0 == 26) {
                return -1;
            }
            i6++;
        }
    }

    @Override // o0.AbstractC0891d
    public boolean H0() {
        if (this.f19014v != -1) {
            int i5 = this.f18999e;
            char[] cArr = this.f19013u;
            if (i5 != cArr.length && (this.f18998d != 26 || i5 + 1 < cArr.length)) {
                return false;
            }
        }
        return true;
    }

    @Override // o0.AbstractC0891d, o0.InterfaceC0890c
    public final String N() {
        if (this.f19004j) {
            return new String(this.f19001g, 0, this.f19002h);
        }
        int i5 = this.f19003i + 1;
        if (i5 < 0) {
            throw new IllegalStateException();
        }
        char[] cArr = this.f19013u;
        int length = cArr.length;
        int i6 = this.f19002h;
        if (i5 <= length - i6) {
            return new String(cArr, i5, i6);
        }
        throw new IllegalStateException();
    }

    @Override // o0.AbstractC0891d, o0.InterfaceC0890c, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        char[] cArr = this.f19013u;
        if (cArr.length <= 65536) {
            f19011w.set(cArr);
        }
        this.f19013u = null;
        u0.g.a(this.f19012t);
    }

    @Override // o0.AbstractC0891d, o0.InterfaceC0890c
    public final boolean m() {
        int i5 = 0;
        while (true) {
            char c6 = this.f19013u[i5];
            if (c6 == 26) {
                this.f18995a = 20;
                return true;
            }
            if (!AbstractC0891d.I0(c6)) {
                return false;
            }
            i5++;
        }
    }

    @Override // o0.AbstractC0891d
    public final String n1(int i5, int i6) {
        if (i6 >= 0) {
            return new String(this.f19013u, i5, i6);
        }
        throw new StringIndexOutOfBoundsException(i6);
    }

    @Override // o0.AbstractC0891d, o0.InterfaceC0890c
    public final char next() throws IOException {
        int i5 = this.f18999e + 1;
        this.f18999e = i5;
        int i6 = this.f19014v;
        if (i5 >= i6) {
            if (i6 == -1) {
                return (char) 26;
            }
            int i7 = this.f19002h;
            if (i7 > 0) {
                int i8 = i6 - i7;
                if (this.f18998d == '\"' && i8 > 0) {
                    i8--;
                }
                char[] cArr = this.f19013u;
                System.arraycopy(cArr, i8, cArr, 0, i7);
            }
            this.f19003i = -1;
            int i9 = this.f19002h;
            this.f18999e = i9;
            try {
                char[] cArr2 = this.f19013u;
                int length = cArr2.length - i9;
                if (length == 0) {
                    char[] cArr3 = new char[cArr2.length * 2];
                    System.arraycopy(cArr2, 0, cArr3, 0, cArr2.length);
                    this.f19013u = cArr3;
                    length = cArr3.length - i9;
                }
                int i10 = this.f19012t.read(this.f19013u, this.f18999e, length);
                this.f19014v = i10;
                if (i10 == 0) {
                    throw new l0.d("illegal stat, textLength is zero");
                }
                if (i10 == -1) {
                    this.f18998d = (char) 26;
                    return (char) 26;
                }
                this.f19014v = i10 + this.f18999e;
                i5 = i9;
            } catch (IOException e6) {
                throw new l0.d(e6.getMessage(), e6);
            }
        }
        char c6 = this.f19013u[i5];
        this.f18998d = c6;
        return c6;
    }

    @Override // o0.AbstractC0891d
    public final char[] o1(int i5, int i6) {
        if (i6 < 0) {
            throw new StringIndexOutOfBoundsException(i6);
        }
        if (i5 == 0) {
            return this.f19013u;
        }
        char[] cArr = new char[i6];
        System.arraycopy(this.f19013u, i5, cArr, 0, i6);
        return cArr;
    }

    @Override // o0.AbstractC0891d, o0.InterfaceC0890c
    public final String w0() throws IOException {
        int i5 = this.f19003i;
        if (i5 == -1) {
            i5 = 0;
        }
        char cC0 = C0((this.f19002h + i5) - 1);
        int i6 = this.f19002h;
        if (cC0 == 'L' || cC0 == 'S' || cC0 == 'B' || cC0 == 'F' || cC0 == 'D') {
            i6--;
        }
        return new String(this.f19013u, i5, i6);
    }

    @Override // o0.AbstractC0891d
    public final String z0(int i5, int i6, int i7, C0897j c0897j) {
        return c0897j.c(this.f19013u, i5, i6, i7);
    }
}
