package androidx.compose.ui.layout;

import S7.n;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.Placeable;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B%\b\u0002\u0012\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007B\t\b\u0016¢\u0006\u0004\b\u0006\u0010\bJ'\u0010\u000f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0010¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/layout/HorizontalRuler;", "Landroidx/compose/ui/layout/Ruler;", "Lkotlin/Function2;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "calculation", AppAgent.CONSTRUCT, "(LS7/n;)V", "()V", "coordinate", "Landroidx/compose/ui/layout/LayoutCoordinates;", "sourceCoordinates", "targetCoordinates", "calculateCoordinate$ui_release", "(FLandroidx/compose/ui/layout/LayoutCoordinates;Landroidx/compose/ui/layout/LayoutCoordinates;)F", "calculateCoordinate", "Companion", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class HorizontalRuler extends Ruler {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0007\u001a\u00020\u00052\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\t\u001a\u00020\u00052\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005¢\u0006\u0004\b\t\u0010\bJ'\u0010\u000e\u001a\u00020\u00052\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/layout/HorizontalRuler$Companion;", "", AppAgent.CONSTRUCT, "()V", "", "Landroidx/compose/ui/layout/HorizontalRuler;", "rulers", "maxOf", "([Landroidx/compose/ui/layout/HorizontalRuler;)Landroidx/compose/ui/layout/HorizontalRuler;", "minOf", "Lkotlin/Function2;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "calculation", "derived", "(LS7/n;)Landroidx/compose/ui/layout/HorizontalRuler;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final HorizontalRuler derived(n calculation) {
            return new HorizontalRuler(calculation, null);
        }

        public final HorizontalRuler maxOf(final HorizontalRuler... rulers) {
            return new HorizontalRuler(new n() { // from class: androidx.compose.ui.layout.HorizontalRuler$Companion$maxOf$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    return invoke((Placeable.PlacementScope) obj, ((Number) obj2).floatValue());
                }

                public final Float invoke(Placeable.PlacementScope placementScope, float f) {
                    return Float.valueOf(RulerKt.mergeRulerValues(placementScope, true, rulers, f));
                }
            }, null);
        }

        public final HorizontalRuler minOf(final HorizontalRuler... rulers) {
            return new HorizontalRuler(new n() { // from class: androidx.compose.ui.layout.HorizontalRuler$Companion$minOf$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    return invoke((Placeable.PlacementScope) obj, ((Number) obj2).floatValue());
                }

                public final Float invoke(Placeable.PlacementScope placementScope, float f) {
                    return Float.valueOf(RulerKt.mergeRulerValues(placementScope, false, rulers, f));
                }
            }, null);
        }

        private Companion() {
        }
    }

    public /* synthetic */ HorizontalRuler(n nVar, e eVar) {
        this(nVar);
    }

    @Override // androidx.compose.ui.layout.Ruler
    public float calculateCoordinate$ui_release(float coordinate, LayoutCoordinates sourceCoordinates, LayoutCoordinates targetCoordinates) {
        return Float.intBitsToFloat((int) (targetCoordinates.mo5558localPositionOfR5De75A(sourceCoordinates, Offset.m3887constructorimpl((Float.floatToRawIntBits(((int) (sourceCoordinates.mo5557getSizeYbymL2g() >> 32)) / 2.0f) << 32) | (Float.floatToRawIntBits(coordinate) & 4294967295L))) & 4294967295L));
    }

    private HorizontalRuler(n nVar) {
        super(nVar, null);
    }

    public HorizontalRuler() {
        this(null);
    }
}
