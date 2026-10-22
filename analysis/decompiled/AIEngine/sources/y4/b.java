package y4;

import android.graphics.RectF;
import java.util.Arrays;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b implements d {

    /* renamed from: a, reason: collision with root package name */
    public final d f14019a;

    /* renamed from: b, reason: collision with root package name */
    public final float f14020b;

    public b(float f8, d dVar) {
        while (dVar instanceof b) {
            dVar = ((b) dVar).f14019a;
            f8 += ((b) dVar).f14020b;
        }
        this.f14019a = dVar;
        this.f14020b = f8;
    }

    @Override // y4.d
    public final float a(RectF rectF) {
        return Math.max(0.0f, this.f14019a.a(rectF) + this.f14020b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f14019a.equals(bVar.f14019a) && this.f14020b == bVar.f14020b;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f14019a, Float.valueOf(this.f14020b)});
    }
}
