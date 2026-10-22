package F9;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

/* loaded from: classes4.dex */
public final class N extends Reader {

    /* renamed from: a, reason: collision with root package name */
    public final V9.i f633a;
    public final Charset b;
    public boolean c;
    public InputStreamReader d;

    public N(V9.i source, Charset charset) {
        kotlin.jvm.internal.k.f(source, "source");
        kotlin.jvm.internal.k.f(charset, "charset");
        this.f633a = source;
        this.b = charset;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        C7.r rVar;
        this.c = true;
        InputStreamReader inputStreamReader = this.d;
        if (inputStreamReader != null) {
            inputStreamReader.close();
            rVar = C7.r.f317a;
        } else {
            rVar = null;
        }
        if (rVar == null) {
            this.f633a.close();
        }
    }

    @Override // java.io.Reader
    public final int read(char[] cbuf, int i, int i6) throws IOException {
        kotlin.jvm.internal.k.f(cbuf, "cbuf");
        if (this.c) {
            throw new IOException("Stream closed");
        }
        InputStreamReader inputStreamReader = this.d;
        if (inputStreamReader == null) {
            V9.i iVar = this.f633a;
            inputStreamReader = new InputStreamReader(iVar.D(), G9.b.q(iVar, this.b));
            this.d = inputStreamReader;
        }
        return inputStreamReader.read(cbuf, i, i6);
    }
}
