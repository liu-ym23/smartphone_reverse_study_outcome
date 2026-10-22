package ab;

import java.io.Closeable;
import java.io.IOException;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public abstract class b0 implements Closeable {
    public abstract long a();

    public abstract r b();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        bb.b.d(d());
    }

    public abstract ob.j d();

    public final String e() throws IOException {
        Charset charsetA;
        ob.j jVarD = d();
        try {
            r rVarB = b();
            if (rVarB == null || (charsetA = rVarB.a(ga.a.f4005a)) == null) {
                charsetA = ga.a.f4005a;
            }
            String strP = jVarD.P(bb.b.s(jVarD, charsetA));
            jVarD.close();
            return strP;
        } finally {
        }
    }
}
