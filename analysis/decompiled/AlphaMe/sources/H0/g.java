package H0;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;

/* loaded from: classes.dex */
public final class g extends e {

    /* renamed from: g, reason: collision with root package name */
    public final PointF f697g;

    /* renamed from: h, reason: collision with root package name */
    public final float[] f698h;

    /* renamed from: i, reason: collision with root package name */
    public f f699i;

    /* renamed from: j, reason: collision with root package name */
    public PathMeasure f700j;

    public g(List list) {
        super(list);
        this.f697g = new PointF();
        this.f698h = new float[2];
    }

    @Override // H0.b
    public final Object f(Q0.a aVar, float f4) {
        f fVar = (f) aVar;
        Path path = fVar.f696k;
        if (path == null) {
            return (PointF) aVar.f1627b;
        }
        Q0.b bVar = this.f691e;
        if (bVar != null) {
            fVar.f1631f.getClass();
            d();
            PointF pointF = (PointF) bVar.b(fVar.f1627b, fVar.f1628c);
            if (pointF != null) {
                return pointF;
            }
        }
        if (this.f699i != fVar) {
            this.f700j = new PathMeasure(path, false);
            this.f699i = fVar;
        }
        PathMeasure pathMeasure = this.f700j;
        float length = pathMeasure.getLength() * f4;
        float[] fArr = this.f698h;
        pathMeasure.getPosTan(length, fArr, null);
        PointF pointF2 = this.f697g;
        pointF2.set(fArr[0], fArr[1]);
        return pointF2;
    }
}
