package Z2;

import android.graphics.RectF;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class j implements d {

    /* renamed from: a, reason: collision with root package name */
    public final float f7181a;

    public j(float f10) {
        this.f7181a = f10;
    }

    private static float b(RectF rectF) {
        return Math.min(rectF.width(), rectF.height());
    }

    @Override // Z2.d
    public float a(RectF rectF) {
        return this.f7181a * b(rectF);
    }

    public float c() {
        return this.f7181a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof j) && this.f7181a == ((j) obj).f7181a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f7181a)});
    }

    public String toString() {
        return ((int) (c() * 100.0f)) + "%";
    }
}
