package Ec;

/* loaded from: classes5.dex */
public abstract class d {

    public static class a extends d {

        /* renamed from: a, reason: collision with root package name */
        public float f2513a;

        /* renamed from: b, reason: collision with root package name */
        public float f2514b;

        /* renamed from: c, reason: collision with root package name */
        public float f2515c;

        /* renamed from: d, reason: collision with root package name */
        public float f2516d;

        public a(float f10, float f11, float f12, float f13) {
            this.f2513a = f10;
            this.f2514b = f11;
            this.f2515c = f12;
            this.f2516d = f13;
        }

        @Override // Ec.d
        public float a() {
            return this.f2516d;
        }

        @Override // Ec.d
        public float b() {
            return this.f2515c;
        }

        @Override // Ec.d
        public float c() {
            return this.f2513a;
        }

        @Override // Ec.d
        public float d() {
            return this.f2514b;
        }

        public String toString() {
            return "Float{x=" + this.f2513a + ", y=" + this.f2514b + ", w=" + this.f2515c + ", h=" + this.f2516d + '}';
        }
    }

    public abstract float a();

    public abstract float b();

    public abstract float c();

    public abstract float d();
}
