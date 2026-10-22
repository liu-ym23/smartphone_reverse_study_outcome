package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b \n\u0002\u0018\u0002\n\u0002\bC\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\u0011\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0012\u0010\u0007R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000eR\u0014\u0010\u0019\u001a\u00020\u001aX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0007R\u0011\u0010\u001c\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u000eR\u0014\u0010\u001e\u001a\u00020\u001aX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0007R\u0011\u0010 \u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u000eR\u0014\u0010\"\u001a\u00020\u001aX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0007R\u0013\u0010$\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b%\u0010\u0007R\u0011\u0010&\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u000eR\u0011\u0010(\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u000eR\u0011\u0010*\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u000eR\u0011\u0010,\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u000eR\u0011\u0010.\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u000eR\u0011\u00100\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u000eR\u0011\u00102\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u000eR\u0011\u00104\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u000eR\u0011\u00106\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u000eR\u0011\u00108\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u000eR\u0011\u0010:\u001a\u00020;¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0013\u0010>\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b?\u0010\u0007R\u0011\u0010@\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\u000eR\u0011\u0010B\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\bC\u0010\u000eR\u0011\u0010D\u001a\u00020;¢\u0006\b\n\u0000\u001a\u0004\bE\u0010=R\u0011\u0010F\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\bG\u0010\u0016R\u0013\u0010H\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\bI\u0010\u0007R\u0011\u0010J\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\bK\u0010\u000eR\u0013\u0010L\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\bM\u0010\u0007R\u0013\u0010N\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\bO\u0010\u0007R\u0011\u0010P\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010\u0016R\u0013\u0010R\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\bS\u0010\u0007R\u0013\u0010T\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\bU\u0010\u0007R\u0011\u0010V\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\bW\u0010\u0016R\u0013\u0010X\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\bY\u0010\u0007R\u0013\u0010Z\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b[\u0010\u0007R\u0011\u0010\\\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b]\u0010\u000eR\u0011\u0010^\u001a\u00020;¢\u0006\b\n\u0000\u001a\u0004\b_\u0010=R\u0011\u0010`\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\ba\u0010\u000eR\u0011\u0010b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\bc\u0010\u000eR\u0011\u0010d\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\be\u0010\u000eR\u0011\u0010f\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\bg\u0010\u000eR\u0013\u0010h\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\bi\u0010\u0007R\u0011\u0010j\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\bk\u0010\u000eR\u0011\u0010l\u001a\u00020;¢\u0006\b\n\u0000\u001a\u0004\bm\u0010=R\u0013\u0010n\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\bo\u0010\u0007R\u0011\u0010p\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\bq\u0010\u000eR\u0013\u0010r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\bs\u0010\u0007R\u0013\u0010t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\bu\u0010\u0007R\u0011\u0010v\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\bw\u0010\u000eR\u0011\u0010x\u001a\u00020;¢\u0006\b\n\u0000\u001a\u0004\by\u0010=R\u0013\u0010z\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b{\u0010\u0007R\u0011\u0010|\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b}\u0010\u000e¨\u0006~"}, d2 = {"Landroidx/compose/material3/tokens/ListTokens;", "", "<init>", "()V", "DividerLeadingSpace", "Landroidx/compose/ui/unit/Dp;", "getDividerLeadingSpace-D9Ej5fM", "()F", FaceService.girlLabel, "DividerTrailingSpace", "getDividerTrailingSpace-D9Ej5fM", "FocusIndicatorColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getFocusIndicatorColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "ListItemContainerColor", "getListItemContainerColor", "ListItemContainerElevation", "getListItemContainerElevation-D9Ej5fM", "ListItemContainerShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getListItemContainerShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "ListItemDisabledLabelTextColor", "getListItemDisabledLabelTextColor", "ListItemDisabledLabelTextOpacity", "", "getListItemDisabledLabelTextOpacity", "ListItemDisabledLeadingIconColor", "getListItemDisabledLeadingIconColor", "ListItemDisabledLeadingIconOpacity", "getListItemDisabledLeadingIconOpacity", "ListItemDisabledTrailingIconColor", "getListItemDisabledTrailingIconColor", "ListItemDisabledTrailingIconOpacity", "getListItemDisabledTrailingIconOpacity", "ListItemDraggedContainerElevation", "getListItemDraggedContainerElevation-D9Ej5fM", "ListItemDraggedLabelTextColor", "getListItemDraggedLabelTextColor", "ListItemDraggedLeadingIconColor", "getListItemDraggedLeadingIconColor", "ListItemDraggedTrailingIconColor", "getListItemDraggedTrailingIconColor", "ListItemFocusLabelTextColor", "getListItemFocusLabelTextColor", "ListItemFocusLeadingIconColor", "getListItemFocusLeadingIconColor", "ListItemFocusTrailingIconColor", "getListItemFocusTrailingIconColor", "ListItemHoverLabelTextColor", "getListItemHoverLabelTextColor", "ListItemHoverLeadingIconColor", "getListItemHoverLeadingIconColor", "ListItemHoverTrailingIconColor", "getListItemHoverTrailingIconColor", "ListItemLabelTextColor", "getListItemLabelTextColor", "ListItemLabelTextFont", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "getListItemLabelTextFont", "()Landroidx/compose/material3/tokens/TypographyKeyTokens;", "ListItemLargeLeadingVideoHeight", "getListItemLargeLeadingVideoHeight-D9Ej5fM", "ListItemLeadingAvatarColor", "getListItemLeadingAvatarColor", "ListItemLeadingAvatarLabelColor", "getListItemLeadingAvatarLabelColor", "ListItemLeadingAvatarLabelFont", "getListItemLeadingAvatarLabelFont", "ListItemLeadingAvatarShape", "getListItemLeadingAvatarShape", "ListItemLeadingAvatarSize", "getListItemLeadingAvatarSize-D9Ej5fM", "ListItemLeadingIconColor", "getListItemLeadingIconColor", "ListItemLeadingIconSize", "getListItemLeadingIconSize-D9Ej5fM", "ListItemLeadingImageHeight", "getListItemLeadingImageHeight-D9Ej5fM", "ListItemLeadingImageShape", "getListItemLeadingImageShape", "ListItemLeadingImageWidth", "getListItemLeadingImageWidth-D9Ej5fM", "ListItemLeadingSpace", "getListItemLeadingSpace-D9Ej5fM", "ListItemLeadingVideoShape", "getListItemLeadingVideoShape", "ListItemLeadingVideoWidth", "getListItemLeadingVideoWidth-D9Ej5fM", "ListItemOneLineContainerHeight", "getListItemOneLineContainerHeight-D9Ej5fM", "ListItemOverlineColor", "getListItemOverlineColor", "ListItemOverlineFont", "getListItemOverlineFont", "ListItemPressedLabelTextColor", "getListItemPressedLabelTextColor", "ListItemPressedLeadingIconColor", "getListItemPressedLeadingIconColor", "ListItemPressedTrailingIconColor", "getListItemPressedTrailingIconColor", "ListItemSelectedTrailingIconColor", "getListItemSelectedTrailingIconColor", "ListItemSmallLeadingVideoHeight", "getListItemSmallLeadingVideoHeight-D9Ej5fM", "ListItemSupportingTextColor", "getListItemSupportingTextColor", "ListItemSupportingTextFont", "getListItemSupportingTextFont", "ListItemThreeLineContainerHeight", "getListItemThreeLineContainerHeight-D9Ej5fM", "ListItemTrailingIconColor", "getListItemTrailingIconColor", "ListItemTrailingIconSize", "getListItemTrailingIconSize-D9Ej5fM", "ListItemTrailingSpace", "getListItemTrailingSpace-D9Ej5fM", "ListItemTrailingSupportingTextColor", "getListItemTrailingSupportingTextColor", "ListItemTrailingSupportingTextFont", "getListItemTrailingSupportingTextFont", "ListItemTwoLineContainerHeight", "getListItemTwoLineContainerHeight-D9Ej5fM", "ListItemUnselectedTrailingIconColor", "getListItemUnselectedTrailingIconColor", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ListTokens {
    public static final int $stable = 0;
    private static final float DividerLeadingSpace = 0.0f;
    private static final float DividerTrailingSpace = 0.0f;
    private static final ColorSchemeKeyTokens FocusIndicatorColor = null;
    public static final ListTokens INSTANCE = null;
    private static final ColorSchemeKeyTokens ListItemContainerColor = null;
    private static final float ListItemContainerElevation = 0.0f;
    private static final ShapeKeyTokens ListItemContainerShape = null;
    private static final ColorSchemeKeyTokens ListItemDisabledLabelTextColor = null;
    private static final float ListItemDisabledLabelTextOpacity = 0.0f;
    private static final ColorSchemeKeyTokens ListItemDisabledLeadingIconColor = null;
    private static final float ListItemDisabledLeadingIconOpacity = 0.0f;
    private static final ColorSchemeKeyTokens ListItemDisabledTrailingIconColor = null;
    private static final float ListItemDisabledTrailingIconOpacity = 0.0f;
    private static final float ListItemDraggedContainerElevation = 0.0f;
    private static final ColorSchemeKeyTokens ListItemDraggedLabelTextColor = null;
    private static final ColorSchemeKeyTokens ListItemDraggedLeadingIconColor = null;
    private static final ColorSchemeKeyTokens ListItemDraggedTrailingIconColor = null;
    private static final ColorSchemeKeyTokens ListItemFocusLabelTextColor = null;
    private static final ColorSchemeKeyTokens ListItemFocusLeadingIconColor = null;
    private static final ColorSchemeKeyTokens ListItemFocusTrailingIconColor = null;
    private static final ColorSchemeKeyTokens ListItemHoverLabelTextColor = null;
    private static final ColorSchemeKeyTokens ListItemHoverLeadingIconColor = null;
    private static final ColorSchemeKeyTokens ListItemHoverTrailingIconColor = null;
    private static final ColorSchemeKeyTokens ListItemLabelTextColor = null;
    private static final TypographyKeyTokens ListItemLabelTextFont = null;
    private static final float ListItemLargeLeadingVideoHeight = 0.0f;
    private static final ColorSchemeKeyTokens ListItemLeadingAvatarColor = null;
    private static final ColorSchemeKeyTokens ListItemLeadingAvatarLabelColor = null;
    private static final TypographyKeyTokens ListItemLeadingAvatarLabelFont = null;
    private static final ShapeKeyTokens ListItemLeadingAvatarShape = null;
    private static final float ListItemLeadingAvatarSize = 0.0f;
    private static final ColorSchemeKeyTokens ListItemLeadingIconColor = null;
    private static final float ListItemLeadingIconSize = 0.0f;
    private static final float ListItemLeadingImageHeight = 0.0f;
    private static final ShapeKeyTokens ListItemLeadingImageShape = null;
    private static final float ListItemLeadingImageWidth = 0.0f;
    private static final float ListItemLeadingSpace = 0.0f;
    private static final ShapeKeyTokens ListItemLeadingVideoShape = null;
    private static final float ListItemLeadingVideoWidth = 0.0f;
    private static final float ListItemOneLineContainerHeight = 0.0f;
    private static final ColorSchemeKeyTokens ListItemOverlineColor = null;
    private static final TypographyKeyTokens ListItemOverlineFont = null;
    private static final ColorSchemeKeyTokens ListItemPressedLabelTextColor = null;
    private static final ColorSchemeKeyTokens ListItemPressedLeadingIconColor = null;
    private static final ColorSchemeKeyTokens ListItemPressedTrailingIconColor = null;
    private static final ColorSchemeKeyTokens ListItemSelectedTrailingIconColor = null;
    private static final float ListItemSmallLeadingVideoHeight = 0.0f;
    private static final ColorSchemeKeyTokens ListItemSupportingTextColor = null;
    private static final TypographyKeyTokens ListItemSupportingTextFont = null;
    private static final float ListItemThreeLineContainerHeight = 0.0f;
    private static final ColorSchemeKeyTokens ListItemTrailingIconColor = null;
    private static final float ListItemTrailingIconSize = 0.0f;
    private static final float ListItemTrailingSpace = 0.0f;
    private static final ColorSchemeKeyTokens ListItemTrailingSupportingTextColor = null;
    private static final TypographyKeyTokens ListItemTrailingSupportingTextFont = null;
    private static final float ListItemTwoLineContainerHeight = 0.0f;
    private static final ColorSchemeKeyTokens ListItemUnselectedTrailingIconColor = null;

    private ListTokens() {
    }

    static {
        INSTANCE = new ListTokens();
        float r100 = (float) 16.0d;
        DividerLeadingSpace = Dp.m7544constructorimpl(r100);
        DividerTrailingSpace = Dp.m7544constructorimpl(r100);
        FocusIndicatorColor = ColorSchemeKeyTokens.Secondary;
        ListItemContainerColor = ColorSchemeKeyTokens.Surface;
        ElevationTokens r101 = ElevationTokens.INSTANCE;
        ListItemContainerElevation = r101.m3498getLevel0D9Ej5fM();
        ShapeKeyTokens r102 = ShapeKeyTokens.CornerNone;
        ListItemContainerShape = r102;
        ColorSchemeKeyTokens r103 = ColorSchemeKeyTokens.OnSurface;
        ListItemDisabledLabelTextColor = r103;
        ListItemDisabledLabelTextOpacity = 0.38f;
        ListItemDisabledLeadingIconColor = r103;
        ListItemDisabledLeadingIconOpacity = 0.38f;
        ListItemDisabledTrailingIconColor = r103;
        ListItemDisabledTrailingIconOpacity = 0.38f;
        ListItemDraggedContainerElevation = r101.m3502getLevel4D9Ej5fM();
        ListItemDraggedLabelTextColor = r103;
        ColorSchemeKeyTokens r104 = ColorSchemeKeyTokens.OnSurfaceVariant;
        ListItemDraggedLeadingIconColor = r104;
        ListItemDraggedTrailingIconColor = r104;
        ListItemFocusLabelTextColor = r103;
        ListItemFocusLeadingIconColor = r104;
        ListItemFocusTrailingIconColor = r104;
        ListItemHoverLabelTextColor = r103;
        ListItemHoverLeadingIconColor = r104;
        ListItemHoverTrailingIconColor = r104;
        ListItemLabelTextColor = r103;
        ListItemLabelTextFont = TypographyKeyTokens.BodyLarge;
        ListItemLargeLeadingVideoHeight = Dp.m7544constructorimpl((float) 69.0d);
        ListItemLeadingAvatarColor = ColorSchemeKeyTokens.PrimaryContainer;
        ListItemLeadingAvatarLabelColor = ColorSchemeKeyTokens.OnPrimaryContainer;
        ListItemLeadingAvatarLabelFont = TypographyKeyTokens.TitleMedium;
        ListItemLeadingAvatarShape = ShapeKeyTokens.CornerFull;
        ListItemLeadingAvatarSize = Dp.m7544constructorimpl((float) 40.0d);
        ListItemLeadingIconColor = r104;
        float r105 = (float) 24.0d;
        ListItemLeadingIconSize = Dp.m7544constructorimpl(r105);
        float r106 = (float) 56.0d;
        ListItemLeadingImageHeight = Dp.m7544constructorimpl(r106);
        ListItemLeadingImageShape = r102;
        ListItemLeadingImageWidth = Dp.m7544constructorimpl(r106);
        ListItemLeadingSpace = Dp.m7544constructorimpl(r100);
        ListItemLeadingVideoShape = r102;
        ListItemLeadingVideoWidth = Dp.m7544constructorimpl((float) 100.0d);
        ListItemOneLineContainerHeight = Dp.m7544constructorimpl(r106);
        ListItemOverlineColor = r104;
        TypographyKeyTokens r107 = TypographyKeyTokens.LabelSmall;
        ListItemOverlineFont = r107;
        ListItemPressedLabelTextColor = r103;
        ListItemPressedLeadingIconColor = r104;
        ListItemPressedTrailingIconColor = r104;
        ListItemSelectedTrailingIconColor = ColorSchemeKeyTokens.Primary;
        ListItemSmallLeadingVideoHeight = Dp.m7544constructorimpl(r106);
        ListItemSupportingTextColor = r104;
        ListItemSupportingTextFont = TypographyKeyTokens.BodyMedium;
        ListItemThreeLineContainerHeight = Dp.m7544constructorimpl((float) 88.0d);
        ListItemTrailingIconColor = r104;
        ListItemTrailingIconSize = Dp.m7544constructorimpl(r105);
        ListItemTrailingSpace = Dp.m7544constructorimpl(r100);
        ListItemTrailingSupportingTextColor = r104;
        ListItemTrailingSupportingTextFont = r107;
        ListItemTwoLineContainerHeight = Dp.m7544constructorimpl((float) 72.0d);
        ListItemUnselectedTrailingIconColor = r103;
    }

    /* JADX INFO: renamed from: getDividerLeadingSpace-D9Ej5fM, reason: not valid java name */
    public final float m3642getDividerLeadingSpaceD9Ej5fM() {
        return DividerLeadingSpace;
    }

    /* JADX INFO: renamed from: getDividerTrailingSpace-D9Ej5fM, reason: not valid java name */
    public final float m3643getDividerTrailingSpaceD9Ej5fM() {
        return DividerTrailingSpace;
    }

    public final ColorSchemeKeyTokens getFocusIndicatorColor() {
        return FocusIndicatorColor;
    }

    public final ColorSchemeKeyTokens getListItemContainerColor() {
        return ListItemContainerColor;
    }

    /* JADX INFO: renamed from: getListItemContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m3644getListItemContainerElevationD9Ej5fM() {
        return ListItemContainerElevation;
    }

    public final ShapeKeyTokens getListItemContainerShape() {
        return ListItemContainerShape;
    }

    public final ColorSchemeKeyTokens getListItemDisabledLabelTextColor() {
        return ListItemDisabledLabelTextColor;
    }

    public final float getListItemDisabledLabelTextOpacity() {
        return ListItemDisabledLabelTextOpacity;
    }

    public final ColorSchemeKeyTokens getListItemDisabledLeadingIconColor() {
        return ListItemDisabledLeadingIconColor;
    }

    public final float getListItemDisabledLeadingIconOpacity() {
        return ListItemDisabledLeadingIconOpacity;
    }

    public final ColorSchemeKeyTokens getListItemDisabledTrailingIconColor() {
        return ListItemDisabledTrailingIconColor;
    }

    public final float getListItemDisabledTrailingIconOpacity() {
        return ListItemDisabledTrailingIconOpacity;
    }

    /* JADX INFO: renamed from: getListItemDraggedContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m3645getListItemDraggedContainerElevationD9Ej5fM() {
        return ListItemDraggedContainerElevation;
    }

    public final ColorSchemeKeyTokens getListItemDraggedLabelTextColor() {
        return ListItemDraggedLabelTextColor;
    }

    public final ColorSchemeKeyTokens getListItemDraggedLeadingIconColor() {
        return ListItemDraggedLeadingIconColor;
    }

    public final ColorSchemeKeyTokens getListItemDraggedTrailingIconColor() {
        return ListItemDraggedTrailingIconColor;
    }

    public final ColorSchemeKeyTokens getListItemFocusLabelTextColor() {
        return ListItemFocusLabelTextColor;
    }

    public final ColorSchemeKeyTokens getListItemFocusLeadingIconColor() {
        return ListItemFocusLeadingIconColor;
    }

    public final ColorSchemeKeyTokens getListItemFocusTrailingIconColor() {
        return ListItemFocusTrailingIconColor;
    }

    public final ColorSchemeKeyTokens getListItemHoverLabelTextColor() {
        return ListItemHoverLabelTextColor;
    }

    public final ColorSchemeKeyTokens getListItemHoverLeadingIconColor() {
        return ListItemHoverLeadingIconColor;
    }

    public final ColorSchemeKeyTokens getListItemHoverTrailingIconColor() {
        return ListItemHoverTrailingIconColor;
    }

    public final ColorSchemeKeyTokens getListItemLabelTextColor() {
        return ListItemLabelTextColor;
    }

    public final TypographyKeyTokens getListItemLabelTextFont() {
        return ListItemLabelTextFont;
    }

    /* JADX INFO: renamed from: getListItemLargeLeadingVideoHeight-D9Ej5fM, reason: not valid java name */
    public final float m3646getListItemLargeLeadingVideoHeightD9Ej5fM() {
        return ListItemLargeLeadingVideoHeight;
    }

    public final ColorSchemeKeyTokens getListItemLeadingAvatarColor() {
        return ListItemLeadingAvatarColor;
    }

    public final ColorSchemeKeyTokens getListItemLeadingAvatarLabelColor() {
        return ListItemLeadingAvatarLabelColor;
    }

    public final TypographyKeyTokens getListItemLeadingAvatarLabelFont() {
        return ListItemLeadingAvatarLabelFont;
    }

    public final ShapeKeyTokens getListItemLeadingAvatarShape() {
        return ListItemLeadingAvatarShape;
    }

    /* JADX INFO: renamed from: getListItemLeadingAvatarSize-D9Ej5fM, reason: not valid java name */
    public final float m3647getListItemLeadingAvatarSizeD9Ej5fM() {
        return ListItemLeadingAvatarSize;
    }

    public final ColorSchemeKeyTokens getListItemLeadingIconColor() {
        return ListItemLeadingIconColor;
    }

    /* JADX INFO: renamed from: getListItemLeadingIconSize-D9Ej5fM, reason: not valid java name */
    public final float m3648getListItemLeadingIconSizeD9Ej5fM() {
        return ListItemLeadingIconSize;
    }

    /* JADX INFO: renamed from: getListItemLeadingImageHeight-D9Ej5fM, reason: not valid java name */
    public final float m3649getListItemLeadingImageHeightD9Ej5fM() {
        return ListItemLeadingImageHeight;
    }

    public final ShapeKeyTokens getListItemLeadingImageShape() {
        return ListItemLeadingImageShape;
    }

    /* JADX INFO: renamed from: getListItemLeadingImageWidth-D9Ej5fM, reason: not valid java name */
    public final float m3650getListItemLeadingImageWidthD9Ej5fM() {
        return ListItemLeadingImageWidth;
    }

    /* JADX INFO: renamed from: getListItemLeadingSpace-D9Ej5fM, reason: not valid java name */
    public final float m3651getListItemLeadingSpaceD9Ej5fM() {
        return ListItemLeadingSpace;
    }

    public final ShapeKeyTokens getListItemLeadingVideoShape() {
        return ListItemLeadingVideoShape;
    }

    /* JADX INFO: renamed from: getListItemLeadingVideoWidth-D9Ej5fM, reason: not valid java name */
    public final float m3652getListItemLeadingVideoWidthD9Ej5fM() {
        return ListItemLeadingVideoWidth;
    }

    /* JADX INFO: renamed from: getListItemOneLineContainerHeight-D9Ej5fM, reason: not valid java name */
    public final float m3653getListItemOneLineContainerHeightD9Ej5fM() {
        return ListItemOneLineContainerHeight;
    }

    public final ColorSchemeKeyTokens getListItemOverlineColor() {
        return ListItemOverlineColor;
    }

    public final TypographyKeyTokens getListItemOverlineFont() {
        return ListItemOverlineFont;
    }

    public final ColorSchemeKeyTokens getListItemPressedLabelTextColor() {
        return ListItemPressedLabelTextColor;
    }

    public final ColorSchemeKeyTokens getListItemPressedLeadingIconColor() {
        return ListItemPressedLeadingIconColor;
    }

    public final ColorSchemeKeyTokens getListItemPressedTrailingIconColor() {
        return ListItemPressedTrailingIconColor;
    }

    public final ColorSchemeKeyTokens getListItemSelectedTrailingIconColor() {
        return ListItemSelectedTrailingIconColor;
    }

    /* JADX INFO: renamed from: getListItemSmallLeadingVideoHeight-D9Ej5fM, reason: not valid java name */
    public final float m3654getListItemSmallLeadingVideoHeightD9Ej5fM() {
        return ListItemSmallLeadingVideoHeight;
    }

    public final ColorSchemeKeyTokens getListItemSupportingTextColor() {
        return ListItemSupportingTextColor;
    }

    public final TypographyKeyTokens getListItemSupportingTextFont() {
        return ListItemSupportingTextFont;
    }

    /* JADX INFO: renamed from: getListItemThreeLineContainerHeight-D9Ej5fM, reason: not valid java name */
    public final float m3655getListItemThreeLineContainerHeightD9Ej5fM() {
        return ListItemThreeLineContainerHeight;
    }

    public final ColorSchemeKeyTokens getListItemTrailingIconColor() {
        return ListItemTrailingIconColor;
    }

    /* JADX INFO: renamed from: getListItemTrailingIconSize-D9Ej5fM, reason: not valid java name */
    public final float m3656getListItemTrailingIconSizeD9Ej5fM() {
        return ListItemTrailingIconSize;
    }

    /* JADX INFO: renamed from: getListItemTrailingSpace-D9Ej5fM, reason: not valid java name */
    public final float m3657getListItemTrailingSpaceD9Ej5fM() {
        return ListItemTrailingSpace;
    }

    public final ColorSchemeKeyTokens getListItemTrailingSupportingTextColor() {
        return ListItemTrailingSupportingTextColor;
    }

    public final TypographyKeyTokens getListItemTrailingSupportingTextFont() {
        return ListItemTrailingSupportingTextFont;
    }

    /* JADX INFO: renamed from: getListItemTwoLineContainerHeight-D9Ej5fM, reason: not valid java name */
    public final float m3658getListItemTwoLineContainerHeightD9Ej5fM() {
        return ListItemTwoLineContainerHeight;
    }

    public final ColorSchemeKeyTokens getListItemUnselectedTrailingIconColor() {
        return ListItemUnselectedTrailingIconColor;
    }
}
