package z2;

/* renamed from: z2.k0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C6176k0 {

    /* renamed from: a, reason: collision with root package name */
    public C6206n0 f45040a;

    /* renamed from: b, reason: collision with root package name */
    public Integer f45041b;

    /* renamed from: c, reason: collision with root package name */
    public C6321y5 f45042c;

    public final C6176k0 a(Integer num) {
        this.f45041b = Integer.valueOf(num.intValue() & Integer.MAX_VALUE);
        return this;
    }

    public final C6176k0 b(C6321y5 c6321y5) {
        this.f45042c = c6321y5;
        return this;
    }

    public final C6176k0 c(C6206n0 c6206n0) {
        this.f45040a = c6206n0;
        return this;
    }

    public final C6226p0 e() {
        return new C6226p0(this, null);
    }
}
