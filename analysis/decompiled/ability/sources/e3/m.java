package e3;

import android.graphics.RectF;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class m implements InterfaceC1415d {

    /* renamed from: a, reason: collision with root package name */
    public final float f4366a;

    public m(float f) {
        this.f4366a = f;
    }

    @Override // e3.InterfaceC1415d
    public final float a(RectF rectF) {
        return Math.min(rectF.width(), rectF.height()) * this.f4366a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof m) && this.f4366a == ((m) obj).f4366a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f4366a)});
    }

    public final String toString() {
        return androidx.appfunctions.metadata.a.o(new StringBuilder(), "%", (int) (this.f4366a * 100.0f));
    }
}
