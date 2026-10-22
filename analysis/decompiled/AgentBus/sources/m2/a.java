package m2;

import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public String f6130a;

    /* renamed from: b, reason: collision with root package name */
    public String f6131b;

    /* renamed from: c, reason: collision with root package name */
    public List f6132c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Objects.equals(this.f6130a, aVar.f6130a) && Objects.equals(this.f6131b, aVar.f6131b) && Objects.equals(this.f6132c, aVar.f6132c);
    }

    public final int hashCode() {
        return Objects.hash(this.f6130a, this.f6131b, this.f6132c);
    }
}
