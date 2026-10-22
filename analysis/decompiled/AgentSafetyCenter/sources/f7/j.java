package f7;

import android.graphics.RectF;
import java.util.Arrays;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j implements d {

    /* renamed from: a, reason: collision with root package name */
    public float f3974a;

    @Override // f7.d
    public final float a(RectF rectF) {
        return Math.min(rectF.width(), rectF.height()) * this.f3974a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof j) && this.f3974a == ((j) obj).f3974a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f3974a)});
    }

    public final String toString() {
        return k0.a.r(new StringBuilder(), (int) (this.f3974a * 100.0f), "%");
    }
}
