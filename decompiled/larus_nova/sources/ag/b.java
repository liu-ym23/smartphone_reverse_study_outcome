package ag;

import android.animation.TypeEvaluator;
import android.graphics.PointF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b implements TypeEvaluator<PointF> {
    public b() {
    }

    @Override // android.animation.TypeEvaluator
    public final PointF evaluate(float r100, PointF r101, PointF r102) {
        PointF r103 = r101;
        PointF r104 = r102;
        Intrinsics.checkNotNullParameter(r103, "startValue");
        Intrinsics.checkNotNullParameter(r104, "endValue");
        PointF r105 = new PointF();
        float r106 = r103.x;
        float r107 = 1.0f - r100;
        r105.x = r106 + ((r104.x - r106) * (1.0f - (r107 * r107)));
        float r108 = r103.y;
        r105.y = r108 + ((r104.y - r108) * (r100 * r100));
        return r105;
    }
}
