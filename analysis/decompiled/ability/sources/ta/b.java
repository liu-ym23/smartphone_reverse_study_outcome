package ta;

import S7.k;
import t5.C2016a;

/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final k f6683a = new C2016a(20);

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof b) && kotlin.jvm.internal.k.b(this.f6683a, ((b) obj).f6683a);
    }

    public final int hashCode() {
        return this.f6683a.hashCode();
    }

    public final String toString() {
        return "AccessibilityConfig(compressor=" + this.f6683a + ")";
    }
}
