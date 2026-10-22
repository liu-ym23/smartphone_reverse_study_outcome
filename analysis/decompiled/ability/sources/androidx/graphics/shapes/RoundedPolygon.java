package androidx.graphics.shapes;

import D7.v;
import H4.o;
import androidx.collection.FloatFloatPair;
import androidx.compose.foundation.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 !2\u00020\u0001:\u0001!B%\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u001c\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007J\u0010\u0010\u0016\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0012J\u0013\u0010\u0017\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0006\u0010\u001b\u001a\u00020\u0000J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\""}, d2 = {"Landroidx/graphics/shapes/RoundedPolygon;", "", "features", "", "Landroidx/graphics/shapes/Feature;", "centerX", "", "centerY", "(Ljava/util/List;FF)V", "getCenterX", "()F", "getCenterY", "cubics", "Landroidx/graphics/shapes/Cubic;", "getCubics", "()Ljava/util/List;", "getFeatures$graphics_shapes_release", "calculateBounds", "", "bounds", "approximate", "", "calculateMaxBounds", "equals", "other", "hashCode", "", "normalized", "toString", "", "transformed", "f", "Landroidx/graphics/shapes/PointTransformer;", "Companion", "graphics-shapes_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RoundedPolygon {
    private final float centerX;
    private final float centerY;
    private final List<Cubic> cubics;
    private final List<Feature> features;

    /* JADX WARN: Multi-variable type inference failed */
    public RoundedPolygon(List<? extends Feature> features, float f, float f7) {
        ArrayList arrayListQ;
        ArrayList arrayListQ2;
        Cubic cubic;
        List<Cubic> cubics;
        k.f(features, "features");
        this.features = features;
        this.centerX = f;
        this.centerY = f7;
        ListBuilder listBuilderY = o.y();
        int i = 0;
        Cubic cubic2 = null;
        if (features.size() <= 0 || ((Feature) features.get(0)).getCubics().size() != 3) {
            arrayListQ = null;
            arrayListQ2 = null;
        } else {
            Pair<Cubic, Cubic> pairSplit = ((Feature) features.get(0)).getCubics().get(1).split(0.5f);
            Cubic cubic3 = (Cubic) pairSplit.f4886a;
            Cubic cubic4 = (Cubic) pairSplit.b;
            arrayListQ2 = o.Q(((Feature) features.get(0)).getCubics().get(0), cubic3);
            arrayListQ = o.Q(cubic4, ((Feature) features.get(0)).getCubics().get(2));
        }
        int size = features.size();
        if (size >= 0) {
            int i6 = 0;
            Cubic cubic5 = null;
            while (true) {
                if (i6 == 0 && arrayListQ != null) {
                    cubics = arrayListQ;
                } else if (i6 != this.features.size()) {
                    cubics = this.features.get(i6).getCubics();
                } else if (arrayListQ2 == null) {
                    break;
                } else {
                    cubics = arrayListQ2;
                }
                int size2 = cubics.size();
                for (int i10 = 0; i10 < size2; i10++) {
                    Cubic cubic6 = cubics.get(i10);
                    if (!cubic6.zeroLength$graphics_shapes_release()) {
                        if (cubic5 != null) {
                            listBuilderY.add(cubic5);
                        }
                        if (cubic2 == null) {
                            cubic2 = cubic6;
                            cubic5 = cubic2;
                        } else {
                            cubic5 = cubic6;
                        }
                    } else if (cubic5 != null) {
                        cubic5.getPoints()[6] = cubic6.getAnchor1X();
                        cubic5.getPoints()[7] = cubic6.getAnchor1Y();
                    }
                }
                if (i6 == size) {
                    break;
                } else {
                    i6++;
                }
            }
            cubic = cubic2;
            cubic2 = cubic5;
        } else {
            cubic = null;
        }
        if (cubic2 != null && cubic != null) {
            listBuilderY.add(CubicKt.Cubic(cubic2.getAnchor0X(), cubic2.getAnchor0Y(), cubic2.getControl0X(), cubic2.getControl0Y(), cubic2.getControl1X(), cubic2.getControl1Y(), cubic.getAnchor0X(), cubic.getAnchor0Y()));
        }
        ListBuilder listBuilderQ = o.q(listBuilderY);
        this.cubics = listBuilderQ;
        Object obj = listBuilderQ.get(listBuilderQ.size() - 1);
        int size3 = listBuilderQ.size();
        while (i < size3) {
            Cubic cubic7 = this.cubics.get(i);
            Cubic cubic8 = (Cubic) obj;
            if (Math.abs(cubic7.getAnchor0X() - cubic8.getAnchor1X()) > 1.0E-4f || Math.abs(cubic7.getAnchor0Y() - cubic8.getAnchor1Y()) > 1.0E-4f) {
                throw new IllegalArgumentException("RoundedPolygon must be contiguous, with the anchor points of all curves matching the anchor points of the preceding and succeeding cubics");
            }
            i++;
            obj = cubic7;
        }
    }

    public static /* synthetic */ float[] calculateBounds$default(RoundedPolygon roundedPolygon, float[] fArr, boolean z10, int i, Object obj) {
        if ((i & 1) != 0) {
            fArr = new float[4];
        }
        if ((i & 2) != 0) {
            z10 = true;
        }
        return roundedPolygon.calculateBounds(fArr, z10);
    }

    public static /* synthetic */ float[] calculateMaxBounds$default(RoundedPolygon roundedPolygon, float[] fArr, int i, Object obj) {
        if ((i & 1) != 0) {
            fArr = new float[4];
        }
        return roundedPolygon.calculateMaxBounds(fArr);
    }

    public final float[] calculateBounds() {
        return calculateBounds$default(this, null, false, 3, null);
    }

    public final float[] calculateMaxBounds(float[] bounds) {
        k.f(bounds, "bounds");
        if (bounds.length < 4) {
            throw new IllegalArgumentException("Required bounds size of 4");
        }
        int size = this.cubics.size();
        float fMax = 0.0f;
        for (int i = 0; i < size; i++) {
            Cubic cubic = this.cubics.get(i);
            float fDistanceSquared = Utils.distanceSquared(cubic.getAnchor0X() - this.centerX, cubic.getAnchor0Y() - this.centerY);
            long jM7125pointOnCurveOOQOV4g$graphics_shapes_release = cubic.m7125pointOnCurveOOQOV4g$graphics_shapes_release(0.5f);
            fMax = Math.max(fMax, Math.max(fDistanceSquared, Utils.distanceSquared(PointKt.m7137getXDnnuFBc(jM7125pointOnCurveOOQOV4g$graphics_shapes_release) - this.centerX, PointKt.m7138getYDnnuFBc(jM7125pointOnCurveOOQOV4g$graphics_shapes_release) - this.centerY)));
        }
        float fSqrt = (float) Math.sqrt(fMax);
        float f = this.centerX;
        bounds[0] = f - fSqrt;
        float f7 = this.centerY;
        bounds[1] = f7 - fSqrt;
        bounds[2] = f + fSqrt;
        bounds[3] = f7 + fSqrt;
        return bounds;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof RoundedPolygon) {
            return k.b(this.features, ((RoundedPolygon) other).features);
        }
        return false;
    }

    public final float getCenterX() {
        return this.centerX;
    }

    public final float getCenterY() {
        return this.centerY;
    }

    public final List<Cubic> getCubics() {
        return this.cubics;
    }

    public final List<Feature> getFeatures$graphics_shapes_release() {
        return this.features;
    }

    public int hashCode() {
        return this.features.hashCode();
    }

    public final RoundedPolygon normalized() {
        float[] fArrCalculateBounds$default = calculateBounds$default(this, null, false, 3, null);
        float f = fArrCalculateBounds$default[2] - fArrCalculateBounds$default[0];
        float f7 = fArrCalculateBounds$default[3] - fArrCalculateBounds$default[1];
        final float fMax = Math.max(f, f7);
        float f9 = 2;
        final float f10 = ((fMax - f) / f9) - fArrCalculateBounds$default[0];
        final float f11 = ((fMax - f7) / f9) - fArrCalculateBounds$default[1];
        return transformed(new PointTransformer() { // from class: androidx.graphics.shapes.RoundedPolygon.normalized.1
            @Override // androidx.graphics.shapes.PointTransformer
            /* renamed from: transform-XgqJiTY */
            public final long mo7146transformXgqJiTY(float f12, float f13) {
                float f14 = f12 + f10;
                float f15 = fMax;
                return FloatFloatPair.m11constructorimpl(f14 / f15, (f13 + f11) / f15);
            }
        });
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[RoundedPolygon. Cubics = ");
        sb.append(v.I0(this.cubics, null, null, null, null, 63));
        sb.append(" || Features = ");
        sb.append(v.I0(this.features, null, null, null, null, 63));
        sb.append(" || Center = (");
        sb.append(this.centerX);
        sb.append(", ");
        return b.u(sb, ")]", this.centerY);
    }

    public final RoundedPolygon transformed(PointTransformer f) {
        k.f(f, "f");
        long jM7144transformedso9K2fw = PointKt.m7144transformedso9K2fw(FloatFloatPair.m11constructorimpl(this.centerX, this.centerY), f);
        ListBuilder listBuilderY = o.y();
        int size = this.features.size();
        for (int i = 0; i < size; i++) {
            listBuilderY.add(this.features.get(i).transformed$graphics_shapes_release(f));
        }
        return new RoundedPolygon(o.q(listBuilderY), PointKt.m7137getXDnnuFBc(jM7144transformedso9K2fw), PointKt.m7138getYDnnuFBc(jM7144transformedso9K2fw));
    }

    public final float[] calculateBounds(float[] bounds) {
        k.f(bounds, "bounds");
        return calculateBounds$default(this, bounds, false, 2, null);
    }

    public final float[] calculateBounds(float[] bounds, boolean approximate) {
        k.f(bounds, "bounds");
        if (bounds.length >= 4) {
            int size = this.cubics.size();
            float fMax = Float.MIN_VALUE;
            float fMin = Float.MAX_VALUE;
            float fMin2 = Float.MAX_VALUE;
            float fMax2 = Float.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                this.cubics.get(i).calculateBounds$graphics_shapes_release(bounds, approximate);
                fMin = Math.min(fMin, bounds[0]);
                fMin2 = Math.min(fMin2, bounds[1]);
                fMax = Math.max(fMax, bounds[2]);
                fMax2 = Math.max(fMax2, bounds[3]);
            }
            bounds[0] = fMin;
            bounds[1] = fMin2;
            bounds[2] = fMax;
            bounds[3] = fMax2;
            return bounds;
        }
        throw new IllegalArgumentException("Required bounds size of 4");
    }
}
