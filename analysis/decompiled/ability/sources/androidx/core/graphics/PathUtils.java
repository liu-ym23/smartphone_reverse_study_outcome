package androidx.core.graphics;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.FloatRange;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes2.dex */
public final class PathUtils {

    @RequiresApi(26)
    public static class Api26Impl {
        private Api26Impl() {
        }

        public static float[] approximate(Path path, float f) {
            return path.approximate(f);
        }
    }

    private PathUtils() {
    }

    @RequiresApi(26)
    public static Collection<PathSegment> flatten(Path path) {
        return flatten(path, 0.5f);
    }

    @RequiresApi(26)
    public static Collection<PathSegment> flatten(Path path, @FloatRange(from = 0.0d) float f) {
        float[] fArrApproximate = Api26Impl.approximate(path, f);
        int length = fArrApproximate.length / 3;
        ArrayList arrayList = new ArrayList(length);
        for (int i = 1; i < length; i++) {
            int i6 = i * 3;
            int i10 = (i - 1) * 3;
            float f7 = fArrApproximate[i6];
            float f9 = fArrApproximate[i6 + 1];
            float f10 = fArrApproximate[i6 + 2];
            float f11 = fArrApproximate[i10];
            float f12 = fArrApproximate[i10 + 1];
            float f13 = fArrApproximate[i10 + 2];
            if (f7 != f11 && (f9 != f12 || f10 != f13)) {
                arrayList.add(new PathSegment(new PointF(f12, f13), f11, new PointF(f9, f10), f7));
            }
        }
        return arrayList;
    }
}
