package A1;

import java.io.IOException;
import java.io.StringWriter;

/* loaded from: classes.dex */
public abstract class j {
    public g a() {
        if (h()) {
            return (g) this;
        }
        throw new IllegalStateException("Not a JSON Array: " + this);
    }

    public m c() {
        if (m()) {
            return (m) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public o f() {
        if (n()) {
            return (o) this;
        }
        throw new IllegalStateException("Not a JSON Primitive: " + this);
    }

    public boolean h() {
        return this instanceof g;
    }

    public boolean i() {
        return this instanceof l;
    }

    public boolean m() {
        return this instanceof m;
    }

    public boolean n() {
        return this instanceof o;
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            G1.c cVar = new G1.c(stringWriter);
            cVar.S(true);
            C1.l.b(this, cVar);
            return stringWriter.toString();
        } catch (IOException e6) {
            throw new AssertionError(e6);
        }
    }
}
