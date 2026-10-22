package D;

/* loaded from: classes.dex */
public class A {

    /* renamed from: d, reason: collision with root package name */
    public static final A f1988d = new b().b(1.0f).c(0.0f, 0.0f).d(1.0f, 1.0f).a();

    /* renamed from: a, reason: collision with root package name */
    public final float f1989a;

    /* renamed from: b, reason: collision with root package name */
    public final B0.d<Float, Float> f1990b;

    /* renamed from: c, reason: collision with root package name */
    public final B0.d<Float, Float> f1991c;

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public float f1992a;

        /* renamed from: b, reason: collision with root package name */
        public B0.d<Float, Float> f1993b;

        /* renamed from: c, reason: collision with root package name */
        public B0.d<Float, Float> f1994c;

        public b() {
            Float fValueOf = Float.valueOf(1.0f);
            this.f1992a = 1.0f;
            Float fValueOf2 = Float.valueOf(0.0f);
            this.f1993b = B0.d.a(fValueOf2, fValueOf2);
            this.f1994c = B0.d.a(fValueOf, fValueOf);
        }

        public A a() {
            return new A(this.f1992a, this.f1993b, this.f1994c);
        }

        public b b(float f10) {
            this.f1992a = f10;
            return this;
        }

        public b c(float f10, float f11) {
            this.f1993b = B0.d.a(Float.valueOf(f10), Float.valueOf(f11));
            return this;
        }

        public b d(float f10, float f11) {
            this.f1994c = B0.d.a(Float.valueOf(f10), Float.valueOf(f11));
            return this;
        }
    }

    public float a() {
        return this.f1989a;
    }

    public B0.d<Float, Float> b() {
        return this.f1990b;
    }

    public B0.d<Float, Float> c() {
        return this.f1991c;
    }

    public A(float f10, B0.d<Float, Float> dVar, B0.d<Float, Float> dVar2) {
        this.f1989a = f10;
        this.f1990b = dVar;
        this.f1991c = dVar2;
    }
}
