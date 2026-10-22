package androidx.core.widget;

import com.stepos.alphame.utils.Property;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public int f3356a;

    /* renamed from: b, reason: collision with root package name */
    public int f3357b;

    /* renamed from: c, reason: collision with root package name */
    public float f3358c;

    /* renamed from: d, reason: collision with root package name */
    public float f3359d;

    /* renamed from: e, reason: collision with root package name */
    public long f3360e;

    /* renamed from: f, reason: collision with root package name */
    public long f3361f;

    /* renamed from: g, reason: collision with root package name */
    public long f3362g;

    /* renamed from: h, reason: collision with root package name */
    public float f3363h;

    /* renamed from: i, reason: collision with root package name */
    public int f3364i;

    public final float a(long j4) {
        if (j4 < this.f3360e) {
            return Property.DEFAULT_FLOAT_VALUE;
        }
        long j5 = this.f3362g;
        if (j5 < 0 || j4 < j5) {
            return f.b((j4 - r0) / this.f3356a, Property.DEFAULT_FLOAT_VALUE, 1.0f) * 0.5f;
        }
        float f4 = this.f3363h;
        return (f.b((j4 - j5) / this.f3364i, Property.DEFAULT_FLOAT_VALUE, 1.0f) * f4) + (1.0f - f4);
    }
}
