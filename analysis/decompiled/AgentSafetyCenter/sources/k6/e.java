package k6;

import java.util.Objects;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: c, reason: collision with root package name */
    public static final e f7269c = new e(0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final int f7270a;

    /* renamed from: b, reason: collision with root package name */
    public final int f7271b;

    public e(int i, int i3) {
        this.f7270a = i;
        this.f7271b = i3;
    }

    public final int a() {
        return (this.f7271b * 60) + (this.f7270a * 3600);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && e.class == obj.getClass()) {
            e eVar = (e) obj;
            if (this.f7270a == eVar.f7270a && this.f7271b == eVar.f7271b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f7270a), Integer.valueOf(this.f7271b));
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("TimezoneOffset{hours=");
        sb2.append(this.f7270a);
        sb2.append(", minutes=");
        return androidx.activity.b.l(sb2, this.f7271b, '}');
    }
}
