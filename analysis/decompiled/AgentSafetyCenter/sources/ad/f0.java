package ad;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f0 extends Reader {

    /* renamed from: c, reason: collision with root package name */
    public final od.k f481c;

    /* renamed from: f, reason: collision with root package name */
    public final Charset f482f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f483g;

    /* renamed from: h, reason: collision with root package name */
    public InputStreamReader f484h;

    public f0(od.k kVar, Charset charset) {
        kVar.getClass();
        charset.getClass();
        this.f481c = kVar;
        this.f482f = charset;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        jb.v vVar;
        this.f483g = true;
        InputStreamReader inputStreamReader = this.f484h;
        if (inputStreamReader != null) {
            inputStreamReader.close();
            vVar = jb.v.f6774a;
        } else {
            vVar = null;
        }
        if (vVar == null) {
            this.f481c.close();
        }
    }

    @Override // java.io.Reader
    public final int read(char[] cArr, int i, int i3) throws IOException {
        cArr.getClass();
        if (this.f483g) {
            od.f.l("Stream closed");
            return 0;
        }
        InputStreamReader inputStreamReader = this.f484h;
        if (inputStreamReader == null) {
            od.k kVar = this.f481c;
            inputStreamReader = new InputStreamReader(kVar.L(), bd.b.r(kVar, this.f482f));
            this.f484h = inputStreamReader;
        }
        return inputStreamReader.read(cArr, i, i3);
    }
}
