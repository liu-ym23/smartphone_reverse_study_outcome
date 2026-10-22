package s4;

import java.util.Map;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final Map f5985a;
    public final boolean b;

    public f(Map map, boolean z10) {
        this.f5985a = map;
        this.b = z10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return k.b(this.f5985a, fVar.f5985a) && this.b == fVar.b;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.b) + (this.f5985a.hashCode() * 31);
    }

    public final String toString() {
        return "ModeTable(modes=" + this.f5985a + ", stale=" + this.b + ")";
    }
}
