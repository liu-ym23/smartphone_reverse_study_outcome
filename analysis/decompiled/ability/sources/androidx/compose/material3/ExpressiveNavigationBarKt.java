package androidx.compose.material3;

import androidx.compose.material3.tokens.ColorSchemeKeyTokens;
import androidx.compose.material3.tokens.ShapeKeyTokens;
import androidx.compose.material3.tokens.TypographyKeyTokens;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\u001aW\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u000bH\u0001ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u009d\u0001\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u00102\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0002\b\u000b2\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u00192\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u001f\u0010#\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 H\u0002¢\u0006\u0004\b#\u0010$\"\u0014\u0010&\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'\"\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010'\"\u0014\u0010)\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010'\"\u0014\u0010*\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010'\"\u0014\u0010,\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-\"\u0014\u0010/\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100\"\u0014\u00102\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103\"\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00103\"\u0014\u00105\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00103\"\u0014\u00106\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00103\"\u0014\u00107\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00103\"\u0014\u00108\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u0010'\"\u001a\u00109\u001a\u00020%8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b9\u0010'\u001a\u0004\b:\u0010;\"\u001a\u0010<\u001a\u00020%8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b<\u0010'\u001a\u0004\b=\u0010;\"\u001a\u0010>\u001a\u00020%8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b>\u0010'\u001a\u0004\b?\u0010;\"\u001a\u0010@\u001a\u00020%8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b@\u0010'\u001a\u0004\bA\u0010;\"\u001a\u0010B\u001a\u00020%8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bB\u0010'\u001a\u0004\bC\u0010;\"\u001a\u0010D\u001a\u00020%8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bD\u0010'\u001a\u0004\bE\u0010;\"\u001a\u0010F\u001a\u00020%8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bF\u0010'\u001a\u0004\bG\u0010;\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006H"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/ui/graphics/Color;", "containerColor", "contentColor", "Landroidx/compose/foundation/layout/WindowInsets;", "windowInsets", "Landroidx/compose/material3/NavigationBarArrangement;", "arrangement", "Lkotlin/Function0;", "LC7/r;", "Landroidx/compose/runtime/Composable;", "content", "ExpressiveNavigationBar-NiJtXQ4", "(Landroidx/compose/ui/Modifier;JJLandroidx/compose/foundation/layout/WindowInsets;ILS7/n;Landroidx/compose/runtime/Composer;II)V", "ExpressiveNavigationBar", "", "selected", "onClick", "icon", "enabled", "label", "badge", "Landroidx/compose/material3/NavigationItemIconPosition;", "iconPosition", "Landroidx/compose/material3/NavigationItemColors;", "colors", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "interactionSource", "ExpressiveNavigationBarItem-pli-t6k", "(ZLS7/a;LS7/n;Landroidx/compose/ui/Modifier;ZLS7/n;LS7/n;ILandroidx/compose/material3/NavigationItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "ExpressiveNavigationBarItem", "", "itemsCount", "barWidth", "calculateCenteredContentHorizontalPadding", "(II)I", "Landroidx/compose/ui/unit/Dp;", "IconSize", "F", "TopIconItemActiveIndicatorWidth", "TopIconItemActiveIndicatorHeight", "StartIconItemActiveIndicatorHeight", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "LabelTextFont", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "ActiveIndicatorShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "ActiveIconColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "ActiveLabelTextColor", "ActiveIndicatorColor", "InactiveIconColor", "InactiveLabelTextColor", "NavigationBarHeight", "TopIconItemVerticalPadding", "getTopIconItemVerticalPadding", "()F", "TopIconIndicatorVerticalPadding", "getTopIconIndicatorVerticalPadding", "TopIconIndicatorHorizontalPadding", "getTopIconIndicatorHorizontalPadding", "StartIconIndicatorVerticalPadding", "getStartIconIndicatorVerticalPadding", "TopIconIndicatorToLabelPadding", "getTopIconIndicatorToLabelPadding", "StartIconIndicatorHorizontalPadding", "getStartIconIndicatorHorizontalPadding", "StartIconToLabelPadding", "getStartIconToLabelPadding", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ExpressiveNavigationBarKt {
    private static final ColorSchemeKeyTokens ActiveIconColor;
    private static final ColorSchemeKeyTokens ActiveIndicatorColor;
    private static final ShapeKeyTokens ActiveIndicatorShape;
    private static final ColorSchemeKeyTokens ActiveLabelTextColor;
    private static final float IconSize;
    private static final ColorSchemeKeyTokens InactiveIconColor;
    private static final ColorSchemeKeyTokens InactiveLabelTextColor;
    private static final TypographyKeyTokens LabelTextFont;
    private static final float NavigationBarHeight;
    private static final float StartIconIndicatorHorizontalPadding;
    private static final float StartIconIndicatorVerticalPadding;
    private static final float StartIconItemActiveIndicatorHeight;
    private static final float StartIconToLabelPadding;
    private static final float TopIconIndicatorHorizontalPadding;
    private static final float TopIconIndicatorToLabelPadding;
    private static final float TopIconIndicatorVerticalPadding;
    private static final float TopIconItemActiveIndicatorHeight;
    private static final float TopIconItemActiveIndicatorWidth;
    private static final float TopIconItemVerticalPadding;

    static {
        float fM6844constructorimpl = Dp.m6844constructorimpl((float) 24.0d);
        IconSize = fM6844constructorimpl;
        float fM6844constructorimpl2 = Dp.m6844constructorimpl(56);
        TopIconItemActiveIndicatorWidth = fM6844constructorimpl2;
        float fM6844constructorimpl3 = Dp.m6844constructorimpl(32);
        TopIconItemActiveIndicatorHeight = fM6844constructorimpl3;
        float fM6844constructorimpl4 = Dp.m6844constructorimpl(40);
        StartIconItemActiveIndicatorHeight = fM6844constructorimpl4;
        LabelTextFont = TypographyKeyTokens.LabelMedium;
        ActiveIndicatorShape = ShapeKeyTokens.CornerFull;
        ColorSchemeKeyTokens colorSchemeKeyTokens = ColorSchemeKeyTokens.Secondary;
        ActiveIconColor = colorSchemeKeyTokens;
        ActiveLabelTextColor = colorSchemeKeyTokens;
        ActiveIndicatorColor = ColorSchemeKeyTokens.SecondaryContainer;
        ColorSchemeKeyTokens colorSchemeKeyTokens2 = ColorSchemeKeyTokens.OnSurfaceVariant;
        InactiveIconColor = colorSchemeKeyTokens2;
        InactiveLabelTextColor = colorSchemeKeyTokens2;
        NavigationBarHeight = Dp.m6844constructorimpl(64);
        TopIconItemVerticalPadding = Dp.m6844constructorimpl(6);
        float f = 2;
        TopIconIndicatorVerticalPadding = Dp.m6844constructorimpl(Dp.m6844constructorimpl(fM6844constructorimpl3 - fM6844constructorimpl) / f);
        TopIconIndicatorHorizontalPadding = Dp.m6844constructorimpl(Dp.m6844constructorimpl(fM6844constructorimpl2 - fM6844constructorimpl) / f);
        StartIconIndicatorVerticalPadding = Dp.m6844constructorimpl(Dp.m6844constructorimpl(fM6844constructorimpl4 - fM6844constructorimpl) / f);
        float f7 = 4;
        TopIconIndicatorToLabelPadding = Dp.m6844constructorimpl(f7);
        StartIconIndicatorHorizontalPadding = Dp.m6844constructorimpl(16);
        StartIconToLabelPadding = Dp.m6844constructorimpl(f7);
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0170  */
    @androidx.compose.runtime.Composable
    @androidx.compose.material3.ExperimentalMaterial3Api
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* renamed from: ExpressiveNavigationBar-NiJtXQ4, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1854ExpressiveNavigationBarNiJtXQ4(androidx.compose.ui.Modifier r23, long r24, long r26, androidx.compose.foundation.layout.WindowInsets r28, int r29, final S7.n r30, androidx.compose.runtime.Composer r31, final int r32, final int r33) {
        /*
            Method dump skipped, instructions count: 393
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ExpressiveNavigationBarKt.m1854ExpressiveNavigationBarNiJtXQ4(androidx.compose.ui.Modifier, long, long, androidx.compose.foundation.layout.WindowInsets, int, S7.n, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:173:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0109  */
    @androidx.compose.runtime.Composable
    @androidx.compose.material3.ExperimentalMaterial3Api
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* renamed from: ExpressiveNavigationBarItem-pli-t6k, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1855ExpressiveNavigationBarItemplit6k(final boolean r34, final S7.a r35, final S7.n r36, androidx.compose.ui.Modifier r37, boolean r38, S7.n r39, S7.n r40, int r41, androidx.compose.material3.NavigationItemColors r42, androidx.compose.foundation.interaction.MutableInteractionSource r43, androidx.compose.runtime.Composer r44, final int r45, final int r46) {
        /*
            Method dump skipped, instructions count: 646
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ExpressiveNavigationBarKt.m1855ExpressiveNavigationBarItemplit6k(boolean, S7.a, S7.n, androidx.compose.ui.Modifier, boolean, S7.n, S7.n, int, androidx.compose.material3.NavigationItemColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int calculateCenteredContentHorizontalPadding(int i, int i6) {
        if (i > 6) {
            return 0;
        }
        return U7.a.U((((100 - ((i + 3) * 10)) / 2.0f) / 100) * i6);
    }

    public static final float getStartIconIndicatorHorizontalPadding() {
        return StartIconIndicatorHorizontalPadding;
    }

    public static final float getStartIconIndicatorVerticalPadding() {
        return StartIconIndicatorVerticalPadding;
    }

    public static final float getStartIconToLabelPadding() {
        return StartIconToLabelPadding;
    }

    public static final float getTopIconIndicatorHorizontalPadding() {
        return TopIconIndicatorHorizontalPadding;
    }

    public static final float getTopIconIndicatorToLabelPadding() {
        return TopIconIndicatorToLabelPadding;
    }

    public static final float getTopIconIndicatorVerticalPadding() {
        return TopIconIndicatorVerticalPadding;
    }

    public static final float getTopIconItemVerticalPadding() {
        return TopIconItemVerticalPadding;
    }
}
