package androidx.compose.material3;

import C7.r;
import S7.n;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.material3.tokens.NavigationRailTokens;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\u001ap\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\u001b\b\u0002\u0010\t\u001a\u0015\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\b\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\bH\u0007ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u0083\u0001\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u00122\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00070\u0012¢\u0006\u0002\b\b2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0015\u001a\u00020\u00102\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0012¢\u0006\u0002\b\b2\b\b\u0002\u0010\u0017\u001a\u00020\u00102\b\b\u0002\u0010\u0019\u001a\u00020\u00182\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0007¢\u0006\u0004\b\u001c\u0010\u001d\u001as\u0010\"\u001a\u00020\u00072\u0011\u0010\u001e\u001a\r\u0012\u0004\u0012\u00020\u00070\u0012¢\u0006\u0002\b\b2\u0011\u0010\u001f\u001a\r\u0012\u0004\u0012\u00020\u00070\u0012¢\u0006\u0002\b\b2\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00070\u0012¢\u0006\u0002\b\b2\u0013\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0012¢\u0006\u0002\b\b2\u0006\u0010\u0017\u001a\u00020\u00102\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u0012H\u0003¢\u0006\u0004\b\"\u0010#\u001a8\u0010.\u001a\u00020+*\u00020$2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020%2\b\u0010(\u001a\u0004\u0018\u00010%2\u0006\u0010*\u001a\u00020)H\u0002ø\u0001\u0000¢\u0006\u0004\b,\u0010-\u001aP\u00102\u001a\u00020+*\u00020$2\u0006\u0010/\u001a\u00020%2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020%2\b\u0010(\u001a\u0004\u0018\u00010%2\u0006\u0010*\u001a\u00020)2\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010!\u001a\u00020 H\u0002ø\u0001\u0000¢\u0006\u0004\b0\u00101\"\u0014\u00104\u001a\u0002038\u0002X\u0082T¢\u0006\u0006\n\u0004\b4\u00105\"\u0014\u00106\u001a\u0002038\u0002X\u0082T¢\u0006\u0006\n\u0004\b6\u00105\"\u0014\u00107\u001a\u0002038\u0002X\u0082T¢\u0006\u0006\n\u0004\b7\u00105\"\u0014\u00108\u001a\u0002038\u0002X\u0082T¢\u0006\u0006\n\u0004\b8\u00105\"\u001a\u0010:\u001a\u0002098\u0000X\u0080\u0004¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0014\u0010>\u001a\u0002098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010;\"\u0014\u0010@\u001a\u00020?8\u0002X\u0082T¢\u0006\u0006\n\u0004\b@\u0010A\"\u001a\u0010B\u001a\u0002098\u0000X\u0080\u0004¢\u0006\f\n\u0004\bB\u0010;\u001a\u0004\bC\u0010=\"\u001a\u0010D\u001a\u0002098\u0000X\u0080\u0004¢\u0006\f\n\u0004\bD\u0010;\u001a\u0004\bE\u0010=\"\u001a\u0010F\u001a\u0002098\u0000X\u0080\u0004¢\u0006\f\n\u0004\bF\u0010;\u001a\u0004\bG\u0010=\"\u0014\u0010H\u001a\u0002098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010;\"\u0014\u0010I\u001a\u0002098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010;\"\u0014\u0010J\u001a\u0002098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010;\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006M²\u0006\f\u0010K\u001a\u00020\u00028\nX\u008a\u0084\u0002²\u0006\f\u0010L\u001a\u00020\u00028\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/ui/graphics/Color;", "containerColor", "contentColor", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "LC7/r;", "Landroidx/compose/runtime/Composable;", "header", "Landroidx/compose/foundation/layout/WindowInsets;", "windowInsets", "content", "NavigationRail-qi6gXK8", "(Landroidx/compose/ui/Modifier;JJLS7/o;Landroidx/compose/foundation/layout/WindowInsets;LS7/o;Landroidx/compose/runtime/Composer;II)V", "NavigationRail", "", "selected", "Lkotlin/Function0;", "onClick", NavigationRailKt.IconLayoutIdTag, "enabled", NavigationRailKt.LabelLayoutIdTag, "alwaysShowLabel", "Landroidx/compose/material3/NavigationRailItemColors;", "colors", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "interactionSource", "NavigationRailItem", "(ZLS7/a;LS7/n;Landroidx/compose/ui/Modifier;ZLS7/n;ZLandroidx/compose/material3/NavigationRailItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", NavigationRailKt.IndicatorRippleLayoutIdTag, NavigationRailKt.IndicatorLayoutIdTag, "", "animationProgress", "NavigationRailItemLayout", "(LS7/n;LS7/n;LS7/n;LS7/n;ZLS7/a;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Placeable;", "iconPlaceable", "indicatorRipplePlaceable", "indicatorPlaceable", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/layout/MeasureResult;", "placeIcon-X9ElhV4", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;J)Landroidx/compose/ui/layout/MeasureResult;", "placeIcon", "labelPlaceable", "placeLabelAndIcon-zUg2_y0", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JZF)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndIcon", "", "IndicatorRippleLayoutIdTag", "Ljava/lang/String;", "IndicatorLayoutIdTag", "IconLayoutIdTag", "LabelLayoutIdTag", "Landroidx/compose/ui/unit/Dp;", "NavigationRailVerticalPadding", "F", "getNavigationRailVerticalPadding", "()F", "NavigationRailHeaderPadding", "", "ItemAnimationDurationMillis", "I", "NavigationRailItemWidth", "getNavigationRailItemWidth", "NavigationRailItemHeight", "getNavigationRailItemHeight", "NavigationRailItemVerticalPadding", "getNavigationRailItemVerticalPadding", "IndicatorHorizontalPadding", "IndicatorVerticalPaddingWithLabel", "IndicatorVerticalPaddingNoLabel", "iconColor", "textColor", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class NavigationRailKt {
    private static final String IconLayoutIdTag = "icon";
    private static final float IndicatorHorizontalPadding;
    private static final String IndicatorLayoutIdTag = "indicator";
    private static final String IndicatorRippleLayoutIdTag = "indicatorRipple";
    private static final float IndicatorVerticalPaddingNoLabel;
    private static final float IndicatorVerticalPaddingWithLabel;
    private static final int ItemAnimationDurationMillis = 150;
    private static final String LabelLayoutIdTag = "label";
    private static final float NavigationRailHeaderPadding = Dp.m6844constructorimpl(8);
    private static final float NavigationRailItemHeight;
    private static final float NavigationRailItemVerticalPadding;
    private static final float NavigationRailItemWidth;
    private static final float NavigationRailVerticalPadding;

    static {
        float f = 4;
        NavigationRailVerticalPadding = Dp.m6844constructorimpl(f);
        NavigationRailTokens navigationRailTokens = NavigationRailTokens.INSTANCE;
        NavigationRailItemWidth = navigationRailTokens.m3109getContainerWidthD9Ej5fM();
        NavigationRailItemHeight = navigationRailTokens.m3112getNoLabelActiveIndicatorHeightD9Ej5fM();
        NavigationRailItemVerticalPadding = Dp.m6844constructorimpl(f);
        float f7 = 2;
        IndicatorHorizontalPadding = Dp.m6844constructorimpl(Dp.m6844constructorimpl(navigationRailTokens.m3107getActiveIndicatorWidthD9Ej5fM() - navigationRailTokens.m3110getIconSizeD9Ej5fM()) / f7);
        IndicatorVerticalPaddingWithLabel = Dp.m6844constructorimpl(Dp.m6844constructorimpl(navigationRailTokens.m3106getActiveIndicatorHeightD9Ej5fM() - navigationRailTokens.m3110getIconSizeD9Ej5fM()) / f7);
        IndicatorVerticalPaddingNoLabel = Dp.m6844constructorimpl(Dp.m6844constructorimpl(navigationRailTokens.m3112getNoLabelActiveIndicatorHeightD9Ej5fM() - navigationRailTokens.m3110getIconSizeD9Ej5fM()) / f7);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:115:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0118  */
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* renamed from: NavigationRail-qi6gXK8, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2100NavigationRailqi6gXK8(androidx.compose.ui.Modifier r23, long r24, long r26, S7.o r28, androidx.compose.foundation.layout.WindowInsets r29, final S7.o r30, androidx.compose.runtime.Composer r31, final int r32, final int r33) {
        /*
            Method dump skipped, instructions count: 389
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationRailKt.m2100NavigationRailqi6gXK8(androidx.compose.ui.Modifier, long, long, S7.o, androidx.compose.foundation.layout.WindowInsets, S7.o, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x035c  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x036d  */
    /* JADX WARN: Removed duplicated region for block: B:185:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00f6  */
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void NavigationRailItem(final boolean r23, final S7.a r24, final S7.n r25, androidx.compose.ui.Modifier r26, boolean r27, S7.n r28, boolean r29, androidx.compose.material3.NavigationRailItemColors r30, androidx.compose.foundation.interaction.MutableInteractionSource r31, androidx.compose.runtime.Composer r32, final int r33, final int r34) {
        /*
            Method dump skipped, instructions count: 896
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationRailKt.NavigationRailItem(boolean, S7.a, S7.n, androidx.compose.ui.Modifier, boolean, S7.n, boolean, androidx.compose.material3.NavigationRailItemColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void NavigationRailItemLayout(final n nVar, final n nVar2, final n nVar3, n nVar4, final boolean z10, final S7.a aVar, Composer composer, final int i) {
        int i6;
        final n nVar5 = nVar4;
        Composer composerStartRestartGroup = composer.startRestartGroup(1498399348);
        if ((i & 6) == 0) {
            i6 = (composerStartRestartGroup.changedInstance(nVar) ? 4 : 2) | i;
        } else {
            i6 = i;
        }
        if ((i & 48) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(nVar2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(nVar3) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(nVar5) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i6 |= composerStartRestartGroup.changed(z10) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(aVar) ? 131072 : 65536;
        }
        if ((74899 & i6) == 74898 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1498399348, i6, -1, "androidx.compose.material3.NavigationRailItemLayout (NavigationRail.kt:514)");
            }
            int i10 = 458752 & i6;
            int i11 = 57344 & i6;
            boolean z11 = ((i6 & 7168) == 2048) | (i10 == 131072) | (i11 == 16384);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z11 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new MeasurePolicy() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItemLayout$2$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* renamed from: measure-3p2s80s */
                    public final MeasureResult mo37measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j5) {
                        Measurable measurable;
                        Placeable placeableMo5549measureBRTryo0;
                        MeasureScope measureScope2 = measureScope;
                        float fFloatValue = ((Number) aVar.invoke()).floatValue();
                        long jM6787copyZbe2FdA$default = Constraints.m6787copyZbe2FdA$default(j5, 0, 0, 0, 0, 10, null);
                        int size = list.size();
                        int i12 = 0;
                        while (i12 < size) {
                            Measurable measurable2 = list.get(i12);
                            if (k.b(LayoutIdKt.getLayoutId(measurable2), "icon")) {
                                Placeable placeableMo5549measureBRTryo02 = measurable2.mo5549measureBRTryo0(jM6787copyZbe2FdA$default);
                                float f = 2;
                                int iMo375roundToPx0680j_4 = measureScope2.mo375roundToPx0680j_4(Dp.m6844constructorimpl(NavigationRailKt.IndicatorHorizontalPadding * f)) + placeableMo5549measureBRTryo02.getWidth();
                                int iU = U7.a.U(iMo375roundToPx0680j_4 * fFloatValue);
                                int iMo375roundToPx0680j_42 = measureScope2.mo375roundToPx0680j_4(Dp.m6844constructorimpl((nVar5 == null ? NavigationRailKt.IndicatorVerticalPaddingNoLabel : NavigationRailKt.IndicatorVerticalPaddingWithLabel) * f)) + placeableMo5549measureBRTryo02.getHeight();
                                int size2 = list.size();
                                int i13 = 0;
                                while (i13 < size2) {
                                    Measurable measurable3 = list.get(i13);
                                    if (k.b(LayoutIdKt.getLayoutId(measurable3), "indicatorRipple")) {
                                        Placeable placeableMo5549measureBRTryo03 = measurable3.mo5549measureBRTryo0(Constraints.INSTANCE.m6807fixedJhjzzOo(iMo375roundToPx0680j_4, iMo375roundToPx0680j_42));
                                        int size3 = list.size();
                                        int i14 = 0;
                                        while (true) {
                                            if (i14 >= size3) {
                                                measurable = null;
                                                break;
                                            }
                                            measurable = list.get(i14);
                                            if (k.b(LayoutIdKt.getLayoutId(measurable), "indicator")) {
                                                break;
                                            }
                                            i14++;
                                        }
                                        Measurable measurable4 = measurable;
                                        Placeable placeableMo5549measureBRTryo04 = measurable4 != null ? measurable4.mo5549measureBRTryo0(Constraints.INSTANCE.m6807fixedJhjzzOo(iU, iMo375roundToPx0680j_42)) : null;
                                        if (nVar5 != null) {
                                            int size4 = list.size();
                                            for (int i15 = 0; i15 < size4; i15++) {
                                                Measurable measurable5 = list.get(i15);
                                                if (k.b(LayoutIdKt.getLayoutId(measurable5), "label")) {
                                                    placeableMo5549measureBRTryo0 = measurable5.mo5549measureBRTryo0(jM6787copyZbe2FdA$default);
                                                }
                                            }
                                            throw new NoSuchElementException("Collection contains no element matching the predicate.");
                                        }
                                        placeableMo5549measureBRTryo0 = null;
                                        if (nVar5 == null) {
                                            return NavigationRailKt.m2103placeIconX9ElhV4(measureScope2, placeableMo5549measureBRTryo02, placeableMo5549measureBRTryo03, placeableMo5549measureBRTryo04, j5);
                                        }
                                        k.c(placeableMo5549measureBRTryo0);
                                        return NavigationRailKt.m2104placeLabelAndIconzUg2_y0(measureScope, placeableMo5549measureBRTryo0, placeableMo5549measureBRTryo02, placeableMo5549measureBRTryo03, placeableMo5549measureBRTryo04, j5, z10, fFloatValue);
                                    }
                                    i13++;
                                    measureScope2 = measureScope;
                                }
                                throw new NoSuchElementException("Collection contains no element matching the predicate.");
                            }
                            i12++;
                            measureScope2 = measureScope;
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue;
            Modifier.Companion companion = Modifier.INSTANCE;
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            int i12 = i6;
            S7.a constructor = companion2.getConstructor();
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM3474constructorimpl = Updater.m3474constructorimpl(composerStartRestartGroup);
            n nVarG = androidx.appfunctions.metadata.a.g(companion2, composerM3474constructorimpl, measurePolicy, composerM3474constructorimpl, currentCompositionLocalMap);
            if (composerM3474constructorimpl.getInserting() || !k.b(composerM3474constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                androidx.appfunctions.metadata.a.z(nVarG, currentCompositeKeyHash, composerM3474constructorimpl, currentCompositeKeyHash);
            }
            Updater.m3481setimpl(composerM3474constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            nVar.invoke(composerStartRestartGroup, Integer.valueOf(i12 & 14));
            nVar2.invoke(composerStartRestartGroup, Integer.valueOf((i12 >> 3) & 14));
            Modifier modifierLayoutId = LayoutIdKt.layoutId(companion, IconLayoutIdTag);
            Alignment.Companion companion3 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierLayoutId);
            S7.a constructor2 = companion2.getConstructor();
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM3474constructorimpl2 = Updater.m3474constructorimpl(composerStartRestartGroup);
            n nVarG2 = androidx.appfunctions.metadata.a.g(companion2, composerM3474constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, composerM3474constructorimpl2, currentCompositionLocalMap2);
            if (composerM3474constructorimpl2.getInserting() || !k.b(composerM3474constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                androidx.appfunctions.metadata.a.z(nVarG2, currentCompositeKeyHash2, composerM3474constructorimpl2, currentCompositeKeyHash2);
            }
            Updater.m3481setimpl(composerM3474constructorimpl2, modifierMaterializeModifier2, companion2.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            nVar3.invoke(composerStartRestartGroup, Integer.valueOf((i12 >> 6) & 14));
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.startReplaceGroup(2145400941);
            if (nVar4 != null) {
                Modifier modifierLayoutId2 = LayoutIdKt.layoutId(companion, LabelLayoutIdTag);
                boolean z12 = (i11 == 16384) | (i10 == 131072);
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z12 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new S7.k() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItemLayout$1$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // S7.k
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((GraphicsLayerScope) obj);
                            return r.f317a;
                        }

                        public final void invoke(GraphicsLayerScope graphicsLayerScope) {
                            graphicsLayerScope.setAlpha(z10 ? 1.0f : ((Number) aVar.invoke()).floatValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                Modifier modifierGraphicsLayer = GraphicsLayerModifierKt.graphicsLayer(modifierLayoutId2, (S7.k) objRememberedValue2);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierGraphicsLayer);
                S7.a constructor3 = companion2.getConstructor();
                if (composerStartRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor3);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM3474constructorimpl3 = Updater.m3474constructorimpl(composerStartRestartGroup);
                n nVarG3 = androidx.appfunctions.metadata.a.g(companion2, composerM3474constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy2, composerM3474constructorimpl3, currentCompositionLocalMap3);
                if (composerM3474constructorimpl3.getInserting() || !k.b(composerM3474constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    androidx.appfunctions.metadata.a.z(nVarG3, currentCompositeKeyHash3, composerM3474constructorimpl3, currentCompositeKeyHash3);
                }
                Updater.m3481setimpl(composerM3474constructorimpl3, modifierMaterializeModifier3, companion2.getSetModifier());
                nVar5 = nVar4;
                androidx.compose.foundation.b.A(nVar5, composerStartRestartGroup, (i12 >> 9) & 14);
            } else {
                nVar5 = nVar4;
            }
            if (androidx.appfunctions.metadata.a.D(composerStartRestartGroup)) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.material3.NavigationRailKt.NavigationRailItemLayout.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                public final void invoke(Composer composer2, int i13) {
                    NavigationRailKt.NavigationRailItemLayout(nVar, nVar2, nVar3, nVar5, z10, aVar, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final float getNavigationRailItemHeight() {
        return NavigationRailItemHeight;
    }

    public static final float getNavigationRailItemVerticalPadding() {
        return NavigationRailItemVerticalPadding;
    }

    public static final float getNavigationRailItemWidth() {
        return NavigationRailItemWidth;
    }

    public static final float getNavigationRailVerticalPadding() {
        return NavigationRailVerticalPadding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: placeIcon-X9ElhV4, reason: not valid java name */
    public static final MeasureResult m2103placeIconX9ElhV4(MeasureScope measureScope, final Placeable placeable, final Placeable placeable2, final Placeable placeable3, long j5) {
        final int iM6814constrainWidthK40F9xA = ConstraintsKt.m6814constrainWidthK40F9xA(j5, Math.max(placeable.getWidth(), Math.max(placeable2.getWidth(), placeable3 != null ? placeable3.getWidth() : 0)));
        final int iM6813constrainHeightK40F9xA = ConstraintsKt.m6813constrainHeightK40F9xA(j5, measureScope.mo375roundToPx0680j_4(NavigationRailItemHeight));
        final int iD = androidx.compose.foundation.b.D(placeable, iM6814constrainWidthK40F9xA, 2);
        final int iF = androidx.compose.foundation.b.f(placeable, iM6813constrainHeightK40F9xA, 2);
        final int iD2 = androidx.compose.foundation.b.D(placeable2, iM6814constrainWidthK40F9xA, 2);
        final int iF2 = androidx.compose.foundation.b.f(placeable2, iM6813constrainHeightK40F9xA, 2);
        return MeasureScope.layout$default(measureScope, iM6814constrainWidthK40F9xA, iM6813constrainHeightK40F9xA, null, new S7.k() { // from class: androidx.compose.material3.NavigationRailKt$placeIcon$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return r.f317a;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope placementScope2;
                Placeable placeable4 = placeable3;
                if (placeable4 != null) {
                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, androidx.compose.foundation.b.D(placeable4, iM6814constrainWidthK40F9xA, 2), androidx.compose.foundation.b.f(placeable4, iM6813constrainHeightK40F9xA, 2), 0.0f, 4, null);
                    placementScope2 = placementScope;
                } else {
                    placementScope2 = placementScope;
                }
                Placeable.PlacementScope.placeRelative$default(placementScope2, placeable, iD, iF, 0.0f, 4, null);
                Placeable.PlacementScope.placeRelative$default(placementScope2, placeable2, iD2, iF2, 0.0f, 4, null);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: placeLabelAndIcon-zUg2_y0, reason: not valid java name */
    public static final MeasureResult m2104placeLabelAndIconzUg2_y0(final MeasureScope measureScope, final Placeable placeable, final Placeable placeable2, final Placeable placeable3, final Placeable placeable4, long j5, final boolean z10, final float f) {
        float height = placeable2.getHeight();
        float f7 = IndicatorVerticalPaddingWithLabel;
        float fMo381toPx0680j_4 = measureScope.mo381toPx0680j_4(f7) + height;
        float f9 = NavigationRailItemVerticalPadding;
        float fMo381toPx0680j_42 = measureScope.mo381toPx0680j_4(f9) + fMo381toPx0680j_4 + placeable.getHeight();
        float f10 = 2;
        float fM6798getMinHeightimpl = (Constraints.m6798getMinHeightimpl(j5) - fMo381toPx0680j_42) / f10;
        float fMo381toPx0680j_43 = measureScope.mo381toPx0680j_4(f7);
        final float f11 = fM6798getMinHeightimpl < fMo381toPx0680j_43 ? fMo381toPx0680j_43 : fM6798getMinHeightimpl;
        float f12 = (f11 * f10) + fMo381toPx0680j_42;
        final float height2 = (1 - f) * ((z10 ? f11 : (f12 - placeable2.getHeight()) / f10) - f11);
        final float fMo381toPx0680j_44 = measureScope.mo381toPx0680j_4(f9) + measureScope.mo381toPx0680j_4(f7) + placeable2.getHeight() + f11;
        final int iM6814constrainWidthK40F9xA = ConstraintsKt.m6814constrainWidthK40F9xA(j5, Math.max(placeable2.getWidth(), Math.max(placeable.getWidth(), placeable4 != null ? placeable4.getWidth() : 0)));
        final int iD = androidx.compose.foundation.b.D(placeable, iM6814constrainWidthK40F9xA, 2);
        final int iD2 = androidx.compose.foundation.b.D(placeable2, iM6814constrainWidthK40F9xA, 2);
        final int iD3 = androidx.compose.foundation.b.D(placeable3, iM6814constrainWidthK40F9xA, 2);
        final float fMo381toPx0680j_45 = f11 - measureScope.mo381toPx0680j_4(f7);
        return MeasureScope.layout$default(measureScope, iM6814constrainWidthK40F9xA, U7.a.U(f12), null, new S7.k() { // from class: androidx.compose.material3.NavigationRailKt$placeLabelAndIcon$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return r.f317a;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope placementScope2;
                Placeable placeable5 = placeable4;
                if (placeable5 != null) {
                    int i = iM6814constrainWidthK40F9xA;
                    float f13 = f11;
                    MeasureScope measureScope2 = measureScope;
                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable5, androidx.compose.foundation.b.D(placeable5, i, 2), U7.a.U((f13 - measureScope2.mo381toPx0680j_4(NavigationRailKt.IndicatorVerticalPaddingWithLabel)) + height2), 0.0f, 4, null);
                    placementScope2 = placementScope;
                } else {
                    placementScope2 = placementScope;
                }
                if (z10 || f != 0.0f) {
                    Placeable.PlacementScope.placeRelative$default(placementScope2, placeable, iD, U7.a.U(fMo381toPx0680j_44 + height2), 0.0f, 4, null);
                }
                Placeable.PlacementScope.placeRelative$default(placementScope2, placeable2, iD2, U7.a.U(f11 + height2), 0.0f, 4, null);
                Placeable.PlacementScope.placeRelative$default(placementScope2, placeable3, iD3, U7.a.U(fMo381toPx0680j_45 + height2), 0.0f, 4, null);
            }
        }, 4, null);
    }
}
