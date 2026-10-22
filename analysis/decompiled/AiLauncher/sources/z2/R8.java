package z2;

import android.graphics.Point;
import java.util.Iterator;

/* loaded from: classes2.dex */
public abstract class R8 {
    public static R8 f(Iterable iterable, int i10, int i11, float f10) {
        Iterator it = iterable.iterator();
        int iMax = 0;
        int iMin = i10;
        int iMin2 = i11;
        int iMax2 = 0;
        while (it.hasNext()) {
            Point point = (Point) it.next();
            iMin = Math.min(iMin, point.x);
            iMin2 = Math.min(iMin2, point.y);
            iMax = Math.max(iMax, point.x);
            iMax2 = Math.max(iMax2, point.y);
        }
        float f11 = i10;
        float f12 = i11;
        return new P8((iMin + 0.0f) / f11, (iMin2 + 0.0f) / f12, (iMax + 0.0f) / f11, (iMax2 + 0.0f) / f12, 0.0f);
    }

    public abstract float a();

    public abstract float b();

    public abstract float c();

    public abstract float d();

    public abstract float e();
}
