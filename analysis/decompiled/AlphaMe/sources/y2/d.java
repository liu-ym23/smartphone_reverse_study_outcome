package y2;

import com.stepos.alphame.utils.Property;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class d implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final g f16338a;

    /* renamed from: b, reason: collision with root package name */
    public float f16339b;

    public d(g gVar) {
        g gVar2 = new g();
        this.f16338a = gVar2;
        this.f16339b = Property.DEFAULT_FLOAT_VALUE;
        gVar2.d(gVar);
        gVar2.b();
        this.f16339b = Property.DEFAULT_FLOAT_VALUE;
    }

    public final void a(g gVar, g gVar2, g gVar3) {
        g gVar4 = this.f16338a;
        gVar4.d(gVar);
        gVar4.e(gVar2);
        float f4 = gVar2.f16346a - gVar3.f16346a;
        float f5 = gVar2.f16347b - gVar3.f16347b;
        float f6 = gVar2.f16348c - gVar3.f16348c;
        float f7 = gVar4.f16347b;
        float f8 = gVar4.f16348c;
        float f9 = gVar4.f16346a;
        gVar4.c((f7 * f6) - (f8 * f5), (f8 * f4) - (f6 * f9), (f9 * f5) - (f7 * f4));
        gVar4.b();
        this.f16339b = -((gVar.f16348c * gVar4.f16348c) + (gVar.f16347b * gVar4.f16347b) + (gVar.f16346a * gVar4.f16346a));
    }

    public final String toString() {
        return this.f16338a.toString() + ", " + this.f16339b;
    }
}
