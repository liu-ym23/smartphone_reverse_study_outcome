package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¨\u0006\u0007"}, d2 = {"width", "Landroidx/compose/ui/Modifier;", "intrinsicSize", "Landroidx/compose/foundation/layout/IntrinsicSize;", "height", "requiredWidth", "requiredHeight", "foundation-layout"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class IntrinsicKt {
    public static final Modifier height(Modifier r100, final IntrinsicSize r101) {
        if (InspectableValueKt.isDebugInspectorInfoEnabled() == false) goto L5;
        Function1<InspectorInfo, Unit> r102 = new IntrinsicKt$height$$inlined$debugInspectorInfo$1(r101);
    L7:
        return r100.then(new IntrinsicHeightElement(r101, true, r102));
    L5:
        r102 = InspectableValueKt.getNoInspectorInfo();
        goto L7
    }

    public static final Modifier requiredHeight(Modifier r100, final IntrinsicSize r101) {
        if (InspectableValueKt.isDebugInspectorInfoEnabled() == false) goto L5;
        Function1<InspectorInfo, Unit> r102 = new IntrinsicKt$requiredHeight$$inlined$debugInspectorInfo$1(r101);
    L7:
        return r100.then(new IntrinsicHeightElement(r101, false, r102));
    L5:
        r102 = InspectableValueKt.getNoInspectorInfo();
        goto L7
    }

    public static final Modifier requiredWidth(Modifier r100, final IntrinsicSize r101) {
        if (InspectableValueKt.isDebugInspectorInfoEnabled() == false) goto L5;
        Function1<InspectorInfo, Unit> r102 = new IntrinsicKt$requiredWidth$$inlined$debugInspectorInfo$1(r101);
    L7:
        return r100.then(new IntrinsicWidthElement(r101, false, r102));
    L5:
        r102 = InspectableValueKt.getNoInspectorInfo();
        goto L7
    }

    public static final Modifier width(Modifier r100, final IntrinsicSize r101) {
        if (InspectableValueKt.isDebugInspectorInfoEnabled() == false) goto L5;
        Function1<InspectorInfo, Unit> r102 = new IntrinsicKt$width$$inlined$debugInspectorInfo$1(r101);
    L7:
        return r100.then(new IntrinsicWidthElement(r101, true, r102));
    L5:
        r102 = InspectableValueKt.getNoInspectorInfo();
        goto L7
    }
}
