package O0;

import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.JsonReader;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.airbnb.lottie.LottieComposition;
import com.stepos.alphame.utils.Property;
import f1.AbstractC0557a;
import java.lang.ref.WeakReference;
import q.m;

/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final LinearInterpolator f1528a = new LinearInterpolator();

    /* renamed from: b, reason: collision with root package name */
    public static m f1529b;

    public static Q0.a a(JsonReader jsonReader, LottieComposition lottieComposition, float f4, k kVar, boolean z4) {
        Interpolator interpolator;
        Object obj;
        WeakReference weakReference;
        if (!z4) {
            return new Q0.a(kVar.a(jsonReader, f4));
        }
        jsonReader.beginObject();
        PointF pointFB = null;
        PointF pointFB2 = null;
        Object objA = null;
        Object objA2 = null;
        PointF pointFB3 = null;
        PointF pointFB4 = null;
        float fNextDouble = 0.0f;
        while (true) {
            boolean z5 = false;
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                strNextName.getClass();
                switch (strNextName) {
                    case "e":
                        objA = kVar.a(jsonReader, f4);
                        break;
                    case "h":
                        if (jsonReader.nextInt() == 1) {
                            z5 = true;
                            break;
                        }
                        break;
                    case "i":
                        pointFB2 = com.stepos.statsrpk.c.B(jsonReader, f4);
                        break;
                    case "o":
                        pointFB = com.stepos.statsrpk.c.B(jsonReader, f4);
                        break;
                    case "s":
                        objA2 = kVar.a(jsonReader, f4);
                        break;
                    case "t":
                        fNextDouble = (float) jsonReader.nextDouble();
                        break;
                    case "ti":
                        pointFB3 = com.stepos.statsrpk.c.B(jsonReader, f4);
                        break;
                    case "to":
                        pointFB4 = com.stepos.statsrpk.c.B(jsonReader, f4);
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            jsonReader.endObject();
            if (z5) {
                interpolator = f1528a;
                obj = objA2;
            } else {
                if (pointFB == null || pointFB2 == null) {
                    interpolator = f1528a;
                } else {
                    float f5 = -f4;
                    pointFB.x = AbstractC0557a.p(pointFB.x, f5, f4);
                    pointFB.y = AbstractC0557a.p(pointFB.y, -100.0f, 100.0f);
                    pointFB2.x = AbstractC0557a.p(pointFB2.x, f5, f4);
                    float fP = AbstractC0557a.p(pointFB2.y, -100.0f, 100.0f);
                    pointFB2.y = fP;
                    float f6 = pointFB.x;
                    float f7 = pointFB.y;
                    float f8 = pointFB2.x;
                    PathMeasure pathMeasure = P0.c.f1558a;
                    int i4 = f6 != Property.DEFAULT_FLOAT_VALUE ? (int) (527 * f6) : 17;
                    if (f7 != Property.DEFAULT_FLOAT_VALUE) {
                        i4 = (int) (i4 * 31 * f7);
                    }
                    if (f8 != Property.DEFAULT_FLOAT_VALUE) {
                        i4 = (int) (i4 * 31 * f8);
                    }
                    if (fP != Property.DEFAULT_FLOAT_VALUE) {
                        i4 = (int) (i4 * 31 * fP);
                    }
                    synchronized (f.class) {
                        if (f1529b == null) {
                            f1529b = new m();
                        }
                        weakReference = (WeakReference) f1529b.c(i4);
                    }
                    Interpolator interpolatorB = weakReference != null ? (Interpolator) weakReference.get() : null;
                    if (weakReference == null || interpolatorB == null) {
                        interpolatorB = M.a.b(pointFB.x / f4, pointFB.y / f4, pointFB2.x / f4, pointFB2.y / f4);
                        try {
                            WeakReference weakReference2 = new WeakReference(interpolatorB);
                            synchronized (f.class) {
                                f1529b.d(i4, weakReference2);
                            }
                        } catch (ArrayIndexOutOfBoundsException unused) {
                        }
                    }
                    interpolator = interpolatorB;
                }
                obj = objA;
            }
            Q0.a aVar = new Q0.a(lottieComposition, objA2, obj, interpolator, fNextDouble, null);
            aVar.f1634i = pointFB4;
            aVar.f1635j = pointFB3;
            return aVar;
        }
    }
}
