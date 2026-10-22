package ad;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class t implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public a f171a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a extends Reader {

        /* renamed from: a, reason: collision with root package name */
        public final sd.h f172a;

        /* renamed from: b, reason: collision with root package name */
        public final Charset f173b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f174c;

        /* renamed from: d, reason: collision with root package name */
        public InputStreamReader f175d;

        public a(sd.h source, Charset charset) {
            kotlin.jvm.internal.g.f(source, "source");
            kotlin.jvm.internal.g.f(charset, "charset");
            this.f172a = source;
            this.f173b = charset;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            lb.n nVar;
            this.f174c = true;
            InputStreamReader inputStreamReader = this.f175d;
            if (inputStreamReader != null) {
                inputStreamReader.close();
                nVar = lb.n.f10413a;
            } else {
                nVar = null;
            }
            if (nVar == null) {
                this.f172a.close();
            }
        }

        @Override // java.io.Reader
        public final int read(char[] cbuf, int i10, int i11) throws IOException {
            kotlin.jvm.internal.g.f(cbuf, "cbuf");
            if (this.f174c) {
                throw new IOException("Stream closed");
            }
            InputStreamReader inputStreamReader = this.f175d;
            if (inputStreamReader == null) {
                sd.h hVar = this.f172a;
                inputStreamReader = new InputStreamReader(hVar.F0(), bd.l.g(hVar, this.f173b));
                this.f175d = inputStreamReader;
            }
            return inputStreamReader.read(cbuf, i10, i11);
        }
    }

    public final String C() throws IOException {
        Charset charsetA;
        sd.h hVarW = w();
        try {
            l lVarO = o();
            if (lVarO == null || (charsetA = l.a(lVarO)) == null) {
                charsetA = gc.a.f9106b;
            }
            String strP0 = hVarW.p0(bd.l.g(hVarW, charsetA));
            hVarW.close();
            return strP0;
        } finally {
        }
    }

    public abstract long a();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        bd.i.b(w());
    }

    public abstract l o();

    public abstract sd.h w();
}
