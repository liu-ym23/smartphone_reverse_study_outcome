package w;

import android.content.res.Resources;
import java.util.Objects;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final Resources f6059a;

    /* renamed from: b, reason: collision with root package name */
    public final Resources.Theme f6060b;

    public i(Resources resources, Resources.Theme theme) {
        this.f6059a = resources;
        this.f6060b = theme;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && i.class == obj.getClass()) {
            i iVar = (i) obj;
            if (this.f6059a.equals(iVar.f6059a) && Objects.equals(this.f6060b, iVar.f6060b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.f6059a, this.f6060b);
    }
}
