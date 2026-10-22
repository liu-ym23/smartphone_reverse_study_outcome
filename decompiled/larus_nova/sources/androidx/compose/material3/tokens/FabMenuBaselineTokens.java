package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0017\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0011\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0012\u0010\u0007R\u0013\u0010\u0013\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0014\u0010\u0007R\u0013\u0010\u0015\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0016\u0010\u0007R\u0013\u0010\u0017\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0018\u0010\u0007R\u0013\u0010\u0019\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001a\u0010\u0007R\u0011\u0010\u001b\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0010R\u0013\u0010\u001d\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001e\u0010\u0007R\u0013\u0010\u001f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b \u0010\u0007R\u0013\u0010!\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\"\u0010\u0007R\u0013\u0010#\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b$\u0010\u0007¨\u0006%"}, d2 = {"Landroidx/compose/material3/tokens/FabMenuBaselineTokens;", "", "<init>", "()V", "CloseButtonBetweenSpace", "Landroidx/compose/ui/unit/Dp;", "getCloseButtonBetweenSpace-D9Ej5fM", "()F", FaceService.girlLabel, "CloseButtonContainerElevation", "getCloseButtonContainerElevation-D9Ej5fM", "CloseButtonContainerHeight", "getCloseButtonContainerHeight-D9Ej5fM", "CloseButtonContainerShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getCloseButtonContainerShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "CloseButtonContainerWidth", "getCloseButtonContainerWidth-D9Ej5fM", "CloseButtonIconSize", "getCloseButtonIconSize-D9Ej5fM", "ListItemBetweenSpace", "getListItemBetweenSpace-D9Ej5fM", "ListItemContainerElevation", "getListItemContainerElevation-D9Ej5fM", "ListItemContainerHeight", "getListItemContainerHeight-D9Ej5fM", "ListItemContainerShape", "getListItemContainerShape", "ListItemIconLabelSpace", "getListItemIconLabelSpace-D9Ej5fM", "ListItemIconSize", "getListItemIconSize-D9Ej5fM", "ListItemLeadingSpace", "getListItemLeadingSpace-D9Ej5fM", "ListItemTrailingSpace", "getListItemTrailingSpace-D9Ej5fM", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FabMenuBaselineTokens {
    public static final int $stable = 0;
    private static final float CloseButtonBetweenSpace = 0.0f;
    private static final float CloseButtonContainerElevation = 0.0f;
    private static final float CloseButtonContainerHeight = 0.0f;
    private static final ShapeKeyTokens CloseButtonContainerShape = null;
    private static final float CloseButtonContainerWidth = 0.0f;
    private static final float CloseButtonIconSize = 0.0f;
    public static final FabMenuBaselineTokens INSTANCE = null;
    private static final float ListItemBetweenSpace = 0.0f;
    private static final float ListItemContainerElevation = 0.0f;
    private static final float ListItemContainerHeight = 0.0f;
    private static final ShapeKeyTokens ListItemContainerShape = null;
    private static final float ListItemIconLabelSpace = 0.0f;
    private static final float ListItemIconSize = 0.0f;
    private static final float ListItemLeadingSpace = 0.0f;
    private static final float ListItemTrailingSpace = 0.0f;

    private FabMenuBaselineTokens() {
    }

    static {
        INSTANCE = new FabMenuBaselineTokens();
        float r100 = (float) 8.0d;
        CloseButtonBetweenSpace = Dp.m7544constructorimpl(r100);
        ElevationTokens r101 = ElevationTokens.INSTANCE;
        CloseButtonContainerElevation = r101.m3501getLevel3D9Ej5fM();
        float r102 = (float) 56.0d;
        CloseButtonContainerHeight = Dp.m7544constructorimpl(r102);
        ShapeKeyTokens r103 = ShapeKeyTokens.CornerFull;
        CloseButtonContainerShape = r103;
        CloseButtonContainerWidth = Dp.m7544constructorimpl(r102);
        CloseButtonIconSize = Dp.m7544constructorimpl((float) 20.0d);
        ListItemBetweenSpace = Dp.m7544constructorimpl((float) 4.0d);
        ListItemContainerElevation = r101.m3501getLevel3D9Ej5fM();
        ListItemContainerHeight = Dp.m7544constructorimpl(r102);
        ListItemContainerShape = r103;
        ListItemIconLabelSpace = Dp.m7544constructorimpl(r100);
        float r104 = (float) 24.0d;
        ListItemIconSize = Dp.m7544constructorimpl(r104);
        ListItemLeadingSpace = Dp.m7544constructorimpl(r104);
        ListItemTrailingSpace = Dp.m7544constructorimpl(r104);
    }

    /* JADX INFO: renamed from: getCloseButtonBetweenSpace-D9Ej5fM, reason: not valid java name */
    public final float m3538getCloseButtonBetweenSpaceD9Ej5fM() {
        return CloseButtonBetweenSpace;
    }

    /* JADX INFO: renamed from: getCloseButtonContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m3539getCloseButtonContainerElevationD9Ej5fM() {
        return CloseButtonContainerElevation;
    }

    /* JADX INFO: renamed from: getCloseButtonContainerHeight-D9Ej5fM, reason: not valid java name */
    public final float m3540getCloseButtonContainerHeightD9Ej5fM() {
        return CloseButtonContainerHeight;
    }

    public final ShapeKeyTokens getCloseButtonContainerShape() {
        return CloseButtonContainerShape;
    }

    /* JADX INFO: renamed from: getCloseButtonContainerWidth-D9Ej5fM, reason: not valid java name */
    public final float m3541getCloseButtonContainerWidthD9Ej5fM() {
        return CloseButtonContainerWidth;
    }

    /* JADX INFO: renamed from: getCloseButtonIconSize-D9Ej5fM, reason: not valid java name */
    public final float m3542getCloseButtonIconSizeD9Ej5fM() {
        return CloseButtonIconSize;
    }

    /* JADX INFO: renamed from: getListItemBetweenSpace-D9Ej5fM, reason: not valid java name */
    public final float m3543getListItemBetweenSpaceD9Ej5fM() {
        return ListItemBetweenSpace;
    }

    /* JADX INFO: renamed from: getListItemContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m3544getListItemContainerElevationD9Ej5fM() {
        return ListItemContainerElevation;
    }

    /* JADX INFO: renamed from: getListItemContainerHeight-D9Ej5fM, reason: not valid java name */
    public final float m3545getListItemContainerHeightD9Ej5fM() {
        return ListItemContainerHeight;
    }

    public final ShapeKeyTokens getListItemContainerShape() {
        return ListItemContainerShape;
    }

    /* JADX INFO: renamed from: getListItemIconLabelSpace-D9Ej5fM, reason: not valid java name */
    public final float m3546getListItemIconLabelSpaceD9Ej5fM() {
        return ListItemIconLabelSpace;
    }

    /* JADX INFO: renamed from: getListItemIconSize-D9Ej5fM, reason: not valid java name */
    public final float m3547getListItemIconSizeD9Ej5fM() {
        return ListItemIconSize;
    }

    /* JADX INFO: renamed from: getListItemLeadingSpace-D9Ej5fM, reason: not valid java name */
    public final float m3548getListItemLeadingSpaceD9Ej5fM() {
        return ListItemLeadingSpace;
    }

    /* JADX INFO: renamed from: getListItemTrailingSpace-D9Ej5fM, reason: not valid java name */
    public final float m3549getListItemTrailingSpaceD9Ej5fM() {
        return ListItemTrailingSpace;
    }
}
