package K0;

import z0.C1341g;

/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f3521a = new e();

    /* renamed from: b, reason: collision with root package name */
    public static final g f3522b;

    /* renamed from: c, reason: collision with root package name */
    public static final g f3523c;

    /* renamed from: d, reason: collision with root package name */
    public static final g f3524d;

    /* renamed from: e, reason: collision with root package name */
    public static final g f3525e;

    /* renamed from: f, reason: collision with root package name */
    public static final g f3526f;

    /* renamed from: g, reason: collision with root package name */
    public static final g f3527g;

    /* renamed from: h, reason: collision with root package name */
    public static final C1341g<g> f3528h;

    private static class a extends g {
        a() {
        }

        @Override // K0.g
        public EnumC0049g a(int i5, int i6, int i7, int i8) {
            return EnumC0049g.QUALITY;
        }

        @Override // K0.g
        public float b(int i5, int i6, int i7, int i8) {
            if (Math.min(i6 / i8, i5 / i7) == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(r0);
        }
    }

    private static class b extends g {
        b() {
        }

        @Override // K0.g
        public EnumC0049g a(int i5, int i6, int i7, int i8) {
            return EnumC0049g.MEMORY;
        }

        @Override // K0.g
        public float b(int i5, int i6, int i7, int i8) {
            int iCeil = (int) Math.ceil(Math.max(i6 / i8, i5 / i7));
            return 1.0f / (r1 << (Math.max(1, Integer.highestOneBit(iCeil)) >= iCeil ? 0 : 1));
        }
    }

    private static class c extends g {
        c() {
        }

        @Override // K0.g
        public EnumC0049g a(int i5, int i6, int i7, int i8) {
            return EnumC0049g.QUALITY;
        }

        @Override // K0.g
        public float b(int i5, int i6, int i7, int i8) {
            return Math.min(1.0f, g.f3521a.b(i5, i6, i7, i8));
        }
    }

    private static class d extends g {
        d() {
        }

        @Override // K0.g
        public EnumC0049g a(int i5, int i6, int i7, int i8) {
            return EnumC0049g.QUALITY;
        }

        @Override // K0.g
        public float b(int i5, int i6, int i7, int i8) {
            return Math.max(i7 / i5, i8 / i6);
        }
    }

    private static class e extends g {
        e() {
        }

        @Override // K0.g
        public EnumC0049g a(int i5, int i6, int i7, int i8) {
            return EnumC0049g.QUALITY;
        }

        @Override // K0.g
        public float b(int i5, int i6, int i7, int i8) {
            return Math.min(i7 / i5, i8 / i6);
        }
    }

    private static class f extends g {
        f() {
        }

        @Override // K0.g
        public EnumC0049g a(int i5, int i6, int i7, int i8) {
            return EnumC0049g.QUALITY;
        }

        @Override // K0.g
        public float b(int i5, int i6, int i7, int i8) {
            return 1.0f;
        }
    }

    /* renamed from: K0.g$g, reason: collision with other inner class name */
    public enum EnumC0049g {
        MEMORY,
        QUALITY
    }

    static {
        d dVar = new d();
        f3522b = dVar;
        f3523c = new a();
        f3524d = new b();
        f3525e = new c();
        f3526f = new f();
        f3527g = dVar;
        f3528h = C1341g.f("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", dVar);
    }

    public abstract EnumC0049g a(int i5, int i6, int i7, int i8);

    public abstract float b(int i5, int i6, int i7, int i8);
}
