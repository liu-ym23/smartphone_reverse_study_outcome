package v1;

import m.x;

/* loaded from: classes.dex */
public final class a implements o {

    /* renamed from: f, reason: collision with root package name */
    public final int f10347f;

    public a(int i2) {
        this.f10347f = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && this.f10347f == ((a) obj).f10347f;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f10347f);
    }

    public final String toString() {
        return x.m(new StringBuilder("AndroidFontResolveInterceptor(fontWeightAdjustment="), this.f10347f, ')');
    }
}
