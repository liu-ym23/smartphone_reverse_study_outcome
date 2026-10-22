package C4;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public abstract class G implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private Reader f723a;

    class a extends G {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ y f724b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f725c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ L4.g f726d;

        a(y yVar, long j5, L4.g gVar) {
            this.f724b = yVar;
            this.f725c = j5;
            this.f726d = gVar;
        }

        @Override // C4.G
        public long o() {
            return this.f725c;
        }

        @Override // C4.G
        @Nullable
        public y r() {
            return this.f724b;
        }

        @Override // C4.G
        public L4.g w() {
            return this.f726d;
        }
    }

    static final class b extends Reader {

        /* renamed from: a, reason: collision with root package name */
        private final L4.g f727a;

        /* renamed from: b, reason: collision with root package name */
        private final Charset f728b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f729c;

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        private Reader f730d;

        b(L4.g gVar, Charset charset) {
            this.f727a = gVar;
            this.f728b = charset;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f729c = true;
            Reader reader = this.f730d;
            if (reader != null) {
                reader.close();
            } else {
                this.f727a.close();
            }
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i5, int i6) throws IOException {
            if (this.f729c) {
                throw new IOException("Stream closed");
            }
            Reader reader = this.f730d;
            if (reader == null) {
                InputStreamReader inputStreamReader = new InputStreamReader(this.f727a.x0(), D4.e.c(this.f727a, this.f728b));
                this.f730d = inputStreamReader;
                reader = inputStreamReader;
            }
            return reader.read(cArr, i5, i6);
        }
    }

    private static /* synthetic */ void a(Throwable th, AutoCloseable autoCloseable) throws Exception {
        if (th == null) {
            X.f.a(autoCloseable);
            return;
        }
        try {
            X.f.a(autoCloseable);
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
    }

    private Charset m() {
        y yVarR = r();
        return yVarR != null ? yVarR.a(StandardCharsets.UTF_8) : StandardCharsets.UTF_8;
    }

    public static G u(@Nullable y yVar, long j5, L4.g gVar) {
        if (gVar != null) {
            return new a(yVar, j5, gVar);
        }
        throw new NullPointerException("source == null");
    }

    public static G v(@Nullable y yVar, byte[] bArr) {
        return u(yVar, bArr.length, new L4.e().write(bArr));
    }

    public final InputStream c() {
        return w().x0();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        D4.e.g(w());
    }

    public final Reader f() {
        Reader reader = this.f723a;
        if (reader != null) {
            return reader;
        }
        b bVar = new b(w(), m());
        this.f723a = bVar;
        return bVar;
    }

    public abstract long o();

    @Nullable
    public abstract y r();

    public abstract L4.g w();

    public final String x() throws Exception {
        L4.g gVarW = w();
        try {
            String strK = gVarW.K(D4.e.c(gVarW, m()));
            a(null, gVarW);
            return strK;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (gVarW != null) {
                    a(th, gVarW);
                }
                throw th2;
            }
        }
    }
}
