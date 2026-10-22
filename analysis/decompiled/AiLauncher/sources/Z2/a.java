package Z2;

import android.graphics.RectF;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class a implements d {

    /* renamed from: a, reason: collision with root package name */
    public final float f7115a;

    public a(float f10) {
        this.f7115a = f10;
    }

    @Override // Z2.d
    public float a(RectF rectF) {
        return this.f7115a;
    }

    public float b() {
        return this.f7115a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && this.f7115a == ((a) obj).f7115a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f7115a)});
    }

    public String toString() {
        return b() + "px";
    }
}
