package N1;

import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.LruCache;
import c4.C0586c;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public static final k f4211a = new k();

    /* renamed from: b, reason: collision with root package name */
    private static final LruCache<b, Path> f4212b = new c(100);

    /* renamed from: c, reason: collision with root package name */
    private static final Paint f4213c;

    public static final class a {

        /* renamed from: b, reason: collision with root package name */
        public static final C0063a f4214b = new C0063a(null);

        /* renamed from: a, reason: collision with root package name */
        private float[] f4215a;

        /* renamed from: N1.k$a$a, reason: collision with other inner class name */
        public static final class C0063a {
            public /* synthetic */ C0063a(j4.g gVar) {
                this();
            }

            public final a a(float f5, float f6) {
                a aVar = new a(null);
                aVar.b()[0] = 0.0f;
                aVar.b()[1] = (f6 * f5) + f5;
                aVar.b()[2] = 0.0f;
                double d6 = f5;
                aVar.b()[3] = (float) (((-Math.tan(0.2617993877991494d)) * d6) + d6);
                double dCos = Math.cos(0.7853981633974483d) * d6;
                double dCos2 = Math.cos(0.7853981633974483d) * Math.tan(0.24434609527920614d) * d6;
                aVar.b()[4] = (float) ((-(dCos2 + dCos)) + d6);
                aVar.b()[5] = (float) ((-(dCos - dCos2)) + d6);
                double d7 = -f5;
                aVar.b()[6] = (float) ((Math.cos(0.7853981633974483d) * d7) + d6);
                aVar.b()[7] = (float) ((d7 * Math.sin(0.7853981633974483d)) + d6);
                aVar.b()[8] = aVar.b()[5];
                aVar.b()[9] = aVar.b()[4];
                aVar.b()[10] = aVar.b()[3];
                aVar.b()[11] = aVar.b()[2];
                aVar.b()[12] = aVar.b()[1];
                aVar.b()[13] = aVar.b()[0];
                return aVar;
            }

            private C0063a() {
            }
        }

        public /* synthetic */ a(j4.g gVar) {
            this();
        }

        public final void a(Path path) {
            j4.k.g(path, "path");
            float[] fArr = this.f4215a;
            path.cubicTo(fArr[2], fArr[3], fArr[4], fArr[5], fArr[6], fArr[7]);
            float[] fArr2 = this.f4215a;
            path.cubicTo(fArr2[8], fArr2[9], fArr2[10], fArr2[11], fArr2[12], fArr2[13]);
        }

        public final float[] b() {
            return this.f4215a;
        }

        public final void c(float f5, float f6) {
            int i5 = 0;
            int iC = C0586c.c(0, this.f4215a.length - 1, 2);
            if (iC < 0) {
                return;
            }
            while (true) {
                float[] fArr = this.f4215a;
                fArr[i5] = fArr[i5] + f5;
                int i6 = i5 + 1;
                fArr[i6] = fArr[i6] + f6;
                if (i5 == iC) {
                    return;
                } else {
                    i5 += 2;
                }
            }
        }

        public final void d() {
            float[] fArr = this.f4215a;
            float f5 = fArr[0];
            float f6 = fArr[1];
            fArr[0] = fArr[12];
            fArr[1] = fArr[13];
            fArr[12] = f5;
            fArr[13] = f6;
            float f7 = fArr[2];
            float f8 = fArr[3];
            fArr[2] = fArr[10];
            fArr[3] = fArr[11];
            fArr[10] = f7;
            fArr[11] = f8;
            float f9 = fArr[4];
            float f10 = fArr[5];
            fArr[4] = fArr[8];
            fArr[5] = fArr[9];
            fArr[8] = f9;
            fArr[9] = f10;
        }

        private a() {
            this.f4215a = new float[14];
        }
    }

    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final float f4216a;

        /* renamed from: b, reason: collision with root package name */
        private final float f4217b;

        /* renamed from: c, reason: collision with root package name */
        private final float f4218c;

        /* renamed from: d, reason: collision with root package name */
        private final float f4219d;

        /* renamed from: e, reason: collision with root package name */
        private final float f4220e;

        /* renamed from: f, reason: collision with root package name */
        private final float f4221f;

        /* renamed from: g, reason: collision with root package name */
        private final boolean f4222g;

        public b(float f5, float f6, float f7, float f8, float f9, float f10, boolean z5) {
            this.f4216a = f5;
            this.f4217b = f6;
            this.f4218c = f7;
            this.f4219d = f8;
            this.f4220e = f9;
            this.f4221f = f10;
            this.f4222g = z5;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return Float.compare(this.f4216a, bVar.f4216a) == 0 && Float.compare(this.f4217b, bVar.f4217b) == 0 && Float.compare(this.f4218c, bVar.f4218c) == 0 && Float.compare(this.f4219d, bVar.f4219d) == 0 && Float.compare(this.f4220e, bVar.f4220e) == 0 && Float.compare(this.f4221f, bVar.f4221f) == 0 && this.f4222g == bVar.f4222g;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int iHashCode = ((((((((((Float.hashCode(this.f4216a) * 31) + Float.hashCode(this.f4217b)) * 31) + Float.hashCode(this.f4218c)) * 31) + Float.hashCode(this.f4219d)) * 31) + Float.hashCode(this.f4220e)) * 31) + Float.hashCode(this.f4221f)) * 31;
            boolean z5 = this.f4222g;
            int i5 = z5;
            if (z5 != 0) {
                i5 = 1;
            }
            return iHashCode + i5;
        }

        public String toString() {
            return "SmoothPathParams(left=" + this.f4216a + ", top=" + this.f4217b + ", right=" + this.f4218c + ", bottom=" + this.f4219d + ", smoothness=" + this.f4220e + ", radius=" + this.f4221f + ", useNativeRoundCornerWhileParamsInvalid=" + this.f4222g + ')';
        }
    }

    public static final class c extends LruCache<b, Path> {
        public c(int i5) {
            super(i5);
        }

        @Override // android.util.LruCache
        protected Path create(b bVar) {
            return null;
        }

        @Override // android.util.LruCache
        protected void entryRemoved(boolean z5, b bVar, Path path, Path path2) {
        }

        @Override // android.util.LruCache
        protected int sizeOf(b bVar, Path path) {
            return 1;
        }
    }

    static {
        Paint paint = new Paint();
        paint.setColor(0);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        paint.setAntiAlias(true);
        f4213c = paint;
    }

    private k() {
    }

    public static final Path a(float f5, float f6, float f7, float f8, float f9, float f10, boolean z5) {
        Path path = new Path();
        b bVar = new b(f5, f6, f7, f8, f9, f10, z5);
        LruCache<b, Path> lruCache = f4212b;
        Path path2 = lruCache.get(bVar);
        if (path2 != null) {
            path.addPath(path2);
            return path;
        }
        lruCache.put(bVar, path);
        float f11 = f7 - f5;
        float f12 = f8 - f6;
        if (f11 <= 0.0f || f12 <= 0.0f) {
            path.addRect(f5, f6, f7, f8, Path.Direction.CW);
            return new Path(path);
        }
        if (z5 && f10 > f4211a.e(f11, f12, f9)) {
            path.addRoundRect(f5, f6, f7, f8, f10, f10, Path.Direction.CW);
            return new Path(path);
        }
        float f13 = (f7 + f5) / 2.0f;
        float f14 = (f8 + f6) / 2.0f;
        a aVarA = a.f4214b.a(f10, f9);
        aVarA.c(f5, f6);
        path.moveTo(aVarA.b()[0], aVarA.b()[1]);
        aVarA.a(path);
        Matrix matrix = new Matrix();
        float f15 = -f13;
        float f16 = -f14;
        matrix.postTranslate(f15, f16);
        matrix.postScale(-1.0f, 1.0f);
        matrix.postTranslate(f13, f14);
        matrix.mapPoints(aVarA.b());
        aVarA.d();
        path.lineTo(aVarA.b()[0], aVarA.b()[1]);
        aVarA.a(path);
        aVarA.d();
        matrix.reset();
        matrix.postTranslate(f15, f16);
        matrix.postScale(1.0f, -1.0f);
        matrix.postTranslate(f13, f14);
        matrix.mapPoints(aVarA.b());
        path.lineTo(aVarA.b()[0], aVarA.b()[1]);
        aVarA.a(path);
        matrix.reset();
        matrix.postTranslate(f15, f16);
        matrix.postScale(-1.0f, 1.0f);
        matrix.postTranslate(f13, f14);
        matrix.mapPoints(aVarA.b());
        aVarA.d();
        path.lineTo(aVarA.b()[0], aVarA.b()[1]);
        aVarA.a(path);
        path.close();
        return new Path(path);
    }

    public static /* synthetic */ Path b(float f5, float f6, float f7, float f8, float f9, float f10, boolean z5, int i5, Object obj) {
        if ((i5 & 64) != 0) {
            z5 = false;
        }
        return a(f5, f6, f7, f8, f9, f10, z5);
    }

    public final Paint c() {
        return f4213c;
    }

    public final float d(float f5, float f6) {
        return kotlin.ranges.l.d(f5, (f5 / 2.0f) / (f6 + 1.0f));
    }

    public final float e(float f5, float f6, float f7) {
        return d(Math.min(f5, f6), f7);
    }
}
