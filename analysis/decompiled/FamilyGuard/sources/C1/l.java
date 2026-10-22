package C1;

import A1.r;
import D1.n;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;

/* loaded from: classes.dex */
public final class l {
    public static A1.j a(G1.a aVar) {
        boolean z5;
        try {
            try {
                aVar.V();
                z5 = false;
            } catch (EOFException e6) {
                e = e6;
                z5 = true;
            }
            try {
                return n.f1127X.b(aVar);
            } catch (EOFException e7) {
                e = e7;
                if (z5) {
                    return A1.l.f64a;
                }
                throw new r(e);
            }
        } catch (G1.d e8) {
            throw new r(e8);
        } catch (IOException e9) {
            throw new A1.k(e9);
        } catch (NumberFormatException e10) {
            throw new r(e10);
        }
    }

    public static void b(A1.j jVar, G1.c cVar) {
        n.f1127X.d(cVar, jVar);
    }

    public static Writer c(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new a(appendable);
    }

    private static final class a extends Writer {

        /* renamed from: a, reason: collision with root package name */
        private final Appendable f593a;

        /* renamed from: b, reason: collision with root package name */
        private final C0015a f594b = new C0015a();

        /* renamed from: C1.l$a$a, reason: collision with other inner class name */
        static class C0015a implements CharSequence {

            /* renamed from: a, reason: collision with root package name */
            char[] f595a;

            C0015a() {
            }

            @Override // java.lang.CharSequence
            public char charAt(int i5) {
                return this.f595a[i5];
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.f595a.length;
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i5, int i6) {
                return new String(this.f595a, i5, i6 - i5);
            }
        }

        a(Appendable appendable) {
            this.f593a = appendable;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i5, int i6) throws IOException {
            C0015a c0015a = this.f594b;
            c0015a.f595a = cArr;
            this.f593a.append(c0015a, i5, i6 + i5);
        }

        @Override // java.io.Writer
        public void write(int i5) throws IOException {
            this.f593a.append((char) i5);
        }
    }
}
