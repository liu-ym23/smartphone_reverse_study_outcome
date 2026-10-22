package t1;

import android.graphics.RectF;
import java.util.Arrays;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c implements d {

    /* renamed from: a, reason: collision with root package name */
    public final float f5453a;

    public c(float f3) {
        this.f5453a = f3;
    }

    @Override // t1.d
    public final float a(RectF rectF) {
        float fMin = Math.min(rectF.width() / 2.0f, rectF.height() / 2.0f);
        float f3 = this.f5453a;
        if (f3 < 0.0f) {
            return 0.0f;
        }
        return f3 > fMin ? fMin : f3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c) && this.f5453a == ((c) obj).f5453a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f5453a)});
    }
}
