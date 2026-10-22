package androidx.compose.material3;

import C7.r;
import S7.n;
import S7.o;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.material3.tokens.OutlinedSegmentedButtonTokens;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicyKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.k;
import m9.InterfaceC1733z;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\u001a\u0093\u0001\u0010\u0015\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0013\b\u0002\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\u00040\u0011¢\u0006\u0002\b\u00122\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00040\u0011¢\u0006\u0002\b\u0012H\u0007¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u008d\u0001\u0010\u0015\u001a\u00020\u0004*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u00112\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0013\b\u0002\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\u00040\u0011¢\u0006\u0002\b\u00122\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00040\u0011¢\u0006\u0002\b\u0012H\u0007¢\u0006\u0004\b\u0015\u0010\u001a\u001a?\u0010 \u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\u0017\u0010\u001d\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a?\u0010\"\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\u0017\u0010\u001d\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b!\u0010\u001f\u001a5\u0010#\u001a\u00020\u00042\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\u00040\u0011¢\u0006\u0002\b\u00122\u0011\u0010\u001d\u001a\r\u0012\u0004\u0012\u00020\u00040\u0011¢\u0006\u0002\b\u0012H\u0003¢\u0006\u0004\b#\u0010$\u001a\u0019\u0010(\u001a\b\u0012\u0004\u0012\u00020'0&*\u00020%H\u0003¢\u0006\u0004\b(\u0010)\u001a)\u0010+\u001a\u00020\b*\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010*\u001a\b\u0012\u0004\u0012\u00020'0&H\u0002¢\u0006\u0004\b+\u0010,\"\u0014\u0010.\u001a\u00020-8\u0002X\u0082T¢\u0006\u0006\n\u0004\b.\u0010/\"\u0014\u00100\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u0010/\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00061"}, d2 = {"Landroidx/compose/material3/MultiChoiceSegmentedButtonRowScope;", "", "checked", "Lkotlin/Function1;", "LC7/r;", "onCheckedChange", "Landroidx/compose/ui/graphics/Shape;", "shape", "Landroidx/compose/ui/Modifier;", "modifier", "enabled", "Landroidx/compose/material3/SegmentedButtonColors;", "colors", "Landroidx/compose/foundation/BorderStroke;", "border", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "interactionSource", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "icon", "label", "SegmentedButton", "(Landroidx/compose/material3/MultiChoiceSegmentedButtonRowScope;ZLS7/k;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SegmentedButtonColors;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;LS7/n;LS7/n;Landroidx/compose/runtime/Composer;III)V", "Landroidx/compose/material3/SingleChoiceSegmentedButtonRowScope;", "selected", "onClick", "(Landroidx/compose/material3/SingleChoiceSegmentedButtonRowScope;ZLS7/a;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SegmentedButtonColors;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;LS7/n;LS7/n;Landroidx/compose/runtime/Composer;III)V", "Landroidx/compose/ui/unit/Dp;", "space", "content", "SingleChoiceSegmentedButtonRow-uFdPcIQ", "(Landroidx/compose/ui/Modifier;FLS7/o;Landroidx/compose/runtime/Composer;II)V", "SingleChoiceSegmentedButtonRow", "MultiChoiceSegmentedButtonRow-uFdPcIQ", "MultiChoiceSegmentedButtonRow", "SegmentedButtonContent", "(LS7/n;LS7/n;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/foundation/interaction/InteractionSource;", "Landroidx/compose/runtime/State;", "", "interactionCountAsState", "(Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "interactionCount", "interactionZIndex", "(Landroidx/compose/ui/Modifier;ZLandroidx/compose/runtime/State;)Landroidx/compose/ui/Modifier;", "", "CheckedZIndexFactor", "F", "IconSpacing", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SegmentedButtonKt {
    private static final float CheckedZIndexFactor = 5.0f;
    private static final float IconSpacing = Dp.m6844constructorimpl(8);

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* renamed from: MultiChoiceSegmentedButtonRow-uFdPcIQ, reason: not valid java name */
    public static final void m2221MultiChoiceSegmentedButtonRowuFdPcIQ(Modifier modifier, float f, final o oVar, Composer composer, final int i, final int i6) {
        int i10;
        Composer composerStartRestartGroup = composer.startRestartGroup(155922315);
        int i11 = i6 & 1;
        if (i11 != 0) {
            i10 = i | 6;
        } else if ((i & 6) == 0) {
            i10 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i10 = i;
        }
        int i12 = i6 & 2;
        if (i12 != 0) {
            i10 |= 48;
        } else if ((i & 48) == 0) {
            i10 |= composerStartRestartGroup.changed(f) ? 32 : 16;
        }
        if ((i6 & 4) != 0) {
            i10 |= 384;
        } else if ((i & 384) == 0) {
            i10 |= composerStartRestartGroup.changedInstance(oVar) ? 256 : 128;
        }
        if ((i10 & 147) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i11 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (i12 != 0) {
                f = SegmentedButtonDefaults.INSTANCE.m2219getBorderWidthD9Ej5fM();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(155922315, i10, -1, "androidx.compose.material3.MultiChoiceSegmentedButtonRow (SegmentedButton.kt:306)");
            }
            Modifier modifierWidth = IntrinsicKt.width(SizeKt.m730defaultMinSizeVpY3zN4$default(modifier, 0.0f, OutlinedSegmentedButtonTokens.INSTANCE.m3134getContainerHeightD9Ej5fM(), 1, null), IntrinsicSize.Min);
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.m580spacedBy0680j_4(Dp.m6844constructorimpl(-f)), Alignment.INSTANCE.getCenterVertically(), composerStartRestartGroup, 48);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWidth);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            S7.a constructor = companion.getConstructor();
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
            n nVarG = androidx.appfunctions.metadata.a.g(companion, composerM3474constructorimpl, measurePolicyRowMeasurePolicy, composerM3474constructorimpl, currentCompositionLocalMap);
            if (composerM3474constructorimpl.getInserting() || !k.b(composerM3474constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                androidx.appfunctions.metadata.a.z(nVarG, currentCompositeKeyHash, composerM3474constructorimpl, currentCompositeKeyHash);
            }
            Updater.m3481setimpl(composerM3474constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new MultiChoiceSegmentedButtonScopeWrapper(rowScopeInstance);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            oVar.invoke((MultiChoiceSegmentedButtonScopeWrapper) objRememberedValue, composerStartRestartGroup, Integer.valueOf(((i10 >> 3) & 112) | 6));
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final Modifier modifier2 = modifier;
        final float f7 = f;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.material3.SegmentedButtonKt$MultiChoiceSegmentedButtonRow$2
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
                    SegmentedButtonKt.m2221MultiChoiceSegmentedButtonRowuFdPcIQ(modifier2, f7, oVar, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i6);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:176:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0110  */
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[_][_]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void SegmentedButton(final androidx.compose.material3.MultiChoiceSegmentedButtonRowScope r27, final boolean r28, final S7.k r29, final androidx.compose.ui.graphics.Shape r30, androidx.compose.ui.Modifier r31, boolean r32, androidx.compose.material3.SegmentedButtonColors r33, androidx.compose.foundation.BorderStroke r34, androidx.compose.foundation.interaction.MutableInteractionSource r35, S7.n r36, final S7.n r37, androidx.compose.runtime.Composer r38, final int r39, final int r40, final int r41) {
        /*
            Method dump skipped, instructions count: 729
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SegmentedButtonKt.SegmentedButton(androidx.compose.material3.MultiChoiceSegmentedButtonRowScope, boolean, S7.k, androidx.compose.ui.graphics.Shape, androidx.compose.ui.Modifier, boolean, androidx.compose.material3.SegmentedButtonColors, androidx.compose.foundation.BorderStroke, androidx.compose.foundation.interaction.MutableInteractionSource, S7.n, S7.n, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[_][_]]")
    public static final void SegmentedButtonContent(final n nVar, final n nVar2, Composer composer, final int i) {
        int i6;
        Composer composerStartRestartGroup = composer.startRestartGroup(1464121570);
        if ((i & 6) == 0) {
            i6 = (composerStartRestartGroup.changedInstance(nVar) ? 4 : 2) | i;
        } else {
            i6 = i;
        }
        if ((i & 48) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(nVar2) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1464121570, i6, -1, "androidx.compose.material3.SegmentedButtonContent (SegmentedButton.kt:324)");
            }
            Alignment center = Alignment.INSTANCE.getCenter();
            Modifier modifierPadding = PaddingKt.padding(Modifier.INSTANCE, ButtonDefaults.INSTANCE.getTextButtonContentPadding());
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierPadding);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            S7.a constructor = companion.getConstructor();
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
            n nVarG = androidx.appfunctions.metadata.a.g(companion, composerM3474constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, composerM3474constructorimpl, currentCompositionLocalMap);
            if (composerM3474constructorimpl.getInserting() || !k.b(composerM3474constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                androidx.appfunctions.metadata.a.z(nVarG, currentCompositeKeyHash, composerM3474constructorimpl, currentCompositeKeyHash);
            }
            Updater.m3481setimpl(composerM3474constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            TextKt.ProvideTextStyle(TypographyKt.getValue(OutlinedSegmentedButtonTokens.INSTANCE.getLabelTextFont(), composerStartRestartGroup, 6), ComposableLambdaKt.rememberComposableLambda(1420592651, true, new n() { // from class: androidx.compose.material3.SegmentedButtonKt$SegmentedButtonContent$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void invoke(Composer composer2, int i10) {
                    if ((i10 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1420592651, i10, -1, "androidx.compose.material3.SegmentedButtonContent.<anonymous>.<anonymous> (SegmentedButton.kt:331)");
                    }
                    Object objRememberedValue = composer2.rememberedValue();
                    Composer.Companion companion2 = Composer.INSTANCE;
                    if (objRememberedValue == companion2.getEmpty()) {
                        objRememberedValue = B7.a.e(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.f4908a, composer2), composer2);
                    }
                    InterfaceC1733z coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                    Object objRememberedValue2 = composer2.rememberedValue();
                    if (objRememberedValue2 == companion2.getEmpty()) {
                        objRememberedValue2 = new SegmentedButtonContentMeasurePolicy(coroutineScope);
                        composer2.updateRememberedValue(objRememberedValue2);
                    }
                    SegmentedButtonContentMeasurePolicy segmentedButtonContentMeasurePolicy = (SegmentedButtonContentMeasurePolicy) objRememberedValue2;
                    Modifier modifierHeight = IntrinsicKt.height(Modifier.INSTANCE, IntrinsicSize.Min);
                    n nVarCombineAsVirtualLayouts = LayoutKt.combineAsVirtualLayouts(H4.o.N(nVar, nVar2));
                    Object objRememberedValue3 = composer2.rememberedValue();
                    if (objRememberedValue3 == companion2.getEmpty()) {
                        objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(segmentedButtonContentMeasurePolicy);
                        composer2.updateRememberedValue(objRememberedValue3);
                    }
                    MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue3;
                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifierHeight);
                    ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                    S7.a constructor2 = companion3.getConstructor();
                    if (composer2.getApplier() == null) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor2);
                    } else {
                        composer2.useNode();
                    }
                    Composer composerM3474constructorimpl2 = Updater.m3474constructorimpl(composer2);
                    n nVarG2 = androidx.appfunctions.metadata.a.g(companion3, composerM3474constructorimpl2, measurePolicy, composerM3474constructorimpl2, currentCompositionLocalMap2);
                    if (composerM3474constructorimpl2.getInserting() || !k.b(composerM3474constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        androidx.appfunctions.metadata.a.z(nVarG2, currentCompositeKeyHash2, composerM3474constructorimpl2, currentCompositeKeyHash2);
                    }
                    Updater.m3481setimpl(composerM3474constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
                    nVarCombineAsVirtualLayouts.invoke(composer2, 0);
                    composer2.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 48);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.material3.SegmentedButtonKt.SegmentedButtonContent.2
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
                    SegmentedButtonKt.SegmentedButtonContent(nVar, nVar2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* renamed from: SingleChoiceSegmentedButtonRow-uFdPcIQ, reason: not valid java name */
    public static final void m2222SingleChoiceSegmentedButtonRowuFdPcIQ(Modifier modifier, float f, final o oVar, Composer composer, final int i, final int i6) {
        int i10;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1520863498);
        int i11 = i6 & 1;
        if (i11 != 0) {
            i10 = i | 6;
        } else if ((i & 6) == 0) {
            i10 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i10 = i;
        }
        int i12 = i6 & 2;
        if (i12 != 0) {
            i10 |= 48;
        } else if ((i & 48) == 0) {
            i10 |= composerStartRestartGroup.changed(f) ? 32 : 16;
        }
        if ((i6 & 4) != 0) {
            i10 |= 384;
        } else if ((i & 384) == 0) {
            i10 |= composerStartRestartGroup.changedInstance(oVar) ? 256 : 128;
        }
        if ((i10 & 147) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i11 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (i12 != 0) {
                f = SegmentedButtonDefaults.INSTANCE.m2219getBorderWidthD9Ej5fM();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1520863498, i10, -1, "androidx.compose.material3.SingleChoiceSegmentedButtonRow (SegmentedButton.kt:268)");
            }
            Modifier modifierWidth = IntrinsicKt.width(SizeKt.m730defaultMinSizeVpY3zN4$default(SelectableGroupKt.selectableGroup(modifier), 0.0f, OutlinedSegmentedButtonTokens.INSTANCE.m3134getContainerHeightD9Ej5fM(), 1, null), IntrinsicSize.Min);
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.m580spacedBy0680j_4(Dp.m6844constructorimpl(-f)), Alignment.INSTANCE.getCenterVertically(), composerStartRestartGroup, 48);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWidth);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            S7.a constructor = companion.getConstructor();
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
            n nVarG = androidx.appfunctions.metadata.a.g(companion, composerM3474constructorimpl, measurePolicyRowMeasurePolicy, composerM3474constructorimpl, currentCompositionLocalMap);
            if (composerM3474constructorimpl.getInserting() || !k.b(composerM3474constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                androidx.appfunctions.metadata.a.z(nVarG, currentCompositeKeyHash, composerM3474constructorimpl, currentCompositeKeyHash);
            }
            Updater.m3481setimpl(composerM3474constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new SingleChoiceSegmentedButtonScopeWrapper(rowScopeInstance);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            oVar.invoke((SingleChoiceSegmentedButtonScopeWrapper) objRememberedValue, composerStartRestartGroup, Integer.valueOf(((i10 >> 3) & 112) | 6));
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final Modifier modifier2 = modifier;
        final float f7 = f;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.material3.SegmentedButtonKt$SingleChoiceSegmentedButtonRow$2
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
                    SegmentedButtonKt.m2222SingleChoiceSegmentedButtonRowuFdPcIQ(modifier2, f7, oVar, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i6);
                }
            });
        }
    }

    @Composable
    private static final State<Integer> interactionCountAsState(InteractionSource interactionSource, Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(281890131, i, -1, "androidx.compose.material3.interactionCountAsState (SegmentedButton.kt:396)");
        }
        Object objRememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (objRememberedValue == companion.getEmpty()) {
            objRememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
            composer.updateRememberedValue(objRememberedValue);
        }
        MutableIntState mutableIntState = (MutableIntState) objRememberedValue;
        int i6 = i & 14;
        boolean z10 = ((i6 ^ 6) > 4 && composer.changed(interactionSource)) || (i & 6) == 4;
        Object objRememberedValue2 = composer.rememberedValue();
        if (z10 || objRememberedValue2 == companion.getEmpty()) {
            objRememberedValue2 = new SegmentedButtonKt$interactionCountAsState$1$1(interactionSource, mutableIntState, null);
            composer.updateRememberedValue(objRememberedValue2);
        }
        EffectsKt.LaunchedEffect(interactionSource, (n) objRememberedValue2, composer, i6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return mutableIntState;
    }

    private static final Modifier interactionZIndex(Modifier modifier, final boolean z10, final State<Integer> state) {
        return LayoutModifierKt.layout(modifier, new o() { // from class: androidx.compose.material3.SegmentedButtonKt.interactionZIndex.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // S7.o
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return m2223invoke3p2s80s((MeasureScope) obj, (Measurable) obj2, ((Constraints) obj3).getValue());
            }

            /* renamed from: invoke-3p2s80s, reason: not valid java name */
            public final MeasureResult m2223invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j5) {
                final Placeable placeableMo5549measureBRTryo0 = measurable.mo5549measureBRTryo0(j5);
                int width = placeableMo5549measureBRTryo0.getWidth();
                int height = placeableMo5549measureBRTryo0.getHeight();
                final State<Integer> state2 = state;
                final boolean z11 = z10;
                return MeasureScope.layout$default(measureScope, width, height, null, new S7.k() { // from class: androidx.compose.material3.SegmentedButtonKt.interactionZIndex.1.1
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
                        placementScope.place(placeableMo5549measureBRTryo0, 0, 0, state2.getValue().floatValue() + (z11 ? SegmentedButtonKt.CheckedZIndexFactor : 0.0f));
                    }
                }, 4, null);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:176:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0110  */
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[_][_]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void SegmentedButton(final androidx.compose.material3.SingleChoiceSegmentedButtonRowScope r27, final boolean r28, final S7.a r29, final androidx.compose.ui.graphics.Shape r30, androidx.compose.ui.Modifier r31, boolean r32, androidx.compose.material3.SegmentedButtonColors r33, androidx.compose.foundation.BorderStroke r34, androidx.compose.foundation.interaction.MutableInteractionSource r35, S7.n r36, final S7.n r37, androidx.compose.runtime.Composer r38, final int r39, final int r40, final int r41) {
        /*
            Method dump skipped, instructions count: 737
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SegmentedButtonKt.SegmentedButton(androidx.compose.material3.SingleChoiceSegmentedButtonRowScope, boolean, S7.a, androidx.compose.ui.graphics.Shape, androidx.compose.ui.Modifier, boolean, androidx.compose.material3.SegmentedButtonColors, androidx.compose.foundation.BorderStroke, androidx.compose.foundation.interaction.MutableInteractionSource, S7.n, S7.n, androidx.compose.runtime.Composer, int, int, int):void");
    }
}
