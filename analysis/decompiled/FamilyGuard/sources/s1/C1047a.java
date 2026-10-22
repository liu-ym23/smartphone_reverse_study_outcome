package s1;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;

/* renamed from: s1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1047a {

    /* renamed from: i, reason: collision with root package name */
    private static final int[] f20229i = new int[3];

    /* renamed from: j, reason: collision with root package name */
    private static final float[] f20230j = {0.0f, 0.5f, 1.0f};

    /* renamed from: k, reason: collision with root package name */
    private static final int[] f20231k = new int[4];

    /* renamed from: l, reason: collision with root package name */
    private static final float[] f20232l = {0.0f, 0.0f, 0.5f, 1.0f};

    /* renamed from: a, reason: collision with root package name */
    private final Paint f20233a;

    /* renamed from: b, reason: collision with root package name */
    private final Paint f20234b;

    /* renamed from: c, reason: collision with root package name */
    private final Paint f20235c;

    /* renamed from: d, reason: collision with root package name */
    private int f20236d;

    /* renamed from: e, reason: collision with root package name */
    private int f20237e;

    /* renamed from: f, reason: collision with root package name */
    private int f20238f;

    /* renamed from: g, reason: collision with root package name */
    private final Path f20239g;

    /* renamed from: h, reason: collision with root package name */
    private final Paint f20240h;

    public C1047a() {
        this(-16777216);
    }

    public void a(Canvas canvas, Matrix matrix, RectF rectF, int i5, float f5, float f6) {
        float f7;
        boolean z5 = f6 < 0.0f;
        Path path = this.f20239g;
        if (z5) {
            int[] iArr = f20231k;
            iArr[0] = 0;
            iArr[1] = this.f20238f;
            iArr[2] = this.f20237e;
            iArr[3] = this.f20236d;
            f7 = f5;
        } else {
            path.rewind();
            path.moveTo(rectF.centerX(), rectF.centerY());
            f7 = f5;
            path.arcTo(rectF, f7, f6);
            path.close();
            float f8 = -i5;
            rectF.inset(f8, f8);
            int[] iArr2 = f20231k;
            iArr2[0] = 0;
            iArr2[1] = this.f20236d;
            iArr2[2] = this.f20237e;
            iArr2[3] = this.f20238f;
        }
        float fWidth = rectF.width() / 2.0f;
        if (fWidth <= 0.0f) {
            return;
        }
        float f9 = 1.0f - (i5 / fWidth);
        float[] fArr = f20232l;
        fArr[1] = f9;
        fArr[2] = ((1.0f - f9) / 2.0f) + f9;
        this.f20234b.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), fWidth, f20231k, fArr, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.scale(1.0f, rectF.height() / rectF.width());
        if (!z5) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawPath(path, this.f20240h);
        }
        canvas.drawArc(rectF, f7, f6, true, this.f20234b);
        canvas.restore();
    }

    public void b(Canvas canvas, Matrix matrix, RectF rectF, int i5) {
        rectF.bottom += i5;
        rectF.offset(0.0f, -i5);
        int[] iArr = f20229i;
        iArr[0] = this.f20238f;
        iArr[1] = this.f20237e;
        iArr[2] = this.f20236d;
        Paint paint = this.f20235c;
        float f5 = rectF.left;
        paint.setShader(new LinearGradient(f5, rectF.top, f5, rectF.bottom, iArr, f20230j, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.drawRect(rectF, this.f20235c);
        canvas.restore();
    }

    public Paint c() {
        return this.f20233a;
    }

    public void d(int i5) {
        this.f20236d = androidx.core.graphics.a.k(i5, 68);
        this.f20237e = androidx.core.graphics.a.k(i5, 20);
        this.f20238f = androidx.core.graphics.a.k(i5, 0);
        this.f20233a.setColor(this.f20236d);
    }

    public C1047a(int i5) {
        this.f20239g = new Path();
        Paint paint = new Paint();
        this.f20240h = paint;
        this.f20233a = new Paint();
        d(i5);
        paint.setColor(0);
        Paint paint2 = new Paint(4);
        this.f20234b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.f20235c = new Paint(paint2);
    }
}
