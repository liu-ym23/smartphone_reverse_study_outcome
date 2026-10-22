package G;

import java.util.Locale;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: b, reason: collision with root package name */
    public static final g f463b = new g(new i(f.a(new Locale[0])));

    /* renamed from: a, reason: collision with root package name */
    public final h f464a;

    public g(i iVar) {
        this.f464a = iVar;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof g) {
            if (this.f464a.equals(((g) obj).f464a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f464a.hashCode();
    }

    public final String toString() {
        return this.f464a.toString();
    }
}
