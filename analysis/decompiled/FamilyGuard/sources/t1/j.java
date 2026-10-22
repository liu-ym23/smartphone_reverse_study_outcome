package t1;

import android.graphics.RectF;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class j implements InterfaceC1111d {

    /* renamed from: a, reason: collision with root package name */
    private final float f22383a;

    public j(float f5) {
        this.f22383a = f5;
    }

    private static float b(RectF rectF) {
        return Math.min(rectF.width(), rectF.height());
    }

    @Override // t1.InterfaceC1111d
    public float a(RectF rectF) {
        return this.f22383a * b(rectF);
    }

    public float c() {
        return this.f22383a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof j) && this.f22383a == ((j) obj).f22383a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f22383a)});
    }

    public String toString() {
        return ((int) (c() * 100.0f)) + "%";
    }
}
