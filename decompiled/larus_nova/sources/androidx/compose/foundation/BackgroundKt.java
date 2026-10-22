package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u001a%\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\n\u001a\u00020\u000bH\u0007¨\u0006\f"}, d2 = {"background", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "shape", "Landroidx/compose/ui/graphics/Shape;", "background-bw27NRU", "(Landroidx/compose/ui/Modifier;JLandroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class BackgroundKt {
    /* JADX INFO: renamed from: background-bw27NRU, reason: not valid java name */
    public static final Modifier m231backgroundbw27NRU(Modifier r110, final long r111, final Shape r112) {
        if (InspectableValueKt.isDebugInspectorInfoEnabled() == false) goto L5;
        Function1<InspectorInfo, Unit> r100 = new BackgroundKt$backgroundbw27NRU$$inlined$debugInspectorInfo$1(r111, r112);
    L7:
        return r110.then(new BackgroundElement(r111, null, 1.0f, r112, r100, 2, null));
    L5:
        r100 = InspectableValueKt.getNoInspectorInfo();
        goto L7
    }

    public static final Modifier background(Modifier r110, final Brush r111, final Shape r112, final float r113) {
        if (InspectableValueKt.isDebugInspectorInfoEnabled() == false) goto L5;
        Function1<InspectorInfo, Unit> r100 = new BackgroundKt$background$$inlined$debugInspectorInfo$1(r113, r111, r112);
    L7:
        return r110.then(new BackgroundElement(0, r111, r113, r112, r100, 1, null));
    L5:
        r100 = InspectableValueKt.getNoInspectorInfo();
        goto L7
    }

    /* JADX INFO: renamed from: background-bw27NRU$default, reason: not valid java name */
    public static /* synthetic */ Modifier m232backgroundbw27NRU$default(Modifier r100, long r101, Shape r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = RectangleShapeKt.getRectangleShape();
    L6:
        return m231backgroundbw27NRU(r100, r101, r102);
    }

    public static /* synthetic */ Modifier background$default(Modifier r100, Brush r101, Shape r102, float r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = RectangleShapeKt.getRectangleShape();
    L6:
        if ((r104 & 4) == 0) goto L9;
        r103 = 1.0f;
    L9:
        return background(r100, r101, r102, r103);
    }
}
