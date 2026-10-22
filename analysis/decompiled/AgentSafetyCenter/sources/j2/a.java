package j2;

import java.util.Locale;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final Locale f6543a;

    public a(Locale locale) {
        this.f6543a = locale;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof a)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return k.a(this.f6543a.toLanguageTag(), ((a) obj).f6543a.toLanguageTag());
    }

    public final int hashCode() {
        return this.f6543a.toLanguageTag().hashCode();
    }

    public final String toString() {
        return this.f6543a.toLanguageTag();
    }
}
