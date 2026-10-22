package Y2;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import t0.C5502d;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f6990i = new int[3];

    /* renamed from: j, reason: collision with root package name */
    public static final float[] f6991j = {0.0f, 0.5f, 1.0f};

    /* renamed from: k, reason: collision with root package name */
    public static final int[] f6992k = new int[4];

    /* renamed from: l, reason: collision with root package name */
    public static final float[] f6993l = {0.0f, 0.0f, 0.5f, 1.0f};

    /* renamed from: a, reason: collision with root package name */
    public final Paint f6994a;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f6995b;

    /* renamed from: c, reason: collision with root package name */
    public final Paint f6996c;

    /* renamed from: d, reason: collision with root package name */
    public int f6997d;

    /* renamed from: e, reason: collision with root package name */
    public int f6998e;

    /* renamed from: f, reason: collision with root package name */
    public int f6999f;

    /* renamed from: g, reason: collision with root package name */
    public final Path f7000g;

    /* renamed from: h, reason: collision with root package name */
    public final Paint f7001h;

    public a() {
        this(-16777216);
    }

    public void a(Canvas canvas, Matrix matrix, RectF rectF, int i10, float f10, float f11) {
        float f12;
        boolean z10 = f11 < 0.0f;
        Path path = this.f7000g;
        if (z10) {
            int[] iArr = f6992k;
            iArr[0] = 0;
            iArr[1] = this.f6999f;
            iArr[2] = this.f6998e;
            iArr[3] = this.f6997d;
            f12 = f10;
        } else {
            path.rewind();
            path.moveTo(rectF.centerX(), rectF.centerY());
            f12 = f10;
            path.arcTo(rectF, f12, f11);
            path.close();
            float f13 = -i10;
            rectF.inset(f13, f13);
            int[] iArr2 = f6992k;
            iArr2[0] = 0;
            iArr2[1] = this.f6997d;
            iArr2[2] = this.f6998e;
            iArr2[3] = this.f6999f;
        }
        float fWidth = rectF.width() / 2.0f;
        if (fWidth <= 0.0f) {
            return;
        }
        float f14 = 1.0f - (i10 / fWidth);
        float[] fArr = f6993l;
        fArr[1] = f14;
        fArr[2] = ((1.0f - f14) / 2.0f) + f14;
        this.f6995b.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), fWidth, f6992k, fArr, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.scale(1.0f, rectF.height() / rectF.width());
        if (!z10) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawPath(path, this.f7001h);
        }
        canvas.drawArc(rectF, f12, f11, true, this.f6995b);
        canvas.restore();
    }

    public void b(Canvas canvas, Matrix matrix, RectF rectF, int i10) {
        rectF.bottom += i10;
        rectF.offset(0.0f, -i10);
        int[] iArr = f6990i;
        iArr[0] = this.f6999f;
        iArr[1] = this.f6998e;
        iArr[2] = this.f6997d;
        Paint paint = this.f6996c;
        float f10 = rectF.left;
        paint.setShader(new LinearGradient(f10, rectF.top, f10, rectF.bottom, iArr, f6991j, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.drawRect(rectF, this.f6996c);
        canvas.restore();
    }

    public Paint c() {
        return this.f6994a;
    }

    public void d(int i10) {
        this.f6997d = C5502d.k(i10, 68);
        this.f6998e = C5502d.k(i10, 20);
        this.f6999f = C5502d.k(i10, 0);
        this.f6994a.setColor(this.f6997d);
    }

    public a(int i10) {
        this.f7000g = new Path();
        Paint paint = new Paint();
        this.f7001h = paint;
        this.f6994a = new Paint();
        d(i10);
        paint.setColor(0);
        Paint paint2 = new Paint(4);
        this.f6995b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.f6996c = new Paint(paint2);
    }
}
