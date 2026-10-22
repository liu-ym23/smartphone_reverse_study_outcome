package androidx.graphics.shapes;

import H4.o;
import androidx.collection.FloatFloatPair;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u00002\u00020\u0001:\u0002\f\rB\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nH ¢\u0006\u0002\b\u000bR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Landroidx/graphics/shapes/Feature;", "", "cubics", "", "Landroidx/graphics/shapes/Cubic;", "(Ljava/util/List;)V", "getCubics", "()Ljava/util/List;", "transformed", "f", "Landroidx/graphics/shapes/PointTransformer;", "transformed$graphics_shapes_release", "Corner", "Edge", "graphics-shapes_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class Feature {
    private final List<Cubic> cubics;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B7\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006\u0012\n\u0010\b\u001a\u00060\u0005j\u0002`\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\rH\u0010¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R!\u0010\u0007\u001a\u00060\u0005j\u0002`\u00068\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R!\u0010\b\u001a\u00060\u0005j\u0002`\u00068\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0018\u0010\u0017R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001c"}, d2 = {"Landroidx/graphics/shapes/Feature$Corner;", "Landroidx/graphics/shapes/Feature;", "", "Landroidx/graphics/shapes/Cubic;", "cubics", "Landroidx/collection/FloatFloatPair;", "Landroidx/graphics/shapes/Point;", "vertex", "roundedCenter", "", "convex", AppAgent.CONSTRUCT, "(Ljava/util/List;JJZLkotlin/jvm/internal/e;)V", "Landroidx/graphics/shapes/PointTransformer;", "f", "transformed$graphics_shapes_release", "(Landroidx/graphics/shapes/PointTransformer;)Landroidx/graphics/shapes/Feature;", "transformed", "", "toString", "()Ljava/lang/String;", "J", "getVertex-1ufDz9w", "()J", "getRoundedCenter-1ufDz9w", "Z", "getConvex", "()Z", "graphics-shapes_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Corner extends Feature {
        private final boolean convex;
        private final long roundedCenter;
        private final long vertex;

        public /* synthetic */ Corner(List list, long j5, long j6, boolean z10, e eVar) {
            this(list, j5, j6, z10);
        }

        public final boolean getConvex() {
            return this.convex;
        }

        /* renamed from: getRoundedCenter-1ufDz9w, reason: not valid java name and from getter */
        public final long getRoundedCenter() {
            return this.roundedCenter;
        }

        /* renamed from: getVertex-1ufDz9w, reason: not valid java name and from getter */
        public final long getVertex() {
            return this.vertex;
        }

        public String toString() {
            return "Corner: vertex=" + ((Object) FloatFloatPair.m18toStringimpl(this.vertex)) + ", center=" + ((Object) FloatFloatPair.m18toStringimpl(this.roundedCenter)) + ", convex=" + this.convex;
        }

        @Override // androidx.graphics.shapes.Feature
        public Feature transformed$graphics_shapes_release(PointTransformer f) {
            k.f(f, "f");
            ListBuilder listBuilderY = o.y();
            int size = getCubics().size();
            for (int i = 0; i < size; i++) {
                listBuilderY.add(getCubics().get(i).transformed(f));
            }
            return new Corner(o.q(listBuilderY), PointKt.m7144transformedso9K2fw(this.vertex, f), PointKt.m7144transformedso9K2fw(this.roundedCenter, f), this.convex, null);
        }

        public /* synthetic */ Corner(List list, long j5, long j6, boolean z10, int i, e eVar) {
            this(list, j5, j6, (i & 8) != 0 ? true : z10, null);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private Corner(List<? extends Cubic> cubics, long j5, long j6, boolean z10) {
            super(cubics);
            k.f(cubics, "cubics");
            this.vertex = j5;
            this.roundedCenter = j6;
            this.convex = z10;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0015\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nH\u0010¢\u0006\u0002\b\u000b¨\u0006\f"}, d2 = {"Landroidx/graphics/shapes/Feature$Edge;", "Landroidx/graphics/shapes/Feature;", "cubics", "", "Landroidx/graphics/shapes/Cubic;", "(Ljava/util/List;)V", "toString", "", "transformed", "f", "Landroidx/graphics/shapes/PointTransformer;", "transformed$graphics_shapes_release", "graphics-shapes_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Edge extends Feature {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Edge(List<? extends Cubic> cubics) {
            super(cubics);
            k.f(cubics, "cubics");
        }

        public String toString() {
            return "Edge";
        }

        @Override // androidx.graphics.shapes.Feature
        public Edge transformed$graphics_shapes_release(PointTransformer f) {
            k.f(f, "f");
            ListBuilder listBuilderY = o.y();
            int size = getCubics().size();
            for (int i = 0; i < size; i++) {
                listBuilderY.add(getCubics().get(i).transformed(f));
            }
            return new Edge(o.q(listBuilderY));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Feature(List<? extends Cubic> cubics) {
        k.f(cubics, "cubics");
        this.cubics = cubics;
    }

    public final List<Cubic> getCubics() {
        return this.cubics;
    }

    public abstract Feature transformed$graphics_shapes_release(PointTransformer f);
}
