package s8;

import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class u2 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f12009a;

    /* renamed from: b, reason: collision with root package name */
    public final int f12010b;

    public u2(ArrayList arrayList, int i) {
        this.f12009a = arrayList;
        this.f12010b = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u2)) {
            return false;
        }
        u2 u2Var = (u2) obj;
        return this.f12009a.equals(u2Var.f12009a) && this.f12010b == u2Var.f12010b;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f12010b) + (this.f12009a.hashCode() * 31);
    }

    public final String toString() {
        return "ChipRow(items=" + this.f12009a + ", height=" + this.f12010b + ")";
    }
}
