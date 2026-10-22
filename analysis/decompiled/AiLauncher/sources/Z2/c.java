package Z2;

import android.graphics.RectF;
import java.util.Arrays;
import w0.C5715a;

/* loaded from: classes2.dex */
public final class c implements d {

    /* renamed from: a, reason: collision with root package name */
    public final float f7118a;

    public c(float f10) {
        this.f7118a = f10;
    }

    public static float b(RectF rectF) {
        return Math.min(rectF.width() / 2.0f, rectF.height() / 2.0f);
    }

    @Override // Z2.d
    public float a(RectF rectF) {
        return C5715a.a(this.f7118a, 0.0f, b(rectF));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c) && this.f7118a == ((c) obj).f7118a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f7118a)});
    }
}
