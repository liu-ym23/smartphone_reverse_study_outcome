package androidx.graphics.shapes;

import D7.v;
import H4.o;
import Y7.e;
import Y7.f;
import androidx.graphics.shapes.Feature;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a6\u0010\u0002\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u00052\u0010\u0010\u0006\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u00052\u0010\u0010\u0007\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u0005H\u0000\u001a\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\nH\u0000\u001a,\u0010\u000b\u001a\u00020\f2\u0010\u0010\r\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u00052\u0010\u0010\u000e\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u0005H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082D¢\u0006\u0002\n\u0000*\u0018\b\u0000\u0010\u000f\"\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0012\u0004\u0012\u00020\u00040\u0003¨\u0006\u0010"}, d2 = {"LOG_TAG", "", "doMapping", "", "Landroidx/graphics/shapes/ProgressableFeature;", "Landroidx/graphics/shapes/MeasuredFeatures;", "f1", "f2", "featureDistSquared", "", "Landroidx/graphics/shapes/Feature;", "featureMapper", "Landroidx/graphics/shapes/DoubleMapper;", "features1", "features2", "MeasuredFeatures", "graphics-shapes_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FeatureMappingKt {
    private static final String LOG_TAG = "FeatureMapping";

    public static final List<ProgressableFeature> doMapping(List<ProgressableFeature> f12, List<ProgressableFeature> f22) {
        k.f(f12, "f1");
        k.f(f22, "f2");
        e it = o.F(f22).iterator();
        if (!it.c) {
            throw new NoSuchElementException();
        }
        int iNextInt = it.nextInt();
        if (it.c) {
            float fFeatureDistSquared = featureDistSquared(f12.get(0).getFeature(), f22.get(iNextInt).getFeature());
            do {
                int iNextInt2 = it.nextInt();
                float fFeatureDistSquared2 = featureDistSquared(f12.get(0).getFeature(), f22.get(iNextInt2).getFeature());
                if (Float.compare(fFeatureDistSquared, fFeatureDistSquared2) > 0) {
                    iNextInt = iNextInt2;
                    fFeatureDistSquared = fFeatureDistSquared2;
                }
            } while (it.c);
        }
        int size = f12.size();
        int size2 = f22.size();
        ArrayList arrayListQ = o.Q(f22.get(iNextInt));
        int i = iNextInt;
        for (int i6 = 1; i6 < size; i6++) {
            int i10 = iNextInt - (size - i6);
            if (i10 <= i) {
                i10 += size2;
            }
            e it2 = new f(i + 1, i10, 1).iterator();
            if (!it2.c) {
                throw new NoSuchElementException();
            }
            int iNextInt3 = it2.nextInt();
            if (it2.c) {
                float fFeatureDistSquared3 = featureDistSquared(f12.get(i6).getFeature(), f22.get(iNextInt3 % size2).getFeature());
                do {
                    int iNextInt4 = it2.nextInt();
                    float fFeatureDistSquared4 = featureDistSquared(f12.get(i6).getFeature(), f22.get(iNextInt4 % size2).getFeature());
                    if (Float.compare(fFeatureDistSquared3, fFeatureDistSquared4) > 0) {
                        iNextInt3 = iNextInt4;
                        fFeatureDistSquared3 = fFeatureDistSquared4;
                    }
                } while (it2.c);
            }
            i = iNextInt3;
            arrayListQ.add(f22.get(i % size2));
        }
        return arrayListQ;
    }

    public static final float featureDistSquared(Feature f12, Feature f22) {
        k.f(f12, "f1");
        k.f(f22, "f2");
        if ((f12 instanceof Feature.Corner) && (f22 instanceof Feature.Corner) && ((Feature.Corner) f12).getConvex() != ((Feature.Corner) f22).getConvex()) {
            return Float.MAX_VALUE;
        }
        float anchor1X = (((Cubic) v.K0(f12.getCubics())).getAnchor1X() + ((Cubic) v.A0(f12.getCubics())).getAnchor0X()) / 2.0f;
        float anchor1Y = (((Cubic) v.K0(f12.getCubics())).getAnchor1Y() + ((Cubic) v.A0(f12.getCubics())).getAnchor0Y()) / 2.0f;
        float anchor1X2 = (((Cubic) v.K0(f22.getCubics())).getAnchor1X() + ((Cubic) v.A0(f22.getCubics())).getAnchor0X()) / 2.0f;
        float f = anchor1X - anchor1X2;
        float anchor1Y2 = anchor1Y - ((((Cubic) v.K0(f22.getCubics())).getAnchor1Y() + ((Cubic) v.A0(f22.getCubics())).getAnchor0Y()) / 2.0f);
        return (anchor1Y2 * anchor1Y2) + (f * f);
    }

    public static final DoubleMapper featureMapper(List<ProgressableFeature> features1, List<ProgressableFeature> features2) {
        k.f(features1, "features1");
        k.f(features2, "features2");
        ListBuilder listBuilderY = o.y();
        int size = features1.size();
        for (int i = 0; i < size; i++) {
            if (features1.get(i).getFeature() instanceof Feature.Corner) {
                listBuilderY.add(features1.get(i));
            }
        }
        ListBuilder listBuilderQ = o.q(listBuilderY);
        ListBuilder listBuilderY2 = o.y();
        int size2 = features2.size();
        for (int i6 = 0; i6 < size2; i6++) {
            if (features2.get(i6).getFeature() instanceof Feature.Corner) {
                listBuilderY2.add(features2.get(i6));
            }
        }
        ListBuilder listBuilderQ2 = o.q(listBuilderY2);
        Pair pair = listBuilderQ.size() > listBuilderQ2.size() ? new Pair(doMapping(listBuilderQ2, listBuilderQ), listBuilderQ2) : new Pair(listBuilderQ, doMapping(listBuilderQ, listBuilderQ2));
        List list = (List) pair.f4886a;
        List list2 = (List) pair.b;
        ListBuilder listBuilderY3 = o.y();
        int size3 = list.size();
        for (int i10 = 0; i10 < size3 && i10 != list2.size(); i10++) {
            listBuilderY3.add(new Pair(Float.valueOf(((ProgressableFeature) list.get(i10)).getProgress()), Float.valueOf(((ProgressableFeature) list2.get(i10)).getProgress())));
        }
        Pair[] pairArr = (Pair[]) o.q(listBuilderY3).toArray(new Pair[0]);
        return new DoubleMapper((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
    }
}
