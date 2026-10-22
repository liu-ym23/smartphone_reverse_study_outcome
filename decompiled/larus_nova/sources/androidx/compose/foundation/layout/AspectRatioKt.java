package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Constraints;
import com.baidu.platform.comapi.map.MapBundleKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u001a \u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007\u001a#\u0010\u0006\u001a\u00020\u0005*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0001¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"aspectRatio", "Landroidx/compose/ui/Modifier;", MapBundleKey.OfflineMapKey.OFFLINE_RATION, "", "matchHeightConstraintsFirst", "", "isSatisfiedBy", "Landroidx/compose/ui/unit/Constraints;", "width", "", "height", "isSatisfiedBy-NN6Ew-U", "(JII)Z", "foundation-layout"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AspectRatioKt {
    public static final Modifier aspectRatio(Modifier r100, final float r101, final boolean r102) {
        if (InspectableValueKt.isDebugInspectorInfoEnabled() == false) goto L5;
        Function1<InspectorInfo, Unit> r103 = new AspectRatioKt$aspectRatio$$inlined$debugInspectorInfo$1(r101, r102);
    L7:
        return r100.then(new AspectRatioElement(r101, r102, r103));
    L5:
        r103 = InspectableValueKt.getNoInspectorInfo();
        goto L7
    }

    /* JADX INFO: renamed from: isSatisfiedBy-NN6Ew-U, reason: not valid java name */
    public static final boolean m631isSatisfiedByNN6EwU(long r100, int r101, int r102) {
        int r103 = Constraints.m7489getMinWidthimpl(r100);
        if (r101 > Constraints.m7487getMaxWidthimpl(r100)) goto L6;
        if (r103 > r101) goto L6;
        boolean r104 = true;
    L7:
        if (r104 == false) goto L15;
        int r105 = Constraints.m7488getMinHeightimpl(r100);
        if (r102 > Constraints.m7486getMaxHeightimpl(r100)) goto L12;
        if (r105 > r102) goto L12;
        boolean r106 = true;
    L13:
        if (r106 == false) goto L15;
        return true;
    L12:
        r106 = false;
    L15:
        return false;
    L6:
        r104 = false;
        goto L7
    }

    public static /* synthetic */ Modifier aspectRatio$default(Modifier r100, float r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = false;
    L6:
        return aspectRatio(r100, r101, r102);
    }
}
