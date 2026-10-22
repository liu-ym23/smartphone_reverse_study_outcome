package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.Dp;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import kotlin.Metadata;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0017\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0012H\u0000\u001a\u0018\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0012H\u0000\"\u0016\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0005\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0006\u0010\u0003\"\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0019"}, d2 = {"HandleWidth", "Landroidx/compose/ui/unit/Dp;", "getHandleWidth", "()F", FaceService.girlLabel, "HandleHeight", "getHandleHeight", "SelectionHandleInfoKey", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "Landroidx/compose/foundation/text/selection/SelectionHandleInfo;", "getSelectionHandleInfoKey", "()Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "getAdjustedCoordinates", "Landroidx/compose/ui/geometry/Offset;", "position", "getAdjustedCoordinates-k-4lQ0M", "(J)J", "isLeftSelectionHandle", "", "isStartHandle", "direction", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "handlesCrossed", "isHandleLtrDirection", "areHandlesCrossed", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SelectionHandlesKt {
    private static final float HandleHeight = 0.0f;
    private static final float HandleWidth = 0.0f;
    private static final SemanticsPropertyKey<SelectionHandleInfo> SelectionHandleInfoKey = null;

    static {
        float r100 = 25;
        HandleWidth = Dp.m7544constructorimpl(r100);
        HandleHeight = Dp.m7544constructorimpl(r100);
        SelectionHandleInfoKey = new SemanticsPropertyKey("SelectionHandleInfo", null, 2, null);
    }

    public static final float getHandleHeight() {
        return HandleHeight;
    }

    public static final float getHandleWidth() {
        return HandleWidth;
    }

    public static final SemanticsPropertyKey<SelectionHandleInfo> getSelectionHandleInfoKey() {
        return SelectionHandleInfoKey;
    }

    /* JADX INFO: renamed from: getAdjustedCoordinates-k-4lQ0M, reason: not valid java name */
    public static final long m1460getAdjustedCoordinatesk4lQ0M(long r100) {
        float r101 = Float.intBitsToFloat((int) (r100 >> 32));
        float r102 = Float.intBitsToFloat((int) (r100 & BodyPartID.bodyIdMax)) - 1.0f;
        long r103 = Float.floatToRawIntBits(r101);
        return Offset.m4574constructorimpl((((long) Float.floatToRawIntBits(r102)) & BodyPartID.bodyIdMax) | (r103 << 32));
    }

    public static final boolean isHandleLtrDirection(ResolvedTextDirection r100, boolean r101) {
        if (r100 != ResolvedTextDirection.Ltr) goto L6;
        if (r101 == true) goto L6;
    L8:
        return true;
    L6:
        if (r100 != ResolvedTextDirection.Rtl) goto L9;
        if (r101 == true) goto L8;
    L9:
        return false;
    }

    public static final boolean isLeftSelectionHandle(boolean r100, ResolvedTextDirection r101, boolean r102) {
        if (r100 == false) goto L5;
        return isHandleLtrDirection(r101, r102);
    L5:
        if (isHandleLtrDirection(r101, r102) == true) goto L7;
        return true;
    L7:
        return false;
    }
}
