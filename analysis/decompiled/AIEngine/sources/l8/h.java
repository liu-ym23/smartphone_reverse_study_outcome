package l8;

import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.LruCache;
import mb.y;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final c f10359a = new c(100);

    /* renamed from: b, reason: collision with root package name */
    public static final Paint f10360b;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public float[] f10361a;

        public final void a(Path path) {
            float[] fArr = this.f10361a;
            path.cubicTo(fArr[2], fArr[3], fArr[4], fArr[5], fArr[6], fArr[7]);
            path.cubicTo(fArr[8], fArr[9], fArr[10], fArr[11], fArr[12], fArr[13]);
        }

        public final void b() {
            float[] fArr = this.f10361a;
            float f8 = fArr[0];
            float f9 = fArr[1];
            fArr[0] = fArr[12];
            fArr[1] = fArr[13];
            fArr[12] = f8;
            fArr[13] = f9;
            float f10 = fArr[2];
            float f11 = fArr[3];
            fArr[2] = fArr[10];
            fArr[3] = fArr[11];
            fArr[10] = f10;
            fArr[11] = f11;
            float f12 = fArr[4];
            float f13 = fArr[5];
            fArr[4] = fArr[8];
            fArr[5] = fArr[9];
            fArr[8] = f12;
            fArr[9] = f13;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final float f10362a;

        /* renamed from: b, reason: collision with root package name */
        public final float f10363b;

        /* renamed from: c, reason: collision with root package name */
        public final float f10364c;

        /* renamed from: d, reason: collision with root package name */
        public final float f10365d;

        /* renamed from: e, reason: collision with root package name */
        public final float f10366e;

        /* renamed from: f, reason: collision with root package name */
        public final float f10367f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean f10368g;

        public b(float f8, float f9, float f10, float f11, float f12, float f13, boolean z) {
            this.f10362a = f8;
            this.f10363b = f9;
            this.f10364c = f10;
            this.f10365d = f11;
            this.f10366e = f12;
            this.f10367f = f13;
            this.f10368g = z;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return Float.compare(this.f10362a, bVar.f10362a) == 0 && Float.compare(this.f10363b, bVar.f10363b) == 0 && Float.compare(this.f10364c, bVar.f10364c) == 0 && Float.compare(this.f10365d, bVar.f10365d) == 0 && Float.compare(this.f10366e, bVar.f10366e) == 0 && Float.compare(this.f10367f, bVar.f10367f) == 0 && this.f10368g == bVar.f10368g;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final int hashCode() {
            int iA = a0.a.a(this.f10367f, a0.a.a(this.f10366e, a0.a.a(this.f10365d, a0.a.a(this.f10364c, a0.a.a(this.f10363b, Float.hashCode(this.f10362a) * 31, 31), 31), 31), 31), 31);
            boolean z = this.f10368g;
            int i10 = z;
            if (z != 0) {
                i10 = 1;
            }
            return iA + i10;
        }

        public final String toString() {
            return "SmoothPathParams(left=" + this.f10362a + ", top=" + this.f10363b + ", right=" + this.f10364c + ", bottom=" + this.f10365d + ", smoothness=" + this.f10366e + ", radius=" + this.f10367f + ", useNativeRoundCornerWhileParamsInvalid=" + this.f10368g + ')';
        }
    }

    static {
        Paint paint = new Paint();
        paint.setColor(0);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        paint.setAntiAlias(true);
        f10360b = paint;
    }

    public static final Path a(float f8, float f9, float f10, float f11, float f12, float f13, boolean z) {
        Path path = new Path();
        b bVar = new b(f8, f9, f10, f11, f12, f13, z);
        c cVar = f10359a;
        Path path2 = cVar.get(bVar);
        if (path2 != null) {
            path.addPath(path2);
            return path;
        }
        cVar.put(bVar, path);
        float f14 = f10 - f8;
        float f15 = f11 - f9;
        if (f14 <= 0.0f || f15 <= 0.0f) {
            path.addRect(f8, f9, f10, f11, Path.Direction.CW);
            return new Path(path);
        }
        if (z && f13 > b(f14, f15, f12)) {
            path.addRoundRect(f8, f9, f10, f11, f13, f13, Path.Direction.CW);
            return new Path(path);
        }
        float f16 = (f8 + f10) / 2.0f;
        float f17 = (f9 + f11) / 2.0f;
        a aVar = new a();
        float[] fArr = new float[14];
        aVar.f10361a = fArr;
        fArr[0] = 0.0f;
        fArr[1] = (f12 * f13) + f13;
        fArr[2] = 0.0f;
        double d8 = f13;
        fArr[3] = (float) (((-Math.tan(0.2617993877991494d)) * d8) + d8);
        double dCos = Math.cos(0.7853981633974483d) * d8;
        double dTan = Math.tan(0.24434609527920614d) * Math.cos(0.7853981633974483d) * d8;
        fArr[4] = (float) ((-(dTan + dCos)) + d8);
        fArr[5] = (float) ((-(dCos - dTan)) + d8);
        double d10 = -f13;
        fArr[6] = (float) ((Math.cos(0.7853981633974483d) * d10) + d8);
        fArr[7] = (float) ((Math.sin(0.7853981633974483d) * d10) + d8);
        fArr[8] = fArr[5];
        fArr[9] = fArr[4];
        fArr[10] = fArr[3];
        fArr[11] = fArr[2];
        fArr[12] = fArr[1];
        fArr[13] = fArr[0];
        int iZ = y.z(0, 13, 2);
        if (iZ >= 0) {
            int i10 = 0;
            while (true) {
                fArr[i10] = fArr[i10] + f8;
                int i11 = i10 + 1;
                fArr[i11] = fArr[i11] + f9;
                if (i10 == iZ) {
                    break;
                }
                i10 += 2;
            }
        }
        float[] fArr2 = aVar.f10361a;
        path.moveTo(fArr2[0], fArr2[1]);
        aVar.a(path);
        Matrix matrix = new Matrix();
        float f18 = -f16;
        float f19 = -f17;
        matrix.postTranslate(f18, f19);
        matrix.postScale(-1.0f, 1.0f);
        matrix.postTranslate(f16, f17);
        matrix.mapPoints(aVar.f10361a);
        aVar.b();
        float[] fArr3 = aVar.f10361a;
        path.lineTo(fArr3[0], fArr3[1]);
        aVar.a(path);
        aVar.b();
        matrix.reset();
        matrix.postTranslate(f18, f19);
        matrix.postScale(1.0f, -1.0f);
        matrix.postTranslate(f16, f17);
        matrix.mapPoints(aVar.f10361a);
        float[] fArr4 = aVar.f10361a;
        path.lineTo(fArr4[0], fArr4[1]);
        aVar.a(path);
        matrix.reset();
        matrix.postTranslate(f18, f19);
        matrix.postScale(-1.0f, 1.0f);
        matrix.postTranslate(f16, f17);
        matrix.mapPoints(aVar.f10361a);
        aVar.b();
        float[] fArr5 = aVar.f10361a;
        path.lineTo(fArr5[0], fArr5[1]);
        aVar.a(path);
        path.close();
        return new Path(path);
    }

    public static float b(float f8, float f9, float f10) {
        float fMin = Math.min(f8, f9);
        float f11 = (fMin / 2.0f) / (f10 + 1.0f);
        return fMin > f11 ? f11 : fMin;
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class c extends LruCache<b, Path> {
        @Override // android.util.LruCache
        public final Path create(b bVar) {
            return null;
        }

        @Override // android.util.LruCache
        public final int sizeOf(b bVar, Path path) {
            return 1;
        }

        @Override // android.util.LruCache
        public final void entryRemoved(boolean z, b bVar, Path path, Path path2) {
        }
    }
}
