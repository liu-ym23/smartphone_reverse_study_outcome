package androidx.compose.material3;

import C7.r;
import H4.o;
import S7.n;
import androidx.annotation.VisibleForTesting;
import androidx.compose.material3.ListItemType;
import androidx.compose.material3.internal.ProvideContentColorTextStyleKt;
import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.material3.tokens.ListTokens;
import androidx.compose.material3.tokens.TypographyKeyTokens;
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
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicyKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001e\u001a©\u0001\u0010\u0011\u001a\u00020\u00012\u0011\u0010\u0003\u001a\r\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0002\b\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0015\b\u0002\u0010\u0006\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000¢\u0006\u0002\b\u00022\u0015\b\u0002\u0010\u0007\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000¢\u0006\u0002\b\u00022\u0015\b\u0002\u0010\b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000¢\u0006\u0002\b\u00022\u0015\b\u0002\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000¢\u0006\u0002\b\u00022\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001av\u0010\u0017\u001a\u00020\u00012\u0013\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000¢\u0006\u0002\b\u00022\u0013\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000¢\u0006\u0002\b\u00022\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0002\b\u00022\u0013\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000¢\u0006\u0002\b\u00022\u0013\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000¢\u0006\u0002\b\u0002H\u0003¢\u0006\u0004\b\u0017\u0010\u0018\u001aN\u0010%\u001a\u00020\u001a*\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020!H\u0002ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001aV\u00100\u001a\u00020\u001a*\u00020\u00192\u0006\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020!H\u0002ø\u0001\u0000¢\u0006\u0004\b.\u0010/\u001au\u0010@\u001a\u00020?*\u0002012\u0006\u00102\u001a\u00020\u001a2\u0006\u00103\u001a\u00020\u001a2\b\u00105\u001a\u0004\u0018\u0001042\b\u00106\u001a\u0004\u0018\u0001042\b\u00107\u001a\u0004\u0018\u0001042\b\u00108\u001a\u0004\u0018\u0001042\b\u00109\u001a\u0004\u0018\u0001042\u0006\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020\u001a2\u0006\u0010=\u001a\u00020\u001a2\u0006\u0010>\u001a\u00020\u001aH\u0002¢\u0006\u0004\b@\u0010A\u001a5\u0010I\u001a\u00020\u00012\u0006\u0010C\u001a\u00020B2\u0006\u0010E\u001a\u00020D2\u0011\u0010F\u001a\r\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0002\b\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\bG\u0010H\u001a\u001b\u0010L\u001a\u00020:*\u00020J2\u0006\u0010K\u001a\u00020\u001aH\u0002¢\u0006\u0004\bL\u0010M\u001a\u001a\u0010-\u001a\u00020\f2\u0006\u0010,\u001a\u00020+H\u0002ø\u0001\u0000¢\u0006\u0004\bN\u0010O\u001a\u001b\u0010Q\u001a\u00020\u001a*\u00020\u001a2\u0006\u0010P\u001a\u00020\u001aH\u0002¢\u0006\u0004\bQ\u0010R\" \u0010S\u001a\u00020\f8\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\bS\u0010T\u0012\u0004\bW\u0010X\u001a\u0004\bU\u0010V\" \u0010Y\u001a\u00020\f8\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\bY\u0010T\u0012\u0004\b[\u0010X\u001a\u0004\bZ\u0010V\" \u0010\\\u001a\u00020\f8\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\\\u0010T\u0012\u0004\b^\u0010X\u001a\u0004\b]\u0010V\" \u0010_\u001a\u00020\f8\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b_\u0010T\u0012\u0004\ba\u0010X\u001a\u0004\b`\u0010V\" \u0010b\u001a\u00020\f8\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\bb\u0010T\u0012\u0004\bd\u0010X\u001a\u0004\bc\u0010V\" \u0010e\u001a\u00020\f8\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\be\u0010T\u0012\u0004\bg\u0010X\u001a\u0004\bf\u0010V\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006h"}, d2 = {"Lkotlin/Function0;", "LC7/r;", "Landroidx/compose/runtime/Composable;", "headlineContent", "Landroidx/compose/ui/Modifier;", "modifier", "overlineContent", "supportingContent", "leadingContent", "trailingContent", "Landroidx/compose/material3/ListItemColors;", "colors", "Landroidx/compose/ui/unit/Dp;", "tonalElevation", "shadowElevation", "ListItem-HXNGIdc", "(LS7/n;Landroidx/compose/ui/Modifier;LS7/n;LS7/n;LS7/n;LS7/n;Landroidx/compose/material3/ListItemColors;FFLandroidx/compose/runtime/Composer;II)V", "ListItem", "leading", "trailing", "headline", "overline", "supporting", "ListItemLayout", "(LS7/n;LS7/n;LS7/n;LS7/n;LS7/n;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "", "leadingWidth", "trailingWidth", "headlineWidth", "overlineWidth", "supportingWidth", "horizontalPadding", "Landroidx/compose/ui/unit/Constraints;", "constraints", "calculateWidth-yeHjK3Y", "(Landroidx/compose/ui/layout/IntrinsicMeasureScope;IIIIIIJ)I", "calculateWidth", "leadingHeight", "trailingHeight", "headlineHeight", "overlineHeight", "supportingHeight", "Landroidx/compose/material3/ListItemType;", "listItemType", "verticalPadding", "calculateHeight-N4Jib3Y", "(Landroidx/compose/ui/layout/IntrinsicMeasureScope;IIIIIIIJ)I", "calculateHeight", "Landroidx/compose/ui/layout/MeasureScope;", "width", "height", "Landroidx/compose/ui/layout/Placeable;", "leadingPlaceable", "trailingPlaceable", "headlinePlaceable", "overlinePlaceable", "supportingPlaceable", "", "isThreeLine", "startPadding", "endPadding", "topPadding", "Landroidx/compose/ui/layout/MeasureResult;", "place", "(Landroidx/compose/ui/layout/MeasureScope;IILandroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;ZIII)Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/graphics/Color;", TypedValues.Custom.S_COLOR, "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "textToken", "content", "ProvideTextStyleFromToken-3J-VO9M", "(JLandroidx/compose/material3/tokens/TypographyKeyTokens;LS7/n;Landroidx/compose/runtime/Composer;I)V", "ProvideTextStyleFromToken", "Landroidx/compose/ui/unit/Density;", "estimatedSupportingHeight", "isSupportingMultilineHeuristic", "(Landroidx/compose/ui/unit/Density;I)Z", "verticalPadding-yh95HIg", "(I)F", "n", "subtractConstraintSafely", "(II)I", "ListItemVerticalPadding", "F", "getListItemVerticalPadding", "()F", "getListItemVerticalPadding$annotations", "()V", "ListItemThreeLineVerticalPadding", "getListItemThreeLineVerticalPadding", "getListItemThreeLineVerticalPadding$annotations", "ListItemStartPadding", "getListItemStartPadding", "getListItemStartPadding$annotations", "ListItemEndPadding", "getListItemEndPadding", "getListItemEndPadding$annotations", "LeadingContentEndPadding", "getLeadingContentEndPadding", "getLeadingContentEndPadding$annotations", "TrailingContentStartPadding", "getTrailingContentStartPadding", "getTrailingContentStartPadding$annotations", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ListItemKt {
    private static final float LeadingContentEndPadding;
    private static final float ListItemEndPadding;
    private static final float ListItemStartPadding;
    private static final float TrailingContentStartPadding;
    private static final float ListItemVerticalPadding = Dp.m6844constructorimpl(8);
    private static final float ListItemThreeLineVerticalPadding = Dp.m6844constructorimpl(12);

    static {
        float f = 16;
        ListItemStartPadding = Dp.m6844constructorimpl(f);
        ListItemEndPadding = Dp.m6844constructorimpl(f);
        LeadingContentEndPadding = Dp.m6844constructorimpl(f);
        TrailingContentStartPadding = Dp.m6844constructorimpl(f);
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:165:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00f9  */
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[_][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* renamed from: ListItem-HXNGIdc, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1954ListItemHXNGIdc(final S7.n r36, androidx.compose.ui.Modifier r37, S7.n r38, S7.n r39, S7.n r40, S7.n r41, androidx.compose.material3.ListItemColors r42, float r43, float r44, androidx.compose.runtime.Composer r45, final int r46, final int r47) {
        /*
            Method dump skipped, instructions count: 713
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ListItemKt.m1954ListItemHXNGIdc(S7.n, androidx.compose.ui.Modifier, S7.n, S7.n, S7.n, S7.n, androidx.compose.material3.ListItemColors, float, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[_][_][_][_][_]]")
    public static final void ListItemLayout(final n nVar, final n nVar2, final n nVar3, final n nVar4, final n nVar5, Composer composer, final int i) {
        int i6;
        Composer composerStartRestartGroup = composer.startRestartGroup(2052297037);
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
            i6 |= composerStartRestartGroup.changedInstance(nVar4) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(nVar5) ? 16384 : 8192;
        }
        if ((i6 & 9363) == 9362 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2052297037, i6, -1, "androidx.compose.material3.ListItemLayout (ListItem.kt:180)");
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = new ListItemMeasurePolicy();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ListItemMeasurePolicy listItemMeasurePolicy = (ListItemMeasurePolicy) objRememberedValue;
            List listN = o.N(nVar3, nVar4 == null ? ComposableSingletons$ListItemKt.INSTANCE.m1711getLambda1$material3_release() : nVar4, nVar5 == null ? ComposableSingletons$ListItemKt.INSTANCE.m1712getLambda2$material3_release() : nVar5, nVar == null ? ComposableSingletons$ListItemKt.INSTANCE.m1713getLambda3$material3_release() : nVar, nVar2 == null ? ComposableSingletons$ListItemKt.INSTANCE.m1714getLambda4$material3_release() : nVar2);
            Modifier.Companion companion2 = Modifier.INSTANCE;
            n nVarCombineAsVirtualLayouts = LayoutKt.combineAsVirtualLayouts(listN);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = MultiContentMeasurePolicyKt.createMeasurePolicy(listItemMeasurePolicy);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue2;
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion2);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            S7.a constructor = companion3.getConstructor();
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
            n nVarG = androidx.appfunctions.metadata.a.g(companion3, composerM3474constructorimpl, measurePolicy, composerM3474constructorimpl, currentCompositionLocalMap);
            if (composerM3474constructorimpl.getInserting() || !k.b(composerM3474constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                androidx.appfunctions.metadata.a.z(nVarG, currentCompositeKeyHash, composerM3474constructorimpl, currentCompositeKeyHash);
            }
            Updater.m3481setimpl(composerM3474constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
            nVarCombineAsVirtualLayouts.invoke(composerStartRestartGroup, 0);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.material3.ListItemKt.ListItemLayout.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                public final void invoke(Composer composer2, int i10) {
                    ListItemKt.ListItemLayout(nVar, nVar2, nVar3, nVar4, nVar5, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    /* renamed from: ProvideTextStyleFromToken-3J-VO9M, reason: not valid java name */
    public static final void m1955ProvideTextStyleFromToken3JVO9M(long j5, final TypographyKeyTokens typographyKeyTokens, n nVar, Composer composer, final int i) {
        int i6;
        long j6;
        final n nVar2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1133967795);
        if ((i & 6) == 0) {
            i6 = (composerStartRestartGroup.changed(j5) ? 4 : 2) | i;
        } else {
            i6 = i;
        }
        if ((i & 48) == 0) {
            i6 |= composerStartRestartGroup.changed(typographyKeyTokens) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(nVar) ? 256 : 128;
        }
        if ((i6 & 147) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            j6 = j5;
            nVar2 = nVar;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1133967795, i6, -1, "androidx.compose.material3.ProvideTextStyleFromToken (ListItem.kt:657)");
            }
            j6 = j5;
            ProvideContentColorTextStyleKt.m2680ProvideContentColorTextStyle3JVO9M(j6, TypographyKt.getValue(typographyKeyTokens, composerStartRestartGroup, (i6 >> 3) & 14), nVar, composerStartRestartGroup, i6 & 910);
            nVar2 = nVar;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final long j10 = j6;
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.material3.ListItemKt$ProvideTextStyleFromToken$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                public final void invoke(Composer composer2, int i10) {
                    ListItemKt.m1955ProvideTextStyleFromToken3JVO9M(j10, typographyKeyTokens, nVar2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculateHeight-N4Jib3Y, reason: not valid java name */
    public static final int m1960calculateHeightN4Jib3Y(IntrinsicMeasureScope intrinsicMeasureScope, int i, int i6, int i10, int i11, int i12, int i13, int i14, long j5) {
        ListItemType.Companion companion = ListItemType.INSTANCE;
        int iMax = Math.max(Math.max(Constraints.m6798getMinHeightimpl(j5), intrinsicMeasureScope.mo375roundToPx0680j_4(ListItemType.m1967equalsimpl0(i13, companion.m1972getOneLineAlXitO8()) ? ListTokens.INSTANCE.m3088getListItemOneLineContainerHeightD9Ej5fM() : ListItemType.m1967equalsimpl0(i13, companion.m1974getTwoLineAlXitO8()) ? ListTokens.INSTANCE.m3093getListItemTwoLineContainerHeightD9Ej5fM() : ListTokens.INSTANCE.m3090getListItemThreeLineContainerHeightD9Ej5fM())), Math.max(i, Math.max(i10 + i11 + i12, i6)) + i14);
        int iM6796getMaxHeightimpl = Constraints.m6796getMaxHeightimpl(j5);
        return iMax > iM6796getMaxHeightimpl ? iM6796getMaxHeightimpl : iMax;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculateWidth-yeHjK3Y, reason: not valid java name */
    public static final int m1961calculateWidthyeHjK3Y(IntrinsicMeasureScope intrinsicMeasureScope, int i, int i6, int i10, int i11, int i12, int i13, long j5) {
        if (Constraints.m6793getHasBoundedWidthimpl(j5)) {
            return Constraints.m6797getMaxWidthimpl(j5);
        }
        return i13 + i + Math.max(i10, Math.max(i11, i12)) + i6;
    }

    public static final float getLeadingContentEndPadding() {
        return LeadingContentEndPadding;
    }

    @VisibleForTesting
    public static /* synthetic */ void getLeadingContentEndPadding$annotations() {
    }

    public static final float getListItemEndPadding() {
        return ListItemEndPadding;
    }

    @VisibleForTesting
    public static /* synthetic */ void getListItemEndPadding$annotations() {
    }

    public static final float getListItemStartPadding() {
        return ListItemStartPadding;
    }

    @VisibleForTesting
    public static /* synthetic */ void getListItemStartPadding$annotations() {
    }

    public static final float getListItemThreeLineVerticalPadding() {
        return ListItemThreeLineVerticalPadding;
    }

    @VisibleForTesting
    public static /* synthetic */ void getListItemThreeLineVerticalPadding$annotations() {
    }

    public static final float getListItemVerticalPadding() {
        return ListItemVerticalPadding;
    }

    @VisibleForTesting
    public static /* synthetic */ void getListItemVerticalPadding$annotations() {
    }

    public static final float getTrailingContentStartPadding() {
        return TrailingContentStartPadding;
    }

    @VisibleForTesting
    public static /* synthetic */ void getTrailingContentStartPadding$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isSupportingMultilineHeuristic(Density density, int i) {
        return i > density.mo374roundToPxR2X_6o(TextUnitKt.getSp(30));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult place(MeasureScope measureScope, final int i, final int i6, final Placeable placeable, final Placeable placeable2, final Placeable placeable3, final Placeable placeable4, final Placeable placeable5, final boolean z10, final int i10, final int i11, final int i12) {
        return MeasureScope.layout$default(measureScope, i, i6, null, new S7.k() { // from class: androidx.compose.material3.ListItemKt.place.1
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
                int iAlign;
                Placeable placeable6 = placeable;
                if (placeable6 != null) {
                    int i13 = i10;
                    boolean z11 = z10;
                    int iAlign2 = i12;
                    int i14 = i6;
                    if (!z11) {
                        iAlign2 = Alignment.INSTANCE.getCenterVertically().align(placeable6.getHeight(), i14);
                    }
                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable6, i13, iAlign2, 0.0f, 4, null);
                    placementScope2 = placementScope;
                } else {
                    placementScope2 = placementScope;
                }
                Placeable placeable7 = placeable2;
                if (placeable7 != null) {
                    int i15 = i;
                    int i16 = i11;
                    boolean z12 = z10;
                    int iAlign3 = i12;
                    int i17 = i6;
                    int width = (i15 - i16) - placeable7.getWidth();
                    if (!z12) {
                        iAlign3 = Alignment.INSTANCE.getCenterVertically().align(placeable7.getHeight(), i17);
                    }
                    Placeable.PlacementScope.placeRelative$default(placementScope2, placeable7, width, iAlign3, 0.0f, 4, null);
                }
                int iWidthOrZero = TextFieldImplKt.widthOrZero(placeable) + i10;
                if (z10) {
                    iAlign = i12;
                } else {
                    iAlign = Alignment.INSTANCE.getCenterVertically().align(TextFieldImplKt.heightOrZero(placeable5) + TextFieldImplKt.heightOrZero(placeable4) + TextFieldImplKt.heightOrZero(placeable3), i6);
                }
                int i18 = iAlign;
                Placeable placeable8 = placeable4;
                if (placeable8 != null) {
                    Placeable.PlacementScope.placeRelative$default(placementScope2, placeable8, iWidthOrZero, i18, 0.0f, 4, null);
                }
                int iHeightOrZero = i18 + TextFieldImplKt.heightOrZero(placeable4);
                Placeable placeable9 = placeable3;
                if (placeable9 != null) {
                    Placeable.PlacementScope.placeRelative$default(placementScope2, placeable9, iWidthOrZero, iHeightOrZero, 0.0f, 4, null);
                }
                int iHeightOrZero2 = iHeightOrZero + TextFieldImplKt.heightOrZero(placeable3);
                Placeable placeable10 = placeable5;
                if (placeable10 != null) {
                    Placeable.PlacementScope.placeRelative$default(placementScope2, placeable10, iWidthOrZero, iHeightOrZero2, 0.0f, 4, null);
                }
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int subtractConstraintSafely(int i, int i6) {
        return i == Integer.MAX_VALUE ? i : i - i6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: verticalPadding-yh95HIg, reason: not valid java name */
    public static final float m1962verticalPaddingyh95HIg(int i) {
        return ListItemType.m1967equalsimpl0(i, ListItemType.INSTANCE.m1973getThreeLineAlXitO8()) ? ListItemThreeLineVerticalPadding : ListItemVerticalPadding;
    }
}
