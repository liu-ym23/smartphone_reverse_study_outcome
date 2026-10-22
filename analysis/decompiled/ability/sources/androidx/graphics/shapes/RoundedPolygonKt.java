package androidx.graphics.shapes;

import D7.F;
import D7.v;
import D7.w;
import H4.o;
import Y7.f;
import androidx.annotation.IntRange;
import androidx.collection.FloatFloatPair;
import androidx.collection.MutableFloatList;
import androidx.graphics.shapes.Feature;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import g1.AbstractC1451a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u001a@\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0007\u001aL\u0010\u0000\u001a\u00020\u00012\b\b\u0001\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bH\u0007\u001a\u0019\u0010\u000f\u001a\u00060\u0010j\u0002`\u00112\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\u0012\u001a(\u0010\u0013\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002¨\u0006\u0014"}, d2 = {"RoundedPolygon", "Landroidx/graphics/shapes/RoundedPolygon;", AgentBusWakeContract.EXTRA_SOURCE, "vertices", "", "rounding", "Landroidx/graphics/shapes/CornerRounding;", "perVertexRounding", "", "centerX", "", "centerY", "numVertices", "", "radius", "calculateCenter", "Landroidx/collection/FloatFloatPair;", "Landroidx/graphics/shapes/Point;", "([F)J", "verticesFromNumVerts", "graphics-shapes_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RoundedPolygonKt {
    public static final RoundedPolygon RoundedPolygon(@IntRange(from = 3) int i) {
        return RoundedPolygon$default(i, 0.0f, 0.0f, 0.0f, null, null, 62, null);
    }

    public static /* synthetic */ RoundedPolygon RoundedPolygon$default(int i, float f, float f7, float f9, CornerRounding cornerRounding, List list, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            f = 1.0f;
        }
        if ((i6 & 4) != 0) {
            f7 = 0.0f;
        }
        if ((i6 & 8) != 0) {
            f9 = 0.0f;
        }
        if ((i6 & 16) != 0) {
            cornerRounding = CornerRounding.Unrounded;
        }
        if ((i6 & 32) != 0) {
            list = null;
        }
        List list2 = list;
        return RoundedPolygon(i, f, f7, f9, cornerRounding, list2);
    }

    private static final long calculateCenter(float[] fArr) {
        float f = 0.0f;
        int i = 0;
        float f7 = 0.0f;
        while (i < fArr.length) {
            int i6 = i + 1;
            f += fArr[i];
            i += 2;
            f7 += fArr[i6];
        }
        float f9 = 2;
        return FloatFloatPair.m11constructorimpl((f / fArr.length) / f9, (f7 / fArr.length) / f9);
    }

    private static final float[] verticesFromNumVerts(int i, float f, float f7, float f9) {
        float[] fArr = new float[i * 2];
        int i6 = 0;
        int i10 = 0;
        while (i6 < i) {
            float f10 = f;
            long jM7141plusybeJwSQ = PointKt.m7141plusybeJwSQ(Utils.m7157radialToCartesianL6JJ3z0$default(f10, (Utils.getFloatPi() / i) * 2 * i6, 0L, 4, null), FloatFloatPair.m11constructorimpl(f7, f9));
            int i11 = i10 + 1;
            fArr[i10] = PointKt.m7137getXDnnuFBc(jM7141plusybeJwSQ);
            i10 += 2;
            fArr[i11] = PointKt.m7138getYDnnuFBc(jM7141plusybeJwSQ);
            i6++;
            f = f10;
        }
        return fArr;
    }

    public static final RoundedPolygon RoundedPolygon(@IntRange(from = 3) int i, float f) {
        return RoundedPolygon$default(i, f, 0.0f, 0.0f, null, null, 60, null);
    }

    public static final RoundedPolygon RoundedPolygon(@IntRange(from = 3) int i, float f, float f7) {
        return RoundedPolygon$default(i, f, f7, 0.0f, null, null, 56, null);
    }

    public static /* synthetic */ RoundedPolygon RoundedPolygon$default(float[] fArr, CornerRounding cornerRounding, List list, float f, float f7, int i, Object obj) {
        if ((i & 2) != 0) {
            cornerRounding = CornerRounding.Unrounded;
        }
        if ((i & 4) != 0) {
            list = null;
        }
        if ((i & 8) != 0) {
            f = Float.MIN_VALUE;
        }
        if ((i & 16) != 0) {
            f7 = Float.MIN_VALUE;
        }
        return RoundedPolygon(fArr, cornerRounding, (List<CornerRounding>) list, f, f7);
    }

    public static final RoundedPolygon RoundedPolygon(@IntRange(from = 3) int i, float f, float f7, float f9) {
        return RoundedPolygon$default(i, f, f7, f9, null, null, 48, null);
    }

    public static final RoundedPolygon RoundedPolygon(@IntRange(from = 3) int i, float f, float f7, float f9, CornerRounding rounding) {
        k.f(rounding, "rounding");
        return RoundedPolygon$default(i, f, f7, f9, rounding, null, 32, null);
    }

    public static final RoundedPolygon RoundedPolygon(float[] vertices) {
        k.f(vertices, "vertices");
        return RoundedPolygon$default(vertices, null, null, 0.0f, 0.0f, 30, null);
    }

    public static final RoundedPolygon RoundedPolygon(float[] vertices, CornerRounding rounding) {
        k.f(vertices, "vertices");
        k.f(rounding, "rounding");
        return RoundedPolygon$default(vertices, rounding, null, 0.0f, 0.0f, 28, null);
    }

    public static final RoundedPolygon RoundedPolygon(float[] vertices, CornerRounding rounding, List<CornerRounding> list) {
        k.f(vertices, "vertices");
        k.f(rounding, "rounding");
        return RoundedPolygon$default(vertices, rounding, list, 0.0f, 0.0f, 24, null);
    }

    public static final RoundedPolygon RoundedPolygon(float[] vertices, CornerRounding rounding, List<CornerRounding> list, float f) {
        k.f(vertices, "vertices");
        k.f(rounding, "rounding");
        return RoundedPolygon$default(vertices, rounding, list, f, 0.0f, 16, null);
    }

    public static final RoundedPolygon RoundedPolygon(@IntRange(from = 3) int i, float f, float f7, float f9, CornerRounding rounding, List<CornerRounding> list) {
        k.f(rounding, "rounding");
        return RoundedPolygon(verticesFromNumVerts(i, f, f7, f9), rounding, list, f7, f9);
    }

    public static final RoundedPolygon RoundedPolygon(RoundedPolygon source) {
        k.f(source, "source");
        return new RoundedPolygon(source.getFeatures$graphics_shapes_release(), source.getCenterX(), source.getCenterY());
    }

    public static final RoundedPolygon RoundedPolygon(float[] vertices, CornerRounding rounding, List<CornerRounding> list, float f, float f7) {
        long jCalculateCenter;
        Pair pair;
        CornerRounding cornerRounding;
        Float fValueOf = Float.valueOf(1.0f);
        k.f(vertices, "vertices");
        k.f(rounding, "rounding");
        if (vertices.length >= 6) {
            int i = 2;
            int i6 = 1;
            if (vertices.length % 2 != 1) {
                if (list != null && list.size() * 2 != vertices.length) {
                    throw new IllegalArgumentException("perVertexRounding list should be either null or the same size as the number of vertices (vertices.size / 2)");
                }
                ArrayList arrayList = new ArrayList();
                int length = vertices.length / 2;
                ArrayList arrayList2 = new ArrayList();
                int i10 = 0;
                int i11 = 0;
                while (i11 < length) {
                    CornerRounding cornerRounding2 = (list == null || (cornerRounding = list.get(i11)) == null) ? rounding : cornerRounding;
                    int i12 = (((i11 + length) - i6) % length) * 2;
                    int i13 = i11 + 1;
                    int i14 = (i13 % length) * 2;
                    int i15 = i11 * 2;
                    arrayList2.add(new RoundedCorner(FloatFloatPair.m11constructorimpl(vertices[i12], vertices[i12 + i6]), FloatFloatPair.m11constructorimpl(vertices[i15], vertices[i15 + i6]), FloatFloatPair.m11constructorimpl(vertices[i14], vertices[i14 + 1]), cornerRounding2, null));
                    i11 = i13;
                    i6 = i6;
                }
                int i16 = i6;
                f fVarX = AbstractC1451a.X(0, length);
                ArrayList arrayList3 = new ArrayList(w.c0(fVarX, 10));
                Iterator it = fVarX.iterator();
                while (it.hasNext()) {
                    int iNextInt = ((F) it).nextInt();
                    int i17 = (iNextInt + 1) % length;
                    float expectedRoundCut = ((RoundedCorner) arrayList2.get(iNextInt)).getExpectedRoundCut() + ((RoundedCorner) arrayList2.get(i17)).getExpectedRoundCut();
                    float expectedCut = ((RoundedCorner) arrayList2.get(iNextInt)).getExpectedCut() + ((RoundedCorner) arrayList2.get(i17)).getExpectedCut();
                    int i18 = iNextInt * 2;
                    int i19 = i17 * 2;
                    float fDistance = Utils.distance(vertices[i18] - vertices[i19], vertices[i18 + 1] - vertices[i19 + 1]);
                    if (expectedRoundCut > fDistance) {
                        pair = new Pair(Float.valueOf(fDistance / expectedRoundCut), Float.valueOf(0.0f));
                    } else if (expectedCut > fDistance) {
                        pair = new Pair(fValueOf, Float.valueOf((fDistance - expectedRoundCut) / (expectedCut - expectedRoundCut)));
                    } else {
                        pair = new Pair(fValueOf, fValueOf);
                    }
                    arrayList3.add(pair);
                }
                for (int i20 = 0; i20 < length; i20++) {
                    MutableFloatList mutableFloatList = new MutableFloatList(2);
                    for (int i21 = 0; i21 < 2; i21++) {
                        Pair pair2 = (Pair) arrayList3.get((((i20 + length) - 1) + i21) % length);
                        mutableFloatList.add(((((RoundedCorner) arrayList2.get(i20)).getExpectedCut() - ((RoundedCorner) arrayList2.get(i20)).getExpectedRoundCut()) * ((Number) pair2.b).floatValue()) + (((RoundedCorner) arrayList2.get(i20)).getExpectedRoundCut() * ((Number) pair2.f4886a).floatValue()));
                    }
                    arrayList.add(((RoundedCorner) arrayList2.get(i20)).getCubics(mutableFloatList.get(0), mutableFloatList.get(i16)));
                }
                ArrayList arrayList4 = new ArrayList();
                while (i10 < length) {
                    int i22 = i10 + 1;
                    int i23 = i22 % length;
                    int i24 = i10 * 2;
                    long jM11constructorimpl = FloatFloatPair.m11constructorimpl(vertices[i24], vertices[i24 + i16]);
                    int i25 = (((i10 + length) - i16) % length) * i;
                    long jM11constructorimpl2 = FloatFloatPair.m11constructorimpl(vertices[i25], vertices[i25 + i16]);
                    int i26 = i23 * 2;
                    arrayList4.add(new Feature.Corner((List) arrayList.get(i10), jM11constructorimpl, ((RoundedCorner) arrayList2.get(i10)).getCenter(), PointKt.m7128clockwiseybeJwSQ(PointKt.m7140minusybeJwSQ(jM11constructorimpl, jM11constructorimpl2), PointKt.m7140minusybeJwSQ(FloatFloatPair.m11constructorimpl(vertices[i26], vertices[i26 + i16]), jM11constructorimpl)), null));
                    arrayList4.add(new Feature.Edge(o.M(Cubic.INSTANCE.straightLine(((Cubic) v.K0((List) arrayList.get(i10))).getAnchor1X(), ((Cubic) v.K0((List) arrayList.get(i10))).getAnchor1Y(), ((Cubic) v.A0((List) arrayList.get(i23))).getAnchor0X(), ((Cubic) v.A0((List) arrayList.get(i23))).getAnchor0Y()))));
                    i10 = i22;
                    i = 2;
                }
                if (f == Float.MIN_VALUE || f7 == Float.MIN_VALUE) {
                    jCalculateCenter = calculateCenter(vertices);
                } else {
                    jCalculateCenter = FloatFloatPair.m11constructorimpl(f, f7);
                }
                return new RoundedPolygon(arrayList4, Float.intBitsToFloat((int) (jCalculateCenter >> 32)), Float.intBitsToFloat((int) (jCalculateCenter & 4294967295L)));
            }
            throw new IllegalArgumentException("The vertices array should have even size");
        }
        throw new IllegalArgumentException("Polygons must have at least 3 vertices");
    }
}
