package y1;

import java.util.Locale;
import q7.k;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final Locale f11541a;

    public a(Locale locale) {
        this.f11541a = locale;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof a)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return k.a(this.f11541a.toLanguageTag(), ((a) obj).f11541a.toLanguageTag());
    }

    public final int hashCode() {
        return this.f11541a.toLanguageTag().hashCode();
    }

    public final String toString() {
        return this.f11541a.toLanguageTag();
    }
}
