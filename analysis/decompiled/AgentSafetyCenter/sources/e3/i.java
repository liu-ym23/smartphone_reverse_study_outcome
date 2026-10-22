package e3;

import android.content.res.Resources;
import java.util.Objects;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public Resources f3475a;

    /* renamed from: b, reason: collision with root package name */
    public Resources.Theme f3476b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && i.class == obj.getClass()) {
            i iVar = (i) obj;
            if (this.f3475a.equals(iVar.f3475a) && Objects.equals(this.f3476b, iVar.f3476b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.f3475a, this.f3476b);
    }
}
