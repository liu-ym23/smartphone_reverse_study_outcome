package x;

import m.x;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final float f11006a;

    /* renamed from: b, reason: collision with root package name */
    public final float f11007b;

    /* renamed from: c, reason: collision with root package name */
    public final float f11008c;

    /* renamed from: d, reason: collision with root package name */
    public final float f11009d;

    public f(float f10, float f11, float f12, float f13) {
        this.f11006a = f10;
        this.f11007b = f11;
        this.f11008c = f12;
        this.f11009d = f13;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f11006a == fVar.f11006a && this.f11007b == fVar.f11007b && this.f11008c == fVar.f11008c && this.f11009d == fVar.f11009d;
    }

    public final int hashCode() {
        return Float.hashCode(this.f11009d) + x.d(this.f11008c, x.d(this.f11007b, Float.hashCode(this.f11006a) * 31, 31), 31);
    }

    public final String toString() {
        return "RippleAlpha(draggedAlpha=" + this.f11006a + ", focusedAlpha=" + this.f11007b + ", hoveredAlpha=" + this.f11008c + ", pressedAlpha=" + this.f11009d + ')';
    }
}
