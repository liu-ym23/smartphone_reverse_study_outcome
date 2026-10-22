package t;

import android.content.Context;
import android.widget.EdgeEffect;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    public Context f13094a;

    /* renamed from: b, reason: collision with root package name */
    public int f13095b;

    /* renamed from: c, reason: collision with root package name */
    public long f13096c;

    /* renamed from: d, reason: collision with root package name */
    public EdgeEffect f13097d;

    /* renamed from: e, reason: collision with root package name */
    public EdgeEffect f13098e;

    /* renamed from: f, reason: collision with root package name */
    public EdgeEffect f13099f;

    /* renamed from: g, reason: collision with root package name */
    public EdgeEffect f13100g;

    /* renamed from: h, reason: collision with root package name */
    public EdgeEffect f13101h;
    public EdgeEffect i;

    /* renamed from: j, reason: collision with root package name */
    public EdgeEffect f13102j;

    /* renamed from: k, reason: collision with root package name */
    public EdgeEffect f13103k;

    public static boolean f(EdgeEffect edgeEffect) {
        if (edgeEffect == null) {
            return false;
        }
        return !edgeEffect.isFinished();
    }

    public static boolean g(EdgeEffect edgeEffect) {
        if (edgeEffect == null) {
            return false;
        }
        return !(g.f12979a.b(edgeEffect) == 0.0f);
    }

    public final EdgeEffect a() {
        EdgeEffect edgeEffectA = g.f12979a.a(this.f13094a, null);
        edgeEffectA.setColor(this.f13095b);
        if (!o2.k.b(this.f13096c, 0L)) {
            long j10 = this.f13096c;
            edgeEffectA.setSize((int) (j10 >> 32), (int) (j10 & 4294967295L));
        }
        return edgeEffectA;
    }

    public final EdgeEffect b() {
        EdgeEffect edgeEffect = this.f13098e;
        if (edgeEffect != null) {
            return edgeEffect;
        }
        EdgeEffect edgeEffectA = a();
        this.f13098e = edgeEffectA;
        return edgeEffectA;
    }

    public final EdgeEffect c() {
        EdgeEffect edgeEffect = this.f13099f;
        if (edgeEffect != null) {
            return edgeEffect;
        }
        EdgeEffect edgeEffectA = a();
        this.f13099f = edgeEffectA;
        return edgeEffectA;
    }

    public final EdgeEffect d() {
        EdgeEffect edgeEffect = this.f13100g;
        if (edgeEffect != null) {
            return edgeEffect;
        }
        EdgeEffect edgeEffectA = a();
        this.f13100g = edgeEffectA;
        return edgeEffectA;
    }

    public final EdgeEffect e() {
        EdgeEffect edgeEffect = this.f13097d;
        if (edgeEffect != null) {
            return edgeEffect;
        }
        EdgeEffect edgeEffectA = a();
        this.f13097d = edgeEffectA;
        return edgeEffectA;
    }
}
