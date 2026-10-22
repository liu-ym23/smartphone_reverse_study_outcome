package k3;

import java.util.List;
import java.util.Objects;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public String f7208a;

    /* renamed from: b, reason: collision with root package name */
    public String f7209b;

    /* renamed from: c, reason: collision with root package name */
    public List f7210c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Objects.equals(this.f7208a, aVar.f7208a) && Objects.equals(this.f7209b, aVar.f7209b) && Objects.equals(this.f7210c, aVar.f7210c);
    }

    public final int hashCode() {
        return Objects.hash(this.f7208a, this.f7209b, this.f7210c);
    }
}
