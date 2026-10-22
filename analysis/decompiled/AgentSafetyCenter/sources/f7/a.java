package f7;

import android.graphics.RectF;
import java.util.Arrays;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a implements d {

    /* renamed from: a, reason: collision with root package name */
    public final float f3929a;

    public a(float f5) {
        this.f3929a = f5;
    }

    @Override // f7.d
    public final float a(RectF rectF) {
        return this.f3929a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && this.f3929a == ((a) obj).f3929a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f3929a)});
    }

    public final String toString() {
        return this.f3929a + "px";
    }
}
