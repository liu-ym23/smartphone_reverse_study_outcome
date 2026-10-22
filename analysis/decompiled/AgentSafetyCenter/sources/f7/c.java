package f7;

import android.graphics.RectF;
import java.util.Arrays;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c implements d {

    /* renamed from: a, reason: collision with root package name */
    public float f3932a;

    @Override // f7.d
    public final float a(RectF rectF) {
        float f5 = this.f3932a;
        float fMin = Math.min(rectF.width() / 2.0f, rectF.height() / 2.0f);
        if (f5 < 0.0f) {
            return 0.0f;
        }
        return f5 > fMin ? fMin : f5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c) && this.f3932a == ((c) obj).f3932a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f3932a)});
    }
}
