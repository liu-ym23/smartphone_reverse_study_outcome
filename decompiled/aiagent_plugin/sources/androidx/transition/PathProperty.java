package androidx.transition;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class PathProperty<T> extends Property<T, Float> {
    private float mCurrentFraction;
    private final float mPathLength;
    private final PathMeasure mPathMeasure;
    private final PointF mPointF;
    private final float[] mPosition;
    private final Property<T, PointF> mProperty;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.util.Property
    public /* bridge */ /* synthetic */ Float get(Object r1) {
        return get(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.util.Property
    public /* synthetic */ void set(Object r3, Float r4) {
        set2(r3, (Float) ZeusTransformUtils.preCheckCast(r4, Float.class, "com.obric.aiagent.plugin"));
    }

    PathProperty(Property<T, PointF> r3, Path r4) {
        super(Float.class, r3.getName());
        this.mPosition = new float[2];
        this.mPointF = new PointF();
        this.mProperty = r3;
        PathMeasure r5 = new PathMeasure(r4, false);
        this.mPathMeasure = r5;
        this.mPathLength = r5.getLength();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.util.Property
    public Float get(T r1) {
        return Float.valueOf(this.mCurrentFraction);
    }

    /* JADX INFO: renamed from: set, reason: avoid collision after fix types in other method */
    public void set2(T r4, Float r5) {
        this.mCurrentFraction = r5.floatValue();
        this.mPathMeasure.getPosTan(this.mPathLength * r5.floatValue(), this.mPosition, null);
        PointF r6 = this.mPointF;
        r6.x = this.mPosition[0];
        PointF r7 = this.mPointF;
        r7.y = this.mPosition[1];
        this.mProperty.set(r4, this.mPointF);
    }
}
