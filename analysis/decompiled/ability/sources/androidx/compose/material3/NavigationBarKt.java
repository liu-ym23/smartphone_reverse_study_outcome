package androidx.compose.material3;

import C7.r;
import S7.n;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material3.tokens.NavigationBarTokens;
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

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000f\u001a]\u0010\u0010\u001a\u00020\u000b2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\b\fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0087\u0001\u0010\u001d\u001a\u00020\u000b*\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00132\u0011\u0010\u0015\u001a\r\u0012\u0004\u0012\u00020\u000b0\u0013¢\u0006\u0002\b\f2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0016\u001a\u00020\u00112\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0013¢\u0006\u0002\b\f2\b\b\u0002\u0010\u0018\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u00192\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0007¢\u0006\u0004\b\u001d\u0010\u001e\u001as\u0010#\u001a\u00020\u000b2\u0011\u0010\u001f\u001a\r\u0012\u0004\u0012\u00020\u000b0\u0013¢\u0006\u0002\b\f2\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\u000b0\u0013¢\u0006\u0002\b\f2\u0011\u0010\u0015\u001a\r\u0012\u0004\u0012\u00020\u000b0\u0013¢\u0006\u0002\b\f2\u0013\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0013¢\u0006\u0002\b\f2\u0006\u0010\u0018\u001a\u00020\u00112\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u0013H\u0003¢\u0006\u0004\b#\u0010$\u001a8\u0010/\u001a\u00020,*\u00020%2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020&2\b\u0010)\u001a\u0004\u0018\u00010&2\u0006\u0010+\u001a\u00020*H\u0002ø\u0001\u0000¢\u0006\u0004\b-\u0010.\u001aP\u00103\u001a\u00020,*\u00020%2\u0006\u00100\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020&2\b\u0010)\u001a\u0004\u0018\u00010&2\u0006\u0010+\u001a\u00020*2\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020!H\u0002ø\u0001\u0000¢\u0006\u0004\b1\u00102\"\u0014\u00105\u001a\u0002048\u0002X\u0082T¢\u0006\u0006\n\u0004\b5\u00106\"\u0014\u00107\u001a\u0002048\u0002X\u0082T¢\u0006\u0006\n\u0004\b7\u00106\"\u0014\u00108\u001a\u0002048\u0002X\u0082T¢\u0006\u0006\n\u0004\b8\u00106\"\u0014\u00109\u001a\u0002048\u0002X\u0082T¢\u0006\u0006\n\u0004\b9\u00106\"\u0014\u0010:\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;\"\u0014\u0010=\u001a\u00020<8\u0002X\u0082T¢\u0006\u0006\n\u0004\b=\u0010>\"\u001a\u0010?\u001a\u00020\u00058\u0000X\u0080\u0004¢\u0006\f\n\u0004\b?\u0010;\u001a\u0004\b@\u0010A\"\u001a\u0010B\u001a\u00020\u00058\u0000X\u0080\u0004¢\u0006\f\n\u0004\bB\u0010;\u001a\u0004\bC\u0010A\"\u0014\u0010D\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010;\"\u001a\u0010E\u001a\u00020\u00058\u0000X\u0080\u0004¢\u0006\f\n\u0004\bE\u0010;\u001a\u0004\bF\u0010A\"\u0014\u0010G\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010;\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006K²\u0006\f\u0010H\u001a\u00020\u00028\nX\u008a\u0084\u0002²\u0006\f\u0010I\u001a\u00020\u00028\nX\u008a\u0084\u0002²\u0006\u000e\u0010J\u001a\u00020<8\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/ui/graphics/Color;", "containerColor", "contentColor", "Landroidx/compose/ui/unit/Dp;", "tonalElevation", "Landroidx/compose/foundation/layout/WindowInsets;", "windowInsets", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "LC7/r;", "Landroidx/compose/runtime/Composable;", "content", "NavigationBar-HsRjFd4", "(Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/WindowInsets;LS7/o;Landroidx/compose/runtime/Composer;II)V", "NavigationBar", "", "selected", "Lkotlin/Function0;", "onClick", NavigationBarKt.IconLayoutIdTag, "enabled", NavigationBarKt.LabelLayoutIdTag, "alwaysShowLabel", "Landroidx/compose/material3/NavigationBarItemColors;", "colors", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "interactionSource", "NavigationBarItem", "(Landroidx/compose/foundation/layout/RowScope;ZLS7/a;LS7/n;Landroidx/compose/ui/Modifier;ZLS7/n;ZLandroidx/compose/material3/NavigationBarItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", NavigationBarKt.IndicatorRippleLayoutIdTag, NavigationBarKt.IndicatorLayoutIdTag, "", "animationProgress", "NavigationBarItemLayout", "(LS7/n;LS7/n;LS7/n;LS7/n;ZLS7/a;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Placeable;", "iconPlaceable", "indicatorRipplePlaceable", "indicatorPlaceable", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/layout/MeasureResult;", "placeIcon-X9ElhV4", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;J)Landroidx/compose/ui/layout/MeasureResult;", "placeIcon", "labelPlaceable", "placeLabelAndIcon-zUg2_y0", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JZF)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndIcon", "", "IndicatorRippleLayoutIdTag", "Ljava/lang/String;", "IndicatorLayoutIdTag", "IconLayoutIdTag", "LabelLayoutIdTag", "NavigationBarHeight", "F", "", "ItemAnimationDurationMillis", "I", "NavigationBarItemHorizontalPadding", "getNavigationBarItemHorizontalPadding", "()F", "NavigationBarIndicatorToLabelPadding", "getNavigationBarIndicatorToLabelPadding", "IndicatorHorizontalPadding", "IndicatorVerticalPadding", "getIndicatorVerticalPadding", "IndicatorVerticalOffset", "iconColor", "textColor", "itemWidth", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class NavigationBarKt {
    private static final String IconLayoutIdTag = "icon";
    private static final float IndicatorHorizontalPadding;
    private static final String IndicatorLayoutIdTag = "indicator";
    private static final String IndicatorRippleLayoutIdTag = "indicatorRipple";
    private static final float IndicatorVerticalOffset;
    private static final float IndicatorVerticalPadding;
    private static final int ItemAnimationDurationMillis = 100;
    private static final String LabelLayoutIdTag = "label";
    private static final float NavigationBarHeight;
    private static final float NavigationBarIndicatorToLabelPadding;
    private static final float NavigationBarItemHorizontalPadding;

    static {
        NavigationBarTokens navigationBarTokens = NavigationBarTokens.INSTANCE;
        NavigationBarHeight = navigationBarTokens.m3098getContainerHeightD9Ej5fM();
        NavigationBarItemHorizontalPadding = Dp.m6844constructorimpl(8);
        NavigationBarIndicatorToLabelPadding = Dp.m6844constructorimpl(4);
        float f = 2;
        IndicatorHorizontalPadding = Dp.m6844constructorimpl(Dp.m6844constructorimpl(navigationBarTokens.m3096getActiveIndicatorWidthD9Ej5fM() - navigationBarTokens.m3099getIconSizeD9Ej5fM()) / f);
        IndicatorVerticalPadding = Dp.m6844constructorimpl(Dp.m6844constructorimpl(navigationBarTokens.m3095getActiveIndicatorHeightD9Ej5fM() - navigationBarTokens.m3099getIconSizeD9Ej5fM()) / f);
        IndicatorVerticalOffset = Dp.m6844constructorimpl(12);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:115:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x011b  */
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* renamed from: NavigationBar-HsRjFd4, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2035NavigationBarHsRjFd4(androidx.compose.ui.Modifier r23, long r24, long r26, float r28, androidx.compose.foundation.layout.WindowInsets r29, final S7.o r30, androidx.compose.runtime.Composer r31, final int r32, final int r33) {
        /*
            Method dump skipped, instructions count: 404
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationBarKt.m2035NavigationBarHsRjFd4(androidx.compose.ui.Modifier, long, long, float, androidx.compose.foundation.layout.WindowInsets, S7.o, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0170 A[PHI: r0 r8 r9 r13 r15 r20
      0x0170: PHI (r0v12 androidx.compose.material3.NavigationBarItemColors) = (r0v8 androidx.compose.material3.NavigationBarItemColors), (r0v16 androidx.compose.material3.NavigationBarItemColors) binds: [B:139:0x0194, B:125:0x016e] A[DONT_GENERATE, DONT_INLINE]
      0x0170: PHI (r8v5 androidx.compose.ui.Modifier) = (r8v3 androidx.compose.ui.Modifier), (r8v2 androidx.compose.ui.Modifier) binds: [B:139:0x0194, B:125:0x016e] A[DONT_GENERATE, DONT_INLINE]
      0x0170: PHI (r9v4 boolean) = (r9v2 boolean), (r9v1 boolean) binds: [B:139:0x0194, B:125:0x016e] A[DONT_GENERATE, DONT_INLINE]
      0x0170: PHI (r13v6 boolean) = (r13v4 boolean), (r13v3 boolean) binds: [B:139:0x0194, B:125:0x016e] A[DONT_GENERATE, DONT_INLINE]
      0x0170: PHI (r15v6 S7.n) = (r15v4 S7.n), (r15v3 S7.n) binds: [B:139:0x0194, B:125:0x016e] A[DONT_GENERATE, DONT_INLINE]
      0x0170: PHI (r20v8 int) = (r20v6 int), (r20v5 int) binds: [B:139:0x0194, B:125:0x016e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0335  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x03aa  */
    /* JADX WARN: Removed duplicated region for block: B:197:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0107  */
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void NavigationBarItem(final androidx.compose.foundation.layout.RowScope r25, final boolean r26, final S7.a r27, final S7.n r28, androidx.compose.ui.Modifier r29, boolean r30, S7.n r31, boolean r32, androidx.compose.material3.NavigationBarItemColors r33, androidx.compose.foundation.interaction.MutableInteractionSource r34, androidx.compose.runtime.Composer r35, final int r36, final int r37) {
        /*
            Method dump skipped, instructions count: 955
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationBarKt.NavigationBarItem(androidx.compose.foundation.layout.RowScope, boolean, S7.a, S7.n, androidx.compose.ui.Modifier, boolean, S7.n, boolean, androidx.compose.material3.NavigationBarItemColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void NavigationBarItemLayout(final n nVar, final n nVar2, final n nVar3, n nVar4, final boolean z10, final S7.a aVar, Composer composer, final int i) {
        int i6;
        final n nVar5 = nVar4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1427075886);
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
                ComposerKt.traceEventStart(-1427075886, i6, -1, "androidx.compose.material3.NavigationBarItemLayout (NavigationBar.kt:516)");
            }
            int i10 = 458752 & i6;
            int i11 = 57344 & i6;
            boolean z11 = (i10 == 131072) | ((i6 & 7168) == 2048) | (i11 == 16384);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z11 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new MeasurePolicy() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItemLayout$2$1
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
                                int iMo375roundToPx0680j_4 = measureScope2.mo375roundToPx0680j_4(Dp.m6844constructorimpl(NavigationBarKt.IndicatorHorizontalPadding * f)) + placeableMo5549measureBRTryo02.getWidth();
                                int iU = U7.a.U(iMo375roundToPx0680j_4 * fFloatValue);
                                int iMo375roundToPx0680j_42 = measureScope2.mo375roundToPx0680j_4(Dp.m6844constructorimpl(NavigationBarKt.getIndicatorVerticalPadding() * f)) + placeableMo5549measureBRTryo02.getHeight();
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
                                            return NavigationBarKt.m2038placeIconX9ElhV4(measureScope2, placeableMo5549measureBRTryo02, placeableMo5549measureBRTryo03, placeableMo5549measureBRTryo04, j5);
                                        }
                                        k.c(placeableMo5549measureBRTryo0);
                                        return NavigationBarKt.m2039placeLabelAndIconzUg2_y0(measureScope, placeableMo5549measureBRTryo0, placeableMo5549measureBRTryo02, placeableMo5549measureBRTryo03, placeableMo5549measureBRTryo04, j5, z10, fFloatValue);
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
            composerStartRestartGroup.startReplaceGroup(1087198243);
            if (nVar4 != null) {
                Modifier modifierLayoutId2 = LayoutIdKt.layoutId(companion, LabelLayoutIdTag);
                boolean z12 = (i11 == 16384) | (i10 == 131072);
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z12 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new S7.k() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItemLayout$1$2$1
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
                Modifier modifierM702paddingVpY3zN4$default = PaddingKt.m702paddingVpY3zN4$default(GraphicsLayerModifierKt.graphicsLayer(modifierLayoutId2, (S7.k) objRememberedValue2), Dp.m6844constructorimpl(NavigationBarItemHorizontalPadding / 2), 0.0f, 2, null);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM702paddingVpY3zN4$default);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.material3.NavigationBarKt.NavigationBarItemLayout.3
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
                    NavigationBarKt.NavigationBarItemLayout(nVar, nVar2, nVar3, nVar5, z10, aVar, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final float getIndicatorVerticalPadding() {
        return IndicatorVerticalPadding;
    }

    public static final float getNavigationBarIndicatorToLabelPadding() {
        return NavigationBarIndicatorToLabelPadding;
    }

    public static final float getNavigationBarItemHorizontalPadding() {
        return NavigationBarItemHorizontalPadding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: placeIcon-X9ElhV4, reason: not valid java name */
    public static final MeasureResult m2038placeIconX9ElhV4(MeasureScope measureScope, final Placeable placeable, final Placeable placeable2, final Placeable placeable3, long j5) {
        final int iM6797getMaxWidthimpl = Constraints.m6797getMaxWidthimpl(j5);
        final int iM6813constrainHeightK40F9xA = ConstraintsKt.m6813constrainHeightK40F9xA(j5, measureScope.mo375roundToPx0680j_4(NavigationBarHeight));
        final int iD = androidx.compose.foundation.b.D(placeable, iM6797getMaxWidthimpl, 2);
        final int iF = androidx.compose.foundation.b.f(placeable, iM6813constrainHeightK40F9xA, 2);
        final int iD2 = androidx.compose.foundation.b.D(placeable2, iM6797getMaxWidthimpl, 2);
        final int iF2 = androidx.compose.foundation.b.f(placeable2, iM6813constrainHeightK40F9xA, 2);
        return MeasureScope.layout$default(measureScope, iM6797getMaxWidthimpl, iM6813constrainHeightK40F9xA, null, new S7.k() { // from class: androidx.compose.material3.NavigationBarKt$placeIcon$1
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
                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, androidx.compose.foundation.b.D(placeable4, iM6797getMaxWidthimpl, 2), androidx.compose.foundation.b.f(placeable4, iM6813constrainHeightK40F9xA, 2), 0.0f, 4, null);
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
    public static final MeasureResult m2039placeLabelAndIconzUg2_y0(final MeasureScope measureScope, final Placeable placeable, final Placeable placeable2, final Placeable placeable3, final Placeable placeable4, long j5, final boolean z10, final float f) {
        float height = placeable2.getHeight();
        float f7 = IndicatorVerticalPadding;
        float fMo381toPx0680j_4 = measureScope.mo381toPx0680j_4(f7) + height;
        float f9 = NavigationBarIndicatorToLabelPadding;
        float fMo381toPx0680j_42 = measureScope.mo381toPx0680j_4(f9) + fMo381toPx0680j_4 + placeable.getHeight();
        float f10 = 2;
        float fM6798getMinHeightimpl = (Constraints.m6798getMinHeightimpl(j5) - fMo381toPx0680j_42) / f10;
        float fMo381toPx0680j_43 = measureScope.mo381toPx0680j_4(f7);
        final float f11 = fM6798getMinHeightimpl < fMo381toPx0680j_43 ? fMo381toPx0680j_43 : fM6798getMinHeightimpl;
        float f12 = (f11 * f10) + fMo381toPx0680j_42;
        final float height2 = (1 - f) * ((z10 ? f11 : (f12 - placeable2.getHeight()) / f10) - f11);
        final float fMo381toPx0680j_44 = measureScope.mo381toPx0680j_4(f9) + measureScope.mo381toPx0680j_4(f7) + placeable2.getHeight() + f11;
        final int iM6797getMaxWidthimpl = Constraints.m6797getMaxWidthimpl(j5);
        final int iD = androidx.compose.foundation.b.D(placeable, iM6797getMaxWidthimpl, 2);
        final int iD2 = androidx.compose.foundation.b.D(placeable2, iM6797getMaxWidthimpl, 2);
        final int iD3 = androidx.compose.foundation.b.D(placeable3, iM6797getMaxWidthimpl, 2);
        final float fMo381toPx0680j_45 = f11 - measureScope.mo381toPx0680j_4(f7);
        return MeasureScope.layout$default(measureScope, iM6797getMaxWidthimpl, U7.a.U(f12), null, new S7.k() { // from class: androidx.compose.material3.NavigationBarKt$placeLabelAndIcon$1
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
                    int i = iM6797getMaxWidthimpl;
                    float f13 = f11;
                    MeasureScope measureScope2 = measureScope;
                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable5, androidx.compose.foundation.b.D(placeable5, i, 2), U7.a.U((f13 - measureScope2.mo375roundToPx0680j_4(NavigationBarKt.getIndicatorVerticalPadding())) + height2), 0.0f, 4, null);
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
