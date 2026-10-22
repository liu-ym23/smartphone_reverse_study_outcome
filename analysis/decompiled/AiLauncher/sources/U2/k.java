package U2;

import U2.b;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Rect;
import java.util.Arrays;

/* loaded from: classes2.dex */
public abstract class k<S extends U2.b> {

    /* renamed from: a, reason: collision with root package name */
    public S f6265a;

    /* renamed from: b, reason: collision with root package name */
    public final Path f6266b;

    /* renamed from: c, reason: collision with root package name */
    public final Path f6267c;

    /* renamed from: d, reason: collision with root package name */
    public final PathMeasure f6268d;

    /* renamed from: e, reason: collision with root package name */
    public final Matrix f6269e;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public float f6270a;

        /* renamed from: b, reason: collision with root package name */
        public float f6271b;

        /* renamed from: c, reason: collision with root package name */
        public int f6272c;

        /* renamed from: d, reason: collision with root package name */
        public int f6273d;

        /* renamed from: e, reason: collision with root package name */
        public float f6274e = 1.0f;

        /* renamed from: f, reason: collision with root package name */
        public float f6275f;

        /* renamed from: g, reason: collision with root package name */
        public float f6276g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f6277h;
    }

    public k(S s10) {
        Path path = new Path();
        this.f6266b = path;
        this.f6267c = new Path();
        this.f6268d = new PathMeasure(path, false);
        this.f6265a = s10;
        this.f6269e = new Matrix();
    }

    public abstract void a(Canvas canvas, Rect rect, float f10, boolean z10, boolean z11);

    public abstract void b(Canvas canvas, Paint paint, int i10, int i11);

    public abstract void c(Canvas canvas, Paint paint, a aVar, int i10);

    public abstract void d(Canvas canvas, Paint paint, float f10, float f11, int i10, int i11, int i12);

    public abstract int e();

    public abstract int f();

    public abstract void g();

    public void h(Canvas canvas, Rect rect, float f10, boolean z10, boolean z11) {
        this.f6265a.h();
        a(canvas, rect, f10, z10, z11);
    }

    public float i(float[] fArr) {
        return (float) Math.toDegrees(Math.atan2(fArr[1], fArr[0]));
    }

    public class b {

        /* renamed from: a, reason: collision with root package name */
        public float[] f6278a;

        /* renamed from: b, reason: collision with root package name */
        public float[] f6279b;

        /* renamed from: c, reason: collision with root package name */
        public final Matrix f6280c;

        public b() {
            this.f6278a = new float[2];
            this.f6279b = new float[]{1.0f, 0.0f};
            this.f6280c = new Matrix();
        }

        public void a(float f10) {
            float[] fArr = this.f6279b;
            float fAtan2 = (float) (Math.atan2(fArr[1], fArr[0]) + 1.5707963267948966d);
            double d10 = f10;
            double d11 = fAtan2;
            this.f6278a[0] = (float) (r2[0] + (Math.cos(d11) * d10));
            this.f6278a[1] = (float) (r13[1] + (d10 * Math.sin(d11)));
        }

        public void b(float f10) {
            float[] fArr = this.f6279b;
            float fAtan2 = (float) Math.atan2(fArr[1], fArr[0]);
            double d10 = f10;
            double d11 = fAtan2;
            this.f6278a[0] = (float) (r2[0] + (Math.cos(d11) * d10));
            this.f6278a[1] = (float) (r13[1] + (d10 * Math.sin(d11)));
        }

        public void c() {
            Arrays.fill(this.f6278a, 0.0f);
            Arrays.fill(this.f6279b, 0.0f);
            this.f6279b[0] = 1.0f;
            this.f6280c.reset();
        }

        public void d(float f10) {
            this.f6280c.reset();
            this.f6280c.setRotate(f10);
            this.f6280c.mapPoints(this.f6278a);
            this.f6280c.mapPoints(this.f6279b);
        }

        public b(k kVar, k<S>.b bVar) {
            this(bVar.f6278a, bVar.f6279b);
        }

        public b(float[] fArr, float[] fArr2) {
            float[] fArr3 = new float[2];
            this.f6278a = fArr3;
            this.f6279b = new float[2];
            System.arraycopy(fArr, 0, fArr3, 0, 2);
            System.arraycopy(fArr2, 0, this.f6279b, 0, 2);
            this.f6280c = new Matrix();
        }
    }
}
