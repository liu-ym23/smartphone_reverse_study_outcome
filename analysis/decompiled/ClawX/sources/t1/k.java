package t1;

import android.graphics.RectF;
import java.util.Arrays;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class k implements d {

    /* renamed from: a, reason: collision with root package name */
    public final float f5496a;

    public k(float f3) {
        this.f5496a = f3;
    }

    @Override // t1.d
    public final float a(RectF rectF) {
        return Math.min(rectF.width(), rectF.height()) * this.f5496a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof k) && this.f5496a == ((k) obj).f5496a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f5496a)});
    }

    public final String toString() {
        return m0.f.e(new StringBuilder(), (int) (this.f5496a * 100.0f), "%");
    }
}
