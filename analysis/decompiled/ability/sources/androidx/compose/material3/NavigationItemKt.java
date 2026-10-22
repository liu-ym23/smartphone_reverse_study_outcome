package androidx.compose.material3;

import C7.r;
import S7.k;
import S7.n;
import S7.o;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.material3.internal.MappedInteractionSource;
import androidx.compose.material3.internal.ProvideContentColorTextStyleKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\u001aÍ\u0001\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\b\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00002\u0013\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0002\b\u00052\u0013\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0002\b\u00052\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u0090\u0001\u0010'\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020 2\u0006\u0010\"\u001a\u00020!2\u0006\u0010\n\u001a\u00020\t2\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\b\u00052\u0006\u0010\u001a\u001a\u00020\u00192\u0013\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0002\b\u00052\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u00022\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0003ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a6\u00102\u001a\u00020/*\u00020(2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020)2\u0006\u0010.\u001a\u00020-H\u0002ø\u0001\u0000¢\u0006\u0004\b0\u00101\u001aV\u00106\u001a\u00020/*\u00020(2\u0006\u00103\u001a\u00020)2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020)2\u0006\u0010.\u001a\u00020-2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0002ø\u0001\u0000¢\u0006\u0004\b4\u00105\u001aF\u00109\u001a\u00020/*\u00020(2\u0006\u00103\u001a\u00020)2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020)2\u0006\u0010.\u001a\u00020-2\u0006\u0010\u0010\u001a\u00020\u000bH\u0002ø\u0001\u0000¢\u0006\u0004\b7\u00108\"\u001a\u0010:\u001a\u00020\u000b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u001a\u0010>\u001a\u00020\u000b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b>\u0010;\u001a\u0004\b?\u0010=\"\u0014\u0010A\u001a\u00020@8\u0002X\u0082T¢\u0006\u0006\n\u0004\bA\u0010B\"\u0014\u0010C\u001a\u00020@8\u0002X\u0082T¢\u0006\u0006\n\u0004\bC\u0010B\"\u0014\u0010D\u001a\u00020@8\u0002X\u0082T¢\u0006\u0006\n\u0004\bD\u0010B\"\u0014\u0010E\u001a\u00020@8\u0002X\u0082T¢\u0006\u0006\n\u0004\bE\u0010B\"\u0014\u0010G\u001a\u00020F8\u0002X\u0082T¢\u0006\u0006\n\u0004\bG\u0010H\"\u0014\u0010I\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010;\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006K²\u0006\u000e\u0010J\u001a\u00020F8\n@\nX\u008a\u008e\u0002"}, d2 = {"", "selected", "Lkotlin/Function0;", "LC7/r;", "onClick", "Landroidx/compose/runtime/Composable;", NavigationItemKt.IconLayoutIdTag, "Landroidx/compose/ui/text/TextStyle;", "labelTextStyle", "Landroidx/compose/ui/graphics/Shape;", "indicatorShape", "Landroidx/compose/ui/unit/Dp;", "indicatorWidth", "indicatorHorizontalPadding", "indicatorVerticalPadding", "indicatorToLabelVerticalPadding", "startIconToLabelHorizontalPadding", "topIconItemVerticalPadding", "Landroidx/compose/material3/NavigationItemColors;", "colors", "Landroidx/compose/ui/Modifier;", "modifier", "enabled", NavigationItemKt.LabelLayoutIdTag, "badge", "Landroidx/compose/material3/NavigationItemIconPosition;", "iconPosition", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "interactionSource", "NavigationItem-SHbi2eg", "(ZLS7/a;LS7/n;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/graphics/Shape;FFFFFFLandroidx/compose/material3/NavigationItemColors;Landroidx/compose/ui/Modifier;ZLS7/n;LS7/n;ILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "NavigationItem", "Landroidx/compose/foundation/interaction/InteractionSource;", "Landroidx/compose/ui/graphics/Color;", "indicatorColor", "", "animationProgress", "NavigationItemLayout-KmRX-Dg", "(Landroidx/compose/foundation/interaction/InteractionSource;JLandroidx/compose/ui/graphics/Shape;LS7/n;ILS7/n;LS7/a;FFFFFLandroidx/compose/runtime/Composer;II)V", "NavigationItemLayout", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Placeable;", "iconPlaceable", "indicatorRipplePlaceable", "indicatorPlaceable", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/layout/MeasureResult;", "placeIcon-X9ElhV4", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;J)Landroidx/compose/ui/layout/MeasureResult;", "placeIcon", "labelPlaceable", "placeLabelAndTopIcon-qoqLrGI", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JFFF)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndTopIcon", "placeLabelAndStartIcon-nru01g4", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JF)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndStartIcon", "NavigationItemMinWidth", "F", "getNavigationItemMinWidth", "()F", "NavigationItemMinHeight", "getNavigationItemMinHeight", "", "IndicatorRippleLayoutIdTag", "Ljava/lang/String;", "IndicatorLayoutIdTag", "IconLayoutIdTag", "LabelLayoutIdTag", "", "ItemAnimationDurationMillis", "I", "IndicatorVerticalOffset", "itemWidth", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class NavigationItemKt {
    private static final String IconLayoutIdTag = "icon";
    private static final String IndicatorLayoutIdTag = "indicator";
    private static final String IndicatorRippleLayoutIdTag = "indicatorRipple";
    private static final int ItemAnimationDurationMillis = 100;
    private static final String LabelLayoutIdTag = "label";
    private static final float NavigationItemMinWidth = NavigationRailKt.getNavigationRailItemWidth();
    private static final float NavigationItemMinHeight = NavigationRailKt.getNavigationRailItemHeight();
    private static final float IndicatorVerticalOffset = Dp.m6844constructorimpl(12);

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* renamed from: NavigationItem-SHbi2eg, reason: not valid java name */
    public static final void m2076NavigationItemSHbi2eg(final boolean z10, final S7.a aVar, final n nVar, final TextStyle textStyle, final Shape shape, final float f, final float f7, final float f9, final float f10, final float f11, final float f12, final NavigationItemColors navigationItemColors, final Modifier modifier, final boolean z11, final n nVar2, final n nVar3, final int i, MutableInteractionSource mutableInteractionSource, Composer composer, final int i6, final int i10) {
        int i11;
        Shape shape2;
        int i12;
        boolean z12;
        MutableInteractionSource mutableInteractionSource2;
        int i13;
        InteractionSource interactionSource;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(547979956);
        if ((i6 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(z10) ? 4 : 2) | i6;
        } else {
            i11 = i6;
        }
        if ((i6 & 48) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(aVar) ? 32 : 16;
        }
        if ((i6 & 384) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(nVar) ? 256 : 128;
        }
        if ((i6 & 3072) == 0) {
            i11 |= composerStartRestartGroup.changed(textStyle) ? 2048 : 1024;
        }
        if ((i6 & 24576) == 0) {
            shape2 = shape;
            i11 |= composerStartRestartGroup.changed(shape2) ? 16384 : 8192;
        } else {
            shape2 = shape;
        }
        if ((i6 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i11 |= composerStartRestartGroup.changed(f) ? 131072 : 65536;
        }
        if ((i6 & 1572864) == 0) {
            i11 |= composerStartRestartGroup.changed(f7) ? 1048576 : 524288;
        }
        if ((i6 & 12582912) == 0) {
            i11 |= composerStartRestartGroup.changed(f9) ? 8388608 : 4194304;
        }
        if ((i6 & 100663296) == 0) {
            i11 |= composerStartRestartGroup.changed(f10) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((i6 & 805306368) == 0) {
            i11 |= composerStartRestartGroup.changed(f11) ? 536870912 : 268435456;
        }
        if ((i10 & 6) == 0) {
            i12 = i10 | (composerStartRestartGroup.changed(f12) ? 4 : 2);
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changed(navigationItemColors) ? 32 : 16;
        }
        if ((i10 & 384) == 0) {
            i12 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i12 |= composerStartRestartGroup.changed(z11) ? 2048 : 1024;
        }
        if ((i10 & 24576) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(nVar2) ? 16384 : 8192;
        }
        if ((i10 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(nVar3) ? 131072 : 65536;
        }
        if ((i10 & 1572864) == 0) {
            i12 |= composerStartRestartGroup.changed(i) ? 1048576 : 524288;
        }
        if ((i10 & 12582912) == 0) {
            i12 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 8388608 : 4194304;
        }
        int i14 = i12;
        if ((i11 & 306783379) == 306783378 && (4793491 & i14) == 4793490 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            mutableInteractionSource2 = mutableInteractionSource;
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(547979956, i11, i14, "androidx.compose.material3.NavigationItem (NavigationItem.kt:252)");
            }
            int i15 = i11;
            final ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-44329638, true, new n() { // from class: androidx.compose.material3.NavigationItemKt$NavigationItem$styledIcon$1
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
                public final void invoke(Composer composer3, int i16) {
                    if ((i16 & 3) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-44329638, i16, -1, "androidx.compose.material3.NavigationItem.<anonymous> (NavigationItem.kt:255)");
                    }
                    long jM2065iconColorWaAFU9c = navigationItemColors.m2065iconColorWaAFU9c(z10, z11);
                    Modifier modifierClearAndSetSemantics = nVar2 != null ? SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new k() { // from class: androidx.compose.material3.NavigationItemKt$NavigationItem$styledIcon$1.1
                        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        }

                        @Override // S7.k
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((SemanticsPropertyReceiver) obj);
                            return r.f317a;
                        }
                    }) : Modifier.INSTANCE;
                    n nVar4 = nVar;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer3, modifierClearAndSetSemantics);
                    ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                    S7.a constructor = companion.getConstructor();
                    if (composer3.getApplier() == null) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor);
                    } else {
                        composer3.useNode();
                    }
                    Composer composerM3474constructorimpl = Updater.m3474constructorimpl(composer3);
                    n nVarG = androidx.appfunctions.metadata.a.g(companion, composerM3474constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, composerM3474constructorimpl, currentCompositionLocalMap);
                    if (composerM3474constructorimpl.getInserting() || !kotlin.jvm.internal.k.b(composerM3474constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        androidx.appfunctions.metadata.a.z(nVarG, currentCompositeKeyHash, composerM3474constructorimpl, currentCompositeKeyHash);
                    }
                    Updater.m3481setimpl(composerM3474constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4129boximpl(jM2065iconColorWaAFU9c)), nVar4, composer3, ProvidedValue.$stable);
                    composer3.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54);
            composerStartRestartGroup.startReplaceGroup(-1735402128);
            if (nVar3 != null) {
                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1836184859, true, new n() { // from class: androidx.compose.material3.NavigationItemKt$NavigationItem$iconWithBadge$1
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
                    public final void invoke(Composer composer3, int i16) {
                        if ((i16 & 3) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1836184859, i16, -1, "androidx.compose.material3.NavigationItem.<anonymous> (NavigationItem.kt:264)");
                        }
                        final n nVar4 = nVar3;
                        ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(870803363, true, new o() { // from class: androidx.compose.material3.NavigationItemKt$NavigationItem$iconWithBadge$1.1
                            {
                                super(3);
                            }

                            @Override // S7.o
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                invoke((BoxScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                                return r.f317a;
                            }

                            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                            @Composable
                            public final void invoke(BoxScope boxScope, Composer composer4, int i17) {
                                if ((i17 & 17) == 16 && composer4.getSkipping()) {
                                    composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(870803363, i17, -1, "androidx.compose.material3.NavigationItem.<anonymous>.<anonymous> (NavigationItem.kt:264)");
                                }
                                nVar4.invoke(composer4, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composer3, 54);
                        final n nVar5 = composableLambdaRememberComposableLambda;
                        BadgeKt.BadgedBox(composableLambdaRememberComposableLambda2, null, ComposableLambdaKt.rememberComposableLambda(-1365557663, true, new o() { // from class: androidx.compose.material3.NavigationItemKt$NavigationItem$iconWithBadge$1.2
                            {
                                super(3);
                            }

                            @Override // S7.o
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                invoke((BoxScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                                return r.f317a;
                            }

                            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                            @Composable
                            public final void invoke(BoxScope boxScope, Composer composer4, int i17) {
                                if ((i17 & 17) == 16 && composer4.getSkipping()) {
                                    composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1365557663, i17, -1, "androidx.compose.material3.NavigationItem.<anonymous>.<anonymous> (NavigationItem.kt:264)");
                                }
                                nVar5.invoke(composer4, 6);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composer3, 54), composer3, 390, 2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54);
            }
            ComposableLambda composableLambda = composableLambdaRememberComposableLambda;
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.startReplaceGroup(-1735395524);
            ComposableLambda composableLambdaRememberComposableLambda2 = null;
            if (nVar2 == null) {
                z12 = true;
            } else {
                z12 = true;
                composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-254668050, true, new n() { // from class: androidx.compose.material3.NavigationItemKt$NavigationItem$styledLabel$1$1
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
                    public final void invoke(Composer composer3, int i16) {
                        if ((i16 & 3) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-254668050, i16, -1, "androidx.compose.material3.NavigationItem.<anonymous>.<anonymous> (NavigationItem.kt:272)");
                        }
                        ProvideContentColorTextStyleKt.m2680ProvideContentColorTextStyle3JVO9M(navigationItemColors.m2066textColorWaAFU9c(z10, z11), textStyle, nVar2, composer3, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54);
            }
            ComposableLambda composableLambda2 = composableLambdaRememberComposableLambda2;
            composerStartRestartGroup.endReplaceGroup();
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableIntState mutableIntState = (MutableIntState) objRememberedValue;
            mutableInteractionSource2 = mutableInteractionSource;
            Modifier modifierM729defaultMinSizeVpY3zN4 = SizeKt.m729defaultMinSizeVpY3zN4(SelectableKt.m953selectableO2vRcR0(modifier, z10, mutableInteractionSource2, null, z11, Role.m6074boximpl(Role.INSTANCE.m6088getTabo7Vup1c()), aVar), NavigationItemMinWidth, NavigationItemMinHeight);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new k() { // from class: androidx.compose.material3.NavigationItemKt$NavigationItem$1$1
                    {
                        super(1);
                    }

                    @Override // S7.k
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        m2085invokeozmzZPI(((IntSize) obj).m7019unboximpl());
                        return r.f317a;
                    }

                    /* renamed from: invoke-ozmzZPI, reason: not valid java name */
                    public final void m2085invokeozmzZPI(long j5) {
                        mutableIntState.setIntValue(IntSize.m7015getWidthimpl(j5));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Modifier modifierOnSizeChanged = OnRemeasuredModifierKt.onSizeChanged(modifierM729defaultMinSizeVpY3zN4, (k) objRememberedValue2);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), z12);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierOnSizeChanged);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
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
            n nVarG = androidx.appfunctions.metadata.a.g(companion2, composerM3474constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, composerM3474constructorimpl, currentCompositionLocalMap);
            if (composerM3474constructorimpl.getInserting() || !kotlin.jvm.internal.k.b(composerM3474constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                androidx.appfunctions.metadata.a.z(nVarG, currentCompositeKeyHash, composerM3474constructorimpl, currentCompositeKeyHash);
            }
            Updater.m3481setimpl(composerM3474constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            final State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(z10 ? 1.0f : 0.0f, AnimationSpecKt.tween$default(100, 0, null, 6, null), 0.0f, null, null, composerStartRestartGroup, 48, 28);
            composerStartRestartGroup.startReplaceGroup(-1634400795);
            if (NavigationItemIconPosition.m2070equalsimpl0(i, NavigationItemIconPosition.INSTANCE.m2075getTopxw1Ddg())) {
                i13 = 29360128;
                long jOffset = OffsetKt.Offset((mutableIntState.getIntValue() - r8.mo375roundToPx0680j_4(f)) / 2, ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo381toPx0680j_4(IndicatorVerticalOffset));
                boolean zChanged = ((i14 & 29360128) == 8388608) | composerStartRestartGroup.changed(jOffset);
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = new MappedInteractionSource(mutableInteractionSource2, jOffset, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                interactionSource = (MappedInteractionSource) objRememberedValue3;
            } else {
                i13 = 29360128;
                interactionSource = null;
            }
            composerStartRestartGroup.endReplaceGroup();
            InteractionSource interactionSource2 = interactionSource != null ? interactionSource : mutableInteractionSource2;
            long selectedIndicatorColor = navigationItemColors.getSelectedIndicatorColor();
            boolean zChanged2 = composerStartRestartGroup.changed(stateAnimateFloatAsState);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = new S7.a() { // from class: androidx.compose.material3.NavigationItemKt$NavigationItem$2$3$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // S7.a
                    public final Float invoke() {
                        return stateAnimateFloatAsState.getValue();
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            int i16 = i15 << 3;
            m2077NavigationItemLayoutKmRXDg(interactionSource2, selectedIndicatorColor, shape2, composableLambda, i, composableLambda2, (S7.a) objRememberedValue4, f7, f9, f10, f11, f12, composerStartRestartGroup, ((i15 >> 6) & 896) | ((i14 >> 6) & 57344) | (i16 & i13) | (234881024 & i16) | (i16 & 1879048192), ((i15 >> 27) & 14) | ((i14 << 3) & 112));
            composer2 = composerStartRestartGroup;
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final MutableInteractionSource mutableInteractionSource3 = mutableInteractionSource2;
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.material3.NavigationItemKt$NavigationItem$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                public final void invoke(Composer composer3, int i17) {
                    NavigationItemKt.m2076NavigationItemSHbi2eg(z10, aVar, nVar, textStyle, shape, f, f7, f9, f10, f11, f12, navigationItemColors, modifier, z11, nVar2, nVar3, i, mutableInteractionSource3, composer3, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), RecomposeScopeImplKt.updateChangedFlags(i10));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* renamed from: NavigationItemLayout-KmRX-Dg, reason: not valid java name */
    public static final void m2077NavigationItemLayoutKmRXDg(final InteractionSource interactionSource, final long j5, final Shape shape, final n nVar, final int i, final n nVar2, S7.a aVar, final float f, final float f7, final float f9, final float f10, final float f11, Composer composer, final int i6, final int i10) {
        int i11;
        int i12;
        int i13;
        int i14;
        MeasurePolicy topIconOrIconOnlyMeasurePolicy;
        Composer composer2;
        final S7.a aVar2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1757687417);
        if ((i6 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(interactionSource) ? 4 : 2) | i6;
        } else {
            i11 = i6;
        }
        if ((i6 & 48) == 0) {
            i11 |= composerStartRestartGroup.changed(j5) ? 32 : 16;
        }
        if ((i6 & 384) == 0) {
            i11 |= composerStartRestartGroup.changed(shape) ? 256 : 128;
        }
        if ((i6 & 3072) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(nVar) ? 2048 : 1024;
        }
        if ((i6 & 24576) == 0) {
            i11 |= composerStartRestartGroup.changed(i) ? 16384 : 8192;
        }
        if ((196608 & i6) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(nVar2) ? 131072 : 65536;
        }
        if ((1572864 & i6) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(aVar) ? 1048576 : 524288;
        }
        if ((12582912 & i6) == 0) {
            i11 |= composerStartRestartGroup.changed(f) ? 8388608 : 4194304;
        }
        if ((i6 & 100663296) == 0) {
            i11 |= composerStartRestartGroup.changed(f7) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((i6 & 805306368) == 0) {
            i11 |= composerStartRestartGroup.changed(f9) ? 536870912 : 268435456;
        }
        if ((i10 & 6) == 0) {
            i12 = i10 | (composerStartRestartGroup.changed(f10) ? 4 : 2);
        } else {
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changed(f11) ? 32 : 16;
        }
        int i15 = i12;
        if ((i11 & 306783379) == 306783378 && (i15 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            aVar2 = aVar;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1757687417, i11, i15, "androidx.compose.material3.NavigationItemLayout (NavigationItem.kt:355)");
            }
            if (nVar2 == null || NavigationItemIconPosition.m2070equalsimpl0(i, NavigationItemIconPosition.INSTANCE.m2075getTopxw1Ddg())) {
                i13 = 0;
                i14 = i11;
                composer2 = composerStartRestartGroup;
                topIconOrIconOnlyMeasurePolicy = new TopIconOrIconOnlyMeasurePolicy(nVar2 != null, aVar, f, f7, f9, f11, null);
                aVar2 = aVar;
            } else {
                i13 = 0;
                i14 = i11;
                aVar2 = aVar;
                topIconOrIconOnlyMeasurePolicy = new StartIconMeasurePolicy(aVar2, f, f7, f10, null);
                composer2 = composerStartRestartGroup;
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, i13);
            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, companion);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            S7.a constructor = companion2.getConstructor();
            if (composer2.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            Composer composerM3474constructorimpl = Updater.m3474constructorimpl(composer2);
            n nVarG = androidx.appfunctions.metadata.a.g(companion2, composerM3474constructorimpl, topIconOrIconOnlyMeasurePolicy, composerM3474constructorimpl, currentCompositionLocalMap);
            if (composerM3474constructorimpl.getInserting() || !kotlin.jvm.internal.k.b(composerM3474constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                androidx.appfunctions.metadata.a.z(nVarG, currentCompositeKeyHash, composerM3474constructorimpl, currentCompositeKeyHash);
            }
            Updater.m3481setimpl(composerM3474constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            composerStartRestartGroup = composer2;
            BoxKt.Box(IndicationKt.indication(ClipKt.clip(LayoutIdKt.layoutId(companion, IndicatorRippleLayoutIdTag), shape), interactionSource, RippleKt.m2172rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composerStartRestartGroup, 0, 7)), composerStartRestartGroup, 0);
            Modifier modifierLayoutId = LayoutIdKt.layoutId(companion, IndicatorLayoutIdTag);
            boolean z10 = (i14 & 3670016) == 1048576;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z10 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new k() { // from class: androidx.compose.material3.NavigationItemKt$NavigationItemLayout$1$1$1
                    {
                        super(1);
                    }

                    @Override // S7.k
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((GraphicsLayerScope) obj);
                        return r.f317a;
                    }

                    public final void invoke(GraphicsLayerScope graphicsLayerScope) {
                        graphicsLayerScope.setAlpha(((Number) aVar2.invoke()).floatValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            BoxKt.Box(BackgroundKt.m238backgroundbw27NRU(GraphicsLayerModifierKt.graphicsLayer(modifierLayoutId, (k) objRememberedValue), j5, shape), composerStartRestartGroup, 0);
            Modifier modifierLayoutId2 = LayoutIdKt.layoutId(companion, IconLayoutIdTag);
            Alignment.Companion companion3 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierLayoutId2);
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
            if (composerM3474constructorimpl2.getInserting() || !kotlin.jvm.internal.k.b(composerM3474constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                androidx.appfunctions.metadata.a.z(nVarG2, currentCompositeKeyHash2, composerM3474constructorimpl2, currentCompositeKeyHash2);
            }
            Updater.m3481setimpl(composerM3474constructorimpl2, modifierMaterializeModifier2, companion2.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            nVar.invoke(composerStartRestartGroup, Integer.valueOf((i14 >> 9) & 14));
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.startReplaceGroup(-776741606);
            if (nVar2 != null) {
                Modifier modifierLayoutId3 = LayoutIdKt.layoutId(companion, LabelLayoutIdTag);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierLayoutId3);
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
                if (composerM3474constructorimpl3.getInserting() || !kotlin.jvm.internal.k.b(composerM3474constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    androidx.appfunctions.metadata.a.z(nVarG3, currentCompositeKeyHash3, composerM3474constructorimpl3, currentCompositeKeyHash3);
                }
                Updater.m3481setimpl(composerM3474constructorimpl3, modifierMaterializeModifier3, companion2.getSetModifier());
                androidx.compose.foundation.b.A(nVar2, composerStartRestartGroup, (i14 >> 15) & 14);
            }
            if (androidx.appfunctions.metadata.a.D(composerStartRestartGroup)) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final S7.a aVar3 = aVar2;
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.material3.NavigationItemKt$NavigationItemLayout$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                public final void invoke(Composer composer3, int i16) {
                    NavigationItemKt.m2077NavigationItemLayoutKmRXDg(interactionSource, j5, shape, nVar, i, nVar2, aVar3, f, f7, f9, f10, f11, composer3, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), RecomposeScopeImplKt.updateChangedFlags(i10));
                }
            });
        }
    }

    public static final float getNavigationItemMinHeight() {
        return NavigationItemMinHeight;
    }

    public static final float getNavigationItemMinWidth() {
        return NavigationItemMinWidth;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: placeIcon-X9ElhV4, reason: not valid java name */
    public static final MeasureResult m2082placeIconX9ElhV4(MeasureScope measureScope, final Placeable placeable, final Placeable placeable2, final Placeable placeable3, long j5) {
        int iM6814constrainWidthK40F9xA = ConstraintsKt.m6814constrainWidthK40F9xA(j5, placeable2.getWidth());
        int iM6813constrainHeightK40F9xA = ConstraintsKt.m6813constrainHeightK40F9xA(j5, placeable2.getHeight());
        final int iD = androidx.compose.foundation.b.D(placeable3, iM6814constrainWidthK40F9xA, 2);
        final int iF = androidx.compose.foundation.b.f(placeable3, iM6813constrainHeightK40F9xA, 2);
        final int iD2 = androidx.compose.foundation.b.D(placeable, iM6814constrainWidthK40F9xA, 2);
        final int iF2 = androidx.compose.foundation.b.f(placeable, iM6813constrainHeightK40F9xA, 2);
        final int iD3 = androidx.compose.foundation.b.D(placeable2, iM6814constrainWidthK40F9xA, 2);
        final int iF3 = androidx.compose.foundation.b.f(placeable2, iM6813constrainHeightK40F9xA, 2);
        return MeasureScope.layout$default(measureScope, iM6814constrainWidthK40F9xA, iM6813constrainHeightK40F9xA, null, new k() { // from class: androidx.compose.material3.NavigationItemKt$placeIcon$1
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
                Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, iD, iF, 0.0f, 4, null);
                Placeable.PlacementScope.placeRelative$default(placementScope, placeable, iD2, iF2, 0.0f, 4, null);
                Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, iD3, iF3, 0.0f, 4, null);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: placeLabelAndStartIcon-nru01g4, reason: not valid java name */
    public static final MeasureResult m2083placeLabelAndStartIconnru01g4(MeasureScope measureScope, final Placeable placeable, final Placeable placeable2, final Placeable placeable3, final Placeable placeable4, long j5, float f) {
        int iM6814constrainWidthK40F9xA = ConstraintsKt.m6814constrainWidthK40F9xA(j5, placeable3.getWidth());
        int iM6813constrainHeightK40F9xA = ConstraintsKt.m6813constrainHeightK40F9xA(j5, placeable3.getHeight());
        final int iD = androidx.compose.foundation.b.D(placeable4, iM6814constrainWidthK40F9xA, 2);
        final int iF = androidx.compose.foundation.b.f(placeable4, iM6813constrainHeightK40F9xA, 2);
        final int iF2 = androidx.compose.foundation.b.f(placeable2, iM6813constrainHeightK40F9xA, 2);
        final int iF3 = androidx.compose.foundation.b.f(placeable, iM6813constrainHeightK40F9xA, 2);
        final int width = (iM6814constrainWidthK40F9xA - (placeable.getWidth() + (measureScope.mo375roundToPx0680j_4(f) + placeable2.getWidth()))) / 2;
        final int iMo375roundToPx0680j_4 = measureScope.mo375roundToPx0680j_4(f) + placeable2.getWidth() + width;
        final int iD2 = androidx.compose.foundation.b.D(placeable3, iM6814constrainWidthK40F9xA, 2);
        final int iF4 = androidx.compose.foundation.b.f(placeable3, iM6813constrainHeightK40F9xA, 2);
        return MeasureScope.layout$default(measureScope, iM6814constrainWidthK40F9xA, iM6813constrainHeightK40F9xA, null, new k() { // from class: androidx.compose.material3.NavigationItemKt$placeLabelAndStartIcon$1
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
                Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, iD, iF, 0.0f, 4, null);
                Placeable.PlacementScope.placeRelative$default(placementScope, placeable, iMo375roundToPx0680j_4, iF3, 0.0f, 4, null);
                Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, width, iF2, 0.0f, 4, null);
                Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, iD2, iF4, 0.0f, 4, null);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: placeLabelAndTopIcon-qoqLrGI, reason: not valid java name */
    public static final MeasureResult m2084placeLabelAndTopIconqoqLrGI(MeasureScope measureScope, final Placeable placeable, final Placeable placeable2, final Placeable placeable3, final Placeable placeable4, long j5, float f, float f7, float f9) {
        int iM6814constrainWidthK40F9xA = ConstraintsKt.m6814constrainWidthK40F9xA(j5, Math.max(placeable.getWidth(), placeable3.getWidth()));
        int iM6813constrainHeightK40F9xA = ConstraintsKt.m6813constrainHeightK40F9xA(j5, U7.a.U((measureScope.mo381toPx0680j_4(f9) * 2) + measureScope.mo381toPx0680j_4(f) + placeable3.getHeight() + placeable.getHeight()));
        final int iMo375roundToPx0680j_4 = measureScope.mo375roundToPx0680j_4(Dp.m6844constructorimpl(f9 + f7));
        final int iD = androidx.compose.foundation.b.D(placeable2, iM6814constrainWidthK40F9xA, 2);
        final int iD2 = androidx.compose.foundation.b.D(placeable4, iM6814constrainWidthK40F9xA, 2);
        final int iMo375roundToPx0680j_42 = iMo375roundToPx0680j_4 - measureScope.mo375roundToPx0680j_4(f7);
        final int iD3 = androidx.compose.foundation.b.D(placeable, iM6814constrainWidthK40F9xA, 2);
        final int iMo375roundToPx0680j_43 = measureScope.mo375roundToPx0680j_4(Dp.m6844constructorimpl(f + f7)) + placeable2.getHeight() + iMo375roundToPx0680j_4;
        final int iD4 = androidx.compose.foundation.b.D(placeable3, iM6814constrainWidthK40F9xA, 2);
        return MeasureScope.layout$default(measureScope, iM6814constrainWidthK40F9xA, iM6813constrainHeightK40F9xA, null, new k() { // from class: androidx.compose.material3.NavigationItemKt$placeLabelAndTopIcon$1
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
                Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, iD2, iMo375roundToPx0680j_42, 0.0f, 4, null);
                Placeable.PlacementScope.placeRelative$default(placementScope, placeable, iD3, iMo375roundToPx0680j_43, 0.0f, 4, null);
                Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, iD, iMo375roundToPx0680j_4, 0.0f, 4, null);
                Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, iD4, iMo375roundToPx0680j_42, 0.0f, 4, null);
            }
        }, 4, null);
    }
}
