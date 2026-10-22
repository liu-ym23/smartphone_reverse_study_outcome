package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007¨\u0006\u000f"}, d2 = {"Landroidx/compose/material3/tokens/NavigationBarVerticalItemTokens;", "", "<init>", "()V", "ActiveIndicatorHeight", "Landroidx/compose/ui/unit/Dp;", "getActiveIndicatorHeight-D9Ej5fM", "()F", FaceService.girlLabel, "ActiveIndicatorWidth", "getActiveIndicatorWidth-D9Ej5fM", "ContainerBetweenSpace", "getContainerBetweenSpace-D9Ej5fM", "IconSize", "getIconSize-D9Ej5fM", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class NavigationBarVerticalItemTokens {
    public static final int $stable = 0;
    private static final float ActiveIndicatorHeight = 0.0f;
    private static final float ActiveIndicatorWidth = 0.0f;
    private static final float ContainerBetweenSpace = 0.0f;
    public static final NavigationBarVerticalItemTokens INSTANCE = null;
    private static final float IconSize = 0.0f;

    private NavigationBarVerticalItemTokens() {
    }

    static {
        INSTANCE = new NavigationBarVerticalItemTokens();
        ActiveIndicatorHeight = Dp.m7544constructorimpl((float) 32.0d);
        ActiveIndicatorWidth = Dp.m7544constructorimpl((float) 56.0d);
        ContainerBetweenSpace = Dp.m7544constructorimpl((float) 6.0d);
        IconSize = Dp.m7544constructorimpl((float) 24.0d);
    }

    /* JADX INFO: renamed from: getActiveIndicatorHeight-D9Ej5fM, reason: not valid java name */
    public final float m3681getActiveIndicatorHeightD9Ej5fM() {
        return ActiveIndicatorHeight;
    }

    /* JADX INFO: renamed from: getActiveIndicatorWidth-D9Ej5fM, reason: not valid java name */
    public final float m3682getActiveIndicatorWidthD9Ej5fM() {
        return ActiveIndicatorWidth;
    }

    /* JADX INFO: renamed from: getContainerBetweenSpace-D9Ej5fM, reason: not valid java name */
    public final float m3683getContainerBetweenSpaceD9Ej5fM() {
        return ContainerBetweenSpace;
    }

    /* JADX INFO: renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m3684getIconSizeD9Ej5fM() {
        return IconSize;
    }
}
