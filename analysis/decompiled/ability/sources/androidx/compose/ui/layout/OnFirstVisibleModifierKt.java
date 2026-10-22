package androidx.compose.ui.layout;

import S7.a;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import com.stepos.policy.sdk.config.PolicySdkConstants;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aA\u0010\n\u001a\u00020\u0000*\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00012\b\b\u0003\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/compose/ui/Modifier;", "", "minDurationMs", "", "minFractionVisible", "Landroidx/compose/ui/layout/LayoutBoundsHolder;", "viewportBounds", "Lkotlin/Function0;", "LC7/r;", "callback", "onFirstVisible", "(Landroidx/compose/ui/Modifier;JFLandroidx/compose/ui/layout/LayoutBoundsHolder;LS7/a;)Landroidx/compose/ui/Modifier;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class OnFirstVisibleModifierKt {
    @Stable
    public static final Modifier onFirstVisible(Modifier modifier, @IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) long j5, @FloatRange(from = 0.0d, to = 1.0d) float f, LayoutBoundsHolder layoutBoundsHolder, a aVar) {
        return modifier.then(new OnFirstVisibleElement(j5, f, layoutBoundsHolder, aVar));
    }

    public static /* synthetic */ Modifier onFirstVisible$default(Modifier modifier, long j5, float f, LayoutBoundsHolder layoutBoundsHolder, a aVar, int i, Object obj) {
        if ((i & 1) != 0) {
            j5 = 0;
        }
        long j6 = j5;
        if ((i & 2) != 0) {
            f = 1.0f;
        }
        float f7 = f;
        if ((i & 4) != 0) {
            layoutBoundsHolder = null;
        }
        return onFirstVisible(modifier, j6, f7, layoutBoundsHolder, aVar);
    }
}
