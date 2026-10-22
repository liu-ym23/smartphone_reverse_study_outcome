package o;

import android.content.Context;
import android.os.Build;
import android.widget.EdgeEffect;

/* loaded from: classes.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    public final Context f7147a;

    /* renamed from: b, reason: collision with root package name */
    public final int f7148b;

    /* renamed from: c, reason: collision with root package name */
    public long f7149c = 0;

    /* renamed from: d, reason: collision with root package name */
    public EdgeEffect f7150d;

    /* renamed from: e, reason: collision with root package name */
    public EdgeEffect f7151e;

    /* renamed from: f, reason: collision with root package name */
    public EdgeEffect f7152f;

    /* renamed from: g, reason: collision with root package name */
    public EdgeEffect f7153g;

    /* renamed from: h, reason: collision with root package name */
    public EdgeEffect f7154h;

    /* renamed from: i, reason: collision with root package name */
    public EdgeEffect f7155i;

    /* renamed from: j, reason: collision with root package name */
    public EdgeEffect f7156j;

    /* renamed from: k, reason: collision with root package name */
    public EdgeEffect f7157k;

    public y(Context context, int i2) {
        this.f7147a = context;
        this.f7148b = i2;
    }

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
        return !((Build.VERSION.SDK_INT >= 31 ? h.f7056a.b(edgeEffect) : 0.0f) == 0.0f);
    }

    public final EdgeEffect a() {
        int i2 = Build.VERSION.SDK_INT;
        Context context = this.f7147a;
        EdgeEffect edgeEffectA = i2 >= 31 ? h.f7056a.a(context, null) : new f0(context);
        edgeEffectA.setColor(this.f7148b);
        if (!d2.k.a(this.f7149c, 0L)) {
            long j2 = this.f7149c;
            edgeEffectA.setSize((int) (j2 >> 32), (int) (j2 & 4294967295L));
        }
        return edgeEffectA;
    }

    public final EdgeEffect b() {
        EdgeEffect edgeEffect = this.f7151e;
        if (edgeEffect != null) {
            return edgeEffect;
        }
        EdgeEffect edgeEffectA = a();
        this.f7151e = edgeEffectA;
        return edgeEffectA;
    }

    public final EdgeEffect c() {
        EdgeEffect edgeEffect = this.f7152f;
        if (edgeEffect != null) {
            return edgeEffect;
        }
        EdgeEffect edgeEffectA = a();
        this.f7152f = edgeEffectA;
        return edgeEffectA;
    }

    public final EdgeEffect d() {
        EdgeEffect edgeEffect = this.f7153g;
        if (edgeEffect != null) {
            return edgeEffect;
        }
        EdgeEffect edgeEffectA = a();
        this.f7153g = edgeEffectA;
        return edgeEffectA;
    }

    public final EdgeEffect e() {
        EdgeEffect edgeEffect = this.f7150d;
        if (edgeEffect != null) {
            return edgeEffect;
        }
        EdgeEffect edgeEffectA = a();
        this.f7150d = edgeEffectA;
        return edgeEffectA;
    }
}
