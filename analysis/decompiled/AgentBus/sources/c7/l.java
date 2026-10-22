package c7;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class l implements Serializable {

    /* renamed from: f, reason: collision with root package name */
    public final Throwable f1975f;

    public l(Throwable th) {
        q7.k.e(th, "exception");
        this.f1975f = th;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof l) {
            return q7.k.a(this.f1975f, ((l) obj).f1975f);
        }
        return false;
    }

    public final int hashCode() {
        return this.f1975f.hashCode();
    }

    public final String toString() {
        return "Failure(" + this.f1975f + ')';
    }
}
