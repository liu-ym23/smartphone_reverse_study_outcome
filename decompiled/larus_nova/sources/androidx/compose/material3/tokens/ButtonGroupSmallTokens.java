package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007¨\u0006\u000b"}, d2 = {"Landroidx/compose/material3/tokens/ButtonGroupSmallTokens;", "", "<init>", "()V", "BetweenSpace", "Landroidx/compose/ui/unit/Dp;", "getBetweenSpace-D9Ej5fM", "()F", FaceService.girlLabel, "ContainerHeight", "getContainerHeight-D9Ej5fM", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ButtonGroupSmallTokens {
    public static final int $stable = 0;
    private static final float BetweenSpace = 0.0f;
    private static final float ContainerHeight = 0.0f;
    public static final ButtonGroupSmallTokens INSTANCE = null;

    private ButtonGroupSmallTokens() {
    }

    static {
        INSTANCE = new ButtonGroupSmallTokens();
        BetweenSpace = Dp.m7544constructorimpl((float) 12.0d);
        ContainerHeight = Dp.m7544constructorimpl((float) 40.0d);
    }

    /* JADX INFO: renamed from: getBetweenSpace-D9Ej5fM, reason: not valid java name */
    public final float m3289getBetweenSpaceD9Ej5fM() {
        return BetweenSpace;
    }

    /* JADX INFO: renamed from: getContainerHeight-D9Ej5fM, reason: not valid java name */
    public final float m3290getContainerHeightD9Ej5fM() {
        return ContainerHeight;
    }
}
