package androidx.graphics.shapes;

import D7.AbstractC0214f;
import D7.v;
import D7.w;
import H4.o;
import androidx.annotation.FloatRange;
import androidx.collection.FloatList;
import androidx.collection.MutableFloatList;
import androidx.graphics.shapes.Feature;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import g1.AbstractC1451a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\b\u0000\u0018\u0000 \u001d2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u001d\u001eB5\b\u0012\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u001c\u0010\u0014\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0012H\u0096\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0016R\u001e\u0010\t\u001a\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0017R\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Landroidx/graphics/shapes/MeasuredPolygon;", "LD7/f;", "Landroidx/graphics/shapes/MeasuredPolygon$MeasuredCubic;", "Landroidx/graphics/shapes/Measurer;", "measurer", "", "Landroidx/graphics/shapes/ProgressableFeature;", "features", "Landroidx/graphics/shapes/Cubic;", "cubics", "Landroidx/collection/FloatList;", "outlineProgress", AppAgent.CONSTRUCT, "(Landroidx/graphics/shapes/Measurer;Ljava/util/List;Ljava/util/List;Landroidx/collection/FloatList;)V", "", "cuttingPoint", "cutAndShift", "(F)Landroidx/graphics/shapes/MeasuredPolygon;", "", "index", "get", "(I)Landroidx/graphics/shapes/MeasuredPolygon$MeasuredCubic;", "Landroidx/graphics/shapes/Measurer;", "Ljava/util/List;", "getFeatures", "()Ljava/util/List;", "getSize", "()I", "size", "Companion", "MeasuredCubic", "graphics-shapes_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MeasuredPolygon extends AbstractC0214f {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<MeasuredCubic> cubics;
    private final List<ProgressableFeature> features;
    private final Measurer measurer;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b\t¨\u0006\n"}, d2 = {"Landroidx/graphics/shapes/MeasuredPolygon$Companion;", "", "()V", "measurePolygon", "Landroidx/graphics/shapes/MeasuredPolygon;", "measurer", "Landroidx/graphics/shapes/Measurer;", "polygon", "Landroidx/graphics/shapes/RoundedPolygon;", "measurePolygon$graphics_shapes_release", "graphics-shapes_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final MeasuredPolygon measurePolygon$graphics_shapes_release(Measurer measurer, RoundedPolygon polygon) {
            List listM;
            k.f(measurer, "measurer");
            k.f(polygon, "polygon");
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int size = polygon.getFeatures$graphics_shapes_release().size();
            for (int i = 0; i < size; i++) {
                Feature feature = polygon.getFeatures$graphics_shapes_release().get(i);
                int size2 = feature.getCubics().size();
                for (int i6 = 0; i6 < size2; i6++) {
                    if ((feature instanceof Feature.Corner) && i6 == feature.getCubics().size() / 2) {
                        arrayList2.add(new Pair(feature, Integer.valueOf(arrayList.size())));
                    }
                    arrayList.add(feature.getCubics().get(i6));
                }
            }
            Float fValueOf = Float.valueOf(0.0f);
            int iC0 = w.c0(arrayList, 9);
            if (iC0 == 0) {
                listM = o.M(fValueOf);
            } else {
                ArrayList arrayList3 = new ArrayList(iC0 + 1);
                arrayList3.add(fValueOf);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Cubic cubic = (Cubic) it.next();
                    float fFloatValue = fValueOf.floatValue();
                    float fMeasureCubic = measurer.measureCubic(cubic);
                    if (fMeasureCubic < 0.0f) {
                        throw new IllegalArgumentException("Measured cubic is expected to be greater or equal to zero");
                    }
                    fValueOf = Float.valueOf(fFloatValue + fMeasureCubic);
                    arrayList3.add(fValueOf);
                }
                listM = arrayList3;
            }
            float fFloatValue2 = ((Number) v.K0(listM)).floatValue();
            MutableFloatList mutableFloatList = new MutableFloatList(listM.size());
            int size3 = listM.size();
            for (int i10 = 0; i10 < size3; i10++) {
                mutableFloatList.add(((Number) listM.get(i10)).floatValue() / fFloatValue2);
            }
            String unused = PolygonMeasureKt.LOG_TAG;
            ListBuilder listBuilderY = o.y();
            int size4 = arrayList2.size();
            for (int i11 = 0; i11 < size4; i11++) {
                int iIntValue = ((Number) ((Pair) arrayList2.get(i11)).b).intValue();
                listBuilderY.add(new ProgressableFeature((mutableFloatList.get(iIntValue + 1) + mutableFloatList.get(iIntValue)) / 2, (Feature) ((Pair) arrayList2.get(i11)).f4886a));
            }
            return new MeasuredPolygon(measurer, o.q(listBuilderY), arrayList, mutableFloatList, null);
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0080\u0004\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\u0010\u001a\u0016\u0012\b\u0012\u00060\u0000R\u00020\u000f\u0012\b\u0012\u00060\u0000R\u00020\u000f0\u000e2\u0006\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0018\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00048\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001d\u0010\u001bR$\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00048\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001e\u0010\u001b¨\u0006\u001f"}, d2 = {"Landroidx/graphics/shapes/MeasuredPolygon$MeasuredCubic;", "", "Landroidx/graphics/shapes/Cubic;", "cubic", "", "startOutlineProgress", "endOutlineProgress", AppAgent.CONSTRUCT, "(Landroidx/graphics/shapes/MeasuredPolygon;Landroidx/graphics/shapes/Cubic;FF)V", "LC7/r;", "updateProgressRange$graphics_shapes_release", "(FF)V", "updateProgressRange", "cutOutlineProgress", "Lkotlin/Pair;", "Landroidx/graphics/shapes/MeasuredPolygon;", "cutAtProgress", "(F)Lkotlin/Pair;", "", "toString", "()Ljava/lang/String;", "Landroidx/graphics/shapes/Cubic;", "getCubic", "()Landroidx/graphics/shapes/Cubic;", "measuredSize", "F", "getMeasuredSize", "()F", "<set-?>", "getStartOutlineProgress", "getEndOutlineProgress", "graphics-shapes_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class MeasuredCubic {
        private final Cubic cubic;
        private float endOutlineProgress;
        private final float measuredSize;
        private float startOutlineProgress;
        final /* synthetic */ MeasuredPolygon this$0;

        public MeasuredCubic(MeasuredPolygon measuredPolygon, @FloatRange(from = 0.0d, to = 1.0d) Cubic cubic, @FloatRange(from = 0.0d, to = 1.0d) float f, float f7) {
            k.f(cubic, "cubic");
            this.this$0 = measuredPolygon;
            this.cubic = cubic;
            if (f7 < f) {
                throw new IllegalArgumentException("endOutlineProgress is expected to be equal or greater than startOutlineProgress");
            }
            this.measuredSize = measuredPolygon.measurer.measureCubic(cubic);
            this.startOutlineProgress = f;
            this.endOutlineProgress = f7;
        }

        public static /* synthetic */ void updateProgressRange$graphics_shapes_release$default(MeasuredCubic measuredCubic, float f, float f7, int i, Object obj) {
            if ((i & 1) != 0) {
                f = measuredCubic.startOutlineProgress;
            }
            if ((i & 2) != 0) {
                f7 = measuredCubic.endOutlineProgress;
            }
            measuredCubic.updateProgressRange$graphics_shapes_release(f, f7);
        }

        public final Pair<MeasuredCubic, MeasuredCubic> cutAtProgress(float cutOutlineProgress) {
            float fT = AbstractC1451a.t(cutOutlineProgress, this.startOutlineProgress, this.endOutlineProgress);
            float f = this.endOutlineProgress;
            float f7 = this.startOutlineProgress;
            float fFindCubicCutPoint = this.this$0.measurer.findCubicCutPoint(this.cubic, ((fT - f7) / (f - f7)) * this.measuredSize);
            if (0.0f > fFindCubicCutPoint || fFindCubicCutPoint > 1.0f) {
                throw new IllegalArgumentException("Cubic cut point is expected to be between 0 and 1");
            }
            String unused = PolygonMeasureKt.LOG_TAG;
            Pair<Cubic, Cubic> pairSplit = this.cubic.split(fFindCubicCutPoint);
            return new Pair<>(new MeasuredCubic(this.this$0, (Cubic) pairSplit.f4886a, this.startOutlineProgress, fT), new MeasuredCubic(this.this$0, (Cubic) pairSplit.b, fT, this.endOutlineProgress));
        }

        public final Cubic getCubic() {
            return this.cubic;
        }

        public final float getEndOutlineProgress() {
            return this.endOutlineProgress;
        }

        public final float getMeasuredSize() {
            return this.measuredSize;
        }

        public final float getStartOutlineProgress() {
            return this.startOutlineProgress;
        }

        public String toString() {
            return "MeasuredCubic(outlineProgress=[" + this.startOutlineProgress + " .. " + this.endOutlineProgress + "], size=" + this.measuredSize + ", cubic=" + this.cubic + ')';
        }

        public final void updateProgressRange$graphics_shapes_release(float startOutlineProgress, float endOutlineProgress) {
            if (endOutlineProgress < startOutlineProgress) {
                throw new IllegalArgumentException("endOutlineProgress is expected to be equal or greater than startOutlineProgress");
            }
            this.startOutlineProgress = startOutlineProgress;
            this.endOutlineProgress = endOutlineProgress;
        }
    }

    public /* synthetic */ MeasuredPolygon(Measurer measurer, List list, List list2, FloatList floatList, e eVar) {
        this(measurer, list, list2, floatList);
    }

    public /* bridge */ boolean contains(MeasuredCubic measuredCubic) {
        return super.contains((Object) measuredCubic);
    }

    public final MeasuredPolygon cutAndShift(float cuttingPoint) {
        float fPositiveModulo;
        if (0.0f > cuttingPoint || cuttingPoint > 1.0f) {
            throw new IllegalArgumentException("Cutting point is expected to be between 0 and 1");
        }
        if (cuttingPoint < 1.0E-4f) {
            return this;
        }
        Iterator<MeasuredCubic> it = this.cubics.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            MeasuredCubic next = it.next();
            float startOutlineProgress = next.getStartOutlineProgress();
            if (cuttingPoint <= next.getEndOutlineProgress() && startOutlineProgress <= cuttingPoint) {
                break;
            }
            i++;
        }
        Pair<MeasuredCubic, MeasuredCubic> pairCutAtProgress = this.cubics.get(i).cutAtProgress(cuttingPoint);
        MeasuredCubic measuredCubic = (MeasuredCubic) pairCutAtProgress.f4886a;
        MeasuredCubic measuredCubic2 = (MeasuredCubic) pairCutAtProgress.b;
        String unused = PolygonMeasureKt.LOG_TAG;
        ArrayList arrayListQ = o.Q(measuredCubic2.getCubic());
        int size = this.cubics.size();
        for (int i6 = 1; i6 < size; i6++) {
            List<MeasuredCubic> list = this.cubics;
            arrayListQ.add(list.get((i6 + i) % list.size()).getCubic());
        }
        arrayListQ.add(measuredCubic.getCubic());
        MutableFloatList mutableFloatList = new MutableFloatList(this.cubics.size() + 2);
        int size2 = this.cubics.size() + 2;
        for (int i10 = 0; i10 < size2; i10++) {
            if (i10 == 0) {
                fPositiveModulo = 0.0f;
            } else if (i10 == this.cubics.size() + 1) {
                fPositiveModulo = 1.0f;
            } else {
                fPositiveModulo = Utils.positiveModulo(this.cubics.get(((i + i10) - 1) % this.cubics.size()).getEndOutlineProgress() - cuttingPoint, 1.0f);
            }
            mutableFloatList.add(fPositiveModulo);
        }
        ListBuilder listBuilderY = o.y();
        int size3 = this.features.size();
        for (int i11 = 0; i11 < size3; i11++) {
            listBuilderY.add(new ProgressableFeature(Utils.positiveModulo(this.features.get(i11).getProgress() - cuttingPoint, 1.0f), this.features.get(i11).getFeature()));
        }
        return new MeasuredPolygon(this.measurer, o.q(listBuilderY), arrayListQ, mutableFloatList);
    }

    public final List<ProgressableFeature> getFeatures() {
        return this.features;
    }

    @Override // D7.AbstractC0214f, D7.AbstractC0209a
    public int getSize() {
        return this.cubics.size();
    }

    public /* bridge */ int indexOf(MeasuredCubic measuredCubic) {
        return super.indexOf((Object) measuredCubic);
    }

    public /* bridge */ int lastIndexOf(MeasuredCubic measuredCubic) {
        return super.lastIndexOf((Object) measuredCubic);
    }

    private MeasuredPolygon(Measurer measurer, List<ProgressableFeature> list, List<? extends Cubic> list2, FloatList floatList) {
        if (floatList.getSize() != list2.size() + 1) {
            throw new IllegalArgumentException("Outline progress size is expected to be the cubics size + 1");
        }
        if (floatList.first() != 0.0f) {
            throw new IllegalArgumentException("First outline progress value is expected to be zero");
        }
        if (floatList.last() != 1.0f) {
            throw new IllegalArgumentException("Last outline progress value is expected to be one");
        }
        this.measurer = measurer;
        this.features = list;
        ArrayList arrayList = new ArrayList();
        int size = list2.size();
        int i = 0;
        float f = 0.0f;
        while (i < size) {
            int i6 = i + 1;
            if (floatList.get(i6) - floatList.get(i) > 1.0E-4f) {
                arrayList.add(new MeasuredCubic(this, list2.get(i), f, floatList.get(i6)));
                f = floatList.get(i6);
            }
            i = i6;
        }
        MeasuredCubic.updateProgressRange$graphics_shapes_release$default((MeasuredCubic) arrayList.get(o.H(arrayList)), 0.0f, 1.0f, 1, null);
        this.cubics = arrayList;
    }

    @Override // D7.AbstractC0209a, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof MeasuredCubic) {
            return contains((MeasuredCubic) obj);
        }
        return false;
    }

    @Override // D7.AbstractC0214f, java.util.List
    public MeasuredCubic get(int index) {
        return this.cubics.get(index);
    }

    @Override // D7.AbstractC0214f, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof MeasuredCubic) {
            return indexOf((MeasuredCubic) obj);
        }
        return -1;
    }

    @Override // D7.AbstractC0214f, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof MeasuredCubic) {
            return lastIndexOf((MeasuredCubic) obj);
        }
        return -1;
    }
}
