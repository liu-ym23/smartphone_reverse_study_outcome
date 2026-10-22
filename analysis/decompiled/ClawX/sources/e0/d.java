package e0;

import android.view.DisplayCutout;
import java.util.Objects;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final DisplayCutout f2301a;

    public d(DisplayCutout displayCutout) {
        this.f2301a = displayCutout;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.f2301a, ((d) obj).f2301a);
    }

    public final int hashCode() {
        DisplayCutout displayCutout = this.f2301a;
        if (displayCutout == null) {
            return 0;
        }
        return displayCutout.hashCode();
    }

    public final String toString() {
        return "DisplayCutoutCompat{" + this.f2301a + "}";
    }
}
