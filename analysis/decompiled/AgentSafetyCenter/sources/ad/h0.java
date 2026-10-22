package ad;

import java.io.Closeable;
import java.io.IOException;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class h0 implements Closeable {

    /* renamed from: c, reason: collision with root package name */
    public f0 f511c;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        bd.b.d(g());
    }

    public abstract long d();

    public abstract s e();

    public abstract od.k g();

    public final String i() throws IOException {
        Charset charsetA;
        od.k kVarG = g();
        try {
            s sVarE = e();
            if (sVarE == null || (charsetA = sVarE.a(hc.a.f5448a)) == null) {
                charsetA = hc.a.f5448a;
            }
            String strX = kVarG.x(bd.b.r(kVarG, charsetA));
            kVarG.close();
            return strX;
        } finally {
        }
    }
}
