package r5;

import java.util.Objects;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final float f11728a;

    /* renamed from: b, reason: collision with root package name */
    public final float f11729b;

    public a(float f8, float f9) {
        this.f11728a = f8;
        this.f11729b = f9;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Float.compare(this.f11728a, aVar.f11728a) == 0 && Float.compare(this.f11729b, aVar.f11729b) == 0;
    }

    public final int hashCode() {
        return Objects.hash(Float.valueOf(this.f11728a), Float.valueOf(this.f11729b));
    }

    public final String toString() {
        return "TextModelHeadScore(pass=" + this.f11728a + ", block=" + this.f11729b + ")";
    }
}
