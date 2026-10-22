package m2;

import ch.qos.logback.core.CoreConstants;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final float f13576a;

    /* renamed from: b, reason: collision with root package name */
    public final float f13577b;

    /* renamed from: c, reason: collision with root package name */
    public final float f13578c;

    /* renamed from: d, reason: collision with root package name */
    public final float f13579d;

    /* renamed from: e, reason: collision with root package name */
    public final float f13580e;

    /* renamed from: f, reason: collision with root package name */
    public final float f13581f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f13582g;

    public k(float f4, float f5, float f6, float f7, float f8, float f9, boolean z4) {
        this.f13576a = f4;
        this.f13577b = f5;
        this.f13578c = f6;
        this.f13579d = f7;
        this.f13580e = f8;
        this.f13581f = f9;
        this.f13582g = z4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return Float.compare(this.f13576a, kVar.f13576a) == 0 && Float.compare(this.f13577b, kVar.f13577b) == 0 && Float.compare(this.f13578c, kVar.f13578c) == 0 && Float.compare(this.f13579d, kVar.f13579d) == 0 && Float.compare(this.f13580e, kVar.f13580e) == 0 && Float.compare(this.f13581f, kVar.f13581f) == 0 && this.f13582g == kVar.f13582g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int iHashCode = (Float.hashCode(this.f13581f) + ((Float.hashCode(this.f13580e) + ((Float.hashCode(this.f13579d) + ((Float.hashCode(this.f13578c) + ((Float.hashCode(this.f13577b) + (Float.hashCode(this.f13576a) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        boolean z4 = this.f13582g;
        int i4 = z4;
        if (z4 != 0) {
            i4 = 1;
        }
        return iHashCode + i4;
    }

    public final String toString() {
        return "SmoothPathParams(left=" + this.f13576a + ", top=" + this.f13577b + ", right=" + this.f13578c + ", bottom=" + this.f13579d + ", smoothness=" + this.f13580e + ", radius=" + this.f13581f + ", useNativeRoundCornerWhileParamsInvalid=" + this.f13582g + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
