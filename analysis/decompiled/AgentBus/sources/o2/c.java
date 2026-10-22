package o2;

import android.view.DisplayCutout;
import java.util.Objects;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final DisplayCutout f7223a;

    public c(DisplayCutout displayCutout) {
        this.f7223a = displayCutout;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.f7223a, ((c) obj).f7223a);
    }

    public final int hashCode() {
        DisplayCutout displayCutout = this.f7223a;
        if (displayCutout == null) {
            return 0;
        }
        return displayCutout.hashCode();
    }

    public final String toString() {
        return "DisplayCutoutCompat{" + this.f7223a + "}";
    }
}
