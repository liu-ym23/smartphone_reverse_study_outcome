package y1;

import android.graphics.RectF;
import java.util.Arrays;
import s.AbstractC0831a;

/* loaded from: classes.dex */
public final class k implements InterfaceC0990d {

    /* renamed from: a, reason: collision with root package name */
    public final float f16259a;

    public k(float f4) {
        this.f16259a = f4;
    }

    @Override // y1.InterfaceC0990d
    public final float a(RectF rectF) {
        return Math.min(rectF.width(), rectF.height()) * this.f16259a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof k) && this.f16259a == ((k) obj).f16259a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f16259a)});
    }

    public final String toString() {
        return AbstractC0831a.d(new StringBuilder(), (int) (this.f16259a * 100.0f), "%");
    }
}
