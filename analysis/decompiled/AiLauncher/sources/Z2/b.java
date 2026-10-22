package Z2;

import android.graphics.RectF;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class b implements d {

    /* renamed from: a, reason: collision with root package name */
    public final d f7116a;

    /* renamed from: b, reason: collision with root package name */
    public final float f7117b;

    public b(float f10, d dVar) {
        while (dVar instanceof b) {
            dVar = ((b) dVar).f7116a;
            f10 += ((b) dVar).f7117b;
        }
        this.f7116a = dVar;
        this.f7117b = f10;
    }

    @Override // Z2.d
    public float a(RectF rectF) {
        return Math.max(0.0f, this.f7116a.a(rectF) + this.f7117b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f7116a.equals(bVar.f7116a) && this.f7117b == bVar.f7117b;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f7116a, Float.valueOf(this.f7117b)});
    }
}
