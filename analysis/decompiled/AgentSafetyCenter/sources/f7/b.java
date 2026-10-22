package f7;

import android.graphics.RectF;
import java.util.Arrays;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b implements d {

    /* renamed from: a, reason: collision with root package name */
    public d f3930a;

    /* renamed from: b, reason: collision with root package name */
    public float f3931b;

    @Override // f7.d
    public final float a(RectF rectF) {
        return Math.max(0.0f, this.f3930a.a(rectF) + this.f3931b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f3930a.equals(bVar.f3930a) && this.f3931b == bVar.f3931b;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f3930a, Float.valueOf(this.f3931b)});
    }
}
