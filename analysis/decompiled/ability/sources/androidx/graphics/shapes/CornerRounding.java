package androidx.graphics.shapes;

import androidx.annotation.FloatRange;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0019\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\n"}, d2 = {"Landroidx/graphics/shapes/CornerRounding;", "", "radius", "", "smoothing", "(FF)V", "getRadius", "()F", "getSmoothing", "Companion", "graphics-shapes_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CornerRounding {
    public static final CornerRounding Unrounded;
    private final float radius;
    private final float smoothing;

    static {
        e eVar = null;
        INSTANCE = new Companion(eVar);
        float f = 0.0f;
        Unrounded = new CornerRounding(f, f, 3, eVar);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public CornerRounding() {
        float f = 0.0f;
        this(f, f, 3, null);
    }

    public final float getRadius() {
        return this.radius;
    }

    public final float getSmoothing() {
        return this.smoothing;
    }

    public CornerRounding(@FloatRange(from = 0.0d) float f, @FloatRange(from = 0.0d, to = 1.0d) float f7) {
        this.radius = f;
        this.smoothing = f7;
    }

    public /* synthetic */ CornerRounding(float f, float f7, int i, e eVar) {
        this((i & 1) != 0 ? 0.0f : f, (i & 2) != 0 ? 0.0f : f7);
    }
}
