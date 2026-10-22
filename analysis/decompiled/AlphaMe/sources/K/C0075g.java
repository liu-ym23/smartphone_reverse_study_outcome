package K;

import android.view.DisplayCutout;
import java.util.Objects;

/* renamed from: K.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0075g {

    /* renamed from: a, reason: collision with root package name */
    public final DisplayCutout f970a;

    public C0075g(DisplayCutout displayCutout) {
        this.f970a = displayCutout;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0075g.class != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.f970a, ((C0075g) obj).f970a);
    }

    public final int hashCode() {
        DisplayCutout displayCutout = this.f970a;
        if (displayCutout == null) {
            return 0;
        }
        return displayCutout.hashCode();
    }

    public final String toString() {
        return "DisplayCutoutCompat{" + this.f970a + "}";
    }
}
