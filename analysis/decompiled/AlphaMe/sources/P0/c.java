package P0;

import G0.s;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import com.airbnb.lottie.AbstractC0398c;
import com.stepos.alphame.utils.Property;
import f1.AbstractC0557a;
import java.util.HashSet;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final PathMeasure f1558a = new PathMeasure();

    /* renamed from: b, reason: collision with root package name */
    public static final Path f1559b = new Path();

    /* renamed from: c, reason: collision with root package name */
    public static final Path f1560c = new Path();

    /* renamed from: d, reason: collision with root package name */
    public static final float[] f1561d = new float[4];

    /* renamed from: e, reason: collision with root package name */
    public static final float f1562e = (float) Math.sqrt(2.0d);

    /* renamed from: f, reason: collision with root package name */
    public static float f1563f = -1.0f;

    public static void a(Path path, float f4, float f5, float f6) {
        HashSet hashSet = AbstractC0398c.f4541a;
        PathMeasure pathMeasure = f1558a;
        pathMeasure.setPath(path, false);
        float length = pathMeasure.getLength();
        if (f4 == 1.0f && f5 == Property.DEFAULT_FLOAT_VALUE) {
            AbstractC0398c.a();
            return;
        }
        if (length < 1.0f || Math.abs((f5 - f4) - 1.0f) < 0.01d) {
            AbstractC0398c.a();
            return;
        }
        float f7 = f4 * length;
        float f8 = f5 * length;
        float f9 = f6 * length;
        float fMin = Math.min(f7, f8) + f9;
        float fMax = Math.max(f7, f8) + f9;
        if (fMin >= length && fMax >= length) {
            fMin = AbstractC0557a.s(fMin, length);
            fMax = AbstractC0557a.s(fMax, length);
        }
        if (fMin < Property.DEFAULT_FLOAT_VALUE) {
            fMin = AbstractC0557a.s(fMin, length);
        }
        if (fMax < Property.DEFAULT_FLOAT_VALUE) {
            fMax = AbstractC0557a.s(fMax, length);
        }
        if (fMin == fMax) {
            path.reset();
            AbstractC0398c.a();
            return;
        }
        if (fMin >= fMax) {
            fMin -= length;
        }
        Path path2 = f1559b;
        path2.reset();
        pathMeasure.getSegment(fMin, fMax, path2, true);
        Path path3 = f1560c;
        if (fMax > length) {
            path3.reset();
            pathMeasure.getSegment(Property.DEFAULT_FLOAT_VALUE, fMax % length, path3, true);
            path2.addPath(path3);
        } else if (fMin < Property.DEFAULT_FLOAT_VALUE) {
            path3.reset();
            pathMeasure.getSegment(fMin + length, length, path3, true);
            path2.addPath(path3);
        }
        path.set(path2);
        AbstractC0398c.a();
    }

    public static void b(Path path, s sVar) {
        if (sVar == null) {
            return;
        }
        a(path, ((Float) sVar.f581c.e()).floatValue() / 100.0f, ((Float) sVar.f582d.e()).floatValue() / 100.0f, ((Float) sVar.f583e.e()).floatValue() / 360.0f);
    }

    public static float c() {
        if (f1563f == -1.0f) {
            f1563f = Resources.getSystem().getDisplayMetrics().density;
        }
        return f1563f;
    }

    public static float d(Matrix matrix) {
        float[] fArr = f1561d;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        float f4 = f1562e;
        fArr[2] = f4;
        fArr[3] = f4;
        matrix.mapPoints(fArr);
        return ((float) Math.hypot(fArr[2] - fArr[0], fArr[3] - fArr[1])) / 2.0f;
    }
}
