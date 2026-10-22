package androidx.compose.animation;

import C7.f;
import C7.r;
import S7.k;
import S7.n;
import S7.o;
import S7.p;
import androidx.collection.MutableScatterMap;
import androidx.compose.animation.SharedTransitionScope;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.LookaheadScope;
import androidx.compose.ui.layout.LookaheadScopeKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import m9.InterfaceC1733z;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u001a2\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0002\b\u0005H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a.\u0010\n\u001a\u00020\u00042\u001d\u0010\u0006\u001a\u0019\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00040\t¢\u0006\u0002\b\u0005H\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a)\u0010\u0011\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u001f\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0003¢\u0006\u0004\b\u0017\u0010\u0018\"\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a\"\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e\"\u001a\u0010 \u001a\u00020\u001f8\u0002X\u0083\u0004¢\u0006\f\n\u0004\b \u0010!\u0012\u0004\b\"\u0010#\"(\u0010'\u001a\u0016\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%\u0012\u0006\u0012\u0004\u0018\u00010&0\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(\"\u001a\u0010*\u001a\u00020)8\u0002X\u0083\u0004¢\u0006\f\n\u0004\b*\u0010+\u0012\u0004\b,\u0010#\"\u0014\u0010-\u001a\u00020\u000f8\u0000X\u0080T¢\u0006\u0006\n\u0004\b-\u0010.\"\u001b\u00104\u001a\u00020/8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"2\u00106\u001a\u001a\u0012\u0004\u0012\u00020\u0013\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\f05058\u0002X\u0083\u0004¢\u0006\f\n\u0004\b6\u00107\u0012\u0004\b8\u0010#\"\u0018\u0010;\u001a\u00020\u000f*\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:\"\u0018\u0010;\u001a\u00020\u000f*\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b9\u0010<¨\u0006="}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Lkotlin/Function1;", "Landroidx/compose/animation/SharedTransitionScope;", "LC7/r;", "Landroidx/compose/runtime/Composable;", "content", "SharedTransitionLayout", "(Landroidx/compose/ui/Modifier;LS7/o;Landroidx/compose/runtime/Composer;II)V", "Lkotlin/Function2;", "SharedTransitionScope", "(LS7/p;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/animation/ScaleToBoundsImpl;", "scaleToBounds", "Lkotlin/Function0;", "", "isEnabled", "createContentScaleModifier", "(Landroidx/compose/ui/Modifier;Landroidx/compose/animation/ScaleToBoundsImpl;LS7/a;)Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/layout/ContentScale;", "contentScale", "Landroidx/compose/ui/Alignment;", "alignment", "ScaleToBoundsCached", "(Landroidx/compose/ui/layout/ContentScale;Landroidx/compose/ui/Alignment;)Landroidx/compose/animation/ScaleToBoundsImpl;", "DefaultEnabled", "LS7/a;", "Landroidx/compose/animation/core/SpringSpec;", "Landroidx/compose/ui/geometry/Rect;", "DefaultSpring", "Landroidx/compose/animation/core/SpringSpec;", "Landroidx/compose/animation/SharedTransitionScope$OverlayClip;", "ParentClip", "Landroidx/compose/animation/SharedTransitionScope$OverlayClip;", "getParentClip$annotations", "()V", "Landroidx/compose/ui/unit/LayoutDirection;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/graphics/Path;", "DefaultClipInOverlayDuringTransition", "LS7/n;", "Landroidx/compose/animation/BoundsTransform;", "DefaultBoundsTransform", "Landroidx/compose/animation/BoundsTransform;", "getDefaultBoundsTransform$annotations", "VisualDebugging", "Z", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "SharedTransitionObserver$delegate", "LC7/f;", "getSharedTransitionObserver", "()Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "SharedTransitionObserver", "Landroidx/collection/MutableScatterMap;", "cachedScaleToBoundsImplMap", "Landroidx/collection/MutableScatterMap;", "getCachedScaleToBoundsImplMap$annotations", "getShouldCache", "(Landroidx/compose/ui/Alignment;)Z", "shouldCache", "(Landroidx/compose/ui/layout/ContentScale;)Z", "animation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SharedTransitionScopeKt {
    public static final boolean VisualDebugging = false;
    private static final S7.a DefaultEnabled = new S7.a() { // from class: androidx.compose.animation.SharedTransitionScopeKt$DefaultEnabled$1
        @Override // S7.a
        public final Boolean invoke() {
            return Boolean.TRUE;
        }
    };
    private static final SpringSpec<Rect> DefaultSpring = AnimationSpecKt.spring$default(0.0f, 400.0f, VisibilityThresholdsKt.getVisibilityThreshold(Rect.INSTANCE), 1, null);
    private static final SharedTransitionScope.OverlayClip ParentClip = new SharedTransitionScope.OverlayClip() { // from class: androidx.compose.animation.SharedTransitionScopeKt$ParentClip$1
        @Override // androidx.compose.animation.SharedTransitionScope.OverlayClip
        public Path getClipPath(SharedTransitionScope.SharedContentState state, Rect bounds, LayoutDirection layoutDirection, Density density) {
            SharedTransitionScope.SharedContentState parentSharedContentState = state.getParentSharedContentState();
            if (parentSharedContentState != null) {
                return parentSharedContentState.getClipPathInOverlay();
            }
            return null;
        }
    };
    private static final n DefaultClipInOverlayDuringTransition = new n() { // from class: androidx.compose.animation.SharedTransitionScopeKt$DefaultClipInOverlayDuringTransition$1
        @Override // S7.n
        public final Void invoke(LayoutDirection layoutDirection, Density density) {
            return null;
        }
    };
    private static final BoundsTransform DefaultBoundsTransform = new b();
    private static final f SharedTransitionObserver$delegate = kotlin.a.b(LazyThreadSafetyMode.c, new S7.a() { // from class: androidx.compose.animation.SharedTransitionScopeKt$SharedTransitionObserver$2
        @Override // S7.a
        public final SnapshotStateObserver invoke() {
            SnapshotStateObserver snapshotStateObserver = new SnapshotStateObserver(new k() { // from class: androidx.compose.animation.SharedTransitionScopeKt$SharedTransitionObserver$2.1
                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((S7.a) obj);
                    return r.f317a;
                }

                public final void invoke(S7.a aVar) {
                    aVar.invoke();
                }
            });
            snapshotStateObserver.start();
            return snapshotStateObserver;
        }
    });
    private static final MutableScatterMap<ContentScale, MutableScatterMap<Alignment, ScaleToBoundsImpl>> cachedScaleToBoundsImplMap = new MutableScatterMap<>(0, 1, null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final FiniteAnimationSpec DefaultBoundsTransform$lambda$0(Rect rect, Rect rect2) {
        return DefaultSpring;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ExperimentalSharedTransitionApi
    public static final ScaleToBoundsImpl ScaleToBoundsCached(ContentScale contentScale, Alignment alignment) {
        if (!getShouldCache(contentScale) || !getShouldCache(alignment)) {
            return new ScaleToBoundsImpl(contentScale, alignment);
        }
        MutableScatterMap<ContentScale, MutableScatterMap<Alignment, ScaleToBoundsImpl>> mutableScatterMap = cachedScaleToBoundsImplMap;
        MutableScatterMap<Alignment, ScaleToBoundsImpl> mutableScatterMap2 = mutableScatterMap.get(contentScale);
        if (mutableScatterMap2 == null) {
            mutableScatterMap2 = new MutableScatterMap<>(0, 1, null);
            mutableScatterMap.set(contentScale, mutableScatterMap2);
        }
        MutableScatterMap<Alignment, ScaleToBoundsImpl> mutableScatterMap3 = mutableScatterMap2;
        ScaleToBoundsImpl scaleToBoundsImpl = mutableScatterMap3.get(alignment);
        if (scaleToBoundsImpl == null) {
            scaleToBoundsImpl = new ScaleToBoundsImpl(contentScale, alignment);
            mutableScatterMap3.set(alignment, scaleToBoundsImpl);
        }
        return scaleToBoundsImpl;
    }

    @ExperimentalSharedTransitionApi
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void SharedTransitionLayout(final Modifier modifier, final o oVar, Composer composer, final int i, final int i6) {
        int i10;
        Composer composerStartRestartGroup = composer.startRestartGroup(2043053727);
        int i11 = i6 & 1;
        if (i11 != 0) {
            i10 = i | 6;
        } else if ((i & 6) == 0) {
            i10 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i10 = i;
        }
        if ((i6 & 2) != 0) {
            i10 |= 48;
        } else if ((i & 48) == 0) {
            i10 |= composerStartRestartGroup.changedInstance(oVar) ? 32 : 16;
        }
        if ((i10 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i11 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2043053727, i10, -1, "androidx.compose.animation.SharedTransitionLayout (SharedTransitionScope.kt:111)");
            }
            SharedTransitionScope(ComposableLambdaKt.rememberComposableLambda(-130587847, true, new p() { // from class: androidx.compose.animation.SharedTransitionScopeKt.SharedTransitionLayout.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(4);
                }

                @Override // S7.p
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    invoke((SharedTransitionScope) obj, (Modifier) obj2, (Composer) obj3, ((Number) obj4).intValue());
                    return r.f317a;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void invoke(SharedTransitionScope sharedTransitionScope, Modifier modifier2, Composer composer2, int i12) {
                    int i13;
                    if ((i12 & 6) == 0) {
                        i13 = (composer2.changed(sharedTransitionScope) ? 4 : 2) | i12;
                    } else {
                        i13 = i12;
                    }
                    if ((i12 & 48) == 0) {
                        i13 |= composer2.changed(modifier2) ? 32 : 16;
                    }
                    if ((i13 & 147) == 146 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-130587847, i13, -1, "androidx.compose.animation.SharedTransitionLayout.<anonymous> (SharedTransitionScope.kt:115)");
                    }
                    Modifier modifierThen = modifier.then(modifier2);
                    o oVar2 = oVar;
                    composer2.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
                    composer2.startReplaceableGroup(-1323940314);
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                    S7.a constructor = companion.getConstructor();
                    o oVarModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifierThen);
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
                    n nVarG = androidx.appfunctions.metadata.a.g(companion, composerM3474constructorimpl, measurePolicyRememberBoxMeasurePolicy, composerM3474constructorimpl, currentCompositionLocalMap);
                    if (composerM3474constructorimpl.getInserting() || !kotlin.jvm.internal.k.b(composerM3474constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        androidx.appfunctions.metadata.a.z(nVarG, currentCompositeKeyHash, composerM3474constructorimpl, currentCompositeKeyHash);
                    }
                    oVarModifierMaterializerOf.invoke(SkippableUpdater.m3447boximpl(SkippableUpdater.m3448constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    oVar2.invoke(sharedTransitionScope, composer2, Integer.valueOf(i13 & 14));
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.animation.SharedTransitionScopeKt.SharedTransitionLayout.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                public final void invoke(Composer composer2, int i12) {
                    SharedTransitionScopeKt.SharedTransitionLayout(modifier, oVar, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i6);
                }
            });
        }
    }

    @ExperimentalSharedTransitionApi
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void SharedTransitionScope(final p pVar, Composer composer, final int i) {
        int i6;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2093217917);
        if ((i & 6) == 0) {
            i6 = (composerStartRestartGroup.changedInstance(pVar) ? 4 : 2) | i;
        } else {
            i6 = i;
        }
        if ((i6 & 3) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2093217917, i6, -1, "androidx.compose.animation.SharedTransitionScope (SharedTransitionScope.kt:138)");
            }
            LookaheadScopeKt.LookaheadScope(ComposableLambdaKt.rememberComposableLambda(-863967934, true, new o() { // from class: androidx.compose.animation.SharedTransitionScopeKt.SharedTransitionScope.1
                {
                    super(3);
                }

                @Override // S7.o
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke((LookaheadScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                    return r.f317a;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void invoke(LookaheadScope lookaheadScope, Composer composer2, int i10) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-863967934, i10, -1, "androidx.compose.animation.SharedTransitionScope.<anonymous> (SharedTransitionScope.kt:140)");
                    }
                    Object objRememberedValue = composer2.rememberedValue();
                    Composer.Companion companion = Composer.INSTANCE;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = B7.a.e(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.f4908a, composer2), composer2);
                    }
                    InterfaceC1733z coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                    Object objRememberedValue2 = composer2.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = new SharedTransitionScopeImpl(lookaheadScope, coroutineScope);
                        composer2.updateRememberedValue(objRememberedValue2);
                    }
                    final SharedTransitionScopeImpl sharedTransitionScopeImpl = (SharedTransitionScopeImpl) objRememberedValue2;
                    p pVar2 = pVar;
                    Modifier.Companion companion2 = Modifier.INSTANCE;
                    Object objRememberedValue3 = composer2.rememberedValue();
                    if (objRememberedValue3 == companion.getEmpty()) {
                        objRememberedValue3 = new o() { // from class: androidx.compose.animation.SharedTransitionScopeKt$SharedTransitionScope$1$1$1
                            {
                                super(3);
                            }

                            @Override // S7.o
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                return m110invoke3p2s80s((MeasureScope) obj, (Measurable) obj2, ((Constraints) obj3).getValue());
                            }

                            /* renamed from: invoke-3p2s80s, reason: not valid java name */
                            public final MeasureResult m110invoke3p2s80s(final MeasureScope measureScope, Measurable measurable, long j5) {
                                final Placeable placeableMo5549measureBRTryo0 = measurable.mo5549measureBRTryo0(j5);
                                int width = placeableMo5549measureBRTryo0.getWidth();
                                int height = placeableMo5549measureBRTryo0.getHeight();
                                final SharedTransitionScopeImpl sharedTransitionScopeImpl2 = sharedTransitionScopeImpl;
                                return MeasureScope.layout$default(measureScope, width, height, null, new k() { // from class: androidx.compose.animation.SharedTransitionScopeKt$SharedTransitionScope$1$1$1.1
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
                                        LayoutCoordinates coordinates = placementScope.getCoordinates();
                                        if (coordinates != null) {
                                            if (measureScope.isLookingAhead()) {
                                                sharedTransitionScopeImpl2.setNullableLookaheadRoot$animation_release(coordinates);
                                            } else {
                                                sharedTransitionScopeImpl2.setRoot$animation_release(coordinates);
                                            }
                                        }
                                        Placeable.PlacementScope.place$default(placementScope, placeableMo5549measureBRTryo0, 0, 0, 0.0f, 4, null);
                                    }
                                }, 4, null);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue3);
                    }
                    Modifier modifierLayout = LayoutModifierKt.layout(companion2, (o) objRememberedValue3);
                    Object objRememberedValue4 = composer2.rememberedValue();
                    if (objRememberedValue4 == companion.getEmpty()) {
                        objRememberedValue4 = new k() { // from class: androidx.compose.animation.SharedTransitionScopeKt$SharedTransitionScope$1$2$1
                            {
                                super(1);
                            }

                            @Override // S7.k
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((ContentDrawScope) obj);
                                return r.f317a;
                            }

                            public final void invoke(ContentDrawScope contentDrawScope) {
                                contentDrawScope.drawContent();
                                sharedTransitionScopeImpl.drawInOverlay$animation_release(contentDrawScope);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue4);
                    }
                    pVar2.invoke(sharedTransitionScopeImpl, DrawModifierKt.drawWithContent(modifierLayout, (k) objRememberedValue4), composer2, 6);
                    Object objRememberedValue5 = composer2.rememberedValue();
                    if (objRememberedValue5 == companion.getEmpty()) {
                        objRememberedValue5 = new k() { // from class: androidx.compose.animation.SharedTransitionScopeKt$SharedTransitionScope$1$3$1
                            {
                                super(1);
                            }

                            @Override // S7.k
                            public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                                final SharedTransitionScopeImpl sharedTransitionScopeImpl2 = sharedTransitionScopeImpl;
                                return new DisposableEffectResult() { // from class: androidx.compose.animation.SharedTransitionScopeKt$SharedTransitionScope$1$3$1$invoke$$inlined$onDispose$1
                                    @Override // androidx.compose.runtime.DisposableEffectResult
                                    public void dispose() {
                                        SharedTransitionScopeKt.getSharedTransitionObserver().clear(sharedTransitionScopeImpl2);
                                    }
                                };
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue5);
                    }
                    EffectsKt.DisposableEffect(r.f317a, (k) objRememberedValue5, composer2, 54);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.animation.SharedTransitionScopeKt.SharedTransitionScope.2
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
                    SharedTransitionScopeKt.SharedTransitionScope(pVar, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier createContentScaleModifier(Modifier modifier, ScaleToBoundsImpl scaleToBoundsImpl, final S7.a aVar) {
        return modifier.then(kotlin.jvm.internal.k.b(scaleToBoundsImpl.getContentScale(), ContentScale.INSTANCE.getCrop()) ? GraphicsLayerModifierKt.graphicsLayer(Modifier.INSTANCE, new k() { // from class: androidx.compose.animation.SharedTransitionScopeKt.createContentScaleModifier.1
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((GraphicsLayerScope) obj);
                return r.f317a;
            }

            public final void invoke(GraphicsLayerScope graphicsLayerScope) {
                graphicsLayerScope.setClip(((Boolean) aVar.invoke()).booleanValue());
            }
        }) : Modifier.INSTANCE).then(new SkipToLookaheadElement(scaleToBoundsImpl, aVar));
    }

    @ExperimentalSharedTransitionApi
    private static /* synthetic */ void getCachedScaleToBoundsImplMap$annotations() {
    }

    @ExperimentalSharedTransitionApi
    private static /* synthetic */ void getDefaultBoundsTransform$annotations() {
    }

    @ExperimentalSharedTransitionApi
    private static /* synthetic */ void getParentClip$annotations() {
    }

    public static final SnapshotStateObserver getSharedTransitionObserver() {
        return (SnapshotStateObserver) SharedTransitionObserver$delegate.getF4884a();
    }

    private static final boolean getShouldCache(Alignment alignment) {
        Alignment.Companion companion = Alignment.INSTANCE;
        return alignment == companion.getTopStart() || alignment == companion.getTopCenter() || alignment == companion.getTopEnd() || alignment == companion.getCenterStart() || alignment == companion.getCenter() || alignment == companion.getCenterEnd() || alignment == companion.getBottomStart() || alignment == companion.getBottomCenter() || alignment == companion.getBottomEnd();
    }

    private static final boolean getShouldCache(ContentScale contentScale) {
        ContentScale.Companion companion = ContentScale.INSTANCE;
        return contentScale == companion.getFillWidth() || contentScale == companion.getFillHeight() || contentScale == companion.getFillBounds() || contentScale == companion.getFit() || contentScale == companion.getCrop() || contentScale == companion.getNone() || contentScale == companion.getInside();
    }
}
