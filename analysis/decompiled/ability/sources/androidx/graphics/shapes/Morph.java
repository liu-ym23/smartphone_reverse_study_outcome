package androidx.graphics.shapes;

import D7.v;
import H4.o;
import androidx.graphics.shapes.MeasuredPolygon;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 %2\u00020\u0001:\u0001%B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014J9\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0016\u001a\u00020\u00152\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00180\u0017H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001cR\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u001cR&\u0010\u001e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u001d0\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR,\u0010$\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u001d0\u00118@X\u0081\u0004¢\u0006\f\u0012\u0004\b\"\u0010#\u001a\u0004\b \u0010!\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006&"}, d2 = {"Landroidx/graphics/shapes/Morph;", "", "Landroidx/graphics/shapes/RoundedPolygon;", "start", "end", AppAgent.CONSTRUCT, "(Landroidx/graphics/shapes/RoundedPolygon;Landroidx/graphics/shapes/RoundedPolygon;)V", "", "bounds", "", "approximate", "calculateBounds", "([FZ)[F", "calculateMaxBounds", "([F)[F", "", "progress", "", "Landroidx/graphics/shapes/Cubic;", "asCubics", "(F)Ljava/util/List;", "Landroidx/graphics/shapes/MutableCubic;", "mutableCubic", "Lkotlin/Function1;", "LC7/r;", "callback", "forEachCubic", "(FLandroidx/graphics/shapes/MutableCubic;LS7/k;)V", "Landroidx/graphics/shapes/RoundedPolygon;", "Lkotlin/Pair;", "_morphMatch", "Ljava/util/List;", "getMorphMatch", "()Ljava/util/List;", "getMorphMatch$annotations", "()V", "morphMatch", "Companion", "graphics-shapes_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Morph {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<Pair<Cubic, Cubic>> _morphMatch;
    private final RoundedPolygon end;
    private final RoundedPolygon start;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J/\u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0001¢\u0006\u0002\b\n¨\u0006\u000b"}, d2 = {"Landroidx/graphics/shapes/Morph$Companion;", "", "()V", "match", "", "Lkotlin/Pair;", "Landroidx/graphics/shapes/Cubic;", "p1", "Landroidx/graphics/shapes/RoundedPolygon;", "p2", "match$graphics_shapes_release", "graphics-shapes_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final List<Pair<Cubic, Cubic>> match$graphics_shapes_release(RoundedPolygon p1, RoundedPolygon p22) {
            Pair<MeasuredPolygon.MeasuredCubic, MeasuredPolygon.MeasuredCubic> pairCutAtProgress;
            Pair<MeasuredPolygon.MeasuredCubic, MeasuredPolygon.MeasuredCubic> pairCutAtProgress2;
            k.f(p1, "p1");
            k.f(p22, "p2");
            MeasuredPolygon.Companion companion = MeasuredPolygon.INSTANCE;
            MeasuredPolygon measuredPolygonMeasurePolygon$graphics_shapes_release = companion.measurePolygon$graphics_shapes_release(new AngleMeasurer(p1.getCenterX(), p1.getCenterY()), p1);
            MeasuredPolygon measuredPolygonMeasurePolygon$graphics_shapes_release2 = companion.measurePolygon$graphics_shapes_release(new AngleMeasurer(p22.getCenterX(), p22.getCenterY()), p22);
            DoubleMapper doubleMapperFeatureMapper = FeatureMappingKt.featureMapper(measuredPolygonMeasurePolygon$graphics_shapes_release.getFeatures(), measuredPolygonMeasurePolygon$graphics_shapes_release2.getFeatures());
            float map = doubleMapperFeatureMapper.map(0.0f);
            String unused = MorphKt.LOG_TAG;
            MeasuredPolygon measuredPolygonCutAndShift = measuredPolygonMeasurePolygon$graphics_shapes_release2.cutAndShift(map);
            ArrayList arrayList = new ArrayList();
            MeasuredPolygon.MeasuredCubic measuredCubic = (MeasuredPolygon.MeasuredCubic) v.D0(0, measuredPolygonMeasurePolygon$graphics_shapes_release);
            MeasuredPolygon.MeasuredCubic measuredCubic2 = (MeasuredPolygon.MeasuredCubic) v.D0(0, measuredPolygonCutAndShift);
            int i = 1;
            int i6 = 1;
            while (measuredCubic != null && measuredCubic2 != null) {
                float endOutlineProgress = i == measuredPolygonMeasurePolygon$graphics_shapes_release.size() ? 1.0f : measuredCubic.getEndOutlineProgress();
                float fMapBack = i6 == measuredPolygonCutAndShift.size() ? 1.0f : doubleMapperFeatureMapper.mapBack(Utils.positiveModulo(measuredCubic2.getEndOutlineProgress() + map, 1.0f));
                float fMin = Math.min(endOutlineProgress, fMapBack);
                String unused2 = MorphKt.LOG_TAG;
                float f = 1.0E-6f + fMin;
                if (endOutlineProgress > f) {
                    String unused3 = MorphKt.LOG_TAG;
                    pairCutAtProgress = measuredCubic.cutAtProgress(fMin);
                } else {
                    Pair<MeasuredPolygon.MeasuredCubic, MeasuredPolygon.MeasuredCubic> pair = new Pair<>(measuredCubic, v.D0(i, measuredPolygonMeasurePolygon$graphics_shapes_release));
                    i++;
                    pairCutAtProgress = pair;
                }
                MeasuredPolygon.MeasuredCubic measuredCubic3 = (MeasuredPolygon.MeasuredCubic) pairCutAtProgress.f4886a;
                measuredCubic = (MeasuredPolygon.MeasuredCubic) pairCutAtProgress.b;
                if (fMapBack > f) {
                    String unused4 = MorphKt.LOG_TAG;
                    pairCutAtProgress2 = measuredCubic2.cutAtProgress(Utils.positiveModulo(doubleMapperFeatureMapper.map(fMin) - map, 1.0f));
                } else {
                    Pair<MeasuredPolygon.MeasuredCubic, MeasuredPolygon.MeasuredCubic> pair2 = new Pair<>(measuredCubic2, v.D0(i6, measuredPolygonCutAndShift));
                    i6++;
                    pairCutAtProgress2 = pair2;
                }
                MeasuredPolygon.MeasuredCubic measuredCubic4 = (MeasuredPolygon.MeasuredCubic) pairCutAtProgress2.f4886a;
                measuredCubic2 = (MeasuredPolygon.MeasuredCubic) pairCutAtProgress2.b;
                String unused5 = MorphKt.LOG_TAG;
                arrayList.add(new Pair(measuredCubic3.getCubic(), measuredCubic4.getCubic()));
            }
            if (measuredCubic == null && measuredCubic2 == null) {
                return arrayList;
            }
            throw new IllegalArgumentException("Expected both Polygon's Cubic to be fully matched");
        }

        private Companion() {
        }
    }

    public Morph(RoundedPolygon start, RoundedPolygon end) {
        k.f(start, "start");
        k.f(end, "end");
        this.start = start;
        this.end = end;
        this._morphMatch = INSTANCE.match$graphics_shapes_release(start, end);
    }

    public static /* synthetic */ float[] calculateBounds$default(Morph morph, float[] fArr, boolean z10, int i, Object obj) {
        if ((i & 1) != 0) {
            fArr = new float[4];
        }
        if ((i & 2) != 0) {
            z10 = true;
        }
        return morph.calculateBounds(fArr, z10);
    }

    public static /* synthetic */ float[] calculateMaxBounds$default(Morph morph, float[] fArr, int i, Object obj) {
        if ((i & 1) != 0) {
            fArr = new float[4];
        }
        return morph.calculateMaxBounds(fArr);
    }

    public static void forEachCubic$default(Morph morph, float f, MutableCubic mutableCubic, S7.k callback, int i, Object obj) {
        if ((i & 2) != 0) {
            mutableCubic = new MutableCubic();
        }
        k.f(mutableCubic, "mutableCubic");
        k.f(callback, "callback");
        int size = morph.getMorphMatch().size();
        for (int i6 = 0; i6 < size; i6++) {
            mutableCubic.interpolate((Cubic) morph.getMorphMatch().get(i6).f4886a, (Cubic) morph.getMorphMatch().get(i6).b, f);
            callback.invoke(mutableCubic);
        }
    }

    public static /* synthetic */ void getMorphMatch$annotations() {
    }

    public final List<Cubic> asCubics(float progress) {
        ListBuilder listBuilderY = o.y();
        int size = this._morphMatch.size();
        Cubic cubic = null;
        Cubic cubic2 = null;
        int i = 0;
        while (i < size) {
            float[] fArr = new float[8];
            for (int i6 = 0; i6 < 8; i6++) {
                fArr[i6] = Utils.interpolate(((Cubic) this._morphMatch.get(i).f4886a).getPoints()[i6], ((Cubic) this._morphMatch.get(i).b).getPoints()[i6], progress);
            }
            Cubic cubic3 = new Cubic(fArr);
            if (cubic2 == null) {
                cubic2 = cubic3;
            }
            if (cubic != null) {
                listBuilderY.add(cubic);
            }
            i++;
            cubic = cubic3;
        }
        if (cubic != null && cubic2 != null) {
            listBuilderY.add(CubicKt.Cubic(cubic.getAnchor0X(), cubic.getAnchor0Y(), cubic.getControl0X(), cubic.getControl0Y(), cubic.getControl1X(), cubic.getControl1Y(), cubic2.getAnchor0X(), cubic2.getAnchor0Y()));
        }
        return o.q(listBuilderY);
    }

    public final float[] calculateBounds() {
        return calculateBounds$default(this, null, false, 3, null);
    }

    public final float[] calculateMaxBounds(float[] bounds) {
        k.f(bounds, "bounds");
        this.start.calculateMaxBounds(bounds);
        float f = bounds[0];
        float f7 = bounds[1];
        float f9 = bounds[2];
        float f10 = bounds[3];
        this.end.calculateMaxBounds(bounds);
        bounds[0] = Math.min(f, bounds[0]);
        bounds[1] = Math.min(f7, bounds[1]);
        bounds[2] = Math.max(f9, bounds[2]);
        bounds[3] = Math.max(f10, bounds[3]);
        return bounds;
    }

    public final void forEachCubic(float progress, MutableCubic mutableCubic, S7.k callback) {
        k.f(mutableCubic, "mutableCubic");
        k.f(callback, "callback");
        int size = getMorphMatch().size();
        for (int i = 0; i < size; i++) {
            mutableCubic.interpolate((Cubic) getMorphMatch().get(i).f4886a, (Cubic) getMorphMatch().get(i).b, progress);
            callback.invoke(mutableCubic);
        }
    }

    public final List<Pair<Cubic, Cubic>> getMorphMatch() {
        return this._morphMatch;
    }

    public final float[] calculateBounds(float[] bounds) {
        k.f(bounds, "bounds");
        return calculateBounds$default(this, bounds, false, 2, null);
    }

    public final float[] calculateBounds(float[] bounds, boolean approximate) {
        k.f(bounds, "bounds");
        this.start.calculateBounds(bounds, approximate);
        float f = bounds[0];
        float f7 = bounds[1];
        float f9 = bounds[2];
        float f10 = bounds[3];
        this.end.calculateBounds(bounds, approximate);
        bounds[0] = Math.min(f, bounds[0]);
        bounds[1] = Math.min(f7, bounds[1]);
        bounds[2] = Math.max(f9, bounds[2]);
        bounds[3] = Math.max(f10, bounds[3]);
        return bounds;
    }

    public final void forEachCubic(float f, S7.k callback) {
        k.f(callback, "callback");
        MutableCubic mutableCubic = new MutableCubic();
        int size = getMorphMatch().size();
        for (int i = 0; i < size; i++) {
            mutableCubic.interpolate((Cubic) getMorphMatch().get(i).f4886a, (Cubic) getMorphMatch().get(i).b, f);
            callback.invoke(mutableCubic);
        }
    }
}
