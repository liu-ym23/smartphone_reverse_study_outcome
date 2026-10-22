package d5;

import com.google.gson.Strictness;
import g5.p;
import java.io.IOException;
import java.io.StringWriter;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class o {
    @Deprecated
    public o() {
    }

    public boolean a() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public int b() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public final q c() {
        if (this instanceof q) {
            return (q) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public final r d() {
        if (this instanceof r) {
            return (r) this;
        }
        throw new IllegalStateException("Not a JSON Primitive: " + this);
    }

    public long e() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String f() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public final String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            k5.b bVar = new k5.b(stringWriter);
            bVar.f9942k = Strictness.f5434a;
            g5.p.z.getClass();
            p.t.d(this, bVar);
            return stringWriter.toString();
        } catch (IOException e10) {
            throw new AssertionError(e10);
        }
    }
}
