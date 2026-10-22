package androidx.compose.ui.layout;

import androidx.compose.ui.unit.Density;
import kotlin.Metadata;

@MeasureScopeMarker
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H¦\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\t\u001a\u00020\u0005*\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0003H¦\u0004¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u000b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000fÀ\u0006\u0001"}, d2 = {"Landroidx/compose/ui/layout/RulerScope;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/layout/Ruler;", "", "value", "LC7/r;", "provides", "(Landroidx/compose/ui/layout/Ruler;F)V", "Landroidx/compose/ui/layout/VerticalRuler;", "providesRelative", "(Landroidx/compose/ui/layout/VerticalRuler;F)V", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "coordinates", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public interface RulerScope extends Density {
    LayoutCoordinates getCoordinates();

    void provides(Ruler ruler, float f);

    void providesRelative(VerticalRuler verticalRuler, float f);
}
