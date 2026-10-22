package F9;

import j9.AbstractC1607a;
import java.io.Closeable;
import java.io.IOException;
import java.nio.charset.Charset;

/* loaded from: classes4.dex */
public abstract class P implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public N f634a;

    public abstract long b();

    public abstract B c();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        G9.b.c(f());
    }

    public abstract V9.i f();

    public final String g() throws IOException {
        Charset charsetA;
        V9.i iVarF = f();
        try {
            B bC = c();
            if (bC == null || (charsetA = bC.a(AbstractC1607a.f4778a)) == null) {
                charsetA = AbstractC1607a.f4778a;
            }
            String strX = iVarF.x(G9.b.q(iVarF, charsetA));
            iVarF.close();
            return strX;
        } finally {
        }
    }
}
