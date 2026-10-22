package v0;

import android.view.DisplayCutout;
import java.util.Objects;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final DisplayCutout f13273a;

    public e(DisplayCutout displayCutout) {
        this.f13273a = displayCutout;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.f13273a, ((e) obj).f13273a);
    }

    public final int hashCode() {
        DisplayCutout displayCutout = this.f13273a;
        if (displayCutout == null) {
            return 0;
        }
        return displayCutout.hashCode();
    }

    public final String toString() {
        return "DisplayCutoutCompat{" + this.f13273a + "}";
    }
}
