package androidx.core.graphics;

import android.graphics.Path;
import android.graphics.PointF;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: loaded from: classes17.dex */
public final class PathUtils {

    public static class Api26Impl {
        private Api26Impl() {
        }

        public static float[] approximate(Path r100, float r101) {
            return r100.approximate(r101);
        }
    }

    private PathUtils() {
    }

    public static Collection<PathSegment> flatten(Path r100) {
        return flatten(r100, 0.5f);
    }

    public static Collection<PathSegment> flatten(Path r110, float r111) {
        float[] r112 = Api26Impl.approximate(r110, r111);
        int r113 = r112.length / 3;
        ArrayList r100 = new ArrayList(r113);
        int r101 = 1;
    L3:
        if (r101 >= r113) goto L12;
        int r102 = r101 * 3;
        int r103 = (r101 - 1) * 3;
        float r104 = r112[r102];
        float r105 = r112[r102 + 1];
        float r106 = r112[r102 + 2];
        float r107 = r112[r103];
        float r108 = r112[r103 + 1];
        float r109 = r112[r103 + 2];
        if (r104 == r107) goto L11;
        if (r105 == r108) goto L9;
    L10:
        r100.add(new PathSegment(new PointF(r108, r109), r107, new PointF(r105, r106), r104));
        goto L11
    L9:
        if (r106 != r109) goto L10;
    L11:
        r101 = r101 + 1;
        goto L3
    L12:
        return r100;
    }
}
