package y4;

import android.graphics.RectF;
import java.util.Arrays;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class h implements d {

    /* renamed from: a, reason: collision with root package name */
    public final float f14061a;

    public h(float f8) {
        this.f14061a = f8;
    }

    @Override // y4.d
    public final float a(RectF rectF) {
        return Math.min(rectF.width(), rectF.height()) * this.f14061a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof h) && this.f14061a == ((h) obj).f14061a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f14061a)});
    }

    public final String toString() {
        return ai.onnxruntime.a.j("%", (int) (this.f14061a * 100.0f), new StringBuilder());
    }
}
