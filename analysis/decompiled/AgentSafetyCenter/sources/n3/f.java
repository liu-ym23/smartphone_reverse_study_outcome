package n3;

import android.view.DisplayCutout;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public DisplayCutout f8712a;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f.class != obj.getClass()) {
            return false;
        }
        return this.f8712a.equals(((f) obj).f8712a);
    }

    public final int hashCode() {
        return this.f8712a.hashCode();
    }

    public final String toString() {
        return "DisplayCutoutCompat{" + this.f8712a + "}";
    }
}
