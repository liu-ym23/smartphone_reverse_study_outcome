package y4;

import android.graphics.RectF;
import java.util.Arrays;
import mb.y;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c implements d {

    /* renamed from: a, reason: collision with root package name */
    public final float f14021a;

    public c(float f8) {
        this.f14021a = f8;
    }

    @Override // y4.d
    public final float a(RectF rectF) {
        return y.o(this.f14021a, 0.0f, Math.min(rectF.width() / 2.0f, rectF.height() / 2.0f));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c) && this.f14021a == ((c) obj).f14021a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f14021a)});
    }
}
