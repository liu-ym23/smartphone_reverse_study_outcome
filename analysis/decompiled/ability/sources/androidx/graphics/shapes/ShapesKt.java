package androidx.graphics.shapes;

import D7.A;
import H4.o;
import Y7.e;
import Y7.f;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.collection.FloatFloatPair;
import androidx.graphics.shapes.RoundedPolygon;
import com.mdisdk.capability.model.WindowType;
import g1.AbstractC1451a;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\u001aH\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0002\u001a0\u0010\f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0002\u001a4\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\b\b\u0003\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005H\u0007\u001a>\u0010\u0012\u001a\u00020\u000f*\u00020\u00102\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005H\u0007\u001a\u0084\u0001\u0010\u0014\u001a\u00020\u000f*\u00020\u00102\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001a2\b\b\u0003\u0010\b\u001a\u00020\u00052\b\b\u0003\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005H\u0007\u001aN\u0010\u001b\u001a\u00020\u000f*\u00020\u00102\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001a2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u001ad\u0010\u001c\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001a2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005H\u0007¨\u0006\u001d"}, d2 = {"pillStarVerticesFromNumVerts", "", "numVerticesPerRadius", "", "width", "", "height", "innerRadius", "vertexSpacing", "startLocation", "centerX", "centerY", "starVerticesFromNumVerts", "radius", "circle", "Landroidx/graphics/shapes/RoundedPolygon;", "Landroidx/graphics/shapes/RoundedPolygon$Companion;", "numVertices", "pill", "smoothing", "pillStar", "innerRadiusRatio", "rounding", "Landroidx/graphics/shapes/CornerRounding;", "innerRounding", "perVertexRounding", "", "rectangle", "star", "graphics-shapes_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ShapesKt {
    public static final RoundedPolygon circle(RoundedPolygon.Companion companion) {
        k.f(companion, "<this>");
        return circle$default(companion, 0, 0.0f, 0.0f, 0.0f, 15, null);
    }

    public static /* synthetic */ RoundedPolygon circle$default(RoundedPolygon.Companion companion, int i, float f, float f7, float f9, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = 8;
        }
        if ((i6 & 2) != 0) {
            f = 1.0f;
        }
        if ((i6 & 4) != 0) {
            f7 = 0.0f;
        }
        if ((i6 & 8) != 0) {
            f9 = 0.0f;
        }
        return circle(companion, i, f, f7, f9);
    }

    public static final RoundedPolygon pill(RoundedPolygon.Companion companion) {
        k.f(companion, "<this>");
        return pill$default(companion, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 31, null);
    }

    public static /* synthetic */ RoundedPolygon pill$default(RoundedPolygon.Companion companion, float f, float f7, float f9, float f10, float f11, int i, Object obj) {
        float f12;
        float f13;
        float f14;
        float f15;
        RoundedPolygon.Companion companion2;
        float f16;
        if ((i & 1) != 0) {
            f = 2.0f;
        }
        if ((i & 2) != 0) {
            f7 = 1.0f;
        }
        if ((i & 4) != 0) {
            f9 = 0.0f;
        }
        if ((i & 8) != 0) {
            f10 = 0.0f;
        }
        if ((i & 16) != 0) {
            f12 = 0.0f;
            f15 = f9;
            f13 = f10;
            f16 = f;
            f14 = f7;
            companion2 = companion;
        } else {
            f12 = f11;
            f13 = f10;
            f14 = f7;
            f15 = f9;
            companion2 = companion;
            f16 = f;
        }
        return pill(companion2, f16, f14, f15, f13, f12);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion) {
        k.f(companion, "<this>");
        return pillStar$default(companion, 0.0f, 0.0f, 0, 0.0f, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 2047, null);
    }

    public static /* synthetic */ RoundedPolygon pillStar$default(RoundedPolygon.Companion companion, float f, float f7, int i, float f9, CornerRounding cornerRounding, CornerRounding cornerRounding2, List list, float f10, float f11, float f12, float f13, int i6, Object obj) {
        float f14;
        float f15;
        float f16;
        float f17;
        CornerRounding cornerRounding3;
        List list2;
        float f18;
        CornerRounding cornerRounding4;
        float f19;
        int i10;
        RoundedPolygon.Companion companion2;
        float f20;
        if ((i6 & 1) != 0) {
            f = 2.0f;
        }
        if ((i6 & 2) != 0) {
            f7 = 1.0f;
        }
        if ((i6 & 4) != 0) {
            i = 8;
        }
        if ((i6 & 8) != 0) {
            f9 = 0.5f;
        }
        if ((i6 & 16) != 0) {
            cornerRounding = CornerRounding.Unrounded;
        }
        if ((i6 & 32) != 0) {
            cornerRounding2 = null;
        }
        if ((i6 & 64) != 0) {
            list = null;
        }
        if ((i6 & 128) != 0) {
            f10 = 0.5f;
        }
        if ((i6 & 256) != 0) {
            f11 = 0.0f;
        }
        if ((i6 & 512) != 0) {
            f12 = 0.0f;
        }
        if ((i6 & 1024) != 0) {
            f14 = 0.0f;
            f17 = f11;
            f15 = f12;
            list2 = list;
            f16 = f10;
            cornerRounding4 = cornerRounding;
            cornerRounding3 = cornerRounding2;
            i10 = i;
            f18 = f9;
            f20 = f;
            f19 = f7;
            companion2 = companion;
        } else {
            f14 = f13;
            f15 = f12;
            f16 = f10;
            f17 = f11;
            cornerRounding3 = cornerRounding2;
            list2 = list;
            f18 = f9;
            cornerRounding4 = cornerRounding;
            f19 = f7;
            i10 = i;
            companion2 = companion;
            f20 = f;
        }
        return pillStar(companion2, f20, f19, i10, f18, cornerRounding4, cornerRounding3, list2, f16, f17, f15, f14);
    }

    private static final float[] pillStarVerticesFromNumVerts(int i, float f, float f7, float f9, float f10, float f11, float f12, float f13) {
        int i6;
        float f14;
        float f15;
        float f16;
        long jM11constructorimpl;
        float fMin = Math.min(f, f7);
        float f17 = f7 - f;
        if (f17 < 0.0f) {
            f17 = 0.0f;
        }
        float f18 = f - f7;
        if (f18 < 0.0f) {
            f18 = 0.0f;
        }
        float f19 = 2;
        float f20 = f17 / f19;
        float f21 = f18 / f19;
        float fInterpolate = Utils.interpolate(f9, 1.0f, f10) * Utils.getTwoPi() * fMin;
        float f22 = (f19 * f17) + (f19 * f18) + fInterpolate;
        float f23 = fInterpolate / 4;
        float f24 = f20 + f23;
        float f25 = f24 + f18;
        float f26 = f25 + f23;
        float f27 = f26 + f17;
        float f28 = f27 + f23;
        float f29 = f28 + f18;
        float f30 = f29 + f23;
        float[] fArr = {0.0f, f20, f24, f25, f26, f27, f28, f29, f30, f30 + f20, f22};
        int i10 = i * 2;
        float f31 = f22 / i10;
        float f32 = f11 * f22;
        float[] fArr2 = new float[i * 4];
        float f33 = f18;
        long jM11constructorimpl2 = FloatFloatPair.m11constructorimpl(f21, f20);
        float f34 = -f21;
        long jM11constructorimpl3 = FloatFloatPair.m11constructorimpl(f34, f20);
        float f35 = -f20;
        long jM11constructorimpl4 = FloatFloatPair.m11constructorimpl(f34, f35);
        long jM11constructorimpl5 = FloatFloatPair.m11constructorimpl(f21, f35);
        float f36 = f17;
        float f37 = f20;
        int i11 = 0;
        float f38 = 0.0f;
        boolean z10 = false;
        int i12 = 0;
        int i13 = 0;
        while (i11 < i10) {
            float f39 = f32 % f22;
            if (f39 < f38) {
                i12 = 0;
            }
            while (true) {
                int i14 = (i12 + 1) % 11;
                float f40 = fArr[i14];
                if (f39 >= f40) {
                    f37 = fArr[(i14 + 1) % 11];
                    i12 = i14;
                    f38 = f40;
                } else {
                    float f41 = (f39 - f38) / (f37 - f38);
                    if (z10) {
                        i6 = i11;
                        f14 = fMin * f9;
                    } else {
                        i6 = i11;
                        f14 = fMin;
                    }
                    switch (i12) {
                        case 0:
                            f15 = f20;
                            float f42 = f14;
                            f16 = f21;
                            jM11constructorimpl = FloatFloatPair.m11constructorimpl(f42, f41 * f15);
                            break;
                        case 1:
                            f15 = f20;
                            float f43 = f14;
                            f16 = f21;
                            jM11constructorimpl = PointKt.m7141plusybeJwSQ(Utils.m7157radialToCartesianL6JJ3z0$default(f43, (Utils.getFloatPi() * f41) / f19, 0L, 4, null), jM11constructorimpl2);
                            break;
                        case 2:
                            f15 = f20;
                            float f44 = f14;
                            f16 = f21;
                            jM11constructorimpl = FloatFloatPair.m11constructorimpl(f16 - (f41 * f33), f44);
                            break;
                        case 3:
                            f15 = f20;
                            float f45 = f14;
                            f16 = f21;
                            jM11constructorimpl = PointKt.m7141plusybeJwSQ(Utils.m7157radialToCartesianL6JJ3z0$default(f45, ((Utils.getFloatPi() * f41) / f19) + (Utils.getFloatPi() / f19), 0L, 4, null), jM11constructorimpl3);
                            break;
                        case 4:
                            f15 = f20;
                            float f46 = f14;
                            f16 = f21;
                            jM11constructorimpl = FloatFloatPair.m11constructorimpl(-f46, f15 - (f41 * f36));
                            break;
                        case 5:
                            f15 = f20;
                            float f47 = f14;
                            f16 = f21;
                            jM11constructorimpl = PointKt.m7141plusybeJwSQ(Utils.m7157radialToCartesianL6JJ3z0$default(f47, ((Utils.getFloatPi() * f41) / f19) + Utils.getFloatPi(), 0L, 4, null), jM11constructorimpl4);
                            break;
                        case 6:
                            f15 = f20;
                            float f48 = f14;
                            f16 = f21;
                            jM11constructorimpl = FloatFloatPair.m11constructorimpl((f41 * f33) + f34, -f48);
                            break;
                        case 7:
                            f15 = f20;
                            float f49 = f14;
                            f16 = f21;
                            jM11constructorimpl = PointKt.m7141plusybeJwSQ(Utils.m7157radialToCartesianL6JJ3z0$default(f49, ((Utils.getFloatPi() * f41) / f19) + (Utils.getFloatPi() * 1.5f), 0L, 4, null), jM11constructorimpl5);
                            break;
                        default:
                            f15 = f20;
                            jM11constructorimpl = FloatFloatPair.m11constructorimpl(f14, (f41 * f20) + f35);
                            f16 = f21;
                            break;
                    }
                    int i15 = i13 + 1;
                    fArr2[i13] = PointKt.m7137getXDnnuFBc(jM11constructorimpl) + f12;
                    i13 += 2;
                    fArr2[i15] = PointKt.m7138getYDnnuFBc(jM11constructorimpl) + f13;
                    f32 += f31;
                    z10 = !z10;
                    f21 = f16;
                    i11 = i6 + 1;
                    f20 = f15;
                }
            }
        }
        return fArr2;
    }

    public static final RoundedPolygon rectangle(RoundedPolygon.Companion companion, float f, float f7, CornerRounding rounding, List<CornerRounding> list, float f9, float f10) {
        k.f(companion, "<this>");
        k.f(rounding, "rounding");
        float f11 = 2;
        float f12 = f / f11;
        float f13 = f9 - f12;
        float f14 = f7 / f11;
        float f15 = f10 - f14;
        float f16 = f12 + f9;
        float f17 = f14 + f10;
        return RoundedPolygonKt.RoundedPolygon(new float[]{f16, f17, f13, f17, f13, f15, f16, f15}, rounding, list, f9, f10);
    }

    public static /* synthetic */ RoundedPolygon rectangle$default(RoundedPolygon.Companion companion, float f, float f7, CornerRounding cornerRounding, List list, float f9, float f10, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 2.0f;
        }
        if ((i & 2) != 0) {
            f7 = 2.0f;
        }
        if ((i & 4) != 0) {
            cornerRounding = CornerRounding.Unrounded;
        }
        if ((i & 8) != 0) {
            list = null;
        }
        if ((i & 16) != 0) {
            f9 = 0.0f;
        }
        if ((i & 32) != 0) {
            f10 = 0.0f;
        }
        return rectangle(companion, f, f7, cornerRounding, list, f9, f10);
    }

    public static final RoundedPolygon star(RoundedPolygon.Companion companion, int i) {
        k.f(companion, "<this>");
        return star$default(companion, i, 0.0f, 0.0f, null, null, null, 0.0f, 0.0f, 254, null);
    }

    public static /* synthetic */ RoundedPolygon star$default(RoundedPolygon.Companion companion, int i, float f, float f7, CornerRounding cornerRounding, CornerRounding cornerRounding2, List list, float f9, float f10, int i6, Object obj) {
        return star(companion, i, (i6 & 2) != 0 ? 1.0f : f, (i6 & 4) != 0 ? 0.5f : f7, (i6 & 8) != 0 ? CornerRounding.Unrounded : cornerRounding, (i6 & 16) != 0 ? null : cornerRounding2, (i6 & 32) == 0 ? list : null, (i6 & 64) != 0 ? 0.0f : f9, (i6 & 128) != 0 ? 0.0f : f10);
    }

    private static final float[] starVerticesFromNumVerts(int i, float f, float f7, float f9, float f10) {
        float[] fArr = new float[i * 4];
        int i6 = 0;
        for (int i10 = 0; i10 < i; i10++) {
            float f11 = i;
            long jM7157radialToCartesianL6JJ3z0$default = Utils.m7157radialToCartesianL6JJ3z0$default(f, (Utils.getFloatPi() / f11) * 2 * i10, 0L, 4, null);
            fArr[i6] = PointKt.m7137getXDnnuFBc(jM7157radialToCartesianL6JJ3z0$default) + f9;
            fArr[i6 + 1] = PointKt.m7138getYDnnuFBc(jM7157radialToCartesianL6JJ3z0$default) + f10;
            long jM7157radialToCartesianL6JJ3z0$default2 = Utils.m7157radialToCartesianL6JJ3z0$default(f7, (Utils.getFloatPi() / f11) * ((i10 * 2) + 1), 0L, 4, null);
            int i11 = i6 + 3;
            fArr[i6 + 2] = PointKt.m7137getXDnnuFBc(jM7157radialToCartesianL6JJ3z0$default2) + f9;
            i6 += 4;
            fArr[i11] = PointKt.m7138getYDnnuFBc(jM7157radialToCartesianL6JJ3z0$default2) + f10;
        }
        return fArr;
    }

    public static final RoundedPolygon circle(RoundedPolygon.Companion companion, @IntRange(from = 3) int i) {
        k.f(companion, "<this>");
        return circle$default(companion, i, 0.0f, 0.0f, 0.0f, 14, null);
    }

    public static final RoundedPolygon pill(RoundedPolygon.Companion companion, float f) {
        k.f(companion, "<this>");
        return pill$default(companion, f, 0.0f, 0.0f, 0.0f, 0.0f, 30, null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f) {
        k.f(companion, "<this>");
        return pillStar$default(companion, f, 0.0f, 0, 0.0f, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 2046, null);
    }

    public static final RoundedPolygon star(RoundedPolygon.Companion companion, int i, float f) {
        k.f(companion, "<this>");
        return star$default(companion, i, f, 0.0f, null, null, null, 0.0f, 0.0f, 252, null);
    }

    public static final RoundedPolygon circle(RoundedPolygon.Companion companion, @IntRange(from = 3) int i, float f) {
        k.f(companion, "<this>");
        return circle$default(companion, i, f, 0.0f, 0.0f, 12, null);
    }

    public static final RoundedPolygon pill(RoundedPolygon.Companion companion, float f, float f7) {
        k.f(companion, "<this>");
        return pill$default(companion, f, f7, 0.0f, 0.0f, 0.0f, 28, null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f, float f7) {
        k.f(companion, "<this>");
        return pillStar$default(companion, f, f7, 0, 0.0f, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 2044, null);
    }

    public static final RoundedPolygon star(RoundedPolygon.Companion companion, int i, float f, float f7) {
        k.f(companion, "<this>");
        return star$default(companion, i, f, f7, null, null, null, 0.0f, 0.0f, 248, null);
    }

    public static final RoundedPolygon circle(RoundedPolygon.Companion companion, @IntRange(from = 3) int i, float f, float f7) {
        k.f(companion, "<this>");
        return circle$default(companion, i, f, f7, 0.0f, 8, null);
    }

    public static final RoundedPolygon pill(RoundedPolygon.Companion companion, float f, float f7, float f9) {
        k.f(companion, "<this>");
        return pill$default(companion, f, f7, f9, 0.0f, 0.0f, 24, null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f, float f7, int i) {
        k.f(companion, "<this>");
        return pillStar$default(companion, f, f7, i, 0.0f, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, WindowType.NOTIFICATION_SHADE, null);
    }

    public static final RoundedPolygon star(RoundedPolygon.Companion companion, int i, float f, float f7, CornerRounding rounding) {
        k.f(companion, "<this>");
        k.f(rounding, "rounding");
        return star$default(companion, i, f, f7, rounding, null, null, 0.0f, 0.0f, 240, null);
    }

    public static final RoundedPolygon circle(RoundedPolygon.Companion companion, @IntRange(from = 3) int i, float f, float f7, float f9) {
        k.f(companion, "<this>");
        if (i >= 3) {
            return RoundedPolygonKt.RoundedPolygon$default(i, f / ((float) Math.cos(Utils.getFloatPi() / i)), f7, f9, new CornerRounding(f, 0.0f, 2, null), null, 32, null);
        }
        throw new IllegalArgumentException("Circle must have at least three vertices");
    }

    public static final RoundedPolygon pill(RoundedPolygon.Companion companion, float f, float f7, float f9, float f10) {
        k.f(companion, "<this>");
        return pill$default(companion, f, f7, f9, f10, 0.0f, 16, null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f, float f7, int i, @FloatRange(from = 0.0d, fromInclusive = false, to = 1.0d, toInclusive = false) float f9) {
        k.f(companion, "<this>");
        return pillStar$default(companion, f, f7, i, f9, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, WindowType.ACCESSIBILITY_OVERLAY, null);
    }

    public static final RoundedPolygon star(RoundedPolygon.Companion companion, int i, float f, float f7, CornerRounding rounding, CornerRounding cornerRounding) {
        k.f(companion, "<this>");
        k.f(rounding, "rounding");
        return star$default(companion, i, f, f7, rounding, cornerRounding, null, 0.0f, 0.0f, 224, null);
    }

    public static final RoundedPolygon pill(RoundedPolygon.Companion companion, float f, float f7, float f9, float f10, float f11) {
        k.f(companion, "<this>");
        if (f > 0.0f && f7 > 0.0f) {
            float f12 = 2;
            float f13 = f / f12;
            float f14 = f7 / f12;
            float f15 = f13 + f10;
            float f16 = f14 + f11;
            float f17 = (-f13) + f10;
            float f18 = (-f14) + f11;
            return RoundedPolygonKt.RoundedPolygon$default(new float[]{f15, f16, f17, f16, f17, f18, f15, f18}, new CornerRounding(Math.min(f13, f14), f9), null, f10, f11, 4, null);
        }
        throw new IllegalArgumentException("Pill shapes must have positive width and height");
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f, float f7, int i, @FloatRange(from = 0.0d, fromInclusive = false, to = 1.0d, toInclusive = false) float f9, CornerRounding rounding) {
        k.f(companion, "<this>");
        k.f(rounding, "rounding");
        return pillStar$default(companion, f, f7, i, f9, rounding, null, null, 0.0f, 0.0f, 0.0f, 0.0f, WindowType.DRAG, null);
    }

    public static final RoundedPolygon star(RoundedPolygon.Companion companion, int i, float f, float f7, CornerRounding rounding, CornerRounding cornerRounding, List<CornerRounding> list) {
        k.f(companion, "<this>");
        k.f(rounding, "rounding");
        return star$default(companion, i, f, f7, rounding, cornerRounding, list, 0.0f, 0.0f, 192, null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f, float f7, int i, @FloatRange(from = 0.0d, fromInclusive = false, to = 1.0d, toInclusive = false) float f9, CornerRounding rounding, CornerRounding cornerRounding) {
        k.f(companion, "<this>");
        k.f(rounding, "rounding");
        return pillStar$default(companion, f, f7, i, f9, rounding, cornerRounding, null, 0.0f, 0.0f, 0.0f, 0.0f, 1984, null);
    }

    public static final RoundedPolygon star(RoundedPolygon.Companion companion, int i, float f, float f7, CornerRounding rounding, CornerRounding cornerRounding, List<CornerRounding> list, float f9) {
        k.f(companion, "<this>");
        k.f(rounding, "rounding");
        return star$default(companion, i, f, f7, rounding, cornerRounding, list, f9, 0.0f, 128, null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f, float f7, int i, @FloatRange(from = 0.0d, fromInclusive = false, to = 1.0d, toInclusive = false) float f9, CornerRounding rounding, CornerRounding cornerRounding, List<CornerRounding> list) {
        k.f(companion, "<this>");
        k.f(rounding, "rounding");
        return pillStar$default(companion, f, f7, i, f9, rounding, cornerRounding, list, 0.0f, 0.0f, 0.0f, 0.0f, 1920, null);
    }

    public static final RoundedPolygon star(RoundedPolygon.Companion companion, int i, float f, float f7, CornerRounding rounding, CornerRounding cornerRounding, List<CornerRounding> list, float f9, float f10) {
        k.f(companion, "<this>");
        k.f(rounding, "rounding");
        if (f <= 0.0f || f7 <= 0.0f) {
            throw new IllegalArgumentException("Star radii must both be greater than 0");
        }
        if (f7 < f) {
            if (list == null && cornerRounding != null) {
                f fVarX = AbstractC1451a.X(0, i);
                list = new ArrayList<>();
                e it = fVarX.iterator();
                while (it.c) {
                    it.nextInt();
                    A.e0(o.N(rounding, cornerRounding), list);
                }
            }
            return RoundedPolygonKt.RoundedPolygon(starVerticesFromNumVerts(i, f, f7, f9, f10), rounding, list, f9, f10);
        }
        throw new IllegalArgumentException("innerRadius must be less than radius");
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f, float f7, int i, @FloatRange(from = 0.0d, fromInclusive = false, to = 1.0d, toInclusive = false) float f9, CornerRounding rounding, CornerRounding cornerRounding, List<CornerRounding> list, @FloatRange(from = 0.0d, to = 1.0d) float f10) {
        k.f(companion, "<this>");
        k.f(rounding, "rounding");
        return pillStar$default(companion, f, f7, i, f9, rounding, cornerRounding, list, f10, 0.0f, 0.0f, 0.0f, 1792, null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f, float f7, int i, @FloatRange(from = 0.0d, fromInclusive = false, to = 1.0d, toInclusive = false) float f9, CornerRounding rounding, CornerRounding cornerRounding, List<CornerRounding> list, @FloatRange(from = 0.0d, to = 1.0d) float f10, @FloatRange(from = 0.0d, to = 1.0d) float f11) {
        k.f(companion, "<this>");
        k.f(rounding, "rounding");
        return pillStar$default(companion, f, f7, i, f9, rounding, cornerRounding, list, f10, f11, 0.0f, 0.0f, 1536, null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f, float f7, int i, @FloatRange(from = 0.0d, fromInclusive = false, to = 1.0d, toInclusive = false) float f9, CornerRounding rounding, CornerRounding cornerRounding, List<CornerRounding> list, @FloatRange(from = 0.0d, to = 1.0d) float f10, @FloatRange(from = 0.0d, to = 1.0d) float f11, float f12) {
        k.f(companion, "<this>");
        k.f(rounding, "rounding");
        return pillStar$default(companion, f, f7, i, f9, rounding, cornerRounding, list, f10, f11, f12, 0.0f, 1024, null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f, float f7, int i, @FloatRange(from = 0.0d, fromInclusive = false, to = 1.0d, toInclusive = false) float f9, CornerRounding rounding, CornerRounding cornerRounding, List<CornerRounding> list, @FloatRange(from = 0.0d, to = 1.0d) float f10, @FloatRange(from = 0.0d, to = 1.0d) float f11, float f12, float f13) {
        List<CornerRounding> arrayList;
        k.f(companion, "<this>");
        k.f(rounding, "rounding");
        if (f <= 0.0f || f7 <= 0.0f) {
            throw new IllegalArgumentException("Pill shapes must have positive width and height");
        }
        if (f9 > 0.0f && f9 <= 1.0f) {
            if (list != null || cornerRounding == null) {
                arrayList = list;
            } else {
                f fVarX = AbstractC1451a.X(0, i);
                arrayList = new ArrayList<>();
                e it = fVarX.iterator();
                while (it.c) {
                    it.nextInt();
                    A.e0(o.N(rounding, cornerRounding), arrayList);
                }
            }
            return RoundedPolygonKt.RoundedPolygon(pillStarVerticesFromNumVerts(i, f, f7, f9, f10, f11, f12, f13), rounding, arrayList, f12, f13);
        }
        throw new IllegalArgumentException("innerRadius must be between 0 and 1");
    }
}
