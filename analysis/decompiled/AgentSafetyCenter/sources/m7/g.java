package m7;

import java.io.IOException;
import p7.g1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class g {
    public abstract g a();

    public boolean b() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public double c() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public final f d() {
        if (this instanceof f) {
            return (f) this;
        }
        g5.f.r(this, "Not a JSON Array: ");
        return null;
    }

    public final j e() {
        if (this instanceof j) {
            return (j) this;
        }
        g5.f.r(this, "Not a JSON Object: ");
        return null;
    }

    public final l f() {
        if (this instanceof l) {
            return (l) this;
        }
        g5.f.r(this, "Not a JSON Primitive: ");
        return null;
    }

    public long g() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public Number h() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String i() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public final String toString() {
        try {
            StringBuilder sb2 = new StringBuilder();
            u7.c cVar = new u7.c(o7.h.n(sb2));
            cVar.f14181l = 1;
            p7.m mVar = g1.f9869z;
            mVar.getClass();
            mVar.write(cVar, this);
            return sb2.toString();
        } catch (IOException e10) {
            throw new AssertionError(e10);
        }
    }
}
