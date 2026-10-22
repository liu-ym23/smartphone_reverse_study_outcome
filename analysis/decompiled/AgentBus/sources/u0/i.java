package u0;

import android.graphics.BlendModeColorFilter;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final BlendModeColorFilter f9908a;

    /* renamed from: b, reason: collision with root package name */
    public final long f9909b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9910c = 5;

    public i(long j2) {
        this.f9908a = new BlendModeColorFilter(z.o(j2), z.m(5));
        this.f9909b = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return m.c(this.f9909b, iVar.f9909b) && this.f9910c == iVar.f9910c;
    }

    public final int hashCode() {
        int i2 = m.f9917g;
        return Integer.hashCode(this.f9910c) + (Long.hashCode(this.f9909b) * 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("BlendModeColorFilter(color=");
        m.x.u(this.f9909b, sb2, ", blendMode=");
        sb2.append((Object) z.r(this.f9910c));
        sb2.append(')');
        return sb2.toString();
    }
}
