package t1;

import android.graphics.RectF;
import java.util.Arrays;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b implements d {

    /* renamed from: a, reason: collision with root package name */
    public final d f5448a;

    /* renamed from: b, reason: collision with root package name */
    public final float f5449b;

    public b(float f3, d dVar) {
        while (dVar instanceof b) {
            dVar = ((b) dVar).f5448a;
            f3 += ((b) dVar).f5449b;
        }
        this.f5448a = dVar;
        this.f5449b = f3;
    }

    @Override // t1.d
    public final float a(RectF rectF) {
        return Math.max(0.0f, this.f5448a.a(rectF) + this.f5449b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f5448a.equals(bVar.f5448a) && this.f5449b == bVar.f5449b;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f5448a, Float.valueOf(this.f5449b)});
    }
}
