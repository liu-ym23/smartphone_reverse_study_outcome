package rc;

import java.util.Map;

/* loaded from: classes5.dex */
public class F0 extends AbstractC5276d {

    /* renamed from: d, reason: collision with root package name */
    public AbstractC5276d f39070d;

    /* renamed from: e, reason: collision with root package name */
    public double f39071e;

    /* renamed from: f, reason: collision with root package name */
    public int f39072f;

    /* renamed from: g, reason: collision with root package name */
    public int f39073g;

    /* renamed from: h, reason: collision with root package name */
    public int f39074h;

    /* renamed from: i, reason: collision with root package name */
    public float f39075i;

    /* renamed from: j, reason: collision with root package name */
    public float f39076j;

    public F0(AbstractC5276d abstractC5276d, double d10, String str) {
        this.f39072f = -1;
        this.f39248a = abstractC5276d.f39248a;
        this.f39070d = abstractC5276d;
        this.f39071e = d10;
        Map<String, String> mapA = C5310u0.a(str);
        if (mapA.containsKey("origin")) {
            this.f39072f = G0.s(mapA.get("origin"));
            return;
        }
        if (mapA.containsKey("x")) {
            float[] fArrK = R0.k(mapA.get("x"));
            this.f39073g = (int) fArrK[0];
            this.f39075i = fArrK[1];
        } else {
            this.f39073g = 3;
            this.f39075i = 0.0f;
        }
        if (!mapA.containsKey("y")) {
            this.f39074h = 3;
            this.f39076j = 0.0f;
        } else {
            float[] fArrK2 = R0.k(mapA.get("y"));
            this.f39074h = (int) fArrK2[0];
            this.f39076j = fArrK2[1];
        }
    }

    @Override // rc.AbstractC5276d
    public AbstractC5284h f(Y0 y02) {
        return this.f39072f != -1 ? new G0(this.f39070d.f(y02), this.f39071e, this.f39072f) : new G0(this.f39070d.f(y02), this.f39071e, this.f39075i * R0.j(this.f39073g, y02), this.f39076j * R0.j(this.f39074h, y02));
    }
}
