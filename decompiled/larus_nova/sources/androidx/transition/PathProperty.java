package androidx.transition;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

/* JADX INFO: loaded from: classes17.dex */
class PathProperty<T> extends Property<T, Float> {
    private float mCurrentFraction;
    private final float mPathLength;
    private final PathMeasure mPathMeasure;
    private final PointF mPointF;
    private final float[] mPosition;
    private final Property<T, PointF> mProperty;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.util.Property
    public Float get(T r100) {
        return Float.valueOf(this.mCurrentFraction);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.util.Property
    public /* bridge */ /* synthetic */ Float get(Object r100) {
        return get(r100);
    }

    public PathProperty(Property<T, PointF> r100, Path r101) {
        super(Float.class, r100.getName());
        this.mPosition = new float[2];
        this.mPointF = new PointF();
        this.mProperty = r100;
        PathMeasure r102 = new PathMeasure(r101, false);
        this.mPathMeasure = r102;
        this.mPathLength = r102.getLength();
    }

    /* JADX INFO: renamed from: set, reason: avoid collision after fix types in other method */
    public void set2(T r100, Float r101) {
        this.mCurrentFraction = r101.floatValue();
        this.mPathMeasure.getPosTan(this.mPathLength * r101.floatValue(), this.mPosition, null);
        PointF r102 = this.mPointF;
        float[] r103 = this.mPosition;
        r102.x = r103[0];
        r102.y = r103[1];
        this.mProperty.set(r100, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.util.Property
    public /* bridge */ /* synthetic */ void set(Object r100, Float r101) {
        set2(r100, r101);
    }
}
