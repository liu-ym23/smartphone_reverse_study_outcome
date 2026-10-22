package J0;

import androidx.room.AbstractC0351g;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f854a;

    /* renamed from: b, reason: collision with root package name */
    public final String f855b;

    /* renamed from: c, reason: collision with root package name */
    public final double f856c;

    /* renamed from: d, reason: collision with root package name */
    public final int f857d;

    /* renamed from: e, reason: collision with root package name */
    public final int f858e;

    /* renamed from: f, reason: collision with root package name */
    public final double f859f;

    /* renamed from: g, reason: collision with root package name */
    public final double f860g;

    /* renamed from: h, reason: collision with root package name */
    public final int f861h;

    /* renamed from: i, reason: collision with root package name */
    public final int f862i;

    /* renamed from: j, reason: collision with root package name */
    public final double f863j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f864k;

    public b(String str, String str2, double d4, int i4, int i5, double d5, double d6, int i6, int i7, double d7, boolean z4) {
        this.f854a = str;
        this.f855b = str2;
        this.f856c = d4;
        this.f857d = i4;
        this.f858e = i5;
        this.f859f = d5;
        this.f860g = d6;
        this.f861h = i6;
        this.f862i = i7;
        this.f863j = d7;
        this.f864k = z4;
    }

    public final int hashCode() {
        int iD = (((((int) (AbstractC0351g.d(this.f855b, this.f854a.hashCode() * 31, 31) + this.f856c)) * 31) + this.f857d) * 31) + this.f858e;
        long jDoubleToLongBits = Double.doubleToLongBits(this.f859f);
        return (((iD * 31) + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)))) * 31) + this.f861h;
    }
}
