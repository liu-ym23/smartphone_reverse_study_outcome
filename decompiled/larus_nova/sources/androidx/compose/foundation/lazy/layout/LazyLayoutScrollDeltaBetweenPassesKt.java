package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.unit.Dp;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"DeltaThresholdForScrollAnimation", "Landroidx/compose/ui/unit/Dp;", FaceService.girlLabel, "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LazyLayoutScrollDeltaBetweenPassesKt {
    private static final float DeltaThresholdForScrollAnimation = 0.0f;

    static {
        DeltaThresholdForScrollAnimation = Dp.m7544constructorimpl(1);
    }

    public static final /* synthetic */ float access$getDeltaThresholdForScrollAnimation$p() {
        return DeltaThresholdForScrollAnimation;
    }
}
