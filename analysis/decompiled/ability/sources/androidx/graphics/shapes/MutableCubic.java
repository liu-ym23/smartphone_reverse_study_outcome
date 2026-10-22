package androidx.graphics.shapes;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u0011\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Landroidx/graphics/shapes/MutableCubic;", "Landroidx/graphics/shapes/Cubic;", AppAgent.CONSTRUCT, "()V", "Landroidx/graphics/shapes/PointTransformer;", "f", "", "ix", "LC7/r;", "transformOnePoint", "(Landroidx/graphics/shapes/PointTransformer;I)V", "transform", "(Landroidx/graphics/shapes/PointTransformer;)V", "c1", "c2", "", "progress", "interpolate", "(Landroidx/graphics/shapes/Cubic;Landroidx/graphics/shapes/Cubic;F)V", "graphics-shapes_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MutableCubic extends Cubic {
    public MutableCubic() {
        super(null, 1, null);
    }

    private final void transformOnePoint(PointTransformer f, int ix) {
        int i = ix + 1;
        long jMo7146transformXgqJiTY = f.mo7146transformXgqJiTY(getPoints()[ix], getPoints()[i]);
        getPoints()[ix] = Float.intBitsToFloat((int) (jMo7146transformXgqJiTY >> 32));
        getPoints()[i] = Float.intBitsToFloat((int) (4294967295L & jMo7146transformXgqJiTY));
    }

    public final void interpolate(Cubic c12, Cubic c2, float progress) {
        k.f(c12, "c1");
        k.f(c2, "c2");
        for (int i = 0; i < 8; i++) {
            getPoints()[i] = Utils.interpolate(c12.getPoints()[i], c2.getPoints()[i], progress);
        }
    }

    public final void transform(PointTransformer f) {
        k.f(f, "f");
        transformOnePoint(f, 0);
        transformOnePoint(f, 2);
        transformOnePoint(f, 4);
        transformOnePoint(f, 6);
    }
}
