package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u000f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007¨\u0006\u0011"}, d2 = {"Landroidx/compose/material3/tokens/AppBarLargeFlexibleTokens;", "", "<init>", "()V", "ContainerHeight", "Landroidx/compose/ui/unit/Dp;", "getContainerHeight-D9Ej5fM", "()F", FaceService.girlLabel, "SubtitleFont", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "getSubtitleFont", "()Landroidx/compose/material3/tokens/TypographyKeyTokens;", "TitleFont", "getTitleFont", "LargeContainerHeight", "getLargeContainerHeight-D9Ej5fM", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AppBarLargeFlexibleTokens {
    public static final int $stable = 0;
    private static final float ContainerHeight = 0.0f;
    public static final AppBarLargeFlexibleTokens INSTANCE = null;
    private static final float LargeContainerHeight = 0.0f;
    private static final TypographyKeyTokens SubtitleFont = null;
    private static final TypographyKeyTokens TitleFont = null;

    private AppBarLargeFlexibleTokens() {
    }

    static {
        INSTANCE = new AppBarLargeFlexibleTokens();
        ContainerHeight = Dp.m7544constructorimpl((float) 120.0d);
        SubtitleFont = TypographyKeyTokens.TitleMedium;
        TitleFont = TypographyKeyTokens.DisplaySmall;
        LargeContainerHeight = Dp.m7544constructorimpl((float) 152.0d);
    }

    /* JADX INFO: renamed from: getContainerHeight-D9Ej5fM, reason: not valid java name */
    public final float m3251getContainerHeightD9Ej5fM() {
        return ContainerHeight;
    }

    /* JADX INFO: renamed from: getLargeContainerHeight-D9Ej5fM, reason: not valid java name */
    public final float m3252getLargeContainerHeightD9Ej5fM() {
        return LargeContainerHeight;
    }

    public final TypographyKeyTokens getSubtitleFont() {
        return SubtitleFont;
    }

    public final TypographyKeyTokens getTitleFont() {
        return TitleFont;
    }
}
